package tlydtdl.compose.foundation.layout;

import java.util.ArrayList;
import lmjxuqdtp.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c3 implements Function1 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f484f;

    public /* synthetic */ c3(d3 d3Var, int i, q4.m1 m1Var, int i2, q4.w0 w0Var) {
        this.d = d3Var;
        this.b = i;
        this.e = m1Var;
        this.c = i2;
        this.f484f = w0Var;
    }

    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                d3 d3Var = (d3) this.d;
                q4.m1 m1Var = (q4.m1) this.e;
                q4.l1.l((q4.l1) obj, m1Var, ((p5.k) d3Var.c.invoke(new p5.m((((long) (this.b - m1Var.a)) << 32) | (((long) (this.c - m1Var.b)) & 4294967295L)), ((q4.w0) this.f484f).getLayoutDirection())).a);
                return lx1.b0.a;
            default:
                sf1.e eVar = (sf1.e) this.d;
                ArrayList arrayList = (ArrayList) this.e;
                ArrayList arrayList2 = (ArrayList) this.f484f;
                q4.l1 l1Var = (q4.l1) obj;
                lmjxuqdtp.jvm.internal.o.h(l1Var, "$this$layout");
                float fG = eVar.a.g();
                int i = 0;
                for (Object obj2 : arrayList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        ct1.b.X();
                        throw null;
                    }
                    q4.m1 m1Var2 = (q4.m1) obj2;
                    Object obj3 = arrayList2.get(i);
                    if (obj3 instanceof sf1.f) {
                        q4.l1.m(l1Var, m1Var2, 0, -by1.b.P((1 - fG) * (this.b - this.c) * ((sf1.f) obj3).a));
                    } else {
                        q4.l1.m(l1Var, m1Var2, 0, 0);
                    }
                    i = i2;
                }
                return lx1.b0.a;
        }
    }

    public /* synthetic */ c3(sf1.e eVar, ArrayList arrayList, ArrayList arrayList2, int i, int i2, q4.w0 w0Var, int i3, int i4) {
        this.d = eVar;
        this.e = arrayList;
        this.f484f = arrayList2;
        this.b = i3;
        this.c = i4;
    }
}
