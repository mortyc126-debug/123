/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 */
package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstaller;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda1;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda2;
import androidx.profileinstaller.ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ProfileInstallerInitializer
implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    static /* synthetic */ void lambda$installAfterDelay$1(Context context) {
        ProfileInstallerInitializer.writeInBackground(context);
    }

    static /* synthetic */ void lambda$writeInBackground$2(Context context) {
        ProfileInstaller.writeProfile(context);
    }

    private static void writeInBackground(Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()).execute(new ProfileInstallerInitializer$$ExternalSyntheticLambda2(context));
    }

    @Override
    public Result create(Context context) {
        this.delayAfterFirstFrame(context.getApplicationContext());
        return new Result();
    }

    void delayAfterFirstFrame(Context context) {
        Choreographer16Impl.postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda1(this, context));
    }

    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    void installAfterDelay(Context context) {
        Handler handler = Build.VERSION.SDK_INT >= 28 ? Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper());
        int n = new Random().nextInt(Math.max(1000, 1));
        handler.postDelayed((Runnable)new ProfileInstallerInitializer$$ExternalSyntheticLambda0(context), (long)(n + 5000));
    }

    /* synthetic */ void lambda$delayAfterFirstFrame$0$androidx-profileinstaller-ProfileInstallerInitializer(Context context) {
        this.installAfterDelay(context);
    }

    private static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        static /* synthetic */ void lambda$postFrameCallback$0(Runnable runnable2, long l) {
            runnable2.run();
        }

        public static void postFrameCallback(Runnable runnable2) {
            Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)new ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0(runnable2));
        }
    }

    private static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync((Looper)looper);
        }
    }

    public static class Result {
    }
}

