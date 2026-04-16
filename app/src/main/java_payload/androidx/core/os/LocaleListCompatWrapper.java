/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.os;

import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

final class LocaleListCompatWrapper
implements LocaleListInterface {
    private static final Locale EN_LATN;
    private static final Locale LOCALE_AR_XB;
    private static final Locale LOCALE_EN_XA;
    private static final Locale[] sEmptyList;
    private final Locale[] mList;
    private final String mStringRepresentation;

    static {
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = new Locale("en", "XA");
        LOCALE_AR_XB = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    LocaleListCompatWrapper(Locale ... localeArray) {
        if (localeArray.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
        } else {
            ArrayList<Locale> arrayList = new ArrayList<Locale>();
            HashSet<Locale> hashSet = new HashSet<Locale>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < localeArray.length; ++i) {
                Locale locale = localeArray[i];
                if (locale != null) {
                    if (hashSet.contains(locale)) continue;
                    locale = (Locale)locale.clone();
                    arrayList.add(locale);
                    LocaleListCompatWrapper.toLanguageTag(stringBuilder, locale);
                    if (i < localeArray.length - 1) {
                        stringBuilder.append(',');
                    }
                    hashSet.add(locale);
                    continue;
                }
                throw new NullPointerException("list[" + i + "] is null");
            }
            this.mList = arrayList.toArray(new Locale[0]);
            this.mStringRepresentation = stringBuilder.toString();
        }
    }

    private Locale computeFirstMatch(Collection<String> object, boolean bl) {
        int n = this.computeFirstMatchIndex((Collection<String>)object, bl);
        object = n == -1 ? null : this.mList[n];
        return object;
    }

    private int computeFirstMatchIndex(Collection<String> object, boolean bl) {
        int n;
        int n2;
        if (this.mList.length == 1) {
            return 0;
        }
        if (this.mList.length == 0) {
            return -1;
        }
        int n3 = n2 = Integer.MAX_VALUE;
        if (bl) {
            n = this.findFirstMatchIndex(EN_LATN);
            if (n == 0) {
                return 0;
            }
            n3 = n2;
            if (n < Integer.MAX_VALUE) {
                n3 = n;
            }
        }
        object = object.iterator();
        n = n3;
        while (object.hasNext()) {
            n2 = this.findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat((String)object.next()));
            if (n2 == 0) {
                return 0;
            }
            n3 = n;
            if (n2 < n) {
                n3 = n2;
            }
            n = n3;
        }
        if (n == Integer.MAX_VALUE) {
            return 0;
        }
        return n;
    }

    private int findFirstMatchIndex(Locale locale) {
        for (int i = 0; i < this.mList.length; ++i) {
            if (LocaleListCompatWrapper.matchScore(locale, this.mList[i]) <= 0) continue;
            return i;
        }
        return Integer.MAX_VALUE;
    }

    private static String getLikelyScript(Locale object) {
        if (!((String)(object = Api21Impl.getScript((Locale)object))).isEmpty()) {
            return object;
        }
        return "";
    }

    private static boolean isPseudoLocale(Locale locale) {
        boolean bl = LOCALE_EN_XA.equals(locale) || LOCALE_AR_XB.equals(locale);
        return bl;
    }

    private static int matchScore(Locale object, Locale locale) {
        boolean bl = ((Locale)object).equals(locale);
        int n = 1;
        if (bl) {
            return 1;
        }
        if (!((Locale)object).getLanguage().equals(locale.getLanguage())) {
            return 0;
        }
        if (!LocaleListCompatWrapper.isPseudoLocale((Locale)object) && !LocaleListCompatWrapper.isPseudoLocale(locale)) {
            String string2 = LocaleListCompatWrapper.getLikelyScript((Locale)object);
            if (string2.isEmpty()) {
                if (!((String)(object = ((Locale)object).getCountry())).isEmpty() && !((String)object).equals(locale.getCountry())) {
                    n = 0;
                }
                return n;
            }
            return string2.equals(LocaleListCompatWrapper.getLikelyScript(locale)) ? 1 : 0;
        }
        return 0;
    }

    static void toLanguageTag(StringBuilder stringBuilder, Locale locale) {
        stringBuilder.append(locale.getLanguage());
        String string2 = locale.getCountry();
        if (string2 != null && !string2.isEmpty()) {
            stringBuilder.append('-');
            stringBuilder.append(locale.getCountry());
        }
    }

    public boolean equals(Object localeArray) {
        if (localeArray == this) {
            return true;
        }
        if (!(localeArray instanceof LocaleListCompatWrapper)) {
            return false;
        }
        localeArray = ((LocaleListCompatWrapper)localeArray).mList;
        if (this.mList.length != localeArray.length) {
            return false;
        }
        for (int i = 0; i < this.mList.length; ++i) {
            if (this.mList[i].equals(localeArray[i])) continue;
            return false;
        }
        return true;
    }

    @Override
    public Locale get(int n) {
        Locale locale = n >= 0 && n < this.mList.length ? this.mList[n] : null;
        return locale;
    }

    @Override
    public Locale getFirstMatch(String[] stringArray) {
        return this.computeFirstMatch(Arrays.asList(stringArray), false);
    }

    @Override
    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        int n = 1;
        Locale[] localeArray = this.mList;
        int n2 = localeArray.length;
        for (int i = 0; i < n2; ++i) {
            n = n * 31 + localeArray[i].hashCode();
        }
        return n;
    }

    @Override
    public int indexOf(Locale locale) {
        for (int i = 0; i < this.mList.length; ++i) {
            if (!this.mList[i].equals(locale)) continue;
            return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.mList.length == 0;
        return bl;
    }

    @Override
    public int size() {
        return this.mList.length;
    }

    @Override
    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.mList.length; ++i) {
            stringBuilder.append(this.mList[i]);
            if (i >= this.mList.length - 1) continue;
            stringBuilder.append(',');
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getScript(Locale locale) {
            return locale.getScript();
        }
    }
}

