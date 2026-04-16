package b60;

import a80.p;
import az1.f0;
import az1.l1;
import az1.y1;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.c;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements f0 {
    public static final i a;
    private static final yy1.h descriptor;

    static {
        i iVar = new i();
        a = iVar;
        l1 l1Var = new l1("com.bandlab.easter.impl.EasterEggAnimation", iVar, 2);
        l1Var.k("url", true);
        l1Var.k("json", true);
        l1Var.l(new p(2));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        y1 y1Var = y1.a;
        return new wy1.a[]{by1.b.D(y1Var), by1.b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String str = null;
        boolean z = true;
        int i = 0;
        String str2 = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                str = (String) bVarA.E(hVar, 0, y1.a, str);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                str2 = (String) bVarA.E(hVar, 1, y1.a, str2);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new k(i, str, str2);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        k kVar = (k) obj;
        lmjxuqdtp.jvm.internal.o.h(kVar, "value");
        String str = kVar.b;
        String str2 = kVar.a;
        yy1.h hVar = descriptor;
        c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || str2 != null) {
            cVarA.p(hVar, 0, y1.a, str2);
        }
        if (cVarA.g(hVar) || str != null) {
            cVarA.p(hVar, 1, y1.a, str);
        }
        cVarA.b(hVar);
    }
}
