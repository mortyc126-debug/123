package cu0;

import ak.g3;
import lx1.b0;
import ny1.m;
import qx1.d;
import rx1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements ny1.l {
    public final /* synthetic */ int a;
    public final /* synthetic */ g3 b;

    public /* synthetic */ n(g3 g3Var, int i) {
        this.a = i;
        this.b = g3Var;
    }

    public final Object collect(m mVar, d dVar) {
        switch (this.a) {
            case 0:
                Object objCollect = this.b.collect(new bz.d(mVar, 22), dVar);
                if (objCollect != a.a) {
                    break;
                }
                break;
            default:
                Object objCollect2 = this.b.collect(new bz.d(mVar, 23), dVar);
                if (objCollect2 != a.a) {
                    break;
                }
                break;
        }
        return b0.a;
    }
}
