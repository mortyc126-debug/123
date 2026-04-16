package so;

import az1.f0;
import az1.l1;
import az1.w0;
import az1.y1;
import lmjxuqdtp.jvm.internal.o;
import m10.t0;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements f0 {
    public static final a a;
    private static final h descriptor;

    static {
        a aVar = new a();
        a = aVar;
        l1 l1Var = new l1("com.bandlab.auth.auth.utils.JWTDecoder.AuthPayload", aVar, 2);
        l1Var.k("iat", false);
        l1Var.k("sub", false);
        l1Var.l(new t0(29));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(w0.a), by1.b.D(y1.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Long l = null;
        boolean z = true;
        int i = 0;
        String str = null;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                l = (Long) bVarA.E(hVar, 0, w0.a, l);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                str = (String) bVarA.E(hVar, 1, y1.a, str);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new c(i, l, str);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        c cVar = (c) obj;
        o.h(cVar, "value");
        h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        cVarA.p(hVar, 0, w0.a, cVar.a);
        cVarA.p(hVar, 1, y1.a, cVar.b);
        cVarA.b(hVar);
    }
}
