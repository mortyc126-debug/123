/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

public final class NavUtils {
    public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
    private static final String TAG = "NavUtils";

    private NavUtils() {
    }

    public static Intent getParentActivityIntent(Activity activity) {
        Object object = activity.getParentActivityIntent();
        if (object != null) {
            return object;
        }
        object = NavUtils.getParentActivityName(activity);
        if (object == null) {
            return null;
        }
        ComponentName componentName = new ComponentName((Context)activity, (String)object);
        try {
            if (NavUtils.getParentActivityName((Context)activity, componentName) == null) {
                activity = Intent.makeMainActivity((ComponentName)componentName);
            } else {
                activity = new Intent();
                activity = activity.setComponent(componentName);
            }
            return activity;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)TAG, (String)("getParentActivityIntent: bad parentActivityName '" + (String)object + "' in manifest"));
            return null;
        }
    }

    public static Intent getParentActivityIntent(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string2 = NavUtils.getParentActivityName(context, componentName);
        if (string2 == null) {
            return null;
        }
        context = NavUtils.getParentActivityName(context, componentName = new ComponentName(componentName.getPackageName(), string2)) == null ? Intent.makeMainActivity((ComponentName)componentName) : new Intent().setComponent(componentName);
        return context;
    }

    public static Intent getParentActivityIntent(Context context, Class<?> object) throws PackageManager.NameNotFoundException {
        if ((object = NavUtils.getParentActivityName(context, new ComponentName(context, object))) == null) {
            return null;
        }
        context = NavUtils.getParentActivityName(context, (ComponentName)(object = new ComponentName(context, (String)object))) == null ? Intent.makeMainActivity((ComponentName)object) : new Intent().setComponent((ComponentName)object);
        return context;
    }

    public static String getParentActivityName(Activity object) {
        try {
            object = NavUtils.getParentActivityName((Context)object, object.getComponentName());
            return object;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            throw new IllegalArgumentException(nameNotFoundException);
        }
    }

    public static String getParentActivityName(Context context, ComponentName object) throws PackageManager.NameNotFoundException {
        Object object2 = context.getPackageManager();
        int n = 0x80 | 0x200;
        n = Build.VERSION.SDK_INT >= 29 ? (n |= 0x100C0000) : (n |= 0xC0000);
        object = object2.getActivityInfo(object, n);
        object2 = object.parentActivityName;
        if (object2 != null) {
            return object2;
        }
        if (object.metaData == null) {
            return null;
        }
        object2 = object.metaData.getString(PARENT_ACTIVITY);
        if (object2 == null) {
            return null;
        }
        object = object2;
        if (((String)object2).charAt(0) == '.') {
            object = context.getPackageName() + (String)object2;
        }
        return object;
    }

    public static void navigateUpFromSameTask(Activity activity) {
        Intent intent = NavUtils.getParentActivityIntent(activity);
        if (intent != null) {
            NavUtils.navigateUpTo(activity, intent);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void navigateUpTo(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }

    public static boolean shouldUpRecreateTask(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}

