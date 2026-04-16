package kg0;

import dl.c;
import eu0.k;
import fy1.l;
import fz0.o;
import g4.d0;
import hw.q;
import k7.w;
import k80.t;
import ky1.a0;
import lmjxuqdtp.jvm.internal.v;
import ny1.b2;
import ny1.j2;
import ny1.r2;
import ny1.z;
import p81.f;
import sh0.b;
import xu0.p;
import yr.q1;
import yr.x4;
import zi.i;
import zj.n;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    public static final /* synthetic */ l[] p;
    public final n a;
    public final a0 b;
    public final x4 c;
    public final f d;
    public final q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f263f;
    public final j0 g;
    public final q1 h;
    public final wk.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f264j;
    public final r2 k;
    public final c l;
    public final k m;
    public final d0 n;
    public final b2 o;

    static {
        l vVar = new v(h.class, "isLengthSelectionVisible", "isLengthSelectionVisible()Lcom/bandlab/amuvvoafs/common/utils/StateProperty;", 0);
        lmjxuqdtp.jvm.internal.d0.a.getClass();
        p = new l[]{vVar};
    }

    public h(n nVar, i iVar, a0 a0Var, x4 x4Var, f fVar, q qVar, p pVar, j0 j0Var, b bVar) {
        this.a = nVar;
        this.b = a0Var;
        this.c = x4Var;
        this.d = fVar;
        this.e = qVar;
        this.f263f = pVar;
        this.g = j0Var;
        Boolean bool = Boolean.FALSE;
        this.h = iVar.c(bool);
        wl.e eVar = nVar.g;
        this.i = eVar;
        this.f264j = new w(1, false);
        r2 r2VarC = z.c(bool);
        this.k = r2VarC;
        gl.h hVar = new gl.h(0, this, h.class, "onTryDismiss", "onTryDismiss()V", 0, 29);
        e eVar2 = new e(0, this, h.class, "onConfirmDismiss", "onConfirmDismiss()V", 0, 0);
        e eVar3 = new e(0, this, h.class, "closeDismissDialog", "closeDismissDialog()V", 0, 1);
        e eVar4 = new e(0, this, h.class, "onAddToProjectClick", "onAddToProjectClick()V", 0, 2);
        e eVar5 = new e(0, this, h.class, "onMuteProjectClick", "onMuteProjectClick()V", 0, 3);
        t tVar = new t(1, this, h.class, "onPlayPosChange", "onPlayPosChange(F)V", 0, 2);
        e eVar6 = new e(0, this, h.class, "onPlayPosChangeOver", "onPlayPosChangeOver()V", 0, 4);
        this.l = new c(hVar, eVar2, eVar3, new e(0, this, h.class, "onPlayClick", "onPlayClick()V", 0, 6), eVar4, eVar5, new e(0, this, h.class, "onRegenerateClick", "onRegenerateClick()V", 0, 5), new gl.h(0, this, h.class, "navigateToPaywallIfEligibleForFreeUsageTokens", "navigateToPaywallIfEligibleForFreeUsageTokens()V", 0, 28), tVar, eVar6, 4);
        this.m = new k(10, new gl.h(0, this, h.class, "onConfirmDismiss", "onConfirmDismiss()V", 0, 26), new gl.h(0, this, h.class, "onRegenerateClick", "onRegenerateClick()V", 0, 27));
        this.n = new d0(7, new o(29, this), new t(1, this, h.class, "openMidiExtend", "openMidiExtend(I)V", 0, 1));
        wl.e eVar7 = eVar;
        this.o = z.R(z.o(eVar7.n, r2VarC, d().d, eVar7.q, new g(this, null)), a0Var, j2.a(3), (Object) null);
    }

    public static final void a(h hVar) {
        hVar.f263f.e(hVar.g.b("smart_tools_extend", lx0.b.INSTANCE));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(kg0.h r6, wk.b r7, sx1.c r8) {
        /*
            boolean r0 = r8 instanceof kg0.d
            if (r0 == 0) goto L13
            r0 = r8
            kg0.d r0 = (kg0.d) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            kg0.d r0 = new kg0.d
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            wk.b r7 = r0.j
            lg.e.O(r8)
            goto L43
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            lg.e.O(r8)
            yr.x4 r8 = r6.c
            double r4 = r7.a
            r0.j = r7
            r0.m = r3
            java.lang.Object r8 = r8.d(r4, r0)
            if (r8 != r1) goto L43
            return r1
        L43:
            wk.a r8 = r6.i
            wl.e r8 = (wl.e) r8
            r8.g()
            boolean r7 = r7.b
            if (r7 == 0) goto L78
            p81.f r6 = r6.d
            x10.c r7 = x10.v.Companion
            int r8 = lmjxuqdtp.time.g.d
            r0 = 900000(0xdbba0, double:4.44659E-318)
            lmjxuqdtp.time.i r8 = lmjxuqdtp.time.i.d
            long r0 = lmjxuqdtp.time.n.t(r0, r8)
            lmjxuqdtp.time.i r8 = lmjxuqdtp.time.i.f
            long r0 = lmjxuqdtp.time.g.t(r0, r8)
            java.lang.String r8 = java.lang.String.valueOf(r0)
            java.lang.String[] r8 = new java.lang.String[]{r8}
            r7.getClass()
            r7 = 2132019895(0x7f140ab7, float:1.9678138E38)
            x10.u r7 = x10.c.g(r8, r7)
            r6.l(r7)
        L78:
            lx1.b0 r6 = lx1.b0.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kg0.h.b(kg0.h, wk.b, sx1.c):java.lang.Object");
    }

    public static final void c(h hVar) {
        r2 r2Var = hVar.k;
        Boolean bool = Boolean.FALSE;
        r2Var.getClass();
        r2Var.i((Object) null, bool);
        hVar.d().a(bool);
        wl.e eVar = hVar.i;
        eVar.h("canceled");
        eVar.g();
    }

    public final zi.k d() {
        return (zi.k) this.h.d(this, p[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(sx1.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kg0.b
            if (r0 == 0) goto L13
            r0 = r6
            kg0.b r0 = (kg0.b) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            kg0.b r0 = new kg0.b
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            wk.a r3 = r5.i
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
            jv0.q r6 = jv0.q.c
            hw.q r2 = r5.e
            boolean r6 = r2.g(r6)
            if (r6 != 0) goto L71
            r0.l = r4
            r6 = r3
            wl.e r6 = (wl.e) r6
            vt1.b r6 = r6.k
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
            wl.e r3 = (wl.e) r3
            ny1.b2 r6 = r3.q
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
        throw new UnsupportedOperationException("Method not decompiled: kg0.h.e(sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(sx1.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kg0.f
            if (r0 == 0) goto L13
            r0 = r5
            kg0.f r0 = (kg0.f) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            kg0.f r0 = new kg0.f
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
            java.lang.Object r5 = r4.e(r0)
            if (r5 != r1) goto L3b
            return r1
        L3b:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r5 = r5 ^ r3
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kg0.h.f(sx1.c):java.lang.Object");
    }
}
