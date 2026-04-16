/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.transition.Transition
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.HeaderViewListAdapter
 *  android.widget.PopupWindow
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuItemHoverListener;
import java.lang.reflect.Method;

public class MenuPopupWindow
extends ListPopupWindow
implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.i((String)TAG, (String)"Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
    }

    @Override
    DropDownListView createDropDownListView(Context object, boolean bl) {
        object = new MenuDropDownListView((Context)object, bl);
        ((MenuDropDownListView)((Object)object)).setHoverListener(this);
        return object;
    }

    @Override
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.mHoverListener != null) {
            this.mHoverListener.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    @Override
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.mHoverListener != null) {
            this.mHoverListener.onItemHoverExit(menuBuilder, menuItem);
        }
    }

    public void setEnterTransition(Object object) {
        Api23Impl.setEnterTransition(this.mPopup, (Transition)object);
    }

    public void setExitTransition(Object object) {
        Api23Impl.setExitTransition(this.mPopup, (Transition)object);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }

    public void setTouchModal(boolean bl) {
        if (Build.VERSION.SDK_INT <= 28) {
            if (sSetTouchModalMethod != null) {
                try {
                    sSetTouchModalMethod.invoke((Object)this.mPopup, bl);
                }
                catch (Exception exception) {
                    Log.i((String)TAG, (String)"Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.setTouchModal(this.mPopup, bl);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void setEnterTransition(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void setExitTransition(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setTouchModal(PopupWindow popupWindow, boolean bl) {
            popupWindow.setTouchModal(bl);
        }
    }

    public static class MenuDropDownListView
    extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        public MenuDropDownListView(Context context, boolean bl) {
            super(context, bl);
            context = context.getResources().getConfiguration();
            if (1 == Api17Impl.getLayoutDirection((Configuration)context)) {
                this.mAdvanceKey = 21;
                this.mRetreatKey = 22;
            } else {
                this.mAdvanceKey = 22;
                this.mRetreatKey = 21;
            }
        }

        public void clearSelection() {
            this.setSelection(-1);
        }

        @Override
        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.mHoverListener != null) {
                Object object;
                int n;
                Object object2 = this.getAdapter();
                if (object2 instanceof HeaderViewListAdapter) {
                    object2 = (HeaderViewListAdapter)object2;
                    n = object2.getHeadersCount();
                    object = (MenuAdapter)object2.getWrappedAdapter();
                } else {
                    n = 0;
                    object = (MenuAdapter)((Object)object2);
                }
                MenuItem menuItem = null;
                object2 = menuItem;
                if (motionEvent.getAction() != 10) {
                    int n2 = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
                    object2 = menuItem;
                    if (n2 != -1) {
                        n = n2 - n;
                        object2 = menuItem;
                        if (n >= 0) {
                            object2 = menuItem;
                            if (n < ((MenuAdapter)((Object)object)).getCount()) {
                                object2 = ((MenuAdapter)((Object)object)).getItem(n);
                            }
                        }
                    }
                }
                if ((menuItem = this.mHoveredMenuItem) != object2) {
                    object = ((MenuAdapter)((Object)object)).getAdapterMenu();
                    if (menuItem != null) {
                        this.mHoverListener.onItemHoverExit((MenuBuilder)object, menuItem);
                    }
                    this.mHoveredMenuItem = object2;
                    if (object2 != null) {
                        this.mHoverListener.onItemHoverEnter((MenuBuilder)object, (MenuItem)object2);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int n, KeyEvent object) {
            ListMenuItemView listMenuItemView = (ListMenuItemView)this.getSelectedView();
            if (listMenuItemView != null && n == this.mAdvanceKey) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    this.performItemClick((View)listMenuItemView, this.getSelectedItemPosition(), this.getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && n == this.mRetreatKey) {
                this.setSelection(-1);
                object = this.getAdapter();
                object = object instanceof HeaderViewListAdapter ? (MenuAdapter)((HeaderViewListAdapter)object).getWrappedAdapter() : (MenuAdapter)((Object)object);
                object.getAdapterMenu().close(false);
                return true;
            }
            return super.onKeyDown(n, object);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.mHoverListener = menuItemHoverListener;
        }

        static class Api17Impl {
            private Api17Impl() {
            }

            static int getLayoutDirection(Configuration configuration2) {
                return configuration2.getLayoutDirection();
            }
        }
    }
}

