/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

public class ButtonBarLayout
extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize = -1;
    private boolean mStacked;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        ViewCompat.saveAttributeDataForStyleable((View)this, context, R.styleable.ButtonBarLayout, attributeSet, typedArray, 0, 0);
        this.mAllowStacking = typedArray.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
        typedArray.recycle();
        if (this.getOrientation() == 1) {
            this.setStacked(this.mAllowStacking);
        }
    }

    private int getNextVisibleChildIndex(int n) {
        int n2 = this.getChildCount();
        while (n < n2) {
            if (this.getChildAt(n).getVisibility() == 0) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    private boolean isStacked() {
        return this.mStacked;
    }

    private void setStacked(boolean n) {
        if (this.mStacked != n && (n == 0 || this.mAllowStacking)) {
            this.mStacked = n;
            this.setOrientation(n);
            int n2 = n != 0 ? 0x800005 : 80;
            this.setGravity(n2);
            View view = this.findViewById(R.id.spacer);
            if (view != null) {
                n = n != 0 ? 8 : 4;
                view.setVisibility(n);
            }
            for (n = this.getChildCount() - 2; n >= 0; --n) {
                this.bringChildToFront(this.getChildAt(n));
            }
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        int n4 = View.MeasureSpec.getSize((int)n);
        if (this.mAllowStacking) {
            if (n4 > this.mLastWidthSize && this.isStacked()) {
                this.setStacked(false);
            }
            this.mLastWidthSize = n4;
        }
        int n5 = 0;
        if (!this.isStacked() && View.MeasureSpec.getMode((int)n) == 0x40000000) {
            n4 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)Integer.MIN_VALUE);
            n5 = 1;
        } else {
            n4 = n;
        }
        super.onMeasure(n4, n2);
        n4 = n5;
        if (this.mAllowStacking) {
            n4 = n5;
            if (!this.isStacked()) {
                n3 = (0xFF000000 & this.getMeasuredWidthAndState()) == 0x1000000 ? 1 : 0;
                n4 = n5;
                if (n3 != 0) {
                    this.setStacked(true);
                    n4 = 1;
                }
            }
        }
        if (n4 != 0) {
            super.onMeasure(n, n2);
        }
        n5 = 0;
        n3 = this.getNextVisibleChildIndex(0);
        if (n3 >= 0) {
            View view = this.getChildAt(n3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
            n4 = 0 + (this.getPaddingTop() + view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            if (this.isStacked()) {
                n3 = this.getNextVisibleChildIndex(n3 + 1);
                n5 = n4;
                if (n3 >= 0) {
                    n5 = n4 + (this.getChildAt(n3).getPaddingTop() + (int)(this.getResources().getDisplayMetrics().density * 16.0f));
                }
            } else {
                n5 = n4 + this.getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight((View)this) != n5) {
            this.setMinimumHeight(n5);
            if (n2 == 0) {
                super.onMeasure(n, n2);
            }
        }
    }

    public void setAllowStacking(boolean bl) {
        if (this.mAllowStacking != bl) {
            this.mAllowStacking = bl;
            if (!this.mAllowStacking && this.isStacked()) {
                this.setStacked(false);
            }
            this.requestLayout();
        }
    }
}

