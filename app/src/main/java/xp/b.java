package xp;

import az1.f0;
import az1.l1;
import az1.p0;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import so0.k;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements f0 {
    public static final b a;
    private static final h descriptor;

    static {
        b bVar = new b();
        a = bVar;
        l1 l1Var = new l1("com.bandlab.auth.validator.AgeRestrictionRequirement", bVar, 2);
        l1Var.k("extra_requirements", false);
        l1Var.k("age_limit", false);
        l1Var.l(new k(11));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D((wy1.a) d.c[0].getValue()), by1.b.D(p0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = d.c;
        List list = null;
        boolean z = true;
        int i = 0;
        Integer num = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                list = (List) bVarA.E(hVar, 0, (wy1.a) hVarArr[0].getValue(), list);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                num = (Integer) bVarA.E(hVar, 1, p0.a, num);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new d(i, num, list);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        d dVar = (d) obj;
        o.h(dVar, "value");
        h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        cVarA.p(hVar, 0, (wy1.a) d.c[0].getValue(), dVar.a);
        cVarA.p(hVar, 1, p0.a, dVar.b);
        cVarA.b(hVar);
    }
}
