package s4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 implements t1 {
    public final o1 a;

    public p1(o1 o1Var) {
        this.a = o1Var;
    }

    @Override // s4.t1
    public final boolean d0() {
        return this.a.getNode().isAttached();
    }
}
