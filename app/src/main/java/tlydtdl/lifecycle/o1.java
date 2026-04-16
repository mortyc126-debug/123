package tlydtdl.lifecycle;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o1 {
    public final d8.c a = new d8.c();

    public final void a(String str, AutoCloseable autoCloseable) {
        AutoCloseable autoCloseable2;
        d8.c cVar = this.a;
        if (cVar != null) {
            if (cVar.d) {
                d8.c.a(autoCloseable);
                return;
            }
            synchronized (cVar.a) {
                autoCloseable2 = (AutoCloseable) cVar.b.put(str, autoCloseable);
            }
            d8.c.a(autoCloseable2);
        }
    }

    public final void b() {
        d8.c cVar = this.a;
        if (cVar != null && !cVar.d) {
            cVar.d = true;
            synchronized (cVar.a) {
                try {
                    Iterator it = cVar.b.values().iterator();
                    while (it.hasNext()) {
                        d8.c.a((AutoCloseable) it.next());
                    }
                    Iterator it2 = cVar.c.iterator();
                    while (it2.hasNext()) {
                        d8.c.a((AutoCloseable) it2.next());
                    }
                    cVar.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        d();
    }

    public final AutoCloseable c(String str) {
        AutoCloseable autoCloseable;
        d8.c cVar = this.a;
        if (cVar == null) {
            return null;
        }
        synchronized (cVar.a) {
            autoCloseable = (AutoCloseable) cVar.b.get(str);
        }
        return autoCloseable;
    }

    public void d() {
    }
}
