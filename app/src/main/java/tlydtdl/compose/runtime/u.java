package tlydtdl.compose.runtime;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static final g1 a = new g1("provider");
    public static final g1 b = new g1("provider");
    public static final g1 c = new g1("compositionLocalMap");
    public static final g1 d = new g1("providers");
    public static final g1 e = new g1("reference");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final tlydtdl.compose.foundation.lazy.layout.a f547f = new tlydtdl.compose.foundation.lazy.layout.a(2);

    public static final void a(List list, int i, int i2) {
        int iF = f(i, list);
        if (iF < 0) {
            iF = -(iF + 1);
        }
        while (iF < list.size() && ((q0) list.get(iF)).b < i2) {
        }
    }

    public static final void b(n2 n2Var, ArrayList arrayList, int i) {
        boolean zL = n2Var.l(i);
        int[] iArr = n2Var.b;
        if (zL) {
            arrayList.add(n2Var.n(i));
            return;
        }
        int i2 = iArr[(i * 5) + 3] + i;
        for (int i3 = i + 1; i3 < i2; i3 += iArr[(i3 * 5) + 3]) {
            b(n2Var, arrayList, i3);
        }
    }

    public static final void c(String str) {
        throw new ComposeRuntimeError(i.n("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final Void d(String str) {
        throw new ComposeRuntimeError(i.n("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final b1 e(z zVar, c1 c1Var, r2 r2Var, c cVar) {
        x0 x0Var = l.a;
        o2 o2Var = new o2();
        if (r2Var.e != null) {
            o2Var.d();
        }
        if (r2Var.f542f != null) {
            o2Var.k = new q1.z();
        }
        int i = r2Var.t;
        if (cVar != null && r2Var.E(i) > 0) {
            int iF = r2Var.v;
            while (iF > 0 && !r2Var.x(iF)) {
                iF = r2Var.F(iF, r2Var.b);
            }
            if (iF >= 0 && r2Var.x(iF)) {
                Object objD = r2Var.D(iF);
                int i2 = iF + 1;
                int iT = r2Var.t(iF) + iF;
                int iE = 0;
                while (i2 < iT) {
                    int iT2 = r2Var.t(i2) + i2;
                    if (iT2 > i) {
                        break;
                    }
                    iE += r2Var.x(i2) ? 1 : r2Var.E(i2);
                    i2 = iT2;
                }
                int iE2 = r2Var.x(i) ? 1 : r2Var.E(i);
                cVar.i(objD);
                cVar.b(iE, iE2);
                cVar.l();
            }
        }
        r2 r2VarH = o2Var.h();
        try {
            r2VarH.d();
            r2VarH.R(c1Var.a, x0Var, false, 126665345);
            r2.y(r2VarH);
            r2VarH.T(c1Var.b);
            List listC = r2Var.C(c1Var.e, r2VarH);
            r2VarH.M();
            r2VarH.j();
            r2VarH.k();
            r2VarH.e(true);
            b1 b1Var = new b1(o2Var);
            if (!listC.isEmpty()) {
                int size = listC.size();
                for (int i3 = 0; i3 < size; i3++) {
                    a aVar = (a) listC.get(i3);
                    if (o2Var.i(aVar)) {
                        int iB = o2Var.b(aVar);
                        int iC = q2.c(iB, o2Var.a);
                        int i4 = iB + 1;
                        if (((i4 < o2Var.b ? o2Var.a[(i4 * 5) + 4] : o2Var.c.length) - iC > 0 ? o2Var.c[iC] : x0Var) instanceof a2) {
                            t tVar = new t(zVar, c1Var);
                            r2VarH = o2Var.h();
                            try {
                                a0.l(r2VarH, listC, tVar);
                                r2VarH.e(true);
                                return b1Var;
                            } finally {
                            }
                        }
                    }
                }
            }
            return b1Var;
        } finally {
        }
    }

    public static final int f(int i, List list) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int i4 = lmjxuqdtp.jvm.internal.o.i(((q0) list.get(i3)).b, i);
            if (i4 < 0) {
                i2 = i3 + 1;
            } else {
                if (i4 <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final void g(r2 r2Var, int i, Object obj) {
        int iH = r2Var.h(i);
        Object[] objArr = r2Var.c;
        Object obj2 = objArr[iH];
        objArr[iH] = l.a;
        if (obj == obj2) {
            return;
        }
        c("Slot table is out of sync (expected " + obj + ", got " + obj2 + ')');
    }
}
