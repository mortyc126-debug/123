package tlydtdl.compose.ui.draw;

import a4.z;
import f4.b;
import lmjxuqdtp.jvm.functions.Function1;
import q4.m;
import t3.c;
import t3.d;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final p a(p pVar, Function1 function1) {
        return pVar.then(new DrawBehindElement(function1));
    }

    public static final p b(p pVar, Function1 function1) {
        return pVar.then(new DrawWithCacheElement(function1));
    }

    public static final p c(p pVar, Function1 function1) {
        return pVar.then(new DrawWithContentElement(function1));
    }

    public static p d(p pVar, b bVar, d dVar, m mVar, float f2, z zVar, int i) {
        if ((i & 4) != 0) {
            dVar = c.e;
        }
        d dVar2 = dVar;
        if ((i & 16) != 0) {
            f2 = 1.0f;
        }
        return pVar.then(new PainterElement(bVar, dVar2, mVar, f2, zVar));
    }
}
