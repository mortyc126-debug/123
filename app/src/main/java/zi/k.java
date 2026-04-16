package zi;

import java.util.concurrent.atomic.AtomicBoolean;
import ny1.g2;
import ny1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final Object a;
    public final wy1.a b;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final g2 d = z.b(1, 1, (my1.c) null, 4);
    public Object e;

    public k(Object obj, wy1.a aVar) {
        this.a = obj;
        this.b = aVar;
        this.e = obj;
    }

    public final void a(Object obj) {
        this.c.set(true);
        this.e = obj;
        this.d.a(obj);
    }
}
