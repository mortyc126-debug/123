/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception;

public class StackTraceElementWrapper {
    private final StackTraceElement stackTraceElement;

    public StackTraceElementWrapper(StackTraceElement stackTraceElement) {
        this.stackTraceElement = stackTraceElement;
    }

    public StackTraceElement getStackTraceElement() {
        return this.stackTraceElement;
    }
}

