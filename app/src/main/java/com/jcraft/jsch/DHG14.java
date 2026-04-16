/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.DH;
import com.jcraft.jsch.HASH;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.KeyExchange;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Util;

public class DHG14
extends KeyExchange {
    private static final int SSH_MSG_KEXDH_INIT = 30;
    private static final int SSH_MSG_KEXDH_REPLY = 31;
    static final byte[] g = new byte[]{2};
    static final byte[] p = new byte[]{0, -1, -1, -1, -1, -1, -1, -1, -1, -55, 15, -38, -94, 33, 104, -62, 52, -60, -58, 98, -117, -128, -36, 28, -47, 41, 2, 78, 8, -118, 103, -52, 116, 2, 11, -66, -90, 59, 19, -101, 34, 81, 74, 8, 121, -114, 52, 4, -35, -17, -107, 25, -77, -51, 58, 67, 27, 48, 43, 10, 109, -14, 95, 20, 55, 79, -31, 53, 109, 109, 81, -62, 69, -28, -123, -75, 118, 98, 94, 126, -58, -12, 76, 66, -23, -90, 55, -19, 107, 11, -1, 92, -74, -12, 6, -73, -19, -18, 56, 107, -5, 90, -119, -97, -91, -82, -97, 36, 17, 124, 75, 31, -26, 73, 40, 102, 81, -20, -28, 91, 61, -62, 0, 124, -72, -95, 99, -65, 5, -104, -38, 72, 54, 28, 85, -45, -102, 105, 22, 63, -88, -3, 36, -49, 95, -125, 101, 93, 35, -36, -93, -83, -106, 28, 98, -13, 86, 32, -123, 82, -69, -98, -43, 41, 7, 112, -106, -106, 109, 103, 12, 53, 78, 74, -68, -104, 4, -15, 116, 108, 8, -54, 24, 33, 124, 50, -112, 94, 70, 46, 54, -50, 59, -29, -98, 119, 44, 24, 14, -122, 3, -101, 39, -125, -94, -20, 7, -94, -113, -75, -59, 93, -16, 111, 76, 82, -55, -34, 43, -53, -10, -107, 88, 23, 24, 57, -107, 73, 124, -22, -107, 106, -27, 21, -46, 38, 24, -104, -6, 5, 16, 21, 114, -114, 90, -118, -84, -86, 104, -1, -1, -1, -1, -1, -1, -1, -1};
    byte[] I_C;
    byte[] I_S;
    byte[] V_C;
    byte[] V_S;
    private Buffer buf;
    DH dh;
    byte[] e;
    private Packet packet;
    private int state;

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void init(Session session, byte[] byArray, byte[] object, byte[] object2, byte[] byArray2) throws Exception {
        this.session = session;
        this.V_S = byArray;
        this.V_C = object;
        this.I_S = object2;
        this.I_C = byArray2;
        try {
            object = (HASH)Class.forName(session.getConfig("sha-1")).newInstance();
            object2 = (HASH)object;
            this.sha = object;
            this.sha.init();
        }
        catch (Exception exception) {
            System.err.println(exception);
        }
        this.buf = new Buffer();
        this.packet = new Packet(this.buf);
        object2 = (DH)Class.forName(session.getConfig("dh")).newInstance();
        object = (DH)object2;
        this.dh = object2;
        this.dh.init();
        this.dh.setP(p);
        this.dh.setG(g);
        this.e = this.dh.getE();
        this.packet.reset();
        this.buf.putByte((byte)30);
        this.buf.putMPInt(this.e);
        if (byArray == null) {
            return;
        }
        session.write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_KEXDH_INIT sent");
            JSch.getLogger().log(1, "expecting SSH_MSG_KEXDH_REPLY");
        }
        this.state = 31;
    }

    @Override
    public boolean next(Buffer object) throws Exception {
        switch (this.state) {
            default: {
                return false;
            }
            case 31: 
        }
        ((Buffer)object).getInt();
        ((Buffer)object).getByte();
        int n = ((Buffer)object).getByte();
        if (n != 31) {
            System.err.println("type: must be 31 " + n);
            return false;
        }
        this.K_S = ((Buffer)object).getString();
        byte[] byArray = ((Buffer)object).getMPInt();
        object = ((Buffer)object).getString();
        this.dh.setF(byArray);
        this.dh.checkRange();
        this.K = this.normalize(this.dh.getK());
        this.buf.reset();
        this.buf.putString(this.V_C);
        this.buf.putString(this.V_S);
        this.buf.putString(this.I_C);
        this.buf.putString(this.I_S);
        this.buf.putString(this.K_S);
        this.buf.putMPInt(this.e);
        this.buf.putMPInt(byArray);
        this.buf.putMPInt(this.K);
        byArray = new byte[this.buf.getLength()];
        this.buf.getByte(byArray);
        this.sha.update(byArray, 0, byArray.length);
        this.H = this.sha.digest();
        byArray = this.K_S;
        int n2 = 0 + 1;
        n = byArray[0];
        byArray = this.K_S;
        int n3 = n2 + 1;
        byte by = byArray[n2];
        byArray = this.K_S;
        n2 = n3 + 1;
        byte by2 = byArray[n3];
        byArray = this.K_S;
        n3 = n2 + 1;
        n = n << 24 & 0xFF000000 | by << 16 & 0xFF0000 | by2 << 8 & 0xFF00 | byArray[n2] & 0xFF;
        boolean bl = this.verify(Util.byte2str(this.K_S, n3, n), this.K_S, n3 + n, (byte[])object);
        this.state = 0;
        return bl;
    }
}

