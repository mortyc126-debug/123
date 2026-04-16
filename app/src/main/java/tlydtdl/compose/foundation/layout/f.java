package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements i {
    public final /* synthetic */ int a;
    public float b;

    public f(float f2) {
        this.a = 4;
        this.b = f2;
    }

    @Override // tlydtdl.compose.foundation.layout.k
    public void a(p5.c cVar, int i, int[] iArr, int[] iArr2) {
        switch (this.a) {
            case 0:
                l.a(i, iArr, iArr2, false);
                break;
            case 1:
                l.d(i, iArr, iArr2, false);
                break;
            case 2:
                l.e(i, iArr, iArr2, false);
                break;
            default:
                l.f(i, iArr, iArr2, false);
                break;
        }
    }

    @Override // tlydtdl.compose.foundation.layout.h, tlydtdl.compose.foundation.layout.k
    public float c() {
        switch (this.a) {
        }
        return this.b;
    }

    @Override // tlydtdl.compose.foundation.layout.h
    public void k(p5.c cVar, int i, int[] iArr, p5.n nVar, int[] iArr2) {
        switch (this.a) {
            case 0:
                if (nVar != p5.n.a) {
                    l.a(i, iArr, iArr2, true);
                } else {
                    l.a(i, iArr, iArr2, false);
                }
                break;
            case 1:
                if (nVar != p5.n.a) {
                    l.d(i, iArr, iArr2, true);
                } else {
                    l.d(i, iArr, iArr2, false);
                }
                break;
            case 2:
                if (nVar != p5.n.a) {
                    l.e(i, iArr, iArr2, true);
                } else {
                    l.e(i, iArr, iArr2, false);
                }
                break;
            default:
                if (nVar != p5.n.a) {
                    l.f(i, iArr, iArr2, true);
                } else {
                    l.f(i, iArr, iArr2, false);
                }
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "Arrangement#Center";
            case 1:
                return "Arrangement#SpaceAround";
            case 2:
                return "Arrangement#SpaceBetween";
            case 3:
                return "Arrangement#SpaceEvenly";
            default:
                return super.toString();
        }
    }

    public f(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = 0;
                break;
            case 2:
                this.b = 0;
                break;
            case 3:
                this.b = 0;
                break;
            case 4:
            default:
                this.b = 0;
                break;
            case 5:
                break;
        }
    }
}
