/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ResourcesWrapper;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources
extends ResourcesWrapper {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled = false;
    private final WeakReference<Context> mContextRef;

    public VectorEnabledTintResources(Context context, Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<Context>(context);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean bl) {
        sCompatVectorFromResourcesEnabled = bl;
    }

    public static boolean shouldBeUsed() {
        VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
        return false;
    }

    @Override
    public Drawable getDrawable(int n) throws Resources.NotFoundException {
        Context context = (Context)this.mContextRef.get();
        if (context != null) {
            return ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, n);
        }
        return this.getDrawableCanonical(n);
    }
}

