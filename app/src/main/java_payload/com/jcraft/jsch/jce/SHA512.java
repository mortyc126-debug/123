/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.HASH;
import java.security.MessageDigest;

public class SHA512
implements HASH {
    MessageDigest md;

    @Override
    public byte[] digest() throws Exception {
        return this.md.digest();
    }

    @Override
    public int getBlockSize() {
        return 64;
    }

    @Override
    public void init() throws Exception {
        try {
            this.md = MessageDigest.getInstance("SHA-512");
        }
        catch (Exception exception) {
            System.err.println(exception);
        }
    }

    @Override
    public void update(byte[] byArray, int n, int n2) throws Exception {
        this.md.update(byArray, n, n2);
    }
}

