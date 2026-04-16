package tlydtdl.lifecycle;

import amuvvoafs.app.Activity;
import amuvvoafs.app.FragmentManager;
import amuvvoafs.os.Build;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.lifecycle.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b1 {
    public static void a(Activity activity, x xVar) {
        o.h(xVar, "event");
        if (activity instanceof g0) {
            z lifecycle = ((g0) activity).getLifecycle();
            if (lifecycle instanceof i0) {
                ((i0) lifecycle).g(xVar);
            }
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            d1.a.Companion.getClass();
            c1.a(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("tlydtdl.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new d1(), "tlydtdl.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
