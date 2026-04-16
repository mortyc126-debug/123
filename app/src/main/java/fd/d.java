package fd;

import af0.v;
import amuvvoafs.app.job.JobInfo;
import amuvvoafs.app.job.JobScheduler;
import amuvvoafs.content.ComponentName;
import amuvvoafs.content.Context;
import amuvvoafs.os.Build;
import amuvvoafs.os.PersistableBundle;
import cd.g0;
import cd.h0;
import cd.i0;
import cd.x;
import dd.g;
import f3.f2;
import fo.n;
import hy.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jq0.e;
import kd.i;
import kd.k;
import kd.l;
import kd.r;
import kd.u;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import org.apache.commons.net.ftp.FTPReply;
import qq1.w;
import qr.m;
import tlydtdl.work.impl.WorkDatabase;
import tlydtdl.work.impl.background.systemjob.SystemJobService;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f121f = x.g("SystemJobScheduler");
    public final Context a;
    public final JobScheduler b;
    public final c c;
    public final WorkDatabase d;
    public final cd.b e;

    public d(Context context, WorkDatabase workDatabase, cd.b bVar) {
        JobScheduler jobSchedulerB = b.b(context);
        c cVar = new c(context, bVar.d, bVar.l);
        this.a = context;
        this.b = jobSchedulerB;
        this.c = cVar;
        this.d = workDatabase;
        this.e = bVar;
    }

    public static void a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            x.e().d(f121f, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    public static ArrayList c(Context context, JobScheduler jobScheduler) {
        List<JobInfo> listA = b.a(jobScheduler);
        if (listA == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(listA.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : listA) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static l f(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new l(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public final void b(r... rVarArr) {
        int iY;
        cd.b bVar = this.e;
        WorkDatabase workDatabase = this.d;
        n nVar = new n(workDatabase);
        for (r rVar : rVarArr) {
            workDatabase.b();
            try {
                u uVarW = workDatabase.w();
                String str = rVar.a;
                r rVarB = uVarW.b(str);
                String str2 = f121f;
                if (rVarB == null) {
                    x.e().h(str2, "Skipping scheduling " + str + " because it's no longer in the DB");
                    workDatabase.p();
                } else if (rVarB.b != h0.a) {
                    x.e().h(str2, "Skipping scheduling " + str + " because it is no longer enqueued");
                    workDatabase.p();
                } else {
                    l lVarX = m.x(rVar);
                    i iVarA = workDatabase.t().a(lVarX);
                    if (iVarA != null) {
                        iY = iVarA.c;
                    } else {
                        bVar.getClass();
                        iY = nVar.y(bVar.i);
                    }
                    if (iVarA == null) {
                        i iVarT = w.T(lVarX, iY);
                        k kVarT = workDatabase.t();
                        kVarT.getClass();
                        i0.C(kVarT.a, false, true, new b0(16, kVarT, iVarT));
                    }
                    g(rVar, iY);
                    workDatabase.p();
                }
            } finally {
                workDatabase.l();
            }
        }
    }

    public final void d(String str) {
        ArrayList arrayList;
        Context context = this.a;
        JobScheduler jobScheduler = this.b;
        ArrayList<JobInfo> arrayListC = c(context, jobScheduler);
        if (arrayListC == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(2);
            for (JobInfo jobInfo : arrayListC) {
                l lVarF = f(jobInfo);
                if (lVarF != null && str.equals(lVarF.b())) {
                    arrayList2.add(Integer.valueOf(jobInfo.getId()));
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a(jobScheduler, ((Integer) it.next()).intValue());
        }
        k kVarT = this.d.t();
        kVarT.getClass();
        o.h(str, "workSpecId");
        i0.C(kVarT.a, false, true, new v(str, 23));
    }

    public final boolean e() {
        return true;
    }

    public final void g(r rVar, int i) {
        String str;
        JobInfo jobInfoA = this.c.a(rVar, i);
        x xVarE = x.e();
        StringBuilder sb = new StringBuilder("Scheduling work ID ");
        String str2 = rVar.a;
        sb.append(str2);
        sb.append("Job ID ");
        sb.append(i);
        String string = sb.toString();
        String str3 = f121f;
        xVarE.a(str3, string);
        try {
            if (this.b.schedule(jobInfoA) == 0) {
                x.e().h(str3, "Unable to schedule work ID " + str2);
                if (rVar.q && rVar.r == g0.a) {
                    rVar.q = false;
                    x.e().a(str3, "Scheduling a non-expedited job (work ID " + str2 + ")");
                    g(rVar, i);
                }
            }
        } catch (IllegalStateException e) {
            String str4 = b.a;
            Context context = this.a;
            o.h(context, "context");
            WorkDatabase workDatabase = this.d;
            o.h(workDatabase, "workDatabase");
            cd.b bVar = this.e;
            o.h(bVar, "configuration");
            int i2 = Build.VERSION.SDK_INT;
            int i3 = i2 >= 31 ? FTPReply.FILE_STATUS_OK : 100;
            int size = ((List) i0.C(workDatabase.w().a, true, false, new e(20))).size();
            String strE0 = "<faulty JobScheduler failed to getPendingJobs>";
            if (i2 >= 34) {
                JobScheduler jobSchedulerB = b.b(context);
                List listA = b.a(jobSchedulerB);
                if (listA != null) {
                    ArrayList arrayListC = c(context, jobSchedulerB);
                    int size2 = arrayListC != null ? listA.size() - arrayListC.size() : 0;
                    String str5 = null;
                    if (size2 == 0) {
                        str = null;
                    } else {
                        str = size2 + " of which are not owned by WorkManager";
                    }
                    Object systemService = context.getSystemService("jobscheduler");
                    o.f(systemService, "null cannot be cast to non-null type amuvvoafs.app.job.JobScheduler");
                    ArrayList arrayListC2 = c(context, (JobScheduler) systemService);
                    int size3 = arrayListC2 != null ? arrayListC2.size() : 0;
                    if (size3 != 0) {
                        str5 = size3 + " from WorkManager in the default namespace";
                    }
                    strE0 = mx1.o.E0(mx1.n.e0(new String[]{listA.size() + " jobs in \"tlydtdl.work.systemjobscheduler\" namespace", str, str5}), ",\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62);
                }
            } else {
                ArrayList arrayListC3 = c(context, b.b(context));
                if (arrayListC3 != null) {
                    strE0 = arrayListC3.size() + " jobs from WorkManager";
                }
            }
            StringBuilder sbP = f2.p("JobScheduler ", i3, " job limit exceeded.\nIn JobScheduler there are ", strE0, ".\nThere are ");
            sbP.append(size);
            sbP.append(" jobs tracked by WorkManager's database;\nthe Configuration limit is ");
            String strL = f2.l(sbP, bVar.k, '.');
            x.e().c(str3, strL);
            throw new IllegalStateException(strL, e);
        } catch (Throwable th) {
            x.e().d(str3, "Unable to schedule " + rVar, th);
        }
    }
}
