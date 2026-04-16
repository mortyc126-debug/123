/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewDebug$ExportedProperty
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ViewUtils;

public class ActionMenuView
extends LinearLayoutCompat
implements MenuBuilder.ItemInvoker,
MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int)(56.0f * f);
        this.mGeneratedItemPadding = (int)(4.0f * f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5;
        LayoutParams layoutParams;
        block8: {
            int n6;
            block9: {
                layoutParams = (LayoutParams)view.getLayoutParams();
                n5 = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n3) - n4), (int)View.MeasureSpec.getMode((int)n3));
                ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView)view : null;
                bl = false;
                n4 = actionMenuItemView != null && actionMenuItemView.hasText() ? 1 : 0;
                n3 = n6 = 0;
                if (n2 <= 0) break block8;
                if (n4 == 0) break block9;
                n3 = n6;
                if (n2 < 2) break block8;
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n * n2), (int)Integer.MIN_VALUE), n5);
            n6 = view.getMeasuredWidth();
            n2 = n3 = n6 / n;
            if (n6 % n != 0) {
                n2 = n3 + 1;
            }
            n3 = n2;
            if (n4 != 0) {
                n3 = n2;
                if (n2 < 2) {
                    n3 = 2;
                }
            }
        }
        boolean bl2 = bl;
        if (!layoutParams.isOverflowButton) {
            bl2 = bl;
            if (n4 != 0) {
                bl2 = true;
            }
        }
        layoutParams.expandable = bl2;
        layoutParams.cellsUsed = n3;
        view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 * n), (int)0x40000000), n5);
        return n3;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void onMeasureExactFormat(int var1_1, int var2_2) {
        block40: {
            var19_3 = View.MeasureSpec.getMode((int)var2_2);
            var1_1 = View.MeasureSpec.getSize((int)var1_1);
            var17_4 = View.MeasureSpec.getSize((int)var2_2);
            var5_5 = this.getPaddingLeft();
            var6_6 = this.getPaddingRight();
            var16_7 = this.getPaddingTop() + this.getPaddingBottom();
            var18_8 = ActionMenuView.getChildMeasureSpec((int)var2_2, (int)var16_7, (int)-2);
            var12_9 = var1_1 - (var5_5 + var6_6);
            var10_10 = var12_9 / this.mMinCellSize;
            var9_11 = var12_9 % this.mMinCellSize;
            if (var10_10 == 0) {
                this.setMeasuredDimension(var12_9, 0);
                return;
            }
            var20_12 = this.mMinCellSize + var9_11 / var10_10;
            var1_1 = var10_10;
            var5_5 = 0;
            var13_13 = 0;
            var8_14 = 0;
            var7_15 = 0;
            var22_16 = 0L;
            var21_17 = this.getChildCount();
            var6_6 = 0;
            for (var11_18 = 0; var11_18 < var21_17; ++var11_18) {
                var29_21 /* !! */  = this.getChildAt(var11_18);
                if (var29_21 /* !! */ .getVisibility() == 8) {
                    var2_2 = var8_14;
                } else {
                    var28_20 = var29_21 /* !! */  instanceof ActionMenuItemView;
                    ++var6_6;
                    if (var28_20) {
                        var29_21 /* !! */ .setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
                    }
                    var30_22 = (LayoutParams)var29_21 /* !! */ .getLayoutParams();
                    var30_22.expanded = false;
                    var30_22.extraPixels = 0;
                    var30_22.cellsUsed = 0;
                    var30_22.expandable = false;
                    var30_22.leftMargin = 0;
                    var30_22.rightMargin = 0;
                    var28_20 = var28_20 != false && ((ActionMenuItemView)var29_21 /* !! */ ).hasText() != false;
                    var30_22.preventEdgeOffset = var28_20;
                    var2_2 = var30_22.isOverflowButton != false ? 1 : var1_1;
                    var14_19 = ActionMenuView.measureChildForCells(var29_21 /* !! */ , var20_12, var2_2, var18_8, var16_7);
                    var13_13 = Math.max(var13_13, var14_19);
                    var2_2 = var8_14;
                    if (var30_22.expandable) {
                        var2_2 = var8_14 + 1;
                    }
                    if (var30_22.isOverflowButton) {
                        var7_15 = 1;
                    }
                    var8_14 = var1_1 - var14_19;
                    var1_1 = Math.max(var5_5, var29_21 /* !! */ .getMeasuredHeight());
                    if (var14_19 == 1) {
                        var22_16 |= (long)(1 << var11_18);
                        var5_5 = var1_1;
                        var1_1 = var8_14;
                    } else {
                        var5_5 = var1_1;
                        var1_1 = var8_14;
                    }
                }
                var8_14 = var2_2;
            }
            var14_19 = var7_15 != 0 && var6_6 == 2 ? 1 : 0;
            var2_2 = 0;
            var15_23 = var1_1;
            var9_11 = var18_8;
            var11_18 = var16_7;
            while (var8_14 > 0 && var15_23 > 0) {
                var26_25 = 0L;
                var18_8 = 0x7FFFFFFF;
                var1_1 = 0;
                var10_10 = var2_2;
                var2_2 = var11_18;
                var11_18 = var18_8;
                for (var16_7 = 0; var16_7 < var21_17; ++var16_7) {
                    var29_21 /* !! */  = (LayoutParams)this.getChildAt(var16_7).getLayoutParams();
                    if (!var29_21 /* !! */ .expandable) ** GOTO lbl-1000
                    if (var29_21 /* !! */ .cellsUsed < var11_18) {
                        var11_18 = var29_21 /* !! */ .cellsUsed;
                        var24_24 = 1L << var16_7;
                        var1_1 = 1;
                    } else if (var29_21 /* !! */ .cellsUsed == var11_18) {
                        var24_24 = var26_25 | 1L << var16_7;
                        ++var1_1;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var24_24 = var26_25;
                    }
                    var26_25 = var24_24;
                }
                var22_16 |= var26_25;
                if (var1_1 > var15_23) {
                    var1_1 = var10_10;
                    break block40;
                }
                ++var11_18;
                for (var10_10 = 0; var10_10 < var21_17; ++var10_10) {
                    var29_21 /* !! */  = this.getChildAt(var10_10);
                    var30_22 = (LayoutParams)var29_21 /* !! */ .getLayoutParams();
                    if ((var26_25 & (long)(1 << var10_10)) == 0L) {
                        var24_24 = var22_16;
                        if (var30_22.cellsUsed == var11_18) {
                            var24_24 = var22_16 | (long)(1 << var10_10);
                        }
                        var22_16 = var24_24;
                        continue;
                    }
                    if (var14_19 != 0 && var30_22.preventEdgeOffset && var15_23 == 1) {
                        var29_21 /* !! */ .setPadding(this.mGeneratedItemPadding + var20_12, 0, this.mGeneratedItemPadding, 0);
                    }
                    ++var30_22.cellsUsed;
                    var30_22.expanded = true;
                    --var15_23;
                }
                var1_1 = 1;
                var11_18 = var2_2;
                var2_2 = var1_1;
            }
            var1_1 = var2_2;
        }
        var2_2 = var7_15 == 0 && var6_6 == 1 ? 1 : 0;
        if (var15_23 > 0 && var22_16 != 0L && (var15_23 < var6_6 - 1 || var2_2 != 0 || var13_13 > 1)) {
            var4_26 = Long.bitCount(var22_16);
            if (var2_2 == 0) {
                if ((var22_16 & 1L) != 0L) {
                    var3_27 = var4_26;
                    if (!((LayoutParams)this.getChildAt((int)0).getLayoutParams()).preventEdgeOffset) {
                        var3_27 = var4_26 - 0.5f;
                    }
                } else {
                    var3_27 = var4_26;
                }
                var4_26 = var3_27;
                if ((var22_16 & (long)(1 << var21_17 - 1)) != 0L) {
                    var4_26 = var3_27;
                    if (!((LayoutParams)this.getChildAt((int)(var21_17 - 1)).getLayoutParams()).preventEdgeOffset) {
                        var4_26 = var3_27 - 0.5f;
                    }
                }
            }
            var8_14 = 0;
            if (var4_26 > 0.0f) {
                var8_14 = (int)((float)(var15_23 * var20_12) / var4_26);
            }
            var7_15 = var1_1;
            for (var10_10 = 0; var10_10 < var21_17; ++var10_10) {
                if ((var22_16 & (long)(1 << var10_10)) == 0L) {
                    var1_1 = var7_15;
                } else {
                    var30_22 = this.getChildAt(var10_10);
                    var29_21 /* !! */  = (LayoutParams)var30_22.getLayoutParams();
                    if (var30_22 instanceof ActionMenuItemView) {
                        var29_21 /* !! */ .extraPixels = var8_14;
                        var29_21 /* !! */ .expanded = true;
                        if (var10_10 == 0 && !var29_21 /* !! */ .preventEdgeOffset) {
                            var29_21 /* !! */ .leftMargin = -var8_14 / 2;
                        }
                        var1_1 = 1;
                    } else if (var29_21 /* !! */ .isOverflowButton) {
                        var29_21 /* !! */ .extraPixels = var8_14;
                        var29_21 /* !! */ .expanded = true;
                        var29_21 /* !! */ .rightMargin = -var8_14 / 2;
                        var1_1 = 1;
                    } else {
                        if (var10_10 != 0) {
                            var29_21 /* !! */ .leftMargin = var8_14 / 2;
                        }
                        var1_1 = var7_15;
                        if (var10_10 != var21_17 - 1) {
                            var29_21 /* !! */ .rightMargin = var8_14 / 2;
                            var1_1 = var7_15;
                        }
                    }
                }
                var7_15 = var1_1;
            }
            var1_1 = var7_15;
        }
        if (var1_1 != 0) {
            for (var1_1 = 0; var1_1 < var21_17; ++var1_1) {
                var29_21 /* !! */  = this.getChildAt(var1_1);
                var30_22 = (LayoutParams)var29_21 /* !! */ .getLayoutParams();
                if (!var30_22.expanded) continue;
                var29_21 /* !! */ .measure(View.MeasureSpec.makeMeasureSpec((int)(var30_22.cellsUsed * var20_12 + var30_22.extraPixels), (int)0x40000000), var9_11);
            }
        }
        var1_1 = var19_3 != 0x40000000 ? var5_5 : var17_4;
        this.setMeasuredDimension(var12_9, var1_1);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        if (this.mPresenter != null) {
            this.mPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        if (object != null) {
            object = object instanceof LayoutParams ? new LayoutParams((LayoutParams)((Object)object)) : new LayoutParams((ViewGroup.LayoutParams)object);
            if (object.gravity <= 0) {
                object.gravity = 16;
            }
            return object;
        }
        return this.generateDefaultLayoutParams();
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams layoutParams = this.generateDefaultLayoutParams();
        layoutParams.isOverflowButton = true;
        return layoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Object object = this.getContext();
            this.mMenu = new MenuBuilder((Context)object);
            this.mMenu.setCallback(new MenuBuilderCallback(this));
            this.mPresenter = new ActionMenuPresenter((Context)object);
            this.mPresenter.setReserveOverflow(true);
            ActionMenuPresenter actionMenuPresenter = this.mPresenter;
            object = this.mActionMenuPresenterCallback != null ? this.mActionMenuPresenterCallback : new ActionMenuPresenterCallback();
            actionMenuPresenter.setCallback((MenuPresenter.Callback)object);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override
    public int getWindowAnimations() {
        return 0;
    }

    protected boolean hasSupportDividerBeforeChildAt(int n) {
        boolean bl;
        if (n == 0) {
            return false;
        }
        View view = this.getChildAt(n - 1);
        View view2 = this.getChildAt(n);
        boolean bl2 = bl = false;
        if (n < this.getChildCount()) {
            bl2 = bl;
            if (view instanceof ActionMenuChildView) {
                bl2 = false | ((ActionMenuChildView)view).needsDividerAfter();
            }
        }
        bl = bl2;
        if (n > 0) {
            bl = bl2;
            if (view2 instanceof ActionMenuChildView) {
                bl = bl2 | ((ActionMenuChildView)view2).needsDividerBefore();
            }
        }
        return bl;
    }

    public boolean hideOverflowMenu() {
        boolean bl = this.mPresenter != null && this.mPresenter.hideOverflowMenu();
        return bl;
    }

    @Override
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl = this.mPresenter != null && this.mPresenter.isOverflowMenuShowPending();
        return bl;
    }

    public boolean isOverflowMenuShowing() {
        boolean bl = this.mPresenter != null && this.mPresenter.isOverflowMenuShowing();
        return bl;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration2) {
        super.onConfigurationChanged(configuration2);
        if (this.mPresenter != null) {
            this.mPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dismissPopupMenus();
    }

    @Override
    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        LayoutParams layoutParams;
        Object object;
        int n5;
        if (!this.mFormatItems) {
            super.onLayout(bl, n, n2, n3, n4);
            return;
        }
        int n6 = this.getChildCount();
        int n7 = (n4 - n2) / 2;
        int n8 = this.getDividerWidth();
        n4 = 0;
        n2 = 0;
        int n9 = n3 - n - this.getPaddingRight() - this.getPaddingLeft();
        int n10 = 0;
        bl = ViewUtils.isLayoutRtl((View)this);
        for (n5 = 0; n5 < n6; ++n5) {
            object = this.getChildAt(n5);
            if (object.getVisibility() == 8) continue;
            layoutParams = (LayoutParams)object.getLayoutParams();
            if (layoutParams.isOverflowButton) {
                int n11;
                n4 = n10 = object.getMeasuredWidth();
                if (this.hasSupportDividerBeforeChildAt(n5)) {
                    n4 = n10 + n8;
                }
                int n12 = object.getMeasuredHeight();
                if (bl) {
                    n11 = this.getPaddingLeft() + layoutParams.leftMargin;
                    n10 = n11 + n4;
                } else {
                    n10 = this.getWidth() - this.getPaddingRight() - layoutParams.rightMargin;
                    n11 = n10 - n4;
                }
                int n13 = n7 - n12 / 2;
                object.layout(n11, n13, n10, n13 + n12);
                n9 -= n4;
                n10 = 1;
                continue;
            }
            n9 -= object.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            this.hasSupportDividerBeforeChildAt(n5);
            ++n2;
        }
        if (n6 == 1 && n10 == 0) {
            object = this.getChildAt(0);
            n4 = object.getMeasuredWidth();
            n2 = object.getMeasuredHeight();
            n = (n3 - n) / 2 - n4 / 2;
            n3 = n7 - n2 / 2;
            object.layout(n, n3, n + n4, n3 + n2);
            return;
        }
        n = n2 - (n10 ^ 1);
        n = n > 0 ? n9 / n : 0;
        n9 = Math.max(0, n);
        if (bl) {
            n3 = this.getWidth() - this.getPaddingRight();
            for (n = 0; n < n6; ++n) {
                object = this.getChildAt(n);
                layoutParams = (LayoutParams)object.getLayoutParams();
                if (object.getVisibility() == 8 || layoutParams.isOverflowButton) continue;
                n5 = n3 - layoutParams.rightMargin;
                n8 = object.getMeasuredWidth();
                n10 = object.getMeasuredHeight();
                n3 = n7 - n10 / 2;
                object.layout(n5 - n8, n3, n5, n3 + n10);
                n3 = n5 - (layoutParams.leftMargin + n8 + n9);
            }
        } else {
            n3 = this.getPaddingLeft();
            for (n = 0; n < n6; ++n) {
                layoutParams = this.getChildAt(n);
                object = (LayoutParams)layoutParams.getLayoutParams();
                n2 = n3;
                if (layoutParams.getVisibility() != 8) {
                    if (object.isOverflowButton) {
                        n2 = n3;
                    } else {
                        n4 = n3 + object.leftMargin;
                        n2 = layoutParams.getMeasuredWidth();
                        n5 = layoutParams.getMeasuredHeight();
                        n3 = n7 - n5 / 2;
                        layoutParams.layout(n4, n3, n4 + n2, n3 + n5);
                        n2 = n4 + (object.rightMargin + n2 + n9);
                    }
                }
                n3 = n2;
            }
        }
    }

    @Override
    protected void onMeasure(int n, int n2) {
        boolean bl = this.mFormatItems;
        boolean bl2 = View.MeasureSpec.getMode((int)n) == 0x40000000;
        this.mFormatItems = bl2;
        if (bl != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int n3 = View.MeasureSpec.getSize((int)n);
        if (this.mFormatItems && this.mMenu != null && n3 != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = n3;
            this.mMenu.onItemsChanged(true);
        }
        int n4 = this.getChildCount();
        if (this.mFormatItems && n4 > 0) {
            this.onMeasureExactFormat(n, n2);
        } else {
            for (n3 = 0; n3 < n4; ++n3) {
                LayoutParams layoutParams = (LayoutParams)this.getChildAt(n3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(n, n2);
        }
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean bl) {
        this.mPresenter.setExpandedActionViewsExclusive(bl);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback2, MenuBuilder.Callback callback3) {
        this.mActionMenuPresenterCallback = callback2;
        this.mMenuBuilderCallback = callback3;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable2) {
        this.getMenu();
        this.mPresenter.setOverflowIcon(drawable2);
    }

    public void setOverflowReserved(boolean bl) {
        this.mReserveOverflow = bl;
    }

    public void setPopupTheme(int n) {
        if (this.mPopupTheme != n) {
            this.mPopupTheme = n;
            this.mPopupContext = n == 0 ? this.getContext() : new ContextThemeWrapper(this.getContext(), n);
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        this.mPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        boolean bl = this.mPresenter != null && this.mPresenter.showOverflowMenu();
        return bl;
    }

    public static interface ActionMenuChildView {
        public boolean needsDividerAfter();

        public boolean needsDividerBefore();
    }

    private static class ActionMenuPresenterCallback
    implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        @Override
        public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        }

        @Override
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public int cellsUsed;
        @ViewDebug.ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ViewDebug.ExportedProperty
        public int extraPixels;
        @ViewDebug.ExportedProperty
        public boolean isOverflowButton;
        @ViewDebug.ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int n, int n2) {
            super(n, n2);
            this.isOverflowButton = false;
        }

        LayoutParams(int n, int n2, boolean bl) {
            super(n, n2);
            this.isOverflowButton = bl;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams)layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }
    }

    private class MenuBuilderCallback
    implements MenuBuilder.Callback {
        final ActionMenuView this$0;

        MenuBuilderCallback(ActionMenuView actionMenuView) {
            this.this$0 = actionMenuView;
        }

        @Override
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            boolean bl = this.this$0.mOnMenuItemClickListener != null && this.this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
            return bl;
        }

        @Override
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.this$0.mMenuBuilderCallback != null) {
                this.this$0.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public static interface OnMenuItemClickListener {
        public boolean onMenuItemClick(MenuItem var1);
    }
}

