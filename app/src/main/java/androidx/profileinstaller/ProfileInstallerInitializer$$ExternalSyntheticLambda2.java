/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final class ProfileInstallerInitializer$$ExternalSyntheticLambda2
implements Runnable {
    public final Context f$0;

    public /* synthetic */ ProfileInstallerInitializer$$ExternalSyntheticLambda2(Context context) {
        this.f$0 = context;
    }

    @Override
    public final void run() {
        ProfileInstallerInitializer.lambda$writeInBackground$2(this.f$0);
    }
}

