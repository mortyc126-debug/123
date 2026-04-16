package r30;

import az1.f0;
import az1.l1;
import az1.y1;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements f0 {
    public static final c a;
    private static final yy1.h descriptor;

    static {
        c cVar = new c();
        a = cVar;
        l1 l1Var = new l1("com.bandlab.createtab.CreateTabPage.Param", cVar, 2);
        l1Var.k("bandId", true);
        l1Var.k("collaborators", true);
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(y1.a), by1.b.D((wy1.a) e.c[1].getValue())};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = e.c;
        String str = null;
        boolean z = true;
        int i = 0;
        List list = null;
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
                list = (List) bVarA.E(hVar, 1, (wy1.a) hVarArr[1].getValue(), list);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new e(str, list, i);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        e eVar2 = (e) obj;
        o.h(eVar2, "value");
        List list = eVar2.b;
        String str = eVar2.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        lx1.h[] hVarArr = e.c;
        if (cVarA.g(hVar) || str != null) {
            cVarA.p(hVar, 0, y1.a, str);
        }
        if (cVarA.g(hVar) || list != null) {
            cVarA.p(hVar, 1, (wy1.a) hVarArr[1].getValue(), list);
        }
        cVarA.b(hVar);
    }
}
