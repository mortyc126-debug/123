package f6;

import a3.f1;
import amuvvoafs.content.BroadcastReceiver;
import amuvvoafs.content.Context;
import amuvvoafs.content.IntentFilter;
import amuvvoafs.os.Build;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Process;
import amuvvoafs.text.TextUtils;
import com.facebook.appevents.l;
import com.gnacba.protobuf.c1;
import java.util.concurrent.Executor;
import qq1.w;
import tlydtdl.core.app.NotificationManagerCompat;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Object a = null;

    public static int a(Context context, String str) {
        l.X(str, "permission must be non-null");
        return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("amuvvoafs.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : NotificationManagerCompat.from(context).areNotificationsEnabled() ? 0 : -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r5.c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static amuvvoafs.content.res.ColorStateList b(amuvvoafs.content.Context r8, int r9) {
        /*
            amuvvoafs.content.res.Resources r0 = r8.getResources()
            amuvvoafs.content.res.Resources$Theme r8 = r8.getTheme()
            h6.j r1 = new h6.j
            r1.<init>(r0, r8)
            java.lang.Object r2 = h6.l.c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = h6.l.b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            amuvvoafs.util.SparseArray r3 = (amuvvoafs.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L50
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L50
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            h6.i r5 = (h6.i) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L50
            amuvvoafs.content.res.Configuration r6 = r5.b     // Catch: java.lang.Throwable -> L3c
            amuvvoafs.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4d
            if (r8 != 0) goto L3f
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L49
            goto L3f
        L3c:
            r8 = move-exception
            goto Lb8
        L3f:
            if (r8 == 0) goto L4d
            int r6 = r5.c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4d
        L49:
            amuvvoafs.content.res.ColorStateList r3 = r5.a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L52
        L4d:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L50:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L52:
            if (r3 == 0) goto L55
            return r3
        L55:
            java.lang.ThreadLocal r2 = h6.l.a
            java.lang.Object r3 = r2.get()
            amuvvoafs.util.TypedValue r3 = (amuvvoafs.util.TypedValue) r3
            if (r3 != 0) goto L67
            amuvvoafs.util.TypedValue r3 = new amuvvoafs.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L67:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L76
            r3 = 31
            if (r2 > r3) goto L76
            goto L87
        L76:
            amuvvoafs.content.res.XmlResourceParser r2 = r0.getXml(r9)
            amuvvoafs.content.res.ColorStateList r4 = h6.c.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7f
            goto L87
        L7f:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            amuvvoafs.util.Log.w(r3, r5, r2)
        L87:
            if (r4 == 0) goto Lb3
            java.lang.Object r2 = h6.l.c
            monitor-enter(r2)
            java.util.WeakHashMap r0 = h6.l.b     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L9f
            amuvvoafs.util.SparseArray r3 = (amuvvoafs.util.SparseArray) r3     // Catch: java.lang.Throwable -> L9f
            if (r3 != 0) goto La1
            amuvvoafs.util.SparseArray r3 = new amuvvoafs.util.SparseArray     // Catch: java.lang.Throwable -> L9f
            r3.<init>()     // Catch: java.lang.Throwable -> L9f
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L9f
            goto La1
        L9f:
            r8 = move-exception
            goto Lb1
        La1:
            h6.i r0 = new h6.i     // Catch: java.lang.Throwable -> L9f
            amuvvoafs.content.res.Resources r1 = r1.a     // Catch: java.lang.Throwable -> L9f
            amuvvoafs.content.res.Configuration r1 = r1.getConfiguration()     // Catch: java.lang.Throwable -> L9f
            r0.<init>(r4, r1, r8)     // Catch: java.lang.Throwable -> L9f
            r3.append(r9, r0)     // Catch: java.lang.Throwable -> L9f
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            goto Lb7
        Lb1:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L9f
            throw r8
        Lb3:
            amuvvoafs.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        Lb7:
            return r4
        Lb8:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a.b(amuvvoafs.content.Context, int):amuvvoafs.content.res.ColorStateList");
    }

    public static Executor c(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? f1.k(context) : w.t(new Handler(context.getMainLooper()));
    }

    public static String d(Context context) {
        String str = context.getApplicationContext().getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (a.a.B(context, str) == 0) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            str = context.getOpPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
            if (a.a.B(context, str) == 0) {
                return str;
            }
        }
        throw new RuntimeException(i.n("Permission ", str, " is required by your application to receive broadcasts, please add it to your manifest"));
    }

    public static void e(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        int i2 = i & 2;
        if (i2 == 0 && (i & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i2 != 0 && (i & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(broadcastReceiver, intentFilter, (String) null, (Handler) null, i);
        } else {
            c1.D(context, broadcastReceiver, intentFilter, i);
        }
    }
}
