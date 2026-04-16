package x5;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends i {
    public int A0;
    public y5.b B0;
    public a6.e C0;
    public int s0;
    public int t0;
    public int u0;
    public int v0;
    public int w0;
    public int x0;
    public boolean y0;
    public int z0;

    @Override // x5.i
    public final void S() {
        for (int i = 0; i < this.r0; i++) {
            d dVar = this.q0[i];
            if (dVar != null) {
                dVar.F = true;
            }
        }
    }

    public final void T(int i, int i2, int i3, int i4, d dVar) {
        a6.e eVar;
        d dVar2;
        y5.b bVar = this.B0;
        while (true) {
            eVar = this.C0;
            if (eVar != null || (dVar2 = this.T) == null) {
                break;
            } else {
                this.C0 = ((e) dVar2).u0;
            }
        }
        bVar.a = i;
        bVar.b = i3;
        bVar.c = i2;
        bVar.d = i4;
        eVar.b(dVar, bVar);
        dVar.O(bVar.e);
        dVar.L(bVar.f700f);
        dVar.E = bVar.h;
        dVar.I(bVar.g);
    }
}
