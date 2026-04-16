package cu;

import az1.f0;
import az1.l1;
import az1.m0;
import az1.p0;
import c40.z0;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.time.l;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements f0 {
    public static final g a;
    private static final yy1.h descriptor;

    static {
        g gVar = new g();
        a = gVar;
        l1 l1Var = new l1("com.bandlab.beat.api.quota.FreeBeatsQuota", gVar, 3);
        l1Var.k("remainingCount", true);
        l1Var.k("totalCount", true);
        l1Var.k("nextDate", true);
        l1Var.l(new z0(25));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        p0 p0Var = p0.a;
        return new wy1.a[]{by1.b.D(p0Var), by1.b.D(p0Var), by1.b.D(m0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Integer num = null;
        boolean z = true;
        int i = 0;
        Integer num2 = null;
        l lVar = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                num = (Integer) bVarA.E(hVar, 0, p0.a, num);
                i |= 1;
            } else if (iC == 1) {
                num2 = (Integer) bVarA.E(hVar, 1, p0.a, num2);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                lVar = (l) bVarA.E(hVar, 2, m0.a, lVar);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new i(i, num, num2, lVar);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        i iVar = (i) obj;
        o.h(iVar, "value");
        l lVar = iVar.c;
        Integer num = iVar.b;
        Integer num2 = iVar.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || num2 != null) {
            cVarA.p(hVar, 0, p0.a, num2);
        }
        if (cVarA.g(hVar) || num != null) {
            cVarA.p(hVar, 1, p0.a, num);
        }
        if (cVarA.g(hVar) || lVar != null) {
            cVarA.p(hVar, 2, m0.a, lVar);
        }
        cVarA.b(hVar);
    }
}
