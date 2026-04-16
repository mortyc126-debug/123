/*
 * Decompiled with CFR 0.152.
 */
package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

enum DirectExecutor implements Executor
{
    INSTANCE;


    @Override
    public void execute(Runnable runnable2) {
        runnable2.run();
    }

    public String toString() {
        return "DirectExecutor";
    }
}

