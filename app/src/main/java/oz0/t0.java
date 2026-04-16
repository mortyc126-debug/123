package oz0;

import az1.l1;
import by1.b;
import p10.l;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t0 implements az1.f0 {
    public static final t0 a;
    private static final yy1.h descriptor;

    static {
        t0 t0Var = new t0();
        a = t0Var;
        l1 l1Var = new l1("com.bandlab.post.objects.LinkEntity", t0Var, 4);
        l1Var.k("album", false);
        l1Var.k("revisionPost", false);
        l1Var.k("beat", false);
        l1Var.k("type", false);
        l1Var.l(new m10.t0(14));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        return new a[]{b.D(d.a), b.D(b1.a), b.D(p10.a.a), b.D((a) v0.e[3].getValue())};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = v0.e;
        int i = 0;
        i iVar = null;
        d1 d1Var = null;
        l lVar = null;
        x0 x0Var = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                iVar = (i) bVarA.E(hVar, 0, d.a, iVar);
                i |= 1;
            } else if (iC == 1) {
                d1Var = (d1) bVarA.E(hVar, 1, b1.a, d1Var);
                i |= 2;
            } else if (iC == 2) {
                lVar = (l) bVarA.E(hVar, 2, p10.a.a, lVar);
                i |= 4;
            } else {
                if (iC != 3) {
                    throw new UnknownFieldException(iC);
                }
                x0Var = (x0) bVarA.E(hVar, 3, (a) hVarArr[3].getValue(), x0Var);
                i |= 8;
            }
        }
        bVarA.b(hVar);
        return new v0(i, iVar, d1Var, lVar, x0Var);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        v0 v0Var = (v0) obj;
        lmjxuqdtp.jvm.internal.o.h(v0Var, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        lx1.h[] hVarArr = v0.e;
        cVarA.p(hVar, 0, d.a, v0Var.a);
        cVarA.p(hVar, 1, b1.a, v0Var.b);
        cVarA.p(hVar, 2, p10.a.a, v0Var.c);
        cVarA.p(hVar, 3, (a) hVarArr[3].getValue(), v0Var.d);
        cVarA.b(hVar);
    }
}
