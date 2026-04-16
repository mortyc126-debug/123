package p10;

import az1.f0;
import az1.g;
import az1.l1;
import az1.m0;
import lmjxuqdtp.jvm.internal.o;
import m10.t0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements f0 {
    public static final i a;
    private static final h descriptor;

    static {
        i iVar = new i();
        a = iVar;
        l1 l1Var = new l1("com.bandlab.common.vmsrhfaqrb.beat.Beat.SaleLimitation", iVar, 2);
        l1Var.k("onSale", false);
        l1Var.k("saleEnd", true);
        l1Var.l(new t0(20));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(g.a), by1.b.D(m0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Boolean bool = null;
        boolean z = true;
        int i = 0;
        lmjxuqdtp.time.l lVar = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                bool = (Boolean) bVarA.E(hVar, 0, g.a, bool);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                lVar = (lmjxuqdtp.time.l) bVarA.E(hVar, 1, m0.a, lVar);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new k(i, bool, lVar);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        k kVar = (k) obj;
        o.h(kVar, "value");
        h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        k.c(kVar, cVarA, hVar);
        cVarA.b(hVar);
    }
}
