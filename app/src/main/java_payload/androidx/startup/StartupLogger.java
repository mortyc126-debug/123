/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.startup;

import android.util.Log;

public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void e(String string2, Throwable throwable) {
        Log.e((String)TAG, (String)string2, (Throwable)throwable);
    }

    public static void i(String string2) {
        Log.i((String)TAG, (String)string2);
    }

    public static void w(String string2) {
        Log.w((String)TAG, (String)string2);
    }
}

