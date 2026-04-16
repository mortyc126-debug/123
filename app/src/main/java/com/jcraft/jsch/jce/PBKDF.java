/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF
implements com.jcraft.jsch.PBKDF {
    @Override
    public byte[] getKey(byte[] object, byte[] byArray, int n, int n2) {
        char[] cArray = new char[((byte[])object).length];
        for (int i = 0; i < ((byte[])object).length; ++i) {
            cArray[i] = (char)(object[i] & 0xFF);
        }
        try {
            object = new PBEKeySpec;
            object(cArray, byArray, n, n2 * 8);
            object = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret((KeySpec)object).getEncoded();
            return object;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            // empty catch block
        }
        return null;
    }
}

