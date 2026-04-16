/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.KeyPairGenDSA;
import com.jcraft.jsch.Signature;
import com.jcraft.jsch.SignatureDSA;
import com.jcraft.jsch.Util;
import java.math.BigInteger;

public class KeyPairDSA
extends KeyPair {
    private static final byte[] begin = Util.str2byte("-----BEGIN DSA PRIVATE KEY-----");
    private static final byte[] end = Util.str2byte("-----END DSA PRIVATE KEY-----");
    private static final byte[] sshdss = Util.str2byte("ssh-dss");
    private byte[] G_array;
    private byte[] P_array;
    private byte[] Q_array;
    private int key_size = 1024;
    private byte[] prv_array;
    private byte[] pub_array;

    public KeyPairDSA(JSch jSch) {
        this(jSch, null, null, null, null, null);
    }

    public KeyPairDSA(JSch jSch, byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4, byte[] byArray5) {
        super(jSch);
        this.P_array = byArray;
        this.Q_array = byArray2;
        this.G_array = byArray3;
        this.pub_array = byArray4;
        this.prv_array = byArray5;
        if (byArray != null) {
            this.key_size = new BigInteger(byArray).bitLength();
        }
    }

    static KeyPair fromSSHAgent(JSch object, Buffer object2) throws JSchException {
        object2 = ((Buffer)object2).getBytes(7, "invalid key format");
        object = new KeyPairDSA((JSch)object, (byte[])object2[1], (byte[])object2[2], (byte[])object2[3], (byte[])object2[4], (byte[])object2[5]);
        ((KeyPairDSA)object).publicKeyComment = new String((byte[])object2[6]);
        ((KeyPairDSA)object).vendor = 0;
        return object;
    }

    @Override
    public void dispose() {
        super.dispose();
        Util.bzero(this.prv_array);
    }

    @Override
    public byte[] forSSHAgent() throws JSchException {
        if (!this.isEncrypted()) {
            Buffer buffer = new Buffer();
            buffer.putString(sshdss);
            buffer.putString(this.P_array);
            buffer.putString(this.Q_array);
            buffer.putString(this.G_array);
            buffer.putString(this.pub_array);
            buffer.putString(this.prv_array);
            buffer.putString(Util.str2byte(this.publicKeyComment));
            byte[] byArray = new byte[buffer.getLength()];
            buffer.getByte(byArray, 0, byArray.length);
            return byArray;
        }
        throw new JSchException("key is encrypted.");
    }

    @Override
    void generate(int n) throws JSchException {
        this.key_size = n;
        try {
            Object object = this.jsch;
            KeyPairGenDSA keyPairGenDSA = (KeyPairGenDSA)Class.forName(JSch.getConfig("keypairgen.dsa")).newInstance();
            object = keyPairGenDSA;
            keyPairGenDSA.init(n);
            this.P_array = keyPairGenDSA.getP();
            this.Q_array = keyPairGenDSA.getQ();
            this.G_array = keyPairGenDSA.getG();
            this.pub_array = keyPairGenDSA.getY();
            this.prv_array = keyPairGenDSA.getX();
            return;
        }
        catch (Exception exception) {
            if (exception instanceof Throwable) {
                throw new JSchException(exception.toString(), exception);
            }
            throw new JSchException(exception.toString());
        }
    }

    @Override
    byte[] getBegin() {
        return begin;
    }

    @Override
    byte[] getEnd() {
        return end;
    }

    @Override
    public int getKeySize() {
        return this.key_size;
    }

    @Override
    public int getKeyType() {
        return 1;
    }

    @Override
    byte[] getKeyTypeName() {
        return sshdss;
    }

    @Override
    byte[] getPrivateKey() {
        int n = this.countLength(1) + 1 + 1 + 1 + this.countLength(this.P_array.length) + this.P_array.length + 1 + this.countLength(this.Q_array.length) + this.Q_array.length + 1 + this.countLength(this.G_array.length) + this.G_array.length + 1 + this.countLength(this.pub_array.length) + this.pub_array.length + 1 + this.countLength(this.prv_array.length) + this.prv_array.length;
        byte[] byArray = new byte[this.countLength(n) + 1 + n];
        this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeSEQUENCE(byArray, 0, n), new byte[1]), this.P_array), this.Q_array), this.G_array), this.pub_array), this.prv_array);
        return byArray;
    }

    @Override
    public byte[] getPublicKeyBlob() {
        byte[] byArray = super.getPublicKeyBlob();
        if (byArray != null) {
            return byArray;
        }
        if (this.P_array == null) {
            return null;
        }
        return Buffer.fromBytes((byte[][])new byte[][]{KeyPairDSA.sshdss, this.P_array, this.Q_array, this.G_array, this.pub_array}).buffer;
    }

    @Override
    public byte[] getSignature(byte[] byArray) {
        try {
            Object object = this.jsch;
            object = (SignatureDSA)Class.forName(JSch.getConfig("signature.dss")).newInstance();
            SignatureDSA signatureDSA = (SignatureDSA)object;
            object.init();
            object.setPrvKey(this.prv_array, this.P_array, this.Q_array, this.G_array);
            object.update(byArray);
            byArray = object.sign();
            byArray = Buffer.fromBytes((byte[][])new byte[][]{KeyPairDSA.sshdss, byArray}).buffer;
            return byArray;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    public Signature getVerifier() {
        try {
            Object object = this.jsch;
            object = (SignatureDSA)Class.forName(JSch.getConfig("signature.dss")).newInstance();
            Object object2 = (SignatureDSA)object;
            object.init();
            if (this.pub_array == null && this.P_array == null && this.getPublicKeyBlob() != null) {
                object2 = new Buffer(this.getPublicKeyBlob());
                ((Buffer)object2).getString();
                this.P_array = ((Buffer)object2).getString();
                this.Q_array = ((Buffer)object2).getString();
                this.G_array = ((Buffer)object2).getString();
                this.pub_array = ((Buffer)object2).getString();
            }
            object.setPubKey(this.pub_array, this.P_array, this.Q_array, this.G_array);
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    boolean parse(byte[] object) {
        int n;
        block31: {
            block30: {
                if (this.vendor != 1) break block30;
                if (object[0] != 48) {
                    Buffer buffer = new Buffer((byte[])object);
                    buffer.getInt();
                    this.P_array = buffer.getMPIntBits();
                    this.G_array = buffer.getMPIntBits();
                    this.Q_array = buffer.getMPIntBits();
                    this.pub_array = buffer.getMPIntBits();
                    this.prv_array = buffer.getMPIntBits();
                    if (this.P_array != null) {
                        object = new BigInteger;
                        ((BigInteger)object)(this.P_array);
                        this.key_size = ((BigInteger)object).bitLength();
                    }
                    return true;
                }
                return false;
            }
            if (this.vendor != 2) break block31;
            Buffer buffer = new Buffer((byte[])object);
            buffer.skip(((byte[])object).length);
            try {
                this.prv_array = buffer.getBytes(1, "")[0];
                return true;
            }
            catch (JSchException jSchException) {
                return false;
            }
        }
        if (object[0] != 48) {
            return false;
        }
        int n2 = 0 + 1;
        int n3 = n2 + 1;
        n2 = object[n2] & 0xFF;
        int n4 = n3;
        if ((n2 & 0x80) != 0) {
            n2 &= 0x7F;
            n = 0;
            while (true) {
                n4 = ++n3;
                if (n2 <= 0) break;
                n = (n << 8) + (object[n3] & 0xFF);
                --n2;
            }
        }
        if (object[n4] != 2) {
            return false;
        }
        n2 = n4 + 1;
        n3 = n2 + 1;
        int n5 = n2 = object[n2] & 0xFF;
        n4 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n5 = n2;
                n4 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n5 = n2 = object[n2] & 0xFF;
        n4 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n5 = n2;
                n4 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        this.P_array = new byte[n5];
        System.arraycopy(object, n4, this.P_array, 0, n5);
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n5 = n2 = object[n2] & 0xFF;
        n4 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n5 = n2;
                n4 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        this.Q_array = new byte[n5];
        System.arraycopy(object, n4, this.Q_array, 0, n5);
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n5 = n2 = object[n2] & 0xFF;
        n4 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n5 = n2;
                n4 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        this.G_array = new byte[n5];
        System.arraycopy(object, n4, this.G_array, 0, n5);
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n5 = n2 = object[n2] & 0xFF;
        n4 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n5 = n2;
                n4 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        this.pub_array = new byte[n5];
        System.arraycopy(object, n4, this.pub_array, 0, n5);
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n5 = n2 = object[n2] & 0xFF;
        n4 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n5 = n2;
                n4 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        try {
            this.prv_array = new byte[n5];
            System.arraycopy(object, n4, this.prv_array, 0, n5);
            if (this.P_array != null) {
                object = new BigInteger(this.P_array);
                this.key_size = ((BigInteger)object).bitLength();
            }
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

