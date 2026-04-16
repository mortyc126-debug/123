package r4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends uz1.g {
    public f a;

    public final boolean m(h hVar) {
        return hVar == this.a.getKey();
    }

    public final Object s(h hVar) {
        if (hVar != this.a.getKey()) {
            p4.a.b("Check failed.");
        }
        return this.a.getValue();
    }
}
