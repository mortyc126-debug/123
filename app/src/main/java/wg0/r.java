package wg0;

import az1.b2;
import s1.a;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class r {
    public static final q Companion = new q();
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f657f;

    public r(String str, String str2, String str3, boolean z, boolean z2, Integer num) {
        lmjxuqdtp.jvm.internal.o.h(str, "id");
        lmjxuqdtp.jvm.internal.o.h(str2, "name");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = z2;
        this.f657f = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, rVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, rVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, rVar.c) && this.d == rVar.d && this.e == rVar.e && lmjxuqdtp.jvm.internal.o.c(this.f657f, rVar.f657f);
    }

    public final int hashCode() {
        int iD = a.d(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        int iF = a.f(a.f((iD + (str == null ? 0 : str.hashCode())) * 31, 31, this.d), 31, this.e);
        Integer num = this.f657f;
        return iF + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("Voice(id=", f.a(this.a), ", name=", this.b, ", pictureUrl=");
        o6.c.z(this.c, ", isSelected=", ", isNew=", sbJ, this.d);
        sbJ.append(this.e);
        sbJ.append(", color=");
        sbJ.append(this.f657f);
        sbJ.append(")");
        return sbJ.toString();
    }

    public /* synthetic */ r(int i, String str, String str2, String str3, boolean z, boolean z2, Integer num) {
        if (63 != (i & 63)) {
            b2.b(i, 63, p.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = z2;
        this.f657f = num;
    }
}
