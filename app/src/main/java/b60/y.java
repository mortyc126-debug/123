package b60;

import com.bandlab.bandlab.utils.debug.DebugUtils;
import java.util.List;
import jv0.p;
import ky1.a0;
import lg.e;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function3;
import lx1.b0;
import qx1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends sx1.i implements Function3 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public /* synthetic */ h f23j;
    public /* synthetic */ p k;
    public final /* synthetic */ z l;
    public final /* synthetic */ a0 m;
    public final /* synthetic */ qi.y n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, a0 a0Var, qi.y yVar, d dVar) {
        super(3, dVar);
        this.l = zVar;
        this.m = a0Var;
        this.n = yVar;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        a0 a0Var = this.m;
        qi.y yVar = this.n;
        y yVar2 = new y(this.l, a0Var, yVar, (d) obj3);
        yVar2.f23j = (h) obj;
        yVar2.k = (p) obj2;
        return yVar2.invokeSuspend(b0.a);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invokeSuspend(Object obj) throws NoWhenBranchMatchedException {
        e eVar;
        h hVar = this.f23j;
        p pVar = this.k;
        rx1.a aVar = rx1.a.a;
        e.O(obj);
        if (hVar == null) {
            return null;
        }
        List list = hVar.b;
        z zVar = this.l;
        e eVarB = z.b(zVar, pVar, list);
        if (eVarB != null) {
            eVar = (e) DebugUtils.alsoDebugThrowIfNull(eVarB, "Easter egg link not found, links: " + list, new String[0]);
        } else {
            eVar = null;
        }
        return new c60.h((d10.j) zVar.g, (oy1.k) zVar.i, hVar.c, new w(this.m, this.n, hVar, zVar, eVar != null ? eVar.b() : null, eVar));
    }
}
