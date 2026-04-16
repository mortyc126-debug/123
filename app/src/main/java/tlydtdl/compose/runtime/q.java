package tlydtdl.compose.runtime;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import lmjxuqdtp.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends w {
    public final long a;
    public final boolean b;
    public final boolean c;
    public HashSet d;
    public final LinkedHashSet e = new LinkedHashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n1 f539f = new n1(q3.o.d, x0.d);
    public final /* synthetic */ s g;

    public q(s sVar, long j2, boolean z, boolean z2, ru1.c cVar) {
        this.g = sVar;
        this.a = j2;
        this.b = z;
        this.c = z2;
    }

    @Override // tlydtdl.compose.runtime.w
    public final void a(z zVar, Function2 function2) {
        this.g.b.a(zVar, function2);
    }

    @Override // tlydtdl.compose.runtime.w
    public final q1.o0 b(z zVar, m2 m2Var, Function2 function2) {
        return this.g.b.b(zVar, m2Var, function2);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void c(c1 c1Var) {
        this.g.b.c(c1Var);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void d() {
        s sVar = this.g;
        sVar.A--;
    }

    @Override // tlydtdl.compose.runtime.w
    public final boolean e() {
        return this.g.b.e();
    }

    @Override // tlydtdl.compose.runtime.w
    public final boolean f() {
        return this.b;
    }

    @Override // tlydtdl.compose.runtime.w
    public final boolean g() {
        return this.c;
    }

    @Override // tlydtdl.compose.runtime.w
    public final long h() {
        return this.a;
    }

    @Override // tlydtdl.compose.runtime.w
    public final v i() {
        return this.g.h;
    }

    @Override // tlydtdl.compose.runtime.w
    public final u1 j() {
        return (u1) this.f539f.getValue();
    }

    @Override // tlydtdl.compose.runtime.w
    public final qx1.i k() {
        return this.g.b.k();
    }

    @Override // tlydtdl.compose.runtime.w
    public final void l(c1 c1Var) {
        this.g.b.l(c1Var);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void m(z zVar) {
        s sVar = this.g;
        sVar.b.m(sVar.h);
        sVar.b.m(zVar);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void n(c1 c1Var, b1 b1Var, c cVar) {
        this.g.b.n(c1Var, b1Var, cVar);
    }

    @Override // tlydtdl.compose.runtime.w
    public final b1 o(c1 c1Var) {
        return this.g.b.o(c1Var);
    }

    @Override // tlydtdl.compose.runtime.w
    public final q1.o0 p(z zVar, m2 m2Var, q1.o0 o0Var) {
        return this.g.b.p(zVar, m2Var, o0Var);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void q(Set set) {
        HashSet hashSet = this.d;
        if (hashSet == null) {
            hashSet = new HashSet();
            this.d = hashSet;
        }
        hashSet.add(set);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void r(s sVar) {
        this.e.add(sVar);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void s(a2 a2Var) {
        this.g.b.s(a2Var);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void t(z zVar) {
        this.g.b.t(zVar);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void u() {
        this.g.A++;
    }

    @Override // tlydtdl.compose.runtime.w
    public final void v(m mVar) {
        HashSet<Set> hashSet = this.d;
        if (hashSet != null) {
            for (Set set : hashSet) {
                lmjxuqdtp.jvm.internal.o.f(mVar, "null cannot be cast to non-null type tlydtdl.compose.runtime.ComposerImpl");
                set.remove(((s) mVar).c);
            }
        }
        LinkedHashSet linkedHashSet = this.e;
        lmjxuqdtp.jvm.internal.g0.a(linkedHashSet);
        linkedHashSet.remove(mVar);
    }

    @Override // tlydtdl.compose.runtime.w
    public final void w(z zVar) {
        this.g.b.w(zVar);
    }

    public final void x() {
        LinkedHashSet<s> linkedHashSet = this.e;
        if (linkedHashSet.isEmpty()) {
            return;
        }
        HashSet hashSet = this.d;
        if (hashSet != null) {
            for (s sVar : linkedHashSet) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((Set) it.next()).remove(sVar.c);
                }
            }
        }
        linkedHashSet.clear();
    }
}
