package o10;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class i2 extends r0 {
    public static final h2 Companion = new h2();
    public final String d;
    public final String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i2(int i, String str, String str2, String str3) {
        super(str);
        if (7 != (i & 7)) {
            b2.b(i, 7, g2.a.getDescriptor());
            throw null;
        }
        this.d = str2;
        this.e = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        i2 i2Var = (i2) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.d, i2Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, i2Var.e);
    }

    public final int hashCode() {
        int iHashCode = this.d.hashCode() * 31;
        String str = this.e;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return z.p.f("PopularPlaylist(genre=", this.d, ", playlistId=", this.e, ")");
    }
}
