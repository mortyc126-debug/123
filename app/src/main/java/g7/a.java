package g7;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public transient o a;

    public final void f(h hVar) {
        synchronized (this) {
            try {
                if (this.a == null) {
                    this.a = new o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.a(hVar);
    }

    public final void g() {
        synchronized (this) {
            try {
                o oVar = this.a;
                if (oVar == null) {
                    return;
                }
                oVar.d(this, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(int i) {
        synchronized (this) {
            try {
                o oVar = this.a;
                if (oVar == null) {
                    return;
                }
                oVar.d(this, i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
