/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 */
package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.utils.WakeLocksHolder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001c\u0010\u0004\u001a\u00060\u0005R\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"TAG", "", "checkWakeLocks", "", "newWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "context", "Landroid/content/Context;", "tag", "work-runtime_release"}, k=2, mv={1, 8, 0}, xi=48)
public final class WakeLocks {
    private static final String TAG;

    static {
        String string2 = Logger.tagWithPrefix("WakeLocks");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"tagWithPrefix(\"WakeLocks\")");
        TAG = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void checkWakeLocks() {
        Unit unit;
        Map object2 = new LinkedHashMap();
        Object wakeLocksHolder = WakeLocksHolder.INSTANCE;
        synchronized (wakeLocksHolder) {
            object2.putAll((Map)WakeLocksHolder.INSTANCE.getWakeLocks());
            unit = Unit.INSTANCE;
        }
        wakeLocksHolder = object2.entrySet().iterator();
        while (wakeLocksHolder.hasNext()) {
            boolean bl;
            Map.Entry entry = (Map.Entry)wakeLocksHolder.next();
            unit = (PowerManager.WakeLock)entry.getKey();
            String string2 = (String)entry.getValue();
            boolean bl2 = bl = false;
            if (unit != null) {
                bl2 = bl;
                if (unit.isHeld()) {
                    bl2 = true;
                }
            }
            if (!bl2) continue;
            Logger.get().warning(TAG, "WakeLock held for " + string2);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final PowerManager.WakeLock newWakeLock(Context object, String string2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"context");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"tag");
        object = object.getApplicationContext().getSystemService("power");
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type android.os.PowerManager");
        object = (PowerManager)object;
        string2 = "WorkManager: " + string2;
        PowerManager.WakeLock wakeLock = object.newWakeLock(1, string2);
        object = WakeLocksHolder.INSTANCE;
        synchronized (object) {
            string2 = WakeLocksHolder.INSTANCE.getWakeLocks().put(wakeLock, string2);
        }
        Intrinsics.checkNotNullExpressionValue((Object)wakeLock, (String)"wakeLock");
        return wakeLock;
    }
}

