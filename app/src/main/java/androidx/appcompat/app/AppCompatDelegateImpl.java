/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.UiModeManager
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.LocaleList
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 *  android.os.PowerManager
 *  android.text.TextUtils
 *  android.util.AndroidRuntimeException
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.KeyboardShortcutGroup
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.PopupWindow
 *  android.widget.TextView
 *  android.window.OnBackInvokedCallback
 *  android.window.OnBackInvokedDispatcher
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.app.LayoutIncludeDetector;
import androidx.appcompat.app.LocaleOverlayHelper;
import androidx.appcompat.app.ResourcesFlusher;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.app.TwilightManager;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;

class AppCompatDelegateImpl
extends AppCompatDelegate
implements MenuBuilder.Callback,
LayoutInflater.Factory2 {
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP;
    private static final boolean sCanApplyOverrideConfiguration;
    private static final boolean sCanReturnDifferentContext;
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap<String, Integer> sLocalNightModes;
    private static final int[] sWindowBackgroundStyleable;
    ActionBar mActionBar;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private int mActivityHandlesConfigFlags;
    private boolean mActivityHandlesConfigFlagsChecked;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private OnBackInvokedCallback mBackCallback;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    boolean mDestroyed;
    private OnBackInvokedDispatcher mDispatcher;
    private Configuration mEffectiveConfiguration;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim = null;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes = true;
    boolean mHasActionBar;
    final Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable = new Runnable(this){
        final AppCompatDelegateImpl this$0;
        {
            this.this$0 = appCompatDelegateImpl;
        }

        @Override
        public void run() {
            if ((this.this$0.mInvalidatePanelMenuFeatures & 1) != 0) {
                this.this$0.doInvalidatePanelMenu(0);
            }
            if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1000) != 0) {
                this.this$0.doInvalidatePanelMenu(108);
            }
            this.this$0.mInvalidatePanelMenuPosted = false;
            this.this$0.mInvalidatePanelMenuFeatures = 0;
        }
    };
    boolean mIsFloating;
    private LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode = -100;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private View mStatusGuard;
    ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    Window mWindow;
    boolean mWindowNoTitle;

    static {
        sLocalNightModes = new SimpleArrayMap();
        IS_PRE_LOLLIPOP = false;
        sWindowBackgroundStyleable = new int[]{16842836};
        sCanReturnDifferentContext = "robolectric".equals(Build.FINGERPRINT) ^ true;
        sCanApplyOverrideConfiguration = true;
        if (IS_PRE_LOLLIPOP && !sInstalledExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()){
                final Thread.UncaughtExceptionHandler val$defHandler;
                {
                    this.val$defHandler = uncaughtExceptionHandler;
                }

                private boolean shouldWrapException(Throwable object) {
                    boolean bl = object instanceof Resources.NotFoundException;
                    boolean bl2 = false;
                    if (bl) {
                        if ((object = ((Throwable)object).getMessage()) != null && (((String)object).contains("drawable") || ((String)object).contains("Drawable"))) {
                            bl2 = true;
                        }
                        return bl2;
                    }
                    return false;
                }

                @Override
                public void uncaughtException(Thread thread, Throwable throwable) {
                    if (this.shouldWrapException(throwable)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(throwable.getMessage() + AppCompatDelegateImpl.EXCEPTION_HANDLER_MESSAGE_SUFFIX);
                        notFoundException.initCause(throwable.getCause());
                        notFoundException.setStackTrace(throwable.getStackTrace());
                        this.val$defHandler.uncaughtException(thread, (Throwable)notFoundException);
                    } else {
                        this.val$defHandler.uncaughtException(thread, throwable);
                    }
                }
            });
            sInstalledExceptionHandler = true;
        }
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this((Context)activity, null, appCompatCallback, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    private AppCompatDelegateImpl(Context object, Window window, AppCompatCallback appCompatCallback, Object object2) {
        this.mContext = object;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = object2;
        if (this.mLocalNightMode == -100 && this.mHost instanceof Dialog && (object = this.tryUnwrapContext()) != null) {
            this.mLocalNightMode = ((AppCompatActivity)object).getDelegate().getLocalNightMode();
        }
        if (this.mLocalNightMode == -100 && (object = sLocalNightModes.get(this.mHost.getClass().getName())) != null) {
            this.mLocalNightMode = (Integer)object;
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        if (window != null) {
            this.attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    private void VavralmConfiguration(Configuration configuration2) {
        Activity activity = (Activity)this.mHost;
        if (activity instanceof LifecycleOwner) {
            if (((LifecycleOwner)activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                activity.onConfigurationChanged(configuration2);
            }
        } else if (this.mCreated && !this.mDestroyed) {
            activity.onConfigurationChanged(configuration2);
        }
    }

    private boolean applyApplicationSpecificConfig(boolean bl) {
        return this.applyApplicationSpecificConfig(bl, true);
    }

    private boolean applyApplicationSpecificConfig(boolean bl, boolean bl2) {
        if (this.mDestroyed) {
            return false;
        }
        int n = this.calculateNightMode();
        int n2 = this.mapNightMode(this.mContext, n);
        LocaleListCompat localeListCompat = null;
        if (Build.VERSION.SDK_INT < 33) {
            localeListCompat = this.calculateApplicationLocales(this.mContext);
        }
        LocaleListCompat localeListCompat2 = localeListCompat;
        if (!bl2) {
            localeListCompat2 = localeListCompat;
            if (localeListCompat != null) {
                localeListCompat2 = this.getConfigurationLocales(this.mContext.getResources().getConfiguration());
            }
        }
        bl = this.updateAppConfiguration(n2, localeListCompat2, bl);
        if (n == 0) {
            this.getAutoTimeNightModeManager(this.mContext).setup();
        } else if (this.mAutoTimeNightModeManager != null) {
            this.mAutoTimeNightModeManager.cleanup();
        }
        if (n == 3) {
            this.getAutoBatteryNightModeManager(this.mContext).setup();
        } else if (this.mAutoBatteryNightModeManager != null) {
            this.mAutoBatteryNightModeManager.cleanup();
        }
        return bl;
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(0x1020002);
        View view = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        view = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        view.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        view.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        view.recycle();
        contentFrameLayout.requestLayout();
    }

    private void attachToWindow(Window window) {
        if (this.mWindow == null) {
            Window.Callback callback2 = window.getCallback();
            if (!(callback2 instanceof AppCompatWindowCallback)) {
                this.mAppCompatWindowCallback = new AppCompatWindowCallback(this, callback2);
                window.setCallback((Window.Callback)this.mAppCompatWindowCallback);
                TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
                callback2 = tintTypedArray.getDrawableIfKnown(0);
                if (callback2 != null) {
                    window.setBackgroundDrawable((Drawable)callback2);
                }
                tintTypedArray.recycle();
                this.mWindow = window;
                if (Build.VERSION.SDK_INT >= 33 && this.mDispatcher == null) {
                    this.setOnBackInvokedDispatcher(null);
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private int calculateNightMode() {
        int n = this.mLocalNightMode != -100 ? this.mLocalNightMode : AppCompatDelegateImpl.getDefaultNightMode();
        return n;
    }

    private void cleanupAutoManagers() {
        if (this.mAutoTimeNightModeManager != null) {
            this.mAutoTimeNightModeManager.cleanup();
        }
        if (this.mAutoBatteryNightModeManager != null) {
            this.mAutoBatteryNightModeManager.cleanup();
        }
    }

    private Configuration createOverrideAppConfiguration(Context context, int n, LocaleListCompat localeListCompat, Configuration configuration2, boolean bl) {
        switch (n) {
            default: {
                n = bl ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 0x30;
            }
            case 2: {
                n = 32;
                break;
            }
            case 1: {
                n = 16;
                break;
            }
        }
        context = new Configuration();
        context.fontScale = 0.0f;
        if (configuration2 != null) {
            context.setTo(configuration2);
        }
        context.uiMode = context.uiMode & 0xFFFFFFCF | n;
        if (localeListCompat != null) {
            this.setConfigurationLocales((Configuration)context, localeListCompat);
        }
        return context;
    }

    private ViewGroup createSubDecor() {
        Object object = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (object.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (object.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                this.requestWindowFeature(1);
            } else if (object.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                this.requestWindowFeature(108);
            }
            if (object.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                this.requestWindowFeature(109);
            }
            if (object.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                this.requestWindowFeature(10);
            }
            this.mIsFloating = object.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            object.recycle();
            this.ensureWindow();
            this.mWindow.getDecorView();
            LayoutInflater layoutInflater = LayoutInflater.from((Context)this.mContext);
            object = null;
            if (!this.mWindowNoTitle) {
                if (this.mIsFloating) {
                    object = (ViewGroup)layoutInflater.inflate(R.layout.abc_dialog_title_material, null);
                    this.mOverlayActionBar = false;
                    this.mHasActionBar = false;
                } else if (this.mHasActionBar) {
                    object = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)object, true);
                    object = object.resourceId != 0 ? new ContextThemeWrapper(this.mContext, object.resourceId) : this.mContext;
                    object = (ViewGroup)LayoutInflater.from((Context)object).inflate(R.layout.abc_screen_toolbar, null);
                    this.mDecorContentParent = (DecorContentParent)object.findViewById(R.id.decor_content_parent);
                    this.mDecorContentParent.setWindowCallback(this.getWindowCallback());
                    if (this.mOverlayActionBar) {
                        this.mDecorContentParent.initFeature(109);
                    }
                    if (this.mFeatureProgress) {
                        this.mDecorContentParent.initFeature(2);
                    }
                    if (this.mFeatureIndeterminateProgress) {
                        this.mDecorContentParent.initFeature(5);
                    }
                }
            } else {
                object = this.mOverlayActionMode ? (ViewGroup)layoutInflater.inflate(R.layout.abc_screen_simple_overlay_action_mode, null) : (ViewGroup)layoutInflater.inflate(R.layout.abc_screen_simple, null);
            }
            if (object != null) {
                ViewCompat.setOnApplyWindowInsetsListener((View)object, new OnApplyWindowInsetsListener(this){
                    final AppCompatDelegateImpl this$0;
                    {
                        this.this$0 = appCompatDelegateImpl;
                    }

                    @Override
                    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                        int n = windowInsetsCompat.getSystemWindowInsetTop();
                        int n2 = this.this$0.updateStatusGuard(windowInsetsCompat, null);
                        WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
                        if (n != n2) {
                            windowInsetsCompat2 = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), n2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                        }
                        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat2);
                    }
                });
                if (this.mDecorContentParent == null) {
                    this.mTitleView = (TextView)object.findViewById(R.id.title);
                }
                ViewUtils.makeOptionalFitsSystemWindows((View)object);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout)object.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup)this.mWindow.findViewById(0x1020002);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        layoutInflater = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView((View)layoutInflater);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(0x1020002);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout)viewGroup).setForeground(null);
                    }
                }
                this.mWindow.setContentView((View)object);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener(this){
                    final AppCompatDelegateImpl this$0;
                    {
                        this.this$0 = appCompatDelegateImpl;
                    }

                    @Override
                    public void onAttachedFromWindow() {
                    }

                    @Override
                    public void onDetachedFromWindow() {
                        this.this$0.dismissPopups();
                    }
                });
                return object;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
        }
        object.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void ensureSubDecor() {
        if (!this.mSubDecorInstalled) {
            this.mSubDecor = this.createSubDecor();
            Object object = this.getTitle();
            if (!TextUtils.isEmpty((CharSequence)object)) {
                if (this.mDecorContentParent != null) {
                    this.mDecorContentParent.setWindowTitle((CharSequence)object);
                } else if (this.peekSupportActionBar() != null) {
                    this.peekSupportActionBar().setWindowTitle((CharSequence)object);
                } else if (this.mTitleView != null) {
                    this.mTitleView.setText((CharSequence)object);
                }
            }
            this.applyFixedSizeWindow();
            this.onSubDecorInstalled(this.mSubDecor);
            this.mSubDecorInstalled = true;
            object = this.getPanelState(0, false);
            if (!(this.mDestroyed || object != null && ((PanelFeatureState)object).menu != null)) {
                this.invalidatePanelMenu(108);
            }
        }
    }

    private void ensureWindow() {
        if (this.mWindow == null && this.mHost instanceof Activity) {
            this.attachToWindow(((Activity)this.mHost).getWindow());
        }
        if (this.mWindow != null) {
            return;
        }
        throw new IllegalStateException("We have not been given a Window");
    }

    private static Configuration generateConfigDelta(Configuration configuration2, Configuration configuration3) {
        Configuration configuration4 = new Configuration();
        configuration4.fontScale = 0.0f;
        if (configuration3 != null && configuration2.diff(configuration3) != 0) {
            if (configuration2.fontScale != configuration3.fontScale) {
                configuration4.fontScale = configuration3.fontScale;
            }
            if (configuration2.mcc != configuration3.mcc) {
                configuration4.mcc = configuration3.mcc;
            }
            if (configuration2.mnc != configuration3.mnc) {
                configuration4.mnc = configuration3.mnc;
            }
            Api24Impl.generateConfigDelta_locale(configuration2, configuration3, configuration4);
            if (configuration2.touchscreen != configuration3.touchscreen) {
                configuration4.touchscreen = configuration3.touchscreen;
            }
            if (configuration2.keyboard != configuration3.keyboard) {
                configuration4.keyboard = configuration3.keyboard;
            }
            if (configuration2.keyboardHidden != configuration3.keyboardHidden) {
                configuration4.keyboardHidden = configuration3.keyboardHidden;
            }
            if (configuration2.navigation != configuration3.navigation) {
                configuration4.navigation = configuration3.navigation;
            }
            if (configuration2.navigationHidden != configuration3.navigationHidden) {
                configuration4.navigationHidden = configuration3.navigationHidden;
            }
            if (configuration2.orientation != configuration3.orientation) {
                configuration4.orientation = configuration3.orientation;
            }
            if ((configuration2.screenLayout & 0xF) != (configuration3.screenLayout & 0xF)) {
                configuration4.screenLayout |= configuration3.screenLayout & 0xF;
            }
            if ((configuration2.screenLayout & 0xC0) != (configuration3.screenLayout & 0xC0)) {
                configuration4.screenLayout |= configuration3.screenLayout & 0xC0;
            }
            if ((configuration2.screenLayout & 0x30) != (configuration3.screenLayout & 0x30)) {
                configuration4.screenLayout |= configuration3.screenLayout & 0x30;
            }
            if ((configuration2.screenLayout & 0x300) != (configuration3.screenLayout & 0x300)) {
                configuration4.screenLayout |= configuration3.screenLayout & 0x300;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Api26Impl.generateConfigDelta_colorMode(configuration2, configuration3, configuration4);
            }
            if ((configuration2.uiMode & 0xF) != (configuration3.uiMode & 0xF)) {
                configuration4.uiMode |= configuration3.uiMode & 0xF;
            }
            if ((configuration2.uiMode & 0x30) != (configuration3.uiMode & 0x30)) {
                configuration4.uiMode |= configuration3.uiMode & 0x30;
            }
            if (configuration2.screenWidthDp != configuration3.screenWidthDp) {
                configuration4.screenWidthDp = configuration3.screenWidthDp;
            }
            if (configuration2.screenHeightDp != configuration3.screenHeightDp) {
                configuration4.screenHeightDp = configuration3.screenHeightDp;
            }
            if (configuration2.smallestScreenWidthDp != configuration3.smallestScreenWidthDp) {
                configuration4.smallestScreenWidthDp = configuration3.smallestScreenWidthDp;
            }
            Api17Impl.generateConfigDelta_densityDpi(configuration2, configuration3, configuration4);
            return configuration4;
        }
        return configuration4;
    }

    private int getActivityHandlesConfigChangesFlags(Context context) {
        block6: {
            if (!this.mActivityHandlesConfigFlagsChecked && this.mHost instanceof Activity) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return 0;
                }
                int n = Build.VERSION.SDK_INT >= 29 ? 0x100C0000 : 786432;
                ComponentName componentName = new ComponentName(context, this.mHost.getClass());
                context = packageManager.getActivityInfo(componentName, n);
                if (context == null) break block6;
                try {
                    this.mActivityHandlesConfigFlags = context.configChanges;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    Log.d((String)"AppCompatDelegate", (String)"Exception while getting ActivityInfo", (Throwable)nameNotFoundException);
                    this.mActivityHandlesConfigFlags = 0;
                }
            }
        }
        this.mActivityHandlesConfigFlagsChecked = true;
        return this.mActivityHandlesConfigFlags;
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(Context context) {
        if (this.mAutoBatteryNightModeManager == null) {
            this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, context);
        }
        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance(context));
        }
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        this.ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            if (this.mHost instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity)this.mHost, this.mOverlayActionBar);
            } else if (this.mHost instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog)this.mHost);
            }
            if (this.mActionBar != null) {
                this.mActionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
            return;
        }
    }

    private boolean initializePanelContent(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.createdPanelView;
        boolean bl = true;
        if (view != null) {
            panelFeatureState.shownPanelView = panelFeatureState.createdPanelView;
            return true;
        }
        if (panelFeatureState.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
        }
        panelFeatureState.shownPanelView = (View)panelFeatureState.getListMenuView(this.mPanelMenuPresenterCallback);
        if (panelFeatureState.shownPanelView == null) {
            bl = false;
        }
        return bl;
    }

    private boolean initializePanelDecor(PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(this.getActionBarThemedContext());
        panelFeatureState.decorView = new ListMenuDecorView(this, panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState panelFeatureState) {
        Object object;
        block10: {
            Context context;
            block9: {
                context = this.mContext;
                if (panelFeatureState.featureId == 0) break block9;
                object = context;
                if (panelFeatureState.featureId != 108) break block10;
            }
            object = context;
            if (this.mDecorContentParent != null) {
                TypedValue typedValue = new TypedValue();
                Resources.Theme theme = context.getTheme();
                theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                object = null;
                if (typedValue.resourceId != 0) {
                    object = context.getResources().newTheme();
                    object.setTo(theme);
                    object.applyStyle(typedValue.resourceId, true);
                    object.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                } else {
                    theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                }
                Object object2 = object;
                if (typedValue.resourceId != 0) {
                    object2 = object;
                    if (object == null) {
                        object2 = context.getResources().newTheme();
                        object2.setTo(theme);
                    }
                    object2.applyStyle(typedValue.resourceId, true);
                }
                object = context;
                if (object2 != null) {
                    object = new ContextThemeWrapper(context, 0);
                    object.getTheme().setTo((Resources.Theme)object2);
                }
            }
        }
        object = new MenuBuilder((Context)object);
        object.setCallback(this);
        panelFeatureState.setMenu((MenuBuilder)object);
        return true;
    }

    private void invalidatePanelMenu(int n) {
        this.mInvalidatePanelMenuFeatures |= 1 << n;
        if (!this.mInvalidatePanelMenuPosted) {
            ViewCompat.postOnAnimation(this.mWindow.getDecorView(), this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    private boolean onKeyDownPanel(int n, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            PanelFeatureState panelFeatureState = this.getPanelState(n, true);
            if (!panelFeatureState.isOpen) {
                return this.preparePanel(panelFeatureState, keyEvent);
            }
        }
        return false;
    }

    private boolean onKeyUpPanel(int n, KeyEvent keyEvent) {
        boolean bl;
        if (this.mActionMode != null) {
            return false;
        }
        boolean bl2 = false;
        PanelFeatureState panelFeatureState = this.getPanelState(n, true);
        if (n == 0 && this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && !ViewConfiguration.get((Context)this.mContext).hasPermanentMenuKey()) {
            if (!this.mDecorContentParent.isOverflowMenuShowing()) {
                bl = bl2;
                if (!this.mDestroyed) {
                    bl = bl2;
                    if (this.preparePanel(panelFeatureState, keyEvent)) {
                        bl = this.mDecorContentParent.showOverflowMenu();
                    }
                }
            } else {
                bl = this.mDecorContentParent.hideOverflowMenu();
            }
        } else if (!panelFeatureState.isOpen && !panelFeatureState.isHandled) {
            bl = bl2;
            if (panelFeatureState.isPrepared) {
                boolean bl3 = true;
                if (panelFeatureState.refreshMenuContent) {
                    panelFeatureState.isPrepared = false;
                    bl3 = this.preparePanel(panelFeatureState, keyEvent);
                }
                bl = bl2;
                if (bl3) {
                    this.openPanel(panelFeatureState, keyEvent);
                    bl = true;
                }
            }
        } else {
            bl = panelFeatureState.isOpen;
            this.closePanel(panelFeatureState, true);
        }
        if (bl) {
            keyEvent = (AudioManager)this.mContext.getApplicationContext().getSystemService("audio");
            if (keyEvent != null) {
                keyEvent.playSoundEffect(0);
            } else {
                Log.w((String)"AppCompatDelegate", (String)"Couldn't get audio manager");
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        block25: {
            WindowManager windowManager;
            int n;
            block24: {
                int n2;
                block23: {
                    Window.Callback callback2;
                    block22: {
                        if (panelFeatureState.isOpen) return;
                        if (this.mDestroyed) {
                            return;
                        }
                        if (panelFeatureState.featureId == 0) {
                            if ((this.mContext.getResources().getConfiguration().screenLayout & 0xF) == 4) {
                                return;
                            }
                            n = 0;
                            if (n != 0) {
                                return;
                            }
                        }
                        if ((callback2 = this.getWindowCallback()) != null && !callback2.onMenuOpened(panelFeatureState.featureId, (Menu)panelFeatureState.menu)) {
                            this.closePanel(panelFeatureState, true);
                            return;
                        }
                        windowManager = (WindowManager)this.mContext.getSystemService("window");
                        if (windowManager == null) {
                            return;
                        }
                        if (!this.preparePanel(panelFeatureState, keyEvent)) {
                            return;
                        }
                        n2 = -2;
                        if (panelFeatureState.decorView == null || panelFeatureState.refreshDecorView) break block22;
                        if (panelFeatureState.createdPanelView == null) break block23;
                        keyEvent = panelFeatureState.createdPanelView.getLayoutParams();
                        n = n2;
                        if (keyEvent != null) {
                            n = n2;
                            if (keyEvent.width == -1) {
                                n = -1;
                            }
                        }
                        break block24;
                    }
                    if (panelFeatureState.decorView == null) {
                        if (!this.initializePanelDecor(panelFeatureState)) return;
                        if (panelFeatureState.decorView == null) {
                            return;
                        }
                    } else if (panelFeatureState.refreshDecorView && panelFeatureState.decorView.getChildCount() > 0) {
                        panelFeatureState.decorView.removeAllViews();
                    }
                    if (!this.initializePanelContent(panelFeatureState) || !panelFeatureState.hasPanelItems()) break block25;
                    callback2 = panelFeatureState.shownPanelView.getLayoutParams();
                    keyEvent = callback2;
                    if (callback2 == null) {
                        keyEvent = new ViewGroup.LayoutParams(-2, -2);
                    }
                    n = panelFeatureState.background;
                    panelFeatureState.decorView.setBackgroundResource(n);
                    callback2 = panelFeatureState.shownPanelView.getParent();
                    if (callback2 instanceof ViewGroup) {
                        ((ViewGroup)callback2).removeView(panelFeatureState.shownPanelView);
                    }
                    panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, (ViewGroup.LayoutParams)keyEvent);
                    if (!panelFeatureState.shownPanelView.hasFocus()) {
                        panelFeatureState.shownPanelView.requestFocus();
                    }
                }
                n = n2;
            }
            panelFeatureState.isHandled = false;
            keyEvent = new WindowManager.LayoutParams(n, -2, panelFeatureState.x, panelFeatureState.y, 1002, 0x820000, -3);
            keyEvent.gravity = panelFeatureState.gravity;
            keyEvent.windowAnimations = panelFeatureState.windowAnimations;
            windowManager.addView((View)panelFeatureState.decorView, (ViewGroup.LayoutParams)keyEvent);
            panelFeatureState.isOpen = true;
            if (panelFeatureState.featureId != 0) return;
            this.updateBackInvokedCallbackState();
            return;
        }
        panelFeatureState.refreshDecorView = true;
    }

    private boolean performPanelShortcut(PanelFeatureState panelFeatureState, int n, KeyEvent keyEvent, int n2) {
        boolean bl;
        block7: {
            boolean bl2;
            block6: {
                if (keyEvent.isSystem()) {
                    return false;
                }
                bl2 = false;
                if (panelFeatureState.isPrepared) break block6;
                bl = bl2;
                if (!this.preparePanel(panelFeatureState, keyEvent)) break block7;
            }
            bl = bl2;
            if (panelFeatureState.menu != null) {
                bl = panelFeatureState.menu.performShortcut(n, keyEvent, n2);
            }
        }
        if (bl && (n2 & 1) == 0 && this.mDecorContentParent == null) {
            this.closePanel(panelFeatureState, true);
        }
        return bl;
    }

    private boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        Window.Callback callback2;
        if (this.mDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        if (this.mPreparedPanel != null && this.mPreparedPanel != panelFeatureState) {
            this.closePanel(this.mPreparedPanel, false);
        }
        if ((callback2 = this.getWindowCallback()) != null) {
            panelFeatureState.createdPanelView = callback2.onCreatePanelView(panelFeatureState.featureId);
        }
        int n = panelFeatureState.featureId != 0 && panelFeatureState.featureId != 108 ? 0 : 1;
        if (n != 0 && this.mDecorContentParent != null) {
            this.mDecorContentParent.setMenuPrepared();
        }
        if (!(panelFeatureState.createdPanelView != null || n != 0 && this.peekSupportActionBar() instanceof ToolbarActionBar)) {
            if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                if (!(panelFeatureState.menu != null || this.initializePanelMenu(panelFeatureState) && panelFeatureState.menu != null)) {
                    return false;
                }
                if (n != 0 && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
                    }
                    this.mDecorContentParent.setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!callback2.onCreatePanelMenu(panelFeatureState.featureId, (Menu)panelFeatureState.menu)) {
                    panelFeatureState.setMenu(null);
                    if (n != 0 && this.mDecorContentParent != null) {
                        this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            if (panelFeatureState.frozenActionViewState != null) {
                panelFeatureState.menu.restoreActionViewStates(panelFeatureState.frozenActionViewState);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!callback2.onPreparePanel(0, panelFeatureState.createdPanelView, (Menu)panelFeatureState.menu)) {
                if (n != 0 && this.mDecorContentParent != null) {
                    this.mDecorContentParent.setMenu(null, this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            n = keyEvent != null ? keyEvent.getDeviceId() : -1;
            boolean bl = KeyCharacterMap.load((int)n).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = bl;
            panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    private void reopenMenu(boolean bl) {
        if (this.mDecorContentParent != null && this.mDecorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get((Context)this.mContext).hasPermanentMenuKey() || this.mDecorContentParent.isOverflowMenuShowPending())) {
            Window.Callback callback2 = this.getWindowCallback();
            if (this.mDecorContentParent.isOverflowMenuShowing() && bl) {
                this.mDecorContentParent.hideOverflowMenu();
                if (!this.mDestroyed) {
                    callback2.onPanelClosed(108, (Menu)this.getPanelState((int)0, (boolean)true).menu);
                }
            } else if (callback2 != null && !this.mDestroyed) {
                if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                    this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                    this.mInvalidatePanelMenuRunnable.run();
                }
                PanelFeatureState panelFeatureState = this.getPanelState(0, true);
                if (panelFeatureState.menu != null && !panelFeatureState.refreshMenuContent && callback2.onPreparePanel(0, panelFeatureState.createdPanelView, (Menu)panelFeatureState.menu)) {
                    callback2.onMenuOpened(108, (Menu)panelFeatureState.menu);
                    this.mDecorContentParent.showOverflowMenu();
                }
            }
            return;
        }
        PanelFeatureState panelFeatureState = this.getPanelState(0, true);
        panelFeatureState.refreshDecorView = true;
        this.closePanel(panelFeatureState, false);
        this.openPanel(panelFeatureState, null);
    }

    private int sanitizeWindowFeatureId(int n) {
        if (n == 8) {
            Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (n == 9) {
            Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
        return n;
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View view = this.mWindow.getDecorView();
        while (true) {
            if (viewParent == null) {
                return true;
            }
            if (viewParent == view || !(viewParent instanceof View) || ViewCompat.isAttachedToWindow((View)viewParent)) break;
            viewParent = viewParent.getParent();
        }
        return false;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (!this.mSubDecorInstalled) {
            return;
        }
        throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private AppCompatActivity tryUnwrapContext() {
        Context context = this.mContext;
        while (context != null) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity)context;
            }
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper)context).getBaseContext();
                continue;
            }
            return null;
        }
        return null;
    }

    private boolean updateAppConfiguration(int n, LocaleListCompat localeListCompat, boolean bl) {
        boolean bl2;
        int n2;
        int n3;
        Object object;
        int n4;
        block14: {
            boolean bl3;
            block15: {
                bl3 = false;
                Configuration configuration2 = this.createOverrideAppConfiguration(this.mContext, n, localeListCompat, null, false);
                n4 = this.getActivityHandlesConfigChangesFlags(this.mContext);
                object = this.mEffectiveConfiguration == null ? this.mContext.getResources().getConfiguration() : this.mEffectiveConfiguration;
                n3 = object.uiMode;
                n2 = configuration2.uiMode & 0x30;
                LocaleListCompat localeListCompat2 = this.getConfigurationLocales((Configuration)object);
                object = localeListCompat == null ? null : this.getConfigurationLocales(configuration2);
                int n5 = 0;
                if ((n3 & 0x30) != n2) {
                    n5 = 0 | 0x200;
                }
                n3 = n5;
                if (object != null) {
                    n3 = n5;
                    if (!localeListCompat2.equals(object)) {
                        n3 = n5 | 4 | 0x2000;
                    }
                }
                bl2 = bl3;
                if ((~n4 & n3) == 0) break block14;
                bl2 = bl3;
                if (!bl) break block14;
                bl2 = bl3;
                if (!this.mBaseContextAttached) break block14;
                if (sCanReturnDifferentContext) break block15;
                bl2 = bl3;
                if (!this.mCreated) break block14;
            }
            bl2 = bl3;
            if (this.mHost instanceof Activity) {
                bl2 = bl3;
                if (!((Activity)this.mHost).isChild()) {
                    ActivityCompat.recreate((Activity)this.mHost);
                    bl2 = true;
                }
            }
        }
        bl = bl2;
        if (!bl2) {
            bl = bl2;
            if (n3 != 0) {
                bl = (n3 & n4) == n3;
                this.updateResourcesConfiguration(n2, (LocaleListCompat)object, bl, null);
                bl = true;
            }
        }
        if (bl && this.mHost instanceof AppCompatActivity) {
            if ((n3 & 0x200) != 0) {
                ((AppCompatActivity)this.mHost).onNightModeChanged(n);
            }
            if ((n3 & 4) != 0) {
                ((AppCompatActivity)this.mHost).onLocalesChanged(localeListCompat);
            }
        }
        if (bl && object != null) {
            this.setDefaultLocalesForLocaleList(this.getConfigurationLocales(this.mContext.getResources().getConfiguration()));
        }
        return bl;
    }

    private void updateResourcesConfiguration(int n, LocaleListCompat localeListCompat, boolean bl, Configuration configuration2) {
        Resources resources = this.mContext.getResources();
        Configuration configuration3 = new Configuration(resources.getConfiguration());
        if (configuration2 != null) {
            configuration3.updateFrom(configuration2);
        }
        configuration3.uiMode = resources.getConfiguration().uiMode & 0xFFFFFFCF | n;
        if (localeListCompat != null) {
            this.setConfigurationLocales(configuration3, localeListCompat);
        }
        resources.updateConfiguration(configuration3, null);
        if (Build.VERSION.SDK_INT < 26) {
            ResourcesFlusher.flush(resources);
        }
        if (this.mThemeResId != 0) {
            this.mContext.setTheme(this.mThemeResId);
            this.mContext.getTheme().applyStyle(this.mThemeResId, true);
        }
        if (bl && this.mHost instanceof Activity) {
            this.VavralmConfiguration(configuration3);
        }
    }

    private void updateStatusGuardColor(View view) {
        int n = (ViewCompat.getWindowSystemUiVisibility(view) & 0x2000) != 0 ? 1 : 0;
        n = n != 0 ? ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard_light) : ContextCompat.getColor(this.mContext, R.color.abc_decor_view_status_guard);
        view.setBackgroundColor(n);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.ensureSubDecor();
        ((ViewGroup)this.mSubDecor.findViewById(0x1020002)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override
    boolean applyAppLocales() {
        if (AppCompatDelegateImpl.isAutoStorageOptedIn(this.mContext) && AppCompatDelegateImpl.getRequestedAppLocales() != null && !AppCompatDelegateImpl.getRequestedAppLocales().equals(AppCompatDelegateImpl.getStoredAppLocales())) {
            this.asyncExecuteSyncRequestedAndStoredLocales(this.mContext);
        }
        return this.applyApplicationSpecificConfig(true);
    }

    @Override
    public boolean applyDayNight() {
        return this.applyApplicationSpecificConfig(true);
    }

    @Override
    public Context attachBaseContext2(Context context) {
        boolean bl = true;
        this.mBaseContextAttached = true;
        int n = this.mapNightMode(context, this.calculateNightMode());
        if (AppCompatDelegateImpl.isAutoStorageOptedIn(context)) {
            AppCompatDelegateImpl.syncRequestedAndStoredLocales(context);
        }
        LocaleListCompat localeListCompat = this.calculateApplicationLocales(context);
        if (sCanApplyOverrideConfiguration && context instanceof android.view.ContextThemeWrapper) {
            Configuration configuration2 = this.createOverrideAppConfiguration(context, n, localeListCompat, null, false);
            try {
                ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper)context, configuration2);
                return context;
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
        }
        if (context instanceof ContextThemeWrapper) {
            Configuration configuration3 = this.createOverrideAppConfiguration(context, n, localeListCompat, null, false);
            try {
                ((ContextThemeWrapper)context).applyOverrideConfiguration(configuration3);
                return context;
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
        }
        if (!sCanReturnDifferentContext) {
            return super.attachBaseContext2(context);
        }
        Object object = new Configuration();
        ((Configuration)object).uiMode = -1;
        ((Configuration)object).fontScale = 0.0f;
        Configuration configuration4 = Api17Impl.createConfigurationContext(context, (Configuration)object).getResources().getConfiguration();
        object = context.getResources().getConfiguration();
        configuration4.uiMode = ((Configuration)object).uiMode;
        object = !configuration4.equals((Configuration)object) ? AppCompatDelegateImpl.generateConfigDelta(configuration4, (Configuration)object) : null;
        localeListCompat = this.createOverrideAppConfiguration(context, n, localeListCompat, (Configuration)object, true);
        object = new ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
        ((ContextThemeWrapper)((Object)object)).applyOverrideConfiguration((Configuration)localeListCompat);
        try {
            context = context.getTheme();
            if (context == null) {
                bl = false;
            }
        }
        catch (NullPointerException nullPointerException) {
            bl = false;
        }
        if (bl) {
            ResourcesCompat.ThemeCompat.rebase(((ContextThemeWrapper)((Object)object)).getTheme());
        }
        return super.attachBaseContext2((Context)object);
    }

    LocaleListCompat calculateApplicationLocales(Context object) {
        if (Build.VERSION.SDK_INT >= 33) {
            return null;
        }
        LocaleListCompat localeListCompat = AppCompatDelegateImpl.getRequestedAppLocales();
        if (localeListCompat == null) {
            return null;
        }
        LocaleListCompat localeListCompat2 = this.getConfigurationLocales(object.getApplicationContext().getResources().getConfiguration());
        localeListCompat = LocaleOverlayHelper.combineLocalesIfOverlayExists(localeListCompat, localeListCompat2);
        object = localeListCompat;
        if (localeListCompat.isEmpty()) {
            object = localeListCompat2;
        }
        return object;
    }

    void callOnPanelClosed(int n, PanelFeatureState panelFeatureState, Menu menu) {
        PanelFeatureState panelFeatureState2 = panelFeatureState;
        Menu menu2 = menu;
        if (menu == null) {
            PanelFeatureState panelFeatureState3 = panelFeatureState;
            if (panelFeatureState == null) {
                panelFeatureState3 = panelFeatureState;
                if (n >= 0) {
                    panelFeatureState3 = panelFeatureState;
                    if (n < this.mPanels.length) {
                        panelFeatureState3 = this.mPanels[n];
                    }
                }
            }
            panelFeatureState2 = panelFeatureState3;
            menu2 = menu;
            if (panelFeatureState3 != null) {
                menu2 = panelFeatureState3.menu;
                panelFeatureState2 = panelFeatureState3;
            }
        }
        if (panelFeatureState2 != null && !panelFeatureState2.isOpen) {
            return;
        }
        if (!this.mDestroyed) {
            this.mAppCompatWindowCallback.bypassOnPanelClosed(this.mWindow.getCallback(), n, menu2);
        }
    }

    void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback callback2 = this.getWindowCallback();
        if (callback2 != null && !this.mDestroyed) {
            callback2.onPanelClosed(108, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    void closePanel(int n) {
        this.closePanel(this.getPanelState(n, true), true);
    }

    void closePanel(PanelFeatureState panelFeatureState, boolean bl) {
        if (bl && panelFeatureState.featureId == 0 && this.mDecorContentParent != null && this.mDecorContentParent.isOverflowMenuShowing()) {
            this.checkCloseActionMenu(panelFeatureState.menu);
            return;
        }
        WindowManager windowManager = (WindowManager)this.mContext.getSystemService("window");
        if (windowManager != null && panelFeatureState.isOpen && panelFeatureState.decorView != null) {
            windowManager.removeView((View)panelFeatureState.decorView);
            if (bl) {
                this.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
        if (panelFeatureState.featureId == 0) {
            this.updateBackInvokedCallbackState();
        }
    }

    @Override
    public View createView(View view, String string2, Context context, AttributeSet attributeSet) {
        AppCompatViewInflater appCompatViewInflater = this.mAppCompatViewInflater;
        boolean bl = false;
        if (appCompatViewInflater == null) {
            String string3 = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string3 == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater)this.mContext.getClassLoader().loadClass(string3).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                }
                catch (Throwable throwable) {
                    Log.i((String)"AppCompatDelegate", (String)("Failed to instantiate custom view inflater " + string3 + ". Falling back to default."), (Throwable)throwable);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        boolean bl2 = false;
        if (IS_PRE_LOLLIPOP) {
            if (this.mLayoutIncludeDetector == null) {
                this.mLayoutIncludeDetector = new LayoutIncludeDetector();
            }
            if (this.mLayoutIncludeDetector.detect(attributeSet)) {
                bl2 = true;
            } else if (attributeSet instanceof XmlPullParser) {
                bl2 = bl;
                if (((XmlPullParser)attributeSet).getDepth() > 1) {
                    bl2 = true;
                }
            } else {
                bl2 = this.shouldInheritContext((ViewParent)view);
            }
        }
        return this.mAppCompatViewInflater.createView(view, string2, context, attributeSet, bl2, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
    }

    void dismissPopups() {
        if (this.mDecorContentParent != null) {
            this.mDecorContentParent.dismissPopups();
        }
        if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if (this.mActionModePopup.isShowing()) {
                try {
                    this.mActionModePopup.dismiss();
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    // empty catch block
                }
            }
            this.mActionModePopup = null;
        }
        this.endOnGoingFadeAnimation();
        PanelFeatureState panelFeatureState = this.getPanelState(0, false);
        if (panelFeatureState != null && panelFeatureState.menu != null) {
            panelFeatureState.menu.close();
        }
    }

    boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View view;
        boolean bl = this.mHost instanceof KeyEventDispatcher.Component;
        boolean bl2 = true;
        if ((bl || this.mHost instanceof AppCompatDialog) && (view = this.mWindow.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy(view, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.bypassDispatchKeyEvent(this.mWindow.getCallback(), keyEvent)) {
            return true;
        }
        int n = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            bl2 = false;
        }
        bl = bl2 ? this.onKeyDown(n, keyEvent) : this.onKeyUp(n, keyEvent);
        return bl;
    }

    void doInvalidatePanelMenu(int n) {
        PanelFeatureState panelFeatureState = this.getPanelState(n, true);
        if (panelFeatureState.menu != null) {
            Bundle bundle = new Bundle();
            panelFeatureState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelFeatureState.frozenActionViewState = bundle;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            panelFeatureState.menu.clear();
        }
        panelFeatureState.refreshMenuContent = true;
        panelFeatureState.refreshDecorView = true;
        if ((n == 108 || n == 0) && this.mDecorContentParent != null && (panelFeatureState = this.getPanelState(0, false)) != null) {
            panelFeatureState.isPrepared = false;
            this.preparePanel(panelFeatureState, null);
        }
    }

    void endOnGoingFadeAnimation() {
        if (this.mFadeAnim != null) {
            this.mFadeAnim.cancel();
        }
    }

    PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panelFeatureStateArray = this.mPanels;
        int n = panelFeatureStateArray != null ? panelFeatureStateArray.length : 0;
        for (int i = 0; i < n; ++i) {
            PanelFeatureState panelFeatureState = panelFeatureStateArray[i];
            if (panelFeatureState == null || panelFeatureState.menu != menu) continue;
            return panelFeatureState;
        }
        return null;
    }

    @Override
    public <T extends View> T findViewById(int n) {
        this.ensureSubDecor();
        return (T)this.mWindow.findViewById(n);
    }

    final Context getActionBarThemedContext() {
        Context context = null;
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        }
        actionBar = context;
        if (context == null) {
            actionBar = this.mContext;
        }
        return actionBar;
    }

    final AutoNightModeManager getAutoTimeNightModeManager() {
        return this.getAutoTimeNightModeManager(this.mContext);
    }

    LocaleListCompat getConfigurationLocales(Configuration configuration2) {
        return Api24Impl.getLocales(configuration2);
    }

    @Override
    public Context getContextForDelegate() {
        return this.mContext;
    }

    @Override
    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }

    @Override
    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    @Override
    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater == null) {
            this.initWindowDecorActionBar();
            Context context = this.mActionBar != null ? this.mActionBar.getThemedContext() : this.mContext;
            this.mMenuInflater = new SupportMenuInflater(context);
        }
        return this.mMenuInflater;
    }

    protected PanelFeatureState getPanelState(int n, boolean bl) {
        Object object;
        PanelFeatureState[] panelFeatureStateArray;
        PanelFeatureState[] panelFeatureStateArray2;
        block6: {
            block5: {
                panelFeatureStateArray = panelFeatureStateArray2 = this.mPanels;
                if (panelFeatureStateArray2 == null) break block5;
                panelFeatureStateArray2 = panelFeatureStateArray;
                if (panelFeatureStateArray.length > n) break block6;
            }
            object = new PanelFeatureState[n + 1];
            if (panelFeatureStateArray != null) {
                System.arraycopy(panelFeatureStateArray, 0, object, 0, panelFeatureStateArray.length);
            }
            panelFeatureStateArray2 = object;
            this.mPanels = object;
        }
        object = panelFeatureStateArray2[n];
        panelFeatureStateArray = object;
        if (object == null) {
            object = new PanelFeatureState(n);
            panelFeatureStateArray = object;
            panelFeatureStateArray2[n] = object;
        }
        return panelFeatureStateArray;
    }

    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    @Override
    public ActionBar getSupportActionBar() {
        this.initWindowDecorActionBar();
        return this.mActionBar;
    }

    final CharSequence getTitle() {
        if (this.mHost instanceof Activity) {
            return ((Activity)this.mHost).getTitle();
        }
        return this.mTitle;
    }

    final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    @Override
    public boolean hasWindowFeature(int n) {
        boolean bl = false;
        switch (this.sanitizeWindowFeatureId(n)) {
            default: {
                break;
            }
            case 109: {
                bl = this.mOverlayActionBar;
                break;
            }
            case 108: {
                bl = this.mHasActionBar;
                break;
            }
            case 10: {
                bl = this.mOverlayActionMode;
                break;
            }
            case 5: {
                bl = this.mFeatureIndeterminateProgress;
                break;
            }
            case 2: {
                bl = this.mFeatureProgress;
                break;
            }
            case 1: {
                bl = this.mWindowNoTitle;
            }
        }
        bl = bl || this.mWindow.hasFeature(n);
        return bl;
    }

    @Override
    public void installViewFactory() {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.mContext);
        if (layoutInflater.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(layoutInflater, this);
        } else if (!(layoutInflater.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i((String)"AppCompatDelegate", (String)"The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override
    public void invalidateOptionsMenu() {
        if (this.peekSupportActionBar() != null && !this.getSupportActionBar().invalidateOptionsMenu()) {
            this.invalidatePanelMenu(0);
            return;
        }
    }

    @Override
    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    int mapNightMode(Context context, int n) {
        switch (n) {
            default: {
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
            case 3: {
                return this.getAutoBatteryNightModeManager(context).getApplyableNightMode();
            }
            case 0: {
                if (((UiModeManager)context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return this.getAutoTimeNightModeManager(context).getApplyableNightMode();
            }
            case -1: 
            case 1: 
            case 2: {
                return n;
            }
            case -100: 
        }
        return -1;
    }

    boolean onBackPressed() {
        boolean bl = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        Object object = this.getPanelState(0, false);
        if (object != null && ((PanelFeatureState)object).isOpen) {
            if (!bl) {
                this.closePanel((PanelFeatureState)object, true);
            }
            return true;
        }
        if (this.mActionMode != null) {
            this.mActionMode.finish();
            return true;
        }
        object = this.getSupportActionBar();
        return object != null && ((ActionBar)object).collapseActionView();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration2) {
        ActionBar actionBar;
        if (this.mHasActionBar && this.mSubDecorInstalled && (actionBar = this.getSupportActionBar()) != null) {
            actionBar.onConfigurationChanged(configuration2);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.applyApplicationSpecificConfig(false, false);
    }

    @Override
    public void onCreate(Bundle object) {
        this.mBaseContextAttached = true;
        this.applyApplicationSpecificConfig(false);
        this.ensureWindow();
        if (this.mHost instanceof Activity) {
            object = null;
            try {
                String string2 = NavUtils.getParentActivityName((Activity)this.mHost);
                object = string2;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
            if (object != null) {
                object = this.peekSupportActionBar();
                if (object == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    ((ActionBar)object).setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegateImpl.addActiveDelegate(this);
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    public final View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.createView(view, string2, context, attributeSet);
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string2, context, attributeSet);
    }

    @Override
    public void onDestroy() {
        if (this.mHost instanceof Activity) {
            AppCompatDelegateImpl.removeActivityDelegate(this);
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mDestroyed = true;
        if (this.mLocalNightMode != -100 && this.mHost instanceof Activity && ((Activity)this.mHost).isChangingConfigurations()) {
            sLocalNightModes.put(this.mHost.getClass().getName(), this.mLocalNightMode);
        } else {
            sLocalNightModes.remove(this.mHost.getClass().getName());
        }
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
        this.cleanupAutoManagers();
    }

    boolean onKeyDown(int n, KeyEvent keyEvent) {
        boolean bl = true;
        switch (n) {
            default: {
                break;
            }
            case 82: {
                this.onKeyDownPanel(0, keyEvent);
                return true;
            }
            case 4: {
                if ((keyEvent.getFlags() & 0x80) == 0) {
                    bl = false;
                }
                this.mLongPressBackDown = bl;
            }
        }
        return false;
    }

    boolean onKeyShortcut(int n, KeyEvent keyEvent) {
        Object object = this.getSupportActionBar();
        if (object != null && ((ActionBar)object).onKeyShortcut(n, keyEvent)) {
            return true;
        }
        if (this.mPreparedPanel != null && this.performPanelShortcut(this.mPreparedPanel, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.mPreparedPanel != null) {
                this.mPreparedPanel.isHandled = true;
            }
            return true;
        }
        if (this.mPreparedPanel == null) {
            object = this.getPanelState(0, true);
            this.preparePanel((PanelFeatureState)object, keyEvent);
            boolean bl = this.performPanelShortcut((PanelFeatureState)object, keyEvent.getKeyCode(), keyEvent, 1);
            ((PanelFeatureState)object).isPrepared = false;
            if (bl) {
                return true;
            }
        }
        return false;
    }

    boolean onKeyUp(int n, KeyEvent keyEvent) {
        switch (n) {
            default: {
                break;
            }
            case 82: {
                this.onKeyUpPanel(0, keyEvent);
                return true;
            }
            case 4: {
                if (!this.onBackPressed()) break;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        Window.Callback callback2 = this.getWindowCallback();
        if (callback2 != null && !this.mDestroyed && (object = this.findMenuPanel(((MenuBuilder)object).getRootMenu())) != null) {
            return callback2.onMenuItemSelected(((PanelFeatureState)object).featureId, menuItem);
        }
        return false;
    }

    @Override
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        this.reopenMenu(true);
    }

    void onMenuOpened(int n) {
        ActionBar actionBar;
        if (n == 108 && (actionBar = this.getSupportActionBar()) != null) {
            actionBar.dispatchMenuVisibilityChanged(true);
        }
    }

    void onPanelClosed(int n) {
        block2: {
            block1: {
                if (n != 108) break block1;
                ActionBar actionBar = this.getSupportActionBar();
                if (actionBar == null) break block2;
                actionBar.dispatchMenuVisibilityChanged(false);
                break block2;
            }
            if (n != 0) break block2;
            PanelFeatureState panelFeatureState = this.getPanelState(n, true);
            if (panelFeatureState.isOpen) {
                this.closePanel(panelFeatureState, false);
            }
        }
    }

    @Override
    public void onPostCreate(Bundle bundle) {
        this.ensureSubDecor();
    }

    @Override
    public void onPostResume() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override
    public void onStart() {
        this.applyApplicationSpecificConfig(true, false);
    }

    @Override
    public void onStop() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    void onSubDecorInstalled(ViewGroup viewGroup) {
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    @Override
    public boolean requestWindowFeature(int n) {
        n = this.sanitizeWindowFeatureId(n);
        if (this.mWindowNoTitle && n == 108) {
            return false;
        }
        if (this.mHasActionBar && n == 1) {
            this.mHasActionBar = false;
        }
        switch (n) {
            default: {
                return this.mWindow.requestFeature(n);
            }
            case 109: {
                this.throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionBar = true;
                return true;
            }
            case 108: {
                this.throwFeatureRequestIfSubDecorInstalled();
                this.mHasActionBar = true;
                return true;
            }
            case 10: {
                this.throwFeatureRequestIfSubDecorInstalled();
                this.mOverlayActionMode = true;
                return true;
            }
            case 5: {
                this.throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = true;
                return true;
            }
            case 2: {
                this.throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureProgress = true;
                return true;
            }
            case 1: 
        }
        this.throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = true;
        return true;
    }

    void setConfigurationLocales(Configuration configuration2, LocaleListCompat localeListCompat) {
        Api24Impl.setLocales(configuration2, localeListCompat);
    }

    @Override
    public void setContentView(int n) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        LayoutInflater.from((Context)this.mContext).inflate(n, viewGroup);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override
    public void setContentView(View view) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    void setDefaultLocalesForLocaleList(LocaleListCompat localeListCompat) {
        Api24Impl.setDefaultLocales(localeListCompat);
    }

    @Override
    public void setHandleNativeActionModesEnabled(boolean bl) {
        this.mHandleNativeActionModes = bl;
    }

    @Override
    public void setLocalNightMode(int n) {
        if (this.mLocalNightMode != n) {
            this.mLocalNightMode = n;
            if (this.mBaseContextAttached) {
                this.applyDayNight();
            }
        }
    }

    @Override
    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        super.setOnBackInvokedDispatcher(onBackInvokedDispatcher);
        if (this.mDispatcher != null && this.mBackCallback != null) {
            Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, this.mBackCallback);
            this.mBackCallback = null;
        }
        this.mDispatcher = onBackInvokedDispatcher == null && this.mHost instanceof Activity && ((Activity)this.mHost).getWindow() != null ? Api33Impl.getOnBackInvokedDispatcher((Activity)this.mHost) : onBackInvokedDispatcher;
        this.updateBackInvokedCallbackState();
    }

    @Override
    public void setSupportActionBar(Toolbar toolbar) {
        if (!(this.mHost instanceof Activity)) {
            return;
        }
        ActionBar actionBar = this.getSupportActionBar();
        if (!(actionBar instanceof WindowDecorActionBar)) {
            this.mMenuInflater = null;
            if (actionBar != null) {
                actionBar.onDestroy();
            }
            this.mActionBar = null;
            if (toolbar != null) {
                this.mActionBar = actionBar = new ToolbarActionBar(toolbar, this.getTitle(), this.mAppCompatWindowCallback);
                this.mAppCompatWindowCallback.setActionBarCallback(((ToolbarActionBar)actionBar).mMenuCallback);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.mAppCompatWindowCallback.setActionBarCallback(null);
            }
            this.invalidateOptionsMenu();
            return;
        }
        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
    }

    @Override
    public void setTheme(int n) {
        this.mThemeResId = n;
    }

    @Override
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        if (this.mDecorContentParent != null) {
            this.mDecorContentParent.setWindowTitle(charSequence);
        } else if (this.peekSupportActionBar() != null) {
            this.peekSupportActionBar().setWindowTitle(charSequence);
        } else if (this.mTitleView != null) {
            this.mTitleView.setText(charSequence);
        }
    }

    final boolean shouldAnimateActionModeView() {
        boolean bl = this.mSubDecorInstalled && this.mSubDecor != null && ViewCompat.isLaidOut((View)this.mSubDecor);
        return bl;
    }

    boolean shouldRegisterBackInvokedCallback() {
        if (this.mDispatcher == null) {
            return false;
        }
        PanelFeatureState panelFeatureState = this.getPanelState(0, false);
        if (panelFeatureState != null && panelFeatureState.isOpen) {
            return true;
        }
        return this.mActionMode != null;
    }

    @Override
    public ActionMode startSupportActionMode(ActionMode.Callback callback2) {
        if (callback2 != null) {
            if (this.mActionMode != null) {
                this.mActionMode.finish();
            }
            callback2 = new ActionModeCallbackWrapperV9(this, callback2);
            ActionBar actionBar = this.getSupportActionBar();
            if (actionBar != null) {
                this.mActionMode = actionBar.startActionMode(callback2);
                if (this.mActionMode != null && this.mAppCompatCallback != null) {
                    this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
                }
            }
            if (this.mActionMode == null) {
                this.mActionMode = this.startSupportActionModeFromWindow(callback2);
            }
            this.updateBackInvokedCallbackState();
            return this.mActionMode;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    ActionMode startSupportActionModeFromWindow(ActionMode.Callback object) {
        this.endOnGoingFadeAnimation();
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        ActionMode.Callback callback2 = object;
        if (!(object instanceof ActionModeCallbackWrapperV9)) {
            callback2 = new ActionModeCallbackWrapperV9(this, (ActionMode.Callback)object);
        }
        TypedValue typedValue = null;
        object = typedValue;
        if (this.mAppCompatCallback != null) {
            object = typedValue;
            if (!this.mDestroyed) {
                try {
                    object = this.mAppCompatCallback.onWindowStartingSupportActionMode(callback2);
                }
                catch (AbstractMethodError abstractMethodError) {
                    object = typedValue;
                }
            }
        }
        if (object != null) {
            this.mActionMode = object;
        } else {
            object = this.mActionModeView;
            boolean bl = true;
            if (object == null) {
                if (this.mIsFloating) {
                    typedValue = new TypedValue();
                    object = this.mContext.getTheme();
                    object.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme theme = this.mContext.getResources().newTheme();
                        theme.setTo((Resources.Theme)object);
                        theme.applyStyle(typedValue.resourceId, true);
                        object = new ContextThemeWrapper(this.mContext, 0);
                        object.getTheme().setTo(theme);
                    } else {
                        object = this.mContext;
                    }
                    this.mActionModeView = new ActionBarContextView((Context)object);
                    this.mActionModePopup = new PopupWindow((Context)object, null, R.attr.actionModePopupWindowStyle);
                    PopupWindowCompat.setWindowLayoutType(this.mActionModePopup, 2);
                    this.mActionModePopup.setContentView((View)this.mActionModeView);
                    this.mActionModePopup.setWidth(-1);
                    object.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    int n = TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)object.getResources().getDisplayMetrics());
                    this.mActionModeView.setContentHeight(n);
                    this.mActionModePopup.setHeight(-2);
                    this.mShowActionModePopup = new Runnable(this){
                        final AppCompatDelegateImpl this$0;
                        {
                            this.this$0 = appCompatDelegateImpl;
                        }

                        @Override
                        public void run() {
                            this.this$0.mActionModePopup.showAtLocation((View)this.this$0.mActionModeView, 55, 0, 0);
                            this.this$0.endOnGoingFadeAnimation();
                            if (this.this$0.shouldAnimateActionModeView()) {
                                this.this$0.mActionModeView.setAlpha(0.0f);
                                this.this$0.mFadeAnim = ViewCompat.animate((View)this.this$0.mActionModeView).alpha(1.0f);
                                this.this$0.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter(this){
                                    final 6 this$1;
                                    {
                                        this.this$1 = var1_1;
                                    }

                                    @Override
                                    public void onAnimationEnd(View view) {
                                        this.this$1.this$0.mActionModeView.setAlpha(1.0f);
                                        this.this$1.this$0.mFadeAnim.setListener(null);
                                        this.this$1.this$0.mFadeAnim = null;
                                    }

                                    @Override
                                    public void onAnimationStart(View view) {
                                        this.this$1.this$0.mActionModeView.setVisibility(0);
                                    }
                                });
                            } else {
                                this.this$0.mActionModeView.setAlpha(1.0f);
                                this.this$0.mActionModeView.setVisibility(0);
                            }
                        }
                    };
                } else {
                    object = (ViewStubCompat)this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
                    if (object != null) {
                        ((ViewStubCompat)((Object)object)).setLayoutInflater(LayoutInflater.from((Context)this.getActionBarThemedContext()));
                        this.mActionModeView = (ActionBarContextView)((ViewStubCompat)((Object)object)).inflate();
                    }
                }
            }
            if (this.mActionModeView != null) {
                this.endOnGoingFadeAnimation();
                this.mActionModeView.killMode();
                typedValue = this.mActionModeView.getContext();
                object = this.mActionModeView;
                if (this.mActionModePopup != null) {
                    bl = false;
                }
                object = new StandaloneActionMode((Context)typedValue, (ActionBarContextView)((Object)object), callback2, bl);
                if (callback2.onCreateActionMode((ActionMode)object, ((ActionMode)object).getMenu())) {
                    ((ActionMode)object).invalidate();
                    this.mActionModeView.initForMode((ActionMode)object);
                    this.mActionMode = object;
                    if (this.shouldAnimateActionModeView()) {
                        this.mActionModeView.setAlpha(0.0f);
                        this.mFadeAnim = ViewCompat.animate((View)this.mActionModeView).alpha(1.0f);
                        this.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter(this){
                            final AppCompatDelegateImpl this$0;
                            {
                                this.this$0 = appCompatDelegateImpl;
                            }

                            @Override
                            public void onAnimationEnd(View view) {
                                this.this$0.mActionModeView.setAlpha(1.0f);
                                this.this$0.mFadeAnim.setListener(null);
                                this.this$0.mFadeAnim = null;
                            }

                            @Override
                            public void onAnimationStart(View view) {
                                this.this$0.mActionModeView.setVisibility(0);
                                if (this.this$0.mActionModeView.getParent() instanceof View) {
                                    ViewCompat.requestApplyInsets((View)this.this$0.mActionModeView.getParent());
                                }
                            }
                        });
                    } else {
                        this.mActionModeView.setAlpha(1.0f);
                        this.mActionModeView.setVisibility(0);
                        if (this.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View)this.mActionModeView.getParent());
                        }
                    }
                    if (this.mActionModePopup != null) {
                        this.mWindow.getDecorView().post(this.mShowActionModePopup);
                    }
                } else {
                    this.mActionMode = null;
                }
            }
        }
        if (this.mActionMode != null && this.mAppCompatCallback != null) {
            this.mAppCompatCallback.onSupportActionModeStarted(this.mActionMode);
        }
        this.updateBackInvokedCallbackState();
        return this.mActionMode;
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT >= 33) {
            boolean bl = this.shouldRegisterBackInvokedCallback();
            if (bl && this.mBackCallback == null) {
                this.mBackCallback = Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
            } else if (!bl && this.mBackCallback != null) {
                Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, this.mBackCallback);
            }
        }
    }

    final int updateStatusGuard(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int n;
        int n2 = 0;
        if (windowInsetsCompat != null) {
            n2 = windowInsetsCompat.getSystemWindowInsetTop();
        } else if (rect != null) {
            n2 = rect.top;
        }
        int n3 = 0;
        int n4 = 0;
        if (this.mActionModeView != null && this.mActionModeView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
            n = 0;
            int n5 = 0;
            if (this.mActionModeView.isShown()) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect2 = this.mTempRect1;
                Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows((View)this.mSubDecor, rect2, rect3);
                n3 = rect2.top;
                int n6 = rect2.left;
                int n7 = rect2.right;
                windowInsetsCompat = ViewCompat.getRootWindowInsets((View)this.mSubDecor);
                n4 = windowInsetsCompat == null ? 0 : windowInsetsCompat.getSystemWindowInsetLeft();
                n = windowInsetsCompat == null ? 0 : windowInsetsCompat.getSystemWindowInsetRight();
                if (marginLayoutParams.topMargin != n3 || marginLayoutParams.leftMargin != n6 || marginLayoutParams.rightMargin != n7) {
                    marginLayoutParams.topMargin = n3;
                    marginLayoutParams.leftMargin = n6;
                    marginLayoutParams.rightMargin = n7;
                    n5 = 1;
                }
                if (n3 > 0 && this.mStatusGuard == null) {
                    this.mStatusGuard = new View(this.mContext);
                    this.mStatusGuard.setVisibility(8);
                    windowInsetsCompat = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    ((FrameLayout.LayoutParams)windowInsetsCompat).leftMargin = n4;
                    ((FrameLayout.LayoutParams)windowInsetsCompat).rightMargin = n;
                    this.mSubDecor.addView(this.mStatusGuard, -1, (ViewGroup.LayoutParams)windowInsetsCompat);
                } else if (this.mStatusGuard != null) {
                    windowInsetsCompat = (ViewGroup.MarginLayoutParams)this.mStatusGuard.getLayoutParams();
                    if (((ViewGroup.MarginLayoutParams)windowInsetsCompat).height != marginLayoutParams.topMargin || ((ViewGroup.MarginLayoutParams)windowInsetsCompat).leftMargin != n4 || ((ViewGroup.MarginLayoutParams)windowInsetsCompat).rightMargin != n) {
                        ((ViewGroup.MarginLayoutParams)windowInsetsCompat).height = marginLayoutParams.topMargin;
                        ((ViewGroup.MarginLayoutParams)windowInsetsCompat).leftMargin = n4;
                        ((ViewGroup.MarginLayoutParams)windowInsetsCompat).rightMargin = n;
                        this.mStatusGuard.setLayoutParams((ViewGroup.LayoutParams)windowInsetsCompat);
                    }
                }
                n4 = this.mStatusGuard != null ? 1 : 0;
                if (n4 != 0 && this.mStatusGuard.getVisibility() != 0) {
                    this.updateStatusGuardColor(this.mStatusGuard);
                }
                if (!this.mOverlayActionMode && n4 != 0) {
                    n2 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                n5 = 1;
                marginLayoutParams.topMargin = 0;
            } else {
                n5 = n;
            }
            n = n2;
            n3 = n4;
            if (n5 != 0) {
                this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
                n = n2;
                n3 = n4;
            }
        } else {
            n = n2;
        }
        if (this.mStatusGuard != null) {
            windowInsetsCompat = this.mStatusGuard;
            n2 = n3 != 0 ? 0 : 8;
            windowInsetsCompat.setVisibility(n2);
        }
        return n;
    }

    private class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate {
        final AppCompatDelegateImpl this$0;

        ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
            this.this$0 = appCompatDelegateImpl;
        }

        @Override
        public Context getActionBarThemedContext() {
            return this.this$0.getActionBarThemedContext();
        }

        @Override
        public Drawable getThemeUpIndicator() {
            TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.getActionBarThemedContext(), null, new int[]{R.attr.homeAsUpIndicator});
            Drawable drawable2 = tintTypedArray.getDrawable(0);
            tintTypedArray.recycle();
            return drawable2;
        }

        @Override
        public boolean isNavigationVisible() {
            ActionBar actionBar = this.this$0.getSupportActionBar();
            boolean bl = actionBar != null && (actionBar.getDisplayOptions() & 4) != 0;
            return bl;
        }

        @Override
        public void setActionBarDescription(int n) {
            ActionBar actionBar = this.this$0.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(n);
            }
        }

        @Override
        public void setActionBarUpIndicator(Drawable drawable2, int n) {
            ActionBar actionBar = this.this$0.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable2);
                actionBar.setHomeActionContentDescription(n);
            }
        }
    }

    static interface ActionBarMenuCallback {
        public View onCreatePanelView(int var1);

        public boolean onPreparePanel(int var1);
    }

    private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback {
        final AppCompatDelegateImpl this$0;

        ActionMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
            this.this$0 = appCompatDelegateImpl;
        }

        @Override
        public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
            this.this$0.checkCloseActionMenu(menuBuilder);
        }

        @Override
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback2 = this.this$0.getWindowCallback();
            if (callback2 != null) {
                callback2.onMenuOpened(108, (Menu)menuBuilder);
            }
            return true;
        }
    }

    class ActionModeCallbackWrapperV9
    implements ActionMode.Callback {
        private ActionMode.Callback mWrapped;
        final AppCompatDelegateImpl this$0;

        public ActionModeCallbackWrapperV9(AppCompatDelegateImpl appCompatDelegateImpl, ActionMode.Callback callback2) {
            this.this$0 = appCompatDelegateImpl;
            this.mWrapped = callback2;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.mWrapped.onActionItemClicked(actionMode, menuItem);
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.mWrapped.onCreateActionMode(actionMode, menu);
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            this.mWrapped.onDestroyActionMode(actionMode);
            if (this.this$0.mActionModePopup != null) {
                this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
            }
            if (this.this$0.mActionModeView != null) {
                this.this$0.endOnGoingFadeAnimation();
                this.this$0.mFadeAnim = ViewCompat.animate((View)this.this$0.mActionModeView).alpha(0.0f);
                this.this$0.mFadeAnim.setListener(new ViewPropertyAnimatorListenerAdapter(this){
                    final ActionModeCallbackWrapperV9 this$1;
                    {
                        this.this$1 = actionModeCallbackWrapperV9;
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        this.this$1.this$0.mActionModeView.setVisibility(8);
                        if (this.this$1.this$0.mActionModePopup != null) {
                            this.this$1.this$0.mActionModePopup.dismiss();
                        } else if (this.this$1.this$0.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View)this.this$1.this$0.mActionModeView.getParent());
                        }
                        this.this$1.this$0.mActionModeView.killMode();
                        this.this$1.this$0.mFadeAnim.setListener(null);
                        this.this$1.this$0.mFadeAnim = null;
                        ViewCompat.requestApplyInsets((View)this.this$1.this$0.mSubDecor);
                    }
                });
            }
            if (this.this$0.mAppCompatCallback != null) {
                this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
            }
            this.this$0.mActionMode = null;
            ViewCompat.requestApplyInsets((View)this.this$0.mSubDecor);
            this.this$0.updateBackInvokedCallbackState();
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            ViewCompat.requestApplyInsets((View)this.this$0.mSubDecor);
            return this.mWrapped.onPrepareActionMode(actionMode, menu);
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context createConfigurationContext(Context context, Configuration configuration2) {
            return context.createConfigurationContext(configuration2);
        }

        static void generateConfigDelta_densityDpi(Configuration configuration2, Configuration configuration3, Configuration configuration4) {
            if (configuration2.densityDpi != configuration3.densityDpi) {
                configuration4.densityDpi = configuration3.densityDpi;
            }
        }

        static void setLayoutDirection(Configuration configuration2, Locale locale) {
            configuration2.setLayoutDirection(locale);
        }

        static void setLocale(Configuration configuration2, Locale locale) {
            configuration2.setLocale(locale);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean isPowerSaveMode(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void generateConfigDelta_locale(Configuration configuration2, Configuration configuration3, Configuration configuration4) {
            LocaleList localeList = configuration2.getLocales();
            if (!localeList.equals((Object)(configuration2 = configuration3.getLocales()))) {
                configuration4.setLocales((LocaleList)configuration2);
                configuration4.locale = configuration3.locale;
            }
        }

        static LocaleListCompat getLocales(Configuration configuration2) {
            return LocaleListCompat.forLanguageTags(configuration2.getLocales().toLanguageTags());
        }

        public static void setDefaultLocales(LocaleListCompat localeListCompat) {
            LocaleList.setDefault((LocaleList)LocaleList.forLanguageTags((String)localeListCompat.toLanguageTags()));
        }

        static void setLocales(Configuration configuration2, LocaleListCompat localeListCompat) {
            configuration2.setLocales(LocaleList.forLanguageTags((String)localeListCompat.toLanguageTags()));
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void generateConfigDelta_colorMode(Configuration configuration2, Configuration configuration3, Configuration configuration4) {
            if ((configuration2.colorMode & 3) != (configuration3.colorMode & 3)) {
                configuration4.colorMode |= configuration3.colorMode & 3;
            }
            if ((configuration2.colorMode & 0xC) != (configuration3.colorMode & 0xC)) {
                configuration4.colorMode |= configuration3.colorMode & 0xC;
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback registerOnBackPressedCallback(Object object, AppCompatDelegateImpl object2) {
            Objects.requireNonNull(object2);
            object2 = new AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0((AppCompatDelegateImpl)object2);
            ((OnBackInvokedDispatcher)object).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback)object2);
            return object2;
        }

        static void unregisterOnBackInvokedCallback(Object object, Object object2) {
            object2 = (OnBackInvokedCallback)object2;
            ((OnBackInvokedDispatcher)object).unregisterOnBackInvokedCallback((OnBackInvokedCallback)object2);
        }
    }

    class AppCompatWindowCallback
    extends WindowCallbackWrapper {
        private ActionBarMenuCallback mActionBarCallback;
        private boolean mDispatchKeyEventBypassEnabled;
        private boolean mOnContentChangedBypassEnabled;
        private boolean mOnPanelClosedBypassEnabled;
        final AppCompatDelegateImpl this$0;

        AppCompatWindowCallback(AppCompatDelegateImpl appCompatDelegateImpl, Window.Callback callback2) {
            this.this$0 = appCompatDelegateImpl;
            super(callback2);
        }

        public boolean bypassDispatchKeyEvent(Window.Callback callback2, KeyEvent keyEvent) {
            try {
                this.mDispatchKeyEventBypassEnabled = true;
                boolean bl = callback2.dispatchKeyEvent(keyEvent);
                return bl;
            }
            finally {
                this.mDispatchKeyEventBypassEnabled = false;
            }
        }

        public void bypassOnContentChanged(Window.Callback callback2) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                callback2.onContentChanged();
                return;
            }
            finally {
                this.mOnContentChangedBypassEnabled = false;
            }
        }

        public void bypassOnPanelClosed(Window.Callback callback2, int n, Menu menu) {
            try {
                this.mOnPanelClosedBypassEnabled = true;
                callback2.onPanelClosed(n, menu);
                return;
            }
            finally {
                this.mOnPanelClosedBypassEnabled = false;
            }
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.mDispatchKeyEventBypassEnabled) {
                return this.getWrapped().dispatchKeyEvent(keyEvent);
            }
            boolean bl = this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
            return bl;
        }

        @Override
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            boolean bl = super.dispatchKeyShortcutEvent(keyEvent) || this.this$0.onKeyShortcut(keyEvent.getKeyCode(), keyEvent);
            return bl;
        }

        @Override
        public void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled) {
                this.getWrapped().onContentChanged();
                return;
            }
        }

        @Override
        public boolean onCreatePanelMenu(int n, Menu menu) {
            if (n == 0 && !(menu instanceof MenuBuilder)) {
                return false;
            }
            return super.onCreatePanelMenu(n, menu);
        }

        @Override
        public View onCreatePanelView(int n) {
            View view;
            if (this.mActionBarCallback != null && (view = this.mActionBarCallback.onCreatePanelView(n)) != null) {
                return view;
            }
            return super.onCreatePanelView(n);
        }

        @Override
        public boolean onMenuOpened(int n, Menu menu) {
            super.onMenuOpened(n, menu);
            this.this$0.onMenuOpened(n);
            return true;
        }

        @Override
        public void onPanelClosed(int n, Menu menu) {
            if (this.mOnPanelClosedBypassEnabled) {
                this.getWrapped().onPanelClosed(n, menu);
                return;
            }
            super.onPanelClosed(n, menu);
            this.this$0.onPanelClosed(n);
        }

        @Override
        public boolean onPreparePanel(int n, View view, Menu menu) {
            boolean bl;
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder)menu : null;
            if (n == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(true);
            }
            boolean bl2 = bl = false;
            if (this.mActionBarCallback != null) {
                bl2 = bl;
                if (this.mActionBarCallback.onPreparePanel(n)) {
                    bl2 = true;
                }
            }
            bl = bl2;
            if (!bl2) {
                bl = super.onPreparePanel(n, view, menu);
            }
            if (menuBuilder != null) {
                menuBuilder.setOverrideVisibleItems(false);
            }
            return bl;
        }

        @Override
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int n) {
            PanelFeatureState panelFeatureState = this.this$0.getPanelState(0, true);
            if (panelFeatureState != null && panelFeatureState.menu != null) {
                super.onProvideKeyboardShortcuts(list, panelFeatureState.menu, n);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, n);
            }
        }

        @Override
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback2) {
            return null;
        }

        @Override
        public android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback2, int n) {
            if (this.this$0.isHandleNativeActionModesEnabled()) {
                switch (n) {
                    default: {
                        break;
                    }
                    case 0: {
                        return this.startAsSupportActionMode(callback2);
                    }
                }
            }
            return super.onWindowStartingActionMode(callback2, n);
        }

        void setActionBarCallback(ActionBarMenuCallback actionBarMenuCallback) {
            this.mActionBarCallback = actionBarMenuCallback;
        }

        final android.view.ActionMode startAsSupportActionMode(ActionMode.Callback object) {
            ActionMode actionMode = this.this$0.startSupportActionMode((ActionMode.Callback)(object = new SupportActionModeWrapper.CallbackWrapper(this.this$0.mContext, (ActionMode.Callback)object)));
            if (actionMode != null) {
                return ((SupportActionModeWrapper.CallbackWrapper)object).getActionModeWrapper(actionMode);
            }
            return null;
        }
    }

    private class AutoBatteryNightModeManager
    extends AutoNightModeManager {
        private final PowerManager mPowerManager;
        final AppCompatDelegateImpl this$0;

        AutoBatteryNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
            this.this$0 = appCompatDelegateImpl;
            super(appCompatDelegateImpl);
            this.mPowerManager = (PowerManager)context.getApplicationContext().getSystemService("power");
        }

        @Override
        IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override
        public int getApplyableNightMode() {
            int n = Api21Impl.isPowerSaveMode(this.mPowerManager) ? 2 : 1;
            return n;
        }

        @Override
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    abstract class AutoNightModeManager {
        private BroadcastReceiver mReceiver;
        final AppCompatDelegateImpl this$0;

        AutoNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl) {
            this.this$0 = appCompatDelegateImpl;
        }

        void cleanup() {
            if (this.mReceiver != null) {
                try {
                    this.this$0.mContext.unregisterReceiver(this.mReceiver);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    // empty catch block
                }
                this.mReceiver = null;
            }
        }

        abstract IntentFilter createIntentFilterForBroadcastReceiver();

        abstract int getApplyableNightMode();

        boolean isListening() {
            boolean bl = this.mReceiver != null;
            return bl;
        }

        abstract void onChange();

        void setup() {
            this.cleanup();
            IntentFilter intentFilter = this.createIntentFilterForBroadcastReceiver();
            if (intentFilter != null && intentFilter.countActions() != 0) {
                if (this.mReceiver == null) {
                    this.mReceiver = new BroadcastReceiver(this){
                        final AutoNightModeManager this$1;
                        {
                            this.this$1 = autoNightModeManager;
                        }

                        public void onReceive(Context context, Intent intent) {
                            this.this$1.onChange();
                        }
                    };
                }
                this.this$0.mContext.registerReceiver(this.mReceiver, intentFilter);
                return;
            }
        }
    }

    private class AutoTimeNightModeManager
    extends AutoNightModeManager {
        private final TwilightManager mTwilightManager;
        final AppCompatDelegateImpl this$0;

        AutoTimeNightModeManager(AppCompatDelegateImpl appCompatDelegateImpl, TwilightManager twilightManager) {
            this.this$0 = appCompatDelegateImpl;
            super(appCompatDelegateImpl);
            this.mTwilightManager = twilightManager;
        }

        @Override
        IntentFilter createIntentFilterForBroadcastReceiver() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override
        public int getApplyableNightMode() {
            int n = this.mTwilightManager.isNight() ? 2 : 1;
            return n;
        }

        @Override
        public void onChange() {
            this.this$0.applyDayNight();
        }
    }

    private static class ContextThemeWrapperCompatApi17Impl {
        private ContextThemeWrapperCompatApi17Impl() {
        }

        static void applyOverrideConfiguration(android.view.ContextThemeWrapper contextThemeWrapper, Configuration configuration2) {
            contextThemeWrapper.applyOverrideConfiguration(configuration2);
        }
    }

    private class ListMenuDecorView
    extends ContentFrameLayout {
        final AppCompatDelegateImpl this$0;

        public ListMenuDecorView(AppCompatDelegateImpl appCompatDelegateImpl, Context context) {
            this.this$0 = appCompatDelegateImpl;
            super(context);
        }

        private boolean isOutOfBounds(int n, int n2) {
            boolean bl = n < -5 || n2 < -5 || n > this.getWidth() + 5 || n2 > this.getHeight() + 5;
            return bl;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean bl = this.this$0.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
            return bl;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && this.isOutOfBounds((int)motionEvent.getX(), (int)motionEvent.getY())) {
                this.this$0.closePanel(0);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int n) {
            this.setBackgroundDrawable(AppCompatResources.getDrawable(this.getContext(), n));
        }
    }

    protected static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        int x;
        int y;

        PanelFeatureState(int n) {
            this.featureId = n;
            this.refreshDecorView = false;
        }

        void applyFrozenState() {
            if (this.menu != null && this.frozenMenuState != null) {
                this.menu.restorePresenterStates(this.frozenMenuState);
                this.frozenMenuState = null;
            }
        }

        public void clearMenuPresenters() {
            if (this.menu != null) {
                this.menu.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        MenuView getListMenuView(MenuPresenter.Callback callback2) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.setCallback(callback2);
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            return this.listMenuPresenter.getMenuView(this.decorView);
        }

        public boolean hasPanelItems() {
            View view = this.shownPanelView;
            boolean bl = false;
            if (view == null) {
                return false;
            }
            if (this.createdPanelView != null) {
                return true;
            }
            if (this.listMenuPresenter.getAdapter().getCount() > 0) {
                bl = true;
            }
            return bl;
        }

        void onRestoreInstanceState(Parcelable parcelable) {
            parcelable = (SavedState)parcelable;
            this.featureId = parcelable.featureId;
            this.wasLastOpen = parcelable.isOpen;
            this.frozenMenuState = parcelable.menuState;
            this.shownPanelView = null;
            this.decorView = null;
        }

        Parcelable onSaveInstanceState() {
            SavedState savedState = new SavedState();
            savedState.featureId = this.featureId;
            savedState.isOpen = this.isOpen;
            if (this.menu != null) {
                savedState.menuState = new Bundle();
                this.menu.savePresenterStates(savedState.menuState);
            }
            return savedState;
        }

        void setMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == this.menu) {
                return;
            }
            if (this.menu != null) {
                this.menu.removeMenuPresenter(this.listMenuPresenter);
            }
            this.menu = menuBuilder;
            if (menuBuilder != null && this.listMenuPresenter != null) {
                menuBuilder.addMenuPresenter(this.listMenuPresenter);
            }
        }

        void setStyle(Context object) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = object.getResources().newTheme();
            theme.setTo(object.getTheme());
            theme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, true);
            }
            theme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                theme.applyStyle(typedValue.resourceId, true);
            } else {
                theme.applyStyle(R.style.Theme_AppCompat_CompactMenu, true);
            }
            object = new ContextThemeWrapper((Context)object, 0);
            object.getTheme().setTo(theme);
            this.listPresenterContext = object;
            object = object.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.background = object.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = object.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            object.recycle();
        }

        private static class SavedState
        implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>(){

                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.readFromParcel(parcel, null);
                }

                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.readFromParcel(parcel, classLoader);
                }

                public SavedState[] newArray(int n) {
                    return new SavedState[n];
                }
            };
            int featureId;
            boolean isOpen;
            Bundle menuState;

            SavedState() {
            }

            static SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.featureId = parcel.readInt();
                int n = parcel.readInt();
                boolean bl = true;
                if (n != 1) {
                    bl = false;
                }
                savedState.isOpen = bl;
                if (savedState.isOpen) {
                    savedState.menuState = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int n) {
                parcel.writeInt(this.featureId);
                parcel.writeInt(this.isOpen ? 1 : 0);
                if (this.isOpen) {
                    parcel.writeBundle(this.menuState);
                }
            }
        }
    }

    private final class PanelMenuPresenterCallback
    implements MenuPresenter.Callback {
        final AppCompatDelegateImpl this$0;

        PanelMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
            this.this$0 = appCompatDelegateImpl;
        }

        @Override
        public void onCloseMenu(MenuBuilder object, boolean bl) {
            MenuBuilder menuBuilder = ((MenuBuilder)object).getRootMenu();
            boolean bl2 = menuBuilder != object;
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            if (bl2) {
                object = menuBuilder;
            }
            if ((object = appCompatDelegateImpl.findMenuPanel((Menu)object)) != null) {
                if (bl2) {
                    this.this$0.callOnPanelClosed(((PanelFeatureState)object).featureId, (PanelFeatureState)object, menuBuilder);
                    this.this$0.closePanel((PanelFeatureState)object, true);
                } else {
                    this.this$0.closePanel((PanelFeatureState)object, bl);
                }
            }
        }

        @Override
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback2;
            if (menuBuilder == menuBuilder.getRootMenu() && this.this$0.mHasActionBar && (callback2 = this.this$0.getWindowCallback()) != null && !this.this$0.mDestroyed) {
                callback2.onMenuOpened(108, (Menu)menuBuilder);
            }
            return true;
        }
    }
}

