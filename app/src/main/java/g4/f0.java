package g4;

import lmjxuqdtp.jvm.functions.Function1;
import tlydtdl.compose.foundation.lazy.layout.r1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends lmjxuqdtp.jvm.internal.p implements Function1 {
    public final /* synthetic */ int c;
    public final /* synthetic */ g0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(g0 g0Var, int i) {
        super(1);
        this.c = i;
        this.d = g0Var;
    }

    public final Object invoke(Object obj) {
        switch (this.c) {
            case 0:
                g0 g0Var = this.d;
                g0Var.d = true;
                g0Var.f161f.invoke();
                return lx1.b0.a;
            default:
                c4.d dVar = (c4.d) obj;
                g0 g0Var2 = this.d;
                c cVar = g0Var2.b;
                float f2 = g0Var2.k;
                float f3 = g0Var2.l;
                r1 r1VarX0 = dVar.x0();
                long jO = r1VarX0.o();
                r1VarX0.j().o();
                try {
                    ((ru1.c) r1VarX0.c).t(0L, f2, f3);
                    cVar.a(dVar);
                    s1.a.v(r1VarX0, jO);
                    return lx1.b0.a;
                } catch (Throwable th) {
                    s1.a.v(r1VarX0, jO);
                    throw th;
                }
        }
    }
}
