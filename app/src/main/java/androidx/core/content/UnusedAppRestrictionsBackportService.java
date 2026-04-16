/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.RemoteException
 */
package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import androidx.core.content.UnusedAppRestrictionsBackportCallback;

public abstract class UnusedAppRestrictionsBackportService
extends Service {
    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private IUnusedAppRestrictionsBackportService.Stub mBinder = new IUnusedAppRestrictionsBackportService.Stub(this){
        final UnusedAppRestrictionsBackportService this$0;
        {
            this.this$0 = unusedAppRestrictionsBackportService;
        }

        @Override
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback object) throws RemoteException {
            if (object == null) {
                return;
            }
            object = new UnusedAppRestrictionsBackportCallback((IUnusedAppRestrictionsBackportCallback)object);
            this.this$0.isPermissionRevocationEnabled((UnusedAppRestrictionsBackportCallback)object);
        }
    };

    protected abstract void isPermissionRevocationEnabled(UnusedAppRestrictionsBackportCallback var1);

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}

