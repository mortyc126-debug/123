/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.BadParcelableException
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 */
package androidx.core.os;

import android.os.BadParcelableException;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ParcelCompat {
    private ParcelCompat() {
    }

    public static <T> Object[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readArray(parcel, classLoader, clazz);
        }
        return parcel.readArray(classLoader);
    }

    public static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readArrayList(parcel, classLoader, clazz);
        }
        return parcel.readArrayList(classLoader);
    }

    public static boolean readBoolean(Parcel parcel) {
        boolean bl = parcel.readInt() != 0;
        return bl;
    }

    public static <K, V> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> clazz, Class<? extends V> clazz2) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readHashMap(parcel, classLoader, clazz, clazz2);
        }
        return parcel.readHashMap(classLoader);
    }

    public static <T> void readList(Parcel parcel, List<? super T> list, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api33Impl.readList(parcel, list, classLoader, clazz);
        } else {
            parcel.readList(list, classLoader);
        }
    }

    public static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map2, ClassLoader classLoader, Class<K> clazz, Class<V> clazz2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api33Impl.readMap(parcel, map2, classLoader, clazz, clazz2);
        } else {
            parcel.readMap(map2, classLoader);
        }
    }

    public static <T extends Parcelable> T readParcelable(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelable(parcel, classLoader, clazz);
        }
        if ((parcel = parcel.readParcelable(classLoader)) != null && !clazz.isInstance(parcel)) {
            throw new BadParcelableException("Parcelable " + parcel.getClass() + " is not a subclass of required class " + clazz.getName() + " provided in the parameter");
        }
        return (T)parcel;
    }

    @Deprecated
    public static <T> T[] readParcelableArray(Parcel parcelableArray, ClassLoader objectArray, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableArray((Parcel)parcelableArray, (ClassLoader)objectArray, clazz);
        }
        parcelableArray = parcelableArray.readParcelableArray((ClassLoader)objectArray);
        if (clazz.isAssignableFrom(Parcelable.class)) {
            return parcelableArray;
        }
        objectArray = (Object[])Array.newInstance(clazz, parcelableArray.length);
        for (int i = 0; i < parcelableArray.length; ++i) {
            try {
                objectArray[i] = clazz.cast(parcelableArray[i]);
                continue;
            }
            catch (ClassCastException classCastException) {
                throw new BadParcelableException("Parcelable at index " + i + " is not a subclass of required class " + clazz.getName() + " provided in the parameter");
            }
        }
        return objectArray;
    }

    public static <T> Parcelable[] readParcelableArrayTyped(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (Parcelable[])Api33Impl.readParcelableArray(parcel, classLoader, clazz);
        }
        return parcel.readParcelableArray(classLoader);
    }

    public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableCreator(parcel, classLoader, clazz);
        }
        return Api30Impl.readParcelableCreator(parcel, classLoader);
    }

    public static <T> List<T> readParcelableList(Parcel parcel, List<T> list, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readParcelableList(parcel, list, classLoader, clazz);
        }
        return Api29Impl.readParcelableList(parcel, list, classLoader);
    }

    public static <T extends Serializable> T readSerializable(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.readSerializable(parcel, classLoader, clazz);
        }
        return (T)parcel.readSerializable();
    }

    public static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> clazz) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api33Impl.readSparseArray(parcel, classLoader, clazz);
        }
        return parcel.readSparseArray(classLoader);
    }

    public static void writeBoolean(Parcel parcel, boolean bl) {
        parcel.writeInt(bl ? 1 : 0);
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static <T extends Parcelable> List<T> readParcelableList(Parcel parcel, List<T> list, ClassLoader classLoader) {
            return parcel.readParcelableList(list, classLoader);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static Parcelable.Creator<?> readParcelableCreator(Parcel parcel, ClassLoader classLoader) {
            return parcel.readParcelableCreator(classLoader);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static <T> T[] readArray(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
            return parcel.readArray(classLoader, clazz);
        }

        static <T> ArrayList<T> readArrayList(Parcel parcel, ClassLoader classLoader, Class<? extends T> clazz) {
            return parcel.readArrayList(classLoader, clazz);
        }

        static <V, K> HashMap<K, V> readHashMap(Parcel parcel, ClassLoader classLoader, Class<? extends K> clazz, Class<? extends V> clazz2) {
            return parcel.readHashMap(classLoader, clazz, clazz2);
        }

        static <T> void readList(Parcel parcel, List<? super T> list, ClassLoader classLoader, Class<T> clazz) {
            parcel.readList(list, classLoader, clazz);
        }

        static <K, V> void readMap(Parcel parcel, Map<? super K, ? super V> map2, ClassLoader classLoader, Class<K> clazz, Class<V> clazz2) {
            parcel.readMap(map2, classLoader, clazz, clazz2);
        }

        static <T extends Parcelable> T readParcelable(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
            return (T)((Parcelable)parcel.readParcelable(classLoader, clazz));
        }

        static <T> T[] readParcelableArray(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
            return parcel.readParcelableArray(classLoader, clazz);
        }

        static <T> Parcelable.Creator<T> readParcelableCreator(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
            return parcel.readParcelableCreator(classLoader, clazz);
        }

        static <T> List<T> readParcelableList(Parcel parcel, List<T> list, ClassLoader classLoader, Class<T> clazz) {
            return parcel.readParcelableList(list, classLoader, clazz);
        }

        static <T extends Serializable> T readSerializable(Parcel parcel, ClassLoader classLoader, Class<T> clazz) {
            return (T)((Serializable)parcel.readSerializable(classLoader, clazz));
        }

        static <T> SparseArray<T> readSparseArray(Parcel parcel, ClassLoader classLoader, Class<? extends T> clazz) {
            return parcel.readSparseArray(classLoader, clazz);
        }
    }
}

