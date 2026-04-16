package kb;

import bb.z0;
import f.a0;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public c a;
    public boolean b;

    public void a() {
        b();
    }

    public final void b() {
        c cVar = this.a;
        if (cVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.b) {
            cVar.d(this, null);
        }
        j jVar = cVar.b;
        z0 z0Var = cVar.a;
        jVar.getClass();
        if (equals(jVar.h) && -1 == jVar.g) {
            e eVarC = jVar.f258f;
            if (eVarC == null) {
                eVarC = jVar.c(-1);
            }
            jVar.f258f = null;
            jVar.g = 0;
            jVar.h = null;
            k kVar = k.a;
            if (eVarC == null) {
                ((a0) z0Var.b).a.run();
            } else {
                eVarC.d = kVar;
                eVarC.b();
            }
            r2 r2Var = jVar.a;
            r2Var.getClass();
            r2Var.i((Object) null, kVar);
        }
        this.b = false;
    }

    public void c(boolean z) {
    }
}
