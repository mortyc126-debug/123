/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.text.style.ClickableSpan
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo$Builder
 *  android.view.accessibility.AccessibilityNodeInfo$ExtraRenderingInfo
 *  android.view.accessibility.AccessibilityNodeInfo$RangeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo
 */
package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityWindowInfoCompat;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 0x100000;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 0x200000;
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_DATA_SENSITIVE = 64;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    private static final int BOOLEAN_PROPERTY_SUPPORTS_GRANULAR_SCROLLING = 0x4000000;
    private static final int BOOLEAN_PROPERTY_TEXT_SELECTABLE = 0x800000;
    private static final String BOUNDS_IN_WINDOW_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    private static final String CONTAINER_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 32;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId = 0;
    private final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object object) {
        this.mInfo = (AccessibilityNodeInfo)object;
    }

    private void addSpanLocationToExtras(ClickableSpan clickableSpan, Spanned spanned, int n) {
        this.extrasIntList(SPANS_START_KEY).add(spanned.getSpanStart((Object)clickableSpan));
        this.extrasIntList(SPANS_END_KEY).add(spanned.getSpanEnd((Object)clickableSpan));
        this.extrasIntList(SPANS_FLAGS_KEY).add(spanned.getSpanFlags((Object)clickableSpan));
        this.extrasIntList(SPANS_ID_KEY).add(n);
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String string2) {
        ArrayList arrayList;
        ArrayList arrayList2 = arrayList = this.mInfo.getExtras().getIntegerArrayList(string2);
        if (arrayList == null) {
            arrayList2 = new ArrayList();
            this.mInfo.getExtras().putIntegerArrayList(string2, arrayList2);
        }
        return arrayList2;
    }

    static String getActionSymbolicName(int n) {
        switch (n) {
            default: {
                return "ACTION_UNKNOWN";
            }
            case 16908382: {
                return "ACTION_SCROLL_IN_DIRECTION";
            }
            case 16908375: {
                return "ACTION_DRAG_CANCEL";
            }
            case 16908374: {
                return "ACTION_DRAG_DROP";
            }
            case 16908373: {
                return "ACTION_DRAG_START";
            }
            case 16908372: {
                return "ACTION_IME_ENTER";
            }
            case 16908362: {
                return "ACTION_PRESS_AND_HOLD";
            }
            case 16908361: {
                return "ACTION_PAGE_RIGHT";
            }
            case 16908360: {
                return "ACTION_PAGE_LEFT";
            }
            case 16908359: {
                return "ACTION_PAGE_DOWN";
            }
            case 16908358: {
                return "ACTION_PAGE_UP";
            }
            case 16908357: {
                return "ACTION_HIDE_TOOLTIP";
            }
            case 16908356: {
                return "ACTION_SHOW_TOOLTIP";
            }
            case 16908354: {
                return "ACTION_MOVE_WINDOW";
            }
            case 16908349: {
                return "ACTION_SET_PROGRESS";
            }
            case 16908348: {
                return "ACTION_CONTEXT_CLICK";
            }
            case 16908347: {
                return "ACTION_SCROLL_RIGHT";
            }
            case 16908346: {
                return "ACTION_SCROLL_DOWN";
            }
            case 16908345: {
                return "ACTION_SCROLL_LEFT";
            }
            case 16908344: {
                return "ACTION_SCROLL_UP";
            }
            case 16908343: {
                return "ACTION_SCROLL_TO_POSITION";
            }
            case 16908342: {
                return "ACTION_SHOW_ON_SCREEN";
            }
            case 0x200000: {
                return "ACTION_SET_TEXT";
            }
            case 524288: {
                return "ACTION_COLLAPSE";
            }
            case 262144: {
                return "ACTION_EXPAND";
            }
            case 131072: {
                return "ACTION_SET_SELECTION";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 1: 
        }
        return "ACTION_FOCUS";
    }

    private boolean getBooleanProperty(int n) {
        Bundle bundle = this.getExtras();
        boolean bl = false;
        if (bundle == null) {
            return false;
        }
        if ((bundle.getInt(BOOLEAN_PROPERTY_KEY, 0) & n) == n) {
            bl = true;
        }
        return bl;
    }

    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[])((Spanned)charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View view) {
        SparseArray sparseArray;
        SparseArray sparseArray2 = sparseArray = this.getSpansFromViewTags(view);
        if (sparseArray == null) {
            sparseArray2 = new SparseArray();
            view.setTag(R.id.tag_accessibility_clickable_spans, (Object)sparseArray2);
        }
        return sparseArray2;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View view) {
        return (SparseArray)view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return this.extrasIntList(SPANS_START_KEY).isEmpty() ^ true;
    }

    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        int n;
        if (sparseArray != null) {
            for (n = 0; n < sparseArray.size(); ++n) {
                if (!clickableSpan.equals((ClickableSpan)((WeakReference)sparseArray.valueAt(n)).get())) continue;
                return sparseArray.keyAt(n);
            }
        }
        n = sClickableSpanId;
        sClickableSpanId = n + 1;
        return n;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain((View)view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int n) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfo.obtain((View)view, (int)n));
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfoCompat.mInfo));
    }

    private void removeCollectedSpans(View sparseArray) {
        if ((sparseArray = this.getSpansFromViewTags((View)sparseArray)) != null) {
            int n;
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (n = 0; n < sparseArray.size(); ++n) {
                if (((WeakReference)sparseArray.valueAt(n)).get() != null) continue;
                arrayList.add(n);
            }
            for (n = 0; n < arrayList.size(); ++n) {
                sparseArray.remove(((Integer)arrayList.get(n)).intValue());
            }
        }
    }

    private void setBooleanProperty(int n, boolean bl) {
        Bundle bundle = this.getExtras();
        if (bundle != null) {
            int n2 = 0;
            int n3 = bundle.getInt(BOOLEAN_PROPERTY_KEY, 0);
            if (bl) {
                n2 = n;
            }
            bundle.putInt(BOOLEAN_PROPERTY_KEY, n2 | n3 & ~n);
        }
    }

    public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            return new AccessibilityNodeInfoCompat(object);
        }
        return null;
    }

    public void addAction(int n) {
        this.mInfo.addAction(n);
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction)accessibilityActionCompat.mAction);
    }

    public void addChild(View view) {
        this.mInfo.addChild(view);
    }

    public void addChild(View view, int n) {
        this.mInfo.addChild(view, n);
    }

    public void addSpansToExtras(CharSequence charSequence, View sparseArray) {
        if (Build.VERSION.SDK_INT < 26) {
            this.clearExtrasSpans();
            this.removeCollectedSpans((View)sparseArray);
            ClickableSpan[] clickableSpanArray = AccessibilityNodeInfoCompat.getClickableSpans(charSequence);
            if (clickableSpanArray != null && clickableSpanArray.length > 0) {
                this.getExtras().putInt(SPANS_ACTION_ID_KEY, R.id.accessibility_action_clickable_span);
                sparseArray = this.getOrCreateSpansFromViewTags((View)sparseArray);
                for (int i = 0; clickableSpanArray != null && i < clickableSpanArray.length; ++i) {
                    int n = this.idForClickableSpan(clickableSpanArray[i], sparseArray);
                    sparseArray.put(n, new WeakReference<ClickableSpan>(clickableSpanArray[i]));
                    this.addSpanLocationToExtras(clickableSpanArray[i], (Spanned)charSequence, n);
                }
            }
        }
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        object = (AccessibilityNodeInfoCompat)object;
        if (this.mInfo == null ? ((AccessibilityNodeInfoCompat)object).mInfo != null : !this.mInfo.equals((Object)((AccessibilityNodeInfoCompat)object).mInfo)) {
            return false;
        }
        if (this.mVirtualDescendantId != ((AccessibilityNodeInfoCompat)object).mVirtualDescendantId) {
            return false;
        }
        return this.mParentVirtualDescendantId == ((AccessibilityNodeInfoCompat)object).mParentVirtualDescendantId;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String object) {
        ArrayList<AccessibilityNodeInfoCompat> arrayList = new ArrayList<AccessibilityNodeInfoCompat>();
        object = this.mInfo.findAccessibilityNodeInfosByText((String)object);
        int n = object.size();
        for (int i = 0; i < n; ++i) {
            arrayList.add(AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)object.get(i)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String object) {
        Object object2 = this.mInfo.findAccessibilityNodeInfosByViewId((String)object);
        object = new ArrayList();
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)object2.next()));
        }
        return object;
    }

    public AccessibilityNodeInfoCompat findFocus(int n) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.findFocus(n));
    }

    public AccessibilityNodeInfoCompat focusSearch(int n) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.focusSearch(n));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List list = this.mInfo.getActionList();
        if (list != null) {
            ArrayList<AccessibilityActionCompat> arrayList = new ArrayList<AccessibilityActionCompat>();
            int n = list.size();
            for (int i = 0; i < n; ++i) {
                arrayList.add(new AccessibilityActionCompat(list.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.getAvailableExtraData();
        }
        return Collections.emptyList();
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public void getBoundsInWindow(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.getBoundsInWindow(this.mInfo, rect);
        } else {
            Rect rect2 = (Rect)this.mInfo.getExtras().getParcelable(BOUNDS_IN_WINDOW_KEY);
            if (rect2 != null) {
                rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
    }

    public AccessibilityNodeInfoCompat getChild(int n) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getChild(n));
    }

    public AccessibilityNodeInfoCompat getChild(int n, int n2) {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getChild(this.mInfo, n, n2);
        }
        return this.getChild(n);
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    public CharSequence getContainerTitle() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getContainerTitle(this.mInfo);
        }
        return this.mInfo.getExtras().getCharSequence(CONTAINER_TITLE_KEY);
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getExtraRenderingInfo(this.mInfo);
        }
        return null;
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    public CharSequence getHintText() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.getHintText();
        }
        return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getMinDurationBetweenContentChangeMillis(this.mInfo);
        }
        return this.mInfo.getExtras().getLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY);
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    public CharSequence getPaneTitle() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.getPaneTitle();
        }
        return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getParent());
    }

    public AccessibilityNodeInfoCompat getParent(int n) {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getParent(this.mInfo, n);
        }
        return this.getParent();
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    public CharSequence getStateDescription() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getStateDescription(this.mInfo);
        }
        return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public CharSequence getText() {
        if (this.hasSpans()) {
            List<Integer> list = this.extrasIntList(SPANS_START_KEY);
            List<Integer> list2 = this.extrasIntList(SPANS_END_KEY);
            List<Integer> list3 = this.extrasIntList(SPANS_FLAGS_KEY);
            List<Integer> list4 = this.extrasIntList(SPANS_ID_KEY);
            SpannableString spannableString = new SpannableString((CharSequence)TextUtils.substring((CharSequence)this.mInfo.getText(), (int)0, (int)this.mInfo.getText().length()));
            for (int i = 0; i < list.size(); ++i) {
                spannableString.setSpan((Object)new AccessibilityClickableSpanCompat(list4.get(i), this, this.getExtras().getInt(SPANS_ACTION_ID_KEY)), list.get(i).intValue(), list2.get(i).intValue(), list3.get(i).intValue());
            }
            return spannableString;
        }
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    public CharSequence getTooltipText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.getTooltipText();
        }
        return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
    }

    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        if (Build.VERSION.SDK_INT >= 29 && (touchDelegateInfo = this.mInfo.getTouchDelegateInfo()) != null) {
            return new TouchDelegateInfoCompat(touchDelegateInfo);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    public String getUniqueId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getUniqueId(this.mInfo);
        }
        return this.mInfo.getExtras().getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public boolean hasRequestInitialAccessibilityFocus() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo);
        }
        return this.getBooleanProperty(32);
    }

    public int hashCode() {
        int n = this.mInfo == null ? 0 : this.mInfo.hashCode();
        return n;
    }

    public boolean isAccessibilityDataSensitive() {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.isAccessibilityDataSensitive(this.mInfo);
        }
        return this.getBooleanProperty(64);
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return this.getBooleanProperty(0x4000000);
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.isHeading();
        }
        boolean bl = this.getBooleanProperty(2);
        boolean bl2 = true;
        if (bl) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfoCompat = this.getCollectionItemInfo();
        if (collectionItemInfoCompat == null || !collectionItemInfoCompat.isHeading()) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean isImportantForAccessibility() {
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.isScreenReaderFocusable();
        }
        return this.getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.isShowingHintText();
        }
        return this.getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mInfo.isTextEntryKey();
        }
        return this.getBooleanProperty(8);
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.isTextSelectable(this.mInfo);
        }
        return this.getBooleanProperty(0x800000);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int n) {
        return this.mInfo.performAction(n);
    }

    public boolean performAction(int n, Bundle bundle) {
        return this.mInfo.performAction(n, bundle);
    }

    @Deprecated
    public void recycle() {
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction)accessibilityActionCompat.mAction);
    }

    public boolean removeChild(View view) {
        return this.mInfo.removeChild(view);
    }

    public boolean removeChild(View view, int n) {
        return this.mInfo.removeChild(view, n);
    }

    public void setAccessibilityDataSensitive(boolean bl) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setAccessibilityDataSensitive(this.mInfo, bl);
        } else {
            this.setBooleanProperty(64, bl);
        }
    }

    public void setAccessibilityFocused(boolean bl) {
        this.mInfo.setAccessibilityFocused(bl);
    }

    public void setAvailableExtraData(List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setAvailableExtraData(list);
        }
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setBoundsInWindow(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setBoundsInWindow(this.mInfo, rect);
        } else {
            this.mInfo.getExtras().putParcelable(BOUNDS_IN_WINDOW_KEY, (Parcelable)rect);
        }
    }

    public void setCanOpenPopup(boolean bl) {
        this.mInfo.setCanOpenPopup(bl);
    }

    public void setCheckable(boolean bl) {
        this.mInfo.setCheckable(bl);
    }

    public void setChecked(boolean bl) {
        this.mInfo.setChecked(bl);
    }

    public void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean bl) {
        this.mInfo.setClickable(bl);
    }

    public void setCollectionInfo(Object object) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        object = object == null ? null : (AccessibilityNodeInfo.CollectionInfo)((CollectionInfoCompat)object).mInfo;
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)object);
    }

    public void setCollectionItemInfo(Object object) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        object = object == null ? null : (AccessibilityNodeInfo.CollectionItemInfo)((CollectionItemInfoCompat)object).mInfo;
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)object);
    }

    public void setContainerTitle(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setContainerTitle(this.mInfo, charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(CONTAINER_TITLE_KEY, charSequence);
        }
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean bl) {
        this.mInfo.setContentInvalid(bl);
    }

    public void setContextClickable(boolean bl) {
        this.mInfo.setContextClickable(bl);
    }

    public void setDismissable(boolean bl) {
        this.mInfo.setDismissable(bl);
    }

    public void setDrawingOrder(int n) {
        this.mInfo.setDrawingOrder(n);
    }

    public void setEditable(boolean bl) {
        this.mInfo.setEditable(bl);
    }

    public void setEnabled(boolean bl) {
        this.mInfo.setEnabled(bl);
    }

    public void setError(CharSequence charSequence) {
        this.mInfo.setError(charSequence);
    }

    public void setFocusable(boolean bl) {
        this.mInfo.setFocusable(bl);
    }

    public void setFocused(boolean bl) {
        this.mInfo.setFocused(bl);
    }

    public void setGranularScrollingSupported(boolean bl) {
        this.setBooleanProperty(0x4000000, bl);
    }

    public void setHeading(boolean bl) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(bl);
        } else {
            this.setBooleanProperty(2, bl);
        }
    }

    public void setHintText(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setHintText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, charSequence);
        }
    }

    public void setImportantForAccessibility(boolean bl) {
        this.mInfo.setImportantForAccessibility(bl);
    }

    public void setInputType(int n) {
        this.mInfo.setInputType(n);
    }

    public void setLabelFor(View view) {
        this.mInfo.setLabelFor(view);
    }

    public void setLabelFor(View view, int n) {
        this.mInfo.setLabelFor(view, n);
    }

    public void setLabeledBy(View view) {
        this.mInfo.setLabeledBy(view);
    }

    public void setLabeledBy(View view, int n) {
        this.mInfo.setLabeledBy(view, n);
    }

    public void setLiveRegion(int n) {
        this.mInfo.setLiveRegion(n);
    }

    public void setLongClickable(boolean bl) {
        this.mInfo.setLongClickable(bl);
    }

    public void setMaxTextLength(int n) {
        this.mInfo.setMaxTextLength(n);
    }

    public void setMinDurationBetweenContentChangesMillis(long l) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setMinDurationBetweenContentChangeMillis(this.mInfo, l);
        } else {
            this.mInfo.getExtras().putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, l);
        }
    }

    public void setMovementGranularities(int n) {
        this.mInfo.setMovementGranularities(n);
    }

    public void setMultiLine(boolean bl) {
        this.mInfo.setMultiLine(bl);
    }

    public void setPackageName(CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setPaneTitle(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setPaneTitle(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, charSequence);
        }
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    public void setParent(View view, int n) {
        this.mParentVirtualDescendantId = n;
        this.mInfo.setParent(view, n);
    }

    public void setPassword(boolean bl) {
        this.mInfo.setPassword(bl);
    }

    public void setQueryFromAppProcessEnabled(View view, boolean bl) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, view, bl);
        }
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo)rangeInfoCompat.mInfo);
    }

    public void setRequestInitialAccessibilityFocus(boolean bl) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, bl);
        } else {
            this.setBooleanProperty(32, bl);
        }
    }

    public void setRoleDescription(CharSequence charSequence) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    public void setScreenReaderFocusable(boolean bl) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(bl);
        } else {
            this.setBooleanProperty(1, bl);
        }
    }

    public void setScrollable(boolean bl) {
        this.mInfo.setScrollable(bl);
    }

    public void setSelected(boolean bl) {
        this.mInfo.setSelected(bl);
    }

    public void setShowingHintText(boolean bl) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setShowingHintText(bl);
        } else {
            this.setBooleanProperty(4, bl);
        }
    }

    public void setSource(View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    public void setSource(View view, int n) {
        this.mVirtualDescendantId = n;
        this.mInfo.setSource(view, n);
    }

    public void setStateDescription(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setStateDescription(this.mInfo, charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextEntryKey(boolean bl) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(bl);
        } else {
            this.setBooleanProperty(8, bl);
        }
    }

    public void setTextSelectable(boolean bl) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setTextSelectable(this.mInfo, bl);
        } else {
            this.setBooleanProperty(0x800000, bl);
        }
    }

    public void setTextSelection(int n, int n2) {
        this.mInfo.setTextSelection(n, n2);
    }

    public void setTooltipText(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setTooltipText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
        }
    }

    public void setTouchDelegateInfo(TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.mInfo);
        }
    }

    public void setTraversalAfter(View view) {
        this.mInfo.setTraversalAfter(view);
    }

    public void setTraversalAfter(View view, int n) {
        this.mInfo.setTraversalAfter(view, n);
    }

    public void setTraversalBefore(View view) {
        this.mInfo.setTraversalBefore(view);
    }

    public void setTraversalBefore(View view, int n) {
        this.mInfo.setTraversalBefore(view, n);
    }

    public void setUniqueId(String string2) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setUniqueId(this.mInfo, string2);
        } else {
            this.mInfo.getExtras().putString(UNIQUE_ID_KEY, string2);
        }
    }

    public void setViewIdResourceName(String string2) {
        this.mInfo.setViewIdResourceName(string2);
    }

    public void setVisibleToUser(boolean bl) {
        this.mInfo.setVisibleToUser(bl);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Object object = new Rect();
        this.getBoundsInParent((Rect)object);
        stringBuilder.append("; boundsInParent: " + object);
        this.getBoundsInScreen((Rect)object);
        stringBuilder.append("; boundsInScreen: " + object);
        this.getBoundsInWindow((Rect)object);
        stringBuilder.append("; boundsInWindow: " + object);
        stringBuilder.append("; packageName: ").append(this.getPackageName());
        stringBuilder.append("; className: ").append(this.getClassName());
        stringBuilder.append("; text: ").append(this.getText());
        stringBuilder.append("; error: ").append(this.getError());
        stringBuilder.append("; maxTextLength: ").append(this.getMaxTextLength());
        stringBuilder.append("; stateDescription: ").append(this.getStateDescription());
        stringBuilder.append("; contentDescription: ").append(this.getContentDescription());
        stringBuilder.append("; tooltipText: ").append(this.getTooltipText());
        stringBuilder.append("; viewIdResName: ").append(this.getViewIdResourceName());
        stringBuilder.append("; uniqueId: ").append(this.getUniqueId());
        stringBuilder.append("; checkable: ").append(this.isCheckable());
        stringBuilder.append("; checked: ").append(this.isChecked());
        stringBuilder.append("; focusable: ").append(this.isFocusable());
        stringBuilder.append("; focused: ").append(this.isFocused());
        stringBuilder.append("; selected: ").append(this.isSelected());
        stringBuilder.append("; clickable: ").append(this.isClickable());
        stringBuilder.append("; longClickable: ").append(this.isLongClickable());
        stringBuilder.append("; contextClickable: ").append(this.isContextClickable());
        stringBuilder.append("; enabled: ").append(this.isEnabled());
        stringBuilder.append("; password: ").append(this.isPassword());
        stringBuilder.append("; scrollable: " + this.isScrollable());
        stringBuilder.append("; containerTitle: ").append(this.getContainerTitle());
        stringBuilder.append("; granularScrollingSupported: ").append(this.isGranularScrollingSupported());
        stringBuilder.append("; importantForAccessibility: ").append(this.isImportantForAccessibility());
        stringBuilder.append("; visible: ").append(this.isVisibleToUser());
        stringBuilder.append("; isTextSelectable: ").append(this.isTextSelectable());
        stringBuilder.append("; accessibilityDataSensitive: ").append(this.isAccessibilityDataSensitive());
        stringBuilder.append("; [");
        List<AccessibilityActionCompat> list = this.getActionList();
        for (int i = 0; i < list.size(); ++i) {
            AccessibilityActionCompat accessibilityActionCompat = list.get(i);
            String string2 = AccessibilityNodeInfoCompat.getActionSymbolicName(accessibilityActionCompat.getId());
            object = string2;
            if (string2.equals("ACTION_UNKNOWN")) {
                object = string2;
                if (accessibilityActionCompat.getLabel() != null) {
                    object = ((Object)accessibilityActionCompat.getLabel()).toString();
                }
            }
            stringBuilder.append((String)object);
            if (i == list.size() - 1) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
        public static final AccessibilityActionCompat ACTION_CLICK;
        public static final AccessibilityActionCompat ACTION_COLLAPSE;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
        public static final AccessibilityActionCompat ACTION_COPY;
        public static final AccessibilityActionCompat ACTION_CUT;
        public static final AccessibilityActionCompat ACTION_DISMISS;
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL;
        public static final AccessibilityActionCompat ACTION_DRAG_DROP;
        public static final AccessibilityActionCompat ACTION_DRAG_START;
        public static final AccessibilityActionCompat ACTION_EXPAND;
        public static final AccessibilityActionCompat ACTION_FOCUS;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
        public static final AccessibilityActionCompat ACTION_IME_ENTER;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
        public static final AccessibilityActionCompat ACTION_PAGE_UP;
        public static final AccessibilityActionCompat ACTION_PASTE;
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public static final AccessibilityActionCompat ACTION_SELECT;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION;
        public static final AccessibilityActionCompat ACTION_SET_TEXT;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            Object var1 = null;
            ACTION_FOCUS = new AccessibilityActionCompat(1, null);
            ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
            ACTION_SELECT = new AccessibilityActionCompat(4, null);
            ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
            ACTION_CLICK = new AccessibilityActionCompat(16, null);
            ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
            ACTION_COPY = new AccessibilityActionCompat(16384, null);
            ACTION_PASTE = new AccessibilityActionCompat(32768, null);
            ACTION_CUT = new AccessibilityActionCompat(65536, null);
            ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
            ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
            ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
            ACTION_DISMISS = new AccessibilityActionCompat(0x100000, null);
            ACTION_SET_TEXT = new AccessibilityActionCompat(0x200000, null, AccessibilityViewCommand.SetTextArguments.class);
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
            Object object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null;
            ACTION_PAGE_UP = new AccessibilityActionCompat(object, 16908358, null, null, null);
            object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null;
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(object, 16908359, null, null, null);
            object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null;
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(object, 16908360, null, null, null);
            object = Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null;
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(object, 16908361, null, null, null);
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            object = Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null;
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(object, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            object = Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null;
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(object, 16908356, null, null, null);
            object = Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null;
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(object, 16908357, null, null, null);
            object = Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null;
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(object, 16908362, null, null, null);
            object = Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null;
            ACTION_IME_ENTER = new AccessibilityActionCompat(object, 16908372, null, null, null);
            object = Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null;
            ACTION_DRAG_START = new AccessibilityActionCompat(object, 16908373, null, null, null);
            object = Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null;
            ACTION_DRAG_DROP = new AccessibilityActionCompat(object, 16908374, null, null, null);
            object = Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null;
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(object, 16908375, null, null, null);
            object = Build.VERSION.SDK_INT >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null;
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(object, 16908376, null, null, null);
            object = var1;
            if (Build.VERSION.SDK_INT >= 34) {
                object = Api34Impl.getActionScrollInDirection();
            }
            ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(object, 16908382, null, null, null);
        }

        public AccessibilityActionCompat(int n, CharSequence charSequence) {
            this(null, n, charSequence, null, null);
        }

        public AccessibilityActionCompat(int n, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, n, charSequence, accessibilityViewCommand, null);
        }

        private AccessibilityActionCompat(int n, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> clazz) {
            this(null, n, charSequence, null, clazz);
        }

        AccessibilityActionCompat(Object object) {
            this(object, 0, null, null, null);
        }

        AccessibilityActionCompat(Object object, int n, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> clazz) {
            this.mId = n;
            this.mCommand = accessibilityViewCommand;
            this.mAction = object == null ? new AccessibilityNodeInfo.AccessibilityAction(n, charSequence) : object;
            this.mViewCommandArgumentClass = clazz;
        }

        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
        }

        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!(object instanceof AccessibilityActionCompat)) {
                return false;
            }
            object = (AccessibilityActionCompat)object;
            return !(this.mAction == null ? ((AccessibilityActionCompat)object).mAction != null : !this.mAction.equals(((AccessibilityActionCompat)object).mAction));
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getLabel();
        }

        public int hashCode() {
            int n = this.mAction != null ? this.mAction.hashCode() : 0;
            return n;
        }

        public boolean perform(View view, Bundle object) {
            if (this.mCommand != null) {
                AccessibilityViewCommand.CommandArguments commandArguments = null;
                AccessibilityViewCommand.CommandArguments commandArguments2 = null;
                if (this.mViewCommandArgumentClass != null) {
                    commandArguments = commandArguments2;
                    commandArguments = commandArguments2 = this.mViewCommandArgumentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    try {
                        commandArguments2.setBundle((Bundle)object);
                        commandArguments = commandArguments2;
                    }
                    catch (Exception exception) {
                        object = this.mViewCommandArgumentClass == null ? "null" : this.mViewCommandArgumentClass.getName();
                        Log.e((String)TAG, (String)("Failed to execute command with argument class ViewCommandArgument: " + (String)object), (Throwable)exception);
                    }
                }
                return this.mCommand.perform(view, commandArguments);
            }
            return false;
        }

        public String toString() {
            String string2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AccessibilityActionCompat: ");
            String string3 = string2 = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (string2.equals("ACTION_UNKNOWN")) {
                string3 = string2;
                if (this.getLabel() != null) {
                    string3 = ((Object)this.getLabel()).toString();
                }
            }
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
    }

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static CollectionItemInfoCompat createCollectionItemInfo(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n, (int)n2, (int)n3, (int)n4, (boolean)bl, (boolean)bl2));
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        public static Object createRangeInfo(int n, float f, float f2, float f3) {
            return new AccessibilityNodeInfo.RangeInfo(n, f, f2, f3);
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean bl, int n, int n2, int n3, int n4, boolean bl2, String string2, String string3) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(bl).setColumnIndex(n).setRowIndex(n2).setColumnSpan(n3).setRowSpan(n4).setSelected(bl2).setRowTitle(string2).setColumnTitle(string3).build());
        }

        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo accessibilityNodeInfo, int n, int n2) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(accessibilityNodeInfo.getChild(n, n2));
        }

        public static String getCollectionItemColumnTitle(Object object) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)object).getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object object) {
            return ((AccessibilityNodeInfo.CollectionItemInfo)object).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo accessibilityNodeInfo, int n) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(accessibilityNodeInfo.getParent(n));
        }

        public static String getUniqueId(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void setTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo, boolean bl) {
            accessibilityNodeInfo.setTextSelectable(bl);
        }

        public static void setUniqueId(AccessibilityNodeInfo accessibilityNodeInfo, String string2) {
            accessibilityNodeInfo.setUniqueId(string2);
        }
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void getBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence getContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo, boolean bl) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(bl);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void setContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo, long l) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(l));
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean bl) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, bl);
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo, boolean bl) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(bl);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        final Object mInfo;

        CollectionInfoCompat(Object object) {
            this.mInfo = object;
        }

        public static CollectionInfoCompat obtain(int n, int n2, boolean bl) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain((int)n, (int)n2, (boolean)bl));
        }

        public static CollectionInfoCompat obtain(int n, int n2, boolean bl, int n3) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain((int)n, (int)n2, (boolean)bl, (int)n3));
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getColumnCount();
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo)this.mInfo).isHierarchical();
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        CollectionItemInfoCompat(Object object) {
            this.mInfo = object;
        }

        public static CollectionItemInfoCompat obtain(int n, int n2, int n3, int n4, boolean bl) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n, (int)n2, (int)n3, (int)n4, (boolean)bl));
        }

        public static CollectionItemInfoCompat obtain(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n, (int)n2, (int)n3, (int)n4, (boolean)bl, (boolean)bl2));
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getColumnSpan();
        }

        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Impl.getCollectionItemColumnTitle(this.mInfo);
            }
            return null;
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).getRowSpan();
        }

        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) {
                return Api33Impl.getCollectionItemRowTitle(this.mInfo);
            }
            return null;
        }

        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo)this.mInfo).isSelected();
        }

        public static final class Builder {
            private int mColumnIndex;
            private int mColumnSpan;
            private String mColumnTitle;
            private boolean mHeading;
            private int mRowIndex;
            private int mRowSpan;
            private String mRowTitle;
            private boolean mSelected;

            public CollectionItemInfoCompat build() {
                if (Build.VERSION.SDK_INT >= 33) {
                    return Api33Impl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle);
                }
                return Api21Impl.createCollectionItemInfo(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading, this.mSelected);
            }

            public Builder setColumnIndex(int n) {
                this.mColumnIndex = n;
                return this;
            }

            public Builder setColumnSpan(int n) {
                this.mColumnSpan = n;
                return this;
            }

            public Builder setColumnTitle(String string2) {
                this.mColumnTitle = string2;
                return this;
            }

            public Builder setHeading(boolean bl) {
                this.mHeading = bl;
                return this;
            }

            public Builder setRowIndex(int n) {
                this.mRowIndex = n;
                return this;
            }

            public Builder setRowSpan(int n) {
                this.mRowSpan = n;
                return this;
            }

            public Builder setRowTitle(String string2) {
                this.mRowTitle = string2;
                return this;
            }

            public Builder setSelected(boolean bl) {
                this.mSelected = bl;
                return this;
            }
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        public RangeInfoCompat(int n, float f, float f2, float f3) {
            this.mInfo = Build.VERSION.SDK_INT >= 30 ? Api30Impl.createRangeInfo(n, f, f2, f3) : AccessibilityNodeInfo.RangeInfo.obtain((int)n, (float)f, (float)f2, (float)f3);
        }

        RangeInfoCompat(Object object) {
            this.mInfo = object;
        }

        public static RangeInfoCompat obtain(int n, float f, float f2, float f3) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain((int)n, (float)f, (float)f2, (float)f3));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo)this.mInfo).getType();
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.mInfo = touchDelegateInfo;
        }

        public TouchDelegateInfoCompat(Map<Region, View> map2) {
            this.mInfo = Build.VERSION.SDK_INT >= 29 ? new AccessibilityNodeInfo.TouchDelegateInfo(map2) : null;
        }

        public Region getRegionAt(int n) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mInfo.getRegionAt(n);
            }
            return null;
        }

        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.mInfo.getRegionCount();
            }
            return 0;
        }

        public AccessibilityNodeInfoCompat getTargetForRegion(Region region) {
            if (Build.VERSION.SDK_INT >= 29 && (region = this.mInfo.getTargetForRegion(region)) != null) {
                return AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)region);
            }
            return null;
        }
    }
}

