package js0;

import az1.b2;
import lmjxuqdtp.jvm.internal.o;
import s1.a;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class a0 {
    public static final z Companion = new z();
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Integer e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f244f;

    public /* synthetic */ a0(int i, String str, String str2, String str3, String str4, Integer num, String str5) {
        if (63 != (i & 63)) {
            b2.b(i, 63, y.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = num;
        this.f244f = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return o.c(this.a, a0Var.a) && o.c(this.b, a0Var.b) && o.c(this.c, a0Var.c) && o.c(this.d, a0Var.d) && o.c(this.e, a0Var.e) && o.c(this.f244f, a0Var.f244f);
    }

    public final int hashCode() {
        int iD = a.d(this.a.hashCode() * 31, 31, this.b);
        String str = this.c;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.e;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.f244f;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = p.j("IdeaParams(revisionId=", this.a, ", midiId=", this.b, ", lyric=");
        a.y(sbJ, this.c, ", key=", this.d, ", bpm=");
        sbJ.append(this.e);
        sbJ.append(", projectName=");
        sbJ.append(this.f244f);
        sbJ.append(")");
        return sbJ.toString();
    }

    public a0(Integer num, String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = num;
        this.f244f = str5;
    }
}
