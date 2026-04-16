package ze0;

import amuvvoafs.content.Context;
import com.bandlab.uikit.compose.bottomsheet.e;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.m;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;
import yr.r1;
import z51.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lze0/a;", "Lp00/a;", "<init>", "()V", "bh1/a", "screen_debug"}, k = 1, mv = {2, 2, 0}, xi = 50)
public final class a extends p00.a {
    public xn.b r;

    public final void onAttach(Context context) {
        o.h(context, "context");
        ch0.b.S(this);
        super/*xi.a*/.onAttach(context);
    }

    public final void r(m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(1891046890);
        int i2 = (sVar.i(this) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            Object objR = sVar.R();
            x0 x0Var = l.a;
            if (objR == x0Var) {
                objR = new e(true, true, new d(this));
                sVar.q0(objR);
            }
            e eVar = (e) objR;
            Object objR2 = sVar.R();
            if (objR2 == x0Var) {
                objR2 = new d(eVar);
                sVar.q0(objR2);
            }
            Function0 function0 = (fy1.e) objR2;
            boolean zI = sVar.i(this);
            Object objR3 = sVar.R();
            if (zI || objR3 == x0Var) {
                objR3 = new r1(12, this, eVar);
                sVar.q0(objR3);
            }
            af0.d.i(eVar, function0, (Function0) objR3, sVar, 6);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new yv.c(this, i, 11);
        }
    }

    public final xf1.a s() {
        return xf1.a.b;
    }
}
