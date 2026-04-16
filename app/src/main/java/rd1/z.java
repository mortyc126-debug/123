package rd1;

import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.foundation.layout.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements a0 {
    public static final /* synthetic */ int g = 0;
    public final b0 b;
    public final float c;
    public final float d;
    public final e2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final of1.n f419f;

    public z(b0 b0Var, float f2, f2 f2Var, int i) {
        b0Var = (i & 1) != 0 ? b0.b : b0Var;
        float f3 = 20;
        f2 = (i & 4) != 0 ? f3 : f2;
        if ((i & 8) != 0) {
            float f4 = 12;
            float f5 = 8;
            f2Var = new f2(f4, f5, f4, f5);
        }
        lmjxuqdtp.jvm.internal.o.h(b0Var, "shape");
        this.b = b0Var;
        this.c = f3;
        this.d = f2;
        this.e = f2Var;
        this.f419f = of1.q.c();
    }

    @Override // rd1.a0
    public final of1.n a() {
        return this.f419f;
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
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.b == zVar.b && p5.f.a(this.c, zVar.c) && p5.f.a(this.d, zVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, zVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + s1.a.b(this.d, s1.a.b(this.c, this.b.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "Medium(shape=" + this.b + ", iconHeight=" + p5.f.b(this.c) + ", iconWidth=" + p5.f.b(this.d) + ", padding=" + this.e + ")";
    }
}
