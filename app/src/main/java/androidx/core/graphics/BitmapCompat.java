/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BlendMode
 *  android.graphics.Canvas
 *  android.graphics.ColorSpace
 *  android.graphics.ColorSpace$Named
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 */
package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.os.Build;

public final class BitmapCompat {
    private BitmapCompat() {
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int n, int n2, Rect rect, boolean bl) {
        if (n > 0 && n2 > 0) {
            Rect rect2;
            int n3;
            if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
                throw new IllegalArgumentException("srcRect must be contained by srcBm!");
            }
            Bitmap bitmap2 = bitmap;
            if (Build.VERSION.SDK_INT >= 27) {
                bitmap2 = Api27Impl.copyBitmapIfHardware(bitmap);
            }
            int n4 = rect != null ? rect.width() : bitmap.getWidth();
            int n5 = rect != null ? rect.height() : bitmap.getHeight();
            float f = (float)n / (float)n4;
            float f2 = (float)n2 / (float)n5;
            int n6 = rect != null ? rect.left : 0;
            int n7 = rect != null ? rect.top : 0;
            if (n6 == 0 && n7 == 0 && n == bitmap.getWidth() && n2 == bitmap.getHeight()) {
                if (bitmap.isMutable() && bitmap == bitmap2) {
                    return bitmap.copy(bitmap.getConfig(), true);
                }
                return bitmap2;
            }
            Paint paint = new Paint(1);
            paint.setFilterBitmap(true);
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.setPaintBlendMode(paint);
            } else {
                paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
            }
            if (n4 == n && n5 == n2) {
                bitmap = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)bitmap2.getConfig());
                new Canvas(bitmap).drawBitmap(bitmap2, (float)(-n6), (float)(-n7), paint);
                return bitmap;
            }
            double d = Math.log(2.0);
            int n8 = f > 1.0f ? (int)Math.ceil(Math.log(f) / d) : (int)Math.floor(Math.log(f) / d);
            int n9 = f2 > 1.0f ? (int)Math.ceil(Math.log(f2) / d) : (int)Math.floor(Math.log(f2) / d);
            rect = null;
            int n10 = 0;
            if (bl) {
                if (Build.VERSION.SDK_INT >= 27 && !Api27Impl.isAlreadyF16AndLinear(bitmap)) {
                    n10 = n8 > 0 ? BitmapCompat.sizeAtStep(n4, n, 1, n8) : n4;
                    n3 = n9 > 0 ? BitmapCompat.sizeAtStep(n5, n2, 1, n9) : n5;
                    rect2 = Api27Impl.createBitmapWithSourceColorspace(n10, n3, bitmap, true);
                    new Canvas((Bitmap)rect2).drawBitmap(bitmap2, (float)(-n6), (float)(-n7), paint);
                    n6 = 0;
                    n3 = 0;
                    rect = bitmap2;
                    bitmap2 = rect2;
                    n10 = 1;
                } else {
                    n3 = n7;
                }
            } else {
                n3 = n7;
            }
            n7 = n9;
            rect2 = new Rect(n6, n3, n4, n5);
            Rect rect3 = new Rect();
            int n11 = n8;
            int n12 = n6;
            while (true) {
                if (n11 == 0 && n7 == 0) {
                    if (rect != bitmap && rect != null) {
                        rect.recycle();
                    }
                    return bitmap2;
                }
                if (n11 < 0) {
                    n6 = n11 + 1;
                } else {
                    n6 = n11;
                    if (n11 > 0) {
                        n6 = n11 - 1;
                    }
                }
                if (n7 < 0) {
                    ++n7;
                } else if (n7 > 0) {
                    --n7;
                }
                rect3.set(0, 0, BitmapCompat.sizeAtStep(n4, n, n6, n8), BitmapCompat.sizeAtStep(n5, n2, n7, n9));
                n11 = n6 == 0 && n7 == 0 ? 1 : 0;
                int n13 = rect != null && rect.getWidth() == n && rect.getHeight() == n2 ? 1 : 0;
                if (rect == null || rect == bitmap || bl && Build.VERSION.SDK_INT >= 27 && !Api27Impl.isAlreadyF16AndLinear((Bitmap)rect) || n11 != 0 && (n13 == 0 || n10 != 0)) {
                    if (rect != bitmap && rect != null) {
                        rect.recycle();
                    }
                    n13 = n6 > 0 ? n10 : n6;
                    int n14 = BitmapCompat.sizeAtStep(n4, n, n13, n8);
                    n13 = n7 > 0 ? n10 : n7;
                    n13 = BitmapCompat.sizeAtStep(n5, n2, n13, n9);
                    if (Build.VERSION.SDK_INT >= 27) {
                        boolean bl2 = bl && n11 == 0;
                        rect = Api27Impl.createBitmapWithSourceColorspace(n14, n13, bitmap, bl2);
                    } else {
                        rect = Bitmap.createBitmap((int)n14, (int)n13, (Bitmap.Config)bitmap2.getConfig());
                    }
                }
                new Canvas((Bitmap)rect).drawBitmap(bitmap2, rect2, rect3, paint);
                Rect rect4 = rect;
                rect = bitmap2;
                rect2.set(rect3);
                bitmap2 = rect4;
                n11 = n6;
            }
        }
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    public static void setHasMipMap(Bitmap bitmap, boolean bl) {
        bitmap.setHasMipMap(bl);
    }

    static int sizeAtStep(int n, int n2, int n3, int n4) {
        if (n3 == 0) {
            return n2;
        }
        if (n3 > 0) {
            return (1 << n4 - n3) * n;
        }
        return n2 << -n3 - 1;
    }

    static class Api27Impl {
        private Api27Impl() {
        }

        static Bitmap copyBitmapIfHardware(Bitmap bitmap) {
            if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = Api31Impl.getHardwareBitmapConfig(bitmap);
                }
                return bitmap.copy(config, true);
            }
            return bitmap;
        }

        static Bitmap createBitmapWithSourceColorspace(int n, int n2, Bitmap bitmap, boolean bl) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get((ColorSpace.Named)ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (bl && !bitmap.getColorSpace().equals((Object)colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
            } else {
                colorSpace2 = colorSpace;
                if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                    config = Bitmap.Config.ARGB_8888;
                    colorSpace2 = colorSpace;
                    if (Build.VERSION.SDK_INT >= 31) {
                        config = Api31Impl.getHardwareBitmapConfig(bitmap);
                        colorSpace2 = colorSpace;
                    }
                }
            }
            return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config, (boolean)bitmap.hasAlpha(), (ColorSpace)colorSpace2);
        }

        static boolean isAlreadyF16AndLinear(Bitmap bitmap) {
            ColorSpace colorSpace = ColorSpace.get((ColorSpace.Named)ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            boolean bl = bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals((Object)colorSpace);
            return bl;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
            if (bitmap.getHardwareBuffer().getFormat() == 22) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
    }
}

