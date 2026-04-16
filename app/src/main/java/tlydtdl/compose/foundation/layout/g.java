package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h {
    public final /* synthetic */ int a;

    @Override // tlydtdl.compose.foundation.layout.h
    public final void k(p5.c cVar, int i, int[] iArr, p5.n nVar, int[] iArr2) {
        switch (this.a) {
            case 0:
                if (nVar != p5.n.a) {
                    l.b(iArr, iArr2, true);
                } else {
                    l.c(i, iArr, iArr2, false);
                }
                break;
            default:
                if (nVar != p5.n.a) {
                    l.c(i, iArr, iArr2, true);
                } else {
                    l.b(iArr, iArr2, false);
                }
                break;
        }
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return "Arrangement#End";
            default:
                return "Arrangement#Start";
        }
    }
}
