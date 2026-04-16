package fz0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements ay0.j {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final void t(boolean z) {
        switch (this.a) {
            case 0:
                c0 c0Var = (c0) this.b;
                n10.f fVar = c0Var.k().C;
                c0Var.d.a(fVar != null ? fVar.f : null, c0Var.a.n, n10.a.e);
                break;
            case 1:
                h0 h0Var = (h0) this.b;
                dt.g gVar = h0Var.f143f;
                n10.f fVar2 = h0Var.a().C;
                gVar.a(fVar2 != null ? fVar2.f : null, h0Var.a.n, n10.a.e);
                break;
            default:
                gz0.b bVar = (gz0.b) this.b;
                wz0.y yVar = bVar.a;
                if (z) {
                    fy.a.k(bVar.b, mu0.u.s(yVar.e));
                }
                dt.g gVar2 = bVar.c;
                n10.f fVar3 = yVar.a.a.C;
                gVar2.a(fVar3 != null ? fVar3.f : null, yVar.n, n10.a.e);
                break;
        }
    }
}
