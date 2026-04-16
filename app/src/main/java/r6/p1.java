package r6;

import amuvvoafs.annotation.SuppressLint;
import amuvvoafs.graphics.Rect;
import amuvvoafs.os.Build;
import amuvvoafs.util.Log;
import amuvvoafs.view.View;
import amuvvoafs.view.WindowInsets;
import i6.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class p1 extends w1 {
    public static boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Method f396j;
    public static Class k;
    public static Field l;
    public static Field m;
    public final WindowInsets c;
    public c[] d;
    public c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z1 f397f;
    public c g;
    public int h;

    public p1(z1 z1Var, WindowInsets windowInsets) {
        super(z1Var);
        this.e = null;
        this.c = windowInsets;
    }

    @SuppressLint({"PrivateApi"})
    private static void B() {
        try {
            f396j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("amuvvoafs.view.View$AttachInfo");
            k = cls;
            l = cls.getDeclaredField("mVisibleInsets");
            m = Class.forName("amuvvoafs.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            l.setAccessible(true);
            m.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        i = true;
    }

    public static boolean C(int i2, int i3) {
        return (i2 & 6) == (i3 & 6);
    }

    @SuppressLint({"WrongConstant"})
    private c w(int i2, boolean z) {
        c cVarA = c.e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                cVarA = c.a(cVarA, x(i3, z));
            }
        }
        return cVarA;
    }

    private c y() {
        z1 z1Var = this.f397f;
        return z1Var != null ? z1Var.a.j() : c.e;
    }

    private c z(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!i) {
            B();
        }
        Method method = f396j;
        if (method != null && k != null && l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) l.get(m.get(objInvoke));
                if (rect != null) {
                    return c.c(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    public boolean A(int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 8 && i2 != 128) {
                return true;
            }
        }
        return !x(i2, false).equals(c.e);
    }

    @Override // r6.w1
    public void d(View view) {
        c cVarZ = z(view);
        if (cVarZ == null) {
            cVarZ = c.e;
        }
        s(cVarZ);
    }

    @Override // r6.w1
    public void e(z1 z1Var) {
        z1Var.a.t(this.f397f);
        c cVar = this.g;
        w1 w1Var = z1Var.a;
        w1Var.s(cVar);
        w1Var.v(this.h);
    }

    @Override // r6.w1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return Objects.equals(this.g, p1Var.g) && C(this.h, p1Var.h);
    }

    @Override // r6.w1
    public c g(int i2) {
        return w(i2, false);
    }

    @Override // r6.w1
    public c h(int i2) {
        return w(i2, true);
    }

    @Override // r6.w1
    public final c l() {
        if (this.e == null) {
            WindowInsets windowInsets = this.c;
            this.e = c.c(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // r6.w1
    public z1 n(int i2, int i3, int i4, int i6) {
        z1 z1VarG = z1.g(null, this.c);
        int i7 = Build.VERSION.SDK_INT;
        o1 n1Var = i7 >= 34 ? new n1(z1VarG) : i7 >= 31 ? new m1(z1VarG) : i7 >= 30 ? new l1(z1VarG) : i7 >= 29 ? new k1(z1VarG) : new j1(z1VarG);
        n1Var.g(z1.e(l(), i2, i3, i4, i6));
        n1Var.e(z1.e(j(), i2, i3, i4, i6));
        return n1Var.b();
    }

    @Override // r6.w1
    public boolean p() {
        return this.c.isRound();
    }

    @Override // r6.w1
    @SuppressLint({"WrongConstant"})
    public boolean q(int i2) {
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0 && !A(i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // r6.w1
    public void r(c[] cVarArr) {
        this.d = cVarArr;
    }

    @Override // r6.w1
    public void s(c cVar) {
        this.g = cVar;
    }

    @Override // r6.w1
    public void t(z1 z1Var) {
        this.f397f = z1Var;
    }

    @Override // r6.w1
    public void v(int i2) {
        this.h = i2;
    }

    public c x(int i2, boolean z) {
        c cVarJ;
        int i3;
        c cVar = c.e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 8) {
                    c[] cVarArr = this.d;
                    cVarJ = cVarArr != null ? cVarArr[x30.c.v(8)] : null;
                    if (cVarJ != null) {
                        return cVarJ;
                    }
                    c cVarL = l();
                    c cVarY = y();
                    int i4 = cVarL.d;
                    if (i4 > cVarY.d) {
                        return c.c(0, 0, 0, i4);
                    }
                    c cVar2 = this.g;
                    if (cVar2 != null && !cVar2.equals(cVar) && (i3 = this.g.d) > cVarY.d) {
                        return c.c(0, 0, 0, i3);
                    }
                } else {
                    if (i2 == 16) {
                        return k();
                    }
                    if (i2 == 32) {
                        return i();
                    }
                    if (i2 == 64) {
                        return m();
                    }
                    if (i2 == 128) {
                        z1 z1Var = this.f397f;
                        j jVarF = z1Var != null ? z1Var.a.f() : f();
                        if (jVarF != null) {
                            int i6 = Build.VERSION.SDK_INT;
                            return c.c(i6 >= 28 ? a3.f1.o(jVarF.a) : 0, i6 >= 28 ? a3.f1.q(jVarF.a) : 0, i6 >= 28 ? a3.f1.p(jVarF.a) : 0, i6 >= 28 ? a3.f1.n(jVarF.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    c cVarY2 = y();
                    c cVarJ2 = j();
                    return c.c(Math.max(cVarY2.a, cVarJ2.a), 0, Math.max(cVarY2.c, cVarJ2.c), Math.max(cVarY2.d, cVarJ2.d));
                }
                if ((this.h & 2) == 0) {
                    c cVarL2 = l();
                    z1 z1Var2 = this.f397f;
                    cVarJ = z1Var2 != null ? z1Var2.a.j() : null;
                    int iMin = cVarL2.d;
                    if (cVarJ != null) {
                        iMin = Math.min(iMin, cVarJ.d);
                    }
                    return c.c(cVarL2.a, 0, cVarL2.c, iMin);
                }
            }
        } else {
            if (z) {
                return c.c(0, Math.max(y().b, l().b), 0, 0);
            }
            if ((this.h & 4) == 0) {
                return c.c(0, l().b, 0, 0);
            }
        }
        return cVar;
    }

    public p1(z1 z1Var, p1 p1Var) {
        this(z1Var, new WindowInsets(p1Var.c));
    }
}
