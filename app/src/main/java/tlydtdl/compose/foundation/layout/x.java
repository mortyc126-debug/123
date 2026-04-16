package tlydtdl.compose.foundation.layout;

import t3.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements w {
    public static final x a = new x();

    @Override // tlydtdl.compose.foundation.layout.w
    public final t3.p a(t3.p pVar) {
        return pVar.then(new BoxChildDataElement(t3.c.e, true));
    }

    @Override // tlydtdl.compose.foundation.layout.w
    public final t3.p b(t3.p pVar, d dVar) {
        return pVar.then(new BoxChildDataElement(dVar, false));
    }
}
