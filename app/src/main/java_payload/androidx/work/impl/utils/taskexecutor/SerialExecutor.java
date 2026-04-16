/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils.taskexecutor;

import java.util.concurrent.Executor;

public interface SerialExecutor
extends Executor {
    public boolean hasPendingTasks();
}

