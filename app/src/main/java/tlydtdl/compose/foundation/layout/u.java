package tlydtdl.compose.foundation.layout;

import java.io.Serializable;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Serializable e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f493f;
    public final /* synthetic */ Object g;

    public /* synthetic */ u(Object obj, Object obj2, Object obj3, Serializable serializable, Object obj4, Object obj5, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = serializable;
        this.f493f = obj4;
        this.g = obj5;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                q4.m1[] m1VarArr = (q4.m1[]) this.b;
                List list = (List) this.c;
                q4.w0 w0Var = (q4.w0) this.d;
                lmjxuqdtp.jvm.internal.a0 a0Var = this.e;
                lmjxuqdtp.jvm.internal.a0 a0Var2 = (lmjxuqdtp.jvm.internal.a0) this.f493f;
                v vVar = (v) this.g;
                q4.l1 l1Var = (q4.l1) obj;
                int length = m1VarArr.length;
                int i = 0;
                int i2 = 0;
                while (i2 < length) {
                    q4.m1 m1Var = m1VarArr[i2];
                    lmjxuqdtp.jvm.internal.o.f(m1Var, "null cannot be cast to non-null type tlydtdl.compose.ui.layout.Placeable");
                    s.b(l1Var, m1Var, (q4.t0) list.get(i), w0Var.getLayoutDirection(), a0Var.a, a0Var2.a, vVar.a);
                    i2++;
                    i++;
                }
                break;
            default:
                tlydtdl.compose.runtime.d1 d1Var = (tlydtdl.compose.runtime.d1) this.b;
                tlydtdl.compose.runtime.d1 d1Var2 = (tlydtdl.compose.runtime.d1) this.c;
                lmjxuqdtp.jvm.internal.z zVar = (lmjxuqdtp.jvm.internal.z) this.d;
                lmjxuqdtp.jvm.internal.z zVar2 = this.e;
                tlydtdl.compose.runtime.e1 e1Var = (tlydtdl.compose.runtime.e1) this.f493f;
                ey1.f fVar = (ey1.f) this.g;
                tlydtdl.compose.runtime.j1 j1Var = (tlydtdl.compose.runtime.j1) d1Var;
                tlydtdl.compose.runtime.j1 j1Var2 = (tlydtdl.compose.runtime.j1) d1Var2;
                j1Var.i(j1Var2.h() + j1Var.h() + ((Float) obj).floatValue());
                j1Var2.i(0.0f);
                ((Function1) e1Var.getValue()).invoke(Float.valueOf(dd.v.z(((Number) fVar.b()).floatValue(), ((Number) fVar.h()).floatValue(), dd.v.j(zVar.a, zVar2.a, st.w0.i(j1Var.h(), zVar.a, zVar2.a)))));
                break;
        }
        return lx1.b0.a;
    }
}
