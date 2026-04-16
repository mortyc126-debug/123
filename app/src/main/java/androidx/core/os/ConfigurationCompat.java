/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.LocaleList
 */
package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;

public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration configuration2) {
        return LocaleListCompat.wrap(Api24Impl.getLocales(configuration2));
    }

    public static void setLocales(Configuration configuration2, LocaleListCompat localeListCompat) {
        Api24Impl.setLocales(configuration2, localeListCompat);
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList getLocales(Configuration configuration2) {
            return configuration2.getLocales();
        }

        static void setLocales(Configuration configuration2, LocaleListCompat localeListCompat) {
            configuration2.setLocales((LocaleList)localeListCompat.unwrap());
        }
    }
}

