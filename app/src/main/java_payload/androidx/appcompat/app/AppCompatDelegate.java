/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.LocaleManager
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.os.LocaleList
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.window.OnBackInvokedDispatcher
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0;
import androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppLocalesMetadataHolderService;
import androidx.appcompat.app.AppLocalesStorageHelper;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;

public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates;
    private static final Object sActivityDelegatesLock;
    private static final Object sAppLocalesStorageSyncLock;
    private static int sDefaultNightMode;
    private static Boolean sIsAutoStoreLocalesOptedIn;
    private static boolean sIsFrameworkSyncChecked;
    private static LocaleListCompat sRequestedAppLocales;
    static AppLocalesStorageHelper.SerialExecutor sSerialExecutorForLocalesStorage;
    private static LocaleListCompat sStoredAppLocales;

    static {
        sSerialExecutorForLocalesStorage = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());
        sDefaultNightMode = -100;
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
        sIsAutoStoreLocalesOptedIn = null;
        sIsFrameworkSyncChecked = false;
        sActivityDelegates = new ArraySet();
        sActivityDelegatesLock = new Object();
        sAppLocalesStorageSyncLock = new Object();
    }

    AppCompatDelegate() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void addActiveDelegate(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate);
            ArraySet<WeakReference<AppCompatDelegate>> arraySet = sActivityDelegates;
            WeakReference<AppCompatDelegate> weakReference = new WeakReference<AppCompatDelegate>(appCompatDelegate);
            arraySet.add(weakReference);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void applyDayNightToActiveDelegates() {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            Iterator<WeakReference<AppCompatDelegate>> iterator2 = sActivityDelegates.iterator();
            while (iterator2.hasNext()) {
                AppCompatDelegate appCompatDelegate = (AppCompatDelegate)iterator2.next().get();
                if (appCompatDelegate == null) continue;
                appCompatDelegate.applyDayNight();
            }
            return;
        }
    }

    private static void applyLocalesToActiveDelegates() {
        Iterator<WeakReference<AppCompatDelegate>> iterator2 = sActivityDelegates.iterator();
        while (iterator2.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate)iterator2.next().get();
            if (appCompatDelegate == null) continue;
            appCompatDelegate.applyAppLocales();
        }
    }

    public static AppCompatDelegate create(Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    public static AppCompatDelegate create(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, activity, appCompatCallback);
    }

    public static AppCompatDelegate create(Context context, Window window, AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, window, appCompatCallback);
    }

    public static LocaleListCompat getApplicationLocales() {
        if (BuildCompat.isAtLeastT()) {
            Object object = AppCompatDelegate.getLocaleManagerForApplication();
            if (object != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(object));
            }
        } else if (sRequestedAppLocales != null) {
            return sRequestedAppLocales;
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    static Object getLocaleManagerForApplication() {
        Iterator<WeakReference<AppCompatDelegate>> iterator2 = sActivityDelegates.iterator();
        while (iterator2.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate)iterator2.next().get();
            if (appCompatDelegate == null || (appCompatDelegate = appCompatDelegate.getContextForDelegate()) == null) continue;
            return appCompatDelegate.getSystemService("locale");
        }
        return null;
    }

    static LocaleListCompat getRequestedAppLocales() {
        return sRequestedAppLocales;
    }

    static LocaleListCompat getStoredAppLocales() {
        return sStoredAppLocales;
    }

    static boolean isAutoStorageOptedIn(Context context) {
        if (sIsAutoStoreLocalesOptedIn == null) {
            try {
                context = AppLocalesMetadataHolderService.getServiceInfo(context);
                if (context.metaData != null) {
                    sIsAutoStoreLocalesOptedIn = context.metaData.getBoolean("autoStoreLocales");
                }
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.d((String)TAG, (String)"Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                sIsAutoStoreLocalesOptedIn = false;
            }
        }
        return sIsAutoStoreLocalesOptedIn;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    static /* synthetic */ void lambda$asyncExecuteSyncRequestedAndStoredLocales$0(Context context) {
        AppCompatDelegate.syncRequestedAndStoredLocales(context);
    }

    static /* synthetic */ void lambda$syncRequestedAndStoredLocales$1(Context context) {
        AppLocalesStorageHelper.syncLocalesToFramework(context);
        sIsFrameworkSyncChecked = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void removeActivityDelegate(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            AppCompatDelegate.removeDelegateFromActives(appCompatDelegate);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void removeDelegateFromActives(AppCompatDelegate appCompatDelegate) {
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            Iterator<WeakReference<AppCompatDelegate>> iterator2 = sActivityDelegates.iterator();
            while (iterator2.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate)iterator2.next().get();
                if (appCompatDelegate2 != appCompatDelegate && appCompatDelegate2 != null) continue;
                iterator2.remove();
            }
            return;
        }
    }

    static void resetStaticRequestedAndStoredLocales() {
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setApplicationLocales(LocaleListCompat localeListCompat) {
        Objects.requireNonNull(localeListCompat);
        if (BuildCompat.isAtLeastT()) {
            Object object = AppCompatDelegate.getLocaleManagerForApplication();
            if (object == null) return;
            Api33Impl.localeManagerSetApplicationLocales(object, Api24Impl.localeListForLanguageTags(localeListCompat.toLanguageTags()));
            return;
        }
        if (localeListCompat.equals(sRequestedAppLocales)) return;
        Object object = sActivityDelegatesLock;
        synchronized (object) {
            sRequestedAppLocales = localeListCompat;
            AppCompatDelegate.applyLocalesToActiveDelegates();
            return;
        }
    }

    public static void setCompatVectorFromResourcesEnabled(boolean bl) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(bl);
    }

    public static void setDefaultNightMode(int n) {
        switch (n) {
            default: {
                Log.d((String)TAG, (String)"setDefaultNightMode() called with an unknown mode");
                break;
            }
            case -1: 
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                if (sDefaultNightMode == n) break;
                sDefaultNightMode = n;
                AppCompatDelegate.applyDayNightToActiveDelegates();
            }
        }
    }

    static void setIsAutoStoreLocalesOptedIn(boolean bl) {
        sIsAutoStoreLocalesOptedIn = bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void syncRequestedAndStoredLocales(Context context) {
        if (!AppCompatDelegate.isAutoStorageOptedIn(context)) {
            return;
        }
        if (BuildCompat.isAtLeastT()) {
            if (sIsFrameworkSyncChecked) return;
            sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda1(context));
            return;
        }
        Object object = sAppLocalesStorageSyncLock;
        synchronized (object) {
            if (sRequestedAppLocales == null) {
                if (sStoredAppLocales == null) {
                    sStoredAppLocales = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context));
                }
                if (sStoredAppLocales.isEmpty()) {
                    return;
                }
                sRequestedAppLocales = sStoredAppLocales;
            } else {
                if (sRequestedAppLocales.equals(sStoredAppLocales)) return;
                sStoredAppLocales = sRequestedAppLocales;
                AppLocalesStorageHelper.persistLocales(context, sRequestedAppLocales.toLanguageTags());
            }
            return;
        }
    }

    public abstract void addContentView(View var1, ViewGroup.LayoutParams var2);

    boolean applyAppLocales() {
        return false;
    }

    public abstract boolean applyDayNight();

    void asyncExecuteSyncRequestedAndStoredLocales(Context context) {
        sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda0(context));
    }

    @Deprecated
    public void attachBaseContext(Context context) {
    }

    public Context attachBaseContext2(Context context) {
        this.attachBaseContext(context);
        return context;
    }

    public abstract View createView(View var1, String var2, Context var3, AttributeSet var4);

    public abstract <T extends View> T findViewById(int var1);

    public Context getContextForDelegate() {
        return null;
    }

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int var1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration var1);

    public abstract void onCreate(Bundle var1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle var1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle var1);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int var1);

    public abstract void setContentView(int var1);

    public abstract void setContentView(View var1);

    public abstract void setContentView(View var1, ViewGroup.LayoutParams var2);

    public abstract void setHandleNativeActionModesEnabled(boolean var1);

    public abstract void setLocalNightMode(int var1);

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void setSupportActionBar(Toolbar var1);

    public void setTheme(int n) {
    }

    public abstract void setTitle(CharSequence var1);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback var1);

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList localeListForLanguageTags(String string2) {
            return LocaleList.forLanguageTags((String)string2);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static LocaleList localeManagerGetApplicationLocales(Object object) {
            return ((LocaleManager)object).getApplicationLocales();
        }

        static void localeManagerSetApplicationLocales(Object object, LocaleList localeList) {
            ((LocaleManager)object).setApplicationLocales(localeList);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface NightMode {
    }
}

