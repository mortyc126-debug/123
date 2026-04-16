/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityWindowInfo
 */
package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    public AccessibilityWindowInfoCompat() {
        this.mInfo = Build.VERSION.SDK_INT >= 30 ? Api30Impl.instantiateAccessibilityWindowInfo() : null;
    }

    private AccessibilityWindowInfoCompat(Object object) {
        this.mInfo = object;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        accessibilityWindowInfoCompat = accessibilityWindowInfoCompat == null ? null : AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo)accessibilityWindowInfoCompat.mInfo));
        return accessibilityWindowInfoCompat;
    }

    private static String typeToString(int n) {
        switch (n) {
            default: {
                return "<UNKNOWN>";
            }
            case 4: {
                return "TYPE_ACCESSIBILITY_OVERLAY";
            }
            case 3: {
                return "TYPE_SYSTEM";
            }
            case 2: {
                return "TYPE_INPUT_METHOD";
            }
            case 1: 
        }
        return "TYPE_APPLICATION";
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            return new AccessibilityWindowInfoCompat(object);
        }
        return null;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        object = (AccessibilityWindowInfoCompat)object;
        if (this.mInfo == null) {
            if (((AccessibilityWindowInfoCompat)object).mInfo != null) {
                bl = false;
            }
            return bl;
        }
        return this.mInfo.equals(((AccessibilityWindowInfoCompat)object).mInfo);
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo)this.mInfo));
    }

    public void getBoundsInScreen(Rect rect) {
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo)this.mInfo, rect);
    }

    public AccessibilityWindowInfoCompat getChild(int n) {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo)this.mInfo, n));
    }

    public int getChildCount() {
        return Api21Impl.getChildCount((AccessibilityWindowInfo)this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getDisplayId((AccessibilityWindowInfo)this.mInfo);
        }
        return 0;
    }

    public int getId() {
        return Api21Impl.getId((AccessibilityWindowInfo)this.mInfo);
    }

    public int getLayer() {
        return Api21Impl.getLayer((AccessibilityWindowInfo)this.mInfo);
    }

    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocaleListCompat.wrap(Api34Impl.getLocales((AccessibilityWindowInfo)this.mInfo));
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public AccessibilityWindowInfoCompat getParent() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo)this.mInfo));
    }

    public void getRegionInScreen(Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.getRegionInScreen((AccessibilityWindowInfo)this.mInfo, region);
        } else {
            Rect rect = new Rect();
            Api21Impl.getBoundsInScreen((AccessibilityWindowInfo)this.mInfo, rect);
            region.set(rect);
        }
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo)this.mInfo));
    }

    public AccessibilityNodeInfoCompat getRoot(int n) {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getRoot(this.mInfo, n);
        }
        return this.getRoot();
    }

    public CharSequence getTitle() {
        return Api24Impl.getTitle((AccessibilityWindowInfo)this.mInfo);
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getTransitionTimeMillis((AccessibilityWindowInfo)this.mInfo);
        }
        return 0L;
    }

    public int getType() {
        return Api21Impl.getType((AccessibilityWindowInfo)this.mInfo);
    }

    public int hashCode() {
        int n = this.mInfo == null ? 0 : this.mInfo.hashCode();
        return n;
    }

    public boolean isAccessibilityFocused() {
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo)this.mInfo);
    }

    public boolean isActive() {
        return Api21Impl.isActive((AccessibilityWindowInfo)this.mInfo);
    }

    public boolean isFocused() {
        return Api21Impl.isFocused((AccessibilityWindowInfo)this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.isInPictureInPictureMode((AccessibilityWindowInfo)this.mInfo);
        }
        return false;
    }

    @Deprecated
    public void recycle() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = new Rect();
        this.getBoundsInScreen((Rect)object);
        stringBuilder.append("AccessibilityWindowInfo[");
        stringBuilder.append("id=").append(this.getId());
        stringBuilder.append(", type=").append(AccessibilityWindowInfoCompat.typeToString(this.getType()));
        stringBuilder.append(", layer=").append(this.getLayer());
        stringBuilder.append(", bounds=").append(object);
        stringBuilder.append(", focused=").append(this.isFocused());
        stringBuilder.append(", active=").append(this.isActive());
        StringBuilder stringBuilder2 = stringBuilder.append(", hasParent=");
        object = this.getParent();
        boolean bl = true;
        boolean bl2 = object != null;
        stringBuilder2.append(bl2);
        object = stringBuilder.append(", hasChildren=");
        bl2 = this.getChildCount() > 0 ? bl : false;
        ((StringBuilder)object).append(bl2);
        stringBuilder.append(", transitionTime=").append(this.getTransitionTimeMillis());
        stringBuilder.append(", locales=").append(this.getLocales());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo)this.mInfo;
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void getBoundsInScreen(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo accessibilityWindowInfo, int n) {
            return accessibilityWindowInfo.getChild(n);
        }

        static int getChildCount(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        static int getId(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        static int getLayer(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        static int getType(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        static boolean isAccessibilityFocused(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        static boolean isActive(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        static boolean isFocused(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain((AccessibilityWindowInfo)accessibilityWindowInfo);
        }
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        static CharSequence getTitle(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static boolean isInPictureInPictureMode(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            return new AccessibilityWindowInfo();
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static int getDisplayId(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        static void getRegionInScreen(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        public static AccessibilityNodeInfoCompat getRoot(Object object, int n) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo)object).getRoot(n));
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static LocaleList getLocales(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        public static long getTransitionTimeMillis(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }
}

