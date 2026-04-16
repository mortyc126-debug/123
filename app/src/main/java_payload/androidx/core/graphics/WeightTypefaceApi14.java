/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.util.Log
 *  android.util.SparseArray
 */
package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import java.lang.reflect.Field;

final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
            field.setAccessible(true);
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)exception.getClass().getName(), (Throwable)exception);
            field = null;
        }
        sNativeInstance = field;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi14() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static Typeface createWeightStyle(TypefaceCompatBaseImpl typefaceCompatBaseImpl, Context context, Typeface typeface, int n, boolean bl) {
        if (!WeightTypefaceApi14.isPrivateApiAvailable()) {
            return null;
        }
        int n2 = n << 1 | bl;
        Object object = sWeightCacheLock;
        synchronized (object) {
            long l = WeightTypefaceApi14.getNativeInstance(typeface);
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
            context = WeightTypefaceApi14.getBestFontFromFamily(typefaceCompatBaseImpl, context, typeface, n, bl);
            typefaceCompatBaseImpl = context;
            if (context == null) {
                typefaceCompatBaseImpl = WeightTypefaceApi14.platformTypefaceCreate(typeface, n, bl);
            }
            sparseArray.put(n2, (Object)typefaceCompatBaseImpl);
            return typefaceCompatBaseImpl;
        }
    }

    private static Typeface getBestFontFromFamily(TypefaceCompatBaseImpl typefaceCompatBaseImpl, Context context, Typeface object, int n, boolean bl) {
        if ((object = typefaceCompatBaseImpl.getFontFamily((Typeface)object)) == null) {
            return null;
        }
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)object, context.getResources(), n, bl);
    }

    private static long getNativeInstance(Typeface typeface) {
        try {
            long l = ((Number)sNativeInstance.get(typeface)).longValue();
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

    private static Typeface platformTypefaceCreate(Typeface typeface, int n, boolean bl) {
        n = (n = n >= 600 ? 1 : 0) == 0 && !bl ? 0 : (n == 0 ? 2 : (!bl ? 1 : 3));
        return Typeface.create((Typeface)typeface, (int)n);
    }
}

