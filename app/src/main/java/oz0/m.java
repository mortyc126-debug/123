package oz0;

import az1.l1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements az1.f0 {
    public static final m a;
    private static final yy1.h descriptor;

    static {
        m mVar = new m();
        a = mVar;
        l1 l1Var = new l1("com.bandlab.post.objects.AlbumPermissions", mVar, 3);
        l1Var.k("purchase", false);
        l1Var.k("delete", false);
        l1Var.k("edit", false);
        l1Var.l(new m10.t0(10));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        az1.g gVar = az1.g.a;
        return new a[]{b.D(gVar), b.D(gVar), b.D(gVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Boolean bool = null;
        boolean z = true;
        int i = 0;
        Boolean bool2 = null;
        Boolean bool3 = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                bool = (Boolean) bVarA.E(hVar, 0, az1.g.a, bool);
                i |= 1;
            } else if (iC == 1) {
                bool2 = (Boolean) bVarA.E(hVar, 1, az1.g.a, bool2);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                bool3 = (Boolean) bVarA.E(hVar, 2, az1.g.a, bool3);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new o(i, bool, bool2, bool3);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        o oVar = (o) obj;
        lmjxuqdtp.jvm.internal.o.h(oVar, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        az1.g gVar = az1.g.a;
        cVarA.p(hVar, 0, gVar, oVar.a);
        cVarA.p(hVar, 1, gVar, oVar.b);
        cVarA.p(hVar, 2, gVar, oVar.c);
        cVarA.b(hVar);
    }
}
