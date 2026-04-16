package tlydtdl.compose.foundation.layout;

import a2.o3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 implements q4.b1, h2 {
    public final boolean a;
    public final h b;
    public final k c;
    public final float d;
    public final m e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f487f;
    public final int g;
    public final d1 h;

    public f1(boolean z, h hVar, k kVar, float f2, m mVar, float f3, int i, d1 d1Var) {
        this.a = z;
        this.b = hVar;
        this.c = kVar;
        this.d = f2;
        this.e = mVar;
        this.f487f = f3;
        this.g = i;
        this.h = d1Var;
    }

    public final int a(q4.w wVar, List list, int i) {
        List list2 = (List) mx1.o.z0(1, list);
        q4.v vVar = list2 != null ? (q4.v) mx1.o.y0(list2) : null;
        List list3 = (List) mx1.o.z0(2, list);
        this.h.b(vVar, list3 != null ? (q4.v) mx1.o.y0(list3) : null, this.a, p5.b.b(i, 0, 13));
        boolean z = this.a;
        float f2 = this.f487f;
        float f3 = this.d;
        List list4 = mx1.t.a;
        if (z) {
            List list5 = (List) mx1.o.y0(list);
            return k(list5 == null ? list4 : list5, i, wVar.O(f3), wVar.O(f2), this.g, this.h);
        }
        List list6 = (List) mx1.o.y0(list);
        if (list6 != null) {
            list4 = list6;
        }
        return m(list4, i, wVar.O(f3), wVar.O(f2), this.g, this.h);
    }

    public final int b(q4.w wVar, List list, int i) {
        List list2 = (List) mx1.o.z0(1, list);
        q4.v vVar = list2 != null ? (q4.v) mx1.o.y0(list2) : null;
        List list3 = (List) mx1.o.z0(2, list);
        this.h.b(vVar, list3 != null ? (q4.v) mx1.o.y0(list3) : null, this.a, p5.b.b(i, 0, 13));
        boolean z = this.a;
        float f2 = this.d;
        List list4 = mx1.t.a;
        if (z) {
            List list5 = (List) mx1.o.y0(list);
            return k(list5 == null ? list4 : list5, i, wVar.O(f2), wVar.O(this.f487f), this.g, this.h);
        }
        List list6 = (List) mx1.o.y0(list);
        if (list6 != null) {
            list4 = list6;
        }
        return l(list4, i, wVar.O(f2));
    }

    public final int c(q4.w wVar, List list, int i) {
        List list2 = (List) mx1.o.z0(1, list);
        q4.v vVar = list2 != null ? (q4.v) mx1.o.y0(list2) : null;
        List list3 = (List) mx1.o.z0(2, list);
        this.h.b(vVar, list3 != null ? (q4.v) mx1.o.y0(list3) : null, this.a, p5.b.b(0, i, 7));
        boolean z = this.a;
        float f2 = this.d;
        List list4 = mx1.t.a;
        if (!z) {
            List list5 = (List) mx1.o.y0(list);
            return k(list5 == null ? list4 : list5, i, wVar.O(f2), wVar.O(this.f487f), this.g, this.h);
        }
        List list6 = (List) mx1.o.y0(list);
        if (list6 != null) {
            list4 = list6;
        }
        return l(list4, i, wVar.O(f2));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    public final q4.v0 d(q4.w0 w0Var, List list, long j2) throws NoWhenBranchMatchedException {
        q4.v vVar;
        long j3;
        k3.e eVar;
        q1.l lVar;
        q4.m1 m1VarT;
        s0 s0Var;
        r0 r0VarA;
        int i;
        int i2;
        int iG;
        char c;
        ArrayList arrayList;
        int i3;
        int height;
        int width;
        q4.v vVar2;
        long j4;
        q4.m1 m1VarT2;
        q1.l lVar2;
        Integer num;
        q1.l lVar3;
        long jA;
        long jA2;
        final f1 f1Var = this;
        int i4 = f1Var.g;
        mx1.u uVar = mx1.u.a;
        final int i6 = 0;
        if (i4 != 0 && !((ArrayList) list).isEmpty()) {
            int iG2 = p5.a.g(j2);
            final d1 d1Var = f1Var.h;
            if (iG2 != 0) {
                List list2 = (List) mx1.o.w0(list);
                if (list2.isEmpty()) {
                    return w0Var.g0(0, 0, uVar, new uc0.a(19));
                }
                final int i7 = 1;
                List list3 = (List) mx1.o.z0(1, list);
                q4.t0 t0Var = list3 != null ? (q4.t0) mx1.o.y0(list3) : null;
                List list4 = (List) mx1.o.z0(2, list);
                q4.t0 t0Var2 = list4 != null ? (q4.t0) mx1.o.y0(list4) : null;
                list2.size();
                d1Var.getClass();
                boolean z = f1Var.a;
                t1 t1Var = z ? t1.a : t1.b;
                long jK = m.K(m.r(10, m.p(j2, t1Var)), t1Var);
                if (t0Var != null) {
                    m.x(t0Var, f1Var, jK, new Function1() { // from class: tlydtdl.compose.foundation.layout.b1
                        public final Object invoke(Object obj) {
                            int iJ;
                            int iG3;
                            int iJ2;
                            int iG4;
                            q4.m1 m1Var = (q4.m1) obj;
                            switch (i6) {
                                case 0:
                                    if (m1Var != null) {
                                        f1 f1Var2 = f1Var;
                                        iJ = f1Var2.j(m1Var);
                                        iG3 = f1Var2.g(m1Var);
                                    } else {
                                        iJ = 0;
                                        iG3 = 0;
                                    }
                                    q1.l lVar4 = new q1.l(q1.l.a(iJ, iG3));
                                    d1 d1Var2 = d1Var;
                                    d1Var2.e = lVar4;
                                    d1Var2.b = m1Var;
                                    break;
                                default:
                                    if (m1Var != null) {
                                        f1 f1Var3 = f1Var;
                                        iJ2 = f1Var3.j(m1Var);
                                        iG4 = f1Var3.g(m1Var);
                                    } else {
                                        iJ2 = 0;
                                        iG4 = 0;
                                    }
                                    q1.l lVar5 = new q1.l(q1.l.a(iJ2, iG4));
                                    d1 d1Var3 = d1Var;
                                    d1Var3.f485f = lVar5;
                                    d1Var3.d = m1Var;
                                    break;
                            }
                            return lx1.b0.a;
                        }
                    });
                    d1Var.a = t0Var;
                }
                if (t0Var2 != null) {
                    m.x(t0Var2, f1Var, jK, new Function1() { // from class: tlydtdl.compose.foundation.layout.b1
                        public final Object invoke(Object obj) {
                            int iJ;
                            int iG3;
                            int iJ2;
                            int iG4;
                            q4.m1 m1Var = (q4.m1) obj;
                            switch (i7) {
                                case 0:
                                    if (m1Var != null) {
                                        f1 f1Var2 = f1Var;
                                        iJ = f1Var2.j(m1Var);
                                        iG3 = f1Var2.g(m1Var);
                                    } else {
                                        iJ = 0;
                                        iG3 = 0;
                                    }
                                    q1.l lVar4 = new q1.l(q1.l.a(iJ, iG3));
                                    d1 d1Var2 = d1Var;
                                    d1Var2.e = lVar4;
                                    d1Var2.b = m1Var;
                                    break;
                                default:
                                    if (m1Var != null) {
                                        f1 f1Var3 = f1Var;
                                        iJ2 = f1Var3.j(m1Var);
                                        iG4 = f1Var3.g(m1Var);
                                    } else {
                                        iJ2 = 0;
                                        iG4 = 0;
                                    }
                                    q1.l lVar5 = new q1.l(q1.l.a(iJ2, iG4));
                                    d1 d1Var3 = d1Var;
                                    d1Var3.f485f = lVar5;
                                    d1Var3.d = m1Var;
                                    break;
                            }
                            return lx1.b0.a;
                        }
                    });
                    d1Var.c = t0Var2;
                }
                Iterator it = list2.iterator();
                long jP = m.p(j2, z ? t1.a : t1.b);
                k3.e eVar2 = new k3.e(0, new q4.v0[16]);
                int iH = p5.a.h(jP);
                int iJ = p5.a.j(jP);
                int iG3 = p5.a.g(jP);
                q1.z zVar = q1.o.a;
                q1.z zVar2 = new q1.z();
                ArrayList arrayList2 = new ArrayList();
                int iCeil = (int) Math.ceil(w0Var.w0(f1Var.d));
                int iCeil2 = (int) Math.ceil(w0Var.w0(f1Var.f487f));
                long jA3 = p5.b.a(0, iH, 0, iG3);
                long jK2 = m.K(m.r(14, jA3), z ? t1.a : t1.b);
                if (it.hasNext()) {
                    try {
                        vVar = (q4.t0) it.next();
                    } catch (IndexOutOfBoundsException unused) {
                        vVar = null;
                    }
                } else {
                    vVar = null;
                }
                if (vVar != null) {
                    if (m.t(m.s(vVar)) == 0.0f) {
                        m.s(vVar);
                        m1VarT = vVar.T(jK2);
                        j3 = jA3;
                        jA2 = q1.l.a(f1Var.j(m1VarT), f1Var.g(m1VarT));
                    } else {
                        j3 = jA3;
                        int iM = z ? vVar.M(IntCompanionObject.MAX_VALUE) : vVar.z(IntCompanionObject.MAX_VALUE);
                        jA2 = q1.l.a(iM, z ? vVar.z(iM) : vVar.M(iM));
                        m1VarT = null;
                    }
                    eVar = eVar2;
                    lVar = new q1.l(jA2);
                } else {
                    j3 = jA3;
                    eVar = eVar2;
                    lVar = null;
                    m1VarT = null;
                }
                Integer numValueOf = lVar != null ? Integer.valueOf((int) (lVar.a >> 32)) : null;
                Integer numValueOf2 = lVar != null ? Integer.valueOf((int) (lVar.a & 4294967295L)) : null;
                q1.y yVar = new q1.y();
                q4.m1 m1Var = m1VarT;
                q1.y yVar2 = new q1.y();
                Integer num2 = numValueOf2;
                q1.a0 a0Var = new q1.a0();
                q1.l lVar4 = lVar;
                int i8 = f1Var.g;
                d1 d1Var2 = f1Var.h;
                t0 t0Var3 = new t0(i8, d1Var2, jP, iCeil, iCeil2);
                s0 s0VarB = t0Var3.b(it.hasNext(), 0, q1.l.a(iH, iG3), lVar4, 0, 0, 0, false, false);
                if (s0VarB.b) {
                    s0Var = s0VarB;
                    r0VarA = t0Var3.a(s0Var, lVar4 != null, -1, 0, iH, 0);
                } else {
                    s0Var = s0VarB;
                    r0VarA = null;
                }
                int i9 = iH;
                int i10 = iCeil;
                int i11 = iG3;
                q4.v vVar3 = vVar;
                int i12 = iJ;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                r0 r0Var = r0VarA;
                s0 s0Var2 = s0Var;
                q4.m1 m1Var2 = m1Var;
                int i18 = 0;
                while (!s0Var2.b && vVar3 != null) {
                    lmjxuqdtp.jvm.internal.o.e(numValueOf);
                    int iIntValue = numValueOf.intValue();
                    lmjxuqdtp.jvm.internal.o.e(num2);
                    q1.a0 a0Var2 = a0Var;
                    int i19 = i15 + iIntValue;
                    int iMax = Math.max(i13, num2.intValue());
                    int i20 = i9 - iIntValue;
                    int i21 = i14 + 1;
                    d1Var2.getClass();
                    arrayList2.add(vVar3);
                    zVar2.h(i14, m1Var2);
                    vVar3.l();
                    int i22 = i21 - i18;
                    if (it.hasNext()) {
                        try {
                            vVar2 = (q4.t0) it.next();
                        } catch (IndexOutOfBoundsException unused2) {
                            vVar2 = null;
                        }
                    } else {
                        vVar2 = null;
                    }
                    if (vVar2 != null) {
                        if (m.t(m.s(vVar2)) == 0.0f) {
                            m.s(vVar2);
                            m1VarT2 = vVar2.T(jK2);
                            j4 = jK2;
                            jA = q1.l.a(f1Var.j(m1VarT2), f1Var.g(m1VarT2));
                        } else {
                            j4 = jK2;
                            int iM2 = z ? vVar2.M(IntCompanionObject.MAX_VALUE) : vVar2.z(IntCompanionObject.MAX_VALUE);
                            jA = q1.l.a(iM2, z ? vVar2.z(iM2) : vVar2.M(iM2));
                            m1VarT2 = null;
                        }
                        lVar2 = new q1.l(jA);
                    } else {
                        j4 = jK2;
                        m1VarT2 = null;
                        lVar2 = null;
                    }
                    Integer numValueOf3 = lVar2 != null ? Integer.valueOf(((int) (lVar2.a >> 32)) + i10) : null;
                    q4.v vVar4 = vVar2;
                    q4.m1 m1Var3 = m1VarT2;
                    Integer numValueOf4 = lVar2 != null ? Integer.valueOf((int) (lVar2.a & 4294967295L)) : null;
                    boolean zHasNext = it.hasNext();
                    long jA4 = q1.l.a(i20, i11);
                    if (lVar2 == null) {
                        num = numValueOf4;
                        lVar3 = null;
                    } else {
                        lmjxuqdtp.jvm.internal.o.e(numValueOf3);
                        int iIntValue2 = numValueOf3.intValue();
                        lmjxuqdtp.jvm.internal.o.e(numValueOf4);
                        num = numValueOf4;
                        lVar3 = new q1.l(q1.l.a(iIntValue2, numValueOf4.intValue()));
                    }
                    s0 s0VarB2 = t0Var3.b(zHasNext, i22, jA4, lVar3, i16, i17, iMax, false, false);
                    int i23 = iMax;
                    if (s0VarB2.a) {
                        int iMin = Math.min(Math.max(i12, i19), iH);
                        int i24 = i17 + i23;
                        t0 t0Var4 = t0Var3;
                        int i25 = i16;
                        r0 r0VarA2 = t0Var4.a(s0VarB2, lVar2 != null, i25, i24, i20, i22);
                        t0Var3 = t0Var4;
                        s0Var2 = s0VarB2;
                        yVar2.a(i23);
                        i11 = (i11 - i24) - iCeil2;
                        yVar.a(i21);
                        i16 = i25 + 1;
                        i17 = i24 + iCeil2;
                        r0Var = r0VarA2;
                        i12 = iMin;
                        i9 = iH;
                        numValueOf3 = numValueOf3 != null ? Integer.valueOf(numValueOf3.intValue() - i10) : null;
                        i18 = i21;
                        i23 = 0;
                        i15 = 0;
                    } else {
                        s0Var2 = s0VarB2;
                        i15 = i19;
                        i9 = i20;
                    }
                    f1Var = this;
                    i14 = i21;
                    a0Var = a0Var2;
                    m1Var2 = m1Var3;
                    num2 = num;
                    i13 = i23;
                    numValueOf = numValueOf3;
                    vVar3 = vVar4;
                    jK2 = j4;
                }
                q1.a0 a0Var3 = a0Var;
                if (r0Var != null) {
                    arrayList2.add(r0Var.a());
                    zVar2.h(arrayList2.size() - 1, r0Var.d());
                    int i26 = yVar.b - 1;
                    if (r0Var.c()) {
                        int i27 = yVar.b - 1;
                        yVar2.f(i26, Math.max(yVar2.c(i26), (int) (r0Var.b() & 4294967295L)));
                        yVar.f(i27, yVar.d() + 1);
                    } else {
                        yVar2.a((int) (r0Var.b() & 4294967295L));
                        yVar.a(yVar.d() + 1);
                    }
                }
                int size = arrayList2.size();
                ArrayList arrayList3 = arrayList2;
                q4.m1[] m1VarArr = new q4.m1[size];
                for (int i28 = 0; i28 < size; i28++) {
                    m1VarArr[i28] = zVar2.b(i28);
                }
                int i29 = yVar.b;
                int[] iArr = new int[i29];
                int[] iArr2 = new int[i29];
                int[] iArr3 = yVar.a;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                while (i31 < i29) {
                    int i34 = iArr3[i31];
                    int iC = yVar2.c(i31);
                    q1.a0 a0Var4 = a0Var3;
                    if (a0Var4.b(i31)) {
                        arrayList = arrayList3;
                        i3 = i12;
                        c = CharCompanionObject.MAX_VALUE;
                    } else {
                        int iG4 = p5.a.g(j3);
                        c = CharCompanionObject.MAX_VALUE;
                        if (iG4 == Integer.MAX_VALUE) {
                            arrayList = arrayList3;
                            iC = Integer.MAX_VALUE;
                        } else {
                            iC = p5.a.g(j3) - i33;
                            arrayList = arrayList3;
                        }
                        i3 = i12;
                    }
                    int i35 = i31;
                    a0Var3 = a0Var4;
                    int i36 = i10;
                    int[] iArr4 = iArr3;
                    q1.y yVar3 = yVar2;
                    k3.e eVar3 = eVar;
                    q4.v0 v0VarW = m.w(this, i3, p5.a.i(j3), p5.a.h(j3), iC, i36, w0Var, arrayList, m1VarArr, i32, i34, iArr, i35);
                    ArrayList arrayList4 = arrayList;
                    int i37 = i3;
                    if (z) {
                        height = v0VarW.getWidth();
                        width = v0VarW.getHeight();
                    } else {
                        height = v0VarW.getHeight();
                        width = v0VarW.getWidth();
                    }
                    iArr2[i35] = width;
                    i33 += width;
                    int iMax2 = Math.max(i37, height);
                    eVar3.d(v0VarW);
                    i31 = i35 + 1;
                    arrayList3 = arrayList4;
                    i12 = iMax2;
                    i10 = i36;
                    i32 = i34;
                    eVar = eVar3;
                    iArr3 = iArr4;
                    yVar2 = yVar3;
                }
                k3.e eVar4 = eVar;
                int i38 = i12;
                if (eVar4.c == 0) {
                    i = 0;
                    i2 = 0;
                } else {
                    i = i38;
                    i2 = i33;
                }
                if (z) {
                    k kVar = this.c;
                    int iO = ((eVar4.c - 1) * w0Var.O(kVar.c())) + i2;
                    int i39 = p5.a.i(jP);
                    iG = p5.a.g(jP);
                    if (iO < i39) {
                        iO = i39;
                    }
                    if (iO <= iG) {
                        iG = iO;
                    }
                    kVar.a(w0Var, iG, iArr2, iArr);
                } else {
                    h hVar = this.b;
                    int iO2 = ((eVar4.c - 1) * w0Var.O(hVar.c())) + i2;
                    int i40 = p5.a.i(jP);
                    int iG5 = p5.a.g(jP);
                    if (iO2 < i40) {
                        iO2 = i40;
                    }
                    int i41 = iO2 > iG5 ? iG5 : iO2;
                    hVar.k(w0Var, i41, iArr2, w0Var.getLayoutDirection(), iArr);
                    iG = i41;
                }
                int iJ2 = p5.a.j(jP);
                int iH2 = p5.a.h(jP);
                if (i < iJ2) {
                    i = iJ2;
                }
                if (i <= iH2) {
                    iH2 = i;
                }
                if (z) {
                    int i42 = iG;
                    iG = iH2;
                    iH2 = i42;
                }
                return w0Var.g0(iG, iH2, uVar, new o3(3, eVar4));
            }
            d1Var.getClass();
            z0 z0Var = z0.a;
            z0 z0Var2 = z0.a;
        }
        return w0Var.g0(0, 0, uVar, new uc0.a(19));
    }

    public final int e(q4.w wVar, List list, int i) {
        List list2 = (List) mx1.o.z0(1, list);
        q4.v vVar = list2 != null ? (q4.v) mx1.o.y0(list2) : null;
        List list3 = (List) mx1.o.z0(2, list);
        this.h.b(vVar, list3 != null ? (q4.v) mx1.o.y0(list3) : null, this.a, p5.b.b(0, i, 7));
        boolean z = this.a;
        float f2 = this.f487f;
        float f3 = this.d;
        List list4 = mx1.t.a;
        if (z) {
            List list5 = (List) mx1.o.y0(list);
            return m(list5 == null ? list4 : list5, i, wVar.O(f3), wVar.O(f2), this.g, this.h);
        }
        List list6 = (List) mx1.o.y0(list);
        if (list6 != null) {
            list4 = list6;
        }
        return k(list4, i, wVar.O(f3), wVar.O(f2), this.g, this.h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return this.a == f1Var.a && this.b.equals(f1Var.b) && this.c.equals(f1Var.c) && p5.f.a(this.d, f1Var.d) && this.e.equals(f1Var.e) && p5.f.a(this.f487f, f1Var.f487f) && this.g == f1Var.g && lmjxuqdtp.jvm.internal.o.c(this.h, f1Var.h);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public void f(int i, int[] iArr, int[] iArr2, q4.w0 w0Var) {
        if (this.a) {
            this.b.k(w0Var, i, iArr, w0Var.getLayoutDirection(), iArr2);
        } else {
            this.c.a(w0Var, i, iArr, iArr2);
        }
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public int g(q4.m1 m1Var) {
        return this.a ? m1Var.b0() : m1Var.e0();
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public long h(int i, int i2, int i3, boolean z) {
        if (this.a) {
            l2 l2Var = j2.a;
            return !z ? p5.b.a(i, i2, 0, i3) : di0.z.r(i, i2, 0, i3);
        }
        e0 e0Var = c0.a;
        return !z ? p5.b.a(0, i3, i, i2) : di0.z.q(0, i3, i, i2);
    }

    public final int hashCode() {
        return this.h.hashCode() + s1.a.c(IntCompanionObject.MAX_VALUE, s1.a.c(this.g, s1.a.b(this.f487f, (this.e.hashCode() + s1.a.b(this.d, (this.c.hashCode() + ((this.b.hashCode() + (Boolean.hashCode(this.a) * 31)) * 31)) * 31, 31)) * 31, 31), 31), 31);
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public q4.v0 i(final q4.m1[] m1VarArr, q4.w0 w0Var, final int[] iArr, int i, final int i2, final int[] iArr2, final int i3, final int i4, final int i6) {
        int i7;
        int i8;
        boolean z = this.a;
        if (z) {
            i8 = i;
            i7 = i2;
        } else {
            i7 = i;
            i8 = i2;
        }
        final p5.n layoutDirection = z ? p5.n.a : w0Var.getLayoutDirection();
        return w0Var.g0(i8, i7, mx1.u.a, new Function1() { // from class: tlydtdl.compose.foundation.layout.e1
            public final Object invoke(Object obj) {
                m mVar;
                q4.l1 l1Var = (q4.l1) obj;
                int[] iArr3 = iArr2;
                int i9 = iArr3 != null ? iArr3[i3] : 0;
                int i10 = i4;
                for (int i11 = i10; i11 < i6; i11++) {
                    q4.m1 m1Var = m1VarArr[i11];
                    lmjxuqdtp.jvm.internal.o.e(m1Var);
                    Object objL = m1Var.l();
                    i2 i2Var = objL instanceof i2 ? (i2) objL : null;
                    f1 f1Var = this;
                    if (i2Var == null || (mVar = i2Var.c) == null) {
                        mVar = f1Var.e;
                    }
                    int iK = mVar.k(i2 - f1Var.g(m1Var), layoutDirection) + i9;
                    boolean z2 = f1Var.a;
                    int[] iArr4 = iArr;
                    if (z2) {
                        q4.l1.i(l1Var, m1Var, iArr4[i11 - i10], iK);
                    } else {
                        q4.l1.i(l1Var, m1Var, iK, iArr4[i11 - i10]);
                    }
                }
                return lx1.b0.a;
            }
        });
    }

    @Override // tlydtdl.compose.foundation.layout.h2
    public int j(q4.m1 m1Var) {
        return this.a ? m1Var.e0() : m1Var.b0();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    public final int k(List list, int i, int i2, int i3, int i4, d1 d1Var) throws NoWhenBranchMatchedException {
        long jA;
        int iM;
        List list2 = list;
        int i6 = 0;
        if (list2.isEmpty()) {
            jA = q1.l.a(0, 0);
        } else {
            int i7 = IntCompanionObject.MAX_VALUE;
            t0 t0Var = new t0(i4, d1Var, p5.b.a(0, i, 0, IntCompanionObject.MAX_VALUE), i2, i3);
            q4.v vVar = (q4.v) mx1.o.z0(0, list2);
            boolean z = this.a;
            int iZ = vVar != null ? z ? vVar.z(i) : vVar.M(i) : 0;
            int iM2 = vVar != null ? z ? vVar.M(iZ) : vVar.z(iZ) : 0;
            int i8 = 0;
            if (t0Var.b(list2.size() > 1, 0, q1.l.a(i, IntCompanionObject.MAX_VALUE), vVar == null ? null : new q1.l(q1.l.a(iM2, iZ)), 0, 0, 0, false, false).b) {
                q1.l lVarA = d1Var.a(0, 0, vVar != null);
                jA = q1.l.a(lVarA != null ? (int) (lVarA.a & 4294967295L) : 0, 0);
            } else {
                int size = list2.size();
                int i9 = i;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    int i15 = i9 - iM2;
                    int i16 = i10 + 1;
                    int iMax = Math.max(i14, iZ);
                    q4.v vVar2 = (q4.v) mx1.o.z0(i16, list2);
                    int iZ2 = vVar2 != null ? z ? vVar2.z(i) : vVar2.M(i) : i6;
                    if (vVar2 != null) {
                        iM = (z ? vVar2.M(iZ2) : vVar2.z(iZ2)) + i2;
                    } else {
                        iM = i6;
                    }
                    int i17 = i16 - i12;
                    boolean z2 = i10 + 2 < list2.size() ? 1 : i6;
                    int i18 = i13;
                    int i19 = iZ2;
                    int i20 = iM;
                    s0 s0VarB = t0Var.b(z2, i17, q1.l.a(i15, i7), vVar2 == null ? null : new q1.l(q1.l.a(iM, iZ2)), i18, i8, iMax, false, false);
                    if (s0VarB.a) {
                        int i21 = iMax + i3 + i8;
                        r0 r0VarA = t0Var.a(s0VarB, vVar2 != null, i18, i21, i15, i17);
                        int i22 = i20 - i2;
                        i13 = i18 + 1;
                        if (s0VarB.b) {
                            if (r0VarA != null) {
                                long jB = r0VarA.b();
                                if (!r0VarA.c()) {
                                    i21 += ((int) (jB & 4294967295L)) + i3;
                                }
                            }
                            i8 = i21;
                            i11 = i16;
                        } else {
                            i12 = i16;
                            i8 = i21;
                            iM2 = i22;
                            i14 = 0;
                            i9 = i;
                        }
                    } else {
                        iM2 = i20;
                        i9 = i15;
                        i13 = i18;
                        i14 = iMax;
                    }
                    list2 = list;
                    i10 = i16;
                    i11 = i10;
                    iZ = i19;
                    i7 = IntCompanionObject.MAX_VALUE;
                    i6 = 0;
                }
                jA = q1.l.a(i8 - i3, i11);
            }
        }
        return (int) (jA >> 32);
    }

    public final int l(List list, int i, int i2) {
        int size = list.size();
        int i3 = 0;
        int iMax = 0;
        int i4 = 0;
        int i6 = 0;
        while (i3 < size) {
            q4.v vVar = (q4.v) list.get(i3);
            int iR = (this.a ? vVar.R(i) : vVar.c(i)) + i2;
            int i7 = i3 + 1;
            if (i7 - i4 == this.g || i7 == list.size()) {
                iMax = Math.max(iMax, (i6 + iR) - i2);
                i6 = 0;
                i4 = i3;
            } else {
                i6 += iR;
            }
            i3 = i7;
        }
        return iMax;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    public final int m(List list, int i, int i2, int i3, int i4, d1 d1Var) throws NoWhenBranchMatchedException {
        long j2;
        int i6;
        int i7;
        long jA;
        int i8;
        List list2 = list;
        int i9 = i;
        int i10 = 0;
        if (list2.isEmpty()) {
            return 0;
        }
        int size = list2.size();
        int[] iArr = new int[size];
        int size2 = list2.size();
        int[] iArr2 = new int[size2];
        int size3 = list2.size();
        for (int i11 = 0; i11 < size3; i11++) {
            q4.v vVar = (q4.v) list2.get(i11);
            boolean z = this.a;
            int iM = z ? vVar.M(i9) : vVar.z(i9);
            iArr[i11] = iM;
            iArr2[i11] = z ? vVar.z(iM) : vVar.M(iM);
        }
        int size4 = list2.size();
        int i12 = IntCompanionObject.MAX_VALUE;
        if (Integer.MAX_VALUE < size4) {
            d1Var.getClass();
            z0 z0Var = z0.a;
            z0 z0Var2 = z0.a;
            z0 z0Var3 = z0.a;
        }
        if (Integer.MAX_VALUE >= list2.size()) {
            d1Var.getClass();
            z0 z0Var4 = z0.a;
            z0 z0Var5 = z0.a;
        }
        int iMin = Math.min(IntCompanionObject.MAX_VALUE, list2.size());
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            i13 += iArr[i14];
        }
        int i15 = 1;
        int size5 = ((list2.size() - 1) * i2) + i13;
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int i16 = iArr2[0];
        int i17 = size2 - 1;
        if (1 <= i17) {
            int i18 = 1;
            while (true) {
                int i19 = iArr2[i18];
                if (i16 < i19) {
                    i16 = i19;
                }
                if (i18 == i17) {
                    break;
                }
                i18++;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i20 = iArr[0];
        int i21 = size - 1;
        if (1 <= i21) {
            int i22 = 1;
            while (true) {
                int i23 = iArr[i22];
                if (i20 < i23) {
                    i20 = i23;
                }
                if (i22 == i21) {
                    break;
                }
                i22++;
            }
        }
        int i24 = size5;
        while (i20 <= size5 && i16 != i9) {
            i24 = (i20 + size5) / 2;
            if (list2.isEmpty()) {
                i6 = size5;
                jA = q1.l.a(i10, i10);
                j2 = 4294967295L;
            } else {
                t0 t0Var = new t0(i4, d1Var, p5.b.a(i10, i24, i10, i12), i2, i3);
                q4.v vVar2 = (q4.v) mx1.o.z0(i10, list2);
                int i25 = vVar2 != null ? iArr2[i10] : i10;
                int i26 = vVar2 != null ? iArr[i10] : i10;
                j2 = 4294967295L;
                i6 = size5;
                int i27 = 0;
                if (t0Var.b(list2.size() > i15 ? i15 : i10, 0, q1.l.a(i24, i12), vVar2 == null ? null : new q1.l(q1.l.a(i26, i25)), 0, 0, 0, false, false).b) {
                    q1.l lVarA = d1Var.a(i10, i10, vVar2 != null ? true : i10);
                    jA = q1.l.a(lVarA != null ? (int) (lVarA.a & 4294967295L) : i10, i10);
                } else {
                    int size6 = list2.size();
                    int i28 = i24;
                    int i29 = i10;
                    int i31 = i29;
                    int i32 = i31;
                    int i33 = 0;
                    int i34 = 0;
                    while (true) {
                        if (i29 >= size6) {
                            i7 = i31;
                            break;
                        }
                        int i35 = i28 - i26;
                        i7 = i29 + 1;
                        int iMax = Math.max(i34, i25);
                        q4.v vVar3 = (q4.v) mx1.o.z0(i7, list2);
                        i25 = vVar3 != null ? iArr2[i7] : 0;
                        int i36 = vVar3 != null ? iArr[i7] + i2 : 0;
                        int i37 = i7 - i32;
                        int i38 = i33;
                        s0 s0VarB = t0Var.b(i29 + 2 < list.size(), i37, q1.l.a(i35, IntCompanionObject.MAX_VALUE), vVar3 == null ? null : new q1.l(q1.l.a(i36, i25)), i38, i27, iMax, false, false);
                        if (s0VarB.a) {
                            int i39 = iMax + i3 + i27;
                            r0 r0VarA = t0Var.a(s0VarB, vVar3 != null, i38, i39, i35, i37);
                            i36 -= i2;
                            i33 = i38 + 1;
                            if (s0VarB.b) {
                                if (r0VarA != null) {
                                    long jB = r0VarA.b();
                                    if (!r0VarA.c()) {
                                        i39 = ((int) (jB & 4294967295L)) + i3 + i39;
                                    }
                                }
                                i27 = i39;
                            } else {
                                i8 = i24;
                                i32 = i7;
                                i27 = i39;
                                i34 = 0;
                            }
                        } else {
                            i8 = i35;
                            i33 = i38;
                            i34 = iMax;
                        }
                        i26 = i36;
                        list2 = list;
                        i29 = i7;
                        i31 = i29;
                        i28 = i8;
                    }
                    jA = q1.l.a(i27 - i3, i7);
                }
            }
            int i40 = (int) (jA >> 32);
            int i41 = (int) (jA & j2);
            if (i40 > i || i41 < iMin) {
                i20 = i24 + 1;
                size5 = i6;
                if (i20 > size5) {
                    return i20;
                }
            } else {
                if (i40 >= i) {
                    return i24;
                }
                size5 = i24 - 1;
            }
            i16 = i40;
            i9 = i;
            i10 = 0;
            i12 = IntCompanionObject.MAX_VALUE;
            i15 = 1;
            list2 = list;
        }
        return i24;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FlowMeasurePolicy(isHorizontal=");
        sb.append(this.a);
        sb.append(", horizontalArrangement=");
        sb.append(this.b);
        sb.append(", verticalArrangement=");
        sb.append(this.c);
        sb.append(", mainAxisSpacing=");
        q.q2.p(this.d, ", crossAxisAlignment=", sb);
        sb.append(this.e);
        sb.append(", crossAxisArrangementSpacing=");
        q.q2.p(this.f487f, ", maxItemsInMainAxis=", sb);
        sb.append(this.g);
        sb.append(", maxLines=2147483647, overflow=");
        sb.append(this.h);
        sb.append(')');
        return sb.toString();
    }
}
