/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlinx.coroutines.Job;

public class SystemForegroundDispatcher
implements OnConstraintsStateChangedListener,
ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_GENERATION = "KEY_GENERATION";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    WorkGenerationalId mCurrentForegroundId;
    final Map<WorkGenerationalId, ForegroundInfo> mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Map<WorkGenerationalId, Job> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<WorkGenerationalId, WorkSpec> mWorkSpecById;

    SystemForegroundDispatcher(Context context) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = WorkManagerImpl.getInstance(this.mContext);
        this.mTaskExecutor = this.mWorkManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap<WorkGenerationalId, ForegroundInfo>();
        this.mTrackedWorkSpecs = new HashMap<WorkGenerationalId, Job>();
        this.mWorkSpecById = new HashMap<WorkGenerationalId, WorkSpec>();
        this.mConstraintsTracker = new WorkConstraintsTracker(this.mWorkManagerImpl.getTrackers());
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    SystemForegroundDispatcher(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mLock = new Object();
        this.mWorkManagerImpl = workManagerImpl;
        this.mTaskExecutor = this.mWorkManagerImpl.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap<WorkGenerationalId, ForegroundInfo>();
        this.mTrackedWorkSpecs = new HashMap<WorkGenerationalId, Job>();
        this.mWorkSpecById = new HashMap<WorkGenerationalId, WorkSpec>();
        this.mConstraintsTracker = workConstraintsTracker;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    public static Intent createCancelWorkIntent(Context context, String string2) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_CANCEL_WORK);
        context.setData(Uri.parse((String)("workspec://" + string2)));
        context.putExtra(KEY_WORKSPEC_ID, string2);
        return context;
    }

    public static Intent createNotifyIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_NOTIFY);
        context.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        context.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        context.putExtra(KEY_NOTIFICATION, (Parcelable)foregroundInfo.getNotification());
        context.putExtra(KEY_WORKSPEC_ID, workGenerationalId.getWorkSpecId());
        context.putExtra(KEY_GENERATION, workGenerationalId.getGeneration());
        return context;
    }

    public static Intent createStartForegroundIntent(Context context, WorkGenerationalId workGenerationalId, ForegroundInfo foregroundInfo) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_START_FOREGROUND);
        context.putExtra(KEY_WORKSPEC_ID, workGenerationalId.getWorkSpecId());
        context.putExtra(KEY_GENERATION, workGenerationalId.getGeneration());
        context.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        context.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        context.putExtra(KEY_NOTIFICATION, (Parcelable)foregroundInfo.getNotification());
        return context;
    }

    public static Intent createStopForegroundIntent(Context context) {
        context = new Intent(context, SystemForegroundService.class);
        context.setAction(ACTION_STOP_FOREGROUND);
        return context;
    }

    private void handleCancelWork(Intent object) {
        Logger.get().info(TAG, "Stopping foreground work for " + object);
        object = object.getStringExtra(KEY_WORKSPEC_ID);
        if (object != null && !TextUtils.isEmpty((CharSequence)object)) {
            this.mWorkManagerImpl.cancelWorkById(UUID.fromString((String)object));
        }
    }

    private void handleNotify(Intent object) {
        int n = object.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int n2 = object.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        Object object2 = object.getStringExtra(KEY_WORKSPEC_ID);
        WorkGenerationalId workGenerationalId = new WorkGenerationalId((String)object2, object.getIntExtra(KEY_GENERATION, 0));
        object = (Notification)object.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, "Notifying with (id:" + n + ", workSpecId: " + (String)object2 + ", notificationType :" + n2 + ")");
        if (object != null && this.mCallback != null) {
            object2 = new ForegroundInfo(n, (Notification)object, n2);
            this.mForegroundInfoById.put(workGenerationalId, (ForegroundInfo)object2);
            if (this.mCurrentForegroundId == null) {
                this.mCurrentForegroundId = workGenerationalId;
                this.mCallback.startForeground(n, n2, (Notification)object);
            } else {
                this.mCallback.notify(n, (Notification)object);
                if (n2 != 0 && Build.VERSION.SDK_INT >= 29) {
                    n2 = 0;
                    object = this.mForegroundInfoById.entrySet().iterator();
                    while (object.hasNext()) {
                        n2 |= ((ForegroundInfo)((Map.Entry)object.next()).getValue()).getForegroundServiceType();
                    }
                    object = this.mForegroundInfoById.get(this.mCurrentForegroundId);
                    if (object != null) {
                        this.mCallback.startForeground(((ForegroundInfo)object).getNotificationId(), n2, ((ForegroundInfo)object).getNotification());
                    }
                }
            }
        }
    }

    private void handleStartForeground(Intent object) {
        Logger.get().info(TAG, "Started foreground service " + object);
        object = object.getStringExtra(KEY_WORKSPEC_ID);
        this.mTaskExecutor.executeOnTaskThread(new Runnable(){
            final SystemForegroundDispatcher this$0;
            final String val$workSpecId;
            {
                this.this$0 = systemForegroundDispatcher;
                this.val$workSpecId = string2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void run() {
                WorkSpec workSpec = this.this$0.mWorkManagerImpl.getProcessor().getRunningWorkSpec(this.val$workSpecId);
                if (workSpec == null) return;
                if (!workSpec.hasConstraints()) return;
                Object object = this.this$0.mLock;
                synchronized (object) {
                    this.this$0.mWorkSpecById.put(WorkSpecKt.generationalId(workSpec), workSpec);
                    Job job2 = WorkConstraintsTrackerKt.listen(this.this$0.mConstraintsTracker, workSpec, this.this$0.mTaskExecutor.getTaskCoroutineDispatcher(), this.this$0);
                    this.this$0.mTrackedWorkSpecs.put(WorkSpecKt.generationalId(workSpec), job2);
                    return;
                }
            }
        });
    }

    void handleStop(Intent intent) {
        Logger.get().info(TAG, "Stopping foreground service");
        if (this.mCallback != null) {
            this.mCallback.stop();
        }
    }

    @Override
    public void onConstraintsStateChanged(WorkSpec workSpec, ConstraintsState object) {
        if (object instanceof ConstraintsState.ConstraintsNotMet) {
            object = workSpec.id;
            Logger.get().debug(TAG, "Constraints unmet for WorkSpec " + (String)object);
            this.mWorkManagerImpl.stopForegroundWork(WorkSpecKt.generationalId(workSpec));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void onDestroy() {
        this.mCallback = null;
        Object object = this.mLock;
        synchronized (object) {
            Iterator<Job> iterator2 = this.mTrackedWorkSpecs.values().iterator();
            while (true) {
                if (!iterator2.hasNext()) {
                    // MONITOREXIT @DISABLED, blocks:[2, 3, 4] lbl7 : MonitorExitStatement: MONITOREXIT : var1_1
                    this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
                    return;
                }
                iterator2.next().cancel(null);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onExecuted(WorkGenerationalId workGenerationalId, boolean bl) {
        Object object = null;
        Object object2 = this.mLock;
        synchronized (object2) {
            if (this.mWorkSpecById.remove(workGenerationalId) != null) {
                object = this.mTrackedWorkSpecs.remove(workGenerationalId);
            }
            if (object != null) {
                object.cancel(null);
            }
        }
        object2 = this.mForegroundInfoById.remove(workGenerationalId);
        if (workGenerationalId.equals(this.mCurrentForegroundId)) {
            if (this.mForegroundInfoById.size() > 0) {
                Iterator<Map.Entry<WorkGenerationalId, ForegroundInfo>> iterator2 = this.mForegroundInfoById.entrySet().iterator();
                object = iterator2.next();
                while (iterator2.hasNext()) {
                    object = iterator2.next();
                }
                this.mCurrentForegroundId = object.getKey();
                if (this.mCallback != null) {
                    object = object.getValue();
                    this.mCallback.startForeground(((ForegroundInfo)object).getNotificationId(), ((ForegroundInfo)object).getForegroundServiceType(), ((ForegroundInfo)object).getNotification());
                    this.mCallback.cancelNotification(((ForegroundInfo)object).getNotificationId());
                }
            } else {
                this.mCurrentForegroundId = null;
            }
        }
        object = this.mCallback;
        if (object2 != null && object != null) {
            Logger.get().debug(TAG, "Removing Notification (id: " + ((ForegroundInfo)object2).getNotificationId() + ", workSpecId: " + workGenerationalId + ", notificationType: " + ((ForegroundInfo)object2).getForegroundServiceType());
            object.cancelNotification(((ForegroundInfo)object2).getNotificationId());
        }
    }

    void onStartCommand(Intent intent) {
        String string2 = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(string2)) {
            this.handleStartForeground(intent);
            this.handleNotify(intent);
        } else if (ACTION_NOTIFY.equals(string2)) {
            this.handleNotify(intent);
        } else if (ACTION_CANCEL_WORK.equals(string2)) {
            this.handleCancelWork(intent);
        } else if (ACTION_STOP_FOREGROUND.equals(string2)) {
            this.handleStop(intent);
        }
    }

    void setCallback(Callback callback2) {
        if (this.mCallback != null) {
            Logger.get().error(TAG, "A callback already exists.");
            return;
        }
        this.mCallback = callback2;
    }

    static interface Callback {
        public void cancelNotification(int var1);

        public void notify(int var1, Notification var2);

        public void startForeground(int var1, int var2, Notification var3);

        public void stop();
    }
}

