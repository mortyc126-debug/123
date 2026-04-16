/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.WindowInsetsAnimationController
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsetsAnimationController;

public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    public void finish(boolean bl) {
        this.mImpl.finish(bl);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public androidx.core.graphics.Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public androidx.core.graphics.Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public androidx.core.graphics.Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        boolean bl = !this.isFinished() && !this.isCancelled();
        return bl;
    }

    public void setInsetsAndAlpha(androidx.core.graphics.Insets insets, float f, float f2) {
        this.mImpl.setInsetsAndAlpha(insets, f, f2);
    }

    private static class Impl {
        Impl() {
        }

        void finish(boolean bl) {
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        public float getCurrentFraction() {
            return 0.0f;
        }

        public androidx.core.graphics.Insets getCurrentInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        public androidx.core.graphics.Insets getHiddenStateInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        public androidx.core.graphics.Insets getShownStateInsets() {
            return androidx.core.graphics.Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        boolean isCancelled() {
            return true;
        }

        boolean isFinished() {
            return false;
        }

        public void setInsetsAndAlpha(androidx.core.graphics.Insets insets, float f, float f2) {
        }
    }

    private static class Impl30
    extends Impl {
        private final WindowInsetsAnimationController mController;

        Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        @Override
        void finish(boolean bl) {
            this.mController.finish(bl);
        }

        @Override
        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        @Override
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @Override
        public androidx.core.graphics.Insets getCurrentInsets() {
            return androidx.core.graphics.Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @Override
        public androidx.core.graphics.Insets getHiddenStateInsets() {
            return androidx.core.graphics.Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @Override
        public androidx.core.graphics.Insets getShownStateInsets() {
            return androidx.core.graphics.Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @Override
        public int getTypes() {
            return this.mController.getTypes();
        }

        @Override
        boolean isCancelled() {
            return this.mController.isCancelled();
        }

        @Override
        boolean isFinished() {
            return this.mController.isFinished();
        }

        @Override
        public void setInsetsAndAlpha(androidx.core.graphics.Insets insets, float f, float f2) {
            WindowInsetsAnimationController windowInsetsAnimationController = this.mController;
            insets = insets == null ? null : insets.toPlatformInsets();
            windowInsetsAnimationController.setInsetsAndAlpha((Insets)insets, f, f2);
        }
    }
}

