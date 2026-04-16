package am1;

import com.braze.requests.framework.b;
import com.braze.requests.framework.g;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.braze.requests.framework.h b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(com.braze.requests.framework.h hVar, long j2, long j3, Object obj, int i) {
        this.a = i;
        this.b = hVar;
        this.c = j2;
        this.d = j3;
        this.e = obj;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return b.a(this.b, this.c, this.d, (com.braze.requests.util.d) this.e);
            default:
                return g.a(this.b, this.c, this.d, (g) this.e);
        }
    }
}
