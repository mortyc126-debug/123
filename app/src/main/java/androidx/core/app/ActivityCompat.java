/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.SharedElementCallback
 *  android.app.SharedElementCallback$OnSharedElementsReadyListener
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.LocusId
 *  android.content.pm.PackageManager
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.Display
 *  android.view.DragEvent
 *  android.view.View
 */
package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0;
import androidx.core.app.ActivityRecreator;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActivityCompat
extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    protected ActivityCompat() {
    }

    public static void finishAffinity(Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(Activity activity) {
        Api21Impl.finishAfterTransition(activity);
    }

    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static Uri getReferrer(Activity activity) {
        return Api22Impl.getReferrer(activity);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(Activity activity) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.isLaunchedFromBubble(activity);
        }
        int n = Build.VERSION.SDK_INT;
        boolean bl = true;
        boolean bl2 = true;
        if (n == 30) {
            if (Api30Impl.getDisplay((ContextWrapper)activity) == null || Api30Impl.getDisplay((ContextWrapper)activity).getDisplayId() == 0) {
                bl2 = false;
            }
            return bl2;
        }
        if (Build.VERSION.SDK_INT == 29) {
            bl2 = activity.getWindowManager().getDefaultDisplay() != null && activity.getWindowManager().getDefaultDisplay().getDisplayId() != 0 ? bl : false;
            return bl2;
        }
        return false;
    }

    static /* synthetic */ void lambda$recreate$0(Activity activity) {
        if (!activity.isFinishing() && !ActivityRecreator.recreate(activity)) {
            activity.recreate();
        }
    }

    public static void postponeEnterTransition(Activity activity) {
        Api21Impl.postponeEnterTransition(activity);
    }

    public static void recreate(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post((Runnable)new ActivityCompat$$ExternalSyntheticLambda0(activity));
        }
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    public static void requestPermissions(Activity activity, String[] stringArray, int n) {
        int n2;
        if (sDelegate != null && sDelegate.requestPermissions(activity, stringArray, n)) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (n2 = 0; n2 < stringArray.length; ++n2) {
            if (!TextUtils.isEmpty((CharSequence)stringArray[n2])) {
                if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals((CharSequence)stringArray[n2], (CharSequence)"android.permission.POST_NOTIFICATIONS")) continue;
                hashSet.add(n2);
                continue;
            }
            throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(stringArray) + " must not contain null or empty values");
        }
        n2 = hashSet.size();
        String[] stringArray2 = n2 > 0 ? new String[stringArray.length - n2] : stringArray;
        if (n2 > 0) {
            if (n2 == stringArray.length) {
                return;
            }
            int n3 = 0;
            for (int i = 0; i < stringArray.length; ++i) {
                n2 = n3;
                if (!hashSet.contains(i)) {
                    stringArray2[n3] = stringArray[i];
                    n2 = n3 + 1;
                }
                n3 = n2;
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator)activity).validateRequestPermissionsRequestCode(n);
        }
        Api23Impl.requestPermissions(activity, stringArray, n);
    }

    public static <T extends View> T requireViewById(Activity activity, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T)((View)Api28Impl.requireViewById(activity, n));
        }
        if ((activity = activity.findViewById(n)) != null) {
            return (T)activity;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback object) {
        object = object != null ? new SharedElementCallback21Impl((SharedElementCallback)object) : null;
        Api21Impl.setEnterSharedElementCallback(activity, (android.app.SharedElementCallback)object);
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback object) {
        object = object != null ? new SharedElementCallback21Impl((SharedElementCallback)object) : null;
        Api21Impl.setExitSharedElementCallback(activity, (android.app.SharedElementCallback)object);
    }

    public static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setLocusContext(activity, locusIdCompat, bundle);
        }
    }

    public static void setPermissionCompatDelegate(PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String string2) {
        if (Build.VERSION.SDK_INT < 33 && TextUtils.equals((CharSequence)"android.permission.POST_NOTIFICATIONS", (CharSequence)string2)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 32) {
            return Api32Impl.shouldShowRequestPermissionRationale(activity, string2);
        }
        if (Build.VERSION.SDK_INT == 31) {
            return Api31Impl.shouldShowRequestPermissionRationale(activity, string2);
        }
        return Api23Impl.shouldShowRequestPermissionRationale(activity, string2);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int n, Bundle bundle) {
        activity.startActivityForResult(intent, n, bundle);
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int n, Intent intent, int n2, int n3, int n4, Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }

    public static void startPostponedEnterTransition(Activity activity) {
        Api21Impl.startPostponedEnterTransition(activity);
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void finishAfterTransition(Activity activity) {
            activity.finishAfterTransition();
        }

        static void postponeEnterTransition(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void setEnterSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void setExitSharedElementCallback(Activity activity, android.app.SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void startPostponedEnterTransition(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class Api22Impl {
        private Api22Impl() {
        }

        static Uri getReferrer(Activity activity) {
            return activity.getReferrer();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static void onSharedElementsReady(Object object) {
            ((SharedElementCallback.OnSharedElementsReadyListener)object).onSharedElementsReady();
        }

        static void requestPermissions(Activity activity, String[] stringArray, int n) {
            activity.requestPermissions(stringArray, n);
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String string2) {
            return activity.shouldShowRequestPermissionRationale(string2);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Activity activity, int n) {
            return (T)activity.requireViewById(n);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Display getDisplay(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
            locusIdCompat = locusIdCompat == null ? null : locusIdCompat.toLocusId();
            activity.setLocusContext((LocusId)locusIdCompat, bundle);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean isLaunchedFromBubble(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String string2) {
            try {
                PackageManager packageManager = activity.getApplication().getPackageManager();
                boolean bl = (Boolean)PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke((Object)packageManager, string2);
                return bl;
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
            return activity.shouldShowRequestPermissionRationale(string2);
        }
    }

    static class Api32Impl {
        private Api32Impl() {
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String string2) {
            return activity.shouldShowRequestPermissionRationale(string2);
        }
    }

    public static interface OnRequestPermissionsResultCallback {
        public void onRequestPermissionsResult(int var1, String[] var2, int[] var3);
    }

    public static interface PermissionCompatDelegate {
        public boolean onActivityResult(Activity var1, int var2, int var3, Intent var4);

        public boolean requestPermissions(Activity var1, String[] var2, int var3);
    }

    public static interface RequestPermissionsRequestCodeValidator {
        public void validateRequestPermissionsRequestCode(int var1);
    }

    static class SharedElementCallback21Impl
    extends android.app.SharedElementCallback {
        private final SharedElementCallback mCallback;

        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.mCallback = sharedElementCallback;
        }

        static /* synthetic */ void lambda$onSharedElementsArrived$0(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            Api23Impl.onSharedElementsReady(onSharedElementsReadyListener);
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.mCallback.onCreateSnapshotView(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map2) {
            this.mCallback.onMapSharedElements(list, map2);
        }

        public void onRejectSharedElements(List<View> list) {
            this.mCallback.onRejectSharedElements(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementEnd(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.mCallback.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.mCallback.onSharedElementsArrived(list, list2, new ActivityCompat$SharedElementCallback21Impl$$ExternalSyntheticLambda0(onSharedElementsReadyListener));
        }
    }
}

