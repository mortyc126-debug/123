/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.ECDH;
import com.jcraft.jsch.HASH;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.KeyExchange;
import com.jcraft.jsch.KeyPairECDSA;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Util;

public abstract class DHECN
extends KeyExchange {
    private static final int SSH_MSG_KEX_ECDH_INIT = 30;
    private static final int SSH_MSG_KEX_ECDH_REPLY = 31;
    byte[] I_C;
    byte[] I_S;
    byte[] Q_C;
    byte[] V_C;
    byte[] V_S;
    private Buffer buf;
    byte[] e;
    private ECDH ecdh;
    protected int key_size;
    private Packet packet;
    protected String sha_name;
    private int state;

    @Override
    public int getState() {
        return this.state;
    }

    @Override
    public void init(Session session, byte[] byArray, byte[] object, byte[] object2, byte[] byArray2) throws Exception {
        block6: {
            this.session = session;
            this.V_S = byArray;
            this.V_C = object;
            this.I_S = object2;
            this.I_C = byArray2;
            try {
                object = (HASH)Class.forName(session.getConfig(this.sha_name)).newInstance();
                object2 = (HASH)object;
                this.sha = object;
                this.sha.init();
            }
            catch (Exception exception) {
                System.err.println(exception);
            }
            this.buf = new Buffer();
            this.packet = new Packet(this.buf);
            this.packet.reset();
            this.buf.putByte((byte)30);
            try {
                object2 = (ECDH)Class.forName(session.getConfig("ecdh-sha2-nistp")).newInstance();
                object = (ECDH)object2;
                this.ecdh = object2;
                this.ecdh.init(this.key_size);
                this.Q_C = this.ecdh.getQ();
                this.buf.putString(this.Q_C);
                if (byArray != null) break block6;
                return;
            }
            catch (Exception exception) {
                if (exception instanceof Throwable) {
                    throw new JSchException(exception.toString(), exception);
                }
                throw new JSchException(exception.toString());
            }
        }
        session.write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_KEX_ECDH_INIT sent");
            JSch.getLogger().log(1, "expecting SSH_MSG_KEX_ECDH_REPLY");
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
        byte[] byArray = ((Buffer)object).getString();
        byte[][] byArray2 = KeyPairECDSA.fromPoint(byArray);
        if (!this.ecdh.validate(byArray2[0], byArray2[1])) {
            return false;
        }
        this.K = this.ecdh.getSecret(byArray2[0], byArray2[1]);
        this.K = this.normalize(this.K);
        object = ((Buffer)object).getString();
        this.buf.reset();
        this.buf.putString(this.V_C);
        this.buf.putString(this.V_S);
        this.buf.putString(this.I_C);
        this.buf.putString(this.I_S);
        this.buf.putString(this.K_S);
        this.buf.putString(this.Q_C);
        this.buf.putString(byArray);
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

