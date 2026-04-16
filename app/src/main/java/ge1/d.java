package ge1;

import a2.w3;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.internal.o;
import ny1.p2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final w3 a;
    public final p2 b;
    public final Function1 c;
    public final Function1 d;

    public d(w3 w3Var, p2 p2Var, Function1 function1, Function1 function12) {
        o.h(w3Var, "scrollableState");
        this.a = w3Var;
        this.b = p2Var;
        this.c = function1;
        this.d = function12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return o.c(this.a, dVar.a) && o.c(this.b, dVar.b) && o.c(this.c, dVar.c) && o.c(this.d, dVar.d);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        p2 p2Var = this.b;
        int iHashCode2 = (iHashCode + (p2Var == null ? 0 : p2Var.hashCode())) * 31;
        Function1 function1 = this.c;
        int iHashCode3 = (iHashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Function1 function12 = this.d;
        return iHashCode3 + (function12 != null ? function12.hashCode() : 0);
    }

    public final String toString() {
        return "ImpressionDetectorState(scrollableState=" + this.a + ", onRefreshedEvent=" + this.b + ", onItemImpressed=" + this.c + ", onNthItemViewed=" + this.d + ")";
    }

    public /* synthetic */ d(w3 w3Var, p2 p2Var, Function1 function1, Function1 function12, int i) {
        this(w3Var, (i & 2) != 0 ? null : p2Var, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12);
    }
}
