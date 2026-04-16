package tlydtdl.lifecycle;

import ny1.b2;
import ny1.r2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public final u1 a = new u1();

    public abstract void a(f0 f0Var);

    public abstract y b();

    public b2 c() {
        r2 r2VarC = ny1.z.c(b());
        a(new t(0, r2VarC));
        return new b2(r2VarC);
    }

    public abstract void d(f0 f0Var);
}
