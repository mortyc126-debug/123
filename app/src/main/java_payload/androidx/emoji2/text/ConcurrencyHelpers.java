/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda0;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda1;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ConcurrencyHelpers {
    private static final int FONT_LOAD_TIMEOUT_SECONDS = 15;

    public static /* synthetic */ boolean $r8$lambda$xMC8M6LLEeW997bBmO6BCC6GGAM(Handler handler, Runnable runnable2) {
        return handler.post(runnable2);
    }

    private ConcurrencyHelpers() {
    }

    @Deprecated
    static Executor convertHandlerToExecutor(Handler handler) {
        Objects.requireNonNull(handler);
        return new ConcurrencyHelpers$$ExternalSyntheticLambda1(handler);
    }

    static ThreadPoolExecutor createBackgroundPriorityExecutor(String object) {
        object = new ConcurrencyHelpers$$ExternalSyntheticLambda0((String)object);
        object = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return object;
    }

    static /* synthetic */ Thread lambda$createBackgroundPriorityExecutor$0(String object, Runnable runnable2) {
        object = new Thread(runnable2, (String)object);
        ((Thread)object).setPriority(10);
        return object;
    }

    static Handler mainHandlerAsync() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler28Impl.createAsync(Looper.getMainLooper());
        }
        return new Handler(Looper.getMainLooper());
    }

    static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync((Looper)looper);
        }
    }
}

