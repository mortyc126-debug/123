/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.activity;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;

public final class ComponentActivity$$ExternalSyntheticLambda3
implements OnContextAvailableListener {
    public final ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda3(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override
    public final void onContextAvailable(Context context) {
        this.f$0.lambda$new$2$androidx-activity-ComponentActivity(context);
    }
}

