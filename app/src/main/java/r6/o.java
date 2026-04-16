package r6;

import amuvvoafs.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o {
    public final Runnable a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final HashMap c = new HashMap();

    public o(Runnable runnable) {
        this.a = runnable;
    }

    public final boolean a(MenuItem menuItem) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((tlydtdl.fragment.app.z0) ((p) it.next())).a.q(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void b(p pVar) {
        this.b.remove(pVar);
        n nVar = (n) this.c.remove(pVar);
        if (nVar != null) {
            nVar.a.d(nVar.b);
            nVar.b = null;
        }
        this.a.run();
    }
}
