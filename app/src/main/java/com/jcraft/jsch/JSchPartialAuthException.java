/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchException;

class JSchPartialAuthException
extends JSchException {
    String methods;

    public JSchPartialAuthException() {
    }

    public JSchPartialAuthException(String string2) {
        super(string2);
        this.methods = string2;
    }

    public String getMethods() {
        return this.methods;
    }
}

