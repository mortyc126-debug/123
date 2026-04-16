package y8;

import amuvvoafs.os.Handler;
import v8.c1;
import w8.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public final Handler a;
    public final j b;

    public i(Handler handler, j jVar) {
        if (jVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.a = handler;
        this.b = jVar;
    }

    public final void a(f fVar) {
        synchronized (fVar) {
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new c1(15, this, fVar));
        }
    }
}
