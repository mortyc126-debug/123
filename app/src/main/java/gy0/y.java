package gy0;

import aj.a;
import az1.b2;
import lmjxuqdtp.jvm.internal.o;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class y {
    public static final x Companion = new x();
    public final String a;
    public final String b;

    public /* synthetic */ y(int i, String str, String str2) {
        if (3 != (i & 3)) {
            b2.b(i, 3, w.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return o.c(this.a, yVar.a) && o.c(this.b, yVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return p.f("TrendingInGenre(channelId=", this.a, ", collectionId=", this.b, ")");
    }
}
