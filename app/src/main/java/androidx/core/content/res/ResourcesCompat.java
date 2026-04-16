/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches;
    private static final ThreadLocal<TypedValue> sTempTypedValue;

    static {
        sTempTypedValue = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private ResourcesCompat() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int n, ColorStateList colorStateList, Resources.Theme theme) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            Object object2;
            SparseArray sparseArray = object2 = sColorStateCaches.get(colorStateListCacheKey);
            if (object2 == null) {
                sparseArray = new SparseArray();
                sColorStateCaches.put(colorStateListCacheKey, (SparseArray<ColorStateListCacheEntry>)sparseArray);
            }
            object2 = new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme);
            sparseArray.append(n, object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void clearCachesForTheme(Resources.Theme theme) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            Iterator<ColorStateListCacheKey> iterator2 = sColorStateCaches.keySet().iterator();
            while (iterator2.hasNext()) {
                ColorStateListCacheKey colorStateListCacheKey = iterator2.next();
                if (colorStateListCacheKey == null || !theme.equals((Object)colorStateListCacheKey.mTheme)) continue;
                iterator2.remove();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ColorStateList getCachedColorStateList(ColorStateListCacheKey colorStateListCacheKey, int n) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
            if (sparseArray == null) return null;
            if (sparseArray.size() <= 0) return null;
            ColorStateListCacheEntry colorStateListCacheEntry = (ColorStateListCacheEntry)sparseArray.get(n);
            if (colorStateListCacheEntry == null) return null;
            if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration())) {
                if (colorStateListCacheKey.mTheme == null) {
                    if (colorStateListCacheEntry.mThemeHash == 0) return colorStateListCacheEntry.mValue;
                }
                if (colorStateListCacheKey.mTheme != null && colorStateListCacheEntry.mThemeHash == colorStateListCacheKey.mTheme.hashCode()) {
                    return colorStateListCacheEntry.mValue;
                }
            }
            sparseArray.remove(n);
            return null;
        }
    }

    public static Typeface getCachedFont(Context context, int n) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, n, new TypedValue(), 0, null, null, false, true);
    }

    public static int getColor(Resources resources, int n, Resources.Theme theme) throws Resources.NotFoundException {
        return Api23Impl.getColor(resources, n, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, int n, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList colorStateList = ResourcesCompat.getCachedColorStateList(colorStateListCacheKey, n);
        if (colorStateList != null) {
            return colorStateList;
        }
        colorStateList = ResourcesCompat.inflateColorStateList(resources, n, theme);
        if (colorStateList != null) {
            ResourcesCompat.addColorStateListToCache(colorStateListCacheKey, n, colorStateList, theme);
            return colorStateList;
        }
        return Api23Impl.getColorStateList(resources, n, theme);
    }

    public static Drawable getDrawable(Resources resources, int n, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(resources, n, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int n, int n2, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(resources, n, n2, theme);
    }

    public static float getFloat(Resources resources, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getFloat(resources, n);
        }
        TypedValue typedValue = ResourcesCompat.getTypedValue();
        resources.getValue(n, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(n) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    public static Typeface getFont(Context context, int n) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, n, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface getFont(Context context, int n, TypedValue typedValue, int n2, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return ResourcesCompat.loadFont(context, n, typedValue, n2, fontCallback, null, true, false);
    }

    public static void getFont(Context context, int n, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        ResourcesCompat.loadFont(context, n, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue;
        TypedValue typedValue2 = typedValue = sTempTypedValue.get();
        if (typedValue == null) {
            typedValue2 = new TypedValue();
            sTempTypedValue.set(typedValue2);
        }
        return typedValue2;
    }

    private static ColorStateList inflateColorStateList(Resources resources, int n, Resources.Theme theme) {
        if (ResourcesCompat.isColorInt(resources, n)) {
            return null;
        }
        XmlResourceParser xmlResourceParser = resources.getXml(n);
        try {
            resources = ColorStateListInflaterCompat.createFromXml(resources, (XmlPullParser)xmlResourceParser, theme);
            return resources;
        }
        catch (Exception exception) {
            Log.w((String)TAG, (String)"Failed to inflate ColorStateList, leaving it to the framework", (Throwable)exception);
            return null;
        }
    }

    private static boolean isColorInt(Resources resources, int n) {
        TypedValue typedValue = ResourcesCompat.getTypedValue();
        boolean bl = true;
        resources.getValue(n, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            bl = false;
        }
        return bl;
    }

    private static Typeface loadFont(Context context, int n, TypedValue typedValue, int n2, FontCallback fontCallback, Handler handler, boolean bl, boolean bl2) {
        Resources resources = context.getResources();
        resources.getValue(n, typedValue, true);
        context = ResourcesCompat.loadFont(context, resources, typedValue, n, n2, fontCallback, handler, bl, bl2);
        if (context == null && fontCallback == null && !bl2) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(n) + " could not be retrieved.");
        }
        return context;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static Typeface loadFont(Context var0, Resources var1_12, TypedValue var2_13, int var3_14, int var4_15, FontCallback var5_16, Handler var6_17, boolean var7_18, boolean var8_19) {
        block28: {
            block29: {
                block26: {
                    block25: {
                        block27: {
                            block23: {
                                block24: {
                                    if (var2_13.string == null) break block28;
                                    var10_20 = var2_13.string.toString();
                                    if (!var10_20.startsWith("res/")) {
                                        if (var5_16 != null) {
                                            var5_16.callbackFailAsync(-3, var6_17);
                                        }
                                        return null;
                                    }
                                    var11_21 = TypefaceCompat.findFromCache(var1_12 /* !! */ , var3_14, var10_20, var2_13.assetCookie, var4_15);
                                    if (var11_21 != null) {
                                        if (var5_16 != null) {
                                            var5_16.callbackSuccessAsync((Typeface)var11_21, var6_17);
                                        }
                                        return var11_21;
                                    }
                                    if (var8_19) {
                                        return null;
                                    }
                                    var11_21 = var10_20.toLowerCase();
                                    if (!var11_21.endsWith(".xml")) ** GOTO lbl39
                                    var11_21 = var1_12 /* !! */ .getXml(var3_14);
                                    if ((var11_21 = FontResourcesParserCompat.parse((XmlPullParser)var11_21, var1_12 /* !! */ )) != null) break block23;
                                    Log.e((String)"ResourcesCompat", (String)"Failed to find font-family tag");
                                    if (var5_16 == null) break block24;
                                    try {
                                        var5_16.callbackFailAsync(-3, var6_17);
                                    }
                                    catch (IOException var0_1) {
                                        break block25;
                                    }
                                    catch (XmlPullParserException var0_2) {
                                        var1_12 /* !! */  = var10_20;
                                        break block26;
                                    }
                                }
                                return null;
                            }
                            var9_22 = var2_13.assetCookie;
                            return TypefaceCompat.createFromResourcesFamilyXml(var0, (FontResourcesParserCompat.FamilyResourceEntry)var11_21, var1_12 /* !! */ , var3_14, var10_20, var9_22, var4_15, var5_16, var6_17, var7_18);
lbl39:
                            // 1 sources

                            var0 = TypefaceCompat.createFromResourcesFontFile(var0, var1_12 /* !! */ , var3_14, var10_20, var2_13.assetCookie, var4_15);
                            if (var5_16 == null) break block27;
                            if (var0 == null) ** GOTO lbl45
                            try {
                                var5_16.callbackSuccessAsync((Typeface)var0, var6_17);
                                break block27;
lbl45:
                                // 1 sources

                                var5_16.callbackFailAsync(-3, var6_17);
                            }
                            catch (IOException var0_3) {
                                break block25;
                            }
                            catch (XmlPullParserException var0_4) {
                                var1_12 /* !! */  = var10_20;
                                break block26;
                            }
                        }
                        return var0;
                        catch (IOException var0_5) {
                            break block25;
                        }
                        catch (XmlPullParserException var0_6) {
                            var1_12 /* !! */  = var10_20;
                            break block26;
                        }
                        {
                            catch (XmlPullParserException var0_7) {
                                var1_12 /* !! */  = var10_20;
                                break block26;
                            }
                        }
                        catch (IOException var0_8) {
                            // empty catch block
                        }
                    }
                    Log.e((String)"ResourcesCompat", (String)("Failed to read xml resource " + var10_20), (Throwable)var0_9);
                    break block29;
                    {
                        catch (XmlPullParserException var0_10) {
                            var1_12 /* !! */  = var10_20;
                        }
                    }
                }
                Log.e((String)"ResourcesCompat", (String)("Failed to parse xml resource " + var10_20), (Throwable)var0_11);
            }
            if (var5_16 != null) {
                var5_16.callbackFailAsync(-3, var6_17);
            }
            return null;
        }
        throw new Resources.NotFoundException("Resource \"" + var1_12 /* !! */ .getResourceName(var3_14) + "\" (" + Integer.toHexString(var3_14) + ") is not a Font: " + var2_13);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable getDrawable(Resources resources, int n, Resources.Theme theme) {
            return resources.getDrawable(n, theme);
        }

        static Drawable getDrawableForDensity(Resources resources, int n, int n2, Resources.Theme theme) {
            return resources.getDrawableForDensity(n, n2, theme);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getColor(Resources resources, int n, Resources.Theme theme) {
            return resources.getColor(n, theme);
        }

        static ColorStateList getColorStateList(Resources resources, int n, Resources.Theme theme) {
            return resources.getColorStateList(n, theme);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static float getFloat(Resources resources, int n) {
            return resources.getFloat(n);
        }
    }

    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration2, Resources.Theme theme) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration2;
            int n = theme == null ? 0 : theme.hashCode();
            this.mThemeHash = n;
        }
    }

    private static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (object != null && this.getClass() == object.getClass()) {
                object = (ColorStateListCacheKey)object;
                if (!this.mResources.equals(((ColorStateListCacheKey)object).mResources) || !ObjectsCompat.equals(this.mTheme, ((ColorStateListCacheKey)object).mTheme)) {
                    bl = false;
                }
                return bl;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mResources, this.mTheme);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            block0: {
                if (handler != null) break block0;
                handler = new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void callbackFailAsync(int n, Handler handler) {
            FontCallback.getHandler(handler).post((Runnable)new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(this, n));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            FontCallback.getHandler(handler).post((Runnable)new ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(this, typeface));
        }

        /* synthetic */ void lambda$callbackFailAsync$1$androidx-core-content-res-ResourcesCompat$FontCallback(int n) {
            this.onFontRetrievalFailed(n);
        }

        /* synthetic */ void lambda$callbackSuccessAsync$0$androidx-core-content-res-ResourcesCompat$FontCallback(Typeface typeface) {
            this.onFontRetrieved(typeface);
        }

        public abstract void onFontRetrievalFailed(int var1);

        public abstract void onFontRetrieved(Typeface var1);
    }

    public static final class ThemeCompat {
        private ThemeCompat() {
        }

        public static void rebase(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.rebase(theme);
            } else {
                Api23Impl.rebase(theme);
            }
        }

        static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock;

            static {
                sRebaseMethodLock = new Object();
            }

            private Api23Impl() {
            }

            /*
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            static void rebase(Resources.Theme theme) {
                Object object = sRebaseMethodLock;
                synchronized (object) {
                    block9: {
                        Method method;
                        boolean bl = sRebaseMethodFetched;
                        if (!bl) {
                            try {
                                sRebaseMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                sRebaseMethod.setAccessible(true);
                            }
                            catch (NoSuchMethodException noSuchMethodException) {
                                Log.i((String)ResourcesCompat.TAG, (String)"Failed to retrieve rebase() method", (Throwable)noSuchMethodException);
                            }
                            sRebaseMethodFetched = true;
                        }
                        if ((method = sRebaseMethod) != null) {
                            void var0_3;
                            try {
                                sRebaseMethod.invoke((Object)theme, new Object[0]);
                                break block9;
                            }
                            catch (InvocationTargetException invocationTargetException) {
                            }
                            catch (IllegalAccessException illegalAccessException) {
                                // empty catch block
                            }
                            Log.i((String)ResourcesCompat.TAG, (String)"Failed to invoke rebase() method via reflection", (Throwable)var0_3);
                            sRebaseMethod = null;
                        }
                    }
                    return;
                }
            }
        }

        static class Api29Impl {
            private Api29Impl() {
            }

            static void rebase(Resources.Theme theme) {
                theme.rebase();
            }
        }
    }
}

