/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.IO;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Util;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelDirectTCPIP
extends Channel {
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
    private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
    private static final byte[] _type = Util.str2byte("direct-tcpip");
    String host;
    String originator_IP_address = "127.0.0.1";
    int originator_port = 0;
    int port;

    ChannelDirectTCPIP() {
        this.type = _type;
        this.setLocalWindowSizeMax(131072);
        this.setLocalWindowSize(131072);
        this.setLocalPacketSize(16384);
    }

    @Override
    public void connect(int n) throws JSchException {
        Exception exception2;
        block7: {
            block6: {
                this.connectTimeout = n;
                try {
                    Object object = this.getSession();
                    if (((Session)object).isConnected()) {
                        if (this.io.in != null) {
                            Thread thread;
                            thread = this.thread = (thread = new Thread(this));
                            StringBuilder stringBuilder = new StringBuilder();
                            thread.setName(stringBuilder.append("DirectTCPIP thread ").append(((Session)object).getHost()).toString());
                            if (((Session)object).daemon_thread) {
                                this.thread.setDaemon(((Session)object).daemon_thread);
                            }
                            this.thread.start();
                        } else {
                            this.sendChannelOpen();
                        }
                        break block6;
                    }
                    object = new JSchException("session is down");
                    throw object;
                }
                catch (Exception exception2) {
                    this.io.close();
                    this.io = null;
                    Channel.del(this);
                    if (exception2 instanceof JSchException) break block7;
                }
            }
            return;
        }
        throw (JSchException)exception2;
    }

    @Override
    protected Packet genChannelOpenPacket() {
        Buffer buffer = new Buffer(this.host.length() + 50 + this.originator_IP_address.length() + 128);
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte)90);
        buffer.putString(this.type);
        buffer.putInt(this.id);
        buffer.putInt(this.lwsize);
        buffer.putInt(this.lmpsize);
        buffer.putString(Util.str2byte(this.host));
        buffer.putInt(this.port);
        buffer.putString(Util.str2byte(this.originator_IP_address));
        buffer.putInt(this.originator_port);
        return packet;
    }

    @Override
    void init() {
        this.io = new IO();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        Session session;
        Packet packet;
        Buffer buffer;
        try {
            this.sendChannelOpen();
            buffer = new Buffer(this.rmpsize);
            packet = new Packet(buffer);
            session = this.getSession();
        }
        catch (Exception exception) {
            if (!this.connected) {
                this.connected = true;
            }
            this.disconnect();
            return;
        }
        while (this.isConnected() && this.thread != null && this.io != null && this.io.in != null) {
            int n = this.io.in.read(buffer.buffer, 14, buffer.buffer.length - 14 - 128);
            if (n <= 0) {
                this.eof();
                break;
            }
            packet.reset();
            buffer.putByte((byte)94);
            buffer.putInt(this.recipient);
            buffer.putInt(n);
            buffer.skip(n);
            synchronized (this) {
                if (this.close) {
                    break;
                }
                session.write(packet, this, n);
            }
        }
        this.eof();
        this.disconnect();
    }

    public void setHost(String string2) {
        this.host = string2;
    }

    @Override
    public void setInputStream(InputStream inputStream) {
        this.io.setInputStream(inputStream);
    }

    public void setOrgIPAddress(String string2) {
        this.originator_IP_address = string2;
    }

    public void setOrgPort(int n) {
        this.originator_port = n;
    }

    @Override
    public void setOutputStream(OutputStream outputStream) {
        this.io.setOutputStream(outputStream);
    }

    public void setPort(int n) {
        this.port = n;
    }
}

