package tlydtdl.lifecycle;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import ny1.b2;
import ny1.r2;
import s.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends z {
    public final boolean b;
    public a c = new a();
    public y d;
    public final WeakReference e;

    /* JADX INFO: renamed from: f */
    public int f598f;
    public boolean g;
    public boolean h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j */
    public final r2 f599j;

    public i0(g0 g0Var, boolean z) {
        this.b = z;
        y yVar = y.b;
        this.d = yVar;
        this.i = new ArrayList();
        this.e = new WeakReference(g0Var);
        this.f599j = ny1.z.c(yVar);
    }

    @Override // tlydtdl.lifecycle.z
    public final void a(f0 f0Var) {
        e0 jVar;
        g0 g0Var;
        o.h(f0Var, "observer");
        f("addObserver");
        y yVar = this.d;
        y yVar2 = y.a;
        if (yVar != yVar2) {
            yVar2 = y.b;
        }
        h0 h0Var = new h0();
        HashMap map = k0.a;
        boolean z = f0Var instanceof e0;
        boolean z2 = f0Var instanceof h;
        Object obj = null;
        if (z && z2) {
            jVar = new j((h) f0Var, (e0) f0Var);
        } else if (z2) {
            jVar = new j((h) f0Var, null);
        } else if (z) {
            jVar = (e0) f0Var;
        } else {
            Class<?> cls = f0Var.getClass();
            if (k0.b(cls) == 2) {
                Object obj2 = k0.b.get(cls);
                o.e(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    k0.a((Constructor) list.get(0), f0Var);
                    throw null;
                }
                int size = list.size();
                p[] pVarArr = new p[size];
                if (size > 0) {
                    k0.a((Constructor) list.get(0), f0Var);
                    throw null;
                }
                jVar = new e(pVarArr);
            } else {
                jVar = new j(f0Var);
            }
        }
        h0Var.b = jVar;
        h0Var.a = yVar2;
        a aVar = this.c;
        s.d dVarB = aVar.b(f0Var);
        if (dVarB != null) {
            obj = dVarB.b;
        } else {
            HashMap map2 = aVar.e;
            s.d dVar = new s.d(f0Var, h0Var);
            ((s.h) aVar).d++;
            s.d dVar2 = ((s.h) aVar).b;
            if (dVar2 == null) {
                ((s.h) aVar).a = dVar;
                ((s.h) aVar).b = dVar;
            } else {
                dVar2.c = dVar;
                dVar.d = dVar2;
                ((s.h) aVar).b = dVar;
            }
            map2.put(f0Var, dVar);
        }
        if (((h0) obj) == null && (g0Var = (g0) this.e.get()) != null) {
            boolean z3 = this.f598f != 0 || this.g;
            y yVarE = e(f0Var);
            this.f598f++;
            while (h0Var.a.compareTo(yVarE) < 0 && this.c.e.containsKey(f0Var)) {
                y yVar3 = h0Var.a;
                ArrayList arrayList = this.i;
                arrayList.add(yVar3);
                v vVar = x.Companion;
                y yVar4 = h0Var.a;
                vVar.getClass();
                x xVarB = v.b(yVar4);
                if (xVarB == null) {
                    throw new IllegalStateException("no event up from " + h0Var.a);
                }
                h0Var.a(g0Var, xVarB);
                arrayList.remove(arrayList.size() - 1);
                yVarE = e(f0Var);
            }
            if (!z3) {
                j();
            }
            this.f598f--;
        }
    }

    @Override // tlydtdl.lifecycle.z
    public final y b() {
        return this.d;
    }

    @Override // tlydtdl.lifecycle.z
    public final b2 c() {
        return new b2(this.f599j);
    }

    @Override // tlydtdl.lifecycle.z
    public final void d(f0 f0Var) {
        o.h(f0Var, "observer");
        f("removeObserver");
        this.c.d(f0Var);
    }

    public final y e(f0 f0Var) {
        HashMap map = this.c.e;
        s.d dVar = map.containsKey(f0Var) ? ((s.d) map.get(f0Var)).d : null;
        y yVar = dVar != null ? ((h0) dVar.b).a : null;
        ArrayList arrayList = this.i;
        y yVar2 = arrayList.isEmpty() ? null : (y) o6.c.h(1, arrayList);
        y yVar3 = this.d;
        o.h(yVar3, "state1");
        if (yVar == null || yVar.compareTo(yVar3) >= 0) {
            yVar = yVar3;
        }
        return (yVar2 == null || yVar2.compareTo(yVar) >= 0) ? yVar : yVar2;
    }

    public final void f(String str) {
        if (this.b && !r.b.O().P()) {
            throw new IllegalStateException(i.n("Method ", str, " must be called on the main thread").toString());
        }
    }

    public final void g(x xVar) {
        o.h(xVar, "event");
        f("handleLifecycleEvent");
        h(xVar.a());
    }

    public final void h(y yVar) {
        if (this.d == yVar) {
            return;
        }
        g0 g0Var = (g0) this.e.get();
        y yVar2 = this.d;
        o.h(yVar2, "current");
        o.h(yVar, "next");
        if (yVar2 == y.b && yVar == y.a) {
            throw new IllegalStateException(("State must be at least '" + y.c + "' to be moved to '" + yVar + "' in component " + g0Var).toString());
        }
        y yVar3 = y.a;
        if (yVar2 == yVar3 && yVar2 != yVar) {
            throw new IllegalStateException(("State is '" + yVar3 + "' and cannot be moved to `" + yVar + "` in component " + g0Var).toString());
        }
        this.d = yVar;
        if (this.g || this.f598f != 0) {
            this.h = true;
            return;
        }
        this.g = true;
        j();
        this.g = false;
        if (this.d == yVar3) {
            this.c = new a();
        }
    }

    public final void i(y yVar) {
        o.h(yVar, "state");
        f("setCurrentState");
        h(yVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0030, code lost:
    
        r7.h = false;
        r7.f599j.setValue(r7.d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0039, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.lifecycle.i0.j():void");
    }
}
