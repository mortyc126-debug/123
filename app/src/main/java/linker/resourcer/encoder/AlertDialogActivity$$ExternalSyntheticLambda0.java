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
import linker.resourcer.encoder.AlertDialogActivity;

public final class AlertDialogActivity$$ExternalSyntheticLambda0
implements DialogInterface.OnClickListener {
    public final AlertDialogActivity f$0;
    public final Context f$1;

    public /* synthetic */ AlertDialogActivity$$ExternalSyntheticLambda0(AlertDialogActivity vmwtzvb, Context context) {
        this.f$0 = vmwtzvb;
        this.f$1 = context;
    }

    public final void onClick(DialogInterface dialogInterface, int n) {
        this.f$0.lambda$onCreate$0$com-icontrol-protector-AlertDialogActivity(this.f$1, dialogInterface, n);
    }
}

