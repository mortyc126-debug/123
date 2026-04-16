/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jcraft;

import java.security.MessageDigest;

class HMAC {
    private static final int B = 64;
    private int bsize = 0;
    private byte[] k_ipad = null;
    private byte[] k_opad = null;
    private MessageDigest md = null;
    private final byte[] tmp = new byte[4];

    HMAC() {
    }

    public void doFinal(byte[] byArray, int n) {
        byte[] byArray2 = this.md.digest();
        this.md.update(this.k_opad, 0, 64);
        this.md.update(byArray2, 0, this.bsize);
        try {
            this.md.digest(byArray, n, this.bsize);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.md.update(this.k_ipad, 0, 64);
    }

    public int getBlockSize() {
        return this.bsize;
    }

    public void init(byte[] byArray) throws Exception {
        this.md.reset();
        byte[] byArray2 = byArray;
        if (byArray.length > this.bsize) {
            byArray2 = new byte[this.bsize];
            System.arraycopy(byArray, 0, byArray2, 0, this.bsize);
        }
        byArray = byArray2;
        if (byArray2.length > 64) {
            this.md.update(byArray2, 0, byArray2.length);
            byArray = this.md.digest();
        }
        this.k_ipad = new byte[64];
        System.arraycopy(byArray, 0, this.k_ipad, 0, byArray.length);
        this.k_opad = new byte[64];
        System.arraycopy(byArray, 0, this.k_opad, 0, byArray.length);
        for (int i = 0; i < 64; ++i) {
            byArray = this.k_ipad;
            byArray[i] = (byte)(byArray[i] ^ 0x36);
            byArray = this.k_opad;
            byArray[i] = (byte)(byArray[i] ^ 0x5C);
        }
        this.md.update(this.k_ipad, 0, 64);
    }

    protected void setH(MessageDigest messageDigest) {
        this.md = messageDigest;
        this.bsize = messageDigest.getDigestLength();
    }

    public void update(int n) {
        this.tmp[0] = (byte)(n >>> 24);
        this.tmp[1] = (byte)(n >>> 16);
        this.tmp[2] = (byte)(n >>> 8);
        this.tmp[3] = (byte)n;
        this.update(this.tmp, 0, 4);
    }

    public void update(byte[] byArray, int n, int n2) {
        this.md.update(byArray, n, n2);
    }
}

