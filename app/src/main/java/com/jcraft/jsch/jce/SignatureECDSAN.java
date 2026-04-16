/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.SignatureECDSA;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;

public abstract class SignatureECDSAN
implements SignatureECDSA {
    KeyFactory keyFactory;
    Signature signature;

    private void bzero(byte[] byArray) {
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = 0;
        }
    }

    private byte[] chop0(byte[] byArray) {
        if (byArray[0] != 0) {
            return byArray;
        }
        byte[] byArray2 = new byte[byArray.length - 1];
        System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
        this.bzero(byArray);
        return byArray2;
    }

    private byte[] insert0(byte[] byArray) {
        if ((byArray[0] & 0x80) == 0) {
            return byArray;
        }
        byte[] byArray2 = new byte[byArray.length + 1];
        System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
        this.bzero(byArray);
        return byArray2;
    }

    abstract String getName();

    @Override
    public void init() throws Exception {
        String string2 = this.getName();
        String string3 = "SHA256withECDSA";
        if (string2.equals("ecdsa-sha2-nistp384")) {
            string3 = "SHA384withECDSA";
        } else if (string2.equals("ecdsa-sha2-nistp521")) {
            string3 = "SHA512withECDSA";
        }
        this.signature = Signature.getInstance(string3);
        this.keyFactory = KeyFactory.getInstance("EC");
    }

    @Override
    public void setPrvKey(byte[] object) throws Exception {
        Object object2 = this.insert0((byte[])object);
        object = "secp256r1";
        if (((byte[])object2).length >= 64) {
            object = "secp521r1";
        } else if (((byte[])object2).length >= 48) {
            object = "secp384r1";
        }
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC");
        algorithmParameters.init(new ECGenParameterSpec((String)object));
        object = algorithmParameters.getParameterSpec(ECParameterSpec.class);
        object2 = new BigInteger(1, (byte[])object2);
        object = this.keyFactory.generatePrivate(new ECPrivateKeySpec((BigInteger)object2, (ECParameterSpec)object));
        this.signature.initSign((PrivateKey)object);
    }

    @Override
    public void setPubKey(byte[] object, byte[] object2) throws Exception {
        byte[] byArray = this.insert0((byte[])object);
        object2 = this.insert0((byte[])object2);
        object = "secp256r1";
        if (byArray.length >= 64) {
            object = "secp521r1";
        } else if (byArray.length >= 48) {
            object = "secp384r1";
        }
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC");
        algorithmParameters.init(new ECGenParameterSpec((String)object));
        object = algorithmParameters.getParameterSpec(ECParameterSpec.class);
        object2 = new ECPoint(new BigInteger(1, byArray), new BigInteger(1, (byte[])object2));
        object = this.keyFactory.generatePublic(new ECPublicKeySpec((ECPoint)object2, (ECParameterSpec)object));
        this.signature.initVerify((PublicKey)object);
    }

    @Override
    public byte[] sign() throws Exception {
        byte[] byArray;
        block5: {
            int n;
            Object object;
            block6: {
                object = this.signature.sign();
                byArray = object;
                if (object[0] != 48) break block5;
                if (object[1] + 2 == ((byte[])object).length) break block6;
                byArray = object;
                if ((object[1] & 0x80) == 0) break block5;
                byArray = object;
                if ((object[2] & 0xFF) + 3 != ((byte[])object).length) break block5;
            }
            int n2 = n = 3;
            if ((object[1] & 0x80) != 0) {
                n2 = n;
                if ((object[2] & 0xFF) + 3 == ((byte[])object).length) {
                    n2 = 4;
                }
            }
            byte[] byArray2 = new byte[object[n2]];
            byArray = new byte[object[n2 + 2 + object[n2]]];
            System.arraycopy(object, n2 + 1, byArray2, 0, byArray2.length);
            System.arraycopy(object, n2 + 3 + object[n2], byArray, 0, byArray.length);
            byArray2 = this.chop0(byArray2);
            byArray = this.chop0(byArray);
            object = new Buffer();
            ((Buffer)object).putMPInt(byArray2);
            ((Buffer)object).putMPInt(byArray);
            byArray = new byte[((Buffer)object).getLength()];
            ((Buffer)object).setOffSet(0);
            ((Buffer)object).getByte(byArray);
        }
        return byArray;
    }

    @Override
    public void update(byte[] byArray) throws Exception {
        this.signature.update(byArray);
    }

    @Override
    public boolean verify(byte[] object) throws Exception {
        Object object2;
        block6: {
            block5: {
                if (object[0] != 48) break block5;
                object2 = object;
                if (object[1] + 2 == ((Object)object).length) break block6;
                if ((object[1] & 0x80) == 0) break block5;
                object2 = object;
                if ((object[2] & 0xFF) + 3 == ((byte[])object).length) break block6;
            }
            object = new Buffer((byte[])object);
            object.getString();
            object.getInt();
            object2 = object.getMPInt();
            object = object.getMPInt();
            object2 = this.insert0((byte[])object2);
            byte[] byArray = this.insert0((byte[])object);
            if (((byte[])object2).length < 64) {
                object = new byte[((byte[])object2).length + 6 + byArray.length];
                object[0] = 48;
                object[1] = (byte)(((byte[])object2).length + 4 + byArray.length);
                object[2] = 2;
                object[3] = (byte)((byte[])object2).length;
                System.arraycopy(object2, 0, object, 4, ((byte[])object2).length);
                object[((byte[])object2).length + 4] = 2;
                object[((byte[])object2).length + 5] = (byte)byArray.length;
                System.arraycopy(byArray, 0, object, ((byte[])object2).length + 6, byArray.length);
            } else {
                object = new byte[((byte[])object2).length + 6 + byArray.length + 1];
                object[0] = 48;
                object[1] = -127;
                object[2] = (byte)(((byte[])object2).length + 4 + byArray.length);
                object[3] = 2;
                object[4] = (byte)((byte[])object2).length;
                System.arraycopy(object2, 0, object, 5, ((byte[])object2).length);
                object[((byte[])object2).length + 5] = 2;
                object[((byte[])object2).length + 6] = (byte)byArray.length;
                System.arraycopy(byArray, 0, object, ((byte[])object2).length + 7, byArray.length);
            }
            object2 = object;
        }
        return this.signature.verify((byte[])object2);
    }
}

