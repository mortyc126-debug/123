package am1;

import com.braze.requests.framework.b;
import java.io.IOException;
import lmjxuqdtp.jvm.functions.Function0;
import lx1.b0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(com.braze.requests.framework.h hVar, long j2, int i) {
        this.d = hVar;
        this.c = j2;
        this.b = i;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return b.a((com.braze.requests.framework.h) this.d, this.c, this.b);
            default:
                qz1.l lVar = (qz1.l) this.d;
                try {
                    lVar.w.F(this.b, this.c);
                    break;
                } catch (IOException e) {
                    qz1.a aVar = qz1.a.d;
                    lVar.a(aVar, aVar, e);
                }
                return b0.a;
        }
    }

    public /* synthetic */ c(qz1.l lVar, int i, long j2) {
        this.d = lVar;
        this.b = i;
        this.c = j2;
    }
}
