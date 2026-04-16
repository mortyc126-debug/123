package tlydtdl.compose.ui.viewinterop;

import amuvvoafs.content.Context;
import amuvvoafs.view.View;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import p5.n;
import r3.g;
import r3.i;
import s4.j0;
import s4.k;
import s5.c;
import s5.o;
import s5.v;
import t3.p;
import t4.r0;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.q;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.u1;
import tlydtdl.lifecycle.g0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final void a(Function1 function1, p pVar, Function1 function12, m mVar, int i, int i2) {
        int i3;
        p pVar2;
        Function1 function13;
        Function1 function14 = c.f;
        s sVar = (s) mVar;
        sVar.h0(-1783766393);
        if ((i & 6) == 0) {
            i3 = (sVar.i(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= sVar.g(pVar) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= sVar.i(function12) ? 256 : 128;
        }
        if (sVar.W(i3 & 1, (i3 & 147) != 146)) {
            if (i4 != 0) {
                pVar = t3.m.a;
            }
            p pVar3 = pVar;
            Function1 function15 = i6 != 0 ? function14 : function12;
            b(function1, pVar3, null, function14, function15, sVar, (i3 & 14) | 3072 | (i3 & 112) | (57344 & (i3 << 6)), 4);
            pVar2 = pVar3;
            function13 = function15;
        } else {
            sVar.Z();
            pVar2 = pVar;
            function13 = function12;
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new s5.m(function1, pVar2, function13, i, i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(lmjxuqdtp.jvm.functions.Function1 r16, t3.p r17, lmjxuqdtp.jvm.functions.Function1 r18, lmjxuqdtp.jvm.functions.Function1 r19, lmjxuqdtp.jvm.functions.Function1 r20, tlydtdl.compose.runtime.m r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.ui.viewinterop.a.b(lmjxuqdtp.jvm.functions.Function1, t3.p, lmjxuqdtp.jvm.functions.Function1, lmjxuqdtp.jvm.functions.Function1, lmjxuqdtp.jvm.functions.Function1, tlydtdl.compose.runtime.m, int, int):void");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public static final v c(j0 j0Var) throws KotlinNothingValueException {
        v vVar = j0Var.n;
        if (vVar != null) {
            return vVar;
        }
        throw s1.a.q("Required value was null.");
    }

    public static final Function0 d(Function1 function1, m mVar, int i) {
        s sVar = (s) mVar;
        int iHashCode = Long.hashCode(sVar.T);
        Context context = (Context) sVar.k(r0.b);
        q qVarW = a0.w(sVar);
        g gVar = (g) sVar.k(i.a);
        View view = (View) sVar.k(r0.f);
        boolean zI = ((((i & 14) ^ 6) > 4 && sVar.g(function1)) || (i & 6) == 4) | sVar.i(context) | sVar.i(qVarW) | sVar.i(gVar) | sVar.e(iHashCode) | sVar.i(view);
        Object objR = sVar.R();
        if (zI || objR == l.a) {
            s5.q qVar = new s5.q(context, function1, qVarW, gVar, iHashCode, view);
            sVar.q0(qVar);
            objR = qVar;
        }
        return (Function0) objR;
    }

    public static final void e(m mVar, p pVar, int i, p5.c cVar, g0 g0Var, cc.g gVar, n nVar, u1 u1Var) {
        s4.l.f436d2.getClass();
        a0.y(mVar, u1Var, k.e);
        a0.y(mVar, pVar, o.f);
        a0.y(mVar, cVar, o.g);
        a0.y(mVar, g0Var, o.h);
        a0.y(mVar, gVar, o.i);
        a0.y(mVar, nVar, o.j);
        s4.i iVar = k.g;
        s sVar = (s) mVar;
        if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(i))) {
            i.x(i, sVar, i, iVar);
        }
    }
}
