package wm;

import az1.l1;
import az1.y1;
import lmjxuqdtp.jvm.internal.o;
import so0.k;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements az1.f0 {
    public static final r a;
    private static final h descriptor;

    static {
        r rVar = new r();
        a = rVar;
        l1 l1Var = new l1("com.bandlab.audiopack.api.MediaUrls", rVar, 1);
        l1Var.k("m4a", false);
        l1Var.l(new k(8));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(y1.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        String str = null;
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
                str = (String) bVarA.E(hVar, 0, y1.a, str);
                i = 1;
            }
        }
        bVarA.b(hVar);
        return new t(i, str);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        t tVar = (t) obj;
        o.h(tVar, "value");
        h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        cVarA.p(hVar, 0, y1.a, tVar.a);
        cVarA.b(hVar);
    }
}
