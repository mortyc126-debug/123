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

class RequestExec
extends Request {
    private byte[] command = new byte[0];

    RequestExec(byte[] byArray) {
        this.command = byArray;
    }

    @Override
    public void request(Session object, Channel channel) throws Exception {
        super.request((Session)object, channel);
        object = new Buffer();
        Packet packet = new Packet((Buffer)object);
        packet.reset();
        ((Buffer)object).putByte((byte)98);
        ((Buffer)object).putInt(channel.getRecipient());
        ((Buffer)object).putString(Util.str2byte("exec"));
        ((Buffer)object).putByte((byte)(this.waitForReply() ? 1 : 0));
        ((Buffer)object).checkFreeSize(this.command.length + 4);
        ((Buffer)object).putString(this.command);
        this.write(packet);
    }
}

