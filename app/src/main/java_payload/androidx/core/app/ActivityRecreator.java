/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    protected static final Class<?> activityThreadClass;
    private static final Handler mainHandler;
    protected static final Field mainThreadField;
    protected static final Method performStopActivity2ParamsMethod;
    protected static final Method performStopActivity3ParamsMethod;
    protected static final Method requestRelaunchActivityMethod;
    protected static final Field tokenField;

    static {
        mainHandler = new Handler(Looper.getMainLooper());
        activityThreadClass = ActivityRecreator.getActivityThreadClass();
        mainThreadField = ActivityRecreator.getMainThreadField();
        tokenField = ActivityRecreator.getTokenField();
        performStopActivity3ParamsMethod = ActivityRecreator.getPerformStopActivity3Params(activityThreadClass);
        performStopActivity2ParamsMethod = ActivityRecreator.getPerformStopActivity2Params(activityThreadClass);
        requestRelaunchActivityMethod = ActivityRecreator.getRequestRelaunchActivityMethod(activityThreadClass);
    }

    private ActivityRecreator() {
    }

    private static Class<?> getActivityThreadClass() {
        try {
            Class<?> clazz = Class.forName("android.app.ActivityThread");
            return clazz;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Field getMainThreadField() {
        try {
            Field field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
            return field;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method getPerformStopActivity2Params(Class<?> genericDeclaration) {
        if (genericDeclaration == null) {
            return null;
        }
        try {
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            ((Method)genericDeclaration).setAccessible(true);
            return genericDeclaration;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method getPerformStopActivity3Params(Class<?> genericDeclaration) {
        if (genericDeclaration == null) {
            return null;
        }
        try {
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            ((Method)genericDeclaration).setAccessible(true);
            return genericDeclaration;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method getRequestRelaunchActivityMethod(Class<?> genericDeclaration) {
        if (ActivityRecreator.needsRelaunchCall() && genericDeclaration != null) {
            try {
                genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE);
                ((Method)genericDeclaration).setAccessible(true);
                return genericDeclaration;
            }
            catch (Throwable throwable) {
                return null;
            }
        }
        return null;
    }

    private static Field getTokenField() {
        try {
            Field field = Activity.class.getDeclaredField("mToken");
            field.setAccessible(true);
            return field;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        boolean bl = Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
        return bl;
    }

    protected static boolean queueOnStopIfNecessary(Object runnable2, int n, Activity activity) {
        block3: {
            Object object;
            try {
                object = tokenField.get(activity);
                if (object != runnable2) break block3;
            }
            catch (Throwable throwable) {
                Log.e((String)LOG_TAG, (String)"Exception while fetching field values", (Throwable)throwable);
                return false;
            }
            if (activity.hashCode() != n) break block3;
            Object object2 = mainThreadField.get(activity);
            activity = mainHandler;
            runnable2 = new Runnable(){
                final Object val$activityThread;
                final Object val$token;
                {
                    this.val$activityThread = object;
                    this.val$token = object2;
                }

                @Override
                public void run() {
                    block5: {
                        try {
                            if (performStopActivity3ParamsMethod != null) {
                                performStopActivity3ParamsMethod.invoke(this.val$activityThread, this.val$token, false, "AppCompat recreation");
                            } else {
                                performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, false);
                            }
                        }
                        catch (Throwable throwable) {
                            Log.e((String)ActivityRecreator.LOG_TAG, (String)"Exception while invoking performStopActivity", (Throwable)throwable);
                        }
                        catch (RuntimeException runtimeException) {
                            if (runtimeException.getClass() != RuntimeException.class || runtimeException.getMessage() == null || !runtimeException.getMessage().startsWith("Unable to stop")) break block5;
                            throw runtimeException;
                        }
                    }
                }
            };
            activity.postAtFrontOfQueue(runnable2);
            return true;
        }
        return false;
    }

    /*
     * Loose catch block
     */
    static boolean recreate(Activity activity) {
        Object object;
        LifecycleCheckCallbacks lifecycleCheckCallbacks;
        Application application;
        Runnable runnable2;
        block14: {
            Object object2;
            block13: {
                block12: {
                    if (Build.VERSION.SDK_INT >= 28) {
                        activity.recreate();
                        return true;
                    }
                    if (ActivityRecreator.needsRelaunchCall() && requestRelaunchActivityMethod == null) {
                        return false;
                    }
                    if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
                        return false;
                    }
                    runnable2 = tokenField.get(activity);
                    if (runnable2 != null) break block12;
                    return false;
                    {
                        catch (Throwable throwable) {
                            return false;
                        }
                    }
                }
                object2 = mainThreadField.get(activity);
                if (object2 != null) break block13;
                return false;
            }
            application = activity.getApplication();
            lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
            application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)lifecycleCheckCallbacks);
            object = mainHandler;
            Runnable runnable3 = new Runnable(){
                final LifecycleCheckCallbacks val$callbacks;
                final Object val$token;
                {
                    this.val$callbacks = lifecycleCheckCallbacks;
                    this.val$token = object;
                }

                @Override
                public void run() {
                    this.val$callbacks.currentlyRecreatingToken = this.val$token;
                }
            };
            object.post(runnable3);
            if (ActivityRecreator.needsRelaunchCall()) {
                requestRelaunchActivityMethod.invoke(object2, runnable2, null, null, 0, false, null, null, false, false);
                break block14;
            }
            activity.recreate();
        }
        activity = mainHandler;
        object = new Runnable(){
            final Application val$application;
            final LifecycleCheckCallbacks val$callbacks;
            {
                this.val$application = application;
                this.val$callbacks = lifecycleCheckCallbacks;
            }

            @Override
            public void run() {
                this.val$application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.val$callbacks);
            }
        };
        activity.post((Runnable)object);
        return true;
        catch (Throwable throwable) {
            object = mainHandler;
            runnable2 = new /* invalid duplicate definition of identical inner class */;
            object.post(runnable2);
            throw throwable;
        }
    }

    private static final class LifecycleCheckCallbacks
    implements Application.ActivityLifecycleCallbacks {
        Object currentlyRecreatingToken;
        private Activity mActivity;
        private boolean mDestroyed = false;
        private final int mRecreatingHashCode;
        private boolean mStarted = false;
        private boolean mStopQueued = false;

        LifecycleCheckCallbacks(Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = this.mActivity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.mDestroyed && !this.mStopQueued && !this.mStarted && ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                this.mStopQueued = true;
                this.currentlyRecreatingToken = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }
}

