package gp;

import az1.b2;
import hs1.d;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class c0 implements o0 {
    public static final b0 Companion = new b0();
    public static final lx1.h[] b = {d.E(lx1.j.a, new fx0.a0(22))};
    public final pp.q a;

    public /* synthetic */ c0(int i, pp.q qVar) {
        if (1 == (i & 1)) {
            this.a = qVar;
        } else {
            b2.b(i, 1, a0.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c0) && o.c(this.a, ((c0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "AgeVerificationScreen(signupInfo=" + this.a + ")";
    }

    public c0(pp.q qVar) {
        o.h(qVar, "signupInfo");
        this.a = qVar;
    }
}
