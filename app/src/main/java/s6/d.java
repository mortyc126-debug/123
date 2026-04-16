package s6;

import amuvvoafs.os.Bundle;
import amuvvoafs.view.accessibility.AccessibilityNodeInfo;
import amuvvoafs.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends AccessibilityNodeProvider {
    public final rs1.d a;

    public d(rs1.d dVar) {
        this.a = dVar;
    }

    public final void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        this.a.v(i, new c(accessibilityNodeInfo), str, bundle);
    }

    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        c cVarX = this.a.x(i);
        if (cVarX == null) {
            return null;
        }
        return cVarX.a;
    }

    public final List findAccessibilityNodeInfosByText(String str, int i) {
        this.a.getClass();
        return null;
    }

    public final AccessibilityNodeInfo findFocus(int i) {
        c cVarY = this.a.y(i);
        if (cVarY == null) {
            return null;
        }
        return cVarY.a;
    }

    public final boolean performAction(int i, int i2, Bundle bundle) {
        return this.a.H(i, i2, bundle);
    }
}
