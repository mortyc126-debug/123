/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

public class ContextThemeWrapper
extends ContextWrapper {
    private static Configuration sEmptyConfig;
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int n) {
        super(context);
        this.mThemeResource = n;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    private Resources getResourcesInternal() {
        if (this.mResources == null) {
            this.mResources = !(this.mOverrideConfiguration == null || Build.VERSION.SDK_INT >= 26 && ContextThemeWrapper.isEmptyConfiguration(this.mOverrideConfiguration)) ? Api17Impl.createConfigurationContext(this, this.mOverrideConfiguration).getResources() : super.getResources();
        }
        return this.mResources;
    }

    private void initializeTheme() {
        boolean bl = this.mTheme == null;
        if (bl) {
            this.mTheme = this.getResources().newTheme();
            Resources.Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.onApplyThemeResource(this.mTheme, this.mThemeResource, bl);
    }

    private static boolean isEmptyConfiguration(Configuration configuration2) {
        if (configuration2 == null) {
            return true;
        }
        if (sEmptyConfig == null) {
            Configuration configuration3 = new Configuration();
            configuration3.fontScale = 0.0f;
            sEmptyConfig = configuration3;
        }
        return configuration2.equals(sEmptyConfig);
    }

    public void applyOverrideConfiguration(Configuration configuration2) {
        if (this.mResources == null) {
            if (this.mOverrideConfiguration == null) {
                this.mOverrideConfiguration = new Configuration(configuration2);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    public Resources getResources() {
        return this.getResourcesInternal();
    }

    public Object getSystemService(String string2) {
        if ("layout_inflater".equals(string2)) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from((Context)this.getBaseContext()).cloneInContext((Context)this);
            }
            return this.mInflater;
        }
        return this.getBaseContext().getSystemService(string2);
    }

    public Resources.Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.mThemeResource == 0) {
            this.mThemeResource = R.style.Theme_AppCompat_Light;
        }
        this.initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    protected void onApplyThemeResource(Resources.Theme theme, int n, boolean bl) {
        theme.applyStyle(n, true);
    }

    public void setTheme(int n) {
        if (this.mThemeResource != n) {
            this.mThemeResource = n;
            this.initializeTheme();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static Context createConfigurationContext(ContextThemeWrapper contextThemeWrapper, Configuration configuration2) {
            return contextThemeWrapper.createConfigurationContext(configuration2);
        }
    }
}

