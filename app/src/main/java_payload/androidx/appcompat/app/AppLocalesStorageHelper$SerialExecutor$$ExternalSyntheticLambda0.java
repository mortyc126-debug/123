/*
 * Decompiled with CFR 0.152.
 */
package androidx.appcompat.app;

import androidx.appcompat.app.AppLocalesStorageHelper;

public final class AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0
implements Runnable {
    public final AppLocalesStorageHelper.SerialExecutor f$0;
    public final Runnable f$1;

    public /* synthetic */ AppLocalesStorageHelper$SerialExecutor$$ExternalSyntheticLambda0(AppLocalesStorageHelper.SerialExecutor serialExecutor, Runnable runnable2) {
        this.f$0 = serialExecutor;
        this.f$1 = runnable2;
    }

    @Override
    public final void run() {
        this.f$0.lambda$execute$0$androidx-appcompat-app-AppLocalesStorageHelper$SerialExecutor(this.f$1);
    }
}

