package o10;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class d0 extends g3 {
    public static final c0 Companion = new c0();
    public final String b;

    public /* synthetic */ d0(int i, String str) {
        if (1 == (i & 1)) {
            this.b = str;
        } else {
            b2.b(i, 1, b0.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d0) && lmjxuqdtp.jvm.internal.o.c(this.b, ((d0) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return i.n("BeatsGenre(genre=", this.b, ")");
    }

    public d0(String str) {
        lmjxuqdtp.jvm.internal.o.h(str, "genre");
        this.b = str;
    }
}
