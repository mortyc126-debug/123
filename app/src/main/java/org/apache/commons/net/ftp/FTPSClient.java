package org.apache.commons.net.ftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import okhttp3.HttpUrl;
import org.apache.commons.net.util.Base64;
import org.apache.commons.net.util.SSLContextUtils;
import org.apache.commons.net.util.SSLSocketUtils;
import org.apache.commons.net.util.TrustManagerUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FTPSClient extends FTPClient {
    private static final String CMD_ADAT = "ADAT";
    private static final String CMD_AUTH = "AUTH";
    private static final String CMD_CCC = "CCC";
    private static final String CMD_CONF = "CONF";
    private static final String CMD_ENC = "ENC";
    private static final String CMD_MIC = "MIC";
    private static final String CMD_PBSZ = "PBSZ";
    private static final String CMD_PROT = "PROT";
    public static final int DEFAULT_FTPS_DATA_PORT = 989;
    public static final int DEFAULT_FTPS_PORT = 990;
    private static final String DEFAULT_PROTOCOL = "TLS";

    @Deprecated
    public static String KEYSTORE_ALGORITHM;

    @Deprecated
    public static String PROVIDER;

    @Deprecated
    public static String STORE_TYPE;

    @Deprecated
    public static String TRUSTSTORE_ALGORITHM;
    private String auth;
    private SSLContext context;
    private HostnameVerifier hostnameVerifier;
    private boolean isClientMode;
    private boolean isCreation;
    private final boolean isImplicit;
    private boolean isNeedClientAuth;
    private boolean isWantClientAuth;
    private KeyManager keyManager;
    private Socket plainSocket;
    private final String protocol;
    private String[] protocols;
    private String[] suites;
    private boolean tlsEndpointChecking;
    private TrustManager trustManager;
    private static final String DEFAULT_PROT = "C";
    private static final String[] PROT_COMMAND_VALUE = {DEFAULT_PROT, "E", "S", "P"};

    public FTPSClient() {
        this("TLS", false);
    }

    public FTPSClient(boolean isImplicit) {
        this("TLS", isImplicit);
    }

    public FTPSClient(boolean isImplicit, SSLContext context) {
        this("TLS", isImplicit);
        this.context = context;
    }

    public FTPSClient(SSLContext context) {
        this(false, context);
    }

    public FTPSClient(String protocol) {
        this(protocol, false);
    }

    public FTPSClient(String protocol, boolean isImplicit) {
        this.auth = "TLS";
        this.isCreation = true;
        this.isClientMode = true;
        this.trustManager = TrustManagerUtils.getValidateServerCertificateTrustManager();
        this.protocol = protocol;
        this.isImplicit = isImplicit;
        if (isImplicit) {
            setDefaultPort(DEFAULT_FTPS_PORT);
        }
    }

    @Override // org.apache.commons.net.ftp.FTPClient, org.apache.commons.net.ftp.FTP, org.apache.commons.net.SocketClient
    protected void _connectAction_() throws IOException {
        if (this.isImplicit) {
            applySocketAttributes();
            sslNegotiation();
        }
        super._connectAction_();
        if (!this.isImplicit) {
            execAUTH();
            sslNegotiation();
        }
    }

    @Override // org.apache.commons.net.ftp.FTPClient
    @Deprecated
    protected Socket _openDataConnection_(int command, String arg) throws IOException {
        return _openDataConnection_(FTPCommand.getCommand(command), arg);
    }

    @Override // org.apache.commons.net.ftp.FTPClient
    protected Socket _openDataConnection_(String command, String arg) throws IOException {
        Socket socket = openDataSecureConnection(command, arg);
        _prepareDataSocket_(socket);
        if (socket instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.setUseClientMode(this.isClientMode);
            sslSocket.setEnableSessionCreation(this.isCreation);
            if (!this.isClientMode) {
                sslSocket.setNeedClientAuth(this.isNeedClientAuth);
                sslSocket.setWantClientAuth(this.isWantClientAuth);
            }
            if (this.suites != null) {
                sslSocket.setEnabledCipherSuites(this.suites);
            }
            if (this.protocols != null) {
                sslSocket.setEnabledProtocols(this.protocols);
            }
            sslSocket.startHandshake();
        }
        return socket;
    }

    protected void _prepareDataSocket_(Socket socket) throws IOException {
    }

    private boolean checkPROTValue(String prot) {
        for (String element : PROT_COMMAND_VALUE) {
            if (element.equals(prot)) {
                return true;
            }
        }
        return false;
    }

    private void closeSockets(Socket socket, Socket sslSocket) throws IOException {
        if (socket != null) {
            socket.close();
        }
        if (sslSocket != null) {
            sslSocket.close();
        }
    }

    private SSLSocket createSSLSocket(Socket socket) throws IOException {
        if (socket != null) {
            SSLSocketFactory f2 = this.context.getSocketFactory();
            return (SSLSocket) f2.createSocket(socket, this._hostname_, socket.getPort(), false);
        }
        return null;
    }

    @Override // org.apache.commons.net.ftp.FTPClient, org.apache.commons.net.ftp.FTP, org.apache.commons.net.SocketClient
    public void disconnect() throws IOException {
        super.disconnect();
        if (this.plainSocket != null) {
            this.plainSocket.close();
        }
        setSocketFactory(null);
        setServerSocketFactory(null);
    }

    public int execADAT(byte[] data) throws IOException {
        if (data != null) {
            return sendCommand(CMD_ADAT, Base64.encodeBase64StringUnChunked(data));
        }
        return sendCommand(CMD_ADAT);
    }

    protected void execAUTH() throws IOException {
        int replyCode = sendCommand(CMD_AUTH, this.auth);
        if (334 != replyCode && 234 != replyCode) {
            throw new SSLException(getReplyString());
        }
    }

    public int execAUTH(String mechanism) throws IOException {
        return sendCommand(CMD_AUTH, mechanism);
    }

    public int execCCC() throws IOException {
        int repCode = sendCommand(CMD_CCC);
        return repCode;
    }

    public int execCONF(byte[] data) throws IOException {
        return data != null ? sendCommand(CMD_CONF, Base64.encodeBase64StringUnChunked(data)) : sendCommand(CMD_CONF, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public int execENC(byte[] data) throws IOException {
        return data != null ? sendCommand(CMD_ENC, Base64.encodeBase64StringUnChunked(data)) : sendCommand(CMD_ENC, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public int execMIC(byte[] data) throws IOException {
        return data != null ? sendCommand(CMD_MIC, Base64.encodeBase64StringUnChunked(data)) : sendCommand(CMD_MIC, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public void execPBSZ(long pbsz) throws IOException {
        if (pbsz < 0 || 4294967295L < pbsz) {
            throw new IllegalArgumentException();
        }
        int status = sendCommand(CMD_PBSZ, String.valueOf(pbsz));
        if (200 != status) {
            throw new SSLException(getReplyString());
        }
    }

    public void execPROT(String prot) throws IOException {
        if (prot == null) {
            prot = DEFAULT_PROT;
        }
        if (!checkPROTValue(prot)) {
            throw new IllegalArgumentException();
        }
        if (200 != sendCommand(CMD_PROT, prot)) {
            throw new SSLException(getReplyString());
        }
        if (DEFAULT_PROT.equals(prot)) {
            setSocketFactory(null);
            setServerSocketFactory(null);
        } else {
            setSocketFactory(new FTPSSocketFactory(this.context));
            setServerSocketFactory(new FTPSServerSocketFactory(this.context));
            initSslContext();
        }
    }

    private String extractPrefixedData(String prefix, String reply) {
        int idx = reply.indexOf(prefix);
        if (idx == -1) {
            return null;
        }
        return reply.substring(prefix.length() + idx).trim();
    }

    public String getAuthValue() {
        return this.auth;
    }

    public String[] getEnabledCipherSuites() {
        if (this._socket_ instanceof SSLSocket) {
            return ((SSLSocket) this._socket_).getEnabledCipherSuites();
        }
        return null;
    }

    public String[] getEnabledProtocols() {
        if (this._socket_ instanceof SSLSocket) {
            return ((SSLSocket) this._socket_).getEnabledProtocols();
        }
        return null;
    }

    public boolean getEnableSessionCreation() {
        if (this._socket_ instanceof SSLSocket) {
            return ((SSLSocket) this._socket_).getEnableSessionCreation();
        }
        return false;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    private KeyManager getKeyManager() {
        return this.keyManager;
    }

    public boolean getNeedClientAuth() {
        if (this._socket_ instanceof SSLSocket) {
            return ((SSLSocket) this._socket_).getNeedClientAuth();
        }
        return false;
    }

    public TrustManager getTrustManager() {
        return this.trustManager;
    }

    public boolean getUseClientMode() {
        if (this._socket_ instanceof SSLSocket) {
            return ((SSLSocket) this._socket_).getUseClientMode();
        }
        return false;
    }

    public boolean getWantClientAuth() {
        if (this._socket_ instanceof SSLSocket) {
            return ((SSLSocket) this._socket_).getWantClientAuth();
        }
        return false;
    }

    private void initSslContext() throws IOException {
        if (this.context == null) {
            this.context = SSLContextUtils.createSSLContext(this.protocol, getKeyManager(), getTrustManager());
        }
    }

    public boolean isEndpointCheckingEnabled() {
        return this.tlsEndpointChecking;
    }

    private Socket openDataSecureConnection(String command, String arg) throws IOException {
        Socket socket;
        if (getDataConnectionMode() != 0 && getDataConnectionMode() != 2) {
            return null;
        }
        boolean isInet6Address = getRemoteAddress() instanceof Inet6Address;
        int soTimeoutMillis = DurationUtils.toMillisInt(getDataTimeout());
        if (getDataConnectionMode() == 0) {
            ServerSocket server = this._serverSocketFactory_.createServerSocket(getActivePort(), 1, getHostAddress());
            try {
                if (isInet6Address) {
                    if (!FTPReply.isPositiveCompletion(eprt(getReportHostAddress(), server.getLocalPort()))) {
                        if (server != null) {
                            server.close();
                        }
                        return null;
                    }
                } else if (!FTPReply.isPositiveCompletion(port(getReportHostAddress(), server.getLocalPort()))) {
                    if (server != null) {
                        server.close();
                    }
                    return null;
                }
                if (getRestartOffset() > 0 && !restart(getRestartOffset())) {
                    if (server != null) {
                        server.close();
                    }
                    return null;
                }
                if (!FTPReply.isPositivePreliminary(sendCommand(command, arg))) {
                    if (server != null) {
                        server.close();
                    }
                    return null;
                }
                if (soTimeoutMillis >= 0) {
                    server.setSoTimeout(soTimeoutMillis);
                }
                socket = server.accept();
                if (soTimeoutMillis >= 0) {
                    socket.setSoTimeout(soTimeoutMillis);
                }
                if (getReceiveDataSocketBufferSize() > 0) {
                    socket.setReceiveBufferSize(getReceiveDataSocketBufferSize());
                }
                if (getSendDataSocketBufferSize() > 0) {
                    socket.setSendBufferSize(getSendDataSocketBufferSize());
                }
                if (server != null) {
                    server.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (server != null) {
                        try {
                            server.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } else {
            boolean attemptEPSV = isUseEPSVwithIPv4() || isInet6Address;
            if (attemptEPSV && epsv() == 229) {
                _parseExtendedPassiveModeReply(this._replyLines.get(0));
            } else {
                if (isInet6Address || pasv() != 227) {
                    return null;
                }
                _parsePassiveModeReply(this._replyLines.get(0));
            }
            Socket socket2 = getProxy() != null ? new Socket(getProxy()) : this._socketFactory_.createSocket();
            if (getReceiveDataSocketBufferSize() > 0) {
                socket2.setReceiveBufferSize(getReceiveDataSocketBufferSize());
            }
            if (getSendDataSocketBufferSize() > 0) {
                socket2.setSendBufferSize(getSendDataSocketBufferSize());
            }
            if (getPassiveLocalIPAddress() != null) {
                socket2.bind(new InetSocketAddress(getPassiveLocalIPAddress(), 0));
            }
            if (soTimeoutMillis >= 0) {
                socket2.setSoTimeout(soTimeoutMillis);
            }
            socket2.connect(new InetSocketAddress(getPassiveHost(), getPassivePort()), this.connectTimeout);
            sslSocket = getProxy() != null ? this.context.getSocketFactory().createSocket(socket2, getPassiveHost(), getPassivePort(), true) : null;
            if (getRestartOffset() > 0 && !restart(getRestartOffset())) {
                closeSockets(socket2, sslSocket);
                return null;
            }
            if (!FTPReply.isPositivePreliminary(sendCommand(command, arg))) {
                closeSockets(socket2, sslSocket);
                return null;
            }
            socket = socket2;
        }
        boolean attemptEPSV2 = isRemoteVerificationEnabled();
        if (!attemptEPSV2 || verifyRemote(socket)) {
            return getProxy() != null ? sslSocket : socket;
        }
        InetAddress socketHost = socket.getInetAddress();
        closeSockets(socket, sslSocket);
        throw new IOException("Host attempting data connection " + socketHost.getHostAddress() + " is not same as server " + getRemoteAddress().getHostAddress());
    }

    public byte[] parseADATReply(String reply) {
        if (reply == null) {
            return null;
        }
        return Base64.decodeBase64(extractPrefixedData("ADAT=", reply));
    }

    public long parsePBSZ(long pbsz) throws IOException {
        execPBSZ(pbsz);
        String remainder = extractPrefixedData("PBSZ=", getReplyString());
        if (remainder == null) {
            return pbsz;
        }
        long replysz = Long.parseLong(remainder);
        if (replysz >= pbsz) {
            return pbsz;
        }
        return replysz;
    }

    @Override // org.apache.commons.net.ftp.FTP
    public int sendCommand(String command, String args) throws IOException {
        int repCode = super.sendCommand(command, args);
        if (CMD_CCC.equals(command)) {
            if (200 != repCode) {
                throw new SSLException(getReplyString());
            }
            this._socket_.close();
            this._socket_ = this.plainSocket;
            this._controlInput_ = new BufferedReader(new InputStreamReader(this._socket_.getInputStream(), getControlEncoding()));
            this._controlOutput_ = new BufferedWriter(new OutputStreamWriter(this._socket_.getOutputStream(), getControlEncoding()));
        }
        return repCode;
    }

    public void setAuthValue(String auth) {
        this.auth = auth;
    }

    public void setEnabledCipherSuites(String[] cipherSuites) {
        this.suites = (String[]) cipherSuites.clone();
    }

    public void setEnabledProtocols(String[] protocolVersions) {
        this.protocols = (String[]) protocolVersions.clone();
    }

    public void setEnabledSessionCreation(boolean isCreation) {
        this.isCreation = isCreation;
    }

    public void setEndpointCheckingEnabled(boolean enable) {
        this.tlsEndpointChecking = enable;
    }

    public void setHostnameVerifier(HostnameVerifier newHostnameVerifier) {
        this.hostnameVerifier = newHostnameVerifier;
    }

    public void setKeyManager(KeyManager keyManager) {
        this.keyManager = keyManager;
    }

    public void setNeedClientAuth(boolean isNeedClientAuth) {
        this.isNeedClientAuth = isNeedClientAuth;
    }

    public void setTrustManager(TrustManager trustManager) {
        this.trustManager = trustManager;
    }

    public void setUseClientMode(boolean isClientMode) {
        this.isClientMode = isClientMode;
    }

    public void setWantClientAuth(boolean isWantClientAuth) {
        this.isWantClientAuth = isWantClientAuth;
    }

    protected void sslNegotiation() throws IOException {
        this.plainSocket = this._socket_;
        initSslContext();
        SSLSocket socket = createSSLSocket(this._socket_);
        socket.setEnableSessionCreation(this.isCreation);
        socket.setUseClientMode(this.isClientMode);
        if (this.isClientMode) {
            if (this.tlsEndpointChecking) {
                SSLSocketUtils.enableEndpointNameVerification(socket);
            }
        } else {
            socket.setNeedClientAuth(this.isNeedClientAuth);
            socket.setWantClientAuth(this.isWantClientAuth);
        }
        if (this.protocols != null) {
            socket.setEnabledProtocols(this.protocols);
        }
        if (this.suites != null) {
            socket.setEnabledCipherSuites(this.suites);
        }
        socket.startHandshake();
        this._socket_ = socket;
        this._controlInput_ = new BufferedReader(new InputStreamReader(socket.getInputStream(), getControlEncoding()));
        this._controlOutput_ = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), getControlEncoding()));
        if (this.isClientMode && this.hostnameVerifier != null && !this.hostnameVerifier.verify(this._hostname_, socket.getSession())) {
            throw new SSLHandshakeException("Hostname doesn't match certificate");
        }
    }
}
