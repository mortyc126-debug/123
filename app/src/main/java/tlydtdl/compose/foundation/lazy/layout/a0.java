package tlydtdl.compose.foundation.lazy.layout;

import java.util.ArrayList;
import lmjxuqdtp.KotlinNothingValueException;
import t3.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends o implements s4.q {
    public d0 a;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && lmjxuqdtp.jvm.internal.o.c(this.a, ((a0) obj).a);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.KotlinNothingValueException */
    @Override // s4.q
    public final void g(s4.l0 l0Var) throws KotlinNothingValueException {
        c4.b bVar = l0Var.a;
        ArrayList arrayList = this.a.i;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            y yVar = (y) arrayList.get(i);
            d4.c cVar = yVar.n;
            if (cVar != null) {
                long j2 = yVar.m;
                long j3 = cVar.t;
                float f2 = ((int) (j2 >> 32)) - ((int) (j3 >> 32));
                float f3 = ((int) (j2 & 4294967295L)) - ((int) (j3 & 4294967295L));
                ((ru1.c) bVar.b.c).v(f2, f3);
                try {
                    ln1.e.q(l0Var, cVar);
                } finally {
                    ((ru1.c) bVar.b.c).v(-f2, -f3);
                }
            }
        }
        l0Var.b();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void onAttach() {
        this.a.f502j = this;
    }

    public final void onDetach() {
        d0 d0Var = this.a;
        d0Var.e();
        d0Var.b = null;
        d0Var.c = -1;
    }

    public final String toString() {
        return "DisplayingDisappearingItemsNode(animator=" + this.a + ')';
    }
}
