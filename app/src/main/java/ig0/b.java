package ig0;

import java.util.List;
import kd1.g;
import lmjxuqdtp.jvm.internal.o;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final boolean a;
    public final g b;
    public final List c;

    public b(boolean z, g gVar, List list) {
        o.h(gVar, "tooltip");
        o.h(list, "genres");
        this.a = z;
        this.b = gVar;
        this.c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && o.c(this.b, bVar.b) && o.c(this.c, bVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (Boolean.hashCode(this.a) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AutoMixTracksControlState(showMembershipIcon=");
        sb.append(this.a);
        sb.append(", tooltip=");
        sb.append(this.b);
        sb.append(", genres=");
        return p.h(sb, this.c, ")");
    }
}
