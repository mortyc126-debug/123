package fd;

import amuvvoafs.app.job.JobScheduler;
import amuvvoafs.graphics.Rect;
import amuvvoafs.os.Build;
import amuvvoafs.view.accessibility.AccessibilityManager;
import amuvvoafs.view.accessibility.AccessibilityNodeInfo;
import amuvvoafs.view.inputmethod.CursorAnchorInfo;
import amuvvoafs.view.inputmethod.DeleteGesture;
import amuvvoafs.view.inputmethod.DeleteRangeGesture;
import amuvvoafs.view.inputmethod.EditorInfo;
import amuvvoafs.view.inputmethod.InsertGesture;
import amuvvoafs.view.inputmethod.JoinOrSplitGesture;
import amuvvoafs.view.inputmethod.RemoveSpaceGesture;
import amuvvoafs.view.inputmethod.SelectGesture;
import amuvvoafs.view.inputmethod.SelectRangeGesture;
import com.bandlab.user.profile.screen.UserProfileActivity;
import d5.m0;
import d5.r;
import lmjxuqdtp.jvm.internal.o;
import mx1.n;
import tlydtdl.activity.ComponentActivity;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final void a(CursorAnchorInfo.Builder builder, m0 m0Var, z3.c cVar) {
        if (cVar.m()) {
            return;
        }
        float f2 = cVar.b;
        r rVar = m0Var.b;
        int iE = rVar.e(f2);
        int iE2 = rVar.e(cVar.d);
        if (iE > iE2) {
            return;
        }
        while (true) {
            builder.addVisibleLineBounds(m0Var.e(iE), rVar.f(iE), m0Var.f(iE), rVar.b(iE));
            if (iE == iE2) {
                return;
            } else {
                iE++;
            }
        }
    }

    public static JobScheduler b(JobScheduler jobScheduler) {
        JobScheduler jobSchedulerForNamespace = jobScheduler.forNamespace("tlydtdl.work.systemjobscheduler");
        o.g(jobSchedulerForNamespace, "forNamespace(...)");
        return jobSchedulerForNamespace;
    }

    public static AccessibilityNodeInfo.AccessibilityAction c() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    public static void d(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static boolean g(AccessibilityManager accessibilityManager) {
        return accessibilityManager.isRequestFromAccessibilityTool();
    }

    public static final void h(ComponentActivity componentActivity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            componentActivity.overrideActivityTransition(1, i, i2);
        } else {
            componentActivity.overridePendingTransition(i, i2);
        }
    }

    public static final void i(UserProfileActivity userProfileActivity, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 34) {
            userProfileActivity.overrideActivityTransition(0, i, i2);
        } else {
            userProfileActivity.overridePendingTransition(i, i2);
        }
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z);
    }

    public static void k(EditorInfo editorInfo) {
        editorInfo.setSupportedHandwritingGestures(ct1.b.C(new Class[]{SelectGesture.class, DeleteGesture.class, SelectRangeGesture.class, DeleteRangeGesture.class, JoinOrSplitGesture.class, InsertGesture.class, RemoveSpaceGesture.class}));
        editorInfo.setSupportedHandwritingGesturePreviews(n.C0(new Class[]{SelectGesture.class, DeleteGesture.class, SelectRangeGesture.class, DeleteRangeGesture.class}));
    }
}
