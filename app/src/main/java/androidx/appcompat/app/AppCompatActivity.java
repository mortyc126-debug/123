/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatActivity
extends FragmentActivity
implements AppCompatCallback,
TaskStackBuilder.SupportParentable,
ActionBarDrawerToggle.DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        this.initDelegate();
    }

    public AppCompatActivity(int n) {
        super(n);
        this.initDelegate();
    }

    private void initDelegate() {
        this.getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new SavedStateRegistry.SavedStateProvider(this){
            final AppCompatActivity this$0;
            {
                this.this$0 = appCompatActivity;
            }

            @Override
            public Bundle saveState() {
                Bundle bundle = new Bundle();
                this.this$0.getDelegate().onSaveInstanceState(bundle);
                return bundle;
            }
        });
        this.addOnContextAvailableListener(new OnContextAvailableListener(this){
            final AppCompatActivity this$0;
            {
                this.this$0 = appCompatActivity;
            }

            @Override
            public void onContextAvailable(Context object) {
                object = this.this$0.getDelegate();
                ((AppCompatDelegate)object).installViewFactory();
                ((AppCompatDelegate)object).onCreate(this.this$0.getSavedStateRegistry().consumeRestoredStateForKey(AppCompatActivity.DELEGATE_TAG));
            }
        });
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(this.getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        return Build.VERSION.SDK_INT < 26 && !keyEvent.isCtrlPressed() && !KeyEvent.metaStateHasNoModifiers((int)keyEvent.getMetaState()) && keyEvent.getRepeatCount() == 0 && !KeyEvent.isModifierKey((int)keyEvent.getKeyCode()) && (window = this.getWindow()) != null && window.getDecorView() != null && window.getDecorView().dispatchKeyShortcutEvent(keyEvent);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().addContentView(view, layoutParams);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(this.getDelegate().attachBaseContext2(context));
    }

    public void closeOptionsMenu() {
        ActionBar actionBar = this.getSupportActionBar();
        if (this.getWindow().hasFeature(0) && (actionBar == null || !actionBar.closeOptionsMenu())) {
            super.closeOptionsMenu();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        ActionBar actionBar = this.getSupportActionBar();
        if (n == 82 && actionBar != null && actionBar.onMenuKeyEvent(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public <T extends View> T findViewById(int n) {
        return this.getDelegate().findViewById(n);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create(this, (AppCompatCallback)this);
        }
        return this.mDelegate;
    }

    @Override
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return this.getDelegate().getDrawerToggleDelegate();
    }

    public MenuInflater getMenuInflater() {
        return this.getDelegate().getMenuInflater();
    }

    public Resources getResources() {
        if (this.mResources == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources((Context)this, super.getResources());
        }
        Resources resources = this.mResources == null ? super.getResources() : this.mResources;
        return resources;
    }

    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }

    @Override
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration2) {
        super.onConfigurationChanged(configuration2);
        this.getDelegate().onConfigurationChanged(configuration2);
        if (this.mResources != null) {
            configuration2 = super.getResources().getConfiguration();
            DisplayMetrics displayMetrics = super.getResources().getDisplayMetrics();
            this.mResources.updateConfiguration(configuration2, displayMetrics);
        }
    }

    public void onContentChanged() {
        this.onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.getDelegate().onDestroy();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        if (this.performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }

    protected void onLocalesChanged(LocaleListCompat localeListCompat) {
    }

    @Override
    public final boolean onMenuItemSelected(int n, MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        ActionBar actionBar = this.getSupportActionBar();
        if (menuItem.getItemId() == 16908332 && actionBar != null && (actionBar.getDisplayOptions() & 4) != 0) {
            return this.onSupportNavigateUp();
        }
        return false;
    }

    public boolean onMenuOpened(int n, Menu menu) {
        return super.onMenuOpened(n, menu);
    }

    protected void onNightModeChanged(int n) {
    }

    @Override
    public void onPanelClosed(int n, Menu menu) {
        super.onPanelClosed(n, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.getDelegate().onPostCreate(bundle);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        this.getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.getDelegate().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }

    @Override
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Object object = this.getSupportParentActivityIntent();
        if (object != null) {
            if (this.supportShouldUpRecreateTask((Intent)object)) {
                object = TaskStackBuilder.create((Context)this);
                this.onCreateSupportNavigateUpTaskStack((TaskStackBuilder)object);
                this.onPrepareSupportNavigateUpTaskStack((TaskStackBuilder)object);
                ((TaskStackBuilder)object).startActivities();
                try {
                    ActivityCompat.finishAffinity(this);
                }
                catch (IllegalStateException illegalStateException) {
                    this.finish();
                }
            } else {
                this.supportNavigateUpTo((Intent)object);
            }
            return true;
        }
        return false;
    }

    protected void onTitleChanged(CharSequence charSequence, int n) {
        super.onTitleChanged(charSequence, n);
        this.getDelegate().setTitle(charSequence);
    }

    @Override
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback2) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar actionBar = this.getSupportActionBar();
        if (this.getWindow().hasFeature(0) && (actionBar == null || !actionBar.openOptionsMenu())) {
            super.openOptionsMenu();
        }
    }

    @Override
    public void setContentView(int n) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(n);
    }

    @Override
    public void setContentView(View view) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().setContentView(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        this.getDelegate().setSupportActionBar(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int n) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean bl) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean bl) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean bl) {
    }

    public void setTheme(int n) {
        super.setTheme(n);
        this.getDelegate().setTheme(n);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback2) {
        return this.getDelegate().startSupportActionMode(callback2);
    }

    @Override
    public void supportInvalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int n) {
        return this.getDelegate().requestWindowFeature(n);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }
}

