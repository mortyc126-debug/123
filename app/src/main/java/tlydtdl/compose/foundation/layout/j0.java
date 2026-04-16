package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends m {
    public final t3.g h;

    public j0(t3.g gVar) {
        this.h = gVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j0) && lmjxuqdtp.jvm.internal.o.c(this.h, ((j0) obj).h);
    }

    public final int hashCode() {
        return Float.hashCode(this.h.a);
    }

    @Override // tlydtdl.compose.foundation.layout.m
    public final int k(int i, p5.n nVar) {
        return this.h.a(0, i);
    }

    public final String toString() {
        return "VerticalCrossAxisAlignment(vertical=" + this.h + ')';
    }
}
