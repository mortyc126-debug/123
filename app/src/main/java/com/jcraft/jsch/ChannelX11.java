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
import java.io.IOException;
import java.net.Socket;
import java.util.Hashtable;

class ChannelX11
extends Channel {
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
    private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
    private static final int TIMEOUT = 10000;
    static byte[] cookie;
    private static byte[] cookie_hex;
    private static Hashtable faked_cookie_hex_pool;
    private static Hashtable faked_cookie_pool;
    private static String host;
    private static int port;
    private static byte[] table;
    private byte[] cache = new byte[0];
    private boolean init = true;
    private Socket socket = null;

    static {
        host = "127.0.0.1";
        port = 6000;
        cookie = null;
        cookie_hex = null;
        faked_cookie_pool = new Hashtable();
        faked_cookie_hex_pool = new Hashtable();
        table = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    }

    ChannelX11() {
        this.setLocalWindowSizeMax(131072);
        this.setLocalWindowSize(131072);
        this.setLocalPacketSize(16384);
        this.type = Util.str2byte("x11");
        this.connected = true;
    }

    private byte[] addCache(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[this.cache.length + n2];
        System.arraycopy(byArray, n, byArray2, this.cache.length, n2);
        if (this.cache.length > 0) {
            System.arraycopy(this.cache, 0, byArray2, 0, this.cache.length);
        }
        this.cache = byArray2;
        return this.cache;
    }

    private static boolean equals(byte[] byArray, byte[] byArray2) {
        if (byArray.length != byArray2.length) {
            return false;
        }
        for (int i = 0; i < byArray.length; ++i) {
            if (byArray[i] == byArray2[i]) continue;
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static byte[] getFakedCookie(Session session) {
        Hashtable hashtable = faked_cookie_hex_pool;
        synchronized (hashtable) {
            byte[] byArray;
            Object object = byArray = (byte[])faked_cookie_hex_pool.get(session);
            if (byArray == null) {
                object = Session.random;
                byArray = new byte[16];
                synchronized (object) {
                    object.fill(byArray, 0, 16);
                }
                faked_cookie_pool.put(session, byArray);
                object = new byte[32];
                for (int i = 0; i < 16; ++i) {
                    object[i * 2] = table[byArray[i] >>> 4 & 0xF];
                    object[i * 2 + 1] = table[byArray[i] & 0xF];
                }
                faked_cookie_hex_pool.put(session, object);
            }
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void removeFakedCookie(Session session) {
        Hashtable hashtable = faked_cookie_hex_pool;
        synchronized (hashtable) {
            faked_cookie_hex_pool.remove(session);
            faked_cookie_pool.remove(session);
            return;
        }
    }

    static int revtable(byte by) {
        for (int i = 0; i < table.length; ++i) {
            if (table[i] != by) continue;
            return i;
        }
        return 0;
    }

    static void setCookie(String string2) {
        cookie_hex = Util.str2byte(string2);
        cookie = new byte[16];
        for (int i = 0; i < 16; ++i) {
            ChannelX11.cookie[i] = (byte)(ChannelX11.revtable(cookie_hex[i * 2]) << 4 & 0xF0 | ChannelX11.revtable(cookie_hex[i * 2 + 1]) & 0xF);
        }
    }

    static void setHost(String string2) {
        host = string2;
    }

    static void setPort(int n) {
        port = n;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        this.socket = Util.createSocket(host, port, 10000);
        this.socket.setTcpNoDelay(true);
        Object object = new IO();
        this.io = object;
        this.io.setInputStream(this.socket.getInputStream());
        this.io.setOutputStream(this.socket.getOutputStream());
        this.sendOpenConfirmation();
        this.thread = Thread.currentThread();
        object = new Buffer(this.rmpsize);
        Packet packet = new Packet((Buffer)object);
        try {
            while (this.thread != null && this.io != null && this.io.in != null) {
                int n = this.io.in.read(((Buffer)object).buffer, 14, ((Buffer)object).buffer.length - 14 - 128);
                if (n <= 0) {
                    this.eof();
                } else if (!this.close) {
                    packet.reset();
                    ((Buffer)object).putByte((byte)94);
                    ((Buffer)object).putInt(this.recipient);
                    ((Buffer)object).putInt(n);
                    ((Buffer)object).skip(n);
                    this.getSession().write(packet, this, n);
                    continue;
                }
                break;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.disconnect();
        return;
        catch (Exception exception) {
            this.sendOpenFailure(1);
            this.close = true;
            this.disconnect();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    void write(byte[] object, int n, int n2) throws IOException {
        byte[] byArray;
        Object object2;
        if (!this.init) {
            this.io.put((byte[])object, n, n2);
            return;
        }
        try {
            object2 = this.getSession();
            byArray = this.addCache((byte[])object, n, n2);
        }
        catch (JSchException jSchException) {
            throw new IOException(jSchException.toString());
        }
        int n3 = byArray.length;
        if (n3 < 9) {
            return;
        }
        n = (byArray[0 + 6] & 0xFF) * 256 + (byArray[0 + 7] & 0xFF);
        n2 = (byArray[0 + 8] & 0xFF) * 256 + (byArray[0 + 9] & 0xFF);
        if ((byArray[0] & 0xFF) != 66 && (byArray[0] & 0xFF) == 108) {
            n = n >>> 8 & 0xFF | n << 8 & 0xFF00;
            n2 = n2 >>> 8 & 0xFF | n2 << 8 & 0xFF00;
        }
        if (n3 < n + 12 + (-n & 3) + n2) {
            return;
        }
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 0 + 12 + n + (-n & 3), byArray2, 0, n2);
        object = faked_cookie_pool;
        // MONITORENTER : object
        object2 = (byte[])faked_cookie_pool.get(object2);
        // MONITOREXIT : object
        if (ChannelX11.equals(byArray2, (byte[])object2)) {
            if (cookie != null) {
                System.arraycopy(cookie, 0, byArray, 0 + 12 + n + (-n & 3), n2);
            }
        } else {
            this.thread = null;
            this.eof();
            this.io.close();
            this.disconnect();
        }
        this.init = false;
        this.io.put(byArray, 0, n3);
        this.cache = null;
    }
}

