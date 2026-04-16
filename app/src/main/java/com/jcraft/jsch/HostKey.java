/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.HASH;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Util;

public class HostKey {
    public static final int ECDSA256 = 3;
    public static final int ECDSA384 = 4;
    public static final int ECDSA521 = 5;
    protected static final int GUESS = 0;
    public static final int SSHDSS = 1;
    public static final int SSHRSA = 2;
    static final int UNKNOWN = 6;
    private static final byte[][] names = new byte[][]{Util.str2byte("ssh-dss"), Util.str2byte("ssh-rsa"), Util.str2byte("ecdsa-sha2-nistp256"), Util.str2byte("ecdsa-sha2-nistp384"), Util.str2byte("ecdsa-sha2-nistp521")};
    protected String comment;
    protected String host;
    protected byte[] key;
    protected String marker;
    protected int type;

    public HostKey(String string2, int n, byte[] byArray) throws JSchException {
        this(string2, n, byArray, null);
    }

    public HostKey(String string2, int n, byte[] byArray, String string3) throws JSchException {
        this("", string2, n, byArray, string3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public HostKey(String string2, String string3, int n, byte[] byArray, String string4) throws JSchException {
        this.marker = string2;
        this.host = string3;
        if (n == 0) {
            if (byArray[8] == 100) {
                this.type = 1;
            } else if (byArray[8] == 114) {
                this.type = 2;
            } else if (byArray[8] == 97 && byArray[20] == 50) {
                this.type = 3;
            } else if (byArray[8] == 97 && byArray[20] == 51) {
                this.type = 4;
            } else {
                if (byArray[8] != 97 || byArray[20] != 53) throw new JSchException("invalid key type");
                this.type = 5;
            }
        } else {
            this.type = n;
        }
        this.key = byArray;
        this.comment = string4;
    }

    public HostKey(String string2, byte[] byArray) throws JSchException {
        this(string2, 0, byArray);
    }

    private boolean isIncluded(String string2) {
        int n = 0;
        String string3 = this.host;
        int n2 = string3.length();
        int n3 = string2.length();
        while (n < n2) {
            int n4 = string3.indexOf(44, n);
            if (n4 == -1) {
                if (n3 != n2 - n) {
                    return false;
                }
                return string3.regionMatches(true, n, string2, 0, n3);
            }
            if (n3 == n4 - n && string3.regionMatches(true, n, string2, 0, n3)) {
                return true;
            }
            n = n4 + 1;
        }
        return false;
    }

    protected static int name2type(String string2) {
        for (int i = 0; i < names.length; ++i) {
            if (!Util.byte2str(names[i]).equals(string2)) continue;
            return i + 1;
        }
        return 6;
    }

    public String getComment() {
        return this.comment;
    }

    public String getFingerPrint(JSch object) {
        object = null;
        try {
            HASH hASH;
            HASH hASH2 = hASH = (HASH)Class.forName(JSch.getConfig("md5")).newInstance();
            object = hASH;
        }
        catch (Exception exception) {
            System.err.println("getFingerPrint: " + exception);
        }
        return Util.getFingerPrint((HASH)object, this.key);
    }

    public String getHost() {
        return this.host;
    }

    public String getKey() {
        return Util.byte2str(Util.toBase64(this.key, 0, this.key.length));
    }

    public String getMarker() {
        return this.marker;
    }

    public String getType() {
        if (this.type != 1 && this.type != 2 && this.type != 3 && this.type != 4 && this.type != 5) {
            return "UNKNOWN";
        }
        return Util.byte2str(names[this.type - 1]);
    }

    boolean isMatched(String string2) {
        return this.isIncluded(string2);
    }
}

