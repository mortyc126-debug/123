/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.RippleDrawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ImageView
 */
package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private int mLevel = 0;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable2) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList colorStateList = ImageViewCompat.getImageTintList(this.mView);
        if (colorStateList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = colorStateList;
        }
        if ((colorStateList = ImageViewCompat.getImageTintMode(this.mView)) != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = colorStateList;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            return false;
        }
        AppCompatDrawableManager.tintDrawable(drawable2, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int n = Build.VERSION.SDK_INT;
        boolean bl = this.mInternalImageTint != null;
        return bl;
    }

    void applyImageLevel() {
        if (this.mView.getDrawable() != null) {
            this.mView.getDrawable().setLevel(this.mLevel);
        }
    }

    void applySupportImageTint() {
        Drawable drawable2 = this.mView.getDrawable();
        if (drawable2 != null) {
            DrawableUtils.fixDrawable(drawable2);
        }
        if (drawable2 != null) {
            if (this.shouldApplyFrameworkTintUsingColorFilter() && this.applyFrameworkTintUsingColorFilter(drawable2)) {
                return;
            }
            if (this.mImageTint != null) {
                AppCompatDrawableManager.tintDrawable(drawable2, this.mImageTint, this.mView.getDrawableState());
            } else if (this.mInternalImageTint != null) {
                AppCompatDrawableManager.tintDrawable(drawable2, this.mInternalImageTint, this.mView.getDrawableState());
            }
        }
    }

    ColorStateList getSupportImageTintList() {
        ColorStateList colorStateList = this.mImageTint != null ? this.mImageTint.mTintList : null;
        return colorStateList;
    }

    PorterDuff.Mode getSupportImageTintMode() {
        PorterDuff.Mode mode = this.mImageTint != null ? this.mImageTint.mTintMode : null;
        return mode;
    }

    boolean hasOverlappingRendering() {
        return !(this.mView.getBackground() instanceof RippleDrawable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadFromAttributes(AttributeSet attributeSet, int n) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.AppCompatImageView, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this.mView, this.mView.getContext(), R.styleable.AppCompatImageView, attributeSet, tintTypedArray.getWrappedTypeArray(), n, 0);
        try {
            Drawable drawable2 = this.mView.getDrawable();
            attributeSet = drawable2;
            if (drawable2 == null) {
                n = tintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
                attributeSet = drawable2;
                if (n != -1) {
                    drawable2 = AppCompatResources.getDrawable(this.mView.getContext(), n);
                    attributeSet = drawable2;
                    if (drawable2 != null) {
                        this.mView.setImageDrawable(drawable2);
                        attributeSet = drawable2;
                    }
                }
            }
            if (attributeSet != null) {
                DrawableUtils.fixDrawable((Drawable)attributeSet);
            }
            if (tintTypedArray.hasValue(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.mView, tintTypedArray.getColorStateList(R.styleable.AppCompatImageView_tint));
            }
            if (!tintTypedArray.hasValue(R.styleable.AppCompatImageView_tintMode)) return;
            ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null));
            return;
        }
        finally {
            tintTypedArray.recycle();
        }
    }

    void obtainLevelFromDrawable(Drawable drawable2) {
        this.mLevel = drawable2.getLevel();
    }

    public void setImageResource(int n) {
        if (n != 0) {
            Drawable drawable2 = AppCompatResources.getDrawable(this.mView.getContext(), n);
            if (drawable2 != null) {
                DrawableUtils.fixDrawable(drawable2);
            }
            this.mView.setImageDrawable(drawable2);
        } else {
            this.mView.setImageDrawable(null);
        }
        this.applySupportImageTint();
    }

    void setInternalImageTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new TintInfo();
            }
            this.mInternalImageTint.mTintList = colorStateList;
            this.mInternalImageTint.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        this.applySupportImageTint();
    }

    void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        this.mImageTint.mTintList = colorStateList;
        this.mImageTint.mHasTintList = true;
        this.applySupportImageTint();
    }

    void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        this.mImageTint.mTintMode = mode;
        this.mImageTint.mHasTintMode = true;
        this.applySupportImageTint();
    }
}

