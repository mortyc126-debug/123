package tlydtdl.lifecycle;

import java.util.Map;
import s.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p0 {
    public static final Object k = new Object();
    public final Object a;
    public final s.h b;
    public int c;
    public boolean d;
    public volatile Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f601f;
    public int g;
    public boolean h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l0 f602j;

    public p0(Object obj) {
        this.a = new Object();
        this.b = new s.h();
        this.c = 0;
        this.f601f = k;
        this.f602j = new l0(this);
        this.e = obj;
        this.g = 0;
    }

    public static void a(String str) {
        if (!r.b.O().P()) {
            throw new IllegalStateException(i.n("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(o0 o0Var) {
        if (o0Var.b) {
            if (!o0Var.d()) {
                o0Var.a(false);
                return;
            }
            int i = o0Var.c;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            o0Var.c = i2;
            o0Var.a.onChanged(this.e);
        }
    }

    public final void c(o0 o0Var) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (o0Var != null) {
                b(o0Var);
                o0Var = null;
            } else {
                s.h hVar = this.b;
                hVar.getClass();
                e eVar = new e(hVar);
                hVar.c.put(eVar, Boolean.FALSE);
                while (eVar.hasNext()) {
                    b((o0) ((Map.Entry) eVar.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object d() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    public final void e(g0 g0Var, u0 u0Var) {
        Object obj;
        a("observe");
        if (g0Var.getLifecycle().b() == y.a) {
            return;
        }
        n0 n0Var = new n0(this, g0Var, u0Var);
        s.h hVar = this.b;
        s.d dVarB = hVar.b(u0Var);
        if (dVarB != null) {
            obj = dVarB.b;
        } else {
            s.d dVar = new s.d(u0Var, n0Var);
            hVar.d++;
            s.d dVar2 = hVar.b;
            if (dVar2 == null) {
                hVar.a = dVar;
                hVar.b = dVar;
            } else {
                dVar2.c = dVar;
                dVar.d = dVar2;
                hVar.b = dVar;
            }
            obj = null;
        }
        o0 o0Var = (o0) obj;
        if (o0Var != null && !o0Var.c(g0Var)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (o0Var != null) {
            return;
        }
        g0Var.getLifecycle().a(n0Var);
    }

    public final void f(u0 u0Var) {
        Object obj;
        a("observeForever");
        m0 m0Var = new m0(this, u0Var);
        s.h hVar = this.b;
        s.d dVarB = hVar.b(u0Var);
        if (dVarB != null) {
            obj = dVarB.b;
        } else {
            s.d dVar = new s.d(u0Var, m0Var);
            hVar.d++;
            s.d dVar2 = hVar.b;
            if (dVar2 == null) {
                hVar.a = dVar;
                hVar.b = dVar;
            } else {
                dVar2.c = dVar;
                dVar.d = dVar2;
                hVar.b = dVar;
            }
            obj = null;
        }
        o0 o0Var = (o0) obj;
        if (o0Var instanceof n0) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (o0Var != null) {
            return;
        }
        m0Var.a(true);
    }

    public void g() {
    }

    public void h() {
    }

    public void i(u0 u0Var) {
        a("removeObserver");
        o0 o0Var = (o0) this.b.d(u0Var);
        if (o0Var == null) {
            return;
        }
        o0Var.b();
        o0Var.a(false);
    }

    public abstract void j(Object obj);

    public p0() {
        this.a = new Object();
        this.b = new s.h();
        this.c = 0;
        Object obj = k;
        this.f601f = obj;
        this.f602j = new l0(this);
        this.e = obj;
        this.g = -1;
    }
}
