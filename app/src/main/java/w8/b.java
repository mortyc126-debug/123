package w8;

import amuvvoafs.content.BroadcastReceiver;
import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import tlydtdl.compose.foundation.lazy.layout.q1;
import u0.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends BroadcastReceiver {
    public final a0 a;
    public final o8.b0 b;
    public final /* synthetic */ q1 c;

    public b(q1 q1Var, o8.b0 b0Var, a0 a0Var) {
        this.c = q1Var;
        this.b = b0Var;
        this.a = a0Var;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("amuvvoafs.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.b.d(new c(12, this));
        }
    }
}
