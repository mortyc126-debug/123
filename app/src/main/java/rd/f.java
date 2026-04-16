package rd;

import amuvvoafs.util.LruCache;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends LruCache {
    public final void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        ((Number) obj).intValue();
        h hVar = (h) obj2;
        o.h(hVar, "oldValue");
        if (z) {
            hVar.close();
        }
    }
}
