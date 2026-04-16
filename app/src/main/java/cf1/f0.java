package cf1;

import cq1.d;
import dg1.g;
import fs0.a;
import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Function2 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f34f;
    public final /* synthetic */ Object g;

    public /* synthetic */ f0(g0 g0Var, tlydtdl.compose.foundation.layout.w wVar, l0 l0Var, k kVar, boolean z, int i) {
        this.d = g0Var;
        this.e = wVar;
        this.f34f = l0Var;
        this.g = kVar;
        this.c = z;
        this.b = i;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).intValue();
                ((g0) this.d).b((tlydtdl.compose.foundation.layout.w) this.e, (l0) this.f34f, (k) this.g, this.c, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.b | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                int iB = tlydtdl.compose.runtime.a0.B(24577);
                a.l((x10.r) this.d, this.b, (Function1) this.e, (ey1.k) this.f34f, (Function1) this.g, this.c, (tlydtdl.compose.runtime.m) obj, iB);
                break;
            case 2:
                ((Integer) obj2).getClass();
                lu0.m.h((g) this.d, this.c, (Function0) this.e, (t3.p) this.f34f, (String) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.b | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                d.a((Function0) this.d, (List) this.e, (Function1) this.f34f, this.c, (wp.r) this.g, (tlydtdl.compose.runtime.m) obj, tlydtdl.compose.runtime.a0.B(this.b | 1));
                break;
        }
        return lx1.b0.a;
    }

    public /* synthetic */ f0(g gVar, boolean z, Function0 function0, t3.p pVar, String str, int i) {
        this.d = gVar;
        this.c = z;
        this.e = function0;
        this.f34f = pVar;
        this.g = str;
        this.b = i;
    }

    public /* synthetic */ f0(Function0 function0, List list, Function1 function1, boolean z, wp.r rVar, int i) {
        this.d = function0;
        this.e = list;
        this.f34f = function1;
        this.c = z;
        this.g = rVar;
        this.b = i;
    }

    public /* synthetic */ f0(x10.r rVar, int i, Function1 function1, ey1.k kVar, Function1 function12, boolean z, int i2) {
        this.d = rVar;
        this.b = i;
        this.e = function1;
        this.f34f = kVar;
        this.g = function12;
        this.c = z;
    }
}
