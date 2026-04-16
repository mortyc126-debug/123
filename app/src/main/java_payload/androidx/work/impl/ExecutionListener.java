/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;

public interface ExecutionListener {
    public void onExecuted(WorkGenerationalId var1, boolean var2);
}

