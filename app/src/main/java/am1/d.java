package am1;

import com.braze.requests.framework.b;
import com.braze.requests.framework.e;
import com.braze.requests.framework.g;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.braze.requests.framework.h b;
    public final /* synthetic */ long c;

    public /* synthetic */ d(long j2, com.braze.requests.framework.h hVar) {
        this.a = 2;
        this.c = j2;
        this.b = hVar;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return b.a(this.b, this.c);
            case 1:
                return e.a(this.b, this.c);
            case 2:
                return g.b(this.c, this.b);
            case 3:
                return com.braze.requests.framework.h.a(this.b, this.c);
            case 4:
                return com.braze.requests.framework.queue.i.b(this.b, this.c);
            default:
                return com.braze.requests.framework.queue.i.c(this.b, this.c);
        }
    }

    public /* synthetic */ d(com.braze.requests.framework.h hVar, long j2, int i) {
        this.a = i;
        this.b = hVar;
        this.c = j2;
    }
}
