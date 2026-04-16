package js0;

import a80.p;
import az1.f0;
import az1.l1;
import az1.w0;
import az1.y1;
import by1.b;
import lmjxuqdtp.jvm.internal.o;
import s71.b1;
import s71.d1;
import un0.m;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import y11.l2;
import y11.q2;
import y11.s2;
import yy1.h;
import z11.c;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements f0 {
    public static final r a;
    private static final h descriptor;

    static {
        r rVar = new r();
        a = rVar;
        l1 l1Var = new l1("com.bandlab.mixeditor.state.MixEditorState", rVar, 8);
        l1Var.k("revisionStamp", false);
        l1Var.k("revision", false);
        l1Var.k("selectedTrackId", true);
        l1Var.k("playPosition", true);
        l1Var.k("metronomeEnabled", true);
        l1Var.k("cycleState", true);
        l1Var.k("projectOrigin", true);
        l1Var.k("contentMetadata", true);
        l1Var.l(new p(16));
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        lx1.h[] hVarArr = t.i;
        a aVar = y1.a;
        return new a[]{aVar, q2.a, b.D(aVar), w0.a, az1.g.a, b.D(c.a), b.D((a) hVarArr[6].getValue()), b.D(b1.a)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        lx1.h[] hVarArr = t.i;
        z11.e eVar = null;
        String strA = null;
        s2 s2Var = null;
        String str = null;
        long jL = 0;
        boolean z = true;
        int i = 0;
        boolean zB = false;
        l2 l2Var = null;
        d1 d1Var = null;
        while (z) {
            int iC = bVarA.C(hVar);
            switch (iC) {
                case -1:
                    z = false;
                    break;
                case 0:
                    strA = bVarA.A(hVar, 0);
                    i |= 1;
                    break;
                case 1:
                    s2Var = (s2) bVarA.z(hVar, 1, q2.a, s2Var);
                    i |= 2;
                    break;
                case 2:
                    str = (String) bVarA.E(hVar, 2, y1.a, str);
                    i |= 4;
                    break;
                case 3:
                    jL = bVarA.l(hVar, 3);
                    i |= 8;
                    break;
                case 4:
                    zB = bVarA.B(hVar, 4);
                    i |= 16;
                    break;
                case 5:
                    eVar = (z11.e) bVarA.E(hVar, 5, c.a, eVar);
                    i |= 32;
                    break;
                case 6:
                    l2Var = (l2) bVarA.E(hVar, 6, (a) hVarArr[6].getValue(), l2Var);
                    i |= 64;
                    break;
                case 7:
                    d1Var = (d1) bVarA.E(hVar, 7, b1.a, d1Var);
                    i |= 128;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new t(i, strA, s2Var, str, jL, zB, eVar, l2Var, d1Var);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        t tVar = (t) obj;
        o.h(tVar, "value");
        h hVar = descriptor;
        m mVarA = eVar.a(hVar);
        lx1.h[] hVarArr = t.i;
        String str = tVar.a;
        d1 d1Var = tVar.h;
        l2 l2Var = tVar.g;
        z11.e eVar2 = tVar.f;
        boolean z = tVar.e;
        long j2 = tVar.d;
        String str2 = tVar.c;
        m mVar = mVarA;
        mVar.d0(hVar, 0, str);
        mVar.c0(hVar, 1, q2.a, tVar.b);
        if (mVar.g(hVar) || str2 != null) {
            mVar.p(hVar, 2, y1.a, str2);
        }
        if (mVar.g(hVar) || j2 != 0) {
            mVar.a0(hVar, 3, j2);
        }
        if (mVar.g(hVar) || z) {
            mVar.U(hVar, 4, z);
        }
        if (mVar.g(hVar) || eVar2 != null) {
            mVar.p(hVar, 5, c.a, eVar2);
        }
        if (mVar.g(hVar) || l2Var != null) {
            mVar.p(hVar, 6, (a) hVarArr[6].getValue(), l2Var);
        }
        if (mVar.g(hVar) || d1Var != null) {
            mVar.p(hVar, 7, b1.a, d1Var);
        }
        mVarA.b(hVar);
    }
}
