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
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class SignatureRSA
implements com.jcraft.jsch.SignatureRSA {
    KeyFactory keyFactory;
    Signature signature;

    @Override
    public void init() throws Exception {
        this.signature = Signature.getInstance("SHA1withRSA");
        this.keyFactory = KeyFactory.getInstance("RSA");
    }

    @Override
    public void setPrvKey(byte[] object, byte[] byArray) throws Exception {
        object = new RSAPrivateKeySpec(new BigInteger(byArray), new BigInteger((byte[])object));
        object = this.keyFactory.generatePrivate((KeySpec)object);
        this.signature.initSign((PrivateKey)object);
    }

    @Override
    public void setPubKey(byte[] object, byte[] byArray) throws Exception {
        object = new RSAPublicKeySpec(new BigInteger(byArray), new BigInteger((byte[])object));
        object = this.keyFactory.generatePublic((KeySpec)object);
        this.signature.initVerify((PublicKey)object);
    }

    @Override
    public byte[] sign() throws Exception {
        return this.signature.sign();
    }

    @Override
    public void update(byte[] byArray) throws Exception {
        this.signature.update(byArray);
    }

    @Override
    public boolean verify(byte[] byArray) throws Exception {
        Buffer buffer = new Buffer(byArray);
        byte[] byArray2 = byArray;
        if (new String(buffer.getString()).equals("ssh-rsa")) {
            int n = buffer.getInt();
            int n2 = buffer.getOffSet();
            byArray2 = new byte[n];
            System.arraycopy(byArray, n2, byArray2, 0, n);
        }
        return this.signature.verify(byArray2);
    }
}

