/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.google.common.util.concurrent.ListenableFuture
 */
package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.PackageManagerCompat$$ExternalSyntheticLambda0;
import androidx.core.content.UnusedAppRestrictionsBackportServiceConnection;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executors;

public final class PackageManagerCompat {
    public static final String ACTION_PERMISSION_REVOCATION_SETTINGS = "android.intent.action.AUTO_REVOKE_PERMISSIONS";
    public static final String LOG_TAG = "PackageManagerCompat";

    private PackageManagerCompat() {
    }

    public static boolean areUnusedAppRestrictionsAvailable(PackageManager packageManager) {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        n = n >= 30 ? 1 : 0;
        boolean bl2 = Build.VERSION.SDK_INT < 30;
        boolean bl3 = PackageManagerCompat.getPermissionRevocationVerifierApp(packageManager) != null;
        boolean bl4 = bl;
        if (n == 0) {
            bl4 = bl2 && bl3 ? bl : false;
        }
        return bl4;
    }

    public static String getPermissionRevocationVerifierApp(PackageManager packageManager) {
        Object object = new Intent(ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts((String)"package", (String)"com.example", null));
        Object object2 = packageManager.queryIntentActivities(object, 0);
        object = null;
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            object2 = ((ResolveInfo)iterator2.next()).activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", (String)object2) != 0) continue;
            if (object != null) {
                return object;
            }
            object = object2;
        }
        return object;
    }

    public static ListenableFuture<Integer> getUnusedAppRestrictionsStatus(Context object) {
        ResolvableFuture<Integer> resolvableFuture = ResolvableFuture.create();
        boolean bl = UserManagerCompat.isUserUnlocked((Context)object);
        Integer n = 0;
        if (!bl) {
            resolvableFuture.set(n);
            Log.e((String)LOG_TAG, (String)"User is in locked direct boot mode");
            return resolvableFuture;
        }
        if (!PackageManagerCompat.areUnusedAppRestrictionsAvailable(object.getPackageManager())) {
            resolvableFuture.set(1);
            return resolvableFuture;
        }
        int n2 = object.getApplicationInfo().targetSdkVersion;
        if (n2 < 30) {
            resolvableFuture.set(n);
            Log.e((String)LOG_TAG, (String)"Target SDK version below API 30");
            return resolvableFuture;
        }
        int n3 = Build.VERSION.SDK_INT;
        int n4 = 4;
        if (n3 >= 31) {
            if (Api30Impl.areUnusedAppRestrictionsEnabled((Context)object)) {
                if (n2 >= 31) {
                    n4 = 5;
                }
                resolvableFuture.set(n4);
            } else {
                resolvableFuture.set(2);
            }
            return resolvableFuture;
        }
        if (Build.VERSION.SDK_INT == 30) {
            if (!Api30Impl.areUnusedAppRestrictionsEnabled((Context)object)) {
                n4 = 2;
            }
            resolvableFuture.set(n4);
            return resolvableFuture;
        }
        object = new UnusedAppRestrictionsBackportServiceConnection((Context)object);
        Objects.requireNonNull(object);
        resolvableFuture.addListener(new PackageManagerCompat$$ExternalSyntheticLambda0((UnusedAppRestrictionsBackportServiceConnection)object), Executors.newSingleThreadExecutor());
        ((UnusedAppRestrictionsBackportServiceConnection)object).connectAndFetchResult(resolvableFuture);
        return resolvableFuture;
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean areUnusedAppRestrictionsEnabled(Context context) {
            return context.getPackageManager().isAutoRevokeWhitelisted() ^ true;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface UnusedAppRestrictionsStatus {
    }
}

