package oz0;

import az1.l1;
import az1.y1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l0 implements az1.f0 {
    public static final l0 a;
    private static final yy1.h descriptor;

    static {
        l0 l0Var = new l0();
        a = l0Var;
        l1 l1Var = new l1("com.bandlab.post.objects.BandInfo", l0Var, 6);
        l1Var.k("id", false);
        l1Var.k("name", false);
        l1Var.k("username", false);
        l1Var.k("picture", false);
        l1Var.k("followingState", false);
        l1Var.k("isMember", false);
        l1Var.l(new m10.t0(13));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        lx1.h[] hVarArr = n0.g;
        a aVar = y1.a;
        return new a[]{aVar, b.D(aVar), b.D(aVar), b.D(m10.h0.a), b.D((a) hVarArr[4].getValue()), b.D(az1.g.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = n0.g;
        int i = 0;
        String strA = null;
        String str = null;
        String str2 = null;
        m10.j0 j0Var = null;
        q10.l0 l0Var = null;
        Boolean bool = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    strA = bVarA.A(hVar, 0);
                    i |= 1;
                    break;
                case 1:
                    str = (String) bVarA.E(hVar, 1, y1.a, str);
                    i |= 2;
                    break;
                case 2:
                    str2 = (String) bVarA.E(hVar, 2, y1.a, str2);
                    i |= 4;
                    break;
                case 3:
                    j0Var = (m10.j0) bVarA.E(hVar, 3, m10.h0.a, j0Var);
                    i |= 8;
                    break;
                case 4:
                    l0Var = (q10.l0) bVarA.E(hVar, 4, (a) hVarArr[4].getValue(), l0Var);
                    i |= 16;
                    break;
                case 5:
                    bool = (Boolean) bVarA.E(hVar, 5, az1.g.a, bool);
                    i |= 32;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new n0(i, strA, str, str2, j0Var, l0Var, bool);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        n0 n0Var = (n0) obj;
        lmjxuqdtp.jvm.internal.o.h(n0Var, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        lx1.h[] hVarArr = n0.g;
        un0.m mVar = mVarA;
        mVar.d0(hVar, 0, n0Var.a);
        y1 y1Var = y1.a;
        mVar.p(hVar, 1, y1Var, n0Var.b);
        mVar.p(hVar, 2, y1Var, n0Var.c);
        mVar.p(hVar, 3, m10.h0.a, n0Var.d);
        mVar.p(hVar, 4, (a) hVarArr[4].getValue(), n0Var.e);
        mVar.p(hVar, 5, az1.g.a, n0Var.f384f);
        mVarA.b(hVar);
    }
}
