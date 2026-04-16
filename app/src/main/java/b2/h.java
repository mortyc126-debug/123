package b2;

import a2.f3;
import a2.v4;
import lmjxuqdtp.jvm.internal.o;
import t1.b1;
import t1.u;
import tlydtdl.compose.foundation.gestures.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements v4 {
    public final n a;
    public final u b;
    public final b1 c;
    public final f3 d = b.c;

    public h(n nVar, u uVar, b1 b1Var) {
        this.a = nVar;
        this.b = uVar;
        this.c = b1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(b2.h r4, a2.x2 r5, float r6, float r7, b2.e r8, sx1.c r9) {
        /*
            boolean r0 = r9 instanceof b2.g
            if (r0 == 0) goto L14
            r0 = r9
            b2.g r0 = (b2.g) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.l = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            b2.g r0 = new b2.g
            r0.<init>(r4, r9)
            goto L12
        L1a:
            java.lang.Object r0 = r9.f15j
            rx1.a r1 = rx1.a.a
            int r2 = r9.l
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lg.e.O(r0)
            goto L87
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            lg.e.O(r0)
            float r0 = java.lang.Math.abs(r6)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L3e
            goto L46
        L3e:
            float r0 = java.lang.Math.abs(r7)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L4d
        L46:
            r4 = 28
            t1.k r4 = t1.c.b(r6, r7, r4)
            return r4
        L4d:
            r9.l = r3
            t1.u r0 = r4.b
            float r2 = t1.c.l(r0, r2, r7)
            float r2 = java.lang.Math.abs(r2)
            float r3 = java.lang.Math.abs(r6)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L6a
            fp1.i r4 = new fp1.i
            r2 = 10
            r4.<init>(r2, r0)
        L68:
            r0 = r6
            goto L75
        L6a:
            a0.o r0 = new a0.o
            t1.b1 r4 = r4.c
            r2 = 9
            r0.<init>(r2, r4)
            r4 = r0
            goto L68
        L75:
            java.lang.Float r6 = new java.lang.Float
            r6.<init>(r0)
            r0 = r7
            java.lang.Float r7 = new java.lang.Float
            r7.<init>(r0)
            java.lang.Object r0 = r4.w(r5, r6, r7, r8, r9)
            if (r0 != r1) goto L87
            return r1
        L87:
            b2.a r0 = (b2.a) r0
            t1.k r4 = r0.b
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.h.c(b2.h, a2.x2, float, float, b2.e, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(a2.x2 r5, float r6, lmjxuqdtp.jvm.functions.Function1 r7, sx1.c r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof b2.f
            if (r0 == 0) goto L13
            r0 = r8
            b2.f r0 = (b2.f) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            b2.f r0 = new b2.f
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f14j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r8)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            lg.e.O(r8)
            r0.l = r3
            java.lang.Object r8 = r4.d(r5, r6, r7, r0)
            if (r8 != r1) goto L3b
            return r1
        L3b:
            b2.a r8 = (b2.a) r8
            java.lang.Float r5 = r8.a
            float r5 = r5.floatValue()
            t1.k r6 = r8.b
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L4b
            goto L55
        L4b:
            java.lang.Object r5 = r6.b()
            java.lang.Number r5 = (java.lang.Number) r5
            float r7 = r5.floatValue()
        L55:
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.h.b(a2.x2, float, lmjxuqdtp.jvm.functions.Function1, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(a2.x2 r11, float r12, lmjxuqdtp.jvm.functions.Function1 r13, sx1.c r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof b2.d
            if (r0 == 0) goto L13
            r0 = r14
            b2.d r0 = (b2.d) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            b2.d r0 = new b2.d
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            lmjxuqdtp.jvm.functions.Function1 r13 = r0.f13j
            lg.e.O(r14)
            r5 = r10
            goto L4d
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L32:
            lg.e.O(r14)
            a2.r r4 = new a2.r
            r9 = 0
            r5 = r10
            r8 = r11
            r6 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f13j = r7
            r0.m = r3
            a2.f3 r11 = r5.d
            java.lang.Object r14 = ky1.c0.R(r11, r4, r0)
            if (r14 != r1) goto L4c
            return r1
        L4c:
            r13 = r7
        L4d:
            b2.a r14 = (b2.a) r14
            r11 = 0
            i.w(r11, r13)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.h.d(a2.x2, float, lmjxuqdtp.jvm.functions.Function1, sx1.c):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.c.equals(this.c) && o.c(hVar.b, this.b) && o.c(hVar.a, this.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + ((this.b.hashCode() + (this.c.hashCode() * 31)) * 31);
    }
}
