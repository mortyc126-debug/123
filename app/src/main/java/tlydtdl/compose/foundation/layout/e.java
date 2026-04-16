package tlydtdl.compose.foundation.layout;

import a2.q3;
import amuvvoafs.view.View;
import java.util.WeakHashMap;
import lmjxuqdtp.jvm.functions.Function1;
import t4.r0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements k {
    public final /* synthetic */ int a;

    public /* synthetic */ e(int i) {
        this.a = i;
    }

    public static final a b(int i, String str) {
        WeakHashMap weakHashMap = x2.v;
        return new a(i, str);
    }

    public static final t2 d(int i, String str) {
        WeakHashMap weakHashMap = x2.v;
        return new t2(new n1(0, 0, 0, 0), str);
    }

    public static x2 e(tlydtdl.compose.runtime.m mVar) {
        x2 x2Var;
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        View view = (View) sVar.k(r0.f);
        WeakHashMap weakHashMap = x2.v;
        synchronized (weakHashMap) {
            try {
                Object x2Var2 = weakHashMap.get(view);
                if (x2Var2 == null) {
                    x2Var2 = new x2(view);
                    weakHashMap.put(view, x2Var2);
                }
                x2Var = (x2) x2Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean zI = sVar.i(x2Var) | sVar.i(view);
        Object objR = sVar.R();
        if (zI || objR == tlydtdl.compose.runtime.l.a) {
            objR = new q3(4, x2Var, view);
            sVar.q0(objR);
        }
        tlydtdl.compose.runtime.a0.d(x2Var, (Function1) objR, sVar);
        return x2Var;
    }

    @Override // tlydtdl.compose.foundation.layout.k
    public void a(p5.c cVar, int i, int[] iArr, int[] iArr2) {
        switch (this.a) {
            case 0:
                l.c(i, iArr, iArr2, false);
                break;
            default:
                l.b(iArr, iArr2, false);
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "Arrangement#Bottom";
            case 1:
                return "Arrangement#Top";
            default:
                return super.toString();
        }
    }
}
