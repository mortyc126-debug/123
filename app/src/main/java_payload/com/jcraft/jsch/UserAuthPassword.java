/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchAuthCancelException;
import com.jcraft.jsch.JSchPartialAuthException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserAuth;
import com.jcraft.jsch.Util;

class UserAuthPassword
extends UserAuth {
    private final int SSH_MSG_USERAUTH_PASSWD_CHANGEREQ;

    UserAuthPassword() {
        this.SSH_MSG_USERAUTH_PASSWD_CHANGEREQ = 60;
    }

    @Override
    public boolean start(Session object) throws Exception {
        Object object2;
        block89: {
            Object object3;
            super.start((Session)object);
            byte[] byArray = ((Session)object).password;
            String string2 = this.username + "@" + ((Session)object).host;
            if (((Session)object).port != 22) {
                string2 = string2 + ":" + ((Session)object).port;
            }
            while (true) {
                int n;
                block86: {
                    block88: {
                        block87: {
                            Object[] objectArray;
                            block83: {
                                block77: {
                                    block78: {
                                        object3 = byArray;
                                        n = ((Session)object).auth_failures;
                                        object3 = byArray;
                                        int n2 = ((Session)object).max_auth_tries;
                                        if (n < n2) break block77;
                                        if (byArray == null) break block78;
                                        Util.bzero(byArray);
                                    }
                                    return false;
                                }
                                object2 = byArray;
                                if (byArray == null) {
                                    block81: {
                                        block82: {
                                            block79: {
                                                block80: {
                                                    object3 = byArray;
                                                    object2 = this.userinfo;
                                                    if (object2 != null) break block79;
                                                    if (byArray == null) break block80;
                                                    Util.bzero(byArray);
                                                }
                                                return false;
                                            }
                                            object3 = byArray;
                                            objectArray = this.userinfo;
                                            object3 = byArray;
                                            object2 = new StringBuilder;
                                            object3 = byArray;
                                            object2();
                                            object3 = byArray;
                                            if (!objectArray.promptPassword(object2.append("Password for ").append(string2).toString())) break block81;
                                            object3 = byArray;
                                            object2 = this.userinfo.getPassword();
                                            if (object2 == null) break block82;
                                            object3 = byArray;
                                            object2 = Util.str2byte((String)object2);
                                            break block83;
                                        }
                                        object3 = byArray;
                                        object3 = byArray;
                                        object = new JSchAuthCancelException("password");
                                        object3 = byArray;
                                        throw object;
                                    }
                                    object3 = byArray;
                                    object3 = byArray;
                                    object = new JSchAuthCancelException("password");
                                    object3 = byArray;
                                    throw object;
                                }
                            }
                            object3 = object2;
                            byArray = Util.str2byte(this.username);
                            object3 = object2;
                            this.packet.reset();
                            object3 = object2;
                            this.buf.putByte((byte)50);
                            object3 = object2;
                            this.buf.putString(byArray);
                            object3 = object2;
                            this.buf.putString(Util.str2byte("ssh-connection"));
                            object3 = object2;
                            this.buf.putString(Util.str2byte("password"));
                            object3 = object2;
                            this.buf.putByte((byte)0);
                            object3 = object2;
                            this.buf.putString((byte[])object2);
                            object3 = object2;
                            ((Session)object).write(this.packet);
                            while (true) {
                                block84: {
                                    block85: {
                                        object3 = object2;
                                        this.buf = ((Session)object).read(this.buf);
                                        object3 = object2;
                                        n = this.buf.getCommand();
                                        if ((n &= 0xFF) != 52) break block84;
                                        if (object2 == null) break block85;
                                        Util.bzero(object2);
                                    }
                                    return true;
                                }
                                if (n == 53) {
                                    object3 = object2;
                                    this.buf.getInt();
                                    object3 = object2;
                                    this.buf.getByte();
                                    object3 = object2;
                                    this.buf.getByte();
                                    object3 = object2;
                                    objectArray = this.buf.getString();
                                    object3 = object2;
                                    this.buf.getString();
                                    object3 = object2;
                                    objectArray = Util.byte2str((byte[])objectArray);
                                    object3 = object2;
                                    if (this.userinfo == null) continue;
                                    object3 = object2;
                                    this.userinfo.showMessage((String)objectArray);
                                    continue;
                                }
                                if (n != 60) break block86;
                                object3 = object2;
                                this.buf.getInt();
                                object3 = object2;
                                this.buf.getByte();
                                object3 = object2;
                                this.buf.getByte();
                                object3 = object2;
                                objectArray = this.buf.getString();
                                object3 = object2;
                                this.buf.getString();
                                object3 = object2;
                                if (this.userinfo == null) break block87;
                                object3 = object2;
                                if (!(this.userinfo instanceof UIKeyboardInteractive)) break block87;
                                object3 = object2;
                                objectArray = ((UIKeyboardInteractive)((Object)this.userinfo)).promptKeyboardInteractive(string2, "Password Change Required", Util.byte2str((byte[])objectArray), new String[]{"New Password: "}, new boolean[]{false});
                                if (objectArray == null) break;
                                object3 = object2;
                                objectArray = Util.str2byte(objectArray[0]);
                                object3 = object2;
                                this.packet.reset();
                                object3 = object2;
                                this.buf.putByte((byte)50);
                                object3 = object2;
                                this.buf.putString(byArray);
                                object3 = object2;
                                this.buf.putString(Util.str2byte("ssh-connection"));
                                object3 = object2;
                                this.buf.putString(Util.str2byte("password"));
                                object3 = object2;
                                this.buf.putByte((byte)1);
                                object3 = object2;
                                this.buf.putString((byte[])object2);
                                object3 = object2;
                                this.buf.putString((byte[])objectArray);
                                object3 = object2;
                                Util.bzero((byte[])objectArray);
                                object3 = object2;
                                ((Session)object).write(this.packet);
                                continue;
                                break;
                            }
                            object3 = object2;
                            object3 = object2;
                            object = new JSchAuthCancelException("password");
                            object3 = object2;
                            throw object;
                        }
                        object3 = object2;
                        if (this.userinfo == null) break block88;
                        object3 = object2;
                        this.userinfo.showMessage("Password must be changed.");
                    }
                    if (object2 != null) {
                        Util.bzero(object2);
                    }
                    return false;
                }
                if (n != 51) break block89;
                object3 = object2;
                this.buf.getInt();
                object3 = object2;
                this.buf.getByte();
                object3 = object2;
                this.buf.getByte();
                object3 = object2;
                byArray = this.buf.getString();
                object3 = object2;
                if (this.buf.getByte() != 0) break;
                object3 = object2;
                ++((Session)object).auth_failures;
                byArray = object2;
                if (object2 == null) continue;
                object3 = object2;
                Util.bzero(object2);
                byArray = null;
                continue;
                break;
            }
            object3 = object2;
            object3 = object2;
            try {
                object = new JSchPartialAuthException(Util.byte2str(byArray));
                object3 = object2;
            }
            catch (Throwable throwable) {
                if (object3 != null) {
                    Util.bzero(object3);
                }
                throw throwable;
            }
            throw object;
        }
        if (object2 != null) {
            Util.bzero(object2);
        }
        return false;
    }
}

