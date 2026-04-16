/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationChannelGroup
 *  android.app.NotificationManager
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ResolveInfo
 *  android.os.Build$VERSION
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.RemoteException
 *  android.provider.Settings$Secure
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationChannelGroupCompat;
import androidx.core.app.NotificationCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet<String>();
        sLock = new Object();
    }

    NotificationManagerCompat(NotificationManager notificationManager, Context context) {
        this.mContext = context;
        this.mNotificationManager = notificationManager;
    }

    private NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
    }

    public static NotificationManagerCompat from(Context context) {
        return new NotificationManagerCompat(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Set<String> getEnabledListenerPackages(Context object) {
        String string2 = Settings.Secure.getString((ContentResolver)object.getContentResolver(), (String)SETTING_ENABLED_NOTIFICATION_LISTENERS);
        object = sEnabledNotificationListenersLock;
        synchronized (object) {
            if (string2 == null) return sEnabledNotificationListenerPackages;
            if (string2.equals(sEnabledNotificationListeners)) return sEnabledNotificationListenerPackages;
            String[] stringArray = string2.split(":", -1);
            HashSet<String> hashSet = new HashSet<String>(stringArray.length);
            int n = stringArray.length;
            for (int i = 0; i < n; ++i) {
                ComponentName componentName = ComponentName.unflattenFromString((String)stringArray[i]);
                if (componentName == null) continue;
                hashSet.add(componentName.getPackageName());
            }
            sEnabledNotificationListenerPackages = hashSet;
            sEnabledNotificationListeners = string2;
            return sEnabledNotificationListenerPackages;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void pushSideChannelQueue(Task task) {
        Object object = sLock;
        synchronized (object) {
            if (sSideChannelManager == null) {
                SideChannelManager sideChannelManager;
                sSideChannelManager = sideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
            }
            sSideChannelManager.queueTask(task);
            return;
        }
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        boolean bl = (notification = NotificationCompat.getExtras(notification)) != null && notification.getBoolean(EXTRA_USE_SIDE_CHANNEL);
        return bl;
    }

    public boolean areNotificationsEnabled() {
        return Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public boolean canUseFullScreenIntent() {
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        if (n < 29) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 34) {
            if (this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") != 0) {
                bl = false;
            }
            return bl;
        }
        return Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancel(int n) {
        this.cancel(null, n);
    }

    public void cancel(String string2, int n) {
        this.mNotificationManager.cancel(string2, n);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.createNotificationChannel(this.mNotificationManager, notificationChannel);
        }
    }

    public void createNotificationChannel(NotificationChannelCompat notificationChannelCompat) {
        this.createNotificationChannel(notificationChannelCompat.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup notificationChannelGroup) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.createNotificationChannelGroup(this.mNotificationManager, notificationChannelGroup);
        }
    }

    public void createNotificationChannelGroup(NotificationChannelGroupCompat notificationChannelGroupCompat) {
        this.createNotificationChannelGroup(notificationChannelGroupCompat.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.createNotificationChannelGroups(this.mNotificationManager, list);
        }
    }

    public void createNotificationChannelGroupsCompat(List<NotificationChannelGroupCompat> object) {
        if (Build.VERSION.SDK_INT >= 26 && !object.isEmpty()) {
            ArrayList<NotificationChannelGroup> arrayList = new ArrayList<NotificationChannelGroup>(object.size());
            object = object.iterator();
            while (object.hasNext()) {
                arrayList.add(((NotificationChannelGroupCompat)object.next()).getNotificationChannelGroup());
            }
            Api26Impl.createNotificationChannelGroups(this.mNotificationManager, arrayList);
        }
    }

    public void createNotificationChannels(List<NotificationChannel> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.createNotificationChannels(this.mNotificationManager, list);
        }
    }

    public void createNotificationChannelsCompat(List<NotificationChannelCompat> object) {
        if (Build.VERSION.SDK_INT >= 26 && !object.isEmpty()) {
            ArrayList<NotificationChannel> arrayList = new ArrayList<NotificationChannel>(object.size());
            object = object.iterator();
            while (object.hasNext()) {
                arrayList.add(((NotificationChannelCompat)object.next()).getNotificationChannel());
            }
            Api26Impl.createNotificationChannels(this.mNotificationManager, arrayList);
        }
    }

    public void deleteNotificationChannel(String string2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.deleteNotificationChannel(this.mNotificationManager, string2);
        }
    }

    public void deleteNotificationChannelGroup(String string2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, string2);
        }
    }

    public void deleteUnlistedNotificationChannels(Collection<String> collection) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannel notificationChannel : Api26Impl.getNotificationChannels(this.mNotificationManager)) {
                if (collection.contains(Api26Impl.getId(notificationChannel)) || Build.VERSION.SDK_INT >= 30 && collection.contains(Api30Impl.getParentChannelId(notificationChannel))) continue;
                Api26Impl.deleteNotificationChannel(this.mNotificationManager, Api26Impl.getId(notificationChannel));
            }
        }
    }

    public List<StatusBarNotification> getActiveNotifications() {
        return Api23Impl.getActiveNotifications(this.mNotificationManager);
    }

    public int getCurrentInterruptionFilter() {
        return Api23Impl.getCurrentInterruptionFilter(this.mNotificationManager);
    }

    public int getImportance() {
        return Api24Impl.getImportance(this.mNotificationManager);
    }

    public NotificationChannel getNotificationChannel(String string2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNotificationChannel(this.mNotificationManager, string2);
        }
        return null;
    }

    public NotificationChannel getNotificationChannel(String string2, String string3) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getNotificationChannel(this.mNotificationManager, string2, string3);
        }
        return this.getNotificationChannel(string2);
    }

    public NotificationChannelCompat getNotificationChannelCompat(String string2) {
        if (Build.VERSION.SDK_INT >= 26 && (string2 = this.getNotificationChannel(string2)) != null) {
            return new NotificationChannelCompat((NotificationChannel)string2);
        }
        return null;
    }

    public NotificationChannelCompat getNotificationChannelCompat(String string2, String string3) {
        if (Build.VERSION.SDK_INT >= 26 && (string2 = this.getNotificationChannel(string2, string3)) != null) {
            return new NotificationChannelCompat((NotificationChannel)string2);
        }
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String string2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getNotificationChannelGroup(this.mNotificationManager, string2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            for (NotificationChannelGroup notificationChannelGroup : this.getNotificationChannelGroups()) {
                if (!Api26Impl.getId(notificationChannelGroup).equals(string2)) continue;
                return notificationChannelGroup;
            }
            return null;
        }
        return null;
    }

    public NotificationChannelGroupCompat getNotificationChannelGroupCompat(String string2) {
        if (Build.VERSION.SDK_INT >= 28) {
            if ((string2 = this.getNotificationChannelGroup(string2)) != null) {
                return new NotificationChannelGroupCompat((NotificationChannelGroup)string2);
            }
        } else if (Build.VERSION.SDK_INT >= 26 && (string2 = this.getNotificationChannelGroup(string2)) != null) {
            return new NotificationChannelGroupCompat((NotificationChannelGroup)string2, this.getNotificationChannels());
        }
        return null;
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
        }
        return Collections.emptyList();
    }

    public List<NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        NotificationChannelGroup notificationChannelGroup2;
        if (Build.VERSION.SDK_INT >= 26 && !(notificationChannelGroup2 = this.getNotificationChannelGroups()).isEmpty()) {
            List<Object> list = Build.VERSION.SDK_INT >= 28 ? Collections.emptyList() : this.getNotificationChannels();
            ArrayList<NotificationChannelGroupCompat> arrayList = new ArrayList<NotificationChannelGroupCompat>(notificationChannelGroup2.size());
            for (NotificationChannelGroup notificationChannelGroup2 : notificationChannelGroup2) {
                if (Build.VERSION.SDK_INT >= 28) {
                    arrayList.add(new NotificationChannelGroupCompat(notificationChannelGroup2));
                    continue;
                }
                arrayList.add(new NotificationChannelGroupCompat(notificationChannelGroup2, list));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public List<NotificationChannel> getNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNotificationChannels(this.mNotificationManager);
        }
        return Collections.emptyList();
    }

    public List<NotificationChannelCompat> getNotificationChannelsCompat() {
        Object object;
        if (Build.VERSION.SDK_INT >= 26 && !(object = this.getNotificationChannels()).isEmpty()) {
            ArrayList<NotificationChannelCompat> arrayList = new ArrayList<NotificationChannelCompat>(object.size());
            object = object.iterator();
            while (object.hasNext()) {
                arrayList.add(new NotificationChannelCompat((NotificationChannel)object.next()));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void notify(int n, Notification notification) {
        this.notify(null, n, notification);
    }

    public void notify(String string2, int n, Notification notification) {
        if (NotificationManagerCompat.useSideChannelForNotification(notification)) {
            this.pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), n, string2, notification));
            this.mNotificationManager.cancel(string2, n);
        } else {
            this.mNotificationManager.notify(string2, n, notification);
        }
    }

    public void notify(List<NotificationWithIdAndTag> list) {
        int n = list.size();
        for (int i = 0; i < n; ++i) {
            NotificationWithIdAndTag notificationWithIdAndTag = list.get(i);
            this.notify(notificationWithIdAndTag.mTag, notificationWithIdAndTag.mId, notificationWithIdAndTag.mNotification);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static List<StatusBarNotification> getActiveNotifications(NotificationManager statusBarNotificationArray) {
            if ((statusBarNotificationArray = statusBarNotificationArray.getActiveNotifications()) == null) {
                return new ArrayList<StatusBarNotification>();
            }
            return Arrays.asList(statusBarNotificationArray);
        }

        static int getCurrentInterruptionFilter(NotificationManager notificationManager) {
            return notificationManager.getCurrentInterruptionFilter();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean areNotificationsEnabled(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int getImportance(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void createNotificationChannel(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        static void createNotificationChannelGroup(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        static void createNotificationChannelGroups(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        static void createNotificationChannels(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        static void deleteNotificationChannel(NotificationManager notificationManager, String string2) {
            notificationManager.deleteNotificationChannel(string2);
        }

        static void deleteNotificationChannelGroup(NotificationManager notificationManager, String string2) {
            notificationManager.deleteNotificationChannelGroup(string2);
        }

        static String getId(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        static String getId(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        static NotificationChannel getNotificationChannel(NotificationManager notificationManager, String string2) {
            return notificationManager.getNotificationChannel(string2);
        }

        static List<NotificationChannelGroup> getNotificationChannelGroups(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        static List<NotificationChannel> getNotificationChannels(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static NotificationChannelGroup getNotificationChannelGroup(NotificationManager notificationManager, String string2) {
            return notificationManager.getNotificationChannelGroup(string2);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static NotificationChannel getNotificationChannel(NotificationManager notificationManager, String string2, String string3) {
            return notificationManager.getNotificationChannel(string2, string3);
        }

        static String getParentChannelId(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static boolean canUseFullScreenIntent(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    private static class CancelTask
    implements Task {
        final boolean all;
        final int id;
        final String packageName;
        final String tag;

        CancelTask(String string2) {
            this.packageName = string2;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        CancelTask(String string2, int n, String string3) {
            this.packageName = string2;
            this.id = n;
            this.tag = string3;
            this.all = false;
        }

        @Override
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.all) {
                iNotificationSideChannel.cancelAll(this.packageName);
            } else {
                iNotificationSideChannel.cancel(this.packageName, this.id, this.tag);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.all);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {
        final int mId;
        Notification mNotification;
        final String mTag;

        public NotificationWithIdAndTag(int n, Notification notification) {
            this(null, n, notification);
        }

        public NotificationWithIdAndTag(String string2, int n, Notification notification) {
            this.mTag = string2;
            this.mId = n;
            this.mNotification = notification;
        }
    }

    private static class NotifyTask
    implements Task {
        final int id;
        final Notification notif;
        final String packageName;
        final String tag;

        NotifyTask(String string2, int n, String string3, Notification notification) {
            this.packageName = string2;
            this.id = n;
            this.tag = string3;
            this.notif = notification;
        }

        @Override
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class ServiceConnectedEvent {
        final ComponentName componentName;
        final IBinder iBinder;

        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    private static class SideChannelManager
    implements Handler.Callback,
    ServiceConnection {
        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap<ComponentName, ListenerRecord>();

        SideChannelManager(Context context) {
            this.mCachedEnabledPackages = new HashSet<String>();
            this.mContext = context;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), (Handler.Callback)this);
        }

        private boolean ensureServiceBound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                return true;
            }
            Intent intent = new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName);
            listenerRecord.bound = this.mContext.bindService(intent, (ServiceConnection)this, 33);
            if (listenerRecord.bound) {
                listenerRecord.retryCount = 0;
            } else {
                Log.w((String)NotificationManagerCompat.TAG, (String)("Unable to bind to listener " + listenerRecord.componentName));
                this.mContext.unbindService((ServiceConnection)this);
            }
            return listenerRecord.bound;
        }

        private void ensureServiceUnbound(ListenerRecord listenerRecord) {
            if (listenerRecord.bound) {
                this.mContext.unbindService((ServiceConnection)this);
                listenerRecord.bound = false;
            }
            listenerRecord.service = null;
        }

        private void handleQueueTask(Task task) {
            this.updateListenerMap();
            for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                listenerRecord.taskQueue.add(task);
                this.processListenerQueue(listenerRecord);
            }
        }

        private void handleRetryListenerQueue(ComponentName object) {
            if ((object = this.mRecordMap.get(object)) != null) {
                this.processListenerQueue((ListenerRecord)object);
            }
        }

        private void handleServiceConnected(ComponentName object, IBinder iBinder) {
            if ((object = this.mRecordMap.get(object)) != null) {
                object.service = INotificationSideChannel.Stub.asInterface(iBinder);
                object.retryCount = 0;
                this.processListenerQueue((ListenerRecord)object);
            }
        }

        private void handleServiceDisconnected(ComponentName object) {
            if ((object = this.mRecordMap.get(object)) != null) {
                this.ensureServiceUnbound((ListenerRecord)object);
            }
        }

        private void processListenerQueue(ListenerRecord listenerRecord) {
            if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                Log.d((String)NotificationManagerCompat.TAG, (String)("Processing component " + listenerRecord.componentName + ", " + listenerRecord.taskQueue.size() + " queued tasks"));
            }
            if (listenerRecord.taskQueue.isEmpty()) {
                return;
            }
            if (this.ensureServiceBound(listenerRecord) && listenerRecord.service != null) {
                Task task;
                while ((task = listenerRecord.taskQueue.peek()) != null) {
                    try {
                        if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            Log.d((String)NotificationManagerCompat.TAG, (String)stringBuilder.append("Sending task ").append(task).toString());
                        }
                        task.send(listenerRecord.service);
                        listenerRecord.taskQueue.remove();
                    }
                    catch (RemoteException remoteException) {
                        Log.w((String)NotificationManagerCompat.TAG, (String)("RemoteException communicating with " + listenerRecord.componentName), (Throwable)remoteException);
                        break;
                    }
                    catch (DeadObjectException deadObjectException) {
                        if (!Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) break;
                        Log.d((String)NotificationManagerCompat.TAG, (String)("Remote service has died: " + listenerRecord.componentName));
                        break;
                    }
                }
                if (!listenerRecord.taskQueue.isEmpty()) {
                    this.scheduleListenerRetry(listenerRecord);
                }
                return;
            }
            this.scheduleListenerRetry(listenerRecord);
        }

        private void scheduleListenerRetry(ListenerRecord listenerRecord) {
            if (this.mHandler.hasMessages(3, (Object)listenerRecord.componentName)) {
                return;
            }
            ++listenerRecord.retryCount;
            if (listenerRecord.retryCount > 6) {
                Log.w((String)NotificationManagerCompat.TAG, (String)("Giving up on delivering " + listenerRecord.taskQueue.size() + " tasks to " + listenerRecord.componentName + " after " + listenerRecord.retryCount + " retries"));
                listenerRecord.taskQueue.clear();
                return;
            }
            int n = (1 << listenerRecord.retryCount - 1) * 1000;
            if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                Log.d((String)NotificationManagerCompat.TAG, (String)("Scheduling retry for " + n + " ms"));
            }
            listenerRecord = this.mHandler.obtainMessage(3, (Object)listenerRecord.componentName);
            this.mHandler.sendMessageDelayed((Message)listenerRecord, (long)n);
        }

        private void updateListenerMap() {
            Object object = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (object.equals(this.mCachedEnabledPackages)) {
                return;
            }
            this.mCachedEnabledPackages = object;
            ComponentName componentName3 = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
            HashSet<ComponentName> hashSet = new HashSet<ComponentName>();
            for (ResolveInfo resolveInfo : componentName3) {
                if (!object.contains(resolveInfo.serviceInfo.packageName)) continue;
                ComponentName componentName2 = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                if (resolveInfo.serviceInfo.permission != null) {
                    Log.w((String)NotificationManagerCompat.TAG, (String)("Permission present on component " + componentName2 + ", not adding listener record."));
                    continue;
                }
                hashSet.add(componentName2);
            }
            for (ComponentName componentName3 : hashSet) {
                if (this.mRecordMap.containsKey(componentName3)) continue;
                if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                    Log.d((String)NotificationManagerCompat.TAG, (String)("Adding listener record for " + componentName3));
                }
                this.mRecordMap.put(componentName3, new ListenerRecord(componentName3));
            }
            object = this.mRecordMap.entrySet().iterator();
            while (object.hasNext()) {
                componentName3 = object.next();
                if (hashSet.contains(componentName3.getKey())) continue;
                if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                    Log.d((String)NotificationManagerCompat.TAG, (String)("Removing listener record for " + componentName3.getKey()));
                }
                this.ensureServiceUnbound(componentName3.getValue());
                object.remove();
            }
        }

        public boolean handleMessage(Message object) {
            switch (object.what) {
                default: {
                    return false;
                }
                case 3: {
                    this.handleRetryListenerQueue((ComponentName)object.obj);
                    return true;
                }
                case 2: {
                    this.handleServiceDisconnected((ComponentName)object.obj);
                    return true;
                }
                case 1: {
                    object = (ServiceConnectedEvent)object.obj;
                    this.handleServiceConnected(object.componentName, object.iBinder);
                    return true;
                }
                case 0: 
            }
            this.handleQueueTask((Task)object.obj);
            return true;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                Log.d((String)NotificationManagerCompat.TAG, (String)("Connected to service " + componentName));
            }
            this.mHandler.obtainMessage(1, (Object)new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable((String)NotificationManagerCompat.TAG, (int)3)) {
                Log.d((String)NotificationManagerCompat.TAG, (String)("Disconnected from service " + componentName));
            }
            this.mHandler.obtainMessage(2, (Object)componentName).sendToTarget();
        }

        public void queueTask(Task task) {
            this.mHandler.obtainMessage(0, (Object)task).sendToTarget();
        }

        private static class ListenerRecord {
            boolean bound = false;
            final ComponentName componentName;
            int retryCount = 0;
            INotificationSideChannel service;
            ArrayDeque<Task> taskQueue = new ArrayDeque();

            ListenerRecord(ComponentName componentName) {
                this.componentName = componentName;
            }
        }
    }

    private static interface Task {
        public void send(INotificationSideChannel var1) throws RemoteException;
    }
}

