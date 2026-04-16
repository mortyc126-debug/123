package jv0;

import az1.f0;
import az1.l1;
import az1.y1;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.c;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements f0 {
    public static final l a;
    private static final yy1.h descriptor;

    static {
        l lVar = new l();
        a = lVar;
        l1 l1Var = new l1("com.bandlab.network.vmsrhfaqrb.Link", lVar, 4);
        l1Var.k("url", false);
        l1Var.k("title", true);
        l1Var.k("description", true);
        l1Var.k("image", true);
        l1Var.l(new a80.p(18));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        y1 y1Var = y1.a;
        return new wy1.a[]{by1.b.D(y1Var), by1.b.D(y1Var), by1.b.D(y1Var), by1.b.D(y1Var)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                str = (String) bVarA.E(hVar, 0, y1.a, str);
                i |= 1;
            } else if (iC == 1) {
                str2 = (String) bVarA.E(hVar, 1, y1.a, str2);
                i |= 2;
            } else if (iC == 2) {
                str3 = (String) bVarA.E(hVar, 2, y1.a, str3);
                i |= 4;
            } else {
                if (iC != 3) {
                    throw new UnknownFieldException(iC);
                }
                str4 = (String) bVarA.E(hVar, 3, y1.a, str4);
                i |= 8;
            }
        }
        bVarA.b(hVar);
        return new n(str, i, str2, str3, str4);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        n nVar = (n) obj;
        lmjxuqdtp.jvm.internal.o.h(nVar, "value");
        yy1.h hVar = descriptor;
        c cVarA = eVar.a(hVar);
        y1 y1Var = y1.a;
        String str = nVar.a;
        String str2 = nVar.d;
        String str3 = nVar.c;
        String str4 = nVar.b;
        cVarA.p(hVar, 0, y1Var, str);
        if (cVarA.g(hVar) || str4 != null) {
            cVarA.p(hVar, 1, y1Var, str4);
        }
        if (cVarA.g(hVar) || str3 != null) {
            cVarA.p(hVar, 2, y1Var, str3);
        }
        if (cVarA.g(hVar) || str2 != null) {
            cVarA.p(hVar, 3, y1Var, str2);
        }
        cVarA.b(hVar);
    }
}
