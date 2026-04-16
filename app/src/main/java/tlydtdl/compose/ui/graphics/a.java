package tlydtdl.compose.ui.graphics;

import a4.a1;
import a4.f1;
import a4.i0;
import a4.w0;
import lmjxuqdtp.jvm.functions.Function1;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a(p pVar, Function1 function1) {
        return pVar.then(new BlockGraphicsLayerElement(function1));
    }

    public static p b(p pVar, float f2, float f3, float f4, float f5, a1 a1Var, int i) {
        float f7 = (i & 1) != 0 ? 1.0f : f2;
        float f8 = (i & 2) != 0 ? 1.0f : f3;
        float f9 = (i & 4) != 0 ? 1.0f : f4;
        float f10 = (i & 32) != 0 ? 0.0f : f5;
        long j2 = f1.b;
        a1 a1Var2 = (i & 2048) != 0 ? w0.a : a1Var;
        long j3 = i0.a;
        return pVar.then(new GraphicsLayerElement(f7, f8, f9, 0.0f, f10, 0.0f, j2, a1Var2, false, j3, j3, 0));
    }

    public static p c(p pVar, float f2, float f3, float f4, float f5, float f7, a1 a1Var, int i) {
        float f8 = (i & 1) != 0 ? 1.0f : f2;
        float f9 = (i & 2) != 0 ? 1.0f : f3;
        float f10 = (i & 4) != 0 ? 1.0f : f4;
        float f12 = (i & 16) != 0 ? 0.0f : f5;
        float f13 = (i & 256) != 0 ? 0.0f : f7;
        long j2 = f1.b;
        a1 a1Var2 = (i & 2048) != 0 ? w0.a : a1Var;
        boolean z = (i & 4096) == 0;
        long j3 = i0.a;
        return pVar.then(new GraphicsLayerElement(f8, f9, f10, f12, 0.0f, f13, j2, a1Var2, z, j3, j3, (i & 65536) != 0 ? 0 : 1));
    }
}
