package kb;

import bb.z0;
import java.util.LinkedHashSet;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final z0 a;
    public final j b = new j();
    public final LinkedHashSet c;
    public final LinkedHashSet d;

    public c(z0 z0Var) {
        this.a = z0Var;
        new LinkedHashSet();
        this.c = new LinkedHashSet();
        this.d = new LinkedHashSet();
    }

    public static void a(c cVar, e eVar) {
        cVar.getClass();
        lmjxuqdtp.jvm.internal.o.h(eVar, "handler");
        if (cVar.c.add(eVar)) {
            j jVar = cVar.b;
            jVar.getClass();
            if (eVar.g == null) {
                jVar.e.addFirst(eVar);
                eVar.g = cVar;
                jVar.b();
            } else {
                throw new IllegalArgumentException(("Handler '" + eVar + "' is already registered with a dispatcher").toString());
            }
        }
    }

    public final void b(i iVar) {
        if (this.d.add(iVar)) {
            this.b.a(this, iVar, -1);
        }
    }

    public final void c(q qVar, int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException(o6.c.k(i, "Unsupported priority value: ").toString());
        }
        if (this.d.add(qVar)) {
            this.b.a(this, qVar, i);
        }
    }

    public final void d(i iVar, b bVar) {
        j jVar = this.b;
        jVar.getClass();
        if (jVar.g != 0) {
            return;
        }
        e eVarC = jVar.c(-1);
        jVar.f258f = eVarC;
        jVar.g = -1;
        jVar.h = iVar;
        if (bVar != null) {
            if (eVarC != null) {
                eVarC.d = new l(bVar, -1);
                eVarC.d(bVar);
            }
            r2 r2Var = jVar.a;
            l lVar = new l(bVar, -1);
            r2Var.getClass();
            r2Var.i((Object) null, lVar);
        }
    }
}
