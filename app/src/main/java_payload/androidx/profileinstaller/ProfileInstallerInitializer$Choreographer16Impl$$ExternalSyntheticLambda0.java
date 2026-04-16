/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package androidx.profileinstaller;

import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final class ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0
implements Choreographer.FrameCallback {
    public final Runnable f$0;

    public /* synthetic */ ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0(Runnable runnable2) {
        this.f$0 = runnable2;
    }

    public final void doFrame(long l) {
        ProfileInstallerInitializer.Choreographer16Impl.lambda$postFrameCallback$0(this.f$0, l);
    }
}

