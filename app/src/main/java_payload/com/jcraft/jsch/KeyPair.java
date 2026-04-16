/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Cipher;
import com.jcraft.jsch.HASH;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyPairDSA;
import com.jcraft.jsch.KeyPairECDSA;
import com.jcraft.jsch.KeyPairPKCS8;
import com.jcraft.jsch.KeyPairRSA;
import com.jcraft.jsch.Random;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Signature;
import com.jcraft.jsch.Util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;

public abstract class KeyPair {
    public static final int DSA = 1;
    public static final int ECDSA = 3;
    public static final int ERROR = 0;
    public static final int RSA = 2;
    public static final int UNKNOWN = 4;
    static final int VENDOR_FSECURE = 1;
    static final int VENDOR_OPENSSH = 0;
    static final int VENDOR_PKCS8 = 3;
    static final int VENDOR_PUTTY = 2;
    private static final byte[] cr = Util.str2byte("\n");
    static byte[][] header = new byte[][]{Util.str2byte("Proc-Type: 4,ENCRYPTED"), Util.str2byte("DEK-Info: DES-EDE3-CBC,")};
    private static final String[] header1;
    private static final String[] header2;
    private static final String[] header3;
    private static byte[] space;
    private Cipher cipher;
    protected byte[] data = null;
    protected boolean encrypted = false;
    private HASH hash;
    private byte[] iv = null;
    JSch jsch = null;
    private byte[] passphrase;
    protected String publicKeyComment = "no comment";
    private byte[] publickeyblob = null;
    private Random random;
    int vendor = 0;

    static {
        space = Util.str2byte(" ");
        header1 = new String[]{"PuTTY-User-Key-File-2: ", "Encryption: ", "Comment: ", "Public-Lines: "};
        header2 = new String[]{"Private-Lines: "};
        header3 = new String[]{"Private-MAC: "};
    }

    public KeyPair(JSch jSch) {
        this.jsch = jSch;
    }

    private static byte a2b(byte by) {
        if (48 <= by && by <= 57) {
            return (byte)(by - 48);
        }
        return (byte)(by - 97 + 10);
    }

    private static byte b2a(byte by) {
        if (by >= 0 && by <= 9) {
            return (byte)(by + 48);
        }
        return (byte)(by - 10 + 65);
    }

    private byte[] decrypt(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        try {
            byArray2 = this.genKey(byArray2, byArray3);
            this.cipher.init(1, byArray2, byArray3);
            Util.bzero(byArray2);
            byArray2 = new byte[byArray.length];
            this.cipher.update(byArray, 0, byArray.length, byArray2, 0);
            return byArray2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    private byte[] encrypt(byte[] byArray, byte[][] object, byte[] byArray2) {
        if (byArray2 == null) {
            return byArray;
        }
        if (this.cipher == null) {
            this.cipher = this.genCipher();
        }
        byte[] byArray3 = new byte[this.cipher.getIVSize()];
        object[0] = byArray3;
        if (this.random == null) {
            this.random = this.genRandom();
        }
        this.random.fill(byArray3, 0, byArray3.length);
        byArray2 = this.genKey(byArray2, byArray3);
        int n = this.cipher.getIVSize();
        object = new byte[(byArray.length / n + 1) * n];
        System.arraycopy(byArray, 0, object, 0, byArray.length);
        int n2 = n - byArray.length % n;
        for (n = ((byte[][])object).length - 1; ((byte[][])object).length - n2 <= n; --n) {
            object[n] = (byte[])((byte)n2);
        }
        try {
            this.cipher.init(0, byArray2, byArray3);
            this.cipher.update((byte[])object, 0, ((byte[][])object).length, (byte[])object, 0);
        }
        catch (Exception exception) {
            // empty catch block
        }
        Util.bzero(byArray2);
        return object;
    }

    private Cipher genCipher() {
        try {
            Cipher cipher;
            Cipher cipher2 = cipher = (Cipher)Class.forName(JSch.getConfig("3des-cbc")).newInstance();
            this.cipher = cipher;
        }
        catch (Exception exception) {
            // empty catch block
        }
        return this.cipher;
    }

    private HASH genHash() {
        try {
            HASH hASH;
            HASH hASH2 = hASH = (HASH)Class.forName(JSch.getConfig("md5")).newInstance();
            this.hash = hASH;
            this.hash.init();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return this.hash;
    }

    public static KeyPair genKeyPair(JSch jSch, int n) throws JSchException {
        return KeyPair.genKeyPair(jSch, n, 1024);
    }

    public static KeyPair genKeyPair(JSch jSch, int n, int n2) throws JSchException {
        KeyPair keyPair = null;
        if (n == 1) {
            keyPair = new KeyPairDSA(jSch);
        } else if (n == 2) {
            keyPair = new KeyPairRSA(jSch);
        } else if (n == 3) {
            keyPair = new KeyPairECDSA(jSch);
        }
        if (keyPair != null) {
            keyPair.generate(n2);
        }
        return keyPair;
    }

    private Random genRandom() {
        if (this.random == null) {
            try {
                Random random;
                Random random2 = random = (Random)Class.forName(JSch.getConfig("random")).newInstance();
                this.random = random;
            }
            catch (Exception exception) {
                System.err.println("connect: random " + exception);
            }
        }
        return this.random;
    }

    public static KeyPair load(JSch jSch, String string2) throws JSchException {
        String string3;
        String string4 = string3 = string2 + ".pub";
        if (!new File(string3).exists()) {
            string4 = null;
        }
        return KeyPair.load(jSch, string2, string4);
    }

    public static KeyPair load(JSch object, String object2, String string2) throws JSchException {
        IOException iOException3;
        block8: {
            String string3;
            byte[] byArray;
            Object var4_6;
            block7: {
                var4_6 = null;
                try {
                    byArray = Util.fromFile((String)object2);
                    string3 = string2;
                    if (string2 != null) break block7;
                    string3 = (String)object2 + ".pub";
                }
                catch (IOException iOException2) {
                    throw new JSchException(iOException2.toString(), iOException2);
                }
            }
            try {
                object2 = Util.fromFile(string3);
            }
            catch (IOException iOException3) {
                if (string2 != null) break block8;
                object2 = var4_6;
            }
            try {
                object = KeyPair.load((JSch)object, byArray, (byte[])object2);
                return object;
            }
            finally {
                Util.bzero(byArray);
            }
        }
        throw new JSchException(iOException3.toString(), iOException3);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static KeyPair load(JSch var0, byte[] var1_9, byte[] var2_10) throws JSchException {
        block137: {
            block150: {
                block134: {
                    block139: {
                        block151: {
                            block154: {
                                block153: {
                                    block135: {
                                        block133: {
                                            block131: {
                                                block130: {
                                                    block129: {
                                                        block125: {
                                                            block128: {
                                                                block148: {
                                                                    var16_11 /* !! */  = new byte[8];
                                                                    var15_12 = null;
                                                                    var19_15 = null;
                                                                    var13_16 = "";
                                                                    if (var2_10 == null && var1_9 != null && var1_9.length > 11 && var1_9[0] == 0 && var1_9[1] == 0 && var1_9[2] == 0 && (var1_9[3] == 7 || var1_9[3] == 19)) {
                                                                        var2_10 = new Buffer(var1_9);
                                                                        var2_10.skip(var1_9.length);
                                                                        var12_17 = new String(var2_10.getString());
                                                                        var2_10.rewind();
                                                                        if (var12_17.equals("ssh-rsa")) {
                                                                            return KeyPairRSA.fromSSHAgent((JSch)var0, (Buffer)var2_10);
                                                                        }
                                                                        if (var12_17.equals("ssh-dss")) {
                                                                            return KeyPairDSA.fromSSHAgent((JSch)var0, (Buffer)var2_10);
                                                                        }
                                                                        if (var12_17.equals("ecdsa-sha2-nistp256") != false) return KeyPairECDSA.fromSSHAgent((JSch)var0, (Buffer)var2_10);
                                                                        if (var12_17.equals("ecdsa-sha2-nistp384") != false) return KeyPairECDSA.fromSSHAgent((JSch)var0, (Buffer)var2_10);
                                                                        if (var12_17.equals("ecdsa-sha2-nistp521") == false) throw new JSchException("privatekey: invalid key " + new String(var1_9, 4, 7));
                                                                        return KeyPairECDSA.fromSSHAgent((JSch)var0, (Buffer)var2_10);
                                                                    }
                                                                    var20_19 = null;
                                                                    var21_20 = null;
                                                                    var10_21 = true;
                                                                    var17_22 /* !! */  = var1_9;
                                                                    if (var17_22 /* !! */  != null) {
                                                                        try {
                                                                            var12_18 = KeyPair.loadPPK((JSch)var0, var17_22 /* !! */ );
                                                                            if (var12_18 != null) {
                                                                                return var12_18;
                                                                            }
                                                                        }
                                                                        catch (Exception var0_1) {
                                                                            break block125;
                                                                        }
                                                                    }
                                                                    var6_25 = var17_22 /* !! */  != null ? var17_22 /* !! */ .length : 0;
                                                                    for (var3_26 = 0; var3_26 < var6_25 && (var17_22 /* !! */ [var3_26] != 45 || var3_26 + 4 >= var6_25 || var17_22 /* !! */ [var3_26 + 1] != 45 || var17_22 /* !! */ [var3_26 + 2] != 45 || var17_22 /* !! */ [var3_26 + 3] != 45 || (var4_27 = var17_22 /* !! */ [var3_26 + 4]) != 45); ++var3_26) {
                                                                    }
                                                                    var14_28 = null;
                                                                    var7_29 = 0;
                                                                    var5_30 /* !! */  = 0;
                                                                    var4_27 = var3_26;
                                                                    var3_26 = var5_30 /* !! */ ;
                                                                    block44: while (true) {
                                                                        block126: {
                                                                            block140: {
                                                                                block147: {
                                                                                    block142: {
                                                                                        block146: {
                                                                                            block145: {
                                                                                                block144: {
                                                                                                    block143: {
                                                                                                        block141: {
                                                                                                            var18_33 = "invalid privatekey: ";
                                                                                                            var5_30 /* !! */  = ++var4_27;
                                                                                                            var11_32 = var10_21;
                                                                                                            if (var4_27 >= var6_25) break;
                                                                                                            if (var17_22 /* !! */ [var4_27] != 66 || var4_27 + 3 >= var6_25 || var17_22 /* !! */ [var4_27 + 1] != 69 || var17_22 /* !! */ [var4_27 + 2] != 71 || var17_22 /* !! */ [var4_27 + 3] != 73) break block140;
                                                                                                            if ((var4_27 += 6) + 2 >= var6_25) ** GOTO lbl95
                                                                                                            if (var17_22 /* !! */ [var4_27] != 68 || var17_22 /* !! */ [var4_27 + 1] != 83 || var17_22 /* !! */ [var4_27 + 2] != 65) break block141;
                                                                                                            var3_26 = 1;
                                                                                                            var5_30 /* !! */  = var7_29;
                                                                                                            break block142;
                                                                                                        }
                                                                                                        if (var17_22 /* !! */ [var4_27] != 82 || var17_22 /* !! */ [var4_27 + 1] != 83 || var17_22 /* !! */ [var4_27 + 2] != 65) break block143;
                                                                                                        var3_26 = 2;
                                                                                                        var5_30 /* !! */  = var7_29;
                                                                                                        break block142;
                                                                                                    }
                                                                                                    if (var17_22 /* !! */ [var4_27] != 69 || var17_22 /* !! */ [var4_27 + 1] != 67) break block144;
                                                                                                    var3_26 = 3;
                                                                                                    var5_30 /* !! */  = var7_29;
                                                                                                    break block142;
                                                                                                }
                                                                                                if (var17_22 /* !! */ [var4_27] != 83 || var17_22 /* !! */ [var4_27 + 1] != 83 || var17_22 /* !! */ [var4_27 + 2] != 72) break block145;
                                                                                                var5_30 /* !! */  = 1;
                                                                                                var3_26 = 4;
                                                                                                break block142;
                                                                                            }
                                                                                            if (var4_27 + 6 >= var6_25 || var17_22 /* !! */ [var4_27] != 80 || var17_22 /* !! */ [var4_27 + 1] != 82 || var17_22 /* !! */ [var4_27 + 2] != 73 || var17_22 /* !! */ [var4_27 + 3] != 86 || var17_22 /* !! */ [var4_27 + 4] != 65 || var17_22 /* !! */ [var4_27 + 5] != 84 || var17_22 /* !! */ [var4_27 + 6] != 69) break block146;
                                                                                            var4_27 += 3;
                                                                                            var10_21 = false;
                                                                                            var5_30 /* !! */  = 3;
                                                                                            var3_26 = 4;
                                                                                            break block142;
                                                                                        }
                                                                                        if (var4_27 + 8 >= var6_25 || var17_22 /* !! */ [var4_27] != 69 || var17_22 /* !! */ [var4_27 + 1] != 78 || var17_22 /* !! */ [var4_27 + 2] != 67 || var17_22 /* !! */ [var4_27 + 3] != 82 || var17_22 /* !! */ [var4_27 + 4] != 89 || var17_22 /* !! */ [var4_27 + 5] != 80 || var17_22 /* !! */ [var4_27 + 6] != 84 || var17_22 /* !! */ [var4_27 + 7] != 69 || var17_22 /* !! */ [var4_27 + 8] != 68) break block147;
                                                                                        var4_27 += 5;
                                                                                        var5_30 /* !! */  = 3;
                                                                                        var3_26 = 4;
                                                                                    }
                                                                                    var4_27 += 3;
                                                                                    var7_29 = var5_30 /* !! */ ;
                                                                                    continue;
                                                                                }
                                                                                var12_18 = var14_28;
                                                                                var11_32 = var10_21;
                                                                                try {
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var2_10 = new StringBuilder();
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var0 = new JSchException(var2_10.append("invalid privatekey: ").append(var1_9).toString());
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    throw var0;
lbl95:
                                                                                    // 1 sources

                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var2_10 = new JSchException;
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var0 = new StringBuilder();
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var2_10 = new JSchException(var0.append("invalid privatekey: ").append(var1_9).toString());
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    throw var2_10;
                                                                                }
                                                                                catch (Exception var0_2) {
                                                                                    break block125;
                                                                                }
                                                                            }
                                                                            if (var17_22 /* !! */ [var4_27] == 65 && var4_27 + 7 < var6_25 && var17_22 /* !! */ [var4_27 + 1] == 69 && var17_22 /* !! */ [var4_27 + 2] == 83 && var17_22 /* !! */ [var4_27 + 3] == 45 && var17_22 /* !! */ [var4_27 + 4] == 50 && var17_22 /* !! */ [var4_27 + 5] == 53 && var17_22 /* !! */ [var4_27 + 6] == 54 && var17_22 /* !! */ [var4_27 + 7] == 45) {
                                                                                var4_27 += 8;
                                                                                var12_18 = var14_28;
                                                                                var11_32 = var10_21;
                                                                                {
                                                                                    if (!Session.checkCipher(JSch.getConfig("aes256-cbc"))) {
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var2_10 = new StringBuilder();
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var0 = new JSchException(var2_10.append("privatekey: aes256-cbc is not available ").append(var1_9).toString());
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        throw var0;
                                                                                    }
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var16_11 /* !! */  = (byte[])((Cipher)Class.forName(JSch.getConfig("aes256-cbc")).newInstance());
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var12_18 = (Cipher)var16_11 /* !! */ ;
                                                                                    var14_28 = var16_11 /* !! */ ;
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var16_11 /* !! */  = new byte[var14_28.getIVSize()];
                                                                                    continue;
                                                                                }
                                                                            }
                                                                            if (var17_22 /* !! */ [var4_27] == 65 && var4_27 + 7 < var6_25 && var17_22 /* !! */ [var4_27 + 1] == 69 && var17_22 /* !! */ [var4_27 + 2] == 83 && var17_22 /* !! */ [var4_27 + 3] == 45 && var17_22 /* !! */ [var4_27 + 4] == 49 && var17_22 /* !! */ [var4_27 + 5] == 57 && var17_22 /* !! */ [var4_27 + 6] == 50 && var17_22 /* !! */ [var4_27 + 7] == 45) {
                                                                                var4_27 += 8;
                                                                                var12_18 = var14_28;
                                                                                var11_32 = var10_21;
                                                                                {
                                                                                    if (!Session.checkCipher(JSch.getConfig("aes192-cbc"))) {
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var0 = new StringBuilder();
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var2_10 = new JSchException(var0.append("privatekey: aes192-cbc is not available ").append(var1_9).toString());
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        throw var2_10;
                                                                                    }
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var16_11 /* !! */  = (byte[])((Cipher)Class.forName(JSch.getConfig("aes192-cbc")).newInstance());
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var12_18 = (Cipher)var16_11 /* !! */ ;
                                                                                    var12_18 = var14_28 = var16_11 /* !! */ ;
                                                                                    var11_32 = var10_21;
                                                                                    var16_11 /* !! */  = new byte[var14_28.getIVSize()];
                                                                                    continue;
                                                                                }
                                                                            }
                                                                            if (var17_22 /* !! */ [var4_27] == 65 && var4_27 + 7 < var6_25 && var17_22 /* !! */ [var4_27 + 1] == 69 && var17_22 /* !! */ [var4_27 + 2] == 83 && var17_22 /* !! */ [var4_27 + 3] == 45 && var17_22 /* !! */ [var4_27 + 4] == 49 && var17_22 /* !! */ [var4_27 + 5] == 50 && var17_22 /* !! */ [var4_27 + 6] == 56 && var17_22 /* !! */ [var4_27 + 7] == 45) {
                                                                                var4_27 += 8;
                                                                                var12_18 = var14_28;
                                                                                var11_32 = var10_21;
                                                                                {
                                                                                    if (!Session.checkCipher(JSch.getConfig("aes128-cbc"))) {
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var0 = new StringBuilder();
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var2_10 = new JSchException(var0.append("privatekey: aes128-cbc is not available ").append(var1_9).toString());
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        throw var2_10;
                                                                                    }
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var16_11 /* !! */  = (byte[])((Cipher)Class.forName(JSch.getConfig("aes128-cbc")).newInstance());
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var12_18 = (Cipher)var16_11 /* !! */ ;
                                                                                    var14_28 = var16_11 /* !! */ ;
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    var16_11 /* !! */  = new byte[var14_28.getIVSize()];
                                                                                    continue;
                                                                                }
                                                                            }
                                                                            if (var17_22 /* !! */ [var4_27] == 67 && var4_27 + 3 < var6_25 && var17_22 /* !! */ [var4_27 + 1] == 66 && var17_22 /* !! */ [var4_27 + 2] == 67 && var17_22 /* !! */ [var4_27 + 3] == 44) {
                                                                                var4_27 += 4;
                                                                                var5_30 /* !! */  = 0;
                                                                                while (true) {
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    {
                                                                                        if (var5_30 /* !! */  >= var16_11 /* !! */ .length) continue block44;
                                                                                        var8_31 = var4_27 + 1;
                                                                                        var12_18 = var14_28;
                                                                                        var11_32 = var10_21;
                                                                                        var16_11 /* !! */ [var5_30 /* !! */ ] = (byte)((KeyPair.a2b((byte)var17_22 /* !! */ [var4_27]) << 4 & 240) + (KeyPair.a2b((byte)var17_22 /* !! */ [var8_31]) & 15));
                                                                                        ++var5_30 /* !! */ ;
                                                                                        var4_27 = var8_31 + 1;
                                                                                        continue;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                            }
                                                                            if (var17_22 /* !! */ [var4_27] == 13) {
                                                                                var12_18 = var14_28;
                                                                                var11_32 = var10_21;
                                                                                if (var4_27 + 1 < var17_22 /* !! */ .length && var17_22 /* !! */ [var4_27 + 1] == 10) continue;
                                                                            }
                                                                            if (var17_22 /* !! */ [var4_27] == 10) {
                                                                                var12_18 = var14_28;
                                                                                var11_32 = var10_21;
                                                                                {
                                                                                    if (var4_27 + 1 >= var17_22 /* !! */ .length) break block126;
                                                                                }
                                                                                if (var17_22 /* !! */ [var4_27 + 1] == 10) {
                                                                                    var5_30 /* !! */  = var4_27 + 2;
                                                                                    var11_32 = var10_21;
                                                                                    break;
                                                                                }
                                                                                if (var17_22 /* !! */ [var4_27 + 1] == 13) {
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    if (var4_27 + 2 < var17_22 /* !! */ .length && var17_22 /* !! */ [var4_27 + 2] == 10) {
                                                                                        var5_30 /* !! */  = var4_27 + 3;
                                                                                        var11_32 = var10_21;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                var5_30 /* !! */  = 0;
                                                                                var8_31 = var4_27 + 1;
                                                                                while (true) {
                                                                                    var12_18 = var14_28;
                                                                                    var11_32 = var10_21;
                                                                                    if (var8_31 >= var17_22 /* !! */ .length || var17_22 /* !! */ [var8_31] == 10) break;
                                                                                    if (var17_22 /* !! */ [var8_31] == 58) {
                                                                                        var5_30 /* !! */  = 1;
                                                                                        break;
                                                                                    }
                                                                                    ++var8_31;
                                                                                }
                                                                                if (var5_30 /* !! */  == 0) {
                                                                                    var5_30 /* !! */  = ++var4_27;
                                                                                    var11_32 = var10_21;
                                                                                    if (var7_29 == 3) break;
                                                                                    var11_32 = false;
                                                                                    var5_30 /* !! */  = var4_27;
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        ++var4_27;
                                                                    }
                                                                    if (var17_22 /* !! */  == null) break block148;
                                                                    if (var3_26 == 0) ** GOTO lbl296
                                                                    for (var4_27 = var5_30 /* !! */ ; var4_27 < var6_25 && (var8_31 = var17_22 /* !! */ [var4_27]) != 45; ++var4_27) {
                                                                    }
                                                                    if (var6_25 - var4_27 == 0 || var4_27 - var5_30 /* !! */  == 0) ** GOTO lbl288
                                                                    var12_18 = var15_12;
                                                                    var12_18 = var13_16;
                                                                    var22_34 = new byte[var4_27 - var5_30 /* !! */ ];
                                                                    var12_18 = var15_12;
                                                                    var12_18 = var13_16;
                                                                    System.arraycopy(var17_22 /* !! */ , var5_30 /* !! */ , var22_34, 0, var22_34.length);
                                                                    var5_30 /* !! */  = 0;
                                                                    var12_18 = var15_12;
                                                                    var12_18 = var13_16;
                                                                    var4_27 = var22_34.length;
                                                                    {
                                                                        block149: {
                                                                            block127: {
                                                                                catch (Exception var0_3) {
                                                                                    break block125;
                                                                                }
                                                                                var15_12 = var22_34;
                                                                                var12_18 = var19_15;
lbl273:
                                                                                // 3 sources

                                                                                while (var5_30 /* !! */  < var4_27) {
                                                                                    var6_25 = var22_34[var5_30 /* !! */ ];
                                                                                    if (var6_25 != 10) break block127;
                                                                                    var6_25 = var22_34[var5_30 /* !! */  - 1];
                                                                                    var6_25 = var6_25 == 13 ? 1 : 0;
                                                                                    var8_31 = var6_25 != 0 ? 1 : 0;
                                                                                    var19_15 = var20_19;
                                                                                    System.arraycopy(var22_34, var5_30 /* !! */  + 1, var22_34, var5_30 /* !! */  - var8_31, var4_27 - (var5_30 /* !! */  + 1));
                                                                                    var8_31 = var4_27;
                                                                                    if (var6_25 != 0) {
                                                                                        var8_31 = var4_27 - 1;
                                                                                    }
                                                                                    var4_27 = var8_31 - 1;
                                                                                }
                                                                                break block149;
lbl288:
                                                                                // 1 sources

                                                                                var19_15 = var20_19;
                                                                                var19_15 = var20_19;
                                                                                var19_15 = var20_19;
                                                                                var0 = new StringBuilder();
                                                                                var19_15 = var20_19;
                                                                                var2_10 = new JSchException(var0.append("invalid privatekey: ").append(var1_9).toString());
                                                                                var19_15 = var20_19;
                                                                                throw var2_10;
lbl296:
                                                                                // 1 sources

                                                                                var19_15 = var20_19;
                                                                                var19_15 = var20_19;
                                                                                var19_15 = var20_19;
                                                                                var0 = new StringBuilder();
                                                                                var19_15 = var20_19;
                                                                                var2_10 = new JSchException(var0.append("invalid privatekey: ").append(var1_9).toString());
                                                                                var19_15 = var20_19;
                                                                                throw var2_10;
                                                                                catch (Exception var0_4) {
                                                                                    break block125;
                                                                                }
                                                                            }
                                                                            if (var22_34[var5_30 /* !! */ ] == 45) break block149;
                                                                            ++var5_30 /* !! */ ;
                                                                            ** GOTO lbl273
                                                                        }
                                                                        var17_22 /* !! */  = var12_18;
                                                                        var12_18 = var21_20;
                                                                        if (var5_30 /* !! */  - 0 > 0) {
                                                                            var19_15 = var20_19;
                                                                            var12_18 = Util.fromBase64(var22_34, 0, var5_30 /* !! */  - 0);
                                                                        }
                                                                        var19_15 = var12_18;
                                                                        Util.bzero(var22_34);
                                                                        var15_12 = var12_18;
                                                                        var12_18 = var17_22 /* !! */ ;
                                                                        break block128;
                                                                    }
                                                                }
                                                                var12_18 = null;
                                                                var13_16 = "";
                                                                var15_12 = null;
                                                            }
                                                            if (var15_12 == null) break block129;
                                                            try {
                                                                if ((var15_12).length <= 4) break block129;
                                                            }
                                                            catch (Exception var0_7) {
                                                                // empty catch block
                                                                break block125;
                                                            }
                                                            if (var15_12[0] != 63 || var15_12[1] != 111 || var15_12[2] != -7 || var15_12[3] != -21) break block129;
                                                            {
                                                                var17_22 /* !! */  = (byte[])new Buffer;
                                                                var17_22 /* !! */ ((byte[])var15_12);
                                                                var17_22 /* !! */ .getInt();
                                                                var17_22 /* !! */ .getInt();
                                                                var17_22 /* !! */ .getString();
                                                                var19_15 = Util.byte2str(var17_22 /* !! */ .getString());
                                                                if (var19_15.equals("3des-cbc")) ** GOTO lbl-1000
                                                                if (!var19_15.equals("none")) break block129;
                                                                var17_22 /* !! */ .getInt();
                                                                var17_22 /* !! */ .getInt();
                                                                var11_32 = false;
                                                            }
                                                            try {
                                                                var20_19 = new byte[((Object)var15_12).length - var17_22 /* !! */ .getOffSet()];
                                                                var17_22 /* !! */ .getByte((byte[])var20_19);
                                                                break block130;
                                                            }
                                                            catch (Exception var0_5) {
                                                                break block125;
                                                            }
lbl-1000:
                                                            // 1 sources

                                                            {
                                                                var17_22 /* !! */ .getInt();
                                                                var17_22 /* !! */ .getByte(new byte[((Object)var15_12).length - var17_22 /* !! */ .getOffSet()]);
                                                            }
                                                            try {
                                                                var2_10 = new StringBuilder();
                                                                var0 = new JSchException(var2_10.append("unknown privatekey format: ").append(var1_9).toString());
                                                                throw var0;
                                                            }
                                                            catch (Exception var0_6) {}
                                                        }
                                                        if (var0_8 instanceof JSchException != false) throw (JSchException)var0_8;
                                                        if (var0_8 instanceof Throwable == false) throw new JSchException(var0_8.toString());
                                                        throw new JSchException(var0_8.toString(), (Throwable)var0_8);
                                                    }
                                                    var20_19 = var15_12;
                                                }
                                                if (var2_10 == null) break block150;
                                                var8_31 = ((Object)var2_10).length;
                                                var15_12 = var18_33;
                                                ** try [egrp 19[TRYBLOCK] [67 : 2900->2906)] { 
lbl376:
                                                // 1 sources

                                                if (((Object)var2_10).length <= 4 || var2_10[0] != 45 || var2_10[1] != 45 || var2_10[2] != 45 || var2_10[3] != 45) break block151;
                                                var5_30 /* !! */  = 1;
                                                var4_27 = 0;
                                                do {
                                                    var6_25 = var4_27 + 1;
                                                    var15_12 = var18_33;
                                                    if (((Object)var2_10).length <= var6_25) break;
                                                    var4_27 = var6_25;
                                                } while (var2_10[var6_25] != 10);
                                                var4_27 = var5_30 /* !! */ ;
                                                var5_30 /* !! */  = var6_25;
                                                var15_12 = var18_33;
                                                if (((Object)var2_10).length > var6_25) break block131;
                                                var4_27 = 0;
                                                var5_30 /* !! */  = var6_25;
                                            }
                                            while (var4_27 != 0) {
                                                if (var2_10[var5_30 /* !! */ ] == 10) {
                                                    block132: {
                                                        var6_25 = 0;
                                                        var9_35 = var5_30 /* !! */  + 1;
                                                        while (true) {
                                                            var15_12 = var18_33;
                                                            ** try [egrp 22[TRYBLOCK] [70 : 3027->3034)] { 
lbl401:
                                                            // 1 sources

                                                            if (var9_35 >= ((Object)var2_10).length || var2_10[var9_35] == 10) break;
                                                            if (var2_10[var9_35] == 58) {
                                                                var9_35 = 1;
                                                                break block132;
                                                            }
                                                            ++var9_35;
                                                        }
                                                        var9_35 = var6_25;
                                                    }
                                                    var6_25 = var4_27;
                                                    if (var9_35 == 0) {
                                                        var6_25 = var5_30 /* !! */  + 1;
                                                        break block133;
                                                    }
                                                } else {
                                                    var6_25 = var4_27;
                                                }
                                                ++var5_30 /* !! */ ;
                                                var4_27 = var6_25;
                                            }
                                            var6_25 = var5_30 /* !! */ ;
                                        }
                                        var15_12 = var18_33;
                                        try {
                                            var9_35 = ((Object)var2_10).length <= var6_25 ? 0 : var4_27;
                                            var15_12 = var18_33;
                                            var4_27 = var6_25;
                                        }
lbl546:
                                        // 5 sources

                                        catch (Exception var17_24) {}
                                        while (var9_35 != 0 && var4_27 < var8_31) {
                                            block152: {
                                                var5_30 /* !! */  = (int)var2_10[var4_27];
                                                var17_22 /* !! */  = (byte[])var15_12;
                                                if (var5_30 /* !! */  != 10) break block152;
                                                var5_30 /* !! */  = var3_26;
                                                var15_12 = var17_22 /* !! */ ;
                                                try {}
                                                catch (Exception var17_23) {
                                                    var3_26 = var5_30 /* !! */ ;
                                                    break block134;
                                                }
                                                System.arraycopy(var2_10, var4_27 + 1, var2_10, var4_27, var8_31 - var4_27 - 1);
                                                --var8_31;
                                                var15_12 = var17_22 /* !! */ ;
                                                continue;
                                            }
                                            if (var2_10[var4_27] == 45) break;
                                            ++var4_27;
                                            var15_12 = var17_22 /* !! */ ;
                                        }
                                        var19_15 = var15_12;
                                        if (var9_35 == 0) break block153;
                                        var5_30 /* !! */  = var3_26;
                                        var15_12 = var19_15;
                                        {
                                            var17_22 /* !! */  = Util.fromBase64((byte[])var2_10, var6_25, var4_27 - var6_25);
                                            if (var1_9 == null) break block135;
                                            var4_27 = var3_26;
                                        }
                                        var12_18 = var17_22 /* !! */ ;
                                        if (var3_26 != 4) break block154;
                                    }
                                    if (var17_22 /* !! */ [8] == 100) {
                                        var4_27 = 1;
                                        var12_18 = var17_22 /* !! */ ;
                                        break block154;
                                    } else {
                                        var5_30 /* !! */  = var17_22 /* !! */ [8];
                                        var4_27 = var3_26;
                                        var12_18 = var17_22 /* !! */ ;
                                        if (var5_30 /* !! */  == 114) {
                                            var4_27 = 2;
                                            var12_18 = var17_22 /* !! */ ;
                                        }
                                    }
                                    break block154;
                                }
                                var4_27 = var3_26;
                            }
                            var15_12 = var12_18;
                            var17_22 /* !! */  = (byte[])var13_16;
                            ** GOTO lbl539
lbl472:
                            // 1 sources

                            while (true) {
                                if (var3_26 < var8_31 && var2_10[var3_26] != 32) {
                                    ++var3_26;
                                    continue;
                                }
                                var3_26 = var6_25 = var3_26 + 1;
                                var15_12 = var12_18;
                                if (var6_25 < var8_31) {
                                    for (var3_26 = var6_25; var3_26 < var8_31 && var2_10[var3_26] != 32; ++var3_26) {
                                    }
                                    var5_30 /* !! */  = var4_27;
                                    var15_12 = var18_33;
                                    {
                                        var17_22 /* !! */  = Util.fromBase64((byte[])var2_10, var6_25, var3_26 - var6_25);
                                    }
                                    var15_12 = var17_22 /* !! */ ;
                                }
                                var9_36 = var3_26 + 1;
                                if (var3_26 < var8_31) {
                                    for (var3_26 = var9_36; var3_26 < var8_31 && var2_10[var3_26] != 10; ++var3_26) {
                                    }
                                    var5_30 /* !! */  = var3_26;
                                    if (var3_26 > 0) {
                                        var5_30 /* !! */  = var3_26;
                                        if (var2_10[var3_26 - 1] == 13) {
                                            var5_30 /* !! */  = var3_26 - 1;
                                        }
                                    }
                                    var17_22 /* !! */  = (byte[])var13_16;
                                    if (var9_36 < var5_30 /* !! */ ) {
                                        var3_26 = var4_27;
                                        var6_25 = var5_30 /* !! */ ;
                                        var12_18 = var15_12;
                                        {
                                            var17_22 /* !! */  = (byte[])new String((byte[])var2_10, var9_36, var5_30 /* !! */  - var9_36);
                                        }
                                    }
                                    var19_15 = var18_33;
                                } else {
                                    var19_15 = var18_33;
                                    var17_22 /* !! */  = var13_16;
                                }
                                ** GOTO lbl539
                                break;
                            }
lbl505:
                            // 1 sources

                            while (true) {
                                if (var3_26 < var8_31 && var2_10[var3_26] != 32) {
                                    ++var3_26;
                                    continue;
                                }
                                var3_26 = var6_25 = var3_26 + 1;
                                var15_12 = var12_18;
                                if (var6_25 < var8_31) {
                                    for (var3_26 = var6_25; var3_26 < var8_31 && var2_10[var3_26] != 32; ++var3_26) {
                                    }
                                    var5_30 /* !! */  = var4_27;
                                    var15_12 = var18_33;
                                    {
                                        var17_22 /* !! */  = Util.fromBase64((byte[])var2_10, var6_25, var3_26 - var6_25);
                                    }
                                    var15_12 = var17_22 /* !! */ ;
                                }
                                var9_37 = var3_26 + 1;
                                if (var3_26 < var8_31) {
                                    for (var3_26 = var9_37; var3_26 < var8_31 && var2_10[var3_26] != 10; ++var3_26) {
                                    }
                                    var5_30 /* !! */  = var3_26;
                                    if (var3_26 > 0) {
                                        var5_30 /* !! */  = var3_26;
                                        if (var2_10[var3_26 - 1] == 13) {
                                            var5_30 /* !! */  = var3_26 - 1;
                                        }
                                    }
                                    if (var9_37 < var5_30 /* !! */ ) {
                                        var3_26 = var4_27;
                                        var6_25 = var5_30 /* !! */ ;
                                        var12_18 = var15_12;
                                        {
                                            var17_22 /* !! */  = (byte[])new String((byte[])var2_10, var9_37, var5_30 /* !! */  - var9_37);
                                            var19_15 = var18_33;
                                        }
                                    } else {
                                        var19_15 = var18_33;
                                        var17_22 /* !! */  = (byte[])var13_16;
                                    }
                                } else {
                                    var17_22 /* !! */  = (byte[])var13_16;
                                    var19_15 = var18_33;
                                }
lbl540:
                                // 5 sources

                                while (true) {
                                    var13_16 = var15_12;
                                    var12_18 = var17_22 /* !! */ ;
                                    var3_26 = var4_27;
                                    var15_12 = var19_15;
                                    break block137;
                                    break;
                                }
                                break;
                            }
                            break block134;
                            catch (Exception var15_14) {
                                var15_12 = "invalid privatekey: ";
                            }
                            break block134;
                        }
                        var18_33 = "invalid privatekey: ";
                        if (var2_10[0] == 115 && var2_10[1] == 115 && var2_10[2] == 104 && var2_10[3] == 45) {
                            block138: {
                                var4_27 = var3_26;
                                if (var1_9 == null) {
                                    var4_27 = var3_26;
                                    var5_30 /* !! */  = var3_26;
                                    var15_12 = var18_33;
                                    {
                                        if (((Object)var2_10).length <= 7) break block138;
                                    }
                                    if (var2_10[4] == 100) {
                                        var4_27 = 1;
                                    } else {
                                        var4_27 = var3_26;
                                        if (var2_10[4] == 114) {
                                            var4_27 = 2;
                                        }
                                    }
                                }
                            }
                            var3_26 = 0;
                            ** continue;
                        }
                        var4_27 = var3_26;
                        var19_15 = var18_33;
                        var15_12 = var12_18;
                        var17_22 /* !! */  = (byte[])var13_16;
                        if (var2_10[0] != 101) ** GOTO lbl540
                        var4_27 = var3_26;
                        var19_15 = var18_33;
                        var15_12 = var12_18;
                        var17_22 /* !! */  = var13_16;
                        if (var2_10[1] != 99) ** GOTO lbl540
                        var4_27 = var3_26;
                        var19_15 = var18_33;
                        var15_12 = var12_18;
                        var17_22 /* !! */  = var13_16;
                        if (var2_10[2] != 100) ** GOTO lbl540
                        var4_27 = var3_26;
                        var19_15 = var18_33;
                        var15_12 = var12_18;
                        var17_22 /* !! */  = var13_16;
                        if (var2_10[3] == 115) ** break;
                        ** while (true)
                        var4_27 = var3_26;
                        if (var1_9 == null) {
                            var4_27 = var3_26;
                            var5_30 /* !! */  = var3_26;
                            var15_12 = var18_33;
                            {
                                if (((Object)var2_10).length <= 7) break block139;
                                var4_27 = 3;
                            }
                        }
                    }
                    var3_26 = 0;
                    ** while (true)
                }
                var17_22 /* !! */  = (byte[])var12_18;
                var12_18 = var13_16;
                var13_16 = var17_22 /* !! */ ;
                break block137;
            }
            var15_12 = "invalid privatekey: ";
            var17_22 /* !! */  = (byte[])var13_16;
            var13_16 = var12_18;
            var12_18 = var17_22 /* !! */ ;
        }
        var17_22 /* !! */  = null;
        if (var3_26 == 1) {
            var2_10 = new KeyPairDSA((JSch)var0);
        } else if (var3_26 == 2) {
            var2_10 = new KeyPairRSA((JSch)var0);
        } else if (var3_26 == 3) {
            var2_10 = new KeyPairECDSA((JSch)var0, (byte[])var2_10);
        } else {
            var2_10 = var17_22 /* !! */ ;
            if (var7_29 == 3) {
                var2_10 = new KeyPairPKCS8((JSch)var0);
            }
        }
        if (var2_10 == null) return var2_10;
        var2_10.encrypted = var11_32;
        var2_10.publickeyblob = (byte[])var13_16;
        var2_10.vendor = var7_29;
        var2_10.publicKeyComment = var12_18;
        var2_10.cipher = var14_28;
        if (var11_32) {
            var2_10.encrypted = true;
            var2_10.iv = var16_11 /* !! */ ;
            var2_10.data = (byte[])var20_19;
            return var2_10;
        }
        if (var2_10.parse((byte[])var20_19) == false) throw new JSchException((String)var15_12 + var1_9);
        var2_10.encrypted = false;
        return var2_10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static KeyPair loadPPK(JSch object, byte[] object2) throws JSchException {
        Buffer buffer = new Buffer((byte[])object2);
        Object object3 = new Hashtable();
        while (KeyPair.parseHeader(buffer, object3)) {
        }
        Object object4 = (String)((Hashtable)object3).get("PuTTY-User-Key-File-2");
        if (object4 == null) {
            return null;
        }
        byte[] byArray = KeyPair.parseLines(buffer, Integer.parseInt((String)((Hashtable)object3).get("Public-Lines")));
        while (KeyPair.parseHeader(buffer, object3)) {
        }
        byte[] byArray2 = KeyPair.parseLines(buffer, Integer.parseInt((String)((Hashtable)object3).get("Private-Lines")));
        while (KeyPair.parseHeader(buffer, object3)) {
        }
        byte[] byArray3 = Util.fromBase64(byArray2, 0, byArray2.length);
        byArray = Util.fromBase64(byArray, 0, byArray.length);
        if (((String)object4).equals("ssh-rsa")) {
            object4 = new Buffer(byArray);
            ((Buffer)object4).skip(byArray.length);
            ((Buffer)object4).getByte(new byte[((Buffer)object4).getInt()]);
            byArray2 = new byte[((Buffer)object4).getInt()];
            ((Buffer)object4).getByte(byArray2);
            byArray = new byte[((Buffer)object4).getInt()];
            ((Buffer)object4).getByte(byArray);
            object = new KeyPairRSA((JSch)object, byArray, byArray2, null);
        } else {
            if (!((String)object4).equals("ssh-dss")) return null;
            object4 = new Buffer(byArray);
            ((Buffer)object4).skip(byArray.length);
            ((Buffer)object4).getByte(new byte[((Buffer)object4).getInt()]);
            byte[] byArray4 = new byte[((Buffer)object4).getInt()];
            ((Buffer)object4).getByte(byArray4);
            byArray2 = new byte[((Buffer)object4).getInt()];
            ((Buffer)object4).getByte(byArray2);
            byArray = new byte[((Buffer)object4).getInt()];
            ((Buffer)object4).getByte(byArray);
            byte[] byArray5 = new byte[((Buffer)object4).getInt()];
            ((Buffer)object4).getByte(byArray5);
            object = new KeyPairDSA((JSch)object, byArray4, byArray2, byArray, byArray5, null);
        }
        ((KeyPair)object).encrypted = ((Hashtable)object3).get("Encryption").equals("none") ^ true;
        ((KeyPair)object).vendor = 2;
        ((KeyPair)object).publicKeyComment = (String)((Hashtable)object3).get("Comment");
        if (((KeyPair)object).encrypted) {
            if (!Session.checkCipher(JSch.getConfig("aes256-cbc"))) throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
            try {
                object3 = (Cipher)Class.forName(JSch.getConfig("aes256-cbc")).newInstance();
                object4 = (Cipher)object3;
                ((KeyPair)object).cipher = object3;
                ((KeyPair)object).iv = new byte[((KeyPair)object).cipher.getIVSize()];
                ((KeyPair)object).data = byArray3;
                return object;
            }
            catch (Exception exception) {
                throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
            }
        } else {
            ((KeyPair)object).data = byArray3;
            ((KeyPair)object).parse(byArray3);
        }
        return object;
    }

    private static boolean parseHeader(Buffer buffer, Hashtable hashtable) {
        String string2;
        int n;
        boolean bl;
        byte[] byArray = buffer.buffer;
        int n2 = buffer.index;
        String string3 = null;
        String string4 = null;
        int n3 = n2;
        while (true) {
            int n4 = byArray.length;
            bl = true;
            n = n2;
            string2 = string3;
            if (n3 >= n4) break;
            if (byArray[n3] == 13) {
                n = n2;
                string2 = string3;
                break;
            }
            if (byArray[n3] == 58) {
                string2 = new String(byArray, n2, n3 - n2);
                n = n2 = n3 + 1;
                if (n2 >= byArray.length) break;
                n = n2;
                if (byArray[n2] != 32) break;
                n = n2 + 1;
                break;
            }
            ++n3;
        }
        if (string2 == null) {
            return false;
        }
        n2 = n;
        while (true) {
            n3 = n;
            string3 = string4;
            if (n2 >= byArray.length) break;
            if (byArray[n2] == 13) {
                string3 = new String(byArray, n, n2 - n);
                n = ++n2;
                if (n2 < byArray.length) {
                    n = n2;
                    if (byArray[n2] == 10) {
                        n = n2 + 1;
                    }
                }
                n3 = n;
                break;
            }
            ++n2;
        }
        if (string3 != null) {
            hashtable.put(string2, string3);
            buffer.index = n3;
        }
        if (string2 == null || string3 == null) {
            bl = false;
        }
        return bl;
    }

    private static byte[] parseLines(Buffer buffer, int n) {
        byte[] byArray = buffer.buffer;
        int n2 = buffer.index;
        byte[] byArray2 = null;
        int n3 = n2;
        int n4 = n;
        n = n3;
        while (n4 > 0) {
            byte[] byArray3;
            int n5 = n;
            while (true) {
                byArray3 = byArray2;
                n3 = n5;
                if (byArray.length <= n5) break;
                n = n5 + 1;
                if (byArray[n5] == 13) {
                    if (byArray2 == null) {
                        byArray3 = new byte[n - n2 - 1];
                        System.arraycopy(byArray, n2, byArray3, 0, n - n2 - 1);
                        n3 = n;
                        break;
                    }
                    byArray3 = new byte[byArray2.length + n - n2 - 1];
                    System.arraycopy(byArray2, 0, byArray3, 0, byArray2.length);
                    System.arraycopy(byArray, n2, byArray3, byArray2.length, n - n2 - 1);
                    for (n3 = 0; n3 < byArray2.length; ++n3) {
                        byArray2[n3] = 0;
                    }
                    n3 = n;
                    break;
                }
                n5 = n;
            }
            n = n3;
            if (byArray[n3] == 10) {
                n = n3 + 1;
            }
            n2 = n;
            --n4;
            byArray2 = byArray3;
        }
        if (byArray2 != null) {
            buffer.index = n2;
        }
        return byArray2;
    }

    void copy(KeyPair keyPair) {
        this.publickeyblob = keyPair.publickeyblob;
        this.vendor = keyPair.vendor;
        this.publicKeyComment = keyPair.publicKeyComment;
        this.cipher = keyPair.cipher;
    }

    int countLength(int n) {
        int n2 = 1;
        int n3 = n;
        if (n <= 127) {
            return 1;
        }
        while (n3 > 0) {
            n3 >>>= 8;
            ++n2;
        }
        return n2;
    }

    public boolean decrypt(String string2) {
        if (string2 != null && string2.length() != 0) {
            return this.decrypt(Util.str2byte(string2));
        }
        return this.encrypted ^ true;
    }

    public boolean decrypt(byte[] byArray) {
        if (!this.encrypted) {
            return true;
        }
        if (byArray == null) {
            return this.encrypted ^ true;
        }
        byte[] byArray2 = new byte[byArray.length];
        System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
        byArray = this.decrypt(this.data, byArray2, this.iv);
        Util.bzero(byArray2);
        if (this.parse(byArray)) {
            this.encrypted = false;
        }
        return true ^ this.encrypted;
    }

    public void dispose() {
        Util.bzero(this.passphrase);
    }

    public void finalize() {
        this.dispose();
    }

    public abstract byte[] forSSHAgent() throws JSchException;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    byte[] genKey(byte[] byArray, byte[] object) {
        synchronized (this) {
            byte[] byArray2;
            Object object2;
            Object object3;
            int n;
            byte[] byArray3;
            block43: {
                byte[] byArray4;
                int n2;
                block40: {
                    if (this.cipher == null) {
                        this.cipher = this.genCipher();
                    }
                    if (this.hash == null) {
                        this.hash = this.genHash();
                    }
                    byArray3 = new byte[this.cipher.getBlockSize()];
                    n2 = this.hash.getBlockSize();
                    int n3 = byArray3.length / n2;
                    n = byArray3.length % n2 == 0 ? 0 : n2;
                    byArray4 = new byte[n3 * n2 + n];
                    object3 = null;
                    object2 = null;
                    byArray2 = byArray3;
                    if (this.vendor != 0) break block40;
                    n = 0;
                    object3 = object2;
                    while (true) {
                        block42: {
                            block41: {
                                byArray2 = byArray3;
                                if (n + n2 > byArray4.length) break;
                                if (object3 == null) break block41;
                                byArray2 = byArray3;
                                this.hash.update((byte[])object3, 0, (object3).length);
                            }
                            byArray2 = byArray3;
                            this.hash.update(byArray, 0, byArray.length);
                            byArray2 = byArray3;
                            object3 = this.hash;
                            byArray2 = byArray3;
                            int n4 = ((byte[])object).length;
                            n3 = 8;
                            if (n4 > 8) break block42;
                            byArray2 = byArray3;
                            n3 = ((byte[])object).length;
                        }
                        byArray2 = byArray3;
                        object3.update((byte[])object, 0, n3);
                        byArray2 = byArray3;
                        object3 = this.hash.digest();
                        byArray2 = byArray3;
                        System.arraycopy(object3, 0, byArray4, n, ((Object)object3).length);
                        byArray2 = byArray3;
                        n += ((Object)object3).length;
                        continue;
                        break;
                    }
                    byArray2 = byArray3;
                    System.arraycopy(byArray4, 0, byArray3, 0, byArray3.length);
                    return byArray3;
                }
                byArray2 = byArray3;
                if (this.vendor != 1) break block43;
                n = 0;
                object = object3;
                while (true) {
                    block44: {
                        byArray2 = byArray3;
                        if (n + n2 > byArray4.length) break;
                        if (object == null) break block44;
                        byArray2 = byArray3;
                        this.hash.update((byte[])object, 0, ((byte[])object).length);
                    }
                    byArray2 = byArray3;
                    this.hash.update(byArray, 0, byArray.length);
                    byArray2 = byArray3;
                    object = this.hash.digest();
                    byArray2 = byArray3;
                    System.arraycopy(object, 0, byArray4, n, ((byte[])object).length);
                    byArray2 = byArray3;
                    n += ((byte[])object).length;
                    continue;
                    break;
                }
                byArray2 = byArray3;
                System.arraycopy(byArray4, 0, byArray3, 0, byArray3.length);
                return byArray3;
            }
            object = byArray3;
            byArray2 = byArray3;
            if (this.vendor != 2) return object;
            byArray2 = byArray3;
            object3 = (HASH)Class.forName(JSch.getConfig("sha-1")).newInstance();
            byArray2 = byArray3;
            object = object3;
            byArray2 = byArray3;
            object2 = new byte[4];
            byArray2 = byArray3;
            try {
                byArray3 = new byte[40];
                n = 0;
            }
            catch (Exception exception) {
                System.err.println(exception);
                return byArray2;
            }
            while (true) {
                object = byArray3;
                if (n >= 2) return object;
                byArray2 = byArray3;
                object3.init();
                object2[3] = (byte)n;
                byArray2 = byArray3;
                object3.update((byte[])object2, 0, ((Object)object2).length);
                byArray2 = byArray3;
                object3.update(byArray, 0, byArray.length);
                byArray2 = byArray3;
                System.arraycopy(object3.digest(), 0, byArray3, n * 20, 20);
                ++n;
                continue;
                break;
            }
        }
    }

    abstract void generate(int var1) throws JSchException;

    abstract byte[] getBegin();

    abstract byte[] getEnd();

    public String getFingerPrint() {
        byte[] byArray;
        if (this.hash == null) {
            this.hash = this.genHash();
        }
        if ((byArray = this.getPublicKeyBlob()) == null) {
            return null;
        }
        return Util.getFingerPrint(this.hash, byArray);
    }

    abstract int getKeySize();

    public abstract int getKeyType();

    abstract byte[] getKeyTypeName();

    abstract byte[] getPrivateKey();

    public byte[] getPublicKeyBlob() {
        return this.publickeyblob;
    }

    public String getPublicKeyComment() {
        return this.publicKeyComment;
    }

    public abstract byte[] getSignature(byte[] var1);

    public abstract Signature getVerifier();

    public boolean isEncrypted() {
        return this.encrypted;
    }

    abstract boolean parse(byte[] var1);

    public void setPassphrase(String object) {
        if (object != null && ((String)object).length() != 0) {
            this.setPassphrase(Util.str2byte((String)object));
        } else {
            object = null;
            this.setPassphrase((byte[])null);
        }
    }

    public void setPassphrase(byte[] byArray) {
        byte[] byArray2 = byArray;
        if (byArray != null) {
            byArray2 = byArray;
            if (byArray.length == 0) {
                byArray2 = null;
            }
        }
        this.passphrase = byArray2;
    }

    public void setPublicKeyComment(String string2) {
        this.publicKeyComment = string2;
    }

    int writeDATA(byte[] byArray, byte by, int n, byte[] byArray2) {
        byArray[n] = by;
        n = this.writeLength(byArray, n + 1, byArray2.length);
        System.arraycopy(byArray2, 0, byArray, n, byArray2.length);
        return n + byArray2.length;
    }

    int writeINTEGER(byte[] byArray, int n, byte[] byArray2) {
        byArray[n] = 2;
        n = this.writeLength(byArray, n + 1, byArray2.length);
        System.arraycopy(byArray2, 0, byArray, n, byArray2.length);
        return n + byArray2.length;
    }

    int writeLength(byte[] byArray, int n, int n2) {
        int n3 = this.countLength(n2) - 1;
        if (n3 == 0) {
            byArray[n] = (byte)n2;
            return n + 1;
        }
        int n4 = n + 1;
        byArray[n] = (byte)(n3 | 0x80);
        for (n = n3; n > 0; --n) {
            byArray[n4 + n - 1] = (byte)(n2 & 0xFF);
            n2 >>>= 8;
        }
        return n4 + n3;
    }

    int writeOCTETSTRING(byte[] byArray, int n, byte[] byArray2) {
        byArray[n] = 4;
        n = this.writeLength(byArray, n + 1, byArray2.length);
        System.arraycopy(byArray2, 0, byArray, n, byArray2.length);
        return n + byArray2.length;
    }

    public void writePrivateKey(OutputStream outputStream) {
        this.writePrivateKey(outputStream, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writePrivateKey(OutputStream outputStream, byte[] byArray) {
        byte[][] byArrayArray;
        byte[] byArray2;
        byte[] byArray3 = byArray;
        if (byArray == null) {
            byArray3 = this.passphrase;
        }
        if ((byArray = this.encrypt(byArray2 = this.getPrivateKey(), byArrayArray = new byte[1][], byArray3)) != byArray2) {
            Util.bzero(byArray2);
        }
        byte[] byArray4 = byArrayArray[0];
        byArray = Util.toBase64(byArray, 0, byArray.length);
        try {
            int n;
            outputStream.write(this.getBegin());
            outputStream.write(cr);
            if (byArray3 != null) {
                outputStream.write(header[0]);
                outputStream.write(cr);
                outputStream.write(header[1]);
                for (n = 0; n < byArray4.length; ++n) {
                    outputStream.write(KeyPair.b2a((byte)(byArray4[n] >>> 4 & 0xF)));
                    outputStream.write(KeyPair.b2a((byte)(byArray4[n] & 0xF)));
                }
                outputStream.write(cr);
                outputStream.write(cr);
            }
            for (n = 0; n < byArray.length; n += 64) {
                if (n + 64 < byArray.length) {
                    outputStream.write(byArray, n, 64);
                    outputStream.write(cr);
                    continue;
                }
                outputStream.write(byArray, n, byArray.length - n);
                outputStream.write(cr);
                break;
            }
            outputStream.write(this.getEnd());
            outputStream.write(cr);
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void writePrivateKey(String string2) throws FileNotFoundException, IOException {
        this.writePrivateKey(string2, null);
    }

    public void writePrivateKey(String object, byte[] byArray) throws FileNotFoundException, IOException {
        object = new FileOutputStream((String)object);
        this.writePrivateKey((OutputStream)object, byArray);
        ((FileOutputStream)object).close();
    }

    public void writePublicKey(OutputStream outputStream, String string2) {
        byte[] byArray = this.getPublicKeyBlob();
        byArray = Util.toBase64(byArray, 0, byArray.length);
        try {
            outputStream.write(this.getKeyTypeName());
            outputStream.write(space);
            outputStream.write(byArray, 0, byArray.length);
            outputStream.write(space);
            outputStream.write(Util.str2byte(string2));
            outputStream.write(cr);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void writePublicKey(String object, String string2) throws FileNotFoundException, IOException {
        object = new FileOutputStream((String)object);
        this.writePublicKey((OutputStream)object, string2);
        ((FileOutputStream)object).close();
    }

    public void writeSECSHPublicKey(OutputStream outputStream, String string2) {
        byte[] byArray = this.getPublicKeyBlob();
        byArray = Util.toBase64(byArray, 0, byArray.length);
        outputStream.write(Util.str2byte("---- BEGIN SSH2 PUBLIC KEY ----"));
        outputStream.write(cr);
        StringBuilder stringBuilder = new StringBuilder();
        outputStream.write(Util.str2byte(stringBuilder.append("Comment: \"").append(string2).append("\"").toString()));
        outputStream.write(cr);
        int n = 0;
        while (true) {
            if (n >= byArray.length) break;
            int n2 = 70;
            if (byArray.length - n < 70) {
                n2 = byArray.length - n;
            }
            outputStream.write(byArray, n, n2);
            outputStream.write(cr);
            n += n2;
            continue;
            break;
        }
        try {
            outputStream.write(Util.str2byte("---- END SSH2 PUBLIC KEY ----"));
            outputStream.write(cr);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void writeSECSHPublicKey(String object, String string2) throws FileNotFoundException, IOException {
        object = new FileOutputStream((String)object);
        this.writeSECSHPublicKey((OutputStream)object, string2);
        ((FileOutputStream)object).close();
    }

    int writeSEQUENCE(byte[] byArray, int n, int n2) {
        byArray[n] = 48;
        return this.writeLength(byArray, n + 1, n2);
    }

    class ASN1 {
        byte[] buf;
        int length;
        int start;
        final KeyPair this$0;

        ASN1(KeyPair keyPair, byte[] byArray) throws ASN1Exception {
            this(keyPair, byArray, 0, byArray.length);
        }

        ASN1(KeyPair keyPair, byte[] byArray, int n, int n2) throws ASN1Exception {
            this.this$0 = keyPair;
            this.buf = byArray;
            this.start = n;
            this.length = n2;
            if (n + n2 <= byArray.length) {
                return;
            }
            throw new ASN1Exception(keyPair);
        }

        private int getLength(int[] nArray) {
            int n = nArray[0];
            byte[] byArray = this.buf;
            int n2 = n + 1;
            int n3 = n = byArray[n] & 0xFF;
            int n4 = n2;
            if ((n & 0x80) != 0) {
                int n5 = n & 0x7F;
                n = 0;
                while (true) {
                    n3 = n;
                    n4 = ++n2;
                    if (n5 <= 0) break;
                    n = (n << 8) + (this.buf[n2] & 0xFF);
                    --n5;
                }
            }
            nArray[0] = n4;
            return n3;
        }

        byte[] getContent() {
            Object[] objectArray = new int[]{this.start + 1};
            int n = this.getLength((int[])objectArray);
            int n2 = objectArray[0];
            objectArray = new byte[n];
            System.arraycopy(this.buf, n2, objectArray, 0, objectArray.length);
            return objectArray;
        }

        ASN1[] getContents() throws ASN1Exception {
            int n = this.buf[this.start];
            Object[] objectArray = new int[]{this.start + 1};
            int n2 = this.getLength((int[])objectArray);
            if (n == 5) {
                return new ASN1[0];
            }
            n = objectArray[0];
            Vector<ASN1> vector = new Vector<ASN1>();
            while (n2 > 0) {
                int n3;
                objectArray[0] = n3 = n + 1;
                int n4 = this.getLength((int[])objectArray);
                int n5 = objectArray[0];
                vector.addElement(new ASN1(this.this$0, this.buf, n3 - 1, n5 - n3 + 1 + n4));
                n = n5 + n4;
                n2 = n2 - 1 - (n5 - n3) - n4;
            }
            objectArray = new ASN1[vector.size()];
            for (n2 = 0; n2 < vector.size(); ++n2) {
                objectArray[n2] = (int)((ASN1)vector.elementAt(n2));
            }
            return objectArray;
        }

        int getType() {
            return this.buf[this.start] & 0xFF;
        }

        boolean isINTEGER() {
            boolean bl = this.getType() == 2;
            return bl;
        }

        boolean isOBJECT() {
            boolean bl = this.getType() == 6;
            return bl;
        }

        boolean isOCTETSTRING() {
            boolean bl = this.getType() == 4;
            return bl;
        }

        boolean isSEQUENCE() {
            boolean bl = this.getType() == 48;
            return bl;
        }
    }

    class ASN1Exception
    extends Exception {
        final KeyPair this$0;

        ASN1Exception(KeyPair keyPair) {
            this.this$0 = keyPair;
        }
    }
}

