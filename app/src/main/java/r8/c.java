package r8;

import q8.m;
import q8.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements q8.f {
    public s a;
    public m b;

    @Override // q8.f
    public final q8.g a() {
        m mVar = this.b;
        b bVarW = null;
        q8.g gVarA = mVar != null ? mVar.a() : null;
        s sVar = this.a;
        sVar.getClass();
        if (gVarA != null) {
            og1.f fVar = new og1.f();
            fVar.J(sVar);
            bVarW = fVar.w();
        }
        return new d(sVar, gVarA, new t(), bVarW);
    }
}
