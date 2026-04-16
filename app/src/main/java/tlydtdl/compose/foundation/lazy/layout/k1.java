package tlydtdl.compose.foundation.lazy.layout;

import a2.o3;
import a2.q3;
import java.util.Map;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import okhttp3.internal.ws.WebSocketProtocol;
import r3.i;
import tlydtdl.compose.runtime.a2;
import tlydtdl.compose.runtime.g3;
import tlydtdl.compose.runtime.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements r3.g, r3.c {
    public final r3.h a;
    public final r3.c b;
    public final q1.o0 c;

    public k1(r3.g gVar, Map map, r3.c cVar) {
        o3 o3Var = new o3(7, gVar);
        g3 g3Var = i.a;
        this.a = new r3.h(map, o3Var);
        this.b = cVar;
        q1.o0 o0Var = q1.w0.a;
        this.c = new q1.o0();
    }

    public final r3.f a(String str, Function0 function0) {
        return this.a.a(str, function0);
    }

    public final void b(Object obj) {
        this.b.b(obj);
    }

    public final void c(Object obj, q3.k kVar, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        s sVar = (s) mVar;
        sVar.h0(-858296452);
        if ((i & 6) == 0) {
            i2 = (sVar.i(obj) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.i(kVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.i(this) ? 256 : 128;
        }
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            this.b.c(obj, kVar, sVar, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            boolean zI = sVar.i(this) | sVar.i(obj);
            Object objR = sVar.R();
            if (zI || objR == tlydtdl.compose.runtime.l.a) {
                objR = new q3(5, this, obj);
                sVar.q0(objR);
            }
            tlydtdl.compose.runtime.a0.d(obj, (Function1) objR, sVar);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new h0(i, 1, this, obj, kVar);
        }
    }

    public final boolean d(Object obj) {
        return this.a.d(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map e() {
        /*
            r14 = this;
            q1.o0 r0 = r14.c
            java.lang.Object[] r1 = r0.b
            long[] r0 = r0.a
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L47
            r3 = 0
            r4 = r3
        Ld:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L42
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L27:
            if (r9 >= r7) goto L40
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3c
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            r3.c r11 = r14.b
            r11.b(r10)
        L3c:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L27
        L40:
            if (r7 != r8) goto L47
        L42:
            if (r4 == r2) goto L47
            int r4 = r4 + 1
            goto Ld
        L47:
            r3.h r0 = r14.a
            java.util.Map r0 = r0.e()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.k1.e():java.util.Map");
    }

    public final Object f(String str) {
        return this.a.f(str);
    }
}
