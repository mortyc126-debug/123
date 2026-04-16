package cs0;

import bh.j;
import f3.f2;
import hg1.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements h {
    public final float a;
    public final boolean b;
    public final boolean c;

    public f(float f2, boolean z, boolean z2) {
        this.a = f2;
        this.b = z;
        this.c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return b.a(this.a, fVar.a) && this.b == fVar.b && this.c == fVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + s1.a.f(Float.hashCode(this.a) * 31, 31, this.b);
    }

    public final String toString() {
        return f2.o(j.s("TextInputFocused(lastValidBpm=", b.b(this.a), ", isEnabled=", ", applying=", this.b), this.c, ")");
    }
}
