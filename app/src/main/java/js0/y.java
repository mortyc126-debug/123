package js0;

import az1.f0;
import az1.l1;
import az1.p0;
import az1.y1;
import by1.b;
import lmjxuqdtp.jvm.internal.o;
import un0.m;
import wy1.a;
import xwfkdfdvbiz.serialization.UnknownFieldException;
import yy1.h;
import zy1.d;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements f0 {
    public static final y a;
    private static final h descriptor;

    static {
        y yVar = new y();
        a = yVar;
        l1 l1Var = new l1("com.bandlab.mixeditor.state.SongStarterMixEditorLoadingDelegate.IdeaParams", yVar, 6);
        l1Var.k("revisionId", false);
        l1Var.k("midiId", false);
        l1Var.k("lyric", false);
        l1Var.k("key", false);
        l1Var.k("bpm", false);
        l1Var.k("projectName", false);
        descriptor = l1Var;
    }

    public final a[] childSerializers() {
        a aVar = y1.a;
        return new a[]{aVar, aVar, b.D(aVar), b.D(aVar), b.D(p0.a), b.D(aVar)};
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: xwfkdfdvbiz.serialization.UnknownFieldException */
    public final Object deserialize(d dVar) throws UnknownFieldException {
        h hVar = descriptor;
        zy1.b bVarA = dVar.a(hVar);
        int i = 0;
        String strA = null;
        String strA2 = null;
        String str = null;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        boolean z = true;
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
                    strA2 = bVarA.A(hVar, 1);
                    i |= 2;
                    break;
                case 2:
                    str = (String) bVarA.E(hVar, 2, y1.a, str);
                    i |= 4;
                    break;
                case 3:
                    str2 = (String) bVarA.E(hVar, 3, y1.a, str2);
                    i |= 8;
                    break;
                case 4:
                    num = (Integer) bVarA.E(hVar, 4, p0.a, num);
                    i |= 16;
                    break;
                case 5:
                    str3 = (String) bVarA.E(hVar, 5, y1.a, str3);
                    i |= 32;
                    break;
                default:
                    throw new UnknownFieldException(iC);
            }
        }
        bVarA.b(hVar);
        return new a0(i, strA, strA2, str, str2, num, str3);
    }

    public final h getDescriptor() {
        return descriptor;
    }

    public final void serialize(zy1.e eVar, Object obj) {
        a0 a0Var = (a0) obj;
        o.h(a0Var, "value");
        h hVar = descriptor;
        m mVarA = eVar.a(hVar);
        m mVar = mVarA;
        mVar.d0(hVar, 0, a0Var.a);
        mVar.d0(hVar, 1, a0Var.b);
        y1 y1Var = y1.a;
        mVar.p(hVar, 2, y1Var, a0Var.c);
        mVar.p(hVar, 3, y1Var, a0Var.d);
        mVar.p(hVar, 4, p0.a, a0Var.e);
        mVar.p(hVar, 5, y1Var, a0Var.f244f);
        mVarA.b(hVar);
    }
}
