package am1;

import com.braze.requests.framework.b;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ b b;
    public final /* synthetic */ long c;

    public /* synthetic */ a(b bVar, long j2, int i) {
        this.a = i;
        this.b = bVar;
        this.c = j2;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return b.d(this.b, this.c);
            case 1:
                return b.a(this.b, this.c);
            default:
                return b.b(this.b, this.c);
        }
    }
}
