/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Proxy;
import com.jcraft.jsch.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxySOCKS5
implements Proxy {
    private static int DEFAULTPORT = 1080;
    private InputStream in;
    private OutputStream out;
    private String passwd;
    private String proxy_host;
    private int proxy_port;
    private Socket socket;
    private String user;

    public ProxySOCKS5(String string2) {
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

    public ProxySOCKS5(String string2, int n) {
        this.proxy_host = string2;
        this.proxy_port = n;
    }

    private void fill(InputStream inputStream, byte[] byArray, int n) throws JSchException, IOException {
        int n2;
        for (int i = 0; i < n; i += n2) {
            n2 = inputStream.read(byArray, i, n - i);
            if (n2 > 0) {
                continue;
            }
            throw new JSchException("ProxySOCKS5: stream is closed");
        }
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
     * Exception decompiling
     */
    @Override
    public void connect(SocketFactory var1_1, String var2_5, int var3_8, int var4_9) throws JSchException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [23[CASE]], but top level block is 10[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
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

