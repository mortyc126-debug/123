/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Cipher;

public class CipherNone
implements Cipher {
    private static final int bsize = 16;
    private static final int ivsize = 8;

    @Override
    public int getBlockSize() {
        return 16;
    }

    @Override
    public int getIVSize() {
        return 8;
    }

    @Override
    public void init(int n, byte[] byArray, byte[] byArray2) throws Exception {
    }

    @Override
    public boolean isCBC() {
        return false;
    }

    @Override
    public void update(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws Exception {
    }
}

