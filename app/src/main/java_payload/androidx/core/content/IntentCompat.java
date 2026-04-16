/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 */
package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.content.PackageManagerCompat;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
    }

    public static Intent createManageUnusedAppRestrictionsIntent(Context object, String string2) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(object.getPackageManager())) {
            if (Build.VERSION.SDK_INT >= 31) {
                return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts((String)"package", (String)string2, null));
            }
            string2 = new Intent("android.intent.action.AUTO_REVOKE_PERMISSIONS").setData(Uri.fromParts((String)"package", (String)string2, null));
            if (Build.VERSION.SDK_INT >= 30) {
                return string2;
            }
            object = PackageManagerCompat.getPermissionRevocationVerifierApp(object.getPackageManager());
            return string2.setPackage((String)Preconditions.checkNotNull(object));
        }
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    public static Parcelable[] getParcelableArrayExtra(Intent intent, String string2, Class<? extends Parcelable> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayExtra(intent, string2, clazz);
        }
        return intent.getParcelableArrayExtra(string2);
    }

    public static <T> ArrayList<T> getParcelableArrayListExtra(Intent intent, String string2, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayListExtra(intent, string2, clazz);
        }
        return intent.getParcelableArrayListExtra(string2);
    }

    public static <T> T getParcelableExtra(Intent intent, String string2, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableExtra(intent, string2, clazz);
        }
        if (!clazz.isInstance(intent = intent.getParcelableExtra(string2))) {
            intent = null;
        }
        return (T)intent;
    }

    public static <T extends Serializable> T getSerializableExtra(Intent object, String string2, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getSerializableExtra(object, string2, clazz);
        }
        if (!clazz.isInstance(object = object.getSerializableExtra(string2))) {
            object = null;
        }
        return (T)object;
    }

    public static Intent makeMainSelectorActivity(String string2, String string3) {
        return Intent.makeMainSelectorActivity((String)string2, (String)string3);
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T[] getParcelableArrayExtra(Intent intent, String string2, Class<T> clazz) {
            return intent.getParcelableArrayExtra(string2, clazz);
        }

        static <T> ArrayList<T> getParcelableArrayListExtra(Intent intent, String string2, Class<? extends T> clazz) {
            return intent.getParcelableArrayListExtra(string2, clazz);
        }

        static <T> T getParcelableExtra(Intent intent, String string2, Class<T> clazz) {
            return (T)intent.getParcelableExtra(string2, clazz);
        }

        static <T extends Serializable> T getSerializableExtra(Intent intent, String string2, Class<T> clazz) {
            return (T)intent.getSerializableExtra(string2, clazz);
        }
    }
}

