/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ServiceInfo
 *  android.os.IBinder
 */
package androidx.appcompat.app;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;

public final class AppLocalesMetadataHolderService
extends Service {
    public static ServiceInfo getServiceInfo(Context context) throws PackageManager.NameNotFoundException {
        int n = Api24Impl.getDisabledComponentFlag();
        return context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), 0x80 | n);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static int getDisabledComponentFlag() {
            return 512;
        }
    }
}

