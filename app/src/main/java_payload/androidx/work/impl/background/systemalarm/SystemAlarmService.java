/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.utils.WakeLocks;

public class SystemAlarmService
extends LifecycleService
implements SystemAlarmDispatcher.CommandsCompletedListener {
    private static final String TAG = Logger.tagWithPrefix("SystemAlarmService");
    private SystemAlarmDispatcher mDispatcher;
    private boolean mIsShutdown;

    private void initializeDispatcher() {
        this.mDispatcher = new SystemAlarmDispatcher((Context)this);
        this.mDispatcher.setCompletedListener(this);
    }

    @Override
    public void onAllCommandsCompleted() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed in dispatcher");
        WakeLocks.checkWakeLocks();
        this.stopSelf();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeDispatcher();
        this.mIsShutdown = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mIsShutdown = true;
        this.mDispatcher.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int n, int n2) {
        super.onStartCommand(intent, n, n2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            this.mDispatcher.onDestroy();
            this.initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent != null) {
            this.mDispatcher.add(intent, n2);
        }
        return 3;
    }
}

