/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.MAC;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

abstract class HMAC
implements MAC {
    protected String algorithm;
    protected int bsize;
    private Mac mac;
    protected String name;
    private final byte[] tmp = new byte[4];

    HMAC() {
    }

    @Override
    public void doFinal(byte[] byArray, int n) {
        try {
            this.mac.doFinal(byArray, n);
        }
        catch (ShortBufferException shortBufferException) {
            System.err.println(shortBufferException);
        }
    }

    @Override
    public int getBlockSize() {
        return this.bsize;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void init(byte[] object) throws Exception {
        byte[] byArray = object;
        if (((byte[])object).length > this.bsize) {
            byArray = new byte[this.bsize];
            System.arraycopy(object, 0, byArray, 0, this.bsize);
        }
        object = new SecretKeySpec(byArray, this.algorithm);
        this.mac = Mac.getInstance(this.algorithm);
        this.mac.init((Key)object);
    }

    @Override
    public void update(int n) {
        this.tmp[0] = (byte)(n >>> 24);
        this.tmp[1] = (byte)(n >>> 16);
        this.tmp[2] = (byte)(n >>> 8);
        this.tmp[3] = (byte)n;
        this.update(this.tmp, 0, 4);
    }

    @Override
    public void update(byte[] byArray, int n, int n2) {
        this.mac.update(byArray, n, n2);
    }
}

