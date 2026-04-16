package r6;

import i6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o1 {
    public final z1 a;
    public c[] b;

    public o1() {
        this(new z1((z1) null));
    }

    public final void a() {
        c[] cVarArr = this.b;
        if (cVarArr != null) {
            c cVarG = cVarArr[0];
            c cVarG2 = cVarArr[1];
            z1 z1Var = this.a;
            if (cVarG2 == null) {
                cVarG2 = z1Var.a.g(2);
            }
            if (cVarG == null) {
                cVarG = z1Var.a.g(1);
            }
            g(c.a(cVarG, cVarG2));
            c cVar = this.b[x30.c.v(16)];
            if (cVar != null) {
                f(cVar);
            }
            c cVar2 = this.b[x30.c.v(32)];
            if (cVar2 != null) {
                d(cVar2);
            }
            c cVar3 = this.b[x30.c.v(64)];
            if (cVar3 != null) {
                h(cVar3);
            }
        }
    }

    public abstract z1 b();

    public void c(int i, c cVar) {
        if (this.b == null) {
            this.b = new c[10];
        }
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.b[x30.c.v(i2)] = cVar;
            }
        }
    }

    public void d(c cVar) {
    }

    public abstract void e(c cVar);

    public void f(c cVar) {
    }

    public abstract void g(c cVar);

    public void h(c cVar) {
    }

    public o1(z1 z1Var) {
        this.a = z1Var;
    }
}
