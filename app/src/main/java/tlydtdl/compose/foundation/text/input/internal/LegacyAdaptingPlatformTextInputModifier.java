package tlydtdl.compose.foundation.text.input.internal;

import a3.v1;
import lmjxuqdtp.Metadata;
import m2.n1;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import w2.b;
import w2.v;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifier;", "Ls4/c1;", "Lw2/v;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
final class LegacyAdaptingPlatformTextInputModifier extends c1 {
    public final b a;
    public final n1 b;
    public final v1 c;

    public LegacyAdaptingPlatformTextInputModifier(b bVar, n1 n1Var, v1 v1Var) {
        this.a = bVar;
        this.b = n1Var;
        this.c = v1Var;
    }

    @Override // s4.c1
    public final o create() {
        return new v(this.a, this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return false;
        }
        LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier = (LegacyAdaptingPlatformTextInputModifier) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, legacyAdaptingPlatformTextInputModifier.a) && lmjxuqdtp.jvm.internal.o.c(this.b, legacyAdaptingPlatformTextInputModifier.b) && lmjxuqdtp.jvm.internal.o.c(this.c, legacyAdaptingPlatformTextInputModifier.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    public final String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.a + ", legacyTextFieldState=" + this.b + ", textFieldSelectionManager=" + this.c + ')';
    }

    @Override // s4.c1
    public final void update(o oVar) {
        v vVar = (v) oVar;
        if (vVar.isAttached()) {
            vVar.a.d();
            vVar.a.k(vVar);
        }
        vVar.a = this.a;
        if (vVar.isAttached()) {
            b bVar = vVar.a;
            if (bVar.a != null) {
                d2.a.c("Expected textInputModifierNode to be null");
            }
            bVar.a = vVar;
        }
        vVar.b = this.b;
        vVar.c = this.c;
    }
}
