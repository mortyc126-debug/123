/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;

public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        if (sTempNestedScrollConsumed == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            ViewParentCompat.sTempNestedScrollConsumed[0] = 0;
            ViewParentCompat.sTempNestedScrollConsumed[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int n) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, n);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean bl) {
        try {
            bl = Api21Impl.onNestedFling(viewParent, view, f, f2, bl);
            return bl;
        }
        catch (AbstractMethodError abstractMethodError) {
            Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onNestedFling"), (Throwable)abstractMethodError);
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        try {
            boolean bl = Api21Impl.onNestedPreFling(viewParent, view, f, f2);
            return bl;
        }
        catch (AbstractMethodError abstractMethodError) {
            Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onNestedPreFling"), (Throwable)abstractMethodError);
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int n, int n2, int[] nArray) {
        ViewParentCompat.onNestedPreScroll(viewParent, view, n, n2, nArray, 0);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int n, int n2, int[] nArray, int n3) {
        block3: {
            block2: {
                if (!(viewParent instanceof NestedScrollingParent2)) break block2;
                ((NestedScrollingParent2)viewParent).onNestedPreScroll(view, n, n2, nArray, n3);
                break block3;
            }
            if (n3 != 0) break block3;
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, n, n2, nArray);
            }
            catch (AbstractMethodError abstractMethodError) {
                Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onNestedPreScroll"), (Throwable)abstractMethodError);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n, int n2, int n3, int n4) {
        ViewParentCompat.onNestedScroll(viewParent, view, n, n2, n3, n4, 0, ViewParentCompat.getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n, int n2, int n3, int n4, int n5) {
        ViewParentCompat.onNestedScroll(viewParent, view, n, n2, n3, n4, n5, ViewParentCompat.getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        block3: {
            block4: {
                block2: {
                    if (!(viewParent instanceof NestedScrollingParent3)) break block2;
                    ((NestedScrollingParent3)viewParent).onNestedScroll(view, n, n2, n3, n4, n5, nArray);
                    break block3;
                }
                nArray[0] = nArray[0] + n3;
                nArray[1] = nArray[1] + n4;
                if (!(viewParent instanceof NestedScrollingParent2)) break block4;
                ((NestedScrollingParent2)viewParent).onNestedScroll(view, n, n2, n3, n4, n5);
                break block3;
            }
            if (n5 != 0) break block3;
            try {
                Api21Impl.onNestedScroll(viewParent, view, n, n2, n3, n4);
            }
            catch (AbstractMethodError abstractMethodError) {
                Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onNestedScroll"), (Throwable)abstractMethodError);
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int n) {
        ViewParentCompat.onNestedScrollAccepted(viewParent, view, view2, n, 0);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int n, int n2) {
        block3: {
            block2: {
                if (!(viewParent instanceof NestedScrollingParent2)) break block2;
                ((NestedScrollingParent2)viewParent).onNestedScrollAccepted(view, view2, n, n2);
                break block3;
            }
            if (n2 != 0) break block3;
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, n);
            }
            catch (AbstractMethodError abstractMethodError) {
                Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted"), (Throwable)abstractMethodError);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int n) {
        return ViewParentCompat.onStartNestedScroll(viewParent, view, view2, n, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int n, int n2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2)viewParent).onStartNestedScroll(view, view2, n, n2);
        }
        if (n2 == 0) {
            try {
                boolean bl = Api21Impl.onStartNestedScroll(viewParent, view, view2, n);
                return bl;
            }
            catch (AbstractMethodError abstractMethodError) {
                Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onStartNestedScroll"), (Throwable)abstractMethodError);
            }
        }
        return false;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        ViewParentCompat.onStopNestedScroll(viewParent, view, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int n) {
        block3: {
            block2: {
                if (!(viewParent instanceof NestedScrollingParent2)) break block2;
                ((NestedScrollingParent2)viewParent).onStopNestedScroll(view, n);
                break block3;
            }
            if (n != 0) break block3;
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            }
            catch (AbstractMethodError abstractMethodError) {
                Log.e((String)TAG, (String)("ViewParent " + viewParent + " does not implement interface method onStopNestedScroll"), (Throwable)abstractMethodError);
            }
        }
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean bl) {
            return viewParent.onNestedFling(view, f, f2, bl);
        }

        static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
            return viewParent.onNestedPreFling(view, f, f2);
        }

        static void onNestedPreScroll(ViewParent viewParent, View view, int n, int n2, int[] nArray) {
            viewParent.onNestedPreScroll(view, n, n2, nArray);
        }

        static void onNestedScroll(ViewParent viewParent, View view, int n, int n2, int n3, int n4) {
            viewParent.onNestedScroll(view, n, n2, n3, n4);
        }

        static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int n) {
            viewParent.onNestedScrollAccepted(view, view2, n);
        }

        static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int n) {
            return viewParent.onStartNestedScroll(view, view2, n);
        }

        static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }
}

