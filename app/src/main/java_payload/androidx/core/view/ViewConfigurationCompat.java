/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.InputDevice
 *  android.view.ViewConfiguration
 */
package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.core.util.Supplier;
import androidx.core.view.ViewConfigurationCompat$$ExternalSyntheticLambda0;
import androidx.core.view.ViewConfigurationCompat$$ExternalSyntheticLambda1;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ViewConfigurationCompat {
    private static final int NO_FLING_MAX_VELOCITY = Integer.MIN_VALUE;
    private static final int NO_FLING_MIN_VELOCITY = Integer.MAX_VALUE;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    public static /* synthetic */ int $r8$lambda$IGsMijeK7N_jGk6FsFLBeanWyb4(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public static /* synthetic */ int $r8$lambda$pBZR2VTL3ErbMOjuomplKFHo3xQ(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledMinimumFlingVelocity();
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            }
            catch (Exception exception) {
                Log.i((String)TAG, (String)"Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    private static int getCompatFlingVelocityThreshold(Resources resources, int n, Supplier<Integer> supplier, int n2) {
        switch (n) {
            default: {
                n = resources.getDimensionPixelSize(n);
                if (n >= 0) break;
                n = n2;
                break;
            }
            case 0: {
                return n2;
            }
            case -1: {
                return supplier.get();
            }
        }
        return n;
    }

    private static float getLegacyScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 25 && sGetScaledScrollFactorMethod != null) {
            int n;
            try {
                n = (Integer)sGetScaledScrollFactorMethod.invoke((Object)viewConfiguration, new Object[0]);
            }
            catch (Exception exception) {
                Log.i((String)TAG, (String)"Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
            return n;
        }
        viewConfiguration = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, (TypedValue)viewConfiguration, true)) {
            return viewConfiguration.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    private static int getPlatformResId(Resources resources, String string2, String string3) {
        return resources.getIdentifier(string2, string3, "android");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources resources, int n, int n2) {
        if (n == 0x400000 && n2 == 26) {
            return ViewConfigurationCompat.getPlatformResId(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources resources, int n, int n2) {
        if (n == 0x400000 && n2 == 26) {
            return ViewConfigurationCompat.getPlatformResId(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
        }
        return ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getScaledHoverSlop(viewConfiguration);
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int getScaledMaximumFlingVelocity(Context context, ViewConfiguration viewConfiguration, int n, int n2, int n3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, n, n2, n3);
        }
        if (!ViewConfigurationCompat.isInputDeviceInfoValid(n, n2, n3)) {
            return Integer.MIN_VALUE;
        }
        context = context.getResources();
        n = ViewConfigurationCompat.getPreApi34MaximumFlingVelocityResId((Resources)context, n3, n2);
        Objects.requireNonNull(viewConfiguration);
        return ViewConfigurationCompat.getCompatFlingVelocityThreshold((Resources)context, n, new ViewConfigurationCompat$$ExternalSyntheticLambda1(viewConfiguration), Integer.MIN_VALUE);
    }

    public static int getScaledMinimumFlingVelocity(Context context, ViewConfiguration viewConfiguration, int n, int n2, int n3) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMinimumFlingVelocity(viewConfiguration, n, n2, n3);
        }
        if (!ViewConfigurationCompat.isInputDeviceInfoValid(n, n2, n3)) {
            return Integer.MAX_VALUE;
        }
        context = context.getResources();
        n = ViewConfigurationCompat.getPreApi34MinimumFlingVelocityResId((Resources)context, n3, n2);
        Objects.requireNonNull(viewConfiguration);
        return ViewConfigurationCompat.getCompatFlingVelocityThreshold((Resources)context, n, new ViewConfigurationCompat$$ExternalSyntheticLambda0(viewConfiguration), Integer.MAX_VALUE);
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.getScaledVerticalScrollFactor(viewConfiguration);
        }
        return ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    private static boolean isInputDeviceInfoValid(int n, int n2, int n3) {
        InputDevice inputDevice = InputDevice.getDevice((int)n);
        boolean bl = inputDevice != null && inputDevice.getMotionRange(n2, n3) != null;
        return bl;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(viewConfiguration);
        }
        viewConfiguration = context.getResources();
        int n = ViewConfigurationCompat.getPlatformResId((Resources)viewConfiguration, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        boolean bl = n != 0 && viewConfiguration.getBoolean(n);
        return bl;
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static class Api34Impl {
        private Api34Impl() {
        }

        static int getScaledMaximumFlingVelocity(ViewConfiguration viewConfiguration, int n, int n2, int n3) {
            return viewConfiguration.getScaledMaximumFlingVelocity(n, n2, n3);
        }

        static int getScaledMinimumFlingVelocity(ViewConfiguration viewConfiguration, int n, int n2, int n3) {
            return viewConfiguration.getScaledMinimumFlingVelocity(n, n2, n3);
        }
    }
}

