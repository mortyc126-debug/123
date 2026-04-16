package nu0;

import a4.a1;
import dd.v;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import md1.n0;
import t3.p;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.foundation.layout.x;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.e1;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;
import un0.q;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ c(int i, long j2, q3.k kVar, q3.k kVar2, p pVar) {
        this.c = kVar;
        this.d = kVar2;
        this.b = j2;
        this.e = pVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                q3.k kVar = (q3.k) this.c;
                q3.k kVar2 = (q3.k) this.d;
                p pVar = (p) this.e;
                ((Integer) obj2).getClass();
                v.i(a0.B(55), this.b, (m) obj, kVar, kVar2, pVar);
                break;
            default:
                un0.p pVar2 = (un0.p) this.c;
                q qVar = (q) this.d;
                e1 e1Var = (e1) this.e;
                m mVar = (m) obj;
                int iIntValue = ((Integer) obj2).intValue();
                s sVar = (s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    p pVarP = o2.p(x.a.b(t3.m.a, t3.c.e), vn0.e.d);
                    st.h hVar = pVar2.a;
                    boolean zG = sVar.g(pVar2);
                    Object objR = sVar.R();
                    if (zG || objR == tlydtdl.compose.runtime.l.a) {
                        objR = new t1.d(11, pVar2, e1Var);
                        sVar.q0(objR);
                    }
                    fe1.f.a(qVar.a, qVar.b, (a1) null, tlydtdl.compose.ui.platform.a.a(md1.g.w(pVarP, false, (Function0) null, (Function0) objR, hVar, 7), "TrackItemTags.TRACK_ICON"), (t3.d) null, (q4.m) null, 0.0f, new a4.q(this.b, 5), (Function0) null, false, (n0) null, (fe1.j) null, (fe1.g) null, false, (Function3) null, vn0.c.a, sVar, 384, 196608, 32624);
                } else {
                    sVar.Z();
                }
                break;
        }
        return b0.a;
    }

    public /* synthetic */ c(un0.p pVar, q qVar, long j2, e1 e1Var) {
        this.c = pVar;
        this.d = qVar;
        this.b = j2;
        this.e = e1Var;
    }
}
