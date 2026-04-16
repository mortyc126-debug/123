/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.core.location;

import android.location.Location;
import java.util.function.Consumer;

public final class LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0
implements Consumer {
    public final androidx.core.util.Consumer f$0;

    public /* synthetic */ LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(androidx.core.util.Consumer consumer) {
        this.f$0 = consumer;
    }

    public final void accept(Object object) {
        this.f$0.accept((Location)object);
    }
}

