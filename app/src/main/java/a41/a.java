package a41;

import amuvvoafs.content.Context;
import amuvvoafs.net.ConnectivityManager;
import amuvvoafs.os.Build;
import ct1.b;
import gd.d;
import gd.h;
import hd.c;
import hd.f;
import id.e;
import id.j;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import mx1.n;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final List a;

    public a() {
        this.a = b.C(new z31.a[]{z31.a.a, z31.a.b, z31.a.c});
    }

    public a(j jVar) {
        d dVar;
        o.h(jVar, "trackers");
        hd.d cVar = new c(jVar.b, 0);
        hd.d cVar2 = new c(jVar.c);
        hd.d cVar3 = new c(jVar.e, 4);
        e eVar = jVar.d;
        hd.d cVar4 = new c(eVar, 2);
        hd.d cVar5 = new c(eVar, 3);
        hd.d fVar = new f(eVar);
        hd.d eVar2 = new hd.e(eVar);
        if (Build.VERSION.SDK_INT >= 28) {
            Context context = jVar.a;
            String str = h.a;
            o.h(context, "context");
            Object systemService = context.getSystemService("connectivity");
            o.f(systemService, "null cannot be cast to non-null type amuvvoafs.net.ConnectivityManager");
            dVar = new d((ConnectivityManager) systemService);
        } else {
            dVar = null;
        }
        this.a = n.e0(new hd.d[]{cVar, cVar2, cVar3, cVar4, cVar5, fVar, eVar2, dVar});
    }

    public a(List list) {
        this.a = list;
    }
}
