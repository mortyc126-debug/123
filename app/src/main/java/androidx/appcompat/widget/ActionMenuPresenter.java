/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseBooleanArray
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

class ActionMenuPresenter
extends BaseMenuPresenter
implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback(this);
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int n = viewGroup.getChildCount();
        for (int i = 0; i < n; ++i) {
            View view = viewGroup.getChildAt(i);
            if (!(view instanceof MenuView.ItemView) || ((MenuView.ItemView)view).getItemData() != menuItem) continue;
            return view;
        }
        return null;
    }

    @Override
    public void bindItemView(MenuItemImpl object, MenuView.ItemView itemView) {
        itemView.initialize((MenuItemImpl)object, 0);
        object = (ActionMenuView)this.mMenuView;
        itemView = (ActionMenuItemView)itemView;
        ((ActionMenuItemView)itemView).setItemInvoker((MenuBuilder.ItemInvoker)object);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback(this);
        }
        ((ActionMenuItemView)itemView).setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return this.hideOverflowMenu() | this.hideSubMenus();
    }

    @Override
    public boolean filterLeftoverView(ViewGroup viewGroup, int n) {
        if (viewGroup.getChildAt(n) == this.mOverflowButton) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, n);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean flagActionItems() {
        block33: {
            block34: {
                if (this.mMenu != null) {
                    var15_1 = this.mMenu.getVisibleItems();
                    var3_2 = var15_1.size();
                } else {
                    var15_1 = null;
                    var3_2 = 0;
                }
                var1_3 = this.mMaxItems;
                var9_4 = this.mActionItemWidthLimit;
                var11_5 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                var16_6 = (ViewGroup)this.mMenuView;
                var4_7 = 0;
                var6_8 = 0;
                var8_9 = 0;
                var5_10 = 0;
                for (var2_11 = 0; var2_11 < var3_2; ++var2_11) {
                    var17_13 = var15_1.get(var2_11);
                    if (var17_13.requiresActionButton()) {
                        ++var4_7;
                    } else if (var17_13.requestsActionButton()) {
                        ++var6_8;
                    } else {
                        var5_10 = 1;
                    }
                    var7_12 = var1_3;
                    if (this.mExpandedActionViewsExclusive) {
                        var7_12 = var1_3;
                        if (var17_13.isActionViewExpanded()) {
                            var7_12 = 0;
                        }
                    }
                    var1_3 = var7_12;
                }
                var2_11 = var1_3;
                if (!this.mReserveOverflow) break block33;
                if (var5_10 != 0) break block34;
                var2_11 = var1_3;
                if (var4_7 + var6_8 <= var1_3) break block33;
            }
            var2_11 = var1_3 - 1;
        }
        var10_14 = var2_11 - var4_7;
        var17_13 = this.mActionButtonGroups;
        var17_13.clear();
        var6_8 = 0;
        var2_11 = 0;
        if (this.mStrictWidthLimit) {
            var2_11 = var9_4 / this.mMinCellSize;
            var1_3 = this.mMinCellSize;
            var6_8 = this.mMinCellSize + var9_4 % var1_3 / var2_11;
        }
        var5_10 = 0;
        var1_3 = var8_9;
        var7_12 = var4_7;
        var8_9 = var5_10;
        var5_10 = var9_4;
        var4_7 = var10_14;
        var9_4 = var3_2;
        while (var8_9 < var9_4) {
            block36: {
                block37: {
                    block38: {
                        block35: {
                            var18_18 = var15_1.get(var8_9);
                            if (!var18_18.requiresActionButton()) break block35;
                            var19_19 = this.getItemView(var18_18, null, var16_6);
                            if (this.mStrictWidthLimit) {
                                var2_11 -= ActionMenuView.measureChildForCells((View)var19_19, var6_8, var2_11, var11_5, 0);
                            } else {
                                var19_19.measure(var11_5, var11_5);
                            }
                            var10_14 = var19_19.getMeasuredWidth();
                            var5_10 -= var10_14;
                            var3_2 = var1_3;
                            if (var1_3 == 0) {
                                var3_2 = var10_14;
                            }
                            if ((var1_3 = var18_18.getGroupId()) != 0) {
                                var17_13.put(var1_3, true);
                            }
                            var18_18.setIsActionButton(true);
                            var1_3 = var3_2;
                            break block36;
                        }
                        if (!var18_18.requestsActionButton()) break block37;
                        var12_15 = var18_18.getGroupId();
                        var14_17 = var17_13.get(var12_15);
                        var13_16 = !(var4_7 <= 0 && var14_17 == false || var5_10 <= 0 || this.mStrictWidthLimit != false && var2_11 <= 0) ? 1 : 0;
                        if (var13_16 != 0) {
                            var19_19 = this.getItemView(var18_18, null, var16_6);
                            if (this.mStrictWidthLimit) {
                                var3_2 = ActionMenuView.measureChildForCells((View)var19_19, var6_8, var2_11, var11_5, 0);
                                var2_11 -= var3_2;
                                if (var3_2 == 0) {
                                    var13_16 = 0;
                                }
                            } else {
                                var19_19.measure(var11_5, var11_5);
                            }
                            var10_14 = var19_19.getMeasuredWidth();
                            var5_10 -= var10_14;
                            var3_2 = var1_3;
                            if (var1_3 == 0) {
                                var3_2 = var10_14;
                            }
                            if (this.mStrictWidthLimit) {
                                var1_3 = var5_10 >= 0 ? 1 : 0;
                                var13_16 = var1_3 & var13_16;
                            } else {
                                var1_3 = var5_10 + var3_2 > 0 ? 1 : 0;
                                var13_16 = var1_3 & var13_16;
                            }
                        } else {
                            var3_2 = var1_3;
                        }
                        var1_3 = var4_7;
                        if (var13_16 == 0 || var12_15 == 0) break block38;
                        var17_13.put(var12_15, true);
                        ** GOTO lbl-1000
                    }
                    if (var14_17) {
                        var17_13.put(var12_15, false);
                        for (var10_14 = 0; var10_14 < var8_9; ++var10_14) {
                            var19_19 = var15_1.get(var10_14);
                            var4_7 = var1_3;
                            if (var19_19.getGroupId() == var12_15) {
                                var4_7 = var1_3;
                                if (var19_19.isActionButton()) {
                                    var4_7 = var1_3 + 1;
                                }
                                var19_19.setIsActionButton(false);
                            }
                            var1_3 = var4_7;
                        }
                        var4_7 = var1_3;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var4_7 = var1_3;
                    }
                    var1_3 = var4_7;
                    if (var13_16 != 0) {
                        var1_3 = var4_7 - 1;
                    }
                    var18_18.setIsActionButton((boolean)var13_16);
                    var4_7 = var1_3;
                    var1_3 = var3_2;
                    break block36;
                }
                var18_18.setIsActionButton(false);
            }
            ++var8_9;
        }
        return true;
    }

    @Override
    public View getItemView(MenuItemImpl object, View view, ViewGroup viewGroup) {
        View view2 = ((MenuItemImpl)object).getActionView();
        if (view2 == null || ((MenuItemImpl)object).hasCollapsibleActionView()) {
            view2 = super.getItemView((MenuItemImpl)object, view, viewGroup);
        }
        int n = ((MenuItemImpl)object).isActionViewExpanded() ? 8 : 0;
        view2.setVisibility(n);
        object = (ActionMenuView)viewGroup;
        view = view2.getLayoutParams();
        if (!((ActionMenuView)object).checkLayoutParams((ViewGroup.LayoutParams)view)) {
            view2.setLayoutParams((ViewGroup.LayoutParams)((ActionMenuView)object).generateLayoutParams((ViewGroup.LayoutParams)view));
        }
        return view2;
    }

    @Override
    public MenuView getMenuView(ViewGroup object) {
        MenuView menuView = this.mMenuView;
        if (menuView != (object = super.getMenuView((ViewGroup)object))) {
            ((ActionMenuView)object).setPresenter(this);
        }
        return object;
    }

    public Drawable getOverflowIcon() {
        if (this.mOverflowButton != null) {
            return this.mOverflowButton.getDrawable();
        }
        if (this.mPendingOverflowIconSet) {
            return this.mPendingOverflowIcon;
        }
        return null;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
            ((View)this.mMenuView).removeCallbacks((Runnable)this.mPostedOpenRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup != null) {
            overflowPopup.dismiss();
            return true;
        }
        return false;
    }

    public boolean hideSubMenus() {
        if (this.mActionButtonPopup != null) {
            this.mActionButtonPopup.dismiss();
            return true;
        }
        return false;
    }

    @Override
    public void initForMenu(Context object, MenuBuilder menuBuilder) {
        super.initForMenu((Context)object, menuBuilder);
        menuBuilder = object.getResources();
        object = ActionBarPolicy.get((Context)object);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = ((ActionBarPolicy)object).showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = ((ActionBarPolicy)object).getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ((ActionBarPolicy)object).getMaxActionButtons();
        }
        int n = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
                if (this.mPendingOverflowIconSet) {
                    this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                this.mOverflowButton.measure(n2, n2);
            }
            n -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = n;
        this.mMinCellSize = (int)(menuBuilder.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl = this.mPostedOpenRunnable != null || this.isOverflowMenuShowing();
        return bl;
    }

    public boolean isOverflowMenuShowing() {
        boolean bl = this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
        return bl;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override
    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        this.dismissPopupMenus();
        super.onCloseMenu(menuBuilder, bl);
    }

    public void onConfigurationChanged(Configuration configuration2) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ActionBarPolicy.get(this.mContext).getMaxActionButtons();
        }
        if (this.mMenu != null) {
            this.mMenu.onItemsChanged(true);
        }
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            return;
        }
        parcelable = (SavedState)parcelable;
        if (parcelable.openSubMenuId > 0 && (parcelable = this.mMenu.findItem(parcelable.openSubMenuId)) != null) {
            this.onSubMenuSelected((SubMenuBuilder)parcelable.getSubMenu());
        }
    }

    @Override
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    @Override
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean bl;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder)subMenuBuilder2.getParentMenu();
        }
        if ((subMenuBuilder2 = this.findViewForItem(subMenuBuilder2.getItem())) == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        boolean bl2 = false;
        int n = subMenuBuilder.size();
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            MenuItem menuItem = subMenuBuilder.getItem(n2);
            if (menuItem.isVisible() && menuItem.getIcon() != null) {
                bl = true;
                break;
            }
            ++n2;
        }
        this.mActionButtonPopup = new ActionButtonSubmenu(this, this.mContext, subMenuBuilder, (View)subMenuBuilder2);
        this.mActionButtonPopup.setForceShowIcon(bl);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    @Override
    public void onSubUiVisibilityChanged(boolean bl) {
        if (bl) {
            super.onSubMenuSelected(null);
        } else if (this.mMenu != null) {
            this.mMenu.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean bl) {
        this.mExpandedActionViewsExclusive = bl;
    }

    public void setItemLimit(int n) {
        this.mMaxItems = n;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable2) {
        if (this.mOverflowButton != null) {
            this.mOverflowButton.setImageDrawable(drawable2);
        } else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable2;
        }
    }

    public void setReserveOverflow(boolean bl) {
        this.mReserveOverflow = bl;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int n, boolean bl) {
        this.mWidthLimit = n;
        this.mStrictWidthLimit = bl;
        this.mWidthLimitSet = true;
    }

    @Override
    public boolean shouldIncludeItem(int n, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (this.mReserveOverflow && !this.isOverflowMenuShowing() && this.mMenu != null && this.mMenuView != null && this.mPostedOpenRunnable == null && !this.mMenu.getNonActionItems().isEmpty()) {
            this.mPostedOpenRunnable = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, (View)this.mOverflowButton, true));
            ((View)this.mMenuView).post((Runnable)this.mPostedOpenRunnable);
            return true;
        }
        return false;
    }

    @Override
    public void updateMenuView(boolean bl) {
        Object object;
        int n;
        int n2;
        super.updateMenuView(bl);
        ((View)this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            ArrayList<MenuItemImpl> arrayList = this.mMenu.getActionItems();
            n2 = arrayList.size();
            for (n = 0; n < n2; ++n) {
                object = arrayList.get(n).getSupportActionProvider();
                if (object == null) continue;
                ((ActionProvider)object).setSubUiVisibilityListener(this);
            }
        }
        object = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
        n = n2 = 0;
        if (this.mReserveOverflow) {
            n = n2;
            if (object != null) {
                n2 = ((ArrayList)object).size();
                n = 0;
                if (n2 == 1) {
                    n = ((MenuItemImpl)((ArrayList)object).get(0)).isActionViewExpanded() ^ 1;
                } else if (n2 > 0) {
                    n = 1;
                }
            }
        }
        if (n != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
            }
            if ((object = (ViewGroup)this.mOverflowButton.getParent()) != this.mMenuView) {
                if (object != null) {
                    object.removeView((View)this.mOverflowButton);
                }
                object = (ActionMenuView)this.mMenuView;
                object.addView((View)this.mOverflowButton, (ViewGroup.LayoutParams)((ActionMenuView)object).generateOverflowButtonLayoutParams());
            }
        } else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup)this.mMenuView).removeView((View)this.mOverflowButton);
        }
        ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }

    private class ActionButtonSubmenu
    extends MenuPopupHelper {
        final ActionMenuPresenter this$0;

        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context object, SubMenuBuilder subMenuBuilder, View view) {
            this.this$0 = actionMenuPresenter;
            super((Context)object, subMenuBuilder, view, false, R.attr.actionOverflowMenuStyle);
            if (!((MenuItemImpl)subMenuBuilder.getItem()).isActionButton()) {
                object = actionMenuPresenter.mOverflowButton == null ? (View)actionMenuPresenter.mMenuView : actionMenuPresenter.mOverflowButton;
                this.setAnchorView((View)object);
            }
            this.setPresenterCallback(actionMenuPresenter.mPopupPresenterCallback);
        }

        @Override
        protected void onDismiss() {
            this.this$0.mActionButtonPopup = null;
            this.this$0.mOpenSubMenuId = 0;
            super.onDismiss();
        }
    }

    private class ActionMenuPopupCallback
    extends ActionMenuItemView.PopupCallback {
        final ActionMenuPresenter this$0;

        ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
            this.this$0 = actionMenuPresenter;
        }

        @Override
        public ShowableListMenu getPopup() {
            MenuPopup menuPopup = this.this$0.mActionButtonPopup != null ? this.this$0.mActionButtonPopup.getPopup() : null;
            return menuPopup;
        }
    }

    private class OpenOverflowRunnable
    implements Runnable {
        private OverflowPopup mPopup;
        final ActionMenuPresenter this$0;

        public OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, OverflowPopup overflowPopup) {
            this.this$0 = actionMenuPresenter;
            this.mPopup = overflowPopup;
        }

        @Override
        public void run() {
            View view;
            if (this.this$0.mMenu != null) {
                this.this$0.mMenu.changeMenuMode();
            }
            if ((view = (View)this.this$0.mMenuView) != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
                this.this$0.mOverflowPopup = this.mPopup;
            }
            this.this$0.mPostedOpenRunnable = null;
        }
    }

    private class OverflowMenuButton
    extends AppCompatImageView
    implements ActionMenuView.ActionMenuChildView {
        final ActionMenuPresenter this$0;

        public OverflowMenuButton(ActionMenuPresenter actionMenuPresenter, Context context) {
            this.this$0 = actionMenuPresenter;
            super(context, null, R.attr.actionOverflowButtonStyle);
            this.setClickable(true);
            this.setFocusable(true);
            this.setVisibility(0);
            this.setEnabled(true);
            TooltipCompat.setTooltipText((View)this, this.getContentDescription());
            this.setOnTouchListener(new ForwardingListener(this, (View)this, actionMenuPresenter){
                final OverflowMenuButton this$1;
                final ActionMenuPresenter val$this$0;
                {
                    this.this$1 = overflowMenuButton;
                    this.val$this$0 = actionMenuPresenter;
                    super(view);
                }

                @Override
                public ShowableListMenu getPopup() {
                    if (this.this$1.this$0.mOverflowPopup == null) {
                        return null;
                    }
                    return this.this$1.this$0.mOverflowPopup.getPopup();
                }

                @Override
                public boolean onForwardingStarted() {
                    this.this$1.this$0.showOverflowMenu();
                    return true;
                }

                @Override
                public boolean onForwardingStopped() {
                    if (this.this$1.this$0.mPostedOpenRunnable != null) {
                        return false;
                    }
                    this.this$1.this$0.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override
        public boolean needsDividerAfter() {
            return false;
        }

        @Override
        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            this.playSoundEffect(0);
            this.this$0.showOverflowMenu();
            return true;
        }

        protected boolean setFrame(int n, int n2, int n3, int n4) {
            boolean bl = super.setFrame(n, n2, n3, n4);
            Drawable drawable2 = this.getDrawable();
            Drawable drawable3 = this.getBackground();
            if (drawable2 != null && drawable3 != null) {
                int n5 = this.getWidth();
                n3 = this.getHeight();
                n = Math.max(n5, n3) / 2;
                int n6 = this.getPaddingLeft();
                int n7 = this.getPaddingRight();
                n2 = this.getPaddingTop();
                n4 = this.getPaddingBottom();
                n6 = (n5 + (n6 - n7)) / 2;
                n2 = (n3 + (n2 - n4)) / 2;
                DrawableCompat.setHotspotBounds(drawable3, n6 - n, n2 - n, n6 + n, n2 + n);
            }
            return bl;
        }
    }

    private class OverflowPopup
    extends MenuPopupHelper {
        final ActionMenuPresenter this$0;

        public OverflowPopup(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean bl) {
            this.this$0 = actionMenuPresenter;
            super(context, menuBuilder, view, bl, R.attr.actionOverflowMenuStyle);
            this.setGravity(0x800005);
            this.setPresenterCallback(actionMenuPresenter.mPopupPresenterCallback);
        }

        @Override
        protected void onDismiss() {
            if (this.this$0.mMenu != null) {
                this.this$0.mMenu.close();
            }
            this.this$0.mOverflowPopup = null;
            super.onDismiss();
        }
    }

    private class PopupPresenterCallback
    implements MenuPresenter.Callback {
        final ActionMenuPresenter this$0;

        PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
            this.this$0 = actionMenuPresenter;
        }

        @Override
        public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
            MenuPresenter.Callback callback2;
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            if ((callback2 = this.this$0.getCallback()) != null) {
                callback2.onCloseMenu(menuBuilder, bl);
            }
        }

        @Override
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Object object = this.this$0.mMenu;
            boolean bl = false;
            if (menuBuilder == object) {
                return false;
            }
            this.this$0.mOpenSubMenuId = ((SubMenuBuilder)menuBuilder).getItem().getItemId();
            object = this.this$0.getCallback();
            if (object != null) {
                bl = object.onOpenSubMenu(menuBuilder);
            }
            return bl;
        }
    }

    private static class SavedState
    implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        public int openSubMenuId;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int n) {
            parcel.writeInt(this.openSubMenuId);
        }
    }
}

