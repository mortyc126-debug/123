package p10;

import az1.f0;
import az1.l1;
import az1.p0;
import lmjxuqdtp.jvm.internal.o;
import m10.j;
import m10.t0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements f0 {
    public static final f a;
    private static final h descriptor;

    static {
        f fVar = new f();
        a = fVar;
        l1 l1Var = new l1("com.bandlab.common.vmsrhfaqrb.beat.Beat.Sale", fVar, 3);
        l1Var.k("price", false);
        l1Var.k("offPercentage", false);
        l1Var.k("paymentProviderPriceIds", false);
        l1Var.l(new t0(20));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(j.a), by1.b.D(p0.a), by1.b.D(c.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        m10.l lVar = null;
        boolean z = true;
        int i = 0;
        Integer num = null;
        e eVar = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                lVar = (m10.l) bVarA.E(hVar, 0, j.a, lVar);
                i |= 1;
            } else if (iC == 1) {
                num = (Integer) bVarA.E(hVar, 1, p0.a, num);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                eVar = (e) bVarA.E(hVar, 2, c.a, eVar);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new h(i, lVar, num, eVar);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        h hVar = (h) obj;
        o.h(hVar, "value");
        h hVar2 = descriptor;
        zy1.c cVarA = eVar.a(hVar2);
        h.d(hVar, cVarA, hVar2);
        cVarA.b(hVar2);
    }
}
