package tlydtdl.compose.ui.layout;

import okhttp3.internal.ws.WebSocketProtocol;
import q1.z;
import q4.i2;
import q4.j2;
import q4.t;
import q4.u;
import q4.y1;
import s4.p0;
import t3.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final z a;
    public static final j2[] b;
    public static final z c;

    static {
        z zVar = new z(8);
        j2.a.getClass();
        j2 j2Var = i2.g;
        zVar.h(1, j2Var);
        j2 j2Var2 = i2.f;
        zVar.h(2, j2Var2);
        j2 j2Var3 = i2.b;
        zVar.h(4, j2Var3);
        j2 j2Var4 = i2.d;
        zVar.h(8, j2Var4);
        j2 j2Var5 = i2.h;
        zVar.h(16, j2Var5);
        j2 j2Var6 = i2.e;
        zVar.h(32, j2Var6);
        j2 j2Var7 = i2.i;
        zVar.h(64, j2Var7);
        a = zVar;
        b = new j2[]{j2Var, j2Var2, j2Var3, j2Var7, j2Var5, j2Var6, j2Var4, i2.j, i2.c};
        z zVar2 = new z(7);
        zVar2.h(1, j2Var);
        zVar2.h(2, j2Var2);
        zVar2.h(4, j2Var3);
        zVar2.h(16, j2Var5);
        zVar2.h(64, j2Var7);
        zVar2.h(32, j2Var6);
        zVar2.h(8, j2Var4);
        c = zVar2;
    }

    public static final void a(p0 p0Var, t tVar, long j2, int i, int i2) {
        if (y1.f(j2, -1L)) {
            return;
        }
        float f2 = (int) ((j2 >>> 48) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        float f3 = (int) ((j2 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        float f4 = i - ((int) ((j2 >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        float f5 = i2 - ((int) (j2 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        p0Var.b(tVar.b(), f2);
        p0Var.b(tVar.d(), f3);
        p0Var.b(tVar.c(), f4);
        p0Var.b(tVar.a(), f5);
    }

    public static final p b(u uVar) {
        return new RulerProviderModifierElement(uVar);
    }
}
