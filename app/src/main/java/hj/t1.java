package hj;

import a3.c1;
import amuvvoafs.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 {
    public k2 a;
    public final j3 b;
    public final k1 c;
    public final ky1.a0 d;
    public final View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f208f;
    public int g;
    public boolean h;
    public LinkedHashMap i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinkedHashMap f209j;
    public boolean k;
    public Map l;

    public t1(float f2, k2 k2Var, j3 j3Var, k1 k1Var, ky1.a0 a0Var, l1 l1Var, Map map, int i, boolean z, boolean z2) {
        o.h(j3Var, "conv");
        o.h(k1Var, "regionAttributes");
        o.h(a0Var, "scope");
        o.h(map, "initialState");
        this.a = k2Var;
        this.b = j3Var;
        this.c = k1Var;
        this.d = a0Var;
        this.e = (View) l1Var;
        this.f208f = f2;
        this.g = i;
        this.h = z;
        this.k = z2;
        mx1.u uVar = mx1.u.a;
        s1 s1VarE = e(k2Var, uVar, uVar, map, i, z);
        this.f209j = s1VarE.a;
        this.i = s1VarE.b;
    }

    public static final w2 a(d2 d2Var, w2 w2Var) {
        i3 i3VarE = d2Var.e();
        y2 y2VarC = d2Var.c();
        float fB = d2Var.b();
        float fL = w2Var.l();
        float fD = w2Var.d();
        return new w2(w2Var.f(), w2Var.n(), fL, fD, fB, w2Var.g(), w2Var.e(), w2Var.k(), i3VarE, y2VarC);
    }

    public final di0.a b(hg1.o oVar) {
        c1 c1VarJ;
        r1 r1Var;
        Iterator it = this.f209j.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                c1VarJ = null;
                break;
            }
            c1VarJ = ((o1) it.next()).j(oVar);
            if (c1VarJ != null) {
                break;
            }
        }
        q1 q1Var = c1VarJ != null ? new q1(c1VarJ) : null;
        if (q1Var != null) {
            return q1Var;
        }
        for (Map.Entry entry : this.i.entrySet()) {
            String str = (String) entry.getKey();
            gy1.w it2 = mx1.o.t1((List) entry.getValue()).iterator();
            while (true) {
                gy1.w wVar = it2;
                if (!wVar.b.hasNext()) {
                    r1Var = null;
                    break;
                }
                mx1.w wVar2 = (mx1.w) wVar.next();
                r1Var = ((o1) wVar2.b).j(oVar) != null ? new r1(str, wVar2.a) : null;
                if (r1Var != null) {
                    break;
                }
            }
            if (r1Var != null) {
                return r1Var;
            }
        }
        return null;
    }

    public final void c(float f2) {
        this.f208f = f2;
        Iterator it = this.f209j.entrySet().iterator();
        while (it.hasNext()) {
            ((o1) ((Map.Entry) it.next()).getValue()).m(this.f208f);
        }
        Iterator it2 = this.i.values().iterator();
        while (it2.hasNext()) {
            Iterator it3 = ((List) it2.next()).iterator();
            while (it3.hasNext()) {
                ((o1) it3.next()).m(this.f208f);
            }
        }
    }

    public final void d(Map map, k2 k2Var, int i, boolean z) {
        o.h(map, "newRegions");
        this.g = i;
        boolean z2 = this.h != z;
        boolean zEquals = this.a.equals(k2Var);
        if (map == this.l && !z2 && zEquals) {
            return;
        }
        this.l = map;
        this.h = z;
        this.a = k2Var;
        s1 s1VarE = e(k2Var, this.f209j, this.i, map, this.g, z);
        this.f209j = s1VarE.a;
        this.i = s1VarE.b;
    }

    public final s1 e(k2 k2Var, Map map, Map map2, Map map3, int i, boolean z) {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        String str;
        int i2;
        LinkedHashMap linkedHashMap3;
        List list;
        int i3;
        String strA;
        k2 k2Var2 = k2Var;
        int i4 = i;
        boolean z2 = z;
        int i6 = k2Var2.a;
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap();
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        for (Map.Entry entry : map3.entrySet()) {
            String str2 = (String) entry.getKey();
            w2 w2Var = (w2) entry.getValue();
            o1 o1Var = (o1) map.get(str2);
            View view = this.e;
            if (o1Var != null) {
                o1Var.q(w2Var, i4, z2, k2Var2.d);
                str = str2;
                linkedHashMap = linkedHashMap4;
                linkedHashMap2 = linkedHashMap6;
            } else {
                linkedHashMap = linkedHashMap4;
                linkedHashMap2 = linkedHashMap6;
                str = str2;
                o1Var = new o1(this.c, this.f208f, k2Var2.d, w2Var, this.b, this.d, view, this.g, z2);
            }
            boolean z3 = this.k;
            o1Var.k(z3, z3);
            if (o1Var.h().j()) {
                linkedHashMap2.put(str, o1Var);
            } else {
                linkedHashMap5.put(str, o1Var);
            }
            if (i6 > 0) {
                List listF1 = mx1.o.f1(w2Var.m(), i6);
                ArrayList arrayList = new ArrayList(listF1.size());
                int size = listF1.size();
                int i7 = 0;
                while (i7 < size) {
                    d2 d2Var = (d2) listF1.get(i7);
                    List list2 = (List) map2.get(w2Var.f());
                    o1 o1Var2 = list2 != null ? (o1) mx1.o.z0(i7, list2) : null;
                    d3 d3Var = (d3) k2Var2.c.get(i7);
                    boolean z4 = !d2Var.d() || z;
                    if (o1Var2 != null) {
                        i3 i3VarE = d2Var.e();
                        if (i3VarE != null) {
                            list = listF1;
                            strA = i3VarE.a();
                        } else {
                            list = listF1;
                            strA = null;
                        }
                        i3 i3VarO = o1Var2.h().o();
                        i3 = size;
                        o1Var2.q((o.c(strA, i3VarO != null ? i3VarO.a() : null) && o.c(d2Var.c(), o1Var2.h().i()) && hg1.r.b(d2Var.b(), o1Var2.h().h()) && hg1.r.b(w2Var.l(), o1Var2.h().l()) && hg1.r.b(w2Var.d(), o1Var2.h().d()) && o.c(w2Var.f(), o1Var2.h().f()) && o.c(w2Var.n(), o1Var2.h().n()) && hg1.r.b(w2Var.g(), o1Var2.h().g()) && w2Var.k() == o1Var2.h().k() && w2Var.e() == o1Var2.h().e()) ? o1Var2.h() : a(d2Var, w2Var), i, z4, d3Var);
                    } else {
                        list = listF1;
                        i3 = size;
                        o1Var2 = new o1(this.c, this.f208f, d3Var, a(d2Var, w2Var), this.b, this.d, view, this.g, z4);
                    }
                    arrayList.add(o1Var2);
                    i7++;
                    k2Var2 = k2Var;
                    listF1 = list;
                    size = i3;
                }
                i2 = i;
                linkedHashMap3 = linkedHashMap;
                linkedHashMap3.put(str, arrayList);
            } else {
                i2 = i;
                linkedHashMap3 = linkedHashMap;
            }
            z2 = z;
            i4 = i2;
            linkedHashMap6 = linkedHashMap2;
            linkedHashMap4 = linkedHashMap3;
            k2Var2 = k2Var;
        }
        return new s1(mx1.z.Y(linkedHashMap5, linkedHashMap6), linkedHashMap4);
    }
}
