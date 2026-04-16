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
public final /* synthetic */ class g implements f0 {
    public static final g a;
    private static final yy1.h descriptor;

    static {
        g gVar = new g();
        a = gVar;
        l1 l1Var = new l1("com.bandlab.user.vmsrhfaqrb.FirstTimeUXFlags", gVar, 9);
        l1Var.k("confirmedEmail", true);
        l1Var.k("createdSong", true);
        l1Var.k("createdBand", true);
        l1Var.k("setPicture", true);
        l1Var.k("setCustomUsername", true);
        l1Var.k("setSkills", true);
        l1Var.k("setGenres", true);
        l1Var.k("setInspiredBy", true);
        l1Var.k("usedStudio", true);
        l1Var.l(new p(5));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        az1.g gVar = az1.g.a;
        return new wy1.a[]{b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar), b.D(gVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        Boolean bool6 = null;
        Boolean bool7 = null;
        Boolean bool8 = null;
        Boolean bool9 = null;
        int i = 0;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    bool = (Boolean) bVarA.E(hVar, 0, az1.g.a, bool);
                    i |= 1;
                    break;
                case 1:
                    bool2 = (Boolean) bVarA.E(hVar, 1, az1.g.a, bool2);
                    i |= 2;
                    break;
                case 2:
                    bool3 = (Boolean) bVarA.E(hVar, 2, az1.g.a, bool3);
                    i |= 4;
                    break;
                case 3:
                    bool4 = (Boolean) bVarA.E(hVar, 3, az1.g.a, bool4);
                    i |= 8;
                    break;
                case 4:
                    bool5 = (Boolean) bVarA.E(hVar, 4, az1.g.a, bool5);
                    i |= 16;
                    break;
                case 5:
                    bool6 = (Boolean) bVarA.E(hVar, 5, az1.g.a, bool6);
                    i |= 32;
                    break;
                case 6:
                    bool7 = (Boolean) bVarA.E(hVar, 6, az1.g.a, bool7);
                    i |= 64;
                    break;
                case 7:
                    bool8 = (Boolean) bVarA.E(hVar, 7, az1.g.a, bool8);
                    i |= 128;
                    break;
                case 8:
                    bool9 = (Boolean) bVarA.E(hVar, 8, az1.g.a, bool9);
                    i |= 256;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new i(i, bool, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        i iVar = (i) obj;
        lmjxuqdtp.jvm.internal.o.h(iVar, "value");
        Boolean bool = iVar.i;
        Boolean bool2 = iVar.h;
        Boolean bool3 = iVar.g;
        Boolean bool4 = iVar.f86f;
        Boolean bool5 = iVar.e;
        Boolean bool6 = iVar.d;
        Boolean bool7 = iVar.c;
        Boolean bool8 = iVar.b;
        Boolean bool9 = iVar.a;
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        if (cVarA.g(hVar) || bool9 != null) {
            cVarA.p(hVar, 0, az1.g.a, bool9);
        }
        if (cVarA.g(hVar) || bool8 != null) {
            cVarA.p(hVar, 1, az1.g.a, bool8);
        }
        if (cVarA.g(hVar) || bool7 != null) {
            cVarA.p(hVar, 2, az1.g.a, bool7);
        }
        if (cVarA.g(hVar) || bool6 != null) {
            cVarA.p(hVar, 3, az1.g.a, bool6);
        }
        if (cVarA.g(hVar) || bool5 != null) {
            cVarA.p(hVar, 4, az1.g.a, bool5);
        }
        if (cVarA.g(hVar) || bool4 != null) {
            cVarA.p(hVar, 5, az1.g.a, bool4);
        }
        if (cVarA.g(hVar) || bool3 != null) {
            cVarA.p(hVar, 6, az1.g.a, bool3);
        }
        if (cVarA.g(hVar) || bool2 != null) {
            cVarA.p(hVar, 7, az1.g.a, bool2);
        }
        if (cVarA.g(hVar) || bool != null) {
            cVarA.p(hVar, 8, az1.g.a, bool);
        }
        cVarA.b(hVar);
    }
}
