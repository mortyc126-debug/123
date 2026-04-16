/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.PendingIntent$OnFinished
 *  android.content.Intent
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public final class PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0
implements PendingIntent.OnFinished {
    public final PendingIntentCompat.GatedCallback f$0;

    public /* synthetic */ PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f$0 = gatedCallback;
    }

    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int n, String string2, Bundle bundle) {
        PendingIntentCompat.GatedCallback.$r8$lambda$dARjk2pGHL_3_vnErsOjaRzR5JA(this.f$0, pendingIntent, intent, n, string2, bundle);
    }
}

