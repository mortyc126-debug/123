package com.google.android.material.math;

/* JADX INFO: loaded from: classes3.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float x12, float y12, float x22, float y2) {
        float x = x22 - x12;
        float y = y2 - y12;
        return (float) Math.hypot(x, y);
    }

    public static float lerp(float start, float stop, float amount) {
        return ((1.0f - amount) * start) + (amount * stop);
    }

    public static boolean geq(float a, float b, float epsilon) {
        return a + epsilon >= b;
    }

    public static float distanceToFurthestCorner(float pointX, float pointY, float rectLeft, float rectTop, float rectRight, float rectBottom) {
        return max(dist(pointX, pointY, rectLeft, rectTop), dist(pointX, pointY, rectRight, rectTop), dist(pointX, pointY, rectRight, rectBottom), dist(pointX, pointY, rectLeft, rectBottom));
    }

    private static float max(float a, float b, float c, float d) {
        return (a <= b || a <= c || a <= d) ? (b <= c || b <= d) ? c > d ? c : d : b : a;
    }

    public static float floorMod(float x, int y) {
        int r = (int) (x / y);
        if (Math.signum(x) * y < 0.0f && r * y != x) {
            r--;
        }
        return x - (r * y);
    }

    public static int floorMod(int x, int y) {
        int r = x / y;
        if ((x ^ y) < 0 && r * y != x) {
            r--;
        }
        return x - (r * y);
    }
}
