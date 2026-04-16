package b2;

import a2.x2;
import java.util.concurrent.CancellationException;
import lmjxuqdtp.jvm.functions.Function1;
import t1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final float a = 400;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(a2.x2 r10, float r11, t1.k r12, t1.u r13, lmjxuqdtp.jvm.functions.Function1 r14, sx1.c r15) {
        /*
            boolean r0 = r15 instanceof b2.k
            if (r0 == 0) goto L13
            r0 = r15
            b2.k r0 = (b2.k) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            b2.k r0 = new b2.k
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.m
            rx1.a r1 = rx1.a.a
            int r2 = r0.n
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            float r11 = r0.j
            lmjxuqdtp.jvm.internal.z r10 = r0.l
            t1.k r12 = r0.k
            lg.e.O(r15)
            goto L6a
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            lg.e.O(r15)
            lmjxuqdtp.jvm.internal.z r6 = new lmjxuqdtp.jvm.internal.z
            r6.<init>()
            java.lang.Object r15 = r12.b()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            r2 = 0
            int r15 = (r15 > r2 ? 1 : (r15 == r2 ? 0 : -1))
            if (r15 != 0) goto L4e
            r15 = r3
            goto L4f
        L4e:
            r15 = 0
        L4f:
            r15 = r15 ^ r3
            b2.i r4 = new b2.i
            r9 = 0
            r7 = r10
            r5 = r11
            r8 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            r0.k = r12
            r0.l = r6
            r0.j = r5
            r0.n = r3
            java.lang.Object r10 = t1.c.g(r12, r13, r15, r4, r0)
            if (r10 != r1) goto L68
            return r1
        L68:
            r11 = r5
            r10 = r6
        L6a:
            b2.a r13 = new b2.a
            float r10 = r10.a
            float r11 = r11 - r10
            java.lang.Float r10 = new java.lang.Float
            r10.<init>(r11)
            r13.<init>(r10, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.m.a(a2.x2, float, t1.k, t1.u, lmjxuqdtp.jvm.functions.Function1, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(a2.x2 r9, float r10, float r11, t1.k r12, t1.b1 r13, lmjxuqdtp.jvm.functions.Function1 r14, sx1.c r15) {
        /*
            boolean r0 = r15 instanceof b2.l
            if (r0 == 0) goto L14
            r0 = r15
            b2.l r0 = (b2.l) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.o = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            b2.l r0 = new b2.l
            r0.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r15 = r6.n
            rx1.a r0 = rx1.a.a
            int r1 = r6.o
            r7 = 0
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            float r9 = r6.k
            float r10 = r6.f16j
            lmjxuqdtp.jvm.internal.z r11 = r6.m
            t1.k r12 = r6.l
            lg.e.O(r15)
            goto L80
        L32:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3a:
            lg.e.O(r15)
            lmjxuqdtp.jvm.internal.z r15 = new lmjxuqdtp.jvm.internal.z
            r15.<init>()
            java.lang.Object r1 = r12.b()
            java.lang.Number r1 = (java.lang.Number) r1
            float r8 = r1.floatValue()
            r1 = r2
            java.lang.Float r2 = new java.lang.Float
            r2.<init>(r10)
            java.lang.Object r3 = r12.b()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 != 0) goto L62
            r3 = r1
            goto L63
        L62:
            r3 = 0
        L63:
            r4 = r3 ^ 1
            b2.j r5 = new b2.j
            r5.<init>(r11, r15, r9, r14)
            r6.l = r12
            r6.m = r15
            r6.f16j = r10
            r6.k = r8
            r6.o = r1
            r1 = r12
            r3 = r13
            java.lang.Object r9 = t1.c.i(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L7d
            return r0
        L7d:
            r11 = r15
            r12 = r1
            r9 = r8
        L80:
            java.lang.Object r13 = r12.b()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            float r9 = d(r13, r9)
            b2.a r13 = new b2.a
            float r11 = r11.a
            float r10 = r10 - r11
            java.lang.Float r11 = new java.lang.Float
            r11.<init>(r10)
            r10 = 29
            t1.k r9 = t1.c.n(r12, r7, r9, r10)
            r13.<init>(r11, r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.m.b(a2.x2, float, float, t1.k, t1.b1, lmjxuqdtp.jvm.functions.Function1, sx1.c):java.lang.Object");
    }

    public static final void c(i iVar, x2 x2Var, Function1 function1, float f2) {
        float f3;
        try {
            f3 = x2Var.f(f2);
        } catch (CancellationException unused) {
            iVar.a();
            f3 = 0.0f;
        }
        function1.invoke(Float.valueOf(f3));
        if (Math.abs(f2 - f3) > 0.5f) {
            iVar.a();
        }
    }

    public static final float d(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        return (f3 <= 0.0f ? f2 >= f3 : f2 <= f3) ? f2 : f3;
    }
}
