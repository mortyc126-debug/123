package gp;

import az1.l1;
import lmjxuqdtp.jvm.internal.o;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements az1.f0 {
    public static final a0 a;
    private static final yy1.h descriptor;

    static {
        a0 a0Var = new a0();
        a = a0Var;
        l1 l1Var = new l1("com.bandlab.auth.screens.JoinBandlabDestination.AgeVerificationScreen", a0Var, 1);
        l1Var.k("signupInfo", false);
        descriptor = l1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a[] childSerializers() {
        return new a[]{c0.b[0].getValue()};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = c0.b;
        pp.q qVar = null;
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
                qVar = (pp.q) bVarA.z(hVar, 0, (a) hVarArr[0].getValue(), qVar);
                i = 1;
            }
        }
        bVarA.b(hVar);
        return new c0(i, qVar);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        c0 c0Var = (c0) obj;
        o.h(c0Var, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        mVarA.c0(hVar, 0, (a) c0.b[0].getValue(), c0Var.a);
        mVarA.b(hVar);
    }
}
