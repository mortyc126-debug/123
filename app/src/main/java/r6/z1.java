package r6;

import amuvvoafs.os.Build;
import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;
import i6.c;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z1 {
    public static final z1 b;
    public final w1 a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            b = v1.s;
        } else if (i >= 30) {
            b = t1.r;
        } else {
            b = w1.b;
        }
    }

    public z1(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.a = new v1(this, windowInsets);
            return;
        }
        if (i >= 31) {
            this.a = new u1(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.a = new t1(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new s1(this, windowInsets);
        } else if (i >= 28) {
            this.a = new r1(this, windowInsets);
        } else {
            this.a = new q1(this, windowInsets);
        }
    }

    public static c e(c cVar, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, cVar.a - i);
        int iMax2 = Math.max(0, cVar.b - i2);
        int iMax3 = Math.max(0, cVar.c - i3);
        int iMax4 = Math.max(0, cVar.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? cVar : c.c(iMax, iMax2, iMax3, iMax4);
    }

    public static z1 g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        z1 z1Var = new z1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = u0.a;
            z1 z1VarA = m0.a(view);
            w1 w1Var = z1Var.a;
            w1Var.t(z1VarA);
            w1Var.d(view.getRootView());
            w1Var.v(view.getWindowSystemUiVisibility());
        }
        return z1Var;
    }

    public final int a() {
        return this.a.l().d;
    }

    public final int b() {
        return this.a.l().a;
    }

    public final int c() {
        return this.a.l().c;
    }

    public final int d() {
        return this.a.l().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z1) {
            return Objects.equals(this.a, ((z1) obj).a);
        }
        return false;
    }

    public final WindowInsets f() {
        w1 w1Var = this.a;
        if (w1Var instanceof p1) {
            return ((p1) w1Var).c;
        }
        return null;
    }

    public final int hashCode() {
        w1 w1Var = this.a;
        if (w1Var == null) {
            return 0;
        }
        return w1Var.hashCode();
    }

    public z1(z1 z1Var) {
        if (z1Var != null) {
            w1 w1Var = z1Var.a;
            int i = Build.VERSION.SDK_INT;
            if (i >= 34 && (w1Var instanceof v1)) {
                this.a = new v1(this, (v1) w1Var);
            } else if (i >= 31 && (w1Var instanceof u1)) {
                this.a = new u1(this, (u1) w1Var);
            } else if (i >= 30 && (w1Var instanceof t1)) {
                this.a = new t1(this, (t1) w1Var);
            } else if (i >= 29 && (w1Var instanceof s1)) {
                this.a = new s1(this, (s1) w1Var);
            } else if (i >= 28 && (w1Var instanceof r1)) {
                this.a = new r1(this, (r1) w1Var);
            } else if (w1Var instanceof q1) {
                this.a = new q1(this, (q1) w1Var);
            } else if (w1Var instanceof p1) {
                this.a = new p1(this, (p1) w1Var);
            } else {
                this.a = new w1(this);
            }
            w1Var.e(this);
            return;
        }
        this.a = new w1(this);
    }
}
