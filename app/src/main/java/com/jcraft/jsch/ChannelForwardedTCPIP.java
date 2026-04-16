/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.Buffer;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ForwardedTCPIPDaemon;
import com.jcraft.jsch.IO;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Packet;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SocketFactory;
import com.jcraft.jsch.Util;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.net.Socket;
import java.util.Vector;

public class ChannelForwardedTCPIP
extends Channel {
    private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
    private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
    private static final int TIMEOUT = 10000;
    private static Vector pool = new Vector();
    private Config config = null;
    private ForwardedTCPIPDaemon daemon = null;
    private Socket socket = null;

    ChannelForwardedTCPIP() {
        this.setLocalWindowSizeMax(131072);
        this.setLocalWindowSize(131072);
        this.setLocalPacketSize(16384);
        this.io = new IO();
        this.connected = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void addPort(Session object, String object2, int n, int n2, String object3, int n3, SocketFactory socketFactory) throws JSchException {
        String string2 = ChannelForwardedTCPIP.normalize((String)object2);
        object2 = pool;
        synchronized (object2) {
            if (ChannelForwardedTCPIP.getPort((Session)object, string2, n) == null) {
                ConfigLHost configLHost = new ConfigLHost();
                configLHost.session = object;
                configLHost.rport = n;
                configLHost.allocated_rport = n2;
                configLHost.target = object3;
                configLHost.lport = n3;
                configLHost.address_to_bind = string2;
                configLHost.factory = socketFactory;
                pool.addElement(configLHost);
                return;
            }
            object = new StringBuilder();
            object3 = new JSchException(((StringBuilder)object).append("PortForwardingR: remote port ").append(n).append(" is already registered.").toString());
            throw object3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void addPort(Session object, String object2, int n, int n2, String charSequence, Object[] objectArray) throws JSchException {
        String string2 = ChannelForwardedTCPIP.normalize((String)object2);
        object2 = pool;
        synchronized (object2) {
            if (ChannelForwardedTCPIP.getPort((Session)object, string2, n) == null) {
                ConfigDaemon configDaemon = new ConfigDaemon();
                configDaemon.session = object;
                configDaemon.rport = n;
                configDaemon.allocated_rport = n;
                configDaemon.target = charSequence;
                configDaemon.arg = objectArray;
                configDaemon.address_to_bind = string2;
                pool.addElement(configDaemon);
                return;
            }
            charSequence = new StringBuilder();
            object = new JSchException(((StringBuilder)charSequence).append("PortForwardingR: remote port ").append(n).append(" is already registered.").toString());
            throw object;
        }
    }

    static void delPort(ChannelForwardedTCPIP channelForwardedTCPIP) {
        Session session = null;
        try {
            Session session2;
            session = session2 = channelForwardedTCPIP.getSession();
        }
        catch (JSchException jSchException) {
            // empty catch block
        }
        if (session != null && channelForwardedTCPIP.config != null) {
            ChannelForwardedTCPIP.delPort(session, channelForwardedTCPIP.config.rport);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    static void delPort(Session session) {
        int n = 0;
        int n2 = 0;
        Vector vector = pool;
        // MONITORENTER : vector
        int[] nArray = new int[pool.size()];
        int n3 = 0;
        while (true) {
            n = n2;
            if (n3 >= pool.size()) break;
            n = n2;
            Config config = (Config)pool.elementAt(n3);
            n = n2;
            Object object = config;
            n = n2;
            object = config.session;
            n = n2;
            if (object == session) {
                nArray[n2] = config.rport;
                n = n2 + 1;
            }
            ++n3;
            n2 = n;
        }
        n = n2;
        // MONITOREXIT : vector
        n3 = 0;
        while (n3 < n2) {
            ChannelForwardedTCPIP.delPort(session, nArray[n3]);
            ++n3;
        }
        return;
        catch (Throwable throwable) {
            throw throwable;
        }
    }

    static void delPort(Session session, int n) {
        ChannelForwardedTCPIP.delPort(session, null, n);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void delPort(Session session, String object, int n) {
        Object object2;
        Object object3;
        Vector vector = pool;
        synchronized (vector) {
            object2 = object3 = ChannelForwardedTCPIP.getPort(session, ChannelForwardedTCPIP.normalize((String)object), n);
            if (object3 == null) {
                object2 = ChannelForwardedTCPIP.getPort(session, null, n);
            }
            if (object2 == null) {
                return;
            }
            pool.removeElement(object2);
            object3 = object;
            if (object == null) {
                object3 = ((Config)object2).address_to_bind;
            }
            object = object3;
            if (object3 == null) {
                object = "0.0.0.0";
            }
        }
        object2 = new Buffer(100);
        object3 = new Packet((Buffer)object2);
        try {
            ((Packet)object3).reset();
            ((Buffer)object2).putByte((byte)80);
            ((Buffer)object2).putString(Util.str2byte("cancel-tcpip-forward"));
            ((Buffer)object2).putByte((byte)0);
            ((Buffer)object2).putString(Util.str2byte((String)object));
            ((Buffer)object2).putInt(n);
            session.write((Packet)object3);
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Config getPort(Session session, String string2, int n) {
        Vector vector = pool;
        synchronized (vector) {
            Config config;
            int n2 = 0;
            while (true) {
                if (n2 >= pool.size()) {
                    return null;
                }
                Config config2 = config = (Config)pool.elementAt(n2);
                if (config.session == session && (config.rport == n || config.rport == 0 && config.allocated_rport == n) && (string2 == null || config.address_to_bind.equals(string2))) break;
                ++n2;
            }
            return config;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static String[] getPortForwarding(Session object) {
        String[] stringArray;
        Object object2;
        int n;
        object = new Vector();
        Object object3 = pool;
        synchronized (object3) {
            for (n = 0; n < pool.size(); ++n) {
                object2 = (Config)pool.elementAt(n);
                stringArray = object2;
                if (object2 instanceof ConfigDaemon) {
                    stringArray = new StringBuilder();
                    ((Vector)object).addElement(stringArray.append(((Config)object2).allocated_rport).append(":").append(((Config)object2).target).append(":").toString());
                    continue;
                }
                stringArray = new StringBuilder();
                ((Vector)object).addElement(stringArray.append(((Config)object2).allocated_rport).append(":").append(((Config)object2).target).append(":").append(((ConfigLHost)object2).lport).toString());
            }
        }
        stringArray = new String[((Vector)object).size()];
        n = 0;
        while (n < ((Vector)object).size()) {
            object3 = (String)((Vector)object).elementAt(n);
            object2 = (String)object3;
            stringArray[n] = object3;
            ++n;
        }
        return stringArray;
    }

    static String normalize(String string2) {
        if (string2 == null) {
            return "localhost";
        }
        if (string2.length() != 0 && !string2.equals("*")) {
            return string2;
        }
        return "";
    }

    private void setSocketFactory(SocketFactory socketFactory) {
        if (this.config != null && this.config instanceof ConfigLHost) {
            ((ConfigLHost)this.config).factory = socketFactory;
        }
    }

    @Override
    void getData(Buffer object) {
        this.setRecipient(((Buffer)object).getInt());
        this.setRemoteWindowSize(((Buffer)object).getUInt());
        this.setRemotePacketSize(((Buffer)object).getInt());
        byte[] byArray = ((Buffer)object).getString();
        int n = ((Buffer)object).getInt();
        ((Buffer)object).getString();
        ((Buffer)object).getInt();
        object = null;
        try {
            Session session = this.getSession();
            object = session;
        }
        catch (JSchException jSchException) {
            // empty catch block
        }
        this.config = ChannelForwardedTCPIP.getPort((Session)object, Util.byte2str(byArray), n);
        if (this.config == null) {
            this.config = ChannelForwardedTCPIP.getPort((Session)object, null, n);
        }
        if (this.config == null && JSch.getLogger().isEnabled(3)) {
            JSch.getLogger().log(3, "ChannelForwardedTCPIP: " + Util.byte2str(byArray) + ":" + n + " is not registered.");
        }
    }

    public int getRemotePort() {
        int n = this.config != null ? this.config.rport : 0;
        return n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        block13: {
            Object object;
            Object object2;
            Object object3;
            try {
                if (this.config instanceof ConfigDaemon) {
                    object3 = (ConfigDaemon)this.config;
                    this.daemon = (ForwardedTCPIPDaemon)Class.forName(((ConfigDaemon)object3).target).newInstance();
                    PipedOutputStream pipedOutputStream = new PipedOutputStream();
                    object2 = this.io;
                    object = new Channel.PassiveInputStream((Channel)this, pipedOutputStream, 32768);
                    ((IO)object2).setInputStream((InputStream)object, false);
                    this.daemon.setChannel(this, this.getInputStream(), pipedOutputStream);
                    this.daemon.setArg(((ConfigDaemon)object3).arg);
                    object = new Thread(this.daemon);
                    ((Thread)object).start();
                } else {
                    object = (ConfigLHost)this.config;
                    object = ((ConfigLHost)object).factory == null ? Util.createSocket(((ConfigLHost)object).target, ((ConfigLHost)object).lport, 10000) : ((ConfigLHost)object).factory.createSocket(((ConfigLHost)object).target, ((ConfigLHost)object).lport);
                    this.socket = object;
                    this.socket.setTcpNoDelay(true);
                    this.io.setInputStream(this.socket.getInputStream());
                    this.io.setOutputStream(this.socket.getOutputStream());
                }
                this.sendOpenConfirmation();
            }
            catch (Exception exception) {
                this.sendOpenFailure(1);
                this.close = true;
                this.disconnect();
                return;
            }
            this.thread = Thread.currentThread();
            object3 = new Buffer(this.rmpsize);
            object = new Packet((Buffer)object3);
            try {
                object2 = this.getSession();
            }
            catch (Exception exception) {
                // empty catch block
                break block13;
            }
            while (this.thread != null && this.io != null && this.io.in != null) {
                int n = this.io.in.read(((Buffer)object3).buffer, 14, ((Buffer)object3).buffer.length - 14 - 128);
                if (n <= 0) {
                    this.eof();
                    break;
                }
                ((Packet)object).reset();
                ((Buffer)object3).putByte((byte)94);
                ((Buffer)object3).putInt(this.recipient);
                ((Buffer)object3).putInt(n);
                ((Buffer)object3).skip(n);
                synchronized (this) {
                    if (this.close) {
                        break;
                    }
                    ((Session)object2).write((Packet)object, this, n);
                }
            }
        }
        this.disconnect();
    }

    static abstract class Config {
        String address_to_bind;
        int allocated_rport;
        int rport;
        Session session;
        String target;

        Config() {
        }
    }

    static class ConfigDaemon
    extends Config {
        Object[] arg;

        ConfigDaemon() {
        }
    }

    static class ConfigLHost
    extends Config {
        SocketFactory factory;
        int lport;

        ConfigLHost() {
        }
    }
}

