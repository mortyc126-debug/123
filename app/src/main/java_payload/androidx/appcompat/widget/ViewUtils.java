/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE;
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        boolean bl = Build.VERSION.SDK_INT >= 27;
        SDK_LEVEL_SUPPORTS_AUTOSIZE = bl;
        try {
            sComputeFitSystemWindowsMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            if (!sComputeFitSystemWindowsMethod.isAccessible()) {
                sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.d((String)TAG, (String)"Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        if (sComputeFitSystemWindowsMethod != null) {
            try {
                sComputeFitSystemWindowsMethod.invoke((Object)view, rect, rect2);
            }
            catch (Exception exception) {
                Log.d((String)TAG, (String)"Could not invoke computeFitSystemWindows", (Throwable)exception);
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        int n = ViewCompat.getLayoutDirection(view);
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        return bl;
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke((Object)view, new Object[0]);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.d((String)TAG, (String)"Could not invoke makeOptionalFitsSystemWindows", (Throwable)illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.d((String)TAG, (String)"Could not invoke makeOptionalFitsSystemWindows", (Throwable)invocationTargetException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.d((String)TAG, (String)"Could not find method makeOptionalFitsSystemWindows. Oh well...");
        }
    }
}

