package g4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends k0 implements Iterable, ay1.a {
    public final String a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f165f;
    public final float g;
    public final float h;
    public final List i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f166j;

    public i0(String str, float f2, float f3, float f4, float f5, float f7, float f8, float f9, List list, ArrayList arrayList) {
        this.a = str;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f165f = f7;
        this.g = f8;
        this.h = f9;
        this.i = list;
        this.f166j = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof i0)) {
            i0 i0Var = (i0) obj;
            return lmjxuqdtp.jvm.internal.o.c(this.a, i0Var.a) && this.b == i0Var.b && this.c == i0Var.c && this.d == i0Var.d && this.e == i0Var.e && this.f165f == i0Var.f165f && this.g == i0Var.g && this.h == i0Var.h && lmjxuqdtp.jvm.internal.o.c(this.i, i0Var.i) && lmjxuqdtp.jvm.internal.o.c(this.f166j, i0Var.f166j);
        }
        return false;
    }

    public final int hashCode() {
        return this.f166j.hashCode() + i.d(this.i, s1.a.b(this.h, s1.a.b(this.g, s1.a.b(this.f165f, s1.a.b(this.e, s1.a.b(this.d, s1.a.b(this.c, s1.a.b(this.b, this.a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new h0(this);
    }
}
