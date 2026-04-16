/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.view.animation.Interpolator
 *  android.view.animation.PathInterpolator
 */
package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(float f, float f2) {
        return Api21Impl.createPathInterpolator(f, f2);
    }

    public static Interpolator create(float f, float f2, float f3, float f4) {
        return Api21Impl.createPathInterpolator(f, f2, f3, f4);
    }

    public static Interpolator create(Path path2) {
        return Api21Impl.createPathInterpolator(path2);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Interpolator createPathInterpolator(float f, float f2) {
            return new PathInterpolator(f, f2);
        }

        static Interpolator createPathInterpolator(float f, float f2, float f3, float f4) {
            return new PathInterpolator(f, f2, f3, f4);
        }

        static Interpolator createPathInterpolator(Path path2) {
            return new PathInterpolator(path2);
        }
    }
}

