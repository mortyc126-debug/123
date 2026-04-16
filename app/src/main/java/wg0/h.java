package wg0;

import az1.f0;
import az1.l1;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements f0 {
    public static final h a;
    private static final yy1.h descriptor;

    static {
        h hVar = new h();
        a = hVar;
        l1 l1Var = new l1("com.bandlab.mixeditor.ai.tools.voice.transfer.ui.VoiceTransferState.Error", hVar, 2);
        l1Var.k("message", false);
        l1Var.k("canRetry", false);
        descriptor = l1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a[] childSerializers() {
        return new a[]{j.c[0].getValue(), az1.g.a};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = j.c;
        x10.v vVar = null;
        boolean z = true;
        int i = 0;
        boolean zB = false;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else if (iC == 0) {
                vVar = (x10.v) bVarA.z(hVar, 0, (a) hVarArr[0].getValue(), vVar);
                i |= 1;
            } else {
                if (iC != 1) {
                    throw new UnknownFieldException(iC);
                }
                zB = bVarA.B(hVar, 1);
                i |= 2;
            }
        }
        bVarA.b(hVar);
        return new j(i, vVar, zB);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        j jVar = (j) obj;
        lmjxuqdtp.jvm.internal.o.h(jVar, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        un0.m mVar = mVarA;
        mVar.c0(hVar, 0, (a) j.c[0].getValue(), jVar.a);
        mVar.U(hVar, 1, jVar.b);
        mVarA.b(hVar);
    }
}
