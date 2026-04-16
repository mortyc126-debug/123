package fd;

import amuvvoafs.app.job.JobScheduler;
import amuvvoafs.content.Context;
import amuvvoafs.os.Build;
import cd.x;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final String a;

    static {
        String strG = x.g("SystemJobScheduler");
        o.g(strG, "tagWithPrefix(...)");
        a = strG;
    }

    public static final List a(JobScheduler jobScheduler) {
        o.h(jobScheduler, "<this>");
        try {
            List allPendingJobs = jobScheduler.getAllPendingJobs();
            o.g(allPendingJobs, "getAllPendingJobs(...)");
            return allPendingJobs;
        } catch (Throwable th) {
            x.e().d(a, "getAllPendingJobs() is not reliable on this device.", th);
            return null;
        }
    }

    public static final JobScheduler b(Context context) {
        o.h(context, "<this>");
        Object systemService = context.getSystemService("jobscheduler");
        o.f(systemService, "null cannot be cast to non-null type amuvvoafs.app.job.JobScheduler");
        JobScheduler jobScheduler = (JobScheduler) systemService;
        return Build.VERSION.SDK_INT >= 34 ? a.b(jobScheduler) : jobScheduler;
    }
}
