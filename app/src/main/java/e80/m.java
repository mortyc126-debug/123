package e80;

import com.gnacba.amuvvoafs.gms.internal.ads.da;
import f3.r2;
import f3.w2;
import f3.x2;
import f3.y2;
import hs1.d;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import mx1.o;
import mx1.u;
import ny1.p2;
import p5.b;
import p5.n;
import q4.d2;
import q4.m1;
import q4.t0;
import tlydtdl.compose.foundation.layout.f2;
import tlydtdl.compose.foundation.layout.v2;
import tlydtdl.compose.runtime.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ lx1.e f102f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    public /* synthetic */ m(v2 v2Var, Function2 function2, Function2 function22, Function2 function23, Function2 function24, w2 w2Var, Function2 function25) {
        this.a = 1;
        this.b = v2Var;
        this.c = function2;
        this.d = function22;
        this.e = function23;
        this.f102f = function24;
        this.g = w2Var;
        this.h = function25;
    }

    public final Object invoke(Object obj, Object obj2) {
        da daVar;
        Integer numValueOf;
        int iIntValue;
        int iO;
        int iA;
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                d.i((kx0.e) this.b, (kd1.g) this.c, (p2) this.d, (p2) this.e, this.f102f, (gl.h) this.g, (gl.h) this.h, (tlydtdl.compose.runtime.m) obj, a0.B(12582921));
                return b0.a;
            case 1:
                v2 v2Var = (v2) this.b;
                Function2 function2 = (Function2) this.c;
                Function2 function22 = (Function2) this.d;
                Function2 function23 = (Function2) this.e;
                Function2 function24 = this.f102f;
                w2 w2Var = (w2) this.g;
                Function2 function25 = (Function2) this.h;
                d2 d2Var = (d2) obj;
                p5.a aVar = (p5.a) obj2;
                float f2 = x2.a;
                int iH = p5.a.h(aVar.a);
                int iG = p5.a.g(aVar.a);
                long jA = p5.a.a(aVar.a, 0, 0, 0, 0, 10);
                int iB = v2Var.b(d2Var, d2Var.getLayoutDirection());
                int iC = v2Var.c(d2Var, d2Var.getLayoutDirection());
                int iA2 = v2Var.a(d2Var);
                m1 m1VarT = ((t0) o.w0(d2Var.k(y2.a, function2))).T(jA);
                int i = (-iB) - iC;
                int i2 = -iA2;
                m1 m1VarT2 = ((t0) o.w0(d2Var.k(y2.c, function22))).T(b.i(i, jA, i2));
                m1 m1VarT3 = ((t0) o.w0(d2Var.k(y2.d, function23))).T(b.i(i, jA, i2));
                int i3 = m1VarT3.a;
                if (i3 == 0 && m1VarT3.b == 0) {
                    daVar = null;
                } else {
                    daVar = new da(d2Var.getLayoutDirection() == n.a ? ((iH - d2Var.O(f2)) - i3) - iC : d2Var.O(f2) + iB, m1VarT3.b);
                }
                m1 m1VarT4 = ((t0) o.w0(d2Var.k(y2.e, function24))).T(jA);
                int i4 = 0;
                boolean z = m1VarT4.a == 0 && m1VarT4.b == 0;
                if (daVar != null) {
                    int i6 = daVar.b;
                    if (z) {
                        iO = d2Var.O(f2) + i6;
                        iA = v2Var.a(d2Var);
                    } else {
                        iO = m1VarT4.b + i6;
                        iA = d2Var.O(f2);
                    }
                    numValueOf = Integer.valueOf(iA + iO);
                } else {
                    numValueOf = null;
                }
                int i7 = m1VarT2.b;
                if (i7 != 0) {
                    if (numValueOf != null) {
                        iIntValue = numValueOf.intValue();
                    } else {
                        Integer numValueOf2 = !z ? Integer.valueOf(m1VarT4.b) : null;
                        iIntValue = numValueOf2 != null ? numValueOf2.intValue() : v2Var.a(d2Var);
                    }
                    i4 = iIntValue + i7;
                }
                int i8 = i4;
                tlydtdl.compose.foundation.layout.m1 m1Var = new tlydtdl.compose.foundation.layout.m1(v2Var, d2Var);
                w2Var.a.setValue(new f2(tlydtdl.compose.foundation.layout.m.o(m1Var, d2Var.getLayoutDirection()), (m1VarT.a == 0 && m1VarT.b == 0) ? m1Var.d() : d2Var.p0(m1VarT.b), tlydtdl.compose.foundation.layout.m.n(m1Var, d2Var.getLayoutDirection()), z ? m1Var.a() : d2Var.p0(m1VarT4.b)));
                return d2Var.g0(iH, iG, u.a, new r2(((t0) o.w0(d2Var.k(y2.b, function25))).T(jA), m1VarT, m1VarT2, iH, v2Var, d2Var, iG, i8, m1VarT4, daVar, m1VarT3, numValueOf));
            default:
                ((Integer) obj2).getClass();
                fs0.a.e((Function0) this.b, (Function0) this.c, (Function0) this.d, (Function0) this.e, this.f102f, (Function0) this.g, (x10.l) this.h, (tlydtdl.compose.runtime.m) obj, a0.B(1));
                return b0.a;
        }
    }

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, Object obj4, Function0 function0, Function0 function02, Object obj5, int i, int i2) {
        this.a = i2;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
        this.f102f = function0;
        this.g = function02;
        this.h = obj5;
    }
}
