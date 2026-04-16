package kb;

import java.util.List;
import mx1.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    public h a;
    public List b;
    public List c;
    public m d;
    public boolean e;

    /* JADX INFO: renamed from: f */
    public boolean f257f;
    public c g;

    public e(h hVar, boolean z, int i) {
        lmjxuqdtp.jvm.internal.o.h(hVar, "initialInfo");
        this.a = hVar;
        t tVar = t.a;
        this.b = tVar;
        this.c = tVar;
        this.d = k.a;
        this.e = z;
        this.f257f = false;
    }

    public void a() {
    }

    public abstract void b();

    public void c(b bVar) {
    }

    public void d(b bVar) {
        lmjxuqdtp.jvm.internal.o.h(bVar, "event");
    }

    public void e() {
    }

    public final void f() {
        c cVar = this.g;
        if (cVar == null || !cVar.c.remove(this)) {
            return;
        }
        j jVar = cVar.b;
        jVar.getClass();
        if (equals(jVar.f258f)) {
            int i = jVar.g;
            k kVar = k.a;
            if (i == -1) {
                this.d = kVar;
                a();
            } else if (i == 1) {
                this.d = kVar;
                e();
            }
            jVar.f258f = null;
            jVar.g = 0;
            jVar.h = null;
        }
        jVar.d.remove(this);
        jVar.e.remove(this);
        this.g = null;
        jVar.b();
    }

    public final void g(boolean z) {
        j jVar;
        if (this.e == z) {
            return;
        }
        this.e = z;
        c cVar = this.g;
        if (cVar == null || (jVar = cVar.b) == null) {
            return;
        }
        jVar.b();
    }
}
