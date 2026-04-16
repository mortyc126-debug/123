package sc0;

import am.p;
import b60.q;
import bh.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lmjxuqdtp.jvm.functions.Function0;
import lx1.l;
import nc0.i;
import nc0.n;
import nc0.t;
import ny1.e0;
import ny1.r2;
import ny1.z;
import qi.k;
import qx1.d;
import rt1.f;
import tc0.m;
import z10.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements m, t {
    public final Function0 a;
    public final f b;
    public List c;
    public final r2 d = z.c(a.c);
    public final AtomicReference e = new AtomicReference(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f457f;

    public c(Function0 function0, f fVar) {
        this.a = function0;
        this.b = fVar;
        this.c = (List) function0.invoke();
        this.f457f = new int[this.c.size()];
    }

    public final int b() {
        Iterator it = this.c.iterator();
        int iB = 0;
        while (it.hasNext()) {
            iB += ((nc0.a) it.next()).b();
        }
        return iB;
    }

    public final void d() {
        l lVar = (l) this.e.get();
        if (lVar == null) {
            return;
        }
        int iIntValue = ((Number) lVar.a).intValue();
        i iVar = (n) lVar.b;
        if (iIntValue >= this.c.size()) {
            return;
        }
        m mVar = (nc0.a) this.c.get(iIntValue);
        if ((!(iVar instanceof i) || iVar.c) && (mVar instanceof m)) {
            mVar.d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(qx1.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sc0.b
            if (r0 == 0) goto L13
            r0 = r7
            sc0.b r0 = (sc0.b) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            sc0.b r0 = new sc0.b
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.n
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r2 = r0.k
            java.util.Iterator r4 = r0.j
            lg.e.O(r7)
            goto L59
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            lg.e.O(r7)
            java.util.List r7 = r6.c
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r7 = r7.iterator()
        L41:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L53
            java.lang.Object r4 = r7.next()
            boolean r5 = r4 instanceof nc0.q
            if (r5 == 0) goto L41
            r2.add(r4)
            goto L41
        L53:
            java.util.Iterator r7 = r2.iterator()
            r2 = 0
            r4 = r7
        L59:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L72
            java.lang.Object r7 = r4.next()
            nc0.q r7 = (nc0.q) r7
            r0.j = r4
            r0.k = r2
            r0.n = r3
            java.lang.Object r7 = r7.e(r0)
            if (r7 != r1) goto L59
            return r1
        L72:
            lx1.b0 r7 = lx1.b0.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sc0.c.e(qx1.d):java.lang.Object");
    }

    public final void f(int i, int i2) {
        t tVar;
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = this.f457f[i3];
            t tVar2 = (nc0.a) this.c.get(i3);
            int i6 = i - i4;
            if (i6 >= 0 || i2 < 0) {
                tVar = tVar2 instanceof t ? tVar2 : null;
                if (tVar != null) {
                    tVar.f(-1, -1);
                }
                i2 -= i4;
                i = i6;
            } else {
                tVar = tVar2 instanceof t ? tVar2 : null;
                if (tVar != null) {
                    tVar.f(Math.max(i, 0), Math.min(Math.max(i2, 0), i4));
                }
                i2 -= i4;
                i = 0;
            }
        }
    }

    public final ny1.l getState() {
        d dVar = null;
        return new p(20, new e0(new b(2, 6, dVar), z.U(this.d, new q(dVar, this, 18))), new k(this, (d) null, 5));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(qx1.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sc0.a
            if (r0 == 0) goto L13
            r0 = r7
            sc0.a r0 = (sc0.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            sc0.a r0 = new sc0.a
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            int r0 = r0.j
            lg.e.O(r7)
            goto L60
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            lg.e.O(r7)
            lmjxuqdtp.jvm.functions.Function0 r7 = r6.a
            java.lang.Object r7 = r7.invoke()
            java.util.List r7 = (java.util.List) r7
            java.util.List r2 = r6.c
            boolean r2 = lmjxuqdtp.jvm.internal.o.c(r7, r2)
            r2 = r2 ^ r3
            r6.c = r7
            int r7 = r7.size()
            int[] r7 = new int[r7]
            r6.f457f = r7
            s91.b r7 = new s91.b
            r4 = 1
            r5 = 0
            r7.<init>(r6, r5, r4)
            r0.j = r2
            r0.m = r3
            java.lang.Object r7 = ky1.c0.o(r7, r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            r0 = r2
        L60:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            r7.getClass()
            if (r0 == 0) goto L6c
            ny1.r2 r0 = r6.d
            z10.d.G(r0)
        L6c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sc0.c.n(qx1.d):java.lang.Object");
    }
}
