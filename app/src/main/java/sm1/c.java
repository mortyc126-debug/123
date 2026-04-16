package sm1;

import com.braze.events.BrazeUserChangeEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import f3.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements IEventSubscriber {
    public final /* synthetic */ int a;
    public final /* synthetic */ BrazeInAppMessageManager b;

    public /* synthetic */ c(BrazeInAppMessageManager brazeInAppMessageManager, int i) {
        this.a = i;
        this.b = brazeInAppMessageManager;
    }

    public final void trigger(Object obj) {
        switch (this.a) {
            case 0:
                f2.y(obj);
                BrazeInAppMessageManager.d0(this.b);
                break;
            case 1:
                BrazeInAppMessageManager.W(this.b, (BrazeUserChangeEvent) obj);
                break;
            default:
                BrazeInAppMessageManager.V(this.b, (InAppMessageEvent) obj);
                break;
        }
    }
}
