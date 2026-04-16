/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final class ProfileInstallerInitializer$$ExternalSyntheticLambda1
implements Runnable {
    public final ProfileInstallerInitializer f$0;
    public final Context f$1;

    public /* synthetic */ ProfileInstallerInitializer$$ExternalSyntheticLambda1(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f$0 = profileInstallerInitializer;
        this.f$1 = context;
    }

    @Override
    public final void run() {
        this.f$0.lambda$delayAfterFirstFrame$0$androidx-profileinstaller-ProfileInstallerInitializer(this.f$1);
    }
}

