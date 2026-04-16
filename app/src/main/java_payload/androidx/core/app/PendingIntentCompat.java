/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.PendingIntent$CanceledException
 *  android.app.PendingIntent$OnFinished
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.app.PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {
    private PendingIntentCompat() {
    }

    private static int addMutabilityFlags(boolean bl, int n) {
        int n2;
        if (bl) {
            n2 = n;
            if (Build.VERSION.SDK_INT >= 31) {
                n2 = n | 0x2000000;
            }
        } else {
            n2 = n | 0x4000000;
        }
        return n2;
    }

    public static PendingIntent getActivities(Context context, int n, Intent[] intentArray, int n2, Bundle bundle, boolean bl) {
        return PendingIntent.getActivities((Context)context, (int)n, (Intent[])intentArray, (int)PendingIntentCompat.addMutabilityFlags(bl, n2), (Bundle)bundle);
    }

    public static PendingIntent getActivities(Context context, int n, Intent[] intentArray, int n2, boolean bl) {
        return PendingIntent.getActivities((Context)context, (int)n, (Intent[])intentArray, (int)PendingIntentCompat.addMutabilityFlags(bl, n2));
    }

    public static PendingIntent getActivity(Context context, int n, Intent intent, int n2, Bundle bundle, boolean bl) {
        return PendingIntent.getActivity((Context)context, (int)n, (Intent)intent, (int)PendingIntentCompat.addMutabilityFlags(bl, n2), (Bundle)bundle);
    }

    public static PendingIntent getActivity(Context context, int n, Intent intent, int n2, boolean bl) {
        return PendingIntent.getActivity((Context)context, (int)n, (Intent)intent, (int)PendingIntentCompat.addMutabilityFlags(bl, n2));
    }

    public static PendingIntent getBroadcast(Context context, int n, Intent intent, int n2, boolean bl) {
        return PendingIntent.getBroadcast((Context)context, (int)n, (Intent)intent, (int)PendingIntentCompat.addMutabilityFlags(bl, n2));
    }

    public static PendingIntent getForegroundService(Context context, int n, Intent intent, int n2, boolean bl) {
        return Api26Impl.getForegroundService(context, n, intent, PendingIntentCompat.addMutabilityFlags(bl, n2));
    }

    public static PendingIntent getService(Context context, int n, Intent intent, int n2, boolean bl) {
        return PendingIntent.getService((Context)context, (int)n, (Intent)intent, (int)PendingIntentCompat.addMutabilityFlags(bl, n2));
    }

    public static void send(PendingIntent pendingIntent, int n, PendingIntent.OnFinished object, Handler handler) throws PendingIntent.CanceledException {
        object = new GatedCallback((PendingIntent.OnFinished)object);
        try {
            pendingIntent.send(n, ((GatedCallback)object).getCallback(), handler);
            ((GatedCallback)object).complete();
            return;
        }
        finally {
            ((GatedCallback)object).close();
        }
    }

    public static void send(PendingIntent pendingIntent, Context context, int n, Intent intent, PendingIntent.OnFinished onFinished, Handler handler) throws PendingIntent.CanceledException {
        PendingIntentCompat.send(pendingIntent, context, n, intent, onFinished, handler, null, null);
    }

    public static void send(PendingIntent pendingIntent, Context context, int n, Intent intent, PendingIntent.OnFinished onFinished, Handler handler, String string2, Bundle bundle) throws PendingIntent.CanceledException {
        try (GatedCallback gatedCallback = new GatedCallback(onFinished);){
            Api23Impl.send(pendingIntent, context, n, intent, onFinished, handler, string2, bundle);
            gatedCallback.complete();
            return;
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static void send(PendingIntent pendingIntent, Context context, int n, Intent intent, PendingIntent.OnFinished onFinished, Handler handler, String string2, Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, n, intent, onFinished, handler, string2, bundle);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context context, int n, Intent intent, int n2) {
            return PendingIntent.getForegroundService((Context)context, (int)n, (Intent)intent, (int)n2);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface Flags {
    }

    private static class GatedCallback
    implements Closeable {
        private PendingIntent.OnFinished mCallback;
        private final CountDownLatch mComplete = new CountDownLatch(1);
        private boolean mSuccess;

        public static /* synthetic */ void $r8$lambda$dARjk2pGHL_3_vnErsOjaRzR5JA(GatedCallback gatedCallback, PendingIntent pendingIntent, Intent intent, int n, String string2, Bundle bundle) {
            gatedCallback.onSendFinished(pendingIntent, intent, n, string2, bundle);
        }

        GatedCallback(PendingIntent.OnFinished onFinished) {
            this.mCallback = onFinished;
            this.mSuccess = false;
        }

        private void onSendFinished(PendingIntent pendingIntent, Intent intent, int n, String string2, Bundle bundle) {
            boolean bl = false;
            while (true) {
                block6: {
                    try {
                        this.mComplete.await();
                        if (bl) {
                            Thread.currentThread().interrupt();
                        }
                        if (this.mCallback == null) break block6;
                    }
                    catch (Throwable throwable) {
                        if (bl) {
                            Thread.currentThread().interrupt();
                        }
                        throw throwable;
                    }
                    catch (InterruptedException interruptedException) {
                        bl = true;
                        continue;
                    }
                    this.mCallback.onSendFinished(pendingIntent, intent, n, string2, bundle);
                    this.mCallback = null;
                }
                return;
                break;
            }
        }

        @Override
        public void close() {
            if (!this.mSuccess) {
                this.mCallback = null;
            }
            this.mComplete.countDown();
        }

        public void complete() {
            this.mSuccess = true;
        }

        public PendingIntent.OnFinished getCallback() {
            if (this.mCallback == null) {
                return null;
            }
            return new PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0(this);
        }
    }
}

