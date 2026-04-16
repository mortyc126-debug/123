package tlydtdl.work.impl.background.systemalarm;

import amuvvoafs.content.BroadcastReceiver;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import cd.x;
import dd.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    public static final String a = x.g("RescheduleReceiver");

    public final void onReceive(Context context, Intent intent) {
        x.e().a(a, "Received intent " + intent);
        try {
            t tVarP = t.P(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (t.p) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = tVarP.l;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    tVarP.l = pendingResultGoAsync;
                    if (tVarP.k) {
                        pendingResultGoAsync.finish();
                        tVarP.l = null;
                    }
                } finally {
                }
            }
        } catch (IllegalStateException e) {
            x.e().d(a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
        }
    }
}
