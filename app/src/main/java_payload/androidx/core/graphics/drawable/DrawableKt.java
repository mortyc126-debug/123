/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  kotlin.Metadata
 */
package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2={"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable2, int n, int n2, Bitmap.Config config) {
        if (drawable2 instanceof BitmapDrawable) {
            if (((BitmapDrawable)drawable2).getBitmap() != null) {
                if (config == null || ((BitmapDrawable)drawable2).getBitmap().getConfig() == config) {
                    if (n == ((BitmapDrawable)drawable2).getBitmap().getWidth() && n2 == ((BitmapDrawable)drawable2).getBitmap().getHeight()) {
                        return ((BitmapDrawable)drawable2).getBitmap();
                    }
                    return Bitmap.createScaledBitmap((Bitmap)((BitmapDrawable)drawable2).getBitmap(), (int)n, (int)n2, (boolean)true);
                }
            } else {
                throw new IllegalArgumentException("bitmap is null");
            }
        }
        Rect rect = drawable2.getBounds();
        int n3 = rect.left;
        int n4 = rect.top;
        int n5 = rect.right;
        int n6 = rect.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        config = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
        drawable2.setBounds(0, 0, n, n2);
        drawable2.draw(new Canvas((Bitmap)config));
        drawable2.setBounds(n3, n4, n5, n6);
        return config;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable2, int n, int n2, Bitmap.Config config, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = drawable2.getIntrinsicWidth();
        }
        if ((n3 & 2) != 0) {
            n2 = drawable2.getIntrinsicHeight();
        }
        if ((n3 & 4) != 0) {
            config = null;
        }
        return DrawableKt.toBitmap(drawable2, n, n2, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable2, int n, int n2, Bitmap.Config config) {
        if (drawable2 instanceof BitmapDrawable && ((BitmapDrawable)drawable2).getBitmap() == null) {
            return null;
        }
        return DrawableKt.toBitmap(drawable2, n, n2, config);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable2, int n, int n2, Bitmap.Config config, int n3, Object object) {
        if ((n3 & 1) != 0) {
            n = drawable2.getIntrinsicWidth();
        }
        if ((n3 & 2) != 0) {
            n2 = drawable2.getIntrinsicHeight();
        }
        if ((n3 & 4) != 0) {
            config = null;
        }
        return DrawableKt.toBitmapOrNull(drawable2, n, n2, config);
    }

    public static final void updateBounds(Drawable drawable2, int n, int n2, int n3, int n4) {
        drawable2.setBounds(n, n2, n3, n4);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable2, int n, int n2, int n3, int n4, int n5, Object object) {
        if ((n5 & 1) != 0) {
            n = drawable2.getBounds().left;
        }
        if ((n5 & 2) != 0) {
            n2 = drawable2.getBounds().top;
        }
        if ((n5 & 4) != 0) {
            n3 = drawable2.getBounds().right;
        }
        if ((n5 & 8) != 0) {
            n4 = drawable2.getBounds().bottom;
        }
        DrawableKt.updateBounds(drawable2, n, n2, n3, n4);
    }
}

