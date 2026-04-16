package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i2 {
    public float a = 0.0f;
    public boolean b = true;
    public m c = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i2)) {
            return false;
        }
        i2 i2Var = (i2) obj;
        return Float.compare(this.a, i2Var.a) == 0 && this.b == i2Var.b && lmjxuqdtp.jvm.internal.o.c(this.c, i2Var.c);
    }

    public final int hashCode() {
        int iF = s1.a.f(Float.hashCode(this.a) * 31, 31, this.b);
        m mVar = this.c;
        return (iF + (mVar == null ? 0 : mVar.hashCode())) * 31;
    }

    public final String toString() {
        return "RowColumnParentData(weight=" + this.a + ", fill=" + this.b + ", crossAxisAlignment=" + this.c + ", flowLayoutData=null)";
    }
}
