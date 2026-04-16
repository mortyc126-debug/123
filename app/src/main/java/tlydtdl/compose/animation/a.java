package tlydtdl.compose.animation;

import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.internal.o;
import mx1.n;
import okhttp3.internal.http2.Http2;
import q1.n0;
import q1.v0;
import q3.k;
import s1.d0;
import s1.i;
import s1.r;
import s4.c1;
import s4.j;
import t1.k1;
import t1.q1;
import t1.u1;
import t3.d;
import t3.p;
import t4.e2;
import tlydtdl.compose.foundation.lazy.layout.r0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.n1;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final long a;
    public static final /* synthetic */ int b = 0;

    static {
        long j2 = IntCompanionObject.MIN_VALUE;
        a = (j2 & 4294967295L) | (j2 << 32);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(java.lang.Object r17, t3.p r18, lmjxuqdtp.jvm.functions.Function1 r19, t3.d r20, java.lang.String r21, lmjxuqdtp.jvm.functions.Function1 r22, q3.k r23, tlydtdl.compose.runtime.m r24, int r25, int r26) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.animation.a.a(java.lang.Object, t3.p, lmjxuqdtp.jvm.functions.Function1, t3.d, java.lang.String, lmjxuqdtp.jvm.functions.Function1, q3.k, tlydtdl.compose.runtime.m, int, int):void");
    }

    public static final void b(q1 q1Var, p pVar, Function1 function1, d dVar, Function1 function12, k kVar, m mVar, int i) {
        int i2;
        Function1 function13;
        s sVar;
        r0 r0Var;
        s1.s sVar2;
        s3.p pVar2;
        final s1.s sVar3;
        final k1 k1VarB;
        s sVar4;
        boolean z;
        Function1 function14 = function1;
        s sVar5 = (s) mVar;
        sVar5.h0(511725103);
        if ((i & 6) == 0) {
            i2 = (sVar5.g(q1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar5.g(pVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar5.i(function14) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= sVar5.g(dVar) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= sVar5.i(function12) ? Http2.INITIAL_MAX_FRAME_SIZE : 8192;
        }
        k kVar2 = kVar;
        if ((196608 & i) == 0) {
            i2 |= sVar5.i(kVar2) ? 131072 : 65536;
        }
        if (sVar5.W(i2 & 1, (74899 & i2) != 74898)) {
            int i3 = i2 & 14;
            boolean z2 = i3 == 4;
            Object objR = sVar5.R();
            x0 x0Var = l.a;
            if (z2 || objR == x0Var) {
                objR = new s1.s(q1Var, dVar);
                sVar5.q0(objR);
            }
            s1.s sVar6 = (s1.s) objR;
            boolean z3 = i3 == 4;
            Object objR2 = sVar5.R();
            Object obj = objR2;
            if (z3 || objR2 == x0Var) {
                Object[] objArr = {q1Var.a.m()};
                s3.p pVar3 = new s3.p();
                pVar3.addAll(n.x0(objArr));
                sVar5.q0(pVar3);
                obj = pVar3;
            }
            s3.p pVar4 = (s3.p) obj;
            boolean z4 = i3 == 4;
            Object objR3 = sVar5.R();
            if (z4 || objR3 == x0Var) {
                long[] jArr = v0.a;
                objR3 = new n0();
                sVar5.q0(objR3);
            }
            n0 n0Var = (n0) objR3;
            r0 r0Var2 = q1Var.a;
            n1 n1Var = q1Var.d;
            if (!pVar4.contains(r0Var2.m())) {
                pVar4.clear();
                pVar4.add(r0Var2.m());
            }
            if (o.c(r0Var2.m(), n1Var.getValue())) {
                if (pVar4.size() != 1 || !o.c(pVar4.get(0), r0Var2.m())) {
                    pVar4.clear();
                    pVar4.add(r0Var2.m());
                }
                if (n0Var.e != 1 || n0Var.c(r0Var2.m())) {
                    n0Var.a();
                }
                sVar6.b = dVar;
            }
            if (o.c(r0Var2.m(), n1Var.getValue()) || pVar4.contains(n1Var.getValue())) {
                r0Var = r0Var2;
            } else {
                nx1.c cVarListIterator = pVar4.listIterator();
                int i4 = 0;
                while (true) {
                    nx1.c cVar = cVarListIterator;
                    r0Var = r0Var2;
                    if (!cVar.hasNext()) {
                        i4 = -1;
                        break;
                    } else {
                        if (o.c(function12.invoke(cVar.next()), function12.invoke(n1Var.getValue()))) {
                            break;
                        }
                        i4++;
                        r0Var2 = r0Var;
                    }
                }
                if (i4 == -1) {
                    pVar4.add(n1Var.getValue());
                } else {
                    pVar4.set(i4, n1Var.getValue());
                }
            }
            if (n0Var.c(n1Var.getValue()) && n0Var.c(r0Var.m())) {
                sVar5.f0(1969054067);
                sVar5.r(false);
                function13 = function14;
                sVar2 = sVar6;
            } else {
                sVar5.f0(1966468977);
                n0Var.a();
                int size = pVar4.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj2 = pVar4.get(i6);
                    n0Var.m(obj2, q3.p.d(-23915175, new i(q1Var, obj2, function14, sVar6, pVar4, kVar2), sVar5));
                    i6++;
                    function14 = function14;
                    kVar2 = kVar;
                }
                function13 = function14;
                sVar2 = sVar6;
                sVar5.r(false);
            }
            boolean zG = sVar5.g(q1Var.f()) | sVar5.g(sVar2);
            Object objR4 = sVar5.R();
            if (zG || objR4 == x0Var) {
                objR4 = (d0) function13.invoke(sVar2);
                sVar5.q0(objR4);
            }
            d0 d0Var = (d0) objR4;
            q1 q1Var2 = sVar2.a;
            boolean zG2 = sVar5.g(sVar2);
            Object objR5 = sVar5.R();
            if (zG2 || objR5 == x0Var) {
                objR5 = a0.t(Boolean.FALSE);
                sVar5.q0(objR5);
            }
            e1 e1Var = (e1) objR5;
            final e1 e1VarX = a0.x(d0Var.d, sVar5);
            if (o.c(q1Var2.a.m(), q1Var2.d.getValue())) {
                e1Var.setValue(Boolean.FALSE);
            } else if (e1VarX.getValue() != null) {
                e1Var.setValue(Boolean.TRUE);
            }
            boolean zBooleanValue = ((Boolean) e1Var.getValue()).booleanValue();
            p pVar5 = t3.m.a;
            if (zBooleanValue) {
                sVar5.f0(1353180665);
                s1.s sVar7 = sVar2;
                pVar2 = pVar4;
                s sVar8 = sVar5;
                sVar3 = sVar7;
                k1VarB = u1.b(sVar7.a, t1.c.p, (String) null, sVar8, 0, 2);
                boolean zG3 = sVar8.g(k1VarB);
                Object objR6 = sVar8.R();
                if (zG3 || objR6 == x0Var) {
                    objR6 = b4.w(pVar5);
                    sVar8.q0(objR6);
                }
                pVar5 = (p) objR6;
                sVar8.r(false);
                sVar4 = sVar8;
            } else {
                pVar2 = pVar4;
                s sVar9 = sVar5;
                sVar3 = sVar2;
                sVar9.f0(1353446707);
                sVar9.r(false);
                k1VarB = null;
                sVar4 = sVar9;
            }
            p pVarThen = pVar.then(pVar5.then(new c1(k1VarB, e1VarX, sVar3) { // from class: tlydtdl.compose.animation.AnimatedContentTransitionScopeImpl$SizeModifierElement
                public final k1 a;
                public final e1 b;
                public final s1.s c;

                {
                    this.a = k1VarB;
                    this.b = e1VarX;
                    this.c = sVar3;
                }

                @Override // s4.c1
                public final t3.o create() {
                    r rVar = new r(1);
                    rVar.b = this.a;
                    rVar.c = this.b;
                    rVar.d = this.c;
                    rVar.e = a.a;
                    return rVar;
                }

                public final boolean equals(Object obj3) {
                    if (!(obj3 instanceof AnimatedContentTransitionScopeImpl$SizeModifierElement)) {
                        return false;
                    }
                    AnimatedContentTransitionScopeImpl$SizeModifierElement animatedContentTransitionScopeImpl$SizeModifierElement = (AnimatedContentTransitionScopeImpl$SizeModifierElement) obj3;
                    return o.c(animatedContentTransitionScopeImpl$SizeModifierElement.a, this.a) && animatedContentTransitionScopeImpl$SizeModifierElement.b.equals(this.b);
                }

                public final int hashCode() {
                    int iHashCode = this.c.hashCode() * 31;
                    k1 k1Var = this.a;
                    return this.b.hashCode() + ((iHashCode + (k1Var != null ? k1Var.hashCode() : 0)) * 31);
                }

                @Override // s4.c1
                public final void inspectableProperties(e2 e2Var) {
                    e2Var.d("sizeTransform");
                    e2Var.b().c(this.a, "sizeAnimation");
                    e2Var.b().c(this.b, "sizeTransform");
                    e2Var.b().c(this.c, "scope");
                }

                @Override // s4.c1
                public final void update(t3.o oVar) {
                    r rVar = (r) oVar;
                    rVar.b = this.a;
                    rVar.c = this.b;
                    rVar.d = this.c;
                }
            }));
            Object objR7 = sVar4.R();
            if (objR7 == x0Var) {
                objR7 = new s1.m(sVar3);
                sVar4.q0(objR7);
            }
            s1.m mVar2 = (s1.m) objR7;
            int iHashCode = Long.hashCode(sVar4.T);
            tlydtdl.compose.runtime.u1 u1VarM = sVar4.m();
            p pVarX = j4.x(sVar4, pVarThen);
            s4.l.f436d2.getClass();
            j jVar = s4.k.b;
            sVar4.j0();
            if (sVar4.S) {
                sVar4.l(jVar);
            } else {
                sVar4.t0();
            }
            a0.y(sVar4, mVar2, s4.k.f435f);
            a0.y(sVar4, u1VarM, s4.k.e);
            s4.i iVar = s4.k.g;
            if (sVar4.S || !o.c(sVar4.R(), Integer.valueOf(iHashCode))) {
                i.x(iHashCode, sVar4, iHashCode, iVar);
            }
            a0.y(sVar4, pVarX, s4.k.d);
            sVar4.f0(-860173498);
            int size2 = pVar2.size();
            int i7 = 0;
            while (i7 < size2) {
                s3.p pVar6 = pVar2;
                Object obj3 = pVar6.get(i7);
                sVar4.d0(-2026002954, function12.invoke(obj3));
                Function2 function2 = (Function2) n0Var.g(obj3);
                if (function2 == null) {
                    sVar4.f0(1618454323);
                    z = false;
                } else {
                    z = false;
                    sVar4.f0(-2026001778);
                    function2.invoke(sVar4, 0);
                }
                sVar4.r(z);
                sVar4.r(z);
                i7++;
                pVar2 = pVar6;
            }
            sVar4.r(false);
            sVar4.r(true);
            sVar = sVar4;
        } else {
            function13 = function14;
            s sVar10 = sVar5;
            sVar10.Z();
            sVar = sVar10;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new s1.j(q1Var, pVar, function13, dVar, function12, kVar, i);
        }
    }
}
