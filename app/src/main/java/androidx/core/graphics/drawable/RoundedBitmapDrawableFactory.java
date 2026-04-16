/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Rect
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.graphics.BitmapCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable21;
import androidx.core.view.GravityCompat;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources resources, Bitmap bitmap) {
        return new RoundedBitmapDrawable21(resources, bitmap);
    }

    public static RoundedBitmapDrawable create(Resources object, InputStream inputStream) {
        if (((RoundedBitmapDrawable)((Object)(object = RoundedBitmapDrawableFactory.create((Resources)object, BitmapFactory.decodeStream((InputStream)inputStream))))).getBitmap() == null) {
            Log.w((String)TAG, (String)("RoundedBitmapDrawable cannot decode " + inputStream));
        }
        return object;
    }

    public static RoundedBitmapDrawable create(Resources object, String string2) {
        if (((RoundedBitmapDrawable)((Object)(object = RoundedBitmapDrawableFactory.create((Resources)object, BitmapFactory.decodeFile((String)string2))))).getBitmap() == null) {
            Log.w((String)TAG, (String)("RoundedBitmapDrawable cannot decode " + string2));
        }
        return object;
    }

    private static class DefaultRoundedBitmapDrawable
    extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override
        void gravityCompatApply(int n, int n2, int n3, Rect rect, Rect rect2) {
            GravityCompat.apply(n, n2, n3, rect, rect2, 0);
        }

        @Override
        public boolean hasMipMap() {
            boolean bl = this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap);
            return bl;
        }

        @Override
        public void setMipMap(boolean bl) {
            if (this.mBitmap != null) {
                BitmapCompat.setHasMipMap(this.mBitmap, bl);
                this.invalidateSelf();
            }
        }
    }
}

