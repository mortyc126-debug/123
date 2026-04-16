package tlydtdl.compose.foundation;

import a2.k2;
import a2.q1;
import a2.w3;
import a4.a1;
import a4.l0;
import a4.u;
import a4.w0;
import a5.h;
import amuvvoafs.os.Build;
import amuvvoafs.view.KeyEvent;
import c2.m;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import f3.q2;
import k4.c;
import lmjxuqdtp.jvm.functions.Function0;
import t3.p;
import v1.i;
import v1.k0;
import v1.t;
import v1.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a(p pVar, u uVar, a1 a1Var, float f2) {
        return pVar.then(new BackgroundElement(0L, uVar, f2, a1Var, 1));
    }

    public static /* synthetic */ p b(p pVar, l0 l0Var, a1 a1Var, float f2, int i) {
        if ((i & 2) != 0) {
            a1Var = w0.a;
        }
        if ((i & 4) != 0) {
            f2 = 1.0f;
        }
        return a(pVar, l0Var, a1Var, f2);
    }

    public static final p c(p pVar, long j2, a1 a1Var) {
        return pVar.then(new BackgroundElement(j2, null, 1.0f, a1Var, 2));
    }

    public static final p d(p pVar, m mVar, t0 t0Var, boolean z, h hVar, Function0 function0) {
        ClickableElement clickableElementThen;
        if (t0Var instanceof t0) {
            clickableElementThen = new ClickableElement(mVar, t0Var, false, z, (String) null, hVar, function0);
        } else if (t0Var == null) {
            clickableElementThen = new ClickableElement(mVar, (t0) null, false, z, (String) null, hVar, function0);
        } else {
            t3.m mVar2 = t3.m.a;
            clickableElementThen = mVar != null ? d.a(mVar2, mVar, t0Var).then(new ClickableElement(mVar, (t0) null, false, z, (String) null, hVar, function0)) : j4.i(mVar2, new b(t0Var, z, hVar, function0));
        }
        return pVar.then(clickableElementThen);
    }

    public static /* synthetic */ p e(p pVar, m mVar, q2 q2Var, boolean z, h hVar, Function0 function0, int i) {
        if ((i & 16) != 0) {
            hVar = null;
        }
        return d(pVar, mVar, q2Var, z, hVar, function0);
    }

    public static p f(p pVar, String str, Function0 function0) {
        return pVar.then(new ClickableElement((m) null, (t0) null, true, true, str, (h) null, function0));
    }

    public static p g(p pVar, m mVar, t0 t0Var, boolean z, h hVar, Function0 function0, Function0 function02, Function0 function03, int i) {
        CombinedClickableElement combinedClickableElementThen;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        h hVar2 = (i & 16) != 0 ? null : hVar;
        Function0 function04 = (i & 64) != 0 ? null : function0;
        Function0 function05 = (i & 128) != 0 ? null : function02;
        if (t0Var instanceof t0) {
            combinedClickableElementThen = new CombinedClickableElement(hVar2, mVar, function03, function04, function05, t0Var, z2);
        } else {
            h hVar3 = hVar2;
            if (t0Var == null) {
                combinedClickableElementThen = new CombinedClickableElement(hVar3, mVar, function03, function04, function05, null, z2);
            } else {
                t3.m mVar2 = t3.m.a;
                combinedClickableElementThen = mVar != null ? d.a(mVar2, mVar, t0Var).then(new CombinedClickableElement(hVar3, mVar, function03, function04, function05, null, z2)) : j4.i(mVar2, new c(t0Var, z2, hVar3, function03, function04, function05));
            }
        }
        return pVar.then(combinedClickableElementThen);
    }

    public static final p h() {
        return FocusGroupElement.a;
    }

    public static final p i(p pVar, boolean z, m mVar) {
        return pVar.then(z ? new FocusableElement(mVar) : t3.m.a);
    }

    public static /* synthetic */ p j(p pVar, boolean z, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        return i(pVar, z, null);
    }

    public static p k(p pVar, m mVar) {
        return pVar.then(new HoverableElement(mVar));
    }

    public static final boolean l(KeyEvent keyEvent) {
        long jB = c.B(keyEvent);
        int i = k4.a.z;
        return k4.a.a(jB, k4.a.h) || k4.a.a(jB, k4.a.q) || k4.a.a(jB, k4.a.w) || k4.a.a(jB, k4.a.p);
    }

    public static final p m(p pVar, w3 w3Var, k2 k2Var, boolean z, boolean z2, q1 q1Var, m mVar, boolean z3, i iVar, i2.h hVar) {
        float f2 = t.a;
        k2 k2Var2 = k2.a;
        t3.m mVar2 = t3.m.a;
        return pVar.then(k2Var == k2Var2 ? b4.v(mVar2, k0.c) : b4.v(mVar2, k0.b)).then(new ScrollingContainerElement(hVar, q1Var, k2Var, w3Var, mVar, iVar, z, z2, z3));
    }

    public static final p n(p pVar) {
        return Build.VERSION.SDK_INT < 29 ? pVar : pVar.then(new ExcludeFromSystemGestureElement());
    }
}
