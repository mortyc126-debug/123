package l8;

import amuvvoafs.os.Bundle;
import o6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b1 {
    public static final String a;

    static {
        int i = o8.f0.a;
        a = Integer.toString(0, 36);
    }

    public static b1 a(Bundle bundle) {
        int i = bundle.getInt(a, -1);
        if (i == 0) {
            return w.d(bundle);
        }
        if (i == 1) {
            return s0.d(bundle);
        }
        if (i == 2) {
            return c1.d(bundle);
        }
        if (i == 3) {
            return f1.d(bundle);
        }
        throw new IllegalArgumentException(c.k(i, "Unknown RatingType: "));
    }

    public abstract boolean b();

    public abstract Bundle c();
}
