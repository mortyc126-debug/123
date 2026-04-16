package nv0;

import amuvvoafs.content.Intent;
import bj0.d0;
import d01.i;
import lmjxuqdtp.jvm.internal.o;
import zs.k0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public final l a;
    public final d01.k b;
    public final k0 c;

    public g(l lVar, d01.k kVar, k0 k0Var) {
        this.a = lVar;
        this.b = kVar;
        this.c = k0Var;
    }

    public final void a(Intent intent) {
        String stringExtra;
        o.h(intent, "intent");
        if (!intent.getBooleanExtra("FROM_NOTIFICATION", false) || (stringExtra = intent.getStringExtra("NOTIFICATION_GROUP")) == null) {
            return;
        }
        d(stringExtra).k((Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(amuvvoafs.content.Context r6, lv0.x r7, java.lang.String r8, sx1.c r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof nv0.d
            if (r0 == 0) goto L13
            r0 = r9
            nv0.d r0 = (nv0.d) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            nv0.d r0 = new nv0.d
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.m
            rx1.a r1 = rx1.a.a
            int r2 = r0.o
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.String r6 = r0.l
            java.lang.String r7 = r0.k
            lv0.x r8 = r0.j
            lg.e.O(r9)
            goto L6b
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            lg.e.O(r9)
            lv0.h r9 = r7.e()
            if (r9 == 0) goto L43
            java.lang.String r9 = r9.toString()
            goto L44
        L43:
            r9 = 0
        L44:
            x10.v r2 = r7.f()
            java.lang.String r6 = x10.a.n(r6, r2)
            if (r9 != 0) goto L54
            nv0.j r9 = new nv0.j
            r9.<init>(r8, r6)
            goto L75
        L54:
            d01.i r8 = r5.d(r9)
            r0.j = r7
            r0.k = r9
            r0.l = r6
            r0.o = r3
            java.lang.Object r8 = r8.a(r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            r4 = r8
            r8 = r7
            r7 = r9
            r9 = r4
        L6b:
            nv0.j r9 = (nv0.j) r9
            if (r9 != 0) goto L74
            nv0.j r9 = new nv0.j
            r9.<init>(r7, r6)
        L74:
            r7 = r8
        L75:
            java.lang.String r6 = r7.a()
            if (r6 == 0) goto L8f
            java.util.List r7 = r9.b()
            if (r7 != 0) goto L83
            mx1.t r7 = mx1.t.a
        L83:
            java.util.ArrayList r7 = mx1.o.o1(r7)
            r7.add(r6)
            nv0.j r6 = nv0.j.a(r9, r7)
            return r6
        L8f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: nv0.g.b(amuvvoafs.content.Context, lv0.x, java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r5, sx1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof nv0.e
            if (r0 == 0) goto L13
            r0 = r6
            nv0.e r0 = (nv0.e) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            nv0.e r0 = new nv0.e
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r6)
            goto L3f
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            lg.e.O(r6)
            d01.i r5 = r4.d(r5)
            r0.l = r3
            java.lang.Object r6 = r5.a(r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            nv0.j r6 = (nv0.j) r6
            if (r6 == 0) goto L4b
            boolean r5 = r6.d()
            if (r5 == 0) goto L4a
            goto L4b
        L4a:
            r3 = 0
        L4b:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: nv0.g.c(java.lang.String, sx1.c):java.lang.Object");
    }

    public final i d(String str) {
        l lVar = this.a;
        o.h(str, "event");
        return this.b.a(new d0(str, (vb0.a) lVar.a.a.invoke()));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(lv0.x r5, sx1.c r6) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof nv0.f
            if (r0 == 0) goto L13
            r0 = r6
            nv0.f r0 = (nv0.f) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            nv0.f r0 = new nv0.f
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lv0.h r5 = r0.j
            lg.e.O(r6)
            goto L49
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            lg.e.O(r6)
            lv0.h r5 = r5.e()
            if (r5 == 0) goto L6f
            java.lang.String r6 = r5.toString()
            r0.j = r5
            r0.m = r3
            java.lang.Object r6 = r4.c(r6, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L6f
            int r5 = r5.ordinal()
            if (r5 == 0) goto L62
            if (r5 != r3) goto L5c
            lv0.v r5 = lv0.v.b
            goto L64
        L5c:
            lmjxuqdtp.NoWhenBranchMatchedException r5 = new lmjxuqdtp.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L62:
            lv0.v r5 = lv0.v.a
        L64:
            zs.k0 r6 = r4.c
            xu0.l r5 = zs.k0.b(r6, r5)
            amuvvoafs.content.Intent r5 = aq1.b.N(r5)
            return r5
        L6f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: nv0.g.e(lv0.x, sx1.c):java.lang.Object");
    }
}
