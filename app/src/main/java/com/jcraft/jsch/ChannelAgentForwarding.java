/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Identity;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Util;
import java.io.IOException;

class ChannelAgentForwarding
extends Channel {
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
    private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
    private final byte SSH2_AGENTC_ADD_IDENTITY;
    private final byte SSH2_AGENTC_REMOVE_ALL_IDENTITIES;
    private final byte SSH2_AGENTC_REMOVE_IDENTITY;
    private final byte SSH2_AGENTC_REQUEST_IDENTITIES;
    private final byte SSH2_AGENTC_SIGN_REQUEST;
    private final byte SSH2_AGENT_FAILURE;
    private final byte SSH2_AGENT_IDENTITIES_ANSWER;
    private final byte SSH2_AGENT_SIGN_RESPONSE;
    private final byte SSH_AGENTC_ADD_RSA_IDENTITY;
    private final byte SSH_AGENTC_REMOVE_ALL_RSA_IDENTITIES;
    private final byte SSH_AGENTC_REMOVE_RSA_IDENTITY;
    private final byte SSH_AGENTC_REQUEST_RSA_IDENTITIES;
    private final byte SSH_AGENTC_RSA_CHALLENGE;
    private final byte SSH_AGENT_FAILURE;
    private final byte SSH_AGENT_RSA_IDENTITIES_ANSWER = (byte)2;
    private final byte SSH_AGENT_RSA_RESPONSE;
    private final byte SSH_AGENT_SUCCESS;
    boolean init = true;
    private Buffer mbuf = null;
    private Packet packet = null;
    private Buffer rbuf = null;
    private Buffer wbuf = null;

    ChannelAgentForwarding() {
        this.SSH_AGENTC_REQUEST_RSA_IDENTITIES = 1;
        this.SSH_AGENTC_RSA_CHALLENGE = (byte)3;
        this.SSH_AGENT_RSA_RESPONSE = (byte)4;
        this.SSH_AGENT_FAILURE = (byte)5;
        this.SSH_AGENT_SUCCESS = (byte)6;
        this.SSH_AGENTC_ADD_RSA_IDENTITY = (byte)7;
        this.SSH_AGENTC_REMOVE_RSA_IDENTITY = (byte)8;
        this.SSH_AGENTC_REMOVE_ALL_RSA_IDENTITIES = (byte)9;
        this.SSH2_AGENTC_REQUEST_IDENTITIES = (byte)11;
        this.SSH2_AGENT_IDENTITIES_ANSWER = (byte)12;
        this.SSH2_AGENTC_SIGN_REQUEST = (byte)13;
        this.SSH2_AGENT_SIGN_RESPONSE = (byte)14;
        this.SSH2_AGENTC_ADD_IDENTITY = (byte)17;
        this.SSH2_AGENTC_REMOVE_IDENTITY = (byte)18;
        this.SSH2_AGENTC_REMOVE_ALL_IDENTITIES = (byte)19;
        this.SSH2_AGENT_FAILURE = (byte)30;
        this.setLocalWindowSizeMax(131072);
        this.setLocalWindowSize(131072);
        this.setLocalPacketSize(16384);
        this.type = Util.str2byte("auth-agent@openssh.com");
        this.rbuf = new Buffer();
        this.rbuf.reset();
        this.mbuf = new Buffer();
        this.connected = true;
    }

    private void send(byte[] byArray) {
        this.packet.reset();
        this.wbuf.putByte((byte)94);
        this.wbuf.putInt(this.recipient);
        this.wbuf.putInt(byArray.length + 4);
        this.wbuf.putString(byArray);
        try {
            this.getSession().write(this.packet, this, byArray.length + 4);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    void eof_remote() {
        super.eof_remote();
        this.eof();
    }

    @Override
    public void run() {
        try {
            this.sendOpenConfirmation();
        }
        catch (Exception exception) {
            this.close = true;
            this.disconnect();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    void write(byte[] var1_1, int var2_3, int var3_4) throws IOException {
        if (this.packet == null) {
            this.wbuf = new Buffer(this.rmpsize);
            this.packet = new Packet(this.wbuf);
        }
        this.rbuf.shift();
        if (this.rbuf.buffer.length < this.rbuf.index + var3_4) {
            var7_5 /* !! */  = new byte[this.rbuf.s + var3_4];
            System.arraycopy(this.rbuf.buffer, 0, var7_5 /* !! */ , 0, this.rbuf.buffer.length);
            this.rbuf.buffer = var7_5 /* !! */ ;
        }
        this.rbuf.putByte((byte[])var1_1, var2_3, var3_4);
        if (this.rbuf.getInt() > this.rbuf.getLength()) {
            var1_1 = this.rbuf;
            var1_1.s -= 4;
            return;
        }
        var2_3 = this.rbuf.getByte();
        try {
            var7_5 /* !! */  = (byte[])this.getSession();
        }
        catch (JSchException var1_2) {
            throw new IOException(var1_2.toString());
        }
        var1_1 = var7_5 /* !! */ .getIdentityRepository();
        var10_6 = var7_5 /* !! */ .getUserInfo();
        this.mbuf.reset();
        if (var2_3 == 11) {
            this.mbuf.putByte((byte)12);
            var1_1 = var1_1.getIdentities();
            synchronized (var1_1) {
                var5_7 = 0;
                for (var2_3 = 0; var2_3 < var1_1.size(); ++var2_3) {
                    var7_5 /* !! */  = (Identity)var1_1.elementAt(var2_3);
                    var8_8 = (Identity)var7_5 /* !! */ ;
                    var3_4 = var5_7;
                    if (var7_5 /* !! */ .getPublicKeyBlob() != null) {
                        var3_4 = var5_7 + 1;
                    }
                    var5_7 = var3_4;
                }
                this.mbuf.putInt(var5_7);
                for (var2_3 = 0; var2_3 < var1_1.size(); ++var2_3) {
                    var8_8 = (Identity)var1_1.elementAt(var2_3);
                    var7_5 /* !! */  = var8_8;
                    var7_5 /* !! */  = var8_8.getPublicKeyBlob();
                    if (var7_5 /* !! */  == null) continue;
                    this.mbuf.putString(var7_5 /* !! */ );
                    this.mbuf.putString(Util.empty);
                }
            }
        } else if (var2_3 == 1) {
            this.mbuf.putByte((byte)2);
            this.mbuf.putInt(0);
        } else if (var2_3 == 13) {
            var11_10 = this.rbuf.getString();
            var8_9 = this.rbuf.getString();
            this.rbuf.getInt();
            var9_11 = var1_1.getIdentities();
            var7_5 /* !! */  = null;
            synchronized (var9_11) {
                var2_3 = 0;
                while (true) {
                    var1_1 = var7_5 /* !! */ ;
                    if (var2_3 >= var9_11.size()) break;
                    var1_1 = (Identity)var9_11.elementAt(var2_3);
                    var12_14 = (Identity)var1_1;
                    if (var1_1.getPublicKeyBlob() != null && Util.array_equals(var11_10, var1_1.getPublicKeyBlob())) {
                        if (var1_1.isEncrypted()) {
                            if (var10_6 != null) {
                                while (var1_1.isEncrypted() && var10_6.promptPassphrase((var12_14 = new StringBuilder()).append("Passphrase for ").append(var1_1.getName()).toString()) && (var12_14 = var10_6.getPassphrase()) != null) {
                                    var12_14 = Util.str2byte((String)var12_14);
                                    try {
                                        var6_12 = var1_1.setPassphrase((byte[])var12_14);
                                        if (!var6_12) continue;
                                        ** break;
                                    }
                                    catch (JSchException var12_15) {
                                        // empty catch block
                                        ** break;
                                    }
                                }
                            }
                        } else if (!var1_1.isEncrypted()) break;
                    }
                    ++var2_3;
                }
            }
            var7_5 /* !! */  = null;
            if (var1_1 != null) {
                var7_5 /* !! */  = var1_1.getSignature(var8_9);
            }
            if (var7_5 /* !! */  == null) {
                this.mbuf.putByte((byte)30);
            } else {
                this.mbuf.putByte((byte)14);
                this.mbuf.putString(var7_5 /* !! */ );
            }
        } else {
            var4_16 = 6;
            if (var2_3 == 18) {
                var1_1.remove(this.rbuf.getString());
                this.mbuf.putByte((byte)6);
            } else if (var2_3 == 9) {
                this.mbuf.putByte((byte)6);
            } else if (var2_3 == 19) {
                var1_1.removeAll();
                this.mbuf.putByte((byte)6);
            } else if (var2_3 == 17) {
                var7_5 /* !! */  = new byte[this.rbuf.getLength()];
                this.rbuf.getByte(var7_5 /* !! */ );
                var6_13 = var1_1.add(var7_5 /* !! */ );
                var1_1 = this.mbuf;
                if (!var6_13) {
                    var4_16 = 5;
                }
                var1_1.putByte(var4_16);
            } else {
                this.rbuf.skip(this.rbuf.getLength() - 1);
                this.mbuf.putByte((byte)5);
            }
        }
        var1_1 = new byte[this.mbuf.getLength()];
        this.mbuf.getByte((byte[])var1_1);
        this.send((byte[])var1_1);
    }
}

