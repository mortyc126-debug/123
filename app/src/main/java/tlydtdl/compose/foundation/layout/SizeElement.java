package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.Metadata;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/layout/SizeElement;", "Ls4/c1;", "Ltlydtdl/compose/foundation/layout/p2;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class SizeElement extends s4.c1 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t4.q f483f;

    public SizeElement(float f2, float f3, float f4, float f5, boolean z) {
        t4.q qVar = t4.q.h;
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = z;
        this.f483f = qVar;
    }

    @Override // s4.c1
    public final t3.o create() {
        p2 p2Var = new p2();
        p2Var.a = this.a;
        p2Var.b = this.b;
        p2Var.c = this.c;
        p2Var.d = this.d;
        p2Var.e = this.e;
        return p2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return p5.f.a(this.a, sizeElement.a) && p5.f.a(this.b, sizeElement.b) && p5.f.a(this.c, sizeElement.c) && p5.f.a(this.d, sizeElement.d) && this.e == sizeElement.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.e) + s1.a.b(this.d, s1.a.b(this.c, s1.a.b(this.b, Float.hashCode(this.a) * 31, 31), 31), 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(t4.e2 e2Var) {
        this.f483f.getClass();
    }

    @Override // s4.c1
    public final void update(t3.o oVar) {
        p2 p2Var = (p2) oVar;
        p2Var.a = this.a;
        p2Var.b = this.b;
        p2Var.c = this.c;
        p2Var.d = this.d;
        p2Var.e = this.e;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SizeElement(float f2, float f3, float f4, float f5, boolean z, int i) {
        boolean z2;
        float f7;
        f2 = (i & 1) != 0 ? Float.NaN : f2;
        f3 = (i & 2) != 0 ? Float.NaN : f3;
        f4 = (i & 4) != 0 ? Float.NaN : f4;
        if ((i & 8) != 0) {
            z2 = z;
            f7 = Float.NaN;
        } else {
            z2 = z;
            f7 = f5;
        }
        this(f2, f3, f4, f7, z2);
    }
}
