package ye;

import iz1.i;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final i a;

    public /* synthetic */ b(i iVar) {
        this.a = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(iz1.i r8, ve.p r9, o7.c r10, sx1.c r11) {
        /*
            boolean r0 = r11 instanceof ye.a
            if (r0 == 0) goto L13
            r0 = r11
            ye.a r0 = (ye.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            ye.a r0 = new ye.a
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L4e
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r8 = r0.k
            java.io.Closeable r8 = (java.io.Closeable) r8
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L33
            goto La3
        L33:
            r9 = move-exception
            goto Lab
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            lmjxuqdtp.jvm.functions.Function2 r8 = r0.f712j
            lg.e.O(r11)
            goto L8b
        L44:
            java.lang.Object r8 = r0.k
            iz1.i r8 = (iz1.i) r8
            lmjxuqdtp.jvm.functions.Function2 r10 = r0.f712j
            lg.e.O(r11)
            goto L5e
        L4e:
            lg.e.O(r11)
            r0.f712j = r10
            r0.k = r8
            r0.m = r5
            iz1.l0 r11 = bn1.c.h(r9, r0)
            if (r11 != r1) goto L5e
            goto La1
        L5e:
            iz1.l0 r11 = (iz1.l0) r11
            nz1.n r8 = r8.a(r11)
            r0.f712j = r10
            r0.k = r6
            r0.m = r4
            ky1.m r9 = new ky1.m
            qx1.d r11 = di0.z.C(r0)
            r9.<init>(r5, r11)
            r9.s()
            m2.y0 r11 = new m2.y0
            r2 = 8
            r11.<init>(r2, r8, r9)
            r8.e(r11)
            r9.v(r11)
            java.lang.Object r11 = r9.q()
            if (r11 != r1) goto L8a
            goto La1
        L8a:
            r8 = r10
        L8b:
            r9 = r11
            java.io.Closeable r9 = (java.io.Closeable) r9
            r10 = r9
            iz1.q0 r10 = (iz1.q0) r10     // Catch: java.lang.Throwable -> La7
            ve.q r10 = bn1.c.g(r10)     // Catch: java.lang.Throwable -> La7
            r0.f712j = r6     // Catch: java.lang.Throwable -> La7
            r0.k = r9     // Catch: java.lang.Throwable -> La7
            r0.m = r3     // Catch: java.lang.Throwable -> La7
            java.lang.Object r11 = r8.invoke(r10, r0)     // Catch: java.lang.Throwable -> La7
            if (r11 != r1) goto La2
        La1:
            return r1
        La2:
            r8 = r9
        La3:
            mu0.u.j(r8, r6)
            return r11
        La7:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        Lab:
            throw r9     // Catch: java.lang.Throwable -> Lac
        Lac:
            r10 = move-exception
            mu0.u.j(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.b.a(iz1.i, ve.p, o7.c, sx1.c):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return o.c(this.a, ((b) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "CallFactoryNetworkClient(callFactory=" + this.a + ')';
    }
}
