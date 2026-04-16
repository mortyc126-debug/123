/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

public class SftpException
extends Exception {
    private Throwable cause = null;
    public int id;

    public SftpException(int n, String string2) {
        super(string2);
        this.id = n;
    }

    public SftpException(int n, String string2, Throwable throwable) {
        super(string2);
        this.id = n;
        this.cause = throwable;
    }

    @Override
    public Throwable getCause() {
        return this.cause;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.getMessage();
    }
}

