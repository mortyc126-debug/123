package gp;

import az1.l1;
import lmjxuqdtp.jvm.internal.o;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements az1.f0 {
    public static final c a;
    private static final yy1.h descriptor;

    static {
        c cVar = new c();
        a = cVar;
        l1 l1Var = new l1("com.bandlab.auth.screens.JoinBandlabActivity.JoinBLAction.Login", cVar, 1);
        l1Var.k("authRequest", false);
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        return new a[]{bp.e.a};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        bp.g gVar = null;
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
                gVar = (bp.g) bVarA.z(hVar, 0, bp.e.a, gVar);
                i = 1;
            }
        }
        bVarA.b(hVar);
        return new e(i, gVar);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        e eVar2 = (e) obj;
        o.h(eVar2, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        mVarA.c0(hVar, 0, bp.e.a, eVar2.a);
        mVarA.b(hVar);
    }
}
