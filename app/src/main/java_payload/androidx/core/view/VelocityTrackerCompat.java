/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 */
package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.core.view.VelocityTrackerFallback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class VelocityTrackerCompat {
    private static Map<VelocityTracker, VelocityTrackerFallback> sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());

    private VelocityTrackerCompat() {
    }

    public static void addMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT >= 34) {
            return;
        }
        if (motionEvent.getSource() == 0x400000) {
            if (!sFallbackTrackers.containsKey(velocityTracker)) {
                sFallbackTrackers.put(velocityTracker, new VelocityTrackerFallback());
            }
            sFallbackTrackers.get(velocityTracker).addMovement(motionEvent);
        }
    }

    public static void clear(VelocityTracker velocityTracker) {
        velocityTracker.clear();
        VelocityTrackerCompat.removeFallbackForTracker(velocityTracker);
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int n) {
        VelocityTrackerCompat.computeCurrentVelocity(velocityTracker, n, Float.MAX_VALUE);
    }

    public static void computeCurrentVelocity(VelocityTracker object, int n, float f) {
        object.computeCurrentVelocity(n, f);
        object = VelocityTrackerCompat.getFallbackTrackerOrNull((VelocityTracker)object);
        if (object != null) {
            ((VelocityTrackerFallback)object).computeCurrentVelocity(n, f);
        }
    }

    public static float getAxisVelocity(VelocityTracker object, int n) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity((VelocityTracker)object, n);
        }
        if (n == 0) {
            return object.getXVelocity();
        }
        if (n == 1) {
            return object.getYVelocity();
        }
        if ((object = VelocityTrackerCompat.getFallbackTrackerOrNull((VelocityTracker)object)) != null) {
            return ((VelocityTrackerFallback)object).getAxisVelocity(n);
        }
        return 0.0f;
    }

    public static float getAxisVelocity(VelocityTracker velocityTracker, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(velocityTracker, n, n2);
        }
        if (n == 0) {
            return velocityTracker.getXVelocity(n2);
        }
        if (n == 1) {
            return velocityTracker.getYVelocity(n2);
        }
        return 0.0f;
    }

    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker velocityTracker) {
        return sFallbackTrackers.get(velocityTracker);
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int n) {
        return velocityTracker.getXVelocity(n);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int n) {
        return velocityTracker.getYVelocity(n);
    }

    public static boolean isAxisSupported(VelocityTracker velocityTracker, int n) {
        boolean bl;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.isAxisSupported(velocityTracker, n);
        }
        boolean bl2 = bl = true;
        if (n != 26) {
            bl2 = bl;
            if (n != 0) {
                bl2 = n == 1 ? bl : false;
            }
        }
        return bl2;
    }

    public static void recycle(VelocityTracker velocityTracker) {
        velocityTracker.recycle();
        VelocityTrackerCompat.removeFallbackForTracker(velocityTracker);
    }

    private static void removeFallbackForTracker(VelocityTracker velocityTracker) {
        sFallbackTrackers.remove(velocityTracker);
    }

    private static class Api34Impl {
        private Api34Impl() {
        }

        static float getAxisVelocity(VelocityTracker velocityTracker, int n) {
            return velocityTracker.getAxisVelocity(n);
        }

        static float getAxisVelocity(VelocityTracker velocityTracker, int n, int n2) {
            return velocityTracker.getAxisVelocity(n, n2);
        }

        static boolean isAxisSupported(VelocityTracker velocityTracker, int n) {
            return velocityTracker.isAxisSupported(n);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface VelocityTrackableMotionEventAxis {
    }
}

