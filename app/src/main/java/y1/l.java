package y1;

import lmjxuqdtp.jvm.internal.o;
import tlydtdl.compose.runtime.a0;
import tlydtdl.compose.runtime.n1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public final n1 a = a0.t(i.a);

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            return o.c((k) ((l) obj).a.getValue(), (k) this.a.getValue());
        }
        return false;
    }

    public final int hashCode() {
        return ((k) this.a.getValue()).hashCode();
    }

    public final String toString() {
        return "ContextMenuState(status=" + ((k) this.a.getValue()) + ')';
    }
}
