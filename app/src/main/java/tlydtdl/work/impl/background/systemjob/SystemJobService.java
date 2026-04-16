package tlydtdl.work.impl.background.systemjob;

import a0.i;
import a3.f1;
import amuvvoafs.app.Application;
import amuvvoafs.app.job.JobParameters;
import amuvvoafs.app.job.JobService;
import amuvvoafs.os.Build;
import amuvvoafs.os.Looper;
import amuvvoafs.os.PersistableBundle;
import amuvvoafs.support.v4.media.session.r;
import b8.e;
import cd.x;
import com.gnacba.amuvvoafs.gms.internal.ads.vi1;
import dd.c;
import dd.j;
import dd.t;
import java.util.Arrays;
import java.util.HashMap;
import kd.l;
import md.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements c {
    public static final String e = x.g("SystemJobService");
    public t a;
    public final HashMap b = new HashMap();
    public final e c = new e(1, false);
    public vi1 d;

    public static void b(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(i.n("Cannot invoke ", str, " on a background thread"));
        }
    }

    public static l c(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new l(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public final void a(l lVar, boolean z) {
        b("onExecuted");
        x.e().a(e, lVar.b() + " executed on JobScheduler");
        JobParameters jobParameters = (JobParameters) this.b.remove(lVar);
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    public final void onCreate() {
        super/*amuvvoafs.app.Service*/.onCreate();
        try {
            t tVarP = t.P(getApplicationContext());
            this.a = tVarP;
            dd.e eVar = tVarP.i;
            this.d = new vi1(eVar, tVarP.g);
            eVar.a(this);
        } catch (IllegalStateException e2) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
            x.e().h(e, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    public final void onDestroy() {
        super/*amuvvoafs.app.Service*/.onDestroy();
        t tVar = this.a;
        if (tVar != null) {
            dd.e eVar = tVar.i;
            synchronized (eVar.k) {
                eVar.j.remove(this);
            }
        }
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        b("onStartJob");
        t tVar = this.a;
        String str = e;
        if (tVar == null) {
            x.e().a(str, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        l lVarC = c(jobParameters);
        if (lVarC == null) {
            x.e().c(str, "WorkSpec id not found!");
            return false;
        }
        HashMap map = this.b;
        if (map.containsKey(lVarC)) {
            x.e().a(str, "Job is already being executed by SystemJobService: " + lVarC);
            return false;
        }
        x.e().a(str, "onStartJob for " + lVarC);
        map.put(lVarC, jobParameters);
        int i = Build.VERSION.SDK_INT;
        r rVar = new r(12);
        if (f02.c.E(jobParameters) != null) {
            rVar.c = Arrays.asList(f02.c.E(jobParameters));
        }
        if (f02.c.D(jobParameters) != null) {
            rVar.b = Arrays.asList(f02.c.D(jobParameters));
        }
        if (i >= 28) {
            rVar.d = f1.l(jobParameters);
        }
        vi1 vi1Var = this.d;
        j jVarI = this.c.i(lVarC);
        vi1Var.getClass();
        md.c cVar = (a) vi1Var.b;
        Runnable iVar = new i(vi1Var, jVarI, rVar, 21);
        cVar.getClass();
        cVar.a.execute(iVar);
        return true;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        boolean zContains;
        b("onStopJob");
        if (this.a == null) {
            x.e().a(e, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        l lVarC = c(jobParameters);
        if (lVarC == null) {
            x.e().c(e, "WorkSpec id not found!");
            return false;
        }
        x.e().a(e, "onStopJob for " + lVarC);
        this.b.remove(lVarC);
        j jVar = (j) this.c.a.remove(lVarC);
        if (jVar != null) {
            int iK = Build.VERSION.SDK_INT >= 31 ? c0.a.k(jobParameters) : -512;
            vi1 vi1Var = this.d;
            vi1Var.getClass();
            vi1Var.z(jVar, iK);
        }
        dd.e eVar = this.a.i;
        String strB = lVarC.b();
        synchronized (eVar.k) {
            zContains = eVar.i.contains(strB);
        }
        return !zContains;
    }
}
