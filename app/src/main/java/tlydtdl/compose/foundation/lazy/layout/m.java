package tlydtdl.compose.foundation.lazy.layout;

import a2.k2;
import a2.o3;
import a2.q3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import mx1.o;
import r3.i;
import t3.p;
import tlydtdl.compose.foundation.layout.z;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.g3;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {
    public static final y[] a = new y[0];
    public static final a b = new a(1);

    public static final void d(Function0 function0, p pVar, z0 z0Var, o0 o0Var, tlydtdl.compose.runtime.m mVar, int i, int i2) {
        int i3;
        s sVar = (s) mVar;
        sVar.h0(1055276397);
        if ((i & 6) == 0) {
            i3 = (sVar.i(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= sVar.g(pVar) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= sVar.g(z0Var) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? sVar.g(o0Var) : sVar.i(o0Var) ? 2048 : 1024;
        }
        if (sVar.W(i3 & 1, (i3 & 1171) != 1170)) {
            if (i4 != 0) {
                z0Var = null;
            }
            f(q3.p.d(-933153643, new n0(z0Var, pVar, o0Var, tlydtdl.compose.runtime.a0.x(function0, sVar)), sVar), sVar, 6);
        } else {
            sVar.Z();
        }
        z0 z0Var2 = z0Var;
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new k0(i, i2, 0, function0, z0Var2, o0Var, pVar);
        }
    }

    public static final void e(Object obj, int i, w0 w0Var, q3.k kVar, tlydtdl.compose.runtime.m mVar, int i2) {
        int i3;
        s sVar = (s) mVar;
        sVar.h0(872548579);
        if ((i2 & 6) == 0) {
            i3 = (sVar.i(obj) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= sVar.e(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= sVar.i(w0Var) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= sVar.i(kVar) ? 2048 : 1024;
        }
        if (sVar.W(i3 & 1, (i3 & 1171) != 1170)) {
            boolean zG = sVar.g(obj) | sVar.g(w0Var);
            Object objR = sVar.R();
            x0 x0Var = tlydtdl.compose.runtime.l.a;
            if (zG || objR == x0Var) {
                objR = new u0(obj, w0Var);
                sVar.q0(objR);
            }
            u0 u0Var = (u0) objR;
            u0Var.c = i;
            tlydtdl.compose.runtime.n1 n1Var = u0Var.g;
            tlydtdl.compose.runtime.e0 e0Var = q4.k1.a;
            u0 u0Var2 = (u0) sVar.k(e0Var);
            s3.f fVarO = rs1.g.o();
            Function1 function1E = fVarO != null ? fVarO.e() : null;
            s3.f fVarP = rs1.g.p(fVarO);
            try {
                if (u0Var2 != ((u0) n1Var.getValue())) {
                    n1Var.setValue(u0Var2);
                    if (u0Var.d > 0) {
                        u0 u0Var3 = u0Var.e;
                        if (u0Var3 != null) {
                            u0Var3.b();
                        }
                        if (u0Var2 != null) {
                            u0Var2.a();
                        } else {
                            u0Var2 = null;
                        }
                        u0Var.e = u0Var2;
                    }
                }
                rs1.g.s(fVarO, fVarP, function1E);
                boolean zG2 = sVar.g(u0Var);
                Object objR2 = sVar.R();
                if (zG2 || objR2 == x0Var) {
                    objR2 = new o3(6, u0Var);
                    sVar.q0(objR2);
                }
                tlydtdl.compose.runtime.a0.d(u0Var, (Function1) objR2, sVar);
                tlydtdl.compose.runtime.a0.a(e0Var.a(u0Var), kVar, sVar, ((i3 >> 6) & 112) | 8);
            } catch (Throwable th) {
                rs1.g.s(fVarO, fVarP, function1E);
                throw th;
            }
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new v0(obj, i, w0Var, kVar, i2);
        }
    }

    public static final void f(q3.k kVar, tlydtdl.compose.runtime.m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(-709502251);
        if (sVar.W(i & 1, (i & 3) != 2)) {
            g3 g3Var = i.a;
            r3.g gVar = (r3.g) sVar.k(g3Var);
            r3.e eVarF = r3.l.f(sVar);
            Object[] objArr = {gVar};
            g4.d0 d0Var = new g4.d0(21, new a70.b(4, (byte) 0), new q3(6, gVar, eVarF));
            boolean zI = sVar.i(gVar) | sVar.i(eVarF);
            Object objR = sVar.R();
            if (zI || objR == tlydtdl.compose.runtime.l.a) {
                objR = new a10.h(3, gVar, eVarF);
                sVar.q0(objR);
            }
            k1 k1Var = (k1) r3.l.d(objArr, d0Var, (Function0) objR, sVar, 0);
            tlydtdl.compose.runtime.a0.a(g3Var.a(k1Var), q3.p.d(-412824043, new z(2, kVar, k1Var), sVar), sVar, 56);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new l1(kVar, i, 0);
        }
    }

    public static final void g(j0 j0Var, Object obj, int i, Object obj2, tlydtdl.compose.runtime.m mVar, int i2) {
        s sVar = (s) mVar;
        sVar.h0(1439843069);
        int i3 = (sVar.g(j0Var) ? 4 : 2) | i2 | (sVar.g(obj) ? 32 : 16) | (sVar.e(i) ? 256 : 128) | (sVar.g(obj2) ? 2048 : 1024);
        if (sVar.W(i3 & 1, (i3 & 1171) != 1170)) {
            ((r3.c) obj).c(obj2, q3.p.d(980966366, new i0(i, j0Var, obj2), sVar), sVar, 48);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new h0(j0Var, obj, i, obj2, i2);
        }
    }

    public static final int h(int i, k3.e eVar) {
        int i2 = eVar.c - 1;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = ((i2 - i3) / 2) + i3;
            Object[] objArr = eVar.a;
            int i6 = ((j) objArr[i4]).a;
            if (i6 != i) {
                if (i6 < i) {
                    i3 = i4 + 1;
                    if (i < ((j) objArr[i3]).a) {
                    }
                } else {
                    i2 = i4 - 1;
                }
            }
            return i4;
        }
        return i3;
    }

    public static final List i(s0 s0Var, int i, int i2, ArrayList arrayList, q1.y yVar, int i3, int i4, int i6, Function1 function1) {
        int i7;
        q1.y yVar2;
        long j2;
        long j3;
        int i8;
        Object obj;
        int i9;
        if (s0Var == null || arrayList.isEmpty() || (i7 = yVar.b) == 0) {
            return mx1.t.a;
        }
        int i10 = -1;
        if (i2 - i < 0 || i7 == 0) {
            yVar2 = q1.m.a;
        } else {
            ey1.k kVarD0 = st.w0.D0(0, i7);
            int i11 = ((ey1.i) kVarD0).a;
            int i12 = ((ey1.i) kVarD0).b;
            int iC = -1;
            if (i11 <= i12) {
                while (yVar.c(i11) <= i) {
                    iC = yVar.c(i11);
                    if (i11 == i12) {
                        break;
                    }
                    i11++;
                }
            }
            if (iC == -1) {
                yVar2 = q1.m.a;
            } else {
                q1.y yVar3 = q1.m.a;
                yVar2 = new q1.y(1);
                yVar2.a(iC);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            Object obj2 = arrayList.get(i13);
            int index = ((q0) obj2).getIndex();
            int[] iArr = yVar.a;
            int i14 = yVar.b;
            int i15 = 0;
            while (true) {
                if (i15 >= i14) {
                    break;
                }
                if (iArr[i15] == index) {
                    arrayList3.add(obj2);
                    break;
                }
                i15++;
            }
        }
        int[] iArr2 = yVar2.a;
        int i16 = yVar2.b;
        int i17 = 0;
        while (i17 < i16) {
            int i18 = iArr2[i17];
            Iterator it = arrayList.iterator();
            int i19 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i19 = i10;
                    break;
                }
                if (((q0) it.next()).getIndex() == i18) {
                    break;
                }
                i19++;
            }
            q0 q0Var = i19 == i10 ? (q0) function1.invoke(Integer.valueOf(i18)) : (q0) arrayList.remove(i19);
            int iG = q0Var.g();
            if (i19 == i10) {
                j2 = 4294967295L;
                i8 = IntCompanionObject.MIN_VALUE;
            } else {
                long j4 = q0Var.j(0);
                if (q0Var.f()) {
                    j2 = 4294967295L;
                    j3 = j4 & 4294967295L;
                } else {
                    j2 = 4294967295L;
                    j3 = j4 >> 32;
                }
                i8 = (int) j3;
            }
            int size2 = arrayList3.size();
            int i20 = 0;
            while (true) {
                if (i20 >= size2) {
                    obj = null;
                    break;
                }
                obj = arrayList3.get(i20);
                if (((q0) obj).getIndex() != i18) {
                    break;
                }
                i20++;
            }
            q0 q0Var2 = (q0) obj;
            if (q0Var2 != null) {
                long j5 = q0Var2.j(0);
                i9 = (int) (q0Var2.f() ? j5 & j2 : j5 >> 32);
            } else {
                i9 = IntCompanionObject.MIN_VALUE;
            }
            int iMax = i8 == Integer.MIN_VALUE ? -i3 : Math.max(-i3, i8);
            if (i9 != Integer.MIN_VALUE) {
                iMax = Math.min(iMax, i9 - iG);
            }
            q0Var.i();
            q0Var.a(iMax, 0, i4, i6);
            arrayList2.add(q0Var);
            i17++;
            i10 = -1;
        }
        return arrayList2;
    }

    public static final List j(j0 j0Var, w0 w0Var, a2.b bVar) {
        ey1.k kVar;
        k3.e eVar = bVar.a;
        if (!(eVar.c != 0) && w0Var.a.isEmpty()) {
            return mx1.t.a;
        }
        ArrayList arrayList = new ArrayList();
        if (bVar.a.c != 0) {
            int i = eVar.c;
            if (i == 0) {
                throw new NoSuchElementException("MutableVector is empty.");
            }
            Object[] objArr = eVar.a;
            int i2 = ((l) objArr[0]).a;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = ((l) objArr[i3]).a;
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i2 < 0) {
                d2.a.a("negative minIndex");
            }
            int i6 = eVar.c;
            if (i6 == 0) {
                throw new NoSuchElementException("MutableVector is empty.");
            }
            Object[] objArr2 = eVar.a;
            int i7 = ((l) objArr2[0]).b;
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = ((l) objArr2[i8]).b;
                if (i9 > i7) {
                    i7 = i9;
                }
            }
            kVar = new ey1.k(i2, Math.min(i7, j0Var.a() - 1), 1);
        } else {
            kVar = ey1.k.d;
        }
        int size = w0Var.a.size();
        for (int i10 = 0; i10 < size; i10++) {
            u0 u0Var = (u0) w0Var.get(i10);
            int iL = l(u0Var.c, j0Var, u0Var.a);
            int i11 = ((ey1.i) kVar).a;
            if ((iL > ((ey1.i) kVar).b || i11 > iL) && iL >= 0 && iL < j0Var.a()) {
                arrayList.add(Integer.valueOf(iL));
            }
        }
        int i12 = ((ey1.i) kVar).a;
        int i13 = ((ey1.i) kVar).b;
        if (i12 <= i13) {
            while (true) {
                arrayList.add(Integer.valueOf(i12));
                if (i12 == i13) {
                    break;
                }
                i12++;
            }
        }
        return arrayList;
    }

    public static e1 k() {
        return new tlydtdl.compose.runtime.n1(lx1.b0.a, x0.c);
    }

    public static final int l(int i, j0 j0Var, Object obj) {
        int iC;
        return (obj == null || j0Var.a() == 0 || (i < j0Var.a() && obj.equals(j0Var.d(i))) || (iC = j0Var.c(obj)) == -1) ? i : iC;
    }

    public static final void p(e1 e1Var) {
        e1Var.setValue(lx1.b0.a);
    }

    public static final p q(r rVar, a2.b bVar, boolean z, k2 k2Var) {
        return new LazyLayoutBeyondBoundsModifierElement(rVar, bVar, z, k2Var);
    }

    public static final p r(p pVar, fy1.i iVar, g1 g1Var, k2 k2Var, boolean z, boolean z2) {
        return pVar.then(new LazyLayoutSemanticsModifier(iVar, g1Var, k2Var, z, z2));
    }

    public static final List s(int i, int i2, ArrayList arrayList, List list) {
        if (arrayList.isEmpty()) {
            return mx1.t.a;
        }
        ArrayList arrayListO1 = o.o1(list);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            q0 q0Var = (q0) arrayList.get(i3);
            int index = q0Var.getIndex();
            if (i <= index && index <= i2) {
                arrayListO1.add(q0Var);
            }
        }
        mx1.r.f0(arrayListO1, b);
        return arrayListO1;
    }

    public Object m(int i) {
        j jVarJ = n().j(i);
        return jVarJ.c.getType().invoke(Integer.valueOf(i - jVarJ.a));
    }

    public abstract m1 n();

    public Object o(int i) {
        Object objInvoke;
        j jVarJ = n().j(i);
        int i2 = i - jVarJ.a;
        Function1 key = jVarJ.c.getKey();
        return (key == null || (objInvoke = key.invoke(Integer.valueOf(i2))) == null) ? new h(i) : objInvoke;
    }
}
