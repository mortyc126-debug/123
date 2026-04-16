package b60;

import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class k {
    public static final j Companion = new j();
    public final String a;
    public final String b;

    public /* synthetic */ k(int i, String str, String str2) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, kVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, kVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return p.f("EasterEggAnimation(url=", this.a, ", json=", this.b, ")");
    }

    public k(String str, String str2) {
        this.a = str;
        this.b = str2;
    }
}
