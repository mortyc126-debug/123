/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.view;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    private HapticFeedbackConstantsCompat() {
    }

    static int getFeedbackConstantOrFallback(int n) {
        if (n == -1) {
            return -1;
        }
        int n2 = n;
        if (Build.VERSION.SDK_INT < 34) {
            switch (n) {
                default: {
                    n2 = n;
                    break;
                }
                case 25: {
                    n2 = 0;
                    break;
                }
                case 22: 
                case 24: 
                case 27: {
                    n2 = 4;
                    break;
                }
                case 21: 
                case 23: 
                case 26: {
                    n2 = 6;
                }
            }
        }
        n = n2;
        if (Build.VERSION.SDK_INT < 30) {
            switch (n2) {
                default: {
                    n = n2;
                    break;
                }
                case 17: {
                    n = 0;
                    break;
                }
                case 13: {
                    n = 6;
                    break;
                }
                case 12: 
                case 16: {
                    n = 1;
                }
            }
        }
        n2 = n;
        if (Build.VERSION.SDK_INT < 27) {
            switch (n) {
                default: {
                    n2 = n;
                    break;
                }
                case 7: 
                case 8: 
                case 9: {
                    n2 = -1;
                }
            }
        }
        return n2;
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface HapticFeedbackFlags {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface HapticFeedbackType {
    }
}

