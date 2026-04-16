package of1;

import d5.b0;
import d5.q0;
import h5.s;
import m8.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final float a;
    public final float b;
    public final s c;
    public final String d;
    public final h5.o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Float f373f;
    public final o5.l g;

    public n(float f2, float f3, s sVar, String str, h5.o oVar, Float f4, o5.l lVar) {
        this.a = f2;
        this.b = f3;
        this.c = sVar;
        this.d = str;
        this.e = oVar;
        this.f373f = f4;
        this.g = lVar;
    }

    public final q0 a() {
        h5.l lVar = o.a;
        float f2 = this.a;
        long jK = d.K(4294967296L, f2);
        long jK2 = d.K(4294967296L, this.b);
        b0 b0Var = o.b;
        o5.i iVar = o.c;
        Float f3 = this.f373f;
        return new q0(0L, jK, this.c, this.e, lVar, this.d, f3 != null ? d.K(4294967296L, (f3.floatValue() / 100) * f2) : p5.p.c, this.g, 0, 0, jK2, b0Var, iVar, 15068945);
    }

    public /* synthetic */ n(float f2, float f3, s sVar) {
        this(f2, f3, sVar, "tnum", null, null, null);
    }
}
