package bw;

import a2.p3;
import a4.z0;
import c4.d;
import d5.h0;
import h5.i;
import h5.p;
import h5.s;
import lmjxuqdtp.jvm.functions.Function1;
import lx1.b0;
import m2.n1;
import okhttp3.internal.ws.WebSocketProtocol;
import q3.k;
import tlydtdl.compose.runtime.f3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(long j2, Object obj, int i) {
        this.a = i;
        this.b = j2;
        this.c = obj;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                d dVar = (d) this.c;
                of1.c cVar = (of1.c) obj;
                lmjxuqdtp.jvm.internal.o.h(cVar, "$this$buildInlineContentTextRes");
                k kVar = new k(new p3(7, dVar), true, 704414818);
                long j2 = this.b;
                cVar.a("ICON_BEAT_PRICE", j2, j2, 7, kVar);
                break;
            case 1:
                f3 f3Var = (f3) this.c;
                d dVar2 = (d) obj;
                lmjxuqdtp.jvm.internal.o.h(dVar2, "$this$Canvas");
                d.s(dVar2, this.b, 0L, 0L, ((Number) f3Var.getValue()).floatValue(), (c4.h) null, 118);
                break;
            case 2:
                String str = (String) this.c;
                d5.d dVar3 = (d5.d) obj;
                lmjxuqdtp.jvm.internal.o.h(dVar3, "$this$buildAnnotatedTextRes");
                int iK = dVar3.k(new h0(this.b, 0L, (s) null, (h5.o) null, (p) null, (i) null, (String) null, 0L, (o5.a) null, (o5.p) null, (k5.b) null, 0L, (o5.l) null, (z0) null, 65534));
                try {
                    dVar3.f(str);
                } finally {
                    dVar3.h(iK);
                }
                break;
            default:
                n1 n1Var = (n1) this.c;
                d dVar4 = (d) obj;
                if (((Boolean) n1Var.s.getValue()).booleanValue() || ((Boolean) n1Var.t.getValue()).booleanValue()) {
                    d.s(dVar4, this.b, 0L, 0L, 0.0f, (c4.h) null, WebSocketProtocol.PAYLOAD_SHORT);
                }
                return b0.a;
        }
        return b0.a;
    }

    public /* synthetic */ c(n1 n1Var, long j2) {
        this.a = 3;
        this.c = n1Var;
        this.b = j2;
    }
}
