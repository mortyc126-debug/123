/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

public class DefaultRunnableScheduler
implements RunnableScheduler {
    private final Handler mHandler = HandlerCompat.createAsync(Looper.getMainLooper());

    @Override
    public void cancel(Runnable runnable2) {
        this.mHandler.removeCallbacks(runnable2);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    @Override
    public void scheduleWithDelay(long l, Runnable runnable2) {
        this.mHandler.postDelayed(runnable2, l);
    }
}

