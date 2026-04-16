package tlydtdl.compose.foundation.lazy.layout;

import kotlin.jvm.internal.IntCompanionObject;
import ky1.c0;
import qx1.i;
import t1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static final long s;
    public static final /* synthetic */ int t = 0;
    public final ky1.a0 a;
    public final a4.h0 b;
    public final c c;
    public z d;
    public z e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f510f;
    public boolean g;
    public final tlydtdl.compose.runtime.n1 h;
    public final tlydtdl.compose.runtime.n1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final tlydtdl.compose.runtime.n1 f511j;
    public final tlydtdl.compose.runtime.n1 k;
    public long l;
    public long m;
    public d4.c n;
    public final t1.b o;
    public final t1.b p;
    public final tlydtdl.compose.runtime.n1 q;
    public long r;

    static {
        long j2 = IntCompanionObject.MAX_VALUE;
        s = (j2 & 4294967295L) | (j2 << 32);
    }

    public y(ky1.a0 a0Var, a4.h0 h0Var, c cVar) {
        this.a = a0Var;
        this.b = h0Var;
        this.c = cVar;
        Boolean bool = Boolean.FALSE;
        this.h = tlydtdl.compose.runtime.a0.t(bool);
        this.i = tlydtdl.compose.runtime.a0.t(bool);
        this.f511j = tlydtdl.compose.runtime.a0.t(bool);
        this.k = tlydtdl.compose.runtime.a0.t(bool);
        long j2 = s;
        this.l = j2;
        this.m = 0L;
        this.n = h0Var != null ? h0Var.b() : null;
        this.o = new t1.b(new p5.k(0L), t1.c.o, (Object) null, 12);
        this.p = new t1.b(Float.valueOf(1.0f), t1.c.i, (Object) null, 12);
        this.q = tlydtdl.compose.runtime.a0.t(new p5.k(0L));
        this.r = j2;
    }

    public final void a() {
        d4.c cVar = this.n;
        z zVar = this.d;
        boolean zBooleanValue = ((Boolean) this.i.getValue()).booleanValue();
        ky1.a0 a0Var = this.a;
        if (zBooleanValue || zVar == null || cVar == null) {
            if (c()) {
                if (cVar != null) {
                    cVar.f(1.0f);
                }
                c0.F(a0Var, (i) null, (ky1.b0) null, new u(this, (qx1.d) null, 0), 3);
                return;
            }
            return;
        }
        e(true);
        boolean zC = c();
        boolean z = !zC;
        if (!zC) {
            cVar.f(0.0f);
        }
        c0.F(a0Var, (i) null, (ky1.b0) null, new w(z, this, zVar, cVar, (qx1.d) null, 0), 3);
    }

    public final void b() {
        if (((Boolean) this.h.getValue()).booleanValue()) {
            c0.F(this.a, (i) null, (ky1.b0) null, new u(this, (qx1.d) null, 1), 3);
        }
    }

    public final boolean c() {
        return ((Boolean) this.f511j.getValue()).booleanValue();
    }

    public final void d() {
        a4.h0 h0Var;
        boolean zBooleanValue = ((Boolean) this.h.getValue()).booleanValue();
        ky1.a0 a0Var = this.a;
        if (zBooleanValue) {
            g(false);
            c0.F(a0Var, (i) null, (ky1.b0) null, new u(this, (qx1.d) null, 2), 3);
        }
        if (((Boolean) this.i.getValue()).booleanValue()) {
            e(false);
            c0.F(a0Var, (i) null, (ky1.b0) null, new u(this, (qx1.d) null, 3), 3);
        }
        if (c()) {
            f(false);
            c0.F(a0Var, (i) null, (ky1.b0) null, new u(this, (qx1.d) null, 4), 3);
        }
        this.g = false;
        h(0L);
        this.l = s;
        d4.c cVar = this.n;
        if (cVar != null && (h0Var = this.b) != null) {
            h0Var.a(cVar);
        }
        this.n = null;
        this.d = null;
        this.f510f = null;
        this.e = null;
    }

    public final void e(boolean z) {
        this.i.setValue(Boolean.valueOf(z));
    }

    public final void f(boolean z) {
        this.f511j.setValue(Boolean.valueOf(z));
    }

    public final void g(boolean z) {
        this.h.setValue(Boolean.valueOf(z));
    }

    public final void h(long j2) {
        this.q.setValue(new p5.k(j2));
    }
}
