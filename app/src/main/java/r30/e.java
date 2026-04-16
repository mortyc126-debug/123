package r30;

import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class e {
    public static final d Companion = new d();
    public static final lx1.h[] c = {null, hs1.d.E(lx1.j.a, new qr.a(13))};
    public final String a;
    public final List b;

    public /* synthetic */ e(String str, List list, int i) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = list;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return o.c(this.a, eVar.a) && o.c(this.b, eVar.b);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List list = this.b;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "Param(bandId=" + this.a + ", collaborators=" + this.b + ")";
    }

    public e(List list) {
        this.a = null;
        this.b = list;
    }
}
