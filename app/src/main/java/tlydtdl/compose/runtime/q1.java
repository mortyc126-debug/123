package tlydtdl.compose.runtime;

import ak.b;
import com.gnacba.amuvvoafs.gms.internal.ads.j70;
import java.util.concurrent.atomic.AtomicReference;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 {
    public final z a;
    public final w b;
    public final s c;
    public final Function2 d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qu0.u f540f;
    public final Object g;
    public final AtomicReference h = new AtomicReference(r1.c);
    public q1.o0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j70 f541j;
    public final h2 k;

    public q1(z zVar, w wVar, s sVar, q1.q0 q0Var, Function2 function2, boolean z, qu0.u uVar, Object obj) {
        this.a = zVar;
        this.b = wVar;
        this.c = sVar;
        this.d = function2;
        this.e = z;
        this.f540f = uVar;
        this.g = obj;
        q1.o0 o0Var = q1.w0.a;
        lmjxuqdtp.jvm.internal.o.f(o0Var, "null cannot be cast to non-null type tlydtdl.collection.ScatterSet<E of tlydtdl.collection.ScatterSetKt.emptyScatterSet>");
        this.i = o0Var;
        j70 j70Var = new j70();
        j70Var.h(q0Var, sVar.E());
        this.f541j = j70Var;
        this.k = new h2(uVar.d);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final void a() throws Exception {
        AtomicReference atomicReference = this.h;
        try {
            switch (((r1) atomicReference.get()).ordinal()) {
                case 0:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                case 1:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 2:
                case 3:
                case 4:
                    throw new IllegalStateException("The paused composition has not completed yet");
                case 5:
                    b();
                    r1 r1Var = r1.f;
                    r1 r1Var2 = r1.g;
                    if (b.u(atomicReference)) {
                        return;
                    }
                    v1.b("Unexpected state change from: " + r1Var + " to: " + r1Var2 + '.');
                    return;
                case 6:
                    throw new IllegalStateException("The paused composition has already been applied");
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            atomicReference.set(r1.a);
            throw e;
        }
    }

    public final void b() {
        synchronized (this.g) {
            try {
                this.k.g(this.f540f, this.f541j);
                this.f541j.d();
                this.f541j.e();
            } finally {
                this.f541j.c();
                this.a.q = null;
            }
        }
    }

    public final boolean c() {
        return ((r1) this.h.get()).compareTo(r1.f) >= 0;
    }

    public final void d() {
        r1 r1Var = r1.d;
        r1 r1Var2 = r1.f;
        if (b.v(this.h)) {
            return;
        }
        v1.b("Unexpected state change from: " + r1Var + " to: " + r1Var2 + '.');
    }

    public final void e() {
        AtomicReference atomicReference = this.h;
        Object obj = atomicReference.get();
        r1 r1Var = r1.d;
        if (obj == r1Var) {
            return;
        }
        r1 r1Var2 = r1.f;
        if (b.q(atomicReference)) {
            return;
        }
        v1.b("Unexpected state change from: " + r1Var2 + " to: " + r1Var + '.');
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final boolean f(m2 m2Var) throws Exception {
        AtomicReference atomicReference = this.h;
        try {
            int iOrdinal = ((r1) atomicReference.get()).ordinal();
            z zVar = this.a;
            w wVar = this.b;
            switch (iOrdinal) {
                case 0:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                case 1:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 2:
                    s sVar = this.c;
                    boolean z = this.e;
                    if (z) {
                        sVar.z = 100;
                        sVar.y = true;
                    }
                    try {
                        this.i = wVar.b(zVar, m2Var, this.d);
                        r1 r1Var = r1.c;
                        r1 r1Var2 = r1.d;
                        if (!b.r(atomicReference)) {
                            v1.b("Unexpected state change from: " + r1Var + " to: " + r1Var2 + '.');
                        }
                        if (this.i.g()) {
                            d();
                        }
                        return c();
                    } finally {
                        if (z) {
                            sVar.w();
                        }
                    }
                case 3:
                    r1 r1Var3 = r1.d;
                    r1 r1Var4 = r1.e;
                    if (!b.s(atomicReference)) {
                        v1.b("Unexpected state change from: " + r1Var3 + " to: " + r1Var4 + '.');
                    }
                    try {
                        this.i = wVar.p(zVar, m2Var, this.i);
                        if (!b.t(atomicReference)) {
                            v1.b("Unexpected state change from: " + r1Var4 + " to: " + r1Var3 + '.');
                        }
                        if (this.i.g()) {
                            d();
                        }
                        return c();
                    } catch (Throwable th) {
                        r1 r1Var5 = r1.e;
                        r1 r1Var6 = r1.d;
                        if (!b.t(atomicReference)) {
                            v1.b("Unexpected state change from: " + r1Var5 + " to: " + r1Var6 + '.');
                        }
                        throw th;
                    }
                case 4:
                    u.d("Recursive call to resume()");
                    throw new KotlinNothingValueException();
                case 5:
                    throw new IllegalStateException("Pausable composition is complete and apply() should be applied");
                case 6:
                    throw new IllegalStateException("The paused composition has been applied");
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } catch (Exception e) {
            atomicReference.set(r1.a);
            throw e;
        }
    }
}
