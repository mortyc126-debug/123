package mf1;

import java.util.List;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import lmjxuqdtp.jvm.functions.Function3;
import lmjxuqdtp.jvm.functions.Function4;
import lx1.b0;
import nc0.n;
import t3.p;
import tlydtdl.compose.foundation.layout.e2;
import tlydtdl.compose.runtime.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Function2 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function3 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f331f;
    public final /* synthetic */ Object g;
    public final /* synthetic */ Object h;
    public final /* synthetic */ Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ lx1.e f332j;

    public /* synthetic */ j(int i, n nVar, int i2, Function0 function0, q3.k kVar, Function2 function2, Function3 function3, Function3 function32, int i3) {
        this.b = i;
        this.g = nVar;
        this.c = i2;
        this.d = function0;
        this.h = kVar;
        this.i = function2;
        this.e = function3;
        this.f332j = function32;
        this.f331f = i3;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                ((Integer) obj2).getClass();
                aq1.b.g((List) this.g, this.b, (p) this.h, (e2) this.i, this.d, this.e, this.f332j, (tlydtdl.compose.runtime.m) obj, a0.B(this.c | 1), this.f331f);
                break;
            default:
                ((Integer) obj2).getClass();
                rw0.b.c(this.b, (n) this.g, this.c, this.d, (q3.k) this.h, (Function2) this.i, this.e, this.f332j, (tlydtdl.compose.runtime.m) obj, a0.B(this.f331f | 1));
                break;
        }
        return b0.a;
    }

    public /* synthetic */ j(List list, int i, p pVar, e2 e2Var, Function0 function0, Function3 function3, Function4 function4, int i2, int i3) {
        this.g = list;
        this.b = i;
        this.h = pVar;
        this.i = e2Var;
        this.d = function0;
        this.e = function3;
        this.f332j = function4;
        this.c = i2;
        this.f331f = i3;
    }
}
