/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 */
package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.CommandHandler;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.IdGenerator;

class Alarms {
    private static final String TAG = Logger.tagWithPrefix("Alarms");

    private Alarms() {
    }

    public static void cancelAlarm(Context context, WorkDatabase object, WorkGenerationalId workGenerationalId) {
        SystemIdInfoDao systemIdInfoDao = ((WorkDatabase)object).systemIdInfoDao();
        if ((object = systemIdInfoDao.getSystemIdInfo(workGenerationalId)) != null) {
            Alarms.cancelExactAlarm(context, workGenerationalId, ((SystemIdInfo)object).systemId);
            Logger.get().debug(TAG, "Removing SystemIdInfo for workSpecId (" + workGenerationalId + ")");
            systemIdInfoDao.removeSystemIdInfo(workGenerationalId);
        }
    }

    private static void cancelExactAlarm(Context context, WorkGenerationalId workGenerationalId, int n) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        Intent intent = CommandHandler.createDelayMetIntent(context, workGenerationalId);
        if ((context = PendingIntent.getService((Context)context, (int)n, (Intent)intent, (int)(0x20000000 | 0x4000000))) != null && alarmManager != null) {
            Logger.get().debug(TAG, "Cancelling existing alarm with (workSpecId, systemId) (" + workGenerationalId + ", " + n + ")");
            alarmManager.cancel((PendingIntent)context);
        }
    }

    public static void setAlarm(Context context, WorkDatabase workDatabase, WorkGenerationalId workGenerationalId, long l) {
        SystemIdInfoDao systemIdInfoDao = workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao.getSystemIdInfo(workGenerationalId);
        if (systemIdInfo != null) {
            Alarms.cancelExactAlarm(context, workGenerationalId, systemIdInfo.systemId);
            Alarms.setExactAlarm(context, workGenerationalId, systemIdInfo.systemId, l);
        } else {
            int n = new IdGenerator(workDatabase).nextAlarmManagerId();
            systemIdInfoDao.insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(workGenerationalId, n));
            Alarms.setExactAlarm(context, workGenerationalId, n, l);
        }
    }

    private static void setExactAlarm(Context context, WorkGenerationalId workGenerationalId, int n, long l) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        context = PendingIntent.getService((Context)context, (int)n, (Intent)CommandHandler.createDelayMetIntent(context, workGenerationalId), (int)(0x8000000 | 0x4000000));
        if (alarmManager != null) {
            Api19Impl.setExact(alarmManager, 0, l, (PendingIntent)context);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static void setExact(AlarmManager alarmManager, int n, long l, PendingIntent pendingIntent) {
            alarmManager.setExact(n, l, pendingIntent);
        }
    }
}

