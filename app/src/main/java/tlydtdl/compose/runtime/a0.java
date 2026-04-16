package tlydtdl.compose.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import ny1.p2;
import org.apache.http.HttpStatus;
import q1.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {
    public static final Object a = new Object();
    public static final k0 b = new k0();

    public static final int A(y yVar) {
        int iC;
        int i = yVar.b;
        int iC2 = yVar.c(0);
        while (yVar.b != 0 && yVar.c(0) == iC2) {
            yVar.f(0, yVar.d());
            yVar.e(yVar.b - 1);
            int i2 = yVar.b;
            int i3 = i2 >>> 1;
            int i4 = 0;
            while (i4 < i3) {
                int iC3 = yVar.c(i4);
                int i6 = (i4 + 1) * 2;
                int i7 = i6 - 1;
                int iC4 = yVar.c(i7);
                if (i6 >= i2 || (iC = yVar.c(i6)) <= iC4) {
                    if (iC4 > iC3) {
                        yVar.f(i4, iC4);
                        yVar.f(i7, iC3);
                        i4 = i7;
                    }
                } else if (iC > iC3) {
                    yVar.f(i4, iC);
                    yVar.f(i6, iC3);
                    i4 = i6;
                }
            }
        }
        return iC2;
    }

    public static final int B(int i) {
        int i2 = 306783378 & i;
        int i3 = 613566756 & i;
        return (i & (-920350135)) | (i3 >> 1) | i2 | ((i2 << 1) & i3);
    }

    public static final q3.o C(y1[] y1VarArr, u1 u1Var, u1 u1Var2) {
        q3.o oVar = q3.o.d;
        q3.n nVar = new q3.n(oVar);
        nVar.g = oVar;
        for (y1 y1Var : y1VarArr) {
            x1 x1Var = y1Var.a;
            if (y1Var.f549f || !u1Var.containsKey(x1Var)) {
                nVar.put(x1Var, x1Var.c(y1Var, (i3) u1Var2.get(x1Var)));
            }
        }
        return nVar.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00c4  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(tlydtdl.compose.runtime.y1 r11, lmjxuqdtp.jvm.functions.Function2 r12, tlydtdl.compose.runtime.m r13, int r14) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.a0.a(tlydtdl.compose.runtime.y1, lmjxuqdtp.jvm.functions.Function2, tlydtdl.compose.runtime.m, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(tlydtdl.compose.runtime.y1[] r8, lmjxuqdtp.jvm.functions.Function2 r9, tlydtdl.compose.runtime.m r10, int r11) {
        /*
            tlydtdl.compose.runtime.s r10 = (tlydtdl.compose.runtime.s) r10
            r0 = 415205898(0x18bf8a0a, float:4.9511727E-24)
            r10.h0(r0)
            tlydtdl.compose.runtime.p0 r0 = r10.x
            tlydtdl.compose.runtime.u1 r1 = r10.m()
            r2 = 201(0xc9, float:2.82E-43)
            tlydtdl.compose.runtime.g1 r3 = tlydtdl.compose.runtime.u.b
            r10.c0(r2, r3)
            boolean r2 = r10.S
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L29
            q3.o r2 = q3.o.d
            q3.o r2 = C(r8, r1, r2)
            q3.o r1 = r10.p0(r1, r2)
            r10.J = r3
        L27:
            r2 = r4
            goto L76
        L29:
            tlydtdl.compose.runtime.n2 r2 = r10.G
            int r5 = r2.g
            java.lang.Object r2 = r2.h(r5, r4)
            java.lang.String r5 = "null cannot be cast to non-null type tlydtdl.compose.runtime.PersistentCompositionLocalMap"
            lmjxuqdtp.jvm.internal.o.f(r2, r5)
            tlydtdl.compose.runtime.u1 r2 = (tlydtdl.compose.runtime.u1) r2
            tlydtdl.compose.runtime.n2 r6 = r10.G
            int r7 = r6.g
            java.lang.Object r6 = r6.h(r7, r3)
            lmjxuqdtp.jvm.internal.o.f(r6, r5)
            tlydtdl.compose.runtime.u1 r6 = (tlydtdl.compose.runtime.u1) r6
            q3.o r5 = C(r8, r1, r6)
            boolean r7 = r10.G()
            if (r7 == 0) goto L67
            boolean r7 = r10.y
            if (r7 != 0) goto L67
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L5a
            goto L67
        L5a:
            int r1 = r10.l
            tlydtdl.compose.runtime.n2 r5 = r10.G
            int r5 = r5.s()
            int r5 = r5 + r1
            r10.l = r5
            r1 = r2
            goto L27
        L67:
            q3.o r1 = r10.p0(r1, r5)
            boolean r5 = r10.y
            if (r5 != 0) goto L75
            boolean r2 = lmjxuqdtp.jvm.internal.o.c(r1, r2)
            if (r2 != 0) goto L27
        L75:
            r2 = r3
        L76:
            if (r2 == 0) goto L7f
            boolean r5 = r10.S
            if (r5 != 0) goto L7f
            r10.P(r1)
        L7f:
            boolean r5 = r10.w
            r0.e(r5)
            r10.w = r2
            r10.K = r1
            r2 = 202(0xca, float:2.83E-43)
            tlydtdl.compose.runtime.g1 r5 = tlydtdl.compose.runtime.u.c
            r10.a0(r2, r5, r1, r4)
            int r1 = r11 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9.invoke(r10, r1)
            r10.r(r4)
            r10.r(r4)
            int r0 = r0.d()
            if (r0 == 0) goto La7
            goto La8
        La7:
            r3 = r4
        La8:
            r10.w = r3
            r0 = 0
            r10.K = r0
            tlydtdl.compose.runtime.a2 r10 = r10.v()
            if (r10 == 0) goto Lbb
            an0.i r0 = new an0.i
            r1 = 2
            r0.<init>(r8, r9, r11, r1)
            r10.d = r0
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.a0.b(tlydtdl.compose.runtime.y1[], lmjxuqdtp.jvm.functions.Function2, tlydtdl.compose.runtime.m, int):void");
    }

    public static final void c(Object obj, Object obj2, Function1 function1, m mVar) {
        s sVar = (s) mVar;
        boolean zG = sVar.g(obj) | sVar.g(obj2);
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            objR = new i0(function1);
            sVar.q0(objR);
        }
    }

    public static final void d(Object obj, Function1 function1, m mVar) {
        s sVar = (s) mVar;
        boolean zG = sVar.g(obj);
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            objR = new i0(function1);
            sVar.q0(objR);
        }
    }

    public static final void e(Object[] objArr, Function1 function1, m mVar) {
        boolean zG = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zG |= ((s) mVar).g(obj);
        }
        s sVar = (s) mVar;
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            sVar.q0(new i0(function1));
        }
    }

    public static final void f(m mVar, Object obj, Function2 function2) {
        s sVar = (s) mVar;
        qx1.i iVar = sVar.R;
        boolean zG = sVar.g(obj);
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            objR = new v0(iVar, function2);
            sVar.q0(objR);
        }
    }

    public static final void g(Object obj, Object obj2, Object obj3, Function2 function2, m mVar) {
        s sVar = (s) mVar;
        qx1.i iVar = sVar.R;
        boolean zG = sVar.g(obj) | sVar.g(obj2) | sVar.g(obj3);
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            objR = new v0(iVar, function2);
            sVar.q0(objR);
        }
    }

    public static final void h(Object obj, Object obj2, Function2 function2, m mVar) {
        s sVar = (s) mVar;
        qx1.i iVar = sVar.R;
        boolean zG = sVar.g(obj) | sVar.g(obj2);
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            objR = new v0(iVar, function2);
            sVar.q0(objR);
        }
    }

    public static final void i(Object[] objArr, Function2 function2, m mVar) {
        s sVar = (s) mVar;
        qx1.i iVar = sVar.R;
        boolean zG = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zG |= sVar.g(obj);
        }
        Object objR = sVar.R();
        if (zG || objR == l.a) {
            sVar.q0(new v0(iVar, function2));
        }
    }

    public static final void j(Function0 function0, m mVar) {
        j3.m0 m0Var = ((s) mVar).M.b.b;
        m0Var.M0(j3.c0.c);
        tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 0, function0);
    }

    public static final void k(y yVar, int i) {
        if (yVar.b == 0 || !(yVar.c(0) == i || yVar.c(yVar.b - 1) == i)) {
            int i2 = yVar.b;
            yVar.a(i);
            while (i2 > 0) {
                int i3 = ((i2 + 1) >>> 1) - 1;
                int iC = yVar.c(i3);
                if (i <= iC) {
                    break;
                }
                yVar.f(i2, iC);
                i2 = i3;
            }
            yVar.f(i2, i);
        }
    }

    public static void l(r2 r2Var, List list, b2 b2Var) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iC = r2Var.c((a) list.get(i));
            int iO = r2Var.O(r2Var.r(iC), r2Var.b);
            Object obj = iO < r2Var.g(r2Var.r(iC + 1), r2Var.b) ? r2Var.c[r2Var.h(iO)] : l.a;
            a2 a2Var = obj instanceof a2 ? (a2) obj : null;
            if (a2Var != null) {
                a2Var.a = b2Var;
            }
        }
    }

    public static final e1 m(p2 p2Var, m mVar) {
        Object value = p2Var.getValue();
        s sVar = (s) mVar;
        qx1.j jVar = qx1.j.a;
        boolean zI = sVar.i(jVar) | sVar.i(p2Var);
        Object objR = sVar.R();
        qx1.d dVar = null;
        x0 x0Var = l.a;
        if (zI || objR == x0Var) {
            objR = new a10.i(jVar, p2Var, (qx1.d) null, 9);
            sVar.q0(objR);
        }
        Function2 function2 = (Function2) objR;
        Object objR2 = sVar.R();
        if (objR2 == x0Var) {
            objR2 = t(value);
            sVar.q0(objR2);
        }
        e1 e1Var = (e1) objR2;
        boolean zI2 = sVar.i(function2);
        Object objR3 = sVar.R();
        if (zI2 || objR3 == x0Var) {
            objR3 = new z2(function2, e1Var, dVar, 1);
            sVar.q0(objR3);
        }
        h(p2Var, jVar, (Function2) objR3, sVar);
        return e1Var;
    }

    public static final ky1.a0 n(m mVar) {
        return new l2(((s) mVar).R);
    }

    public static final k3.e o() {
        jx0.h hVar = y2.b;
        k3.e eVar = (k3.e) hVar.get();
        if (eVar != null) {
            return eVar;
        }
        k3.e eVar2 = new k3.e(0, new r[0]);
        hVar.E(eVar2);
        return eVar2;
    }

    public static final h0 p(x2 x2Var, Function0 function0) {
        jx0.h hVar = y2.a;
        return new h0(x2Var, function0);
    }

    public static final h0 q(Function0 function0) {
        jx0.h hVar = y2.a;
        return new h0(null, function0);
    }

    public static final y0 r(qx1.i iVar) {
        y0 y0Var = (y0) iVar.get(x0.b);
        if (y0Var != null) {
            return y0Var;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
    }

    public static List s(r2 r2Var, int i, r2 r2Var2, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList;
        boolean z4;
        int i2;
        int i3;
        int iT = r2Var.t(i);
        int i4 = i + iT;
        int iF = r2Var.f(i);
        int iF2 = r2Var.f(i4);
        int i6 = iF2 - iF;
        boolean z5 = i >= 0 && (r2Var.b[(r2Var.r(i) * 5) + 1] & 201326592) != 0;
        r2Var2.v(iT);
        r2Var2.w(i6, r2Var2.t);
        if (r2Var.g < i4) {
            r2Var.A(i4);
        }
        if (r2Var.k < iF2) {
            r2Var.B(iF2, i4);
        }
        int[] iArr = r2Var2.b;
        int i7 = r2Var2.t;
        int i8 = i7 * 5;
        mx1.n.R(i8, i * 5, r2Var.b, iArr, i4 * 5);
        Object[] objArr = r2Var2.c;
        int i9 = r2Var2.i;
        System.arraycopy(r2Var.c, iF, objArr, i9, i6);
        int i10 = r2Var2.v;
        iArr[i8 + 2] = i10;
        int i11 = i7 - i;
        int i12 = i7 + iT;
        int iG = i9 - r2Var2.g(i7, iArr);
        int i13 = r2Var2.m;
        int i14 = r2Var2.l;
        int length = objArr.length;
        boolean z6 = z5;
        int i15 = i13;
        int i16 = i7;
        while (i16 < i12) {
            if (i16 != i7) {
                int i17 = (i16 * 5) + 2;
                iArr[i17] = iArr[i17] + i11;
            }
            int[] iArr2 = iArr;
            int iG2 = r2Var2.g(i16, iArr) + iG;
            if (i15 < i16) {
                i2 = i7;
                i3 = 0;
            } else {
                i2 = i7;
                i3 = r2Var2.k;
            }
            iArr2[(i16 * 5) + 4] = r2.i(iG2, i3, i14, length);
            if (i16 == i15) {
                i15++;
            }
            i16++;
            i7 = i2;
            iArr = iArr2;
        }
        int[] iArr3 = iArr;
        r2Var2.m = i15;
        int iB = q2.b(r2Var.d, i, r2Var.p());
        int iB2 = q2.b(r2Var.d, i4, r2Var.p());
        if (iB < iB2) {
            ArrayList arrayList2 = r2Var.d;
            arrayList = new ArrayList(iB2 - iB);
            for (int i18 = iB; i18 < iB2; i18++) {
                a aVar = (a) arrayList2.get(i18);
                aVar.a += i11;
                arrayList.add(aVar);
            }
            r2Var2.d.addAll(q2.b(r2Var2.d, r2Var2.t, r2Var2.p()), arrayList);
            arrayList2.subList(iB, iB2).clear();
        } else {
            arrayList = mx1.t.a;
        }
        if (!arrayList.isEmpty()) {
            HashMap map = r2Var.e;
            HashMap map2 = r2Var2.e;
            if (map != null && map2 != null) {
                int size = arrayList.size();
                for (int i19 = 0; i19 < size; i19++) {
                }
            }
        }
        int i20 = r2Var2.v;
        r2Var2.P(i10);
        int iF3 = r2Var.F(i, r2Var.b);
        if (!z3) {
            z4 = false;
        } else if (z) {
            boolean z7 = iF3 >= 0;
            if (z7) {
                r2Var.Q();
                r2Var.a(iF3 - r2Var.t);
                r2Var.Q();
            }
            r2Var.a(i - r2Var.t);
            boolean zI = r2Var.I();
            if (z7) {
                r2Var.N();
                r2Var.j();
                r2Var.N();
                r2Var.j();
            }
            z4 = zI;
        } else {
            boolean zJ = r2Var.J(i, iT);
            r2Var.K(iF, i6, i - 1);
            z4 = zJ;
        }
        if (z4) {
            u.c("Unexpectedly removed anchors");
        }
        int i21 = r2Var2.o;
        int i22 = iArr3[i8 + 1];
        r2Var2.o = i21 + ((1073741824 & i22) != 0 ? 1 : i22 & 67108863);
        if (z2) {
            r2Var2.t = i12;
            r2Var2.i = i9 + i6;
        }
        if (z6) {
            r2Var2.V(i10);
        }
        return arrayList;
    }

    public static n1 t(Object obj) {
        return new n1(obj, x0.f548f);
    }

    public static final e1 u(m mVar, Object obj, Function2 function2) {
        s sVar = (s) mVar;
        Object objR = sVar.R();
        x0 x0Var = l.a;
        if (objR == x0Var) {
            objR = t(obj);
            sVar.q0(objR);
        }
        e1 e1Var = (e1) objR;
        boolean zI = sVar.i(function2);
        Object objR2 = sVar.R();
        if (zI || objR2 == x0Var) {
            objR2 = new z2(function2, e1Var, null, 0);
            sVar.q0(objR2);
        }
        f(sVar, lx1.b0.a, (Function2) objR2);
        return e1Var;
    }

    public static final Object v(u1 u1Var, x1 x1Var) {
        lmjxuqdtp.jvm.internal.o.f(x1Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.CompositionLocal<lmjxuqdtp.Any?>");
        Object objB = u1Var.get(x1Var);
        if (objB == null) {
            objB = x1Var.b();
        }
        return ((i3) objB).a(u1Var);
    }

    public static final q w(m mVar) {
        s sVar = (s) mVar;
        sVar.c0(HttpStatus.SC_PARTIAL_CONTENT, u.e);
        if (sVar.S) {
            r2.y(sVar.I);
        }
        Object objJ = sVar.J();
        p pVar = objJ instanceof p ? (p) objJ : null;
        if (pVar == null) {
            pVar = new p(new q(sVar, sVar.T, sVar.q, sVar.C, sVar.h.t));
            sVar.r0(pVar);
        }
        q qVar = pVar.a;
        qVar.f539f.setValue(sVar.m());
        sVar.r(false);
        return qVar;
    }

    public static final e1 x(Object obj, m mVar) {
        s sVar = (s) mVar;
        Object objR = sVar.R();
        if (objR == l.a) {
            objR = t(obj);
            sVar.q0(objR);
        }
        e1 e1Var = (e1) objR;
        e1Var.setValue(obj);
        return e1Var;
    }

    public static final void y(m mVar, Object obj, Function2 function2) {
        s sVar = (s) mVar;
        if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), obj)) {
            sVar.q0(obj);
            sVar.b(obj, function2);
        }
    }

    public static final ny1.c2 z(Function0 function0) {
        return new ny1.c2(new d3(function0, null, 0));
    }
}
