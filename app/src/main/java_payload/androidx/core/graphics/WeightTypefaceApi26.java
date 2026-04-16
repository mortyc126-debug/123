/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.util.Log
 *  android.util.SparseArray
 */
package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class WeightTypefaceApi26 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD = "nativeCreateFromTypefaceWithExactStyle";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor;
    private static final Method sNativeCreateFromTypefaceWithExactStyle;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;

    static {
        Constructor constructor;
        Method method;
        Field field;
        block3: {
            try {
                field = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
                method = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD, Long.TYPE, Integer.TYPE, Boolean.TYPE);
                method.setAccessible(true);
                constructor = Typeface.class.getDeclaredConstructor(Long.TYPE);
                constructor.setAccessible(true);
                break block3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
            Log.e((String)TAG, (String)method.getClass().getName(), (Throwable)((Object)method));
            field = null;
            method = null;
            constructor = null;
        }
        sNativeInstance = field;
        sNativeCreateFromTypefaceWithExactStyle = method;
        sConstructor = constructor;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi26() {
    }

    private static Typeface create(long l) {
        try {
            Typeface typeface = sConstructor.newInstance(l);
            return typeface;
        }
        catch (InvocationTargetException invocationTargetException) {
            return null;
        }
        catch (InstantiationException instantiationException) {
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Typeface createWeightStyle(Typeface sparseArray, int n, boolean bl) {
        if (!WeightTypefaceApi26.isPrivateApiAvailable()) {
            return null;
        }
        int n2 = n << 1 | bl;
        Object object = sWeightCacheLock;
        synchronized (object) {
            Typeface typeface;
            long l = WeightTypefaceApi26.getNativeInstance((Typeface)sparseArray);
            sparseArray = sWeightTypefaceCache.get(l);
            if (sparseArray == null) {
                sparseArray = new SparseArray(4);
                sWeightTypefaceCache.put(l, (SparseArray<Typeface>)sparseArray);
            } else {
                typeface = (Typeface)sparseArray.get(n2);
                if (typeface != null) {
                    return typeface;
                }
            }
            typeface = WeightTypefaceApi26.create(WeightTypefaceApi26.nativeCreateFromTypefaceWithExactStyle(l, n, bl));
            sparseArray.put(n2, (Object)typeface);
            return typeface;
        }
    }

    private static long getNativeInstance(Typeface typeface) {
        try {
            long l = sNativeInstance.getLong(typeface);
            return l;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    private static boolean isPrivateApiAvailable() {
        boolean bl = sNativeInstance != null;
        return bl;
    }

    private static long nativeCreateFromTypefaceWithExactStyle(long l, int n, boolean bl) {
        try {
            l = (Long)sNativeCreateFromTypefaceWithExactStyle.invoke(null, l, n, bl);
            return l;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }
}

