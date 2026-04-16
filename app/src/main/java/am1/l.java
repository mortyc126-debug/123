package am1;

import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ com.braze.requests.framework.h b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;

    public /* synthetic */ l(com.braze.requests.framework.h hVar, long j2, com.braze.requests.framework.h hVar2) {
        this.b = hVar;
        this.c = j2;
        this.d = hVar2;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return com.braze.requests.framework.h.a(this.b, (com.braze.requests.framework.i) this.d, this.c);
            default:
                return com.braze.requests.framework.queue.c.a(this.b, this.c, (com.braze.requests.framework.h) this.d);
        }
    }

    public /* synthetic */ l(com.braze.requests.framework.h hVar, com.braze.requests.framework.i iVar, long j2) {
        this.b = hVar;
        this.d = iVar;
        this.c = j2;
    }
}
