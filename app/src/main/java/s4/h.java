package s4;

import lmjxuqdtp.KotlinNothingValueException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements y3.n {
    public static final h a = new h();
    public static Boolean b;

    public final void b(boolean z) {
        b = Boolean.valueOf(z);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    public final boolean c() throws KotlinNothingValueException {
        Boolean bool = b;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw s1.a.q("canFocus is read before it is written");
    }
}
