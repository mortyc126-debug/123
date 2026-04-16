/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ClipData
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.ContentInfo
 *  android.view.Display
 *  android.view.KeyEvent
 *  android.view.OnReceiveContentListener
 *  android.view.PointerIcon
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$DragShadowBuilder
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnUnhandledKeyEventListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.Window
 *  android.view.WindowInsets
 *  android.view.WindowInsetsController
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityManager
 *  android.view.autofill.AutofillId
 *  android.view.contentcapture.ContentCaptureSession
 */
package androidx.core.view;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.SimpleArrayMap;
import androidx.core.R;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.HapticFeedbackConstantsCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.OnReceiveContentListener;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat$$ExternalSyntheticLambda0;
import androidx.core.view.ViewCompat$Api28Impl$$ExternalSyntheticLambda0;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.autofill.AutofillIdCompat;
import androidx.core.view.contentcapture.ContentCaptureSessionCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class ViewCompat {
    private static final int[] ACCESSIBILITY_ACTIONS_RESOURCE_IDS;
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    @Deprecated
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    @Deprecated
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    @Deprecated
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    @Deprecated
    public static final int LAYOUT_DIRECTION_LTR = 0;
    @Deprecated
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 0xFFFFFF;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 0x1000000;
    private static final OnReceiveContentViewBehavior NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static boolean sAccessibilityDelegateCheckFailed;
    private static Field sAccessibilityDelegateField;
    private static final AccessibilityPaneVisibilityManager sAccessibilityPaneVisibilityManager;
    private static Method sChildrenDrawingOrderMethod;
    private static Method sDispatchFinishTemporaryDetach;
    private static Method sDispatchStartTemporaryDetach;
    private static boolean sTempDetachBound;
    private static ThreadLocal<Rect> sThreadLocalRect;
    private static WeakHashMap<View, String> sTransitionNameMap;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> sViewPropertyAnimatorMap;

    static {
        sViewPropertyAnimatorMap = null;
        sAccessibilityDelegateCheckFailed = false;
        ACCESSIBILITY_ACTIONS_RESOURCE_IDS = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR = new ViewCompat$$ExternalSyntheticLambda0();
        sAccessibilityPaneVisibilityManager = new AccessibilityPaneVisibilityManager();
    }

    @Deprecated
    protected ViewCompat() {
    }

    private static AccessibilityViewProperty<Boolean> accessibilityHeadingProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_accessibility_heading, Boolean.class, 28){

            @Override
            Boolean frameworkGet(View view) {
                return Api28Impl.isAccessibilityHeading(view);
            }

            @Override
            void frameworkSet(View view, Boolean bl) {
                Api28Impl.setAccessibilityHeading(view, bl);
            }

            @Override
            boolean shouldUpdate(Boolean bl, Boolean bl2) {
                return this.booleanNullToFalseEquals(bl, bl2) ^ true;
            }
        };
    }

    public static int addAccessibilityAction(View view, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int n = ViewCompat.getAvailableActionIdFromResources(view, charSequence);
        if (n != -1) {
            ViewCompat.addAccessibilityAction(view, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(n, charSequence, accessibilityViewCommand));
        }
        return n;
    }

    private static void addAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat) {
        ViewCompat.ensureAccessibilityDelegateCompat(view);
        ViewCompat.removeActionWithId(accessibilityActionCompat.getId(), view);
        ViewCompat.getActionList(view).add(accessibilityActionCompat);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    public static void addKeyboardNavigationClusters(View view, Collection<View> collection, int n) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.addKeyboardNavigationClusters(view, collection, n);
        }
    }

    public static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        ArrayList<OnUnhandledKeyEventListenerCompat> arrayList;
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.addOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList<OnUnhandledKeyEventListenerCompat> arrayList2 = arrayList = (ArrayList<OnUnhandledKeyEventListenerCompat>)view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null) {
            arrayList2 = new ArrayList<OnUnhandledKeyEventListenerCompat>();
            view.setTag(R.id.tag_unhandled_key_listeners, arrayList2);
        }
        arrayList2.add(onUnhandledKeyEventListenerCompat);
        if (arrayList2.size() == 1) {
            UnhandledKeyEventManager.registerListeningView(view);
        }
    }

    @Deprecated
    public static ViewPropertyAnimatorCompat animate(View view) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        if (sViewPropertyAnimatorMap == null) {
            sViewPropertyAnimatorMap = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat = sViewPropertyAnimatorMap.get(view);
        if (viewPropertyAnimatorCompat == null) {
            viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
            sViewPropertyAnimatorMap.put(view, viewPropertyAnimatorCompat2);
        }
        return viewPropertyAnimatorCompat2;
    }

    private static void bindTempDetach() {
        try {
            sDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
            sDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)TAG, (String)"Couldn't find method", (Throwable)noSuchMethodException);
        }
        sTempDetachBound = true;
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int n) {
        return view.canScrollHorizontally(n);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int n) {
        return view.canScrollVertically(n);
    }

    public static void cancelDragAndDrop(View view) {
        Api24Impl.cancelDragAndDrop(view);
    }

    @Deprecated
    public static int combineMeasuredStates(int n, int n2) {
        return View.combineMeasuredStates((int)n, (int)n2);
    }

    private static void compatOffsetLeftAndRight(View view, int n) {
        view.offsetLeftAndRight(n);
        if (view.getVisibility() == 0) {
            ViewCompat.tickleInvalidationFlag(view);
            view = view.getParent();
            if (view instanceof View) {
                ViewCompat.tickleInvalidationFlag(view);
            }
        }
    }

    private static void compatOffsetTopAndBottom(View view, int n) {
        view.offsetTopAndBottom(n);
        if (view.getVisibility() == 0) {
            ViewCompat.tickleInvalidationFlag(view);
            view = view.getParent();
            if (view instanceof View) {
                ViewCompat.tickleInvalidationFlag(view);
            }
        }
    }

    public static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        return Api21Impl.computeSystemWindowInsets(view, windowInsetsCompat, rect);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2 = windowInsetsCompat.toWindowInsets();
        if (windowInsets2 != null && !(windowInsets = Api20Impl.dispatchApplyWindowInsets(view, windowInsets2)).equals((Object)windowInsets2)) {
            return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        }
        return windowInsetsCompat;
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        Api24Impl.dispatchFinishTemporaryDetach(view);
    }

    public static boolean dispatchNestedFling(View view, float f, float f2, boolean bl) {
        return Api21Impl.dispatchNestedFling(view, f, f2, bl);
    }

    public static boolean dispatchNestedPreFling(View view, float f, float f2) {
        return Api21Impl.dispatchNestedPreFling(view, f, f2);
    }

    public static boolean dispatchNestedPreScroll(View view, int n, int n2, int[] nArray, int[] nArray2) {
        return Api21Impl.dispatchNestedPreScroll(view, n, n2, nArray, nArray2);
    }

    public static boolean dispatchNestedPreScroll(View view, int n, int n2, int[] nArray, int[] nArray2, int n3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view).dispatchNestedPreScroll(n, n2, nArray, nArray2, n3);
        }
        if (n3 == 0) {
            return ViewCompat.dispatchNestedPreScroll(view, n, n2, nArray, nArray2);
        }
        return false;
    }

    public static void dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray, int n5, int[] nArray2) {
        if (view instanceof NestedScrollingChild3) {
            ((NestedScrollingChild3)view).dispatchNestedScroll(n, n2, n3, n4, nArray, n5, nArray2);
        } else {
            ViewCompat.dispatchNestedScroll(view, n, n2, n3, n4, nArray, n5);
        }
    }

    public static boolean dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray) {
        return Api21Impl.dispatchNestedScroll(view, n, n2, n3, n4, nArray);
    }

    public static boolean dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray, int n5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view).dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
        }
        if (n5 == 0) {
            return ViewCompat.dispatchNestedScroll(view, n, n2, n3, n4, nArray);
        }
        return false;
    }

    public static void dispatchStartTemporaryDetach(View view) {
        Api24Impl.dispatchStartTemporaryDetach(view);
    }

    static boolean dispatchUnhandledKeyEventBeforeCallback(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).dispatch(view, keyEvent);
    }

    static boolean dispatchUnhandledKeyEventBeforeHierarchy(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return UnhandledKeyEventManager.at(view).preDispatch(keyEvent);
    }

    public static void enableAccessibleClickableSpanSupport(View view) {
        ViewCompat.ensureAccessibilityDelegateCompat(view);
    }

    static void ensureAccessibilityDelegateCompat(View view) {
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        AccessibilityDelegateCompat accessibilityDelegateCompat2 = accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(view);
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateCompat2 = new AccessibilityDelegateCompat();
        }
        ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat2);
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    public static AccessibilityDelegateCompat getAccessibilityDelegate(View view) {
        if ((view = ViewCompat.getAccessibilityDelegateInternal(view)) == null) {
            return null;
        }
        if (view instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
            return ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter)view).mCompat;
        }
        return new AccessibilityDelegateCompat((View.AccessibilityDelegate)view);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateInternal(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getAccessibilityDelegate(view);
        }
        return ViewCompat.getAccessibilityDelegateThroughReflection(view);
    }

    private static View.AccessibilityDelegate getAccessibilityDelegateThroughReflection(View object) {
        if (sAccessibilityDelegateCheckFailed) {
            return null;
        }
        if (sAccessibilityDelegateField == null) {
            try {
                sAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
                sAccessibilityDelegateField.setAccessible(true);
            }
            catch (Throwable throwable) {
                sAccessibilityDelegateCheckFailed = true;
                return null;
            }
        }
        try {
            object = sAccessibilityDelegateField.get(object);
            if (object instanceof View.AccessibilityDelegate) {
                object = (View.AccessibilityDelegate)object;
                return object;
            }
            return null;
        }
        catch (Throwable throwable) {
            sAccessibilityDelegateCheckFailed = true;
            return null;
        }
    }

    @Deprecated
    public static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if ((view = view.getAccessibilityNodeProvider()) != null) {
            return new AccessibilityNodeProviderCompat(view);
        }
        return null;
    }

    public static CharSequence getAccessibilityPaneTitle(View view) {
        return ViewCompat.paneTitleProperty().get(view);
    }

    private static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> getActionList(View view) {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList = (ArrayList)view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
        }
        return arrayList2;
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    public static AutofillIdCompat getAutofillId(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return AutofillIdCompat.toAutofillIdCompat(Api26Impl.getAutofillId(view));
        }
        return null;
    }

    private static int getAvailableActionIdFromResources(View object, CharSequence charSequence) {
        int n;
        int n2 = -1;
        object = ViewCompat.getActionList((View)object);
        for (n = 0; n < object.size(); ++n) {
            if (!TextUtils.equals((CharSequence)charSequence, (CharSequence)((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(n)).getLabel())) continue;
            return ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(n)).getId();
        }
        for (n = 0; n < ACCESSIBILITY_ACTIONS_RESOURCE_IDS.length && n2 == -1; ++n) {
            int n3 = ACCESSIBILITY_ACTIONS_RESOURCE_IDS[n];
            boolean bl = true;
            for (int i = 0; i < object.size(); ++i) {
                boolean bl2 = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(i)).getId() != n3;
                bl &= bl2;
            }
            if (!bl) continue;
            n2 = n3;
        }
        return n2;
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return Api21Impl.getBackgroundTintList(view);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return Api21Impl.getBackgroundTintMode(view);
    }

    @Deprecated
    public static Rect getClipBounds(View view) {
        return view.getClipBounds();
    }

    public static ContentCaptureSessionCompat getContentCaptureSession(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentCaptureSession contentCaptureSession = Api29Impl.getContentCaptureSession(view);
            if (contentCaptureSession == null) {
                return null;
            }
            return ContentCaptureSessionCompat.toContentCaptureSessionCompat(contentCaptureSession, view);
        }
        return null;
    }

    @Deprecated
    public static Display getDisplay(View view) {
        return view.getDisplay();
    }

    public static float getElevation(View view) {
        return Api21Impl.getElevation(view);
    }

    private static Rect getEmptyTempRect() {
        Rect rect;
        if (sThreadLocalRect == null) {
            sThreadLocalRect = new ThreadLocal();
        }
        Rect rect2 = rect = sThreadLocalRect.get();
        if (rect == null) {
            rect2 = new Rect();
            sThreadLocalRect.set(rect2);
        }
        rect2.setEmpty();
        return rect2;
    }

    private static OnReceiveContentViewBehavior getFallback(View view) {
        if (view instanceof OnReceiveContentViewBehavior) {
            return (OnReceiveContentViewBehavior)view;
        }
        return NO_OP_ON_RECEIVE_CONTENT_VIEW_BEHAVIOR;
    }

    @Deprecated
    public static boolean getFitsSystemWindows(View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    public static int getImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getImportantForAutofill(view);
        }
        return 0;
    }

    public static int getImportantForContentCapture(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getImportantForContentCapture(view);
        }
        return 0;
    }

    @Deprecated
    public static int getLabelFor(View view) {
        return view.getLabelFor();
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    @Deprecated
    public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @Deprecated
    public static int getMinimumHeight(View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static int getMinimumWidth(View view) {
        return view.getMinimumWidth();
    }

    public static int getNextClusterForwardId(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getNextClusterForwardId(view);
        }
        return -1;
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getReceiveContentMimeTypes(view);
        }
        return (String[])view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @Deprecated
    public static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    @Deprecated
    public static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    @Deprecated
    public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        return Api23Impl.getRootWindowInsets(view);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    public static int getScrollIndicators(View view) {
        return Api23Impl.getScrollIndicators(view);
    }

    public static CharSequence getStateDescription(View view) {
        return ViewCompat.stateDescriptionProperty().get(view);
    }

    public static List<Rect> getSystemGestureExclusionRects(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getSystemGestureExclusionRects(view);
        }
        return Collections.emptyList();
    }

    public static String getTransitionName(View view) {
        return Api21Impl.getTransitionName(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static float getTranslationZ(View view) {
        return Api21Impl.getTranslationZ(view);
    }

    @Deprecated
    public static WindowInsetsControllerCompat getWindowInsetsController(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getWindowInsetsController(view);
        }
        Object object = view.getContext();
        while (true) {
            boolean bl = object instanceof ContextWrapper;
            Object var3_3 = null;
            if (!bl) break;
            if (object instanceof Activity) {
                Window window = ((Activity)object).getWindow();
                object = var3_3;
                if (window != null) {
                    object = WindowCompat.getInsetsController(window, view);
                }
                return object;
            }
            object = ((ContextWrapper)object).getBaseContext();
        }
        return null;
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(View view) {
        return view.getWindowSystemUiVisibility();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static float getZ(View view) {
        return Api21Impl.getZ(view);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        boolean bl = ViewCompat.getAccessibilityDelegateInternal(view) != null;
        return bl;
    }

    public static boolean hasExplicitFocusable(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.hasExplicitFocusable(view);
        }
        return view.hasFocusable();
    }

    public static boolean hasNestedScrollingParent(View view) {
        return Api21Impl.hasNestedScrollingParent(view);
    }

    public static boolean hasNestedScrollingParent(View view, int n) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2)view).hasNestedScrollingParent(n);
        } else if (n == 0) {
            return ViewCompat.hasNestedScrollingParent(view);
        }
        return false;
    }

    @Deprecated
    public static boolean hasOnClickListeners(View view) {
        return view.hasOnClickListeners();
    }

    @Deprecated
    public static boolean hasOverlappingRendering(View view) {
        return view.hasOverlappingRendering();
    }

    @Deprecated
    public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View object) {
        object = ViewCompat.accessibilityHeadingProperty().get((View)object);
        boolean bl = object != null && ((Boolean)object).booleanValue();
        return bl;
    }

    @Deprecated
    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean isFocusedByDefault(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.isFocusedByDefault(view);
        }
        return false;
    }

    public static boolean isImportantForAccessibility(View view) {
        return Api21Impl.isImportantForAccessibility(view);
    }

    public static boolean isImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.isImportantForAutofill(view);
        }
        return true;
    }

    public static boolean isImportantForContentCapture(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.isImportantForContentCapture(view);
        }
        return false;
    }

    @Deprecated
    public static boolean isInLayout(View view) {
        return view.isInLayout();
    }

    public static boolean isKeyboardNavigationCluster(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.isKeyboardNavigationCluster(view);
        }
        return false;
    }

    @Deprecated
    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    @Deprecated
    public static boolean isLayoutDirectionResolved(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return Api21Impl.isNestedScrollingEnabled(view);
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    @Deprecated
    public static boolean isPaddingRelative(View view) {
        return view.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View object) {
        object = ViewCompat.screenReaderFocusableProperty().get((View)object);
        boolean bl = object != null && ((Boolean)object).booleanValue();
        return bl;
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static View keyboardNavigationClusterSearch(View view, View view2, int n) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.keyboardNavigationClusterSearch(view, view2, n);
        }
        return null;
    }

    static /* synthetic */ ContentInfoCompat lambda$static$0(ContentInfoCompat contentInfoCompat) {
        return contentInfoCompat;
    }

    static void notifyViewAccessibilityStateChangedIfNeeded(View view, int n) {
        AccessibilityManager accessibilityManager = (AccessibilityManager)view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        boolean bl = ViewCompat.getAccessibilityPaneTitle(view) != null && view.isShown() && view.getWindowVisibility() == 0;
        int n2 = view.getAccessibilityLiveRegion();
        int n3 = 32;
        if (n2 == 0 && !bl) {
            if (n == 32) {
                AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.setEventType(32);
                accessibilityEvent.setContentChangeTypes(n);
                accessibilityEvent.setSource(view);
                view.onPopulateAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.getText().add(ViewCompat.getAccessibilityPaneTitle(view));
                accessibilityManager.sendAccessibilityEvent(accessibilityEvent);
            } else if (view.getParent() != null) {
                ViewParent viewParent = view.getParent();
                try {
                    viewParent.notifySubtreeAccessibilityStateChanged(view, view, n);
                }
                catch (AbstractMethodError abstractMethodError) {
                    Log.e((String)TAG, (String)(view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent"), (Throwable)abstractMethodError);
                }
            }
        } else {
            AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
            if (!bl) {
                n3 = 2048;
            }
            accessibilityEvent.setEventType(n3);
            accessibilityEvent.setContentChangeTypes(n);
            if (bl) {
                accessibilityEvent.getText().add(ViewCompat.getAccessibilityPaneTitle(view));
                ViewCompat.setImportantForAccessibilityIfNeeded(view);
            }
            view.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public static void offsetLeftAndRight(View view, int n) {
        view.offsetLeftAndRight(n);
    }

    public static void offsetTopAndBottom(View view, int n) {
        view.offsetTopAndBottom(n);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsets windowInsets;
        WindowInsets windowInsets2 = windowInsetsCompat.toWindowInsets();
        if (windowInsets2 != null && !(windowInsets = Api20Impl.onApplyWindowInsets(view, windowInsets2)).equals((Object)windowInsets2)) {
            return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        }
        return windowInsetsCompat;
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    private static AccessibilityViewProperty<CharSequence> paneTitleProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28){

            @Override
            CharSequence frameworkGet(View view) {
                return Api28Impl.getAccessibilityPaneTitle(view);
            }

            @Override
            void frameworkSet(View view, CharSequence charSequence) {
                Api28Impl.setAccessibilityPaneTitle(view, charSequence);
            }

            @Override
            boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return TextUtils.equals((CharSequence)charSequence, (CharSequence)charSequence2) ^ true;
            }
        };
    }

    @Deprecated
    public static boolean performAccessibilityAction(View view, int n, Bundle bundle) {
        return view.performAccessibilityAction(n, bundle);
    }

    public static boolean performHapticFeedback(View view, int n) {
        if ((n = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(n)) == -1) {
            return false;
        }
        return view.performHapticFeedback(n);
    }

    public static boolean performHapticFeedback(View view, int n, int n2) {
        if ((n = HapticFeedbackConstantsCompat.getFeedbackConstantOrFallback(n)) == -1) {
            return false;
        }
        return view.performHapticFeedback(n, n2);
    }

    public static ContentInfoCompat performReceiveContent(View object, ContentInfoCompat contentInfoCompat) {
        if (Log.isLoggable((String)TAG, (int)3)) {
            Log.d((String)TAG, (String)("performReceiveContent: " + contentInfoCompat + ", view=" + object.getClass().getSimpleName() + "[" + object.getId() + "]"));
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.performReceiveContent(object, contentInfoCompat);
        }
        OnReceiveContentListener onReceiveContentListener = (OnReceiveContentListener)object.getTag(R.id.tag_on_receive_content_listener);
        if (onReceiveContentListener != null) {
            object = (contentInfoCompat = onReceiveContentListener.onReceiveContent((View)object, contentInfoCompat)) == null ? null : ViewCompat.getFallback(object).onReceiveContent(contentInfoCompat);
            return object;
        }
        return ViewCompat.getFallback(object).onReceiveContent(contentInfoCompat);
    }

    @Deprecated
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void postInvalidateOnAnimation(View view, int n, int n2, int n3, int n4) {
        view.postInvalidateOnAnimation(n, n2, n3, n4);
    }

    @Deprecated
    public static void postOnAnimation(View view, Runnable runnable2) {
        view.postOnAnimation(runnable2);
    }

    @Deprecated
    public static void postOnAnimationDelayed(View view, Runnable runnable2, long l) {
        view.postOnAnimationDelayed(runnable2, l);
    }

    public static void removeAccessibilityAction(View view, int n) {
        ViewCompat.removeActionWithId(n, view);
        ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, 0);
    }

    private static void removeActionWithId(int n, View object) {
        object = ViewCompat.getActionList((View)object);
        for (int i = 0; i < object.size(); ++i) {
            if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat)object.get(i)).getId() != n) continue;
            object.remove(i);
            break;
        }
    }

    public static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.removeOnUnhandledKeyEventListener(view, onUnhandledKeyEventListenerCompat);
            return;
        }
        ArrayList arrayList = (ArrayList)view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null) {
            arrayList.remove(onUnhandledKeyEventListenerCompat);
            if (arrayList.size() == 0) {
                UnhandledKeyEventManager.unregisterListeningView(view);
            }
        }
    }

    public static void replaceAccessibilityAction(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        if (accessibilityViewCommand == null && charSequence == null) {
            ViewCompat.removeAccessibilityAction(view, accessibilityActionCompat.getId());
        } else {
            ViewCompat.addAccessibilityAction(view, accessibilityActionCompat.createReplacementAction(charSequence, accessibilityViewCommand));
        }
    }

    public static void requestApplyInsets(View view) {
        Api20Impl.requestApplyInsets(view);
    }

    public static <T extends View> T requireViewById(View view, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T)((View)Api28Impl.requireViewById(view, n));
        }
        if ((view = view.findViewById(n)) != null) {
            return (T)view;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    @Deprecated
    public static int resolveSizeAndState(int n, int n2, int n3) {
        return View.resolveSizeAndState((int)n, (int)n2, (int)n3);
    }

    public static boolean restoreDefaultFocus(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.restoreDefaultFocus(view);
        }
        return view.requestFocus();
    }

    public static void saveAttributeDataForStyleable(View view, Context context, int[] nArray, AttributeSet attributeSet, TypedArray typedArray, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.saveAttributeDataForStyleable(view, context, nArray, attributeSet, typedArray, n, n2);
        }
    }

    private static AccessibilityViewProperty<Boolean> screenReaderFocusableProperty() {
        return new AccessibilityViewProperty<Boolean>(R.id.tag_screen_reader_focusable, Boolean.class, 28){

            @Override
            Boolean frameworkGet(View view) {
                return Api28Impl.isScreenReaderFocusable(view);
            }

            @Override
            void frameworkSet(View view, Boolean bl) {
                Api28Impl.setScreenReaderFocusable(view, bl);
            }

            @Override
            boolean shouldUpdate(Boolean bl, Boolean bl2) {
                return this.booleanNullToFalseEquals(bl, bl2) ^ true;
            }
        };
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        AccessibilityDelegateCompat accessibilityDelegateCompat2 = accessibilityDelegateCompat;
        if (accessibilityDelegateCompat == null) {
            accessibilityDelegateCompat2 = accessibilityDelegateCompat;
            if (ViewCompat.getAccessibilityDelegateInternal(view) instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter) {
                accessibilityDelegateCompat2 = new AccessibilityDelegateCompat();
            }
        }
        ViewCompat.setImportantForAccessibilityIfNeeded(view);
        accessibilityDelegateCompat = accessibilityDelegateCompat2 == null ? null : accessibilityDelegateCompat2.getBridge();
        view.setAccessibilityDelegate((View.AccessibilityDelegate)accessibilityDelegateCompat);
    }

    public static void setAccessibilityHeading(View view, boolean bl) {
        ViewCompat.accessibilityHeadingProperty().set(view, bl);
    }

    @Deprecated
    public static void setAccessibilityLiveRegion(View view, int n) {
        view.setAccessibilityLiveRegion(n);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        ViewCompat.paneTitleProperty().set(view, charSequence);
        if (charSequence != null) {
            sAccessibilityPaneVisibilityManager.addAccessibilityPane(view);
        } else {
            sAccessibilityPaneVisibilityManager.removeAccessibilityPane(view);
        }
    }

    @Deprecated
    public static void setActivated(View view, boolean bl) {
        view.setActivated(bl);
    }

    @Deprecated
    public static void setAlpha(View view, float f) {
        view.setAlpha(f);
    }

    public static void setAutofillHints(View view, String ... stringArray) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setAutofillHints(view, stringArray);
        }
    }

    public static void setAutofillId(View view, AutofillIdCompat autofillIdCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setAutofillId(view, autofillIdCompat);
        }
    }

    @Deprecated
    public static void setBackground(View view, Drawable drawable2) {
        view.setBackground(drawable2);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        Api21Impl.setBackgroundTintList(view, colorStateList);
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        Api21Impl.setBackgroundTintMode(view, mode);
    }

    @Deprecated
    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean bl) {
        if (sChildrenDrawingOrderMethod == null) {
            try {
                sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)TAG, (String)"Unable to find childrenDrawingOrderEnabled", (Throwable)noSuchMethodException);
            }
            sChildrenDrawingOrderMethod.setAccessible(true);
        }
        try {
            sChildrenDrawingOrderMethod.invoke((Object)viewGroup, bl);
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)TAG, (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)invocationTargetException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Log.e((String)TAG, (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)TAG, (String)"Unable to invoke childrenDrawingOrderEnabled", (Throwable)illegalAccessException);
        }
    }

    @Deprecated
    public static void setClipBounds(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setContentCaptureSession(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setContentCaptureSession(view, contentCaptureSessionCompat);
        }
    }

    public static void setElevation(View view, float f) {
        Api21Impl.setElevation(view, f);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean bl) {
        view.setFitsSystemWindows(bl);
    }

    public static void setFocusedByDefault(View view, boolean bl) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setFocusedByDefault(view, bl);
        }
    }

    @Deprecated
    public static void setHasTransientState(View view, boolean bl) {
        view.setHasTransientState(bl);
    }

    @Deprecated
    public static void setImportantForAccessibility(View view, int n) {
        view.setImportantForAccessibility(n);
    }

    private static void setImportantForAccessibilityIfNeeded(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static void setImportantForAutofill(View view, int n) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setImportantForAutofill(view, n);
        }
    }

    public static void setImportantForContentCapture(View view, int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setImportantForContentCapture(view, n);
        }
    }

    public static void setKeyboardNavigationCluster(View view, boolean bl) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setKeyboardNavigationCluster(view, bl);
        }
    }

    @Deprecated
    public static void setLabelFor(View view, int n) {
        view.setLabelFor(n);
    }

    @Deprecated
    public static void setLayerPaint(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    @Deprecated
    public static void setLayerType(View view, int n, Paint paint) {
        view.setLayerType(n, paint);
    }

    @Deprecated
    public static void setLayoutDirection(View view, int n) {
        view.setLayoutDirection(n);
    }

    public static void setNestedScrollingEnabled(View view, boolean bl) {
        Api21Impl.setNestedScrollingEnabled(view, bl);
    }

    public static void setNextClusterForwardId(View view, int n) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setNextClusterForwardId(view, n);
        }
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        Api21Impl.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static void setOnReceiveContentListener(View view, String[] stringArray, OnReceiveContentListener onReceiveContentListener) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.setOnReceiveContentListener(view, stringArray, onReceiveContentListener);
            return;
        }
        if (stringArray == null || stringArray.length == 0) {
            stringArray = null;
        }
        int n = 0;
        if (onReceiveContentListener != null) {
            boolean bl = stringArray != null;
            Preconditions.checkArgument(bl, "When the listener is set, MIME types must also be set");
        }
        if (stringArray != null) {
            boolean bl;
            boolean bl2 = false;
            int n2 = stringArray.length;
            while (true) {
                bl = bl2;
                if (n >= n2) break;
                if (stringArray[n].startsWith("*")) {
                    bl = true;
                    break;
                }
                ++n;
            }
            Preconditions.checkArgument(bl ^ true, "A MIME type set here must not start with *: " + Arrays.toString(stringArray));
        }
        view.setTag(R.id.tag_on_receive_content_mime_types, (Object)stringArray);
        view.setTag(R.id.tag_on_receive_content_listener, (Object)onReceiveContentListener);
    }

    @Deprecated
    public static void setOverScrollMode(View view, int n) {
        view.setOverScrollMode(n);
    }

    @Deprecated
    public static void setPaddingRelative(View view, int n, int n2, int n3, int n4) {
        view.setPaddingRelative(n, n2, n3, n4);
    }

    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    public static void setPointerIcon(View view, PointerIconCompat object) {
        object = object != null ? ((PointerIconCompat)object).getPointerIcon() : null;
        Api24Impl.setPointerIcon(view, (PointerIcon)object);
    }

    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean bl) {
        view.setSaveFromParentEnabled(bl);
    }

    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    public static void setScreenReaderFocusable(View view, boolean bl) {
        ViewCompat.screenReaderFocusableProperty().set(view, bl);
    }

    public static void setScrollIndicators(View view, int n) {
        Api23Impl.setScrollIndicators(view, n);
    }

    public static void setScrollIndicators(View view, int n, int n2) {
        Api23Impl.setScrollIndicators(view, n, n2);
    }

    public static void setStateDescription(View view, CharSequence charSequence) {
        ViewCompat.stateDescriptionProperty().set(view, charSequence);
    }

    public static void setSystemGestureExclusionRects(View view, List<Rect> list) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.setSystemGestureExclusionRects(view, list);
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.setTooltipText(view, charSequence);
        }
    }

    public static void setTransitionName(View view, String string2) {
        Api21Impl.setTransitionName(view, string2);
    }

    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    public static void setTranslationZ(View view, float f) {
        Api21Impl.setTranslationZ(view, f);
    }

    public static void setWindowInsetsAnimationCallback(View view, WindowInsetsAnimationCompat.Callback callback2) {
        WindowInsetsAnimationCompat.setCallback(view, callback2);
    }

    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    public static void setZ(View view, float f) {
        Api21Impl.setZ(view, f);
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object object, int n) {
        return Api24Impl.startDragAndDrop(view, clipData, dragShadowBuilder, object, n);
    }

    public static boolean startNestedScroll(View view, int n) {
        return Api21Impl.startNestedScroll(view, n);
    }

    public static boolean startNestedScroll(View view, int n, int n2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2)view).startNestedScroll(n, n2);
        }
        if (n2 == 0) {
            return ViewCompat.startNestedScroll(view, n);
        }
        return false;
    }

    private static AccessibilityViewProperty<CharSequence> stateDescriptionProperty() {
        return new AccessibilityViewProperty<CharSequence>(R.id.tag_state_description, CharSequence.class, 64, 30){

            @Override
            CharSequence frameworkGet(View view) {
                return Api30Impl.getStateDescription(view);
            }

            @Override
            void frameworkSet(View view, CharSequence charSequence) {
                Api30Impl.setStateDescription(view, charSequence);
            }

            @Override
            boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
                return TextUtils.equals((CharSequence)charSequence, (CharSequence)charSequence2) ^ true;
            }
        };
    }

    public static void stopNestedScroll(View view) {
        Api21Impl.stopNestedScroll(view);
    }

    public static void stopNestedScroll(View view, int n) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2)view).stopNestedScroll(n);
        } else if (n == 0) {
            ViewCompat.stopNestedScroll(view);
        }
    }

    private static void tickleInvalidationFlag(View view) {
        float f = view.getTranslationY();
        view.setTranslationY(1.0f + f);
        view.setTranslationY(f);
    }

    public static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
        Api24Impl.updateDragShadow(view, dragShadowBuilder);
    }

    static class AccessibilityPaneVisibilityManager
    implements ViewTreeObserver.OnGlobalLayoutListener,
    View.OnAttachStateChangeListener {
        private final WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap();

        AccessibilityPaneVisibilityManager() {
        }

        private void checkPaneVisibility(Map.Entry<View, Boolean> entry) {
            boolean bl;
            View view = entry.getKey();
            boolean bl2 = entry.getValue();
            if (bl2 != (bl = view.isShown() && view.getWindowVisibility() == 0)) {
                int n = bl ? 16 : 32;
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, n);
                entry.setValue(bl);
            }
        }

        private void registerForLayoutCallback(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }

        private void unregisterForLayoutCallback(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        }

        void addAccessibilityPane(View view) {
            WeakHashMap<View, Boolean> weakHashMap = this.mPanesToVisible;
            boolean bl = view.isShown() && view.getWindowVisibility() == 0;
            weakHashMap.put(view, bl);
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            if (view.isAttachedToWindow()) {
                this.registerForLayoutCallback(view);
            }
        }

        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator<Map.Entry<View, Boolean>> iterator2 = this.mPanesToVisible.entrySet().iterator();
                while (iterator2.hasNext()) {
                    this.checkPaneVisibility(iterator2.next());
                }
            }
        }

        public void onViewAttachedToWindow(View view) {
            this.registerForLayoutCallback(view);
        }

        public void onViewDetachedFromWindow(View view) {
        }

        void removeAccessibilityPane(View view) {
            this.mPanesToVisible.remove(view);
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            this.unregisterForLayoutCallback(view);
        }
    }

    static abstract class AccessibilityViewProperty<T> {
        private final int mContentChangeType;
        private final int mFrameworkMinimumSdk;
        private final int mTagKey;
        private final Class<T> mType;

        AccessibilityViewProperty(int n, Class<T> clazz, int n2) {
            this(n, clazz, 0, n2);
        }

        AccessibilityViewProperty(int n, Class<T> clazz, int n2, int n3) {
            this.mTagKey = n;
            this.mType = clazz;
            this.mContentChangeType = n2;
            this.mFrameworkMinimumSdk = n3;
        }

        private boolean frameworkAvailable() {
            boolean bl = Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
            return bl;
        }

        boolean booleanNullToFalseEquals(Boolean bl, Boolean bl2) {
            boolean bl3;
            boolean bl4 = true;
            boolean bl5 = bl != null && bl != false;
            if (bl5 != (bl3 = bl2 != null && bl2 != false)) {
                bl4 = false;
            }
            return bl4;
        }

        abstract T frameworkGet(View var1);

        abstract void frameworkSet(View var1, T var2);

        T get(View object) {
            if (this.frameworkAvailable()) {
                return this.frameworkGet((View)object);
            }
            if (this.mType.isInstance(object = object.getTag(this.mTagKey))) {
                return (T)object;
            }
            return null;
        }

        void set(View view, T t) {
            if (this.frameworkAvailable()) {
                this.frameworkSet(view, t);
            } else if (this.shouldUpdate(this.get(view), t)) {
                ViewCompat.ensureAccessibilityDelegateCompat(view);
                view.setTag(this.mTagKey, t);
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.mContentChangeType);
            }
        }

        boolean shouldUpdate(T t, T t2) {
            return t2.equals(t) ^ true;
        }
    }

    static class Api20Impl {
        private Api20Impl() {
        }

        static WindowInsets dispatchApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        static WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        static void requestApplyInsets(View view) {
            view.requestApplyInsets();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener)view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return windowInsetsCompat;
        }

        static boolean dispatchNestedFling(View view, float f, float f2, boolean bl) {
            return view.dispatchNestedFling(f, f2, bl);
        }

        static boolean dispatchNestedPreFling(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        static boolean dispatchNestedPreScroll(View view, int n, int n2, int[] nArray, int[] nArray2) {
            return view.dispatchNestedPreScroll(n, n2, nArray, nArray2);
        }

        static boolean dispatchNestedScroll(View view, int n, int n2, int n3, int n4, int[] nArray) {
            return view.dispatchNestedScroll(n, n2, n3, n4, nArray);
        }

        static ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        static float getElevation(View view) {
            return view.getElevation();
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(view);
        }

        static String getTransitionName(View view) {
            return view.getTransitionName();
        }

        static float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        static float getZ(View view) {
            return view.getZ();
        }

        static boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void setBackgroundTintList(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void setElevation(View view, float f) {
            view.setElevation(f);
        }

        static void setNestedScrollingEnabled(View view, boolean bl) {
            view.setNestedScrollingEnabled(bl);
        }

        static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, (Object)onApplyWindowInsetsListener);
            }
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)view.getTag(R.id.tag_window_insets_animation_callback));
                return;
            }
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(){
                WindowInsetsCompat mLastInsets;
                final OnApplyWindowInsetsListener val$listener;
                final View val$v;
                {
                    this.val$v = view;
                    this.val$listener = onApplyWindowInsetsListener;
                    this.mLastInsets = null;
                }

                public WindowInsets onApplyWindowInsets(View view, WindowInsets object) {
                    WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)object, view);
                    if (Build.VERSION.SDK_INT < 30) {
                        Api21Impl.callCompatInsetAnimationCallback((WindowInsets)object, this.val$v);
                        if (windowInsetsCompat.equals(this.mLastInsets)) {
                            return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                        }
                    }
                    this.mLastInsets = windowInsetsCompat;
                    object = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
                    if (Build.VERSION.SDK_INT >= 30) {
                        return ((WindowInsetsCompat)object).toWindowInsets();
                    }
                    ViewCompat.requestApplyInsets(view);
                    return ((WindowInsetsCompat)object).toWindowInsets();
                }
            });
        }

        static void setTransitionName(View view, String string2) {
            view.setTransitionName(string2);
        }

        static void setTranslationZ(View view, float f) {
            view.setTranslationZ(f);
        }

        static void setZ(View view, float f) {
            view.setZ(f);
        }

        static boolean startNestedScroll(View view, int n) {
            return view.startNestedScroll(n);
        }

        static void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }
    }

    private static class Api23Impl {
        private Api23Impl() {
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            Object object = view.getRootWindowInsets();
            if (object == null) {
                return null;
            }
            object = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)object);
            ((WindowInsetsCompat)object).setRootWindowInsets((WindowInsetsCompat)object);
            ((WindowInsetsCompat)object).copyRootViewBounds(view.getRootView());
            return object;
        }

        static int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        static void setScrollIndicators(View view, int n) {
            view.setScrollIndicators(n);
        }

        static void setScrollIndicators(View view, int n, int n2) {
            view.setScrollIndicators(n, n2);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void cancelDragAndDrop(View view) {
            view.cancelDragAndDrop();
        }

        static void dispatchFinishTemporaryDetach(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        static void dispatchStartTemporaryDetach(View view) {
            view.dispatchStartTemporaryDetach();
        }

        static void setPointerIcon(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object object, int n) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, object, n);
        }

        static void updateDragShadow(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void addKeyboardNavigationClusters(View view, Collection<View> collection, int n) {
            view.addKeyboardNavigationClusters(collection, n);
        }

        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }

        static int getImportantForAutofill(View view) {
            return view.getImportantForAutofill();
        }

        static int getNextClusterForwardId(View view) {
            return view.getNextClusterForwardId();
        }

        static boolean hasExplicitFocusable(View view) {
            return view.hasExplicitFocusable();
        }

        static boolean isFocusedByDefault(View view) {
            return view.isFocusedByDefault();
        }

        static boolean isImportantForAutofill(View view) {
            return view.isImportantForAutofill();
        }

        static boolean isKeyboardNavigationCluster(View view) {
            return view.isKeyboardNavigationCluster();
        }

        static View keyboardNavigationClusterSearch(View view, View view2, int n) {
            return view.keyboardNavigationClusterSearch(view2, n);
        }

        static boolean restoreDefaultFocus(View view) {
            return view.restoreDefaultFocus();
        }

        static void setAutofillHints(View view, String ... stringArray) {
            view.setAutofillHints(stringArray);
        }

        static void setFocusedByDefault(View view, boolean bl) {
            view.setFocusedByDefault(bl);
        }

        static void setImportantForAutofill(View view, int n) {
            view.setImportantForAutofill(n);
        }

        static void setKeyboardNavigationCluster(View view, boolean bl) {
            view.setKeyboardNavigationCluster(bl);
        }

        static void setNextClusterForwardId(View view, int n) {
            view.setNextClusterForwardId(n);
        }

        static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void addOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            Object object = (SimpleArrayMap<OnUnhandledKeyEventListenerCompat, Object>)view.getTag(R.id.tag_unhandled_key_listeners);
            SimpleArrayMap<OnUnhandledKeyEventListenerCompat, Object> simpleArrayMap = object;
            if (object == null) {
                simpleArrayMap = new SimpleArrayMap<OnUnhandledKeyEventListenerCompat, Object>();
                view.setTag(R.id.tag_unhandled_key_listeners, simpleArrayMap);
            }
            Objects.requireNonNull(onUnhandledKeyEventListenerCompat);
            object = new ViewCompat$Api28Impl$$ExternalSyntheticLambda0(onUnhandledKeyEventListenerCompat);
            simpleArrayMap.put(onUnhandledKeyEventListenerCompat, object);
            view.addOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)object);
        }

        static CharSequence getAccessibilityPaneTitle(View view) {
            return view.getAccessibilityPaneTitle();
        }

        static boolean isAccessibilityHeading(View view) {
            return view.isAccessibilityHeading();
        }

        static boolean isScreenReaderFocusable(View view) {
            return view.isScreenReaderFocusable();
        }

        static void removeOnUnhandledKeyEventListener(View view, OnUnhandledKeyEventListenerCompat onUnhandledKeyEventListenerCompat) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap)view.getTag(R.id.tag_unhandled_key_listeners);
            if (simpleArrayMap == null) {
                return;
            }
            if ((onUnhandledKeyEventListenerCompat = (View.OnUnhandledKeyEventListener)simpleArrayMap.get(onUnhandledKeyEventListenerCompat)) != null) {
                view.removeOnUnhandledKeyEventListener((View.OnUnhandledKeyEventListener)onUnhandledKeyEventListenerCompat);
            }
        }

        static <T> T requireViewById(View view, int n) {
            return (T)view.requireViewById(n);
        }

        static void setAccessibilityHeading(View view, boolean bl) {
            view.setAccessibilityHeading(bl);
        }

        static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void setAutofillId(View view, AutofillIdCompat autofillIdCompat) {
            autofillIdCompat = autofillIdCompat == null ? null : autofillIdCompat.toAutofillId();
            view.setAutofillId((AutofillId)autofillIdCompat);
        }

        static void setScreenReaderFocusable(View view, boolean bl) {
            view.setScreenReaderFocusable(bl);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static View.AccessibilityDelegate getAccessibilityDelegate(View view) {
            return view.getAccessibilityDelegate();
        }

        static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }

        static List<Rect> getSystemGestureExclusionRects(View view) {
            return view.getSystemGestureExclusionRects();
        }

        static void saveAttributeDataForStyleable(View view, Context context, int[] nArray, AttributeSet attributeSet, TypedArray typedArray, int n, int n2) {
            view.saveAttributeDataForStyleable(context, nArray, attributeSet, typedArray, n, n2);
        }

        static void setContentCaptureSession(View view, ContentCaptureSessionCompat contentCaptureSessionCompat) {
            contentCaptureSessionCompat = contentCaptureSessionCompat == null ? null : contentCaptureSessionCompat.toContentCaptureSession();
            view.setContentCaptureSession((ContentCaptureSession)contentCaptureSessionCompat);
        }

        static void setSystemGestureExclusionRects(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getImportantForContentCapture(View view) {
            return view.getImportantForContentCapture();
        }

        static CharSequence getStateDescription(View view) {
            return view.getStateDescription();
        }

        public static WindowInsetsControllerCompat getWindowInsetsController(View object) {
            object = (object = object.getWindowInsetsController()) != null ? WindowInsetsControllerCompat.toWindowInsetsControllerCompat((WindowInsetsController)object) : null;
            return object;
        }

        static boolean isImportantForContentCapture(View view) {
            return view.isImportantForContentCapture();
        }

        static void setImportantForContentCapture(View view, int n) {
            view.setImportantForContentCapture(n);
        }

        static void setStateDescription(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    private static final class Api31Impl {
        private Api31Impl() {
        }

        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static ContentInfoCompat performReceiveContent(View view, ContentInfoCompat contentInfoCompat) {
            ContentInfo contentInfo = contentInfoCompat.toContentInfo();
            if ((view = view.performReceiveContent(contentInfo)) == null) {
                return null;
            }
            if (view == contentInfo) {
                return contentInfoCompat;
            }
            return ContentInfoCompat.toContentInfoCompat((ContentInfo)view);
        }

        public static void setOnReceiveContentListener(View view, String[] stringArray, OnReceiveContentListener onReceiveContentListener) {
            if (onReceiveContentListener == null) {
                view.setOnReceiveContentListener(stringArray, null);
            } else {
                view.setOnReceiveContentListener(stringArray, (android.view.OnReceiveContentListener)new OnReceiveContentListenerAdapter(onReceiveContentListener));
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface FocusDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface FocusRealDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface FocusRelativeDirection {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface NestedScrollType {
    }

    private static final class OnReceiveContentListenerAdapter
    implements android.view.OnReceiveContentListener {
        private final OnReceiveContentListener mJetpackListener;

        OnReceiveContentListenerAdapter(OnReceiveContentListener onReceiveContentListener) {
            this.mJetpackListener = onReceiveContentListener;
        }

        public ContentInfo onReceiveContent(View object, ContentInfo contentInfo) {
            ContentInfoCompat contentInfoCompat = ContentInfoCompat.toContentInfoCompat(contentInfo);
            if ((object = this.mJetpackListener.onReceiveContent((View)object, contentInfoCompat)) == null) {
                return null;
            }
            if (object == contentInfoCompat) {
                return contentInfo;
            }
            return ((ContentInfoCompat)object).toContentInfo();
        }
    }

    public static interface OnUnhandledKeyEventListenerCompat {
        public boolean onUnhandledKeyEvent(View var1, KeyEvent var2);
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ScrollAxis {
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ScrollIndicators {
    }

    static class UnhandledKeyEventManager {
        private static final ArrayList<WeakReference<View>> sViewsWithListeners = new ArrayList();
        private SparseArray<WeakReference<View>> mCapturedKeys = null;
        private WeakReference<KeyEvent> mLastDispatchedPreViewKeyEvent = null;
        private WeakHashMap<View, Boolean> mViewsContainingListeners = null;

        UnhandledKeyEventManager() {
        }

        static UnhandledKeyEventManager at(View view) {
            UnhandledKeyEventManager unhandledKeyEventManager;
            UnhandledKeyEventManager unhandledKeyEventManager2 = unhandledKeyEventManager = (UnhandledKeyEventManager)view.getTag(R.id.tag_unhandled_key_event_manager);
            if (unhandledKeyEventManager == null) {
                unhandledKeyEventManager2 = new UnhandledKeyEventManager();
                view.setTag(R.id.tag_unhandled_key_event_manager, (Object)unhandledKeyEventManager2);
            }
            return unhandledKeyEventManager2;
        }

        private View dispatchInOrder(View view, KeyEvent keyEvent) {
            if (this.mViewsContainingListeners != null && this.mViewsContainingListeners.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup)view;
                    for (int i = viewGroup.getChildCount() - 1; i >= 0; --i) {
                        View view2 = this.dispatchInOrder(viewGroup.getChildAt(i), keyEvent);
                        if (view2 == null) continue;
                        return view2;
                    }
                }
                if (this.onUnhandledKeyEvent(view, keyEvent)) {
                    return view;
                }
                return null;
            }
            return null;
        }

        private SparseArray<WeakReference<View>> getCapturedKeys() {
            if (this.mCapturedKeys == null) {
                this.mCapturedKeys = new SparseArray();
            }
            return this.mCapturedKeys;
        }

        private boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList)view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int i = arrayList.size() - 1; i >= 0; --i) {
                    if (!((OnUnhandledKeyEventListenerCompat)arrayList.get(i)).onUnhandledKeyEvent(view, keyEvent)) continue;
                    return true;
                }
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private void recalcViewsWithUnhandled() {
            if (this.mViewsContainingListeners != null) {
                this.mViewsContainingListeners.clear();
            }
            if (sViewsWithListeners.isEmpty()) {
                return;
            }
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                View view;
                if (this.mViewsContainingListeners == null) {
                    view = new WeakHashMap();
                    this.mViewsContainingListeners = view;
                }
                int n = sViewsWithListeners.size() - 1;
                while (n >= 0) {
                    view = (View)sViewsWithListeners.get(n).get();
                    if (view == null) {
                        sViewsWithListeners.remove(n);
                    } else {
                        this.mViewsContainingListeners.put(view, Boolean.TRUE);
                        view = view.getParent();
                        while (view instanceof View) {
                            this.mViewsContainingListeners.put(view, Boolean.TRUE);
                            view = view.getParent();
                        }
                    }
                    --n;
                }
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static void registerListeningView(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                Object object = sViewsWithListeners.iterator();
                do {
                    if (object.hasNext()) continue;
                    object = sViewsWithListeners;
                    WeakReference<View> weakReference = new WeakReference<View>(view);
                    ((ArrayList)object).add(weakReference);
                    return;
                } while (object.next().get() != view);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        static void unregisterListeningView(View view) {
            ArrayList<WeakReference<View>> arrayList = sViewsWithListeners;
            synchronized (arrayList) {
                int n = 0;
                while (n < sViewsWithListeners.size()) {
                    if (sViewsWithListeners.get(n).get() == view) {
                        sViewsWithListeners.remove(n);
                        return;
                    }
                    ++n;
                }
                return;
            }
        }

        boolean dispatch(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                this.recalcViewsWithUnhandled();
            }
            view = this.dispatchInOrder(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int n = keyEvent.getKeyCode();
                if (view != null && !KeyEvent.isModifierKey((int)n)) {
                    this.getCapturedKeys().put(n, new WeakReference<View>(view));
                }
            }
            boolean bl = view != null;
            return bl;
        }

        boolean preDispatch(KeyEvent keyEvent) {
            if (this.mLastDispatchedPreViewKeyEvent != null && this.mLastDispatchedPreViewKeyEvent.get() == keyEvent) {
                return false;
            }
            this.mLastDispatchedPreViewKeyEvent = new WeakReference<KeyEvent>(keyEvent);
            Reference reference = null;
            SparseArray<WeakReference<View>> sparseArray = this.getCapturedKeys();
            Reference reference2 = reference;
            if (keyEvent.getAction() == 1) {
                int n = sparseArray.indexOfKey(keyEvent.getKeyCode());
                reference2 = reference;
                if (n >= 0) {
                    reference2 = (WeakReference)sparseArray.valueAt(n);
                    sparseArray.removeAt(n);
                }
            }
            reference = reference2;
            if (reference2 == null) {
                reference = (WeakReference)sparseArray.get(keyEvent.getKeyCode());
            }
            if (reference != null) {
                reference2 = (View)reference.get();
                if (reference2 != null && reference2.isAttachedToWindow()) {
                    this.onUnhandledKeyEvent((View)reference2, keyEvent);
                }
                return true;
            }
            return false;
        }
    }
}

