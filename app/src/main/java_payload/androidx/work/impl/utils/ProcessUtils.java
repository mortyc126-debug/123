/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Process
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkManager;
import androidx.work.impl.utils.Api28Impl;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"TAG", "", "getProcessName", "context", "Landroid/content/Context;", "isDefaultProcess", "", "configuration", "Landroidx/work/Configuration;", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class ProcessUtils {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("ProcessUtils");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"ProcessUtils\")");
        TAG = string2;
    }

    private static final String getProcessName(Context object3) {
        Object object2;
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.INSTANCE.getProcessName();
        }
        Object var3_1 = null;
        try {
            object2 = Class.forName("android.app.ActivityThread", false, WorkManager.class.getClassLoader());
            object2 = ((Class)object2).getDeclaredMethod("currentProcessName", new Class[0]);
            ((Method)object2).setAccessible(true);
            object2 = ((Method)object2).invoke(null, new Object[0]);
            Intrinsics.checkNotNull((Object)object2);
            if (object2 instanceof String) {
                object2 = (String)object2;
                return object2;
            }
        }
        catch (Throwable throwable) {
            Logger.get().debug(TAG, "Unable to check ActivityThread for processName", throwable);
        }
        int n = Process.myPid();
        object3 = object3.getSystemService("activity");
        Intrinsics.checkNotNull((Object)object3, (String)"null cannot be cast to non-null type android.app.ActivityManager");
        object2 = ((ActivityManager)object3).getRunningAppProcesses();
        object3 = var3_1;
        if (object2 != null) {
            block7: {
                for (Object object3 : (Iterable)object2) {
                    boolean bl = ((ActivityManager.RunningAppProcessInfo)object3).pid == n;
                    if (!bl) continue;
                    break block7;
                }
                object3 = null;
            }
            object2 = (ActivityManager.RunningAppProcessInfo)object3;
            object3 = var3_1;
            if (object2 != null) {
                object3 = ((ActivityManager.RunningAppProcessInfo)object2).processName;
            }
        }
        return object3;
    }

    public static final boolean isDefaultProcess(Context context, Configuration configuration2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)configuration2, (String)"configuration");
        String string2 = ProcessUtils.getProcessName(context);
        CharSequence charSequence = configuration2.getDefaultProcessName();
        boolean bl = charSequence == null || charSequence.length() == 0;
        boolean bl2 = !bl ? Intrinsics.areEqual((Object)string2, (Object)configuration2.getDefaultProcessName()) : Intrinsics.areEqual((Object)string2, (Object)context.getApplicationInfo().processName);
        return bl2;
    }
}

