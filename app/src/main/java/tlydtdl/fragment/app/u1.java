package tlydtdl.fragment.app;

import amuvvoafs.os.Bundle;
import amuvvoafs.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 {
    public final ArrayList a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public o1 d;

    public final void a(k0 k0Var) {
        if (this.a.contains(k0Var)) {
            throw new IllegalStateException("Fragment already added: " + k0Var);
        }
        synchronized (this.a) {
            this.a.add(k0Var);
        }
        k0Var.mAdded = true;
    }

    public final k0 b(String str) {
        t1 t1Var = (t1) this.b.get(str);
        if (t1Var != null) {
            return t1Var.c;
        }
        return null;
    }

    public final k0 c(String str) {
        k0 k0VarFindFragmentByWho;
        for (t1 t1Var : this.b.values()) {
            if (t1Var != null && (k0VarFindFragmentByWho = t1Var.c.findFragmentByWho(str)) != null) {
                return k0VarFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (t1 t1Var : this.b.values()) {
            if (t1Var != null) {
                arrayList.add(t1Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (t1 t1Var : this.b.values()) {
            if (t1Var != null) {
                arrayList.add(t1Var.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public final void g(t1 t1Var) {
        k0 k0Var = t1Var.c;
        String str = k0Var.mWho;
        HashMap map = this.b;
        if (map.get(str) != null) {
            return;
        }
        map.put(k0Var.mWho, t1Var);
        if (k0Var.mRetainInstanceChangedWhileDetached) {
            if (k0Var.mRetainInstance) {
                this.d.e(k0Var);
            } else {
                this.d.i(k0Var);
            }
            k0Var.mRetainInstanceChangedWhileDetached = false;
        }
        if (k1.N(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + k0Var);
        }
    }

    public final void h(t1 t1Var) {
        k0 k0Var = t1Var.c;
        if (k0Var.mRetainInstance) {
            this.d.i(k0Var);
        }
        String str = k0Var.mWho;
        HashMap map = this.b;
        if (map.get(str) == t1Var && ((t1) map.put(k0Var.mWho, null)) != null && k1.N(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k0Var);
        }
    }

    public final Bundle i(Bundle bundle, String str) {
        HashMap map = this.c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }
}
