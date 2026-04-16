/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Session;

abstract class Request {
    private Channel channel = null;
    private boolean reply = false;
    private Session session = null;

    Request() {
    }

    void request(Session session, Channel channel) throws Exception {
        this.session = session;
        this.channel = channel;
        if (channel.connectTimeout > 0) {
            this.setReply(true);
        }
    }

    void setReply(boolean bl) {
        this.reply = bl;
    }

    boolean waitForReply() {
        return this.reply;
    }

    void write(Packet packet) throws Exception {
        if (this.reply) {
            this.channel.reply = -1;
        }
        this.session.write(packet);
        if (this.reply) {
            long l = System.currentTimeMillis();
            long l2 = this.channel.connectTimeout;
            while (this.channel.isConnected() && this.channel.reply == -1) {
                try {
                    Thread.sleep(10L);
                }
                catch (Exception exception) {
                    // empty catch block
                }
                if (l2 <= 0L || System.currentTimeMillis() - l <= l2) continue;
                this.channel.reply = 0;
                throw new JSchException("channel request: timeout");
            }
            if (this.channel.reply == 0) {
                throw new JSchException("failed to send channel request");
            }
        }
    }
}

