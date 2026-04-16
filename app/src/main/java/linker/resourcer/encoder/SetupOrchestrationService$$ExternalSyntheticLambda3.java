/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.SetupOrchestrationService;

public final class SetupOrchestrationService$$ExternalSyntheticLambda3
implements Runnable {
    public final SetupOrchestrationService f$0;
    public final Context f$1;
    public final Class f$2;

    public /* synthetic */ SetupOrchestrationService$$ExternalSyntheticLambda3(SetupOrchestrationService qswemlflptdlumxqnjrlg2, Context context, Class clazz) {
        this.f$0 = qswemlflptdlumxqnjrlg2;
        this.f$1 = context;
        this.f$2 = clazz;
    }

    @Override
    public final void run() {
        this.f$0.lambda$scheduleNotifyIfNeeded$2$com-icontrol-protector-SetupOrchestrationService(this.f$1, this.f$2);
    }
}

