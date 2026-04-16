package tlydtdl.compose.runtime;

import a2.n3;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements y0 {
    public final n3 a;
    public Throwable c;
    public final Object b = new Object();
    public final q3.a d = new q3.a(0);
    public q1.j0 e = new q1.j0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q1.j0 f529f = new q1.j0();

    public f(n3 n3Var) {
        this.a = n3Var;
    }

    @Override // tlydtdl.compose.runtime.y0
    public final Object F(Function1 function1, qx1.d dVar) {
        int i;
        int i2;
        int i3;
        ky1.m mVar = new ky1.m(1, di0.z.C(dVar));
        mVar.s();
        d dVar2 = new d();
        dVar2.a = function1;
        dVar2.b = mVar;
        lmjxuqdtp.jvm.internal.a0 a0Var = new lmjxuqdtp.jvm.internal.a0();
        a0Var.a = -1;
        synchronized (this.b) {
            Throwable th = this.c;
            if (th != null) {
                mVar.resumeWith(lg.e.u(th));
            } else {
                q3.a aVar = this.d;
                do {
                    i = aVar.get();
                    i2 = i + 1;
                } while (!aVar.compareAndSet(i, i2));
                boolean z = (134217727 & i2) == 1;
                a0Var.a = (i2 >>> 27) & 15;
                this.e.a(dVar2);
                mVar.v(new e(dVar2, this, a0Var, 0));
                if (z) {
                    try {
                        this.a.invoke();
                    } catch (Throwable th2) {
                        synchronized (this.b) {
                            try {
                                if (this.c == null) {
                                    this.c = th2;
                                    q1.j0 j0Var = this.e;
                                    Object[] objArr = j0Var.a;
                                    int i4 = j0Var.b;
                                    for (int i6 = 0; i6 < i4; i6++) {
                                        ky1.m mVar2 = ((d) objArr[i6]).b;
                                        if (mVar2 != null) {
                                            mVar2.resumeWith(lg.e.u(th2));
                                        }
                                    }
                                    this.e.c();
                                    q3.a aVar2 = this.d;
                                    do {
                                        i3 = aVar2.get();
                                    } while (!aVar2.compareAndSet(i3, ((((i3 >>> 27) & 15) + 1) & 15) << 27));
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                }
            }
        }
        Object objQ = mVar.q();
        rx1.a aVar3 = rx1.a.a;
        return objQ;
    }

    public final void d(long j2) {
        int i;
        ky1.m mVar;
        Object objU;
        synchronized (this.b) {
            try {
                q1.j0 j0Var = this.e;
                this.e = this.f529f;
                this.f529f = j0Var;
                q3.a aVar = this.d;
                do {
                    i = aVar.get();
                } while (!aVar.compareAndSet(i, ((((i >>> 27) & 15) + 1) & 15) << 27));
                int i2 = j0Var.b;
                for (int i3 = 0; i3 < i2; i3++) {
                    d dVar = (d) j0Var.e(i3);
                    Function1 function1 = dVar.a;
                    if (function1 != null && (mVar = dVar.b) != null) {
                        try {
                            objU = function1.invoke(Long.valueOf(j2));
                        } catch (Throwable th) {
                            objU = lg.e.u(th);
                        }
                        mVar.resumeWith(objU);
                    }
                }
                j0Var.c();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Object fold(Object obj, Function2 function2) {
        return function2.invoke(obj, this);
    }

    public final qx1.g get(qx1.h hVar) {
        return qg.a.n(this, hVar);
    }

    public final qx1.i minusKey(qx1.h hVar) {
        return qg.a.v(this, hVar);
    }

    public final qx1.i plus(qx1.i iVar) {
        return qg.a.x(this, iVar);
    }
}
