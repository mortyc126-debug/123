package rg1;

import az1.b2;
import hs1.d;
import java.util.ArrayList;
import java.util.List;
import lmjxuqdtp.jvm.internal.o;
import lx1.h;
import qr.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class c {
    public static final b Companion = new b();
    public static final h[] g;
    public final boolean a;
    public final String b;
    public final String c;
    public final List d;
    public final Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f420f;

    static {
        lx1.j jVar = lx1.j.a;
        g = new h[]{null, null, null, d.E(jVar, new a(16)), null, d.E(jVar, new a(17))};
    }

    public /* synthetic */ c(int i, boolean z, String str, String str2, List list, Integer num, List list2) {
        if (63 != (i & 63)) {
            b2.b(i, 63, a.a.getDescriptor());
            throw null;
        }
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = list;
        this.e = num;
        this.f420f = list2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && o.c(this.b, cVar.b) && o.c(this.c, cVar.c) && o.c(this.d, cVar.d) && o.c(this.e, cVar.e) && o.c(this.f420f, cVar.f420f);
    }

    public final int hashCode() {
        int iD = i.d(this.d, s1.a.d(s1.a.d(Boolean.hashCode(this.a) * 31, 31, this.b), 31, this.c), 31);
        Integer num = this.e;
        int iHashCode = (iD + (num == null ? 0 : num.hashCode())) * 31;
        List list = this.f420f;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "CampaignInfo(active=" + this.a + ", target=" + this.b + ", title=" + this.c + ", triggers=" + this.d + ", frequency=" + this.e + ", reasons=" + this.f420f + ")";
    }

    public c(boolean z, String str, String str2, ArrayList arrayList, Integer num, ArrayList arrayList2) {
        o.h(str, "target");
        o.h(str2, "title");
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = arrayList;
        this.e = num;
        this.f420f = arrayList2;
    }
}
