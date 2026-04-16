package i5;

import a4.w0;
import amuvvoafs.graphics.Matrix;
import amuvvoafs.view.View;
import amuvvoafs.view.inputmethod.CursorAnchorInfo;
import amuvvoafs.view.inputmethod.InputMethodManager;
import d5.m0;
import lmjxuqdtp.jvm.functions.Function1;
import tlydtdl.compose.foundation.lazy.layout.r1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final t4.x a;
    public final r1 b;
    public boolean d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f217f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public w f218j;
    public m0 k;
    public q l;
    public z3.c n;
    public z3.c o;
    public final Object c = new Object();
    public Function1 m = c.d;
    public final CursorAnchorInfo.Builder p = new CursorAnchorInfo.Builder();
    public final float[] q = a4.m0.a();
    public final Matrix r = new Matrix();

    public d(t4.x xVar, r1 r1Var) {
        this.a = xVar;
        this.b = r1Var;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, lx1.h] */
    public final void a() {
        r1 r1Var = this.b;
        ?? r2 = r1Var.b;
        InputMethodManager inputMethodManager = (InputMethodManager) r2.getValue();
        View view = (View) r1Var.c;
        if (inputMethodManager.isActive(view)) {
            Function1 function1 = this.m;
            float[] fArr = this.q;
            function1.invoke(new a4.m0(fArr));
            this.a.o(fArr);
            Matrix matrix = this.r;
            w0.q(matrix, fArr);
            w wVar = this.f218j;
            lmjxuqdtp.jvm.internal.o.e(wVar);
            q qVar = this.l;
            lmjxuqdtp.jvm.internal.o.e(qVar);
            m0 m0Var = this.k;
            lmjxuqdtp.jvm.internal.o.e(m0Var);
            z3.c cVar = this.n;
            lmjxuqdtp.jvm.internal.o.e(cVar);
            z3.c cVar2 = this.o;
            lmjxuqdtp.jvm.internal.o.e(cVar2);
            ((InputMethodManager) r2.getValue()).updateCursorAnchorInfo(view, tlydtdl.leanback.transition.d.z(this.p, wVar, qVar, m0Var, matrix, cVar, cVar2, this.f217f, this.g, this.h, this.i));
            this.e = false;
        }
    }
}
