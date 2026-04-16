/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.util.Property
 */
package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path2) {
        return Api21Impl.ofObject(t, property, path2);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static <T, V> ObjectAnimator ofObject(T t, Property<T, V> property, Path path2) {
            return ObjectAnimator.ofObject(t, property, null, (Path)path2);
        }
    }
}

