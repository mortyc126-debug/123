package u10;

import ck0.d;
import com.gnacba.ads.interactivemedia.v3.internal.a;
import x10.l;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    public final oy1.k a;
    public final l b;
    public final d c;

    public s(oy1.k kVar, l lVar, d dVar) {
        this.a = kVar;
        this.b = lVar;
        this.c = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.a.equals(sVar.a) && this.b.equals(sVar.b) && this.c.equals(sVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + a.c(this.a.hashCode() * 31, 31, this.b.e);
    }

    public final String toString() {
        return "TabBarBannerState(visible=" + this.a + ", title=" + this.b + ", onClick=" + this.c + ")";
    }
}
