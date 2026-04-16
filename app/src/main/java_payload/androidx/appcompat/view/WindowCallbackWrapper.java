/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.KeyEvent
 *  android.view.KeyboardShortcutGroup
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.SearchEvent
 *  android.view.View
 *  android.view.Window$Callback
 *  android.view.WindowManager$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class WindowCallbackWrapper
implements Window.Callback {
    final Window.Callback mWrapped;

    public WindowCallbackWrapper(Window.Callback callback2) {
        if (callback2 != null) {
            this.mWrapped = callback2;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.mWrapped.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.mWrapped.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.mWrapped.dispatchTrackballEvent(motionEvent);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.mWrapped.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.mWrapped.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    public boolean onCreatePanelMenu(int n, Menu menu) {
        return this.mWrapped.onCreatePanelMenu(n, menu);
    }

    public View onCreatePanelView(int n) {
        return this.mWrapped.onCreatePanelView(n);
    }

    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int n, MenuItem menuItem) {
        return this.mWrapped.onMenuItemSelected(n, menuItem);
    }

    public boolean onMenuOpened(int n, Menu menu) {
        return this.mWrapped.onMenuOpened(n, menu);
    }

    public void onPanelClosed(int n, Menu menu) {
        this.mWrapped.onPanelClosed(n, menu);
    }

    public void onPointerCaptureChanged(boolean bl) {
        Api26Impl.onPointerCaptureChanged(this.mWrapped, bl);
    }

    public boolean onPreparePanel(int n, View view, Menu menu) {
        return this.mWrapped.onPreparePanel(n, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int n) {
        Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, list, menu, n);
    }

    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return Api23Impl.onSearchRequested(this.mWrapped, searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.mWrapped.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean bl) {
        this.mWrapped.onWindowFocusChanged(bl);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback2) {
        return this.mWrapped.onWindowStartingActionMode(callback2);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback2, int n) {
        return Api23Impl.onWindowStartingActionMode(this.mWrapped, callback2, n);
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean onSearchRequested(Window.Callback callback2, SearchEvent searchEvent) {
            return callback2.onSearchRequested(searchEvent);
        }

        static ActionMode onWindowStartingActionMode(Window.Callback callback2, ActionMode.Callback callback3, int n) {
            return callback2.onWindowStartingActionMode(callback3, n);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void onProvideKeyboardShortcuts(Window.Callback callback2, List<KeyboardShortcutGroup> list, Menu menu, int n) {
            callback2.onProvideKeyboardShortcuts(list, menu, n);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void onPointerCaptureChanged(Window.Callback callback2, boolean bl) {
            callback2.onPointerCaptureChanged(bl);
        }
    }
}

