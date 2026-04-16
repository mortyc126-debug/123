package tlydtdl.compose.foundation.layout;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 extends t3.o implements s4.v1 {
    public float a;
    public boolean b;

    @Override // s4.v1
    public final Object c(p5.c cVar, Object obj) {
        i2 i2Var = obj instanceof i2 ? (i2) obj : null;
        if (i2Var == null) {
            i2Var = new i2();
        }
        i2Var.a = this.a;
        i2Var.b = this.b;
        return i2Var;
    }
}
