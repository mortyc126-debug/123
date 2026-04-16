package v2;

import f3.f2;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements m {
    public final int a;

    public k(int i, int i2) {
        i = (i2 & 2) != 0 ? IntCompanionObject.MAX_VALUE : i;
        this.a = i;
        if (1 <= i) {
            return;
        }
        d2.a.a("Expected 1 ≤ minHeightInLines ≤ maxHeightInLines, were 1, " + i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && k.class == obj.getClass() && this.a == ((k) obj).a;
    }

    public final int hashCode() {
        return 31 + this.a;
    }

    public final String toString() {
        return f2.l(new StringBuilder("MultiLine(minHeightInLines=1, maxHeightInLines="), this.a, ')');
    }
}
