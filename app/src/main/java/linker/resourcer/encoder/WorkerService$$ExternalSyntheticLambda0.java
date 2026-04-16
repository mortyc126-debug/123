/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.WorkerService;

public final class WorkerService$$ExternalSyntheticLambda0
implements Runnable {
    public final WorkerService f$0;
    public final Context f$1;

    public /* synthetic */ WorkerService$$ExternalSyntheticLambda0(WorkerService lqvpqwmhpvnnlhskxyjdwphzvsl2, Context context) {
        this.f$0 = lqvpqwmhpvnnlhskxyjdwphzvsl2;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        this.f$0.lambda$onStartCommand$0$com-icontrol-protector-WorkerService(this.f$1);
    }
}

