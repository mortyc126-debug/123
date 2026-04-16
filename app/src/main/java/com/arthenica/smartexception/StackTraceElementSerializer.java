/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception;

public interface StackTraceElementSerializer {
    public String getModuleName(StackTraceElement var1);

    public String getNativeMethodDefinition();

    public String getPackageInformation(StackTraceElement var1);

    public String getUnknownSourceDefinition();

    public String toString(StackTraceElement var1, boolean var2, boolean var3);
}

