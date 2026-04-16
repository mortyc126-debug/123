package pf1;

import a4.y;
import hy1.o;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;
import x10.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final o a = new o("%(\\d+)\\$s");

    public static final v a(v vVar, i iVar, Function1 function1, Function1 function12, Function0[] function0Arr, tlydtdl.compose.runtime.m mVar, int i, int i2) {
        lmjxuqdtp.jvm.internal.o.h(vVar, "<this>");
        lmjxuqdtp.jvm.internal.o.h(function0Arr, "onHrefTaps");
        if ((i2 & 1) != 0) {
            iVar = i.d;
        }
        i iVar2 = iVar;
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        int i3 = i2 & 4;
        x0 x0Var = tlydtdl.compose.runtime.l.a;
        if (i3 != 0) {
            s sVar = (s) mVar;
            Object objR = sVar.R();
            if (objR == x0Var) {
                objR = f.a;
                sVar.q0(objR);
            }
            function12 = (Function1) objR;
        }
        Function1 function13 = function12;
        long jY = md1.g.y(iVar2.a, mVar, 0);
        CharSequence charSequenceD0 = md1.g.d0(vVar, mVar);
        Object[] objArr = {new y(jY), charSequenceD0, iVar2};
        s sVar2 = (s) mVar;
        boolean zI = sVar2.i(charSequenceD0) | sVar2.f(jY) | ((((i & 112) ^ 48) > 32 && sVar2.g(iVar2)) || (i & 48) == 32) | ((((i & 7168) ^ 3072) > 2048 && sVar2.g(function13)) || (i & 3072) == 2048);
        Object objR2 = sVar2.R();
        if (zI || objR2 == x0Var) {
            objR2 = new d(charSequenceD0, jY, iVar2, function13);
            sVar2.q0(objR2);
        }
        Function1 function14 = (Function1) objR2;
        boolean zI2 = sVar2.i(function0Arr) | ((((i & 896) ^ 384) > 256 && sVar2.g(function1)) || (i & 384) == 256) | sVar2.i(charSequenceD0);
        Object objR3 = sVar2.R();
        if (zI2 || objR3 == x0Var) {
            objR3 = new e(function1, function0Arr, charSequenceD0, 0);
            sVar2.q0(objR3);
        }
        return x30.c.p(objArr, function14, (Function1) objR3, sVar2);
    }
}
