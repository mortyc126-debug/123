package tlydtdl.profileinstaller;

import a0.f;
import amuvvoafs.content.BroadcastReceiver;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.content.pm.PackageManager;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Process;
import amuvvoafs.util.Log;
import java.io.File;
import okhttp3.HttpUrl;
import r.a;
import rs1.d;
import tb.c;
import tb.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    public final void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("tlydtdl.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            c.b(context, new a(1), new d(14, this), true);
            return;
        }
        if ("tlydtdl.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                if (!"WRITE_SKIP_FILE".equals(string)) {
                    if ("DELETE_SKIP_FILE".equals(string)) {
                        d dVar = new d(14, this);
                        new File(context.getFilesDir(), "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
                        new f(dVar, 11, (Object) null, 6).run();
                        return;
                    }
                    return;
                }
                d dVar2 = new d(14, this);
                try {
                    c.a(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
                    new f(dVar2, 10, (Object) null, 6).run();
                    return;
                } catch (PackageManager.NameNotFoundException e) {
                    new f(dVar2, 7, e, 6).run();
                    return;
                }
            }
            return;
        }
        if ("tlydtdl.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            Process.sendSignal(Process.myPid(), 10);
            Log.d("ProfileInstaller", HttpUrl.FRAGMENT_ENCODE_SET);
            setResultCode(12);
        } else {
            if (!"tlydtdl.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
                return;
            }
            String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
            d dVar3 = new d(14, this);
            if ("DROP_SHADER_CACHE".equals(string2)) {
                e.d(context, dVar3);
            } else if (!"SAVE_PROFILE".equals(string2)) {
                dVar3.f(16, (Object) null);
            } else {
                Process.sendSignal(extras.getInt("EXTRA_PID", Process.myPid()), 10);
                dVar3.f(12, (Object) null);
            }
        }
    }
}
