/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Trace
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                sTraceCounterMethod = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            catch (Exception exception) {
                Log.i((String)TAG, (String)"Unable to initialize via reflection.", (Throwable)exception);
            }
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(String string2, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.beginAsyncSection(string2, n);
        } else {
            try {
                sAsyncTraceBeginMethod.invoke(null, sTraceTagApp, string2, n);
            }
            catch (Exception exception) {
                Log.v((String)TAG, (String)"Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(String string2) {
        Trace.beginSection((String)string2);
    }

    public static void endAsyncSection(String string2, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.endAsyncSection(string2, n);
        } else {
            try {
                sAsyncTraceEndMethod.invoke(null, sTraceTagApp, string2, n);
            }
            catch (Exception exception) {
                Log.v((String)TAG, (String)"Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.isEnabled();
        }
        try {
            boolean bl = (Boolean)sIsTagEnabledMethod.invoke(null, sTraceTagApp);
            return bl;
        }
        catch (Exception exception) {
            Log.v((String)TAG, (String)"Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }

    public static void setCounter(String string2, int n) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setCounter(string2, n);
        } else {
            try {
                sTraceCounterMethod.invoke(null, sTraceTagApp, string2, n);
            }
            catch (Exception exception) {
                Log.v((String)TAG, (String)"Unable to invoke traceCounter() via reflection.");
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void beginAsyncSection(String string2, int n) {
            Trace.beginAsyncSection((String)string2, (int)n);
        }

        static void endAsyncSection(String string2, int n) {
            Trace.endAsyncSection((String)string2, (int)n);
        }

        static boolean isEnabled() {
            return Trace.isEnabled();
        }

        static void setCounter(String string2, long l) {
            Trace.setCounter((String)string2, (long)l);
        }
    }
}

