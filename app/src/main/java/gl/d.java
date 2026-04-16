package gl;

import a70.x;
import com.bandlab.bandlab.AppGraph$$;
import com.gnacba.amuvvoafs.gms.internal.ads.vi1;
import hw.q;
import i11.t;
import iw1.b;
import l61.s;
import lm.i;
import lm.l;
import lmjxuqdtp.jvm.internal.o;
import ls0.k;
import qi.y;
import ur.v;
import zg0.l0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {
    public final /* synthetic */ int a;
    public final /* synthetic */ e b;

    public /* synthetic */ d(e eVar, int i) {
        this.a = i;
        this.b = eVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                AppGraph$$.MetroGraph metroGraph = this.b.a;
                jw1.c cVar = metroGraph.B;
                jw1.c cVar2 = metroGraph.s;
                o.h(cVar, "membershipRepo");
                o.h(cVar2, "remoteConfig");
                q qVar = (q) cVar.invoke();
                t tVar = (t) cVar2.invoke();
                o.h(qVar, "membershipRepo");
                o.h(tVar, "remoteConfig");
                return new zl.q(qVar, tVar);
            case 1:
                AppGraph$$.MetroGraph metroGraph2 = this.b.a;
                jw1.c cVar3 = metroGraph2.B;
                jw1.c cVar4 = metroGraph2.s;
                o.h(cVar3, "membershipRepo");
                o.h(cVar4, "remoteConfig");
                q qVar2 = (q) cVar3.invoke();
                t tVar2 = (t) cVar4.invoke();
                o.h(qVar2, "membershipRepo");
                o.h(tVar2, "remoteConfig");
                return new aq.b(qVar2, tVar2);
            case 2:
                AppGraph$$.MetroGraph metroGraph3 = this.b.a;
                jw1.c cVar5 = metroGraph3.s;
                x xVar = metroGraph3.u2;
                o.h(cVar5, "remoteConfig");
                o.h(xVar, "autoPitchVersionExposedConfigSelector");
                t tVar3 = (t) cVar5.invoke();
                aq.f fVar = (aq.f) xVar.invoke();
                o.h(tVar3, "remoteConfig");
                return new aq.d(new ru1.c(7, new vi1(tVar3, fVar, false)));
            case 3:
                return (l0) this.b.a.o5.invoke();
            case 4:
                return (xr0.e) this.b.a.P5.invoke();
            case 5:
                return (v) this.b.a.Q5.a;
            case 6:
                return this.b.a.H();
            case 7:
                return this.b.a.Z();
            case 8:
                return (s) this.b.a.j3.invoke();
            case 9:
                AppGraph$$.MetroGraph metroGraph4 = this.b.a;
                jq0.d dVar = metroGraph4.Q;
                o.h(dVar, "mixEditorStorage");
                jq0.d dVar2 = metroGraph4.Q;
                o.h(dVar2, "mixEditorStorage");
                jw1.c cVar6 = metroGraph4.z;
                o.h(cVar6, "apiServiceFactory");
                o.h((AppGraph$$.MetroGraph) metroGraph4.b.a, "instance");
                dd.b bVar = new dd.b(25, (k) dVar.invoke());
                dd.b bVar2 = new dd.b(25, (k) dVar2.invoke());
                mt.b bVar3 = (mt.b) cVar6.invoke();
                o.h(bVar3, "apiServiceFactory");
                return new i(new jx0.h(bVar, new l(bVar2, bVar3), "0.7.5", 6));
            case 10:
                this.b.a.c2.getClass();
                return a10.a.c;
            case 11:
                AppGraph$$.MetroGraph metroGraph5 = this.b.a;
                b bVar4 = metroGraph5.b1;
                b bVar5 = metroGraph5.l5;
                o.h(bVar4, "tracker");
                o.h(bVar5, "actionTracker");
                y yVar = (y) bVar4.invoke();
                yg0.b bVar6 = (yg0.b) bVar5.invoke();
                y yVar2 = (y) bVar4.invoke();
                o.h(yVar, "tracker");
                o.h(bVar6, "actionTracker");
                o.h(yVar2, "userPropertyTracker");
                return new yg0.d(yVar, bVar6, yVar2);
            case 12:
                this.b.a.getClass();
                return new l11.a();
            default:
                return (zj.v) this.b.a.U2.invoke();
        }
    }
}
