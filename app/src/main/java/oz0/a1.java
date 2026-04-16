package oz0;

import aj.a;
import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(serializable = true)
public final class a1 {
    public static final z0 Companion = new z0();
    public final String a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f376f;
    public final String g;
    public final Integer h;
    public final Boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f377j;
    public final Boolean k;

    public /* synthetic */ a1(int i, String str, double d, double d3, double d4, double d6, String str2, String str3, Integer num, Boolean bool, Boolean bool2, Boolean bool3) {
        if (2047 != (i & 2047)) {
            b2.b(i, 2047, y0.a.getDescriptor());
            throw null;
        }
        this.a = str;
        this.b = d;
        this.c = d3;
        this.d = d4;
        this.e = d6;
        this.f376f = str2;
        this.g = str3;
        this.h = num;
        this.i = bool;
        this.f377j = bool2;
        this.k = bool3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, a1Var.a) && Double.compare(this.b, a1Var.b) == 0 && Double.compare(this.c, a1Var.c) == 0 && Double.compare(this.d, a1Var.d) == 0 && Double.compare(this.e, a1Var.e) == 0 && lmjxuqdtp.jvm.internal.o.c(this.f376f, a1Var.f376f) && lmjxuqdtp.jvm.internal.o.c(this.g, a1Var.g) && lmjxuqdtp.jvm.internal.o.c(this.h, a1Var.h) && lmjxuqdtp.jvm.internal.o.c(this.i, a1Var.i) && lmjxuqdtp.jvm.internal.o.c(this.f377j, a1Var.f377j) && lmjxuqdtp.jvm.internal.o.c(this.k, a1Var.k);
    }

    public final int hashCode() {
        int iB = i.b(this.e, i.b(this.d, i.b(this.c, i.b(this.b, this.a.hashCode() * 31, 31), 31), 31), 31);
        String str = this.f376f;
        int iHashCode = (iB + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.h;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.i;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f377j;
        int iHashCode5 = (iHashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.k;
        return iHashCode5 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaDurationTrackerRequest(postCreatorId=");
        sb.append(this.a);
        sb.append(", duration=");
        sb.append(this.b);
        s1.a.w(sb, ", actualPlayedDuration=", this.c, ", playStartedPosition=");
        sb.append(this.d);
        s1.a.w(sb, ", lastPlayedPosition=", this.e, ", genreId=");
        s1.a.y(sb, this.f376f, ", caption=", this.g, ", trendingPostType=");
        sb.append(this.h);
        sb.append(", isFork=");
        sb.append(this.i);
        sb.append(", hasLyrics=");
        sb.append(this.f377j);
        sb.append(", isPreview=");
        sb.append(this.k);
        sb.append(")");
        return sb.toString();
    }

    public a1(String str, double d, double d3, double d4, double d6, String str2, String str3, Integer num, Boolean bool, Boolean bool2, Boolean bool3) {
        lmjxuqdtp.jvm.internal.o.h(str, "postCreatorId");
        this.a = str;
        this.b = d;
        this.c = d3;
        this.d = d4;
        this.e = d6;
        this.f376f = str2;
        this.g = str3;
        this.h = num;
        this.i = bool;
        this.f377j = bool2;
        this.k = bool3;
    }
}
