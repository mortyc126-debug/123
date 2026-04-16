package s4;

import q4.m1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends t0 {
    public final /* synthetic */ c0 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var) {
        super(c0Var);
        this.u = c0Var;
    }

    @Override // s4.s0
    public final int D0(q4.a aVar) {
        int i = q8.c.i(this, aVar);
        this.t.h(i, aVar);
        return i;
    }

    public final int M(int i) {
        c0 c0Var = this.u;
        a0 a0Var = c0Var.P;
        k1 k1Var = c0Var.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        t0 t0VarH1 = k1Var.h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return a0Var.minIntrinsicWidth(this, t0VarH1, i);
    }

    public final int R(int i) {
        c0 c0Var = this.u;
        a0 a0Var = c0Var.P;
        k1 k1Var = c0Var.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        t0 t0VarH1 = k1Var.h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return a0Var.maxIntrinsicWidth(this, t0VarH1, i);
    }

    public final m1 T(long j2) {
        o0(j2);
        new p5.a(j2);
        c0 c0Var = this.u;
        a0 a0Var = c0Var.P;
        k1 k1Var = c0Var.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        t0 t0VarH1 = k1Var.h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        t0.Y0(this, a0Var.mo1789measure3p2s80s(this, t0VarH1, j2));
        return this;
    }

    public final int c(int i) {
        c0 c0Var = this.u;
        a0 a0Var = c0Var.P;
        k1 k1Var = c0Var.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        t0 t0VarH1 = k1Var.h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return a0Var.maxIntrinsicHeight(this, t0VarH1, i);
    }

    public final int z(int i) {
        c0 c0Var = this.u;
        a0 a0Var = c0Var.P;
        k1 k1Var = c0Var.p;
        lmjxuqdtp.jvm.internal.o.e(k1Var);
        t0 t0VarH1 = k1Var.h1();
        lmjxuqdtp.jvm.internal.o.e(t0VarH1);
        return a0Var.minIntrinsicHeight(this, t0VarH1, i);
    }
}
