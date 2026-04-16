/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jcraft;

import com.jcraft.jsch.jcraft.HMACSHA1;

public class HMACSHA196
extends HMACSHA1 {
    private static final int BSIZE = 12;
    private static final String name = "hmac-sha1-96";
    private final byte[] _buf16 = new byte[20];

    @Override
    public void doFinal(byte[] byArray, int n) {
        super.doFinal(this._buf16, 0);
        System.arraycopy(this._buf16, 0, byArray, n, 12);
    }

    @Override
    public int getBlockSize() {
        return 12;
    }

    @Override
    public String getName() {
        return name;
    }
}

