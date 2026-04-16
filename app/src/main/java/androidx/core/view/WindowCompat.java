/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;

public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    private WindowCompat() {
    }

    public static WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    public static <T extends View> T requireViewById(Window window, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T)((View)Api28Impl.requireViewById(window, n));
        }
        if ((window = window.findViewById(n)) != null) {
            return (T)window;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void setDecorFitsSystemWindows(Window window, boolean bl) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setDecorFitsSystemWindows(window, bl);
        } else {
            Api16Impl.setDecorFitsSystemWindows(window, bl);
        }
    }

    static class Api16Impl {
        private Api16Impl() {
        }

        static void setDecorFitsSystemWindows(Window window, boolean bl) {
            window = window.getDecorView();
            int n = window.getSystemUiVisibility();
            n = bl ? (n &= 0xFFFFF8FF) : (n |= 0x700);
            window.setSystemUiVisibility(n);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Window window, int n) {
            return (T)window.requireViewById(n);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static void setDecorFitsSystemWindows(Window window, boolean bl) {
            window.setDecorFitsSystemWindows(bl);
        }
    }
}

