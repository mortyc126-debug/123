package tlydtdl.lifecycle;

import amuvvoafs.app.Activity;
import amuvvoafs.app.Application;
import amuvvoafs.app.Fragment;
import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Ltlydtdl/lifecycle/d1;", "Lamuvvoafs/app/Fragment;", "<init>", "()V", "tlydtdl/lifecycle/u1", "a", "tlydtdl/lifecycle/b1", "lifecycle-runtime"}, k = 1, mv = {2, 0, 0}, xi = tlydtdl.compose.foundation.layout.m.g)
public class d1 extends Fragment {
    public static final /* synthetic */ int b = 0;
    public u1 a;

    /* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final c1 Companion = new c1();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            c1.a(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            o.h(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            o.h(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            o.h(activity, "activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            o.h(activity, "activity");
            int i = d1.b;
            b1.a(activity, x.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            o.h(activity, "activity");
            int i = d1.b;
            b1.a(activity, x.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            o.h(activity, "activity");
            int i = d1.b;
            b1.a(activity, x.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            o.h(activity, "activity");
            int i = d1.b;
            b1.a(activity, x.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            o.h(activity, "activity");
            int i = d1.b;
            b1.a(activity, x.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            o.h(activity, "activity");
            int i = d1.b;
            b1.a(activity, x.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
            o.h(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            o.h(activity, "activity");
            o.h(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            o.h(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            o.h(activity, "activity");
        }
    }

    public final void a(x xVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            o.g(activity, "getActivity(...)");
            b1.a(activity, xVar);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(x.ON_CREATE);
    }

    public final void onDestroy() {
        super.onDestroy();
        a(x.ON_DESTROY);
        this.a = null;
    }

    public final void onPause() {
        super.onPause();
        a(x.ON_PAUSE);
    }

    public final void onResume() {
        super.onResume();
        u1 u1Var = this.a;
        if (u1Var != null) {
            ((z0) u1Var.a).a();
        }
        a(x.ON_RESUME);
    }

    public final void onStart() {
        super.onStart();
        u1 u1Var = this.a;
        if (u1Var != null) {
            z0 z0Var = (z0) u1Var.a;
            int i = z0Var.a + 1;
            z0Var.a = i;
            if (i == 1 && z0Var.d) {
                z0Var.f604f.g(x.ON_START);
                z0Var.d = false;
            }
        }
        a(x.ON_START);
    }

    public final void onStop() {
        super.onStop();
        a(x.ON_STOP);
    }
}
