/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(Drawable drawable2, Resources.Theme theme) {
        Api21Impl.applyTheme(drawable2, theme);
    }

    public static boolean canApplyTheme(Drawable drawable2) {
        return Api21Impl.canApplyTheme(drawable2);
    }

    public static void clearColorFilter(Drawable drawable2) {
        drawable2.clearColorFilter();
    }

    public static int getAlpha(Drawable drawable2) {
        return drawable2.getAlpha();
    }

    public static ColorFilter getColorFilter(Drawable drawable2) {
        return Api21Impl.getColorFilter(drawable2);
    }

    public static int getLayoutDirection(Drawable drawable2) {
        return Api23Impl.getLayoutDirection(drawable2);
    }

    public static void inflate(Drawable drawable2, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.inflate(drawable2, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean isAutoMirrored(Drawable drawable2) {
        return drawable2.isAutoMirrored();
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable drawable2) {
        drawable2.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable2, boolean bl) {
        drawable2.setAutoMirrored(bl);
    }

    public static void setHotspot(Drawable drawable2, float f, float f2) {
        Api21Impl.setHotspot(drawable2, f, f2);
    }

    public static void setHotspotBounds(Drawable drawable2, int n, int n2, int n3, int n4) {
        Api21Impl.setHotspotBounds(drawable2, n, n2, n3, n4);
    }

    public static boolean setLayoutDirection(Drawable drawable2, int n) {
        return Api23Impl.setLayoutDirection(drawable2, n);
    }

    public static void setTint(Drawable drawable2, int n) {
        Api21Impl.setTint(drawable2, n);
    }

    public static void setTintList(Drawable drawable2, ColorStateList colorStateList) {
        Api21Impl.setTintList(drawable2, colorStateList);
    }

    public static void setTintMode(Drawable drawable2, PorterDuff.Mode mode) {
        Api21Impl.setTintMode(drawable2, mode);
    }

    public static <T extends Drawable> T unwrap(Drawable drawable2) {
        if (drawable2 instanceof WrappedDrawable) {
            return (T)((WrappedDrawable)drawable2).getWrappedDrawable();
        }
        return (T)drawable2;
    }

    public static Drawable wrap(Drawable drawable2) {
        return drawable2;
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void applyTheme(Drawable drawable2, Resources.Theme theme) {
            drawable2.applyTheme(theme);
        }

        static boolean canApplyTheme(Drawable drawable2) {
            return drawable2.canApplyTheme();
        }

        static ColorFilter getColorFilter(Drawable drawable2) {
            return drawable2.getColorFilter();
        }

        static void inflate(Drawable drawable2, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable2.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void setHotspot(Drawable drawable2, float f, float f2) {
            drawable2.setHotspot(f, f2);
        }

        static void setHotspotBounds(Drawable drawable2, int n, int n2, int n3, int n4) {
            drawable2.setHotspotBounds(n, n2, n3, n4);
        }

        static void setTint(Drawable drawable2, int n) {
            drawable2.setTint(n);
        }

        static void setTintList(Drawable drawable2, ColorStateList colorStateList) {
            drawable2.setTintList(colorStateList);
        }

        static void setTintMode(Drawable drawable2, PorterDuff.Mode mode) {
            drawable2.setTintMode(mode);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getLayoutDirection(Drawable drawable2) {
            return drawable2.getLayoutDirection();
        }

        static boolean setLayoutDirection(Drawable drawable2, int n) {
            return drawable2.setLayoutDirection(n);
        }
    }
}

