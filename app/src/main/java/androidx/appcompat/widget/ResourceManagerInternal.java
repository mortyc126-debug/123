/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.LayerDrawable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourceManagerInternal {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE;
    private static ResourceManagerInternal INSTANCE;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    private void addDelegate(String string2, InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap();
        }
        this.mDelegates.put(string2, inflateDelegate);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean addDrawableToCache(Context object, long l, Drawable object2) {
        synchronized (this) {
            Drawable.ConstantState constantState = object2.getConstantState();
            if (constantState == null) {
                return false;
            }
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(object);
            object2 = longSparseArray;
            if (longSparseArray == null) {
                object2 = new LongSparseArray();
                this.mDrawableCaches.put((Context)object, (LongSparseArray<WeakReference<Drawable.ConstantState>>)object2);
            }
            WeakReference<Drawable.ConstantState> weakReference = new WeakReference<Drawable.ConstantState>(constantState);
            ((LongSparseArray)object2).put(l, weakReference);
            return true;
        }
    }

    private void addTintListToCache(Context context, int n, ColorStateList colorStateList) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap();
        }
        SparseArrayCompat<Object> sparseArrayCompat2 = sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat2 = new SparseArrayCompat();
            this.mTintLists.put(context, sparseArrayCompat2);
        }
        sparseArrayCompat2.append(n, colorStateList);
    }

    private void checkVectorDrawableSetup(Context context) {
        if (this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        if ((context = this.getDrawable(context, R.drawable.abc_vector_test)) != null && ResourceManagerInternal.isVectorDrawable((Drawable)context)) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (long)typedValue.assetCookie << 32 | (long)typedValue.data;
    }

    private Drawable createDrawableIfNeeded(Context context, int n) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(n, typedValue, true);
        long l = ResourceManagerInternal.createCacheKey(typedValue);
        Object object = this.getCachedDrawable(context, l);
        if (object != null) {
            return object;
        }
        object = this.mHooks == null ? null : this.mHooks.createDrawableFor(this, context, n);
        if (object != null) {
            object.setChangingConfigurations(typedValue.changingConfigurations);
            this.addDrawableToCache(context, l, (Drawable)object);
        }
        return object;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] nArray) {
        if (colorStateList != null && mode != null) {
            return ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(nArray, 0), mode);
        }
        return null;
    }

    public static ResourceManagerInternal get() {
        synchronized (ResourceManagerInternal.class) {
            ResourceManagerInternal resourceManagerInternal;
            if (INSTANCE == null) {
                INSTANCE = resourceManagerInternal = new ResourceManagerInternal();
                ResourceManagerInternal.installDefaultInflateDelegates(INSTANCE);
            }
            resourceManagerInternal = INSTANCE;
            return resourceManagerInternal;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Drawable getCachedDrawable(Context context, long l) {
        synchronized (this) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray;
            block8: {
                block7: {
                    longSparseArray = this.mDrawableCaches.get(context);
                    if (longSparseArray != null) break block7;
                    return null;
                }
                Drawable.ConstantState constantState = longSparseArray.get(l);
                if (constantState == null) return null;
                constantState = (Drawable.ConstantState)constantState.get();
                if (constantState == null) break block8;
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(l);
            return null;
        }
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int n, PorterDuff.Mode mode) {
        synchronized (ResourceManagerInternal.class) {
            PorterDuffColorFilter porterDuffColorFilter;
            block5: {
                PorterDuffColorFilter porterDuffColorFilter2;
                porterDuffColorFilter = porterDuffColorFilter2 = COLOR_FILTER_CACHE.get(n, mode);
                if (porterDuffColorFilter2 != null) break block5;
                porterDuffColorFilter = new PorterDuffColorFilter(n, mode);
                COLOR_FILTER_CACHE.put(n, mode, porterDuffColorFilter);
            }
            return porterDuffColorFilter;
            finally {
            }
        }
    }

    private ColorStateList getTintListFromCache(Context context, int n) {
        Object object = this.mTintLists;
        Object var3_4 = null;
        if (object != null) {
            object = this.mTintLists.get(context);
            context = var3_4;
            if (object != null) {
                context = (ColorStateList)((SparseArrayCompat)object).get(n);
            }
            return context;
        }
        return null;
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
    }

    private static boolean isVectorDrawable(Drawable drawable2) {
        boolean bl = drawable2 instanceof VectorDrawableCompat || PLATFORM_VD_CLAZZ.equals(drawable2.getClass().getName());
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable loadDrawableFromDelegates(Context object, int n) {
        String string2;
        if (this.mDelegates == null) return null;
        if (this.mDelegates.isEmpty()) return null;
        if (this.mKnownDrawableIdTags != null) {
            string2 = this.mKnownDrawableIdTags.get(n);
            if (SKIP_DRAWABLE_TAG.equals(string2)) return null;
            if (string2 != null && this.mDelegates.get(string2) == null) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new SparseArrayCompat();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        Resources resources = object.getResources();
        resources.getValue(n, typedValue, true);
        long l = ResourceManagerInternal.createCacheKey(typedValue);
        Drawable drawable2 = this.getCachedDrawable((Context)object, l);
        if (drawable2 != null) {
            return drawable2;
        }
        string2 = drawable2;
        if (typedValue.string != null) {
            string2 = drawable2;
            if (((Object)typedValue.string).toString().endsWith(".xml")) {
                Object object2 = drawable2;
                try {
                    int n2;
                    XmlResourceParser xmlResourceParser = resources.getXml(n);
                    object2 = drawable2;
                    resources = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                    do {
                        object2 = drawable2;
                    } while ((n2 = xmlResourceParser.next()) != 2 && n2 != 1);
                    if (n2 != 2) {
                        object2 = drawable2;
                        object2 = drawable2;
                        object = new XmlPullParserException("No start tag found");
                        object2 = drawable2;
                        throw object;
                    }
                    object2 = drawable2;
                    string2 = xmlResourceParser.getName();
                    object2 = drawable2;
                    this.mKnownDrawableIdTags.append(n, string2);
                    object2 = drawable2;
                    InflateDelegate inflateDelegate = this.mDelegates.get(string2);
                    string2 = drawable2;
                    if (inflateDelegate != null) {
                        object2 = drawable2;
                        string2 = inflateDelegate.createFromXmlInner((Context)object, (XmlPullParser)xmlResourceParser, (AttributeSet)resources, object.getTheme());
                    }
                    if (string2 != null) {
                        object2 = string2;
                        string2.setChangingConfigurations(typedValue.changingConfigurations);
                        object2 = string2;
                        this.addDrawableToCache((Context)object, l, (Drawable)string2);
                    }
                }
                catch (Exception exception) {
                    Log.e((String)TAG, (String)"Exception while inflating drawable", (Throwable)exception);
                    string2 = object2;
                }
            }
        }
        if (string2 != null) return string2;
        this.mKnownDrawableIdTags.append(n, SKIP_DRAWABLE_TAG);
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Drawable tintDrawable(Context context, int n, boolean bl, Drawable drawable2) {
        ColorStateList colorStateList = this.getTintList(context, n);
        if (colorStateList != null) {
            context = drawable2;
            if (DrawableUtils.canSafelyMutateDrawable(drawable2)) {
                context = drawable2.mutate();
            }
            context = DrawableCompat.wrap((Drawable)context);
            DrawableCompat.setTintList((Drawable)context, colorStateList);
            colorStateList = this.getTintMode(n);
            drawable2 = context;
            if (colorStateList == null) return drawable2;
            DrawableCompat.setTintMode((Drawable)context, (PorterDuff.Mode)colorStateList);
            drawable2 = context;
            return drawable2;
        }
        if (this.mHooks != null && this.mHooks.tintDrawable(context, n, drawable2)) {
            return drawable2;
        }
        colorStateList = drawable2;
        if (this.tintDrawableUsingColorFilter(context, n, drawable2)) return colorStateList;
        colorStateList = drawable2;
        if (!bl) return colorStateList;
        return null;
    }

    static void tintDrawable(Drawable drawable2, TintInfo tintInfo, int[] nArray) {
        boolean bl;
        Object object = drawable2.getState();
        if (DrawableUtils.canSafelyMutateDrawable(drawable2) && !(bl = drawable2.mutate() == drawable2)) {
            Log.d((String)TAG, (String)"Mutated drawable is not the same instance as the input.");
            return;
        }
        if (drawable2 instanceof LayerDrawable && drawable2.isStateful()) {
            drawable2.setState(new int[0]);
            drawable2.setState(object);
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            drawable2.clearColorFilter();
        } else {
            object = tintInfo.mHasTintList ? (Object)tintInfo.mTintList : null;
            tintInfo = tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE;
            drawable2.setColorFilter((ColorFilter)ResourceManagerInternal.createTintFilter((ColorStateList)object, (PorterDuff.Mode)tintInfo, nArray));
        }
    }

    public Drawable getDrawable(Context context, int n) {
        synchronized (this) {
            context = this.getDrawable(context, n, false);
            return context;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    Drawable getDrawable(Context context, int n, boolean bl) {
        synchronized (this) {
            void var2_2;
            Drawable drawable2;
            this.checkVectorDrawableSetup(context);
            Drawable drawable3 = drawable2 = this.loadDrawableFromDelegates(context, (int)var2_2);
            if (drawable2 == null) {
                drawable3 = this.createDrawableIfNeeded(context, (int)var2_2);
            }
            drawable2 = drawable3;
            if (drawable3 == null) {
                drawable2 = ContextCompat.getDrawable(context, (int)var2_2);
            }
            drawable3 = drawable2;
            if (drawable2 != null) {
                void var3_3;
                drawable3 = this.tintDrawable(context, (int)var2_2, (boolean)var3_3, drawable2);
            }
            if (drawable3 != null) {
                DrawableUtils.fixDrawable(drawable3);
            }
            return drawable3;
        }
    }

    ColorStateList getTintList(Context context, int n) {
        synchronized (this) {
            ColorStateList colorStateList;
            block7: {
                ColorStateList colorStateList2;
                block9: {
                    block8: {
                        colorStateList = colorStateList2 = this.getTintListFromCache(context, n);
                        if (colorStateList2 != null) break block7;
                        if (this.mHooks != null) break block8;
                        colorStateList = null;
                        break block9;
                    }
                    colorStateList = this.mHooks.getTintListForDrawableRes(context, n);
                }
                colorStateList = colorStateList2 = colorStateList;
                if (colorStateList2 != null) {
                    this.addTintListToCache(context, n, colorStateList2);
                    colorStateList = colorStateList2;
                }
            }
            return colorStateList;
        }
    }

    PorterDuff.Mode getTintMode(int n) {
        PorterDuff.Mode mode = this.mHooks == null ? null : this.mHooks.getTintModeForDrawableRes(n);
        return mode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigurationChanged(Context object) {
        synchronized (this) {
            object = this.mDrawableCaches.get(object);
            if (object != null) {
                ((LongSparseArray)object).clear();
            }
            return;
        }
    }

    Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int n) {
        synchronized (this) {
            Drawable drawable2;
            block6: {
                Drawable drawable3;
                drawable2 = drawable3 = this.loadDrawableFromDelegates(context, n);
                if (drawable3 != null) break block6;
                drawable2 = vectorEnabledTintResources.getDrawableCanonical(n);
            }
            if (drawable2 != null) {
                context = this.tintDrawable(context, n, false, drawable2);
                return context;
            }
            return null;
        }
    }

    public void setHooks(ResourceManagerHooks resourceManagerHooks) {
        synchronized (this) {
            this.mHooks = resourceManagerHooks;
            return;
        }
    }

    boolean tintDrawableUsingColorFilter(Context context, int n, Drawable drawable2) {
        boolean bl = this.mHooks != null && this.mHooks.tintDrawableUsingColorFilter(context, n, drawable2);
        return bl;
    }

    static class AsldcInflateDelegate
    implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        @Override
        public Drawable createFromXmlInner(Context object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                object = AnimatedStateListDrawableCompat.createFromXmlInner(object, object.getResources(), xmlPullParser, attributeSet, theme);
                return object;
            }
            catch (Exception exception) {
                Log.e((String)"AsldcInflateDelegate", (String)"Exception while inflating <animated-selector>", (Throwable)exception);
                return null;
            }
        }
    }

    private static class AvdcInflateDelegate
    implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override
        public Drawable createFromXmlInner(Context object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                object = AnimatedVectorDrawableCompat.createFromXmlInner(object, object.getResources(), xmlPullParser, attributeSet, theme);
                return object;
            }
            catch (Exception exception) {
                Log.e((String)"AvdcInflateDelegate", (String)"Exception while inflating <animated-vector>", (Throwable)exception);
                return null;
            }
        }
    }

    private static class ColorFilterLruCache
    extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int n) {
            super(n);
        }

        private static int generateCacheKey(int n, PorterDuff.Mode mode) {
            return (1 * 31 + n) * 31 + mode.hashCode();
        }

        PorterDuffColorFilter get(int n, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter)this.get(ColorFilterLruCache.generateCacheKey(n, mode));
        }

        PorterDuffColorFilter put(int n, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return this.put(ColorFilterLruCache.generateCacheKey(n, mode), porterDuffColorFilter);
        }
    }

    static class DrawableDelegate
    implements InflateDelegate {
        DrawableDelegate() {
        }

        @Override
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String string2 = attributeSet.getClassAttribute();
            if (string2 != null) {
                try {
                    string2 = DrawableDelegate.class.getClassLoader().loadClass(string2).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Compatibility.Api21Impl.inflate((Drawable)string2, context.getResources(), xmlPullParser, attributeSet, theme);
                    return string2;
                }
                catch (Exception exception) {
                    Log.e((String)"DrawableDelegate", (String)"Exception while inflating <drawable>", (Throwable)exception);
                    return null;
                }
            }
            return null;
        }
    }

    private static interface InflateDelegate {
        public Drawable createFromXmlInner(Context var1, XmlPullParser var2, AttributeSet var3, Resources.Theme var4);
    }

    public static interface ResourceManagerHooks {
        public Drawable createDrawableFor(ResourceManagerInternal var1, Context var2, int var3);

        public ColorStateList getTintListForDrawableRes(Context var1, int var2);

        public PorterDuff.Mode getTintModeForDrawableRes(int var1);

        public boolean tintDrawable(Context var1, int var2, Drawable var3);

        public boolean tintDrawableUsingColorFilter(Context var1, int var2, Drawable var3);
    }

    private static class VdcInflateDelegate
    implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override
        public Drawable createFromXmlInner(Context object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                object = VectorDrawableCompat.createFromXmlInner(object.getResources(), xmlPullParser, attributeSet, theme);
                return object;
            }
            catch (Exception exception) {
                Log.e((String)"VdcInflateDelegate", (String)"Exception while inflating <vector>", (Throwable)exception);
                return null;
            }
        }
    }
}

