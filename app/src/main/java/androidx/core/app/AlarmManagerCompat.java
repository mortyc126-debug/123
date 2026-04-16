/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.AlarmManager$AlarmClockInfo
 *  android.app.PendingIntent
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;

public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    public static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.canScheduleExactAlarms(alarmManager);
        }
        return true;
    }

    public static void setAlarmClock(AlarmManager alarmManager, long l, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        Api21Impl.setAlarmClock(alarmManager, Api21Impl.createAlarmClockInfo(l, pendingIntent), pendingIntent2);
    }

    public static void setAndAllowWhileIdle(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
        Api23Impl.setAndAllowWhileIdle(alarmManager, n, l, pendingIntent);
    }

    public static void setExact(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
        alarmManager.setExact(n, l, pendingIntent);
    }

    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
        Api23Impl.setExactAndAllowWhileIdle(alarmManager, n, l, pendingIntent);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static AlarmManager.AlarmClockInfo createAlarmClockInfo(long l, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(l, pendingIntent);
        }

        static void setAlarmClock(AlarmManager alarmManager, Object object, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo)object, pendingIntent);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setAndAllowWhileIdle(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(n, l, pendingIntent);
        }

        static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(n, l, pendingIntent);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean canScheduleExactAlarms(AlarmManager alarmManager) {
            return alarmManager.canScheduleExactAlarms();
        }
    }
}

