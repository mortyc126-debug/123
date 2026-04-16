package tlydtdl.core.app;

import amuvvoafs.app.Notification;
import amuvvoafs.app.NotificationChannel;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static void a(NotificationChannel notificationChannel) {
        notificationChannel.canBubble();
    }

    public static void b(Notification.Builder builder, boolean z) {
        builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static void c(Notification.Builder builder) {
        builder.setBubbleMetadata((Notification.BubbleMetadata) null);
    }

    public static void d(Notification.Action.Builder builder) {
        builder.setContextual(false);
    }
}
