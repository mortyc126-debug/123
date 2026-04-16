package zi;

import amuvvoafs.os.Bundle;
import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import ny1.r2;
import ny1.z;
import yr.q1;
import z70.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public final cc.g a;
    public final ConcurrentHashMap b;
    public final AtomicReference c;
    public final r2 d;
    public final r2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final nc0.g f742f;

    public i(cc.g gVar) {
        o.h(gVar, "savedStateRegistryOwner");
        this.a = gVar;
        this.b = new ConcurrentHashMap();
        this.c = new AtomicReference(null);
        this.d = z.c(g.a);
        r2 r2VarC = z.c((Object) null);
        this.e = r2VarC;
        this.f742f = new nc0.g(r2VarC, 1);
        if (gVar.getSavedStateRegistry().b("stateMapping") != null) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Save bundle: save state provider is already registered"), (String[]) Arrays.copyOf(strArr, strArr.length)));
            gVar.getSavedStateRegistry().e("stateMapping");
        }
        gVar.getSavedStateRegistry().c("stateMapping", new f(this));
        final int i = 0;
        h02.a.t(gVar.getLifecycle(), new Function0(this) { // from class: zi.e
            public final /* synthetic */ i b;

            {
                this.b = this;
            }

            public final Object invoke() {
                switch (i) {
                    case 0:
                        i iVar = this.b;
                        r2 r2Var = iVar.e;
                        d dVar = d.a;
                        r2Var.getClass();
                        r2Var.i((Object) null, dVar);
                        Bundle bundleA = iVar.a.getSavedStateRegistry().a("stateMapping");
                        Bundle bundle = bundleA == null ? Bundle.EMPTY : bundleA;
                        iVar.c.set(bundle);
                        for (Map.Entry entry : iVar.b.entrySet()) {
                            String str = (String) entry.getKey();
                            k kVar = (k) entry.getValue();
                            o.e(bundle);
                            ve.g.k(kVar, bundle, str);
                        }
                        r2 r2Var2 = iVar.d;
                        g gVar2 = bundleA == null ? g.b : g.c;
                        r2Var2.getClass();
                        r2Var2.i((Object) null, gVar2);
                        break;
                    default:
                        this.b.a.getSavedStateRegistry().e("stateMapping");
                        break;
                }
                return b0.a;
            }
        });
        final int i2 = 1;
        h02.a.u(gVar.getLifecycle(), new Function0(this) { // from class: zi.e
            public final /* synthetic */ i b;

            {
                this.b = this;
            }

            public final Object invoke() {
                switch (i2) {
                    case 0:
                        i iVar = this.b;
                        r2 r2Var = iVar.e;
                        d dVar = d.a;
                        r2Var.getClass();
                        r2Var.i((Object) null, dVar);
                        Bundle bundleA = iVar.a.getSavedStateRegistry().a("stateMapping");
                        Bundle bundle = bundleA == null ? Bundle.EMPTY : bundleA;
                        iVar.c.set(bundle);
                        for (Map.Entry entry : iVar.b.entrySet()) {
                            String str = (String) entry.getKey();
                            k kVar = (k) entry.getValue();
                            o.e(bundle);
                            ve.g.k(kVar, bundle, str);
                        }
                        r2 r2Var2 = iVar.d;
                        g gVar2 = bundleA == null ? g.b : g.c;
                        r2Var2.getClass();
                        r2Var2.i((Object) null, gVar2);
                        break;
                    default:
                        this.b.a.getSavedStateRegistry().e("stateMapping");
                        break;
                }
                return b0.a;
            }
        });
    }

    public final k a(String str, Object obj, wy1.a aVar) {
        k kVar;
        ConcurrentHashMap concurrentHashMap = this.b;
        k kVar2 = (k) concurrentHashMap.get(str);
        if (kVar2 != null) {
            return kVar2;
        }
        concurrentHashMap.put(str, new k(obj, aVar));
        Bundle bundle = (Bundle) this.c.get();
        if (bundle != null && (kVar = (k) concurrentHashMap.get(str)) != null) {
            ve.g.k(kVar, bundle, str);
        }
        Object obj2 = concurrentHashMap.get(str);
        o.f(obj2, "null cannot be cast to non-null type com.bandlab.amuvvoafs.common.utils.StateProperty<T of com.bandlab.amuvvoafs.common.utils.SaveStateHelperImpl.getStateProperty>");
        return (k) obj2;
    }

    public final Object b(qx1.d dVar) {
        return z.B(new t(this.d, 2), dVar);
    }

    public final q1 c(Boolean bool) {
        return new q1(this, bool, (wy1.a) null);
    }

    public final q1 d(Integer num) {
        return new q1(this, num, (wy1.a) null);
    }

    public final q1 e(Object obj, wy1.a aVar) {
        o.h(aVar, "serializer");
        return new q1(this, obj, aVar);
    }

    public final q1 f(String str) {
        return new q1(this, str, (wy1.a) null);
    }

    public final k g(Boolean bool, String str) {
        o.h(str, "key");
        return a(str, bool, null);
    }

    public final k h(String str, Object obj, wy1.a aVar) {
        o.h(str, "key");
        o.h(aVar, "serializer");
        return a(str, obj, aVar);
    }
}
