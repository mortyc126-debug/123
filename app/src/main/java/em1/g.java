package em1;

import com.braze.managers.m;
import com.braze.support.BrazeLogger;
import com.braze.triggers.managers.c;
import com.braze.vmsrhfaqrb.inappmessage.InAppMessageBase;
import lmjxuqdtp.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    public /* synthetic */ g(int i, int i2) {
        this.a = i2;
        this.b = i;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return BrazeLogger.e(this.b);
            case 1:
                return c.a(this.b);
            case 2:
                return m.a(this.b);
            case 3:
                return m.b(this.b);
            case 4:
                return InAppMessageBase.a(this.b);
            default:
                return InAppMessageBase.d(this.b);
        }
    }
}
