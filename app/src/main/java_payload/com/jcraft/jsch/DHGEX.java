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

public class DHGEX
extends KeyExchange {
    private static final int SSH_MSG_KEX_DH_GEX_GROUP = 31;
    private static final int SSH_MSG_KEX_DH_GEX_INIT = 32;
    private static final int SSH_MSG_KEX_DH_GEX_REPLY = 33;
    private static final int SSH_MSG_KEX_DH_GEX_REQUEST = 34;
    static int min = 1024;
    static int preferred = 1024;
    byte[] I_C;
    byte[] I_S;
    byte[] V_C;
    byte[] V_S;
    private Buffer buf;
    DH dh;
    private byte[] e;
    private byte[] g;
    protected String hash = "sha-1";
    int max = 1024;
    private byte[] p;
    private Packet packet;
    private int state;

    protected int check2048(Class object, int n) throws Exception {
        object = (DH)((Class)object).newInstance();
        object.init();
        byte[] byArray = new byte[257];
        byArray[1] = -35;
        byArray[256] = 115;
        object.setP(byArray);
        object.setG(new byte[]{2});
        try {
            object.getE();
            n = 2048;
        }
        catch (Exception exception) {}
        return n;
    }

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void init(Session session, byte[] object, byte[] object2, byte[] byArray, byte[] byArray2) throws Exception {
        int n;
        this.session = session;
        this.V_S = object;
        this.V_C = object2;
        this.I_S = byArray;
        this.I_C = byArray2;
        try {
            object2 = (HASH)Class.forName(session.getConfig(this.hash)).newInstance();
            object = (HASH)object2;
            this.sha = object2;
            this.sha.init();
        }
        catch (Exception exception) {
            System.err.println(exception);
        }
        this.buf = new Buffer();
        this.packet = new Packet(this.buf);
        object = Class.forName(session.getConfig("dh"));
        this.max = n = this.check2048((Class)object, this.max);
        preferred = n;
        object2 = (DH)((Class)object).newInstance();
        object = (DH)object2;
        this.dh = object2;
        this.dh.init();
        this.packet.reset();
        this.buf.putByte((byte)34);
        this.buf.putInt(min);
        this.buf.putInt(preferred);
        this.buf.putInt(this.max);
        session.write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_KEX_DH_GEX_REQUEST(" + min + "<" + preferred + "<" + this.max + ") sent");
            JSch.getLogger().log(1, "expecting SSH_MSG_KEX_DH_GEX_GROUP");
        }
        this.state = 31;
    }

    @Override
    public boolean next(Buffer object) throws Exception {
        switch (this.state) {
            default: {
                return false;
            }
            case 33: {
                ((Buffer)object).getInt();
                ((Buffer)object).getByte();
                int n = ((Buffer)object).getByte();
                if (n != 33) {
                    System.err.println("type: must be SSH_MSG_KEX_DH_GEX_REPLY " + n);
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
                this.buf.putInt(min);
                this.buf.putInt(preferred);
                this.buf.putInt(this.max);
                this.buf.putMPInt(this.p);
                this.buf.putMPInt(this.g);
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
            case 31: 
        }
        ((Buffer)object).getInt();
        ((Buffer)object).getByte();
        int n = ((Buffer)object).getByte();
        if (n != 31) {
            System.err.println("type: must be SSH_MSG_KEX_DH_GEX_GROUP " + n);
            return false;
        }
        this.p = ((Buffer)object).getMPInt();
        this.g = ((Buffer)object).getMPInt();
        this.dh.setP(this.p);
        this.dh.setG(this.g);
        this.e = this.dh.getE();
        this.packet.reset();
        this.buf.putByte((byte)32);
        this.buf.putMPInt(this.e);
        this.session.write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_KEX_DH_GEX_INIT sent");
            JSch.getLogger().log(1, "expecting SSH_MSG_KEX_DH_GEX_REPLY");
        }
        this.state = 33;
        return true;
    }
}

