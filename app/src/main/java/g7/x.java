package g7;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x extends WeakReference {
    public final m a;
    public final int b;
    public Object c;

    public x(v vVar, int i, m mVar, ReferenceQueue referenceQueue) {
        super(vVar, referenceQueue);
        this.b = i;
        this.a = mVar;
    }

    public final boolean a() {
        boolean z;
        Object obj = this.c;
        if (obj != null) {
            this.a.c(obj);
            z = true;
        } else {
            z = false;
        }
        this.c = null;
        return z;
    }
}
