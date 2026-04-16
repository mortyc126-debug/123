package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class b0 {
    public static final a0 Companion = new a0();
    public final String a;
    public final String b;

    public /* synthetic */ b0(int i, String str, String str2) {
        if (3 != (i & 3)) {
            b2.b(i, 3, z.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, b0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, b0Var.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return z.p.f("Mastering(presetId=", this.a, ", originalAudioUrl=", this.b, ")");
    }
}
