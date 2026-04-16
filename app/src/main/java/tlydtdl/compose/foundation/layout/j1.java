package tlydtdl.compose.foundation.layout;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import java.util.List;
import r6.w1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends tlydtdl.datastore.preferences.protobuf.k implements Runnable, r6.u, View.OnAttachStateChangeListener {
    public final x2 c;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r6.z1 f488f;

    public j1(x2 x2Var) {
        super(!x2Var.s ? 1 : 0);
        this.c = x2Var;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void d(r6.i1 i1Var) {
        this.d = false;
        this.e = false;
        r6.z1 z1Var = this.f488f;
        if (i1Var.a.b() > 0 && z1Var != null) {
            w1 w1Var = z1Var.a;
            x2 x2Var = this.c;
            x2Var.r.f(m.L(w1Var.g(8)));
            x2Var.q.f(m.L(w1Var.g(8)));
            x2.a(x2Var, z1Var);
        }
        this.f488f = null;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final void e(r6.i1 i1Var) {
        this.d = true;
        this.e = true;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final r6.z1 f(r6.z1 z1Var, List list) {
        x2 x2Var = this.c;
        x2.a(x2Var, z1Var);
        return x2Var.s ? r6.z1.b : z1Var;
    }

    @Override // tlydtdl.datastore.preferences.protobuf.k
    public final i11.c g(r6.i1 i1Var, i11.c cVar) {
        this.d = false;
        return cVar;
    }

    @Override // r6.u
    public final r6.z1 o(r6.z1 z1Var, View view) {
        this.f488f = z1Var;
        x2 x2Var = this.c;
        t2 t2Var = x2Var.q;
        w1 w1Var = z1Var.a;
        t2Var.f(m.L(w1Var.g(8)));
        if (this.d) {
            if (Build.VERSION.SDK_INT == 30) {
                view.post(this);
            }
        } else if (!this.e) {
            x2Var.r.f(m.L(w1Var.g(8)));
            x2.a(x2Var, z1Var);
        }
        return x2Var.s ? r6.z1.b : z1Var;
    }

    public final void onViewAttachedToWindow(View view) {
        view.requestApplyInsets();
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d) {
            this.d = false;
            this.e = false;
            r6.z1 z1Var = this.f488f;
            if (z1Var != null) {
                x2 x2Var = this.c;
                x2Var.r.f(m.L(z1Var.a.g(8)));
                x2.a(x2Var, z1Var);
                this.f488f = null;
            }
        }
    }
}
