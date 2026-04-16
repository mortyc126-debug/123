package gp;

import az1.l1;
import az1.y1;
import lmjxuqdtp.jvm.internal.o;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j0 implements az1.f0 {
    public static final j0 a;
    private static final yy1.h descriptor;

    static {
        j0 j0Var = new j0();
        a = j0Var;
        l1 l1Var = new l1("com.bandlab.auth.screens.JoinBandlabDestination.ResetPasswordScreen", j0Var, 1);
        l1Var.k("email", true);
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        return new a[]{by1.b.D(y1.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
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
        return new l0(i, str);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        l0 l0Var = (l0) obj;
        o.h(l0Var, "value");
        String str = l0Var.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || str != null) {
            cVarA.p(hVar, 0, y1.a, str);
        }
        cVarA.b(hVar);
    }
}
