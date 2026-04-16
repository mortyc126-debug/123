package l8;

import amuvvoafs.net.Uri;
import com.gnacba.amuvvoafs.gms.internal.ads.gm0;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f291j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public final Uri a;
    public final String b;
    public final d0 c;
    public final y d;
    public final List e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f292f;
    public final com.gnacba.common.collect.k0 g;
    public final Object h;
    public final long i;

    static {
        int i = o8.f0.a;
        f291j = Integer.toString(0, 36);
        k = Integer.toString(1, 36);
        l = Integer.toString(2, 36);
        m = Integer.toString(3, 36);
        n = Integer.toString(4, 36);
        o = Integer.toString(5, 36);
        p = Integer.toString(6, 36);
        q = Integer.toString(7, 36);
    }

    public g0(Uri uri, String str, d0 d0Var, y yVar, List list, String str2, com.gnacba.common.collect.k0 k0Var, Object obj, long j2) {
        this.a = uri;
        this.b = q0.m(str);
        this.c = d0Var;
        this.d = yVar;
        this.e = list;
        this.f292f = str2;
        this.g = k0Var;
        com.gnacba.common.collect.g0 g0VarN = com.gnacba.common.collect.k0.n();
        for (int i = 0; i < k0Var.size(); i++) {
            g0VarN.a(gm0.a(((j0) k0Var.get(i)).a()));
        }
        g0VarN.g();
        this.h = obj;
        this.i = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.a.equals(g0Var.a) && Objects.equals(this.b, g0Var.b) && Objects.equals(this.c, g0Var.c) && Objects.equals(this.d, g0Var.d) && this.e.equals(g0Var.e) && Objects.equals(this.f292f, g0Var.f292f) && this.g.equals(g0Var.g) && Objects.equals(this.h, g0Var.h) && this.i == g0Var.i;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        d0 d0Var = this.c;
        int iHashCode3 = (iHashCode2 + (d0Var == null ? 0 : d0Var.hashCode())) * 31;
        y yVar = this.d;
        int iHashCode4 = (this.e.hashCode() + ((iHashCode3 + (yVar == null ? 0 : yVar.hashCode())) * 31)) * 31;
        String str2 = this.f292f;
        int iHashCode5 = (this.g.hashCode() + ((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        Object obj = this.h;
        return (int) ((((long) (iHashCode5 + (obj != null ? obj.hashCode() : 0))) * 31) + this.i);
    }
}
