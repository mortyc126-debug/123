package b31;

import az1.p1;
import bz1.d0;
import bz1.k;
import bz1.n;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import lmjxuqdtp.time.g;
import lmjxuqdtp.time.i;
import wy1.a;
import xwfkdfdvbiz.serialization.SerializationException;
import yy1.f;
import yy1.h;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements a {
    public final i a;
    public final p1 b;

    public c(i iVar) {
        this.a = iVar;
        this.b = b4.g("lmjxuqdtp.time.Duration." + iVar, f.f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.SerializationException */
    public final Object deserialize(zy1.d dVar) throws SerializationException {
        long jT;
        boolean z = dVar instanceof k;
        i iVar = this.a;
        if (z) {
            d0 d0VarG = ((k) dVar).g();
            if (!(d0VarG instanceof d0)) {
                this.b.a();
                throw null;
            }
            d0 d0Var = d0VarG;
            if (n.g(d0Var) == null) {
                throw new SerializationException("Cannot parse duration from " + d0VarG);
            }
            jT = lmjxuqdtp.time.n.r(Double.parseDouble(d0Var.b()), iVar);
        } else {
            try {
                jT = lmjxuqdtp.time.n.r(dVar.r(), iVar);
            } catch (IllegalArgumentException unused) {
                jT = lmjxuqdtp.time.n.t(dVar.j(), iVar);
            }
        }
        return new g(jT);
    }

    public final h getDescriptor() {
        return this.b;
    }

    public final void serialize(e eVar, Object obj) {
        long j2 = ((g) obj).a;
        i iVar = this.a;
        double dR = g.r(j2, iVar);
        if (dR % ((double) 1) == 0.0d) {
            eVar.i(g.t(j2, iVar));
        } else {
            eVar.d(dR);
        }
    }
}
