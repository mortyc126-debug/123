package cu;

import a2.p4;
import ai1.k;
import am.p;
import com.bandlab.beat.api.BeatsService;
import cs0.t;
import d10.j;
import fy1.l;
import hw.q;
import jv0.i0;
import ky1.b0;
import ky1.c0;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.v;
import ny1.b2;
import ny1.j2;
import ny1.o2;
import ny1.r2;
import ny1.z;
import qx1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final /* synthetic */ l[] m;
    public final i0 a;
    public final q b;
    public final mt.b c;
    public final t d;
    public final p e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r2 f58f;
    public final b2 g;
    public final r2 h;
    public final b2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b2 f59j;
    public final r2 k;
    public final b2 l;

    static {
        l vVar = new v(f.class, "beatsService", "getBeatsService()Lcom/bandlab/beat/api/BeatsService;", 0);
        d0.a.getClass();
        m = new l[]{vVar};
    }

    public f(y10.a aVar, i11.t tVar, i0 i0Var, q qVar, mt.b bVar) {
        this.a = i0Var;
        this.b = qVar;
        this.c = bVar;
        t tVar2 = qVar.l;
        this.d = tVar2;
        this.e = new p(8, tVar2, this);
        d dVar = null;
        r2 r2VarC = z.c((Object) null);
        this.f58f = r2VarC;
        this.g = new b2(r2VarC);
        ny1.l lVarA = tVar.a(a.a);
        r2 r2VarC2 = z.c(Boolean.TRUE);
        this.h = r2VarC2;
        j jVar = new j(lVarA, r2VarC2, new ao0.h(3, 3, (d) null), 9);
        o2 o2VarA = j2.a(3);
        Boolean bool = Boolean.FALSE;
        this.i = z.R(jVar, aVar, o2VarA, bool);
        this.f59j = z.R(new j(lVarA, r2VarC2, new k(3, 8, (d) null), 9), aVar, j2.a(3), bool);
        r2 r2VarC3 = z.c(bool);
        this.k = r2VarC3;
        this.l = new b2(r2VarC3);
        z.J(aVar, new p(20, tVar2, new c(this, dVar, 0)));
        z.J(aVar, new p(20, lVarA, new c(this, dVar, 1)));
        c0.F(aVar, (qx1.i) null, (b0) null, new p4(this, (d) null, 12), 3);
    }

    public final BeatsService a() {
        return (BeatsService) new jx0.h(d0.a(BeatsService.class), this.c).t(m[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(sx1.c r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cu.e
            if (r0 == 0) goto L13
            r0 = r7
            cu.e r0 = (cu.e) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            cu.e r0 = new cu.e
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f57j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            ny1.r2 r4 = r6.k
            r5 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            lg.e.O(r7)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            goto L54
        L2a:
            r7 = move-exception
            goto L88
        L2c:
            r7 = move-exception
            goto L7f
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            lg.e.O(r7)
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r4.getClass()
            r4.i(r5, r7)
            com.bandlab.beat.api.BeatsService r7 = r6.a()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            jv0.i0 r2 = r6.a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.String r2 = dd.v.D(r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0.l = r3     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.Object r7 = r7.getFreeDailyQuota(r2, r0)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            if (r7 != r1) goto L54
            return r1
        L54:
            cu.i r7 = (cu.i) r7     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            ny1.r2 r0 = r6.f58f     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0.setValue(r7)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            ny1.r2 r0 = r6.h     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.Integer r7 = r7.a     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r1 = 0
            if (r7 == 0) goto L67
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            goto L68
        L67:
            r7 = r1
        L68:
            if (r7 <= 0) goto L6b
            goto L6c
        L6b:
            r3 = r1
        L6c:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0.getClass()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r0.i(r5, r7)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
        L76:
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r4.getClass()
            r4.i(r5, r7)
            goto L85
        L7f:
            s02.b r0 = s02.d.a     // Catch: java.lang.Throwable -> L2a
            r0.e(r7)     // Catch: java.lang.Throwable -> L2a
            goto L76
        L85:
            lx1.b0 r7 = lx1.b0.a
            return r7
        L88:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.getClass()
            r4.i(r5, r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cu.f.b(sx1.c):java.lang.Object");
    }
}
