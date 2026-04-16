/*
 * Decompiled with CFR 0.152.
 */
package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.ThreadPoolDispatcherKt;

public final class ThreadPoolDispatcherKt$$ExternalSyntheticLambda0
implements ThreadFactory {
    public final int f$0;
    public final String f$1;
    public final AtomicInteger f$2;

    public /* synthetic */ ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(int n, String string2, AtomicInteger atomicInteger) {
        this.f$0 = n;
        this.f$1 = string2;
        this.f$2 = atomicInteger;
    }

    @Override
    public final Thread newThread(Runnable runnable2) {
        return ThreadPoolDispatcherKt.$r8$lambda$riuIvi8mr1MS_Bpu-1FqJ0BJlQ8(this.f$0, this.f$1, this.f$2, runnable2);
    }
}

