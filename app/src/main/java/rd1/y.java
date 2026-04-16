package rd1;

import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements a0 {
    public static final /* synthetic */ int g = 0;
    public final b0 b;
    public final float c;
    public final float d;
    public final e2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final of1.n f418f;

    public y(b0 b0Var, float f2, float f3, int i) {
        b0Var = (i & 1) != 0 ? b0.b : b0Var;
        f2 = (i & 2) != 0 ? 24 : f2;
        f3 = (i & 4) != 0 ? f2 : f3;
        float f4 = 16;
        float f5 = 12;
        f2 f2Var = new f2(f4, f5, f4, f5);
        lmjxuqdtp.jvm.internal.o.h(b0Var, "shape");
        this.b = b0Var;
        this.c = f2;
        this.d = f3;
        this.e = f2Var;
        this.f418f = of1.q.c();
    }

    @Override // rd1.a0
    public final of1.n a() {
        return this.f418f;
    }

    @Override // rd1.a0
    public final e2 b() {
        return this.e;
    }

    @Override // rd1.a0
    public final float c() {
        return this.d;
    }

    @Override // rd1.a0
    public final float d() {
        return this.c;
    }

    @Override // rd1.a0
    public final b0 e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.b == yVar.b && p5.f.a(this.c, yVar.c) && p5.f.a(this.d, yVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, yVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + s1.a.b(this.d, s1.a.b(this.c, this.b.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "Large(shape=" + this.b + ", iconHeight=" + p5.f.b(this.c) + ", iconWidth=" + p5.f.b(this.d) + ", padding=" + this.e + ")";
    }
}
