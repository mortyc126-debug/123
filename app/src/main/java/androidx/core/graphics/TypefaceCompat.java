/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompatApi21Impl;
import androidx.core.graphics.TypefaceCompatApi24Impl;
import androidx.core.graphics.TypefaceCompatApi26Impl;
import androidx.core.graphics.TypefaceCompatApi28Impl;
import androidx.core.graphics.TypefaceCompatApi29Impl;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;

public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        sTypefaceCompatImpl = Build.VERSION.SDK_INT >= 29 ? new TypefaceCompatApi29Impl() : (Build.VERSION.SDK_INT >= 28 ? new TypefaceCompatApi28Impl() : (Build.VERSION.SDK_INT >= 26 ? new TypefaceCompatApi26Impl() : (TypefaceCompatApi24Impl.isUsable() ? new TypefaceCompatApi24Impl() : new TypefaceCompatApi21Impl())));
        sTypefaceCache = new LruCache(16);
    }

    private TypefaceCompat() {
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    public static Typeface create(Context context, Typeface typeface, int n) {
        if (context != null) {
            return Typeface.create((Typeface)typeface, (int)n);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface create(Context context, Typeface typeface, int n, boolean bl) {
        if (context != null) {
            Preconditions.checkArgumentInRange(n, 1, 1000, "weight");
            Typeface typeface2 = typeface;
            if (typeface == null) {
                typeface2 = Typeface.DEFAULT;
            }
            return sTypefaceCompatImpl.createWeightStyle(context, typeface2, n, bl);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArray, int n) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArray, n);
    }

    @Deprecated
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int n, int n2, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean bl) {
        return TypefaceCompat.createFromResourcesFamilyXml(context, familyResourceEntry, resources, n, null, 0, n2, fontCallback, handler, bl);
    }

    public static Typeface createFromResourcesFamilyXml(Context object, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int n, String string2, int n2, int n3, ResourcesCompat.FontCallback object2, Handler handler, boolean bl) {
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            Typeface typeface = TypefaceCompat.getSystemFontFamily(((FontResourcesParserCompat.ProviderResourceEntry)(familyResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry)familyResourceEntry)).getSystemFontFamilyName());
            if (typeface != null) {
                if (object2 != null) {
                    ((ResourcesCompat.FontCallback)object2).callbackSuccessAsync(typeface, handler);
                }
                return typeface;
            }
            boolean bl2 = bl ? ((FontResourcesParserCompat.ProviderResourceEntry)familyResourceEntry).getFetchStrategy() == 0 : object2 == null;
            int n4 = bl ? ((FontResourcesParserCompat.ProviderResourceEntry)familyResourceEntry).getTimeout() : -1;
            handler = ResourcesCompat.FontCallback.getHandler(handler);
            object2 = new ResourcesCallbackAdapter((ResourcesCompat.FontCallback)object2);
            object = FontsContractCompat.requestFont(object, ((FontResourcesParserCompat.ProviderResourceEntry)familyResourceEntry).getRequest(), n3, bl2, n4, handler, (FontsContractCompat.FontRequestCallback)object2);
        } else {
            familyResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry((Context)object, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)familyResourceEntry, resources, n3);
            object = familyResourceEntry;
            if (object2 != null) {
                if (familyResourceEntry != null) {
                    ((ResourcesCompat.FontCallback)object2).callbackSuccessAsync((Typeface)familyResourceEntry, handler);
                    object = familyResourceEntry;
                } else {
                    ((ResourcesCompat.FontCallback)object2).callbackFailAsync(-3, handler);
                    object = familyResourceEntry;
                }
            }
        }
        if (object != null) {
            sTypefaceCache.put(TypefaceCompat.createResourceUid(resources, n, string2, n2, n3), (Typeface)object);
        }
        return object;
    }

    @Deprecated
    public static Typeface createFromResourcesFontFile(Context context, Resources resources, int n, String string2, int n2) {
        return TypefaceCompat.createFromResourcesFontFile(context, resources, n, string2, 0, n2);
    }

    public static Typeface createFromResourcesFontFile(Context context, Resources object, int n, String string2, int n2, int n3) {
        if ((context = sTypefaceCompatImpl.createFromResourcesFontFile(context, (Resources)object, n, string2, n3)) != null) {
            object = TypefaceCompat.createResourceUid(object, n, string2, n2, n3);
            sTypefaceCache.put((String)object, (Typeface)context);
        }
        return context;
    }

    private static String createResourceUid(Resources resources, int n, String string2, int n2, int n3) {
        return resources.getResourcePackageName(n) + '-' + string2 + '-' + n2 + '-' + n + '-' + n3;
    }

    @Deprecated
    public static Typeface findFromCache(Resources resources, int n, int n2) {
        return TypefaceCompat.findFromCache(resources, n, null, 0, n2);
    }

    public static Typeface findFromCache(Resources resources, int n, String string2, int n2, int n3) {
        return sTypefaceCache.get(TypefaceCompat.createResourceUid(resources, n, string2, n2, n3));
    }

    private static Typeface getBestFontFromFamily(Context context, Typeface object, int n) {
        if ((object = sTypefaceCompatImpl.getFontFamily((Typeface)object)) == null) {
            return null;
        }
        return sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry)object, context.getResources(), n);
    }

    private static Typeface getSystemFontFamily(String string2) {
        Object var1_1 = null;
        if (string2 != null && !string2.isEmpty()) {
            Typeface typeface = Typeface.create((String)string2, (int)0);
            Typeface typeface2 = Typeface.create((Typeface)Typeface.DEFAULT, (int)0);
            string2 = var1_1;
            if (typeface != null) {
                string2 = var1_1;
                if (!typeface.equals((Object)typeface2)) {
                    string2 = typeface;
                }
            }
            return string2;
        }
        return null;
    }

    public static class ResourcesCallbackAdapter
    extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }

        @Override
        public void onTypefaceRequestFailed(int n) {
            if (this.mFontCallback != null) {
                this.mFontCallback.onFontRetrievalFailed(n);
            }
        }

        @Override
        public void onTypefaceRetrieved(Typeface typeface) {
            if (this.mFontCallback != null) {
                this.mFontCallback.onFontRetrieved(typeface);
            }
        }
    }
}

