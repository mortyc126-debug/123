/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.KeyPairGenRSA;
import com.jcraft.jsch.Signature;
import com.jcraft.jsch.SignatureRSA;
import com.jcraft.jsch.Util;
import java.math.BigInteger;

public class KeyPairRSA
extends KeyPair {
    private static final byte[] begin = Util.str2byte("-----BEGIN RSA PRIVATE KEY-----");
    private static final byte[] end = Util.str2byte("-----END RSA PRIVATE KEY-----");
    private static final byte[] sshrsa = Util.str2byte("ssh-rsa");
    private byte[] c_array;
    private byte[] ep_array;
    private byte[] eq_array;
    private int key_size = 1024;
    private byte[] n_array;
    private byte[] p_array;
    private byte[] prv_array;
    private byte[] pub_array;
    private byte[] q_array;

    public KeyPairRSA(JSch jSch) {
        this(jSch, null, null, null);
    }

    public KeyPairRSA(JSch jSch, byte[] byArray, byte[] byArray2, byte[] byArray3) {
        super(jSch);
        this.n_array = byArray;
        this.pub_array = byArray2;
        this.prv_array = byArray3;
        if (byArray != null) {
            this.key_size = new BigInteger(byArray).bitLength();
        }
    }

    static KeyPair fromSSHAgent(JSch object, Buffer object2) throws JSchException {
        object2 = ((Buffer)object2).getBytes(8, "invalid key format");
        object = new KeyPairRSA((JSch)object, (byte[])object2[1], (byte[])object2[2], (byte[])object2[3]);
        ((KeyPairRSA)object).c_array = (byte[])object2[4];
        ((KeyPairRSA)object).p_array = (byte[])object2[5];
        ((KeyPairRSA)object).q_array = (byte[])object2[6];
        ((KeyPairRSA)object).publicKeyComment = new String((byte[])object2[7]);
        ((KeyPairRSA)object).vendor = 0;
        return object;
    }

    private byte[] getCArray() {
        if (this.c_array == null) {
            this.c_array = new BigInteger(this.q_array).modInverse(new BigInteger(this.p_array)).toByteArray();
        }
        return this.c_array;
    }

    private byte[] getEPArray() {
        if (this.ep_array == null) {
            this.ep_array = new BigInteger(this.prv_array).mod(new BigInteger(this.p_array).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.ep_array;
    }

    private byte[] getEQArray() {
        if (this.eq_array == null) {
            this.eq_array = new BigInteger(this.prv_array).mod(new BigInteger(this.q_array).subtract(BigInteger.ONE)).toByteArray();
        }
        return this.eq_array;
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
            buffer.putString(sshrsa);
            buffer.putString(this.n_array);
            buffer.putString(this.pub_array);
            buffer.putString(this.prv_array);
            buffer.putString(this.getCArray());
            buffer.putString(this.p_array);
            buffer.putString(this.q_array);
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
            KeyPairGenRSA keyPairGenRSA = (KeyPairGenRSA)Class.forName(JSch.getConfig("keypairgen.rsa")).newInstance();
            object = keyPairGenRSA;
            keyPairGenRSA.init(n);
            this.pub_array = keyPairGenRSA.getE();
            this.prv_array = keyPairGenRSA.getD();
            this.n_array = keyPairGenRSA.getN();
            this.p_array = keyPairGenRSA.getP();
            this.q_array = keyPairGenRSA.getQ();
            this.ep_array = keyPairGenRSA.getEP();
            this.eq_array = keyPairGenRSA.getEQ();
            this.c_array = keyPairGenRSA.getC();
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
        return 2;
    }

    @Override
    byte[] getKeyTypeName() {
        return sshrsa;
    }

    @Override
    byte[] getPrivateKey() {
        int n = this.countLength(1) + 1 + 1 + 1 + this.countLength(this.n_array.length) + this.n_array.length + 1 + this.countLength(this.pub_array.length) + this.pub_array.length + 1 + this.countLength(this.prv_array.length) + this.prv_array.length + 1 + this.countLength(this.p_array.length) + this.p_array.length + 1 + this.countLength(this.q_array.length) + this.q_array.length + 1 + this.countLength(this.ep_array.length) + this.ep_array.length + 1 + this.countLength(this.eq_array.length) + this.eq_array.length + 1 + this.countLength(this.c_array.length) + this.c_array.length;
        byte[] byArray = new byte[this.countLength(n) + 1 + n];
        this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeINTEGER(byArray, this.writeSEQUENCE(byArray, 0, n), new byte[1]), this.n_array), this.pub_array), this.prv_array), this.p_array), this.q_array), this.ep_array), this.eq_array), this.c_array);
        return byArray;
    }

    @Override
    public byte[] getPublicKeyBlob() {
        byte[] byArray = super.getPublicKeyBlob();
        if (byArray != null) {
            return byArray;
        }
        if (this.pub_array == null) {
            return null;
        }
        return Buffer.fromBytes((byte[][])new byte[][]{KeyPairRSA.sshrsa, this.pub_array, this.n_array}).buffer;
    }

    @Override
    public byte[] getSignature(byte[] byArray) {
        try {
            Object object = this.jsch;
            SignatureRSA signatureRSA = (SignatureRSA)Class.forName(JSch.getConfig("signature.rsa")).newInstance();
            object = signatureRSA;
            signatureRSA.init();
            signatureRSA.setPrvKey(this.prv_array, this.n_array);
            signatureRSA.update(byArray);
            byArray = signatureRSA.sign();
            byArray = Buffer.fromBytes((byte[][])new byte[][]{KeyPairRSA.sshrsa, byArray}).buffer;
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
            object = (SignatureRSA)Class.forName(JSch.getConfig("signature.rsa")).newInstance();
            Object object2 = (SignatureRSA)object;
            object.init();
            if (this.pub_array == null && this.n_array == null && this.getPublicKeyBlob() != null) {
                object2 = new Buffer(this.getPublicKeyBlob());
                ((Buffer)object2).getString();
                this.pub_array = ((Buffer)object2).getString();
                this.n_array = ((Buffer)object2).getString();
            }
            object.setPubKey(this.pub_array, this.n_array);
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    boolean parse(byte[] object) {
        int n;
        block39: {
            block38: {
                if (this.vendor != 2) break block38;
                Buffer buffer = new Buffer((byte[])object);
                buffer.skip(((byte[])object).length);
                try {
                    object = buffer.getBytes(4, "");
                    this.prv_array = (byte[])object[0];
                    this.p_array = (byte[])object[1];
                    this.q_array = (byte[])object[2];
                    this.c_array = (byte[])object[3];
                    this.getEPArray();
                }
                catch (JSchException jSchException) {
                    return false;
                }
                this.getEQArray();
                return true;
            }
            if (this.vendor != 1) break block39;
            if (object[0] != 48) {
                Buffer buffer = new Buffer((byte[])object);
                this.pub_array = buffer.getMPIntBits();
                this.prv_array = buffer.getMPIntBits();
                this.n_array = buffer.getMPIntBits();
                buffer.getMPIntBits();
                this.p_array = buffer.getMPIntBits();
                this.q_array = buffer.getMPIntBits();
                if (this.n_array != null) {
                    object = new BigInteger;
                    ((BigInteger)object)(this.n_array);
                    this.key_size = ((BigInteger)object).bitLength();
                }
                this.getEPArray();
                this.getEQArray();
                this.getCArray();
                return true;
            }
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
        this.n_array = new byte[n5];
        System.arraycopy(object, n4, this.n_array, 0, n5);
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
        this.prv_array = new byte[n5];
        System.arraycopy(object, n4, this.prv_array, 0, n5);
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n4 = n2 = object[n2] & 0xFF;
        n5 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n4 = n2;
                n5 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        this.p_array = new byte[n4];
        System.arraycopy(object, n5, this.p_array, 0, n4);
        n2 = n5 + n4 + 1;
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
        this.q_array = new byte[n5];
        System.arraycopy(object, n4, this.q_array, 0, n5);
        n2 = n4 + n5 + 1;
        n3 = n2 + 1;
        n4 = n2 = object[n2] & 0xFF;
        n5 = n3;
        if ((n2 & 0x80) != 0) {
            n = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n4 = n2;
                n5 = ++n3;
                if (n <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n;
            }
        }
        this.ep_array = new byte[n4];
        System.arraycopy(object, n5, this.ep_array, 0, n4);
        n2 = n5 + n4 + 1;
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
        this.eq_array = new byte[n5];
        System.arraycopy(object, n4, this.eq_array, 0, n5);
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
            this.c_array = new byte[n5];
            System.arraycopy(object, n4, this.c_array, 0, n5);
            if (this.n_array != null) {
                object = new BigInteger(this.n_array);
                this.key_size = ((BigInteger)object).bitLength();
            }
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

