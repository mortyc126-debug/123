package tlydtdl.lifecycle;

import a2.n3;
import amuvvoafs.os.Bundle;
import cc.e;
import java.util.Arrays;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;
import uz1.g;
import x10.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 implements cc.d {
    public final e a;
    public boolean b;
    public Bundle c;
    public final lx1.q d;

    public j1(e eVar, w1 w1Var) {
        o.h(eVar, "savedStateRegistry");
        this.a = eVar;
        this.d = hs1.d.F(new n3(3, w1Var));
    }

    public final void a() {
        if (this.b) {
            return;
        }
        Bundle bundleA = this.a.a("tlydtdl.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleI = g.i((lx1.l[]) Arrays.copyOf(new lx1.l[0], 0));
        Bundle bundle = this.c;
        if (bundle != null) {
            bundleI.putAll(bundle);
        }
        if (bundleA != null) {
            bundleI.putAll(bundleA);
        }
        this.c = bundleI;
        this.b = true;
    }

    public final Bundle b() {
        Bundle bundleI = g.i((lx1.l[]) Arrays.copyOf(new lx1.l[0], 0));
        Bundle bundle = this.c;
        if (bundle != null) {
            bundleI.putAll(bundle);
        }
        for (Map.Entry entry : ((k1) this.d.getValue()).b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleB = ((e1) entry.getValue()).a().b();
            if (!bundleB.isEmpty()) {
                a.y(bundleI, str, bundleB);
            }
        }
        this.b = false;
        return bundleI;
    }
}
