package r6;

import amuvvoafs.view.WindowInsets;
import i6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends u1 {
    public static final z1 s = z1.g(null, WindowInsets.CONSUMED);

    public v1(z1 z1Var, WindowInsets windowInsets) {
        super(z1Var, windowInsets);
    }

    @Override // r6.t1, r6.p1, r6.w1
    public c g(int i) {
        return c.d(this.c.getInsets(y1.a(i)));
    }

    @Override // r6.t1, r6.p1, r6.w1
    public c h(int i) {
        return c.d(this.c.getInsetsIgnoringVisibility(y1.a(i)));
    }

    @Override // r6.t1, r6.p1, r6.w1
    public boolean q(int i) {
        return this.c.isVisible(y1.a(i));
    }

    public v1(z1 z1Var, v1 v1Var) {
        super(z1Var, v1Var);
    }
}
