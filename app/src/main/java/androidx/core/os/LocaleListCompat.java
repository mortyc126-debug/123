/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 */
package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListInterface;
import androidx.core.os.LocaleListPlatformWrapper;
import androidx.core.text.ICUCompat;
import java.util.Locale;

public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = LocaleListCompat.create(new Locale[0]);
    private final LocaleListInterface mImpl;

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    public static LocaleListCompat create(Locale ... localeArray) {
        return LocaleListCompat.wrap(Api24Impl.createLocaleList(localeArray));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static Locale forLanguageTagCompat(String string2) {
        if (string2.contains("-")) {
            String[] stringArray = string2.split("-", -1);
            if (stringArray.length > 2) {
                return new Locale(stringArray[0], stringArray[1], stringArray[2]);
            }
            if (stringArray.length > 1) {
                return new Locale(stringArray[0], stringArray[1]);
            }
            if (stringArray.length != 1) throw new IllegalArgumentException("Can not parse language tag: [" + string2 + "]");
            return new Locale(stringArray[0]);
        }
        if (!string2.contains("_")) return new Locale(string2);
        String[] stringArray = string2.split("_", -1);
        if (stringArray.length > 2) {
            return new Locale(stringArray[0], stringArray[1], stringArray[2]);
        }
        if (stringArray.length > 1) {
            return new Locale(stringArray[0], stringArray[1]);
        }
        if (stringArray.length != 1) throw new IllegalArgumentException("Can not parse language tag: [" + string2 + "]");
        return new Locale(stringArray[0]);
    }

    public static LocaleListCompat forLanguageTags(String stringArray) {
        if (stringArray != null && !stringArray.isEmpty()) {
            stringArray = stringArray.split(",", -1);
            Locale[] localeArray = new Locale[stringArray.length];
            for (int i = 0; i < localeArray.length; ++i) {
                localeArray[i] = Api21Impl.forLanguageTag(stringArray[i]);
            }
            return LocaleListCompat.create(localeArray);
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static LocaleListCompat getAdjustedDefault() {
        return LocaleListCompat.wrap(Api24Impl.getAdjustedDefault());
    }

    public static LocaleListCompat getDefault() {
        return LocaleListCompat.wrap(Api24Impl.getDefault());
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    public static boolean matchesLanguageAndScript(Locale locale, Locale locale2) {
        if (Build.VERSION.SDK_INT >= 33) {
            return LocaleList.matchesLanguageAndScript((Locale)locale, (Locale)locale2);
        }
        return Api21Impl.matchesLanguageAndScript(locale, locale2);
    }

    public static LocaleListCompat wrap(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    @Deprecated
    public static LocaleListCompat wrap(Object object) {
        return LocaleListCompat.wrap((LocaleList)object);
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof LocaleListCompat && this.mImpl.equals(((LocaleListCompat)object).mImpl);
        return bl;
    }

    public Locale get(int n) {
        return this.mImpl.get(n);
    }

    public Locale getFirstMatch(String[] stringArray) {
        return this.mImpl.getFirstMatch(stringArray);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public int indexOf(Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};

        private Api21Impl() {
        }

        static Locale forLanguageTag(String string2) {
            return Locale.forLanguageTag(string2);
        }

        private static boolean isPseudoLocale(Locale locale) {
            Locale[] localeArray = PSEUDO_LOCALE;
            int n = localeArray.length;
            for (int i = 0; i < n; ++i) {
                if (!localeArray[i].equals(locale)) continue;
                return true;
            }
            return false;
        }

        static boolean matchesLanguageAndScript(Locale object, Locale locale) {
            boolean bl = ((Locale)object).equals(locale);
            boolean bl2 = true;
            if (bl) {
                return true;
            }
            if (!((Locale)object).getLanguage().equals(locale.getLanguage())) {
                return false;
            }
            if (!Api21Impl.isPseudoLocale((Locale)object) && !Api21Impl.isPseudoLocale(locale)) {
                String string2 = ICUCompat.maximizeAndGetScript((Locale)object);
                if (string2.isEmpty()) {
                    object = ((Locale)object).getCountry();
                    bl = bl2;
                    if (!((String)object).isEmpty()) {
                        bl = ((String)object).equals(locale.getCountry()) ? bl2 : false;
                    }
                    return bl;
                }
                return string2.equals(ICUCompat.maximizeAndGetScript(locale));
            }
            return false;
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList createLocaleList(Locale ... localeArray) {
            return new LocaleList(localeArray);
        }

        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }
}

