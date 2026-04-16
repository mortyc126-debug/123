package tlydtdl.compose.runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;
import q1.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r2 {
    public final o2 a;
    public int[] b;
    public Object[] c;
    public ArrayList d;
    public HashMap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q1.z f542f;
    public int g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f543j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final p0 p;
    public final p0 q;
    public final p0 r;
    public q1.z s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public y x;

    public r2(o2 o2Var) {
        this.a = o2Var;
        int[] iArr = o2Var.a;
        this.b = iArr;
        Object[] objArr = o2Var.c;
        this.c = objArr;
        this.d = o2Var.i;
        this.e = o2Var.f538j;
        this.f542f = o2Var.k;
        int i = o2Var.b;
        this.g = i;
        this.h = (iArr.length / 5) - i;
        int i2 = o2Var.d;
        this.k = i2;
        this.l = objArr.length - i2;
        this.m = i;
        this.p = new p0(0, false);
        this.q = new p0(0, false);
        this.r = new p0(0, false);
        this.u = i;
        this.v = -1;
    }

    public static int i(int i, int i2, int i3, int i4) {
        return i > i2 ? -(((i4 - i3) - i) + 1) : i;
    }

    public static void y(r2 r2Var) {
        int i = r2Var.v;
        int iR = r2Var.r(i);
        int[] iArr = r2Var.b;
        int i2 = (iR * 5) + 1;
        int i3 = iArr[i2];
        if ((i3 & 134217728) != 0) {
            return;
        }
        int i4 = (i3 & (-134217729)) | 134217728;
        iArr[i2] = i4;
        if ((67108864 & i4) != 0) {
            return;
        }
        r2Var.V(r2Var.F(i, iArr));
    }

    public final void A(int i) {
        a aVar;
        int i2;
        a aVar2;
        int i3;
        int i4;
        int i6 = this.h;
        int i7 = this.g;
        if (i7 != i) {
            if (!this.d.isEmpty()) {
                int iO = o() - this.h;
                if (i7 < i) {
                    for (int iB = q2.b(this.d, i7, iO); iB < this.d.size() && (i3 = (aVar2 = (a) this.d.get(iB)).a) < 0 && (i4 = i3 + iO) < i; iB++) {
                        aVar2.a = i4;
                    }
                } else {
                    for (int iB2 = q2.b(this.d, i, iO); iB2 < this.d.size() && (i2 = (aVar = (a) this.d.get(iB2)).a) >= 0; iB2++) {
                        aVar.a = -(iO - i2);
                    }
                }
            }
            if (i6 > 0) {
                int[] iArr = this.b;
                int i8 = i * 5;
                int i9 = i6 * 5;
                int i10 = i7 * 5;
                if (i < i7) {
                    mx1.n.R(i9 + i8, i8, iArr, iArr, i10);
                } else {
                    mx1.n.R(i10, i10 + i9, iArr, iArr, i8 + i9);
                }
            }
            if (i < i7) {
                i7 = i + i6;
            }
            int iO2 = o();
            if (i7 >= iO2) {
                u.c("Check failed");
            }
            while (i7 < iO2) {
                int i11 = (i7 * 5) + 2;
                int i12 = this.b[i11];
                int iP = i12 > -2 ? i12 : (p() + i12) - (-2);
                if (iP >= i) {
                    iP = -((p() - iP) - (-2));
                }
                if (iP != i12) {
                    this.b[i11] = iP;
                }
                i7++;
                if (i7 == i) {
                    i7 += i6;
                }
            }
        }
        this.g = i;
    }

    public final void B(int i, int i2) {
        int i3 = this.l;
        int i4 = this.k;
        int i6 = this.m;
        if (i4 != i) {
            Object[] objArr = this.c;
            if (i < i4) {
                System.arraycopy(objArr, i, objArr, i + i3, i4 - i);
            } else {
                int i7 = i4 + i3;
                System.arraycopy(objArr, i7, objArr, i4, (i + i3) - i7);
            }
        }
        int iMin = Math.min(i2 + 1, p());
        if (i6 != iMin) {
            int length = this.c.length - i3;
            if (iMin < i6) {
                int iR = r(iMin);
                int iR2 = r(i6);
                int i8 = this.g;
                while (iR < iR2) {
                    int i9 = (iR * 5) + 4;
                    int i10 = this.b[i9];
                    if (!(i10 >= 0)) {
                        u.c("Unexpected anchor value, expected a positive anchor");
                    }
                    this.b[i9] = -((length - i10) + 1);
                    iR++;
                    if (iR == i8) {
                        iR += this.h;
                    }
                }
            } else {
                int iR3 = r(i6);
                int iR4 = r(iMin);
                while (iR3 < iR4) {
                    int i11 = (iR3 * 5) + 4;
                    int i12 = this.b[i11];
                    if (!(i12 < 0)) {
                        u.c("Unexpected anchor value, expected a negative anchor");
                    }
                    this.b[i11] = i12 + length + 1;
                    iR3++;
                    if (iR3 == this.g) {
                        iR3 += this.h;
                    }
                }
            }
            this.m = iMin;
        }
        this.k = i;
    }

    public final List C(a aVar, r2 r2Var) {
        if (r2Var.n <= 0) {
            u.c("Check failed");
        }
        if (this.n != 0) {
            u.c("Check failed");
        }
        if (!aVar.a()) {
            u.c("Check failed");
        }
        int iC = c(aVar) + 1;
        int i = this.t;
        if (i > iC || iC >= this.u) {
            u.c("Check failed");
        }
        int iF = F(iC, this.b);
        int iT = t(iC);
        int iE = x(iC) ? 1 : E(iC);
        List listS = a0.s(this, iC, r2Var, false, false, true);
        V(iF);
        boolean z = iE > 0;
        while (iF >= i) {
            int iR = r(iF);
            int[] iArr = this.b;
            int i2 = iR * 5;
            int i3 = i2 + 3;
            iArr[i3] = iArr[i3] - iT;
            if (z) {
                int i4 = iArr[i2 + 1];
                if ((1073741824 & i4) != 0) {
                    z = false;
                } else {
                    q2.d(iR, (i4 & 67108863) - iE, iArr);
                }
            }
            iF = F(iF, this.b);
        }
        if (z) {
            if (this.o < iE) {
                u.c("Check failed");
            }
            this.o -= iE;
        }
        return listS;
    }

    public final Object D(int i) {
        int iR = r(i);
        int[] iArr = this.b;
        if ((iArr[(iR * 5) + 1] & 1073741824) != 0) {
            return this.c[h(g(iR, iArr))];
        }
        return null;
    }

    public final int E(int i) {
        return this.b[(r(i) * 5) + 1] & 67108863;
    }

    public final int F(int i, int[] iArr) {
        int i2 = iArr[(r(i) * 5) + 2];
        return i2 > -2 ? i2 : (p() + i2) - (-2);
    }

    public final Object G(Object obj) {
        if (this.n > 0) {
            w(1, this.v);
        }
        Object[] objArr = this.c;
        int i = this.i;
        this.i = i + 1;
        Object obj2 = objArr[h(i)];
        if (this.i > this.f543j) {
            u.c("Writing to an invalid slot");
        }
        this.c[h(this.i - 1)] = obj;
        return obj2;
    }

    public final void H() {
        int i;
        y yVar = this.x;
        if (yVar != null) {
            while (yVar.b != 0) {
                int iA = a0.A(yVar);
                int iR = r(iA);
                int iT = iA + 1;
                int iT2 = t(iA) + iA;
                while (true) {
                    if (iT >= iT2) {
                        i = 0;
                        break;
                    } else {
                        if ((this.b[(r(iT) * 5) + 1] & 201326592) != 0) {
                            i = 1;
                            break;
                        }
                        iT += t(iT);
                    }
                }
                int[] iArr = this.b;
                int i2 = (iR * 5) + 1;
                int i3 = iArr[i2];
                if (((67108864 & i3) != 0 ? 1 : 0) != i) {
                    iArr[i2] = (i << 26) | ((-67108865) & i3);
                    int iF = F(iA, iArr);
                    if (iF >= 0) {
                        a0.k(yVar, iF);
                    }
                }
            }
        }
    }

    public final boolean I() {
        if (!(this.n == 0)) {
            u.c("Cannot remove group while inserting");
        }
        int i = this.t;
        int i2 = this.i;
        int iG = g(r(i), this.b);
        int iM = M();
        P(this.v);
        y yVar = this.x;
        if (yVar != null) {
            while (true) {
                int i3 = yVar.b;
                if (i3 == 0) {
                    break;
                }
                if (i3 == 0) {
                    r1.a.e("IntList is empty.");
                    throw null;
                }
                if (yVar.a[0] < i) {
                    break;
                }
                a0.A(yVar);
            }
        }
        boolean zJ = J(i, this.t - i);
        K(iG, this.i - iG, i - 1);
        this.t = i;
        this.i = i2;
        this.o -= iM;
        return zJ;
    }

    public final boolean J(int i, int i2) {
        if (i2 > 0) {
            ArrayList arrayList = this.d;
            A(i);
            if (!arrayList.isEmpty()) {
                HashMap map = this.e;
                int i3 = i + i2;
                int iB = q2.b(this.d, i3, o() - this.h);
                if (iB >= this.d.size()) {
                    iB--;
                }
                int i4 = iB + 1;
                int i6 = 0;
                while (iB >= 0) {
                    a aVar = (a) this.d.get(iB);
                    int iC = c(aVar);
                    if (iC < i) {
                        break;
                    }
                    if (iC < i3) {
                        aVar.a = IntCompanionObject.MIN_VALUE;
                        if (map != null) {
                        }
                        if (i6 == 0) {
                            i6 = iB + 1;
                        }
                        i4 = iB;
                    }
                    iB--;
                }
                z = i4 < i6;
                if (z) {
                    this.d.subList(i4, i6).clear();
                }
            }
            this.g = i;
            this.h += i2;
            int i7 = this.m;
            if (i7 > i) {
                this.m = Math.max(i, i7 - i2);
            }
            int i8 = this.u;
            if (i8 >= this.g) {
                this.u = i8 - i2;
            }
            int i9 = this.v;
            if (i9 >= 0 && (this.b[(r(i9) * 5) + 1] & 67108864) != 0) {
                V(i9);
            }
        }
        return z;
    }

    public final void K(int i, int i2, int i3) {
        if (i2 > 0) {
            int i4 = this.l;
            int i6 = i + i2;
            B(i6, i3);
            this.k = i;
            this.l = i4 + i2;
            mx1.n.a0(i, i6, (Object) null, this.c);
            int i7 = this.f543j;
            if (i7 >= i) {
                this.f543j = i7 - i2;
            }
        }
    }

    public final Object L(int i, int i2, Object obj) {
        int iO = O(r(i), this.b);
        int iG = g(r(i + 1), this.b);
        int i3 = iO + i2;
        if (i3 < iO || i3 >= iG) {
            u.c("Write to an invalid slot index " + i2 + " for group " + i);
        }
        int iH = h(i3);
        Object[] objArr = this.c;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    public final int M() {
        int iR = r(this.t);
        int iA = q2.a(iR, this.b) + this.t;
        this.t = iA;
        this.i = g(r(iA), this.b);
        int i = this.b[(iR * 5) + 1];
        if ((1073741824 & i) != 0) {
            return 1;
        }
        return i & 67108863;
    }

    public final void N() {
        int i = this.u;
        this.t = i;
        this.i = g(r(i), this.b);
    }

    public final int O(int i, int[] iArr) {
        if (i >= o()) {
            return this.c.length - this.l;
        }
        int iC = q2.c(i, iArr);
        return iC < 0 ? (this.c.length - this.l) + iC + 1 : iC;
    }

    public final o0 P(int i) {
        a aVarS;
        HashMap map = this.e;
        if (map == null || (aVarS = S(i)) == null) {
            return null;
        }
        return (o0) map.get(aVarS);
    }

    public final void Q() {
        if (this.n != 0) {
            u.c("Key must be supplied when inserting");
        }
        x0 x0Var = l.a;
        R(x0Var, x0Var, false, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(Object obj, Object obj2, boolean z, int i) {
        int i2;
        int i3 = this.v;
        byte b = this.n > 0;
        this.r.e(this.o);
        x0 x0Var = l.a;
        if (b == true) {
            int i4 = this.t;
            int iG = g(r(i4), this.b);
            v(1);
            this.i = iG;
            this.f543j = iG;
            int iR = r(i4);
            int i6 = obj != x0Var ? 1 : 0;
            int i7 = (z || obj2 == x0Var) ? 0 : 1;
            int i8 = i(iG, this.k, this.l, this.c.length);
            if (i8 >= 0 && this.m < i4) {
                i8 = -(((this.c.length - this.l) - i8) + 1);
            }
            int[] iArr = this.b;
            int i9 = this.v;
            int i10 = iR * 5;
            iArr[i10] = i;
            iArr[i10 + 1] = ((z ? 1 : 0) << 30) | (i6 << 29) | (i7 << 28);
            iArr[i10 + 2] = i9;
            iArr[i10 + 3] = 0;
            iArr[i10 + 4] = i8;
            int i11 = (z ? 1 : 0) + i6 + i7;
            if (i11 > 0) {
                w(i11, i4);
                Object[] objArr = this.c;
                int i12 = this.i;
                if (z) {
                    objArr[i12] = obj2;
                    i12++;
                }
                if (i6 != 0) {
                    objArr[i12] = obj;
                    i12++;
                }
                if (i7 != 0) {
                    objArr[i12] = obj2;
                    i12++;
                }
                this.i = i12;
            }
            this.o = 0;
            i2 = i4 + 1;
            this.v = i4;
            this.t = i2;
            if (i3 >= 0) {
                P(i3);
            }
        } else {
            this.p.e(i3);
            this.q.e((o() - this.h) - this.u);
            int i13 = this.t;
            int iR2 = r(i13);
            if (!lmjxuqdtp.jvm.internal.o.c(obj2, x0Var)) {
                if (z) {
                    W(this.t, obj2);
                } else {
                    U(obj2);
                }
            }
            this.i = O(iR2, this.b);
            this.f543j = g(r(this.t + 1), this.b);
            int[] iArr2 = this.b;
            int i14 = iR2 * 5;
            this.o = iArr2[i14 + 1] & 67108863;
            this.v = i13;
            this.t = i13 + 1;
            i2 = i13 + iArr2[i14 + 3];
        }
        this.u = i2;
    }

    public final a S(int i) {
        ArrayList arrayList;
        int iE;
        if (i < 0 || i >= p() || (iE = q2.e((arrayList = this.d), i, p())) < 0) {
            return null;
        }
        return (a) arrayList.get(iE);
    }

    public final void T(Object obj) {
        if (this.n <= 0 || this.i == this.k) {
            G(obj);
            return;
        }
        q1.z zVar = this.s;
        if (zVar == null) {
            zVar = new q1.z();
        }
        this.s = zVar;
        int i = this.v;
        Object objB = zVar.b(i);
        if (objB == null) {
            objB = new q1.j0();
            zVar.h(i, objB);
        }
        ((q1.j0) objB).a(obj);
    }

    public final void U(Object obj) {
        int iR = r(this.t);
        int i = (iR * 5) + 1;
        if ((this.b[i] & 268435456) == 0) {
            u.c("Updating the data of a group that was not created with a data slot");
        }
        Object[] objArr = this.c;
        int[] iArr = this.b;
        objArr[h(Integer.bitCount(iArr[i] >> 29) + g(iR, iArr))] = obj;
    }

    public final void V(int i) {
        if (i >= 0) {
            y yVar = this.x;
            if (yVar == null) {
                yVar = new y();
                this.x = yVar;
            }
            a0.k(yVar, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void W(int r5, java.lang.Object r6) {
        /*
            r4 = this;
            int r0 = r4.r(r5)
            int[] r1 = r4.b
            int r2 = r1.length
            if (r0 >= r2) goto L15
            int r2 = r0 * 5
            r3 = 1
            int r2 = r2 + r3
            r1 = r1[r2]
            r2 = 1073741824(0x40000000, float:2.0)
            r1 = r1 & r2
            if (r1 == 0) goto L15
            goto L16
        L15:
            r3 = 0
        L16:
            if (r3 != 0) goto L2e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Updating the node of a group at "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = " that was not created with as a node group"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            tlydtdl.compose.runtime.u.c(r5)
        L2e:
            java.lang.Object[] r5 = r4.c
            int[] r1 = r4.b
            int r0 = r4.g(r0, r1)
            int r0 = r4.h(r0)
            r5[r0] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.r2.W(int, java.lang.Object):void");
    }

    public final void a(int i) {
        boolean z = false;
        if (!(i >= 0)) {
            u.c("Cannot seek backwards");
        }
        if (!(this.n <= 0)) {
            v1.b("Cannot call seek() while inserting");
        }
        if (i == 0) {
            return;
        }
        int i2 = this.t + i;
        if (i2 >= this.v && i2 <= this.u) {
            z = true;
        }
        if (!z) {
            u.c("Cannot seek outside the current group (" + this.v + '-' + this.u + ')');
        }
        this.t = i2;
        int iG = g(r(i2), this.b);
        this.i = iG;
        this.f543j = iG;
    }

    public final a b(int i) {
        ArrayList arrayList = this.d;
        int iE = q2.e(arrayList, i, p());
        if (iE >= 0) {
            return (a) arrayList.get(iE);
        }
        if (i > this.g) {
            i = -(p() - i);
        }
        a aVar = new a(i);
        arrayList.add(-(iE + 1), aVar);
        return aVar;
    }

    public final int c(a aVar) {
        int i = aVar.a;
        return i < 0 ? p() + i : i;
    }

    public final void d() {
        int i = this.n;
        this.n = i + 1;
        if (i == 0) {
            this.q.e((o() - this.h) - this.u);
        }
    }

    public final void e(boolean z) {
        this.w = true;
        if (z && this.p.b == 0) {
            A(p());
            B(this.c.length - this.l, this.g);
            int i = this.k;
            Arrays.fill(this.c, i, this.l + i, (Object) null);
            H();
        }
        int[] iArr = this.b;
        int i2 = this.g;
        Object[] objArr = this.c;
        int i3 = this.k;
        ArrayList arrayList = this.d;
        HashMap map = this.e;
        q1.z zVar = this.f542f;
        o2 o2Var = this.a;
        if (!o2Var.g) {
            v1.a("Unexpected writer close()");
        }
        o2Var.g = false;
        o2Var.a = iArr;
        o2Var.b = i2;
        o2Var.c = objArr;
        o2Var.d = i3;
        o2Var.i = arrayList;
        o2Var.f538j = map;
        o2Var.k = zVar;
    }

    public final int f(int i) {
        return g(r(i), this.b);
    }

    public final int g(int i, int[] iArr) {
        if (i >= o()) {
            return this.c.length - this.l;
        }
        int i2 = iArr[(i * 5) + 4];
        return i2 < 0 ? (this.c.length - this.l) + i2 + 1 : i2;
    }

    public final int h(int i) {
        return (this.l * (i < this.k ? 0 : 1)) + i;
    }

    public final void j() {
        q1.j0 j0Var;
        boolean z = this.n > 0;
        int i = this.t;
        int i2 = this.u;
        int i3 = this.v;
        int iR = r(i3);
        int i4 = this.o;
        int i6 = i - i3;
        int i7 = iR * 5;
        int i8 = i7 + 1;
        boolean z2 = (this.b[i8] & 1073741824) != 0;
        p0 p0Var = this.r;
        if (z) {
            q1.z zVar = this.s;
            if (zVar != null && (j0Var = (q1.j0) zVar.b(i3)) != null) {
                Object[] objArr = j0Var.a;
                int i9 = j0Var.b;
                for (int i10 = 0; i10 < i9; i10++) {
                    G(objArr[i10]);
                }
            }
            int[] iArr = this.b;
            iArr[i7 + 3] = i6;
            q2.d(iR, i4, iArr);
            int iD = p0Var.d();
            if (z2) {
                i4 = 1;
            }
            this.o = iD + i4;
            int iF = F(i3, this.b);
            this.v = iF;
            int iP = iF < 0 ? p() : r(iF + 1);
            int iG = iP >= 0 ? g(iP, this.b) : 0;
            this.i = iG;
            this.f543j = iG;
            return;
        }
        if (i != i2) {
            u.c("Expected to be at the end of a group");
        }
        int[] iArr2 = this.b;
        int i11 = i7 + 3;
        int i12 = iArr2[i11];
        int i13 = iArr2[i8] & 67108863;
        iArr2[i11] = i6;
        q2.d(iR, i4, iArr2);
        int iD2 = this.p.d();
        this.u = (o() - this.h) - this.q.d();
        this.v = iD2;
        int iF2 = F(i3, this.b);
        int iD3 = p0Var.d();
        this.o = iD3;
        if (iF2 == iD2) {
            this.o = iD3 + (z2 ? 0 : i4 - i13);
            return;
        }
        int i14 = i6 - i12;
        int i15 = z2 ? 0 : i4 - i13;
        if (i14 != 0 || i15 != 0) {
            while (iF2 != 0 && iF2 != iD2 && (i15 != 0 || i14 != 0)) {
                int iR2 = r(iF2);
                if (i14 != 0) {
                    int[] iArr3 = this.b;
                    int i16 = (iR2 * 5) + 3;
                    iArr3[i16] = iArr3[i16] + i14;
                }
                if (i15 != 0) {
                    int[] iArr4 = this.b;
                    q2.d(iR2, (iArr4[(iR2 * 5) + 1] & 67108863) + i15, iArr4);
                }
                int[] iArr5 = this.b;
                if ((iArr5[(iR2 * 5) + 1] & 1073741824) != 0) {
                    i15 = 0;
                }
                iF2 = F(iF2, iArr5);
            }
        }
        this.o += i15;
    }

    public final void k() {
        if (this.n <= 0) {
            v1.b("Unbalanced begin/end insert");
        }
        int i = this.n - 1;
        this.n = i;
        if (i == 0) {
            if (this.r.b != this.p.b) {
                u.c("startGroup/endGroup mismatch while inserting");
            }
            this.u = (o() - this.h) - this.q.d();
        }
    }

    public final void l(int i) {
        boolean z = false;
        if (!(this.n <= 0)) {
            u.c("Cannot call ensureStarted() while inserting");
        }
        int i2 = this.v;
        if (i2 != i) {
            if (i >= i2 && i < this.u) {
                z = true;
            }
            if (!z) {
                u.c("Started group at " + i + " must be a subgroup of the group at " + i2);
            }
            int i3 = this.t;
            int i4 = this.i;
            int i6 = this.f543j;
            this.t = i;
            Q();
            this.t = i3;
            this.i = i4;
            this.f543j = i6;
        }
    }

    public final void m(int i, int i2, int i3) {
        if (i >= this.g) {
            i = -((p() - i) + 2);
        }
        while (i3 < i2) {
            this.b[(r(i3) * 5) + 2] = i;
            int i4 = this.b[(r(i3) * 5) + 3] + i3;
            m(i3, i4, i3 + 1);
            i3 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00eb, code lost:
    
        r1.a.d("Index must be between 0 and size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f0, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void n(int r20, lmjxuqdtp.jvm.functions.Function2 r21) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.r2.n(int, lmjxuqdtp.jvm.functions.Function2):void");
    }

    public final int o() {
        return this.b.length / 5;
    }

    public final int p() {
        return o() - this.h;
    }

    public final Object q(int i) {
        int iR = r(i);
        int[] iArr = this.b;
        int i2 = (iR * 5) + 1;
        if ((iArr[i2] & 268435456) == 0) {
            return l.a;
        }
        return this.c[Integer.bitCount(iArr[i2] >> 29) + g(iR, iArr)];
    }

    public final int r(int i) {
        return (this.h * (i < this.g ? 0 : 1)) + i;
    }

    public final Object s(int i) {
        int iR = r(i);
        int[] iArr = this.b;
        int i2 = iR * 5;
        int i3 = iArr[i2 + 1];
        if ((536870912 & i3) == 0) {
            return null;
        }
        return this.c[Integer.bitCount(i3 >> 30) + iArr[i2 + 4]];
    }

    public final int t(int i) {
        return q2.a(r(i), this.b);
    }

    public final String toString() {
        return "SlotWriter(current = " + this.t + " end=" + this.u + " size = " + p() + " gap=" + this.g + '-' + (this.g + this.h) + ')';
    }

    public final boolean u(int i, int i2) {
        int iO;
        int iT;
        if (i2 == this.v) {
            iO = this.u;
        } else {
            p0 p0Var = this.p;
            if (i2 > p0Var.c(0)) {
                iT = t(i2);
            } else {
                int[] iArr = p0Var.a;
                int iMin = Math.min(iArr.length, p0Var.b);
                int i3 = 0;
                while (true) {
                    if (i3 >= iMin) {
                        i3 = -1;
                        break;
                    }
                    if (iArr[i3] == i2) {
                        break;
                    }
                    i3++;
                }
                if (i3 < 0) {
                    iT = t(i2);
                } else {
                    iO = (o() - this.h) - this.q.a[i3];
                }
            }
            iO = iT + i2;
        }
        return i > i2 && i < iO;
    }

    public final void v(int i) {
        if (i > 0) {
            int i2 = this.t;
            A(i2);
            int i3 = this.g;
            int i4 = this.h;
            int[] iArr = this.b;
            int length = iArr.length / 5;
            int i6 = length - i4;
            if (i4 < i) {
                int iMax = Math.max(Math.max(length * 2, i6 + i), 32);
                int[] iArr2 = new int[iMax * 5];
                int i7 = iMax - i6;
                mx1.n.R(0, 0, iArr, iArr2, i3 * 5);
                mx1.n.R((i3 + i7) * 5, (i4 + i3) * 5, iArr, iArr2, length * 5);
                this.b = iArr2;
                i4 = i7;
            }
            int i8 = this.u;
            if (i8 >= i3) {
                this.u = i8 + i;
            }
            int i9 = i3 + i;
            this.g = i9;
            this.h = i4 - i;
            int i10 = i(i6 > 0 ? f(i2 + i) : 0, this.m >= i3 ? this.k : 0, this.l, this.c.length);
            for (int i11 = i3; i11 < i9; i11++) {
                this.b[(i11 * 5) + 4] = i10;
            }
            int i12 = this.m;
            if (i12 >= i3) {
                this.m = i12 + i;
            }
        }
    }

    public final void w(int i, int i2) {
        if (i > 0) {
            B(this.i, i2);
            int i3 = this.k;
            int i4 = this.l;
            if (i4 < i) {
                Object[] objArr = this.c;
                int length = objArr.length;
                int i6 = length - i4;
                int iMax = Math.max(Math.max(length * 2, i6 + i), 32);
                Object[] objArr2 = new Object[iMax];
                for (int i7 = 0; i7 < iMax; i7++) {
                    objArr2[i7] = null;
                }
                int i8 = iMax - i6;
                int i9 = i4 + i3;
                System.arraycopy(objArr, 0, objArr2, 0, i3);
                System.arraycopy(objArr, i9, objArr2, i3 + i8, length - i9);
                this.c = objArr2;
                i4 = i8;
            }
            int i10 = this.f543j;
            if (i10 >= i3) {
                this.f543j = i10 + i;
            }
            this.k = i3 + i;
            this.l = i4 - i;
        }
    }

    public final boolean x(int i) {
        return (this.b[(r(i) * 5) + 1] & 1073741824) != 0;
    }

    public final void z(o2 o2Var, int i) {
        if (this.n <= 0) {
            u.c("Check failed");
        }
        if (i == 0 && this.t == 0 && this.a.b == 0) {
            int[] iArr = o2Var.a;
            int i2 = iArr[(i * 5) + 3];
            int i3 = o2Var.b;
            if (i2 == i3) {
                int[] iArr2 = this.b;
                Object[] objArr = this.c;
                ArrayList arrayList = this.d;
                HashMap map = this.e;
                q1.z zVar = this.f542f;
                Object[] objArr2 = o2Var.c;
                int i4 = o2Var.d;
                HashMap map2 = o2Var.f538j;
                q1.z zVar2 = o2Var.k;
                this.b = iArr;
                this.c = objArr2;
                this.d = o2Var.i;
                this.g = i3;
                this.h = (iArr.length / 5) - i3;
                this.k = i4;
                this.l = objArr2.length - i4;
                this.m = i3;
                this.e = map2;
                this.f542f = zVar2;
                o2Var.a = iArr2;
                o2Var.b = 0;
                o2Var.c = objArr;
                o2Var.d = 0;
                o2Var.i = arrayList;
                o2Var.f538j = map;
                o2Var.k = zVar;
                return;
            }
        }
        r2 r2VarH = o2Var.h();
        try {
            a0.s(r2VarH, i, this, true, true, false);
            r2VarH.e(true);
        } catch (Throwable th) {
            r2VarH.e(false);
            throw th;
        }
    }
}
