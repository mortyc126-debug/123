package oz0;

import az1.l1;
import by1.b;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements az1.f0 {
    public static final c0 a;
    private static final yy1.h descriptor;

    static {
        c0 c0Var = new c0();
        a = c0Var;
        l1 l1Var = new l1("com.bandlab.post.objects.AlbumTrack.Permissions", c0Var, 2);
        l1Var.k("edit", true);
        l1Var.k("master", true);
        l1Var.l(new m10.t0(12));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        az1.g gVar = az1.g.a;
        return new a[]{b.D(gVar), b.D(gVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Boolean bool = null;
        boolean z = true;
        int i = 0;
        Boolean bool2 = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                bool = (Boolean) bVarA.E(hVar, 0, az1.g.a, bool);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                bool2 = (Boolean) bVarA.E(hVar, 1, az1.g.a, bool2);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new e0(i, bool, bool2);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        e0 e0Var = (e0) obj;
        lmjxuqdtp.jvm.internal.o.h(e0Var, "value");
        Boolean bool = e0Var.b;
        Boolean bool2 = e0Var.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || bool2 != null) {
            cVarA.p(hVar, 0, az1.g.a, bool2);
        }
        if (cVarA.g(hVar) || bool != null) {
            cVarA.p(hVar, 1, az1.g.a, bool);
        }
        cVarA.b(hVar);
    }
}
