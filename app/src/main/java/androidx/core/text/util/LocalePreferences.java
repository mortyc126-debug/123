/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.icu.number.NumberFormatter
 *  android.icu.number.UnlocalizedNumberFormatter
 *  android.icu.text.DateFormat$HourCycle
 *  android.icu.text.DateTimePatternGenerator
 *  android.icu.util.Calendar
 *  android.icu.util.MeasureUnit
 *  android.os.Build$VERSION
 *  android.text.format.DateFormat
 */
package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.number.UnlocalizedNumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build;
import android.text.format.DateFormat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;

public final class LocalePreferences {
    private static final String TAG = LocalePreferences.class.getSimpleName();
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES = new String[]{"BS", "BZ", "KY", "PR", "PW", "US"};

    private LocalePreferences() {
    }

    private static String getBaseFirstDayOfWeek(Locale locale) {
        return LocalePreferences.getStringOfFirstDayOfWeek(java.util.Calendar.getInstance(locale).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(Locale object) {
        object = DateFormat.getBestDateTimePattern((Locale)object, (String)"jm").contains("H") ? "h23" : "h12";
        return object;
    }

    public static String getCalendarType() {
        return LocalePreferences.getCalendarType(true);
    }

    public static String getCalendarType(Locale locale) {
        return LocalePreferences.getCalendarType(locale, true);
    }

    public static String getCalendarType(Locale locale, boolean bl) {
        String string2 = LocalePreferences.getUnicodeLocaleType("ca", "", locale, bl);
        if (string2 != null) {
            return string2;
        }
        return Api24Impl.getCalendarType(locale);
    }

    public static String getCalendarType(boolean bl) {
        Locale locale = Api24Impl.getDefaultLocale();
        return LocalePreferences.getCalendarType(locale, bl);
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    public static String getFirstDayOfWeek() {
        return LocalePreferences.getFirstDayOfWeek(true);
    }

    public static String getFirstDayOfWeek(Locale locale) {
        return LocalePreferences.getFirstDayOfWeek(locale, true);
    }

    public static String getFirstDayOfWeek(Locale object, boolean bl) {
        String string2 = LocalePreferences.getUnicodeLocaleType("fw", "", (Locale)object, bl);
        object = string2 != null ? string2 : LocalePreferences.getBaseFirstDayOfWeek((Locale)object);
        return object;
    }

    public static String getFirstDayOfWeek(boolean bl) {
        Locale locale = Api24Impl.getDefaultLocale();
        return LocalePreferences.getFirstDayOfWeek(locale, bl);
    }

    public static String getHourCycle() {
        return LocalePreferences.getHourCycle(true);
    }

    public static String getHourCycle(Locale locale) {
        return LocalePreferences.getHourCycle(locale, true);
    }

    public static String getHourCycle(Locale locale, boolean bl) {
        String string2 = LocalePreferences.getUnicodeLocaleType("hc", "", locale, bl);
        if (string2 != null) {
            return string2;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getHourCycle(locale);
        }
        return LocalePreferences.getBaseHourCycle(locale);
    }

    public static String getHourCycle(boolean bl) {
        Locale locale = Api24Impl.getDefaultLocale();
        return LocalePreferences.getHourCycle(locale, bl);
    }

    private static String getStringOfFirstDayOfWeek(int n) {
        String string2 = n >= 1 && n <= 7 ? (new String[]{"sun", "mon", "tue", "wed", "thu", "fri", "sat"})[n - 1] : "";
        return string2;
    }

    private static String getTemperatureHardCoded(Locale object) {
        object = Arrays.binarySearch(WEATHER_FAHRENHEIT_COUNTRIES, ((Locale)object).getCountry()) >= 0 ? "fahrenhe" : "celsius";
        return object;
    }

    public static String getTemperatureUnit() {
        return LocalePreferences.getTemperatureUnit(true);
    }

    public static String getTemperatureUnit(Locale locale) {
        return LocalePreferences.getTemperatureUnit(locale, true);
    }

    public static String getTemperatureUnit(Locale locale, boolean bl) {
        String string2 = LocalePreferences.getUnicodeLocaleType("mu", "", locale, bl);
        if (string2 != null) {
            return string2;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getResolvedTemperatureUnit(locale);
        }
        return LocalePreferences.getTemperatureHardCoded(locale);
    }

    public static String getTemperatureUnit(boolean bl) {
        Locale locale = Api24Impl.getDefaultLocale();
        return LocalePreferences.getTemperatureUnit(locale, bl);
    }

    private static String getUnicodeLocaleType(String string2, String string3, Locale locale, boolean bl) {
        if ((string2 = locale.getUnicodeLocaleType(string2)) != null) {
            return string2;
        }
        if (!bl) {
            return string3;
        }
        return null;
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static String getCalendarType(Locale locale) {
            return Calendar.getInstance((Locale)locale).getType();
        }

        static Locale getDefaultLocale() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static String getHourCycle(Locale locale) {
            return Api33Impl.getHourCycleType(DateTimePatternGenerator.getInstance((Locale)locale).getDefaultHourCycle());
        }

        private static String getHourCycleType(DateFormat.HourCycle hourCycle) {
            switch (1.$SwitchMap$android$icu$text$DateFormat$HourCycle[hourCycle.ordinal()]) {
                default: {
                    return "";
                }
                case 4: {
                    return "h24";
                }
                case 3: {
                    return "h23";
                }
                case 2: {
                    return "h12";
                }
                case 1: 
            }
            return "h11";
        }

        static String getResolvedTemperatureUnit(Locale object) {
            object = ((UnlocalizedNumberFormatter)((UnlocalizedNumberFormatter)NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale((Locale)object).format(1L).getOutputUnit().getIdentifier();
            if (((String)object).startsWith("fahrenhe")) {
                return "fahrenhe";
            }
            return object;
        }
    }

    public static class CalendarType {
        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";
        private static final String U_EXTENSION_TAG = "ca";

        private CalendarType() {
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface CalendarTypes {
        }
    }

    public static class FirstDayOfWeek {
        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        private static final String U_EXTENSION_TAG = "fw";
        public static final String WEDNESDAY = "wed";

        private FirstDayOfWeek() {
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface Days {
        }
    }

    public static class HourCycle {
        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";
        private static final String U_EXTENSION_TAG = "hc";

        private HourCycle() {
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface HourCycleTypes {
        }
    }

    public static class TemperatureUnit {
        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";
        private static final String U_EXTENSION_TAG = "mu";

        private TemperatureUnit() {
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface TemperatureUnits {
        }
    }
}

