/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package linker.resourcer.encoder;

import android.content.Context;
import linker.resourcer.encoder.lqvpqwmhpvnnlhskxyjdwphzvsl;

public final class lqvpqwmhpvnnlhskxyjdwphzvsl$MyWorker$$ExternalSyntheticLambda1
implements Runnable {
    public final Context f$0;
    public final String f$1;
    public final String f$2;
    public final byte[] f$3;
    public final Context f$4;

    public /* synthetic */ lqvpqwmhpvnnlhskxyjdwphzvsl$MyWorker$$ExternalSyntheticLambda1(Context context, String string2, String string3, byte[] byArray, Context context2) {
        this.f$0 = context;
        this.f$1 = string2;
        this.f$2 = string3;
        this.f$3 = byArray;
        this.f$4 = context2;
    }

    @Override
    public final void run() {
        lqvpqwmhpvnnlhskxyjdwphzvsl.MyWorker.lambda$monitorAppUsage$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}

