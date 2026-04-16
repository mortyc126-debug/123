/*
 * Decompiled with CFR 0.152.
 */
package com.jcraft.jsch;

import com.jcraft.jsch.JSchException;

class JSchAuthCancelException
extends JSchException {
    String method;

    JSchAuthCancelException() {
    }

    JSchAuthCancelException(String string2) {
        super(string2);
        this.method = string2;
    }

    public String getMethod() {
        return this.method;
    }
}

