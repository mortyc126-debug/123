/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.Cipher;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256CTR
implements Cipher {
    private static final int bsize = 32;
    private static final int ivsize = 16;
    private javax.crypto.Cipher cipher;

    @Override
    public int getBlockSize() {
        return 32;
    }

    @Override
    public int getIVSize() {
        return 16;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void init(int n, byte[] object, byte[] object2) throws Exception {
        javax.crypto.Cipher cipher;
        byte[] byArray = object2;
        if (((byte[])object2).length > 16) {
            byArray = new byte[16];
            System.arraycopy(object2, 0, byArray, 0, byArray.length);
        }
        object2 = object;
        if (((byte[])object).length > 32) {
            object2 = new byte[32];
            System.arraycopy(object, 0, object2, 0, ((byte[])object2).length);
        }
        try {
            object = new SecretKeySpec;
            object((byte[])object2, "AES");
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            this.cipher = javax.crypto.Cipher.getInstance(((StringBuilder)object2).append("AES/CTR/").append("NoPadding").toString());
            synchronized (javax.crypto.Cipher.class) {
                cipher = this.cipher;
                n = n == 0 ? 1 : 2;
                object2 = new IvParameterSpec(byArray);
            }
        }
        catch (Exception exception) {
            this.cipher = null;
            throw exception;
        }
        {
            cipher.init(n, (Key)object, (AlgorithmParameterSpec)object2);
            return;
        }
    }

    @Override
    public boolean isCBC() {
        return false;
    }

    @Override
    public void update(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws Exception {
        this.cipher.update(byArray, n, n2, byArray2, n3);
    }
}

