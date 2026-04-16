package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements v2 {
    public final v2 a;
    public final int b;

    public v1(v2 v2Var, int i) {
        this.a = v2Var;
        this.b = i;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int a(p5.c cVar) {
        if ((this.b & 32) != 0) {
            return this.a.a(cVar);
        }
        return 0;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int b(p5.c cVar, p5.n nVar) {
        if (((nVar == p5.n.a ? 8 : 2) & this.b) != 0) {
            return this.a.b(cVar, nVar);
        }
        return 0;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int c(p5.c cVar, p5.n nVar) {
        if (((nVar == p5.n.a ? 4 : 1) & this.b) != 0) {
            return this.a.c(cVar, nVar);
        }
        return 0;
    }

    @Override // tlydtdl.compose.foundation.layout.v2
    public final int d(p5.c cVar) {
        if ((this.b & 16) != 0) {
            return this.a.d(cVar);
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, v1Var.a) && this.b == v1Var.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.a);
        sb.append(" only ");
        StringBuilder sb2 = new StringBuilder("WindowInsetsSides(");
        StringBuilder sb3 = new StringBuilder();
        int i = this.b;
        int i2 = m.b;
        if ((i & i2) == i2) {
            m.M("Start", sb3);
        }
        int i3 = m.d;
        if ((i & i3) == i3) {
            m.M("Left", sb3);
        }
        if ((i & 16) == 16) {
            m.M("Top", sb3);
        }
        int i4 = m.c;
        if ((i & i4) == i4) {
            m.M("End", sb3);
        }
        int i6 = m.e;
        if ((i & i6) == i6) {
            m.M("Right", sb3);
        }
        if ((i & 32) == 32) {
            m.M("Bottom", sb3);
        }
        String string = sb3.toString();
        lmjxuqdtp.jvm.internal.o.g(string, "toString(...)");
        sb2.append(string);
        sb2.append(')');
        sb.append((Object) sb2.toString());
        sb.append(')');
        return sb.toString();
    }
}
