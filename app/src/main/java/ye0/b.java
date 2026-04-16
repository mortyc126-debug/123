package ye0;

import d01.k;
import i11.t;
import ky1.a0;
import lmjxuqdtp.jvm.internal.o;
import ny1.p2;
import qu0.u;
import xu0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final c a;
    public final f b;

    public b(c cVar, f fVar) {
        this.a = cVar;
        this.b = fVar;
    }

    public final d a(a0 a0Var, p pVar, p2 p2Var, boolean z) {
        dt.d dVar = this.b.a;
        tk1.b bVar = (tk1.b) dVar.a.invoke();
        t tVar = (t) dVar.b.invoke();
        o.h(bVar, "urlNavigationProvider");
        o.h(tVar, "remoteConfig");
        u uVar = new u(pVar, bVar, tVar, 29);
        k kVar = (k) this.a.a.a.invoke();
        o.h(kVar, "preferenceConfig");
        return new d(a0Var, p2Var, z, uVar, kVar);
    }
}
