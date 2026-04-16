/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorSpace
 *  android.graphics.ColorSpace$Named
 *  android.graphics.Point
 *  android.graphics.PointF
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u00a2\u0006\u0002\b\u0010H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0086\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n\u00a8\u0006\u001c"}, d2={"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, Function1<? super Canvas, Unit> function1) {
        function1.invoke((Object)new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int n = bitmap.getWidth();
        int n2 = point.x;
        boolean bl = true;
        if ((n2 = n2 >= 0 && n2 < n ? 1 : 0) == 0 || point.y < 0 || point.y >= bitmap.getHeight()) {
            bl = false;
        }
        return bl;
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        boolean bl = pointF.x >= 0.0f && pointF.x < (float)bitmap.getWidth() && pointF.y >= 0.0f && pointF.y < (float)bitmap.getHeight();
        return bl;
    }

    public static final Bitmap createBitmap(int n, int n2, Bitmap.Config config) {
        return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
    }

    public static final Bitmap createBitmap(int n, int n2, Bitmap.Config config, boolean bl, ColorSpace colorSpace) {
        return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config, (boolean)bl, (ColorSpace)colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int n, int n2, Bitmap.Config config, int n3, Object object) {
        if ((n3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int n, int n2, Bitmap.Config config, boolean bl, ColorSpace colorSpace, int n3, Object object) {
        if ((n3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((n3 & 8) != 0) {
            bl = true;
        }
        if ((n3 & 0x10) != 0) {
            colorSpace = ColorSpace.get((ColorSpace.Named)ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config, (boolean)bl, (ColorSpace)colorSpace);
    }

    public static final int get(Bitmap bitmap, int n, int n2) {
        return bitmap.getPixel(n, n2);
    }

    public static final Bitmap scale(Bitmap bitmap, int n, int n2, boolean bl) {
        return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n, (int)n2, (boolean)bl);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int n, int n2, boolean bl, int n3, Object object) {
        if ((n3 & 4) != 0) {
            bl = true;
        }
        return Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n, (int)n2, (boolean)bl);
    }

    public static final void set(Bitmap bitmap, int n, int n2, int n3) {
        bitmap.setPixel(n, n2, n3);
    }
}

