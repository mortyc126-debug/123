package tlydtdl.work.impl.utils;

import amuvvoafs.content.BroadcastReceiver;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import amuvvoafs.util.Log;
import cd.x;
import ld.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable$BroadcastReceiver extends BroadcastReceiver {
    public static final String a = x.g("ForceStopRunnable$Rcvr");

    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
            return;
        }
        if (x.e().a <= 2) {
            Log.v(a, "Rescheduling alarm that keeps track of force-stops.");
        }
        b.c(context);
    }
}
