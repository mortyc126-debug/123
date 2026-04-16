/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package linker.resourcer.encoder;

import android.content.Context;
import android.content.DialogInterface;
import linker.resourcer.encoder.MIUIAutoStart;
import linker.resourcer.encoder.SplashActivity;

public final class SplashActivity$$ExternalSyntheticLambda0
implements DialogInterface.OnClickListener {
    public final SplashActivity f$0;
    public final MIUIAutoStart f$1;
    public final Context f$2;

    public /* synthetic */ SplashActivity$$ExternalSyntheticLambda0(SplashActivity vwfkyqppf, MIUIAutoStart mIUIAutoStart, Context context) {
        this.f$0 = vwfkyqppf;
        this.f$1 = mIUIAutoStart;
        this.f$2 = context;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.f$0.lambda$AskAutoStart$1$com-icontrol-protector-SplashActivity(this.f$1, this.f$2, dialogInterface, n);
    }
}

