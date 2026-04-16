package cf1;

import a2.p1;
import ey1.f;
import ky1.c0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import qx1.d;
import rx1.a;
import tlydtdl.compose.runtime.j1;
import tlydtdl.compose.runtime.k1;
import tlydtdl.compose.runtime.n1;
import v1.x0;
import v1.z0;
import ve.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements p1 {
    public final m0 a;
    public final Float b;
    public final int c;
    public Function0 d;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j1 f32f;
    public Function1 g;
    public Function0 h;
    public final float[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k1 f33j;
    public boolean k;
    public final j1 l;
    public final j1 m;
    public final j1 n;
    public final n1 o;
    public final a0 p;
    public final j1 q;
    public final j1 r;
    public final z s;
    public final z0 t;

    public b0(m0 m0Var, Float f2, float f3, int i, Function0 function0, f fVar) {
        float[] fArr;
        lmjxuqdtp.jvm.internal.o.h(m0Var, "thumbVisibility");
        lmjxuqdtp.jvm.internal.o.h(fVar, "valueRange");
        this.a = m0Var;
        this.b = f2;
        this.c = i;
        this.d = function0;
        this.e = fVar;
        this.f32f = new j1(f3);
        if (i == 0) {
            fArr = new float[0];
        } else {
            int i2 = i + 2;
            float[] fArr2 = new float[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                fArr2[i3] = i3 / (i + 1);
            }
            fArr = fArr2;
        }
        this.i = fArr;
        this.f33j = new k1(0);
        this.l = new j1(0.0f);
        this.m = new j1(0.0f);
        this.n = new j1(Float.NEGATIVE_INFINITY);
        this.o = tlydtdl.compose.runtime.a0.t(k0.c);
        this.p = new a0(this);
        this.q = new j1(g.I(0.0f, 0.0f, cd.i0.n(((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue(), f3)));
        this.r = new j1(0.0f);
        this.s = new z(0, this);
        this.t = new z0();
    }

    public final Object a(x0 x0Var, Function2 function2, d dVar) {
        Object objO = c0.o(new c41.p(this, x0Var, function2, (d) null), dVar);
        return objO == a.a ? objO : lx1.b0.a;
    }

    public final void b(float f2) {
        Float f3 = this.b;
        float fFloatValue = f3 != null ? f3.floatValue() : this.m.h();
        if (fFloatValue == 0.0f) {
            fFloatValue = Float.MIN_VALUE;
        }
        float f4 = fFloatValue / 2;
        float fMax = Math.max(this.f33j.h() - f4, 0.0f);
        float fMin = Math.min(f4, fMax);
        float fSignum = Math.signum(fFloatValue) * f2;
        j1 j1Var = this.q;
        float fH = j1Var.h() + fSignum;
        j1 j1Var2 = this.r;
        j1Var.i(j1Var2.h() + fH);
        j1Var2.i(0.0f);
        float fG = cd.i0.G(j1Var.h(), this.i, fMin, fMax);
        f fVar = this.e;
        float fI = g.I(((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue(), cd.i0.n(fMin, fMax, fG));
        if (fI == this.f32f.h()) {
            return;
        }
        Function1 function1 = this.g;
        if (function1 != null) {
            function1.invoke(Float.valueOf(fI));
        } else {
            h(fI);
        }
    }

    public final void c() {
        Function0 function0;
        k0 k0VarE = e();
        k0VarE.getClass();
        if (k0VarE != k0.b && (function0 = this.d) != null) {
            function0.invoke();
        }
        g(k0.c);
    }

    public final float d() {
        f fVar = this.e;
        return cd.i0.n(((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue(), st.w0.i(this.f32f.h(), ((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue()));
    }

    public final k0 e() {
        return (k0) this.o.getValue();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final boolean f() throws NoWhenBranchMatchedException {
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            return false;
        }
        if (iOrdinal == 1) {
            return true;
        }
        if (iOrdinal == 2) {
            return e().a();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void g(k0 k0Var) {
        this.o.setValue(k0Var);
    }

    public final void h(float f2) {
        f fVar = this.e;
        this.f32f.i(cd.i0.G(st.w0.i(f2, ((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue()), this.i, ((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue()));
    }
}
