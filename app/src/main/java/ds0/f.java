package ds0;

import ak.g0;
import amuvvoafs.view.KeyEvent;
import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import hg1.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import ky1.a0;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import m2.l2;
import m2.n1;
import m4.z;
import ny1.b2;
import qi.h;
import qi.y;
import so0.v;
import st.h0;
import st.i0;
import st.l0;
import tlydtdl.activity.ComponentActivity;
import xg0.u0;
import yr.s;
import yr.v7;
import zj.o2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Function1 {
    public final /* synthetic */ int a;
    public Object b;

    public final Object invoke(Object obj) {
        boolean z;
        switch (this.a) {
            case 0:
                KeyEvent keyEventB = ((k4.b) obj).b();
                o.h(keyEventB, "$v$c$tlydtdl-compose-ui-input-key-KeyEvent$-event$0");
                if (k4.a.a(k4.c.B(keyEventB), k4.a.r)) {
                    ((Function0) this.b).invoke();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                ((pg.c) this.b).b();
                return b0.a;
            case 2:
                q4.b0 b0Var = (q4.b0) obj;
                l2 l2VarD = ((n1) this.b).d();
                if (l2VarD != null) {
                    l2VarD.g(b0Var);
                }
                return b0.a;
            case 3:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                z zVar = (z) this.b;
                if (zVar != null) {
                    zVar.c = zBooleanValue;
                }
                return b0.a;
            case 4:
                ((List) this.b).get(((Number) obj).intValue());
                return null;
            case 5:
                ky1.m mVar = (ky1.m) this.b;
                b0 b0Var2 = b0.a;
                mVar.resumeWith(b0Var2);
                return b0Var2;
            case 6:
                int iIntValue = ((Number) obj).intValue();
                l0 l0Var = (l0) this.b;
                py1.d dVar = l0Var.f;
                b2 b2Var = l0Var.j;
                yg0.d dVar2 = l0Var.e;
                v7 v7Var = l0Var.c;
                zr.f fVar = v7Var.E;
                h0 h0Var = (h0) b2Var.a.getValue();
                if (h0Var != null) {
                    String str = h0Var.a;
                    az0.f fVar2 = (az0.f) mx1.o.z0(iIntValue, l0Var.m);
                    Integer numValueOf = fVar2 != null ? Integer.valueOf(fVar2.a) : null;
                    if (numValueOf != null && numValueOf.intValue() == 2132018205) {
                        l0Var.i.g(str, (v) ((Map) l0Var.h.getValue()).get(str));
                        dVar2.c(u0.r);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132019236) {
                        dVar2.c(u0.p);
                        c0.F(dVar, (qx1.i) null, (ky1.b0) null, new i0(l0Var, h0Var, (qx1.d) null, 1), 3);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132019234) {
                        dVar2.c(u0.p);
                        c0.F(dVar, (qx1.i) null, (ky1.b0) null, new i0(l0Var, h0Var, (qx1.d) null, 0), 3);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132019936) {
                        a10.g.U(qf0.b.y(str, h0Var.b), l0Var.d, "track_rename_dialog");
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018361) {
                        o.h(str, "id");
                        fVar.q.m(new s(str, fVar, n71.c.a, (qx1.d) null));
                        y.k(fVar.h.a, "misc_actions", m8.d.n("me_export_track_as_audio"), (h) null, 12);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018360) {
                        o.h(str, "id");
                        fVar.q.m(new s(str, fVar, n71.f.a, (qx1.d) null));
                        y.k(fVar.h.a, "misc_actions", m8.d.n("me_export_track_as_audio"), (h) null, 12);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018967) {
                        o.h(str, "id");
                        fVar.q.m(new o2(str, fVar, (qx1.d) null, 7));
                        y.k(fVar.h.a, "misc_actions", m8.d.n("me_export_track_as_midi"), (h) null, 12);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018189) {
                        o.h(str, "id");
                        c0.F(fVar.b, (qx1.i) null, (ky1.b0) null, new zr.d(1, str, (qx1.d) null, fVar), 3);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132019912) {
                        o.h(str, "id");
                        c0.F(fVar.b, (qx1.i) null, (ky1.b0) null, new zr.d(2, str, (qx1.d) null, fVar), 3);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018974) {
                        o.h(str, "id");
                        r70.a aVar = fVar.p.P;
                        aVar.getClass();
                        c0.F((a0) aVar.c, (qx1.i) null, (ky1.b0) null, new zl.m(aVar, str, (qx1.d) null, 0), 3);
                        fVar.h.c(u0.k);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018949) {
                        o.h(str, "id");
                        fVar.k.b(str);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132017731) {
                        o.h(str, "value");
                        v7Var.K(str);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018344) {
                        o.h(str, "value");
                        v7Var.K(str);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132019131) {
                        o.h(str, "id");
                        r70.a aVar2 = fVar.p.P;
                        aVar2.getClass();
                        c0.F((a0) aVar2.c, (qx1.i) null, (ky1.b0) null, new zl.m(aVar2, str, (qx1.d) null, 1), 3);
                        fVar.h.c(u0.l);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132020104) {
                        v7Var.J(str, true);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132018510) {
                        v7Var.J(str, false);
                    } else if (numValueOf != null && numValueOf.intValue() == 2132019916) {
                        o.h(str, "id");
                        fVar.h.c(u0.s);
                        c0.F(fVar.b, (qx1.i) null, (ky1.b0) null, new zr.d(0, str, (qx1.d) null, fVar), 3);
                    } else {
                        w wVar = new w(2);
                        ArrayList arrayList = wVar.a;
                        wVar.a("CRITICAL");
                        wVar.e(new String[0]);
                        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                        DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Not a valid track option"), (String[]) Arrays.copyOf(strArr, strArr.length)));
                    }
                }
                return null;
            case 7:
                o.h((ComponentActivity) obj, "activity");
                ya0.e eVar = (ya0.e) this.b;
                c0.F(eVar.c, (qx1.i) null, (ky1.b0) null, new ya0.d(eVar, (qx1.d) null, 0), 3);
                return b0.a;
            default:
                o.h((zb0.i) obj, "$this$toLatencyInfo");
                return new hg1.l(q.b(r12.b / ((double) ((g0) this.b).a)));
        }
    }

    public /* synthetic */ f(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
