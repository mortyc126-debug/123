package tlydtdl.compose.foundation.layout;

import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function2 {
    public final /* synthetic */ int a;
    public final /* synthetic */ t3.g b;

    public /* synthetic */ c(t3.g gVar, int i) {
        this.a = i;
        this.b = gVar;
    }

    public final Object invoke(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return Integer.valueOf(this.b.a(0, ((Integer) obj).intValue()));
            default:
                return new p5.k((((long) this.b.a(0, (int) (((p5.m) obj).a & 4294967295L))) & 4294967295L) | (((long) 0) << 32));
        }
    }
}
