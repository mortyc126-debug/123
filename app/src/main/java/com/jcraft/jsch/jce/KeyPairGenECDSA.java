/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch.jce;

import com.jcraft.jsch.JSchException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;

public class KeyPairGenECDSA
implements com.jcraft.jsch.KeyPairGenECDSA {
    byte[] d;
    ECParameterSpec params;
    ECPrivateKey prvKey;
    ECPublicKey pubKey;
    byte[] r;
    byte[] s;

    private void bzero(byte[] byArray) {
        for (int i = 0; i < byArray.length; ++i) {
            byArray[i] = 0;
        }
    }

    private byte[] chop0(byte[] byArray) {
        if (byArray[0] == 0 && (byArray[1] & 0x80) != 0) {
            byte[] byArray2 = new byte[byArray.length - 1];
            System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
            this.bzero(byArray);
            return byArray2;
        }
        return byArray;
    }

    private byte[] insert0(byte[] byArray) {
        byte[] byArray2 = new byte[byArray.length + 1];
        System.arraycopy(byArray, 0, byArray2, 1, byArray.length);
        this.bzero(byArray);
        return byArray2;
    }

    @Override
    public byte[] getD() {
        return this.d;
    }

    ECPrivateKey getPrivateKey() {
        return this.prvKey;
    }

    ECPublicKey getPublicKey() {
        return this.pubKey;
    }

    @Override
    public byte[] getR() {
        return this.r;
    }

    @Override
    public byte[] getS() {
        return this.s;
    }

    @Override
    public void init(int n) throws Exception {
        block8: {
            String string2;
            block6: {
                block7: {
                    block5: {
                        if (n != 256) break block5;
                        string2 = "secp256r1";
                        break block6;
                    }
                    if (n != 384) break block7;
                    string2 = "secp384r1";
                    break block6;
                }
                if (n != 521) break block8;
                string2 = "secp521r1";
            }
            for (int i = 0; i < 1000; ++i) {
                Object object = KeyPairGenerator.getInstance("EC");
                ((KeyPairGenerator)object).initialize(new ECGenParameterSpec(string2));
                object = ((KeyPairGenerator)object).genKeyPair();
                this.prvKey = (ECPrivateKey)((KeyPair)object).getPrivate();
                this.pubKey = (ECPublicKey)((KeyPair)object).getPublic();
                this.params = this.pubKey.getParams();
                this.d = this.prvKey.getS().toByteArray();
                object = this.pubKey.getW();
                this.r = ((ECPoint)object).getAffineX().toByteArray();
                this.s = ((ECPoint)object).getAffineY().toByteArray();
                if (this.r.length == this.s.length && (n == 256 && this.r.length == 32 || n == 384 && this.r.length == 48 || n == 521 && this.r.length == 66)) break;
            }
            if (this.d.length < this.r.length) {
                this.d = this.insert0(this.d);
            }
            return;
        }
        throw new JSchException("unsupported key size: " + n);
    }
}

