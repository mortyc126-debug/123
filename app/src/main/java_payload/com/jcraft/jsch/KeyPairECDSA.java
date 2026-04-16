/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.KeyPairGenECDSA;
import com.jcraft.jsch.Signature;
import com.jcraft.jsch.SignatureECDSA;
import com.jcraft.jsch.Util;

public class KeyPairECDSA
extends KeyPair {
    private static final byte[] begin;
    private static final byte[] end;
    private static String[] names;
    private static byte[][] oids;
    private int key_size;
    private byte[] name = Util.str2byte(names[0]);
    private byte[] prv_array;
    private byte[] r_array;
    private byte[] s_array;

    static {
        oids = new byte[][]{{6, 8, 42, -122, 72, -50, 61, 3, 1, 7}, {6, 5, 43, -127, 4, 0, 34}, {6, 5, 43, -127, 4, 0, 35}};
        names = new String[]{"nistp256", "nistp384", "nistp521"};
        begin = Util.str2byte("-----BEGIN EC PRIVATE KEY-----");
        end = Util.str2byte("-----END EC PRIVATE KEY-----");
    }

    public KeyPairECDSA(JSch jSch) {
        this(jSch, null, null, null, null);
    }

    public KeyPairECDSA(JSch object, byte[] byArray) {
        this((JSch)object, null, null, null, null);
        if (byArray != null) {
            object = new byte[8];
            System.arraycopy(byArray, 11, object, 0, 8);
            if (Util.array_equals((byte[])object, Util.str2byte("nistp384"))) {
                this.key_size = 384;
                this.name = (byte[])object;
            }
            if (Util.array_equals((byte[])object, Util.str2byte("nistp521"))) {
                this.key_size = 521;
                this.name = (byte[])object;
            }
        }
    }

    public KeyPairECDSA(JSch jSch, byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4) {
        super(jSch);
        int n = 256;
        this.key_size = 256;
        if (byArray != null) {
            this.name = byArray;
        }
        this.r_array = byArray2;
        this.s_array = byArray3;
        this.prv_array = byArray4;
        if (byArray4 != null) {
            if (byArray4.length >= 64) {
                n = 521;
            } else if (byArray4.length >= 48) {
                n = 384;
            }
            this.key_size = n;
        }
    }

    static byte[][] fromPoint(byte[] byArray) {
        int n = 0;
        while (byArray[n] != 4) {
            ++n;
        }
        byte[] byArray2 = new byte[(byArray.length - ++n) / 2];
        byte[] byArray3 = new byte[(byArray.length - n) / 2];
        System.arraycopy(byArray, n, byArray2, 0, byArray2.length);
        System.arraycopy(byArray, byArray2.length + n, byArray3, 0, byArray3.length);
        return new byte[][]{byArray2, byArray3};
    }

    static KeyPair fromSSHAgent(JSch object, Buffer object2) throws JSchException {
        object2 = ((Buffer)object2).getBytes(5, "invalid key format");
        Object object3 = object2[1];
        byte[][] byArray = KeyPairECDSA.fromPoint((byte[])object2[2]);
        object = new KeyPairECDSA((JSch)object, (byte[])object3, byArray[0], byArray[1], (byte[])object2[3]);
        ((KeyPairECDSA)object).publicKeyComment = new String((byte[])object2[4]);
        ((KeyPairECDSA)object).vendor = 0;
        return object;
    }

    static byte[] toPoint(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + 1 + byArray2.length];
        byArray3[0] = 4;
        System.arraycopy(byArray, 0, byArray3, 1, byArray.length);
        System.arraycopy(byArray2, 0, byArray3, byArray.length + 1, byArray2.length);
        return byArray3;
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
            buffer.putString(Util.str2byte("ecdsa-sha2-" + new String(this.name)));
            buffer.putString(this.name);
            buffer.putString(KeyPairECDSA.toPoint(this.r_array, this.s_array));
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
        String[] stringArray;
        block6: {
            block5: {
                this.key_size = n;
                try {
                    stringArray = this.jsch;
                    KeyPairGenECDSA keyPairGenECDSA = (KeyPairGenECDSA)Class.forName(JSch.getConfig("keypairgen.ecdsa")).newInstance();
                    stringArray = keyPairGenECDSA;
                    keyPairGenECDSA.init(n);
                    this.prv_array = keyPairGenECDSA.getD();
                    this.r_array = keyPairGenECDSA.getR();
                    this.s_array = keyPairGenECDSA.getS();
                    stringArray = names;
                    if (this.prv_array.length < 64) break block5;
                    n = 2;
                    break block6;
                }
                catch (Exception exception) {
                    if (exception instanceof Throwable) {
                        throw new JSchException(exception.toString(), exception);
                    }
                    throw new JSchException(exception.toString());
                }
            }
            n = this.prv_array.length >= 48 ? 1 : 0;
        }
        this.name = Util.str2byte(stringArray[n]);
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
        return 3;
    }

    @Override
    byte[] getKeyTypeName() {
        return Util.str2byte("ecdsa-sha2-" + new String(this.name));
    }

    @Override
    byte[] getPrivateKey() {
        byte[] byArray = new byte[]{1};
        Object object = oids;
        int n = this.r_array.length >= 64 ? 2 : (this.r_array.length >= 48 ? 1 : 0);
        byte[] byArray2 = object[n];
        byte[] byArray3 = KeyPairECDSA.toPoint(this.r_array, this.s_array);
        n = (byArray3.length + 1 & 0x80) == 0 ? 3 : 4;
        object = new byte[byArray3.length + n];
        System.arraycopy(byArray3, 0, object, n, byArray3.length);
        object[0] = (byte[])3;
        if (n == 3) {
            object[1] = (byte[])((byte)(byArray3.length + 1));
        } else {
            object[1] = (byte[])-127;
            object[2] = (byte[])((byte)(byArray3.length + 1));
        }
        n = this.countLength(byArray.length) + 1 + byArray.length + 1 + this.countLength(this.prv_array.length) + this.prv_array.length + 1 + this.countLength(byArray2.length) + byArray2.length + 1 + this.countLength(((byte[][])object).length) + ((byte[][])object).length;
        byArray3 = new byte[this.countLength(n) + 1 + n];
        this.writeDATA(byArray3, (byte)-95, this.writeDATA(byArray3, (byte)-96, this.writeOCTETSTRING(byArray3, this.writeINTEGER(byArray3, this.writeSEQUENCE(byArray3, 0, n), byArray), this.prv_array), byArray2), (byte[])object);
        return byArray3;
    }

    @Override
    public byte[] getPublicKeyBlob() {
        Object object = super.getPublicKeyBlob();
        if (object != null) {
            return object;
        }
        if (this.r_array == null) {
            return null;
        }
        object = new byte[3][];
        object[0] = (byte)Util.str2byte("ecdsa-sha2-" + new String(this.name));
        object[1] = (byte)this.name;
        object[2] = (byte)new byte[this.r_array.length + 1 + this.s_array.length];
        object[2][0] = 4;
        System.arraycopy(this.r_array, 0, object[2], 1, this.r_array.length);
        System.arraycopy(this.s_array, 0, object[2], this.r_array.length + 1, this.s_array.length);
        return Buffer.fromBytes((byte[][])object).buffer;
    }

    @Override
    public byte[] getSignature(byte[] byArray) {
        try {
            Object object = this.jsch;
            object = new StringBuilder();
            object = ((StringBuilder)object).append("ecdsa-sha2-");
            Object object2 = new String(this.name);
            object = (SignatureECDSA)Class.forName(JSch.getConfig(((StringBuilder)object).append((String)object2).toString())).newInstance();
            object2 = (SignatureECDSA)object;
            object.init();
            object.setPrvKey(this.prv_array);
            object.update(byArray);
            byArray = object.sign();
            object = new StringBuilder();
            object = ((StringBuilder)object).append("ecdsa-sha2-");
            object2 = new String(this.name);
            byArray = Buffer.fromBytes((byte[][])new byte[][]{Util.str2byte((String)((StringBuilder)object).append((String)object2).toString()), byArray}).buffer;
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
            object = new StringBuilder();
            Object object2 = ((StringBuilder)object).append("ecdsa-sha2-");
            object = new String(this.name);
            object = (SignatureECDSA)Class.forName(JSch.getConfig(((StringBuilder)object2).append((String)object).toString())).newInstance();
            object2 = (SignatureECDSA)object;
            object.init();
            if (this.r_array == null && this.s_array == null && this.getPublicKeyBlob() != null) {
                object2 = new Buffer(this.getPublicKeyBlob());
                ((Buffer)object2).getString();
                ((Buffer)object2).getString();
                object2 = KeyPairECDSA.fromPoint(((Buffer)object2).getString());
                this.r_array = (byte[])object2[0];
                this.s_array = (byte[])object2[1];
            }
            object.setPubKey(this.r_array, this.s_array);
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    boolean parse(byte[] object) {
        int n;
        block20: {
            if (this.vendor == 1) {
                return false;
            }
            if (this.vendor != 2) break block20;
            return false;
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
        n4 = n2 = object[n2] & 0xFF;
        int n5 = n3;
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
        n2 = n5 + n4 + 1;
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
        this.prv_array = new byte[n4];
        System.arraycopy(object, n5, this.prv_array, 0, n4);
        n2 = n5 + n4 + 1;
        n3 = n2 + 1;
        n4 = n2 = object[n2] & 0xFF;
        n = n3;
        if ((n2 & 0x80) != 0) {
            n5 = n2 & 0x7F;
            n2 = 0;
            while (true) {
                n4 = n2;
                n = ++n3;
                if (n5 <= 0) break;
                n2 = (n2 << 8) + (object[n3] & 0xFF);
                --n5;
            }
        }
        byte[] byArray = new byte[n4];
        System.arraycopy(object, n, byArray, 0, n4);
        for (n3 = 0; n3 < oids.length; ++n3) {
            if (!Util.array_equals(oids[n3], byArray)) continue;
            this.name = Util.str2byte(names[n3]);
            break;
        }
        n2 = n + n4 + 1;
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
            byArray = new byte[n5];
            System.arraycopy(object, n4, byArray, 0, n5);
            object = KeyPairECDSA.fromPoint(byArray);
            this.r_array = (byte[])object[0];
            this.s_array = (byte[])object[1];
            if (this.prv_array != null) {
                n3 = this.prv_array.length >= 64 ? 521 : (this.prv_array.length >= 48 ? 384 : 256);
                this.key_size = n3;
            }
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }
}

