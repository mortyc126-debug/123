package e80;

import gt.b;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ a b;

    public /* synthetic */ c(a aVar, int i) {
        this.a = i;
        this.b = aVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return Integer.valueOf(this.b.a.a.size());
            default:
                return Boolean.valueOf(this.b.d == b.f);
        }
    }
}
