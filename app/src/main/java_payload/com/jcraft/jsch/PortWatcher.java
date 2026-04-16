/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.ChannelDirectTCPIP;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.ServerSocketFactory;
import com.jcraft.jsch.Session;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

class PortWatcher
implements Runnable {
    private static InetAddress anyLocalAddress;
    private static Vector pool;
    InetAddress boundaddress;
    int connectTimeout = 0;
    String host;
    int lport;
    int rport;
    Session session;
    ServerSocket ss;
    Runnable thread;

    static {
        pool = new Vector();
        anyLocalAddress = null;
        try {
            anyLocalAddress = InetAddress.getByName("0.0.0.0");
        }
        catch (UnknownHostException unknownHostException) {
            // empty catch block
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    PortWatcher(Session object, String string2, int n, String string3, int n2, ServerSocketFactory serverSocketFactory) throws JSchException {
        this.session = object;
        this.lport = n;
        this.host = string3;
        this.rport = n2;
        try {
            this.boundaddress = InetAddress.getByName(string2);
            object = serverSocketFactory == null ? new ServerSocket(n, 0, this.boundaddress) : serverSocketFactory.createServerSocket(n, 0, this.boundaddress);
            this.ss = object;
            if (n == 0 && (n = this.ss.getLocalPort()) != -1) {
                this.lport = n;
            }
            return;
        }
        catch (Exception exception) {
            string2 = "PortForwardingL: local port " + string2 + ":" + n + " cannot be bound.";
            if (exception instanceof Throwable) {
                throw new JSchException(string2, exception);
            }
            throw new JSchException(string2);
        }
    }

    static PortWatcher addPort(Session runnable2, String string2, int n, String string3, int n2, ServerSocketFactory serverSocketFactory) throws JSchException {
        if (PortWatcher.getPort(runnable2, string2 = PortWatcher.normalize(string2), n) == null) {
            runnable2 = new PortWatcher((Session)runnable2, string2, n, string3, n2, serverSocketFactory);
            pool.addElement(runnable2);
            return runnable2;
        }
        throw new JSchException("PortForwardingL: local port " + string2 + ":" + n + " is already registered.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void delPort(Session runnable2) {
        Vector vector = pool;
        synchronized (vector) {
            int n;
            PortWatcher[] portWatcherArray = new PortWatcher[pool.size()];
            int n2 = 0;
            for (n = 0; n < pool.size(); ++n) {
                PortWatcher portWatcher;
                PortWatcher portWatcher2 = portWatcher = (PortWatcher)pool.elementAt(n);
                int n3 = n2;
                if (portWatcher.session == runnable2) {
                    portWatcher.delete();
                    portWatcherArray[n2] = portWatcher;
                    n3 = n2 + 1;
                }
                n2 = n3;
            }
            n = 0;
            while (n < n2) {
                runnable2 = portWatcherArray[n];
                pool.removeElement(runnable2);
                ++n;
            }
            return;
        }
    }

    static void delPort(Session runnable2, String string2, int n) throws JSchException {
        if ((runnable2 = PortWatcher.getPort((Session)runnable2, string2 = PortWatcher.normalize(string2), n)) != null) {
            ((PortWatcher)runnable2).delete();
            pool.removeElement(runnable2);
            return;
        }
        throw new JSchException("PortForwardingL: local port " + string2 + ":" + n + " is not registered.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static PortWatcher getPort(Session session, String object, int n) throws JSchException {
        InetAddress inetAddress;
        try {
            inetAddress = InetAddress.getByName((String)object);
            object = pool;
        }
        catch (UnknownHostException unknownHostException) {
            throw new JSchException("PortForwardingL: invalid address " + (String)object + " specified.", unknownHostException);
        }
        synchronized (object) {
            int n2 = 0;
            while (n2 < pool.size()) {
                PortWatcher portWatcher;
                PortWatcher portWatcher2 = portWatcher = (PortWatcher)pool.elementAt(n2);
                if (portWatcher.session == session && portWatcher.lport == n && (anyLocalAddress != null && portWatcher.boundaddress.equals(anyLocalAddress) || portWatcher.boundaddress.equals(inetAddress))) {
                    return portWatcher;
                }
                ++n2;
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static String[] getPortForwarding(Session stringArray) {
        Object object;
        int n;
        Vector<String> vector = new Vector<String>();
        Object object2 = pool;
        synchronized (object2) {
            for (n = 0; n < pool.size(); ++n) {
                Object object3 = object = (PortWatcher)pool.elementAt(n);
                if (((PortWatcher)object).session != stringArray) continue;
                object3 = new StringBuilder();
                vector.addElement(((StringBuilder)object3).append(((PortWatcher)object).lport).append(":").append(((PortWatcher)object).host).append(":").append(((PortWatcher)object).rport).toString());
            }
        }
        stringArray = new String[vector.size()];
        n = 0;
        while (n < vector.size()) {
            object = (String)vector.elementAt(n);
            object2 = (String)object;
            stringArray[n] = object;
            ++n;
        }
        return stringArray;
    }

    private static String normalize(String string2) {
        String string3 = string2;
        if (string2 != null) {
            if (string2.length() != 0 && !string2.equals("*")) {
                string3 = string2;
                if (string2.equals("localhost")) {
                    string3 = "127.0.0.1";
                }
            } else {
                string3 = "0.0.0.0";
            }
        }
        return string3;
    }

    void delete() {
        this.thread = null;
        try {
            if (this.ss != null) {
                this.ss.close();
            }
            this.ss = null;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void run() {
        this.thread = this;
        try {
            while (this.thread != null) {
                Socket socket = this.ss.accept();
                socket.setTcpNoDelay(true);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                ChannelDirectTCPIP channelDirectTCPIP = new ChannelDirectTCPIP();
                channelDirectTCPIP.init();
                channelDirectTCPIP.setInputStream(inputStream);
                channelDirectTCPIP.setOutputStream(outputStream);
                this.session.addChannel(channelDirectTCPIP);
                channelDirectTCPIP.setHost(this.host);
                channelDirectTCPIP.setPort(this.rport);
                channelDirectTCPIP.setOrgIPAddress(socket.getInetAddress().getHostAddress());
                channelDirectTCPIP.setOrgPort(socket.getPort());
                channelDirectTCPIP.connect(this.connectTimeout);
                int n = channelDirectTCPIP.exitstatus;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.delete();
    }

    void setConnectTimeout(int n) {
        this.connectTimeout = n;
    }
}

