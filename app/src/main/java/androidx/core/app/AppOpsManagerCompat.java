/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

public final class AppOpsManagerCompat {
    public static final int MODE_ALLOWED = 0;
    public static final int MODE_DEFAULT = 3;
    public static final int MODE_ERRORED = 2;
    public static final int MODE_IGNORED = 1;

    private AppOpsManagerCompat() {
    }

    public static int checkOrNoteProxyOp(Context context, int n, String string2, String string3) {
        if (Build.VERSION.SDK_INT >= 29) {
            AppOpsManager appOpsManager = Api29Impl.getSystemService(context);
            int n2 = Api29Impl.checkOpNoThrow(appOpsManager, string2, Binder.getCallingUid(), string3);
            if (n2 != 0) {
                return n2;
            }
            return Api29Impl.checkOpNoThrow(appOpsManager, string2, n, Api29Impl.getOpPackageName(context));
        }
        return AppOpsManagerCompat.noteProxyOpNoThrow(context, string2, string3);
    }

    public static int noteOp(Context context, String string2, int n, String string3) {
        return ((AppOpsManager)context.getSystemService("appops")).noteOp(string2, n, string3);
    }

    public static int noteOpNoThrow(Context context, String string2, int n, String string3) {
        return ((AppOpsManager)context.getSystemService("appops")).noteOpNoThrow(string2, n, string3);
    }

    public static int noteProxyOp(Context context, String string2, String string3) {
        return Api23Impl.noteProxyOp(Api23Impl.getSystemService(context, AppOpsManager.class), string2, string3);
    }

    public static int noteProxyOpNoThrow(Context context, String string2, String string3) {
        return Api23Impl.noteProxyOpNoThrow(Api23Impl.getSystemService(context, AppOpsManager.class), string2, string3);
    }

    public static String permissionToOp(String string2) {
        return Api23Impl.permissionToOp(string2);
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static <T> T getSystemService(Context context, Class<T> clazz) {
            return (T)context.getSystemService(clazz);
        }

        static int noteProxyOp(AppOpsManager appOpsManager, String string2, String string3) {
            return appOpsManager.noteProxyOp(string2, string3);
        }

        static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String string2, String string3) {
            return appOpsManager.noteProxyOpNoThrow(string2, string3);
        }

        static String permissionToOp(String string2) {
            return AppOpsManager.permissionToOp((String)string2);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static int checkOpNoThrow(AppOpsManager appOpsManager, String string2, int n, String string3) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(string2, n, string3);
        }

        static String getOpPackageName(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager getSystemService(Context context) {
            return (AppOpsManager)context.getSystemService(AppOpsManager.class);
        }
    }
}

