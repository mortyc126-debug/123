package tlydtdl.compose.foundation.text.modifiers;

import a4.b0;
import d5.g;
import d5.q0;
import h5.h;
import java.util.List;
import lmjxuqdtp.Metadata;
import lmjxuqdtp.jvm.functions.Function1;
import q.q2;
import s1.a;
import s4.c1;
import t3.o;
import t4.e2;
import tlydtdl.compose.foundation.layout.m;
import z2.j;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Ltlydtdl/compose/foundation/text/modifiers/TextAnnotatedStringElement;", "Ls4/c1;", "Lz2/j;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = m.g)
public final class TextAnnotatedStringElement extends c1 {
    public final g a;
    public final q0 b;
    public final h c;
    public final Function1 d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f518f;
    public final int g;
    public final int h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1 f519j;
    public final b0 k;
    public final m2.g l;
    public final Function1 m;

    public TextAnnotatedStringElement(g gVar, q0 q0Var, h hVar, Function1 function1, int i, boolean z, int i2, int i3, List list, Function1 function12, b0 b0Var, m2.g gVar2, Function1 function13) {
        this.a = gVar;
        this.b = q0Var;
        this.c = hVar;
        this.d = function1;
        this.e = i;
        this.f518f = z;
        this.g = i2;
        this.h = i3;
        this.i = list;
        this.f519j = function12;
        this.k = b0Var;
        this.l = gVar2;
        this.m = function13;
    }

    @Override // s4.c1
    public final o create() {
        j jVar = new j();
        jVar.a = this.a;
        jVar.b = this.b;
        jVar.c = this.c;
        jVar.d = this.d;
        jVar.e = this.e;
        jVar.f = this.f518f;
        jVar.g = this.g;
        jVar.h = this.h;
        jVar.i = this.i;
        jVar.j = this.f519j;
        jVar.k = this.k;
        jVar.l = this.l;
        jVar.m = this.m;
        return jVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextAnnotatedStringElement)) {
            return false;
        }
        TextAnnotatedStringElement textAnnotatedStringElement = (TextAnnotatedStringElement) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.k, textAnnotatedStringElement.k) && lmjxuqdtp.jvm.internal.o.c(this.a, textAnnotatedStringElement.a) && lmjxuqdtp.jvm.internal.o.c(this.b, textAnnotatedStringElement.b) && lmjxuqdtp.jvm.internal.o.c(this.i, textAnnotatedStringElement.i) && lmjxuqdtp.jvm.internal.o.c(this.c, textAnnotatedStringElement.c) && this.d == textAnnotatedStringElement.d && this.m == textAnnotatedStringElement.m && this.e == textAnnotatedStringElement.e && this.f518f == textAnnotatedStringElement.f518f && this.g == textAnnotatedStringElement.g && this.h == textAnnotatedStringElement.h && this.f519j == textAnnotatedStringElement.f519j;
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + q2.a(this.a.hashCode() * 31, 31, this.b)) * 31;
        Function1 function1 = this.d;
        int iF = (((a.f(a.c(this.e, (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31, 31), 31, this.f518f) + this.g) * 31) + this.h) * 31;
        List list = this.i;
        int iHashCode2 = (iF + (list != null ? list.hashCode() : 0)) * 31;
        Function1 function12 = this.f519j;
        int iHashCode3 = (iHashCode2 + (function12 != null ? function12.hashCode() : 0)) * 961;
        b0 b0Var = this.k;
        int iHashCode4 = (iHashCode3 + (b0Var != null ? b0Var.hashCode() : 0)) * 31;
        Function1 function13 = this.m;
        return iHashCode4 + (function13 != null ? function13.hashCode() : 0);
    }

    @Override // s4.c1
    public final void inspectableProperties(e2 e2Var) {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    @Override // s4.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void update(t3.o r15) {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.text.modifiers.TextAnnotatedStringElement.update(t3.o):void");
    }
}
