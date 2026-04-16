/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowInsets$Type
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 *  android.view.inputmethod.InputMethodManager
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0;
import androidx.core.view.SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    public SoftwareKeyboardControllerCompat(View view) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(view) : new Impl20(view);
    }

    @Deprecated
    SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController);
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }

    private static class Impl {
        Impl() {
        }

        void hide() {
        }

        void show() {
        }
    }

    private static class Impl20
    extends Impl {
        private final View mView;

        Impl20(View view) {
            this.mView = view;
        }

        static /* synthetic */ void lambda$show$0(View view) {
            ((InputMethodManager)view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
        }

        @Override
        void hide() {
            if (this.mView != null) {
                ((InputMethodManager)this.mView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            }
        }

        @Override
        void show() {
            View view = this.mView;
            if (view == null) {
                return;
            }
            if (!view.isInEditMode() && !view.onCheckIsTextEditor()) {
                view = view.getRootView().findFocus();
            } else {
                view.requestFocus();
            }
            View view2 = view;
            if (view == null) {
                view2 = this.mView.getRootView().findViewById(0x1020002);
            }
            if (view2 != null && view2.hasWindowFocus()) {
                view2.post((Runnable)new SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0(view2));
            }
        }
    }

    private static class Impl30
    extends Impl20 {
        private View mView;
        private WindowInsetsController mWindowInsetsController;

        Impl30(View view) {
            super(view);
            this.mView = view;
        }

        Impl30(WindowInsetsController windowInsetsController) {
            super(null);
            this.mWindowInsetsController = windowInsetsController;
        }

        static /* synthetic */ void lambda$hide$0(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int n) {
            boolean bl = (n & 8) != 0;
            atomicBoolean.set(bl);
        }

        @Override
        void hide() {
            WindowInsetsController windowInsetsController = null;
            if (this.mWindowInsetsController != null) {
                windowInsetsController = this.mWindowInsetsController;
            } else if (this.mView != null) {
                windowInsetsController = this.mView.getWindowInsetsController();
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 softwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0 = new SoftwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)softwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0);
                if (!atomicBoolean.get() && this.mView != null) {
                    ((InputMethodManager)this.mView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)softwareKeyboardControllerCompat$Impl30$$ExternalSyntheticLambda0);
                windowInsetsController.hide(WindowInsets.Type.ime());
            } else {
                super.hide();
            }
        }

        @Override
        void show() {
            if (this.mView != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager)this.mView.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = null;
            if (this.mWindowInsetsController != null) {
                windowInsetsController = this.mWindowInsetsController;
            } else if (this.mView != null) {
                windowInsetsController = this.mView.getWindowInsetsController();
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.show();
            }
        }
    }
}

