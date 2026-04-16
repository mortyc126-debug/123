/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.AdapterView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView
extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding = 0;
    private int mSelectionLeftPadding = 0;
    private int mSelectionRightPadding = 0;
    private int mSelectionTopPadding = 0;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect = new Rect();

    DropDownListView(Context context, boolean bl) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = bl;
        this.setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View view = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition());
        if (view != null) {
            view.setPressed(false);
        }
        if (this.mClickAnimation != null) {
            this.mClickAnimation.cancel();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int n) {
        this.performItemClick(view, n, this.getItemIdAtPosition(n));
    }

    private void drawSelectorCompat(Canvas canvas) {
        Drawable drawable2;
        if (!this.mSelectorRect.isEmpty() && (drawable2 = this.getSelector()) != null) {
            drawable2.setBounds(this.mSelectorRect);
            drawable2.draw(canvas);
        }
    }

    private void positionSelectorCompat(int n, View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        boolean bl = this.superIsSelectedChildViewEnabled();
        if (view.isEnabled() != bl) {
            this.superSetSelectedChildViewEnabled(bl ^ true);
            if (n != -1) {
                this.refreshDrawableState();
            }
        }
    }

    private void positionSelectorLikeFocusCompat(int n, View view) {
        Drawable drawable2 = this.getSelector();
        boolean bl = true;
        boolean bl2 = drawable2 != null && n != -1;
        if (bl2) {
            drawable2.setVisible(false, false);
        }
        this.positionSelectorCompat(n, view);
        if (bl2) {
            view = this.mSelectorRect;
            float f = view.exactCenterX();
            float f2 = view.exactCenterY();
            if (this.getVisibility() != 0) {
                bl = false;
            }
            drawable2.setVisible(bl, false);
            DrawableCompat.setHotspot(drawable2, f, f2);
        }
    }

    private void positionSelectorLikeTouchCompat(int n, View view, float f, float f2) {
        this.positionSelectorLikeFocusCompat(n, view);
        view = this.getSelector();
        if (view != null && n != -1) {
            DrawableCompat.setHotspot((Drawable)view, f, f2);
        }
    }

    private void setPressedItem(View view, int n, float f, float f2) {
        View view2;
        this.mDrawsInPressedState = true;
        Api21Impl.drawableHotspotChanged((View)this, f, f2);
        if (!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        if (this.mMotionPosition != -1 && (view2 = this.getChildAt(this.mMotionPosition - this.getFirstVisiblePosition())) != null && view2 != view && view2.isPressed()) {
            view2.setPressed(false);
        }
        this.mMotionPosition = n;
        float f3 = view.getLeft();
        float f4 = view.getTop();
        Api21Impl.drawableHotspotChanged(view, f - f3, f2 - f4);
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        this.positionSelectorLikeTouchCompat(n, view, f, f2);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    private void setSelectorEnabled(boolean bl) {
        if (this.mSelector != null) {
            this.mSelector.setEnabled(bl);
        }
    }

    private boolean superIsSelectedChildViewEnabled() {
        if (BuildCompat.isAtLeastT()) {
            return Api33Impl.isSelectedChildViewEnabled((AbsListView)this);
        }
        return PreApi33Impl.isSelectedChildViewEnabled((AbsListView)this);
    }

    private void superSetSelectedChildViewEnabled(boolean bl) {
        if (BuildCompat.isAtLeastT()) {
            Api33Impl.setSelectedChildViewEnabled((AbsListView)this, bl);
        } else {
            PreApi33Impl.setSelectedChildViewEnabled((AbsListView)this, bl);
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable drawable2 = this.getSelector();
        if (drawable2 != null && this.touchModeDrawsInPressedStateCompat() && this.isPressed()) {
            drawable2.setState(this.getDrawableState());
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        this.drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.mResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.updateSelectorStateCompat();
    }

    public boolean hasFocus() {
        boolean bl = this.mHijackFocus || super.hasFocus();
        return bl;
    }

    public boolean hasWindowFocus() {
        boolean bl = this.mHijackFocus || super.hasWindowFocus();
        return bl;
    }

    public boolean isFocused() {
        boolean bl = this.mHijackFocus || super.isFocused();
        return bl;
    }

    public boolean isInTouchMode() {
        boolean bl = this.mHijackFocus && this.mListSelectionHidden || super.isInTouchMode();
        return bl;
    }

    public int lookForSelectablePosition(int n, boolean bl) {
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter != null && !this.isInTouchMode()) {
            int n2 = listAdapter.getCount();
            if (!this.getAdapter().areAllItemsEnabled()) {
                int n3;
                if (bl) {
                    n = Math.max(0, n);
                    while (true) {
                        n3 = n;
                        if (n < n2) {
                            n3 = n;
                            if (!listAdapter.isEnabled(n)) {
                                ++n;
                                continue;
                            }
                        }
                        break;
                    }
                } else {
                    n = Math.min(n, n2 - 1);
                    while (true) {
                        n3 = n;
                        if (n < 0) break;
                        n3 = n;
                        if (listAdapter.isEnabled(n)) break;
                        --n;
                    }
                }
                if (n3 >= 0 && n3 < n2) {
                    return n3;
                }
                return -1;
            }
            if (n >= 0 && n < n2) {
                return n;
            }
            return -1;
        }
        return -1;
    }

    public int measureHeightOfChildrenCompat(int n, int n2, int n3, int n4, int n5) {
        int n6 = this.getListPaddingTop();
        int n7 = this.getListPaddingBottom();
        int n8 = this.getDividerHeight();
        Drawable drawable2 = this.getDivider();
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter == null) {
            return n6 + n7;
        }
        n3 = n6 + n7;
        if (n8 <= 0 || drawable2 == null) {
            n8 = 0;
        }
        n2 = 0;
        drawable2 = null;
        int n9 = 0;
        int n10 = listAdapter.getCount();
        for (int i = 0; i < n10; ++i) {
            View view;
            int n11 = listAdapter.getItemViewType(i);
            int n12 = n9;
            if (n11 != n9) {
                drawable2 = null;
                n12 = n11;
            }
            if ((drawable2 = (view = listAdapter.getView(i, (View)drawable2, (ViewGroup)this)).getLayoutParams()) == null) {
                drawable2 = this.generateDefaultLayoutParams();
                view.setLayoutParams((ViewGroup.LayoutParams)drawable2);
            }
            n9 = drawable2.height > 0 ? View.MeasureSpec.makeMeasureSpec((int)drawable2.height, (int)0x40000000) : View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            view.measure(n, n9);
            view.forceLayout();
            n9 = n3;
            if (i > 0) {
                n9 = n3 + n8;
            }
            if ((n3 = n9 + view.getMeasuredHeight()) >= n4) {
                if (n5 < 0 || i <= n5 || n2 <= 0 || n3 == n4) {
                    n2 = n4;
                }
                return n2;
            }
            n9 = n2;
            if (n5 >= 0) {
                n9 = n2;
                if (i >= n5) {
                    n9 = n3;
                }
            }
            n2 = n9;
            drawable2 = view;
            n9 = n12;
        }
        return n3;
    }

    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    public boolean onForwardedEvent(MotionEvent motionEvent, int n) {
        boolean bl = true;
        boolean bl2 = true;
        int n2 = 0;
        int n3 = motionEvent.getActionMasked();
        switch (n3) {
            default: {
                bl2 = bl;
                n = n2;
                break;
            }
            case 3: {
                bl2 = false;
                n = n2;
                break;
            }
            case 1: {
                bl2 = false;
            }
            case 2: {
                int n4;
                int n5 = motionEvent.findPointerIndex(n);
                if (n5 < 0) {
                    bl2 = false;
                    n = n2;
                    break;
                }
                n = (int)motionEvent.getX(n5);
                if ((n5 = this.pointToPosition(n, n4 = (int)motionEvent.getY(n5))) == -1) {
                    n = 1;
                    break;
                }
                View view = this.getChildAt(n5 - this.getFirstVisiblePosition());
                this.setPressedItem(view, n5, n, n4);
                bl2 = bl = true;
                n = n2;
                if (n3 != 1) break;
                this.clickPressedItem(view, n5);
                n = n2;
                bl2 = bl;
            }
        }
        if (!bl2 || n != 0) {
            this.clearPressedItem();
        }
        if (bl2) {
            if (this.mScrollHelper == null) {
                this.mScrollHelper = new ListViewAutoScrollHelper(this);
            }
            this.mScrollHelper.setEnabled(true);
            this.mScrollHelper.onTouch((View)this, motionEvent);
        } else if (this.mScrollHelper != null) {
            this.mScrollHelper.setEnabled(false);
        }
        return bl2;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int n = motionEvent.getActionMasked();
        if (n == 10 && this.mResolveHoverRunnable == null) {
            this.mResolveHoverRunnable = new ResolveHoverRunnable(this);
            this.mResolveHoverRunnable.post();
        }
        boolean bl = super.onHoverEvent(motionEvent);
        if (n != 9 && n != 7) {
            this.setSelection(-1);
        } else {
            n = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
            if (n != -1 && n != this.getSelectedItemPosition()) {
                motionEvent = this.getChildAt(n - this.getFirstVisiblePosition());
                if (motionEvent.isEnabled()) {
                    this.requestFocus();
                    if (Build.VERSION.SDK_INT >= 30 && Api30Impl.canPositionSelectorForHoveredItem()) {
                        Api30Impl.positionSelectorForHoveredItem(this, n, (View)motionEvent);
                    } else {
                        this.setSelectionFromTop(n, motionEvent.getTop() - this.getTop());
                    }
                }
                this.updateSelectorStateCompat();
            }
        }
        return bl;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            default: {
                break;
            }
            case 0: {
                this.mMotionPosition = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
            }
        }
        if (this.mResolveHoverRunnable != null) {
            this.mResolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean bl) {
        this.mListSelectionHidden = bl;
    }

    public void setSelector(Drawable drawable2) {
        GateKeeperDrawable gateKeeperDrawable = drawable2 != null ? new GateKeeperDrawable(drawable2) : null;
        this.mSelector = gateKeeperDrawable;
        super.setSelector((Drawable)this.mSelector);
        gateKeeperDrawable = new Rect();
        if (drawable2 != null) {
            drawable2.getPadding((Rect)gateKeeperDrawable);
        }
        this.mSelectionLeftPadding = ((Rect)gateKeeperDrawable).left;
        this.mSelectionTopPadding = ((Rect)gateKeeperDrawable).top;
        this.mSelectionRightPadding = ((Rect)gateKeeperDrawable).right;
        this.mSelectionBottomPadding = ((Rect)gateKeeperDrawable).bottom;
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void drawableHotspotChanged(View view, float f, float f2) {
            view.drawableHotspotChanged(f, f2);
        }
    }

    static class Api30Impl {
        private static boolean sHasMethods;
        private static Method sPositionSelector;
        private static Method sSetNextSelectedPositionInt;
        private static Method sSetSelectedPositionInt;

        static {
            try {
                sPositionSelector = AbsListView.class.getDeclaredMethod("positionSelector", Integer.TYPE, View.class, Boolean.TYPE, Float.TYPE, Float.TYPE);
                sPositionSelector.setAccessible(true);
                sSetSelectedPositionInt = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", Integer.TYPE);
                sSetSelectedPositionInt.setAccessible(true);
                sSetNextSelectedPositionInt = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", Integer.TYPE);
                sSetNextSelectedPositionInt.setAccessible(true);
                sHasMethods = true;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
        }

        private Api30Impl() {
        }

        static boolean canPositionSelectorForHoveredItem() {
            return sHasMethods;
        }

        static void positionSelectorForHoveredItem(DropDownListView dropDownListView, int n, View view) {
            try {
                sPositionSelector.invoke((Object)dropDownListView, n, view, false, -1, -1);
                sSetSelectedPositionInt.invoke((Object)dropDownListView, n);
                sSetNextSelectedPositionInt.invoke((Object)dropDownListView, n);
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static boolean isSelectedChildViewEnabled(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void setSelectedChildViewEnabled(AbsListView absListView, boolean bl) {
            absListView.setSelectedChildViewEnabled(bl);
        }
    }

    private static class GateKeeperDrawable
    extends DrawableWrapperCompat {
        private boolean mEnabled = true;

        GateKeeperDrawable(Drawable drawable2) {
            super(drawable2);
        }

        @Override
        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        void setEnabled(boolean bl) {
            this.mEnabled = bl;
        }

        @Override
        public void setHotspot(float f, float f2) {
            if (this.mEnabled) {
                super.setHotspot(f, f2);
            }
        }

        @Override
        public void setHotspotBounds(int n, int n2, int n3, int n4) {
            if (this.mEnabled) {
                super.setHotspotBounds(n, n2, n3, n4);
            }
        }

        @Override
        public boolean setState(int[] nArray) {
            if (this.mEnabled) {
                return super.setState(nArray);
            }
            return false;
        }

        @Override
        public boolean setVisible(boolean bl, boolean bl2) {
            if (this.mEnabled) {
                return super.setVisible(bl, bl2);
            }
            return false;
        }
    }

    static class PreApi33Impl {
        private static final Field sIsChildViewEnabled;

        static {
            Field field;
            Field field2 = null;
            field2 = field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            try {
                field.setAccessible(true);
                field2 = field;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                noSuchFieldException.printStackTrace();
            }
            sIsChildViewEnabled = field2;
        }

        private PreApi33Impl() {
        }

        static boolean isSelectedChildViewEnabled(AbsListView absListView) {
            if (sIsChildViewEnabled != null) {
                try {
                    boolean bl = sIsChildViewEnabled.getBoolean(absListView);
                    return bl;
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
            return false;
        }

        static void setSelectedChildViewEnabled(AbsListView absListView, boolean bl) {
            if (sIsChildViewEnabled != null) {
                try {
                    sIsChildViewEnabled.set(absListView, bl);
                }
                catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
    }

    private class ResolveHoverRunnable
    implements Runnable {
        final DropDownListView this$0;

        ResolveHoverRunnable(DropDownListView dropDownListView) {
            this.this$0 = dropDownListView;
        }

        public void cancel() {
            this.this$0.mResolveHoverRunnable = null;
            this.this$0.removeCallbacks(this);
        }

        public void post() {
            this.this$0.post(this);
        }

        @Override
        public void run() {
            this.this$0.mResolveHoverRunnable = null;
            this.this$0.drawableStateChanged();
        }
    }
}

