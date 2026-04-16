/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ShortcutInfo
 *  android.content.pm.ShortcutManager
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoChangeListener;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    static {
        sShortcutInfoCompatSaver = null;
        sShortcutInfoChangeListeners = null;
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(Context object, List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> list2 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons((Context)object, list2);
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            Iterator<ShortcutInfoCompat> iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().toShortcutInfo());
            }
            if (!((ShortcutManager)object.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list2);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutAdded(list);
        }
        return true;
    }

    static boolean convertUriIconToBitmapIcon(Context object, ShortcutInfoCompat shortcutInfoCompat) {
        if (shortcutInfoCompat.mIcon == null) {
            return false;
        }
        int n = shortcutInfoCompat.mIcon.mType;
        if (n != 6 && n != 4) {
            return true;
        }
        if ((object = shortcutInfoCompat.mIcon.getUriInputStream((Context)object)) == null) {
            return false;
        }
        if ((object = BitmapFactory.decodeStream((InputStream)object)) == null) {
            return false;
        }
        object = n == 6 ? IconCompat.createWithAdaptiveBitmap((Bitmap)object) : IconCompat.createWithBitmap((Bitmap)object);
        shortcutInfoCompat.mIcon = object;
        return true;
    }

    static void convertUriIconsToBitmapIcons(Context context, List<ShortcutInfoCompat> list) {
        for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList<ShortcutInfoCompat>(list)) {
            if (ShortcutManagerCompat.convertUriIconToBitmapIcon(context, shortcutInfoCompat)) continue;
            list.remove(shortcutInfoCompat);
        }
    }

    public static Intent createShortcutResultIntent(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Intent intent = null;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = ((ShortcutManager)context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        }
        context = intent;
        if (intent == null) {
            context = new Intent();
        }
        return shortcutInfoCompat.addToIntent((Intent)context);
    }

    public static void disableShortcuts(Context object, List<String> list, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).disableShortcuts(list, charSequence);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutRemoved(list);
        }
    }

    public static void enableShortcuts(Context object, List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> list2 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<String> arrayList = new ArrayList<String>(list.size());
            Iterator<ShortcutInfoCompat> iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().mId);
            }
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).enableShortcuts(arrayList);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list2);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutAdded(list);
        }
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context object) {
        if (Build.VERSION.SDK_INT >= 25) {
            Object object2 = ((ShortcutManager)object.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
            ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<ShortcutInfoCompat>(object2.size());
            object2 = object2.iterator();
            while (object2.hasNext()) {
                arrayList.add(new ShortcutInfoCompat.Builder((Context)object, (ShortcutInfo)object2.next()).build());
            }
            return arrayList;
        }
        try {
            object = ShortcutManagerCompat.getShortcutInfoSaverInstance(object).getShortcuts();
            return object;
        }
        catch (Exception exception) {
            return new ArrayList<ShortcutInfoCompat>();
        }
    }

    private static int getIconDimensionInternal(Context context, boolean bl) {
        ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
        int n = activityManager != null && !activityManager.isLowRamDevice() ? 0 : 1;
        n = n != 0 ? 48 : 96;
        n = Math.max(1, n);
        context = context.getResources().getDisplayMetrics();
        float f = bl ? context.xdpi : context.ydpi;
        return (int)((float)n * (f /= 160.0f));
    }

    public static int getIconMaxHeight(Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getIconMaxHeight();
        }
        return ShortcutManagerCompat.getIconDimensionInternal(context, false);
    }

    public static int getIconMaxWidth(Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getIconMaxWidth();
        }
        return ShortcutManagerCompat.getIconDimensionInternal(context, true);
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> object) {
        int n = -1;
        ShortcutInfoCompat shortcutInfoCompat = null;
        Iterator<ShortcutInfoCompat> iterator2 = object.iterator();
        object = shortcutInfoCompat;
        while (iterator2.hasNext()) {
            shortcutInfoCompat = iterator2.next();
            int n2 = n;
            if (shortcutInfoCompat.getRank() > n) {
                object = shortcutInfoCompat.getId();
                n2 = shortcutInfoCompat.getRank();
            }
            n = n2;
        }
        return object;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        if (sShortcutInfoChangeListeners == null) {
            ArrayList<ShortcutInfoChangeListener> arrayList = new ArrayList<ShortcutInfoChangeListener>();
            Object object = context.getPackageManager();
            Object object2 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
            object2.setPackage(context.getPackageName());
            object = object.queryIntentActivities(object2, 128).iterator();
            while (object.hasNext()) {
                object2 = ((ResolveInfo)object.next()).activityInfo;
                if (object2 == null || (object2 = object2.metaData) == null || (object2 = object2.getString(SHORTCUT_LISTENER_META_DATA_KEY)) == null) continue;
                try {
                    arrayList.add((ShortcutInfoChangeListener)Class.forName((String)object2, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context));
                }
                catch (Exception exception) {}
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = arrayList;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver)Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context object, int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            return ShortcutInfoCompat.fromShortcuts(object, ((ShortcutManager)object.getSystemService(ShortcutManager.class)).getShortcuts(n));
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ShortcutManager shortcutManager = (ShortcutManager)object.getSystemService(ShortcutManager.class);
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            if ((n & 1) != 0) {
                arrayList.addAll(shortcutManager.getManifestShortcuts());
            }
            if ((n & 2) != 0) {
                arrayList.addAll(shortcutManager.getDynamicShortcuts());
            }
            if ((n & 4) != 0) {
                arrayList.addAll(shortcutManager.getPinnedShortcuts());
            }
            return ShortcutInfoCompat.fromShortcuts(object, arrayList);
        }
        if ((n & 2) != 0) {
            try {
                object = ShortcutManagerCompat.getShortcutInfoSaverInstance(object).getShortcuts();
                return object;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).isRateLimitingActive();
        }
        boolean bl = ShortcutManagerCompat.getShortcuts(context, 3).size() == ShortcutManagerCompat.getMaxShortcutCountPerActivity(context);
        return bl;
    }

    public static boolean isRequestPinShortcutSupported(Context object) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager)object.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (ContextCompat.checkSelfPermission((Context)object, INSTALL_SHORTCUT_PERMISSION) != 0) {
            return false;
        }
        object = object.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
        while (object.hasNext()) {
            String string2 = ((ResolveInfo)object.next()).activityInfo.permission;
            if (!TextUtils.isEmpty((CharSequence)string2) && !INSTALL_SHORTCUT_PERMISSION.equals(string2)) continue;
            return true;
        }
        return false;
    }

    public static boolean pushDynamicShortcut(Context object, ShortcutInfoCompat shortcutInfoCompat) {
        Object object2;
        Object object3;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(shortcutInfoCompat);
        if (Build.VERSION.SDK_INT <= 32 && shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
            while (object.hasNext()) {
                ((ShortcutInfoChangeListener)object.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            return true;
        }
        int n = ShortcutManagerCompat.getMaxShortcutCountPerActivity((Context)object);
        if (n == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconToBitmapIcon((Context)object, shortcutInfoCompat);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
        } else if (Build.VERSION.SDK_INT >= 25) {
            object3 = (ShortcutManager)object.getSystemService(ShortcutManager.class);
            if (object3.isRateLimitingActive()) {
                return false;
            }
            object2 = object3.getDynamicShortcuts();
            if (object2.size() >= n) {
                object3.removeDynamicShortcuts(Arrays.asList(Api25Impl.getShortcutInfoWithLowestRank((List<ShortcutInfo>)object2)));
            }
            object3.addDynamicShortcuts(Arrays.asList(shortcutInfoCompat.toShortcutInfo()));
        }
        object2 = ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object);
        try {
            object3 = ((ShortcutInfoCompatSaver)object2).getShortcuts();
            if (object3.size() >= n) {
                ((ShortcutInfoCompatSaver)object2).removeShortcuts(Arrays.asList(ShortcutManagerCompat.getShortcutInfoCompatWithLowestRank((List<ShortcutInfoCompat>)object3)));
            }
            ((ShortcutInfoCompatSaver)object2).addShortcuts(Arrays.asList(shortcutInfoCompat));
            object3 = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        }
        catch (Throwable throwable) {
            object2 = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
            while (object2.hasNext()) {
                ((ShortcutInfoChangeListener)object2.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            ShortcutManagerCompat.reportShortcutUsed((Context)object, shortcutInfoCompat.getId());
            throw throwable;
        }
        catch (Exception exception) {
            Iterator<ShortcutInfoChangeListener> iterator2 = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
            while (iterator2.hasNext()) {
                iterator2.next().onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            ShortcutManagerCompat.reportShortcutUsed((Context)object, shortcutInfoCompat.getId());
            return false;
        }
        while (object3.hasNext()) {
            ((ShortcutInfoChangeListener)object3.next()).onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
        }
        ShortcutManagerCompat.reportShortcutUsed((Context)object, shortcutInfoCompat.getId());
        return true;
    }

    public static void removeAllDynamicShortcuts(Context object) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeAllShortcuts();
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(Context object, List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutRemoved(list);
        }
    }

    public static void removeLongLivedShortcuts(Context object, List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            ShortcutManagerCompat.removeDynamicShortcuts((Context)object, list);
            return;
        }
        ((ShortcutManager)object.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(list);
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeShortcuts(list);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutRemoved(list);
        }
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> object, int n) {
        Objects.requireNonNull(object);
        if (Build.VERSION.SDK_INT > 32) {
            return object;
        }
        ArrayList<ShortcutInfoCompat> arrayList = new ArrayList<ShortcutInfoCompat>((Collection<ShortcutInfoCompat>)object);
        Iterator<ShortcutInfoCompat> iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            object = iterator2.next();
            if (!((ShortcutInfoCompat)object).isExcludedFromSurfaces(n)) continue;
            arrayList.remove(object);
        }
        return arrayList;
    }

    public static void reportShortcutUsed(Context object, String string2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(string2);
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager)object.getSystemService(ShortcutManager.class)).reportShortcutUsed(string2);
        }
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutUsageReported(Collections.singletonList(string2));
        }
    }

    public static boolean requestPinShortcut(Context context, ShortcutInfoCompat shortcutInfoCompat, IntentSender intentSender) {
        if (Build.VERSION.SDK_INT <= 32 && shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager)context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (!ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
            return false;
        }
        shortcutInfoCompat = shortcutInfoCompat.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (intentSender == null) {
            context.sendBroadcast((Intent)shortcutInfoCompat);
            return true;
        }
        context.sendOrderedBroadcast((Intent)shortcutInfoCompat, null, new BroadcastReceiver(intentSender){
            final IntentSender val$callback;
            {
                this.val$callback = intentSender;
            }

            public void onReceive(Context context, Intent intent) {
                try {
                    this.val$callback.sendIntent(context, 0, null, null, null);
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    // empty catch block
                }
            }
        }, null, -1, null, null);
        return true;
    }

    public static boolean setDynamicShortcuts(Context object, List<ShortcutInfoCompat> list) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(list);
        List<ShortcutInfoCompat> list2 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<ShortcutInfo> object2 = new ArrayList<ShortcutInfo>(list2.size());
            Iterator<ShortcutInfoCompat> iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                object2.add(iterator2.next().toShortcutInfo());
            }
            if (!((ShortcutManager)object.getSystemService(ShortcutManager.class)).setDynamicShortcuts(object2)) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).removeAllShortcuts();
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list2);
        for (ShortcutInfoChangeListener shortcutInfoChangeListener : ShortcutManagerCompat.getShortcutInfoListeners((Context)object)) {
            shortcutInfoChangeListener.onAllShortcutsRemoved();
            shortcutInfoChangeListener.onShortcutAdded(list);
        }
        return true;
    }

    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> list) {
        sShortcutInfoChangeListeners = list;
    }

    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(Context object, List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> list2 = ShortcutManagerCompat.removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT <= 29) {
            ShortcutManagerCompat.convertUriIconsToBitmapIcons((Context)object, list2);
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>();
            Iterator<ShortcutInfoCompat> iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().toShortcutInfo());
            }
            if (!((ShortcutManager)object.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                return false;
            }
        }
        ShortcutManagerCompat.getShortcutInfoSaverInstance((Context)object).addShortcuts(list2);
        object = ShortcutManagerCompat.getShortcutInfoListeners((Context)object).iterator();
        while (object.hasNext()) {
            ((ShortcutInfoChangeListener)object.next()).onShortcutUpdated(list);
        }
        return true;
    }

    private static class Api25Impl {
        private Api25Impl() {
        }

        static String getShortcutInfoWithLowestRank(List<ShortcutInfo> object) {
            int n = -1;
            ShortcutInfo shortcutInfo = null;
            Iterator<ShortcutInfo> iterator2 = object.iterator();
            object = shortcutInfo;
            while (iterator2.hasNext()) {
                shortcutInfo = iterator2.next();
                int n2 = n;
                if (shortcutInfo.getRank() > n) {
                    object = shortcutInfo.getId();
                    n2 = shortcutInfo.getRank();
                }
                n = n2;
            }
            return object;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE)
    public static @interface ShortcutMatchFlags {
    }
}

