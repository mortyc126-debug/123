package tlydtdl.compose.foundation.lazy.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final int a;
    public final int b;
    public final t c;

    public j(int i, int i2, t tVar) {
        this.a = i;
        this.b = i2;
        this.c = tVar;
        if (i < 0) {
            d2.a.a("startIndex should be >= 0");
        }
        if (i2 > 0) {
            return;
        }
        d2.a.a("size should be > 0");
    }
}
