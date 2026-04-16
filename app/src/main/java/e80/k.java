package e80;

import amuvvoafs.view.View;
import amuvvoafs.view.inputmethod.CursorAnchorInfo;
import g7.v;
import g7.x;
import java.util.Collection;
import k7.g0;
import ke0.n;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import p02.r0;
import qx1.d;
import t4.h2;
import tlydtdl.compose.foundation.lazy.layout.r1;
import xu1.e0;
import xu1.s0;
import xu1.v0;
import yr.x4;
import zj.u2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements ny1.m {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object emit(Object obj, d dVar) {
        switch (this.a) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                a aVar = (a) this.b;
                if (iIntValue != aVar.c) {
                    aVar.e.invoke(new Integer(iIntValue));
                }
                break;
            case 1:
                x xVar = (x) ((r1) this.b).d;
                v vVar = (v) xVar.get();
                if (vVar == null) {
                    xVar.a();
                }
                if (vVar != null) {
                    int i = xVar.b;
                    Object obj2 = xVar.c;
                    if (!vVar.n && vVar.q(i, 0, obj2)) {
                        vVar.s();
                    }
                }
                break;
            case 2:
                k7.v vVar2 = (k7.v) this.b;
                if ((vVar2.h.c() instanceof g0) || (r3 = k7.v.e(vVar2, true, dVar)) != rx1.a.a) {
                }
                break;
            case 3:
                ((lmjxuqdtp.jvm.internal.k) this.b).invoke(new Integer(((Number) obj).intValue()));
                break;
            case 4:
                ((Collection) this.b).add(obj);
                break;
            case 5:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                ne0.h hVar = ((q90.g) this.b).c;
                if (zBooleanValue) {
                    hVar.d(false);
                } else {
                    hVar.b().e(hVar.i);
                    if (!(((n) hVar.g.getValue()) instanceof ke0.m)) {
                        hVar.d(false);
                    }
                }
                break;
            case 6:
                ((h2) this.b).a.i(((Number) obj).floatValue());
                break;
            case 7:
                ((Function1) this.b).invoke(new p5.f(((p5.f) obj).a));
                break;
            case 8:
                ((w2.j) this.b).j();
                break;
            case 9:
                w2.j jVar = (w2.j) ((r0) this.b).g;
                jVar.h().updateCursorAnchorInfo((View) jVar.a, (CursorAnchorInfo) obj);
                break;
            case 10:
                e0 e0Var = (e0) obj;
                v0 v0Var = (v0) this.b;
                o.h(e0Var, "<set-?>");
                v0Var.h = e0Var;
                Object objA = v0.a(v0Var, e0Var.a.a, s0.a, dVar);
                if (objA != rx1.a.a) {
                    break;
                }
                break;
            default:
                float fFloatValue = ((Number) obj).floatValue();
                u2 u2Var = ((x4) this.b).f;
                float f2 = 1.0f / fFloatValue;
                u2Var.getClass();
                u2Var.j(f2 <= 0.25f ? dm.j.r : (0.25f > f2 || f2 > 0.5f) ? (0.5f > f2 || f2 > 2.0f) ? (2.0f > f2 || f2 > 4.0f) ? f2 > 4.0f ? dm.j.e : dm.j.l : dm.j.i : dm.j.l : dm.j.o);
                break;
        }
        return b0.a;
    }

    public k(Function1 function1) {
        this.a = 3;
        this.b = (lmjxuqdtp.jvm.internal.k) function1;
    }
}
