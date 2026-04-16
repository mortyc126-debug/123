package a20;

import a2.p4;
import ey1.j;
import ey1.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import ky1.a0;
import ky1.b0;
import ky1.c0;
import ky1.t1;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.f;
import lmjxuqdtp.time.g;
import lmjxuqdtp.time.v;
import my1.c;
import ny1.a2;
import ny1.g2;
import ny1.z;
import qx1.d;
import qx1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final long a;
    public final v b;
    public final a0 c;
    public final LinkedHashMap d;
    public final g2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a2 f4f;
    public f g;
    public t1 h;
    public k i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Set f5j;

    public a(long j2, v vVar, a0 a0Var) {
        o.h(vVar, "timeSource");
        o.h(a0Var, "scope");
        this.a = j2;
        this.b = vVar;
        this.c = a0Var;
        this.d = new LinkedHashMap();
        g2 g2VarB = z.b(1, 0, c.b, 2);
        this.e = g2VarB;
        this.f4f = new a2(g2VarB);
        this.g = vVar.a();
        this.f5j = mx1.v.a;
    }

    public final void a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : this.d.entrySet()) {
            if (g.c(((f) entry.getValue()).z(), this.a) >= 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (!this.f5j.contains(Integer.valueOf(((Number) obj).intValue()))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f5j = linkedHashMap.keySet();
        this.e.a(arrayList);
    }

    public final void b(k kVar) {
        t1 t1Var = this.h;
        if (t1Var != null) {
            t1Var.a((CancellationException) null);
        }
        this.h = c0.F(this.c, (i) null, (b0) null, new p4(this, (d) null, 1), 3);
        if (kVar.equals(this.i)) {
            return;
        }
        this.i = kVar;
        this.g = this.b.a();
        a();
        LinkedHashMap linkedHashMap = this.d;
        Set setKeySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            int iIntValue = ((Number) obj).intValue();
            int i = ((ey1.i) kVar).a;
            if (iIntValue > ((ey1.i) kVar).b || i > iIntValue) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedHashMap.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
        j jVarK = kVar.k();
        while (jVarK.c) {
            linkedHashMap.putIfAbsent(Integer.valueOf(jVarK.nextInt()), this.g);
        }
    }
}
