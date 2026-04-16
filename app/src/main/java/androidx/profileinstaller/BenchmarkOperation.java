/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class BenchmarkOperation {
    private BenchmarkOperation() {
    }

    static boolean deleteFilesRecursively(File fileArray) {
        if (fileArray.isDirectory()) {
            if ((fileArray = fileArray.listFiles()) == null) {
                return false;
            }
            boolean bl = true;
            int n = fileArray.length;
            for (int i = 0; i < n; ++i) {
                bl = BenchmarkOperation.deleteFilesRecursively(fileArray[i]) && bl;
            }
            return bl;
        }
        fileArray.delete();
        return true;
    }

    static void dropShaderCache(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        if (BenchmarkOperation.deleteFilesRecursively(Api24ContextHelper.getDeviceProtectedCodeCacheDir(context))) {
            resultDiagnostics.onResultReceived(14, null);
        } else {
            resultDiagnostics.onResultReceived(15, null);
        }
    }

    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static File getDeviceProtectedCodeCacheDir(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }
}

