package g4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends k0 {
    public final String a;
    public final List b;
    public final int c;
    public final a4.u d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a4.u f170f;
    public final float g;
    public final float h;
    public final int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f171j;
    public final float k;
    public final float l;
    public final float m;
    public final float n;

    public m0(String str, List list, int i, a4.u uVar, float f2, a4.u uVar2, float f3, float f4, int i2, int i3, float f5, float f7, float f8, float f9) {
        this.a = str;
        this.b = list;
        this.c = i;
        this.d = uVar;
        this.e = f2;
        this.f170f = uVar2;
        this.g = f3;
        this.h = f4;
        this.i = i2;
        this.f171j = i3;
        this.k = f5;
        this.l = f7;
        this.m = f8;
        this.n = f9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m0.class == obj.getClass()) {
            m0 m0Var = (m0) obj;
            return lmjxuqdtp.jvm.internal.o.c(this.a, m0Var.a) && lmjxuqdtp.jvm.internal.o.c(this.d, m0Var.d) && this.e == m0Var.e && lmjxuqdtp.jvm.internal.o.c(this.f170f, m0Var.f170f) && this.g == m0Var.g && this.h == m0Var.h && this.i == m0Var.i && this.f171j == m0Var.f171j && this.k == m0Var.k && this.l == m0Var.l && this.m == m0Var.m && this.n == m0Var.n && this.c == m0Var.c && lmjxuqdtp.jvm.internal.o.c(this.b, m0Var.b);
        }
        return false;
    }

    public final int hashCode() {
        int iD = i.d(this.b, this.a.hashCode() * 31, 31);
        a4.u uVar = this.d;
        int iB = s1.a.b(this.e, (iD + (uVar != null ? uVar.hashCode() : 0)) * 31, 31);
        a4.u uVar2 = this.f170f;
        return Integer.hashCode(this.c) + s1.a.b(this.n, s1.a.b(this.m, s1.a.b(this.l, s1.a.b(this.k, s1.a.c(this.f171j, s1.a.c(this.i, s1.a.b(this.h, s1.a.b(this.g, (iB + (uVar2 != null ? uVar2.hashCode() : 0)) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }
}
