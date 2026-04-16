/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.ChannelSession;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Request;
import com.jcraft.jsch.RequestExec;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelExec
extends ChannelSession {
    byte[] command = new byte[0];

    public InputStream getErrStream() throws IOException {
        return this.getExtInputStream();
    }

    @Override
    void init() throws JSchException {
        this.io.setInputStream(this.getSession().in);
        this.io.setOutputStream(this.getSession().out);
    }

    public void setCommand(String string2) {
        this.command = Util.str2byte(string2);
    }

    public void setCommand(byte[] byArray) {
        this.command = byArray;
    }

    public void setErrStream(OutputStream outputStream) {
        this.setExtOutputStream(outputStream);
    }

    public void setErrStream(OutputStream outputStream, boolean bl) {
        this.setExtOutputStream(outputStream, bl);
    }

    @Override
    public void start() throws JSchException {
        Session session = this.getSession();
        try {
            this.sendRequests();
            RequestExec requestExec = new RequestExec(this.command);
            ((Request)requestExec).request(session, this);
            if (this.io.in != null) {
                this.thread = new Thread(this);
                this.thread.setName("Exec thread " + session.getHost());
                if (session.daemon_thread) {
                    this.thread.setDaemon(session.daemon_thread);
                }
                this.thread.start();
            }
            return;
        }
        catch (Exception exception) {
            if (!(exception instanceof JSchException)) {
                if (exception instanceof Throwable) {
                    throw new JSchException("ChannelExec", exception);
                }
                throw new JSchException("ChannelExec");
            }
            throw (JSchException)exception;
        }
    }
}

