/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.telephony.SubscriptionManager
 */
package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    private SubscriptionManagerCompat() {
    }

    public static int getSlotIndex(int n) {
        block8: {
            Integer n2;
            if (n == -1) {
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return Api29Impl.getSlotIndex(n);
            }
            if (sGetSlotIndexMethod == null) {
                sGetSlotIndexMethod = Build.VERSION.SDK_INT >= 26 ? SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE) : SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                sGetSlotIndexMethod.setAccessible(true);
            }
            if ((n2 = (Integer)sGetSlotIndexMethod.invoke(null, n)) == null) break block8;
            try {
                n = n2;
                return n;
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
        }
        return -1;
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static int getSlotIndex(int n) {
            return SubscriptionManager.getSlotIndex((int)n);
        }
    }
}

