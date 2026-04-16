package r6;

import amuvvoafs.view.WindowInsets;
import i6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class s1 extends r1 {
    public c o;
    public c p;
    public c q;

    public s1(z1 z1Var, WindowInsets windowInsets) {
        super(z1Var, windowInsets);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    @Override // r6.w1
    public c i() {
        if (this.p == null) {
            this.p = c.d(this.c.getMandatorySystemGestureInsets());
        }
        return this.p;
    }

    @Override // r6.w1
    public c k() {
        if (this.o == null) {
            this.o = c.d(this.c.getSystemGestureInsets());
        }
        return this.o;
    }

    @Override // r6.w1
    public c m() {
        if (this.q == null) {
            this.q = c.d(this.c.getTappableElementInsets());
        }
        return this.q;
    }

    @Override // r6.p1, r6.w1
    public z1 n(int i, int i2, int i3, int i4) {
        return z1.g(null, this.c.inset(i, i2, i3, i4));
    }

    @Override // r6.q1, r6.w1
    public void u(c cVar) {
    }

    public s1(z1 z1Var, s1 s1Var) {
        super(z1Var, s1Var);
        this.o = null;
        this.p = null;
        this.q = null;
    }
}
