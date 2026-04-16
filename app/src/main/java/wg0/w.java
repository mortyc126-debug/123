package wg0;

import az1.b2;
import java.util.List;
import s1.a;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class w {
    public static final v Companion = new v();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final lx1.h[] f658f = {null, null, null, null, hs1.d.E(lx1.j.a, new vb.z(16))};
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final List e;

    public w(String str, String str2, String str3, String str4, List list) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        lmjxuqdtp.jvm.internal.o.h(str2, "name");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, wVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, wVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, wVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, wVar.d) && lmjxuqdtp.jvm.internal.o.c(this.e, wVar.e);
    }

    public final int hashCode() {
        int iD = a.d(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        return this.e.hashCode() + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("Voice(id=", f.a(this.a), ", name=", this.b, ", description=");
        a.y(sbJ, this.c, ", pictureUrl=", this.d, ", tags=");
        return p.h(sbJ, this.e, ")");
    }

    public /* synthetic */ w(int i, String str, String str2, String str3, String str4, List list) {
        if (31 != (i & 31)) {
            b2.b(i, 31, u.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = list;
    }
}
