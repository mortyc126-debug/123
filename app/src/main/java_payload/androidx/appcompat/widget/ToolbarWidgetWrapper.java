/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window$Callback
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class ToolbarWidgetWrapper
implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200L;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription = 0;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode = 0;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window.Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean bl) {
        this(toolbar, bl, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar object, boolean bl, int n, int n2) {
        this.mToolbar = object;
        this.mTitle = ((Toolbar)object).getTitle();
        this.mSubtitle = ((Toolbar)object).getSubtitle();
        boolean bl2 = this.mTitle != null;
        this.mTitleSet = bl2;
        this.mNavIcon = ((Toolbar)object).getNavigationIcon();
        object = TintTypedArray.obtainStyledAttributes(object.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = ((TintTypedArray)object).getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (bl) {
            CharSequence charSequence = ((TintTypedArray)object).getText(R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                this.setTitle(charSequence);
            }
            if (!TextUtils.isEmpty((CharSequence)(charSequence = ((TintTypedArray)object).getText(R.styleable.ActionBar_subtitle)))) {
                this.setSubtitle(charSequence);
            }
            if ((charSequence = ((TintTypedArray)object).getDrawable(R.styleable.ActionBar_logo)) != null) {
                this.setLogo((Drawable)charSequence);
            }
            if ((charSequence = ((TintTypedArray)object).getDrawable(R.styleable.ActionBar_icon)) != null) {
                this.setIcon((Drawable)charSequence);
            }
            if (this.mNavIcon == null && this.mDefaultNavigationIcon != null) {
                this.setNavigationIcon(this.mDefaultNavigationIcon);
            }
            this.setDisplayOptions(((TintTypedArray)object).getInt(R.styleable.ActionBar_displayOptions, 0));
            n2 = ((TintTypedArray)object).getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (n2 != 0) {
                this.setCustomView(LayoutInflater.from((Context)this.mToolbar.getContext()).inflate(n2, (ViewGroup)this.mToolbar, false));
                this.setDisplayOptions(this.mDisplayOpts | 0x10);
            }
            if ((n2 = ((TintTypedArray)object).getLayoutDimension(R.styleable.ActionBar_height, 0)) > 0) {
                charSequence = this.mToolbar.getLayoutParams();
                ((ViewGroup.LayoutParams)charSequence).height = n2;
                this.mToolbar.setLayoutParams((ViewGroup.LayoutParams)charSequence);
            }
            n2 = ((TintTypedArray)object).getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int n3 = ((TintTypedArray)object).getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (n2 >= 0 || n3 >= 0) {
                this.mToolbar.setContentInsetsRelative(Math.max(n2, 0), Math.max(n3, 0));
            }
            if ((n2 = ((TintTypedArray)object).getResourceId(R.styleable.ActionBar_titleTextStyle, 0)) != 0) {
                this.mToolbar.setTitleTextAppearance(this.mToolbar.getContext(), n2);
            }
            if ((n2 = ((TintTypedArray)object).getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0)) != 0) {
                this.mToolbar.setSubtitleTextAppearance(this.mToolbar.getContext(), n2);
            }
            if ((n2 = ((TintTypedArray)object).getResourceId(R.styleable.ActionBar_popupTheme, 0)) != 0) {
                this.mToolbar.setPopupTheme(n2);
            }
        } else {
            this.mDisplayOpts = this.detectDisplayOptions();
        }
        ((TintTypedArray)object).recycle();
        this.setDefaultNavigationContentDescription(n);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener(this){
            final ActionMenuItem mNavItem;
            final ToolbarWidgetWrapper this$0;
            {
                this.this$0 = toolbarWidgetWrapper;
                this.mNavItem = new ActionMenuItem(this.this$0.mToolbar.getContext(), 0, 16908332, 0, 0, this.this$0.mTitle);
            }

            public void onClick(View view) {
                if (this.this$0.mWindowCallback != null && this.this$0.mMenuPrepared) {
                    this.this$0.mWindowCallback.onMenuItemSelected(0, (MenuItem)this.mNavItem);
                }
            }
        });
    }

    private int detectDisplayOptions() {
        int n = 11;
        if (this.mToolbar.getNavigationIcon() != null) {
            n = 0xB | 4;
            this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        }
        return n;
    }

    private void ensureSpinner() {
        if (this.mSpinner == null) {
            this.mSpinner = new AppCompatSpinner(this.getContext(), null, R.attr.actionDropDownStyle);
            Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2, 8388627);
            this.mSpinner.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        }
    }

    private void setTitleInt(CharSequence charSequence) {
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setTitle(charSequence);
            if (this.mTitleSet) {
                ViewCompat.setAccessibilityPaneTitle(this.mToolbar.getRootView(), charSequence);
            }
        }
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) != 0) {
            if (TextUtils.isEmpty((CharSequence)this.mHomeDescription)) {
                this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            } else {
                this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
            }
        }
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable2 = this.mNavIcon != null ? this.mNavIcon : this.mDefaultNavigationIcon;
            toolbar.setNavigationIcon(drawable2);
        } else {
            this.mToolbar.setNavigationIcon(null);
        }
    }

    private void updateToolbarLogo() {
        Drawable drawable2 = null;
        if ((this.mDisplayOpts & 2) != 0) {
            drawable2 = (this.mDisplayOpts & 1) != 0 ? (this.mLogo != null ? this.mLogo : this.mIcon) : this.mIcon;
        }
        this.mToolbar.setLogo(drawable2);
    }

    @Override
    public void animateToVisibility(int n) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.setupAnimatorToVisibility(n, 200L);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    @Override
    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    @Override
    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    @Override
    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    @Override
    public Context getContext() {
        return this.mToolbar.getContext();
    }

    @Override
    public View getCustomView() {
        return this.mCustomView;
    }

    @Override
    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    @Override
    public int getDropdownItemCount() {
        int n = this.mSpinner != null ? this.mSpinner.getCount() : 0;
        return n;
    }

    @Override
    public int getDropdownSelectedPosition() {
        int n = this.mSpinner != null ? this.mSpinner.getSelectedItemPosition() : 0;
        return n;
    }

    @Override
    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    @Override
    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    @Override
    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    @Override
    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    @Override
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override
    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    @Override
    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    @Override
    public boolean hasEmbeddedTabs() {
        boolean bl = this.mTabView != null;
        return bl;
    }

    @Override
    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    @Override
    public boolean hasIcon() {
        boolean bl = this.mIcon != null;
        return bl;
    }

    @Override
    public boolean hasLogo() {
        boolean bl = this.mLogo != null;
        return bl;
    }

    @Override
    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    @Override
    public void initIndeterminateProgress() {
        Log.i((String)TAG, (String)"Progress display unsupported");
    }

    @Override
    public void initProgress() {
        Log.i((String)TAG, (String)"Progress display unsupported");
    }

    @Override
    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    @Override
    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    @Override
    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    @Override
    public void restoreHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }

    @Override
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable2) {
        ViewCompat.setBackground((View)this.mToolbar, drawable2);
    }

    @Override
    public void setCollapsible(boolean bl) {
        this.mToolbar.setCollapsible(bl);
    }

    @Override
    public void setCustomView(View view) {
        if (this.mCustomView != null && (this.mDisplayOpts & 0x10) != 0) {
            this.mToolbar.removeView(this.mCustomView);
        }
        this.mCustomView = view;
        if (view != null && (this.mDisplayOpts & 0x10) != 0) {
            this.mToolbar.addView(this.mCustomView);
        }
    }

    @Override
    public void setDefaultNavigationContentDescription(int n) {
        if (n == this.mDefaultNavigationContentDescription) {
            return;
        }
        this.mDefaultNavigationContentDescription = n;
        if (TextUtils.isEmpty((CharSequence)this.mToolbar.getNavigationContentDescription())) {
            this.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        }
    }

    @Override
    public void setDefaultNavigationIcon(Drawable drawable2) {
        if (this.mDefaultNavigationIcon != drawable2) {
            this.mDefaultNavigationIcon = drawable2;
            this.updateNavigationIcon();
        }
    }

    @Override
    public void setDisplayOptions(int n) {
        int n2 = this.mDisplayOpts ^ n;
        this.mDisplayOpts = n;
        if (n2 != 0) {
            if ((n2 & 4) != 0) {
                if ((n & 4) != 0) {
                    this.updateHomeAccessibility();
                }
                this.updateNavigationIcon();
            }
            if ((n2 & 3) != 0) {
                this.updateToolbarLogo();
            }
            if ((n2 & 8) != 0) {
                if ((n & 8) != 0) {
                    this.mToolbar.setTitle(this.mTitle);
                    this.mToolbar.setSubtitle(this.mSubtitle);
                } else {
                    this.mToolbar.setTitle(null);
                    this.mToolbar.setSubtitle(null);
                }
            }
            if ((n2 & 0x10) != 0 && this.mCustomView != null) {
                if ((n & 0x10) != 0) {
                    this.mToolbar.addView(this.mCustomView);
                } else {
                    this.mToolbar.removeView(this.mCustomView);
                }
            }
        }
    }

    @Override
    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override
    public void setDropdownSelectedPosition(int n) {
        if (this.mSpinner != null) {
            this.mSpinner.setSelection(n);
            return;
        }
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.mTabView != null && this.mTabView.getParent() == this.mToolbar) {
            this.mToolbar.removeView(this.mTabView);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.mNavigationMode == 2) {
            this.mToolbar.addView(this.mTabView, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    @Override
    public void setHomeButtonEnabled(boolean bl) {
    }

    @Override
    public void setIcon(int n) {
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable(this.getContext(), n) : null;
        this.setIcon(drawable2);
    }

    @Override
    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        this.updateToolbarLogo();
    }

    @Override
    public void setLogo(int n) {
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable(this.getContext(), n) : null;
        this.setLogo(drawable2);
    }

    @Override
    public void setLogo(Drawable drawable2) {
        this.mLogo = drawable2;
        this.updateToolbarLogo();
    }

    @Override
    public void setMenu(Menu menu, MenuPresenter.Callback callback2) {
        if (this.mActionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
        }
        this.mActionMenuPresenter.setCallback(callback2);
        this.mToolbar.setMenu((MenuBuilder)menu, this.mActionMenuPresenter);
    }

    @Override
    public void setMenuCallbacks(MenuPresenter.Callback callback2, MenuBuilder.Callback callback3) {
        this.mToolbar.setMenuCallbacks(callback2, callback3);
    }

    @Override
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    @Override
    public void setNavigationContentDescription(int n) {
        String string2 = n == 0 ? null : this.getContext().getString(n);
        this.setNavigationContentDescription(string2);
    }

    @Override
    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        this.updateHomeAccessibility();
    }

    @Override
    public void setNavigationIcon(int n) {
        Drawable drawable2 = n != 0 ? AppCompatResources.getDrawable(this.getContext(), n) : null;
        this.setNavigationIcon(drawable2);
    }

    @Override
    public void setNavigationIcon(Drawable drawable2) {
        this.mNavIcon = drawable2;
        this.updateNavigationIcon();
    }

    @Override
    public void setNavigationMode(int n) {
        int n2 = this.mNavigationMode;
        if (n != n2) {
            switch (n2) {
                default: {
                    break;
                }
                case 2: {
                    if (this.mTabView == null || this.mTabView.getParent() != this.mToolbar) break;
                    this.mToolbar.removeView(this.mTabView);
                    break;
                }
                case 1: {
                    if (this.mSpinner == null || this.mSpinner.getParent() != this.mToolbar) break;
                    this.mToolbar.removeView((View)this.mSpinner);
                }
            }
            this.mNavigationMode = n;
            switch (n) {
                default: {
                    throw new IllegalArgumentException("Invalid navigation mode " + n);
                }
                case 2: {
                    if (this.mTabView == null) break;
                    this.mToolbar.addView(this.mTabView, 0);
                    Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams)this.mTabView.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    layoutParams.gravity = 8388691;
                    break;
                }
                case 1: {
                    this.ensureSpinner();
                    this.mToolbar.addView((View)this.mSpinner, 0);
                }
                case 0: 
            }
        }
    }

    @Override
    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setSubtitle(charSequence);
        }
    }

    @Override
    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        this.setTitleInt(charSequence);
    }

    @Override
    public void setVisibility(int n) {
        this.mToolbar.setVisibility(n);
    }

    @Override
    public void setWindowCallback(Window.Callback callback2) {
        this.mWindowCallback = callback2;
    }

    @Override
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            this.setTitleInt(charSequence);
        }
    }

    @Override
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int n, long l) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.mToolbar);
        float f = n == 0 ? 1.0f : 0.0f;
        return viewPropertyAnimatorCompat.alpha(f).setDuration(l).setListener(new ViewPropertyAnimatorListenerAdapter(this, n){
            private boolean mCanceled;
            final ToolbarWidgetWrapper this$0;
            final int val$visibility;
            {
                this.this$0 = toolbarWidgetWrapper;
                this.val$visibility = n;
                this.mCanceled = false;
            }

            @Override
            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            @Override
            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    this.this$0.mToolbar.setVisibility(this.val$visibility);
                }
            }

            @Override
            public void onAnimationStart(View view) {
                this.this$0.mToolbar.setVisibility(0);
            }
        });
    }

    @Override
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}

