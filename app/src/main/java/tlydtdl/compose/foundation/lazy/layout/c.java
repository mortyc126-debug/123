package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.os.Trace;
import amuvvoafs.view.Choreographer;
import amuvvoafs.view.View;
import com.gnacba.firebase.messaging.w;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements s1, View.OnAttachStateChangeListener, Runnable, Choreographer.FrameCallback {
    public static long h;
    public final View a;
    public boolean c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f500f;
    public long g;
    public final PriorityQueue b = new PriorityQueue(11, new a(0));
    public final Choreographer d = Choreographer.getInstance();
    public final b e = new b();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(amuvvoafs.view.View r5) {
        /*
            r4 = this;
            r4.<init>()
            r4.a = r5
            java.util.PriorityQueue r0 = new java.util.PriorityQueue
            tlydtdl.compose.foundation.lazy.layout.a r1 = new tlydtdl.compose.foundation.lazy.layout.a
            r2 = 0
            r1.<init>(r2)
            r2 = 11
            r0.<init>(r2, r1)
            r4.b = r0
            amuvvoafs.view.Choreographer r0 = amuvvoafs.view.Choreographer.getInstance()
            r4.d = r0
            tlydtdl.compose.foundation.lazy.layout.b r0 = new tlydtdl.compose.foundation.lazy.layout.b
            r0.<init>()
            r4.e = r0
            long r0 = tlydtdl.compose.foundation.lazy.layout.c.h
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L4a
            amuvvoafs.view.Display r0 = r5.getDisplay()
            boolean r1 = r5.isInEditMode()
            if (r1 != 0) goto L40
            if (r0 == 0) goto L40
            float r0 = r0.getRefreshRate()
            r1 = 1106247680(0x41f00000, float:30.0)
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L40
            goto L42
        L40:
            r0 = 1114636288(0x42700000, float:60.0)
        L42:
            r1 = 1000000000(0x3b9aca00, float:0.0047237873)
            float r1 = (float) r1
            float r1 = r1 / r0
            long r0 = (long) r1
            tlydtdl.compose.foundation.lazy.layout.c.h = r0
        L4a:
            r5.addOnAttachStateChangeListener(r4)
            boolean r5 = r5.isAttachedToWindow()
            if (r5 == 0) goto L56
            r5 = 1
            r4.f500f = r5
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.c.<init>(amuvvoafs.view.View):void");
    }

    @Override // tlydtdl.compose.foundation.lazy.layout.s1
    public void a(p1 p1Var) {
        this.b.add(new v1(1, p1Var));
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.post(this);
    }

    public final boolean b() {
        b bVar = this.e;
        long jA = bVar.a();
        w.h(jA, "compose:lazy:prefetch:available_time_nanos");
        boolean z = true;
        if (jA > 0) {
            PriorityQueue priorityQueue = this.b;
            Object objPeek = priorityQueue.peek();
            o.e(objPeek);
            if (!((v1) objPeek).b.c(bVar)) {
                priorityQueue.poll();
                z = false;
            }
            bVar.a = false;
        }
        return z;
    }

    public final void doFrame(long j2) {
        if (this.f500f) {
            this.g = j2;
            this.a.post(this);
        }
    }

    public final void onViewAttachedToWindow(View view) {
        this.f500f = true;
    }

    public final void onViewDetachedFromWindow(View view) {
        this.f500f = false;
        this.a.removeCallbacks(this);
        this.d.removeFrameCallback(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        PriorityQueue priorityQueue = this.b;
        if (!priorityQueue.isEmpty() && this.c && this.f500f) {
            View view = this.a;
            if (view.getWindowVisibility() == 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(view.getDrawingTime());
                boolean z = System.nanoTime() > (((long) 2) * h) + nanos;
                b bVar = this.e;
                bVar.a = z;
                bVar.b = Math.max(this.g, nanos) + h;
                boolean zB = false;
                while (!priorityQueue.isEmpty() && !zB) {
                    if (bVar.a) {
                        Trace.beginSection("compose:lazy:prefetch:idle_frame");
                        try {
                            zB = b();
                        } finally {
                            Trace.endSection();
                        }
                    } else {
                        zB = b();
                    }
                }
                if (zB) {
                    this.d.postFrameCallback(this);
                } else {
                    this.c = false;
                }
                w.h(0L, "compose:lazy:prefetch:available_time_nanos");
                return;
            }
        }
        this.c = false;
    }
}
