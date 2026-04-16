/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.os.UserHandle
 */
package androidx.core.os;

import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

public final class ProcessCompat {
    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int n) {
        return Api24Impl.isApplicationUid(n);
    }

    static class Api19Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock;

        static {
            sResolvedLock = new Object();
        }

        private Api19Impl() {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        static boolean isApplicationUid(int n) {
            Object object;
            block8: {
                object = sResolvedLock;
                // MONITORENTER : object
                if (sResolved) break block8;
                sResolved = true;
                sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
            }
            // MONITOREXIT : object
            try {
                if (sMethodUserHandleIsAppMethod == null) return true;
                object = (Boolean)sMethodUserHandleIsAppMethod.invoke(null, n);
                if (object != null) {
                    return (Boolean)object;
                }
                object = new NullPointerException();
                throw object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static boolean isApplicationUid(int n) {
            return Process.isApplicationUid((int)n);
        }
    }
}

