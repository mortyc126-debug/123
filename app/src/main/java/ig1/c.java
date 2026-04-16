package ig1;

import lmjxuqdtp.jvm.internal.o;
import wy1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class c {
    public static final b Companion = new b();
    public final String a;

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return o.c(this.a, ((c) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a;
    }
}
