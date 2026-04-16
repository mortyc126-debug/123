package o10;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class k0 extends r0 {
    public static final j0 Companion = new j0();
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(int i, String str, String str2) {
        super(str);
        if (3 != (i & 3)) {
            b2.b(i, 3, i0.a.getDescriptor());
            throw null;
        }
        this.d = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k0) && lmjxuqdtp.jvm.internal.o.c(this.d, ((k0) obj).d);
    }

    public final int hashCode() {
        String str = this.d;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return i.n("ChannelFeaturedPlaylist(playlistId=", this.d, ")");
    }

    public k0(String str) {
        super(str, 0);
        this.d = str;
    }
}
