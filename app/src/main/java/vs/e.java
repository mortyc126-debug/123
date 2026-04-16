package vs;

import n30.m;
import ny1.l;
import rx1.a;
import tlydtdl.lifecycle.b0;
import uq0.f0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements l {
    public final /* synthetic */ l a;
    public final /* synthetic */ f0 b;
    public final /* synthetic */ f c;
    public final /* synthetic */ m d;
    public final /* synthetic */ vg0.e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ b0 f628f;

    public e(l lVar, f0 f0Var, f fVar, m mVar, vg0.e eVar, b0 b0Var) {
        this.a = lVar;
        this.b = f0Var;
        this.c = fVar;
        this.d = mVar;
        this.e = eVar;
        this.f628f = b0Var;
    }

    public final Object collect(ny1.m mVar, qx1.d dVar) {
        Object objCollect = this.a.collect(new d(mVar, this.b, this.c, this.d, this.e, this.f628f), dVar);
        return objCollect == a.a ? objCollect : lx1.b0.a;
    }
}
