/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.PropertyValuesHolder
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.util.Property
 */
package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

class PropertyValuesHolderUtils {
    private PropertyValuesHolderUtils() {
    }

    static PropertyValuesHolder ofPointF(Property<?, PointF> property, Path path2) {
        return Api21Impl.ofObject(property, path2);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static <V> PropertyValuesHolder ofObject(Property<?, V> property, Path path2) {
            return PropertyValuesHolder.ofObject(property, null, (Path)path2);
        }
    }
}

