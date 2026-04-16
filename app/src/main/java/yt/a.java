package yt;

import amuvvoafs.content.Context;
import aq1.c;
import cz1.z;
import d01.k;
import iw1.b;
import jw1.e;
import lmjxuqdtp.jvm.internal.o;
import qi.y;
import xs.p;
import z41.d;
import z41.g;
import zj.n;
import zq0.a0;
import zs.e1;
import zs.f1;
import zs.h1;
import zs.i;
import zs.j1;
import zs.k0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {
    public final /* synthetic */ int a;
    public final b b;

    public /* synthetic */ a(b bVar, int i) {
        this.a = i;
        this.b = bVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                y yVar = (y) this.b.invoke();
                o.h(yVar, "tracker");
                return new fy.a(yVar);
            case 1:
                d dVar = (d) this.b.invoke();
                o.h(dVar, "playCounterRepository");
                return new g(dVar);
            case 2:
                cd1.g gVar = (cd1.g) this.b.invoke();
                o.h(gVar, "targetRegistrar");
                return new z70.b(gVar);
            case 3:
                k kVar = (k) this.b.invoke();
                o.h(kVar, "preferenceConfig");
                return new vp1.b(kVar);
            case 4:
                vb0.a aVar = (vb0.a) this.b.invoke();
                o.h(aVar, "jsonMapper");
                return new zg0.y(aVar);
            case 5:
                p pVar = (p) this.b.invoke();
                o.h(pVar, "pref");
                return new z(pVar);
            case 6:
                n nVar = (n) this.b.invoke();
                o.h(nVar, "audioController");
                return new vp1.b(nVar);
            case 7:
                Context context = (Context) this.b.invoke();
                o.h(context, "context");
                return new br0.a(context, 13);
            case 8:
                k kVar2 = (k) this.b.invoke();
                o.h(kVar2, "prefConfig");
                return new a0(kVar2);
            case 9:
                Context context2 = (Context) this.b.invoke();
                o.h(context2, "context");
                return new zs.a(context2);
            case 10:
                Context context3 = (Context) this.b.invoke();
                o.h(context3, "context");
                return new zs.b(context3);
            case 11:
                Context context4 = (Context) this.b.invoke();
                o.h(context4, "context");
                return new i(context4);
            case 12:
                Context context5 = (Context) this.b.invoke();
                o.h(context5, "context");
                return new c(context5, (byte) 0);
            case 13:
                e1 e1Var = (e1) this.b.invoke();
                o.h(e1Var, "navigationScreenActions");
                return new vp1.b(22, e1Var);
            case 14:
                Context context6 = (Context) this.b.invoke();
                o.h(context6, "context");
                return new c(context6, (byte) 0);
            case 15:
                tk1.b bVar = (tk1.b) this.b.invoke();
                o.h(bVar, "urlNavigationProvider");
                return new fj.a(bVar);
            case 16:
                Context context7 = (Context) this.b.invoke();
                o.h(context7, "context");
                return new c(context7, (byte) 0);
            case 17:
                Context context8 = (Context) this.b.invoke();
                o.h(context8, "context");
                return new k0(context8);
            case 18:
                Context context9 = (Context) this.b.invoke();
                o.h(context9, "context");
                return new k0(context9);
            case 19:
                Context context10 = (Context) this.b.invoke();
                o.h(context10, "context");
                return new k0(context10);
            case 20:
                Context context11 = (Context) this.b.invoke();
                o.h(context11, "context");
                return new f1(context11);
            case 21:
                Context context12 = (Context) this.b.invoke();
                o.h(context12, "context");
                return new h1(context12);
            case 22:
                Context context13 = (Context) this.b.invoke();
                o.h(context13, "context");
                return new j1(context13);
            case 23:
                Context context14 = (Context) this.b.invoke();
                o.h(context14, "context");
                return new k0(context14);
            case 24:
                Context context15 = (Context) this.b.invoke();
                o.h(context15, "context");
                return new k0(context15);
            default:
                Context context16 = (Context) this.b.invoke();
                o.h(context16, "context");
                return new k0(context16);
        }
    }
}
