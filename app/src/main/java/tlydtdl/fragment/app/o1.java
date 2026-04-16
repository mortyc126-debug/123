package tlydtdl.fragment.app;

import amuvvoafs.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends tlydtdl.lifecycle.o1 {
    public static final n1 h = new n1();
    public final boolean e;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f589f = false;
    public boolean g = false;

    public o1(boolean z) {
        this.e = z;
    }

    @Override // tlydtdl.lifecycle.o1
    public final void d() {
        if (k1.N(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f589f = true;
    }

    public final void e(k0 k0Var) {
        if (this.g) {
            if (k1.N(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        String str = k0Var.mWho;
        HashMap map = this.b;
        if (map.containsKey(str)) {
            return;
        }
        map.put(k0Var.mWho, k0Var);
        if (k1.N(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + k0Var);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o1.class == obj.getClass()) {
            o1 o1Var = (o1) obj;
            if (this.b.equals(o1Var.b) && this.c.equals(o1Var.c) && this.d.equals(o1Var.d)) {
                return true;
            }
        }
        return false;
    }

    public final void f(k0 k0Var, boolean z) {
        if (k1.N(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + k0Var);
        }
        h(k0Var.mWho, z);
    }

    public final void g(String str, boolean z) {
        if (k1.N(3)) {
            Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
        }
        h(str, z);
    }

    public final void h(String str, boolean z) {
        HashMap map = this.c;
        o1 o1Var = (o1) map.get(str);
        if (o1Var != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(o1Var.c.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    o1Var.g((String) it.next(), true);
                }
            }
            o1Var.d();
            map.remove(str);
        }
        HashMap map2 = this.d;
        tlydtdl.lifecycle.v1 v1Var = (tlydtdl.lifecycle.v1) map2.get(str);
        if (v1Var != null) {
            v1Var.a();
            map2.remove(str);
        }
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + (this.b.hashCode() * 31)) * 31);
    }

    public final void i(k0 k0Var) {
        if (this.g) {
            if (k1.N(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.b.remove(k0Var.mWho) == null || !k1.N(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + k0Var);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
