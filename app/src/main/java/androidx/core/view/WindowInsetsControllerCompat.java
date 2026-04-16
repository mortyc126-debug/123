/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowInsetsAnimationControlListener
 *  android.view.WindowInsetsAnimationController
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsAnimationControllerCompat;
import androidx.core.view.WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0;

public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_DEFAULT = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    @Deprecated
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public WindowInsetsControllerCompat(Window window, View object) {
        object = new SoftwareKeyboardControllerCompat((View)object);
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(window, this, (SoftwareKeyboardControllerCompat)object) : (Build.VERSION.SDK_INT >= 26 ? new Impl26(window, (SoftwareKeyboardControllerCompat)object) : new Impl23(window, (SoftwareKeyboardControllerCompat)object));
    }

    @Deprecated
    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = new Impl30(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }

    @Deprecated
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(n, l, interpolator2, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int n) {
        this.mImpl.hide(n);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean bl) {
        this.mImpl.setAppearanceLightNavigationBars(bl);
    }

    public void setAppearanceLightStatusBars(boolean bl) {
        this.mImpl.setAppearanceLightStatusBars(bl);
    }

    public void setSystemBarsBehavior(int n) {
        this.mImpl.setSystemBarsBehavior(n);
    }

    public void show(int n) {
        this.mImpl.show(n);
    }

    private static class Impl {
        Impl() {
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int n) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void setAppearanceLightNavigationBars(boolean bl) {
        }

        public void setAppearanceLightStatusBars(boolean bl) {
        }

        void setSystemBarsBehavior(int n) {
        }

        void show(int n) {
        }
    }

    private static class Impl20
    extends Impl {
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected final Window mWindow;

        Impl20(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mWindow = window;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        private void hideForType(int n) {
            switch (n) {
                default: {
                    break;
                }
                case 8: {
                    this.mSoftwareKeyboardControllerCompat.hide();
                    break;
                }
                case 2: {
                    this.setSystemUiFlag(2);
                    return;
                }
                case 1: {
                    this.setSystemUiFlag(4);
                    return;
                }
            }
        }

        private void showForType(int n) {
            switch (n) {
                default: {
                    break;
                }
                case 8: {
                    this.mSoftwareKeyboardControllerCompat.show();
                    break;
                }
                case 2: {
                    this.unsetSystemUiFlag(2);
                    return;
                }
                case 1: {
                    this.unsetSystemUiFlag(4);
                    this.unsetWindowFlag(1024);
                    return;
                }
            }
        }

        @Override
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override
        void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        @Override
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override
        void hide(int n) {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) == 0) continue;
                this.hideForType(i);
            }
        }

        @Override
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override
        void setSystemBarsBehavior(int n) {
            switch (n) {
                default: {
                    break;
                }
                case 2: {
                    this.unsetSystemUiFlag(2048);
                    this.setSystemUiFlag(4096);
                    break;
                }
                case 1: {
                    this.unsetSystemUiFlag(4096);
                    this.setSystemUiFlag(2048);
                    break;
                }
                case 0: {
                    this.unsetSystemUiFlag(6144);
                }
            }
        }

        protected void setSystemUiFlag(int n) {
            View view = this.mWindow.getDecorView();
            view.setSystemUiVisibility(view.getSystemUiVisibility() | n);
        }

        protected void setWindowFlag(int n) {
            this.mWindow.addFlags(n);
        }

        @Override
        void show(int n) {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) == 0) continue;
                this.showForType(i);
            }
        }

        protected void unsetSystemUiFlag(int n) {
            View view = this.mWindow.getDecorView();
            view.setSystemUiVisibility(view.getSystemUiVisibility() & ~n);
        }

        protected void unsetWindowFlag(int n) {
            this.mWindow.clearFlags(n);
        }
    }

    private static class Impl23
    extends Impl20 {
        Impl23(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override
        public boolean isAppearanceLightStatusBars() {
            boolean bl = (this.mWindow.getDecorView().getSystemUiVisibility() & 0x2000) != 0;
            return bl;
        }

        @Override
        public void setAppearanceLightStatusBars(boolean bl) {
            if (bl) {
                this.unsetWindowFlag(0x4000000);
                this.setWindowFlag(Integer.MIN_VALUE);
                this.setSystemUiFlag(8192);
            } else {
                this.unsetSystemUiFlag(8192);
            }
        }
    }

    private static class Impl26
    extends Impl23 {
        Impl26(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override
        public boolean isAppearanceLightNavigationBars() {
            boolean bl = (this.mWindow.getDecorView().getSystemUiVisibility() & 0x10) != 0;
            return bl;
        }

        @Override
        public void setAppearanceLightNavigationBars(boolean bl) {
            if (bl) {
                this.unsetWindowFlag(0x8000000);
                this.setWindowFlag(Integer.MIN_VALUE);
                this.setSystemUiFlag(16);
            } else {
                this.unsetSystemUiFlag(16);
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    private static class Impl30
    extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners = new SimpleArrayMap();
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.mWindow = window;
        }

        Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        @Override
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0 windowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0 = new WindowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0(this, onControllableInsetsChangedListener);
            this.mListeners.put(onControllableInsetsChangedListener, windowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0);
            this.mInsetsController.addOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)windowInsetsControllerCompat$Impl30$$ExternalSyntheticLambda0);
        }

        @Override
        void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator2, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat object) {
            object = new WindowInsetsAnimationControlListener(){
                private WindowInsetsAnimationControllerCompat mCompatAnimController;
                final Impl30 this$0;
                final WindowInsetsAnimationControlListenerCompat val$listener;
                {
                    this.this$0 = impl30;
                    this.val$listener = windowInsetsAnimationControlListenerCompat;
                    this.mCompatAnimController = null;
                }

                public void onCancelled(WindowInsetsAnimationController object) {
                    WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat = this.val$listener;
                    object = object == null ? null : this.mCompatAnimController;
                    windowInsetsAnimationControlListenerCompat.onCancelled((WindowInsetsAnimationControllerCompat)object);
                }

                public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                    this.val$listener.onFinished(this.mCompatAnimController);
                }

                public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int n) {
                    this.mCompatAnimController = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.val$listener.onReady(this.mCompatAnimController, n);
                }
            };
            this.mInsetsController.controlWindowInsetsAnimation(n, l, interpolator2, cancellationSignal, (WindowInsetsAnimationControlListener)object);
        }

        @Override
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override
        void hide(int n) {
            if ((n & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.hide();
            }
            this.mInsetsController.hide(n & 0xFFFFFFF7);
        }

        @Override
        public boolean isAppearanceLightNavigationBars() {
            WindowInsetsController windowInsetsController = this.mInsetsController;
            boolean bl = false;
            windowInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 0x10) != 0) {
                bl = true;
            }
            return bl;
        }

        @Override
        public boolean isAppearanceLightStatusBars() {
            WindowInsetsController windowInsetsController = this.mInsetsController;
            boolean bl = false;
            windowInsetsController.setSystemBarsAppearance(0, 0);
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) != 0) {
                bl = true;
            }
            return bl;
        }

        /* synthetic */ void lambda$addOnControllableInsetsChangedListener$0$androidx-core-view-WindowInsetsControllerCompat$Impl30(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int n) {
            if (this.mInsetsController == windowInsetsController) {
                onControllableInsetsChangedListener.onControllableInsetsChanged(this.mCompatController, n);
            }
        }

        @Override
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if ((onControllableInsetsChangedListener = this.mListeners.remove(onControllableInsetsChangedListener)) != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)onControllableInsetsChangedListener);
            }
        }

        @Override
        public void setAppearanceLightNavigationBars(boolean bl) {
            if (bl) {
                if (this.mWindow != null) {
                    this.setSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                if (this.mWindow != null) {
                    this.unsetSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override
        public void setAppearanceLightStatusBars(boolean bl) {
            if (bl) {
                if (this.mWindow != null) {
                    this.setSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                if (this.mWindow != null) {
                    this.unsetSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        @Override
        void setSystemBarsBehavior(int n) {
            this.mInsetsController.setSystemBarsBehavior(n);
        }

        protected void setSystemUiFlag(int n) {
            View view = this.mWindow.getDecorView();
            view.setSystemUiVisibility(view.getSystemUiVisibility() | n);
        }

        @Override
        void show(int n) {
            if ((n & 8) != 0) {
                this.mSoftwareKeyboardControllerCompat.show();
            }
            this.mInsetsController.show(n & 0xFFFFFFF7);
        }

        protected void unsetSystemUiFlag(int n) {
            View view = this.mWindow.getDecorView();
            view.setSystemUiVisibility(view.getSystemUiVisibility() & ~n);
        }
    }

    public static interface OnControllableInsetsChangedListener {
        public void onControllableInsetsChanged(WindowInsetsControllerCompat var1, int var2);
    }
}

