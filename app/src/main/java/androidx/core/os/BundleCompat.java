/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.util.SparseArray
 */
package androidx.core.os;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;

public final class BundleCompat {
    private BundleCompat() {
    }

    @Deprecated
    public static IBinder getBinder(Bundle bundle, String string2) {
        return bundle.getBinder(string2);
    }

    public static <T> T getParcelable(Bundle bundle, String string2, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelable(bundle, string2, clazz);
        }
        if (!clazz.isInstance(bundle = bundle.getParcelable(string2))) {
            bundle = null;
        }
        return (T)bundle;
    }

    public static Parcelable[] getParcelableArray(Bundle bundle, String string2, Class<? extends Parcelable> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArray(bundle, string2, clazz);
        }
        return bundle.getParcelableArray(string2);
    }

    public static <T> ArrayList<T> getParcelableArrayList(Bundle bundle, String string2, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getParcelableArrayList(bundle, string2, clazz);
        }
        return bundle.getParcelableArrayList(string2);
    }

    public static <T extends Serializable> T getSerializable(Bundle object, String string2, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getSerializable(object, string2, clazz);
        }
        if (!clazz.isInstance(object = object.getSerializable(string2))) {
            object = null;
        }
        return (T)object;
    }

    public static <T> SparseArray<T> getSparseParcelableArray(Bundle bundle, String string2, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.getSparseParcelableArray(bundle, string2, clazz);
        }
        return bundle.getSparseParcelableArray(string2);
    }

    @Deprecated
    public static void putBinder(Bundle bundle, String string2, IBinder iBinder) {
        bundle.putBinder(string2, iBinder);
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T getParcelable(Bundle bundle, String string2, Class<T> clazz) {
            return (T)bundle.getParcelable(string2, clazz);
        }

        static <T> T[] getParcelableArray(Bundle bundle, String string2, Class<T> clazz) {
            return bundle.getParcelableArray(string2, clazz);
        }

        static <T> ArrayList<T> getParcelableArrayList(Bundle bundle, String string2, Class<? extends T> clazz) {
            return bundle.getParcelableArrayList(string2, clazz);
        }

        static <T extends Serializable> T getSerializable(Bundle bundle, String string2, Class<T> clazz) {
            return (T)bundle.getSerializable(string2, clazz);
        }

        static <T> SparseArray<T> getSparseParcelableArray(Bundle bundle, String string2, Class<? extends T> clazz) {
            return bundle.getSparseParcelableArray(string2, clazz);
        }
    }
}

