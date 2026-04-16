package tlydtdl.fragment.app;

import amuvvoafs.util.Log;
import f.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import mx1.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends w {
    public final /* synthetic */ k1 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(k1 k1Var) {
        super(false);
        this.d = k1Var;
    }

    @Override // f.w
    public final void a() {
        boolean zN = k1.N(3);
        k1 k1Var = this.d;
        if (zN) {
            Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + k1Var);
        }
        if (k1.N(3)) {
            Log.d("FragmentManager", "cancelBackStackTransition for transition " + k1Var.h);
        }
        a aVar = k1Var.h;
        if (aVar != null) {
            aVar.s = false;
            aVar.h();
            a aVar2 = k1Var.h;
            a0.y yVar = new a0.y(11, k1Var);
            if (aVar2.q == null) {
                aVar2.q = new ArrayList();
            }
            aVar2.q.add(yVar);
            k1Var.h.d();
            k1Var.i = true;
            k1Var.A(true);
            k1Var.G();
            k1Var.i = false;
            k1Var.h = null;
        }
    }

    @Override // f.w
    public final void b() {
        boolean zN = k1.N(3);
        k1 k1Var = this.d;
        if (zN) {
            Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + k1Var);
        }
        y0 y0Var = k1Var.f588j;
        ArrayList<g1> arrayList = k1Var.o;
        k1Var.i = true;
        k1Var.A(true);
        k1Var.i = false;
        if (k1Var.h == null) {
            if (y0Var.b) {
                if (k1.N(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                k1Var.V();
                return;
            } else {
                if (k1.N(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                k1Var.g.c.b();
                return;
            }
        }
        if (!arrayList.isEmpty()) {
            LinkedHashSet<k0> linkedHashSet = new LinkedHashSet(k1.H(k1Var.h));
            for (g1 g1Var : arrayList) {
                for (k0 k0Var : linkedHashSet) {
                    g1Var.getClass();
                }
            }
        }
        Iterator it = k1Var.h.a.iterator();
        while (it.hasNext()) {
            k0 k0Var2 = ((v1) it.next()).b;
            if (k0Var2 != null) {
                k0Var2.mTransitioning = false;
            }
        }
        for (r rVar : k1Var.g(new ArrayList(Collections.singletonList(k1Var.h)), 0, 1)) {
            ArrayList arrayList2 = rVar.c;
            if (k1.N(3)) {
                Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
            }
            rVar.m(arrayList2);
            rVar.c(arrayList2);
        }
        Iterator it2 = k1Var.h.a.iterator();
        while (it2.hasNext()) {
            k0 k0Var3 = ((v1) it2.next()).b;
            if (k0Var3 != null && k0Var3.mContainer == null) {
                k1Var.h(k0Var3).k();
            }
        }
        k1Var.h = null;
        k1Var.n0();
        if (k1.N(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + y0Var.b + " for  FragmentManager " + k1Var);
        }
    }

    @Override // f.w
    public final void c(f.a aVar) {
        boolean zN = k1.N(2);
        k1 k1Var = this.d;
        if (zN) {
            Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + k1Var);
        }
        if (k1Var.h != null) {
            for (r rVar : k1Var.g(new ArrayList(Collections.singletonList(k1Var.h)), 0, 1)) {
                rVar.getClass();
                if (k1.N(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + aVar.a());
                }
                ArrayList arrayList = rVar.c;
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    o.i0(arrayList2, ((j2) it.next()).k);
                }
                List listM1 = o.m1(o.r1(arrayList2));
                int size = listM1.size();
                for (int i = 0; i < size; i++) {
                    ((i2) listM1.get(i)).e(aVar, rVar.a);
                }
            }
            Iterator it2 = k1Var.o.iterator();
            while (it2.hasNext()) {
                ((g1) it2.next()).getClass();
            }
        }
    }

    @Override // f.w
    public final void d(f.a aVar) {
        boolean zN = k1.N(3);
        k1 k1Var = this.d;
        if (zN) {
            Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + k1Var);
        }
        k1Var.x();
        k1Var.y(new j1(k1Var), false);
    }
}
