package rg1;

import az1.b2;
import lmjxuqdtp.jvm.internal.o;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class j {
    public static final i Companion = new i();
    public final String a;
    public final String b;

    public /* synthetic */ j(int i, String str, String str2) {
        if (3 != (i & 3)) {
            b2.b(i, 3, h.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return o.c(this.a, jVar.a) && o.c(this.b, jVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return p.f("Reason(id=", this.a, ", name=", this.b, ")");
    }

    public j(String str, String str2) {
        o.h(str, "id");
        this.a = str;
        this.b = str2;
    }
}
