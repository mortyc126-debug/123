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

public class RequestSftp
extends Request {
    RequestSftp() {
        this.setReply(true);
    }

    @Override
    public void request(Session object, Channel channel) throws Exception {
        super.request((Session)object, channel);
        object = new Buffer();
        Packet packet = new Packet((Buffer)object);
        packet.reset();
        ((Buffer)object).putByte((byte)98);
        ((Buffer)object).putInt(channel.getRecipient());
        ((Buffer)object).putString(Util.str2byte("subsystem"));
        ((Buffer)object).putByte((byte)(this.waitForReply() ? 1 : 0));
        ((Buffer)object).putString(Util.str2byte("sftp"));
        this.write(packet);
    }
}

