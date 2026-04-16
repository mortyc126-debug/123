package dh1;

import a80.p;
import az1.f0;
import az1.l1;
import az1.y1;
import by1.b;
import m10.j0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements f0 {
    public static final l a;
    private static final yy1.h descriptor;

    static {
        l lVar = new l();
        a = lVar;
        l1 l1Var = new l1("com.bandlab.user.vmsrhfaqrb.InspiredArtist", lVar, 3);
        l1Var.k("id", false);
        l1Var.k("name", false);
        l1Var.k("picture", true);
        l1Var.l(new p(7));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        wy1.a aVar = y1.a;
        return new wy1.a[]{aVar, b.D(aVar), b.D(m10.h0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String strA = null;
        boolean z = true;
        int i = 0;
        String str = null;
        j0 j0Var = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                strA = bVarA.A(hVar, 0);
                i |= 1;
            } else if (iC == 1) {
                str = (String) bVarA.E(hVar, 1, y1.a, str);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                j0Var = (j0) bVarA.E(hVar, 2, m10.h0.a, j0Var);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new n(i, strA, str, j0Var);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        n nVar = (n) obj;
        lmjxuqdtp.jvm.internal.o.h(nVar, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        String str = nVar.a;
        j0 j0Var = nVar.c;
        un0.m mVar = mVarA;
        mVar.d0(hVar, 0, str);
        mVar.p(hVar, 1, y1.a, nVar.b);
        if (mVar.g(hVar) || j0Var != null) {
            mVar.p(hVar, 2, m10.h0.a, j0Var);
        }
        mVarA.b(hVar);
    }
}
