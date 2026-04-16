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

final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor;
    private static final Method sNativeCreateFromTypeface;
    private static final Method sNativeCreateWeightAlias;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;

    static {
        Constructor constructor;
        Method method;
        Method method2;
        Field field;
        block3: {
            try {
                field = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
                method2 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, Long.TYPE, Integer.TYPE);
                method2.setAccessible(true);
                method = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, Long.TYPE, Integer.TYPE);
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
            Log.e((String)TAG, (String)field.getClass().getName(), (Throwable)((Object)field));
            field = null;
            method2 = null;
            method = null;
            constructor = null;
        }
        sNativeInstance = field;
        sNativeCreateFromTypeface = method2;
        sNativeCreateWeightAlias = method;
        sConstructor = constructor;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi21() {
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
    static Typeface createWeightStyle(Typeface typeface, int n, boolean bl) {
        if (!WeightTypefaceApi21.isPrivateApiAvailable()) {
            return null;
        }
        int n2 = n << 1 | bl;
        Object object = sWeightCacheLock;
        synchronized (object) {
            long l = WeightTypefaceApi21.getNativeInstance(typeface);
            SparseArray sparseArray = sWeightTypefaceCache.get(l);
            if (sparseArray == null) {
                sparseArray = new SparseArray(4);
                sWeightTypefaceCache.put(l, (SparseArray<Typeface>)sparseArray);
            } else {
                Typeface typeface2 = (Typeface)sparseArray.get(n2);
                if (typeface2 != null) {
                    return typeface2;
                }
            }
            typeface = bl == typeface.isItalic() ? WeightTypefaceApi21.create(WeightTypefaceApi21.nativeCreateWeightAlias(l, n)) : WeightTypefaceApi21.create(WeightTypefaceApi21.nativeCreateFromTypefaceWithExactStyle(l, n, bl));
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
        int n2 = bl ? 2 : 0;
        try {
            l = (Long)sNativeCreateFromTypeface.invoke(null, l, n2);
            l = (Long)sNativeCreateWeightAlias.invoke(null, l, n);
            return l;
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    private static long nativeCreateWeightAlias(long l, int n) {
        try {
            l = (Long)sNativeCreateWeightAlias.invoke(null, l, n);
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

