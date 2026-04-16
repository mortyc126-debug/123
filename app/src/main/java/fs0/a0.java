package fs0;

import a4.w0;
import com.facebook.appevents.l;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import ld1.r;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import q4.u0;
import t3.p;
import tlydtdl.compose.foundation.layout.o2;
import tlydtdl.compose.runtime.u1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements Function2 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function0 d;

    public /* synthetic */ a0(Function0 function0, Function0 function02, boolean z) {
        this.b = z;
        this.c = function0;
        this.d = function02;
    }

    public final Object invoke(Object obj, Object obj2) {
        tlydtdl.compose.runtime.m mVar = (tlydtdl.compose.runtime.m) obj;
        Integer num = (Integer) obj2;
        switch (this.a) {
            case 0:
                num.getClass();
                a.o(this.b, this.c, this.d, mVar, tlydtdl.compose.runtime.a0.B(1));
                break;
            default:
                int iIntValue = num.intValue();
                tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
                if (sVar.W(iIntValue & 1, (iIntValue & 3) != 2)) {
                    if (this.b) {
                        sVar.f0(-727426560);
                        p pVarE = tlydtdl.compose.foundation.layout.m.E(l.o(o2.e(t3.m.a, 1.0f), i.e(2131100884, 0, sVar, r.Companion), w0.a), 16, 12);
                        u0 u0VarD = tlydtdl.compose.foundation.layout.s.d(t3.c.e, false);
                        int iHashCode = Long.hashCode(sVar.T);
                        u1 u1VarM = sVar.m();
                        p pVarX = j4.x(sVar, pVarE);
                        s4.l.f436d2.getClass();
                        s4.j jVar = s4.k.b;
                        sVar.j0();
                        if (sVar.S) {
                            sVar.l(jVar);
                        } else {
                            sVar.t0();
                        }
                        tlydtdl.compose.runtime.a0.y(sVar, u0VarD, s4.k.f435f);
                        tlydtdl.compose.runtime.a0.y(sVar, u1VarM, s4.k.e);
                        s4.i iVar = s4.k.g;
                        if (sVar.S || !lmjxuqdtp.jvm.internal.o.c(sVar.R(), Integer.valueOf(iHashCode))) {
                            i.x(iHashCode, sVar, iHashCode, iVar);
                        }
                        tlydtdl.compose.runtime.a0.y(sVar, pVarX, s4.k.d);
                        m8.d.i(this.c, this.d, sVar, 0);
                        sVar.r(true);
                    } else {
                        sVar.f0(-729947821);
                    }
                    sVar.r(false);
                } else {
                    sVar.Z();
                }
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ a0(boolean z, Function0 function0, Function0 function02, int i) {
        this.b = z;
        this.c = function0;
        this.d = function02;
    }
}
