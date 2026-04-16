package jv0;

import az1.f0;
import az1.l1;
import az1.y1;
import m10.h0;
import m10.j0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements f0 {
    public static final i a;
    private static final yy1.h descriptor;

    static {
        i iVar = new i();
        a = iVar;
        l1 l1Var = new l1("com.bandlab.network.vmsrhfaqrb.Image", iVar, 2);
        l1Var.k("id", false);
        l1Var.k("picture", false);
        l1Var.l(new a80.p(17));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{y1.a, by1.b.D(h0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String strA = null;
        boolean z = true;
        int i = 0;
        j0 j0Var = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                strA = bVarA.A(hVar, 0);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                j0Var = (j0) bVarA.E(hVar, 1, h0.a, j0Var);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new k(i, strA, j0Var);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        k kVar = (k) obj;
        lmjxuqdtp.jvm.internal.o.h(kVar, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        un0.m mVar = mVarA;
        mVar.d0(hVar, 0, kVar.a);
        mVar.p(hVar, 1, h0.a, kVar.b);
        mVarA.b(hVar);
    }
}
