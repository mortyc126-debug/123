package tlydtdl.compose.foundation.lazy.layout;

import java.util.ArrayList;
import s4.c1;
import t3.o;
import t3.p;
import t4.e2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public final q1.n0 a;
    public m1 b;
    public int c;
    public final q1.o0 d;
    public final ArrayList e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f501f;
    public final ArrayList g;
    public final ArrayList h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a0 f502j;
    public final p k;

    public d0() {
        long[] jArr = q1.v0.a;
        this.a = new q1.n0();
        q1.o0 o0Var = q1.w0.a;
        this.d = new q1.o0();
        this.e = new ArrayList();
        this.f501f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = new c1(this) { // from class: tlydtdl.compose.foundation.lazy.layout.LazyLayoutItemAnimator$DisplayingDisappearingItemsElement
            public final d0 a;

            {
                this.a = this;
            }

            @Override // s4.c1
            public final o create() {
                a0 a0Var = new a0();
                a0Var.a = this.a;
                return a0Var;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof LazyLayoutItemAnimator$DisplayingDisappearingItemsElement) && lmjxuqdtp.jvm.internal.o.c(this.a, ((LazyLayoutItemAnimator$DisplayingDisappearingItemsElement) obj).a);
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            @Override // s4.c1
            public final void inspectableProperties(e2 e2Var) {
                e2Var.d("DisplayingDisappearingItemsElement");
            }

            public final String toString() {
                return "DisplayingDisappearingItemsElement(animator=" + this.a + ')';
            }

            @Override // s4.c1
            public final void update(o oVar) {
                a0 a0Var = (a0) oVar;
                d0 d0Var = a0Var.a;
                d0 d0Var2 = this.a;
                if (lmjxuqdtp.jvm.internal.o.c(d0Var, d0Var2) || !a0Var.getNode().isAttached()) {
                    return;
                }
                d0 d0Var3 = a0Var.a;
                d0Var3.e();
                d0Var3.b = null;
                d0Var3.c = -1;
                d0Var2.f502j = a0Var;
                a0Var.a = d0Var2;
            }
        };
    }

    public static void c(q0 q0Var, int i, b0 b0Var) {
        int i2 = 0;
        long j2 = q0Var.j(0);
        long jA = q0Var.f() ? p5.k.a(j2, 0, i, 1) : p5.k.a(j2, i, 0, 2);
        y[] yVarArr = b0Var.a;
        int length = yVarArr.length;
        int i3 = 0;
        while (i2 < length) {
            y yVar = yVarArr[i2];
            int i4 = i3 + 1;
            if (yVar != null) {
                yVar.l = p5.k.d(jA, p5.k.c(q0Var.j(i3), j2));
            }
            i2++;
            i3 = i4;
        }
    }

    public static int h(int[] iArr, q0 q0Var) {
        int iK = q0Var.k();
        int iD = q0Var.d() + iK;
        int iMax = 0;
        while (iK < iD) {
            int iG = q0Var.g() + iArr[iK];
            iArr[iK] = iG;
            iMax = Math.max(iMax, iG);
            iK++;
        }
        return iMax;
    }

    public final y a(int i, Object obj) {
        b0 b0Var = (b0) this.a.g(obj);
        if (b0Var != null) {
            return b0Var.a[i];
        }
        return null;
    }

    public final long b() {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        long jMax = 0;
        for (int i = 0; i < size; i++) {
            y yVar = (y) arrayList.get(i);
            d4.c cVar = yVar.n;
            if (cVar != null) {
                int iMax = Math.max((int) (jMax >> 32), ((int) (yVar.l >> 32)) + ((int) (cVar.u >> 32)));
                jMax = (((long) Math.max((int) (jMax & 4294967295L), ((int) (yVar.l & 4294967295L)) + ((int) (cVar.u & 4294967295L)))) & 4294967295L) | (((long) iMax) << 32);
            }
        }
        return jMax;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(int r51, int r52, int r53, java.util.ArrayList r54, tlydtdl.compose.foundation.lazy.layout.m1 r55, tlydtdl.compose.foundation.lazy.layout.r0 r56, boolean r57, boolean r58, int r59, boolean r60, int r61, int r62, ky1.a0 r63, a4.h0 r64) {
        /*
            Method dump skipped, instruction units count: 1583
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.d0.d(int, int, int, java.util.ArrayList, tlydtdl.compose.foundation.lazy.layout.m1, tlydtdl.compose.foundation.lazy.layout.r0, boolean, boolean, int, boolean, int, int, ky1.a0, a4.h0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r15 = this;
            q1.n0 r0 = r15.a
            boolean r1 = r0.j()
            if (r1 == 0) goto L5d
            java.lang.Object[] r1 = r0.c
            long[] r2 = r0.a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5a
            r4 = 0
            r5 = r4
        L13:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L55
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2d:
            if (r10 >= r8) goto L53
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L4f
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            tlydtdl.compose.foundation.lazy.layout.b0 r11 = (tlydtdl.compose.foundation.lazy.layout.b0) r11
            tlydtdl.compose.foundation.lazy.layout.y[] r11 = r11.a
            int r12 = r11.length
            r13 = r4
        L43:
            if (r13 >= r12) goto L4f
            r14 = r11[r13]
            if (r14 == 0) goto L4c
            r14.d()
        L4c:
            int r13 = r13 + 1
            goto L43
        L4f:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2d
        L53:
            if (r8 != r9) goto L5a
        L55:
            if (r5 == r3) goto L5a
            int r5 = r5 + 1
            goto L13
        L5a:
            r0.a()
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.d0.e():void");
    }

    public final void f(Object obj) {
        y[] yVarArr;
        b0 b0Var = (b0) this.a.k(obj);
        if (b0Var == null || (yVarArr = b0Var.a) == null) {
            return;
        }
        for (y yVar : yVarArr) {
            if (yVar != null) {
                yVar.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(tlydtdl.compose.foundation.lazy.layout.q0 r18, boolean r19) {
        /*
            r17 = this;
            r0 = r17
            q1.n0 r1 = r0.a
            java.lang.Object r2 = r18.getKey()
            java.lang.Object r1 = r1.g(r2)
            lmjxuqdtp.jvm.internal.o.e(r1)
            tlydtdl.compose.foundation.lazy.layout.b0 r1 = (tlydtdl.compose.foundation.lazy.layout.b0) r1
            tlydtdl.compose.foundation.lazy.layout.y[] r1 = r1.a
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r2) goto L7d
            r6 = r1[r3]
            int r12 = r4 + 1
            r13 = r18
            if (r6 == 0) goto L75
            long r14 = r13.j(r4)
            long r4 = r6.l
            int r7 = tlydtdl.compose.foundation.lazy.layout.y.t
            n0.f.K()
            long r7 = tlydtdl.compose.foundation.lazy.layout.y.s
            boolean r7 = p5.k.b(r4, r7)
            if (r7 != 0) goto L70
            boolean r7 = p5.k.b(r4, r14)
            if (r7 != 0) goto L70
            long r4 = p5.k.c(r14, r4)
            t1.z r7 = r6.e
            if (r7 != 0) goto L42
            goto L70
        L42:
            tlydtdl.compose.runtime.n1 r8 = r6.q
            java.lang.Object r8 = r8.getValue()
            p5.k r8 = (p5.k) r8
            long r8 = r8.a
            long r8 = p5.k.c(r8, r4)
            r6.h(r8)
            r4 = 1
            r6.g(r4)
            r4 = r19
            r6.g = r4
            ky1.a0 r5 = r6.a
            r10 = r5
            a2.k3 r5 = new a2.k3
            r11 = r10
            r10 = 0
            r16 = r11
            r11 = 2
            r0 = r16
            r5.<init>(r6, r7, r8, r10, r11)
            r7 = 3
            r8 = 0
            ky1.c0.F(r0, r8, r8, r5, r7)
            goto L72
        L70:
            r4 = r19
        L72:
            r6.l = r14
            goto L77
        L75:
            r4 = r19
        L77:
            int r3 = r3 + 1
            r0 = r17
            r4 = r12
            goto L16
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.d0.g(tlydtdl.compose.foundation.lazy.layout.q0, boolean):void");
    }
}
