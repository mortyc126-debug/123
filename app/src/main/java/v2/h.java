package v2;

import java.util.ArrayList;
import java.util.List;
import tlydtdl.compose.runtime.p0;
import w2.a0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Appendable {
    public final i a;
    public final p0 b;
    public final a0 c;
    public v80.h d;
    public long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d5.p0 f622f;
    public k3.e g;
    public lx1.l h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f623j;

    public h(i iVar, v80.h hVar, i iVar2, p0 p0Var, int i) {
        k3.e eVar = null;
        hVar = (i & 2) != 0 ? null : hVar;
        iVar2 = (i & 4) != 0 ? iVar : iVar2;
        p0Var = (i & 8) != 0 ? null : p0Var;
        this.a = iVar2;
        this.b = p0Var;
        a0 a0Var = new a0();
        a0Var.a = iVar;
        a0Var.c = -1;
        a0Var.d = -1;
        this.c = a0Var;
        this.d = hVar != null ? new v80.h(hVar) : null;
        long j2 = iVar.d;
        List list = iVar.a;
        this.e = j2;
        this.f622f = iVar.e;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            d5.e[] eVarArr = new d5.e[size];
            for (int i2 = 0; i2 < size; i2++) {
                eVarArr[i2] = (d5.e) list.get(i2);
            }
            eVar = new k3.e(size, eVarArr);
        }
        this.g = eVar;
        this.i = this.b != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static v2.i i(v2.h r9, long r10, d5.p0 r12, java.util.List r13, int r14) {
        /*
            r0 = r14 & 1
            if (r0 == 0) goto L6
            long r10 = r9.e
        L6:
            r2 = r10
            r10 = r14 & 2
            if (r10 == 0) goto Ld
            d5.p0 r12 = r9.f622f
        Ld:
            r4 = r12
            k3.e r10 = r9.g
            r11 = 0
            if (r10 == 0) goto L22
            java.util.List r10 = r10.j()
            r12 = r10
            k3.b r12 = (k3.b) r12
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L22
            r6 = r10
            goto L23
        L22:
            r6 = r11
        L23:
            r10 = r14 & 8
            if (r10 == 0) goto L29
            r7 = r11
            goto L2a
        L29:
            r7 = r13
        L2a:
            v2.i r0 = new v2.i
            w2.a0 r9 = r9.c
            java.lang.String r1 = r9.toString()
            r5 = 0
            r8 = 8
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.h.i(v2.h, long, d5.p0, java.util.List, int):v2.i");
    }

    public final v80.h a() {
        v80.h hVar = this.d;
        if (hVar != null) {
            return hVar;
        }
        v80.h hVar2 = new v80.h((v80.h) null);
        this.d = hVar2;
        return hVar2;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        a0 a0Var = this.c;
        b(a0Var.length(), a0Var.length(), 1);
        a0.b(a0Var, a0Var.length(), a0Var.length(), String.valueOf(c));
        return this;
    }

    public final void b(int i, int i2, int i3) {
        int i4;
        v80.h hVarA = a();
        if (i != i2 || i3 != 0) {
            int iMin = Math.min(i, i2);
            int iMax = Math.max(i, i2);
            int i6 = i3 - (iMax - iMin);
            int i7 = 0;
            w2.i iVar = null;
            boolean z = false;
            while (true) {
                k3.e eVar = (k3.e) hVarA.b;
                if (i7 >= eVar.c) {
                    break;
                }
                w2.i iVar2 = (w2.i) eVar.a[i7];
                int i8 = iVar2.a;
                if ((iMin > i8 || i8 > iMax) && ((iMin > (i4 = iVar2.b) || i4 > iMax) && ((iMin > i4 || i8 > iMin) && (iMax > i4 || i8 > iMax)))) {
                    if (i8 > iMax && !z) {
                        hVarA.d(iVar, iMin, iMax, i6);
                        z = true;
                    }
                    if (z) {
                        iVar2.a += i6;
                        iVar2.b += i6;
                    }
                    ((k3.e) hVarA.c).d(iVar2);
                } else if (iVar == null) {
                    iVar = iVar2;
                } else {
                    iVar.b = iVar2.b;
                    iVar.d = iVar2.d;
                }
                i7++;
            }
            if (!z) {
                hVarA.d(iVar, iMin, iMax, i6);
            }
            k3.e eVar2 = (k3.e) hVarA.b;
            hVarA.b = (k3.e) hVarA.c;
            hVarA.c = eVar2;
            eVar2.k();
        }
        p0 p0Var = this.b;
        if (p0Var != null) {
            p0Var.i(i, i2, i3);
        }
        this.e = x10.a.g(this.e, i, i2, i3);
    }

    public final void c(int i, int i2, CharSequence charSequence) {
        d(i, i2, charSequence, 0, charSequence.length());
    }

    public final void d(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (!(i <= i2)) {
            d2.a.a("Expected start=" + i + " <= end=" + i2);
        }
        if (!(i3 <= i4)) {
            d2.a.a("Expected textStart=" + i3 + " <= textEnd=" + i4);
        }
        b(i, i2, i4 - i3);
        this.c.a(i, i2, charSequence, i3, i4);
        g(null);
        this.h = null;
    }

    public final void e() {
        int length = this.c.length();
        i iVar = this.a;
        c(0, length, iVar.c.toString());
        h(iVar.d);
        a().f();
    }

    public final void f(List list, int i, int i2) {
        a0 a0Var = this.c;
        if (i < 0 || i > a0Var.length()) {
            StringBuilder sbR = o6.c.r(i, "start (", ") offset is outside of text region ");
            sbR.append(a0Var.length());
            throw new IndexOutOfBoundsException(sbR.toString());
        }
        if (i2 < 0 || i2 > a0Var.length()) {
            StringBuilder sbR2 = o6.c.r(i2, "end (", ") offset is outside of text region ");
            sbR2.append(a0Var.length());
            throw new IndexOutOfBoundsException(sbR2.toString());
        }
        if (i >= i2) {
            throw new IllegalArgumentException(s1.a.j("Do not set reversed or empty range: ", i, i2, " > "));
        }
        g(new d5.p0(uc0.p.h(i, i2)));
        k3.e eVar = this.g;
        if (eVar != null) {
            eVar.k();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.g == null) {
            this.g = new k3.e(0, new d5.e[16]);
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            d5.e eVar2 = (d5.e) list.get(i3);
            k3.e eVar3 = this.g;
            if (eVar3 != null) {
                eVar3.d(d5.e.a(eVar2, null, eVar2.b + i, eVar2.c + i, 9));
            }
        }
    }

    public final void g(d5.p0 p0Var) {
        if (p0Var != null && !d5.p0.d(p0Var.a)) {
            this.f622f = p0Var;
            return;
        }
        this.f622f = null;
        k3.e eVar = this.g;
        if (eVar != null) {
            eVar.k();
        }
    }

    public final void h(long j2) {
        long jH = uc0.p.h(0, this.c.length());
        if (!d5.p0.a(jH, j2)) {
            d2.a.a("Expected " + ((Object) d5.p0.i(j2)) + " to be in " + ((Object) d5.p0.i(jH)));
        }
        this.e = j2;
        this.h = null;
    }

    public final String toString() {
        return this.c.toString();
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence != null) {
            a0 a0Var = this.c;
            b(a0Var.length(), a0Var.length(), charSequence.length());
            a0Var.a(a0Var.length(), a0Var.length(), charSequence, 0, charSequence.length());
        }
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        if (charSequence != null) {
            a0 a0Var = this.c;
            b(a0Var.length(), a0Var.length(), i2 - i);
            a0.b(a0Var, a0Var.length(), a0Var.length(), charSequence.subSequence(i, i2));
        }
        return this;
    }
}
