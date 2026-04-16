/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Process
 */
package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import androidx.profileinstaller.BenchmarkOperation;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstaller;

public class ProfileInstallReceiver
extends BroadcastReceiver {
    public static final String ACTION_BENCHMARK_OPERATION = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SAVE_PROFILE = "androidx.profileinstaller.action.SAVE_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    static void saveProfile(ProfileInstaller.DiagnosticsCallback diagnosticsCallback) {
        Process.sendSignal((int)Process.myPid(), (int)10);
        diagnosticsCallback.onResultReceived(12, null);
    }

    public void onReceive(Context context, Intent object) {
        if (object == null) {
            return;
        }
        Object object2 = object.getAction();
        if (ACTION_INSTALL_PROFILE.equals(object2)) {
            ProfileInstaller.writeProfile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this), true);
        } else if (ACTION_SKIP_FILE.equals(object2)) {
            if ((object = object.getExtras()) != null) {
                if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(object = object.getString(EXTRA_SKIP_FILE_OPERATION))) {
                    ProfileInstaller.writeSkipFile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this));
                } else if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(object)) {
                    ProfileInstaller.deleteSkipFile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(this));
                }
            }
        } else if (ACTION_SAVE_PROFILE.equals(object2)) {
            ProfileInstallReceiver.saveProfile(new ResultDiagnostics(this));
        } else if (ACTION_BENCHMARK_OPERATION.equals(object2) && (object = object.getExtras()) != null) {
            object = object.getString(EXTRA_BENCHMARK_OPERATION);
            object2 = new ResultDiagnostics(this);
            if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(object)) {
                BenchmarkOperation.dropShaderCache(context, (ResultDiagnostics)object2);
            } else {
                ((ResultDiagnostics)object2).onResultReceived(16, null);
            }
        }
    }

    class ResultDiagnostics
    implements ProfileInstaller.DiagnosticsCallback {
        final ProfileInstallReceiver this$0;

        ResultDiagnostics(ProfileInstallReceiver profileInstallReceiver) {
            this.this$0 = profileInstallReceiver;
        }

        @Override
        public void onDiagnosticReceived(int n, Object object) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(n, object);
        }

        @Override
        public void onResultReceived(int n, Object object) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(n, object);
            this.this$0.setResultCode(n);
        }
    }
}

