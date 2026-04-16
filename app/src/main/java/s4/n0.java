package s4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {
    public final j0 a;
    public boolean b;
    public boolean c;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f437f;
    public boolean g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f438j;
    public boolean k;
    public int l;
    public boolean m;
    public boolean n;
    public int o;
    public x0 q;
    public f0 d = f0.e;
    public final b1 p = new b1(this);

    public n0(j0 j0Var) {
        this.a = j0Var;
    }

    public final k1 a() {
        return (k1) this.a.E.e;
    }

    public final void b() {
        f0 f0Var = this.a.F.d;
        if (f0Var == f0.c || f0Var == f0.d) {
            if (this.p.A) {
                g(true);
            } else {
                f(true);
            }
        }
        if (f0Var == f0.d) {
            x0 x0Var = this.q;
            if (x0Var == null || !x0Var.u) {
                h(true);
            } else {
                i(true);
            }
        }
    }

    public final void c(long j2) {
        x0 x0Var = this.q;
        if (x0Var != null) {
            f0 f0Var = f0.b;
            n0 n0Var = x0Var.f445f;
            n0Var.d = f0Var;
            b1 b1Var = n0Var.p;
            j0 j0Var = n0Var.a;
            n0Var.e = false;
            u1 snapshotObserver = m0.a(j0Var).getSnapshotObserver();
            v0 v0Var = new v0(x0Var, j2);
            snapshotObserver.getClass();
            if (j0Var.g != null) {
                snapshotObserver.a(j0Var, snapshotObserver.b, v0Var);
            } else {
                snapshotObserver.a(j0Var, snapshotObserver.c, v0Var);
            }
            n0Var.f437f = true;
            n0Var.g = true;
            if (g.p(j0Var)) {
                b1Var.v = true;
                b1Var.w = true;
            } else {
                b1Var.u = true;
            }
            n0Var.d = f0.e;
        }
    }

    public final void d(int i) {
        int i2 = this.l;
        this.l = i;
        if ((i2 == 0) != (i == 0)) {
            j0 j0VarV = this.a.v();
            n0 n0Var = j0VarV != null ? j0VarV.F : null;
            if (n0Var != null) {
                if (i == 0) {
                    n0Var.d(n0Var.l - 1);
                } else {
                    n0Var.d(n0Var.l + 1);
                }
            }
        }
    }

    public final void e(int i) {
        int i2 = this.o;
        this.o = i;
        if ((i2 == 0) != (i == 0)) {
            j0 j0VarV = this.a.v();
            n0 n0Var = j0VarV != null ? j0VarV.F : null;
            if (n0Var != null) {
                if (i == 0) {
                    n0Var.e(n0Var.o - 1);
                } else {
                    n0Var.e(n0Var.o + 1);
                }
            }
        }
    }

    public final void f(boolean z) {
        if (this.k != z) {
            this.k = z;
            if (z && !this.f438j) {
                d(this.l + 1);
            } else {
                if (z || this.f438j) {
                    return;
                }
                d(this.l - 1);
            }
        }
    }

    public final void g(boolean z) {
        if (this.f438j != z) {
            this.f438j = z;
            if (z && !this.k) {
                d(this.l + 1);
            } else {
                if (z || this.k) {
                    return;
                }
                d(this.l - 1);
            }
        }
    }

    public final void h(boolean z) {
        if (this.n != z) {
            this.n = z;
            if (z && !this.m) {
                e(this.o + 1);
            } else {
                if (z || this.m) {
                    return;
                }
                e(this.o - 1);
            }
        }
    }

    public final void i(boolean z) {
        if (this.m != z) {
            this.m = z;
            if (z && !this.n) {
                e(this.o + 1);
            } else {
                if (z || this.n) {
                    return;
                }
                e(this.o - 1);
            }
        }
    }

    public final void j() {
        b1 b1Var = this.p;
        n0 n0Var = b1Var.f426f;
        Object obj = b1Var.r;
        j0 j0Var = this.a;
        if ((obj != null || n0Var.a().l() != null) && b1Var.q) {
            b1Var.q = false;
            b1Var.r = n0Var.a().l();
            j0 j0VarV = j0Var.v();
            if (j0VarV != null) {
                j0.Y(j0VarV, false, 7);
            }
        }
        x0 x0Var = this.q;
        if (x0Var != null) {
            n0 n0Var2 = x0Var.f445f;
            if (x0Var.w == null) {
                t0 t0VarH1 = n0Var2.a().h1();
                lmjxuqdtp.jvm.internal.o.e(t0VarH1);
                if (t0VarH1.o.l() == null) {
                    return;
                }
            }
            if (x0Var.v) {
                x0Var.v = false;
                t0 t0VarH12 = n0Var2.a().h1();
                lmjxuqdtp.jvm.internal.o.e(t0VarH12);
                x0Var.w = t0VarH12.o.l();
                if (g.p(j0Var)) {
                    j0 j0VarV2 = j0Var.v();
                    if (j0VarV2 != null) {
                        j0.Y(j0VarV2, false, 7);
                        return;
                    }
                    return;
                }
                j0 j0VarV3 = j0Var.v();
                if (j0VarV3 != null) {
                    j0.W(j0VarV3, false, 7);
                }
            }
        }
    }
}
