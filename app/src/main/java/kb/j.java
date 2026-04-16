package kb;

import ct1.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import ny1.b2;
import ny1.r2;
import ny1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final r2 a = z.c(k.a);
    public final r2 b;
    public final b2 c;
    public final mx1.l d;
    public final mx1.l e;

    /* JADX INFO: renamed from: f */
    public e f258f;
    public int g;
    public i h;
    public final LinkedHashSet i;

    /* JADX INFO: renamed from: j */
    public final LinkedHashSet f259j;
    public final LinkedHashSet k;
    public boolean l;
    public boolean m;
    public boolean n;

    public j() {
        r2 r2VarC = z.c(new f());
        this.b = r2VarC;
        this.c = new b2(r2VarC);
        this.d = new mx1.l();
        this.e = new mx1.l();
        this.i = new LinkedHashSet();
        this.f259j = new LinkedHashSet();
        this.k = new LinkedHashSet();
    }

    public final void a(c cVar, i iVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(cVar, "dispatcher");
        if (iVar.a == null) {
            (i != 0 ? i != 1 ? this.i : this.f259j : this.k).add(iVar);
            iVar.a = cVar;
            lmjxuqdtp.jvm.internal.o.h((f) this.c.a.getValue(), "history");
            iVar.c(i != 0 ? i != 1 ? this.n : this.l : this.m);
            return;
        }
        throw new IllegalArgumentException(("Input '" + iVar + "' is already added to dispatcher " + iVar.a + '.').toString());
    }

    public final void b() {
        boolean z;
        boolean z2;
        mx1.l<e> lVar = this.d;
        if (lVar == null || !lVar.isEmpty()) {
            for (e eVar : lVar) {
                if (eVar.e || eVar.f257f) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        mx1.l<e> lVar2 = this.e;
        if (lVar2 == null || !lVar2.isEmpty()) {
            for (e eVar2 : lVar2) {
                if (eVar2.e || eVar2.f257f) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        } else {
            z2 = false;
        }
        boolean z3 = z || z2;
        boolean z4 = this.m != z;
        boolean z5 = this.l != z2;
        boolean z6 = this.n != z3;
        if (z4) {
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((i) it.next()).c(z);
            }
        }
        if (z5) {
            Iterator it2 = this.f259j.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).c(z2);
            }
        }
        if (z6) {
            Iterator it3 = this.i.iterator();
            while (it3.hasNext()) {
                ((i) it3.next()).c(z3);
            }
        }
        this.m = z;
        this.l = z2;
        this.n = z3;
        e eVarC = this.f258f;
        if (eVarC == null) {
            eVarC = c(0);
        }
        d(eVarC);
    }

    public final e c(int i) {
        Object next;
        Object next2;
        Object next3;
        mx1.l lVar = this.e;
        mx1.l lVar2 = this.d;
        Object obj = null;
        if (i == -1) {
            Iterator it = lVar2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((e) next).e) {
                    break;
                }
            }
            e eVar = (e) next;
            if (eVar != null) {
                return eVar;
            }
            Iterator it2 = lVar.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next4 = it2.next();
                if (((e) next4).e) {
                    obj = next4;
                    break;
                }
            }
            return (e) obj;
        }
        if (i == 0) {
            Iterator it3 = lVar2.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it3.next();
                e eVar2 = (e) next2;
                if (eVar2.e || eVar2.f257f) {
                    break;
                }
            }
            e eVar3 = (e) next2;
            if (eVar3 != null) {
                return eVar3;
            }
            for (Object obj2 : lVar) {
                e eVar4 = (e) obj2;
                if (eVar4.e || eVar4.f257f) {
                    obj = obj2;
                    break;
                }
            }
            return (e) obj;
        }
        if (i != 1) {
            throw new IllegalStateException(("Unsupported direction: '" + i + "'.").toString());
        }
        Iterator it4 = lVar2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next3 = null;
                break;
            }
            next3 = it4.next();
            if (((e) next3).f257f) {
                break;
            }
        }
        e eVar5 = (e) next3;
        if (eVar5 != null) {
            return eVar5;
        }
        Iterator it5 = lVar.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next5 = it5.next();
            if (((e) next5).f257f) {
                obj = next5;
                break;
            }
        }
        return (e) obj;
    }

    public final void d(e eVar) {
        f fVar;
        e eVarC = this.f258f;
        if (eVarC == null) {
            eVarC = c(0);
        }
        if (lmjxuqdtp.jvm.internal.o.c(eVarC, eVar)) {
            if (eVarC == null) {
                fVar = new f();
            } else {
                ArrayList arrayList = new ArrayList();
                for (e eVar2 : this.d) {
                    if (eVar2.e && !eVar2.b.isEmpty()) {
                        arrayList.addAll(eVar2.b);
                    }
                }
                for (e eVar3 : this.e) {
                    if (eVar3.e && !eVar3.b.isEmpty()) {
                        arrayList.addAll(eVar3.b);
                    }
                }
                h hVar = eVarC.a;
                List list = eVarC.c;
                lmjxuqdtp.jvm.internal.o.h(hVar, "currentInfo");
                lmjxuqdtp.jvm.internal.o.h(list, "forwardInfo");
                nx1.d dVarS = b.s();
                mx1.o.i0(dVarS, arrayList);
                dVarS.add(hVar);
                mx1.o.i0(dVarS, list);
                fVar = new f(b.m(dVarS), arrayList.size());
            }
            r2 r2Var = this.b;
            if (lmjxuqdtp.jvm.internal.o.c((f) r2Var.getValue(), fVar)) {
                return;
            }
            r2Var.getClass();
            r2Var.i((Object) null, fVar);
            Iterator it = this.k.iterator();
            while (it.hasNext()) {
                ((i) it.next()).getClass();
            }
            Iterator it2 = this.f259j.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).getClass();
            }
            Iterator it3 = this.i.iterator();
            while (it3.hasNext()) {
                ((i) it3.next()).getClass();
            }
        }
    }
}
