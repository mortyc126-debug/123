package tlydtdl.compose.foundation.lazy.layout;

import dd.v;
import he1.i;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import t3.p;
import tlydtdl.compose.foundation.layout.f2;
import w90.c0;
import w90.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v0 implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f509f;

    public /* synthetic */ v0(i iVar, q3.k kVar, p pVar, int i, int i2) {
        this.a = 1;
        this.e = iVar;
        this.b = kVar;
        this.f509f = pVar;
        this.c = i;
        this.d = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                m.e(this.e, this.c, (w0) this.f509f, (q3.k) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                v.b((i) this.e, (q3.k) this.b, (p) this.f509f, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
            case 2:
                ((Integer) obj2).getClass();
                iu.c.c((iu.b) this.e, (p) this.f509f, (f2) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
            case 3:
                ((Integer) obj2).getClass();
                pe1.g.a((u00.a) this.e, (p) this.f509f, (i2.a0) this.b, this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.d | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                es1.c.i((x10.v) this.e, (p) this.f509f, (of1.n) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
            case 5:
                ((Integer) obj2).getClass();
                w90.g.g((z) this.e, (w90.k) this.f509f, (p) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
            case 6:
                ((Integer) obj2).getClass();
                cd.i0.k((c0) this.e, (w90.k) this.f509f, (p) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
            case 7:
                ((Integer) obj2).getClass();
                com.facebook.appevents.p.e((we1.h) this.e, (p) this.f509f, (Function3) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
            default:
                ((Integer) obj2).getClass();
                com.facebook.appevents.l.b((x20.k) this.e, (p) this.f509f, (String) this.b, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.c | 1), this.d);
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ v0(Object obj, int i, w0 w0Var, q3.k kVar, int i2) {
        this.a = 0;
        this.e = obj;
        this.c = i;
        this.f509f = w0Var;
        this.b = kVar;
        this.d = i2;
    }

    public /* synthetic */ v0(Object obj, Object obj2, Object obj3, int i, int i2, int i3) {
        this.a = i3;
        this.e = obj;
        this.f509f = obj2;
        this.b = obj3;
        this.c = i;
        this.d = i2;
    }
}
