package wm;

import az1.l1;
import az1.p0;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import so0.k;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m0 implements az1.f0 {
    public static final m0 a;
    private static final h descriptor;

    static {
        m0 m0Var = new m0();
        a = m0Var;
        l1 l1Var = new l1("com.bandlab.audiopack.api.WaveformData", m0Var, 2);
        l1Var.k("maxValue", true);
        l1Var.k("values", false);
        l1Var.l(new k(8));
        descriptor = l1Var;
    }

    public final wy1.a[] childSerializers() {
        return new wy1.a[]{p0.a, by1.b.D((wy1.a) o0.a()[1].getValue())};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArrA = o0.a();
        List list = null;
        boolean z = true;
        int i = 0;
        int iD = 0;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                iD = bVarA.d(hVar, 0);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                list = (List) bVarA.E(hVar, 1, (wy1.a) hVarArrA[1].getValue(), list);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new o0(list, i, iD);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(e eVar, Object obj) {
        o0 o0Var = (o0) obj;
        o.h(o0Var, "value");
        h hVar = descriptor;
        zy1.c cVarA = eVar.a(hVar);
        o0.b(o0Var, cVarA, hVar);
        cVarA.b(hVar);
    }
}
