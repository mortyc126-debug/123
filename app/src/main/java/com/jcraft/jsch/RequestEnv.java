/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Request;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Util;

class RequestEnv
extends Request {
    byte[] name = new byte[0];
    byte[] value = new byte[0];

    RequestEnv() {
    }

    @Override
    public void request(Session object, Channel channel) throws Exception {
        super.request((Session)object, channel);
        object = new Buffer();
        Packet packet = new Packet((Buffer)object);
        packet.reset();
        ((Buffer)object).putByte((byte)98);
        ((Buffer)object).putInt(channel.getRecipient());
        ((Buffer)object).putString(Util.str2byte("env"));
        ((Buffer)object).putByte((byte)(this.waitForReply() ? 1 : 0));
        ((Buffer)object).putString(this.name);
        ((Buffer)object).putString(this.value);
        this.write(packet);
    }

    void setEnv(byte[] byArray, byte[] byArray2) {
        this.name = byArray;
        this.value = byArray2;
    }
}

