package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements m2 {
    public static final h1 a = new h1();

    @Override // tlydtdl.compose.foundation.layout.m2
    public final t3.p a(float f2, t3.p pVar, boolean z) {
        if (f2 <= 0.0d) {
            e2.a.a("invalid weight; must be greater than zero");
        }
        if (f2 > Float.MAX_VALUE) {
            f2 = Float.MAX_VALUE;
        }
        return pVar.then(new LayoutWeightElement(f2, z));
    }

    @Override // tlydtdl.compose.foundation.layout.m2
    public final t3.p b(t3.p pVar, t3.g gVar) {
        return pVar.then(new VerticalAlignElement(gVar));
    }
}
