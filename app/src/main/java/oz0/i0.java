package oz0;

import aj.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@a(deserializable = true, serializable = true)
public final class i0 {
    public static final y Companion = new y();
    public final String a;
    public final String b;
    public final e0 c;
    public final m10.j0 d;
    public final b0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f383f;
    public final h0 g;
    public final String h;

    public /* synthetic */ i0(int i, String str, String str2, e0 e0Var, m10.j0 j0Var, b0 b0Var, h0 h0Var, h0 h0Var2, String str3) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = e0Var;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = j0Var;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = b0Var;
        }
        if ((i & 32) == 0) {
            this.f383f = null;
        } else {
            this.f383f = h0Var;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = h0Var2;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = str3;
        }
    }

    public static i0 a(i0 i0Var, m10.j0 j0Var, h0 h0Var, int i) {
        String str = i0Var.a;
        String str2 = i0Var.b;
        e0 e0Var = i0Var.c;
        b0 b0Var = i0Var.e;
        if ((i & 32) != 0) {
            h0Var = i0Var.f383f;
        }
        h0 h0Var2 = i0Var.g;
        String str3 = i0Var.h;
        i0Var.getClass();
        return new i0(str, str2, e0Var, j0Var, b0Var, h0Var, h0Var2, str3);
    }

    public final boolean b() {
        e0 e0Var = this.c;
        return (e0Var != null ? lmjxuqdtp.jvm.internal.o.c(e0Var.b, Boolean.TRUE) : false) && c() != null;
    }

    public final String c() {
        b0 b0Var = this.e;
        if (b0Var != null) {
            return b0Var.b;
        }
        h0 h0Var = this.f383f;
        if (h0Var != null) {
            return h0Var.b;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, i0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.b, i0Var.b) && lmjxuqdtp.jvm.internal.o.c(this.c, i0Var.c) && lmjxuqdtp.jvm.internal.o.c(this.d, i0Var.d) && lmjxuqdtp.jvm.internal.o.c(this.e, i0Var.e) && lmjxuqdtp.jvm.internal.o.c(this.f383f, i0Var.f383f) && lmjxuqdtp.jvm.internal.o.c(this.g, i0Var.g) && lmjxuqdtp.jvm.internal.o.c(this.h, i0Var.h);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        e0 e0Var = this.c;
        int iHashCode3 = (iHashCode2 + (e0Var == null ? 0 : e0Var.hashCode())) * 31;
        m10.j0 j0Var = this.d;
        int iHashCode4 = (iHashCode3 + (j0Var == null ? 0 : j0Var.hashCode())) * 31;
        b0 b0Var = this.e;
        int iHashCode5 = (iHashCode4 + (b0Var == null ? 0 : b0Var.hashCode())) * 31;
        h0 h0Var = this.f383f;
        int iHashCode6 = (iHashCode5 + (h0Var == null ? 0 : h0Var.hashCode())) * 31;
        h0 h0Var2 = this.g;
        int iHashCode7 = (iHashCode6 + (h0Var2 == null ? 0 : h0Var2.hashCode())) * 31;
        String str3 = this.h;
        return iHashCode7 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbJ = z.p.j("AlbumTrack(name=", this.a, ", genreId=", this.b, ", permissions=");
        sbJ.append(this.c);
        sbJ.append(", picture=");
        sbJ.append(this.d);
        sbJ.append(", mastering=");
        sbJ.append(this.e);
        sbJ.append(", sample=");
        sbJ.append(this.f383f);
        sbJ.append(", spatialSample=");
        sbJ.append(this.g);
        sbJ.append(", revisionId=");
        sbJ.append(this.h);
        sbJ.append(")");
        return sbJ.toString();
    }

    public i0(String str, String str2, e0 e0Var, m10.j0 j0Var, b0 b0Var, h0 h0Var, h0 h0Var2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = e0Var;
        this.d = j0Var;
        this.e = b0Var;
        this.f383f = h0Var;
        this.g = h0Var2;
        this.h = str3;
    }
}
