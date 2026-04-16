package r8;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        h hVar = (h) obj;
        h hVar2 = (h) obj2;
        long j2 = hVar.f;
        long j3 = hVar2.f;
        return j2 - j3 == 0 ? hVar.a(hVar2) : j2 < j3 ? -1 : 1;
    }
}
