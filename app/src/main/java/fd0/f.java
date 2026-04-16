package fd0;

import a21.a0;
import a21.e;
import com.bandlab.audiocore.generated.MasteringData;
import com.bandlab.audiocore.generated.MasteringService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import s02.d;
import w2.u;
import x11.g;
import x11.h;
import y11.d2;
import y11.o1;
import y11.r1;
import y11.x1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements qn0.a {
    public final b a;
    public final dd.b b;

    public f(b bVar, dd.b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // qn0.a
    public final e a(e eVar) throws NoWhenBranchMatchedException {
        o.h(eVar, "revision");
        r1 r1Var = eVar.i;
        if (r1Var == null) {
            return eVar;
        }
        d dVarB = b(r1Var);
        if (dVarB instanceof d) {
            return e.a(eVar, (String) null, (List) null, (String) null, (Map) null, (LinkedHashMap) null, (String) null, (d2) null, (o1) null, dVarB.a(), 0.0d, (ArrayList) null, (a0) null, 7935);
        }
        if (!dVarB.equals(c.a)) {
            throw new NoWhenBranchMatchedException();
        }
        d.a.getClass();
        s02.b.r("Mastering:: Failed to migrate " + r1Var);
        return eVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final e b(r1 r1Var) throws NoWhenBranchMatchedException {
        r1 r1VarG;
        o.h(r1Var, "data");
        String str = r1Var.c;
        x11.f fVarQ = this.a.a.q(str);
        if (fVarQ.equals(g.a)) {
            return new d(r1Var);
        }
        if ((fVarQ instanceof h) || (fVarQ instanceof x11.e)) {
            d.a.getClass();
            s02.b.r("Mastering:: AC failed to migrate from " + str + " - unsupported version");
        } else {
            if (!(fVarQ instanceof x11.f)) {
                throw new NoWhenBranchMatchedException();
            }
            if (fVarQ.a) {
                MasteringData masteringDataF = kp1.e.F(r1Var);
                u uVar = (u) this.b.b;
                x11.d dVarE = uVar.e();
                x1 x1VarB = uVar.b();
                x11.d dVarD = uVar.d();
                if (x1VarB.compareTo(dVarE) < 0) {
                    throw new IllegalStateException("Engine feature version shouldn't be less than UI model version");
                }
                String string = ((x11.d) by1.b.L(dVarE, dVarD)).a.toString();
                MasteringData masteringDataMigrateAutomatically = MasteringService.migrateAutomatically(masteringDataF, string);
                if (masteringDataMigrateAutomatically == null) {
                    d.a.getClass();
                    s02.b.r("Mastering:: AC failed to auto migrate from " + str + " to " + string);
                    r1VarG = null;
                } else {
                    r1VarG = kp1.e.G(masteringDataMigrateAutomatically);
                }
                if (r1VarG != null) {
                    return new d(r1VarG);
                }
            }
        }
        return c.a;
    }
}
