/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.FloatProperty
 */
package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String string2) {
        this.mPropertyName = string2;
    }

    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new FloatPropertyCompat<T>(floatProperty.getName(), floatProperty){
            final FloatProperty val$property;
            {
                this.val$property = floatProperty;
                super(string2);
            }

            @Override
            public float getValue(T t) {
                return ((Float)this.val$property.get(t)).floatValue();
            }

            @Override
            public void setValue(T t, float f) {
                this.val$property.setValue(t, f);
            }
        };
    }

    public abstract float getValue(T var1);

    public abstract void setValue(T var1, float var2);
}

