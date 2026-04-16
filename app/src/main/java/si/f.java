package si;

import com.braze.BrazeUser;
import dh1.w;
import f3.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public interface f {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object b(si.f r7, lmjxuqdtp.jvm.internal.k r8, d01.i r9, java.lang.String r10, sx1.c r11) {
        /*
            boolean r0 = r11 instanceof si.e
            if (r0 == 0) goto L13
            r0 = r11
            si.e r0 = (si.e) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            si.e r0 = new si.e
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L42
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r11)
            return r3
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.String r10 = r0.m
            d01.i r9 = r0.l
            lmjxuqdtp.jvm.internal.k r8 = r0.k
            b01.c r7 = r0.f462j
            si.f r7 = (si.f) r7
            lg.e.O(r11)
            goto L59
        L42:
            lg.e.O(r11)
            r11 = r7
            b01.c r11 = (b01.c) r11
            r0.f462j = r11
            r0.k = r8
            r0.l = r9
            r0.m = r10
            r0.p = r5
            java.lang.Object r11 = r9.a(r0)
            if (r11 != r1) goto L59
            goto L8f
        L59:
            java.lang.String r11 = (java.lang.String) r11
            boolean r11 = lmjxuqdtp.jvm.internal.o.c(r11, r10)
            if (r11 != 0) goto L90
            if (r10 == 0) goto L90
            s02.b r11 = s02.d.a
            java.lang.String r7 = r7.j()
            java.lang.String r2 = "("
            java.lang.String r5 = ")"
            java.lang.String r6 = "Setting Braze property "
            java.lang.String r7 = z.p.f(r6, r7, r2, r10, r5)
            r11.getClass()
            s02.b.p(r7)
            lmjxuqdtp.jvm.functions.Function1 r8 = (lmjxuqdtp.jvm.functions.Function1) r8
            r8.invoke(r10)
            r7 = 0
            r0.f462j = r7
            r0.k = r7
            r0.l = r7
            r0.m = r7
            r0.p = r4
            java.lang.Object r7 = r9.j(r10, r0)
            if (r7 != r1) goto L90
        L8f:
            return r1
        L90:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: si.f.b(si.f, lmjxuqdtp.jvm.internal.k, d01.i, java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object c(si.h r10, my1.e r11, d01.i r12, java.lang.String r13, sx1.c r14) {
        /*
            boolean r0 = r14 instanceof si.c
            if (r0 == 0) goto L13
            r0 = r14
            si.c r0 = (si.c) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            si.c r0 = new si.c
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            r3 = 2
            lx1.b0 r4 = lx1.b0.a
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L34
            if (r2 != r3) goto L2c
            lg.e.O(r14)
            return r4
        L2c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            java.lang.String r13 = r0.m
            d01.i r12 = r0.l
            my1.e r11 = r0.k
            si.h r10 = r0.f460j
            lg.e.O(r14)
            goto L54
        L40:
            lg.e.O(r14)
            r0.f460j = r10
            r0.k = r11
            r0.l = r12
            r0.m = r13
            r0.p = r5
            java.lang.Object r14 = r12.a(r0)
            if (r14 != r1) goto L54
            goto Lb6
        L54:
            java.lang.String r14 = (java.lang.String) r14
            boolean r14 = lmjxuqdtp.jvm.internal.o.c(r14, r13)
            if (r14 != 0) goto Lb7
            if (r13 == 0) goto Lb7
            r14 = 0
            java.time.LocalDate r2 = java.time.LocalDate.parse(r13)     // Catch: java.lang.Exception -> L64
            goto L6b
        L64:
            r2 = move-exception
            s02.b r6 = s02.d.a
            r6.e(r2)
            r2 = r14
        L6b:
            if (r2 == 0) goto Lb7
            s02.b r6 = s02.d.a
            java.lang.String r10 = r10.j()
            java.lang.String r7 = "("
            java.lang.String r8 = ")"
            java.lang.String r9 = "Setting Braze property "
            java.lang.String r10 = z.p.f(r9, r10, r7, r13, r8)
            r6.getClass()
            s02.b.p(r10)
            com.braze.enums.Month$Companion r10 = com.braze.enums.Month.Companion
            int r6 = r2.getMonthValue()
            int r6 = r6 - r5
            com.braze.enums.Month r10 = r10.getMonth(r6)
            if (r10 != 0) goto L91
            goto Lb7
        L91:
            int r5 = r2.getYear()
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            int r2 = r2.getDayOfMonth()
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r2)
            r11.invoke(r6, r10, r5)
            r0.f460j = r14
            r0.k = r14
            r0.l = r14
            r0.m = r14
            r0.p = r3
            java.lang.Object r10 = r12.j(r13, r0)
            if (r10 != r1) goto Lb7
        Lb6:
            return r1
        Lb7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: si.f.c(si.h, my1.e, d01.i, java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object e(si.l r8, k80.t r9, d01.i r10, dh1.k r11, sx1.c r12) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            boolean r0 = r12 instanceof si.d
            if (r0 == 0) goto L13
            r0 = r12
            si.d r0 = (si.d) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            si.d r0 = new si.d
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r8 = r0.m
            rx1.a r12 = rx1.a.a
            int r1 = r0.o
            lx1.b0 r2 = lx1.b0.a
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L41
            if (r1 == r4) goto L35
            if (r1 != r3) goto L2d
            lg.e.O(r8)
            return r2
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            dh1.k r11 = r0.l
            d01.i r10 = r0.k
            k80.t r9 = r0.f461j
            lg.e.O(r8)     // Catch: java.lang.Exception -> L3f
            goto L53
        L3f:
            r8 = move-exception
            goto L5c
        L41:
            lg.e.O(r8)
            r0.f461j = r9     // Catch: java.lang.Exception -> L3f
            r0.k = r10     // Catch: java.lang.Exception -> L3f
            r0.l = r11     // Catch: java.lang.Exception -> L3f
            r0.o = r4     // Catch: java.lang.Exception -> L3f
            java.lang.Object r8 = r10.a(r0)     // Catch: java.lang.Exception -> L3f
            if (r8 != r12) goto L53
            goto Lbd
        L53:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L3f
            if (r8 == 0) goto L61
            dh1.k r8 = dh1.k.valueOf(r8)     // Catch: java.lang.Exception -> L3f
            goto L62
        L5c:
            s02.b r1 = s02.d.a
            r1.e(r8)
        L61:
            r8 = r5
        L62:
            if (r8 == r11) goto Lbe
            if (r11 == 0) goto Lbe
            s02.b r8 = s02.d.a
            si.l r1 = si.l.c
            r1.getClass()
            java.lang.String r1 = si.l.e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Setting Braze property "
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r1 = "("
            r6.append(r1)
            r6.append(r11)
            java.lang.String r1 = ")"
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r8.getClass()
            s02.b.p(r1)
            int r8 = r11.ordinal()
            if (r8 == 0) goto La6
            if (r8 == r4) goto La3
            if (r8 != r3) goto L9d
            com.braze.enums.Gender r8 = com.braze.enums.Gender.FEMALE
            goto La8
        L9d:
            lmjxuqdtp.NoWhenBranchMatchedException r8 = new lmjxuqdtp.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        La3:
            com.braze.enums.Gender r8 = com.braze.enums.Gender.MALE
            goto La8
        La6:
            com.braze.enums.Gender r8 = com.braze.enums.Gender.OTHER
        La8:
            r9.invoke(r8)
            java.lang.String r8 = r11.name()
            r0.f461j = r5
            r0.k = r5
            r0.l = r5
            r0.o = r3
            java.lang.Object r8 = r10.j(r8, r0)
            if (r8 != r12) goto Lbe
        Lbd:
            return r12
        Lbe:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: si.f.e(si.l, k80.t, d01.i, dh1.k, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object h(si.f r8, com.braze.BrazeUser r9, d01.i r10, java.lang.String r11, sx1.c r12) {
        /*
            boolean r0 = r12 instanceof si.b
            if (r0 == 0) goto L13
            r0 = r12
            si.b r0 = (si.b) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            si.b r0 = new si.b
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L42
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r12)
            return r3
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.String r11 = r0.m
            d01.i r10 = r0.l
            com.braze.BrazeUser r9 = r0.k
            b01.c r8 = r0.f459j
            si.f r8 = (si.f) r8
            lg.e.O(r12)
            goto L59
        L42:
            lg.e.O(r12)
            r12 = r8
            b01.c r12 = (b01.c) r12
            r0.f459j = r12
            r0.k = r9
            r0.l = r10
            r0.m = r11
            r0.p = r5
            java.lang.Object r12 = r10.a(r0)
            if (r12 != r1) goto L59
            goto L91
        L59:
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = lmjxuqdtp.jvm.internal.o.c(r12, r11)
            if (r12 != 0) goto L92
            if (r11 == 0) goto L92
            s02.b r12 = s02.d.a
            java.lang.String r2 = r8.j()
            java.lang.String r5 = "("
            java.lang.String r6 = ")"
            java.lang.String r7 = "Setting Braze property "
            java.lang.String r2 = z.p.f(r7, r2, r5, r11, r6)
            r12.getClass()
            s02.b.p(r2)
            java.lang.String r8 = r8.j()
            r9.setCustomUserAttribute(r8, r11)
            r8 = 0
            r0.f459j = r8
            r0.k = r8
            r0.l = r8
            r0.m = r8
            r0.p = r4
            java.lang.Object r8 = r10.j(r11, r0)
            if (r8 != r1) goto L92
        L91:
            return r1
        L92:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: si.f.h(si.f, com.braze.BrazeUser, d01.i, java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.Object m(si.i r7, com.braze.BrazeUser r8, d01.i r9, java.lang.Boolean r10, sx1.c r11) {
        /*
            boolean r0 = r11 instanceof si.a
            if (r0 == 0) goto L13
            r0 = r11
            si.a r0 = (si.a) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            si.a r0 = new si.a
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r11)
            return r3
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Boolean r10 = r0.m
            d01.i r9 = r0.l
            com.braze.BrazeUser r8 = r0.k
            si.i r7 = r0.f458j
            lg.e.O(r11)
            goto L54
        L40:
            lg.e.O(r11)
            r0.f458j = r7
            r0.k = r8
            r0.l = r9
            r0.m = r10
            r0.p = r5
            java.lang.Object r11 = r9.a(r0)
            if (r11 != r1) goto L54
            goto La4
        L54:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            r11.getClass()
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto La5
            if (r10 == 0) goto La5
            s02.b r11 = s02.d.a
            java.lang.String r2 = r7.j()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Setting Braze custom boolean property "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = "("
            r5.append(r2)
            r5.append(r10)
            java.lang.String r2 = ")"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r11.getClass()
            s02.b.p(r2)
            java.lang.String r7 = r7.j()
            boolean r11 = r10.booleanValue()
            r8.setCustomUserAttribute(r7, r11)
            r7 = 0
            r0.f458j = r7
            r0.k = r7
            r0.l = r7
            r0.m = r7
            r0.p = r4
            java.lang.Object r7 = r9.j(r10, r0)
            if (r7 != r1) goto La5
        La4:
            return r1
        La5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: si.f.m(si.i, com.braze.BrazeUser, d01.i, java.lang.Boolean, sx1.c):java.lang.Object");
    }

    default String d() {
        return f2.k("braze_cache_", j());
    }

    default String i() {
        return f2.k("Current value for Braze ", d());
    }

    String j();

    Object l(BrazeUser brazeUser, w wVar, d01.k kVar, qi.o oVar);
}
