package w8;

import amuvvoafs.os.Looper;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 {
    public final h1 a;
    public final g1 b;
    public int c;
    public Object d;
    public final Looper e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f638f;

    public i1(g1 g1Var, h1 h1Var, l8.k1 k1Var, int i, Looper looper) {
        this.b = g1Var;
        this.a = h1Var;
        this.e = looper;
    }

    public final synchronized void a(boolean z) {
        notifyAll();
    }

    public final void b() {
        o8.b.h(!this.f638f);
        this.f638f = true;
        k0 k0Var = (k0) this.b;
        synchronized (k0Var) {
            if (!k0Var.D && k0Var.f643j.getThread().isAlive()) {
                k0Var.h.a(14, this).b();
                return;
            }
            o8.b.q("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            a(false);
        }
    }
}
