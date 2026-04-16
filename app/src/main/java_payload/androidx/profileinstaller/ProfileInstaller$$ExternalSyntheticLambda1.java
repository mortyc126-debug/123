/*
 * Decompiled with CFR 0.152.
 */
package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final class ProfileInstaller$$ExternalSyntheticLambda1
implements Runnable {
    public final ProfileInstaller.DiagnosticsCallback f$0;
    public final int f$1;
    public final Object f$2;

    public /* synthetic */ ProfileInstaller$$ExternalSyntheticLambda1(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int n, Object object) {
        this.f$0 = diagnosticsCallback;
        this.f$1 = n;
        this.f$2 = object;
    }

    @Override
    public final void run() {
        ProfileInstaller.lambda$diagnostic$1(this.f$0, this.f$1, this.f$2);
    }
}

