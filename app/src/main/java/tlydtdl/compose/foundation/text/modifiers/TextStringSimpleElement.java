package tlydtdl.compose.foundation.text.modifiers;

import a4.b0;
import d5.q0;
import h5.h;
import lmjxuqdtp.Metadata;
import q.q2;
import s1.a;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/modifiers/TextStringSimpleElement;", "Ls4/c1;", "Lz2/m;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class TextStringSimpleElement extends c1 {
    public final String a;
    public final q0 b;
    public final h c;
    public final int d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f520f;
    public final int g;
    public final b0 h;

    public TextStringSimpleElement(String str, q0 q0Var, h hVar, int i, boolean z, int i2, int i3, b0 b0Var) {
        this.a = str;
        this.b = q0Var;
        this.c = hVar;
        this.d = i;
        this.e = z;
        this.f520f = i2;
        this.g = i3;
        this.h = b0Var;
    }

    @Override // s4.c1
    public final o create() {
        z2.m mVar = new z2.m();
        mVar.a = this.a;
        mVar.b = this.b;
        mVar.c = this.c;
        mVar.d = this.d;
        mVar.e = this.e;
        mVar.f = this.f520f;
        mVar.g = this.g;
        mVar.h = this.h;
        return mVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStringSimpleElement)) {
            return false;
        }
        TextStringSimpleElement textStringSimpleElement = (TextStringSimpleElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.h, textStringSimpleElement.h) && lmjxuqdtp.jvm.internal.o.c(this.a, textStringSimpleElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, textStringSimpleElement.b) && lmjxuqdtp.jvm.internal.o.c(this.c, textStringSimpleElement.c) && this.d == textStringSimpleElement.d && this.e == textStringSimpleElement.e && this.f520f == textStringSimpleElement.f520f && this.g == textStringSimpleElement.g;
    }

    public final int hashCode() {
        int iF = (((a.f(a.c(this.d, (this.c.hashCode() + q2.a(this.a.hashCode() * 31, 31, this.b)) * 31, 31), 31, this.e) + this.f520f) * 31) + this.g) * 31;
        b0 b0Var = this.h;
        return iF + (b0Var != null ? b0Var.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // s4.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(t3.o r12) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.text.modifiers.TextStringSimpleElement.update(t3.o):void");
    }
}
