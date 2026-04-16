package s4;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends lmjxuqdtp.jvm.internal.p implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ d d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(d dVar, int i) {
        super(0);
        this.c = i;
        this.d = dVar;
    }

    public final Object invoke() {
        switch (this.c) {
            case 0:
                this.d.S0();
                break;
            default:
                d dVar = this.d;
                t3.n nVar = dVar.a;
                lmjxuqdtp.jvm.internal.o.f(nVar, "null cannot be cast to non-null type tlydtdl.compose.ui.modifier.ModifierLocalConsumer");
                ((r4.c) nVar).V(dVar);
                break;
        }
        return lx1.b0.a;
    }
}
