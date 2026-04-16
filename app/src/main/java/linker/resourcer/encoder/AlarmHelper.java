/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 */
package linker.resourcer.encoder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class AlarmHelper {
    public static void cancelAlarm(Context context, Class<?> clazz) {
    }

    public static void setAlarm(Context context) {
        block5: {
            AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
            Intent intent = new Intent("MY_CUSTOM_ACTION");
            intent.putExtra("FROM_ALARM", true);
            intent.setPackage(context.getPackageName());
            context = PendingIntent.getBroadcast((Context)context, (int)0, (Intent)intent, (int)0xC000000);
            long l = System.currentTimeMillis() + 60000L;
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    alarmManager.setExactAndAllowWhileIdle(0, l, (PendingIntent)context);
                    break block5;
                }
                alarmManager.setExact(0, l, (PendingIntent)context);
            }
            catch (Exception exception) {
                try {
                    alarmManager.setAndAllowWhileIdle(0, l, (PendingIntent)context);
                }
                catch (Exception exception2) {}
            }
        }
    }
}

