package g4;

import amuvvoafs.graphics.Path;
import java.util.List;
import lmjxuqdtp.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e0 {
    public a4.u b;
    public float c = 1.0f;
    public List d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f163f;
    public a4.u g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f164j;
    public float k;
    public float l;
    public float m;
    public boolean n;
    public boolean o;
    public boolean p;
    public c4.h q;
    public final a4.k r;
    public a4.k s;
    public final Object t;

    public i() {
        int i = j0.a;
        this.d = mx1.t.a;
        this.e = 1.0f;
        this.h = 0;
        this.i = 0;
        this.f164j = 4.0f;
        this.l = 1.0f;
        this.n = true;
        this.o = true;
        a4.k kVarA = a4.o.a();
        this.r = kVarA;
        this.s = kVarA;
        this.t = hs1.d.E(lx1.j.b, h.d);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    @Override // g4.e0
    public final void a(c4.d dVar) throws NoWhenBranchMatchedException {
        c4.h hVar;
        if (this.n) {
            b.d(this.d, this.r);
            e();
        } else if (this.p) {
            e();
        }
        this.n = false;
        this.p = false;
        a4.u uVar = this.b;
        if (uVar != null) {
            c4.d.c0(dVar, this.s, uVar, this.c, (c4.h) null, 56);
        }
        a4.u uVar2 = this.g;
        if (uVar2 != null) {
            c4.h hVar2 = this.q;
            if (this.o || hVar2 == null) {
                c4.h hVar3 = new c4.h(this.f163f, this.f164j, this.h, this.i, (a4.l) null, 16);
                this.q = hVar3;
                this.o = false;
                hVar = hVar3;
            } else {
                hVar = hVar2;
            }
            c4.d.c0(dVar, this.s, uVar2, this.e, hVar, 48);
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object, lx1.h] */
    public final void e() {
        float f2 = this.k;
        a4.k kVar = this.r;
        if (f2 == 0.0f && this.l == 1.0f) {
            this.s = kVar;
            return;
        }
        if (lmjxuqdtp.jvm.internal.o.c(this.s, kVar)) {
            this.s = a4.o.a();
        } else {
            int i = this.s.a.getFillType() == Path.FillType.EVEN_ODD ? 1 : 0;
            this.s.a.rewind();
            this.s.h(i);
        }
        ?? r0 = this.t;
        ((a4.m) r0.getValue()).c(kVar);
        float fA = ((a4.m) r0.getValue()).a();
        float f3 = this.k;
        float f4 = this.m;
        float f5 = ((f3 + f4) % 1.0f) * fA;
        float f7 = ((this.l + f4) % 1.0f) * fA;
        if (f5 <= f7) {
            ((a4.m) r0.getValue()).b(f5, f7, this.s);
        } else {
            ((a4.m) r0.getValue()).b(f5, fA, this.s);
            ((a4.m) r0.getValue()).b(0.0f, f7, this.s);
        }
    }

    public final String toString() {
        return this.r.toString();
    }
}
