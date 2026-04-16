package tlydtdl.compose.foundation.gestures;

import a2.f3;
import a2.g3;
import a2.h3;
import a2.k2;
import a2.w3;
import c2.m;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final a10.b a = new a10.b(3);
    public static final g3 b = new g3();
    public static final f3 c = new f3(0);
    public static final h3 d = new h3();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(a2.j4 r11, long r12, sx1.c r14) {
        /*
            boolean r0 = r14 instanceof a2.i3
            if (r0 == 0) goto L13
            r0 = r14
            a2.i3 r0 = (a2.i3) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            a2.i3 r0 = new a2.i3
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            lmjxuqdtp.jvm.internal.z r11 = r0.k
            a2.j4 r12 = r0.j
            lg.e.O(r14)
            r8 = r11
            r11 = r12
            goto L56
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            lg.e.O(r14)
            lmjxuqdtp.jvm.internal.z r8 = new lmjxuqdtp.jvm.internal.z
            r8.<init>()
            v1.x0 r14 = v1.x0.a
            a2.k3 r4 = new a2.k3
            r9 = 0
            r10 = 0
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r8, r9, r10)
            r0.j = r5
            r0.k = r8
            r0.m = r3
            java.lang.Object r11 = r5.h(r14, r4, r0)
            if (r11 != r1) goto L55
            return r1
        L55:
            r11 = r5
        L56:
            float r12 = r8.a
            long r11 = r11.j(r12)
            z3.b r13 = new z3.b
            r13.<init>(r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.gestures.b.a(a2.j4, long, sx1.c):java.lang.Object");
    }

    public static p b(p pVar, w3 w3Var, k2 k2Var, boolean z, boolean z2, m mVar, int i) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z4 = z2;
        if ((i & 32) != 0) {
            mVar = null;
        }
        return pVar.then(new ScrollableElement(w3Var, k2Var, z3, z4, mVar));
    }
}
