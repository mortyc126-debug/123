package tlydtdl.compose.foundation;

import a4.a1;
import a4.u;
import a4.y;
import lmjxuqdtp.Metadata;
import s4.c1;
import s4.g;
import t3.o;
import t4.e2;
import t4.q;
import tlydtdl.compose.foundation.layout.m;
import v1.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/BackgroundElement;", "Ls4/c1;", "Lv1/l;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class BackgroundElement extends c1 {
    public final long a;
    public final u b;
    public final float c;
    public final a1 d;
    public final q e;

    public BackgroundElement(long j2, u uVar, float f2, a1 a1Var, int i) {
        q qVar = q.h;
        j2 = (i & 1) != 0 ? y.h : j2;
        uVar = (i & 2) != 0 ? null : uVar;
        this.a = j2;
        this.b = uVar;
        this.c = f2;
        this.d = a1Var;
        this.e = qVar;
    }

    @Override // s4.c1
    public final o create() {
        l lVar = new l();
        lVar.a = this.a;
        lVar.b = this.b;
        lVar.c = this.c;
        lVar.d = this.d;
        lVar.e = 9205357640488583168L;
        return lVar;
    }

    public final boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && y.c(this.a, backgroundElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, backgroundElement.b) && this.c == backgroundElement.c && lmjxuqdtp.jvm.internal.o.c(this.d, backgroundElement.d);
    }

    public final int hashCode() {
        int i = y.i;
        int iHashCode = Long.hashCode(this.a) * 31;
        u uVar = this.b;
        return this.d.hashCode() + s1.a.b(this.c, (iHashCode + (uVar != null ? uVar.hashCode() : 0)) * 31, 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
        this.e.getClass();
    }

    @Override // s4.c1
    public final void update(o oVar) {
        l lVar = (l) oVar;
        lVar.a = this.a;
        lVar.b = this.b;
        lVar.c = this.c;
        lVar.d = this.d;
        g.l(lVar);
    }
}
