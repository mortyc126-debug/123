package d5;

import amuvvoafs.graphics.RectF;
import amuvvoafs.text.Layout;
import e5.n;
import java.util.ArrayList;
import o5.j;
import p5.m;
import z.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    public final l0 a;
    public final r b;
    public final long c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f */
    public final ArrayList f74f;

    public m0(l0 l0Var, r rVar, long j2) {
        this.a = l0Var;
        this.b = rVar;
        this.c = j2;
        ArrayList arrayList = rVar.h;
        float fD = 0.0f;
        this.d = arrayList.isEmpty() ? 0.0f : ((t) arrayList.get(0)).a.d.d(0);
        if (!arrayList.isEmpty()) {
            t tVar = (t) mx1.o.G0(arrayList);
            fD = tVar.a.d.d(r4.g - 1) + tVar.f76f;
        }
        this.e = fD;
        this.f74f = rVar.g;
    }

    public final j a(int i) {
        r rVar = this.b;
        ArrayList arrayList = rVar.h;
        rVar.k(i);
        t tVar = (t) arrayList.get(i == ((g) rVar.a.b).b.length() ? ct1.b.z(arrayList) : m8.d.x(i, arrayList));
        return tVar.a.d.f.isRtlCharAt(tVar.d(i)) ? j.b : j.a;
    }

    public final z3.c b(int i) {
        float fI;
        float fI2;
        float fH;
        float fH2;
        r rVar = this.b;
        rVar.j(i);
        ArrayList arrayList = rVar.h;
        t tVar = (t) arrayList.get(m8.d.x(i, arrayList));
        a aVar = tVar.a;
        int iD = tVar.d(i);
        CharSequence charSequence = aVar.e;
        if (iD < 0 || iD >= charSequence.length()) {
            StringBuilder sbR = o6.c.r(iD, "offset(", ") is out of bounds [0,");
            sbR.append(charSequence.length());
            sbR.append(')');
            j5.a.a(sbR.toString());
        }
        n nVar = aVar.d;
        Layout layout = nVar.f;
        int lineForOffset = layout.getLineForOffset(iD);
        float fG = nVar.g(lineForOffset);
        float fE = nVar.e(lineForOffset);
        boolean z = layout.getParagraphDirection(lineForOffset) == 1;
        boolean zIsRtlCharAt = layout.isRtlCharAt(iD);
        if (!z || zIsRtlCharAt) {
            if (z && zIsRtlCharAt) {
                fH = nVar.i(iD, false);
                fH2 = nVar.i(iD + 1, true);
            } else if (zIsRtlCharAt) {
                fH = nVar.h(iD, false);
                fH2 = nVar.h(iD + 1, true);
            } else {
                fI = nVar.i(iD, false);
                fI2 = nVar.i(iD + 1, true);
            }
            float f2 = fH;
            fI = fH2;
            fI2 = f2;
        } else {
            fI = nVar.h(iD, false);
            fI2 = nVar.h(iD + 1, true);
        }
        RectF rectF = new RectF(fI, fG, fI2, fE);
        return tVar.a(new z3.c(rectF.left, rectF.top, rectF.right, rectF.bottom));
    }

    public final z3.c c(int i) {
        r rVar = this.b;
        ArrayList arrayList = rVar.h;
        rVar.k(i);
        t tVar = (t) arrayList.get(i == ((g) rVar.a.b).b.length() ? ct1.b.z(arrayList) : m8.d.x(i, arrayList));
        a aVar = tVar.a;
        int iD = tVar.d(i);
        CharSequence charSequence = aVar.e;
        n nVar = aVar.d;
        if (iD < 0 || iD > charSequence.length()) {
            StringBuilder sbR = o6.c.r(iD, "offset(", ") is out of bounds [0,");
            sbR.append(charSequence.length());
            sbR.append(']');
            j5.a.a(sbR.toString());
        }
        float fH = nVar.h(iD, false);
        int lineForOffset = nVar.f.getLineForOffset(iD);
        return tVar.a(new z3.c(fH, nVar.g(lineForOffset), fH, nVar.e(lineForOffset)));
    }

    public final boolean d() {
        long j2 = this.c;
        float f2 = (int) (j2 >> 32);
        r rVar = this.b;
        return f2 < rVar.d || rVar.c || ((float) ((int) (j2 & 4294967295L))) < rVar.e;
    }

    public final float e(int i) {
        r rVar = this.b;
        rVar.l(i);
        ArrayList arrayList = rVar.h;
        t tVar = (t) arrayList.get(m8.d.y(i, arrayList));
        a aVar = tVar.a;
        int i2 = i - tVar.d;
        n nVar = aVar.d;
        return nVar.f.getLineLeft(i2) + (i2 == nVar.g + (-1) ? nVar.j : 0.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.a.equals(m0Var.a) && this.b.equals(m0Var.b) && m.a(this.c, m0Var.c) && this.d == m0Var.d && this.e == m0Var.e && lmjxuqdtp.jvm.internal.o.c(this.f74f, m0Var.f74f);
    }

    public final float f(int i) {
        r rVar = this.b;
        rVar.l(i);
        ArrayList arrayList = rVar.h;
        t tVar = (t) arrayList.get(m8.d.y(i, arrayList));
        a aVar = tVar.a;
        int i2 = i - tVar.d;
        n nVar = aVar.d;
        return nVar.f.getLineRight(i2) + (i2 == nVar.g + (-1) ? nVar.k : 0.0f);
    }

    public final int g(int i) {
        r rVar = this.b;
        rVar.l(i);
        ArrayList arrayList = rVar.h;
        t tVar = (t) arrayList.get(m8.d.y(i, arrayList));
        a aVar = tVar.a;
        return aVar.d.f.getLineStart(i - tVar.d) + tVar.b;
    }

    public final j h(int i) {
        r rVar = this.b;
        ArrayList arrayList = rVar.h;
        rVar.k(i);
        t tVar = (t) arrayList.get(i == ((g) rVar.a.b).b.length() ? ct1.b.z(arrayList) : m8.d.x(i, arrayList));
        a aVar = tVar.a;
        int iD = tVar.d(i);
        n nVar = aVar.d;
        return nVar.f.getParagraphDirection(nVar.f.getLineForOffset(iD)) == 1 ? j.a : j.b;
    }

    public final int hashCode() {
        return this.f74f.hashCode() + s1.a.b(this.e, s1.a.b(this.d, s1.a.g((this.b.hashCode() + (this.a.hashCode() * 31)) * 31, this.c, 31), 31), 31);
    }

    public final a4.k i(int i, int i2) {
        r rVar = this.b;
        av1.g gVar = rVar.a;
        if (i < 0 || i > i2 || i2 > ((g) gVar.b).b.length()) {
            StringBuilder sbI = p.i(i, i2, "Start(", ") or End(", ") is out of range [0..");
            sbI.append(((g) gVar.b).b.length());
            sbI.append("), or start > end!");
            j5.a.a(sbI.toString());
        }
        if (i == i2) {
            return a4.o.a();
        }
        a4.k kVarA = a4.o.a();
        m8.d.A(rVar.h, uc0.p.h(i, i2), new q(kVarA, i, i2, 0));
        return kVarA;
    }

    public final long j(int i) {
        r rVar = this.b;
        ArrayList arrayList = rVar.h;
        rVar.k(i);
        t tVar = (t) arrayList.get(i == ((g) rVar.a.b).b.length() ? ct1.b.z(arrayList) : m8.d.x(i, arrayList));
        a aVar = tVar.a;
        int iD = tVar.d(i);
        bs1.p pVarJ = aVar.d.j();
        return tVar.b(uc0.p.h(sl0.z.H(pVarJ, iD), sl0.z.G(pVarJ, iD)), false);
    }

    public final boolean k(int i) {
        r rVar = this.b;
        rVar.l(i);
        ArrayList arrayList = rVar.h;
        Layout layout = ((t) arrayList.get(m8.d.y(i, arrayList))).a.d.f;
        e5.m mVar = e5.o.a;
        return layout.getEllipsisCount(i) > 0;
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.a + ", multiParagraph=" + this.b + ", size=" + ((Object) m.b(this.c)) + ", firstBaseline=" + this.d + ", lastBaseline=" + this.e + ", placeholderRects=" + this.f74f + ')';
    }
}
