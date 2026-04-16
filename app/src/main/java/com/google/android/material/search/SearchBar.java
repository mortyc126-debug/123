package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes3.dex */
public class SearchBar extends Toolbar {
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private final AccessibilityManager accessibilityManager;
    private MaterialShapeDrawable backgroundShape;
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private int menuResId;
    private Integer navigationIconTint;
    private Drawable originalNavigationIconBackground;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private final TextView textView;
    private final boolean tintNavigationIcon;
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* JADX INFO: renamed from: lambda$new$0$com-google-android-material-search-SearchBar, reason: not valid java name */
    /* synthetic */ void m95lambda$new$0$comgoogleandroidmaterialsearchSearchBar(boolean enabled) {
        setFocusableInTouchMode(enabled);
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.materialSearchBarStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(MaterialThemeOverlay.wrap(context, attrs, defStyleAttr, DEF_STYLE_RES), attrs, defStyleAttr);
        this.menuResId = -1;
        this.touchExplorationStateChangeListener = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.search.SearchBar$$ExternalSyntheticLambda0
            public final void onTouchExplorationStateChanged(boolean z) {
                this.f$0.m95lambda$new$0$comgoogleandroidmaterialsearchSearchBar(z);
            }
        };
        Context context2 = getContext();
        validateAttributes(attrs);
        this.defaultNavigationIcon = AppCompatResources.getDrawable(context2, getDefaultNavigationIconResource());
        this.searchBarAnimationHelper = new SearchBarAnimationHelper();
        TypedArray a = ThemeEnforcement.obtainStyledAttributes(context2, attrs, R.styleable.SearchBar, defStyleAttr, DEF_STYLE_RES, new int[0]);
        ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attrs, defStyleAttr, DEF_STYLE_RES).build();
        int backgroundColor = a.getColor(R.styleable.SearchBar_backgroundTint, 0);
        float elevation = a.getDimension(R.styleable.SearchBar_elevation, 0.0f);
        this.defaultMarginsEnabled = a.getBoolean(R.styleable.SearchBar_defaultMarginsEnabled, true);
        this.defaultScrollFlagsEnabled = a.getBoolean(R.styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean hideNavigationIcon = a.getBoolean(R.styleable.SearchBar_hideNavigationIcon, false);
        this.forceDefaultNavigationOnClickListener = a.getBoolean(R.styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.tintNavigationIcon = a.getBoolean(R.styleable.SearchBar_tintNavigationIcon, true);
        if (a.hasValue(R.styleable.SearchBar_navigationIconTint)) {
            this.navigationIconTint = Integer.valueOf(a.getColor(R.styleable.SearchBar_navigationIconTint, -1));
        }
        int textAppearanceResId = a.getResourceId(R.styleable.SearchBar_android_textAppearance, -1);
        String text = a.getString(R.styleable.SearchBar_android_text);
        String hint = a.getString(R.styleable.SearchBar_android_hint);
        float strokeWidth = a.getDimension(R.styleable.SearchBar_strokeWidth, -1.0f);
        int strokeColor = a.getColor(R.styleable.SearchBar_strokeColor, 0);
        a.recycle();
        if (!hideNavigationIcon) {
            initNavigationIcon();
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_bar, (ViewGroup) this);
        this.layoutInflated = true;
        this.textView = (TextView) findViewById(R.id.open_search_bar_text_view);
        ViewCompat.setElevation(this, elevation);
        initTextView(textAppearanceResId, text, hint);
        initBackground(shapeAppearanceModel, backgroundColor, elevation, strokeWidth, strokeColor);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setupTouchExplorationStateChangeListener();
    }

    private void setupTouchExplorationStateChangeListener() {
        if (this.accessibilityManager != null) {
            if (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.search.SearchBar.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View ignored) {
                    AccessibilityManagerCompat.addTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View ignored) {
                    AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }
            });
        }
    }

    private void validateAttributes(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(NAMESPACE_APP, "title") != null) {
            throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_APP, "subtitle") != null) {
            throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
        }
    }

    private void initNavigationIcon() {
        setNavigationIcon(getNavigationIcon() == null ? this.defaultNavigationIcon : getNavigationIcon());
        setNavigationIconDecorative(true);
    }

    private void initTextView(int textAppearanceResId, String text, String hint) {
        if (textAppearanceResId != -1) {
            TextViewCompat.setTextAppearance(this.textView, textAppearanceResId);
        }
        setText(text);
        setHint(hint);
        if (getNavigationIcon() == null) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.textView.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initBackground(ShapeAppearanceModel shapeAppearance, int backgroundColor, float elevation, float strokeWidth, int strokeColor) {
        this.backgroundShape = new MaterialShapeDrawable(shapeAppearance);
        this.backgroundShape.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(elevation);
        if (strokeWidth >= 0.0f) {
            this.backgroundShape.setStroke(strokeWidth, strokeColor);
        }
        int rippleColor = MaterialColors.getColor(this, R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(backgroundColor));
        Drawable background = new RippleDrawable(ColorStateList.valueOf(rippleColor), this.backgroundShape, this.backgroundShape);
        ViewCompat.setBackground(this, background);
    }

    private ColorStateList getCompatBackgroundColorStateList(int backgroundColor, int rippleColor) {
        int[][] states = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[0]};
        int pressedBackgroundColor = MaterialColors.layer(backgroundColor, rippleColor);
        int[] colors = {pressedBackgroundColor, pressedBackgroundColor, backgroundColor};
        return new ColorStateList(states, colors);
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.layoutInflated && this.centerView == null && !(child instanceof ActionMenuView)) {
            this.centerView = child;
            this.centerView.setAlpha(0.0f);
        }
        super.addView(child, index, params);
    }

    public void setElevation(float elevation) {
        super.setElevation(elevation);
        if (this.backgroundShape != null) {
            this.backgroundShape.setElevation(elevation);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(EditText.class.getCanonicalName());
        info.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isTextEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            info.setHintText(getHint());
            info.setShowingHintText(isTextEmpty);
        }
        if (isTextEmpty) {
            text = getHint();
        }
        info.setText(text);
    }

    public void setNavigationOnClickListener(View.OnClickListener listener) {
        if (this.forceDefaultNavigationOnClickListener) {
            return;
        }
        super.setNavigationOnClickListener(listener);
        setNavigationIconDecorative(listener == null);
    }

    public void setNavigationIcon(Drawable navigationIcon) {
        super.setNavigationIcon(maybeTintNavigationIcon(navigationIcon));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable maybeTintNavigationIcon(Drawable navigationIcon) {
        int navigationIconColorAttr;
        int navigationIconColorAttr2;
        if (!this.tintNavigationIcon || navigationIcon == null) {
            return navigationIcon;
        }
        if (this.navigationIconTint != null) {
            navigationIconColorAttr2 = this.navigationIconTint.intValue();
        } else {
            if (navigationIcon == this.defaultNavigationIcon) {
                navigationIconColorAttr = R.attr.colorOnSurfaceVariant;
            } else {
                navigationIconColorAttr = R.attr.colorOnSurface;
            }
            navigationIconColorAttr2 = MaterialColors.getColor(this, navigationIconColorAttr);
        }
        Drawable wrappedNavigationIcon = DrawableCompat.wrap(navigationIcon.mutate());
        DrawableCompat.setTint(wrappedNavigationIcon, navigationIconColorAttr2);
        return wrappedNavigationIcon;
    }

    private void setNavigationIconDecorative(boolean decorative) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton == null) {
            return;
        }
        navigationIconButton.setClickable(!decorative);
        navigationIconButton.setFocusable(!decorative);
        Drawable navigationIconBackground = navigationIconButton.getBackground();
        if (navigationIconBackground != null) {
            this.originalNavigationIconBackground = navigationIconBackground;
        }
        navigationIconButton.setBackgroundDrawable(decorative ? null : this.originalNavigationIconBackground);
        setHandwritingBoundsInsets();
    }

    public void inflateMenu(int resId) {
        MenuBuilder menu = getMenu();
        if (menu instanceof MenuBuilder) {
            menu.stopDispatchingItemsChanged();
        }
        super.inflateMenu(resId);
        this.menuResId = resId;
        if (menu instanceof MenuBuilder) {
            menu.startDispatchingItemsChanged();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureCenterView(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        layoutCenterView();
        setHandwritingBoundsInsets();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
    }

    public void setTitle(CharSequence title) {
    }

    public void setSubtitle(CharSequence subtitle) {
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int marginHorizontal = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int marginVertical = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
            lp.leftMargin = defaultIfZero(lp.leftMargin, marginHorizontal);
            lp.topMargin = defaultIfZero(lp.topMargin, marginVertical);
            lp.rightMargin = defaultIfZero(lp.rightMargin, marginHorizontal);
            lp.bottomMargin = defaultIfZero(lp.bottomMargin, marginVertical);
        }
    }

    protected int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    protected int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    private int defaultIfZero(int value, int defValue) {
        return value == 0 ? defValue : value;
    }

    private void setOrClearDefaultScrollFlags() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams lp = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.defaultScrollFlagsEnabled) {
                if (lp.getScrollFlags() == 0) {
                    lp.setScrollFlags(DEFAULT_SCROLL_FLAGS);
                }
            } else if (lp.getScrollFlags() == DEFAULT_SCROLL_FLAGS) {
                lp.setScrollFlags(0);
            }
        }
    }

    private void measureCenterView(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.centerView != null) {
            this.centerView.measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void layoutCenterView() {
        if (this.centerView == null) {
            return;
        }
        int centerViewWidth = this.centerView.getMeasuredWidth();
        int left = (getMeasuredWidth() / 2) - (centerViewWidth / 2);
        int right = left + centerViewWidth;
        int centerViewHeight = this.centerView.getMeasuredHeight();
        int top = (getMeasuredHeight() / 2) - (centerViewHeight / 2);
        int bottom = top + centerViewHeight;
        layoutChild(this.centerView, left, top, right, bottom);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void layoutChild(View child, int left, int top, int right, int bottom) {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            child.layout(getMeasuredWidth() - right, top, getMeasuredWidth() - left, bottom);
        } else {
            child.layout(left, top, right, bottom);
        }
    }

    private void setHandwritingBoundsInsets() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean isRtl = getLayoutDirection() == 1;
        int startInset = 0;
        View navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton != null && navigationIconButton.isClickable()) {
            startInset = isRtl ? getWidth() - navigationIconButton.getLeft() : navigationIconButton.getRight();
        }
        int endInset = 0;
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this);
        if (actionMenuView != null) {
            endInset = isRtl ? actionMenuView.getRight() : getWidth() - actionMenuView.getLeft();
        }
        setHandwritingBoundsOffsets(-(isRtl ? endInset : startInset), 0.0f, -(isRtl ? startInset : endInset), 0.0f);
    }

    public View getCenterView() {
        return this.centerView;
    }

    public void setCenterView(View view) {
        if (this.centerView != null) {
            removeView(this.centerView);
            this.centerView = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public TextView getTextView() {
        return this.textView;
    }

    public CharSequence getText() {
        return this.textView.getText();
    }

    public void setText(CharSequence text) {
        this.textView.setText(text);
    }

    public void setText(int textResId) {
        this.textView.setText(textResId);
    }

    public void clearText() {
        this.textView.setText(HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public CharSequence getHint() {
        return this.textView.getHint();
    }

    public void setHint(CharSequence hint) {
        this.textView.setHint(hint);
    }

    public void setHint(int hintResId) {
        this.textView.setHint(hintResId);
    }

    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    public void setStrokeColor(int strokeColor) {
        if (getStrokeColor() != strokeColor) {
            this.backgroundShape.setStrokeColor(ColorStateList.valueOf(strokeColor));
        }
    }

    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    public void setStrokeWidth(float strokeWidth) {
        if (getStrokeWidth() != strokeWidth) {
            this.backgroundShape.setStrokeWidth(strokeWidth);
        }
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public void setDefaultScrollFlagsEnabled(boolean defaultScrollFlagsEnabled) {
        this.defaultScrollFlagsEnabled = defaultScrollFlagsEnabled;
        setOrClearDefaultScrollFlags();
    }

    /* JADX INFO: renamed from: lambda$startOnLoadAnimation$1$com-google-android-material-search-SearchBar, reason: not valid java name */
    /* synthetic */ void m96x58362b63() {
        this.searchBarAnimationHelper.startOnLoadAnimation(this);
    }

    public void startOnLoadAnimation() {
        post(new Runnable() { // from class: com.google.android.material.search.SearchBar$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m96x58362b63();
            }
        });
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    public void setOnLoadAnimationFadeInEnabled(boolean onLoadAnimationFadeInEnabled) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(onLoadAnimationFadeInEnabled);
    }

    public void addOnLoadAnimationCallback(OnLoadAnimationCallback onLoadAnimationCallback) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public boolean removeOnLoadAnimationCallback(OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean expand(View expandedView) {
        return expand(expandedView, null);
    }

    public boolean expand(View expandedView, AppBarLayout appBarLayout) {
        return expand(expandedView, appBarLayout, false);
    }

    public boolean expand(View expandedView, AppBarLayout appBarLayout, boolean skipAnimation) {
        if ((expandedView.getVisibility() != 0 && !isExpanding()) || isCollapsing()) {
            this.searchBarAnimationHelper.startExpandAnimation(this, expandedView, appBarLayout, skipAnimation);
            return true;
        }
        return false;
    }

    public void addExpandAnimationListener(AnimatorListenerAdapter listener) {
        this.searchBarAnimationHelper.addExpandAnimationListener(listener);
    }

    public boolean removeExpandAnimationListener(AnimatorListenerAdapter listener) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(listener);
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean collapse(View expandedView) {
        return collapse(expandedView, null);
    }

    public boolean collapse(View expandedView, AppBarLayout appBarLayout) {
        return collapse(expandedView, appBarLayout, false);
    }

    public boolean collapse(View expandedView, AppBarLayout appBarLayout, boolean skipAnimation) {
        if ((expandedView.getVisibility() == 0 && !isCollapsing()) || isExpanding()) {
            this.searchBarAnimationHelper.startCollapseAnimation(this, expandedView, appBarLayout, skipAnimation);
            return true;
        }
        return false;
    }

    public void addCollapseAnimationListener(AnimatorListenerAdapter listener) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(listener);
    }

    public boolean removeCollapseAnimationListener(AnimatorListenerAdapter listener) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(listener);
    }

    int getMenuResId() {
        return this.menuResId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    float getCompatElevation() {
        return this.backgroundShape != null ? this.backgroundShape.getElevation() : ViewCompat.getElevation(this);
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized;

        public ScrollingViewBehavior() {
            this.initialized = false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.initialized = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
        public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
            boolean changed = super.onDependentViewChanged(parent, child, dependency);
            if (!this.initialized && (dependency instanceof AppBarLayout)) {
                this.initialized = true;
                AppBarLayout appBarLayout = (AppBarLayout) dependency;
                setAppBarLayoutTransparent(appBarLayout);
            }
            return changed;
        }

        private void setAppBarLayoutTransparent(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        protected boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }
    }

    public static abstract class OnLoadAnimationCallback {
        public void onAnimationStart() {
        }

        public void onAnimationEnd() {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.google.android.material.search.SearchBar$SavedState] */
    protected Parcelable onSaveInstanceState() {
        ?? savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.text = text == null ? null : text.toString();
        return savedState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.text);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.search.SearchBar.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel source, ClassLoader loader) {
                return new SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        String text;

        public SavedState(Parcel source) {
            this(source, null);
        }

        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            this.text = source.readString();
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeString(this.text);
        }
    }
}
