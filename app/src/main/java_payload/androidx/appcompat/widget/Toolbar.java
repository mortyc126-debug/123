/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.text.Layout
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 *  android.window.OnBackInvokedCallback
 *  android.window.OnBackInvokedDispatcher
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.Toolbar$$ExternalSyntheticLambda1;
import androidx.appcompat.widget.Toolbar$Api33Impl$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.TooltipCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Toolbar
extends ViewGroup
implements MenuHost {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity = 8388627;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    MenuBuilder.Callback mMenuBuilderCallback;
    final MenuHostHelper mMenuHostHelper;
    ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList<MenuItem> mProvidedMenuItems;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews = new ArrayList();
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context object, AttributeSet attributeSet, int n) {
        super(object, attributeSet, n);
        int n2;
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new Toolbar$$ExternalSyntheticLambda0(this));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener(this){
            final Toolbar this$0;
            {
                this.this$0 = toolbar;
            }

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (this.this$0.mMenuHostHelper.onMenuItemSelected(menuItem)) {
                    return true;
                }
                if (this.this$0.mOnMenuItemClickListener != null) {
                    return this.this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable(this){
            final Toolbar this$0;
            {
                this.this$0 = toolbar;
            }

            @Override
            public void run() {
                this.this$0.showOverflowMenu();
            }
        };
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.getContext(), attributeSet, R.styleable.Toolbar, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this, object, R.styleable.Toolbar, attributeSet, tintTypedArray.getWrappedTypeArray(), n, 0);
        this.mTitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = tintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = tintTypedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        n = n2 = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        if (tintTypedArray.hasValue(R.styleable.Toolbar_titleMargins)) {
            n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, n2);
        }
        this.mTitleMarginBottom = n;
        this.mTitleMarginTop = n;
        this.mTitleMarginEnd = n;
        this.mTitleMarginStart = n;
        n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (n >= 0) {
            this.mTitleMarginStart = n;
        }
        if ((n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1)) >= 0) {
            this.mTitleMarginEnd = n;
        }
        if ((n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1)) >= 0) {
            this.mTitleMarginTop = n;
        }
        if ((n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1)) >= 0) {
            this.mTitleMarginBottom = n;
        }
        this.mMaxButtonHeight = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        n = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int n3 = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        n2 = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int n4 = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(n2, n4);
        if (n != Integer.MIN_VALUE || n3 != Integer.MIN_VALUE) {
            this.mContentInsets.setRelative(n, n3);
        }
        this.mContentInsetStartWithNavigation = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = tintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = tintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
        object = tintTypedArray.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty((CharSequence)object)) {
            this.setTitle((CharSequence)object);
        }
        if (!TextUtils.isEmpty((CharSequence)(object = tintTypedArray.getText(R.styleable.Toolbar_subtitle)))) {
            this.setSubtitle((CharSequence)object);
        }
        this.mPopupContext = this.getContext();
        this.setPopupTheme(tintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        object = tintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (object != null) {
            this.setNavigationIcon((Drawable)object);
        }
        if (!TextUtils.isEmpty((CharSequence)(object = tintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription)))) {
            this.setNavigationContentDescription((CharSequence)object);
        }
        if ((object = tintTypedArray.getDrawable(R.styleable.Toolbar_logo)) != null) {
            this.setLogo((Drawable)object);
        }
        if (!TextUtils.isEmpty((CharSequence)(object = tintTypedArray.getText(R.styleable.Toolbar_logoDescription)))) {
            this.setLogoDescription((CharSequence)object);
        }
        if (tintTypedArray.hasValue(R.styleable.Toolbar_titleTextColor)) {
            this.setTitleTextColor(tintTypedArray.getColorStateList(R.styleable.Toolbar_titleTextColor));
        }
        if (tintTypedArray.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            this.setSubtitleTextColor(tintTypedArray.getColorStateList(R.styleable.Toolbar_subtitleTextColor));
        }
        if (tintTypedArray.hasValue(R.styleable.Toolbar_menu)) {
            this.inflateMenu(tintTypedArray.getResourceId(R.styleable.Toolbar_menu, 0));
        }
        tintTypedArray.recycle();
    }

    private void addCustomViewsWithGravity(List<View> list, int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        boolean bl = true;
        if (n2 != 1) {
            bl = false;
        }
        int n3 = this.getChildCount();
        n2 = GravityCompat.getAbsoluteGravity(n, ViewCompat.getLayoutDirection((View)this));
        list.clear();
        if (bl) {
            for (n = n3 - 1; n >= 0; --n) {
                View view = this.getChildAt(n);
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (layoutParams.mViewType != 0 || !this.shouldLayout(view) || this.getChildHorizontalGravity(layoutParams.gravity) != n2) continue;
                list.add(view);
            }
        } else {
            for (n = 0; n < n3; ++n) {
                View view = this.getChildAt(n);
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (layoutParams.mViewType != 0 || !this.shouldLayout(view) || this.getChildHorizontalGravity(layoutParams.gravity) != n2) continue;
                list.add(view);
            }
        }
    }

    private void addSystemView(View view, boolean bl) {
        Object object = view.getLayoutParams();
        object = object == null ? this.generateDefaultLayoutParams() : (!this.checkLayoutParams((ViewGroup.LayoutParams)object) ? this.generateLayoutParams((ViewGroup.LayoutParams)object) : (LayoutParams)((Object)object));
        object.mViewType = 1;
        if (bl && this.mExpandedActionView != null) {
            view.setLayoutParams(object);
            this.mHiddenViews.add(view);
        } else {
            this.addView(view, (ViewGroup.LayoutParams)object);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(this.getContext());
        }
    }

    private void ensureMenu() {
        this.ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder)this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            this.updateBackInvokedCallbackState();
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(this.getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new MenuBuilder.Callback(this){
                final Toolbar this$0;
                {
                    this.this$0 = toolbar;
                }

                @Override
                public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                    boolean bl = this.this$0.mMenuBuilderCallback != null && this.this$0.mMenuBuilderCallback.onMenuItemSelected(menuBuilder, menuItem);
                    return bl;
                }

                @Override
                public void onMenuModeChange(MenuBuilder menuBuilder) {
                    if (!this.this$0.mMenuView.isOverflowMenuShowing()) {
                        this.this$0.mMenuHostHelper.onPrepareMenu(menuBuilder);
                    }
                    if (this.this$0.mMenuBuilderCallback != null) {
                        this.this$0.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
                    }
                }
            });
            LayoutParams layoutParams = this.generateDefaultLayoutParams();
            layoutParams.gravity = this.mButtonGravity & 0x70 | 0x800005;
            this.mMenuView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.addSystemView((View)this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(this.getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParams = this.generateDefaultLayoutParams();
            layoutParams.gravity = this.mButtonGravity & 0x70 | 0x800003;
            this.mNavButtonView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
    }

    private int getChildHorizontalGravity(int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        n = GravityCompat.getAbsoluteGravity(n, n2) & 7;
        switch (n) {
            default: {
                n = n2 == 1 ? 5 : 3;
            }
            case 1: 
            case 3: 
            case 5: {
                return n;
            }
        }
        return n;
    }

    private int getChildTop(View view, int n) {
        int n2;
        block5: {
            int n3;
            int n4;
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n5 = view.getMeasuredHeight();
            n = n > 0 ? (n5 - n) / 2 : 0;
            switch (this.getChildVerticalGravity(layoutParams.gravity)) {
                default: {
                    n2 = this.getPaddingTop();
                    n = this.getPaddingBottom();
                    n4 = this.getHeight();
                    n3 = (n4 - n2 - n - n5) / 2;
                    if (n3 >= layoutParams.topMargin) break;
                    n = layoutParams.topMargin;
                    break block5;
                }
                case 80: {
                    return this.getHeight() - this.getPaddingBottom() - n5 - layoutParams.bottomMargin - n;
                }
                case 48: {
                    return this.getPaddingTop() - n;
                }
            }
            n5 = n4 - n - n5 - n3 - n2;
            n = n3;
            if (n5 < layoutParams.bottomMargin) {
                n = Math.max(0, n3 - (layoutParams.bottomMargin - n5));
            }
        }
        return n2 + n;
    }

    private int getChildVerticalGravity(int n) {
        switch (n &= 0x70) {
            default: {
                return this.mGravity & 0x70;
            }
            case 16: 
            case 48: 
            case 80: 
        }
        return n;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<MenuItem>();
        Menu menu = this.getMenu();
        for (int i = 0; i < menu.size(); ++i) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private int getHorizontalMargins(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)view) + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)view);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.getContext());
    }

    private int getVerticalMargins(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        return view.topMargin + view.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] object) {
        int n = object[0];
        int n2 = object[1];
        int n3 = 0;
        int n4 = list.size();
        for (int i = 0; i < n4; ++i) {
            object = list.get(i);
            LayoutParams layoutParams = (LayoutParams)object.getLayoutParams();
            n = layoutParams.leftMargin - n;
            n2 = layoutParams.rightMargin - n2;
            int n5 = Math.max(0, n);
            int n6 = Math.max(0, n2);
            n = Math.max(0, -n);
            n2 = Math.max(0, -n2);
            n3 += object.getMeasuredWidth() + n5 + n6;
        }
        return n3;
    }

    private boolean isChildOrHidden(View view) {
        boolean bl = view.getParent() == this || this.mHiddenViews.contains(view);
        return bl;
    }

    private int layoutChildLeft(View view, int n, int[] nArray, int n2) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n3 = layoutParams.leftMargin - nArray[0];
        n += Math.max(0, n3);
        nArray[0] = Math.max(0, -n3);
        n2 = this.getChildTop(view, n2);
        n3 = view.getMeasuredWidth();
        view.layout(n, n2, n + n3, view.getMeasuredHeight() + n2);
        return n + (layoutParams.rightMargin + n3);
    }

    private int layoutChildRight(View view, int n, int[] nArray, int n2) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n3 = layoutParams.rightMargin - nArray[1];
        n -= Math.max(0, n3);
        nArray[1] = Math.max(0, -n3);
        n2 = this.getChildTop(view, n2);
        n3 = view.getMeasuredWidth();
        view.layout(n - n3, n2, n, view.getMeasuredHeight() + n2);
        return n - (layoutParams.leftMargin + n3);
    }

    private int measureChildCollapseMargins(View view, int n, int n2, int n3, int n4, int[] nArray) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n5 = marginLayoutParams.leftMargin - nArray[0];
        int n6 = marginLayoutParams.rightMargin - nArray[1];
        int n7 = Math.max(0, n5) + Math.max(0, n6);
        nArray[0] = Math.max(0, -n5);
        nArray[1] = Math.max(0, -n6);
        n = Toolbar.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + n7 + n2), (int)marginLayoutParams.width);
        view.measure(n, Toolbar.getChildMeasureSpec((int)n3, (int)(this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + n4), (int)marginLayoutParams.height));
        return view.getMeasuredWidth() + n7;
    }

    private void measureChildConstrained(View view, int n, int n2, int n3, int n4, int n5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n6 = Toolbar.getChildMeasureSpec((int)n, (int)(this.getPaddingLeft() + this.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + n2), (int)marginLayoutParams.width);
        n2 = Toolbar.getChildMeasureSpec((int)n3, (int)(this.getPaddingTop() + this.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + n4), (int)marginLayoutParams.height);
        n3 = View.MeasureSpec.getMode((int)n2);
        n = n2;
        if (n3 != 0x40000000) {
            n = n2;
            if (n5 >= 0) {
                n = n3 != 0 ? Math.min(View.MeasureSpec.getSize((int)n2), n5) : n5;
                n = View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000);
            }
        }
        view.measure(n6, n);
    }

    private void onCreateMenu() {
        Object object = this.getMenu();
        ArrayList<MenuItem> arrayList = this.getCurrentMenuItems();
        this.mMenuHostHelper.onCreateMenu((Menu)object, this.getMenuInflater());
        object = this.getCurrentMenuItems();
        ((ArrayList)object).removeAll(arrayList);
        this.mProvidedMenuItems = object;
    }

    private void postShowOverflowMenu() {
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
        this.post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int n = this.getChildCount();
        for (int i = 0; i < n; ++i) {
            View view = this.getChildAt(i);
            if (!this.shouldLayout(view) || view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) continue;
            return false;
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        boolean bl = view != null && view.getParent() == this && view.getVisibility() != 8;
        return bl;
    }

    void addChildrenForExpandedActionView() {
        for (int i = this.mHiddenViews.size() - 1; i >= 0; --i) {
            this.addView(this.mHiddenViews.get(i));
        }
        this.mHiddenViews.clear();
    }

    @Override
    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.addMenuProvider(menuProvider);
    }

    @Override
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner);
    }

    @Override
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.addMenuProvider(menuProvider, lifecycleOwner, state);
    }

    public boolean canShowOverflowMenu() {
        boolean bl = this.getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
        return bl;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = super.checkLayoutParams(layoutParams) && layoutParams instanceof LayoutParams;
        return bl;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.mCurrentExpandedItem;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new AppCompatImageButton(this.getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams layoutParams = this.generateDefaultLayoutParams();
            layoutParams.gravity = this.mButtonGravity & 0x70 | 0x800003;
            layoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener(this){
                final Toolbar this$0;
                {
                    this.this$0 = toolbar;
                }

                public void onClick(View view) {
                    this.this$0.collapseActionView();
                }
            });
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams)layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams)layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        CharSequence charSequence = this.mCollapseButtonView != null ? this.mCollapseButtonView.getContentDescription() : null;
        return charSequence;
    }

    public Drawable getCollapseIcon() {
        Drawable drawable2 = this.mCollapseButtonView != null ? this.mCollapseButtonView.getDrawable() : null;
        return drawable2;
    }

    public int getContentInsetEnd() {
        int n = this.mContentInsets != null ? this.mContentInsets.getEnd() : 0;
        return n;
    }

    public int getContentInsetEndWithActions() {
        int n = this.mContentInsetEndWithActions != Integer.MIN_VALUE ? this.mContentInsetEndWithActions : this.getContentInsetEnd();
        return n;
    }

    public int getContentInsetLeft() {
        int n = this.mContentInsets != null ? this.mContentInsets.getLeft() : 0;
        return n;
    }

    public int getContentInsetRight() {
        int n = this.mContentInsets != null ? this.mContentInsets.getRight() : 0;
        return n;
    }

    public int getContentInsetStart() {
        int n = this.mContentInsets != null ? this.mContentInsets.getStart() : 0;
        return n;
    }

    public int getContentInsetStartWithNavigation() {
        int n = this.mContentInsetStartWithNavigation != Integer.MIN_VALUE ? this.mContentInsetStartWithNavigation : this.getContentInsetStart();
        return n;
    }

    public int getCurrentContentInsetEnd() {
        int n = 0;
        if (this.mMenuView != null) {
            MenuBuilder menuBuilder = this.mMenuView.peekMenu();
            n = menuBuilder != null && menuBuilder.hasVisibleItems() ? 1 : 0;
        }
        n = n != 0 ? Math.max(this.getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0)) : this.getContentInsetEnd();
        return n;
    }

    public int getCurrentContentInsetLeft() {
        int n = ViewCompat.getLayoutDirection((View)this) == 1 ? this.getCurrentContentInsetEnd() : this.getCurrentContentInsetStart();
        return n;
    }

    public int getCurrentContentInsetRight() {
        int n = ViewCompat.getLayoutDirection((View)this) == 1 ? this.getCurrentContentInsetStart() : this.getCurrentContentInsetEnd();
        return n;
    }

    public int getCurrentContentInsetStart() {
        int n = this.getNavigationIcon() != null ? Math.max(this.getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0)) : this.getContentInsetStart();
        return n;
    }

    public Drawable getLogo() {
        Drawable drawable2 = this.mLogoView != null ? this.mLogoView.getDrawable() : null;
        return drawable2;
    }

    public CharSequence getLogoDescription() {
        CharSequence charSequence = this.mLogoView != null ? this.mLogoView.getContentDescription() : null;
        return charSequence;
    }

    public Menu getMenu() {
        this.ensureMenu();
        return this.mMenuView.getMenu();
    }

    View getNavButtonView() {
        return this.mNavButtonView;
    }

    public CharSequence getNavigationContentDescription() {
        CharSequence charSequence = this.mNavButtonView != null ? this.mNavButtonView.getContentDescription() : null;
        return charSequence;
    }

    public Drawable getNavigationIcon() {
        Drawable drawable2 = this.mNavButtonView != null ? this.mNavButtonView.getDrawable() : null;
        return drawable2;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        this.ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        boolean bl = this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null;
        return bl;
    }

    public boolean hideOverflowMenu() {
        boolean bl = this.mMenuView != null && this.mMenuView.hideOverflowMenu();
        return bl;
    }

    public void inflateMenu(int n) {
        this.getMenuInflater().inflate(n, this.getMenu());
    }

    @Override
    public void invalidateMenu() {
        for (MenuItem menuItem : this.mProvidedMenuItems) {
            this.getMenu().removeItem(menuItem.getItemId());
        }
        this.onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl = this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
        return bl;
    }

    public boolean isOverflowMenuShowing() {
        boolean bl = this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
        return bl;
    }

    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout layout2 = this.mTitleTextView.getLayout();
        if (layout2 == null) {
            return false;
        }
        int n = layout2.getLineCount();
        for (int i = 0; i < n; ++i) {
            if (layout2.getEllipsisCount(i) <= 0) continue;
            return true;
        }
        return false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.updateBackInvokedCallbackState();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.mShowOverflowMenuRunnable);
        this.updateBackInvokedCallbackState();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean bl = super.onHoverEvent(motionEvent);
            if (n == 9 && !bl) {
                this.mEatingHover = true;
            }
        }
        if (n == 10 || n == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5;
        int[] nArray;
        int n6;
        int n7;
        int n8;
        block37: {
            LayoutParams layoutParams;
            boolean bl2;
            int n9;
            int n10;
            int n11;
            int n12;
            block39: {
                block38: {
                    int n13;
                    int n14;
                    block36: {
                        n12 = ViewCompat.getLayoutDirection((View)this) == 1 ? 1 : 0;
                        n8 = this.getWidth();
                        n14 = this.getHeight();
                        n7 = this.getPaddingLeft();
                        n6 = this.getPaddingRight();
                        n11 = this.getPaddingTop();
                        n13 = this.getPaddingBottom();
                        n10 = n7;
                        n9 = n8 - n6;
                        nArray = this.mTempMargins;
                        nArray[1] = 0;
                        nArray[0] = 0;
                        n = ViewCompat.getMinimumHeight((View)this);
                        n5 = n >= 0 ? Math.min(n, n4 - n2) : 0;
                        n = n10;
                        n3 = n9;
                        if (this.shouldLayout((View)this.mNavButtonView)) {
                            if (n12 != 0) {
                                n3 = this.layoutChildRight((View)this.mNavButtonView, n9, nArray, n5);
                                n = n10;
                            } else {
                                n = this.layoutChildLeft((View)this.mNavButtonView, n10, nArray, n5);
                                n3 = n9;
                            }
                        }
                        n2 = n;
                        n4 = n3;
                        if (this.shouldLayout((View)this.mCollapseButtonView)) {
                            if (n12 != 0) {
                                n4 = this.layoutChildRight((View)this.mCollapseButtonView, n3, nArray, n5);
                                n2 = n;
                            } else {
                                n2 = this.layoutChildLeft((View)this.mCollapseButtonView, n, nArray, n5);
                                n4 = n3;
                            }
                        }
                        n3 = n2;
                        n = n4;
                        if (this.shouldLayout((View)this.mMenuView)) {
                            if (n12 != 0) {
                                n3 = this.layoutChildLeft((View)this.mMenuView, n2, nArray, n5);
                                n = n4;
                            } else {
                                n = this.layoutChildRight((View)this.mMenuView, n4, nArray, n5);
                                n3 = n2;
                            }
                        }
                        n2 = this.getCurrentContentInsetLeft();
                        n4 = this.getCurrentContentInsetRight();
                        nArray[0] = Math.max(0, n2 - n3);
                        nArray[1] = Math.max(0, n4 - (n8 - n6 - n));
                        n2 = Math.max(n3, n2);
                        n3 = Math.min(n, n8 - n6 - n4);
                        n = n2;
                        n4 = n3;
                        if (this.shouldLayout(this.mExpandedActionView)) {
                            if (n12 != 0) {
                                n4 = this.layoutChildRight(this.mExpandedActionView, n3, nArray, n5);
                                n = n2;
                            } else {
                                n = this.layoutChildLeft(this.mExpandedActionView, n2, nArray, n5);
                                n4 = n3;
                            }
                        }
                        n3 = n;
                        n2 = n4;
                        if (this.shouldLayout((View)this.mLogoView)) {
                            if (n12 != 0) {
                                n2 = this.layoutChildRight((View)this.mLogoView, n4, nArray, n5);
                                n3 = n;
                            } else {
                                n3 = this.layoutChildLeft((View)this.mLogoView, n, nArray, n5);
                                n2 = n4;
                            }
                        }
                        bl2 = this.shouldLayout((View)this.mTitleTextView);
                        bl = this.shouldLayout((View)this.mSubtitleTextView);
                        n = 0;
                        if (bl2) {
                            layoutParams = (LayoutParams)this.mTitleTextView.getLayoutParams();
                            n = 0 + (layoutParams.topMargin + this.mTitleTextView.getMeasuredHeight() + layoutParams.bottomMargin);
                        }
                        n10 = n;
                        if (bl) {
                            layoutParams = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                            n10 = n + (layoutParams.topMargin + this.mSubtitleTextView.getMeasuredHeight() + layoutParams.bottomMargin);
                        }
                        if (bl2 || bl) break block36;
                        n = n3;
                        break block37;
                    }
                    layoutParams = bl2 ? this.mTitleTextView : this.mSubtitleTextView;
                    Object object = bl ? this.mSubtitleTextView : this.mTitleTextView;
                    layoutParams = (LayoutParams)layoutParams.getLayoutParams();
                    object = (LayoutParams)object.getLayoutParams();
                    n4 = bl2 && this.mTitleTextView.getMeasuredWidth() > 0 || bl && this.mSubtitleTextView.getMeasuredWidth() > 0 ? 1 : 0;
                    switch (this.mGravity & 0x70) {
                        default: {
                            n9 = (n14 - n11 - n13 - n10) / 2;
                            if (n9 >= layoutParams.topMargin + this.mTitleMarginTop) break;
                            n = layoutParams.topMargin + this.mTitleMarginTop;
                            break block38;
                        }
                        case 80: {
                            n = n14 - n13 - object.bottomMargin - this.mTitleMarginBottom - n10;
                            break block39;
                        }
                        case 48: {
                            n = this.getPaddingTop() + layoutParams.topMargin + this.mTitleMarginTop;
                            break block39;
                        }
                    }
                    n10 = n14 - n13 - n10 - n9 - n11;
                    n = n9;
                    if (n10 < layoutParams.bottomMargin + this.mTitleMarginBottom) {
                        n = Math.max(0, n9 - (object.bottomMargin + this.mTitleMarginBottom - n10));
                    }
                }
                n = n11 + n;
            }
            if (n12 != 0) {
                n12 = n4 != 0 ? this.mTitleMarginStart : 0;
                nArray[1] = Math.max(0, -n12);
                n10 = n2 -= Math.max(0, n12 -= nArray[1]);
                n12 = n2;
                if (bl2) {
                    layoutParams = (LayoutParams)this.mTitleTextView.getLayoutParams();
                    n11 = n10 - this.mTitleTextView.getMeasuredWidth();
                    n9 = this.mTitleTextView.getMeasuredHeight() + n;
                    this.mTitleTextView.layout(n11, n, n10, n9);
                    n = n11 - this.mTitleMarginEnd;
                    n9 += layoutParams.bottomMargin;
                } else {
                    n9 = n;
                    n = n10;
                }
                n10 = n12;
                if (bl) {
                    layoutParams = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                    n11 = this.mSubtitleTextView.getMeasuredWidth();
                    n10 = this.mSubtitleTextView.getMeasuredHeight() + (n9 += layoutParams.topMargin);
                    this.mSubtitleTextView.layout(n12 - n11, n9, n12, n10);
                    n10 = n12 - this.mTitleMarginEnd;
                    n12 = layoutParams.bottomMargin;
                }
                if (n4 != 0) {
                    n2 = Math.min(n, n10);
                }
                n = n3;
            } else {
                n12 = n4 != 0 ? this.mTitleMarginStart : 0;
                nArray[0] = Math.max(0, -n12);
                n10 = n3 += Math.max(0, n12 -= nArray[0]);
                n12 = n3;
                if (bl2) {
                    layoutParams = (LayoutParams)this.mTitleTextView.getLayoutParams();
                    n11 = this.mTitleTextView.getMeasuredWidth() + n10;
                    n9 = this.mTitleTextView.getMeasuredHeight() + n;
                    this.mTitleTextView.layout(n10, n, n11, n9);
                    n = n11 + this.mTitleMarginEnd;
                    n9 += layoutParams.bottomMargin;
                } else {
                    n9 = n;
                    n = n10;
                }
                n10 = n12;
                if (bl) {
                    layoutParams = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                    n10 = n9 + layoutParams.topMargin;
                    n9 = this.mSubtitleTextView.getMeasuredWidth() + n12;
                    n11 = this.mSubtitleTextView.getMeasuredHeight() + n10;
                    this.mSubtitleTextView.layout(n12, n10, n9, n11);
                    n10 = n9 + this.mTitleMarginEnd;
                    n12 = layoutParams.bottomMargin;
                }
                n = n4 != 0 ? Math.max(n, n10) : n3;
            }
        }
        this.addCustomViewsWithGravity(this.mTempViews, 3);
        n4 = this.mTempViews.size();
        for (n3 = 0; n3 < n4; ++n3) {
            n = this.layoutChildLeft(this.mTempViews.get(n3), n, nArray, n5);
        }
        this.addCustomViewsWithGravity(this.mTempViews, 5);
        n4 = this.mTempViews.size();
        for (n3 = 0; n3 < n4; ++n3) {
            n2 = this.layoutChildRight(this.mTempViews.get(n3), n2, nArray, n5);
        }
        this.addCustomViewsWithGravity(this.mTempViews, 1);
        n4 = this.getViewListMeasuredWidth(this.mTempViews, nArray);
        n3 = n7 + (n8 - n7 - n6) / 2 - n4 / 2;
        n4 = n3 + n4;
        if (n3 >= n) {
            n = n3;
            if (n4 > n2) {
                n = n3 - (n4 - n2);
            }
        }
        n4 = this.mTempViews.size();
        n3 = 0;
        n2 = n;
        for (n = n3; n < n4; ++n) {
            n2 = this.layoutChildLeft(this.mTempViews.get(n), n2, nArray, n5);
        }
        this.mTempViews.clear();
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        int n4;
        int n5 = 0;
        int n6 = 0;
        int[] nArray = this.mTempMargins;
        if (ViewUtils.isLayoutRtl((View)this)) {
            n4 = 1;
            n3 = 0;
        } else {
            n4 = 0;
            n3 = 1;
        }
        int n7 = 0;
        if (this.shouldLayout((View)this.mNavButtonView)) {
            this.measureChildConstrained((View)this.mNavButtonView, n, 0, n2, 0, this.mMaxButtonHeight);
            n7 = this.mNavButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mNavButtonView);
            n5 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + this.getVerticalMargins((View)this.mNavButtonView));
            n6 = View.combineMeasuredStates((int)0, (int)this.mNavButtonView.getMeasuredState());
        }
        int n8 = n5;
        int n9 = n6;
        if (this.shouldLayout((View)this.mCollapseButtonView)) {
            this.measureChildConstrained((View)this.mCollapseButtonView, n, 0, n2, 0, this.mMaxButtonHeight);
            n7 = this.mCollapseButtonView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mCollapseButtonView);
            n8 = Math.max(n5, this.mCollapseButtonView.getMeasuredHeight() + this.getVerticalMargins((View)this.mCollapseButtonView));
            n9 = View.combineMeasuredStates((int)n6, (int)this.mCollapseButtonView.getMeasuredState());
        }
        n6 = this.getCurrentContentInsetStart();
        n5 = 0 + Math.max(n6, n7);
        nArray[n4] = Math.max(0, n6 - n7);
        if (this.shouldLayout((View)this.mMenuView)) {
            this.measureChildConstrained((View)this.mMenuView, n, n5, n2, 0, this.mMaxButtonHeight);
            n6 = this.mMenuView.getMeasuredWidth();
            n7 = this.getHorizontalMargins((View)this.mMenuView);
            n8 = Math.max(n8, this.mMenuView.getMeasuredHeight() + this.getVerticalMargins((View)this.mMenuView));
            n9 = View.combineMeasuredStates((int)n9, (int)this.mMenuView.getMeasuredState());
            n6 += n7;
        } else {
            n6 = 0;
        }
        n7 = this.getCurrentContentInsetEnd();
        n5 += Math.max(n7, n6);
        nArray[n3] = Math.max(0, n7 - n6);
        if (this.shouldLayout(this.mExpandedActionView)) {
            n3 = n5 + this.measureChildCollapseMargins(this.mExpandedActionView, n, n5, n2, 0, nArray);
            n6 = Math.max(n8, this.mExpandedActionView.getMeasuredHeight() + this.getVerticalMargins(this.mExpandedActionView));
            n9 = View.combineMeasuredStates((int)n9, (int)this.mExpandedActionView.getMeasuredState());
        } else {
            n6 = n8;
            n3 = n5;
        }
        n7 = n3;
        n5 = n6;
        n8 = n9;
        if (this.shouldLayout((View)this.mLogoView)) {
            n7 = n3 + this.measureChildCollapseMargins((View)this.mLogoView, n, n3, n2, 0, nArray);
            n5 = Math.max(n6, this.mLogoView.getMeasuredHeight() + this.getVerticalMargins((View)this.mLogoView));
            n8 = View.combineMeasuredStates((int)n9, (int)this.mLogoView.getMeasuredState());
        }
        n6 = this.getChildCount();
        n9 = n8;
        n8 = n5;
        n5 = n7;
        n3 = 0;
        n7 = n8;
        for (n8 = n3; n8 < n6; ++n8) {
            View view = this.getChildAt(n8);
            if (((LayoutParams)view.getLayoutParams()).mViewType != 0 || !this.shouldLayout(view)) continue;
            n5 += this.measureChildCollapseMargins(view, n, n5, n2, 0, nArray);
            n7 = Math.max(n7, view.getMeasuredHeight() + this.getVerticalMargins(view));
            n9 = View.combineMeasuredStates((int)n9, (int)view.getMeasuredState());
        }
        n3 = n9;
        n6 = 0;
        n8 = 0;
        int n10 = this.mTitleMarginTop + this.mTitleMarginBottom;
        n4 = this.mTitleMarginStart + this.mTitleMarginEnd;
        n9 = n3;
        if (this.shouldLayout((View)this.mTitleTextView)) {
            this.measureChildCollapseMargins((View)this.mTitleTextView, n, n5 + n4, n2, n10, nArray);
            n6 = this.mTitleTextView.getMeasuredWidth() + this.getHorizontalMargins((View)this.mTitleTextView);
            n8 = this.mTitleTextView.getMeasuredHeight() + this.getVerticalMargins((View)this.mTitleTextView);
            n9 = View.combineMeasuredStates((int)n3, (int)this.mTitleTextView.getMeasuredState());
        }
        if (this.shouldLayout((View)this.mSubtitleTextView)) {
            n6 = Math.max(n6, this.measureChildCollapseMargins((View)this.mSubtitleTextView, n, n5 + n4, n2, n8 + n10, nArray));
            n4 = this.mSubtitleTextView.getMeasuredHeight();
            n3 = this.getVerticalMargins((View)this.mSubtitleTextView);
            n9 = View.combineMeasuredStates((int)n9, (int)this.mSubtitleTextView.getMeasuredState());
            n8 += n4 + n3;
        }
        n7 = Math.max(n7, n8);
        n10 = this.getPaddingLeft();
        n4 = this.getPaddingRight();
        n3 = this.getPaddingTop();
        n8 = this.getPaddingBottom();
        n6 = View.resolveSizeAndState((int)Math.max(n5 + n6 + (n10 + n4), this.getSuggestedMinimumWidth()), (int)n, (int)(0xFF000000 & n9));
        n = View.resolveSizeAndState((int)Math.max(n7 + (n3 + n8), this.getSuggestedMinimumHeight()), (int)n2, (int)(n9 << 16));
        if (this.shouldCollapse()) {
            n = 0;
        }
        this.setMeasuredDimension(n6, n);
    }

    protected void onRestoreInstanceState(Parcelable object) {
        if (!(object instanceof SavedState)) {
            super.onRestoreInstanceState(object);
            return;
        }
        SavedState savedState = (SavedState)object;
        super.onRestoreInstanceState(savedState.getSuperState());
        object = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
        if (savedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && object != null && (object = object.findItem(savedState.expandedMenuItemId)) != null) {
            object.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            this.postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int n) {
        super.onRtlPropertiesChanged(n);
        this.ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        rtlSpacingHelper.setDirection(bl);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        savedState.isOverflowOpen = this.isOverflowMenuShowing();
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n = motionEvent.getActionMasked();
        if (n == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean bl = super.onTouchEvent(motionEvent);
            if (n == 0 && !bl) {
                this.mEatingTouch = true;
            }
        }
        if (n == 1 || n == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    void removeChildrenForExpandedActionView() {
        for (int i = this.getChildCount() - 1; i >= 0; --i) {
            View view = this.getChildAt(i);
            if (((LayoutParams)view.getLayoutParams()).mViewType == 2 || view == this.mMenuView) continue;
            this.removeViewAt(i);
            this.mHiddenViews.add(view);
        }
    }

    @Override
    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean bl) {
        if (this.mBackInvokedCallbackEnabled != bl) {
            this.mBackInvokedCallbackEnabled = bl;
            this.updateBackInvokedCallbackState();
        }
    }

    public void setCollapseContentDescription(int n) {
        CharSequence charSequence = n != 0 ? this.getContext().getText(n) : null;
        this.setCollapseContentDescription(charSequence);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.ensureCollapseButtonView();
        }
        if (this.mCollapseButtonView != null) {
            this.mCollapseButtonView.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int n) {
        this.setCollapseIcon(AppCompatResources.getDrawable(this.getContext(), n));
    }

    public void setCollapseIcon(Drawable drawable2) {
        if (drawable2 != null) {
            this.ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable2);
        } else if (this.mCollapseButtonView != null) {
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
        }
    }

    public void setCollapsible(boolean bl) {
        this.mCollapsible = bl;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int n) {
        int n2 = n;
        if (n < 0) {
            n2 = Integer.MIN_VALUE;
        }
        if (n2 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = n2;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int n) {
        int n2 = n;
        if (n < 0) {
            n2 = Integer.MIN_VALUE;
        }
        if (n2 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = n2;
            if (this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int n, int n2) {
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(n, n2);
    }

    public void setContentInsetsRelative(int n, int n2) {
        this.ensureContentInsets();
        this.mContentInsets.setRelative(n, n2);
    }

    public void setLogo(int n) {
        this.setLogo(AppCompatResources.getDrawable(this.getContext(), n));
    }

    public void setLogo(Drawable drawable2) {
        if (drawable2 != null) {
            this.ensureLogoView();
            if (!this.isChildOrHidden((View)this.mLogoView)) {
                this.addSystemView((View)this.mLogoView, true);
            }
        } else if (this.mLogoView != null && this.isChildOrHidden((View)this.mLogoView)) {
            this.removeView((View)this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable2);
        }
    }

    public void setLogoDescription(int n) {
        this.setLogoDescription(this.getContext().getText(n));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(charSequence);
        }
    }

    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        if (menuBuilder == null && this.mMenuView == null) {
            return;
        }
        this.ensureMenuView();
        MenuBuilder menuBuilder2 = this.mMenuView.peekMenu();
        if (menuBuilder2 == menuBuilder) {
            return;
        }
        if (menuBuilder2 != null) {
            menuBuilder2.removeMenuPresenter(this.mOuterActionMenuPresenter);
            menuBuilder2.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
        }
        actionMenuPresenter.setExpandedActionViewsExclusive(true);
        if (menuBuilder != null) {
            menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
            actionMenuPresenter.initForMenu(this.mPopupContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            actionMenuPresenter.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
        this.updateBackInvokedCallbackState();
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback2, MenuBuilder.Callback callback3) {
        this.mActionMenuPresenterCallback = callback2;
        this.mMenuBuilderCallback = callback3;
        if (this.mMenuView != null) {
            this.mMenuView.setMenuCallbacks(callback2, callback3);
        }
    }

    public void setNavigationContentDescription(int n) {
        CharSequence charSequence = n != 0 ? this.getContext().getText(n) : null;
        this.setNavigationContentDescription(charSequence);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            this.ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(charSequence);
            TooltipCompat.setTooltipText((View)this.mNavButtonView, charSequence);
        }
    }

    public void setNavigationIcon(int n) {
        this.setNavigationIcon(AppCompatResources.getDrawable(this.getContext(), n));
    }

    public void setNavigationIcon(Drawable drawable2) {
        if (drawable2 != null) {
            this.ensureNavButtonView();
            if (!this.isChildOrHidden((View)this.mNavButtonView)) {
                this.addSystemView((View)this.mNavButtonView, true);
            }
        } else if (this.mNavButtonView != null && this.isChildOrHidden((View)this.mNavButtonView)) {
            this.removeView((View)this.mNavButtonView);
            this.mHiddenViews.remove(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(drawable2);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        this.ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable2) {
        this.ensureMenu();
        this.mMenuView.setOverflowIcon(drawable2);
    }

    public void setPopupTheme(int n) {
        if (this.mPopupTheme != n) {
            this.mPopupTheme = n;
            this.mPopupContext = n == 0 ? this.getContext() : new ContextThemeWrapper(this.getContext(), n);
        }
    }

    public void setSubtitle(int n) {
        this.setSubtitle(this.getContext().getText(n));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = this.getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != null) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (!this.isChildOrHidden((View)this.mSubtitleTextView)) {
                this.addSystemView((View)this.mSubtitleTextView, true);
            }
        } else if (this.mSubtitleTextView != null && this.isChildOrHidden((View)this.mSubtitleTextView)) {
            this.removeView((View)this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int n) {
        this.mSubtitleTextAppearance = n;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, n);
        }
    }

    public void setSubtitleTextColor(int n) {
        this.setSubtitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int n) {
        this.setTitle(this.getContext().getText(n));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = this.getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != null) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (!this.isChildOrHidden((View)this.mTitleTextView)) {
                this.addSystemView((View)this.mTitleTextView, true);
            }
        } else if (this.mTitleTextView != null && this.isChildOrHidden((View)this.mTitleTextView)) {
            this.removeView((View)this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleMargin(int n, int n2, int n3, int n4) {
        this.mTitleMarginStart = n;
        this.mTitleMarginTop = n2;
        this.mTitleMarginEnd = n3;
        this.mTitleMarginBottom = n4;
        this.requestLayout();
    }

    public void setTitleMarginBottom(int n) {
        this.mTitleMarginBottom = n;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int n) {
        this.mTitleMarginEnd = n;
        this.requestLayout();
    }

    public void setTitleMarginStart(int n) {
        this.mTitleMarginStart = n;
        this.requestLayout();
    }

    public void setTitleMarginTop(int n) {
        this.mTitleMarginTop = n;
        this.requestLayout();
    }

    public void setTitleTextAppearance(Context context, int n) {
        this.mTitleTextAppearance = n;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, n);
        }
    }

    public void setTitleTextColor(int n) {
        this.setTitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(colorStateList);
        }
    }

    public boolean showOverflowMenu() {
        boolean bl = this.mMenuView != null && this.mMenuView.showOverflowMenu();
        return bl;
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = Api33Impl.findOnBackInvokedDispatcher((View)this);
            boolean bl = this.hasExpandedActionView() && onBackInvokedDispatcher != null && ViewCompat.isAttachedToWindow((View)this) && this.mBackInvokedCallbackEnabled;
            if (bl && this.mBackInvokedDispatcher == null) {
                if (this.mBackInvokedCallback == null) {
                    this.mBackInvokedCallback = Api33Impl.newOnBackInvokedCallback(new Toolbar$$ExternalSyntheticLambda1(this));
                }
                Api33Impl.tryRegisterOnBackInvokedCallback(onBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = onBackInvokedDispatcher;
            } else if (!bl && this.mBackInvokedDispatcher != null) {
                Api33Impl.tryUnregisterOnBackInvokedCallback(this.mBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = null;
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher findOnBackInvokedDispatcher(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback newOnBackInvokedCallback(Runnable runnable2) {
            Objects.requireNonNull(runnable2);
            return new Toolbar$Api33Impl$$ExternalSyntheticLambda0(runnable2);
        }

        static void tryRegisterOnBackInvokedCallback(Object object, Object object2) {
            ((OnBackInvokedDispatcher)object).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback)object2);
        }

        static void tryUnregisterOnBackInvokedCallback(Object object, Object object2) {
            ((OnBackInvokedDispatcher)object).unregisterOnBackInvokedCallback((OnBackInvokedCallback)object2);
        }
    }

    private class ExpandedActionViewMenuPresenter
    implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final Toolbar this$0;

        ExpandedActionViewMenuPresenter(Toolbar toolbar) {
            this.this$0 = toolbar;
        }

        @Override
        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewCollapsed();
            }
            this.this$0.removeView(this.this$0.mExpandedActionView);
            this.this$0.removeView((View)this.this$0.mCollapseButtonView);
            this.this$0.mExpandedActionView = null;
            this.this$0.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            this.this$0.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            this.this$0.updateBackInvokedCallbackState();
            return true;
        }

        @Override
        public boolean expandItemActionView(MenuBuilder object, MenuItemImpl menuItemImpl) {
            this.this$0.ensureCollapseButtonView();
            object = this.this$0.mCollapseButtonView.getParent();
            if (object != this.this$0) {
                if (object instanceof ViewGroup) {
                    ((ViewGroup)object).removeView((View)this.this$0.mCollapseButtonView);
                }
                this.this$0.addView((View)this.this$0.mCollapseButtonView);
            }
            this.this$0.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            object = this.this$0.mExpandedActionView.getParent();
            if (object != this.this$0) {
                if (object instanceof ViewGroup) {
                    ((ViewGroup)object).removeView(this.this$0.mExpandedActionView);
                }
                object = this.this$0.generateDefaultLayoutParams();
                ((LayoutParams)((Object)object)).gravity = this.this$0.mButtonGravity & 0x70 | 0x800003;
                ((LayoutParams)((Object)object)).mViewType = 2;
                this.this$0.mExpandedActionView.setLayoutParams((ViewGroup.LayoutParams)object);
                this.this$0.addView(this.this$0.mExpandedActionView);
            }
            this.this$0.removeChildrenForExpandedActionView();
            this.this$0.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (this.this$0.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView)this.this$0.mExpandedActionView).onActionViewExpanded();
            }
            this.this$0.updateBackInvokedCallbackState();
            return true;
        }

        @Override
        public boolean flagActionItems() {
            return false;
        }

        @Override
        public int getId() {
            return 0;
        }

        @Override
        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        @Override
        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            if (this.mMenu != null && this.mCurrentExpandedItem != null) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menuBuilder;
        }

        @Override
        public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        }

        @Override
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override
        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override
        public void setCallback(MenuPresenter.Callback callback2) {
        }

        @Override
        public void updateMenuView(boolean bl) {
            if (this.mCurrentExpandedItem != null) {
                boolean bl2;
                boolean bl3 = bl2 = false;
                if (this.mMenu != null) {
                    int n = this.mMenu.size();
                    int n2 = 0;
                    while (true) {
                        bl3 = bl2;
                        if (n2 >= n) break;
                        if (this.mMenu.getItem(n2) == this.mCurrentExpandedItem) {
                            bl3 = true;
                            break;
                        }
                        ++n2;
                    }
                }
                if (!bl3) {
                    this.collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }
    }

    public static class LayoutParams
    extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType = 0;

        public LayoutParams(int n) {
            this(-2, -1, n);
        }

        public LayoutParams(int n, int n2) {
            super(n, n2);
            this.gravity = 8388627;
        }

        public LayoutParams(int n, int n2, int n3) {
            super(n, n2);
            this.gravity = n3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super((ViewGroup.LayoutParams)marginLayoutParams);
            this.copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = layoutParams.mViewType;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static interface OnMenuItemClickListener {
        public boolean onMenuItemClick(MenuItem var1);
    }

    public static class SavedState
    extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>(){

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int n) {
                return new SavedState[n];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            boolean bl = parcel.readInt() != 0;
            this.isOverflowOpen = bl;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override
        public void writeToParcel(Parcel parcel, int n) {
            super.writeToParcel(parcel, n);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }
}

