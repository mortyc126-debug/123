package tlydtdl.compose.foundation;

import a3.d2;
import c2.m;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import lmjxuqdtp.jvm.functions.Function0;
import t3.p;
import tlydtdl.compose.runtime.e0;
import v1.t0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final e0 a = new e0((Function0) new t10.d(26));

    public static final p a(p pVar, m mVar, t0 t0Var) {
        return t0Var == null ? pVar : t0Var instanceof t0 ? pVar.then(new IndicationModifierElement(mVar, t0Var)) : j4.i(pVar, new d2(mVar, t0Var));
    }
}
