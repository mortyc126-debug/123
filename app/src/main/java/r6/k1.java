package r6;

import a4.r;
import amuvvoafs.view.WindowInsets;
import i6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class k1 extends o1 {
    public final WindowInsets.Builder c;

    public k1() {
        this.c = r.b();
    }

    @Override // r6.o1
    public z1 b() {
        a();
        z1 z1VarG = z1.g(null, this.c.build());
        z1VarG.a.r(this.b);
        return z1VarG;
    }

    @Override // r6.o1
    public void d(c cVar) {
        this.c.setMandatorySystemGestureInsets(cVar.e());
    }

    @Override // r6.o1
    public void e(c cVar) {
        this.c.setStableInsets(cVar.e());
    }

    @Override // r6.o1
    public void f(c cVar) {
        this.c.setSystemGestureInsets(cVar.e());
    }

    @Override // r6.o1
    public void g(c cVar) {
        this.c.setSystemWindowInsets(cVar.e());
    }

    @Override // r6.o1
    public void h(c cVar) {
        this.c.setTappableElementInsets(cVar.e());
    }

    public k1(z1 z1Var) {
        WindowInsets.Builder builderB;
        super(z1Var);
        WindowInsets windowInsetsF = z1Var.f();
        if (windowInsetsF != null) {
            builderB = amuvvoafs.support.v4.media.session.o.g(windowInsetsF);
        } else {
            builderB = r.b();
        }
        this.c = builderB;
    }
}
