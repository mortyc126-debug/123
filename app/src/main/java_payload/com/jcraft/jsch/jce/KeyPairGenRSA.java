/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import java.io.Serializable;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class KeyPairGenRSA
implements com.jcraft.jsch.KeyPairGenRSA {
    byte[] c;
    byte[] d;
    byte[] e;
    byte[] ep;
    byte[] eq;
    byte[] n;
    byte[] p;
    byte[] q;

    @Override
    public byte[] getC() {
        return this.c;
    }

    @Override
    public byte[] getD() {
        return this.d;
    }

    @Override
    public byte[] getE() {
        return this.e;
    }

    @Override
    public byte[] getEP() {
        return this.ep;
    }

    @Override
    public byte[] getEQ() {
        return this.eq;
    }

    @Override
    public byte[] getN() {
        return this.n;
    }

    @Override
    public byte[] getP() {
        return this.p;
    }

    @Override
    public byte[] getQ() {
        return this.q;
    }

    @Override
    public void init(int n) throws Exception {
        Object object = KeyPairGenerator.getInstance("RSA");
        ((KeyPairGenerator)object).initialize(n, new SecureRandom());
        Serializable serializable = ((KeyPairGenerator)object).generateKeyPair();
        object = serializable.getPublic();
        serializable = serializable.getPrivate();
        this.d = ((RSAPrivateKey)serializable).getPrivateExponent().toByteArray();
        this.e = ((RSAPublicKey)object).getPublicExponent().toByteArray();
        this.n = ((RSAPrivateKey)serializable).getModulus().toByteArray();
        this.c = ((RSAPrivateCrtKey)serializable).getCrtCoefficient().toByteArray();
        this.ep = ((RSAPrivateCrtKey)serializable).getPrimeExponentP().toByteArray();
        this.eq = ((RSAPrivateCrtKey)serializable).getPrimeExponentQ().toByteArray();
        this.p = ((RSAPrivateCrtKey)serializable).getPrimeP().toByteArray();
        this.q = ((RSAPrivateCrtKey)serializable).getPrimeQ().toByteArray();
    }
}

