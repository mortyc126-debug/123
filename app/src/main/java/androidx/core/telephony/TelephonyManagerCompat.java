/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 */
package androidx.core.telephony;

import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.telephony.SubscriptionManagerCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TelephonyManagerCompat {
    private static Method sGetDeviceIdMethod;
    private static Method sGetSubIdMethod;

    private TelephonyManagerCompat() {
    }

    public static String getImei(TelephonyManager telephonyManager) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getImei(telephonyManager);
        }
        int n = TelephonyManagerCompat.getSubscriptionId(telephonyManager);
        if (n != Integer.MAX_VALUE && n != -1) {
            n = SubscriptionManagerCompat.getSlotIndex(n);
            return Api23Impl.getDeviceId(telephonyManager, n);
        }
        return telephonyManager.getDeviceId();
    }

    public static int getSubscriptionId(TelephonyManager object) {
        block8: {
            if (Build.VERSION.SDK_INT >= 30) {
                return Api30Impl.getSubscriptionId((TelephonyManager)object);
            }
            if (sGetSubIdMethod == null) {
                sGetSubIdMethod = TelephonyManager.class.getDeclaredMethod("getSubId", new Class[0]);
                sGetSubIdMethod.setAccessible(true);
            }
            if ((object = (Integer)sGetSubIdMethod.invoke(object, new Object[0])) == null) break block8;
            try {
                if ((Integer)object != -1) {
                    int n = (Integer)object;
                    return n;
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {
                // empty catch block
            }
        }
        return Integer.MAX_VALUE;
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        static String getDeviceId(TelephonyManager telephonyManager, int n) {
            return telephonyManager.getDeviceId(n);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static String getImei(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getSubscriptionId(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }
}

