/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception.java;

import com.arthenica.smartexception.AbstractExceptions;
import com.arthenica.smartexception.StackTraceElementSerializer;
import com.arthenica.smartexception.java.Exceptions;

public class JavaStackTraceElementSerializer
implements StackTraceElementSerializer {
    @Override
    public String getModuleName(StackTraceElement stackTraceElement) {
        return "";
    }

    @Override
    public String getNativeMethodDefinition() {
        return "(Native Method)";
    }

    @Override
    public String getPackageInformation(StackTraceElement object) {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> clazz = Exceptions.classLoader.loadClass((String)(object = ((StackTraceElement)object).getClassName()));
        if (clazz != null) {
            stringBuilder.append(AbstractExceptions.packageInformation(AbstractExceptions.libraryName(clazz), AbstractExceptions.version(Exceptions.packageLoader, clazz, AbstractExceptions.packageName((String)object))));
        }
        return stringBuilder.toString();
    }

    @Override
    public String getUnknownSourceDefinition() {
        return "(Unknown Source)";
    }

    @Override
    public String toString(StackTraceElement stackTraceElement, boolean bl, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        if (stackTraceElement.isNativeMethod()) {
            stringBuilder.append(this.getNativeMethodDefinition());
        } else if (stackTraceElement.getFileName() != null && stackTraceElement.getFileName().length() > 0) {
            stringBuilder.append("(");
            stringBuilder.append(stackTraceElement.getFileName());
            if (stackTraceElement.getLineNumber() >= 0) {
                stringBuilder.append(":");
                stringBuilder.append(stackTraceElement.getLineNumber());
            }
            stringBuilder.append(")");
        } else {
            stringBuilder.append(this.getUnknownSourceDefinition());
        }
        if (bl2) {
            stringBuilder.append(this.getPackageInformation(stackTraceElement));
        }
        return stringBuilder.toString();
    }
}

