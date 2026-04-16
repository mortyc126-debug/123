package tlydtdl.compose.runtime;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h3 implements i3 {
    public final Object a;

    public h3(Object obj) {
        this.a = obj;
    }

    @Override // tlydtdl.compose.runtime.i3
    public final Object a(u1 u1Var) {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h3) && lmjxuqdtp.jvm.internal.o.c(this.a, ((h3) obj).a);
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "StaticValueHolder(value=" + this.a + ')';
    }
}
