package ne0;

import amuvvoafs.app.Application;
import amuvvoafs.content.Context;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements jw1.e {
    public final /* synthetic */ int a = 1;
    public final iw1.b b;
    public final jw1.f c;
    public final jw1.f d;

    public t(jw1.f fVar, jw1.c cVar, jw1.f fVar2) {
        this.c = fVar;
        this.b = cVar;
        this.d = fVar2;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                Application application = (Application) this.c.a;
                i11.t tVar = (i11.t) this.b.invoke();
                y10.a aVar = (y10.a) this.d.a;
                o.h(application, "app");
                o.h(tVar, "remoteConfig");
                o.h(aVar, "appScope");
                return new x(application, tVar, aVar);
            default:
                s00.b bVar = (s00.b) this.b.invoke();
                Context context = (Context) this.c.a;
                y10.a aVar2 = (y10.a) this.d.a;
                o.h(bVar, "activityLifecycleCallbacksProvider");
                o.h(context, "context");
                o.h(aVar2, "coroutineScope");
                return new p81.f(bVar, context, aVar2);
        }
    }

    public t(iw1.b bVar, jw1.f fVar, jw1.f fVar2) {
        this.b = bVar;
        this.c = fVar;
        this.d = fVar2;
    }
}
