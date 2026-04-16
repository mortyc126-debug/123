package kg0;

import a70.q;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import gp.q0;
import gp.r0;
import java.util.List;
import je.s;
import k7.w;
import ky1.b0;
import ky1.c0;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.d;
import lmjxuqdtp.jvm.internal.k;
import lu0.u;
import lu0.v;
import me1.m;
import ng0.f;
import ny1.r2;
import og0.b;
import qi.y;
import qx1.i;
import wk.l;
import wk.n;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e extends k implements Function0 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, i2, cls, obj, str, str2);
        this.b = i3;
    }

    public final Object invoke() {
        switch (this.b) {
            case 0:
                h.c((h) ((d) this).receiver);
                break;
            case 1:
                r2 r2Var = ((h) ((d) this).receiver).k;
                Boolean bool = Boolean.FALSE;
                r2Var.getClass();
                r2Var.i((Object) null, bool);
                break;
            case 2:
                h hVar = (h) ((d) this).receiver;
                c0.F(hVar.b, (i) null, (b0) null, new c(hVar, (qx1.d) null, 1), 3);
                break;
            case 3:
                h hVar2 = (h) ((d) this).receiver;
                Object value = hVar2.o.a.getValue();
                lg0.e eVar = value instanceof lg0.e ? (lg0.e) value : null;
                if (eVar != null) {
                    boolean zF = eVar.f();
                    wl.e eVar2 = hVar2.i;
                    c0.F(eVar2.f, (i) null, (b0) null, new q(eVar2, !zF, (qx1.d) null, 28), 3);
                }
                break;
            case 4:
                h hVar3 = (h) ((d) this).receiver;
                w wVar = hVar3.f264j;
                Float f2 = (Float) wVar.a.getValue();
                if (f2 != null) {
                    hVar3.i.e.e(f2.floatValue());
                    wVar.a.setValue((Object) null);
                }
                break;
            case 5:
                wl.e eVar3 = ((h) ((d) this).receiver).i;
                wl.h hVar4 = eVar3.o;
                lx1.b0 b0Var = lx1.b0.a;
                if (hVar4 == null) {
                    DebugUtils.debugThrowReturn("extendedBars is null", b0Var);
                } else {
                    int iB = hVar4.b();
                    eVar3.e.k = false;
                    eVar3.b(iB, true);
                }
                break;
            case 6:
                h hVar5 = (h) ((d) this).receiver;
                wl.e eVar4 = hVar5.i;
                Object value2 = hVar5.o.a.getValue();
                lg0.e eVar5 = value2 instanceof lg0.e ? (lg0.e) value2 : null;
                if (eVar5 != null) {
                    wl.e eVar6 = eVar4;
                    if (eVar5.isPlaying()) {
                        eVar6.e.b();
                    } else {
                        eVar6.e.c();
                    }
                }
                break;
            case 7:
                ((q0) ((d) this).receiver).a();
                break;
            case 8:
                kp.e eVar7 = (kp.e) ((d) this).receiver;
                y.k((y) eVar7.a.b, "log_in_with_email", (List) null, (qi.h) null, 14);
                c0.F(eVar7.f267f, (i) null, (b0) null, new s(eVar7, eVar7.h.a(), eVar7.i.a(), (qx1.d) null, 8), 3);
                break;
            case 9:
                ((r0) ((d) this).receiver).b();
                break;
            case 10:
                ((r0) ((d) this).receiver).a();
                break;
            case 11:
                ((u) ((d) this).receiver).d();
                break;
            case 12:
                ((u) ((d) this).receiver).h();
                break;
            case 13:
                ((v) ((d) this).receiver).c();
                break;
            case 14:
                ((v) ((d) this).receiver).b();
                break;
            case 15:
                ((u) ((d) this).receiver).goBack();
                break;
            case 16:
                ((u) ((d) this).receiver).m();
                break;
            case 17:
                ((u) ((d) this).receiver).f();
                break;
            case 18:
                ((u) ((d) this).receiver).i();
                break;
            case 19:
                ((m) ((d) this).receiver).b();
                break;
            case 20:
                ((xl.g) ((f) ((d) this).receiver).g).g(wk.k.a);
                break;
            case 21:
                ((xl.g) ((f) ((d) this).receiver).g).g(wk.k.b);
                break;
            case 22:
                f fVar = (f) ((d) this).receiver;
                c0.F(fVar.a, (i) null, (b0) null, new ng0.d(fVar, (qx1.d) null, 0), 3);
                break;
            case 23:
                f fVar2 = (f) ((d) this).receiver;
                if (fVar2.k.a.getValue() instanceof b) {
                    r2 r2Var2 = fVar2.i;
                    Boolean bool2 = Boolean.TRUE;
                    r2Var2.getClass();
                    r2Var2.i((Object) null, bool2);
                } else {
                    xl.g gVar = (xl.g) fVar2.g;
                    gVar.k("canceled");
                    gVar.j();
                }
                break;
            case 24:
                f fVar3 = (f) ((d) this).receiver;
                r2 r2Var3 = fVar3.i;
                Boolean bool3 = Boolean.FALSE;
                r2Var3.getClass();
                r2Var3.i((Object) null, bool3);
                xl.g gVar2 = (xl.g) fVar3.g;
                gVar2.k("canceled");
                gVar2.j();
                break;
            case 25:
                r2 r2Var4 = ((f) ((d) this).receiver).i;
                Boolean bool4 = Boolean.FALSE;
                r2Var4.getClass();
                r2Var4.i((Object) null, bool4);
                break;
            case 26:
                f fVar4 = (f) ((d) this).receiver;
                c0.F(fVar4.a, (i) null, (b0) null, new ng0.d(fVar4, (qx1.d) null, 1), 3);
                break;
            case 27:
                f fVar5 = (f) ((d) this).receiver;
                Object value3 = fVar5.k.a.getValue();
                b bVar = value3 instanceof b ? (b) value3 : null;
                if (bVar != null) {
                    boolean zF2 = bVar.f();
                    xl.g gVar3 = (xl.g) fVar5.g;
                    c0.F(gVar3.f694f, (i) null, (b0) null, new xl.e(gVar3, !zF2, (qx1.d) null), 3);
                }
                break;
            case 28:
                f fVar6 = (f) ((d) this).receiver;
                w wVar2 = fVar6.h;
                Float f3 = (Float) wVar2.a.getValue();
                if (f3 != null) {
                    ((xl.g) fVar6.g).e.e(f3.floatValue());
                    wVar2.a.setValue((Object) null);
                }
                break;
            default:
                xl.g gVar4 = (xl.g) ((f) ((d) this).receiver).g;
                xl.h hVar6 = gVar4.e;
                l lVarD = xl.g.d((n) gVar4.n.getValue());
                if ((lVarD != null ? lVarD.f662j : null) == wk.k.b) {
                    hVar6.b();
                    hVar6.e(0.0f);
                }
                gVar4.i(true);
                break;
        }
        return lx1.b0.a;
    }
}
