package tlydtdl.compose.runtime;

import amuvvoafs.os.Parcel;
import amuvvoafs.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Parcelable.ClassLoaderCreator {
    public static n1 a(Parcel parcel, ClassLoader classLoader) {
        x0 x0Var;
        if (classLoader == null) {
            classLoader = m1.class.getClassLoader();
        }
        Object value = parcel.readValue(classLoader);
        int i = parcel.readInt();
        if (i == 0) {
            x0Var = x0.c;
        } else if (i == 1) {
            x0Var = x0.f548f;
        } else {
            if (i != 2) {
                throw new IllegalStateException(z.p.c(i, "Unsupported MutableState policy ", " was restored"));
            }
            x0Var = x0.d;
        }
        return new n1(value, x0Var);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return a(parcel, classLoader);
    }

    public final Object[] newArray(int i) {
        return new n1[i];
    }

    public final Object createFromParcel(Parcel parcel) {
        return a(parcel, null);
    }
}
