/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.GrammaticalInflectionManager
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class GrammaticalInflectionManagerCompat {
    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED = 0;

    private GrammaticalInflectionManagerCompat() {
    }

    public static int getApplicationGrammaticalGender(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getApplicationGrammaticalGender(context);
        }
        return 0;
    }

    public static void setRequestedApplicationGrammaticalGender(Context context, int n) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setRequestedApplicationGrammaticalGender(context, n);
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static int getApplicationGrammaticalGender(Context context) {
            return Api34Impl.getGrammaticalInflectionManager(context).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager getGrammaticalInflectionManager(Context context) {
            return (GrammaticalInflectionManager)context.getSystemService(GrammaticalInflectionManager.class);
        }

        static void setRequestedApplicationGrammaticalGender(Context context, int n) {
            Api34Impl.getGrammaticalInflectionManager(context).setRequestedApplicationGrammaticalGender(n);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface GrammaticalGender {
    }
}

