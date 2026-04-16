package hj;

import amuvvoafs.content.Context;
import amuvvoafs.graphics.Paint;
import com.bandlab.arrangement.view.ArrangementView;
import i6.b;
import ij.q;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 {
    public final Context a;
    public final ky1.a0 b;
    public final ArrangementView c;
    public k2 d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t1 f210f;
    public final j2 g;
    public final m0 h;
    public c3 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f211j;

    public t2(Context context, k2 k2Var, float f2, j3 j3Var, l2 l2Var, h2 h2Var, k1 k1Var, ky1.a0 a0Var, ArrangementView arrangementView, c3 c3Var, g0 g0Var) {
        o.h(j3Var, "zoomConverter");
        o.h(l2Var, "trackAttributes");
        o.h(h2Var, "headerAttributes");
        o.h(k1Var, "regionAttributes");
        o.h(a0Var, "scope");
        o.h(c3Var, "initialState");
        this.a = context;
        this.b = a0Var;
        this.c = arrangementView;
        this.d = k2Var;
        this.e = f2;
        Map map = c3Var.c;
        b3 b3Var = c3Var.b;
        int iP = qg.a.p(context, b3Var.g);
        ij.j jVar = c3Var.d;
        this.f210f = new t1(f2, k2Var, j3Var, k1Var, a0Var, arrangementView, map, iP, !(jVar.b instanceof q), true);
        this.g = new j2(context, k2Var.d, h2Var, this.e, c3Var.b);
        this.h = new m0(j3Var, k2Var.d, this.e, c3Var.a, a0Var, new fz0.o(10, this), g0Var, jVar, b3Var.e);
        this.i = c3Var;
        Paint paint = new Paint();
        paint.setColor(b.g(qg.a.p(context, b3Var.g), 50));
        this.f211j = paint;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final hj.s2 a(hg1.o r13) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: hj.t2.a(hg1.o):hj.s2");
    }
}
