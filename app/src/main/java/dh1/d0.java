package dh1;

import f3.f2;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class d0 {
    public static final c0 Companion = new c0();
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f84f;
    public final int g;
    public final int h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f85j;
    public final int k;
    public final int l;

    public /* synthetic */ d0(int i, int i2, int i3, int i4, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        if ((i & 1) == 0) {
            this.a = 0;
        } else {
            this.a = i2;
        }
        if ((i & 2) == 0) {
            this.b = 0;
        } else {
            this.b = i3;
        }
        if ((i & 4) == 0) {
            this.c = 0;
        } else {
            this.c = i4;
        }
        if ((i & 8) == 0) {
            this.d = 0;
        } else {
            this.d = i6;
        }
        if ((i & 16) == 0) {
            this.e = 0;
        } else {
            this.e = i7;
        }
        if ((i & 32) == 0) {
            this.f84f = 0;
        } else {
            this.f84f = i8;
        }
        if ((i & 64) == 0) {
            this.g = 0;
        } else {
            this.g = i9;
        }
        if ((i & 128) == 0) {
            this.h = 0;
        } else {
            this.h = i10;
        }
        if ((i & 256) == 0) {
            this.i = 0;
        } else {
            this.i = i11;
        }
        if ((i & 512) == 0) {
            this.f85j = 1;
        } else {
            this.f85j = i12;
        }
        if ((i & 1024) == 0) {
            this.k = 0;
        } else {
            this.k = i13;
        }
        if ((i & 2048) == 0) {
            this.l = 0;
        } else {
            this.l = i14;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.a == d0Var.a && this.b == d0Var.b && this.c == d0Var.c && this.d == d0Var.d && this.e == d0Var.e && this.f84f == d0Var.f84f && this.g == d0Var.g && this.h == d0Var.h && this.i == d0Var.i && this.f85j == d0Var.f85j && this.k == d0Var.k && this.l == d0Var.l;
    }

    public final int hashCode() {
        return Integer.hashCode(this.l) + s1.a.c(this.k, s1.a.c(this.f85j, s1.a.c(this.i, s1.a.c(this.h, s1.a.c(this.g, s1.a.c(this.f84f, s1.a.c(this.e, s1.a.c(this.d, s1.a.c(this.c, s1.a.c(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        StringBuilder sbI = p.i(this.a, this.b, "UserCounters(followers=", ", following=", ", bands=");
        f2.A(sbI, this.c, ", collections=", this.d, ", plays=");
        f2.A(sbI, this.e, ", notifications=", this.f84f, ", bandInvites=");
        f2.A(sbI, this.g, ", songInvites=", this.h, ", communityInvites=");
        f2.A(sbI, this.i, ", profilePictures=", this.f85j, ", unreadInviteNotifications=");
        sbI.append(this.k);
        sbI.append(", bandFollowings=");
        sbI.append(this.l);
        sbI.append(")");
        return sbI.toString();
    }
}
