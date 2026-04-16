package o10;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class f2 extends r0 {
    public static final e2 Companion = new e2();
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f2(int i, String str, String str2) {
        super(str);
        if (3 != (i & 3)) {
            b2.b(i, 3, d2.a.getDescriptor());
            throw null;
        }
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f2) && lmjxuqdtp.jvm.internal.o.c(this.d, ((f2) obj).d);
    }

    public final int hashCode() {
        String str = this.d;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return i.n("PlaylistProfile(playlistId=", this.d, ")");
    }

    public f2(String str) {
        super(str, 0);
        this.d = str;
    }
}
