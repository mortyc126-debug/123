/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package androidx.core.os;

import android.os.Message;

public final class MessageCompat {
    private static boolean sTryIsAsynchronous;
    private static boolean sTrySetAsynchronous;

    static {
        sTrySetAsynchronous = true;
        sTryIsAsynchronous = true;
    }

    private MessageCompat() {
    }

    public static boolean isAsynchronous(Message message) {
        return Api22Impl.isAsynchronous(message);
    }

    public static void setAsynchronous(Message message, boolean bl) {
        Api22Impl.setAsynchronous(message, bl);
    }

    static class Api22Impl {
        private Api22Impl() {
        }

        static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        static void setAsynchronous(Message message, boolean bl) {
            message.setAsynchronous(bl);
        }
    }
}

