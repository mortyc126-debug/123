/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ServiceCompat {
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_Q = 255;
    private static final int FOREGROUND_SERVICE_TYPE_ALLOWED_SINCE_U = 0x40000FFF;
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    private ServiceCompat() {
    }

    public static void startForeground(Service service, int n, Notification notification, int n2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.startForeground(service, n, notification, n2);
        } else if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.startForeground(service, n, notification, n2);
        } else {
            service.startForeground(n, notification);
        }
    }

    public static void stopForeground(Service service, int n) {
        Api24Impl.stopForeground(service, n);
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void stopForeground(Service service, int n) {
            service.stopForeground(n);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void startForeground(Service service, int n, Notification notification, int n2) {
            if (n2 != 0 && n2 != -1) {
                service.startForeground(n, notification, n2 & 0xFF);
            } else {
                service.startForeground(n, notification, n2);
            }
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static void startForeground(Service service, int n, Notification notification, int n2) {
            if (n2 != 0 && n2 != -1) {
                service.startForeground(n, notification, 0x40000FFF & n2);
            } else {
                service.startForeground(n, notification, n2);
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface StopForegroundFlags {
    }
}

