package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ t3.f b;

    public /* synthetic */ b(t3.f fVar, int i) {
        this.a = i;
        this.b = fVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return Integer.valueOf(this.b.a(0, ((Integer) obj).intValue(), (p5.n) obj2));
            default:
                int i = (int) (((p5.m) obj).a >> 32);
                return new p5.k((((long) this.b.a(0, i, (p5.n) obj2)) << 32) | (((long) 0) & 4294967295L));
        }
    }
}
