package wg0;

import az1.f0;
import az1.l1;
import az1.p0;
import java.util.List;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements f0 {
    public static final n a;
    private static final yy1.h descriptor;

    static {
        n nVar = new n();
        a = nVar;
        l1 l1Var = new l1("com.bandlab.mixeditor.ai.tools.voice.transfer.ui.VoiceTransferState.Main", nVar, 6);
        l1Var.k("voices", false);
        l1Var.k("pitchSliderPosition", false);
        l1Var.k("pitchesCount", false);
        l1Var.k("showApplyForWholeTrack", false);
        l1Var.k("applyForWholeTrack", false);
        l1Var.k("voicesGenericPreview", false);
        descriptor = l1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a[] childSerializers() {
        az1.g gVar = az1.g.a;
        return new a[]{y.g[0].getValue(), a.a, p0.a, gVar, gVar, s.a};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(zy1.d dVar) throws UnknownFieldException {
        yy1.h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = y.g;
        int i = 0;
        int iD = 0;
        boolean zB = false;
        boolean zB2 = false;
        List list = null;
        c cVar = null;
        x xVar = null;
        boolean z = true;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    list = (List) bVarA.z(hVar, 0, (a) hVarArr[0].getValue(), list);
                    i |= 1;
                    break;
                case 1:
                    cVar = (c) bVarA.z(hVar, 1, a.a, cVar);
                    i |= 2;
                    break;
                case 2:
                    iD = bVarA.d(hVar, 2);
                    i |= 4;
                    break;
                case 3:
                    zB = bVarA.B(hVar, 3);
                    i |= 8;
                    break;
                case 4:
                    zB2 = bVarA.B(hVar, 4);
                    i |= 16;
                    break;
                case 5:
                    xVar = (x) bVarA.z(hVar, 5, s.a, xVar);
                    i |= 32;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new y(i, list, cVar, iD, zB, zB2, xVar);
    }

    public final yy1.h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        y yVar = (y) obj;
        lmjxuqdtp.jvm.internal.o.h(yVar, "value");
        yy1.h hVar = descriptor;
        un0.m mVarA = eVar.a(hVar);
        un0.m mVar = mVarA;
        mVar.c0(hVar, 0, (a) y.g[0].getValue(), yVar.a);
        mVar.c0(hVar, 1, a.a, new c(yVar.b));
        mVar.Z(2, yVar.c, hVar);
        mVar.U(hVar, 3, yVar.d);
        mVar.U(hVar, 4, yVar.e);
        mVar.c0(hVar, 5, s.a, yVar.f659f);
        mVarA.b(hVar);
    }
}
