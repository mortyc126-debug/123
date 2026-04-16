package kb;

import com.gnacba.ads.interactivemedia.v3.internal.a;
import ct1.b;
import java.util.List;
import mx1.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final List a;
    public final int b;

    public f(List list, int i) {
        this.a = list;
        this.b = i;
        if (list.isEmpty() && i == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i >= 0 && i < size) {
                return;
            }
        }
        StringBuilder sbR = o6.c.r(i, "Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '", "', bounds = '");
        sbR.append(b.x(list));
        sbR.append("'.");
        throw new IllegalArgumentException(sbR.toString().toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.b == fVar.b && lmjxuqdtp.jvm.internal.o.c(this.a, fVar.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavigationEventHistory(currentIndex=");
        sb.append(this.b);
        sb.append(", mergedHistory=");
        return a.j(sb, this.a, ')');
    }

    public f() {
        this(t.a, -1);
    }
}
