/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.Buffer;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.KeySpec;

public class SignatureDSA
implements com.jcraft.jsch.SignatureDSA {
    KeyFactory keyFactory;
    Signature signature;

    @Override
    public void init() throws Exception {
        this.signature = Signature.getInstance("SHA1withDSA");
        this.keyFactory = KeyFactory.getInstance("DSA");
    }

    protected byte[] normalize(byte[] byArray) {
        if (byArray.length > 1 && byArray[0] == 0 && (byArray[1] & 0x80) == 0) {
            byte[] byArray2 = new byte[byArray.length - 1];
            System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
            return this.normalize(byArray2);
        }
        return byArray;
    }

    @Override
    public void setPrvKey(byte[] object, byte[] byArray, byte[] byArray2, byte[] byArray3) throws Exception {
        object = new DSAPrivateKeySpec(new BigInteger((byte[])object), new BigInteger(byArray), new BigInteger(byArray2), new BigInteger(byArray3));
        object = this.keyFactory.generatePrivate((KeySpec)object);
        this.signature.initSign((PrivateKey)object);
    }

    @Override
    public void setPubKey(byte[] object, byte[] byArray, byte[] byArray2, byte[] byArray3) throws Exception {
        object = new DSAPublicKeySpec(new BigInteger((byte[])object), new BigInteger(byArray), new BigInteger(byArray2), new BigInteger(byArray3));
        object = this.keyFactory.generatePublic((KeySpec)object);
        this.signature.initVerify((PublicKey)object);
    }

    @Override
    public byte[] sign() throws Exception {
        byte[] byArray = this.signature.sign();
        int n = 3 + 1;
        int n2 = byArray[3] & 0xFF;
        byte[] byArray2 = new byte[n2];
        int n3 = byArray2.length;
        int n4 = 0;
        System.arraycopy(byArray, n, byArray2, 0, n3);
        n2 = n + n2 + 1;
        byte[] byArray3 = new byte[byArray[n2] & 0xFF];
        System.arraycopy(byArray, n2 + 1, byArray3, 0, byArray3.length);
        byArray = new byte[40];
        n2 = byArray2.length;
        int n5 = 20;
        n2 = n2 > 20 ? 1 : 0;
        n = byArray2.length > 20 ? 0 : 20 - byArray2.length;
        n3 = byArray2.length > 20 ? 20 : byArray2.length;
        System.arraycopy(byArray2, n2, byArray, n, n3);
        n2 = n4;
        if (byArray3.length > 20) {
            n2 = 1;
        }
        n = byArray3.length > 20 ? 20 : 40 - byArray3.length;
        n3 = byArray3.length > 20 ? n5 : byArray3.length;
        System.arraycopy(byArray3, n2, byArray, n, n3);
        return byArray;
    }

    @Override
    public void update(byte[] byArray) throws Exception {
        this.signature.update(byArray);
    }

    @Override
    public boolean verify(byte[] byArray) throws Exception {
        int n;
        Object object;
        Object object2 = new Buffer(byArray);
        byte[] byArray2 = byArray;
        if (new String(((Buffer)object2).getString()).equals("ssh-dss")) {
            object = ((Buffer)object2).getInt();
            n = ((Buffer)object2).getOffSet();
            byArray2 = new byte[object];
            System.arraycopy(byArray, n, byArray2, 0, object);
        }
        byArray = new byte[20];
        System.arraycopy(byArray2, 0, byArray, 0, 20);
        byArray = this.normalize(byArray);
        object2 = new byte[20];
        System.arraycopy(byArray2, 20, object2, 0, 20);
        byArray2 = this.normalize((byte[])object2);
        object = (byArray[0] & 0x80) != 0 ? 1 : 0;
        n = (byArray2[0] & 0x80) != 0 ? 1 : 0;
        object2 = new byte[byArray.length + byArray2.length + 6 + object + n];
        object2[0] = 48;
        object2[1] = (byte)(byArray.length + byArray2.length + 4);
        object2[1] = (byte)(object2[1] + object);
        object2[1] = (byte)(object2[1] + n);
        object2[2] = 2;
        object2[3] = (byte)byArray.length;
        object2[3] = (byte)(object2[3] + object);
        System.arraycopy(byArray, 0, object2, object + 4, byArray.length);
        object2[object2[3] + 4] = 2;
        object2[object2[3] + 5] = (byte)byArray2.length;
        object = object2[3] + 5;
        object2[object] = (byte)(object2[object] + n);
        System.arraycopy(byArray2, 0, object2, (int)(object2[3] + 6 + n), byArray2.length);
        return this.signature.verify((byte[])object2);
    }
}

