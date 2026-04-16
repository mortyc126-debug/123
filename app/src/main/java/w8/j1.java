package w8;

import amuvvoafs.util.Pair;
import f9.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import o8.f0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j1 extends l8.k1 {
    public static final /* synthetic */ int n = 0;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c1 f640f;
    public final int g;
    public final int h;
    public final int[] i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f641j;
    public final l8.k1[] k;
    public final Object[] l;
    public final HashMap m;

    /* JADX WARN: Illegal instructions before constructor call */
    public j1(ArrayList arrayList, c1 c1Var) {
        l8.k1[] k1VarArr = new l8.k1[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            k1VarArr[i2] = ((x0) it.next()).b();
            i2++;
        }
        Object[] objArr = new Object[arrayList.size()];
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            objArr[i] = ((x0) it2.next()).a();
            i++;
        }
        this(k1VarArr, objArr, c1Var);
    }

    @Override // l8.k1
    public final int a(boolean z) {
        if (this.e != 0) {
            int iQ = 0;
            if (z) {
                int[] iArr = this.f640f.b;
                iQ = iArr.length > 0 ? iArr[0] : -1;
            }
            do {
                l8.k1[] k1VarArr = this.k;
                if (!k1VarArr[iQ].p()) {
                    return k1VarArr[iQ].a(z) + this.f641j[iQ];
                }
                iQ = q(iQ, z);
            } while (iQ != -1);
        }
        return -1;
    }

    @Override // l8.k1
    public final int b(Object obj) {
        int iB;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            Integer num = (Integer) this.m.get(obj2);
            int iIntValue = num == null ? -1 : num.intValue();
            if (iIntValue != -1 && (iB = this.k[iIntValue].b(obj3)) != -1) {
                return this.i[iIntValue] + iB;
            }
        }
        return -1;
    }

    @Override // l8.k1
    public final int c(boolean z) {
        int iR;
        int i = this.e;
        if (i != 0) {
            if (z) {
                int[] iArr = this.f640f.b;
                iR = iArr.length > 0 ? iArr[iArr.length - 1] : -1;
            } else {
                iR = i - 1;
            }
            do {
                l8.k1[] k1VarArr = this.k;
                if (!k1VarArr[iR].p()) {
                    return k1VarArr[iR].c(z) + this.f641j[iR];
                }
                iR = r(iR, z);
            } while (iR != -1);
        }
        return -1;
    }

    @Override // l8.k1
    public final int e(int i, int i2, boolean z) {
        int[] iArr = this.f641j;
        int iD = f0.d(iArr, i + 1, false, false);
        int i3 = iArr[iD];
        l8.k1[] k1VarArr = this.k;
        int iE = k1VarArr[iD].e(i - i3, i2 != 2 ? i2 : 0, z);
        if (iE != -1) {
            return i3 + iE;
        }
        int iQ = q(iD, z);
        while (iQ != -1 && k1VarArr[iQ].p()) {
            iQ = q(iQ, z);
        }
        if (iQ != -1) {
            return k1VarArr[iQ].a(z) + iArr[iQ];
        }
        if (i2 == 2) {
            return a(z);
        }
        return -1;
    }

    @Override // l8.k1
    public final l8.h1 f(int i, l8.h1 h1Var, boolean z) {
        int[] iArr = this.i;
        int iD = f0.d(iArr, i + 1, false, false);
        int i2 = this.f641j[iD];
        this.k[iD].f(i - iArr[iD], h1Var, z);
        h1Var.c += i2;
        if (z) {
            Object obj = this.l[iD];
            Object obj2 = h1Var.b;
            obj2.getClass();
            h1Var.b = Pair.create(obj, obj2);
        }
        return h1Var;
    }

    @Override // l8.k1
    public final l8.h1 g(Object obj, l8.h1 h1Var) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.m.get(obj2);
        int iIntValue = num == null ? -1 : num.intValue();
        int i = this.f641j[iIntValue];
        this.k[iIntValue].g(obj3, h1Var);
        h1Var.c += i;
        h1Var.b = obj;
        return h1Var;
    }

    @Override // l8.k1
    public final int h() {
        return this.h;
    }

    @Override // l8.k1
    public final int k(int i, int i2, boolean z) {
        int[] iArr = this.f641j;
        int iD = f0.d(iArr, i + 1, false, false);
        int i3 = iArr[iD];
        l8.k1[] k1VarArr = this.k;
        int iK = k1VarArr[iD].k(i - i3, i2 != 2 ? i2 : 0, z);
        if (iK != -1) {
            return i3 + iK;
        }
        int iR = r(iD, z);
        while (iR != -1 && k1VarArr[iR].p()) {
            iR = r(iR, z);
        }
        if (iR != -1) {
            return k1VarArr[iR].c(z) + iArr[iR];
        }
        if (i2 == 2) {
            return c(z);
        }
        return -1;
    }

    @Override // l8.k1
    public final Object l(int i) {
        int[] iArr = this.i;
        int iD = f0.d(iArr, i + 1, false, false);
        return Pair.create(this.l[iD], this.k[iD].l(i - iArr[iD]));
    }

    @Override // l8.k1
    public final l8.j1 m(int i, l8.j1 j1Var, long j2) {
        int[] iArr = this.f641j;
        int iD = f0.d(iArr, i + 1, false, false);
        int i2 = iArr[iD];
        int i3 = this.i[iD];
        this.k[iD].m(i - i2, j1Var, j2);
        Object objCreate = this.l[iD];
        if (!l8.j1.q.equals(j1Var.a)) {
            objCreate = Pair.create(objCreate, j1Var.a);
        }
        j1Var.a = objCreate;
        j1Var.n += i3;
        j1Var.o += i3;
        return j1Var;
    }

    @Override // l8.k1
    public final int o() {
        return this.g;
    }

    public final int q(int i, boolean z) {
        if (!z) {
            if (i < this.e - 1) {
                return i + 1;
            }
            return -1;
        }
        c1 c1Var = this.f640f;
        int i2 = c1Var.c[i] + 1;
        int[] iArr = c1Var.b;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public final int r(int i, boolean z) {
        if (!z) {
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }
        c1 c1Var = this.f640f;
        int i2 = c1Var.c[i] - 1;
        if (i2 >= 0) {
            return c1Var.b[i2];
        }
        return -1;
    }

    public j1(l8.k1[] k1VarArr, Object[] objArr, c1 c1Var) {
        this.f640f = c1Var;
        this.e = c1Var.b.length;
        int length = k1VarArr.length;
        this.k = k1VarArr;
        this.i = new int[length];
        this.f641j = new int[length];
        this.l = objArr;
        this.m = new HashMap();
        int length2 = k1VarArr.length;
        int i = 0;
        int iO = 0;
        int iH = 0;
        int i2 = 0;
        while (i < length2) {
            l8.k1 k1Var = k1VarArr[i];
            this.k[i2] = k1Var;
            this.f641j[i2] = iO;
            this.i[i2] = iH;
            iO += k1Var.o();
            iH += this.k[i2].h();
            this.m.put(objArr[i2], Integer.valueOf(i2));
            i++;
            i2++;
        }
        this.g = iO;
        this.h = iH;
    }
}
