/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import java.security.SecureRandom;

public class Random
implements com.jcraft.jsch.Random {
    private SecureRandom random = null;
    private byte[] tmp = new byte[16];

    public Random() {
        this.random = new SecureRandom();
    }

    @Override
    public void fill(byte[] byArray, int n, int n2) {
        if (n2 > this.tmp.length) {
            this.tmp = new byte[n2];
        }
        this.random.nextBytes(this.tmp);
        System.arraycopy(this.tmp, 0, byArray, n, n2);
    }
}

