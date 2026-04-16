package oz0;

import az1.l1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t1 implements az1.f0 {
    public static final t1 a;
    private static final yy1.h descriptor;

    static {
        t1 t1Var = new t1();
        a = t1Var;
        l1 l1Var = new l1("com.bandlab.post.objects.PostRecommendationReason", t1Var, 2);
        l1Var.k("connectionUser", false);
        l1Var.k("action", false);
        l1Var.l(new m10.t0(18));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        return new a[]{b.D(dh1.r.a), b.D((a) x1.c[1].getValue())};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = x1.c;
        dh1.w wVar = null;
        boolean z = true;
        int i = 0;
        v1 v1Var = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                wVar = (dh1.w) bVarA.E(hVar, 0, dh1.r.a, wVar);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                v1Var = (v1) bVarA.E(hVar, 1, (a) hVarArr[1].getValue(), v1Var);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new x1(i, wVar, v1Var);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        x1 x1Var = (x1) obj;
        lmjxuqdtp.jvm.internal.o.h(x1Var, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        lx1.h[] hVarArr = x1.c;
        cVarA.p(hVar, 0, dh1.r.a, x1Var.a);
        cVarA.p(hVar, 1, (a) hVarArr[1].getValue(), x1Var.b);
        cVarA.b(hVar);
    }
}
