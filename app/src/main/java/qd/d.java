package qd;

import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements e {
    public final Object b;

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return o.c(this.b, ((d) obj).b);
        }
        return false;
    }

    @Override // qd.e
    public final Object getValue() {
        return this.b;
    }

    public final int hashCode() {
        Object obj = this.b;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "Value(value=" + this.b + ')';
    }
}
