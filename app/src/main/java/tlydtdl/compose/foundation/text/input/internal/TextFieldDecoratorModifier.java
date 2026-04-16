package tlydtdl.compose.foundation.text.input.internal;

import lmjxuqdtp.Metadata;
import m2.m1;
import ny1.y1;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import v2.c;
import v2.e;
import w2.r0;
import w2.y0;
import x2.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/input/internal/TextFieldDecoratorModifier;", "Ls4/c1;", "Lw2/r0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class TextFieldDecoratorModifier extends c1 {
    public final w2.c1 a;
    public final y0 b;
    public final y c;
    public final c d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f516f;
    public final m1 g;
    public final e h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c2.m f517j;
    public final y1 k;

    public TextFieldDecoratorModifier(w2.c1 c1Var, y0 y0Var, y yVar, c cVar, boolean z, boolean z2, m1 m1Var, e eVar, boolean z3, c2.m mVar, y1 y1Var) {
        this.a = c1Var;
        this.b = y0Var;
        this.c = yVar;
        this.d = cVar;
        this.e = z;
        this.f516f = z2;
        this.g = m1Var;
        this.h = eVar;
        this.i = z3;
        this.f517j = mVar;
        this.k = y1Var;
    }

    @Override // s4.c1
    public final o create() {
        return new r0(this.a, this.b, this.c, this.d, this.e, this.f516f, this.g, this.h, this.i, this.f517j, this.k);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldDecoratorModifier)) {
            return false;
        }
        TextFieldDecoratorModifier textFieldDecoratorModifier = (TextFieldDecoratorModifier) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, textFieldDecoratorModifier.a) && lmjxuqdtp.jvm.internal.o.c(this.b, textFieldDecoratorModifier.b) && lmjxuqdtp.jvm.internal.o.c(this.c, textFieldDecoratorModifier.c) && lmjxuqdtp.jvm.internal.o.c(this.d, textFieldDecoratorModifier.d) && this.e == textFieldDecoratorModifier.e && this.f516f == textFieldDecoratorModifier.f516f && this.g.equals(textFieldDecoratorModifier.g) && lmjxuqdtp.jvm.internal.o.c(this.h, textFieldDecoratorModifier.h) && this.i == textFieldDecoratorModifier.i && lmjxuqdtp.jvm.internal.o.c(this.f517j, textFieldDecoratorModifier.f517j) && lmjxuqdtp.jvm.internal.o.c(this.k, textFieldDecoratorModifier.k);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        c cVar = this.d;
        int iHashCode2 = (this.g.hashCode() + s1.a.f(s1.a.f((iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31, 31, this.e), 31, this.f516f)) * 31;
        e eVar = this.h;
        int iF = s1.a.f((this.f517j.hashCode() + s1.a.f((iHashCode2 + (eVar == null ? 0 : eVar.hashCode())) * 31, 31, this.i)) * 31, 31, false);
        y1 y1Var = this.k;
        return iF + (y1Var != null ? y1Var.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    public final String toString() {
        return "TextFieldDecoratorModifier(textFieldState=" + this.a + ", textLayoutState=" + this.b + ", textFieldSelectionState=" + this.c + ", filter=" + this.d + ", enabled=" + this.e + ", readOnly=" + this.f516f + ", keyboardOptions=" + this.g + ", keyboardActionHandler=" + this.h + ", singleLine=" + this.i + ", interactionSource=" + this.f517j + ", isPassword=false, stylusHandwritingTrigger=" + this.k + ')';
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
    @Override // s4.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(t3.o r19) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.text.input.internal.TextFieldDecoratorModifier.update(t3.o):void");
    }
}
