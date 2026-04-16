package tlydtdl.lifecycle;

import amuvvoafs.app.Activity;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.lifecycle.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 {
    public static void a(Activity activity) {
        o.h(activity, "activity");
        activity.registerActivityLifecycleCallbacks(new d1.a());
    }
}
