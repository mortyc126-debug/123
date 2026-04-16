package i5;

import amuvvoafs.content.Context;
import amuvvoafs.os.Build;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.view.Choreographer;
import java.util.Random;
import org.apache.commons.net.tftp.TFTP;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements Choreographer.FrameCallback {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ Object b;

    public final void doFrame(long j2) {
        switch (this.a) {
            case 0:
                ((Runnable) this.b).run();
                break;
            default:
                (Build.VERSION.SDK_INT >= 28 ? tb.d.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new l.k((Context) this.b, 1), new Random().nextInt(Math.max(1000, 1)) + TFTP.DEFAULT_TIMEOUT);
                break;
        }
    }
}
