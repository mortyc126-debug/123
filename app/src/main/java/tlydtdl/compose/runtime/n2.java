package tlydtdl.compose.runtime;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 {
    public final o2 a;
    public final int[] b;
    public final int c;
    public Object[] d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f534f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p0 f535j;
    public int k;
    public int l;
    public int m;
    public boolean n;

    public n2(o2 o2Var) {
        this.a = o2Var;
        this.b = o2Var.a;
        int i = o2Var.b;
        this.c = i;
        this.d = o2Var.c;
        this.e = o2Var.d;
        this.h = i;
        this.i = -1;
        this.f535j = new p0(0, false);
    }

    public final a a(int i) {
        ArrayList arrayList = this.a.i;
        int iE = q2.e(arrayList, i, this.c);
        if (iE >= 0) {
            return (a) arrayList.get(iE);
        }
        a aVar = new a(i);
        arrayList.add(-(iE + 1), aVar);
        return aVar;
    }

    public final Object b(int i, int[] iArr) {
        int i2 = i * 5;
        int i3 = iArr[i2 + 1];
        if ((268435456 & i3) != 0) {
            return this.d[i2 >= iArr.length ? iArr.length : iArr[i2 + 4] + Integer.bitCount(i3 >> 29)];
        }
        return l.a;
    }

    public final void c() {
        this.f534f = true;
        o2 o2Var = this.a;
        o2Var.getClass();
        if (this.a != o2Var || o2Var.e <= 0) {
            u.c("Unexpected reader close()");
        }
        o2Var.e--;
        this.d = new Object[0];
    }

    public final boolean d(int i) {
        return (this.b[(i * 5) + 1] & 67108864) != 0;
    }

    public final void e() {
        if (this.k == 0) {
            if (!(this.g == this.h)) {
                u.c("endGroup() not called at the end of a group");
            }
            int i = (this.i * 5) + 2;
            int[] iArr = this.b;
            int i2 = iArr[i];
            this.i = i2;
            int i3 = this.c;
            this.h = i2 < 0 ? i3 : q2.a(i2, iArr) + i2;
            int iD = this.f535j.d();
            if (iD < 0) {
                this.l = 0;
                this.m = 0;
            } else {
                this.l = iD;
                this.m = i2 >= i3 - 1 ? this.e : iArr[((i2 + 1) * 5) + 4];
            }
        }
    }

    public final Object f() {
        int i = this.g;
        if (i < this.h) {
            return b(i, this.b);
        }
        return 0;
    }

    public final int g() {
        int i = this.g;
        if (i >= this.h) {
            return 0;
        }
        return this.b[i * 5];
    }

    public final Object h(int i, int i2) {
        int[] iArr = this.b;
        int iC = q2.c(i, iArr);
        int i3 = i + 1;
        int i4 = iC + i2;
        return i4 < (i3 < this.c ? iArr[(i3 * 5) + 4] : this.e) ? this.d[i4] : l.a;
    }

    public final int i(int i) {
        return this.b[i * 5];
    }

    public final boolean j(int i) {
        return (this.b[(i * 5) + 1] & 134217728) != 0;
    }

    public final boolean k(int i) {
        return (this.b[(i * 5) + 1] & 536870912) != 0;
    }

    public final boolean l(int i) {
        return (this.b[(i * 5) + 1] & 1073741824) != 0;
    }

    public final Object m() {
        int i;
        if (this.k > 0 || (i = this.l) >= this.m) {
            this.n = false;
            return l.a;
        }
        this.n = true;
        Object[] objArr = this.d;
        this.l = i + 1;
        return objArr[i];
    }

    public final Object n(int i) {
        int i2 = i * 5;
        int[] iArr = this.b;
        int i3 = iArr[i2 + 1] & 1073741824;
        if (i3 != 0) {
            return i3 != 0 ? this.d[iArr[i2 + 4]] : l.a;
        }
        return null;
    }

    public final int o(int i) {
        return this.b[(i * 5) + 1] & 67108863;
    }

    public final Object p(int i, int[] iArr) {
        int i2 = i * 5;
        int i3 = iArr[i2 + 1];
        if ((536870912 & i3) == 0) {
            return null;
        }
        return this.d[Integer.bitCount(i3 >> 30) + iArr[i2 + 4]];
    }

    public final int q(int i) {
        return this.b[(i * 5) + 2];
    }

    public final void r(int i) {
        if (!(this.k == 0)) {
            u.c("Cannot reposition while in an empty region");
        }
        this.g = i;
        int[] iArr = this.b;
        int i2 = this.c;
        int i3 = i < i2 ? iArr[(i * 5) + 2] : -1;
        if (i3 != this.i) {
            this.i = i3;
            if (i3 < 0) {
                this.h = i2;
            } else {
                this.h = q2.a(i3, iArr) + i3;
            }
            this.l = 0;
            this.m = 0;
        }
    }

    public final int s() {
        if (!(this.k == 0)) {
            u.c("Cannot skip while in an empty region");
        }
        int i = this.g;
        int[] iArr = this.b;
        int i2 = (iArr[(i * 5) + 1] & 1073741824) == 0 ? iArr[(i * 5) + 1] & 67108863 : 1;
        this.g = q2.a(i, iArr) + i;
        return i2;
    }

    public final void t() {
        if (!(this.k == 0)) {
            u.c("Cannot skip the enclosing group while in an empty region");
        }
        this.g = this.h;
        this.l = 0;
        this.m = 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SlotReader(current=");
        sb.append(this.g);
        sb.append(", key=");
        sb.append(g());
        sb.append(", parent=");
        sb.append(this.i);
        sb.append(", end=");
        return f3.f2.l(sb, this.h, ')');
    }

    public final void u() {
        if (this.k <= 0) {
            int i = this.i;
            int i2 = this.g;
            int[] iArr = this.b;
            if (!(iArr[(i2 * 5) + 2] == i)) {
                v1.a("Invalid slot table detected");
            }
            int i3 = this.l;
            int i4 = this.m;
            p0 p0Var = this.f535j;
            if (i3 == 0 && i4 == 0) {
                p0Var.e(-1);
            } else {
                p0Var.e(i3);
            }
            this.i = i2;
            this.h = q2.a(i2, iArr) + i2;
            int i6 = i2 + 1;
            this.g = i6;
            this.l = q2.c(i2, iArr);
            this.m = i2 >= this.c - 1 ? this.e : iArr[(i6 * 5) + 4];
        }
    }
}
