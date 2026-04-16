package um0;

import lx1.b0;
import ny1.l;
import ny1.m;
import rx1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements l {
    public final /* synthetic */ int a;
    public final /* synthetic */ nc0.g b;

    public /* synthetic */ d(nc0.g gVar, int i) {
        this.a = i;
        this.b = gVar;
    }

    public final Object collect(m mVar, qx1.d dVar) {
        switch (this.a) {
            case 0:
                Object objCollect = this.b.collect(new rt0.g(mVar, 15), dVar);
                if (objCollect != a.a) {
                    break;
                }
                break;
            default:
                Object objCollect2 = this.b.collect(new rt0.g(mVar, 16), dVar);
                if (objCollect2 != a.a) {
                    break;
                }
                break;
        }
        return b0.a;
    }
}
