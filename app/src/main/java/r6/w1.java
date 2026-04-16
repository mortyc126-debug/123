package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import i6.c;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class w1 {
    public static final z1 b;
    public final z1 a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = (i >= 34 ? new n1() : i >= 31 ? new m1() : i >= 30 ? new l1() : i >= 29 ? new k1() : new j1()).b().a.a().a.b().a.c();
    }

    public w1(z1 z1Var) {
        this.a = z1Var;
    }

    public z1 a() {
        return this.a;
    }

    public z1 b() {
        return this.a;
    }

    public z1 c() {
        return this.a;
    }

    public void d(View view) {
    }

    public void e(z1 z1Var) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return p() == w1Var.p() && o() == w1Var.o() && Objects.equals(l(), w1Var.l()) && Objects.equals(j(), w1Var.j()) && Objects.equals(f(), w1Var.f());
    }

    public j f() {
        return null;
    }

    public c g(int i) {
        return c.e;
    }

    public c h(int i) {
        if ((i & 8) == 0) {
            return c.e;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
    }

    public c i() {
        return l();
    }

    public c j() {
        return c.e;
    }

    public c k() {
        return l();
    }

    public c l() {
        return c.e;
    }

    public c m() {
        return l();
    }

    public z1 n(int i, int i2, int i3, int i4) {
        return b;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q(int i) {
        return true;
    }

    public void r(c[] cVarArr) {
    }

    public void s(c cVar) {
    }

    public void t(z1 z1Var) {
    }

    public void u(c cVar) {
    }

    public void v(int i) {
    }
}
