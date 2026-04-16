/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow
implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible = false;
    private View mDropDownAnchorView;
    private int mDropDownGravity = 0;
    private int mDropDownHeight = -2;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth = -2;
    private int mDropDownWindowLayoutType = 1002;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch = false;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum = Integer.MAX_VALUE;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition = 0;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable = new ResizePopupRunnable(this);
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor(this);

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n) {
        this(context, attributeSet, n, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n, int n2) {
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, n, n2);
        this.mDropDownHorizontalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.mDropDownVerticalOffset = typedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        typedArray.recycle();
        this.mPopup = new AppCompatPopupWindow(context, attributeSet, n, n2);
        this.mPopup.setInputMethodMode(1);
    }

    private int buildDropDown() {
        int n;
        int n2 = 0;
        int n3 = 0;
        DropDownListView dropDownListView = this.mDropDownList;
        boolean bl = false;
        if (dropDownListView == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new Runnable(this){
                final ListPopupWindow this$0;
                {
                    this.this$0 = listPopupWindow;
                }

                @Override
                public void run() {
                    View view = this.this$0.getAnchorView();
                    if (view != null && view.getWindowToken() != null) {
                        this.this$0.show();
                    }
                }
            };
            this.mDropDownList = this.createDropDownListView(context, this.mModal ^ true);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this){
                final ListPopupWindow this$0;
                {
                    this.this$0 = listPopupWindow;
                }

                public void onItemSelected(AdapterView<?> object, View view, int n, long l) {
                    if (n != -1 && (object = this.this$0.mDropDownList) != null) {
                        ((DropDownListView)((Object)object)).setListSelectionHidden(false);
                    }
                }

                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            DropDownListView dropDownListView2 = this.mDropDownList;
            View view = this.mPromptView;
            dropDownListView = dropDownListView2;
            if (view != null) {
                dropDownListView = new LinearLayout(context);
                dropDownListView.setOrientation(1);
                context = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.mPromptPosition) {
                    default: {
                        Log.e((String)TAG, (String)("Invalid hint position " + this.mPromptPosition));
                        break;
                    }
                    case 1: {
                        dropDownListView.addView((View)dropDownListView2, (ViewGroup.LayoutParams)context);
                        dropDownListView.addView(view);
                        break;
                    }
                    case 0: {
                        dropDownListView.addView(view);
                        dropDownListView.addView((View)dropDownListView2, (ViewGroup.LayoutParams)context);
                    }
                }
                if (this.mDropDownWidth >= 0) {
                    n3 = Integer.MIN_VALUE;
                    n2 = this.mDropDownWidth;
                } else {
                    n3 = 0;
                    n2 = 0;
                }
                view.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)n3), 0);
                dropDownListView2 = (LinearLayout.LayoutParams)view.getLayoutParams();
                n2 = view.getMeasuredHeight();
                n3 = ((LinearLayout.LayoutParams)dropDownListView2).topMargin;
                n = ((LinearLayout.LayoutParams)dropDownListView2).bottomMargin;
                n3 = n2 + n3 + n;
            }
            this.mPopup.setContentView((View)dropDownListView);
        } else {
            dropDownListView = (ViewGroup)this.mPopup.getContentView();
            View view = this.mPromptView;
            n3 = n2;
            if (view != null) {
                dropDownListView = (LinearLayout.LayoutParams)view.getLayoutParams();
                n3 = view.getMeasuredHeight() + ((LinearLayout.LayoutParams)dropDownListView).topMargin + ((LinearLayout.LayoutParams)dropDownListView).bottomMargin;
            }
        }
        dropDownListView = this.mPopup.getBackground();
        if (dropDownListView != null) {
            dropDownListView.getPadding(this.mTempRect);
            n = n2 = this.mTempRect.top + this.mTempRect.bottom;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
                n = n2;
            }
        } else {
            this.mTempRect.setEmpty();
            n = 0;
        }
        if (this.mPopup.getInputMethodMode() == 2) {
            bl = true;
        }
        int n4 = this.getMaxAvailableHeight(this.getAnchorView(), this.mDropDownVerticalOffset, bl);
        if (!this.mDropDownAlwaysVisible && this.mDropDownHeight != -1) {
            switch (this.mDropDownWidth) {
                default: {
                    n2 = View.MeasureSpec.makeMeasureSpec((int)this.mDropDownWidth, (int)0x40000000);
                    break;
                }
                case -1: {
                    n2 = View.MeasureSpec.makeMeasureSpec((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right)), (int)0x40000000);
                    break;
                }
                case -2: {
                    n2 = View.MeasureSpec.makeMeasureSpec((int)(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right)), (int)Integer.MIN_VALUE);
                }
            }
            n4 = this.mDropDownList.measureHeightOfChildrenCompat(n2, 0, -1, n4 - n3, -1);
            n2 = n3;
            if (n4 > 0) {
                n2 = n3 + (n + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
            }
            return n4 + n2;
        }
        return n4 + n;
    }

    private int getMaxAvailableHeight(View view, int n, boolean bl) {
        return Api24Impl.getMaxAvailableHeight(this.mPopup, view, n, bl);
    }

    private static boolean isConfirmKey(int n) {
        boolean bl = n == 66 || n == 23;
        return bl;
    }

    private void removePromptView() {
        ViewParent viewParent;
        if (this.mPromptView != null && (viewParent = this.mPromptView.getParent()) instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(this.mPromptView);
        }
    }

    private void setPopupClipToScreenEnabled(boolean bl) {
        if (Build.VERSION.SDK_INT <= 28) {
            if (sSetClipToWindowEnabledMethod != null) {
                try {
                    sSetClipToWindowEnabledMethod.invoke((Object)this.mPopup, bl);
                }
                catch (Exception exception) {
                    Log.i((String)TAG, (String)"Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.setIsClippedToScreen(this.mPopup, bl);
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        return new ForwardingListener(this, view){
            final ListPopupWindow this$0;
            {
                this.this$0 = listPopupWindow;
                super(view);
            }

            @Override
            public ListPopupWindow getPopup() {
                return this.this$0;
            }
        };
    }

    DropDownListView createDropDownListView(Context context, boolean bl) {
        return new DropDownListView(context, bl);
    }

    @Override
    public void dismiss() {
        this.mPopup.dismiss();
        this.removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks((Runnable)this.mResizePopupRunnable);
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public Rect getEpicenterBounds() {
        Rect rect = this.mEpicenterBounds != null ? new Rect(this.mEpicenterBounds) : null;
        return rect;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    @Override
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public Object getSelectedItem() {
        if (!this.isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (!this.isShowing()) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (!this.isShowing()) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        if (!this.isShowing()) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        boolean bl = this.mPopup.getInputMethodMode() == 2;
        return bl;
    }

    public boolean isModal() {
        return this.mModal;
    }

    @Override
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int n, KeyEvent keyEvent) {
        block6: {
            int n2;
            int n3;
            boolean bl;
            int n4;
            block7: {
                if (!this.isShowing() || n == 62 || this.mDropDownList.getSelectedItemPosition() < 0 && ListPopupWindow.isConfirmKey(n)) break block6;
                n4 = this.mDropDownList.getSelectedItemPosition();
                bl = this.mPopup.isAboveAnchor() ^ true;
                ListAdapter listAdapter = this.mAdapter;
                n3 = Integer.MAX_VALUE;
                n2 = Integer.MIN_VALUE;
                if (listAdapter != null) {
                    boolean bl2 = listAdapter.areAllItemsEnabled();
                    n2 = bl2 ? 0 : this.mDropDownList.lookForSelectablePosition(0, true);
                    n3 = n2;
                    n2 = bl2 ? listAdapter.getCount() - 1 : this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() - 1, false);
                }
                if (bl && n == 19 && n4 <= n3 || !bl && n == 20 && n4 >= n2) {
                    this.clearListSelection();
                    this.mPopup.setInputMethodMode(1);
                    this.show();
                    return true;
                }
                this.mDropDownList.setListSelectionHidden(false);
                if (!this.mDropDownList.onKeyDown(n, keyEvent)) break block7;
                this.mPopup.setInputMethodMode(2);
                this.mDropDownList.requestFocusFromTouch();
                this.show();
                switch (n) {
                    default: {
                        break block6;
                    }
                    case 19: 
                    case 20: 
                    case 23: 
                    case 66: {
                        return true;
                    }
                }
            }
            if (bl && n == 20 ? n4 == n2 : !bl && n == 19 && n4 == n3) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int n, KeyEvent keyEvent) {
        if (n == 4 && this.isShowing()) {
            View view = this.mDropDownAnchorView;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                if ((view = view.getKeyDispatcherState()) != null) {
                    view.startTracking(keyEvent, (Object)this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                if ((view = view.getKeyDispatcherState()) != null) {
                    view.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    this.dismiss();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean onKeyUp(int n, KeyEvent keyEvent) {
        if (this.isShowing() && this.mDropDownList.getSelectedItemPosition() >= 0) {
            boolean bl = this.mDropDownList.onKeyUp(n, keyEvent);
            if (bl && ListPopupWindow.isConfirmKey(n)) {
                this.dismiss();
            }
            return bl;
        }
        return false;
    }

    public boolean performItemClick(int n) {
        if (this.isShowing()) {
            if (this.mItemClickListener != null) {
                DropDownListView dropDownListView = this.mDropDownList;
                View view = dropDownListView.getChildAt(n - dropDownListView.getFirstVisiblePosition());
                ListAdapter listAdapter = dropDownListView.getAdapter();
                this.mItemClickListener.onItemClick((AdapterView)dropDownListView, view, n, listAdapter.getItemId(n));
            }
            return true;
        }
        return false;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver(this);
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int n) {
        this.mPopup.setAnimationStyle(n);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        this.mPopup.setBackgroundDrawable(drawable2);
    }

    public void setContentWidth(int n) {
        Drawable drawable2 = this.mPopup.getBackground();
        if (drawable2 != null) {
            drawable2.getPadding(this.mTempRect);
            this.mDropDownWidth = this.mTempRect.left + this.mTempRect.right + n;
        } else {
            this.setWidth(n);
        }
    }

    public void setDropDownAlwaysVisible(boolean bl) {
        this.mDropDownAlwaysVisible = bl;
    }

    public void setDropDownGravity(int n) {
        this.mDropDownGravity = n;
    }

    public void setEpicenterBounds(Rect object) {
        object = object != null ? new Rect(object) : null;
        this.mEpicenterBounds = object;
    }

    public void setForceIgnoreOutsideTouch(boolean bl) {
        this.mForceIgnoreOutsideTouch = bl;
    }

    public void setHeight(int n) {
        if (n < 0 && -2 != n && -1 != n) {
            throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
        }
        this.mDropDownHeight = n;
    }

    public void setHorizontalOffset(int n) {
        this.mDropDownHorizontalOffset = n;
    }

    public void setInputMethodMode(int n) {
        this.mPopup.setInputMethodMode(n);
    }

    void setListItemExpandMax(int n) {
        this.mListItemExpandMaximum = n;
    }

    public void setListSelector(Drawable drawable2) {
        this.mDropDownListHighlight = drawable2;
    }

    public void setModal(boolean bl) {
        this.mModal = bl;
        this.mPopup.setFocusable(bl);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean bl) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = bl;
    }

    public void setPromptPosition(int n) {
        this.mPromptPosition = n;
    }

    public void setPromptView(View view) {
        boolean bl = this.isShowing();
        if (bl) {
            this.removePromptView();
        }
        this.mPromptView = view;
        if (bl) {
            this.show();
        }
    }

    public void setSelection(int n) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (this.isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(n);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(n, true);
            }
        }
    }

    public void setSoftInputMode(int n) {
        this.mPopup.setSoftInputMode(n);
    }

    public void setVerticalOffset(int n) {
        this.mDropDownVerticalOffset = n;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int n) {
        this.mDropDownWidth = n;
    }

    public void setWindowLayoutType(int n) {
        this.mDropDownWindowLayoutType = n;
    }

    @Override
    public void show() {
        int n = this.buildDropDown();
        boolean bl = this.isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean bl2 = this.mPopup.isShowing();
        boolean bl3 = true;
        if (bl2) {
            int n2;
            PopupWindow popupWindow;
            if (!ViewCompat.isAttachedToWindow(this.getAnchorView())) {
                return;
            }
            int n3 = this.mDropDownWidth == -1 ? -1 : (this.mDropDownWidth == -2 ? this.getAnchorView().getWidth() : this.mDropDownWidth);
            if (this.mDropDownHeight == -1) {
                if (!bl) {
                    n = -1;
                }
                if (bl) {
                    popupWindow = this.mPopup;
                    n2 = this.mDropDownWidth == -1 ? -1 : 0;
                    popupWindow.setWidth(n2);
                    this.mPopup.setHeight(0);
                } else {
                    popupWindow = this.mPopup;
                    n2 = this.mDropDownWidth == -1 ? -1 : 0;
                    popupWindow.setWidth(n2);
                    this.mPopup.setHeight(-1);
                }
            } else if (this.mDropDownHeight != -2) {
                n = this.mDropDownHeight;
            }
            popupWindow = this.mPopup;
            if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
                bl3 = false;
            }
            popupWindow.setOutsideTouchable(bl3);
            PopupWindow popupWindow2 = this.mPopup;
            popupWindow = this.getAnchorView();
            int n4 = this.mDropDownHorizontalOffset;
            n2 = this.mDropDownVerticalOffset;
            if (n3 < 0) {
                n3 = -1;
            }
            if (n < 0) {
                n = -1;
            }
            popupWindow2.update((View)popupWindow, n4, n2, n3, n);
        } else {
            int n5 = this.mDropDownWidth == -1 ? -1 : (this.mDropDownWidth == -2 ? this.getAnchorView().getWidth() : this.mDropDownWidth);
            if (this.mDropDownHeight == -1) {
                n = -1;
            } else if (this.mDropDownHeight != -2) {
                n = this.mDropDownHeight;
            }
            this.mPopup.setWidth(n5);
            this.mPopup.setHeight(n);
            this.setPopupClipToScreenEnabled(true);
            PopupWindow popupWindow = this.mPopup;
            bl3 = !this.mForceIgnoreOutsideTouch && !this.mDropDownAlwaysVisible;
            popupWindow.setOutsideTouchable(bl3);
            this.mPopup.setTouchInterceptor((View.OnTouchListener)this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                if (sSetEpicenterBoundsMethod != null) {
                    try {
                        sSetEpicenterBoundsMethod.invoke((Object)this.mPopup, this.mEpicenterBounds);
                    }
                    catch (Exception exception) {
                        Log.e((String)TAG, (String)"Could not invoke setEpicenterBounds on PopupWindow", (Throwable)exception);
                    }
                }
            } else {
                Api29Impl.setEpicenterBounds(this.mPopup, this.mEpicenterBounds);
            }
            PopupWindowCompat.showAsDropDown(this.mPopup, this.getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if (!this.mModal || this.mDropDownList.isInTouchMode()) {
                this.clearListSelection();
            }
            if (!this.mModal) {
                this.mHandler.post((Runnable)this.mHideSelector);
            }
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static int getMaxAvailableHeight(PopupWindow popupWindow, View view, int n, boolean bl) {
            return popupWindow.getMaxAvailableHeight(view, n, bl);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setEpicenterBounds(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void setIsClippedToScreen(PopupWindow popupWindow, boolean bl) {
            popupWindow.setIsClippedToScreen(bl);
        }
    }

    private class ListSelectorHider
    implements Runnable {
        final ListPopupWindow this$0;

        ListSelectorHider(ListPopupWindow listPopupWindow) {
            this.this$0 = listPopupWindow;
        }

        @Override
        public void run() {
            this.this$0.clearListSelection();
        }
    }

    private class PopupDataSetObserver
    extends DataSetObserver {
        final ListPopupWindow this$0;

        PopupDataSetObserver(ListPopupWindow listPopupWindow) {
            this.this$0 = listPopupWindow;
        }

        public void onChanged() {
            if (this.this$0.isShowing()) {
                this.this$0.show();
            }
        }

        public void onInvalidated() {
            this.this$0.dismiss();
        }
    }

    private class PopupScrollListener
    implements AbsListView.OnScrollListener {
        final ListPopupWindow this$0;

        PopupScrollListener(ListPopupWindow listPopupWindow) {
            this.this$0 = listPopupWindow;
        }

        public void onScroll(AbsListView absListView, int n, int n2, int n3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int n) {
            if (n == 1 && !this.this$0.isInputMethodNotNeeded() && this.this$0.mPopup.getContentView() != null) {
                this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
                this.this$0.mResizePopupRunnable.run();
            }
        }
    }

    private class PopupTouchInterceptor
    implements View.OnTouchListener {
        final ListPopupWindow this$0;

        PopupTouchInterceptor(ListPopupWindow listPopupWindow) {
            this.this$0 = listPopupWindow;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int n = motionEvent.getAction();
            int n2 = (int)motionEvent.getX();
            int n3 = (int)motionEvent.getY();
            if (n == 0 && this.this$0.mPopup != null && this.this$0.mPopup.isShowing() && n2 >= 0 && n2 < this.this$0.mPopup.getWidth() && n3 >= 0 && n3 < this.this$0.mPopup.getHeight()) {
                this.this$0.mHandler.postDelayed((Runnable)this.this$0.mResizePopupRunnable, 250L);
            } else if (n == 1) {
                this.this$0.mHandler.removeCallbacks((Runnable)this.this$0.mResizePopupRunnable);
            }
            return false;
        }
    }

    private class ResizePopupRunnable
    implements Runnable {
        final ListPopupWindow this$0;

        ResizePopupRunnable(ListPopupWindow listPopupWindow) {
            this.this$0 = listPopupWindow;
        }

        @Override
        public void run() {
            if (this.this$0.mDropDownList != null && ViewCompat.isAttachedToWindow((View)this.this$0.mDropDownList) && this.this$0.mDropDownList.getCount() > this.this$0.mDropDownList.getChildCount() && this.this$0.mDropDownList.getChildCount() <= this.this$0.mListItemExpandMaximum) {
                this.this$0.mPopup.setInputMethodMode(2);
                this.this$0.show();
            }
        }
    }
}

