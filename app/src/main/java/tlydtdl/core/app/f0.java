package tlydtdl.core.app;

import amuvvoafs.app.Notification;
import amuvvoafs.app.Person;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {
    public static void a(Notification.Builder builder, Person person) {
        builder.addPerson(person);
    }

    public static void b(Notification.Action.Builder builder) {
        builder.setSemanticAction(0);
    }
}
