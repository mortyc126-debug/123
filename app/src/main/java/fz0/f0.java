package fz0;

import a2.n3;
import jv0.i0;
import n30.k;
import ny1.j2;
import ny1.r2;
import o10.a4;
import oz0.d1;
import st.w0;
import tlydtdl.lifecycle.i1;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {
    public final n3 a;
    public final wz0.y b;
    public final xu0.p c;
    public final p41.g d;
    public final dt.h e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p81.f f139f;
    public final tlydtdl.lifecycle.z g;
    public final ky1.a0 h;
    public final kd1.j i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qi.y f140j;
    public final i0 k;
    public final k l;
    public final k m;
    public final r2 n;
    public final k o;
    public final kd1.e p;
    public final boolean q;

    public f0(n3 n3Var, wz0.y yVar, xu0.p pVar, n0 n0Var, p41.g gVar, dt.h hVar, p81.f fVar, tlydtdl.lifecycle.z zVar, ky1.a0 a0Var, kd1.j jVar, qi.y yVar2, i0 i0Var) {
        this.a = n3Var;
        this.b = yVar;
        this.c = pVar;
        this.d = gVar;
        this.e = hVar;
        this.f139f = fVar;
        this.g = zVar;
        this.h = a0Var;
        this.i = jVar;
        this.f140j = yVar2;
        this.k = i0Var;
        this.l = w0.o0(ct1.b.F(gVar, a0Var, b()), new z(1));
        d1 d1VarB = b();
        lmjxuqdtp.jvm.internal.o.h(d1VarB, "postEntity");
        p41.i iVarY = ct1.b.Y(d1VarB);
        y41.j jVar2 = ((p41.j) gVar).a;
        p41.f fVarF = gVar.f(iVarY);
        k kVarO0 = w0.o0(fVarF == null ? ny1.z.c((Object) null) : ny1.z.R(dd.v.t(jVar2.c, new y41.a(fVarF)), a0Var, j2.a(3), (Object) null), new z(2));
        this.m = kVarO0;
        r2 r2VarC = ny1.z.c(z10.a.c);
        this.n = r2VarC;
        this.o = w0.o0(kVarO0, new dr0.j(9, this));
        this.p = new kd1.e("reactions_tooltip", com.ironsource.adqualitysdk.sdk.i.a0.v(x10.v.Companion, 2132018404));
        a4 a4Var = yVar.e;
        this.q = a4Var == a4.c || a4Var == a4.b || a4Var == a4.d;
        ny1.z.J(i1.f(zVar), ny1.z.K(new ah.o(this, (qx1.d) null, 22), z10.d.m(r2VarC)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(fz0.f0 r11, c51.j r12, sx1.c r13) {
        /*
            p41.g r0 = r11.d
            jv0.i0 r1 = r11.k
            n30.k r2 = r11.m
            boolean r3 = r13 instanceof fz0.e0
            if (r3 == 0) goto L1a
            r3 = r13
            fz0.e0 r3 = (fz0.e0) r3
            int r4 = r3.l
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L1a
            int r4 = r4 - r5
            r3.l = r4
        L18:
            r5 = r3
            goto L20
        L1a:
            fz0.e0 r3 = new fz0.e0
            r3.<init>(r11, r13)
            goto L18
        L20:
            java.lang.Object r13 = r5.j
            rx1.a r6 = rx1.a.a
            int r3 = r5.l
            r4 = 2
            r7 = 1
            r8 = 0
            lx1.b0 r9 = lx1.b0.a
            if (r3 == 0) goto L41
            if (r3 == r7) goto L31
            if (r3 != r4) goto L39
        L31:
            lg.e.O(r13)     // Catch: java.lang.Exception -> L35
            return r9
        L35:
            r0 = move-exception
            r12 = r0
            goto Lb3
        L39:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L41:
            lg.e.O(r13)
            java.lang.Object r13 = r2.getValue()
            if (r13 != r12) goto L4c
            goto Lb2
        L4c:
            java.lang.Object r13 = r2.getValue()     // Catch: java.lang.Exception -> L35
            c51.j r2 = c51.j.e     // Catch: java.lang.Exception -> L35
            if (r13 == r2) goto L76
            if (r12 == r2) goto L57
            goto L76
        L57:
            java.lang.String r12 = dd.v.D(r1)     // Catch: java.lang.Exception -> L35
            oz0.d1 r13 = r11.b()     // Catch: java.lang.Exception -> L35
            r5.l = r4     // Catch: java.lang.Exception -> L35
            co1.c r1 = new co1.c     // Catch: java.lang.Exception -> L35
            r2 = 2
            r1.<init>(r2)     // Catch: java.lang.Exception -> L35
            p41.i r13 = ct1.b.Y(r13)     // Catch: java.lang.Exception -> L35
            java.lang.Object r11 = r0.q(r12, r13, r1, r5)     // Catch: java.lang.Exception -> L35
            if (r11 != r6) goto L72
            goto L73
        L72:
            r11 = r9
        L73:
            if (r11 != r6) goto Lb2
            goto Lb1
        L76:
            a2.n3 r13 = r11.a     // Catch: java.lang.Exception -> L35
            r13.invoke()     // Catch: java.lang.Exception -> L35
            java.lang.String r1 = dd.v.D(r1)     // Catch: java.lang.Exception -> L35
            oz0.d1 r13 = r11.b()     // Catch: java.lang.Exception -> L35
            wz0.y r2 = r11.b     // Catch: java.lang.Exception -> L35
            o10.a4 r2 = r2.e     // Catch: java.lang.Exception -> L35
            oz0.d1 r3 = r11.b()     // Catch: java.lang.Exception -> L35
            java.lang.Integer r3 = r3.D     // Catch: java.lang.Exception -> L35
            o10.c4 r4 = o10.c4.a     // Catch: java.lang.Exception -> L35
            oz0.d1 r10 = r11.b()     // Catch: java.lang.Exception -> L35
            boolean r10 = com.facebook.appevents.p.W(r10)     // Catch: java.lang.Exception -> L35
            if (r10 == 0) goto L9b
        L99:
            r10 = r2
            goto L9d
        L9b:
            r4 = r8
            goto L99
        L9d:
            p41.i r2 = new p41.i     // Catch: java.lang.Exception -> L35
            r2.<init>(r13, r10, r3, r4)     // Catch: java.lang.Exception -> L35
            fs0.l r4 = new fs0.l     // Catch: java.lang.Exception -> L35
            r13 = 2
            r4.<init>(r13, r11)     // Catch: java.lang.Exception -> L35
            r5.l = r7     // Catch: java.lang.Exception -> L35
            r3 = r12
            java.lang.Object r11 = r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L35
            if (r11 != r6) goto Lb2
        Lb1:
            return r6
        Lb2:
            return r9
        Lb3:
            p81.f r11 = r11.f139f
            r13 = 14
            p81.f.f(r11, r12, r8, r13)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fz0.f0.a(fz0.f0, c51.j, sx1.c):java.lang.Object");
    }

    public final d1 b() {
        return this.b.a.a;
    }
}
