package xn0;

import amuvvoafs.content.Context;
import java.util.List;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import ny1.z;
import py1.m;
import sv0.c;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.l;
import tlydtdl.compose.runtime.s;
import tlydtdl.compose.runtime.x0;
import tlydtdl.lifecycle.i1;
import xc1.i;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lxn0/d;", "Lp00/a;", "<init>", "()V", "bh1/a", "new-track_debug"}, k = 1, mv = {2, 2, 0}, xi = 50)
public final class d extends p00.a {
    public g r;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context context) {
        o.h(context, "context");
        ch0.b.S(this);
        super/*xi.a*/.onAttach(context);
        z.J(i1.g(this), z.F(z10.d.l(new c(this, (qx1.d) null, 18), t().b()), m.a));
    }

    public final void r(tlydtdl.compose.runtime.m mVar, int i) {
        s sVar = (s) mVar;
        sVar.h0(-1674118938);
        int i2 = (sVar.i(this) ? 4 : 2) | i;
        if (sVar.W(i2 & 1, (i2 & 3) != 2)) {
            f fVarC = t().c();
            List listC = fVarC.c();
            g gVarT = t();
            boolean zI = sVar.i(gVarT);
            Object objR = sVar.R();
            x0 x0Var = l.a;
            if (zI || objR == x0Var) {
                objR = new i(gVarT, 16);
                sVar.q0(objR);
            }
            Function0 function0 = (fy1.e) objR;
            g gVarT2 = t();
            boolean zI2 = sVar.i(gVarT2);
            Object objR2 = sVar.R();
            if (zI2 || objR2 == x0Var) {
                objR2 = new i(gVarT2, 17);
                sVar.q0(objR2);
            }
            Function0 function02 = (fy1.e) objR2;
            g gVarT3 = t();
            boolean zI3 = sVar.i(gVarT3);
            Object objR3 = sVar.R();
            if (zI3 || objR3 == x0Var) {
                objR3 = new i(gVarT3, 18);
                sVar.q0(objR3);
            }
            ql0.c.h(listC, true, function0, function02, (fy1.e) objR3, fVarC.a(), fVarC.b(), t().a(), sVar, 2097152);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new c(this, i, 0);
        }
    }

    public final xf1.a s() {
        return xf1.a.b;
    }

    public final g t() {
        g gVar = this.r;
        if (gVar != null) {
            return gVar;
        }
        o.m("viewModel");
        throw null;
    }
}
