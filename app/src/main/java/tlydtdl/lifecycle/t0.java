package tlydtdl.lifecycle;

import amuvvoafs.os.Looper;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class t0 extends p0 {
    @Override // tlydtdl.lifecycle.p0
    public void j(Object obj) {
        p0.a("setValue");
        this.g++;
        this.e = obj;
        c(null);
    }

    public final void k(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f601f == p0.k;
            this.f601f = obj;
        }
        if (z) {
            r.b bVarO = r.b.O();
            l0 l0Var = this.f602j;
            r.c cVar = bVarO.b;
            if (cVar.d == null) {
                synchronized (cVar.b) {
                    try {
                        if (cVar.d == null) {
                            cVar.d = r.c.O(Looper.getMainLooper());
                        }
                    } finally {
                    }
                }
            }
            cVar.d.post(l0Var);
        }
    }
}
