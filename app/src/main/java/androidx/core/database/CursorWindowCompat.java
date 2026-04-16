/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CursorWindow
 *  android.os.Build$VERSION
 */
package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    public static CursorWindow create(String string2, long l) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createCursorWindow(string2, l);
        }
        return new CursorWindow(string2);
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static CursorWindow createCursorWindow(String string2, long l) {
            return new CursorWindow(string2, l);
        }
    }
}

