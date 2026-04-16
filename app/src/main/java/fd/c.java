package fd;

import a3.f1;
import amuvvoafs.app.job.JobInfo;
import amuvvoafs.content.ComponentName;
import amuvvoafs.content.Context;
import amuvvoafs.net.NetworkRequest;
import amuvvoafs.os.Build;
import amuvvoafs.os.PersistableBundle;
import cd.e;
import cd.f;
import cd.x;
import cd.y;
import cd.z;
import kd.r;
import tlydtdl.work.impl.background.systemjob.SystemJobService;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final String d = x.g("SystemJobInfoConverter");
    public final ComponentName a;
    public final z b;
    public final boolean c;

    public c(Context context, z zVar, boolean z) {
        this.b = zVar;
        this.a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
        this.c = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final JobInfo a(r rVar, int i) {
        int i2;
        String strH;
        f fVar = rVar.j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", rVar.a);
        persistableBundle.putInt("EXTRA_WORK_SPEC_GENERATION", rVar.c());
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", rVar.j());
        JobInfo.Builder extras = new JobInfo.Builder(i, this.a).setRequiresCharging(fVar.i()).setRequiresDeviceIdle(fVar.j()).setExtras(persistableBundle);
        NetworkRequest networkRequestD = fVar.d();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28 || networkRequestD == null) {
            y yVarF = fVar.f();
            if (i3 < 30 || yVarF != y.f) {
                int iOrdinal = yVarF.ordinal();
                if (iOrdinal == 0) {
                    i2 = 0;
                } else if (iOrdinal != 1) {
                    i2 = 2;
                    if (iOrdinal != 2) {
                        i2 = 3;
                        if (iOrdinal != 3) {
                            i2 = 4;
                            if (iOrdinal != 4) {
                                x.e().a(d, "API version too low. Cannot convert network type value " + yVarF);
                                i2 = 1;
                            }
                        }
                    }
                } else {
                    i2 = 1;
                }
                extras.setRequiredNetworkType(i2);
            } else {
                extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
            }
        } else {
            f1.E(extras, networkRequestD);
        }
        if (!fVar.j()) {
            extras.setBackoffCriteria(rVar.m, rVar.l == cd.a.b ? 0 : 1);
        }
        long jA = rVar.a();
        this.b.getClass();
        long jMax = Math.max(jA - System.currentTimeMillis(), 0L);
        if (i3 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!rVar.q && this.c) {
            extras.setImportantWhileForeground(true);
        }
        if (fVar.g()) {
            for (e eVar : fVar.c()) {
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(eVar.a(), eVar.b() ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(fVar.b());
            extras.setTriggerContentMaxDelay(fVar.a());
        }
        extras.setPersisted(false);
        int i4 = Build.VERSION.SDK_INT;
        extras.setRequiresBatteryNotLow(fVar.h());
        extras.setRequiresStorageNotLow(fVar.k());
        byte b = rVar.k > 0;
        boolean z = jMax > 0;
        if (i4 >= 31 && rVar.q && b == false && !z) {
            extras.setExpedited(true);
        }
        if (i4 >= 35 && (strH = rVar.h()) != null) {
            extras.setTraceTag(strH);
        }
        return extras.build();
    }
}
