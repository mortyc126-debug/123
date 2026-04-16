package rm;

import java.util.concurrent.atomic.AtomicBoolean;
import ky1.c0;
import ky1.m0;
import lj1.g;
import ls0.k;
import lx1.b0;
import lx1.q;
import qz1.h;
import rx1.a;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final k a;
    public final q c;
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final q d = hs1.d.F(new h(9, this));

    public j(l71.b bVar, k kVar) {
        this.a = kVar;
        this.c = hs1.d.F(new h(8, bVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof rm.h
            if (r0 == 0) goto L13
            r0 = r5
            rm.h r0 = (rm.h) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            rm.h r0 = new rm.h
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r5)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            lg.e.O(r5)
            r0.l = r3
            java.lang.Object r5 = r4.b(r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            lx1.q r5 = r4.d
            java.lang.Object r5 = r5.getValue()
            java.io.File r5 = (java.io.File) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: rm.j.a(sx1.c):java.lang.Object");
    }

    public final Object b(c cVar) {
        if (this.b.compareAndSet(false, true)) {
            ry1.e eVar = m0.a;
            Object objR = c0.R(ry1.d.b, new g(this, (qx1.d) null, 23), cVar);
            if (objR == a.a) {
                return objR;
            }
        }
        return b0.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
    
        if (ky1.c0.R(r12, r4, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.io.File r12, s71.e r13, boolean r14, sx1.c r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof rm.i
            if (r0 == 0) goto L13
            r0 = r15
            rm.i r0 = (rm.i) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            rm.i r0 = new rm.i
            r0.<init>(r11, r15)
        L18:
            java.lang.Object r15 = r0.m
            rx1.a r1 = rx1.a.a
            int r2 = r0.o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lg.e.O(r15)
            goto L6d
        L2a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L32:
            boolean r14 = r0.l
            s71.e r13 = r0.k
            java.io.File r12 = r0.j
            lg.e.O(r15)
        L3b:
            r5 = r12
            r8 = r13
            r7 = r14
            goto L51
        L3f:
            lg.e.O(r15)
            r0.j = r12
            r0.k = r13
            r0.l = r14
            r0.o = r4
            java.lang.Object r15 = r11.b(r0)
            if (r15 != r1) goto L3b
            goto L6c
        L51:
            ry1.e r12 = ky1.m0.a
            ry1.d r12 = ry1.d.b
            d10.d r4 = new d10.d
            r9 = 0
            r10 = 2
            r6 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r13 = 0
            r0.j = r13
            r0.k = r13
            r0.l = r7
            r0.o = r3
            java.lang.Object r12 = ky1.c0.R(r12, r4, r0)
            if (r12 != r1) goto L6d
        L6c:
            return r1
        L6d:
            lx1.b0 r12 = lx1.b0.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: rm.j.c(java.io.File, s71.e, boolean, sx1.c):java.lang.Object");
    }
}
