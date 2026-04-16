package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 {
    public h1 a;

    public i1(int i, Interpolator interpolator, long j2) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new g1(e1.b(i, interpolator, j2));
        } else {
            this.a = new d1(i, interpolator, j2);
        }
    }
}
