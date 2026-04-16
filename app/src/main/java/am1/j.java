package am1;

import com.braze.events.IEventSubscriber;
import com.braze.events.internal.o;
import com.braze.requests.framework.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements IEventSubscriber {
    public final /* synthetic */ int a;
    public final /* synthetic */ g b;

    public /* synthetic */ j(g gVar, int i) {
        this.a = i;
        this.b = gVar;
    }

    public final void trigger(Object obj) {
        switch (this.a) {
            case 0:
                g.a(this.b, (com.braze.events.internal.dispatchmanager.c) obj);
                break;
            default:
                g.a(this.b, (o) obj);
                break;
        }
    }
}
