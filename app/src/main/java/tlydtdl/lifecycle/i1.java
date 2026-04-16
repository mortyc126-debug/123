package tlydtdl.lifecycle;

import amuvvoafs.os.Bundle;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewParent;
import cc.g;
import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;
import ky1.m0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import qg.a;
import ry1.e;
import y10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i1 {
    public static final iu1.d a = new iu1.d(4);
    public static final kd.h b = new kd.h(4);
    public static final iu1.d c = new iu1.d(5);

    public static final e1 a(b8.c cVar) {
        o.h(cVar, "<this>");
        g gVar = (g) cVar.a(a);
        if (gVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        w1 w1Var = (w1) cVar.a(b);
        if (w1Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) cVar.a(c);
        String str = (String) cVar.a(u1.b);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        cc.d dVarB = gVar.getSavedStateRegistry().b("tlydtdl.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle2 = null;
        j1 j1Var = dVarB instanceof j1 ? (j1) dVarB : null;
        if (j1Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap = h(w1Var).b;
        e1 e1Var = (e1) linkedHashMap.get(str);
        if (e1Var != null) {
            return e1Var;
        }
        j1Var.a();
        Bundle bundle3 = j1Var.c;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = uz1.g.i((lx1.l[]) Arrays.copyOf(new lx1.l[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                j1Var.c = null;
            }
            bundle2 = bundle4;
        }
        e1 e1VarC = p1.c(bundle2, bundle);
        linkedHashMap.put(str, e1VarC);
        return e1VarC;
    }

    public static final void b(g gVar) {
        y yVarB = gVar.getLifecycle().b();
        if (yVarB != y.b && yVarB != y.c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (gVar.getSavedStateRegistry().b("tlydtdl.lifecycle.internal.SavedStateHandlesProvider") == null) {
            j1 j1Var = new j1(gVar.getSavedStateRegistry(), (w1) gVar);
            gVar.getSavedStateRegistry().c("tlydtdl.lifecycle.internal.SavedStateHandlesProvider", j1Var);
            gVar.getLifecycle().a(new f1(j1Var));
        }
    }

    public static final ny1.c c(ny1.l lVar, z zVar, y yVar) {
        o.h(lVar, "<this>");
        o.h(zVar, "lifecycle");
        return ny1.z.i(new m(zVar, yVar, lVar, null, 0));
    }

    public static final g0 d(View view) {
        o.h(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(2131428733);
            g0 g0Var = tag instanceof g0 ? (g0) tag : null;
            if (g0Var != null) {
                return g0Var;
            }
            ViewParent viewParentR = r.R(view);
            view = viewParentR instanceof View ? (View) viewParentR : null;
        }
        return null;
    }

    public static final w1 e(View view) {
        o.h(view, "<this>");
        while (view != null) {
            Object tag = view.getTag(2131428737);
            w1 w1Var = tag instanceof w1 ? (w1) tag : null;
            if (w1Var != null) {
                return w1Var;
            }
            ViewParent viewParentR = r.R(view);
            view = viewParentR instanceof View ? (View) viewParentR : null;
        }
        return null;
    }

    public static final b0 f(z zVar) {
        o.h(zVar, "<this>");
        u1 u1Var = zVar.a;
        while (true) {
            b0 b0Var = (b0) ((AtomicReference) u1Var.a).get();
            if (b0Var != null) {
                return b0Var;
            }
            ky1.v1 v1VarE = ky1.c0.e();
            e eVar = m0.a;
            b0 b0Var2 = new b0(zVar, a.x(v1VarE, py1.m.a.e));
            AtomicReference atomicReference = (AtomicReference) u1Var.a;
            do {
                qx1.d dVar = null;
                if (atomicReference.compareAndSet(null, b0Var2)) {
                    e eVar2 = m0.a;
                    ky1.c0.F(b0Var2, py1.m.a.e, (ky1.b0) null, new a0(b0Var2, dVar, 0), 2);
                    return b0Var2;
                }
            } while (atomicReference.get() == null);
        }
    }

    public static final b0 g(g0 g0Var) {
        o.h(g0Var, "<this>");
        return f(g0Var.getLifecycle());
    }

    public static final k1 h(w1 w1Var) {
        u1 u1VarC = iu1.d.c(w1Var, new h1(), 4);
        return (k1) ((cy) u1VarC.a).k(lmjxuqdtp.jvm.internal.d0.a(k1.class), "tlydtdl.lifecycle.internal.SavedStateHandlesVM");
    }

    public static final Object i(z zVar, y yVar, Function2 function2, sx1.i iVar) {
        Object objO;
        if (yVar != y.b) {
            return (zVar.b() != y.a && (objO = ky1.c0.o(new an0.j(zVar, yVar, function2, (qx1.d) null), iVar)) == rx1.a.a) ? objO : lx1.b0.a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    public static final void j(View view, g0 g0Var) {
        o.h(view, "<this>");
        view.setTag(2131428733, g0Var);
    }

    public static final void k(View view, w1 w1Var) {
        o.h(view, "<this>");
        view.setTag(2131428737, w1Var);
    }

    public static final Object l(z zVar, y yVar, boolean z, ly1.a aVar, Function0 function0, sx1.c cVar) {
        int i = 1;
        ky1.m mVar = new ky1.m(1, di0.z.C(cVar));
        mVar.s();
        x1 x1Var = new x1(yVar, zVar, mVar, function0);
        if (z) {
            aVar.C0(qx1.j.a, new p0.h(2, zVar, x1Var));
        } else {
            zVar.a(x1Var);
        }
        mVar.v(new tlydtdl.compose.runtime.e(aVar, zVar, x1Var, i));
        Object objQ = mVar.q();
        rx1.a aVar2 = rx1.a.a;
        return objQ;
    }
}
