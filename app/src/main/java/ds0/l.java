package ds0;

import com.gnacba.amuvvoafs.gms.internal.ads.cy;
import lmjxuqdtp.jvm.internal.o;
import tlydtdl.compose.foundation.lazy.layout.r1;
import v2.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final float a;
    public final boolean b;
    public final p c;
    public final cy d;
    public final r1 e;

    public l(float f2, boolean z, p pVar, cy cyVar, r1 r1Var) {
        o.h(pVar, "textFieldState");
        o.h(cyVar, "buttonsCallbacks");
        o.h(r1Var, "textCallbacks");
        this.a = f2;
        this.b = z;
        this.c = pVar;
        this.d = cyVar;
        this.e = r1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return hg1.b.a(this.a, lVar.a) && this.b == lVar.b && o.c(this.c, lVar.c) && o.c(this.d, lVar.d) && o.c(this.e, lVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + s1.a.f(Float.hashCode(this.a) * 31, 31, this.b)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbS = bh.j.s("TempoInputUiState(lastValid=", hg1.b.b(this.a), ", isEnabled=", ", textFieldState=", this.b);
        sbS.append(this.c);
        sbS.append(", buttonsCallbacks=");
        sbS.append(this.d);
        sbS.append(", textCallbacks=");
        sbS.append(this.e);
        sbS.append(")");
        return sbS.toString();
    }
}
