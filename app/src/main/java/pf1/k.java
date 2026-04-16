package pf1;

import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public final String a;
    public final int b;
    public final int c;

    public k(String str, int i) {
        this.a = str;
        this.b = i;
        this.c = str.length() + i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return o.c(this.a, kVar.a) && this.b == kVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return i.l("StringMatch(value=", this.b, this.a, ", start=", ")");
    }
}
