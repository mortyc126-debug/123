/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    private HandlerCompat() {
    }

    /*
     * WARNING - void declaration
     */
    public static Handler createAsync(Looper looper) {
        void var1_7;
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper);
        }
        try {
            Handler handler = (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            return handler;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (!(throwable instanceof RuntimeException)) {
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new RuntimeException(throwable);
            }
            throw (RuntimeException)throwable;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        Log.w((String)TAG, (String)"Unable to invoke Handler(Looper, Callback, boolean) constructor", (Throwable)var1_7);
        return new Handler(looper);
    }

    /*
     * WARNING - void declaration
     */
    public static Handler createAsync(Looper looper, Handler.Callback callback2) {
        void var2_8;
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper, callback2);
        }
        try {
            Handler handler = (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, callback2, true);
            return handler;
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (!(throwable instanceof RuntimeException)) {
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw new RuntimeException(throwable);
            }
            throw (RuntimeException)throwable;
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        Log.w((String)TAG, (String)"Unable to invoke Handler(Looper, Callback, boolean) constructor", (Throwable)var2_8);
        return new Handler(looper, callback2);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean hasCallbacks(Handler handler, Runnable runnable2) {
        void var0_4;
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.hasCallbacks(handler, runnable2);
        }
        try {
            return (Boolean)Handler.class.getMethod("hasCallbacks", Runnable.class).invoke((Object)handler, runnable2);
        }
        catch (NullPointerException nullPointerException) {
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", (Throwable)var0_4);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", (Throwable)var0_4);
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
            throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", (Throwable)var0_4);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) throw (RuntimeException)throwable;
            if (!(throwable instanceof Error)) throw new RuntimeException(throwable);
            throw (Error)throwable;
        }
    }

    public static boolean postDelayed(Handler handler, Runnable runnable2, Object object, long l) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.postDelayed(handler, runnable2, object, l);
        }
        runnable2 = Message.obtain((Handler)handler, (Runnable)runnable2);
        ((Message)runnable2).obj = object;
        return handler.sendMessageDelayed((Message)runnable2, l);
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper looper) {
            return Handler.createAsync((Looper)looper);
        }

        public static Handler createAsync(Looper looper, Handler.Callback callback2) {
            return Handler.createAsync((Looper)looper, (Handler.Callback)callback2);
        }

        public static boolean postDelayed(Handler handler, Runnable runnable2, Object object, long l) {
            return handler.postDelayed(runnable2, object, l);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler handler, Runnable runnable2) {
            return handler.hasCallbacks(runnable2);
        }
    }
}

