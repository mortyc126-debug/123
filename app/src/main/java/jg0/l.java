package jg0;

import a21.t;
import a21.u;
import ak.p0;
import ak.q0;
import ak.s0;
import com.ironsource.adqualitysdk.sdk.i.a0;
import hw.q;
import java.util.ArrayList;
import kd1.e;
import ky1.b0;
import ky1.c0;
import ky1.t1;
import lmjxuqdtp.jvm.internal.o;
import ny1.b2;
import ny1.j2;
import ny1.r2;
import p81.f;
import qi.h;
import qi.r;
import qi.y;
import qx1.i;
import s02.d;
import sd.g;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.z;
import x10.v;
import xu0.p;
import y11.d2;
import yp.s;
import zi.c;
import zj.n;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final n a;
    public final z b;
    public final c c;
    public final fy.a d;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f236f;
    public final p g;
    public final q h;
    public final kd1.j i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f237j;
    public final r2 k;
    public final b2 l;
    public final r2 m;
    public final e n;

    public l(n nVar, z zVar, c cVar, fy.a aVar, f fVar, j0 j0Var, p pVar, q qVar, kd1.j jVar, sh0.c cVar2) {
        this.a = nVar;
        this.b = zVar;
        this.c = cVar;
        this.d = aVar;
        this.e = fVar;
        this.f236f = j0Var;
        this.g = pVar;
        this.h = qVar;
        this.i = jVar;
        s sVar = nVar.i;
        this.f237j = sVar;
        r2 r2VarC = ny1.z.c(Boolean.FALSE);
        this.k = r2VarC;
        s sVar2 = sVar;
        this.l = ny1.z.R(ny1.z.m(r2VarC, sVar2.s, sVar2.E, new j(this, null, 0)), i1.f(zVar), j2.a(3), (Object) null);
        this.m = ny1.z.c((Object) null);
        this.n = new e("autobeat_tap_to_unselect", a0.v(v.Companion, 2132020347));
    }

    public static final void a(l lVar) {
        lVar.g.e(lVar.f236f.b("smart_tools_layer", lx0.b.INSTANCE));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(jg0.l r10, sx1.c r11) {
        /*
            p81.f r0 = r10.e
            zj.n r1 = r10.a
            boolean r2 = r11 instanceof jg0.k
            if (r2 == 0) goto L17
            r2 = r11
            jg0.k r2 = (jg0.k) r2
            int r3 = r2.l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.l = r3
            goto L1c
        L17:
            jg0.k r2 = new jg0.k
            r2.<init>(r10, r11)
        L1c:
            java.lang.Object r11 = r2.j
            rx1.a r3 = rx1.a.a
            int r4 = r2.l
            r5 = 1
            if (r4 == 0) goto L33
            if (r4 != r5) goto L2b
            lg.e.O(r11)
            goto L77
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            lg.e.O(r11)
            zj.v1 r11 = r1.a
            ny1.r2 r1 = r11.x
            java.lang.Object r1 = r1.getValue()
            a21.e r1 = (a21.e) r1
            int r4 = lmjxuqdtp.time.g.d
            java.util.ArrayList r4 = r1.e()
            java.lang.Object r4 = mx1.o.w0(r4)
            a21.c r4 = (a21.c) r4
            double r6 = r4.o
            lmjxuqdtp.time.i r4 = lmjxuqdtp.time.i.e
            long r6 = lmjxuqdtp.time.n.r(r6, r4)
            y11.d2 r1 = r1.g
            int r1 = r1.a
            double r6 = cn1.j.x(r1, r6)
            r8 = 4629700416936869888(0x4040000000000000, double:32.0)
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 > 0) goto L88
            r2.l = r5
            ak.s0 r10 = r10.f237j
            ny1.r2 r11 = r11.x
            java.lang.Object r11 = r11.getValue()
            a21.e r11 = (a21.e) r11
            yp.s r10 = (yp.s) r10
            java.lang.Object r11 = r10.m(r11, r2)
            if (r11 != r3) goto L77
            return r3
        L77:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r10 = r11.booleanValue()
            if (r10 != 0) goto L9e
            r10 = 2132017268(0x7f140074, float:1.967281E38)
            r0.j(r10)
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        L88:
            x10.c r10 = x10.v.Companion
            java.lang.String r11 = "32"
            java.lang.String[] r11 = new java.lang.String[]{r11}
            r10.getClass()
            r10 = 2132019213(0x7f14080d, float:1.9676755E38)
            x10.u r10 = x10.c.g(r11, r10)
            r0.l(r10)
            r5 = 0
        L9e:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: jg0.l.b(jg0.l, sx1.c):java.lang.Object");
    }

    public final p0 c() {
        Object value = this.f237j.s.getValue();
        q0 q0Var = value instanceof q0 ? (q0) value : null;
        if (q0Var != null) {
            return q0Var.c();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(sx1.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof jg0.e
            if (r0 == 0) goto L13
            r0 = r6
            jg0.e r0 = (jg0.e) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            jg0.e r0 = new jg0.e
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            ak.s0 r3 = r5.f237j
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 != r4) goto L29
            lg.e.O(r6)
            goto L50
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            lg.e.O(r6)
            jv0.q r6 = jv0.q.b
            hw.q r2 = r5.h
            boolean r6 = r2.g(r6)
            if (r6 != 0) goto L71
            r0.l = r4
            r6 = r3
            yp.s r6 = (yp.s) r6
            vt1.b r6 = r6.o
            java.lang.Object r6 = r6.h
            ny1.a2 r6 = (ny1.a2) r6
            java.lang.Object r6 = ny1.z.B(r6, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r0 = 0
            if (r6 == 0) goto L70
            yp.s r3 = (yp.s) r3
            ny1.b2 r6 = r3.E
            ny1.p2 r6 = r6.a
            java.lang.Object r6 = r6.getValue()
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L6c
            int r6 = r6.intValue()
            goto L6d
        L6c:
            r6 = r0
        L6d:
            if (r6 <= 0) goto L70
            goto L71
        L70:
            r4 = r0
        L71:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jg0.l.d(sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof jg0.i
            if (r0 == 0) goto L13
            r0 = r5
            jg0.i r0 = (jg0.i) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            jg0.i r0 = new jg0.i
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r5)
            goto L3b
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            lg.e.O(r5)
            r0.l = r3
            java.lang.Object r5 = r4.d(r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r5 = r5 ^ r3
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jg0.l.e(sx1.c):java.lang.Object");
    }

    public final void f() {
        s02.b bVar = d.a;
        String str = "AB:: " + hashCode() + " - start autobeat controller!";
        bVar.getClass();
        s02.b.t(str);
        s sVar = this.f237j;
        sVar.a.e();
        a21.e eVar = (a21.e) this.a.a.x.getValue();
        c cVar = this.c;
        String strD = cVar.d(2132017267);
        String strD2 = cVar.d(2132017265);
        String strD3 = cVar.d(2132017266);
        o.h(eVar, "rev");
        t1 t1Var = sVar.x;
        if (t1Var != null) {
            c0.l("new auto-beat start requested", t1Var);
        }
        sVar.x = c0.F(sVar.d, (i) null, (b0) null, new g(sVar, eVar, strD, strD2, strD3, (qx1.d) null, 9), 3);
        d2 d2Var = eVar.g;
        int i = d2Var.a;
        String strA = d2Var.b.a();
        String str2 = eVar.f;
        o.h(strA, "signature");
        y yVar = this.d.a;
        ArrayList arrayList = new ArrayList();
        r rVar = new r(arrayList);
        rVar.c("tempo", Integer.valueOf(i));
        rVar.e("time_signature", strA);
        rVar.e("key", str2);
        y.k(yVar, "smart_layer_start", arrayList, h.e, 8);
    }

    public final void g() {
        t tVar;
        a21.e eVar = (a21.e) this.a.a.x.getValue();
        String str = eVar.a;
        d2 d2Var = eVar.g;
        int i = d2Var.a;
        String strA = d2Var.b.a();
        String str2 = eVar.f;
        p0 p0VarC = c();
        u uVarF = eVar.f();
        this.d.f((Integer) null, (Integer) null, (Integer) null, str, (uVarF == null || (tVar = uVarF.b) == null) ? null : tVar.c(), i, strA, str2, p0VarC, "canceled");
    }
}
