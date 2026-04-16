/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeProvider
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    public AccessibilityNodeProviderCompat() {
        this.mProvider = Build.VERSION.SDK_INT >= 26 ? new AccessibilityNodeProviderApi26(this) : new AccessibilityNodeProviderApi19(this);
    }

    public AccessibilityNodeProviderCompat(Object object) {
        this.mProvider = object;
    }

    public void addExtraDataToAccessibilityNodeInfo(int n, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String string2, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int n) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String string2, int n) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int n) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int n, int n2, Bundle bundle) {
        return false;
    }

    static class AccessibilityNodeProviderApi19
    extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.mCompat = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int n) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mCompat.createAccessibilityNodeInfo(n);
            if (accessibilityNodeInfoCompat == null) {
                return null;
            }
            return accessibilityNodeInfoCompat.unwrap();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String object, int n) {
            List<AccessibilityNodeInfoCompat> list = this.mCompat.findAccessibilityNodeInfosByText((String)object, n);
            if (list == null) {
                return null;
            }
            object = new ArrayList();
            int n2 = list.size();
            for (n = 0; n < n2; ++n) {
                object.add(list.get(n).unwrap());
            }
            return object;
        }

        public AccessibilityNodeInfo findFocus(int n) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = this.mCompat.findFocus(n);
            if (accessibilityNodeInfoCompat == null) {
                return null;
            }
            return accessibilityNodeInfoCompat.unwrap();
        }

        public boolean performAction(int n, int n2, Bundle bundle) {
            return this.mCompat.performAction(n, n2, bundle);
        }
    }

    static class AccessibilityNodeProviderApi26
    extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int n, AccessibilityNodeInfo accessibilityNodeInfo, String string2, Bundle bundle) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(n, AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo), string2, bundle);
        }
    }
}

