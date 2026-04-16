package s4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {
    public t3.o a;
    public int b;
    public k3.e c;
    public k3.e d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ dl.c f428f;

    public e1(dl.c cVar, t3.o oVar, int i, k3.e eVar, k3.e eVar2, boolean z) {
        this.f428f = cVar;
        this.a = oVar;
        this.b = i;
        this.c = eVar;
        this.d = eVar2;
        this.e = z;
    }

    public final boolean a(int i, int i2) {
        k3.e eVar = this.c;
        int i3 = this.b;
        t3.n nVar = (t3.n) eVar.a[i + i3];
        t3.n nVar2 = (t3.n) this.d.a[i3 + i2];
        return lmjxuqdtp.jvm.internal.o.c(nVar, nVar2) || nVar.getClass() == nVar2.getClass();
    }
}
