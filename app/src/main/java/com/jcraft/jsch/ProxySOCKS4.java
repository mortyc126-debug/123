/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Proxy;
import com.jcraft.jsch.SocketFactory;
import com.jcraft.jsch.Util;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProxySOCKS4
implements Proxy {
    private static int DEFAULTPORT = 1080;
    private InputStream in;
    private OutputStream out;
    private String passwd;
    private String proxy_host;
    private int proxy_port;
    private Socket socket;
    private String user;

    public ProxySOCKS4(String string2) {
        int n = DEFAULTPORT;
        String string3 = string2;
        int n2 = n;
        String string4 = string3;
        if (string2.indexOf(58) != -1) {
            string3 = string4 = string2.substring(0, string2.indexOf(58));
            try {
                n2 = Integer.parseInt(string2.substring(string2.indexOf(58) + 1));
            }
            catch (Exception exception) {
                string4 = string3;
                n2 = n;
            }
        }
        this.proxy_host = string4;
        this.proxy_port = n2;
    }

    public ProxySOCKS4(String string2, int n) {
        this.proxy_host = string2;
        this.proxy_port = n;
    }

    public static int getDefaultPort() {
        return DEFAULTPORT;
    }

    @Override
    public void close() {
        try {
            if (this.in != null) {
                this.in.close();
            }
            if (this.out != null) {
                this.out.close();
            }
            if (this.socket != null) {
                this.socket.close();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.in = null;
        this.out = null;
        this.socket = null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void connect(SocketFactory var1_1, String var2_4, int var3_7, int var4_8) throws JSchException {
        block21: {
            block23: {
                if (var1_1 != null) ** GOTO lbl7
                this.socket = Util.createSocket(this.proxy_host, this.proxy_port, var4_8);
                this.in = this.socket.getInputStream();
                this.out = this.socket.getOutputStream();
                break block23;
lbl7:
                // 1 sources

                this.socket = var1_1.createSocket(this.proxy_host, this.proxy_port);
                this.in = var1_1.getInputStream(this.socket);
                this.out = var1_1.getOutputStream(this.socket);
            }
            if (var4_8 <= 0) ** GOTO lbl14
            this.socket.setSoTimeout(var4_8);
lbl14:
            // 2 sources

            this.socket.setTcpNoDelay(true);
            var1_1 = new byte[1024];
            var4_8 = 0 + 1;
            var1_1[0] = 4;
            var5_9 = var4_8 + 1;
            var1_1[var4_8] = true;
            var4_8 = var5_9 + 1;
            var1_1[var5_9] = (byte)(var3_7 /* !! */  >>> 8);
            var5_9 = var4_8 + 1;
            var1_1[var4_8] = (byte)(var3_7 /* !! */  & 255);
            var2_4 = InetAddress.getByName((String)var2_4).getAddress();
            var4_8 = 0;
            var3_7 /* !! */  = var5_9;
            while (true) {
                var5_9 = ((Object)var2_4).length;
                if (var4_8 >= var5_9) break;
                var1_1[var3_7 /* !! */ ] = var2_4[var4_8];
                ++var4_8;
                ++var3_7 /* !! */ ;
            }
            var4_8 = var3_7 /* !! */ ;
            if (this.user == null) break block21;
            System.arraycopy(Util.str2byte(this.user), 0, var1_1, var3_7 /* !! */ , this.user.length());
            var4_8 = var3_7 /* !! */  + this.user.length();
        }
        var1_1[var4_8] = false;
        this.out.write((byte[])var1_1, 0, var4_8 + 1);
        for (var3_7 /* !! */  = 0; var3_7 /* !! */  < 8; var3_7 /* !! */  += var4_8) {
            block22: {
                var4_8 = this.in.read((byte[])var1_1, var3_7 /* !! */ , 8 - var3_7 /* !! */ );
                if (var4_8 <= 0) break block22;
                continue;
            }
            var1_1 = new JSchException("ProxySOCKS4: stream is closed");
            throw var1_1;
        }
        if (var1_1[0] != false) ** GOTO lbl68
        var3_7 /* !! */  = (int)var1_1[1];
        if (var3_7 /* !! */  == 90) {
            return;
        }
        try {
            this.socket.close();
        }
        catch (Exception var2_5) {
            // empty catch block
        }
        var2_4 = new StringBuilder();
        var2_4 = var2_4.append("ProxySOCKS4: server returns CD ").append((int)var1_1[1]).toString();
        var1_1 = new JSchException((String)var2_4);
        throw var1_1;
lbl68:
        // 1 sources

        var2_4 = new StringBuilder();
        var6_10 = new JSchException(var2_4.append("ProxySOCKS4: server returns VN ").append((int)var1_1[0]).toString());
        throw var6_10;
        catch (UnknownHostException var6_11) {
            try {
                var1_1 = new StringBuilder();
                var2_4 = new JSchException(var1_1.append("ProxySOCKS4: ").append(var6_11.toString()).toString(), var6_11);
                throw var2_4;
            }
            catch (Exception var1_2) {
                try {
                    if (this.socket != null) {
                        this.socket.close();
                    }
                }
                catch (Exception var2_6) {
                    // empty catch block
                }
                throw new JSchException("ProxySOCKS4: " + var1_2.toString());
            }
            catch (RuntimeException var1_3) {
                throw var1_3;
            }
        }
    }

    @Override
    public InputStream getInputStream() {
        return this.in;
    }

    @Override
    public OutputStream getOutputStream() {
        return this.out;
    }

    @Override
    public Socket getSocket() {
        return this.socket;
    }

    public void setUserPasswd(String string2, String string3) {
        this.user = string2;
        this.passwd = string3;
    }
}

