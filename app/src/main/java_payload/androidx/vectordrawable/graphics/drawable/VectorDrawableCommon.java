/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon
extends Drawable
implements TintAwareDrawable {
    Drawable mDelegateDrawable;

    VectorDrawableCommon() {
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.applyTheme(this.mDelegateDrawable, theme);
            return;
        }
    }

    public void clearColorFilter() {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    public Drawable getCurrent() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumHeight() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.jumpToCurrentState(this.mDelegateDrawable);
            return;
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
            return;
        }
        super.onBoundsChange(rect);
    }

    protected boolean onLevelChange(int n) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setLevel(n);
        }
        return super.onLevelChange(n);
    }

    public void setChangingConfigurations(int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setChangingConfigurations(n);
            return;
        }
        super.setChangingConfigurations(n);
    }

    public void setColorFilter(int n, PorterDuff.Mode mode) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(n, mode);
            return;
        }
        super.setColorFilter(n, mode);
    }

    public void setFilterBitmap(boolean bl) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setFilterBitmap(bl);
            return;
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setHotspot(this.mDelegateDrawable, f, f2);
        }
    }

    public void setHotspotBounds(int n, int n2, int n3, int n4) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setHotspotBounds(this.mDelegateDrawable, n, n2, n3, n4);
            return;
        }
    }

    public boolean setState(int[] nArray) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(nArray);
        }
        return super.setState(nArray);
    }
}

