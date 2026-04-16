package js0;

import com.bandlab.arrangement.view.pendant.TrackPendantView;
import f3.f2;
import gp.c0;
import gp.e0;
import gp.f0;
import gp.i0;
import gp.l0;
import gp.m0;
import gp.n0;
import gp.o0;
import gp.z;
import ky1.x;
import lj.a;
import lj.b;
import lj.c;
import lj.d;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import s1.d0;
import s1.q0;
import s1.s;
import s1.x0;
import s1.y0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j0 implements Function1 {
    public final /* synthetic */ int a;

    public /* synthetic */ j0(int i) {
        this.a = i;
    }

    private final Object a(Object obj) {
        x xVar = (qx1.g) obj;
        if (xVar instanceof x) {
            return xVar;
        }
        return null;
    }

    private final Object b(Object obj) {
        return Float.valueOf(((Float) obj).floatValue() * 0.5f);
    }

    private final Object c(Object obj) throws NoWhenBranchMatchedException {
        String strC;
        String str;
        d dVar = (d) obj;
        int i = TrackPendantView.n;
        c cVar = dVar != null ? dVar.a : null;
        if (cVar == null) {
            return "hidden";
        }
        if (cVar instanceof a) {
            strC = dVar.a.c();
            str = "automation";
        } else {
            if (!(cVar instanceof b)) {
                throw new NoWhenBranchMatchedException();
            }
            strC = dVar.a.c();
            str = "takes";
        }
        return f2.k(str, strC);
    }

    private final Object d(Object obj) {
        int i = TrackPendantView.n;
        o.h((s) obj, "$this$AnimatedContent");
        x0 x0VarE = q0.e(t1.c.t(220, 90, (t1.w) null, 4), 2);
        y0 y0VarF = q0.f(t1.c.t(90, 0, (t1.w) null, 6), 2);
        int i2 = tlydtdl.compose.animation.a.b;
        return new d0(x0VarE, y0VarF);
    }

    private final Object e(Object obj) throws NoWhenBranchMatchedException {
        o0 o0Var = (o0) obj;
        o.h(o0Var, "key");
        if (o0Var.equals(z.INSTANCE)) {
            return new pp.a();
        }
        if (o0Var instanceof c0) {
            return new pp.e();
        }
        if (o0Var.equals(e0.INSTANCE)) {
            return new mp.a();
        }
        if (o0Var.equals(f0.INSTANCE)) {
            return new mp.d();
        }
        if (o0Var instanceof i0) {
            return new kp.a();
        }
        if (o0Var instanceof l0) {
            return new np.b();
        }
        if (o0Var.equals(m0.INSTANCE)) {
            return new op.a();
        }
        if (o0Var.equals(n0.INSTANCE)) {
            return new qp.a();
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Object f(Object obj) {
        o.h((mv0.g) obj, "<this>");
        return b0.a;
    }

    private final Object g(Object obj) {
        o.h((mv0.a) obj, "<this>");
        return b0.a;
    }

    private final Object i(Object obj) {
        int i = m2.y.b;
        return b0.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:432:0x03fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r86) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 2592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: js0.j0.invoke(java.lang.Object):java.lang.Object");
    }
}
