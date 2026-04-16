package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 implements f0 {
    public static final g0 a = new g0();

    @Override // tlydtdl.compose.foundation.layout.f0
    public final t3.p a(float f2, t3.p pVar, boolean z) {
        if (!(((double) f2) > 0.0d)) {
            e2.a.a("invalid weight; must be greater than zero");
        }
        if (f2 > Float.MAX_VALUE) {
            f2 = Float.MAX_VALUE;
        }
        return pVar.then(new LayoutWeightElement(f2, z));
    }

    public final t3.p c(t3.f fVar, t3.p pVar) {
        return i.v(fVar, pVar);
    }
}
