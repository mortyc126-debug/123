/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Build;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils;
import androidx.core.util.Pair;

public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udb3f\udffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal();

    private PaintCompat() {
    }

    public static boolean hasGlyph(Paint paint, String string2) {
        return Api23Impl.hasGlyph(paint, string2);
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        Pair<Rect, Rect> pair = sRectThreadLocal.get();
        if (pair == null) {
            pair = new Pair<Rect, Rect>(new Rect(), new Rect());
            sRectThreadLocal.set(pair);
        } else {
            ((Rect)pair.first).setEmpty();
            ((Rect)pair.second).setEmpty();
        }
        return pair;
    }

    public static boolean setBlendMode(Paint paint, BlendModeCompat object) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        Object var4_4 = null;
        PorterDuff.Mode mode = null;
        if (n >= 29) {
            object = object != null ? BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(object) : mode;
            Api29Impl.setBlendMode(paint, object);
            return true;
        }
        if (object != null) {
            mode = BlendModeUtils.obtainPorterDuffFromCompat(object);
            object = var4_4;
            if (mode != null) {
                object = new PorterDuffXfermode(mode);
            }
            paint.setXfermode((Xfermode)object);
            if (mode == null) {
                bl = false;
            }
            return bl;
        }
        paint.setXfermode(null);
        return true;
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean hasGlyph(Paint paint, String string2) {
            return paint.hasGlyph(string2);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setBlendMode(Paint paint, Object object) {
            paint.setBlendMode((BlendMode)object);
        }
    }
}

