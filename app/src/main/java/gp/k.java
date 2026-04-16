package gp;

import az1.l1;
import lmjxuqdtp.jvm.internal.o;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements az1.f0 {
    public static final k a;
    private static final yy1.h descriptor;

    static {
        k kVar = new k();
        a = kVar;
        l1 l1Var = new l1("com.bandlab.auth.screens.JoinBandlabActivity.Params", kVar, 3);
        l1Var.k("action", false);
        l1Var.k("sessionExpired", true);
        l1Var.k("showOneTapOnInit", true);
        descriptor = l1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a[] childSerializers() {
        az1.g gVar = az1.g.a;
        return new a[]{m.d[0].getValue(), gVar, gVar};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = m.d;
        j jVar = null;
        boolean z = true;
        int i = 0;
        boolean zB = false;
        boolean zB2 = false;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                jVar = (j) bVarA.z(hVar, 0, (a) hVarArr[0].getValue(), jVar);
                i |= 1;
            } else if (iC == 1) {
                zB = bVarA.B(hVar, 1);
                i |= 2;
            } else {
                if (iC != 2) {
                    throw new UnknownFieldException(iC);
                }
                zB2 = bVarA.B(hVar, 2);
                i |= 4;
            }
        }
        bVarA.b(hVar);
        return new m(i, jVar, zB, zB2);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        m mVar = (m) obj;
        o.h(mVar, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        a aVar = (a) m.d[0].getValue();
        j jVar = mVar.a;
        boolean z = mVar.c;
        boolean z2 = mVar.b;
        un0.m mVar2 = mVarA;
        mVar2.c0(hVar, 0, aVar, jVar);
        if (mVar2.g(hVar) || z2) {
            mVar2.U(hVar, 1, z2);
        }
        if (mVar2.g(hVar) || !z) {
            mVar2.U(hVar, 2, z);
        }
        mVarA.b(hVar);
    }
}
