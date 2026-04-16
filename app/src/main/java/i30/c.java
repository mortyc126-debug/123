package i30;

import a2.q3;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import my1.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements IEventSubscriber {
    public final /* synthetic */ y a;
    public final /* synthetic */ e b;

    public /* synthetic */ c(y yVar, e eVar) {
        this.a = yVar;
        this.b = eVar;
    }

    public final void trigger(Object obj) {
        ContentCardsUpdatedEvent contentCardsUpdatedEvent = (ContentCardsUpdatedEvent) obj;
        s02.d.a.getClass();
        s02.b.p("Braze Content Cards: received event " + contentCardsUpdatedEvent);
        hs1.d.P(this.a, new q3(22, this.b, new f[0]).invoke(contentCardsUpdatedEvent.getAllCards()));
    }
}
