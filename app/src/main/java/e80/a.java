package e80;

import a2.q3;
import gt.b;
import java.util.ArrayList;
import lmjxuqdtp.jvm.internal.o;
import q.q2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final u00.a a;
    public final ArrayList b;
    public final int c;
    public final b d;
    public final q3 e;

    public a(u00.a aVar, ArrayList arrayList, int i, b bVar, q3 q3Var) {
        o.h(bVar, "selectedTab");
        this.a = aVar;
        this.b = arrayList;
        this.c = i;
        this.d = bVar;
        this.e = q3Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a.equals(aVar.a) && this.b.equals(aVar.b) && this.c == aVar.c && this.d == aVar.d && this.e.equals(aVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + ((this.d.hashCode() + s1.a.c(this.c, q2.f(this.b, this.a.hashCode() * 31, 31), 31)) * 31);
    }

    public final String toString() {
        return "FeedPagerData(pagerState=" + this.a + ", tabs=" + this.b + ", selectedTabIndex=" + this.c + ", selectedTab=" + this.d + ", onPageChange=" + this.e + ")";
    }
}
