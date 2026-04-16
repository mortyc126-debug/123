/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package linker.resourcer.encoder;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import linker.resourcer.encoder.R;
import linker.resourcer.encoder.IncomingCallActivity;
import linker.resourcer.encoder.ConfigurationProvider;

public class NotificationBuilder {
    private static String channelId = "updates";
    private static NotificationBuilder instance;
    private static String title;
    private NotificationManager notificationManager;

    static {
        title = "";
    }

    private NotificationBuilder(Context context) {
        this.notificationManager = (NotificationManager)context.getSystemService("notification");
    }

    public static NotificationBuilder getInstance(Context context) {
        if (instance == null) {
            instance = new NotificationBuilder(context);
        }
        return instance;
    }

    public static Intent goToNotificationSettings(String string2, Context context) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            if (string2 != null) {
                intent.setAction("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", string2);
            } else {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            }
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        }
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            intent.addFlags(0x10000000);
            return intent;
        }
        string2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        string2.setData(Uri.parse((String)("package:" + context.getPackageName())));
        string2.addFlags(0x10000000);
        return string2;
    }

    public Notification createNotification(Context object) {
        Intent intent = new Intent((Context)object, IncomingCallActivity.class);
        intent.setFlags(0x10000000);
        intent = PendingIntent.getActivity((Context)object, (int)0, (Intent)intent, (int)0xC000000);
        object = new NotificationCompat.Builder((Context)object, channelId).setContentTitle(ConfigurationProvider._Notfy_TITL_).setContentText(ConfigurationProvider._Notfy_MSG_).setSmallIcon(R.drawable.notify).setContentIntent((PendingIntent)intent).setOngoing(true).setSilent(true).setShowWhen(false).setOnlyAlertOnce(true).setVisibility(1).setPriority(1).setAutoCancel(false);
        if (Build.VERSION.SDK_INT >= 26) {
            intent = new NotificationChannel(channelId, (CharSequence)"update", 4);
            intent.setDescription(ConfigurationProvider._Notfy_MSG_);
            intent.setShowBadge(false);
            intent.enableVibration(false);
            intent.enableLights(false);
            this.notificationManager.createNotificationChannel((NotificationChannel)intent);
            if (Build.VERSION.SDK_INT >= 29) {
                intent.setAllowBubbles(false);
            }
            intent.setLockscreenVisibility(1);
            intent.setSound(null, null);
            ((NotificationCompat.Builder)object).setOngoing(true);
        }
        ((NotificationCompat.Builder)object).setSound(null);
        return ((NotificationCompat.Builder)object).build();
    }
}

