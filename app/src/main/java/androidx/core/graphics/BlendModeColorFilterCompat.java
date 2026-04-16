/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.BlendModeColorFilter
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.os.Build$VERSION
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils;

public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    public static ColorFilter createBlendModeColorFilterCompat(int n, BlendModeCompat object) {
        int n2 = Build.VERSION.SDK_INT;
        Object var4_3 = null;
        Object var3_4 = null;
        if (n2 >= 29) {
            object = (object = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(object)) != null ? Api29Impl.createBlendModeColorFilter(n, object) : var3_4;
            return object;
        }
        object = (object = BlendModeUtils.obtainPorterDuffFromCompat(object)) != null ? new PorterDuffColorFilter(n, (PorterDuff.Mode)object) : var4_3;
        return object;
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static ColorFilter createBlendModeColorFilter(int n, Object object) {
            return new BlendModeColorFilter(n, (BlendMode)object);
        }
    }
}

