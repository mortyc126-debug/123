/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 */
package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET = new int[]{0x10100A0};
    private static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(Drawable drawable2) {
        return true;
    }

    static void fixDrawable(Drawable drawable2) {
        String string2 = drawable2.getClass().getName();
        if (Build.VERSION.SDK_INT >= 29 && Build.VERSION.SDK_INT < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(string2)) {
            DrawableUtils.forceDrawableStateChange(drawable2);
        }
    }

    private static void forceDrawableStateChange(Drawable drawable2) {
        int[] nArray = drawable2.getState();
        if (nArray != null && nArray.length != 0) {
            drawable2.setState(EMPTY_STATE_SET);
        } else {
            drawable2.setState(CHECKED_STATE_SET);
        }
        drawable2.setState(nArray);
    }

    public static Rect getOpticalBounds(Drawable drawable2) {
        if (Build.VERSION.SDK_INT >= 29) {
            drawable2 = Api29Impl.getOpticalInsets(drawable2);
            return new Rect(drawable2.left, drawable2.top, drawable2.right, drawable2.bottom);
        }
        return Api18Impl.getOpticalInsets(DrawableCompat.unwrap(drawable2));
    }

    public static PorterDuff.Mode parseTintMode(int n, PorterDuff.Mode mode) {
        switch (n) {
            default: {
                return mode;
            }
            case 16: {
                return PorterDuff.Mode.ADD;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 3: 
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    static class Api18Impl {
        private static final Field sBottom;
        private static final Method sGetOpticalInsets;
        private static final Field sLeft;
        private static final boolean sReflectionSuccessful;
        private static final Field sRight;
        private static final Field sTop;

        static {
            Method method = null;
            Method method2 = null;
            Method method3 = null;
            Field field = null;
            Field field2 = null;
            Field field3 = null;
            Field field4 = null;
            Field field5 = null;
            Field field6 = null;
            Field field7 = null;
            Field field8 = null;
            Field field9 = null;
            Field field10 = null;
            Field field11 = null;
            boolean bl = false;
            boolean bl2 = false;
            Method method4 = method3;
            Field field12 = field3;
            Field field13 = field6;
            Field field14 = field9;
            Method method5 = method;
            Field field15 = field;
            Field field16 = field4;
            Field field17 = field7;
            Method method6 = method2;
            Field field18 = field2;
            Field field19 = field5;
            Field field20 = field8;
            Class<?> clazz = Class.forName("android.graphics.Insets");
            method4 = method3;
            field12 = field3;
            field13 = field6;
            field14 = field9;
            method5 = method;
            field15 = field;
            field16 = field4;
            field17 = field7;
            method6 = method2;
            field18 = field2;
            field19 = field5;
            field20 = field8;
            method4 = method2 = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
            field12 = field3;
            field13 = field6;
            field14 = field9;
            method5 = method2;
            field15 = field;
            field16 = field4;
            field17 = field7;
            method6 = method2;
            field18 = field2;
            field19 = field5;
            field20 = field8;
            field3 = clazz.getField("left");
            method4 = method2;
            field12 = field3;
            field13 = field6;
            field14 = field9;
            method5 = method2;
            field15 = field3;
            field16 = field4;
            field17 = field7;
            method6 = method2;
            field18 = field3;
            field19 = field5;
            field20 = field8;
            field5 = clazz.getField("top");
            method4 = method2;
            field12 = field3;
            field13 = field5;
            field14 = field9;
            method5 = method2;
            field15 = field3;
            field16 = field5;
            field17 = field7;
            method6 = method2;
            field18 = field3;
            field19 = field5;
            field20 = field8;
            field9 = clazz.getField("right");
            method4 = method2;
            field12 = field3;
            field13 = field5;
            field14 = field9;
            method5 = method2;
            field15 = field3;
            field16 = field5;
            field17 = field9;
            method6 = method2;
            field18 = field3;
            field19 = field5;
            field20 = field9;
            try {
                field17 = field8 = clazz.getField("bottom");
                bl = true;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                method2 = method4;
                field3 = field12;
                field5 = field13;
                field9 = field14;
                field17 = field10;
            }
            catch (ClassNotFoundException classNotFoundException) {
                method2 = method5;
                field3 = field15;
                field5 = field16;
                field9 = field17;
                field17 = field11;
                bl = bl2;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                bl = bl2;
                field17 = field11;
                field9 = field20;
                field5 = field19;
                field3 = field18;
                method2 = method6;
            }
            if (bl) {
                sGetOpticalInsets = method2;
                sLeft = field3;
                sTop = field5;
                sRight = field9;
                sBottom = field17;
                sReflectionSuccessful = true;
            } else {
                sGetOpticalInsets = null;
                sLeft = null;
                sTop = null;
                sRight = null;
                sBottom = null;
                sReflectionSuccessful = false;
            }
        }

        private Api18Impl() {
        }

        static Rect getOpticalInsets(Drawable object) {
            block5: {
                if (Build.VERSION.SDK_INT < 29 && sReflectionSuccessful) {
                    object = sGetOpticalInsets.invoke(object, new Object[0]);
                    if (object == null) break block5;
                    try {
                        object = new Rect(sLeft.getInt(object), sTop.getInt(object), sRight.getInt(object), sBottom.getInt(object));
                        return object;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        // empty catch block
                    }
                }
            }
            return INSETS_NONE;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets getOpticalInsets(Drawable drawable2) {
            return drawable2.getOpticalInsets();
        }
    }
}

