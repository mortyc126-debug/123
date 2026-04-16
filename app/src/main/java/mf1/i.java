package mf1;

import a4.u;
import c4.d;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import lx1.b0;
import s4.l0;
import tlydtdl.compose.runtime.f3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ float a;
    public final /* synthetic */ u b;
    public final /* synthetic */ float c;
    public final /* synthetic */ u d;
    public final /* synthetic */ f3 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f3 f330f;

    public /* synthetic */ i(float f2, u uVar, float f3, u uVar2, f3 f3Var, f3 f3Var2) {
        this.a = f2;
        this.b = uVar;
        this.c = f3;
        this.d = uVar2;
        this.e = f3Var;
        this.f330f = f3Var2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final Object invoke(Object obj) throws KotlinNothingValueException {
        l0 l0Var = (l0) obj;
        o.h(l0Var, "$this$drawWithContent");
        c4.b bVar = l0Var.a;
        l0Var.b();
        if (((Boolean) this.e.getValue()).booleanValue()) {
            d.X(l0Var, this.b, 0L, z3.e.a(bVar.h(), l0Var.w0(this.a), 0.0f, 2), 0.0f, (c4.e) null, 6, 56);
        }
        if (((Boolean) this.f330f.getValue()).booleanValue()) {
            long jH = bVar.h();
            float f2 = this.c;
            long jA = z3.e.a(jH, l0Var.w0(f2), 0.0f, 2);
            d.X(l0Var, this.d, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (bVar.h() >> 32)) - l0Var.w0(f2))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L), jA, 0.0f, (c4.e) null, 6, 56);
        }
        return b0.a;
    }
}
