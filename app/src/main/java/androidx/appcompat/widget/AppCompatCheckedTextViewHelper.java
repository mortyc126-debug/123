/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CheckedTextView
 */
package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

class AppCompatCheckedTextViewHelper {
    private ColorStateList mCheckMarkTintList = null;
    private PorterDuff.Mode mCheckMarkTintMode = null;
    private boolean mHasCheckMarkTint = false;
    private boolean mHasCheckMarkTintMode = false;
    private boolean mSkipNextApply;
    private final CheckedTextView mView;

    AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.mView = checkedTextView;
    }

    void applyCheckMarkTint() {
        Drawable drawable2 = CheckedTextViewCompat.getCheckMarkDrawable(this.mView);
        if (drawable2 != null && (this.mHasCheckMarkTint || this.mHasCheckMarkTintMode)) {
            drawable2 = DrawableCompat.wrap(drawable2).mutate();
            if (this.mHasCheckMarkTint) {
                DrawableCompat.setTintList(drawable2, this.mCheckMarkTintList);
            }
            if (this.mHasCheckMarkTintMode) {
                DrawableCompat.setTintMode(drawable2, this.mCheckMarkTintMode);
            }
            if (drawable2.isStateful()) {
                drawable2.setState(this.mView.getDrawableState());
            }
            this.mView.setCheckMarkDrawable(drawable2);
        }
    }

    ColorStateList getSupportCheckMarkTintList() {
        return this.mCheckMarkTintList;
    }

    PorterDuff.Mode getSupportCheckMarkTintMode() {
        return this.mCheckMarkTintMode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void loadFromAttributes(AttributeSet attributeSet, int n) {
        int n2;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, R.styleable.CheckedTextView, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this.mView, this.mView.getContext(), R.styleable.CheckedTextView, attributeSet, tintTypedArray.getWrappedTypeArray(), n, 0);
        n = n2 = 0;
        try {
            if (tintTypedArray.hasValue(R.styleable.CheckedTextView_checkMarkCompat)) {
                int n3 = tintTypedArray.getResourceId(R.styleable.CheckedTextView_checkMarkCompat, 0);
                n = n2;
                if (n3 != 0) {
                    try {
                        this.mView.setCheckMarkDrawable(AppCompatResources.getDrawable(this.mView.getContext(), n3));
                        n = 1;
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        n = n2;
                    }
                }
            }
            if (n == 0 && tintTypedArray.hasValue(R.styleable.CheckedTextView_android_checkMark) && (n = tintTypedArray.getResourceId(R.styleable.CheckedTextView_android_checkMark, 0)) != 0) {
                this.mView.setCheckMarkDrawable(AppCompatResources.getDrawable(this.mView.getContext(), n));
            }
            if (tintTypedArray.hasValue(R.styleable.CheckedTextView_checkMarkTint)) {
                CheckedTextViewCompat.setCheckMarkTintList(this.mView, tintTypedArray.getColorStateList(R.styleable.CheckedTextView_checkMarkTint));
            }
            if (!tintTypedArray.hasValue(R.styleable.CheckedTextView_checkMarkTintMode)) return;
            CheckedTextViewCompat.setCheckMarkTintMode(this.mView, DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.CheckedTextView_checkMarkTintMode, -1), null));
            return;
        }
        finally {
            tintTypedArray.recycle();
        }
    }

    void onSetCheckMarkDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
            return;
        }
        this.mSkipNextApply = true;
        this.applyCheckMarkTint();
    }

    void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        this.mCheckMarkTintList = colorStateList;
        this.mHasCheckMarkTint = true;
        this.applyCheckMarkTint();
    }

    void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        this.mCheckMarkTintMode = mode;
        this.mHasCheckMarkTintMode = true;
        this.applyCheckMarkTint();
    }
}

