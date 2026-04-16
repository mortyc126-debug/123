package gl;

import amuvvoafs.content.Context;
import com.bandlab.audiocore.generated.AudioOutputDevice;
import com.bandlab.audiocore.generated.Transport;
import f3.f2;
import hu0.i;
import im.a0;
import iw1.b;
import k71.u;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.v;
import qi.y;
import tlydtdl.activity.ComponentActivity;
import z71.j0;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements jw1.e {
    public final /* synthetic */ int a;
    public final b b;

    public /* synthetic */ g(b bVar, int i) {
        this.a = i;
        this.b = bVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                zi.c cVar = (zi.c) this.b.invoke();
                o.h(cVar, "resProvider");
                return cVar;
            case 1:
                AudioOutputDevice audioOutputDevice = (AudioOutputDevice) this.b.invoke();
                o.h(audioOutputDevice, "outDevice");
                Transport transportCreate = Transport.create(audioOutputDevice.getClockSource());
                if (transportCreate != null) {
                    return transportCreate;
                }
                throw new IllegalArgumentException(f2.C(d0.a(Transport.class).f(), " from audio core API should not be null here: check if anything changed!").toString());
            case 2:
                ComponentActivity componentActivity = (ComponentActivity) this.b.invoke();
                o.h(componentActivity, "activity");
                return new tp.c(componentActivity);
            case 3:
                Context context = (Context) this.b.invoke();
                o.h(context, "context");
                return new br0.a(context, 5);
            case 4:
                dp.a aVar = (dp.a) this.b.invoke();
                o.h(aVar, "otpNavigationActions");
                return new dd.b(6, aVar);
            case 5:
                hc0.f fVar = (hc0.f) this.b.invoke();
                o.h(fVar, "projectsHandler");
                return new a91.a(5, fVar);
            case 6:
                ue0.a aVar2 = (ue0.a) this.b.invoke();
                o.h(aVar2, "standalonePlayer");
                return new he0.c(aVar2);
            case 7:
                v1 v1Var = (v1) this.b.invoke();
                o.h(v1Var, "mixer");
                return new i(v1Var);
            case 8:
                mt.b bVar = (mt.b) this.b.invoke();
                o.h(bVar, "apiServiceFactory");
                return new hv0.b(bVar);
            case 9:
                i11.g gVar = (i11.g) this.b.invoke();
                o.h(gVar, "variantProvider");
                return new i11.b(gVar);
            case 10:
                tk1.b bVar2 = (tk1.b) this.b.invoke();
                o.h(bVar2, "urlNavigationProvider");
                return new i60.a(bVar2, 0);
            case 11:
                Context context2 = (Context) this.b.invoke();
                o.h(context2, "context");
                return new br0.a(context2, 6);
            case 12:
                gf.i iVar = new gf.i();
                vb0.a aVar3 = (vb0.a) this.b.invoke();
                o.h(aVar3, "jsonMapper");
                return new f0.d(iVar, aVar3);
            case 13:
                y yVar = (y) this.b.invoke();
                o.h(yVar, "tracker");
                return new fy.a(yVar);
            case 14:
                Context context3 = (Context) this.b.invoke();
                o.h(context3, "context");
                return new ij1.a(context3);
            case 15:
                y yVar2 = (y) this.b.invoke();
                o.h(yVar2, "tracker");
                return new ik1.h(yVar2);
            case 16:
                Context context4 = (Context) this.b.invoke();
                o.h(context4, "context");
                return new a0(context4);
            case 17:
                Context context5 = (Context) this.b.invoke();
                o.h(context5, "context");
                return new br0.a(context5, 7);
            case 18:
                v1 v1Var2 = (v1) this.b.invoke();
                o.h(v1Var2, "mixer");
                return new i(v1Var2);
            case 19:
                Context context6 = (Context) this.b.invoke();
                o.h(context6, "context");
                return new br0.a(context6, 8);
            case 20:
                y yVar3 = (y) this.b.invoke();
                o.h(yVar3, "tracker");
                return new fy.a(yVar3);
            case 21:
                vb0.a aVar4 = (vb0.a) this.b.invoke();
                o.h(aVar4, "jsonMapper");
                return new jj1.a(aVar4);
            case 22:
                vb0.a aVar5 = (vb0.a) this.b.invoke();
                o.h(aVar5, "jsonMapper");
                return new jj1.f(aVar5);
            case 23:
                mt.d dVar = (mt.d) this.b.invoke();
                o.h(dVar, "endpointResolver");
                return new jt.a(dVar);
            case 24:
                y yVar4 = (y) this.b.invoke();
                o.h(yVar4, "tracker");
                return new k20.a(yVar4);
            case 25:
                v vVar = (v) this.b.invoke();
                o.h(vVar, "timeSource");
                return new u(vVar);
            case 26:
                qj1.c cVar2 = (qj1.c) this.b.invoke();
                o.h(cVar2, "videoPreviewPlayerPool");
                return new k80.d(cVar2);
            case 27:
                j0 j0Var = (j0) this.b.invoke();
                o.h(j0Var, "queries");
                return new k81.c(j0Var);
            case 28:
                y yVar5 = (y) this.b.invoke();
                o.h(yVar5, "tracker");
                return new kb0.g(yVar5);
            default:
                y yVar6 = (y) this.b.invoke();
                o.h(yVar6, "tracker");
                return new fy.a(yVar6);
        }
    }

    public /* synthetic */ g(Object obj, b bVar, int i) {
        this.a = i;
        this.b = bVar;
    }
}
