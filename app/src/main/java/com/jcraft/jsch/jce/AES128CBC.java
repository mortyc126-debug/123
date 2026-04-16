/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.Cipher;
import java.security.Key;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES128CBC
implements Cipher {
    private static final int bsize = 16;
    private static final int ivsize = 16;
    private javax.crypto.Cipher cipher;

    @Override
    public int getBlockSize() {
        return 16;
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
        IvParameterSpec ivParameterSpec;
        byte[] byArray = object2;
        if (((byte[])object2).length > 16) {
            byArray = new byte[16];
            System.arraycopy(object2, 0, byArray, 0, byArray.length);
        }
        object2 = object;
        if (((byte[])object).length > 16) {
            object2 = new byte[16];
            System.arraycopy(object, 0, object2, 0, ((byte[])object2).length);
        }
        try {
            object = new SecretKeySpec;
            object((byte[])object2, "AES");
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            this.cipher = javax.crypto.Cipher.getInstance(((StringBuilder)object2).append("AES/CBC/").append("NoPadding").toString());
            synchronized (javax.crypto.Cipher.class) {
                object2 = this.cipher;
                n = n == 0 ? 1 : 2;
                ivParameterSpec = new IvParameterSpec(byArray);
            }
        }
        catch (Exception exception) {
            this.cipher = null;
            throw exception;
        }
        {
            ((javax.crypto.Cipher)object2).init(n, (Key)object, ivParameterSpec);
            return;
        }
    }

    @Override
    public boolean isCBC() {
        return true;
    }

    @Override
    public void update(byte[] byArray, int n, int n2, byte[] byArray2, int n3) throws Exception {
        this.cipher.update(byArray, n, n2, byArray2, n3);
    }
}

