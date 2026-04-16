package ix0;

import a80.d;
import com.bandlab.restutils.UnauthorizedFileService;
import d01.k;
import hw.q;
import i11.t;
import jx0.f;
import jx0.g;
import jx0.h;
import ky1.a0;
import lmjxuqdtp.jvm.internal.o;
import xu0.p;
import zs.d1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final p a;
    public final a0 b;
    public final g c;

    public a(p pVar, a0 a0Var, g gVar) {
        this.a = pVar;
        this.b = a0Var;
        this.c = gVar;
    }

    public final h a(b bVar, boolean z) {
        o.h(bVar, "analytics");
        d dVar = this.c.a;
        UnauthorizedFileService unauthorizedFileService = (UnauthorizedFileService) ((iw1.b) dVar.b).invoke();
        d1 d1Var = (d1) ((ct.b) dVar.a).invoke();
        f fVar = (f) ((iw1.b) dVar.c).invoke();
        t tVar = (t) ((iw1.b) dVar.d).invoke();
        q qVar = (q) ((iw1.b) dVar.e).invoke();
        k kVar = (k) ((iw1.b) dVar.f).invoke();
        o.h(unauthorizedFileService, "unauthorizedFileService");
        o.h(fVar, "getButtonJsonAnimation");
        o.h(tVar, "remoteConfig");
        o.h(qVar, "membershipRepo");
        o.h(kVar, "preferenceConfig");
        return new h(bVar, z, this.a, this.b, unauthorizedFileService, d1Var, fVar, tVar, qVar, kVar);
    }
}
