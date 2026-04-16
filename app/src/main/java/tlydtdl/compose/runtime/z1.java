package tlydtdl.compose.runtime;

import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function1;
import q1.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z1 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ z1(int i, d1 d1Var, e1 e1Var) {
        this.a = 1;
        this.b = i;
        this.c = d1Var;
        this.d = e1Var;
    }

    public final Object invoke(Object obj) {
        v vVar;
        v vVar2;
        int i;
        switch (this.a) {
            case 0:
                a2 a2Var = (a2) this.c;
                q1.f0 f0Var = (q1.f0) this.d;
                v vVar3 = (v) obj;
                int i2 = a2Var.e;
                int i3 = this.b;
                if (i2 == i3 && lmjxuqdtp.jvm.internal.o.c(f0Var, a2Var.f522f) && (vVar3 instanceof z)) {
                    long[] jArr = f0Var.a;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i4 = 0;
                        while (true) {
                            long j2 = jArr[i4];
                            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i6 = 8;
                                int i7 = 8 - ((~(i4 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((255 & j2) < 128) {
                                        int i9 = (i4 << 3) + i8;
                                        Object obj2 = f0Var.b[i9];
                                        boolean z = f0Var.c[i9] != i3;
                                        if (z) {
                                            i = i6;
                                            z zVar = (z) vVar3;
                                            n0 n0Var = zVar.g;
                                            j4.B(n0Var, obj2, a2Var);
                                            vVar2 = vVar3;
                                            if (obj2 instanceof h0) {
                                                h0 h0Var = (h0) obj2;
                                                if (!n0Var.c(h0Var)) {
                                                    j4.C(zVar.f551j, h0Var);
                                                }
                                                n0 n0Var2 = a2Var.g;
                                                if (n0Var2 != null) {
                                                    n0Var2.k(obj2);
                                                }
                                            }
                                        } else {
                                            vVar2 = vVar3;
                                            i = i6;
                                        }
                                        if (z) {
                                            f0Var.g(i9);
                                        }
                                    } else {
                                        vVar2 = vVar3;
                                        i = i6;
                                    }
                                    j2 >>= i;
                                    i8++;
                                    i6 = i;
                                    vVar3 = vVar2;
                                }
                                vVar = vVar3;
                                if (i7 == i6) {
                                }
                            } else {
                                vVar = vVar3;
                            }
                            if (i4 != length) {
                                i4++;
                                vVar3 = vVar;
                            }
                        }
                    }
                }
                return lx1.b0.a;
            case 1:
                d1 d1Var = (d1) this.c;
                e1 e1Var = (e1) this.d;
                q4.b0 b0Var = (q4.b0) obj;
                lmjxuqdtp.jvm.internal.o.h(b0Var, "coordinates");
                j1 j1Var = (j1) d1Var;
                j1Var.i(Float.intBitsToFloat((int) (b0Var.A(0L) >> 32)));
                e1Var.setValue(j1Var.h() < ((float) this.b) ? jh0.a0.a : jh0.z.a);
                break;
            case 2:
                md1.h hVar = (md1.h) this.c;
                q4.m1 m1Var = (q4.m1) this.d;
                q4.l1 l1Var = (q4.l1) obj;
                lmjxuqdtp.jvm.internal.o.h(l1Var, "$this$layout");
                boolean z2 = hVar.a;
                int i10 = this.b;
                if (z2) {
                    q4.l1.m(l1Var, m1Var, i10, 0);
                } else {
                    l1Var.g(m1Var, i10, 0, 0.0f);
                }
                return lx1.b0.a;
            default:
                v1.n1 n1Var = (v1.n1) this.c;
                q4.m1 m1Var2 = (q4.m1) this.d;
                q4.l1 l1Var2 = (q4.l1) obj;
                int iH = n1Var.a.a.h();
                if (iH < 0) {
                    iH = 0;
                }
                int i11 = this.b;
                if (iH > i11) {
                    iH = i11;
                }
                int i12 = -iH;
                boolean z3 = n1Var.b;
                int i13 = z3 ? 0 : i12;
                if (!z3) {
                    i12 = 0;
                }
                l1Var2.a = true;
                q4.l1.r(l1Var2, m1Var2, i13, i12);
                l1Var2.a = false;
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ z1(Object obj, int i, Object obj2, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
        this.d = obj2;
    }

    public /* synthetic */ z1(md1.h hVar, q4.m1 m1Var, int i) {
        this.a = 2;
        this.c = hVar;
        this.d = m1Var;
        this.b = i;
    }
}
