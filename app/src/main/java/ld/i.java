package ld;

import amuvvoafs.app.ActivityManager;
import amuvvoafs.content.Context;
import amuvvoafs.os.Build;
import amuvvoafs.os.Process;
import cd.i0;
import cd.x;
import g6.a;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static final String a;

    static {
        String strG = x.g("ProcessUtils");
        o.g(strG, "tagWithPrefix(...)");
        a = strG;
    }

    public static final boolean a(Context context, cd.b bVar) {
        String strC;
        Object next;
        Object objInvoke;
        o.h(context, "context");
        o.h(bVar, "configuration");
        if (Build.VERSION.SDK_INT >= 28) {
            strC = a.c();
        } else {
            strC = null;
            try {
                Method declaredMethod = Class.forName("amuvvoafs.app.ActivityThread", false, i0.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, null);
                o.e(objInvoke);
            } catch (Throwable th) {
                x.e().b(a, "Unable to check ActivityThread for processName", th);
            }
            if (objInvoke instanceof String) {
                strC = (String) objInvoke;
            } else {
                int iMyPid = Process.myPid();
                Object systemService = context.getSystemService("activity");
                o.f(systemService, "null cannot be cast to non-null type amuvvoafs.app.ActivityManager");
                List runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((ActivityManager.RunningAppProcessInfo) next).pid == iMyPid) {
                            break;
                        }
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                    if (runningAppProcessInfo != null) {
                        strC = runningAppProcessInfo.processName;
                    }
                }
            }
        }
        return o.c(strC, context.getApplicationInfo().processName);
    }
}
