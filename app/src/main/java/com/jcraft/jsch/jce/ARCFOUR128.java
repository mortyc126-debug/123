/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.Cipher;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

public class ARCFOUR128
implements Cipher {
    private static final int bsize = 16;
    private static final int ivsize = 8;
    private static final int skip = 1536;
    private javax.crypto.Cipher cipher;

    @Override
    public int getBlockSize() {
        return 16;
    }

    @Override
    public int getIVSize() {
        return 8;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void init(int n, byte[] object, byte[] object2) throws Exception {
        object2 = object;
        if (((byte[])object).length > 16) {
            object2 = new byte[16];
            System.arraycopy(object, 0, object2, 0, ((byte[])object2).length);
        }
        try {
            this.cipher = javax.crypto.Cipher.getInstance("RC4");
            object = new SecretKeySpec;
            object((byte[])object2, "RC4");
            synchronized (javax.crypto.Cipher.class) {
            }
        }
        catch (Exception exception) {
            this.cipher = null;
            throw exception;
        }
        {
            object2 = this.cipher;
            n = n == 0 ? 1 : 2;
            ((javax.crypto.Cipher)object2).init(n, (Key)object);
        }
        {
            object = new byte[1];
            n = 0;
            while (n < 1536) {
                this.cipher.update((byte[])object, 0, 1, (byte[])object, 0);
                ++n;
            }
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

