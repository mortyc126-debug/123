/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.content;

import androidx.core.content.UnusedAppRestrictionsBackportServiceConnection;

public final class PackageManagerCompat$$ExternalSyntheticLambda0
implements Runnable {
    public final UnusedAppRestrictionsBackportServiceConnection f$0;

    public /* synthetic */ PackageManagerCompat$$ExternalSyntheticLambda0(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f$0 = unusedAppRestrictionsBackportServiceConnection;
    }

    @Override
    public final void run() {
        this.f$0.disconnectFromService();
    }
}

