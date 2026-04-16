package org.apache.commons.net.smtp;

import java.io.IOException;
import java.net.InetAddress;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import kotlin.UByte;
import org.apache.commons.net.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class AuthenticatingSMTPClient extends SMTPSClient {

    public enum AUTH_METHOD {
        PLAIN,
        CRAM_MD5,
        LOGIN,
        XOAUTH,
        XOAUTH2;

        public static final String getAuthName(AUTH_METHOD method) {
            if (method.equals(PLAIN)) {
                return "PLAIN";
            }
            if (method.equals(CRAM_MD5)) {
                return "CRAM-MD5";
            }
            if (method.equals(LOGIN)) {
                return "LOGIN";
            }
            if (method.equals(XOAUTH)) {
                return "XOAUTH";
            }
            if (method.equals(XOAUTH2)) {
                return "XOAUTH2";
            }
            return null;
        }
    }

    public AuthenticatingSMTPClient() {
    }

    public AuthenticatingSMTPClient(boolean implicit, SSLContext ctx) {
        super(implicit, ctx);
    }

    public AuthenticatingSMTPClient(String protocol) {
        super(protocol);
    }

    public AuthenticatingSMTPClient(String proto, boolean implicit) {
        super(proto, implicit);
    }

    public AuthenticatingSMTPClient(String proto, boolean implicit, String encoding) {
        super(proto, implicit, encoding);
    }

    public AuthenticatingSMTPClient(String protocol, String encoding) {
        super(protocol, false, encoding);
    }

    public boolean auth(AUTH_METHOD method, String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        if (!SMTPReply.isPositiveIntermediate(sendCommand(14, AUTH_METHOD.getAuthName(method)))) {
            return false;
        }
        if (method.equals(AUTH_METHOD.PLAIN)) {
            return SMTPReply.isPositiveCompletion(sendCommand(Base64.encodeBase64StringUnChunked(("\u0000" + username + "\u0000" + password).getBytes(getCharset()))));
        }
        if (method.equals(AUTH_METHOD.CRAM_MD5)) {
            byte[] serverChallenge = Base64.decodeBase64(getReplyString().substring(4).trim());
            Mac hmac_md5 = Mac.getInstance("HmacMD5");
            hmac_md5.init(new SecretKeySpec(password.getBytes(getCharset()), "HmacMD5"));
            byte[] hmacResult = convertToHexString(hmac_md5.doFinal(serverChallenge)).getBytes(getCharset());
            byte[] usernameBytes = username.getBytes(getCharset());
            byte[] toEncode = new byte[usernameBytes.length + 1 + hmacResult.length];
            System.arraycopy(usernameBytes, 0, toEncode, 0, usernameBytes.length);
            toEncode[usernameBytes.length] = 32;
            System.arraycopy(hmacResult, 0, toEncode, usernameBytes.length + 1, hmacResult.length);
            return SMTPReply.isPositiveCompletion(sendCommand(Base64.encodeBase64StringUnChunked(toEncode)));
        }
        if (method.equals(AUTH_METHOD.LOGIN)) {
            if (SMTPReply.isPositiveIntermediate(sendCommand(Base64.encodeBase64StringUnChunked(username.getBytes(getCharset()))))) {
                return SMTPReply.isPositiveCompletion(sendCommand(Base64.encodeBase64StringUnChunked(password.getBytes(getCharset()))));
            }
            return false;
        }
        if (method.equals(AUTH_METHOD.XOAUTH) || method.equals(AUTH_METHOD.XOAUTH2)) {
            return SMTPReply.isPositiveIntermediate(sendCommand(Base64.encodeBase64StringUnChunked(username.getBytes(getCharset()))));
        }
        return false;
    }

    private String convertToHexString(byte[] a) {
        StringBuilder result = new StringBuilder(a.length * 2);
        for (byte element : a) {
            if ((element & UByte.MAX_VALUE) <= 15) {
                result.append("0");
            }
            result.append(Integer.toHexString(element & UByte.MAX_VALUE));
        }
        return result.toString();
    }

    public int ehlo(String hostname) throws IOException {
        return sendCommand(15, hostname);
    }

    public boolean elogin() throws IOException {
        InetAddress host = getLocalAddress();
        String name = host.getHostName();
        if (name == null) {
            return false;
        }
        return SMTPReply.isPositiveCompletion(ehlo(name));
    }

    public boolean elogin(String hostname) throws IOException {
        return SMTPReply.isPositiveCompletion(ehlo(hostname));
    }

    public int[] getEnhancedReplyCode() {
        String reply = getReplyString().substring(4);
        final String[] parts = reply.substring(0, reply.indexOf(32)).split("\\.");
        int[] res = new int[parts.length];
        Arrays.setAll(res, new IntUnaryOperator() { // from class: org.apache.commons.net.smtp.AuthenticatingSMTPClient$$ExternalSyntheticLambda0
            @Override // java.util.function.IntUnaryOperator
            public final int applyAsInt(int i) {
                return Integer.parseInt(parts[i]);
            }
        });
        return res;
    }
}
