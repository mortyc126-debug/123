package cf1;

import a2.r2;
import a4.a1;
import by1.b;
import com.gnacba.ads.interactivemedia.v3.internal.a;
import l2.e;
import l2.f;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import md1.g;
import o6.c;
import q.q2;
import tlydtdl.compose.runtime.a2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {
    public final of1.n a;
    public final ld1.r b;
    public final ld1.r c;
    public final a1 d;
    public final x10.v e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1 f35f;

    public h0(of1.n nVar, ld1.r rVar, ld1.r rVar2, x10.v vVar, Function1 function1) {
        e eVarB = f.b(4);
        lmjxuqdtp.jvm.internal.o.h(vVar, "expectedMaxLengthText");
        lmjxuqdtp.jvm.internal.o.h(function1, "textProvider");
        this.a = nVar;
        this.b = rVar;
        this.c = rVar2;
        this.d = eVarB;
        this.e = vVar;
        this.f35f = function1;
    }

    public final void a(tlydtdl.compose.foundation.layout.w wVar, l0 l0Var, tlydtdl.compose.runtime.m mVar, int i) {
        int i2;
        lmjxuqdtp.jvm.internal.o.h(wVar, "scope");
        lmjxuqdtp.jvm.internal.o.h(l0Var, "thumbState");
        tlydtdl.compose.runtime.s sVar = (tlydtdl.compose.runtime.s) mVar;
        sVar.h0(1096204912);
        if ((i & 6) == 0) {
            i2 = (sVar.g(wVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= sVar.g(l0Var) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= sVar.g(this) ? 256 : 128;
        }
        if (sVar.W(i2 & 1, (i2 & 147) != 146)) {
            if (l0Var.a().a()) {
                sVar.f0(1970767466);
                t5.o.a(new d((((long) 0) << 32) | (((long) (-b.P(g.i0(10, sVar)))) & 4294967295L)), (Function0) null, new t5.g0(8, false, false, false), q3.p.d(2002197922, new r2(7, this, l0Var), sVar), sVar, 3456, 2);
            } else {
                sVar.f0(1967447335);
            }
            sVar.r(false);
        } else {
            sVar.Z();
        }
        a2 a2VarV = sVar.v();
        if (a2VarV != null) {
            a2VarV.d = new tlydtdl.compose.foundation.lazy.layout.h0(i, 2, this, wVar, l0Var);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, h0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, h0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, h0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, h0Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, h0Var.e) && lmjxuqdtp.jvm.internal.o.c(this.f35f, h0Var.f35f);
    }

    public final int hashCode() {
        return this.f35f.hashCode() + c.d(q2.c(this.d, a.f(this.c, a.f(this.b, this.a.hashCode() * 31, 31), 31), 31), 31, this.e);
    }

    public final String toString() {
        return "TextAboveThumb(textStyle=" + this.a + ", textColor=" + this.b + ", backgroundColor=" + this.c + ", shape=" + this.d + ", expectedMaxLengthText=" + this.e + ", textProvider=" + this.f35f + ")";
    }
}
