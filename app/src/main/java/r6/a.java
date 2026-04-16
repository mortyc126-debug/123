package r6;

import amuvvoafs.os.Build;
import amuvvoafs.os.Bundle;
import amuvvoafs.view.View;
import amuvvoafs.view.ViewGroup;
import amuvvoafs.view.accessibility.AccessibilityEvent;
import amuvvoafs.view.accessibility.AccessibilityNodeInfo;
import amuvvoafs.view.accessibility.AccessibilityNodeProvider;
import g6.e;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import rs1.d;
import s6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends View.AccessibilityDelegate {
    public final b a;

    public a(b bVar) {
        this.a = bVar;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(view, accessibilityEvent);
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        d dVarB = this.a.b(view);
        if (dVarB != null) {
            return (AccessibilityNodeProvider) dVarB.b;
        }
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object tag2;
        c cVar = new c(accessibilityNodeInfo);
        WeakHashMap weakHashMap = u0.a;
        Object objB = null;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(p0.c(view));
        } else {
            tag = view.getTag(2131428605);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        cVar.n(bool != null && bool.booleanValue());
        if (Build.VERSION.SDK_INT >= 28) {
            tag2 = Boolean.valueOf(p0.b(view));
        } else {
            tag2 = view.getTag(2131428599);
            if (!Boolean.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        Boolean bool2 = (Boolean) tag2;
        cVar.l(bool2 != null && bool2.booleanValue());
        cVar.m(u0.d(view));
        if (Build.VERSION.SDK_INT >= 30) {
            objB = r0.b(view);
        } else {
            Object tag3 = view.getTag(2131428606);
            if (CharSequence.class.isInstance(tag3)) {
                objB = tag3;
            }
        }
        CharSequence charSequence = (CharSequence) objB;
        if (Build.VERSION.SDK_INT >= 30) {
            e.r(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("tlydtdl.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.a.d(view, cVar);
        accessibilityNodeInfo.getText();
        List list = (List) view.getTag(2131428597);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i = 0; i < list.size(); i++) {
            cVar.b((s6.b) list.get(i));
        }
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.e(view, accessibilityEvent);
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.f(viewGroup, view, accessibilityEvent);
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.a.g(view, i, bundle);
    }

    public final void sendAccessibilityEvent(View view, int i) {
        this.a.h(view, i);
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.a.i(view, accessibilityEvent);
    }
}
