/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(ViewGroup viewGroup) {
        return viewGroup.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return Api21Impl.getNestedScrollAxes(viewGroup);
    }

    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return Api21Impl.isTransitionGroup(viewGroup);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void setLayoutMode(ViewGroup viewGroup, int n) {
        viewGroup.setLayoutMode(n);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean bl) {
        viewGroup.setMotionEventSplittingEnabled(bl);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean bl) {
        Api21Impl.setTransitionGroup(viewGroup, bl);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void setTransitionGroup(ViewGroup viewGroup, boolean bl) {
            viewGroup.setTransitionGroup(bl);
        }
    }
}

