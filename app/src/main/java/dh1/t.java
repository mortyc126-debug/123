package dh1;

import a80.p;
import az1.f0;
import az1.l1;
import by1.b;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements f0 {
    public static final t a;
    private static final yy1.h descriptor;

    static {
        t tVar = new t();
        a = tVar;
        l1 l1Var = new l1("com.bandlab.user.vmsrhfaqrb.User.Permissions", tVar, 4);
        l1Var.k("canCreateConversations", false);
        l1Var.k("canComment", false);
        l1Var.k("canInvite", false);
        l1Var.k("canFollow", false);
        l1Var.l(new p(8));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        az1.g gVar = az1.g.a;
        return new wy1.a[]{b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        int i = 0;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        boolean z = true;
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
            } else if (iC == 2) {
                bool3 = (Boolean) bVarA.E(hVar, 2, az1.g.a, bool3);
                i |= 4;
            } else {
                if (iC != 3) {
                    throw new UnknownFieldException(iC);
                }
                bool4 = (Boolean) bVarA.E(hVar, 3, az1.g.a, bool4);
                i |= 8;
            }
        }
        bVarA.b(hVar);
        return new v(i, bool, bool2, bool3, bool4);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        v vVar = (v) obj;
        lmjxuqdtp.jvm.internal.o.h(vVar, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        az1.g gVar = az1.g.a;
        cVarA.p(hVar, 0, gVar, vVar.a);
        cVarA.p(hVar, 1, gVar, vVar.b);
        cVarA.p(hVar, 2, gVar, vVar.c);
        cVarA.p(hVar, 3, gVar, vVar.d);
        cVarA.b(hVar);
    }
}
