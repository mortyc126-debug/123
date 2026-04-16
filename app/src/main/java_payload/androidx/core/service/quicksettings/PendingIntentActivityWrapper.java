/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package androidx.core.service.quicksettings;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public class PendingIntentActivityWrapper {
    private final Context mContext;
    private final int mFlags;
    private final Intent mIntent;
    private final boolean mIsMutable;
    private final Bundle mOptions;
    private final PendingIntent mPendingIntent;
    private final int mRequestCode;

    public PendingIntentActivityWrapper(Context context, int n, Intent intent, int n2, Bundle bundle, boolean bl) {
        this.mContext = context;
        this.mRequestCode = n;
        this.mIntent = intent;
        this.mFlags = n2;
        this.mOptions = bundle;
        this.mIsMutable = bl;
        this.mPendingIntent = this.createPendingIntent();
    }

    public PendingIntentActivityWrapper(Context context, int n, Intent intent, int n2, boolean bl) {
        this(context, n, intent, n2, null, bl);
    }

    private PendingIntent createPendingIntent() {
        if (this.mOptions == null) {
            return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, this.mIsMutable);
        }
        return PendingIntentCompat.getActivity(this.mContext, this.mRequestCode, this.mIntent, this.mFlags, this.mOptions, this.mIsMutable);
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public Bundle getOptions() {
        return this.mOptions;
    }

    public PendingIntent getPendingIntent() {
        return this.mPendingIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean isMutable() {
        return this.mIsMutable;
    }
}

