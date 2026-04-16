/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\b"}, d2={"DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT", "", "getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT", "()I", "createDefaultExecutor", "Ljava/util/concurrent/Executor;", "isTaskExecutor", "", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ConfigurationKt {
    private static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    public static final /* synthetic */ Executor access$createDefaultExecutor(boolean bl) {
        return ConfigurationKt.createDefaultExecutor(bl);
    }

    private static final Executor createDefaultExecutor(boolean bl) {
        Object object = new ThreadFactory(bl){
            final boolean $isTaskExecutor;
            private final AtomicInteger threadCount;
            {
                this.$isTaskExecutor = bl;
                this.threadCount = new AtomicInteger(0);
            }

            public Thread newThread(Runnable runnable2) {
                Intrinsics.checkNotNullParameter((Object)runnable2, (String)"runnable");
                String string2 = this.$isTaskExecutor ? "WM.task-" : "androidx.work-";
                return new Thread(runnable2, string2 + this.threadCount.incrementAndGet());
            }
        };
        object = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), (ThreadFactory)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"newFixedThreadPool(\n    \u2026)),\n        factory\n    )");
        return (Executor)object;
    }

    public static final int getDEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT() {
        return DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT;
    }
}

