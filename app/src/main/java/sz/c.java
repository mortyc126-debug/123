package sz;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import ny1.g2;
import ny1.r2;
import ny1.z;
import yy.v;
import z10.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final LinkedBlockingQueue a = new LinkedBlockingQueue(50);
    public final LinkedBlockingQueue b = new LinkedBlockingQueue(100);
    public final g2 c = z.b(0, 1, (my1.c) null, 5);
    public final g2 d = z.b(0, 1, (my1.c) null, 5);
    public final g2 e = z.b(0, 1, (my1.c) null, 5);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r2 f474f = z.c(z10.a.c);
    public final g2 g;
    public final g2 h;
    public final ConcurrentSkipListSet i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f475j;

    public c() {
        z.b(0, 1, (my1.c) null, 5);
        this.g = z.b(0, 1, (my1.c) null, 5);
        this.h = z.b(0, 1, (my1.c) null, 5);
        this.i = new ConcurrentSkipListSet();
    }

    public final void a(yy.a aVar) {
        o.h(aVar, "event");
        String strW = aVar.w();
        o.h(strW, "conversationId");
        boolean z = this.f475j;
        ConcurrentSkipListSet concurrentSkipListSet = this.i;
        if (z || concurrentSkipListSet.contains(strW)) {
            LinkedBlockingQueue linkedBlockingQueue = this.b;
            if (!linkedBlockingQueue.contains(aVar) || aVar.E()) {
                linkedBlockingQueue.offer(aVar);
                this.d.a(aVar);
                d.H(this.f474f, b0.a);
                if (concurrentSkipListSet.contains(aVar.w())) {
                    return;
                }
                this.c.a(new v(aVar.w()));
            }
        }
    }
}
