package ld;

import amuvvoafs.app.AlarmManager;
import amuvvoafs.app.PendingIntent;
import amuvvoafs.content.ComponentName;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.database.sqlite.SQLiteAccessPermException;
import amuvvoafs.database.sqlite.SQLiteCantOpenDatabaseException;
import amuvvoafs.database.sqlite.SQLiteConstraintException;
import amuvvoafs.database.sqlite.SQLiteDatabaseCorruptException;
import amuvvoafs.database.sqlite.SQLiteDatabaseLockedException;
import amuvvoafs.database.sqlite.SQLiteDiskIOException;
import amuvvoafs.database.sqlite.SQLiteException;
import amuvvoafs.database.sqlite.SQLiteFullException;
import amuvvoafs.database.sqlite.SQLiteTableLockedException;
import amuvvoafs.os.Build;
import amuvvoafs.text.TextUtils;
import cd.x;
import dd.t;
import java.util.concurrent.TimeUnit;
import tlydtdl.work.impl.utils.ForceStopRunnable$BroadcastReceiver;
import x10.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {
    public static final String e = x.g("ForceStopRunnable");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f317f = TimeUnit.DAYS.toMillis(3650);
    public final Context a;
    public final t b;
    public final dd.b c;
    public int d = 0;

    public b(Context context, t tVar) {
        this.a = context.getApplicationContext();
        this.b = tVar;
        this.c = tVar.j;
    }

    public static void c(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, ForceStopRunnable$BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long jCurrentTimeMillis = System.currentTimeMillis() + f317f;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() {
        /*
            Method dump skipped, instruction units count: 577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ld.b.a():void");
    }

    public final boolean b() {
        cd.b bVar = this.b.e;
        bVar.getClass();
        boolean zIsEmpty = TextUtils.isEmpty((CharSequence) null);
        String str = e;
        if (zIsEmpty) {
            x.e().a(str, "The default process name was not specified.");
            return true;
        }
        boolean zA = i.a(this.a, bVar);
        x.e().a(str, "Is default app process = " + zA);
        return zA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        String str = e;
        t tVar = this.b;
        try {
            if (!b()) {
                return;
            }
            while (true) {
                try {
                    a.r(context);
                    x.e().a(str, "Performing cleanup operations.");
                    try {
                        a();
                        return;
                    } catch (SQLiteAccessPermException | SQLiteTableLockedException | SQLiteFullException | SQLiteConstraintException | SQLiteDatabaseLockedException | SQLiteDiskIOException | SQLiteDatabaseCorruptException | SQLiteCantOpenDatabaseException e2) {
                        int i = this.d + 1;
                        this.d = i;
                        if (i >= 3) {
                            String str2 = a.o(context) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.amuvvoafs.com/training/articles/direct-boot";
                            x.e().d(str, str2, e2);
                            IllegalStateException illegalStateException = new IllegalStateException(str2, e2);
                            tVar.e.getClass();
                            throw illegalStateException;
                        }
                        x.e().b(str, "Retrying after " + (((long) i) * 300), e2);
                        try {
                            Thread.sleep(((long) this.d) * 300);
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (SQLiteException e3) {
                    x.e().c(str, "Unexpected SQLite exception during migrations");
                    IllegalStateException illegalStateException2 = new IllegalStateException("Unexpected SQLite exception during migrations", e3);
                    tVar.e.getClass();
                    throw illegalStateException2;
                }
            }
        } finally {
            tVar.Q();
        }
    }
}
