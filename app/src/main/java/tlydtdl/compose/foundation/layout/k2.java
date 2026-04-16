package tlydtdl.compose.foundation.layout;

import kotlin.jvm.internal.IntCompanionObject;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k2 implements Function1 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ k2(tlydtdl.compose.runtime.h0 h0Var, q3.l lVar, q1.f0 f0Var, int i) {
        this.c = h0Var;
        this.d = lVar;
        this.e = f0Var;
        this.b = i;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                q4.m1[] m1VarArr = (q4.m1[]) this.c;
                l2 l2Var = (l2) this.d;
                int[] iArr = (int[]) this.e;
                q4.l1 l1Var = (q4.l1) obj;
                int length = m1VarArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    q4.m1 m1Var = m1VarArr[i];
                    int i3 = i2 + 1;
                    lmjxuqdtp.jvm.internal.o.e(m1Var);
                    Object objL = m1Var.l();
                    i2 i2Var = objL instanceof i2 ? (i2) objL : null;
                    m mVar = i2Var != null ? i2Var.c : null;
                    int i4 = this.b;
                    q4.l1.i(l1Var, m1Var, iArr[i2], mVar != null ? mVar.k(i4 - m1Var.b, p5.n.a) : l2Var.b.a(0, i4 - m1Var.b));
                    i++;
                    i2 = i3;
                }
                return lx1.b0.a;
            case 1:
                tlydtdl.compose.runtime.h0 h0Var = (tlydtdl.compose.runtime.h0) this.c;
                q3.l lVar = (q3.l) this.d;
                q1.f0 f0Var = (q1.f0) this.e;
                if (obj == h0Var) {
                    throw new IllegalStateException("A derived state calculation cannot read itself");
                }
                if (obj instanceof s3.a0) {
                    int i6 = lVar.a - this.b;
                    int iD = f0Var.d(obj);
                    f0Var.h(Math.min(i6, iD >= 0 ? f0Var.c[iD] : IntCompanionObject.MAX_VALUE), obj);
                }
                return lx1.b0.a;
            default:
                w2.i0 i0Var = (w2.i0) this.c;
                q4.m1 m1Var2 = (q4.m1) this.d;
                q4.l1 l1Var2 = (q4.l1) obj;
                i0Var.V0(l1Var2, this.b, m1Var2.a, i0Var.f.f().d, ((q4.w0) this.e).getLayoutDirection());
                q4.l1.m(l1Var2, m1Var2, -i0Var.j.a.h(), 0);
                return lx1.b0.a;
        }
    }

    public /* synthetic */ k2(w2.i0 i0Var, int i, q4.m1 m1Var, q4.w0 w0Var) {
        this.c = i0Var;
        this.b = i;
        this.d = m1Var;
        this.e = w0Var;
    }

    public /* synthetic */ k2(q4.m1[] m1VarArr, l2 l2Var, int i, int[] iArr) {
        this.c = m1VarArr;
        this.d = l2Var;
        this.b = i;
        this.e = iArr;
    }
}
