/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import androidx.core.content.PackageManagerCompat;

class UnusedAppRestrictionsBackportServiceConnection
implements ServiceConnection {
    private final Context mContext;
    private boolean mHasBoundService = false;
    ResolvableFuture<Integer> mResultFuture;
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService = null;

    UnusedAppRestrictionsBackportServiceConnection(Context context) {
        this.mContext = context;
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new IUnusedAppRestrictionsBackportCallback.Stub(this){
            final UnusedAppRestrictionsBackportServiceConnection this$0;
            {
                this.this$0 = unusedAppRestrictionsBackportServiceConnection;
            }

            @Override
            public void onIsPermissionRevocationEnabledForAppResult(boolean bl, boolean bl2) throws RemoteException {
                if (bl) {
                    if (bl2) {
                        this.this$0.mResultFuture.set(3);
                    } else {
                        this.this$0.mResultFuture.set(2);
                    }
                } else {
                    this.this$0.mResultFuture.set(0);
                    Log.e((String)"PackageManagerCompat", (String)"Unable to retrieve the permission revocation setting from the backport");
                }
            }
        };
    }

    public void connectAndFetchResult(ResolvableFuture<Integer> intent) {
        if (!this.mHasBoundService) {
            this.mHasBoundService = true;
            this.mResultFuture = intent;
            intent = new Intent("android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService").setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager()));
            this.mContext.bindService(intent, (ServiceConnection)this, 1);
            return;
        }
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void disconnectFromService() {
        if (this.mHasBoundService) {
            this.mHasBoundService = false;
            this.mContext.unbindService((ServiceConnection)this);
            return;
        }
        throw new IllegalStateException("bindService must be called before unbind");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mUnusedAppRestrictionsService = IUnusedAppRestrictionsBackportService.Stub.asInterface(iBinder);
        try {
            this.mUnusedAppRestrictionsService.isPermissionRevocationEnabledForApp(this.getBackportCallback());
        }
        catch (RemoteException remoteException) {
            this.mResultFuture.set(0);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.mUnusedAppRestrictionsService = null;
    }
}

