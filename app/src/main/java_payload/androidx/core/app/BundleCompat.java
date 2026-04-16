/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 */
package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

@Deprecated
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String string2) {
        return bundle.getBinder(string2);
    }

    public static void putBinder(Bundle bundle, String string2, IBinder iBinder) {
        bundle.putBinder(string2, iBinder);
    }
}

