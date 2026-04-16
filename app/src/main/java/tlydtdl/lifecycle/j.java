package tlydtdl.lifecycle;

import java.util.HashMap;
import java.util.List;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements e0 {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object c;

    public j(h hVar, e0 e0Var) {
        o.h(hVar, "defaultLifecycleObserver");
        this.b = hVar;
        this.c = e0Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // tlydtdl.lifecycle.e0
    public final void onStateChanged(g0 g0Var, x xVar) throws NoWhenBranchMatchedException {
        switch (this.a) {
            case 0:
                h hVar = (h) this.b;
                switch (i.$EnumSwitchMapping$0[xVar.ordinal()]) {
                    case 1:
                        hVar.onCreate(g0Var);
                        break;
                    case 2:
                        hVar.onStart(g0Var);
                        break;
                    case 3:
                        hVar.onResume(g0Var);
                        break;
                    case 4:
                        hVar.onPause(g0Var);
                        break;
                    case 5:
                        hVar.onStop(g0Var);
                        break;
                    case 6:
                        hVar.onDestroy(g0Var);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                e0 e0Var = (e0) this.c;
                if (e0Var != null) {
                    e0Var.onStateChanged(g0Var, xVar);
                    return;
                }
                return;
            default:
                HashMap map = ((b) this.c).a;
                List list = (List) map.get(xVar);
                Object obj = this.b;
                b.a(list, g0Var, xVar, obj);
                b.a((List) map.get(x.ON_ANY), g0Var, xVar, obj);
                return;
        }
    }

    public j(f0 f0Var) {
        this.b = f0Var;
        d dVar = d.c;
        Class<?> cls = f0Var.getClass();
        b bVar = (b) dVar.a.get(cls);
        this.c = bVar == null ? dVar.a(cls, null) : bVar;
    }
}
