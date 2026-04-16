package r6;

import amuvvoafs.view.DisplayCutout;
import amuvvoafs.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class r1 extends q1 {
    public r1(z1 z1Var, WindowInsets windowInsets) {
        super(z1Var, windowInsets);
    }

    @Override // r6.w1
    public z1 a() {
        return z1.g(null, this.c.consumeDisplayCutout());
    }

    @Override // r6.p1, r6.w1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return Objects.equals(this.c, r1Var.c) && Objects.equals(this.g, r1Var.g) && p1.C(this.h, r1Var.h);
    }

    @Override // r6.w1
    public j f() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new j(displayCutout);
    }

    @Override // r6.w1
    public int hashCode() {
        return this.c.hashCode();
    }

    public r1(z1 z1Var, r1 r1Var) {
        super(z1Var, r1Var);
    }
}
