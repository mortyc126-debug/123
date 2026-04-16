/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Proxy;
import com.jcraft.jsch.SocketFactory;
import com.jcraft.jsch.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxyHTTP
implements Proxy {
    private static int DEFAULTPORT = 80;
    private InputStream in;
    private OutputStream out;
    private String passwd;
    private String proxy_host;
    private int proxy_port;
    private Socket socket;
    private String user;

    public ProxyHTTP(String string2) {
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

    public ProxyHTTP(String string2, int n) {
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
     */
    @Override
    public void connect(SocketFactory var1_1, String var2_4, int var3_7, int var4_8) throws JSchException {
        block26: {
            block27: {
                if (var1_1 != null) ** GOTO lbl7
                this.socket = Util.createSocket(this.proxy_host, this.proxy_port, var4_8);
                this.in = this.socket.getInputStream();
                this.out = this.socket.getOutputStream();
                break block27;
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
            var8_9 = this.out;
            var1_1 = new StringBuilder();
            var8_9.write(Util.str2byte(var1_1.append("CONNECT ").append((String)var2_4).append(":").append(var3_7).append(" HTTP/1.0\r\n").toString()));
            var1_1 = this.user;
            if (var1_1 == null) ** GOTO lbl28
            if (this.passwd != null) {
                var1_1 = new StringBuilder();
                var1_1 = Util.str2byte(var1_1.append(this.user).append(":").append(this.passwd).toString());
                var1_1 = Util.toBase64((byte[])var1_1, 0, ((Object)var1_1).length);
                this.out.write(Util.str2byte("Proxy-Authorization: Basic "));
                this.out.write((byte[])var1_1);
                this.out.write(Util.str2byte("\r\n"));
            }
lbl28:
            // 4 sources

            this.out.write(Util.str2byte("\r\n"));
            this.out.flush();
            var3_7 = 0;
            var1_1 = new StringBuffer();
            while (true) {
                var4_8 = var3_7;
                if (var3_7 < 0) break;
                var3_7 = this.in.read();
                if (var3_7 == 13) ** GOTO lbl43
                var1_1.append((char)var3_7);
                continue;
lbl43:
                // 1 sources

                var4_8 = var3_7 = this.in.read();
                if (var3_7 == 10) break;
                continue;
                break;
            }
            if (var4_8 < 0) ** GOTO lbl98
            var2_4 = var1_1.toString();
            var1_1 = "Unknow reason";
            var5_10 = -1;
            var3_7 = var4_8;
            var4_8 = var5_10;
            var3_7 = var6_11 = var2_4.indexOf(32);
            var4_8 = var5_10;
            var7_12 = var2_4.indexOf(32, var6_11 + 1);
            var3_7 = var6_11;
            var4_8 = var5_10;
            var5_10 = Integer.parseInt(var2_4.substring(var6_11 + 1, var7_12));
            var3_7 = var6_11;
            var4_8 = var5_10;
            try {
                var1_1 = var2_4 = var2_4.substring(var7_12 + 1);
                var3_7 = var6_11;
                var4_8 = var5_10;
            }
            catch (Exception var2_5) {
                // empty catch block
            }
            if (var4_8 != 200) ** GOTO lbl95
            do {
                var5_10 = 0;
                while (true) {
                    block25: {
                        var4_8 = var3_7;
                        if (var3_7 < 0) break;
                        var3_7 = this.in.read();
                        if (var3_7 == 13) break block25;
                        ++var5_10;
                        continue;
                    }
                    var4_8 = var3_7 = this.in.read();
                    if (var3_7 == 10) break;
                    continue;
                    break;
                }
                if (var4_8 < 0) break block26;
                var3_7 = var4_8;
            } while (var5_10 != 0);
            return;
        }
        try {
            var1_1 = new IOException();
            throw var1_1;
lbl95:
            // 1 sources

            var8_9 = new StringBuilder();
            var2_4 = new IOException(var8_9.append("proxy error: ").append((String)var1_1).toString());
            throw var2_4;
lbl98:
            // 1 sources

            var1_1 = new IOException();
            throw var1_1;
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
            var2_4 = "ProxyHTTP: " + var1_2.toString();
            if (var1_2 instanceof Throwable) {
                throw new JSchException((String)var2_4, var1_2);
            }
            throw new JSchException((String)var2_4);
        }
        catch (RuntimeException var1_3) {
            throw var1_3;
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

