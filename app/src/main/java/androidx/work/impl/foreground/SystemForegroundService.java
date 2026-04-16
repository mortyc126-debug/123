/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ForegroundServiceStartNotAllowedException
 *  android.app.Notification
 *  android.app.NotificationManager
 *  android.app.Service
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

public class SystemForegroundService
extends LifecycleService
implements SystemForegroundDispatcher.Callback {
    private static final String TAG = Logger.tagWithPrefix("SystemFgService");
    private static SystemForegroundService sForegroundService = null;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager)this.getApplicationContext().getSystemService("notification");
        this.mDispatcher = new SystemForegroundDispatcher(this.getApplicationContext());
        this.mDispatcher.setCallback(this);
    }

    @Override
    public void cancelNotification(int n) {
        this.mHandler.post(new Runnable(){
            final SystemForegroundService this$0;
            final int val$notificationId;
            {
                this.this$0 = systemForegroundService;
                this.val$notificationId = n;
            }

            @Override
            public void run() {
                this.this$0.mNotificationManager.cancel(this.val$notificationId);
            }
        });
    }

    @Override
    public void notify(int n, Notification notification) {
        this.mHandler.post(new Runnable(){
            final SystemForegroundService this$0;
            final Notification val$notification;
            final int val$notificationId;
            {
                this.this$0 = systemForegroundService;
                this.val$notificationId = n;
                this.val$notification = notification;
            }

            @Override
            public void run() {
                this.this$0.mNotificationManager.notify(this.val$notificationId, this.val$notification);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        this.initializeDispatcher();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int n, int n2) {
        super.onStartCommand(intent, n, n2);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.mDispatcher.onDestroy();
            this.initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent != null) {
            this.mDispatcher.onStartCommand(intent);
        }
        return 3;
    }

    @Override
    public void startForeground(int n, int n2, Notification notification) {
        this.mHandler.post(new Runnable(){
            final SystemForegroundService this$0;
            final Notification val$notification;
            final int val$notificationId;
            final int val$notificationType;
            {
                this.this$0 = systemForegroundService;
                this.val$notificationId = n;
                this.val$notification = notification;
                this.val$notificationType = n2;
            }

            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= 31) {
                    Api31Impl.startForeground(this.this$0, this.val$notificationId, this.val$notification, this.val$notificationType);
                } else if (Build.VERSION.SDK_INT >= 29) {
                    Api29Impl.startForeground(this.this$0, this.val$notificationId, this.val$notification, this.val$notificationType);
                } else {
                    this.this$0.startForeground(this.val$notificationId, this.val$notification);
                }
            }
        });
    }

    @Override
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.");
        if (Build.VERSION.SDK_INT >= 26) {
            this.stopForeground(true);
        }
        sForegroundService = null;
        this.stopSelf();
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void startForeground(Service service, int n, Notification notification, int n2) {
            service.startForeground(n, notification, n2);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static void startForeground(Service service, int n, Notification notification, int n2) {
            try {
                service.startForeground(n, notification, n2);
            }
            catch (SecurityException securityException) {
                Logger.get().warning(TAG, "Unable to start foreground service", securityException);
            }
            catch (ForegroundServiceStartNotAllowedException foregroundServiceStartNotAllowedException) {
                Logger.get().warning(TAG, "Unable to start foreground service", foregroundServiceStartNotAllowedException);
            }
        }
    }
}

