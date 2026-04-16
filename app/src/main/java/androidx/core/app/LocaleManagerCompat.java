/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.LocaleManager
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 */
package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.app.AppLocalesStorageHelper;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class LocaleManagerCompat {
    private LocaleManagerCompat() {
    }

    public static LocaleListCompat getApplicationLocales(Context object) {
        if (Build.VERSION.SDK_INT >= 33) {
            if ((object = LocaleManagerCompat.getLocaleManagerForApplication(object)) != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(object));
            }
            return LocaleListCompat.getEmptyLocaleList();
        }
        return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(object));
    }

    static LocaleListCompat getConfigurationLocales(Configuration configuration2) {
        return Api24Impl.getLocales(configuration2);
    }

    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    public static LocaleListCompat getSystemLocales(Context object) {
        LocaleListCompat localeListCompat = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT >= 33) {
            Object object2 = LocaleManagerCompat.getLocaleManagerForApplication(object);
            object = localeListCompat;
            if (object2 != null) {
                object = LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(object2));
            }
        } else {
            object = LocaleManagerCompat.getConfigurationLocales(Resources.getSystem().getConfiguration());
        }
        return object;
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleListCompat getLocales(Configuration configuration2) {
            return LocaleListCompat.forLanguageTags(configuration2.getLocales().toLanguageTags());
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static LocaleList localeManagerGetApplicationLocales(Object object) {
            return ((LocaleManager)object).getApplicationLocales();
        }

        static LocaleList localeManagerGetSystemLocales(Object object) {
            return ((LocaleManager)object).getSystemLocales();
        }
    }
}

