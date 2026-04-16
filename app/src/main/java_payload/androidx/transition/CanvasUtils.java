/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 */
package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils {
    private static Method sInorderBarrierMethod;
    private static boolean sOrderMethodsFetched;
    private static Method sReorderBarrierMethod;

    private CanvasUtils() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void enableZ(Canvas canvas, boolean bl) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (bl) {
                Api29Impl.enableZ(canvas);
                return;
            }
            Api29Impl.disableZ(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT == 28) throw new IllegalStateException("This method doesn't work on Pie!");
        if (!sOrderMethodsFetched) {
            try {
                sReorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                sReorderBarrierMethod.setAccessible(true);
                sInorderBarrierMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                sInorderBarrierMethod.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            sOrderMethodsFetched = true;
        }
        if (bl) {
            try {
                if (sReorderBarrierMethod != null) {
                    sReorderBarrierMethod.invoke((Object)canvas, new Object[0]);
                }
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException(invocationTargetException.getCause());
            }
            catch (IllegalAccessException illegalAccessException) {
                return;
            }
        }
        if (bl) return;
        if (sInorderBarrierMethod == null) return;
        sInorderBarrierMethod.invoke((Object)canvas, new Object[0]);
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void disableZ(Canvas canvas) {
            canvas.disableZ();
        }

        static void enableZ(Canvas canvas) {
            canvas.enableZ();
        }
    }
}

