package ig0;

import lmjxuqdtp.jvm.functions.Function0;
import x10.r;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final r a;
    public final Function0 b;

    public a(r rVar, Function0 function0) {
        this.a = rVar;
        this.b = function0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.equals(aVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a.e) * 31);
    }

    public final String toString() {
        return "AutoMixGenreItem(title=" + this.a + ", onClick=" + this.b + ")";
    }
}
