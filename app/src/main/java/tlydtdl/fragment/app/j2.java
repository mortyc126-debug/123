package tlydtdl.fragment.app;

import amuvvoafs.util.Log;
import amuvvoafs.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import lmjxuqdtp.jvm.internal.m;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j2 {
    public int a;
    public int b;
    public final k0 c;
    public final ArrayList d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f585f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f586j;
    public final ArrayList k;
    public final t1 l;

    public j2(int i, int i2, t1 t1Var) {
        m.a(i, "finalState");
        m.a(i2, "lifecycleImpact");
        k0 k0Var = t1Var.c;
        o.g(k0Var, "fragmentStateManager.fragment");
        m.a(i, "finalState");
        m.a(i2, "lifecycleImpact");
        o.h(k0Var, "fragment");
        this.a = i;
        this.b = i2;
        this.c = k0Var;
        this.d = new ArrayList();
        this.i = true;
        ArrayList arrayList = new ArrayList();
        this.f586j = arrayList;
        this.k = arrayList;
        this.l = t1Var;
    }

    public final void a(ViewGroup viewGroup) {
        o.h(viewGroup, "container");
        this.h = false;
        if (this.e) {
            return;
        }
        this.e = true;
        if (this.f586j.isEmpty()) {
            b();
            return;
        }
        Iterator it = mx1.o.m1(this.k).iterator();
        while (it.hasNext()) {
            ((i2) it.next()).a(viewGroup);
        }
    }

    public final void b() {
        this.h = false;
        if (!this.f585f) {
            if (k1.N(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f585f = true;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.c.mTransitioning = false;
        this.l.k();
    }

    public final void c(i2 i2Var) {
        o.h(i2Var, "effect");
        ArrayList arrayList = this.f586j;
        if (arrayList.remove(i2Var) && arrayList.isEmpty()) {
            b();
        }
    }

    public final void d(int i, int i2) {
        m.a(i, "finalState");
        m.a(i2, "lifecycleImpact");
        int iK = z.p.k(i2);
        k0 k0Var = this.c;
        if (iK == 0) {
            if (this.a != 1) {
                if (k1.N(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + k0Var + " mFinalState = " + i.E(this.a) + " -> " + i.E(i) + '.');
                }
                this.a = i;
                return;
            }
            return;
        }
        if (iK == 1) {
            if (this.a == 1) {
                if (k1.N(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + k0Var + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + i.D(this.b) + " to ADDING.");
                }
                this.a = 2;
                this.b = 2;
                this.i = true;
                return;
            }
            return;
        }
        if (iK != 2) {
            return;
        }
        if (k1.N(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + k0Var + " mFinalState = " + i.E(this.a) + " -> REMOVED. mLifecycleImpact  = " + i.D(this.b) + " to REMOVING.");
        }
        this.a = 1;
        this.b = 3;
        this.i = true;
    }

    public final String toString() {
        StringBuilder sbQ = f3.f2.q("Operation {", Integer.toHexString(System.identityHashCode(this)), "} {finalState = ");
        sbQ.append(i.E(this.a));
        sbQ.append(" lifecycleImpact = ");
        sbQ.append(i.D(this.b));
        sbQ.append(" fragment = ");
        sbQ.append(this.c);
        sbQ.append('}');
        return sbQ.toString();
    }
}
