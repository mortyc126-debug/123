package u10;

import java.util.List;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public final boolean a;
    public final List b;
    public final t10.c c;

    public q(boolean z, List list, t10.c cVar) {
        o.h(list, "shortcutItems");
        this.a = z;
        this.b = list;
        this.c = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.a == qVar.a && o.c(this.b, qVar.b) && o.c(this.c, qVar.c);
    }

    public final int hashCode() {
        int iD = i.d(this.b, Boolean.hashCode(this.a) * 31, 31);
        t10.c cVar = this.c;
        return iD + (cVar == null ? 0 : cVar.hashCode());
    }

    public final String toString() {
        return "ShortcutState(showPopup=" + this.a + ", shortcutItems=" + this.b + ", anchor=" + this.c + ")";
    }
}
