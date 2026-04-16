package l8;

import amuvvoafs.net.Uri;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static final String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f287j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public final UUID a;
    public final Uri b;
    public final com.gnacba.common.collect.n0 c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f288f;
    public final com.gnacba.common.collect.k0 g;
    public final byte[] h;

    static {
        int i2 = o8.f0.a;
        i = Integer.toString(0, 36);
        f287j = Integer.toString(1, 36);
        k = Integer.toString(2, 36);
        l = Integer.toString(3, 36);
        m = Integer.toString(4, 36);
        n = Integer.toString(5, 36);
        o = Integer.toString(6, 36);
        p = Integer.toString(7, 36);
    }

    public d0(ec.b bVar) {
        o8.b.h((bVar.c && ((Uri) bVar.e) == null) ? false : true);
        UUID uuid = (UUID) bVar.d;
        uuid.getClass();
        this.a = uuid;
        this.b = (Uri) bVar.e;
        this.c = (com.gnacba.common.collect.n0) bVar.f;
        this.d = bVar.a;
        this.f288f = bVar.c;
        this.e = bVar.b;
        this.g = bVar.g;
        byte[] bArr = (byte[]) bVar.h;
        this.h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.a.equals(d0Var.a) && Objects.equals(this.b, d0Var.b) && Objects.equals(this.c, d0Var.c) && this.d == d0Var.d && this.f288f == d0Var.f288f && this.e == d0Var.e && this.g.equals(d0Var.g) && Arrays.equals(this.h, d0Var.h);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Uri uri = this.b;
        return Arrays.hashCode(this.h) + ((this.g.hashCode() + ((((((((this.c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.d ? 1 : 0)) * 31) + (this.f288f ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31)) * 31);
    }
}
