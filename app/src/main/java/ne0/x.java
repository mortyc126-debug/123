package ne0;

import amuvvoafs.app.Application;
import ny1.r2;
import ny1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    public final r2 a;
    public final r2 b;
    public final r2 c;
    public final bv1.a d;
    public final w e;

    public x(Application application, i11.t tVar, y10.a aVar) {
        h30.g gVarB = tVar.b(le0.a.a, aVar);
        r2 r2VarC = z.c((Object) null);
        this.a = r2VarC;
        this.b = z.c((Object) null);
        this.c = r2VarC;
        this.d = new bv1.a(4, this, aVar);
        z.J(aVar, new am.p(20, gVarB, new v(this, application, null)));
        this.e = new w(this);
    }

    public final void a() {
        jp1.g gVarA;
        jp1.a aVar = (jp1.a) this.b.getValue();
        if (aVar == null || (gVarA = aVar.a()) == null) {
            return;
        }
        gVarA.b(true);
    }
}
