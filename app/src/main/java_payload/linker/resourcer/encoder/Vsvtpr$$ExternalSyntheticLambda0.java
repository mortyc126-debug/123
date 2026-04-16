/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.Intent;
import linker.resourcer.encoder.Vsvtpr;

public final class Vsvtpr$$ExternalSyntheticLambda0
implements Runnable {
    public final Intent f$0;
    public final Context f$1;

    public /* synthetic */ Vsvtpr$$ExternalSyntheticLambda0(Intent intent, Context context) {
        this.f$0 = intent;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        Vsvtpr.lambda$onReceive$0(this.f$0, this.f$1);
    }
}

