package fz0;

import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function0;
import o10.a4;
import oz0.d1;
import zs.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ ep0.e b;

    public /* synthetic */ d(ep0.e eVar, int i) {
        this.a = i;
        this.b = eVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object invoke() throws NoWhenBranchMatchedException {
        String str;
        String str2;
        int iOrdinal;
        switch (this.a) {
            case 0:
                ep0.e eVar = this.b;
                eVar.d((d1) eVar.j);
                break;
            case 1:
                ep0.e eVar2 = this.b;
                vu0.c cVar = ((d1) eVar2.j).s;
                if (cVar != null && (str = cVar.a) != null) {
                    ((xu0.p) eVar2.e).e(((zs.j) eVar2.g).a(str, (r20.i) null, new r20.f0((a4) eVar2.k)));
                }
                return lx1.b0.a;
            case 2:
                ep0.e eVar3 = this.b;
                m1 m1Var = (m1) eVar3.h;
                xu0.p pVar = (xu0.p) eVar3.e;
                d1 d1Var = (d1) eVar3.j;
                m10.f fVar = d1Var.e;
                if (fVar != null && (str2 = fVar.a) != null && (iOrdinal = ((b) eVar3.c).k.ordinal()) != 0) {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        pVar.e(m1.c(m1Var, str2, (oh1.f) null, lh1.a.v, (q10.h0) null, (lx1.l) null, 54));
                    } else if (!lmjxuqdtp.jvm.internal.o.c(d1Var.B, Boolean.TRUE)) {
                        pVar.e(m1.c(m1Var, str2, (oh1.f) null, lh1.a.v, (q10.h0) null, (lx1.l) null, 54));
                    }
                }
                return lx1.b0.a;
            default:
                ep0.e eVar4 = this.b;
                eVar4.d((d1) eVar4.j);
                break;
        }
        return lx1.b0.a;
    }
}
