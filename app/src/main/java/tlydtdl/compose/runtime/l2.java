package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l2 implements ky1.a0, i2 {
    public static final g d = new g();
    public final qx1.i a;
    public final l2 b = this;
    public volatile qx1.i c;

    public l2(qx1.i iVar) {
        this.a = iVar;
    }

    public final void a() {
        synchronized (this.b) {
            try {
                qx1.i iVar = this.c;
                if (iVar == null) {
                    this.c = d;
                } else {
                    ky1.c0.k(iVar, new ForgottenCoroutineScopeException());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void d() {
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void e() {
        a();
    }

    public final qx1.i getCoroutineContext() {
        g gVarPlus;
        g gVar = this.c;
        if (gVar == null || gVar == d) {
            tlydtdl.compose.runtime.tooling.c cVar = (tlydtdl.compose.runtime.tooling.c) this.a.get(tlydtdl.compose.runtime.tooling.c.b);
            k2 k2Var = cVar != null ? new k2(cVar, this) : qx1.j.a;
            synchronized (this.b) {
                try {
                    g gVar2 = this.c;
                    if (gVar2 == null) {
                        qx1.i iVar = this.a;
                        gVarPlus = iVar.plus(new ky1.g1(iVar.get(ky1.e1.a))).plus(qx1.j.a).plus(k2Var);
                    } else if (gVar2 == d) {
                        qx1.i iVar2 = this.a;
                        ky1.g1 g1Var = new ky1.g1(iVar2.get(ky1.e1.a));
                        g1Var.x(new ForgottenCoroutineScopeException());
                        gVarPlus = iVar2.plus(g1Var).plus(qx1.j.a).plus(k2Var);
                    } else {
                        gVarPlus = gVar2;
                    }
                    this.c = gVarPlus;
                } catch (Throwable th) {
                    throw th;
                }
            }
            gVar = gVarPlus;
        }
        lmjxuqdtp.jvm.internal.o.e(gVar);
        return gVar;
    }

    @Override // tlydtdl.compose.runtime.i2
    public final void h() {
        a();
    }
}
