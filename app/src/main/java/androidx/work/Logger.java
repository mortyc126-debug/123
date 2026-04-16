/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.work;

import android.util.Log;

public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static final Object sLock;
    private static volatile Logger sLogger;

    static {
        sLock = new Object();
        MAX_PREFIXED_TAG_LENGTH = 23 - TAG_PREFIX.length();
    }

    public Logger(int n) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Logger get() {
        Object object = sLock;
        synchronized (object) {
            if (sLogger != null) return sLogger;
            Logger logger = new LogcatLogger(3);
            sLogger = logger;
            return sLogger;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setLogger(Logger logger) {
        Object object = sLock;
        synchronized (object) {
            sLogger = logger;
            return;
        }
    }

    public static String tagWithPrefix(String string2) {
        int n = string2.length();
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(TAG_PREFIX);
        if (n >= MAX_PREFIXED_TAG_LENGTH) {
            stringBuilder.append(string2.substring(0, MAX_PREFIXED_TAG_LENGTH));
        } else {
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public abstract void debug(String var1, String var2);

    public abstract void debug(String var1, String var2, Throwable var3);

    public abstract void error(String var1, String var2);

    public abstract void error(String var1, String var2, Throwable var3);

    public abstract void info(String var1, String var2);

    public abstract void info(String var1, String var2, Throwable var3);

    public abstract void verbose(String var1, String var2);

    public abstract void verbose(String var1, String var2, Throwable var3);

    public abstract void warning(String var1, String var2);

    public abstract void warning(String var1, String var2, Throwable var3);

    public static class LogcatLogger
    extends Logger {
        private final int mLoggingLevel;

        public LogcatLogger(int n) {
            super(n);
            this.mLoggingLevel = n;
        }

        @Override
        public void debug(String string2, String string3) {
            if (this.mLoggingLevel <= 3) {
                Log.d((String)string2, (String)string3);
            }
        }

        @Override
        public void debug(String string2, String string3, Throwable throwable) {
            if (this.mLoggingLevel <= 3) {
                Log.d((String)string2, (String)string3, (Throwable)throwable);
            }
        }

        @Override
        public void error(String string2, String string3) {
            if (this.mLoggingLevel <= 6) {
                Log.e((String)string2, (String)string3);
            }
        }

        @Override
        public void error(String string2, String string3, Throwable throwable) {
            if (this.mLoggingLevel <= 6) {
                Log.e((String)string2, (String)string3, (Throwable)throwable);
            }
        }

        @Override
        public void info(String string2, String string3) {
            if (this.mLoggingLevel <= 4) {
                Log.i((String)string2, (String)string3);
            }
        }

        @Override
        public void info(String string2, String string3, Throwable throwable) {
            if (this.mLoggingLevel <= 4) {
                Log.i((String)string2, (String)string3, (Throwable)throwable);
            }
        }

        @Override
        public void verbose(String string2, String string3) {
            if (this.mLoggingLevel <= 2) {
                Log.v((String)string2, (String)string3);
            }
        }

        @Override
        public void verbose(String string2, String string3, Throwable throwable) {
            if (this.mLoggingLevel <= 2) {
                Log.v((String)string2, (String)string3, (Throwable)throwable);
            }
        }

        @Override
        public void warning(String string2, String string3) {
            if (this.mLoggingLevel <= 5) {
                Log.w((String)string2, (String)string3);
            }
        }

        @Override
        public void warning(String string2, String string3, Throwable throwable) {
            if (this.mLoggingLevel <= 5) {
                Log.w((String)string2, (String)string3, (Throwable)throwable);
            }
        }
    }
}

