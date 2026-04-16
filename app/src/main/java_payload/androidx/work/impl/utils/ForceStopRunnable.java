/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.AlarmManager
 *  android.app.ApplicationExitInfo
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.database.sqlite.SQLiteAccessPermException
 *  android.database.sqlite.SQLiteCantOpenDatabaseException
 *  android.database.sqlite.SQLiteConstraintException
 *  android.database.sqlite.SQLiteDatabaseCorruptException
 *  android.database.sqlite.SQLiteDatabaseLockedException
 *  android.database.sqlite.SQLiteDiskIOException
 *  android.database.sqlite.SQLiteException
 *  android.database.sqlite.SQLiteTableLockedException
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package androidx.work.impl.utils;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.UserManagerCompat;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.ProcessUtils;
import java.util.concurrent.TimeUnit;

public class ForceStopRunnable
implements Runnable {
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300L;
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650L);
    private final Context mContext;
    private final PreferenceUtils mPreferenceUtils;
    private int mRetryCount;
    private final WorkManagerImpl mWorkManager;

    public ForceStopRunnable(Context context, WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
        this.mPreferenceUtils = workManagerImpl.getPreferenceUtils();
        this.mRetryCount = 0;
    }

    static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return intent;
    }

    private static PendingIntent getPendingIntent(Context context, int n) {
        return PendingIntent.getBroadcast((Context)context, (int)-1, (Intent)ForceStopRunnable.getIntent(context), (int)n);
    }

    static void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        int n = 0x8000000;
        if (Build.VERSION.SDK_INT >= 31) {
            n = 0x8000000 | 0x2000000;
        }
        context = ForceStopRunnable.getPendingIntent(context, n);
        long l = System.currentTimeMillis();
        long l2 = TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, l + l2, (PendingIntent)context);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean cleanUp() {
        boolean bl = SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager.getWorkDatabase());
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            Object object = workSpecDao.getRunningWork();
            boolean bl2 = true;
            boolean bl3 = object != null && !object.isEmpty();
            if (bl3) {
                object = object.iterator();
                while (object.hasNext()) {
                    WorkSpec workSpec = (WorkSpec)object.next();
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, workSpec.id);
                    workSpecDao.setStopReason(workSpec.id, -512);
                    workSpecDao.markWorkSpecScheduled(workSpec.id, -1L);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            boolean bl4 = bl2;
            if (bl3) return bl4;
            if (bl) {
                bl4 = bl2;
                return bl4;
            }
            bl4 = false;
            return bl4;
        }
        finally {
            workDatabase.endTransaction();
        }
    }

    public void forceStopRunnable() {
        boolean bl = this.cleanUp();
        if (this.shouldRescheduleWorkers()) {
            Logger.get().debug(TAG, "Rescheduling Workers.");
            this.mWorkManager.rescheduleEligibleWork();
            this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        } else if (this.isForceStopped()) {
            Logger.get().debug(TAG, "Application was force-stopped, rescheduling.");
            this.mWorkManager.rescheduleEligibleWork();
            this.mPreferenceUtils.setLastForceStopEventMillis(this.mWorkManager.getConfiguration().getClock().currentTimeMillis());
        } else if (bl) {
            Logger.get().debug(TAG, "Found unfinished work, scheduling it.");
            Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isForceStopped() {
        void var4_5;
        block12: {
            int n = 0x20000000;
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    n = 0x20000000 | 0x2000000;
                }
                Object object = ForceStopRunnable.getPendingIntent(this.mContext, n);
                if (Build.VERSION.SDK_INT >= 30) {
                    if (object != null) {
                        object.cancel();
                    }
                    object = (ActivityManager)this.mContext.getSystemService("activity");
                    if ((object = object.getHistoricalProcessExitReasons(null, 0, 0)) == null || object.isEmpty()) return false;
                    long l = this.mPreferenceUtils.getLastForceStopEventMillis();
                    for (n = 0; n < object.size(); ++n) {
                        ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo)object.get(n);
                        if (applicationExitInfo.getReason() != 10 || applicationExitInfo.getTimestamp() < l) continue;
                        return true;
                    }
                    return false;
                }
                if (object != null) {
                    return false;
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                break block12;
            }
            catch (SecurityException securityException) {
                // empty catch block
                break block12;
            }
            {
                ForceStopRunnable.setAlarm(this.mContext);
                return true;
            }
        }
        Logger.get().warning(TAG, "Ignoring exception", (Throwable)var4_5);
        return true;
    }

    public boolean multiProcessChecks() {
        Configuration configuration2 = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty((CharSequence)configuration2.getDefaultProcessName())) {
            Logger.get().debug(TAG, "The default process name was not specified.");
            return true;
        }
        boolean bl = ProcessUtils.isDefaultProcess(this.mContext, configuration2);
        Logger.get().debug(TAG, "Is default app process = " + bl);
        return bl;
    }

    /*
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        block18: {
            boolean bl = this.multiProcessChecks();
            if (bl) break block18;
            this.mWorkManager.onForceStopRunnableCompleted();
            return;
        }
        try {
            Object object;
            block20: {
                block19: {
                    while (true) {
                        Object object2;
                        CharSequence charSequence;
                        WorkDatabasePathHelper.migrateDatabase(this.mContext);
                        Logger.get().debug(TAG, "Performing cleanup operations.");
                        try {
                            this.forceStopRunnable();
                            break block19;
                        }
                        catch (SQLiteAccessPermException sQLiteAccessPermException) {
                        }
                        catch (SQLiteConstraintException sQLiteConstraintException) {
                        }
                        catch (SQLiteTableLockedException sQLiteTableLockedException) {
                        }
                        catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
                        }
                        catch (SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException) {
                        }
                        catch (SQLiteDiskIOException sQLiteDiskIOException) {
                        }
                        catch (SQLiteCantOpenDatabaseException sQLiteCantOpenDatabaseException) {
                            // empty catch block
                        }
                        ++this.mRetryCount;
                        if (this.mRetryCount >= 3) {
                            charSequence = UserManagerCompat.isUserUnlocked(this.mContext) ? "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store." : "WorkManager can't be accessed from direct boot, because credential encrypted storage isn't accessible.\nDon't access or initialise WorkManager from directAware components. See https://developer.android.com/training/articles/direct-boot";
                            Logger.get().error(TAG, (String)charSequence, (Throwable)object);
                            object2 = new IllegalStateException((String)charSequence, (Throwable)object);
                            object = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();
                            if (object != null) {
                                Logger.get().debug(TAG, "Routing exception to the specified exception handler", (Throwable)object2);
                                object.accept(object2);
                                break block19;
                            }
                            throw object2;
                        }
                        long l = this.mRetryCount;
                        object2 = Logger.get();
                        String string2 = TAG;
                        charSequence = new StringBuilder();
                        ((Logger)object2).debug(string2, ((StringBuilder)charSequence).append("Retrying after ").append(l * 300L).toString(), (Throwable)object);
                        this.sleep((long)this.mRetryCount * 300L);
                    }
                    catch (SQLiteException sQLiteException) {
                        Logger.get().error(TAG, "Unexpected SQLite exception during migrations");
                        object = new IllegalStateException("Unexpected SQLite exception during migrations", sQLiteException);
                        Consumer<Throwable> consumer = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();
                        if (consumer == null) break block20;
                        consumer.accept((Throwable)object);
                    }
                }
                return;
            }
            throw object;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            this.mWorkManager.onForceStopRunnableCompleted();
        }
    }

    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    public void sleep(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public static class BroadcastReceiver
    extends android.content.BroadcastReceiver {
        private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        public void onReceive(Context context, Intent intent) {
            if (intent != null && ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(intent.getAction())) {
                Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.");
                ForceStopRunnable.setAlarm(context);
            }
        }
    }
}

