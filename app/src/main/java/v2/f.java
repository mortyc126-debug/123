package v2;

import a5.t;
import a5.v;
import a5.w;
import f3.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements c {
    public final int a;

    public f(int i) {
        this.a = i;
        if (i >= 0) {
            return;
        }
        d2.a.a("maxLength must be at least zero");
    }

    @Override // v2.c
    public final void a(h hVar) {
        if (hVar.c.length() > this.a) {
            hVar.e();
        }
    }

    @Override // v2.c
    public final void b(a5.k kVar) {
        fy1.l[] lVarArr = v.a;
        w wVar = t.N;
        fy1.l lVar = v.a[26];
        wVar.a(kVar, Integer.valueOf(this.a));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.a == ((f) obj).a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final String toString() {
        return f2.l(new StringBuilder("InputTransformation.maxLength("), this.a, ')');
    }
}
