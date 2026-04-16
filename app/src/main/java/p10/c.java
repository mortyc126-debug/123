package p10;

import az1.f0;
import az1.l1;
import az1.y1;
import lmjxuqdtp.jvm.internal.o;
import m10.t0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements f0 {
    public static final c a;
    private static final h descriptor;

    static {
        c cVar = new c();
        a = cVar;
        l1 l1Var = new l1("com.bandlab.common.vmsrhfaqrb.beat.Beat.PaymentProvider", cVar, 1);
        l1Var.k("googlePlayStore", true);
        l1Var.l(new t0(20));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(y1.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String str = null;
        boolean z = true;
        int i = 0;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else {
                if (iC != 0) {
                    throw new UnknownFieldException(iC);
                }
                str = (String) bVarA.E(hVar, 0, y1.a, str);
                i = 1;
            }
        }
        bVarA.b(hVar);
        return new e(i, str);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        e eVar2 = (e) obj;
        o.h(eVar2, "value");
        String str = eVar2.a;
        h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || str != null) {
            cVarA.p(hVar, 0, y1.a, str);
        }
        cVarA.b(hVar);
    }
}
