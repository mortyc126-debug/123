/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.ChannelSession;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Request;
import com.jcraft.jsch.RequestPtyReq;
import com.jcraft.jsch.RequestSubsystem;
import com.jcraft.jsch.RequestX11;
import com.jcraft.jsch.Session;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelSubsystem
extends ChannelSession {
    boolean pty = false;
    String subsystem = "";
    boolean want_reply = true;
    boolean xforwading = false;

    public InputStream getErrStream() throws IOException {
        return this.getExtInputStream();
    }

    @Override
    void init() throws JSchException {
        this.io.setInputStream(this.getSession().in);
        this.io.setOutputStream(this.getSession().out);
    }

    public void setErrStream(OutputStream outputStream) {
        this.setExtOutputStream(outputStream);
    }

    @Override
    public void setPty(boolean bl) {
        this.pty = bl;
    }

    public void setSubsystem(String string2) {
        this.subsystem = string2;
    }

    public void setWantReply(boolean bl) {
        this.want_reply = bl;
    }

    @Override
    public void setXForwarding(boolean bl) {
        this.xforwading = bl;
    }

    @Override
    public void start() throws JSchException {
        Session session = this.getSession();
        try {
            Request request;
            if (this.xforwading) {
                request = new RequestX11();
                request.request(session, this);
            }
            if (this.pty) {
                request = new RequestPtyReq();
                request.request(session, this);
            }
            request = new RequestSubsystem();
            ((RequestSubsystem)request).request(session, this, this.subsystem, this.want_reply);
            if (this.io.in != null) {
                this.thread = new Thread(this);
                this.thread.setName("Subsystem for " + session.host);
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
                    throw new JSchException("ChannelSubsystem", exception);
                }
                throw new JSchException("ChannelSubsystem");
            }
            throw (JSchException)exception;
        }
    }
}

