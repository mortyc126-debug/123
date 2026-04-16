package gl;

import com.bandlab.artist.dashboard.ArtistDashboardActivity;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import gn0.b;
import gn0.j;
import gp.m0;
import gp.q0;
import gp.r0;
import hg1.q;
import k80.u;
import ky1.c0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.k;
import lmjxuqdtp.jvm.internal.o;
import lx0.m;
import lx1.b0;
import ny1.r2;
import o10.a4;
import qi.y;
import qj.r;
import qx1.i;
import tlydtdl.lifecycle.i1;
import tlydtdl.lifecycle.z;
import xu0.l;
import xu0.p;
import zj.n;
import zj.u2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h extends k implements Function0 {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, i2, cls, obj, str, str2);
        this.b = i3;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke() throws NoWhenBranchMatchedException {
        Object value;
        int i = this.b;
        b0 b0Var = b0.a;
        switch (i) {
            case 0:
                ((n) ((lmjxuqdtp.jvm.internal.d) this).receiver).h();
                return b0Var;
            case 1:
                j jVar = (j) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                r2 r2Var = jVar.D;
                u2 u2Var = jVar.i;
                b bVar = new b(((q) u2Var.c().getValue()).a, u2Var.d());
                r2Var.getClass();
                r2Var.i((Object) null, bVar);
                u2Var.l();
                return b0Var;
            case 2:
                j jVar2 = (j) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                r2 r2Var2 = jVar2.D;
                u2 u2Var2 = jVar2.i;
                do {
                    value = r2Var2.getValue();
                    b bVar2 = (b) value;
                    if (bVar2 != null) {
                        u2Var2.h(bVar2.b(), true);
                        if (bVar2.c()) {
                            u2Var2.f();
                        }
                    }
                } while (!r2Var2.d(value, (Object) null));
                return b0Var;
            case 3:
                r2 r2Var3 = ((gn0.k) ((lmjxuqdtp.jvm.internal.d) this).receiver).d.w;
                Boolean bool = Boolean.TRUE;
                r2Var3.getClass();
                r2Var3.i((Object) null, bool);
                return b0Var;
            case 4:
                gn0.k kVar = (gn0.k) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                ed0.e eVar = (ed0.e) kVar.e.d.getValue();
                if (eVar.c && eVar.b() && !kVar.a.f()) {
                    kVar.c.e(kVar.b.b(tlydtdl.leanback.transition.d.J(eVar), m.INSTANCE));
                } else {
                    c0.F(kVar.f, (i) null, (ky1.b0) null, new fg0.d(kVar, (qx1.d) null, 9), 3);
                }
                return b0Var;
            case 5:
                ((q0) ((lmjxuqdtp.jvm.internal.d) this).receiver).a.b(m0.INSTANCE);
                return b0Var;
            case 6:
                ((r0) ((lmjxuqdtp.jvm.internal.d) this).receiver).b();
                return b0Var;
            case 7:
                ((r0) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 8:
                is0.g gVar = (is0.d) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                boolean z = ((is0.a) gVar.g.a.getValue()).b;
                boolean z2 = !z;
                y.k(gVar.c.a, "me_settings_actions", m8.d.n(!z ? "snap_on" : "snap_off"), (qi.h) null, 12);
                if (gVar.e.a(z2)) {
                    gVar.d.j(!z ? 2132019117 : 2132019116);
                }
                return b0Var;
            case 9:
                int iOrdinal = ((gt.b) ((i80.i) ((lmjxuqdtp.jvm.internal.d) this).receiver).d.a().e).ordinal();
                if (iOrdinal == 0) {
                    return a4.c;
                }
                if (iOrdinal == 1) {
                    return a4.b;
                }
                if (iOrdinal == 2) {
                    return a4.d;
                }
                if (iOrdinal == 3) {
                    return a4.g;
                }
                if (iOrdinal == 4) {
                    return a4.s;
                }
                throw new NoWhenBranchMatchedException();
            case 10:
                ((b80.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 11:
                i80.i iVar = (i80.i) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                p pVar = iVar.h;
                qj.g gVar2 = iVar.a.c;
                int i2 = ArtistDashboardActivity.l;
                pVar.e(new l(qj.a.J(gVar2.a, (r) null), -1));
                return b0Var;
            case 12:
                i80.i iVar2 = (i80.i) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                s70.j jVar3 = iVar2.i;
                gt.b bVar3 = (gt.b) iVar2.d.a().e;
                o.h(bVar3, "tab");
                jVar3.a.a(bVar3);
                return b0Var;
            case 13:
                ((s70.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 14:
                i80.i iVar3 = (i80.i) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                p pVar2 = iVar3.h;
                qj.g gVar3 = iVar3.a.c;
                int i3 = ArtistDashboardActivity.l;
                pVar2.e(new l(qj.a.J(gVar3.a, (r) null), -1));
                return b0Var;
            case 15:
                ((m41.l) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 16:
                lg.f fVar = ((ig.f) ((lmjxuqdtp.jvm.internal.d) this).receiver).h;
                return b0Var;
            case 17:
                ((j80.e) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 18:
                j80.e eVar2 = (j80.e) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                eVar2.getClass();
                eVar2.b(n10.a.f);
                eVar2.a();
                return b0Var;
            case 19:
                j80.e eVar3 = (j80.e) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                eVar3.getClass();
                eVar3.b(n10.a.h);
                return b0Var;
            case 20:
                j80.e eVar4 = (j80.e) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                kd1.p pVar3 = eVar4.i;
                kd1.f fVar2 = eVar4.l;
                z zVar = eVar4.j;
                int i4 = lmjxuqdtp.time.g.d;
                pVar3.h(fVar2, zVar, lmjxuqdtp.time.n.s(0, lmjxuqdtp.time.i.e));
                return b0Var;
            case 21:
                y.k(((j80.i) ((lmjxuqdtp.jvm.internal.d) this).receiver).g.a, "feed_people_to_follow_scroll", m8.d.n("Scroll"), (qi.h) null, 12);
                return b0Var;
            case 22:
                u uVar = (u) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                c0.F(i1.f(uVar.e), (i) null, (ky1.b0) null, new k80.p(uVar, (qx1.d) null, 1), 3);
                return b0Var;
            case 23:
                ((s70.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).c();
                return b0Var;
            case 24:
                ((s70.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).a();
                return b0Var;
            case 25:
                ((s70.c) ((lmjxuqdtp.jvm.internal.d) this).receiver).b();
                return b0Var;
            case 26:
                kg0.h.c((kg0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver);
                return b0Var;
            case 27:
                wl.e eVar5 = ((kg0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver).i;
                wl.h hVar = eVar5.o;
                if (hVar != null) {
                    int iB = hVar.b();
                    eVar5.e.k = false;
                    eVar5.b(iB, true);
                } else {
                    DebugUtils.debugThrowReturn("extendedBars is null", b0Var);
                }
                return b0Var;
            case 28:
                kg0.h hVar2 = (kg0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver;
                c0.F(hVar2.b, (i) null, (ky1.b0) null, new kg0.c(hVar2, (qx1.d) null, 0), 3);
                return b0Var;
            default:
                r2 r2Var4 = ((kg0.h) ((lmjxuqdtp.jvm.internal.d) this).receiver).k;
                Boolean bool2 = Boolean.TRUE;
                r2Var4.getClass();
                r2Var4.i((Object) null, bool2);
                return b0Var;
        }
    }
}
