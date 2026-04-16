package kz0;

import amuvvoafs.content.Context;
import com.bandlab.bandlab.AppGraph$$;
import dt.h;
import jv0.i0;
import jw1.f;
import kd1.j;
import lmjxuqdtp.jvm.internal.o;
import mr.x3;
import p41.g;
import qi.y;
import s51.b0;
import s51.n;
import s51.r;
import tlydtdl.compose.foundation.lazy.layout.r1;
import z41.i;
import zs.e1;
import zs.h0;
import zs.h1;
import zs.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements iw1.b {
    public final /* synthetic */ int a;
    public final /* synthetic */ c b;

    public /* synthetic */ a(c cVar, int i) {
        this.a = i;
        this.b = cVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return (g) this.b.d.n1.invoke();
            case 1:
                return this.b.d.y0();
            case 2:
                return (j) this.b.d.T4.invoke();
            case 3:
                x3 x3Var = this.b.d.g2;
                o.h(x3Var, "webUrlResolver");
                return new v31.b((b20.b) x3Var.invoke());
            case 4:
                return (l41.j) this.b.d.v0.invoke();
            case 5:
                AppGraph$$.MetroGraph metroGraph = this.b.d;
                iw1.b bVar = metroGraph.x0;
                bj.c cVar = metroGraph.g0;
                jw1.c cVar2 = metroGraph.n;
                o.h(cVar, "queries");
                o.h(cVar2, "songDao");
                jw1.c cVar3 = metroGraph.n;
                jw1.c cVar4 = metroGraph.z;
                o.h(bVar, "playCounterRepository");
                o.h(cVar3, "songDao");
                o.h(cVar4, "apiServiceFactory");
                z41.d dVar = (z41.d) bVar.invoke();
                r rVar = (r) cVar.invoke();
                b0 b0Var = (b0) cVar2.invoke();
                o.h(rVar, "queries");
                o.h(b0Var, "songDao");
                n nVar = new n(rVar, b0Var);
                b0 b0Var2 = (b0) cVar3.invoke();
                mt.b bVar2 = (mt.b) cVar4.invoke();
                o.h(dVar, "playCounterRepository");
                o.h(b0Var2, "songDao");
                o.h(bVar2, "apiServiceFactory");
                return new i(dVar, nVar, b0Var2, bVar2);
            case 6:
                AppGraph$$.MetroGraph metroGraph2 = this.b.d;
                f fVar = metroGraph2.a;
                o.h(fVar, "context");
                iw1.b bVar3 = metroGraph2.S0;
                vs0.a aVar = metroGraph2.m2;
                o.h(bVar3, "userIdProvider");
                o.h(aVar, "navigationScreenActions");
                jw1.c cVar5 = metroGraph2.D;
                o.h(cVar5, "urlNavActions");
                Object obj = fVar.a;
                Context context = (Context) obj;
                o.h(context, "context");
                h1 h1Var = new h1(context);
                Context context2 = (Context) obj;
                i0 i0Var = (i0) bVar3.invoke();
                e1 e1Var = (e1) aVar.invoke();
                o.h(context2, "context");
                o.h(i0Var, "userIdProvider");
                m1 m1Var = new m1(context2, i0Var, e1Var);
                tk1.b bVar4 = (tk1.b) cVar5.invoke();
                o.h(bVar4, "urlNavActions");
                return new h0(h1Var, m1Var, bVar4);
            case 7:
                return this.b.d.o0();
            case 8:
                return this.b.d.R();
            case 9:
                AppGraph$$.MetroGraph metroGraph3 = this.b.d;
                iw1.b bVar5 = metroGraph3.J6;
                jw1.c cVar6 = metroGraph3.z;
                o.h(bVar5, "cache");
                o.h(cVar6, "apiServiceFactory");
                vk1.g gVar = (vk1.g) bVar5.invoke();
                mt.b bVar6 = (mt.b) cVar6.invoke();
                o.h(gVar, "cache");
                o.h(bVar6, "apiServiceFactory");
                return new vk1.f(gVar, bVar6);
            case 10:
                return (dt.g) this.b.d.O3.invoke();
            case 11:
                return this.b.d.V();
            case 12:
                return this.b.d.P();
            case 13:
                jw1.c cVar7 = this.b.d.k;
                o.h(cVar7, "standalonePlayer");
                ue0.a aVar2 = (ue0.a) cVar7.invoke();
                o.h(aVar2, "standalonePlayer");
                return new r1(aVar2);
            case 14:
                return this.b.d.D0();
            case 15:
                return this.b.d.k0();
            case 16:
                return this.b.d.B0();
            case 17:
                return this.b.d.z0();
            case 18:
                AppGraph$$.MetroGraph metroGraph4 = this.b.d;
                iw1.b bVar7 = metroGraph4.b1;
                iw1.b bVar8 = metroGraph4.S0;
                o.h(bVar7, "tracker");
                o.h(bVar8, "userIdProvider");
                y yVar = (y) bVar7.invoke();
                i0 i0Var2 = (i0) bVar8.invoke();
                o.h(yVar, "tracker");
                o.h(i0Var2, "userIdProvider");
                return new h(yVar, i0Var2);
            case 19:
                return this.b.d.M();
            case 20:
                iw1.b bVar9 = this.b.d.b1;
                o.h(bVar9, "tracker");
                y yVar2 = (y) bVar9.invoke();
                o.h(yVar2, "tracker");
                return new fy.a(yVar2);
            case 21:
                return (cu.f) this.b.d.V3.invoke();
            case 22:
                return this.b.d.N();
            case 23:
                f fVar2 = this.b.d.a;
                o.h(fVar2, "context");
                Context context3 = (Context) fVar2.invoke();
                o.h(context3, "context");
                return new lw0.b(context3);
            case 24:
                return this.b.d.T();
            case 25:
                o.h((AppGraph$$.MetroGraph) this.b.d.b.a, "instance");
                return Boolean.FALSE;
            case 26:
                iw1.b bVar10 = this.b.d.f1;
                o.h(bVar10, "resProvider");
                zi.c cVar8 = (zi.c) bVar10.invoke();
                cd0.c cVar9 = new cd0.c();
                o.h(cVar8, "resProvider");
                return new dd.b(cVar8, cVar9);
            case 27:
                return this.b.d.a0();
            case 28:
                return (we0.b0) this.b.d.i5.invoke();
            default:
                f fVar3 = this.b.d.a;
                o.h(fVar3, "context");
                Context context4 = (Context) fVar3.a;
                o.h(context4, "context");
                return new zs.a(context4);
        }
    }
}
