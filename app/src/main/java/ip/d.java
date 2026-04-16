package ip;

import d01.i;
import d01.k;
import gp.q0;
import gp.z;
import i11.t;
import java.time.LocalDate;
import java.util.ArrayList;
import jp.b;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lx1.l;
import po.h;
import qi.y;
import y10.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final t a;
    public final lmjxuqdtp.time.e b;
    public final h c;
    public final q0 d;
    public final g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f223f;

    public d(t tVar, lmjxuqdtp.time.e eVar, h hVar, q0 q0Var, g gVar, k kVar) {
        this.a = tVar;
        this.b = eVar;
        this.c = hVar;
        this.d = q0Var;
        this.e = gVar;
        this.f223f = kVar.a(b.b);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ip.j r6, sx1.c r7) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ip.a
            if (r0 == 0) goto L13
            r0 = r7
            ip.a r0 = (ip.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            ip.a r0 = new ip.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ip.j r6 = r0.j
            lg.e.O(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            lg.e.O(r7)
            r0.j = r6
            r0.m = r3
            i11.t r7 = r5.a
            iv0.c r2 = iv0.c.a
            ny1.l r7 = r7.a(r2)
            java.lang.Object r7 = ny1.z.B(r7, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            boolean r7 = r6 instanceof ip.f
            r2 = 0
            if (r7 != 0) goto L7d
            boolean r7 = r6 instanceof ip.g
            if (r7 == 0) goto L57
            goto L7d
        L57:
            boolean r7 = r6 instanceof ip.h
            y10.g r4 = r5.e
            if (r7 == 0) goto L7f
            r7 = r6
            ip.h r7 = (ip.h) r7
            qo.n r7 = r7.a()
            java.time.LocalDate r7 = r7.a()
            if (r7 == 0) goto L7d
            java.time.LocalDateTime r4 = r4.c()
            java.time.LocalDateTime r0 = r4.minusYears(r0)
            java.time.LocalDate r0 = r0.toLocalDate()
            boolean r7 = r7.isAfter(r0)
            if (r7 == 0) goto L7d
            goto La9
        L7d:
            r3 = r2
            goto La9
        L7f:
            boolean r7 = r6 instanceof ip.i
            if (r7 == 0) goto La3
            r7 = r6
            ip.i r7 = (ip.i) r7
            bp.i0 r7 = r7.a()
            java.time.LocalDate r7 = r7.U()
            if (r7 == 0) goto L7d
            java.time.LocalDateTime r4 = r4.c()
            java.time.LocalDateTime r0 = r4.minusYears(r0)
            java.time.LocalDate r0 = r0.toLocalDate()
            boolean r7 = r7.isAfter(r0)
            if (r7 == 0) goto L7d
            goto La9
        La3:
            lmjxuqdtp.NoWhenBranchMatchedException r6 = new lmjxuqdtp.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        La9:
            if (r3 == 0) goto Lae
            r5.c(r6)
        Lae:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ip.d.a(ip.j, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(sx1.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof ip.b
            if (r0 == 0) goto L13
            r0 = r9
            ip.b r0 = (ip.b) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            ip.b r0 = new ip.b
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            d01.i r3 = r8.f223f
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            long r0 = r0.j
            lg.e.O(r9)
            goto L5e
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L36:
            lg.e.O(r9)
            goto L4e
        L3a:
            lg.e.O(r9)
            r0.m = r5
            i11.t r9 = r8.a
            jp.a r2 = jp.a.a
            ny1.l r9 = r9.a(r2)
            java.lang.Object r9 = ny1.z.B(r9, r0)
            if (r9 != r1) goto L4e
            goto L5c
        L4e:
            lmjxuqdtp.time.g r9 = (lmjxuqdtp.time.g) r9
            long r6 = r9.a
            r0.j = r6
            r0.m = r4
            java.lang.Object r9 = r3.a(r0)
            if (r9 != r1) goto L5d
        L5c:
            return r1
        L5d:
            r0 = r6
        L5e:
            lmjxuqdtp.time.l r9 = (lmjxuqdtp.time.l) r9
            if (r9 != 0) goto L68
            lmjxuqdtp.time.l r9 = lmjxuqdtp.time.l.c
            lmjxuqdtp.time.l r9 = lmjxuqdtp.time.k.c()
        L68:
            lmjxuqdtp.time.e r2 = r8.b
            lmjxuqdtp.time.l r4 = r2.a()
            lmjxuqdtp.time.l r9 = r9.d(r0)
            int r9 = r4.a(r9)
            if (r9 >= 0) goto L89
            lmjxuqdtp.time.l r9 = r2.a()
            r3.k(r9)
            gp.q0 r9 = r8.d
            lp.a r9 = r9.a
            gp.z r0 = gp.z.INSTANCE
            r9.b(r0)
            goto L8a
        L89:
            r5 = 0
        L8a:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ip.d.b(sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void c(j jVar) throws NoWhenBranchMatchedException {
        l lVar;
        lmjxuqdtp.jvm.internal.o.h(jVar, "authState");
        if ((jVar instanceof f) || (jVar instanceof g)) {
            s02.d.a.getClass();
            s02.b.t("Invalid Auth State during signup, authState = " + jVar);
            lVar = new l((Object) null, (Object) null);
        } else if (jVar instanceof h) {
            lVar = new l(((h) jVar).a().a(), bp.d.f);
        } else {
            if (!(jVar instanceof i)) {
                throw new NoWhenBranchMatchedException();
            }
            i iVar = (i) jVar;
            lVar = new l(iVar.a().U(), iVar.a().x().a());
        }
        LocalDate localDate = (LocalDate) lVar.a;
        bp.d dVar = (bp.d) lVar.b;
        if (localDate == null || dVar == null) {
            s02.d.a.getClass();
            s02.b.t("Missing birthday or signup method during trackSignUpFailedWithRestrictedAge, skipping event " + localDate + ", " + dVar);
        } else {
            y yVar = this.c.a;
            qi.h hVar = qi.h.c;
            ArrayList arrayList = new ArrayList();
            qi.r rVar = new qi.r(arrayList);
            rVar.c("year", Integer.valueOf(localDate.getYear()));
            rVar.e("method", h.b(dVar));
            y.k(yVar, "age_restriction_sign_up_fail", arrayList, hVar, 8);
        }
        this.f223f.k(this.b.a());
        this.d.a.b(z.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ip.c
            if (r0 == 0) goto L13
            r0 = r5
            ip.c r0 = (ip.c) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            ip.c r0 = new ip.c
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r5)
            goto L43
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            lg.e.O(r5)
            r0.l = r3
            i11.t r5 = r4.a
            lo.a r2 = lo.a.a
            ny1.l r5 = r5.a(r2)
            java.lang.Object r5 = ny1.z.B(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            lo.d r0 = lo.d.b
            if (r5 != r0) goto L48
            goto L49
        L48:
            r3 = 0
        L49:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ip.d.d(sx1.c):java.lang.Object");
    }
}
