/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.DisplayCutout
 *  android.view.View
 *  android.view.WindowInsets
 *  android.view.WindowInsets$Builder
 *  android.view.WindowInsets$Type
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED = Build.VERSION.SDK_INT >= 30 ? Impl30.CONSUMED : Impl.CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    private WindowInsetsCompat(WindowInsets windowInsets) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(this, windowInsets) : (Build.VERSION.SDK_INT >= 29 ? new Impl29(this, windowInsets) : (Build.VERSION.SDK_INT >= 28 ? new Impl28(this, windowInsets) : new Impl21(this, windowInsets)));
    }

    public WindowInsetsCompat(WindowInsetsCompat object) {
        if (object != null) {
            object = ((WindowInsetsCompat)object).mImpl;
            this.mImpl = Build.VERSION.SDK_INT >= 30 && object instanceof Impl30 ? new Impl30(this, (Impl30)object) : (Build.VERSION.SDK_INT >= 29 && object instanceof Impl29 ? new Impl29(this, (Impl29)object) : (Build.VERSION.SDK_INT >= 28 && object instanceof Impl28 ? new Impl28(this, (Impl28)object) : (object instanceof Impl21 ? new Impl21(this, (Impl21)object) : (object instanceof Impl20 ? new Impl20(this, (Impl20)object) : new Impl(this)))));
            ((Impl)object).copyWindowDataInto(this);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    static Insets insetInsets(Insets insets, int n, int n2, int n3, int n4) {
        int n5 = Math.max(0, insets.left - n);
        int n6 = Math.max(0, insets.top - n2);
        int n7 = Math.max(0, insets.right - n3);
        int n8 = Math.max(0, insets.bottom - n4);
        if (n5 == n && n6 == n2 && n7 == n3 && n8 == n4) {
            return insets;
        }
        return Insets.of(n5, n6, n7, n8);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets object, View view) {
        object = new WindowInsetsCompat(Preconditions.checkNotNull(object));
        if (view != null && view.isAttachedToWindow()) {
            ((WindowInsetsCompat)object).setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            ((WindowInsetsCompat)object).copyRootViewBounds(view.getRootView());
        }
        return object;
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    void copyRootViewBounds(View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WindowInsetsCompat)) {
            return false;
        }
        object = (WindowInsetsCompat)object;
        return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat)object).mImpl);
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    public Insets getInsets(int n) {
        return this.mImpl.getInsets(n);
    }

    public Insets getInsetsIgnoringVisibility(int n) {
        return this.mImpl.getInsetsIgnoringVisibility(n);
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        boolean bl = !this.getInsets(Type.all()).equals(Insets.NONE) || !this.getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(Insets.NONE) || this.getDisplayCutout() != null;
        return bl;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return this.mImpl.getStableInsets().equals(Insets.NONE) ^ true;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets().equals(Insets.NONE) ^ true;
    }

    public int hashCode() {
        int n = this.mImpl == null ? 0 : this.mImpl.hashCode();
        return n;
    }

    public WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
        return this.mImpl.inset(n, n2, n3, n4);
    }

    public WindowInsetsCompat inset(Insets insets) {
        return this.inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int n) {
        return this.mImpl.isVisible(n);
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int n, int n2, int n3, int n4) {
        return new Builder(this).setSystemWindowInsets(Insets.of(n, n2, n3, n4)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    void setOverriddenInsets(Insets[] insetsArray) {
        this.mImpl.setOverriddenInsets(insetsArray);
    }

    void setRootViewData(Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    void setStableInsets(Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    public WindowInsets toWindowInsets() {
        WindowInsets windowInsets = this.mImpl instanceof Impl20 ? ((Impl20)this.mImpl).mPlatformInsets : null;
        return windowInsets;
    }

    static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        static {
            try {
                sViewAttachInfoField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField.setAccessible(true);
                Class<?> clazz = Class.forName("android.view.View$AttachInfo");
                sStableInsets = clazz.getDeclaredField("mStableInsets");
                sStableInsets.setAccessible(true);
                sContentInsets = clazz.getDeclaredField("mContentInsets");
                sContentInsets.setAccessible(true);
                sReflectionSucceeded = true;
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                Log.w((String)WindowInsetsCompat.TAG, (String)("Failed to get visible insets from AttachInfo " + reflectiveOperationException.getMessage()), (Throwable)reflectiveOperationException);
            }
        }

        private Api21ReflectionHolder() {
        }

        public static WindowInsetsCompat getRootWindowInsets(View view) {
            if (sReflectionSucceeded && view.isAttachedToWindow()) {
                block5: {
                    Object object = view.getRootView();
                    Object object2 = sViewAttachInfoField.get(object);
                    if (object2 == null) break block5;
                    object = (Rect)sStableInsets.get(object2);
                    object2 = (Rect)sContentInsets.get(object2);
                    if (object == null || object2 == null) break block5;
                    try {
                        Builder builder = new Builder();
                        object = builder.setStableInsets(Insets.of((Rect)object)).setSystemWindowInsets(Insets.of((Rect)object2)).build();
                        ((WindowInsetsCompat)object).setRootWindowInsets((WindowInsetsCompat)object);
                        ((WindowInsetsCompat)object).copyRootViewBounds(view.getRootView());
                        return object;
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        Log.w((String)WindowInsetsCompat.TAG, (String)("Failed to get insets from AttachInfo. " + illegalAccessException.getMessage()), (Throwable)illegalAccessException);
                    }
                }
                return null;
            }
            return null;
        }
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            this.mImpl = Build.VERSION.SDK_INT >= 30 ? new BuilderImpl30() : (Build.VERSION.SDK_INT >= 29 ? new BuilderImpl29() : new BuilderImpl20());
        }

        public Builder(WindowInsetsCompat windowInsetsCompat) {
            this.mImpl = Build.VERSION.SDK_INT >= 30 ? new BuilderImpl30(windowInsetsCompat) : (Build.VERSION.SDK_INT >= 29 ? new BuilderImpl29(windowInsetsCompat) : new BuilderImpl20(windowInsetsCompat));
        }

        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        public Builder setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.setDisplayCutout(displayCutoutCompat);
            return this;
        }

        public Builder setInsets(int n, Insets insets) {
            this.mImpl.setInsets(n, insets);
            return this;
        }

        public Builder setInsetsIgnoringVisibility(int n, Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(n, insets);
            return this;
        }

        @Deprecated
        public Builder setMandatorySystemGestureInsets(Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setStableInsets(Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setSystemGestureInsets(Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setSystemWindowInsets(Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @Deprecated
        public Builder setTappableElementInsets(Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        public Builder setVisible(int n, boolean bl) {
            this.mImpl.setVisible(n, bl);
            return this;
        }
    }

    private static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        BuilderImpl() {
            WindowInsetsCompat windowInsetsCompat = null;
            this(new WindowInsetsCompat(null));
        }

        BuilderImpl(WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }

        protected final void applyInsetTypes() {
            if (this.mInsetsTypeMask != null) {
                Insets insets;
                Insets insets2 = this.mInsetsTypeMask[Type.indexOf(1)];
                Insets insets3 = insets = this.mInsetsTypeMask[Type.indexOf(2)];
                if (insets == null) {
                    insets3 = this.mInsets.getInsets(2);
                }
                insets = insets2;
                if (insets2 == null) {
                    insets = this.mInsets.getInsets(1);
                }
                this.setSystemWindowInsets(Insets.max(insets, insets3));
                insets3 = this.mInsetsTypeMask[Type.indexOf(16)];
                if (insets3 != null) {
                    this.setSystemGestureInsets(insets3);
                }
                if ((insets3 = this.mInsetsTypeMask[Type.indexOf(32)]) != null) {
                    this.setMandatorySystemGestureInsets(insets3);
                }
                if ((insets3 = this.mInsetsTypeMask[Type.indexOf(64)]) != null) {
                    this.setTappableElementInsets(insets3);
                }
            }
        }

        WindowInsetsCompat build() {
            this.applyInsetTypes();
            return this.mInsets;
        }

        void setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
        }

        void setInsets(int n, Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[9];
            }
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) == 0) continue;
                this.mInsetsTypeMask[Type.indexOf((int)i)] = insets;
            }
        }

        void setInsetsIgnoringVisibility(int n, Insets insets) {
            if (n != 8) {
                return;
            }
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }

        void setMandatorySystemGestureInsets(Insets insets) {
        }

        void setStableInsets(Insets insets) {
        }

        void setSystemGestureInsets(Insets insets) {
        }

        void setSystemWindowInsets(Insets insets) {
        }

        void setTappableElementInsets(Insets insets) {
        }

        void setVisible(int n, boolean bl) {
        }
    }

    private static class BuilderImpl20
    extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor;
        private static boolean sConstructorFetched;
        private static Field sConsumedField;
        private static boolean sConsumedFieldFetched;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        static {
            sConsumedFieldFetched = false;
            sConstructorFetched = false;
        }

        BuilderImpl20() {
            this.mPlatformInsets = BuilderImpl20.createWindowInsetsInstance();
        }

        BuilderImpl20(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }

        private static WindowInsets createWindowInsetsInstance() {
            WindowInsets windowInsets;
            block13: {
                if (!sConsumedFieldFetched) {
                    try {
                        sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                    }
                    catch (ReflectiveOperationException reflectiveOperationException) {
                        Log.i((String)WindowInsetsCompat.TAG, (String)"Could not retrieve WindowInsets.CONSUMED field", (Throwable)reflectiveOperationException);
                    }
                    sConsumedFieldFetched = true;
                }
                if (sConsumedField != null) {
                    windowInsets = (WindowInsets)sConsumedField.get(null);
                    if (windowInsets == null) break block13;
                    try {
                        windowInsets = new WindowInsets(windowInsets);
                        return windowInsets;
                    }
                    catch (ReflectiveOperationException reflectiveOperationException) {
                        Log.i((String)WindowInsetsCompat.TAG, (String)"Could not get value from WindowInsets.CONSUMED field", (Throwable)reflectiveOperationException);
                    }
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(Rect.class);
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    Log.i((String)WindowInsetsCompat.TAG, (String)"Could not retrieve WindowInsets(Rect) constructor", (Throwable)reflectiveOperationException);
                }
                sConstructorFetched = true;
            }
            if (sConstructor != null) {
                try {
                    Constructor<WindowInsets> constructor = sConstructor;
                    windowInsets = new Rect();
                    windowInsets = constructor.newInstance(windowInsets);
                    return windowInsets;
                }
                catch (ReflectiveOperationException reflectiveOperationException) {
                    Log.i((String)WindowInsetsCompat.TAG, (String)"Could not invoke WindowInsets(Rect) constructor", (Throwable)reflectiveOperationException);
                }
            }
            return null;
        }

        @Override
        WindowInsetsCompat build() {
            this.applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        @Override
        void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }

        @Override
        void setSystemWindowInsets(Insets insets) {
            if (this.mPlatformInsets != null) {
                this.mPlatformInsets = this.mPlatformInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }
    }

    private static class BuilderImpl29
    extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        BuilderImpl29() {
            this.mPlatBuilder = new WindowInsets.Builder();
        }

        BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            windowInsetsCompat = windowInsetsCompat.toWindowInsets();
            windowInsetsCompat = windowInsetsCompat != null ? new WindowInsets.Builder((WindowInsets)windowInsetsCompat) : new WindowInsets.Builder();
            this.mPlatBuilder = windowInsetsCompat;
        }

        @Override
        WindowInsetsCompat build() {
            this.applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        @Override
        void setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
            WindowInsets.Builder builder = this.mPlatBuilder;
            displayCutoutCompat = displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null;
            builder.setDisplayCutout((DisplayCutout)displayCutoutCompat);
        }

        @Override
        void setMandatorySystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override
        void setStableInsets(Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override
        void setSystemGestureInsets(Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override
        void setSystemWindowInsets(Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override
        void setTappableElementInsets(Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }
    }

    private static class BuilderImpl30
    extends BuilderImpl29 {
        BuilderImpl30() {
        }

        BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }

        @Override
        void setInsets(int n, Insets insets) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(n), insets.toPlatformInsets());
        }

        @Override
        void setInsetsIgnoringVisibility(int n, Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(n), insets.toPlatformInsets());
        }

        @Override
        void setVisible(int n, boolean bl) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(n), bl);
        }
    }

    private static class Impl {
        static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        final WindowInsetsCompat mHost;

        Impl(WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        void copyRootViewBounds(View view) {
        }

        void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (!(object instanceof Impl)) {
                return false;
            }
            object = (Impl)object;
            if (!(this.isRound() == ((Impl)object).isRound() && this.isConsumed() == ((Impl)object).isConsumed() && ObjectsCompat.equals(this.getSystemWindowInsets(), ((Impl)object).getSystemWindowInsets()) && ObjectsCompat.equals(this.getStableInsets(), ((Impl)object).getStableInsets()) && ObjectsCompat.equals(this.getDisplayCutout(), ((Impl)object).getDisplayCutout()))) {
                bl = false;
            }
            return bl;
        }

        DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        Insets getInsets(int n) {
            return Insets.NONE;
        }

        Insets getInsetsIgnoringVisibility(int n) {
            if ((n & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        Insets getMandatorySystemGestureInsets() {
            return this.getSystemWindowInsets();
        }

        Insets getStableInsets() {
            return Insets.NONE;
        }

        Insets getSystemGestureInsets() {
            return this.getSystemWindowInsets();
        }

        Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        Insets getTappableElementInsets() {
            return this.getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.isRound(), this.isConsumed(), this.getSystemWindowInsets(), this.getStableInsets(), this.getDisplayCutout());
        }

        WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
            return CONSUMED;
        }

        boolean isConsumed() {
            return false;
        }

        boolean isRound() {
            return false;
        }

        boolean isVisible(int n) {
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArray) {
        }

        void setRootViewData(Insets insets) {
        }

        void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    private static class Impl20
    extends Impl {
        private static Class<?> sAttachInfoClass;
        private static Field sAttachInfoField;
        private static Method sGetViewRootImplMethod;
        private static Field sVisibleInsetsField;
        private static boolean sVisibleRectReflectionFetched;
        private Insets[] mOverriddenInsets;
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets = null;

        static {
            sVisibleRectReflectionFetched = false;
        }

        Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsets;
        }

        Impl20(WindowInsetsCompat windowInsetsCompat, Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
        }

        private Insets getInsets(int n, boolean bl) {
            Insets insets = Insets.NONE;
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) == 0) continue;
                insets = Insets.max(insets, this.getInsetsForType(i, bl));
            }
            return insets;
        }

        private Insets getRootStableInsets() {
            if (this.mRootWindowInsets != null) {
                return this.mRootWindowInsets.getStableInsets();
            }
            return Insets.NONE;
        }

        private Insets getVisibleInsets(View object) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!sVisibleRectReflectionFetched) {
                    Impl20.loadReflectionField();
                }
                Method method = sGetViewRootImplMethod;
                Object var2_4 = null;
                if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                    block9: {
                        block8: {
                            try {
                                object = sGetViewRootImplMethod.invoke(object, new Object[0]);
                                if (object != null) break block8;
                            }
                            catch (ReflectiveOperationException reflectiveOperationException) {
                                Log.e((String)WindowInsetsCompat.TAG, (String)("Failed to get visible insets. (Reflection error). " + reflectiveOperationException.getMessage()), (Throwable)reflectiveOperationException);
                                return null;
                            }
                            object = new NullPointerException();
                            Log.w((String)WindowInsetsCompat.TAG, (String)"Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", (Throwable)object);
                            return null;
                        }
                        object = sAttachInfoField.get(object);
                        method = (Rect)sVisibleInsetsField.get(object);
                        object = var2_4;
                        if (method == null) break block9;
                        object = Insets.of((Rect)method);
                    }
                    return object;
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                sAttachInfoClass = Class.forName("android.view.View$AttachInfo");
                sVisibleInsetsField = sAttachInfoClass.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            }
            catch (ReflectiveOperationException reflectiveOperationException) {
                Log.e((String)WindowInsetsCompat.TAG, (String)("Failed to get visible insets. (Reflection error). " + reflectiveOperationException.getMessage()), (Throwable)reflectiveOperationException);
            }
            sVisibleRectReflectionFetched = true;
        }

        @Override
        void copyRootViewBounds(View object) {
            Insets insets = this.getVisibleInsets((View)object);
            object = insets;
            if (insets == null) {
                object = Insets.NONE;
            }
            this.setRootViewData((Insets)object);
        }

        @Override
        void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
            windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override
        public boolean equals(Object object) {
            if (!super.equals(object)) {
                return false;
            }
            object = (Impl20)object;
            return Objects.equals(this.mRootViewVisibleInsets, ((Impl20)object).mRootViewVisibleInsets);
        }

        @Override
        public Insets getInsets(int n) {
            return this.getInsets(n, false);
        }

        protected Insets getInsetsForType(int n, boolean bl) {
            Object object = null;
            Insets insets = null;
            switch (n) {
                default: {
                    return Insets.NONE;
                }
                case 128: {
                    object = this.mRootWindowInsets != null ? this.mRootWindowInsets.getDisplayCutout() : this.getDisplayCutout();
                    if (object != null) {
                        return Insets.of(((DisplayCutoutCompat)object).getSafeInsetLeft(), ((DisplayCutoutCompat)object).getSafeInsetTop(), ((DisplayCutoutCompat)object).getSafeInsetRight(), ((DisplayCutoutCompat)object).getSafeInsetBottom());
                    }
                    return Insets.NONE;
                }
                case 64: {
                    return this.getTappableElementInsets();
                }
                case 32: {
                    return this.getMandatorySystemGestureInsets();
                }
                case 16: {
                    return this.getSystemGestureInsets();
                }
                case 8: {
                    object = this.mOverriddenInsets != null ? this.mOverriddenInsets[Type.indexOf(8)] : insets;
                    if (object != null) {
                        return object;
                    }
                    insets = this.getSystemWindowInsets();
                    object = this.getRootStableInsets();
                    if (insets.bottom > ((Insets)object).bottom) {
                        return Insets.of(0, 0, 0, insets.bottom);
                    }
                    if (this.mRootViewVisibleInsets != null && !this.mRootViewVisibleInsets.equals(Insets.NONE) && this.mRootViewVisibleInsets.bottom > ((Insets)object).bottom) {
                        return Insets.of(0, 0, 0, this.mRootViewVisibleInsets.bottom);
                    }
                    return Insets.NONE;
                }
                case 2: {
                    int n2;
                    if (bl) {
                        object = this.getRootStableInsets();
                        insets = this.getStableInsets();
                        return Insets.of(Math.max(((Insets)object).left, insets.left), 0, Math.max(((Insets)object).right, insets.right), Math.max(((Insets)object).bottom, insets.bottom));
                    }
                    insets = this.getSystemWindowInsets();
                    if (this.mRootWindowInsets != null) {
                        object = this.mRootWindowInsets.getStableInsets();
                    }
                    n = n2 = insets.bottom;
                    if (object != null) {
                        n = Math.min(n2, ((Insets)object).bottom);
                    }
                    return Insets.of(insets.left, 0, insets.right, n);
                }
                case 1: 
            }
            if (bl) {
                return Insets.of(0, Math.max(this.getRootStableInsets().top, this.getSystemWindowInsets().top), 0, 0);
            }
            return Insets.of(0, this.getSystemWindowInsets().top, 0, 0);
        }

        @Override
        public Insets getInsetsIgnoringVisibility(int n) {
            return this.getInsets(n, true);
        }

        @Override
        final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override
        WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(this.getSystemWindowInsets(), n, n2, n3, n4));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(this.getStableInsets(), n, n2, n3, n4));
            return builder.build();
        }

        @Override
        boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        protected boolean isTypeVisible(int n) {
            switch (n) {
                default: {
                    return true;
                }
                case 4: {
                    return false;
                }
                case 1: 
                case 2: 
                case 8: 
                case 128: 
            }
            return true ^ this.getInsetsForType(n, false).equals(Insets.NONE);
        }

        @Override
        boolean isVisible(int n) {
            for (int i = 1; i <= 256; i <<= 1) {
                if ((n & i) == 0 || this.isTypeVisible(i)) continue;
                return false;
            }
            return true;
        }

        @Override
        public void setOverriddenInsets(Insets[] insetsArray) {
            this.mOverriddenInsets = insetsArray;
        }

        @Override
        void setRootViewData(Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        @Override
        void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }
    }

    private static class Impl21
    extends Impl20 {
        private Insets mStableInsets = null;

        Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl21(WindowInsetsCompat windowInsetsCompat, Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.mStableInsets = impl21.mStableInsets;
        }

        @Override
        WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override
        WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override
        final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override
        boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override
        public void setStableInsets(Insets insets) {
            this.mStableInsets = insets;
        }
    }

    private static class Impl28
    extends Impl21 {
        Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl28(WindowInsetsCompat windowInsetsCompat, Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }

        @Override
        WindowInsetsCompat consumeDisplayCutout() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
        }

        @Override
        public boolean equals(Object object) {
            boolean bl = true;
            if (this == object) {
                return true;
            }
            if (!(object instanceof Impl28)) {
                return false;
            }
            object = (Impl28)object;
            if (!Objects.equals(this.mPlatformInsets, ((Impl28)object).mPlatformInsets) || !Objects.equals(this.mRootViewVisibleInsets, ((Impl28)object).mRootViewVisibleInsets)) {
                bl = false;
            }
            return bl;
        }

        @Override
        DisplayCutoutCompat getDisplayCutout() {
            return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
        }

        @Override
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }
    }

    private static class Impl29
    extends Impl28 {
        private Insets mMandatorySystemGestureInsets = null;
        private Insets mSystemGestureInsets = null;
        private Insets mTappableElementInsets = null;

        Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl29(WindowInsetsCompat windowInsetsCompat, Impl29 impl29) {
            super(windowInsetsCompat, impl29);
        }

        @Override
        Insets getMandatorySystemGestureInsets() {
            if (this.mMandatorySystemGestureInsets == null) {
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getMandatorySystemGestureInsets());
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override
        Insets getSystemGestureInsets() {
            if (this.mSystemGestureInsets == null) {
                this.mSystemGestureInsets = Insets.toCompatInsets(this.mPlatformInsets.getSystemGestureInsets());
            }
            return this.mSystemGestureInsets;
        }

        @Override
        Insets getTappableElementInsets() {
            if (this.mTappableElementInsets == null) {
                this.mTappableElementInsets = Insets.toCompatInsets(this.mPlatformInsets.getTappableElementInsets());
            }
            return this.mTappableElementInsets;
        }

        @Override
        WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.inset(n, n2, n3, n4));
        }

        @Override
        public void setStableInsets(Insets insets) {
        }
    }

    private static class Impl30
    extends Impl29 {
        static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

        Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        Impl30(WindowInsetsCompat windowInsetsCompat, Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }

        @Override
        final void copyRootViewBounds(View view) {
        }

        @Override
        public Insets getInsets(int n) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(n)));
        }

        @Override
        public Insets getInsetsIgnoringVisibility(int n) {
            return Insets.toCompatInsets(this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(n)));
        }

        @Override
        public boolean isVisible(int n) {
            return this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(n));
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        private Type() {
        }

        static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        static int indexOf(int n) {
            switch (n) {
                default: {
                    throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + n);
                }
                case 256: {
                    return 8;
                }
                case 128: {
                    return 7;
                }
                case 64: {
                    return 6;
                }
                case 32: {
                    return 5;
                }
                case 16: {
                    return 4;
                }
                case 8: {
                    return 3;
                }
                case 4: {
                    return 2;
                }
                case 2: {
                    return 1;
                }
                case 1: 
            }
            return 0;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }

        @Retention(value=RetentionPolicy.SOURCE)
        public static @interface InsetsType {
        }
    }

    private static final class TypeImpl30 {
        private TypeImpl30() {
        }

        static int toPlatformType(int n) {
            int n2 = 0;
            for (int i = 1; i <= 256; i <<= 1) {
                int n3 = n2;
                if ((n & i) != 0) {
                    switch (i) {
                        default: {
                            n3 = n2;
                            break;
                        }
                        case 128: {
                            n3 = n2 | WindowInsets.Type.displayCutout();
                            break;
                        }
                        case 64: {
                            n3 = n2 | WindowInsets.Type.tappableElement();
                            break;
                        }
                        case 32: {
                            n3 = n2 | WindowInsets.Type.mandatorySystemGestures();
                            break;
                        }
                        case 16: {
                            n3 = n2 | WindowInsets.Type.systemGestures();
                            break;
                        }
                        case 8: {
                            n3 = n2 | WindowInsets.Type.ime();
                            break;
                        }
                        case 4: {
                            n3 = n2 | WindowInsets.Type.captionBar();
                            break;
                        }
                        case 2: {
                            n3 = n2 | WindowInsets.Type.navigationBars();
                            break;
                        }
                        case 1: {
                            n3 = n2 | WindowInsets.Type.statusBars();
                        }
                    }
                }
                n2 = n3;
            }
            return n2;
        }
    }
}

