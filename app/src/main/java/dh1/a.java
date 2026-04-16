package dh1;

import a80.p;
import az1.f0;
import az1.l1;
import by1.b;
import java.util.List;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements f0 {
    public static final a a;
    private static final yy1.h descriptor;

    static {
        a aVar = new a();
        a = aVar;
        l1 l1Var = new l1("com.bandlab.user.vmsrhfaqrb.CollabPreferencesLookingFor", aVar, 4);
        l1Var.k("skills", true);
        l1Var.k("genres", true);
        l1Var.k("inspiredBy", true);
        l1Var.k("place", true);
        l1Var.l(new p(4));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        lx1.h[] hVarArr = c.e;
        return new wy1.a[]{b.D((wy1.a) hVarArr[0].getValue()), b.D((wy1.a) hVarArr[1].getValue()), b.D((wy1.a) hVarArr[2].getValue()), b.D(d.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = c.e;
        int i = 0;
        List list = null;
        List list2 = null;
        List list3 = null;
        f fVar = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                list = (List) bVarA.E(hVar, 0, (wy1.a) hVarArr[0].getValue(), list);
                i |= 1;
            } else if (iC == 1) {
                list2 = (List) bVarA.E(hVar, 1, (wy1.a) hVarArr[1].getValue(), list2);
                i |= 2;
            } else if (iC == 2) {
                list3 = (List) bVarA.E(hVar, 2, (wy1.a) hVarArr[2].getValue(), list3);
                i |= 4;
            } else {
                if (iC != 3) {
                    throw new UnknownFieldException(iC);
                }
                fVar = (f) bVarA.E(hVar, 3, d.a, fVar);
                i |= 8;
            }
        }
        bVarA.b(hVar);
        return new c(i, list, list2, list3, fVar);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        c cVar = (c) obj;
        lmjxuqdtp.jvm.internal.o.h(cVar, "value");
        f fVar = cVar.d;
        List list = cVar.c;
        List list2 = cVar.b;
        List list3 = cVar.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        lx1.h[] hVarArr = c.e;
        if (cVarA.g(hVar) || list3 != null) {
            cVarA.p(hVar, 0, (wy1.a) hVarArr[0].getValue(), list3);
        }
        if (cVarA.g(hVar) || list2 != null) {
            cVarA.p(hVar, 1, (wy1.a) hVarArr[1].getValue(), list2);
        }
        if (cVarA.g(hVar) || list != null) {
            cVarA.p(hVar, 2, (wy1.a) hVarArr[2].getValue(), list);
        }
        if (cVarA.g(hVar) || fVar != null) {
            cVarA.p(hVar, 3, d.a, fVar);
        }
        cVarA.b(hVar);
    }
}
