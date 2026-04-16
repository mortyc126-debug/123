package rd;

import az1.z;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import lx1.q;
import tlydtdl.compose.foundation.layout.x1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {
    public final gc.c a;
    public final ThreadLocal b;
    public final q c;
    public final f d;
    public final LinkedHashMap e;

    public /* synthetic */ g(tlydtdl.sqlite.db.framework.c cVar) {
        this(null, cVar, 1);
    }

    public final void a(String[] strArr, pd.a aVar) {
        o.h(strArr, "queryKeys");
        o.h(aVar, "listener");
        synchronized (this.e) {
            try {
                for (String str : strArr) {
                    LinkedHashMap linkedHashMap = this.e;
                    Object linkedHashSet = linkedHashMap.get(str);
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                        linkedHashMap.put(str, linkedHashSet);
                    }
                    ((Set) linkedHashSet).add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final qd.d b(Integer num, String str, Function1 function1) {
        o.h(str, "sql");
        return new qd.d(c(num, new gm1.b(28, this, str), function1, new p90.f(23)));
    }

    public final Object c(Integer num, Function0 function0, Function1 function1, Function1 function12) {
        f fVar = this.d;
        h hVar = num != null ? (h) fVar.remove(num) : null;
        if (hVar == null) {
            hVar = (h) function0.invoke();
        }
        if (function1 != null) {
            try {
                function1.invoke(hVar);
            } catch (Throwable th) {
                if (num != null) {
                    h hVar2 = (h) fVar.put(num, hVar);
                    if (hVar2 != null) {
                        hVar2.close();
                    }
                } else {
                    hVar.close();
                }
                throw th;
            }
        }
        Object objInvoke = function12.invoke(hVar);
        if (num == null) {
            hVar.close();
            return objInvoke;
        }
        h hVar3 = (h) fVar.put(num, hVar);
        if (hVar3 != null) {
            hVar3.close();
        }
        return objInvoke;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.d.evictAll();
        gc.c cVar = this.a;
        if (cVar != null) {
            cVar.close();
        } else {
            g().close();
        }
    }

    public final qd.d f(Integer num, String str, Function1 function1, int i, Function1 function12) {
        o.h(str, "sql");
        o.h(function1, "mapper");
        return new qd.d(c(num, new z(str, this, i), function12, new x1(9, function1)));
    }

    public final gc.a g() {
        return (gc.a) this.c.getValue();
    }

    public final void j(String... strArr) {
        o.h(strArr, "queryKeys");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.e) {
            for (String str : strArr) {
                Set set = (Set) this.e.get(str);
                if (set != null) {
                    linkedHashSet.addAll(set);
                }
            }
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((pd.a) it.next()).a.h(b0.a);
        }
    }

    public final void t(String[] strArr, pd.a aVar) {
        o.h(strArr, "queryKeys");
        o.h(aVar, "listener");
        synchronized (this.e) {
            for (String str : strArr) {
                Set set = (Set) this.e.get(str);
                if (set != null) {
                    set.remove(aVar);
                }
            }
        }
    }

    public g(gc.c cVar, tlydtdl.sqlite.db.framework.c cVar2, int i) {
        this.a = cVar;
        if (!((cVar != null) ^ (cVar2 != null))) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.b = new ThreadLocal();
        this.c = hs1.d.F(new gm1.b(27, this, cVar2));
        this.d = new f(i);
        this.e = new LinkedHashMap();
    }
}
