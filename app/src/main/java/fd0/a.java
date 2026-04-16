package fd0;

import ak.u;
import jw1.e;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {
    public final /* synthetic */ int a;
    public final u b;

    public /* synthetic */ a(u uVar, int i) {
        this.a = i;
        this.b = uVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return new b((w2.u) this.b.invoke());
            default:
                return new dd.b(2, (w2.u) this.b.invoke());
        }
    }
}
