package fm0;

import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import com.bandlab.bandlab.AppGraph$$;
import com.bandlab.bandlab.feature.mixeditor.viewmodel.MixEditorGraph$$;
import d01.k;
import gj.c;
import i11.t;
import iw1.b;
import jw1.e;
import jw1.f;
import ky1.a0;
import mp0.h;
import t1.d;
import y10.a;
import yb0.j;
import yr.b3;
import zq0.l0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements e {
    public final /* synthetic */ int a;
    public final b b;
    public final f c;

    public /* synthetic */ x(b bVar, f fVar, int i) {
        this.a = i;
        this.b = bVar;
        this.c = fVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                a aVar = (a) this.c.a;
                vj0.g0 g0Var = (vj0.g0) this.b.invoke();
                lmjxuqdtp.jvm.internal.o.h(aVar, "coroutineScope");
                lmjxuqdtp.jvm.internal.o.h(g0Var, "serviceProvider");
                return new d0(aVar, g0Var);
            case 1:
                s00.b bVar = (s00.b) this.b.invoke();
                a aVar2 = (a) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(bVar, "activityLifecycleCallbacksProvider");
                lmjxuqdtp.jvm.internal.o.h(aVar2, "appScope");
                return new gj.a(bVar, aVar2);
            case 2:
                s00.b bVar2 = (s00.b) this.b.invoke();
                a aVar3 = (a) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(bVar2, "activityLifecycleCallbacksProvider");
                lmjxuqdtp.jvm.internal.o.h(aVar3, "appScope");
                return new c(bVar2, aVar3);
            case 3:
                Application application = (Application) this.b.invoke();
                a aVar4 = (a) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(application, "application");
                lmjxuqdtp.jvm.internal.o.h(aVar4, "appScope");
                return new i30.e(application, aVar4);
            case 4:
                k kVar = (k) this.b.invoke();
                a aVar5 = (a) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(kVar, "config");
                lmjxuqdtp.jvm.internal.o.h(aVar5, "appScope");
                return new io.c(kVar, aVar5);
            case 5:
                k kVar2 = (k) this.b.invoke();
                a aVar6 = (a) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(kVar2, "prefConfig");
                lmjxuqdtp.jvm.internal.o.h(aVar6, "appScope");
                return new ks.a(kVar2, aVar6);
            case 6:
                t tVar = (t) this.b.invoke();
                a aVar7 = (a) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(tVar, "remoteConfig");
                lmjxuqdtp.jvm.internal.o.h(aVar7, "scope");
                return new h(tVar, aVar7);
            case 7:
                Context context = (Context) this.c.a;
                ne0.x xVar = (ne0.x) this.b.invoke();
                lmjxuqdtp.jvm.internal.o.h(context, "context");
                lmjxuqdtp.jvm.internal.o.h(xVar, "sessionManager");
                return new ne0.h(context, xVar);
            case 8:
                bj.k kVar3 = (bj.k) this.c.a;
                mt.b bVar3 = (mt.b) this.b.invoke();
                lmjxuqdtp.jvm.internal.o.h(kVar3, "scope");
                lmjxuqdtp.jvm.internal.o.h(bVar3, "apiServiceFactory");
                return new rz.r0(kVar3, bVar3);
            case 9:
                a aVar8 = (a) this.c.a;
                j jVar = (j) this.b.invoke();
                lmjxuqdtp.jvm.internal.o.h(aVar8, "appScope");
                lmjxuqdtp.jvm.internal.o.h(jVar, "labelsApi");
                return new d(21, aVar8, jVar);
            case 10:
                kn0.a aVar9 = (kn0.a) this.b.invoke();
                a0 a0Var = (a0) this.c.a;
                lmjxuqdtp.jvm.internal.o.h(aVar9, "factory");
                lmjxuqdtp.jvm.internal.o.h(a0Var, "scope");
                return new kn0.b(a0Var);
            default:
                a aVar10 = (a) this.c.a;
                k kVar4 = (k) this.b.invoke();
                lmjxuqdtp.jvm.internal.o.h(aVar10, "scope");
                lmjxuqdtp.jvm.internal.o.h(kVar4, "preferenceConfig");
                return new l0(kVar4, aVar10);
        }
    }

    public /* synthetic */ x(f fVar, b bVar, int i) {
        this.a = i;
        this.c = fVar;
        this.b = bVar;
    }

    public x(AppGraph$$.MetroGraph metroGraph, f fVar, b bVar) {
        this.a = 9;
        this.c = fVar;
        this.b = bVar;
    }

    public x(MixEditorGraph$$.MetroGraph metroGraph, b3 b3Var, f fVar) {
        this.a = 10;
        this.b = b3Var;
        this.c = fVar;
    }
}
