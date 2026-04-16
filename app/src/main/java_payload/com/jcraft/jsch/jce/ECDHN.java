/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.ECDH;
import com.jcraft.jsch.jce.KeyPairGenECDSA;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;

public class ECDHN
implements ECDH {
    private static BigInteger three;
    private static BigInteger two;
    byte[] Q_array;
    private KeyAgreement myKeyAgree;
    ECPublicKey publicKey;

    static {
        two = BigInteger.ONE.add(BigInteger.ONE);
        three = two.add(BigInteger.ONE);
    }

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

    private byte[] toPoint(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + 1 + byArray2.length];
        byArray3[0] = 4;
        System.arraycopy(byArray, 0, byArray3, 1, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length + 1, byArray2.length);
        return byArray3;
    }

    @Override
    public byte[] getQ() throws Exception {
        return this.Q_array;
    }

    @Override
    public byte[] getSecret(byte[] object, byte[] byArray) throws Exception {
        object = KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(new BigInteger(1, (byte[])object), new BigInteger(1, byArray)), this.publicKey.getParams()));
        this.myKeyAgree.doPhase((Key)object, true);
        return this.myKeyAgree.generateSecret();
    }

    @Override
    public void init(int n) throws Exception {
        this.myKeyAgree = KeyAgreement.getInstance("ECDH");
        KeyPairGenECDSA keyPairGenECDSA = new KeyPairGenECDSA();
        keyPairGenECDSA.init(n);
        this.publicKey = keyPairGenECDSA.getPublicKey();
        this.Q_array = this.toPoint(keyPairGenECDSA.getR(), keyPairGenECDSA.getS());
        this.myKeyAgree.init(keyPairGenECDSA.getPrivateKey());
    }

    @Override
    public boolean validate(byte[] object, byte[] object2) throws Exception {
        BigInteger bigInteger = new BigInteger(1, (byte[])object);
        if (new ECPoint(bigInteger, (BigInteger)(object = (Object)new BigInteger(1, (byte[])object2))).equals(ECPoint.POINT_INFINITY)) {
            return false;
        }
        EllipticCurve ellipticCurve = this.publicKey.getParams().getCurve();
        object2 = ((ECFieldFp)ellipticCurve.getField()).getP();
        BigInteger bigInteger2 = ((BigInteger)object2).subtract(BigInteger.ONE);
        if (bigInteger.compareTo(bigInteger2) <= 0 && ((BigInteger)object).compareTo(bigInteger2) <= 0) {
            bigInteger = bigInteger.multiply(ellipticCurve.getA()).add(ellipticCurve.getB()).add(bigInteger.modPow(three, (BigInteger)object2)).mod((BigInteger)object2);
            return ((BigInteger)object).modPow(two, (BigInteger)object2).equals(bigInteger);
        }
        return false;
    }
}

