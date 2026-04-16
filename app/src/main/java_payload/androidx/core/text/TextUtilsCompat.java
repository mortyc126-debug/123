/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
    private TextUtilsCompat() {
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale((Locale)locale);
    }

    public static String htmlEncode(String string2) {
        return TextUtils.htmlEncode((String)string2);
    }
}

