package tlydtdl.lifecycle;

import amuvvoafs.app.Activity;
import amuvvoafs.app.Application;
import amuvvoafs.os.Bundle;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        o.h(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        o.h(activity, "activity");
    }

    public void onActivityPaused(Activity activity) {
        o.h(activity, "activity");
    }

    public void onActivityResumed(Activity activity) {
        o.h(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        o.h(activity, "activity");
        o.h(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        o.h(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        o.h(activity, "activity");
    }
}
