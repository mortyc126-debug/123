/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.GSSContext;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.JSchPartialAuthException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserAuth;
import com.jcraft.jsch.Util;

public class UserAuthGSSAPIWithMIC
extends UserAuth {
    private static final int SSH_MSG_USERAUTH_GSSAPI_ERROR = 64;
    private static final int SSH_MSG_USERAUTH_GSSAPI_ERRTOK = 65;
    private static final int SSH_MSG_USERAUTH_GSSAPI_EXCHANGE_COMPLETE = 63;
    private static final int SSH_MSG_USERAUTH_GSSAPI_MIC = 66;
    private static final int SSH_MSG_USERAUTH_GSSAPI_RESPONSE = 60;
    private static final int SSH_MSG_USERAUTH_GSSAPI_TOKEN = 61;
    private static final String[] supported_method;
    private static final byte[][] supported_oid;

    static {
        supported_oid = new byte[][]{{6, 9, 42, -122, 72, -122, -9, 18, 1, 2, 2}};
        supported_method = new String[]{"gssapi-with-mic.krb5"};
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean start(Session object) throws Exception {
        int n;
        super.start((Session)object);
        byte[] byArray = Util.str2byte(this.username);
        this.packet.reset();
        this.buf.putByte((byte)50);
        this.buf.putString(byArray);
        this.buf.putString(Util.str2byte("ssh-connection"));
        this.buf.putString(Util.str2byte("gssapi-with-mic"));
        this.buf.putInt(supported_oid.length);
        for (n = 0; n < supported_oid.length; ++n) {
            this.buf.putString(supported_oid[n]);
        }
        ((Session)object).write(this.packet);
        GSSContext gSSContext = null;
        while (true) {
            Object object2;
            this.buf = ((Session)object).read(this.buf);
            n = this.buf.getCommand() & 0xFF;
            if (n == 51) {
                return false;
            }
            if (n == 60) {
                this.buf.getInt();
                this.buf.getByte();
                this.buf.getByte();
                byte[] byArray2 = this.buf.getString();
                n = 0;
                while (true) {
                    object2 = gSSContext;
                    if (n >= supported_oid.length) break;
                    if (Util.array_equals(byArray2, supported_oid[n])) {
                        object2 = supported_method[n];
                        break;
                    }
                    ++n;
                }
                if (object2 == null) {
                    return false;
                }
                try {
                    gSSContext = (GSSContext)Class.forName(((Session)object).getConfig((String)object2)).newInstance();
                    object2 = gSSContext;
                }
                catch (Exception exception) {
                    return false;
                }
                try {
                    gSSContext.create(this.username, ((Session)object).host);
                }
                catch (JSchException jSchException) {
                    return false;
                }
                object2 = new byte[]{};
                while (!gSSContext.isEstablished()) {
                    try {
                        object2 = gSSContext.init((byte[])object2, 0, ((byte[])object2).length);
                        if (object2 != null) {
                            this.packet.reset();
                            this.buf.putByte((byte)61);
                            this.buf.putString((byte[])object2);
                            ((Session)object).write(this.packet);
                        }
                        if (gSSContext.isEstablished()) continue;
                        this.buf = ((Session)object).read(this.buf);
                        int n2 = this.buf.getCommand() & 0xFF;
                        if (n2 == 64) {
                            this.buf = ((Session)object).read(this.buf);
                            n = this.buf.getCommand() & 0xFF;
                        } else {
                            n = n2;
                            if (n2 == 65) {
                                this.buf = ((Session)object).read(this.buf);
                                n = this.buf.getCommand() & 0xFF;
                            }
                        }
                        if (n == 51) {
                            return false;
                        }
                        this.buf.getInt();
                    }
                    catch (JSchException jSchException) {
                        return false;
                    }
                    this.buf.getByte();
                    this.buf.getByte();
                    object2 = this.buf.getString();
                }
                object2 = new Buffer();
                object2.putString(((Session)object).getSessionId());
                object2.putByte((byte)50);
                object2.putString(byArray);
                object2.putString(Util.str2byte("ssh-connection"));
                object2.putString(Util.str2byte("gssapi-with-mic"));
                object2 = gSSContext.getMIC(object2.buffer, 0, object2.getLength());
                if (object2 == null) {
                    return false;
                }
                this.packet.reset();
                this.buf.putByte((byte)66);
                this.buf.putString((byte[])object2);
                ((Session)object).write(this.packet);
                gSSContext.dispose();
                this.buf = ((Session)object).read(this.buf);
                n = this.buf.getCommand() & 0xFF;
                if (n == 52) {
                    return true;
                }
                if (n != 51) return false;
                this.buf.getInt();
                this.buf.getByte();
                this.buf.getByte();
                object = this.buf.getString();
                if (this.buf.getByte() != 0) throw new JSchPartialAuthException(Util.byte2str((byte[])object));
                return false;
            }
            if (n != 53) return false;
            this.buf.getInt();
            this.buf.getByte();
            this.buf.getByte();
            object2 = this.buf.getString();
            this.buf.getString();
            object2 = Util.byte2str(object2);
            if (this.userinfo == null) continue;
            this.userinfo.showMessage((String)object2);
        }
    }
}

