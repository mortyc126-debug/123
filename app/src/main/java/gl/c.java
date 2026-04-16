package gl;

import ak.v;
import amuvvoafs.content.ContentResolver;
import amuvvoafs.content.Context;
import amuvvoafs.media.AudioManager;
import com.bandlab.bandlab.AppGraph$$;
import com.bandlab.restutils.UnauthorizedFileService;
import gm.m;
import gm.t;
import im.a0;
import im.c0;
import ir0.i;
import iw1.b;
import lmjxuqdtp.jvm.internal.o;
import ls0.k;
import mr.x3;
import sh0.l;
import uo0.n;
import uq0.o0;
import xs.p;
import yr.e1;
import zj.b2;
import zs.j0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    public final /* synthetic */ int a;
    public final /* synthetic */ e b;

    public /* synthetic */ c(e eVar, int i) {
        this.a = i;
        this.b = eVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                this.b.a.getClass();
                return new l();
            case 1:
                AppGraph$$.MetroGraph metroGraph = this.b.a;
                vs0.a aVar = metroGraph.T1;
                b bVar = metroGraph.S1;
                o.h(aVar, "resourcesSr");
                o.h(bVar, "deviceAudioInfo");
                int iIntValue = ((Number) aVar.invoke()).intValue();
                vm.d dVar = (vm.d) bVar.invoke();
                o.h(dVar, "deviceAudioInfo");
                return new v(iIntValue, dVar);
            case 2:
                return (k) this.b.a.Q.invoke();
            case 3:
                return (lt.b) this.b.a.b3.invoke();
            case 4:
                return Integer.valueOf(((Number) this.b.a.R1.invoke()).intValue());
            case 5:
                return Integer.valueOf(((Number) this.b.a.T1.invoke()).intValue());
            case 6:
                return this.b.a.z0();
            case 7:
                return (zi.c) this.b.a.f1.invoke();
            case 8:
                AppGraph$$.MetroGraph metroGraph2 = this.b.a;
                bj.c cVar = metroGraph2.W1;
                e1 e1Var = metroGraph2.Z2;
                o.h((AppGraph$$.MetroGraph) metroGraph2.b.a, "instance");
                vs0.a aVar2 = metroGraph2.T1;
                bj.c cVar2 = metroGraph2.a3;
                o.h(cVar, "resolver");
                o.h(e1Var, "converters");
                o.h(aVar2, "targetSr");
                o.h(cVar2, "fileService");
                return new m((ContentResolver) cVar.invoke(), e1Var, new t(), new um.h(), ((Number) aVar2.invoke()).intValue(), (UnauthorizedFileService) cVar2.invoke());
            case 9:
                return this.b.a.G();
            case 10:
                jw1.c cVar3 = this.b.a.s;
                o.h(cVar3, "remoteConfig");
                i11.t tVar = (i11.t) cVar3.invoke();
                o.h(tVar, "remoteConfig");
                return new n(tVar);
            case 11:
                this.b.a.getClass();
                return new sh0.k();
            case 12:
                return this.b.a.o0();
            case 13:
                return (ep0.g) this.b.a.c3.invoke();
            case 14:
                return this.b.a.f0();
            case 15:
                return this.b.a.Q();
            case 16:
                return this.b.a.n0();
            case 17:
                return (lt.b) this.b.a.b3.invoke();
            case 18:
                return (to0.e) this.b.a.C5.invoke();
            case 19:
                return this.b.a.r0();
            case 20:
                return (i) this.b.a.n3.invoke();
            case 21:
                return this.b.a.h0();
            case 22:
                AppGraph$$.MetroGraph metroGraph3 = this.b.a;
                a80.l lVar = metroGraph3.A2;
                jw1.c cVar4 = metroGraph3.D;
                x3 x3Var = metroGraph3.g2;
                o.h(cVar4, "navActions");
                o.h(x3Var, "webUrlResolver");
                aq.g gVar = metroGraph3.X2;
                fd0.a aVar3 = metroGraph3.W2;
                o.h(lVar, "navActions");
                o.h(gVar, "autoPitchVersionChecker");
                o.h(aVar3, "masteringVersionChecker");
                j0 j0Var = (j0) lVar.invoke();
                tk1.b bVar2 = (tk1.b) cVar4.invoke();
                b20.b bVar3 = new b20.b();
                o.h(bVar2, "navActions");
                return new b2(j0Var, new m11.a(bVar2, bVar3), (gh0.b) gVar.invoke(), (fd0.b) aVar3.invoke());
            case 23:
                jw1.f fVar = this.b.a.a;
                o.h(fVar, "context");
                Context context = (Context) fVar.invoke();
                o.h(context, "context");
                return new a0(context);
            case 24:
                this.b.a.L();
                return lmjxuqdtp.time.d.a;
            case 25:
                return (o0) this.b.a.N5.invoke();
            case 26:
                AppGraph$$.MetroGraph metroGraph4 = this.b.a;
                b bVar4 = metroGraph4.x3;
                AppGraph$$.MetroGraph metroGraph5 = (AppGraph$$.MetroGraph) metroGraph4.b.a;
                jw1.f fVar2 = metroGraph4.a;
                o.h(metroGraph5, "instance");
                o.h(fVar2, "context");
                o.h(bVar4, "internalFocus");
                c0 c0Var = (c0) bVar4.invoke();
                Context context2 = (Context) fVar2.a;
                o.h(context2, "context");
                AudioManager audioManager = (AudioManager) context2.getSystemService(AudioManager.class);
                if (audioManager == null) {
                    throw new IllegalStateException("System AudioManager is not available");
                }
                o.h(c0Var, "internalFocus");
                return new im.a(c0Var, audioManager);
            case 27:
                return this.b.a.B0();
            case 28:
                return (cg0.a) this.b.a.d3.invoke();
            default:
                jw1.c cVar5 = this.b.a.A;
                o.h(cVar5, "preferenceConfig");
                d01.k kVar = (d01.k) cVar5.invoke();
                o.h(kVar, "preferenceConfig");
                return new p(kVar);
        }
    }
}
