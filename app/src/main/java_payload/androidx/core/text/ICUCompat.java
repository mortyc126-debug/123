/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.icu.util.ULocale
 *  android.util.Log
 */
package androidx.core.text;

import android.icu.util.ULocale;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    private ICUCompat() {
    }

    private static String addLikelySubtagsBelowApi21(Locale object) {
        object = ((Locale)object).toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                String string2 = (String)sAddLikelySubtagsMethod.invoke(null, object);
                return string2;
            }
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)TAG, (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)TAG, (Throwable)illegalAccessException);
        }
        return object;
    }

    private static String getScriptBelowApi21(String string2) {
        try {
            if (sGetScriptMethod != null) {
                string2 = (String)sGetScriptMethod.invoke(null, string2);
                return string2;
            }
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.w((String)TAG, (Throwable)invocationTargetException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)TAG, (Throwable)illegalAccessException);
        }
        return null;
    }

    public static String maximizeAndGetScript(Locale locale) {
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(locale)));
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static String getScript(Locale locale) {
            return locale.getScript();
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale addLikelySubtags(Object object) {
            return ULocale.addLikelySubtags((ULocale)((ULocale)object));
        }

        static ULocale forLocale(Locale locale) {
            return ULocale.forLocale((Locale)locale);
        }

        static String getScript(Object object) {
            return ((ULocale)object).getScript();
        }
    }
}

