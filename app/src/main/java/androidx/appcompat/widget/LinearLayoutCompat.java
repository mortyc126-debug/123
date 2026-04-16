/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.LinearLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat
extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned = true;
    private int mBaselineAlignedChildIndex = -1;
    private int mBaselineChildTop = 0;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity = 0x800033;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        boolean bl;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this, context, R.styleable.LinearLayoutCompat, attributeSet, tintTypedArray.getWrappedTypeArray(), n, 0);
        n = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (n >= 0) {
            this.setOrientation(n);
        }
        if ((n = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1)) >= 0) {
            this.setGravity(n);
        }
        if (!(bl = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true))) {
            this.setBaselineAligned(bl);
        }
        this.mWeightSum = tintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(tintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArray.recycle();
    }

    private void forceUniformHeight(int n, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0x40000000);
        for (int i = 0; i < n; ++i) {
            View view = this.getVirtualChildAt(i);
            if (view.getVisibility() == 8) continue;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (layoutParams.height != -1) continue;
            int n4 = layoutParams.width;
            layoutParams.width = view.getMeasuredWidth();
            this.measureChildWithMargins(view, n2, 0, n3, 0);
            layoutParams.width = n4;
        }
    }

    private void forceUniformWidth(int n, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000);
        for (int i = 0; i < n; ++i) {
            View view = this.getVirtualChildAt(i);
            if (view.getVisibility() == 8) continue;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (layoutParams.width != -1) continue;
            int n4 = layoutParams.height;
            layoutParams.height = view.getMeasuredHeight();
            this.measureChildWithMargins(view, n3, 0, n2, 0);
            layoutParams.height = n4;
        }
    }

    private void setChildFrame(View view, int n, int n2, int n3, int n4) {
        view.layout(n, n2, n + n3, n2 + n4);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        LayoutParams layoutParams;
        View view;
        int n;
        int n2 = this.getVirtualChildCount();
        boolean bl = ViewUtils.isLayoutRtl((View)this);
        for (n = 0; n < n2; ++n) {
            view = this.getVirtualChildAt(n);
            if (view == null || view.getVisibility() == 8 || !this.hasDividerBeforeChildAt(n)) continue;
            layoutParams = (LayoutParams)view.getLayoutParams();
            int n3 = bl ? view.getRight() + layoutParams.rightMargin : view.getLeft() - layoutParams.leftMargin - this.mDividerWidth;
            this.drawVerticalDivider(canvas, n3);
        }
        if (this.hasDividerBeforeChildAt(n2)) {
            view = this.getVirtualChildAt(n2 - 1);
            if (view == null) {
                n = bl ? this.getPaddingLeft() : this.getWidth() - this.getPaddingRight() - this.mDividerWidth;
            } else {
                layoutParams = (LayoutParams)view.getLayoutParams();
                n = bl ? view.getLeft() - layoutParams.leftMargin - this.mDividerWidth : view.getRight() + layoutParams.rightMargin;
            }
            this.drawVerticalDivider(canvas, n);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        LayoutParams layoutParams;
        View view;
        int n;
        int n2 = this.getVirtualChildCount();
        for (n = 0; n < n2; ++n) {
            view = this.getVirtualChildAt(n);
            if (view == null || view.getVisibility() == 8 || !this.hasDividerBeforeChildAt(n)) continue;
            layoutParams = (LayoutParams)view.getLayoutParams();
            this.drawHorizontalDivider(canvas, view.getTop() - layoutParams.topMargin - this.mDividerHeight);
        }
        if (this.hasDividerBeforeChildAt(n2)) {
            view = this.getVirtualChildAt(n2 - 1);
            if (view == null) {
                n = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
            } else {
                layoutParams = (LayoutParams)view.getLayoutParams();
                n = view.getBottom() + layoutParams.bottomMargin;
            }
            this.drawHorizontalDivider(canvas, n);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int n) {
        this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, n, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, this.mDividerHeight + n);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int n) {
        this.mDivider.setBounds(n, this.getPaddingTop() + this.mDividerPadding, this.mDividerWidth + n, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (this.getChildCount() > this.mBaselineAlignedChildIndex) {
            int n;
            View view = this.getChildAt(this.mBaselineAlignedChildIndex);
            int n2 = view.getBaseline();
            if (n2 == -1) {
                if (this.mBaselineAlignedChildIndex == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int n3 = n = this.mBaselineChildTop;
            if (this.mOrientation == 1) {
                int n4 = this.mGravity & 0x70;
                n3 = n;
                if (n4 != 48) {
                    switch (n4) {
                        default: {
                            n3 = n;
                            break;
                        }
                        case 80: {
                            n3 = this.getBottom() - this.getTop() - this.getPaddingBottom() - this.mTotalLength;
                            break;
                        }
                        case 16: {
                            n3 = n + (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.mTotalLength) / 2;
                        }
                    }
                }
            }
            return ((LayoutParams)view.getLayoutParams()).topMargin + n3 + n2;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int n) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int n) {
        return this.getChildAt(n);
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int n) {
        boolean bl = false;
        boolean bl2 = false;
        if (n == 0) {
            if ((this.mShowDividers & 1) != 0) {
                bl2 = true;
            }
            return bl2;
        }
        if (n == this.getChildCount()) {
            bl2 = bl;
            if ((this.mShowDividers & 4) != 0) {
                bl2 = true;
            }
            return bl2;
        }
        if ((this.mShowDividers & 2) != 0) {
            bl = false;
            --n;
            while (true) {
                bl2 = bl;
                if (n < 0) break;
                if (this.getChildAt(n).getVisibility() != 8) {
                    bl2 = true;
                    break;
                }
                --n;
            }
            return bl2;
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    void layoutHorizontal(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        boolean bl = ViewUtils.isLayoutRtl((View)this);
        int n7 = this.getPaddingTop();
        int n8 = n4 - n2;
        int n9 = n8 - this.getPaddingBottom();
        int n10 = this.getPaddingBottom();
        int n11 = this.getVirtualChildCount();
        n2 = this.mGravity;
        int n12 = this.mGravity;
        boolean bl2 = this.mBaselineAligned;
        int[] nArray = this.mMaxAscent;
        int[] nArray2 = this.mMaxDescent;
        int n13 = ViewCompat.getLayoutDirection((View)this);
        switch (GravityCompat.getAbsoluteGravity(n2 & 0x800007, n13)) {
            default: {
                n = this.getPaddingLeft();
                break;
            }
            case 5: {
                n = this.getPaddingLeft() + n3 - n - this.mTotalLength;
                break;
            }
            case 1: {
                n = this.getPaddingLeft() + (n3 - n - this.mTotalLength) / 2;
            }
        }
        if (bl) {
            n6 = n11 - 1;
            n5 = -1;
        } else {
            n6 = 0;
            n5 = 1;
        }
        int n14 = n8;
        n3 = n7;
        n4 = n;
        for (n2 = 0; n2 < n11; ++n2) {
            int n15 = n6 + n5 * n2;
            View view = this.getVirtualChildAt(n15);
            if (view == null) {
                n4 += this.measureNullChild(n15);
                continue;
            }
            if (view.getVisibility() == 8) continue;
            int n16 = view.getMeasuredWidth();
            int n17 = view.getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            n = bl2 && layoutParams.height != -1 ? view.getBaseline() : -1;
            int n18 = layoutParams.gravity;
            if (n18 < 0) {
                n18 = n12 & 0x70;
            }
            switch (n18 & 0x70) {
                default: {
                    n = n3;
                    break;
                }
                case 80: {
                    n18 = n9 - n17 - layoutParams.bottomMargin;
                    if (n != -1) {
                        int n19 = view.getMeasuredHeight();
                        n = n18 - (nArray2[2] - (n19 - n));
                        break;
                    }
                    n = n18;
                    break;
                }
                case 48: {
                    n18 = layoutParams.topMargin + n3;
                    if (n != -1) {
                        n = n18 + (nArray[1] - n);
                        break;
                    }
                    n = n18;
                    break;
                }
                case 16: {
                    n = (n8 - n7 - n10 - n17) / 2 + n3 + layoutParams.topMargin - layoutParams.bottomMargin;
                }
            }
            n18 = n4;
            if (this.hasDividerBeforeChildAt(n15)) {
                n18 = n4 + this.mDividerWidth;
            }
            n4 = n18 + layoutParams.leftMargin;
            this.setChildFrame(view, n4 + this.getLocationOffset(view), n, n16, n17);
            n = layoutParams.rightMargin;
            n18 = this.getNextLocationOffset(view);
            n2 += this.getChildrenSkipCount(view, n15);
            n4 += n16 + n + n18;
        }
    }

    void layoutVertical(int n, int n2, int n3, int n4) {
        int n5 = this.getPaddingLeft();
        int n6 = n3 - n;
        int n7 = this.getPaddingRight();
        int n8 = this.getPaddingRight();
        int n9 = this.getVirtualChildCount();
        n = this.mGravity;
        int n10 = this.mGravity;
        switch (n & 0x70) {
            default: {
                n = this.getPaddingTop();
                break;
            }
            case 80: {
                n = this.getPaddingTop() + n4 - n2 - this.mTotalLength;
                break;
            }
            case 16: {
                n = this.getPaddingTop() + (n4 - n2 - this.mTotalLength) / 2;
            }
        }
        n2 = 0;
        n3 = n5;
        while (true) {
            n4 = n3;
            if (n2 >= n9) break;
            View view = this.getVirtualChildAt(n2);
            if (view == null) {
                n += this.measureNullChild(n2);
            } else if (view.getVisibility() != 8) {
                int n11 = view.getMeasuredWidth();
                int n12 = view.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                n3 = layoutParams.gravity;
                if (n3 < 0) {
                    n3 = n10 & 0x800007;
                }
                switch (GravityCompat.getAbsoluteGravity(n3, ViewCompat.getLayoutDirection((View)this)) & 7) {
                    default: {
                        n3 = layoutParams.leftMargin + n4;
                        break;
                    }
                    case 5: {
                        n3 = n6 - n7 - n11 - layoutParams.rightMargin;
                        break;
                    }
                    case 1: {
                        n3 = (n6 - n5 - n8 - n11) / 2 + n4 + layoutParams.leftMargin - layoutParams.rightMargin;
                    }
                }
                int n13 = n;
                if (this.hasDividerBeforeChildAt(n2)) {
                    n13 = n + this.mDividerHeight;
                }
                n = n13 + layoutParams.topMargin;
                this.setChildFrame(view, n3, n + this.getLocationOffset(view), n11, n12);
                n13 = layoutParams.bottomMargin;
                n3 = this.getNextLocationOffset(view);
                n2 += this.getChildrenSkipCount(view, n2);
                n += n12 + n13 + n3;
            }
            ++n2;
            n3 = n4;
        }
    }

    void measureChildBeforeLayout(View view, int n, int n2, int n3, int n4, int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }

    void measureHorizontal(int n, int n2) {
        block44: {
            int n3;
            int n4;
            int n5;
            int n6;
            LayoutParams layoutParams;
            Object object;
            int n7;
            this.mTotalLength = 0;
            int n8 = this.getVirtualChildCount();
            int n9 = View.MeasureSpec.getMode((int)n);
            int n10 = View.MeasureSpec.getMode((int)n2);
            if (this.mMaxAscent == null || this.mMaxDescent == null) {
                this.mMaxAscent = new int[4];
                this.mMaxDescent = new int[4];
            }
            int[] nArray = this.mMaxAscent;
            Object object2 = this.mMaxDescent;
            nArray[3] = -1;
            nArray[2] = -1;
            nArray[1] = -1;
            nArray[0] = -1;
            object2[3] = -1;
            object2[2] = -1;
            object2[1] = -1;
            object2[0] = -1;
            boolean bl = this.mBaselineAligned;
            boolean bl2 = this.mUseLargestChild;
            boolean bl3 = n9 == 0x40000000;
            int n11 = 0;
            float f = 0.0f;
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            boolean bl4 = true;
            int n16 = 0;
            int n17 = 0;
            for (n7 = 0; n7 < n8; ++n7) {
                int n18;
                object = this.getVirtualChildAt(n7);
                if (object == null) {
                    this.mTotalLength += this.measureNullChild(n7);
                    continue;
                }
                if (object.getVisibility() == 8) {
                    n7 += this.getChildrenSkipCount((View)object, n7);
                    continue;
                }
                if (this.hasDividerBeforeChildAt(n7)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                layoutParams = (LayoutParams)object.getLayoutParams();
                f += layoutParams.weight;
                if (n9 == 0x40000000 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    if (bl3) {
                        this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        n6 = this.mTotalLength;
                        this.mTotalLength = Math.max(n6, layoutParams.leftMargin + n6 + layoutParams.rightMargin);
                    }
                    if (bl) {
                        n6 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                        object.measure(n6, n6);
                        n6 = n16;
                    } else {
                        n14 = 1;
                        n6 = n16;
                    }
                } else {
                    if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        layoutParams.width = -2;
                        n6 = 0;
                    } else {
                        n6 = Integer.MIN_VALUE;
                    }
                    n5 = f == 0.0f ? this.mTotalLength : 0;
                    n4 = n16;
                    this.measureChildBeforeLayout((View)object, n7, n, n5, n2, 0);
                    if (n6 != Integer.MIN_VALUE) {
                        layoutParams.width = n6;
                    }
                    n5 = object.getMeasuredWidth();
                    if (bl3) {
                        this.mTotalLength += layoutParams.leftMargin + n5 + layoutParams.rightMargin + this.getNextLocationOffset((View)object);
                    } else {
                        n6 = this.mTotalLength;
                        this.mTotalLength = Math.max(n6, n6 + n5 + layoutParams.leftMargin + layoutParams.rightMargin + this.getNextLocationOffset((View)object));
                    }
                    if (bl2) {
                        n13 = Math.max(n5, n13);
                    }
                }
                n6 = n16;
                n5 = n4 = 0;
                n16 = n15;
                if (n10 != 0x40000000) {
                    n5 = n4;
                    n16 = n15;
                    if (layoutParams.height == -1) {
                        n16 = 1;
                        n5 = 1;
                    }
                }
                n15 = layoutParams.topMargin + layoutParams.bottomMargin;
                n4 = object.getMeasuredHeight() + n15;
                n3 = View.combineMeasuredStates((int)n12, (int)object.getMeasuredState());
                if (bl && (n18 = object.getBaseline()) != -1) {
                    n12 = layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity;
                    n12 = ((n12 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                    nArray[n12] = Math.max(nArray[n12], n18);
                    object2[n12] = Math.max(object2[n12], n4 - n18);
                }
                n11 = Math.max(n11, n4);
                bl4 = bl4 && layoutParams.height == -1;
                if (layoutParams.weight > 0.0f) {
                    n12 = n5 != 0 ? n15 : n4;
                    n17 = Math.max(n17, n12);
                    n12 = n6;
                } else {
                    if (n5 == 0) {
                        n15 = n4;
                    }
                    n12 = Math.max(n6, n15);
                }
                n7 += this.getChildrenSkipCount((View)object, n7);
                n6 = n3;
                n5 = n12;
                n15 = n16;
                n12 = n6;
                n16 = n5;
            }
            n7 = n17;
            n6 = n13;
            if (this.mTotalLength > 0 && this.hasDividerBeforeChildAt(n8)) {
                this.mTotalLength += this.mDividerWidth;
            }
            n13 = nArray[1] == -1 && nArray[0] == -1 && nArray[2] == -1 && nArray[3] == -1 ? n11 : Math.max(n11, Math.max(nArray[3], Math.max(nArray[0], Math.max(nArray[1], nArray[2]))) + Math.max(object2[3], Math.max(object2[0], Math.max(object2[1], object2[2]))));
            if (bl2 && (n9 == Integer.MIN_VALUE || n9 == 0)) {
                this.mTotalLength = 0;
                for (n17 = 0; n17 < n8; ++n17) {
                    object = this.getVirtualChildAt(n17);
                    if (object == null) {
                        this.mTotalLength += this.measureNullChild(n17);
                        continue;
                    }
                    if (object.getVisibility() == 8) {
                        n17 += this.getChildrenSkipCount((View)object, n17);
                        continue;
                    }
                    layoutParams = (LayoutParams)object.getLayoutParams();
                    if (bl3) {
                        this.mTotalLength += layoutParams.leftMargin + n6 + layoutParams.rightMargin + this.getNextLocationOffset((View)object);
                        continue;
                    }
                    n11 = this.mTotalLength;
                    this.mTotalLength = Math.max(n11, n11 + n6 + layoutParams.leftMargin + layoutParams.rightMargin + this.getNextLocationOffset((View)object));
                }
            }
            this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
            n17 = View.resolveSizeAndState((int)Math.max(this.mTotalLength, this.getSuggestedMinimumWidth()), (int)n, (int)0);
            n11 = n17 & 0xFFFFFF;
            n4 = n11 - this.mTotalLength;
            if (!(n14 != 0 || n4 != 0 && f > 0.0f)) {
                n16 = Math.max(n16, n7);
                if (bl2 && n9 != 0x40000000) {
                    n9 = n11;
                    for (n7 = 0; n7 < n8; ++n7) {
                        object2 = this.getVirtualChildAt(n7);
                        if (object2 == null || object2.getVisibility() == 8 || !(((LayoutParams)object2.getLayoutParams()).weight > 0.0f)) continue;
                        object2.measure(View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)object2.getMeasuredHeight(), (int)0x40000000));
                    }
                }
                n9 = n17;
                n17 = n16;
                n16 = n13;
                n13 = n17;
                n17 = n12;
                n12 = n9;
            } else {
                n6 = n16;
                if (this.mWeightSum > 0.0f) {
                    f = this.mWeightSum;
                }
                nArray[3] = -1;
                nArray[2] = -1;
                nArray[1] = -1;
                nArray[0] = -1;
                object2[3] = -1;
                object2[2] = -1;
                object2[1] = -1;
                object2[0] = -1;
                this.mTotalLength = 0;
                n5 = 0;
                n13 = n4;
                n11 = -1;
                n16 = n12;
                n14 = n7;
                n7 = n11;
                n11 = n9;
                n9 = n6;
                n12 = n8;
                for (n6 = n5; n6 < n12; ++n6) {
                    layoutParams = this.getVirtualChildAt(n6);
                    if (layoutParams == null || layoutParams.getVisibility() == 8) continue;
                    object = (LayoutParams)layoutParams.getLayoutParams();
                    float f2 = object.weight;
                    if (f2 > 0.0f) {
                        n5 = (int)((float)n13 * f2 / f);
                        n3 = LinearLayoutCompat.getChildMeasureSpec((int)n2, (int)(this.getPaddingTop() + this.getPaddingBottom() + object.topMargin + object.bottomMargin), (int)object.height);
                        if (object.width == 0 && n11 == 0x40000000) {
                            n8 = n5 > 0 ? n5 : 0;
                            layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)n8, (int)0x40000000), n3);
                        } else {
                            n8 = n4 = layoutParams.getMeasuredWidth() + n5;
                            if (n4 < 0) {
                                n8 = 0;
                            }
                            layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)n8, (int)0x40000000), n3);
                        }
                        n16 = View.combineMeasuredStates((int)n16, (int)(layoutParams.getMeasuredState() & 0xFF000000));
                        f -= f2;
                        n13 -= n5;
                    }
                    if (bl3) {
                        this.mTotalLength += layoutParams.getMeasuredWidth() + object.leftMargin + object.rightMargin + this.getNextLocationOffset((View)layoutParams);
                    } else {
                        n8 = this.mTotalLength;
                        this.mTotalLength = Math.max(n8, layoutParams.getMeasuredWidth() + n8 + object.leftMargin + object.rightMargin + this.getNextLocationOffset((View)layoutParams));
                    }
                    n8 = n10 != 0x40000000 && object.height == -1 ? 1 : 0;
                    n4 = object.topMargin + object.bottomMargin;
                    n5 = layoutParams.getMeasuredHeight() + n4;
                    n7 = Math.max(n7, n5);
                    n8 = n8 != 0 ? n4 : n5;
                    n8 = Math.max(n9, n8);
                    bl4 = bl4 && object.height == -1;
                    if (bl && (n4 = layoutParams.getBaseline()) != -1) {
                        n9 = object.gravity < 0 ? this.mGravity : object.gravity;
                        n9 = ((n9 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                        nArray[n9] = Math.max(nArray[n9], n4);
                        object2[n9] = Math.max(object2[n9], n5 - n4);
                    }
                    n9 = n8;
                }
                this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
                n13 = nArray[1] == -1 && nArray[0] == -1 && nArray[2] == -1 && nArray[3] == -1 ? n7 : Math.max(n7, Math.max(nArray[3], Math.max(nArray[0], Math.max(nArray[1], nArray[2]))) + Math.max(object2[3], Math.max(object2[0], Math.max(object2[1], object2[2]))));
                n7 = n16;
                n8 = n12;
                n12 = n17;
                n16 = n13;
                n17 = n7;
                n13 = n9;
            }
            n9 = n16;
            if (!bl4) {
                n9 = n16;
                if (n10 != 0x40000000) {
                    n9 = n13;
                }
            }
            this.setMeasuredDimension(n12 | 0xFF000000 & n17, View.resolveSizeAndState((int)Math.max(n9 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), (int)n2, (int)(n17 << 16)));
            if (n15 == 0) break block44;
            this.forceUniformHeight(n8, n);
        }
    }

    int measureNullChild(int n) {
        return 0;
    }

    void measureVertical(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        LayoutParams layoutParams;
        View view;
        int n7;
        this.mTotalLength = 0;
        int n8 = this.getVirtualChildCount();
        int n9 = View.MeasureSpec.getMode((int)n);
        int n10 = View.MeasureSpec.getMode((int)n2);
        int n11 = this.mBaselineAlignedChildIndex;
        boolean bl = this.mUseLargestChild;
        int n12 = 0;
        int n13 = 0;
        float f = 0.0f;
        int n14 = 0;
        boolean bl2 = false;
        int n15 = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 1;
        for (n7 = 0; n7 < n8; ++n7) {
            view = this.getVirtualChildAt(n7);
            if (view == null) {
                this.mTotalLength += this.measureNullChild(n7);
                continue;
            }
            if (view.getVisibility() == 8) {
                n7 += this.getChildrenSkipCount(view, n7);
                continue;
            }
            if (this.hasDividerBeforeChildAt(n7)) {
                this.mTotalLength += this.mDividerHeight;
            }
            layoutParams = (LayoutParams)view.getLayoutParams();
            f += layoutParams.weight;
            if (n10 == 0x40000000 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                n12 = this.mTotalLength;
                this.mTotalLength = Math.max(n12, layoutParams.topMargin + n12 + layoutParams.bottomMargin);
                n12 = 1;
            } else {
                if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                    layoutParams.height = -2;
                    n6 = 0;
                } else {
                    n6 = Integer.MIN_VALUE;
                }
                n5 = f == 0.0f ? this.mTotalLength : 0;
                this.measureChildBeforeLayout(view, n7, n, 0, n2, n5);
                if (n6 != Integer.MIN_VALUE) {
                    layoutParams.height = n6;
                }
                n5 = view.getMeasuredHeight();
                n6 = this.mTotalLength;
                this.mTotalLength = Math.max(n6, n6 + n5 + layoutParams.topMargin + layoutParams.bottomMargin + this.getNextLocationOffset(view));
                if (bl) {
                    n17 = Math.max(n5, n17);
                }
            }
            if (n11 >= 0 && n11 == n7 + 1) {
                this.mBaselineChildTop = this.mTotalLength;
            }
            if (n7 < n11 && layoutParams.weight > 0.0f) {
                throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
            }
            n6 = 0;
            if (n9 != 0x40000000 && layoutParams.width == -1) {
                bl2 = true;
                n6 = 1;
            }
            n5 = layoutParams.leftMargin + layoutParams.rightMargin;
            n4 = view.getMeasuredWidth() + n5;
            n3 = Math.max(n13, n4);
            n15 = View.combineMeasuredStates((int)n15, (int)view.getMeasuredState());
            n18 = n18 != 0 && layoutParams.width == -1 ? 1 : 0;
            if (layoutParams.weight > 0.0f) {
                if (n6 == 0) {
                    n5 = n4;
                }
                n16 = Math.max(n16, n5);
                n13 = n14;
            } else {
                if (n6 != 0) {
                    n4 = n5;
                }
                n13 = Math.max(n14, n4);
            }
            n7 += this.getChildrenSkipCount(view, n7);
            n14 = n13;
            n13 = n3;
        }
        n6 = n17;
        n17 = n15;
        n7 = n16;
        if (this.mTotalLength > 0 && this.hasDividerBeforeChildAt(n8)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (bl) {
            if (n10 != Integer.MIN_VALUE && n10 != 0) {
                n16 = n17;
            } else {
                this.mTotalLength = 0;
                for (n16 = 0; n16 < n8; ++n16) {
                    view = this.getVirtualChildAt(n16);
                    if (view == null) {
                        this.mTotalLength += this.measureNullChild(n16);
                        continue;
                    }
                    if (view.getVisibility() == 8) {
                        n16 += this.getChildrenSkipCount(view, n16);
                        continue;
                    }
                    layoutParams = (LayoutParams)view.getLayoutParams();
                    n15 = this.mTotalLength;
                    this.mTotalLength = Math.max(n15, n15 + n6 + layoutParams.topMargin + layoutParams.bottomMargin + this.getNextLocationOffset(view));
                }
                n16 = n17;
            }
        } else {
            n16 = n17;
        }
        this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
        n3 = View.resolveSizeAndState((int)Math.max(this.mTotalLength, this.getSuggestedMinimumHeight()), (int)n2, (int)0);
        n15 = n3 & 0xFFFFFF;
        n17 = n15 - this.mTotalLength;
        if (!(n12 != 0 || n17 != 0 && f > 0.0f)) {
            n14 = Math.max(n14, n7);
            if (bl && n10 != 0x40000000) {
                n12 = n15;
                for (n7 = 0; n7 < n8; ++n7) {
                    view = this.getVirtualChildAt(n7);
                    if (view == null || view.getVisibility() == 8 || !(((LayoutParams)view.getLayoutParams()).weight > 0.0f)) continue;
                    view.measure(View.MeasureSpec.makeMeasureSpec((int)view.getMeasuredWidth(), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000));
                }
                n12 = n14;
                n14 = n17;
                n17 = n12;
                n12 = n14;
            } else {
                n12 = n17;
                n17 = n14;
            }
            n14 = n17;
            n17 = n16;
            n16 = n14;
        } else {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            this.mTotalLength = 0;
            n4 = 0;
            n5 = n14;
            n14 = n17;
            n12 = n11;
            n15 = n10;
            n17 = n5;
            for (n5 = n4; n5 < n8; ++n5) {
                view = this.getVirtualChildAt(n5);
                if (view.getVisibility() == 8) continue;
                layoutParams = (LayoutParams)view.getLayoutParams();
                float f2 = layoutParams.weight;
                if (f2 > 0.0f) {
                    n10 = (int)((float)n14 * f2 / f);
                    int n19 = LinearLayoutCompat.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin), (int)layoutParams.width);
                    if (layoutParams.height == 0 && n15 == 0x40000000) {
                        n4 = n10 > 0 ? n10 : 0;
                        view.measure(n19, View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000));
                    } else {
                        n4 = n11 = view.getMeasuredHeight() + n10;
                        if (n11 < 0) {
                            n4 = 0;
                        }
                        view.measure(n19, View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000));
                    }
                    n16 = View.combineMeasuredStates((int)n16, (int)(view.getMeasuredState() & 0xFFFFFF00));
                    n14 -= n10;
                    f -= f2;
                }
                n11 = layoutParams.leftMargin + layoutParams.rightMargin;
                n10 = view.getMeasuredWidth() + n11;
                n4 = Math.max(n13, n10);
                n13 = n9 != 0x40000000 && layoutParams.width == -1 ? 1 : 0;
                n13 = n13 != 0 ? n11 : n10;
                n13 = Math.max(n17, n13);
                n17 = n18 != 0 && layoutParams.width == -1 ? 1 : 0;
                n18 = this.mTotalLength;
                this.mTotalLength = Math.max(n18, n18 + view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + this.getNextLocationOffset(view));
                n18 = n17;
                n17 = n13;
                n13 = n4;
            }
            this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
            n14 = n17;
            n17 = n16;
            n16 = n14;
        }
        n14 = n13;
        if (n18 == 0) {
            n14 = n13;
            if (n9 != 0x40000000) {
                n14 = n16;
            }
        }
        this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max(n14 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), (int)n, (int)n17), n3);
        if (bl2) {
            this.forceUniformWidth(n8, n2);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            this.drawDividersVertical(canvas);
        } else {
            this.drawDividersHorizontal(canvas);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (this.mOrientation == 1) {
            this.layoutVertical(n, n2, n3, n4);
        } else {
            this.layoutHorizontal(n, n2, n3, n4);
        }
    }

    protected void onMeasure(int n, int n2) {
        if (this.mOrientation == 1) {
            this.measureVertical(n, n2);
        } else {
            this.measureHorizontal(n, n2);
        }
    }

    public void setBaselineAligned(boolean bl) {
        this.mBaselineAligned = bl;
    }

    public void setBaselineAlignedChildIndex(int n) {
        if (n >= 0 && n < this.getChildCount()) {
            this.mBaselineAlignedChildIndex = n;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + this.getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable2) {
        if (drawable2 == this.mDivider) {
            return;
        }
        this.mDivider = drawable2;
        boolean bl = false;
        if (drawable2 != null) {
            this.mDividerWidth = drawable2.getIntrinsicWidth();
            this.mDividerHeight = drawable2.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable2 == null) {
            bl = true;
        }
        this.setWillNotDraw(bl);
        this.requestLayout();
    }

    public void setDividerPadding(int n) {
        this.mDividerPadding = n;
    }

    public void setGravity(int n) {
        if (this.mGravity != n) {
            int n2 = n;
            if ((0x800007 & n) == 0) {
                n2 = n | 0x800003;
            }
            n = n2;
            if ((n2 & 0x70) == 0) {
                n = n2 | 0x30;
            }
            this.mGravity = n;
            this.requestLayout();
        }
    }

    public void setHorizontalGravity(int n) {
        if ((0x800007 & this.mGravity) != (n &= 0x800007)) {
            this.mGravity = this.mGravity & 0xFF7FFFF8 | n;
            this.requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean bl) {
        this.mUseLargestChild = bl;
    }

    public void setOrientation(int n) {
        if (this.mOrientation != n) {
            this.mOrientation = n;
            this.requestLayout();
        }
    }

    public void setShowDividers(int n) {
        if (n != this.mShowDividers) {
            this.requestLayout();
        }
        this.mShowDividers = n;
    }

    public void setVerticalGravity(int n) {
        if ((this.mGravity & 0x70) != (n &= 0x70)) {
            this.mGravity = this.mGravity & 0xFFFFFF8F | n;
            this.requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface DividerMode {
    }

    public static class LayoutParams
    extends LinearLayout.LayoutParams {
        public LayoutParams(int n, int n2) {
            super(n, n2);
        }

        public LayoutParams(int n, int n2, float f) {
            super(n, n2, f);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface OrientationMode {
    }
}

