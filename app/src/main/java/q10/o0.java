package q10;

import az1.b2;
import wy1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@f
public final class o0 extends t0 {
    public static final n0 Companion = new n0();
    public final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(int i, String str, String str2) {
        super(str);
        if (3 != (i & 3)) {
            b2.b(i, 3, m0.a.getDescriptor());
            throw null;
        }
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o0) && lmjxuqdtp.jvm.internal.o.c(this.c, ((o0) obj).c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return i.n("Band(bandId=", this.c, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(String str) {
        super(str, 0);
        lmjxuqdtp.jvm.internal.o.h(str, "bandId");
        this.c = str;
    }
}
