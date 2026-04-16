package s4;

import java.util.LinkedHashMap;
import lmjxuqdtp.KotlinNothingValueException;
import lmjxuqdtp.jvm.functions.Function1;
import q4.v0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t0 extends s0 implements q4.t0 {
    public final k1 o;
    public LinkedHashMap q;
    public v0 s;
    public final q1.f0 t;
    public long p = 0;
    public final q4.r0 r = new q4.r0(this);

    public t0(k1 k1Var) {
        this.o = k1Var;
        q1.f0 f0Var = q1.s0.a;
        this.t = new q1.f0();
    }

    public static final void Y0(t0 t0Var, v0 v0Var) {
        LinkedHashMap linkedHashMap;
        if (v0Var != null) {
            t0Var.m0((((long) v0Var.getHeight()) & 4294967295L) | (((long) v0Var.getWidth()) << 32));
        } else {
            t0Var.m0(0L);
        }
        if (!lmjxuqdtp.jvm.internal.o.c(t0Var.s, v0Var) && v0Var != null && ((((linkedHashMap = t0Var.q) != null && !linkedHashMap.isEmpty()) || !v0Var.b().isEmpty()) && !lmjxuqdtp.jvm.internal.o.c(v0Var.b(), t0Var.q))) {
            x0 x0Var = t0Var.o.o.F.q;
            lmjxuqdtp.jvm.internal.o.e(x0Var);
            x0Var.r.g();
            LinkedHashMap linkedHashMap2 = t0Var.q;
            if (linkedHashMap2 == null) {
                linkedHashMap2 = new LinkedHashMap();
                t0Var.q = linkedHashMap2;
            }
            linkedHashMap2.clear();
            linkedHashMap2.putAll(v0Var.b());
        }
        t0Var.s = v0Var;
    }

    @Override // s4.s0
    public final boolean J() {
        return true;
    }

    @Override // s4.s0
    public final s0 M0() {
        k1 k1Var = this.o.p;
        if (k1Var != null) {
            return k1Var.h1();
        }
        return null;
    }

    @Override // s4.s0
    public final q4.b0 N0() {
        return this.r;
    }

    @Override // s4.s0
    public final boolean O0() {
        return this.s != null;
    }

    @Override // s4.s0
    public final j0 Q0() {
        return this.o.o;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    @Override // s4.s0
    public final v0 R0() throws KotlinNothingValueException {
        v0 v0Var = this.s;
        if (v0Var != null) {
            return v0Var;
        }
        throw s1.a.q("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // s4.s0
    public final s0 S0() {
        k1 k1Var = this.o.q;
        if (k1Var != null) {
            return k1Var.h1();
        }
        return null;
    }

    @Override // s4.s0
    public final long T0() {
        return this.p;
    }

    @Override // s4.s0
    public final void X0() {
        k0(this.p, 0.0f, null);
    }

    public void Z0() {
        R0().c();
    }

    public final void a1(long j2) {
        if (!p5.k.b(this.p, j2)) {
            this.p = j2;
            k1 k1Var = this.o;
            x0 x0Var = k1Var.o.F.q;
            if (x0Var != null) {
                x0Var.G0();
            }
            s0.V0(k1Var);
        }
        if (this.k) {
            return;
        }
        I0(R0());
    }

    public final long b1(t0 t0Var, boolean z) {
        long jD = 0;
        t0 t0VarH1 = this;
        while (!t0VarH1.equals(t0Var)) {
            if (!t0VarH1.i || !z) {
                jD = p5.k.d(jD, t0VarH1.p);
            }
            k1 k1Var = t0VarH1.o.q;
            lmjxuqdtp.jvm.internal.o.e(k1Var);
            t0VarH1 = k1Var.h1();
            lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        }
        return jD;
    }

    public final float e() {
        return this.o.e();
    }

    public final p5.n getLayoutDirection() {
        return this.o.o.y;
    }

    public final void k0(long j2, float f2, Function1 function1) {
        a1(j2);
        if (this.f442j) {
            return;
        }
        Z0();
    }

    public final Object l() {
        return this.o.l();
    }

    public final float u0() {
        return this.o.u0();
    }
}
