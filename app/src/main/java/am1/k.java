package am1;

import com.braze.events.internal.o;
import com.braze.managers.b0;
import com.braze.requests.framework.g;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ o b;

    public /* synthetic */ k(o oVar, int i) {
        this.a = i;
        this.b = oVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return g.a(this.b);
            default:
                return b0.a(this.b);
        }
    }
}
