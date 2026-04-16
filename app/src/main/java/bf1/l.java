package bf1;

import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;
import lx1.b0;
import t3.p;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.m;
import un0.n;
import un0.o;
import vn0.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Function2 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ p b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f26f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;

    public /* synthetic */ l(p pVar, boolean z, o oVar, n nVar, boolean z2, int i, int i2) {
        this.b = pVar;
        this.c = z;
        this.g = oVar;
        this.h = nVar;
        this.d = z2;
        this.e = i;
        this.f26f = i2;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                com.facebook.appevents.p.f(this.c, (Function1) this.g, this.b, (k) this.h, this.d, (m) obj, a0.B(this.e | 1), this.f26f);
                break;
            default:
                ((Integer) obj2).getClass();
                a.a(this.b, this.c, (o) this.g, (n) this.h, this.d, (m) obj, a0.B(this.e | 1), this.f26f);
                break;
        }
        return b0.a;
    }

    public /* synthetic */ l(boolean z, Function1 function1, p pVar, k kVar, boolean z2, int i, int i2) {
        this.c = z;
        this.g = function1;
        this.b = pVar;
        this.h = kVar;
        this.d = z2;
        this.e = i;
        this.f26f = i2;
    }
}
