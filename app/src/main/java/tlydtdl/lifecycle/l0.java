package tlydtdl.lifecycle;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements Runnable {
    public final /* synthetic */ p0 a;

    public l0(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        synchronized (this.a.a) {
            obj = this.a.f601f;
            this.a.f601f = p0.k;
        }
        this.a.j(obj);
    }
}
