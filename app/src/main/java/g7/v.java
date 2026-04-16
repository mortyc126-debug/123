package g7;

import amuvvoafs.os.Build;
import amuvvoafs.os.Handler;
import amuvvoafs.os.Looper;
import amuvvoafs.util.Log;
import amuvvoafs.util.SparseIntArray;
import amuvvoafs.view.Choreographer;
import amuvvoafs.view.View;
import bb.a1;
import java.lang.ref.ReferenceQueue;
import tlydtdl.compose.foundation.lazy.layout.r1;
import tlydtdl.fragment.app.k0;
import tlydtdl.lifecycle.g0;
import tlydtdl.lifecycle.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v extends a {
    public static final boolean p = true;
    public final a1 b;
    public boolean c;
    public final x[] d;
    public final View e;

    /* JADX INFO: renamed from: f */
    public c f178f;
    public boolean g;
    public final Choreographer h;
    public final s i;

    /* JADX INFO: renamed from: j */
    public final Handler f179j;
    public v k;
    public g0 l;
    public t m;
    public boolean n;
    public static final int o = Build.VERSION.SDK_INT;
    public static final p q = new p(0);
    public static final q r = new q();
    public static final ReferenceQueue s = new ReferenceQueue();
    public static final r t = new r();

    public v(int i, View view, Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.gnacba.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
        }
        this.b = new a1(5, this);
        this.c = false;
        this.d = new x[i];
        this.e = view;
        if (Looper.myLooper() == null) {
            throw new IllegalStateException("DataBinding must be created in view's UI Thread");
        }
        if (p) {
            this.h = Choreographer.getInstance();
            this.i = new s(this);
        } else {
            this.i = null;
            this.f179j = new Handler(Looper.myLooper());
        }
    }

    public static int l(View view, int i) {
        return view.getContext().getColor(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void o(amuvvoafs.view.View r21, java.lang.Object[] r22, tlydtdl.compose.foundation.lazy.layout.r1 r23, amuvvoafs.util.SparseIntArray r24, boolean r25) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.v.o(amuvvoafs.view.View, java.lang.Object[], tlydtdl.compose.foundation.lazy.layout.r1, amuvvoafs.util.SparseIntArray, boolean):void");
    }

    public static Object[] p(View view, int i, r1 r1Var, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        o(view, objArr, r1Var, sparseIntArray, true);
        return objArr;
    }

    public static float t(Float f2) {
        if (f2 == null) {
            return 0.0f;
        }
        return f2.floatValue();
    }

    public static int u(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static boolean v(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public abstract void i();

    public final void j() {
        if (this.g) {
            s();
            return;
        }
        if (m()) {
            this.g = true;
            c cVar = this.f178f;
            if (cVar != null) {
                cVar.d(this, 1);
            }
            i();
            c cVar2 = this.f178f;
            if (cVar2 != null) {
                cVar2.d(this, 3);
            }
            this.g = false;
        }
    }

    public final void k() {
        v vVar = this.k;
        if (vVar == null) {
            j();
        } else {
            vVar.k();
        }
    }

    public abstract boolean m();

    public abstract void n();

    public abstract boolean q(int i, int i2, Object obj);

    public final void r(int i, Object obj, d dVar) {
        if (obj == null) {
            return;
        }
        x[] xVarArr = this.d;
        x xVarA = xVarArr[i];
        if (xVarA == null) {
            xVarA = dVar.a(this, i, s);
            xVarArr[i] = xVarA;
            g0 g0Var = this.l;
            if (g0Var != null) {
                xVarA.a.b(g0Var);
            }
        }
        xVarA.a();
        xVarA.c = obj;
        xVarA.a.e(obj);
    }

    public final void s() {
        v vVar = this.k;
        if (vVar != null) {
            vVar.s();
            return;
        }
        g0 g0Var = this.l;
        if (g0Var == null || g0Var.getLifecycle().b().compareTo(y.d) >= 0) {
            synchronized (this) {
                try {
                    if (this.c) {
                        return;
                    }
                    this.c = true;
                    if (p) {
                        this.h.postFrameCallback(this.i);
                    } else {
                        this.f179j.post(this.b);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void w(g0 g0Var) {
        if (g0Var instanceof k0) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        g0 g0Var2 = this.l;
        if (g0Var2 == g0Var) {
            return;
        }
        if (g0Var2 != null) {
            g0Var2.getLifecycle().d(this.m);
        }
        this.l = g0Var;
        if (g0Var != null) {
            if (this.m == null) {
                this.m = new t(this);
            }
            g0Var.getLifecycle().a(this.m);
        }
        for (x xVar : this.d) {
            if (xVar != null) {
                xVar.a.b(g0Var);
            }
        }
    }

    public final void x(View view) {
        view.setTag(2131427738, this);
    }

    public abstract boolean y(int i, Object obj);

    public final void z(int i, b bVar) {
        x[] xVarArr = this.d;
        if (bVar == null) {
            x xVar = xVarArr[i];
            if (xVar != null) {
                xVar.a();
                return;
            }
            return;
        }
        x xVar2 = xVarArr[i];
        p pVar = q;
        if (xVar2 == null) {
            r(i, bVar, pVar);
        } else {
            if (xVar2.c == bVar) {
                return;
            }
            xVar2.a();
            r(i, bVar, pVar);
        }
    }
}
