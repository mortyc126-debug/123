package rg1;

import az1.b2;
import hs1.d;
import java.util.Map;
import lmjxuqdtp.jvm.internal.o;
import lx1.h;
import qr.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class f {
    public static final e Companion = new e();
    public static final h[] c = {null, d.E(lx1.j.a, new a(18))};
    public final String a;
    public final Map b;

    public /* synthetic */ f(String str, int i, Map map) {
        if (3 != (i & 3)) {
            b2.b(i, 3, d.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return o.c(this.a, fVar.a) && o.c(this.b, fVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "CampaignTrigger(name=" + this.a + ", params=" + this.b + ")";
    }

    public f(String str, Map map) {
        o.h(str, "name");
        this.a = str;
        this.b = map;
    }
}
