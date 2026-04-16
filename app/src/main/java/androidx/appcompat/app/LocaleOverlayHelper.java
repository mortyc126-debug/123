/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.LocaleList
 */
package androidx.appcompat.app;

import android.os.LocaleList;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    private static LocaleListCompat combineLocales(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        LinkedHashSet<Locale> linkedHashSet = new LinkedHashSet<Locale>();
        for (int i = 0; i < localeListCompat.size() + localeListCompat2.size(); ++i) {
            Locale locale = i < localeListCompat.size() ? localeListCompat.get(i) : localeListCompat2.get(i - localeListCompat.size());
            if (locale == null) continue;
            linkedHashSet.add(locale);
        }
        return LocaleListCompat.create(linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleList localeList, LocaleList localeList2) {
        if (localeList != null && !localeList.isEmpty()) {
            return LocaleOverlayHelper.combineLocales(LocaleListCompat.wrap(localeList), LocaleListCompat.wrap(localeList2));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    static LocaleListCompat combineLocalesIfOverlayExists(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat != null && !localeListCompat.isEmpty()) {
            return LocaleOverlayHelper.combineLocales(localeListCompat, localeListCompat2);
        }
        return LocaleListCompat.getEmptyLocaleList();
    }
}

