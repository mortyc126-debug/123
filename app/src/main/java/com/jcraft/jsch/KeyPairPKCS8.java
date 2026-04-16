/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Cipher;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPair;
import com.jcraft.jsch.PBKDF;
import com.jcraft.jsch.Signature;
import com.jcraft.jsch.Util;
import java.math.BigInteger;

public class KeyPairPKCS8
extends KeyPair {
    private static final byte[] aes128cbc;
    private static final byte[] aes192cbc;
    private static final byte[] aes256cbc;
    private static final byte[] begin;
    private static final byte[] dsaEncryption;
    private static final byte[] end;
    private static final byte[] pbeWithMD5AndDESCBC;
    private static final byte[] pbes2;
    private static final byte[] pbkdf2;
    private static final byte[] rsaEncryption;
    private KeyPair kpair = null;

    static {
        rsaEncryption = new byte[]{42, -122, 72, -122, -9, 13, 1, 1, 1};
        dsaEncryption = new byte[]{42, -122, 72, -50, 56, 4, 1};
        pbes2 = new byte[]{42, -122, 72, -122, -9, 13, 1, 5, 13};
        pbkdf2 = new byte[]{42, -122, 72, -122, -9, 13, 1, 5, 12};
        aes128cbc = new byte[]{96, -122, 72, 1, 101, 3, 4, 1, 2};
        aes192cbc = new byte[]{96, -122, 72, 1, 101, 3, 4, 1, 22};
        aes256cbc = new byte[]{96, -122, 72, 1, 101, 3, 4, 1, 42};
        pbeWithMD5AndDESCBC = new byte[]{42, -122, 72, -122, -9, 13, 1, 5, 3};
        begin = Util.str2byte("-----BEGIN DSA PRIVATE KEY-----");
        end = Util.str2byte("-----END DSA PRIVATE KEY-----");
    }

    public KeyPairPKCS8(JSch jSch) {
        super(jSch);
    }

    @Override
    public boolean decrypt(byte[] byArray) {
        Object object;
        block13: {
            int n;
            Object object2;
            byte[] byArray2;
            Object object3;
            Object object4;
            block14: {
                if (!this.isEncrypted()) {
                    return true;
                }
                if (byArray == null) {
                    return this.isEncrypted() ^ true;
                }
                object4 = new KeyPair.ASN1(this, this.data);
                object = ((KeyPair.ASN1)object4).getContents();
                object4 = object[1].getContent();
                object3 = object[0].getContents();
                object = object3[0].getContent();
                object3 = object3[1];
                if (!Util.array_equals((byte[])object, pbes2)) break block13;
                object = ((KeyPair.ASN1)object3).getContents();
                object3 = object[0];
                object = object[1];
                object3 = ((KeyPair.ASN1)object3).getContents();
                ((KeyPair.ASN1)object3[0]).getContent();
                object3 = ((KeyPair.ASN1)object3[1]).getContents();
                byArray2 = ((KeyPair.ASN1)object3[0]).getContent();
                object2 = new BigInteger(((KeyPair.ASN1)object3[1]).getContent());
                n = Integer.parseInt(((BigInteger)object2).toString());
                object = object.getContents();
                object3 = ((KeyPair.ASN1)object[0]).getContent();
                object = ((KeyPair.ASN1)object[1]).getContent();
                object3 = this.getCipher((byte[])object3);
                if (object3 != null) break block14;
                return false;
            }
            try {
                object2 = this.jsch;
                object2 = (PBKDF)Class.forName(JSch.getConfig("pbkdf")).newInstance();
                PBKDF pBKDF = (PBKDF)object2;
                byArray = object2.getKey(byArray, byArray2, n, object3.getBlockSize());
            }
            catch (Exception exception) {
                byArray = null;
            }
            if (byArray == null) {
                return false;
            }
            object3.init(1, byArray, (byte[])object);
            Util.bzero(byArray);
            byArray = new byte[((Object)object4).length];
            object3.update((byte[])object4, 0, ((Object)object4).length, byArray, 0);
            if (this.parse(byArray)) {
                this.encrypted = false;
                return true;
            }
        }
        try {
            Util.array_equals((byte[])object, pbeWithMD5AndDESCBC);
            return false;
        }
        catch (Exception exception) {
        }
        catch (KeyPair.ASN1Exception aSN1Exception) {
            // empty catch block
        }
        return false;
    }

    @Override
    public byte[] forSSHAgent() throws JSchException {
        return this.kpair.forSSHAgent();
    }

    @Override
    void generate(int n) throws JSchException {
    }

    @Override
    byte[] getBegin() {
        return begin;
    }

    Cipher getCipher(byte[] object) {
        Object object2;
        block10: {
            String string2;
            Object object3;
            String string3;
            block9: {
                string3 = null;
                object3 = null;
                object2 = null;
                string2 = object3;
                if (Util.array_equals((byte[])object, aes128cbc)) {
                    object2 = "aes128-cbc";
                    break block9;
                }
                string2 = object3;
                if (Util.array_equals((byte[])object, aes192cbc)) {
                    object2 = "aes192-cbc";
                    break block9;
                }
                string2 = object3;
                if (!Util.array_equals((byte[])object, aes256cbc)) break block9;
                object2 = "aes256-cbc";
            }
            string2 = object2;
            object3 = this.jsch;
            string2 = object2;
            object3 = (Cipher)Class.forName(JSch.getConfig((String)object2)).newInstance();
            string2 = object2;
            try {
                object2 = (Cipher)object3;
                object2 = object3;
            }
            catch (Exception exception) {
                object2 = string3;
                if (!JSch.getLogger().isEnabled(4)) break block10;
                object = string2 == null ? (Object)("unknown oid: " + Util.toHex((byte[])object)) : (Object)("function " + string2 + " is not supported");
                JSch.getLogger().log(4, "PKCS8: " + (String)object);
                object2 = string3;
            }
        }
        return object2;
    }

    @Override
    byte[] getEnd() {
        return end;
    }

    @Override
    public int getKeySize() {
        return this.kpair.getKeySize();
    }

    @Override
    public int getKeyType() {
        return this.kpair.getKeyType();
    }

    @Override
    byte[] getKeyTypeName() {
        return this.kpair.getKeyTypeName();
    }

    @Override
    byte[] getPrivateKey() {
        return null;
    }

    @Override
    public byte[] getPublicKeyBlob() {
        return this.kpair.getPublicKeyBlob();
    }

    @Override
    public byte[] getSignature(byte[] byArray) {
        return this.kpair.getSignature(byArray);
    }

    @Override
    public Signature getVerifier() {
        return this.kpair.getVerifier();
    }

    /*
     * Exception decompiling
     */
    @Override
    boolean parse(byte[] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 8[TRYBLOCK] [12 : 121->155)] com.jcraft.jsch.KeyPair$ASN1Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

