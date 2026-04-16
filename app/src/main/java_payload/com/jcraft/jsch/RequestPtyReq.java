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

class RequestPtyReq
extends Request {
    private int tcol = 80;
    private byte[] terminal_mode = Util.empty;
    private int thp = 480;
    private int trow = 24;
    private String ttype = "vt100";
    private int twp = 640;

    RequestPtyReq() {
    }

    @Override
    public void request(Session object, Channel channel) throws Exception {
        super.request((Session)object, channel);
        Buffer buffer = new Buffer();
        object = new Packet(buffer);
        ((Packet)object).reset();
        buffer.putByte((byte)98);
        buffer.putInt(channel.getRecipient());
        buffer.putString(Util.str2byte("pty-req"));
        buffer.putByte((byte)(this.waitForReply() ? 1 : 0));
        buffer.putString(Util.str2byte(this.ttype));
        buffer.putInt(this.tcol);
        buffer.putInt(this.trow);
        buffer.putInt(this.twp);
        buffer.putInt(this.thp);
        buffer.putString(this.terminal_mode);
        this.write((Packet)object);
    }

    void setCode(String string2) {
    }

    void setTSize(int n, int n2, int n3, int n4) {
        this.tcol = n;
        this.trow = n2;
        this.twp = n3;
        this.thp = n4;
    }

    void setTType(String string2) {
        this.ttype = string2;
    }

    void setTerminalMode(byte[] byArray) {
        this.terminal_mode = byArray;
    }
}

