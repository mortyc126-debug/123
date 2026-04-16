/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.HASH;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SignatureDSA;
import com.jcraft.jsch.SignatureECDSA;
import com.jcraft.jsch.SignatureRSA;
import com.jcraft.jsch.Util;

public abstract class KeyExchange {
    static final int PROPOSAL_COMP_ALGS_CTOS = 6;
    static final int PROPOSAL_COMP_ALGS_STOC = 7;
    static final int PROPOSAL_ENC_ALGS_CTOS = 2;
    static final int PROPOSAL_ENC_ALGS_STOC = 3;
    static final int PROPOSAL_KEX_ALGS = 0;
    static final int PROPOSAL_LANG_CTOS = 8;
    static final int PROPOSAL_LANG_STOC = 9;
    static final int PROPOSAL_MAC_ALGS_CTOS = 4;
    static final int PROPOSAL_MAC_ALGS_STOC = 5;
    static final int PROPOSAL_MAX = 10;
    static final int PROPOSAL_SERVER_HOST_KEY_ALGS = 1;
    public static final int STATE_END = 0;
    static String enc_c2s;
    static String enc_s2c;
    static String kex;
    static String lang_c2s;
    static String lang_s2c;
    static String mac_c2s;
    static String mac_s2c;
    static String server_host_key;
    protected final int DSS;
    protected final int ECDSA;
    protected byte[] H = null;
    protected byte[] K = null;
    protected byte[] K_S = null;
    protected final int RSA;
    private String key_alg_name = "";
    protected Session session = null;
    protected HASH sha = null;
    private int type = 0;

    static {
        kex = "diffie-hellman-group1-sha1";
        server_host_key = "ssh-rsa,ssh-dss";
        enc_c2s = "blowfish-cbc";
        enc_s2c = "blowfish-cbc";
        mac_c2s = "hmac-md5";
        mac_s2c = "hmac-md5";
        lang_c2s = "";
        lang_s2c = "";
    }

    public KeyExchange() {
        this.RSA = 0;
        this.DSS = 1;
        this.ECDSA = 2;
    }

    protected static String[] guess(byte[] object, byte[] byArray) {
        int n;
        String[] stringArray = new String[10];
        object = new Buffer((byte[])object);
        ((Buffer)object).setOffSet(17);
        Buffer buffer = new Buffer(byArray);
        buffer.setOffSet(17);
        if (JSch.getLogger().isEnabled(1)) {
            for (n = 0; n < 10; ++n) {
                JSch.getLogger().log(1, "kex: server: " + Util.byte2str(((Buffer)object).getString()));
            }
            for (n = 0; n < 10; ++n) {
                JSch.getLogger().log(1, "kex: client: " + Util.byte2str(buffer.getString()));
            }
            ((Buffer)object).setOffSet(17);
            buffer.setOffSet(17);
        }
        for (int i = 0; i < 10; ++i) {
            int n2;
            byte[] byArray2 = ((Buffer)object).getString();
            byArray = buffer.getString();
            n = 0;
            int n3 = 0;
            block3: while (true) {
                n2 = n;
                if (n >= byArray.length) break;
                while (n < byArray.length && byArray[n] != 44) {
                    ++n;
                }
                if (n3 == n) {
                    return null;
                }
                String string2 = Util.byte2str(byArray, n3, n - n3);
                n3 = 0;
                n2 = 0;
                while (n3 < byArray2.length) {
                    while (n3 < byArray2.length && byArray2[n3] != 44) {
                        ++n3;
                    }
                    if (n2 == n3) {
                        return null;
                    }
                    if (string2.equals(Util.byte2str(byArray2, n2, n3 - n2))) {
                        stringArray[i] = string2;
                        n2 = n;
                        break block3;
                    }
                    n2 = ++n3;
                }
                n3 = ++n;
            }
            if (n2 == 0) {
                stringArray[i] = "";
                continue;
            }
            if (stringArray[i] != null) continue;
            return null;
        }
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "kex: server->client " + stringArray[3] + " " + stringArray[5] + " " + stringArray[7]);
            JSch.getLogger().log(1, "kex: client->server " + stringArray[2] + " " + stringArray[4] + " " + stringArray[6]);
        }
        return stringArray;
    }

    public String getFingerPrint() {
        HASH hASH = null;
        try {
            HASH hASH2;
            HASH hASH3 = hASH2 = (HASH)Class.forName(this.session.getConfig("md5")).newInstance();
            hASH = hASH2;
        }
        catch (Exception exception) {
            System.err.println("getFingerPrint: " + exception);
        }
        return Util.getFingerPrint(hASH, this.getHostKey());
    }

    byte[] getH() {
        return this.H;
    }

    HASH getHash() {
        return this.sha;
    }

    byte[] getHostKey() {
        return this.K_S;
    }

    byte[] getK() {
        return this.K;
    }

    public String getKeyAlgorithName() {
        return this.key_alg_name;
    }

    public String getKeyType() {
        if (this.type == 1) {
            return "DSA";
        }
        if (this.type == 0) {
            return "RSA";
        }
        return "ECDSA";
    }

    public abstract int getState();

    public abstract void init(Session var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5) throws Exception;

    public abstract boolean next(Buffer var1) throws Exception;

    protected byte[] normalize(byte[] byArray) {
        if (byArray.length > 1 && byArray[0] == 0 && (byArray[1] & 0x80) == 0) {
            byte[] byArray2 = new byte[byArray.length - 1];
            System.arraycopy(byArray, 1, byArray2, 0, byArray2.length);
            return this.normalize(byArray2);
        }
        return byArray;
    }

    protected boolean verify(String object, byte[] object2, int object3, byte[] byArray) throws Exception {
        boolean bl = false;
        if (((String)object).equals("ssh-rsa")) {
            this.type = 0;
            this.key_alg_name = object;
            int n = object3 + 1;
            object3 = object2[object3];
            int n2 = n + 1;
            byte by = object2[n];
            n = n2 + 1;
            byte by2 = object2[n2];
            n2 = n + 1;
            object3 = object3 << 24 & 0xFF000000 | by << 16 & 0xFF0000 | by2 << 8 & 0xFF00 | object2[n] & 0xFF;
            byte[] byArray2 = new byte[object3];
            System.arraycopy(object2, n2, byArray2, 0, object3);
            object3 = n2 + object3;
            n2 = object3 + 1;
            object3 = object2[object3];
            n = n2 + 1;
            by = object2[n2];
            n2 = n + 1;
            by2 = object2[n];
            n = n2 + 1;
            object3 = 0xFF00 & by2 << 8 | (0xFF0000 & by << 16 | 0xFF000000 & object3 << 24) | object2[n2] & 0xFF;
            byte[] byArray3 = new byte[object3];
            System.arraycopy(object2, n, byArray3, 0, object3);
            SignatureRSA signatureRSA = null;
            object = signatureRSA;
            object2 = (SignatureRSA)Class.forName(this.session.getConfig("signature.rsa")).newInstance();
            object = signatureRSA;
            signatureRSA = (SignatureRSA)object2;
            object = object2;
            try {
                object2.init();
                object = object2;
            }
            catch (Exception exception) {
                System.err.println(exception);
            }
            object.setPubKey(byArray2, byArray3);
            object.update(this.H);
            bl = object.verify(byArray);
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "ssh_rsa_verify: signature " + bl);
            }
        } else if (((String)object).equals("ssh-dss")) {
            this.type = 1;
            this.key_alg_name = object;
            int n = object3 + 1;
            object3 = object2[object3];
            Object object4 = n + 1;
            n = object2[n];
            int n3 = object4 + 1;
            Object object5 = object2[object4];
            object4 = n3 + 1;
            object3 = object3 << 24 & 0xFF000000 | n << 16 & 0xFF0000 | object5 << 8 & 0xFF00 | object2[n3] & 0xFF;
            byte[] byArray4 = new byte[object3];
            System.arraycopy(object2, object4, byArray4, 0, object3);
            object3 = object4 + object3;
            n = object3 + 1;
            object3 = object2[object3];
            object4 = n + 1;
            n3 = object2[n];
            n = object4 + 1;
            object5 = object2[object4];
            object4 = n + 1;
            object3 = object3 << 24 & 0xFF000000 | n3 << 16 & 0xFF0000 | object5 << 8 & 0xFF00 | object2[n] & 0xFF;
            byte[] byArray5 = new byte[object3];
            System.arraycopy(object2, object4, byArray5, 0, object3);
            object3 = object4 + object3;
            n = object3 + 1;
            object3 = object2[object3];
            object4 = n + 1;
            n = object2[n];
            n3 = object4 + 1;
            object5 = object2[object4];
            object4 = n3 + 1;
            object3 = object3 << 24 & 0xFF000000 | n << 16 & 0xFF0000 | object5 << 8 & 0xFF00 | object2[n3] & 0xFF;
            byte[] byArray6 = new byte[object3];
            System.arraycopy(object2, object4, byArray6, 0, object3);
            object3 = object4 + object3;
            n = object3 + 1;
            object3 = object2[object3];
            n3 = n + 1;
            object4 = object2[n];
            n = n3 + 1;
            object5 = object2[n3];
            n3 = n + 1;
            object3 = 0xFF00 & object5 << 8 | (0xFF0000 & object4 << 16 | 0xFF000000 & object3 << 24) | object2[n] & 0xFF;
            byte[] byArray7 = new byte[object3];
            System.arraycopy(object2, n3, byArray7, 0, object3);
            SignatureDSA signatureDSA = null;
            object = signatureDSA;
            object2 = (SignatureDSA)Class.forName(this.session.getConfig("signature.dss")).newInstance();
            object = signatureDSA;
            signatureDSA = (SignatureDSA)object2;
            object = object2;
            try {
                object2.init();
                object = object2;
            }
            catch (Exception exception) {
                System.err.println(exception);
            }
            object.setPubKey(byArray7, byArray4, byArray5, byArray6);
            object.update(this.H);
            bl = object.verify(byArray);
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "ssh_dss_verify: signature " + bl);
            }
        } else if (!(((String)object).equals("ecdsa-sha2-nistp256") || ((String)object).equals("ecdsa-sha2-nistp384") || ((String)object).equals("ecdsa-sha2-nistp521"))) {
            System.err.println("unknown alg");
        } else {
            this.type = 2;
            this.key_alg_name = object;
            int n = object3 + 1;
            object3 = object2[object3];
            int n4 = n + 1;
            byte by = object2[n];
            n = n4 + 1;
            byte by3 = object2[n4];
            n4 = n + 1;
            object3 = object3 << 24 & 0xFF000000 | by << 16 & 0xFF0000 | by3 << 8 & 0xFF00 | object2[n] & 0xFF;
            System.arraycopy(object2, n4, new byte[object3], 0, object3);
            object3 = n4 + object3;
            n4 = object3 + 1;
            n = object2[object3];
            object3 = n4 + 1;
            by = object2[n4];
            n4 = object3 + 1;
            object3 = 0xFF00 & object2[object3] << 8 | (0xFF0000 & by << 16 | 0xFF000000 & n << 24) | object2[n4] & 0xFF;
            n = n4 + 1 + 1;
            byte[] byArray8 = new byte[(object3 - 1) / 2];
            System.arraycopy(object2, n, byArray8, 0, byArray8.length);
            byte[] byArray9 = new byte[(object3 - 1) / 2];
            System.arraycopy(object2, n += (object3 - 1) / 2, byArray9, 0, byArray9.length);
            object3 = (object3 - 1) / 2;
            SignatureECDSA signatureECDSA = null;
            object2 = signatureECDSA;
            object = (SignatureECDSA)Class.forName(this.session.getConfig((String)object)).newInstance();
            object2 = signatureECDSA;
            signatureECDSA = (SignatureECDSA)object;
            object2 = object;
            try {
                object.init();
            }
            catch (Exception exception) {
                System.err.println(exception);
                object = object2;
            }
            object.setPubKey(byArray8, byArray9);
            object.update(this.H);
            bl = object.verify(byArray);
        }
        return bl;
    }
}

