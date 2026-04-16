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

class RequestShell
extends Request {
    RequestShell() {
    }

    @Override
    public void request(Session object, Channel channel) throws Exception {
        super.request((Session)object, channel);
        Buffer buffer = new Buffer();
        object = new Packet(buffer);
        ((Packet)object).reset();
        buffer.putByte((byte)98);
        buffer.putInt(channel.getRecipient());
        buffer.putString(Util.str2byte("shell"));
        buffer.putByte((byte)(this.waitForReply() ? 1 : 0));
        this.write((Packet)object);
    }
}

