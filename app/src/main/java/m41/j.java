package m41;

import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.internal.o;
import ls0.t;
import q10.l0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public static final j g = new j(l0.d, new t(18), false, null, false, new t(18));
    public final l0 a;
    public final Function0 b;
    public final boolean c;
    public final Integer d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0 f323f;

    public j(l0 l0Var, Function0 function0, boolean z, Integer num, boolean z2, Function0 function02) {
        this.a = l0Var;
        this.b = function0;
        this.c = z;
        this.d = num;
        this.e = z2;
        this.f323f = function02;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && this.b.equals(jVar.b) && this.c == jVar.c && o.c(this.d, jVar.d) && this.e == jVar.e && this.f323f.equals(jVar.f323f);
    }

    public final int hashCode() {
        l0 l0Var = this.a;
        int iF = s1.a.f(s1.a.e((l0Var == null ? 0 : l0Var.hashCode()) * 31, 31, this.b), 31, this.c);
        Integer num = this.d;
        return this.f323f.hashCode() + s1.a.f((iF + (num != null ? num.hashCode() : 0)) * 31, 31, this.e);
    }

    public final String toString() {
        return "FollowState(followingState=" + this.a + ", onClickAction=" + this.b + ", isEnabled=" + this.c + ", followStateIcon=" + this.d + ", isSubscriber=" + this.e + ", onSubscribeClickAction=" + this.f323f + ")";
    }
}
