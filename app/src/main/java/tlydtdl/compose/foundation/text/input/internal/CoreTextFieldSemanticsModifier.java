package tlydtdl.compose.foundation.text.input.internal;

import a3.v1;
import d5.p0;
import i5.d0;
import i5.k;
import i5.q;
import i5.w;
import lmjxuqdtp.Metadata;
import m2.n1;
import s4.c1;
import s4.g;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import u50.u;
import w2.l;
import w2.n;
import y3.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/input/internal/CoreTextFieldSemanticsModifier;", "Ls4/c1;", "Lw2/n;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class CoreTextFieldSemanticsModifier extends c1 {
    public final d0 a;
    public final w b;
    public final n1 c;
    public final boolean d;
    public final q e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final v1 f513f;
    public final k g;
    public final t h;

    public CoreTextFieldSemanticsModifier(d0 d0Var, w wVar, n1 n1Var, boolean z, q qVar, v1 v1Var, k kVar, t tVar) {
        this.a = d0Var;
        this.b = wVar;
        this.c = n1Var;
        this.d = z;
        this.e = qVar;
        this.f513f = v1Var;
        this.g = kVar;
        this.h = tVar;
    }

    @Override // s4.c1
    public final o create() {
        n nVar = new n();
        nVar.c = this.a;
        nVar.d = this.b;
        nVar.e = this.c;
        nVar.f = this.d;
        nVar.g = this.e;
        v1 v1Var = this.f513f;
        nVar.h = v1Var;
        nVar.i = this.g;
        nVar.j = this.h;
        v1Var.f = new l(nVar, 3);
        return nVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoreTextFieldSemanticsModifier)) {
            return false;
        }
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = (CoreTextFieldSemanticsModifier) obj;
        return this.a.equals(coreTextFieldSemanticsModifier.a) && lmjxuqdtp.jvm.internal.o.c(this.b, coreTextFieldSemanticsModifier.b) && this.c.equals(coreTextFieldSemanticsModifier.c) && this.d == coreTextFieldSemanticsModifier.d && lmjxuqdtp.jvm.internal.o.c(this.e, coreTextFieldSemanticsModifier.e) && this.f513f.equals(coreTextFieldSemanticsModifier.f513f) && lmjxuqdtp.jvm.internal.o.c(this.g, coreTextFieldSemanticsModifier.g) && lmjxuqdtp.jvm.internal.o.c(this.h, coreTextFieldSemanticsModifier.h);
    }

    public final int hashCode() {
        return this.h.hashCode() + ((this.g.hashCode() + ((this.f513f.hashCode() + ((this.e.hashCode() + s1.a.f(s1.a.f(s1.a.f((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31, 31, false), 31, this.d), 31, false)) * 31)) * 31)) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    public final String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.a + ", value=" + this.b + ", state=" + this.c + ", readOnly=false, enabled=" + this.d + ", isPassword=false, offsetMapping=" + this.e + ", manager=" + this.f513f + ", imeOptions=" + this.g + ", focusRequester=" + this.h + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        n nVar = (n) oVar;
        boolean z = nVar.f;
        k kVar = nVar.i;
        v1 v1Var = nVar.h;
        nVar.c = this.a;
        w wVar = this.b;
        nVar.d = wVar;
        nVar.e = this.c;
        boolean z2 = this.d;
        nVar.f = z2;
        nVar.g = this.e;
        v1 v1Var2 = this.f513f;
        nVar.h = v1Var2;
        k kVar2 = this.g;
        nVar.i = kVar2;
        nVar.j = this.h;
        if (z2 != z || z2 != z || !lmjxuqdtp.jvm.internal.o.c(kVar2, kVar) || !p0.d(wVar.b)) {
            g.u(nVar).G();
        }
        if (v1Var2.equals(v1Var)) {
            return;
        }
        v1Var2.f = new u(16, nVar);
    }
}
