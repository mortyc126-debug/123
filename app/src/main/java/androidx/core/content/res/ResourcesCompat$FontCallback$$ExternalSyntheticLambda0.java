/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final class ResourcesCompat$FontCallback$$ExternalSyntheticLambda0
implements Runnable {
    public final ResourcesCompat.FontCallback f$0;
    public final Typeface f$1;

    public /* synthetic */ ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f$0 = fontCallback;
        this.f$1 = typeface;
    }

    @Override
    public final void run() {
        this.f$0.lambda$callbackSuccessAsync$0$androidx-core-content-res-ResourcesCompat$FontCallback(this.f$1);
    }
}

