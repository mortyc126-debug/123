package ne0;

import bb.e0;
import bb.f0;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import ke0.m;
import lmjxuqdtp.jvm.internal.o;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends bb.y {
    public final /* synthetic */ h a;

    public g(h hVar) {
        this.a = hVar;
    }

    public final void a(f0 f0Var, e0 e0Var) {
        o.h(f0Var, "router");
        this.a.a(e0Var);
    }

    public final void b(f0 f0Var, e0 e0Var) {
        Object value;
        Object next;
        ArrayList arrayListS0;
        o.h(f0Var, "router");
        h hVar = this.a;
        LinkedHashMap linkedHashMap = hVar.d;
        String str = e0Var.c;
        linkedHashMap.put(str, e0Var);
        ke0.j jVarE = h.e(e0Var);
        r2 r2Var = hVar.c;
        do {
            value = r2Var.getValue();
            List list = (List) value;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (o.c(((ke0.j) next).c, str)) {
                        break;
                    }
                }
            }
            ke0.j jVar = (ke0.j) next;
            if (jVar != null) {
                arrayListS0 = mx1.o.o1(list);
                arrayListS0.set(arrayListS0.indexOf(jVar), jVarE);
            } else {
                h.c("=> Route changed but it is not in the device list: " + e0Var.d);
                arrayListS0 = mx1.o.S0(list, jVarE);
            }
        } while (!r2Var.d(value, arrayListS0));
        f0.b();
        if (f0.c().f() == e0Var) {
            r2 r2Var2 = hVar.e;
            ke0.k kVar = new ke0.k(h.e(e0Var));
            r2Var2.getClass();
            r2Var2.i((Object) null, kVar);
        }
    }

    public final void c(f0 f0Var, e0 e0Var) {
        Object value;
        ArrayList arrayList;
        o.h(f0Var, "router");
        h hVar = this.a;
        LinkedHashMap linkedHashMap = hVar.d;
        String str = e0Var.c;
        linkedHashMap.remove(str);
        r2 r2Var = hVar.c;
        do {
            value = r2Var.getValue();
            arrayList = new ArrayList();
            for (Object obj : (List) value) {
                if (!o.c(((ke0.j) obj).c, str)) {
                    arrayList.add(obj);
                }
            }
        } while (!r2Var.d(value, arrayList));
    }

    public final void e(f0 f0Var, e0 e0Var, int i, e0 e0Var2) {
        Object next;
        o.h(f0Var, "router");
        o.h(e0Var2, "requestedRoute");
        h.c("=> Route selected: " + e0Var.d + " - Reason: " + i);
        Iterator it = ((Iterable) this.a.c.getValue()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (o.c(((ke0.j) next).c, e0Var.c)) {
                    break;
                }
            }
        }
        if (((ke0.j) next) == null) {
            bb.w wVar = new bb.w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Selected route not found in the device list"), (String[]) Arrays.copyOf(strArr, strArr.length)));
        }
    }

    public final void f(f0 f0Var, e0 e0Var, int i) {
        o.h(f0Var, "router");
        r2 r2Var = this.a.e;
        m mVar = new m((ke0.j) null);
        r2Var.getClass();
        r2Var.i((Object) null, mVar);
    }
}
