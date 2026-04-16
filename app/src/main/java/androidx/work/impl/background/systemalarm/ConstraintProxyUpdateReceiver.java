/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;

public class ConstraintProxyUpdateReceiver
extends BroadcastReceiver {
    static final String ACTION = "androidx.work.impl.background.systemalarm.UpdateProxies";
    static final String KEY_BATTERY_CHARGING_PROXY_ENABLED = "KEY_BATTERY_CHARGING_PROXY_ENABLED";
    static final String KEY_BATTERY_NOT_LOW_PROXY_ENABLED = "KEY_BATTERY_NOT_LOW_PROXY_ENABLED";
    static final String KEY_NETWORK_STATE_PROXY_ENABLED = "KEY_NETWORK_STATE_PROXY_ENABLED";
    static final String KEY_STORAGE_NOT_LOW_PROXY_ENABLED = "KEY_STORAGE_NOT_LOW_PROXY_ENABLED";
    static final String TAG = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra(KEY_BATTERY_NOT_LOW_PROXY_ENABLED, bl).putExtra(KEY_BATTERY_CHARGING_PROXY_ENABLED, bl2).putExtra(KEY_STORAGE_NOT_LOW_PROXY_ENABLED, bl3).putExtra(KEY_NETWORK_STATE_PROXY_ENABLED, bl4);
        return intent;
    }

    public void onReceive(Context context, Intent intent) {
        String string2 = intent != null ? intent.getAction() : null;
        if (!ACTION.equals(string2)) {
            Logger.get().debug(TAG, "Ignoring unknown action " + string2);
        } else {
            string2 = this.goAsync();
            WorkManagerImpl.getInstance(context).getWorkTaskExecutor().executeOnTaskThread(new Runnable(){
                final ConstraintProxyUpdateReceiver this$0;
                final Context val$context;
                final Intent val$intent;
                final BroadcastReceiver.PendingResult val$pendingResult;
                {
                    this.this$0 = constraintProxyUpdateReceiver;
                    this.val$intent = intent;
                    this.val$context = context;
                    this.val$pendingResult = pendingResult;
                }

                @Override
                public void run() {
                    try {
                        boolean bl = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_BATTERY_NOT_LOW_PROXY_ENABLED, false);
                        boolean bl2 = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_BATTERY_CHARGING_PROXY_ENABLED, false);
                        boolean bl3 = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_STORAGE_NOT_LOW_PROXY_ENABLED, false);
                        boolean bl4 = this.val$intent.getBooleanExtra(ConstraintProxyUpdateReceiver.KEY_NETWORK_STATE_PROXY_ENABLED, false);
                        CharSequence charSequence = new StringBuilder();
                        charSequence = charSequence.append("Updating proxies: (BatteryNotLowProxy (").append(bl).append("), BatteryChargingProxy (").append(bl2).append("), StorageNotLowProxy (").append(bl3).append("), NetworkStateProxy (").append(bl4).append("), ").toString();
                        Logger.get().debug(TAG, (String)charSequence);
                        PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy.BatteryNotLowProxy.class, bl);
                        PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy.BatteryChargingProxy.class, bl2);
                        PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy.StorageNotLowProxy.class, bl3);
                        PackageManagerHelper.setComponentEnabled(this.val$context, ConstraintProxy.NetworkStateProxy.class, bl4);
                        return;
                    }
                    finally {
                        this.val$pendingResult.finish();
                    }
                }
            });
        }
    }
}

