/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityRecord
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_CONTENT_INVALID = 1024;
    public static final int CONTENT_CHANGE_TYPE_DRAG_CANCELLED = 512;
    public static final int CONTENT_CHANGE_TYPE_DRAG_DROPPED = 256;
    public static final int CONTENT_CHANGE_TYPE_DRAG_STARTED = 128;
    public static final int CONTENT_CHANGE_TYPE_ENABLED = 4096;
    public static final int CONTENT_CHANGE_TYPE_ERROR = 2048;
    public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
    public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32;
    public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
    public static final int CONTENT_CHANGE_TYPE_STATE_DESCRIPTION = 64;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 0x1000000;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    @Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    @Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 0x200000;
    public static final int TYPE_TOUCH_INTERACTION_START = 0x100000;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 0x800000;
    @Deprecated
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    @Deprecated
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    @Deprecated
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TARGETED_BY_SCROLL = 0x4000000;
    @Deprecated
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 0x400000;
    @Deprecated
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    private AccessibilityEventCompat() {
    }

    @Deprecated
    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        accessibilityEvent.appendRecord((AccessibilityRecord)accessibilityRecordCompat.getImpl());
    }

    @Deprecated
    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }

    public static int getAction(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getAction();
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static int getMovementGranularity(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getMovementGranularity();
    }

    @Deprecated
    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int n) {
        return new AccessibilityRecordCompat(accessibilityEvent.getRecord(n));
    }

    @Deprecated
    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static boolean isAccessibilityDataSensitive(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.isAccessibilityDataSensitive(accessibilityEvent);
        }
        return false;
    }

    public static void setAccessibilityDataSensitive(AccessibilityEvent accessibilityEvent, boolean bl) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setAccessibilityDataSensitive(accessibilityEvent, bl);
        }
    }

    public static void setAction(AccessibilityEvent accessibilityEvent, int n) {
        accessibilityEvent.setAction(n);
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int n) {
        accessibilityEvent.setContentChangeTypes(n);
    }

    public static void setMovementGranularity(AccessibilityEvent accessibilityEvent, int n) {
        accessibilityEvent.setMovementGranularity(n);
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static boolean isAccessibilityDataSensitive(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.isAccessibilityDataSensitive();
        }

        static void setAccessibilityDataSensitive(AccessibilityEvent accessibilityEvent, boolean bl) {
            accessibilityEvent.setAccessibilityDataSensitive(bl);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ContentChangeType {
    }
}

