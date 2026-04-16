package wl1;

import com.braze.vmsrhfaqrb.response.g;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ g b;

    public /* synthetic */ a(g gVar, int i) {
        this.a = i;
        this.b = gVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return g.a(this.b);
            default:
                return g.b(this.b);
        }
    }
}
