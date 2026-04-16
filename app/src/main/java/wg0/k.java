package wg0;

import az1.f0;
import az1.l1;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements f0 {
    public static final k a;
    private static final yy1.h descriptor;

    static {
        k kVar = new k();
        a = kVar;
        l1 l1Var = new l1("com.bandlab.mixeditor.ai.tools.voice.transfer.ui.VoiceTransferState.Loading", kVar, 1);
        l1Var.k("showApplyForWholeTrackSkeleton", false);
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        return new a[]{az1.g.a};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        boolean z = true;
        int i = 0;
        boolean zB = false;
        while (z) {
            int iC = bVarA.C(hVar);
            if (iC == -1) {
                z = false;
            } else {
                if (iC != 0) {
                    throw new UnknownFieldException(iC);
                }
                zB = bVarA.B(hVar, 0);
                i = 1;
            }
        }
        bVarA.b(hVar);
        return new m(i, zB);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        m mVar = (m) obj;
        lmjxuqdtp.jvm.internal.o.h(mVar, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        mVarA.U(hVar, 0, mVar.a);
        mVarA.b(hVar);
    }
}
