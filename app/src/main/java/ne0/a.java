package ne0;

import ky1.a0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.o;
import ny1.b2;
import ny1.j2;
import ny1.p2;
import ny1.r2;
import ny1.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements re0.e {
    public final a0 a;
    public final re0.e b;
    public final s c;
    public final y d;
    public final b2 e;

    public a(a0 a0Var, re0.e eVar, s sVar, y yVar) {
        o.h(a0Var, "scope");
        o.h(eVar, "originalInteractor");
        this.a = a0Var;
        this.b = eVar;
        this.c = sVar;
        this.d = yVar;
        p2 currentPosition = eVar.getCurrentPosition();
        n30.k kVar = sVar.n;
        re0.h hVar = new re0.h(0L, false);
        b2 b2VarR = z.R(z.U(eVar.isActive(), new cu0.b((qx1.d) null, kVar, hVar, 3)), a0Var, j2.a(3), hVar);
        r2 r2Var = sVar.l;
        this.e = z.R(z.U(r2Var, new cu0.b((qx1.d) null, b2VarR, currentPosition, 4)), a0Var, j2.a(3), ((Boolean) r2Var.getValue()).booleanValue() ? b2VarR.a.getValue() : currentPosition.getValue());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void b(long j2) throws NoWhenBranchMatchedException {
        if (!this.d.a()) {
            this.b.b(j2);
        } else {
            this.c.c(new ke0.h(j2));
        }
    }

    public final se0.k c() {
        return this.b.c();
    }

    public final void d(boolean z) {
        this.b.d(z);
    }

    public final p2 getCurrentPosition() {
        return this.e;
    }

    public final p2 getDuration() {
        return this.b.getDuration();
    }

    public final p2 getState() {
        return this.b.getState();
    }

    public final p2 isActive() {
        return this.b.isActive();
    }
}
