/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.ChannelSession;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Request;
import com.jcraft.jsch.RequestShell;
import com.jcraft.jsch.Session;

public class ChannelShell
extends ChannelSession {
    ChannelShell() {
        this.pty = true;
    }

    @Override
    void init() throws JSchException {
        this.io.setInputStream(this.getSession().in);
        this.io.setOutputStream(this.getSession().out);
    }

    @Override
    public void start() throws JSchException {
        Session session = this.getSession();
        try {
            this.sendRequests();
            RequestShell requestShell = new RequestShell();
            ((Request)requestShell).request(session, this);
            if (this.io.in != null) {
                this.thread = new Thread(this);
                this.thread.setName("Shell for " + session.host);
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
                    throw new JSchException("ChannelShell", exception);
                }
                throw new JSchException("ChannelShell");
            }
            throw (JSchException)exception;
        }
    }
}

