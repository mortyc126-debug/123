package b60;

import az1.b2;
import hs1.d;
import java.util.List;
import md1.b1;
import o6.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class h {
    public static final b Companion = new b();
    public static final lx1.h[] g;
    public final c60.b a;
    public final List b;
    public final Integer c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17f;

    static {
        lx1.j jVar = lx1.j.a;
        g = new lx1.h[]{d.E(jVar, new g(22)), d.E(jVar, new g(23)), null, null, null, null};
    }

    public /* synthetic */ h(int i, c60.b bVar, List list, Integer num, String str, String str2, String str3) {
        if (63 != (i & 63)) {
            b2.b(i, 63, a.a.getDescriptor());
            throw null;
        }
        this.a = bVar;
        this.b = list;
        this.c = num;
        this.d = str;
        this.e = str2;
        this.f17f = str3;
    }

    public final String a() {
        String str;
        c60.b bVar = this.a;
        if (bVar == null || (str = this.f17f) == null) {
            return null;
        }
        return b1.j(bVar.name(), "_", str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.a == hVar.a && lmjxuqdtp.jvm.internal.o.c(this.b, hVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, hVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, hVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, hVar.e) && lmjxuqdtp.jvm.internal.o.c(this.f17f, hVar.f17f);
    }

    public final int hashCode() {
        c60.b bVar = this.a;
        int iHashCode = (bVar == null ? 0 : bVar.hashCode()) * 31;
        List list = this.b;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.d;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f17f;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EasterEgg(id=");
        sb.append(this.a);
        sb.append(", links=");
        sb.append(this.b);
        sb.append(", animationSize=");
        sb.append(this.c);
        sb.append(", animationUrl=");
        sb.append(this.d);
        sb.append(", crackAnimationUrl=");
        return c.p(sb, this.e, ", key=", this.f17f, ")");
    }
}
