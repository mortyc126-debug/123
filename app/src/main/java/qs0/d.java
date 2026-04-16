package qs0;

import jx0.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final h a;
    public final kn0.b b;
    public final fy.a c;
    public final fj1.a d;

    public d(h hVar, kn0.b bVar, fy.a aVar, fj1.a aVar2) {
        this.a = hVar;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof qs0.b
            if (r0 == 0) goto L13
            r0 = r5
            qs0.b r0 = (qs0.b) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            qs0.b r0 = new qs0.b
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f389j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r5)
            goto L3f
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            lg.e.O(r5)
            r0.l = r3
            fj1.a r5 = r4.d
            gj1.d r5 = (gj1.d) r5
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r5 = r5 ^ r3
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qs0.d.a(sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[PHI: r2
  0x007e: PHI (r2v4 rs0.j) = (r2v3 rs0.j), (r2v7 rs0.j) binds: [B:30:0x007b, B:18:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(sx1.c r9) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            r8 = this;
            boolean r0 = r9 instanceof qs0.c
            if (r0 == 0) goto L13
            r0 = r9
            qs0.c r0 = (qs0.c) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            qs0.c r0 = new qs0.c
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            lx1.b0 r3 = lx1.b0.a
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L48
            if (r2 == r7) goto L44
            if (r2 == r6) goto L40
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            lg.e.O(r9)
            return r3
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3a:
            rs0.j r2 = r0.f390j
            lg.e.O(r9)
            goto L7e
        L40:
            lg.e.O(r9)
            goto L6c
        L44:
            lg.e.O(r9)
            goto L54
        L48:
            lg.e.O(r9)
            r0.m = r7
            java.lang.Object r9 = r8.a(r0)
            if (r9 != r1) goto L54
            goto L93
        L54:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lc6
            gm.t r9 = new gm.t
            r9.<init>()
            r0.m = r6
            kn0.b r2 = r8.b
            java.lang.Object r9 = r2.a(r9, r0)
            if (r9 != r1) goto L6c
            goto L93
        L6c:
            r2 = r9
            rs0.j r2 = (rs0.j) r2
            r0.f390j = r2
            r0.m = r5
            fj1.a r9 = r8.d
            gj1.d r9 = (gj1.d) r9
            java.lang.Object r9 = r9.a(r0)
            if (r9 != r1) goto L7e
            goto L93
        L7e:
            rs0.i r9 = rs0.i.a
            boolean r9 = lmjxuqdtp.jvm.internal.o.c(r2, r9)
            if (r9 == 0) goto L94
            r9 = 0
            r0.f390j = r9
            r0.m = r4
            jx0.h r9 = r8.a
            java.lang.Object r9 = r9.G(r0)
            if (r9 != r1) goto Lc6
        L93:
            return r1
        L94:
            rs0.g r9 = rs0.g.a
            boolean r9 = lmjxuqdtp.jvm.internal.o.c(r2, r9)
            if (r9 == 0) goto Lb7
            fy.a r9 = r8.c
            qi.y r9 = r9.a
            oq.n r0 = new oq.n
            r1 = 27
            qs0.f r2 = qs0.f.a
            r0.<init>(r1, r2)
            java.util.ArrayList r0 = m8.d.o(r0)
            qi.h r1 = qi.h.c
            r2 = 8
            java.lang.String r4 = "studio_guided_onboarding_finish"
            qi.y.k(r9, r4, r0, r1, r2)
            return r3
        Lb7:
            rs0.h r9 = rs0.h.a
            boolean r9 = lmjxuqdtp.jvm.internal.o.c(r2, r9)
            if (r9 == 0) goto Lc0
            goto Lc6
        Lc0:
            lmjxuqdtp.NoWhenBranchMatchedException r9 = new lmjxuqdtp.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        Lc6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: qs0.d.b(sx1.c):java.lang.Object");
    }
}
