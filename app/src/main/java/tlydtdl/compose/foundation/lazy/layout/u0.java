package tlydtdl.compose.foundation.lazy.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {
    public final Object a;
    public final w0 b;
    public int d;
    public u0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f508f;
    public int c = -1;
    public final tlydtdl.compose.runtime.n1 g = tlydtdl.compose.runtime.a0.t(null);

    public u0(Object obj, w0 w0Var) {
        this.a = obj;
        this.b = w0Var;
    }

    public final u0 a() {
        if (this.f508f) {
            d2.a.c("Pin should not be called on an already disposed item ");
        }
        if (this.d == 0) {
            this.b.a.add(this);
            u0 u0Var = (u0) this.g.getValue();
            if (u0Var != null) {
                u0Var.a();
            } else {
                u0Var = null;
            }
            this.e = u0Var;
        }
        this.d++;
        return this;
    }

    public final void b() {
        if (this.f508f) {
            return;
        }
        if (this.d <= 0) {
            d2.a.c("Release should only be called once");
        }
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            this.b.a.remove(this);
            u0 u0Var = this.e;
            if (u0Var != null) {
                u0Var.b();
            }
            this.e = null;
        }
    }
}
