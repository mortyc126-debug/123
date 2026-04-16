package rd1;

import q.q2;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements a0 {
    public static final /* synthetic */ int g = 0;
    public final f2 b;
    public final of1.n c;
    public final b0 d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f417f;

    public x(f2 f2Var, of1.n nVar, float f2) {
        b0 b0Var = b0.b;
        lmjxuqdtp.jvm.internal.o.h(nVar, "textStyle");
        lmjxuqdtp.jvm.internal.o.h(b0Var, "shape");
        this.b = f2Var;
        this.c = nVar;
        this.d = b0Var;
        this.e = f2;
        this.f417f = f2;
    }

    @Override // rd1.a0
    public final of1.n a() {
        return this.c;
    }

    @Override // rd1.a0
    public final e2 b() {
        return this.b;
    }

    @Override // rd1.a0
    public final float c() {
        return this.f417f;
    }

    @Override // rd1.a0
    public final float d() {
        return this.e;
    }

    @Override // rd1.a0
    public final b0 e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.b, xVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, xVar.c) && this.d == xVar.d && p5.f.a(this.e, xVar.e) && p5.f.a(this.f417f, xVar.f417f);
    }

    public final int hashCode() {
        return Float.hashCode(this.f417f) + s1.a.b(this.e, (this.d.hashCode() + q2.i(this.c, this.b.hashCode() * 31, 31)) * 31, 31);
    }

    public final String toString() {
        String strB = p5.f.b(this.e);
        String strB2 = p5.f.b(this.f417f);
        StringBuilder sb = new StringBuilder("Custom(padding=");
        sb.append(this.b);
        sb.append(", textStyle=");
        sb.append(this.c);
        sb.append(", shape=");
        sb.append(this.d);
        sb.append(", iconHeight=");
        sb.append(strB);
        sb.append(", iconWidth=");
        return i.p(sb, strB2, ")");
    }
}
