/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserAuth;
import com.jcraft.jsch.Util;

class UserAuthNone
extends UserAuth {
    private static final int SSH_MSG_SERVICE_ACCEPT = 6;
    private String methods = null;

    UserAuthNone() {
    }

    String getMethods() {
        return this.methods;
    }

    @Override
    public boolean start(Session object) throws Exception {
        super.start((Session)object);
        this.packet.reset();
        this.buf.putByte((byte)5);
        this.buf.putString(Util.str2byte("ssh-userauth"));
        ((Session)object).write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_SERVICE_REQUEST sent");
        }
        this.buf = ((Session)object).read(this.buf);
        int n = this.buf.getCommand() == 6 ? 1 : 0;
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_SERVICE_ACCEPT received");
        }
        if (n == 0) {
            return false;
        }
        Object object2 = Util.str2byte(this.username);
        this.packet.reset();
        this.buf.putByte((byte)50);
        this.buf.putString((byte[])object2);
        this.buf.putString(Util.str2byte("ssh-connection"));
        this.buf.putString(Util.str2byte("none"));
        ((Session)object).write(this.packet);
        while (true) {
            this.buf = ((Session)object).read(this.buf);
            n = this.buf.getCommand() & 0xFF;
            if (n == 52) {
                return true;
            }
            if (n != 53) break;
            this.buf.getInt();
            this.buf.getByte();
            this.buf.getByte();
            object2 = this.buf.getString();
            this.buf.getString();
            object2 = Util.byte2str(object2);
            if (this.userinfo == null) continue;
            try {
                this.userinfo.showMessage((String)object2);
            }
            catch (RuntimeException runtimeException) {}
        }
        if (n == 51) {
            this.buf.getInt();
            this.buf.getByte();
            this.buf.getByte();
            object = this.buf.getString();
            this.buf.getByte();
            this.methods = Util.byte2str((byte[])object);
            return false;
        }
        throw new JSchException("USERAUTH fail (" + n + ")");
    }
}

