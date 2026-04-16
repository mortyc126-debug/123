/*
 * Decompiled with CFR 0.152.
 */
package com.arthenica.smartexception;

import com.arthenica.smartexception.StackTraceElementWrapper;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Set;

public class ThrowableWrapper {
    private final ThrowableWrapper cause;
    private final String className;
    private final String message;
    private final StackTraceElementWrapper[] stackTrace;
    private final ThrowableWrapper[] suppressed;

    public ThrowableWrapper(String string2, ThrowableWrapper throwableWrapper, String string3, ThrowableWrapper[] throwableWrapperArray, StackTraceElementWrapper[] stackTraceElementWrapperArray) {
        this.message = string2;
        this.cause = throwableWrapper;
        this.className = string3;
        this.suppressed = throwableWrapperArray;
        this.stackTrace = stackTraceElementWrapperArray;
    }

    public ThrowableWrapper(Throwable throwable) {
        this(throwable, Collections.newSetFromMap(new IdentityHashMap()));
    }

    public ThrowableWrapper(Throwable stackTraceElementArray, Set<Throwable> set) {
        int n;
        set.add((Throwable)stackTraceElementArray);
        this.message = stackTraceElementArray.getMessage();
        this.cause = stackTraceElementArray.getCause() != null && !set.contains(stackTraceElementArray.getCause()) ? new ThrowableWrapper(stackTraceElementArray.getCause(), set) : null;
        this.className = stackTraceElementArray.getClass().getName();
        Throwable[] throwableArray = stackTraceElementArray.getSuppressed();
        LinkedList<ThrowableWrapper> linkedList = new LinkedList<ThrowableWrapper>();
        int n2 = throwableArray.length;
        for (n = 0; n < n2; ++n) {
            if (set.contains(throwableArray[n])) continue;
            linkedList.add(new ThrowableWrapper(throwableArray[n], set));
        }
        this.suppressed = linkedList.toArray(new ThrowableWrapper[0]);
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        this.stackTrace = new StackTraceElementWrapper[stackTraceElementArray.length];
        n2 = stackTraceElementArray.length;
        for (n = 0; n < n2; ++n) {
            this.stackTrace[n] = new StackTraceElementWrapper(stackTraceElementArray[n]);
        }
    }

    public ThrowableWrapper getCause() {
        return this.cause;
    }

    public String getClassName() {
        return this.className;
    }

    public String getMessage() {
        return this.message;
    }

    public StackTraceElementWrapper[] getStackTrace() {
        return this.stackTrace;
    }

    public ThrowableWrapper[] getSuppressed() {
        return this.suppressed;
    }
}

