package r6;

import amuvvoafs.view.WindowInsets;
import i6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class q1 extends p1 {
    public c n;

    public q1(z1 z1Var, WindowInsets windowInsets) {
        super(z1Var, windowInsets);
        this.n = null;
    }

    @Override // r6.w1
    public z1 b() {
        return z1.g(null, this.c.consumeStableInsets());
    }

    @Override // r6.w1
    public z1 c() {
        return z1.g(null, this.c.consumeSystemWindowInsets());
    }

    @Override // r6.w1
    public final c j() {
        if (this.n == null) {
            WindowInsets windowInsets = this.c;
            this.n = c.c(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.n;
    }

    @Override // r6.w1
    public boolean o() {
        return this.c.isConsumed();
    }

    @Override // r6.w1
    public void u(c cVar) {
        this.n = cVar;
    }

    public q1(z1 z1Var, q1 q1Var) {
        super(z1Var, q1Var);
        this.n = null;
        this.n = q1Var.n;
    }
}
