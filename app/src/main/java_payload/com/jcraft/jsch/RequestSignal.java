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

class RequestSignal
extends Request {
    private String signal = "KILL";

    RequestSignal() {
    }

    @Override
    public void request(Session object, Channel channel) throws Exception {
        super.request((Session)object, channel);
        object = new Buffer();
        Packet packet = new Packet((Buffer)object);
        packet.reset();
        ((Buffer)object).putByte((byte)98);
        ((Buffer)object).putInt(channel.getRecipient());
        ((Buffer)object).putString(Util.str2byte("signal"));
        ((Buffer)object).putByte((byte)(this.waitForReply() ? 1 : 0));
        ((Buffer)object).putString(Util.str2byte(this.signal));
        this.write(packet);
    }

    public void setSignal(String string2) {
        this.signal = string2;
    }
}

