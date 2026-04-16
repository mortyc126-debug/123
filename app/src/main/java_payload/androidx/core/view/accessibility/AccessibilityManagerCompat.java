/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityServiceInfo
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityManager
 *  android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener
 *  android.view.accessibility.AccessibilityManager$TouchExplorationStateChangeListener
 */
package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public final class AccessibilityManagerCompat {
    private AccessibilityManagerCompat() {
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.addAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)new AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener));
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return accessibilityManager.addTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int n) {
        return accessibilityManager.getEnabledAccessibilityServiceList(n);
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(AccessibilityManager accessibilityManager) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.isRequestFromAccessibilityTool(accessibilityManager);
        }
        return true;
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isTouchExplorationEnabled();
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        if (accessibilityStateChangeListener == null) {
            return false;
        }
        return accessibilityManager.removeAccessibilityStateChangeListener((AccessibilityManager.AccessibilityStateChangeListener)new AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener));
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return accessibilityManager.removeTouchExplorationStateChangeListener((AccessibilityManager.TouchExplorationStateChangeListener)new TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
    }

    @Deprecated
    public static interface AccessibilityStateChangeListener {
        @Deprecated
        public void onAccessibilityStateChanged(boolean var1);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat
    implements AccessibilityStateChangeListener {
    }

    private static class AccessibilityStateChangeListenerWrapper
    implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(AccessibilityStateChangeListener accessibilityStateChangeListener) {
            this.mListener = accessibilityStateChangeListener;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof AccessibilityStateChangeListenerWrapper)) {
                return false;
            }
            object = (AccessibilityStateChangeListenerWrapper)object;
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper)object).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public void onAccessibilityStateChanged(boolean bl) {
            this.mListener.onAccessibilityStateChanged(bl);
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static boolean isRequestFromAccessibilityTool(AccessibilityManager accessibilityManager) {
            return accessibilityManager.isRequestFromAccessibilityTool();
        }
    }

    public static interface TouchExplorationStateChangeListener {
        public void onTouchExplorationStateChanged(boolean var1);
    }

    private static final class TouchExplorationStateChangeListenerWrapper
    implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            this.mListener = touchExplorationStateChangeListener;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof TouchExplorationStateChangeListenerWrapper)) {
                return false;
            }
            object = (TouchExplorationStateChangeListenerWrapper)object;
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper)object).mListener);
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public void onTouchExplorationStateChanged(boolean bl) {
            this.mListener.onTouchExplorationStateChanged(bl);
        }
    }
}

