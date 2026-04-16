/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

public class JSchException
extends Exception {
    private Throwable cause = null;

    public JSchException() {
    }

    public JSchException(String string2) {
        super(string2);
    }

    public JSchException(String string2, Throwable throwable) {
        super(string2);
        this.cause = throwable;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }
}

