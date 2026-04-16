/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.telephony.mbms.ServiceInfo
 */
package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;

public final class MbmsHelper {
    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context context, ServiceInfo serviceInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getBestNameForService(context, serviceInfo);
        }
        return null;
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static CharSequence getBestNameForService(Context object, ServiceInfo serviceInfo) {
            String[] stringArray = serviceInfo.getNamedContentLocales();
            boolean bl = stringArray.isEmpty();
            Object var4_4 = null;
            if (bl) {
                return null;
            }
            stringArray = new String[stringArray.size()];
            int n = 0;
            Iterator iterator2 = serviceInfo.getNamedContentLocales().iterator();
            while (iterator2.hasNext()) {
                stringArray[n] = ((Locale)iterator2.next()).toLanguageTag();
                ++n;
            }
            object = (object = object.getResources().getConfiguration().getLocales().getFirstMatch(stringArray)) == null ? var4_4 : serviceInfo.getNameForLocale((Locale)object);
            return object;
        }
    }
}

