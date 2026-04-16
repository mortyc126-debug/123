package g4;

import okhttp3.HttpUrl;
import tlydtdl.compose.runtime.n1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends e0 {
    public final c b;
    public String c;
    public boolean d;
    public final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public lmjxuqdtp.jvm.internal.p f161f;
    public final n1 g;
    public a4.q h;
    public final n1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f162j;
    public float k;
    public float l;
    public final f0 m;

    public g0(c cVar) {
        this.b = cVar;
        cVar.i = new f0(this, 0);
        this.c = HttpUrl.FRAGMENT_ENCODE_SET;
        this.d = true;
        this.e = new a();
        this.f161f = h.e;
        this.g = tlydtdl.compose.runtime.a0.t(null);
        this.i = tlydtdl.compose.runtime.a0.t(new z3.e(0L));
        this.f162j = 9205357640488583168L;
        this.k = 1.0f;
        this.l = 1.0f;
        this.m = new f0(this, 1);
    }

    @Override // g4.e0
    public final void a(c4.d dVar) {
        e(dVar, 1.0f, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(c4.d r34, float r35, a4.z r36) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.g0.e(c4.d, float, a4.z):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Params: \tname: ");
        sb.append(this.c);
        sb.append("\n\tviewportWidth: ");
        n1 n1Var = this.i;
        sb.append(Float.intBitsToFloat((int) (((z3.e) n1Var.getValue()).a >> 32)));
        sb.append("\n\tviewportHeight: ");
        sb.append(Float.intBitsToFloat((int) (((z3.e) n1Var.getValue()).a & 4294967295L)));
        sb.append("\n");
        String string = sb.toString();
        lmjxuqdtp.jvm.internal.o.g(string, "toString(...)");
        return string;
    }
}
