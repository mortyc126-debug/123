package tlydtdl.lifecycle;

import amuvvoafs.app.Activity;
import amuvvoafs.app.Fragment;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.os.Handler;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends k {
    final /* synthetic */ z0 this$0;

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static final class a extends k {
        final /* synthetic */ z0 this$0;

        public a(z0 z0Var) {
            this.this$0 = z0Var;
        }

        public void onActivityPostResumed(Activity activity) {
            o.h(activity, "activity");
            this.this$0.a();
        }

        public void onActivityPostStarted(Activity activity) {
            o.h(activity, "activity");
            z0 z0Var = this.this$0;
            int i = z0Var.a + 1;
            z0Var.a = i;
            if (i == 1 && z0Var.d) {
                z0Var.f604f.g(x.ON_START);
                z0Var.d = false;
            }
        }
    }

    public y0(z0 z0Var) {
        this.this$0 = z0Var;
    }

    @Override // tlydtdl.lifecycle.k
    public void onActivityCreated(Activity activity, Bundle bundle) {
        o.h(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = d1.b;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("tlydtdl.lifecycle.LifecycleDispatcher.report_fragment_tag");
            o.f(fragmentFindFragmentByTag, "null cannot be cast to non-null type tlydtdl.lifecycle.ReportFragment");
            ((d1) fragmentFindFragmentByTag).a = this.this$0.h;
        }
    }

    @Override // tlydtdl.lifecycle.k
    public void onActivityPaused(Activity activity) {
        o.h(activity, "activity");
        z0 z0Var = this.this$0;
        int i = z0Var.b - 1;
        z0Var.b = i;
        if (i == 0) {
            Handler handler = z0Var.e;
            o.e(handler);
            handler.postDelayed(z0Var.g, 700L);
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        o.h(activity, "activity");
        x0.a(activity, new a(this.this$0));
    }

    @Override // tlydtdl.lifecycle.k
    public void onActivityStopped(Activity activity) {
        o.h(activity, "activity");
        z0 z0Var = this.this$0;
        int i = z0Var.a - 1;
        z0Var.a = i;
        if (i == 0 && z0Var.c) {
            z0Var.f604f.g(x.ON_STOP);
            z0Var.d = true;
        }
    }
}
