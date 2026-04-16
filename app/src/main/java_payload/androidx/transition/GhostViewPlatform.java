/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.GhostView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GhostViewPlatform
implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    private GhostViewPlatform(View view) {
        this.mGhostView = view;
    }

    static GhostView addGhost(View object, ViewGroup viewGroup, Matrix matrix) {
        GhostViewPlatform.fetchAddGhostMethod();
        if (sAddGhostMethod != null) {
            try {
                object = new GhostViewPlatform((View)sAddGhostMethod.invoke(null, object, viewGroup, matrix));
                return object;
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException(invocationTargetException.getCause());
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
        return null;
    }

    private static void fetchAddGhostMethod() {
        if (!sAddGhostMethodFetched) {
            try {
                GhostViewPlatform.fetchGhostViewClass();
                sAddGhostMethod = sGhostViewClass.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
                sAddGhostMethod.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Failed to retrieve addGhost method", (Throwable)noSuchMethodException);
            }
            sAddGhostMethodFetched = true;
        }
    }

    private static void fetchGhostViewClass() {
        if (!sGhostViewClassFetched) {
            try {
                sGhostViewClass = Class.forName("android.view.GhostView");
            }
            catch (ClassNotFoundException classNotFoundException) {
                Log.i((String)TAG, (String)"Failed to retrieve GhostView class", (Throwable)classNotFoundException);
            }
            sGhostViewClassFetched = true;
        }
    }

    private static void fetchRemoveGhostMethod() {
        if (!sRemoveGhostMethodFetched) {
            try {
                GhostViewPlatform.fetchGhostViewClass();
                sRemoveGhostMethod = sGhostViewClass.getDeclaredMethod("removeGhost", View.class);
                sRemoveGhostMethod.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.i((String)TAG, (String)"Failed to retrieve removeGhost method", (Throwable)noSuchMethodException);
            }
            sRemoveGhostMethodFetched = true;
        }
    }

    static void removeGhost(View view) {
        GhostViewPlatform.fetchRemoveGhostMethod();
        if (sRemoveGhostMethod != null) {
            try {
                sRemoveGhostMethod.invoke(null, view);
            }
            catch (InvocationTargetException invocationTargetException) {
                throw new RuntimeException(invocationTargetException.getCause());
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
        }
    }

    @Override
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    @Override
    public void setVisibility(int n) {
        this.mGhostView.setVisibility(n);
    }
}

