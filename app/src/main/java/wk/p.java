package wk;

import az1.f0;
import az1.l1;
import az1.p0;
import so0.k;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements f0 {
    public static final p a;
    private static final yy1.h descriptor;

    static {
        p pVar = new p();
        a = pVar;
        l1 l1Var = new l1("com.bandlab.audio.controller.api.smartCompose.SmartComposeRemainingTokensDTO", pVar, 1);
        l1Var.k("remaining", false);
        l1Var.l(new k(7));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{by1.b.D(p0.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        Integer num = null;
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
                num = (Integer) bVarA.E(hVar, 0, p0.a, num);
                i = 1;
            }
        }
        bVarA.b(hVar);
        return new r(i, num);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        r rVar = (r) obj;
        lmjxuqdtp.jvm.internal.o.h(rVar, "value");
        yy1.h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        cVarA.p(hVar, 0, p0.a, rVar.a);
        cVarA.b(hVar);
    }
}
