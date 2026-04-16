package rd1;

import lmjxuqdtp.jvm.functions.Function0;
import ny1.p2;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements vu0.d {
    public final String a;
    public final p2 b;
    public final p2 c;
    public final ny1.l d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p2 f416f;
    public final ny1.l g;
    public final Function0 h;

    public v0(String str, p2 p2Var, p2 p2Var2, ny1.l lVar, boolean z, p2 p2Var3, ny1.l lVar2, Function0 function0) {
        lmjxuqdtp.jvm.internal.o.h(p2Var, "playing");
        lmjxuqdtp.jvm.internal.o.h(p2Var2, "loading");
        lmjxuqdtp.jvm.internal.o.h(p2Var3, "visible");
        lmjxuqdtp.jvm.internal.o.h(lVar2, "errorMessages");
        this.a = str;
        this.b = p2Var;
        this.c = p2Var2;
        this.d = lVar;
        this.e = z;
        this.f416f = p2Var3;
        this.g = lVar2;
        this.h = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, v0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, v0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, v0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, v0Var.d) && this.e == v0Var.e && lmjxuqdtp.jvm.internal.o.c(this.f416f, v0Var.f416f) && lmjxuqdtp.jvm.internal.o.c(this.g, v0Var.g) && lmjxuqdtp.jvm.internal.o.c(this.h, v0Var.h);
    }

    public final String getId() {
        return this.a;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (this.g.hashCode() + q2.h(this.f416f, s1.a.f((this.d.hashCode() + q2.h(this.c, q2.h(this.b, (str == null ? 0 : str.hashCode()) * 31, 31), 31)) * 31, 31, this.e), 31)) * 31;
        Function0 function0 = this.h;
        return iHashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public final String toString() {
        return "PlayerButtonState(id=" + this.a + ", playing=" + this.b + ", loading=" + this.c + ", progress=" + this.d + ", enabled=" + this.e + ", visible=" + this.f416f + ", errorMessages=" + this.g + ", onClick=" + this.h + ")";
    }
}
