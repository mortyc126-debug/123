package tlydtdl.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o2 implements Iterable, ay1.a {
    public int b;
    public int d;
    public int e;
    public boolean g;
    public int h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap f538j;
    public q1.z k;
    public int[] a = new int[0];
    public Object[] c = new Object[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f537f = new Object();
    public ArrayList i = new ArrayList();

    public final int b(a aVar) {
        if (this.g) {
            u.c("Use active SlotWriter to determine anchor location instead");
        }
        if (!aVar.a()) {
            v1.a("Anchor refers to a group that was removed");
        }
        return aVar.a;
    }

    public final void d() {
        this.f538j = new HashMap();
    }

    public final n2 e() {
        if (this.g) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.e++;
        return new n2(this);
    }

    public final r2 h() {
        if (this.g) {
            u.c("Cannot start a writer when another writer is pending");
        }
        if (this.e > 0) {
            u.c("Cannot start a writer when a reader is pending");
        }
        this.g = true;
        this.h++;
        return new r2(this);
    }

    public final boolean i(a aVar) {
        int iE;
        return aVar.a() && (iE = q2.e(this.i, aVar.a, this.b)) >= 0 && lmjxuqdtp.jvm.internal.o.c(this.i.get(iE), aVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new n0(this, 0, this.b);
    }

    public final o0 k(int i) {
        int i2;
        ArrayList arrayList;
        int iE;
        HashMap map = this.f538j;
        if (map != null) {
            if (this.g) {
                u.c("use active SlotWriter to crate an anchor for location instead");
            }
            a aVar = (i < 0 || i >= (i2 = this.b) || (iE = q2.e((arrayList = this.i), i, i2)) < 0) ? null : (a) arrayList.get(iE);
            if (aVar != null) {
                return (o0) map.get(aVar);
            }
        }
        return null;
    }
}
