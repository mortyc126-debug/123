package am1;

import com.braze.requests.framework.g;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ g b;
    public final /* synthetic */ long c;

    public /* synthetic */ h(g gVar, long j2, int i) {
        this.a = i;
        this.b = gVar;
        this.c = j2;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return g.b(this.b, this.c);
            default:
                return g.a(this.b, this.c);
        }
    }
}
