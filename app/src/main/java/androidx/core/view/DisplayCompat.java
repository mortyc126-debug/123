/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.UiModeManager
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.Display
 *  android.view.Display$Mode
 */
package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.util.Preconditions;

public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    private DisplayCompat() {
    }

    static Point getCurrentDisplaySizeFromWorkarounds(Context context, Display display) {
        Point point = Build.VERSION.SDK_INT < 28 ? DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display) : DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        if (point != null) {
            return point;
        }
        boolean bl = DisplayCompat.isSonyBravia4kTv(context);
        context = null;
        if (bl) {
            if (DisplayCompat.isCurrentModeTheLargestMode(display)) {
                context = new Point(3840, 2160);
            }
            return context;
        }
        return null;
    }

    private static Point getDisplaySize(Context context, Display display) {
        if ((context = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display)) != null) {
            return context;
        }
        context = new Point();
        display.getRealSize((Point)context);
        return context;
    }

    public static ModeCompat getMode(Context context, Display display) {
        return Api23Impl.getMode(context, display);
    }

    public static ModeCompat[] getSupportedModes(Context context, Display display) {
        return Api23Impl.getSupportedModes(context, display);
    }

    private static String getSystemProperty(String string2) {
        try {
            Class<?> clazz = Class.forName("android.os.SystemProperties");
            string2 = (String)clazz.getMethod("get", String.class).invoke(clazz, string2);
            return string2;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static boolean isCurrentModeTheLargestMode(Display display) {
        return Api23Impl.isCurrentModeTheLargestMode(display);
    }

    private static boolean isSonyBravia4kTv(Context context) {
        boolean bl = DisplayCompat.isTv(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
        return bl;
    }

    private static boolean isTv(Context context) {
        boolean bl = (context = (UiModeManager)context.getSystemService("uimode")) != null && context.getCurrentModeType() == 4;
        return bl;
    }

    private static Point parseDisplaySize(String stringArray) throws NumberFormatException {
        if ((stringArray = stringArray.trim().split("x", -1)).length == 2) {
            int n = Integer.parseInt(stringArray[0]);
            int n2 = Integer.parseInt(stringArray[1]);
            if (n > 0 && n2 > 0) {
                return new Point(n, n2);
            }
        }
        throw new NumberFormatException();
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String string2, Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        if (!TextUtils.isEmpty((CharSequence)(string2 = DisplayCompat.getSystemProperty(string2))) && string2 != null) {
            try {
                string2 = DisplayCompat.parseDisplaySize(string2);
                return string2;
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
        }
        return null;
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static ModeCompat getMode(Context object, Display display) {
            Display.Mode mode = display.getMode();
            object = (object = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(object, display)) != null && !Api23Impl.physicalSizeEquals(mode, (Point)object) ? new ModeCompat(mode, (Point)object) : new ModeCompat(mode, true);
            return object;
        }

        public static ModeCompat[] getSupportedModes(Context object, Display display) {
            Display.Mode[] modeArray = display.getSupportedModes();
            ModeCompat[] modeCompatArray = new ModeCompat[modeArray.length];
            Display.Mode mode = display.getMode();
            if ((display = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(object, display)) != null && !Api23Impl.physicalSizeEquals(mode, (Point)display)) {
                for (int i = 0; i < modeArray.length; ++i) {
                    object = Api23Impl.physicalSizeEquals(modeArray[i], mode) ? new ModeCompat(modeArray[i], (Point)display) : new ModeCompat(modeArray[i], false);
                    modeCompatArray[i] = object;
                }
            } else {
                for (int i = 0; i < modeArray.length; ++i) {
                    boolean bl = Api23Impl.physicalSizeEquals(modeArray[i], mode);
                    modeCompatArray[i] = new ModeCompat(modeArray[i], bl);
                }
            }
            return modeCompatArray;
        }

        static boolean isCurrentModeTheLargestMode(Display display2) {
            Display.Mode mode = display2.getMode();
            for (Display.Mode mode2 : display2.getSupportedModes()) {
                if (mode.getPhysicalHeight() >= mode2.getPhysicalHeight() && mode.getPhysicalWidth() >= mode2.getPhysicalWidth()) {
                    continue;
                }
                return false;
            }
            return true;
        }

        static boolean physicalSizeEquals(Display.Mode mode, Point point) {
            boolean bl = mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y || mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x;
            return bl;
        }

        static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
            boolean bl = mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
            return bl;
        }
    }

    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        ModeCompat(Point point) {
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = null;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode mode, Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }

        ModeCompat(Display.Mode mode, boolean bl) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(Api23Impl.getPhysicalWidth(mode), Api23Impl.getPhysicalHeight(mode));
            this.mMode = mode;
            this.mIsNative = bl;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.mIsNative;
        }

        public Display.Mode toMode() {
            return this.mMode;
        }

        static class Api23Impl {
            private Api23Impl() {
            }

            static int getPhysicalHeight(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            static int getPhysicalWidth(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }
    }
}

