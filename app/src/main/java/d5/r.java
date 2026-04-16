package d5;

import a4.z0;
import amuvvoafs.text.Layout;
import amuvvoafs.text.TextUtils;
import com.gnacba.firebase.messaging.j;
import e5.m;
import e5.n;
import java.util.ArrayList;
import java.util.List;
import uc0.p;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    public final av1.g a;
    public final int b;
    public final boolean c;
    public final float d;
    public final float e;

    /* JADX INFO: renamed from: f */
    public final int f75f;
    public final ArrayList g;
    public final ArrayList h;

    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public r(av1.g gVar, long j2, int i, int i2) {
        boolean z;
        int i3;
        int iG;
        int i4;
        this.a = gVar;
        this.b = i;
        if (p5.a.j(j2) != 0 || p5.a.i(j2) != 0) {
            j5.a.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) gVar.f;
        int size = arrayList2.size();
        float f2 = 0.0f;
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            u uVar = (u) arrayList2.get(i6);
            l5.c cVar = uVar.a;
            int iH = p5.a.h(j2);
            if (p5.a.c(j2)) {
                i3 = i6;
                iG = p5.a.g(j2) - ((int) Math.ceil(f2));
                if (iG < 0) {
                    iG = 0;
                }
            } else {
                i3 = i6;
                iG = p5.a.g(j2);
            }
            a aVar = new a(cVar, this.b - i7, i2, p5.b.b(iH, iG, 5));
            float fB = aVar.b() + f2;
            n nVar = aVar.d;
            int i8 = i7 + nVar.g;
            arrayList.add(new t(aVar, uVar.b, uVar.c, i7, i8, f2, fB));
            if (!nVar.d) {
                if (i8 == this.b) {
                    i4 = i3;
                    if (i4 != ct1.b.z((ArrayList) this.a.f)) {
                    }
                } else {
                    i4 = i3;
                }
                i6 = i4 + 1;
                i7 = i8;
                f2 = fB;
            }
            z = true;
            i7 = i8;
            f2 = fB;
            break;
        }
        z = false;
        this.e = f2;
        this.f75f = i7;
        this.c = z;
        this.h = arrayList;
        this.d = p5.a.h(j2);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i9 = 0; i9 < size2; i9++) {
            t tVar = (t) arrayList.get(i9);
            ?? r7 = tVar.a.f67f;
            ArrayList arrayList4 = new ArrayList(r7.size());
            int size3 = r7.size();
            for (int i10 = 0; i10 < size3; i10++) {
                z3.c cVar2 = (z3.c) r7.get(i10);
                arrayList4.add(cVar2 != null ? tVar.a(cVar2) : null);
            }
            mx1.o.i0(arrayList3, arrayList4);
        }
        if (arrayList3.size() < ((List) this.a.c).size()) {
            int size4 = ((List) this.a.c).size() - arrayList3.size();
            ArrayList arrayList5 = new ArrayList(size4);
            for (int i11 = 0; i11 < size4; i11++) {
                arrayList5.add(null);
            }
            arrayList3 = mx1.o.R0(arrayList3, arrayList5);
        }
        this.g = arrayList3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(long j2, float[] fArr) {
        j(p0.g(j2));
        k(p0.f(j2));
        lmjxuqdtp.jvm.internal.a0 a0Var = new lmjxuqdtp.jvm.internal.a0();
        a0Var.a = 0;
        m8.d.A(this.h, j2, new d3.e(j2, fArr, a0Var, new lmjxuqdtp.jvm.internal.z(), 1));
    }

    public final float b(int i) {
        l(i);
        ArrayList arrayList = this.h;
        t tVar = (t) arrayList.get(m8.d.y(i, arrayList));
        a aVar = tVar.a;
        return aVar.d.e(i - tVar.d) + tVar.f76f;
    }

    public final int c(int i, boolean z) {
        int iF;
        l(i);
        ArrayList arrayList = this.h;
        t tVar = (t) arrayList.get(m8.d.y(i, arrayList));
        a aVar = tVar.a;
        int i2 = i - tVar.d;
        n nVar = aVar.d;
        if (z) {
            Layout layout = nVar.f;
            m mVar = e5.o.a;
            if (layout.getEllipsisCount(i2) <= 0 || nVar.b != TextUtils.TruncateAt.END) {
                av1.g gVarC = nVar.c();
                Layout layout2 = (Layout) gVarC.b;
                iF = gVarC.P(layout2.getLineEnd(i2), layout2.getLineStart(i2));
            } else {
                iF = layout.getEllipsisStart(i2) + layout.getLineStart(i2);
            }
        } else {
            iF = nVar.f(i2);
        }
        return iF + tVar.b;
    }

    public final int d(int i) {
        int length = ((g) this.a.b).b.length();
        ArrayList arrayList = this.h;
        t tVar = (t) arrayList.get(i >= length ? ct1.b.z(arrayList) : i < 0 ? 0 : m8.d.x(i, arrayList));
        return tVar.a.d.f.getLineForOffset(tVar.d(i)) + tVar.d;
    }

    public final int e(float f2) {
        ArrayList arrayList = this.h;
        t tVar = (t) arrayList.get(m8.d.z(arrayList, f2));
        int i = tVar.c - tVar.b;
        int i2 = tVar.d;
        if (i == 0) {
            return i2;
        }
        a aVar = tVar.a;
        float f3 = f2 - tVar.f76f;
        n nVar = aVar.d;
        return nVar.f.getLineForVertical(((int) f3) - nVar.h) + i2;
    }

    public final float f(int i) {
        l(i);
        ArrayList arrayList = this.h;
        t tVar = (t) arrayList.get(m8.d.y(i, arrayList));
        a aVar = tVar.a;
        return aVar.d.g(i - tVar.d) + tVar.f76f;
    }

    public final int g(long j2) {
        int i = (int) (j2 & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        ArrayList arrayList = this.h;
        t tVar = (t) arrayList.get(m8.d.z(arrayList, fIntBitsToFloat));
        int i2 = tVar.c;
        int i3 = tVar.b;
        if (i2 - i3 == 0) {
            return i3;
        }
        a aVar = tVar.a;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 >> 32));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) - tVar.f76f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32);
        n nVar = aVar.d;
        int lineForVertical = nVar.f.getLineForVertical(((int) Float.intBitsToFloat((int) (4294967295L & jFloatToRawIntBits))) - nVar.h);
        return nVar.f.getOffsetForHorizontal(lineForVertical, (nVar.b(lineForVertical) * (-1)) + Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))) + i3;
    }

    public final long h(z3.c cVar, int i, j jVar) {
        long jB;
        long j2;
        float f2 = cVar.b;
        ArrayList arrayList = this.h;
        int iZ = m8.d.z(arrayList, f2);
        float f3 = ((t) arrayList.get(iZ)).g;
        float f4 = cVar.d;
        if (f3 >= f4 || iZ == ct1.b.z(arrayList)) {
            t tVar = (t) arrayList.get(iZ);
            return tVar.b(tVar.a.c(tVar.c(cVar), i, jVar), true);
        }
        int iZ2 = m8.d.z(arrayList, f4);
        long jB2 = p0.b;
        while (true) {
            jB = p0.b;
            if (!p0.c(jB2, jB) || iZ > iZ2) {
                break;
            }
            t tVar2 = (t) arrayList.get(iZ);
            jB2 = tVar2.b(tVar2.a.c(tVar2.c(cVar), i, jVar), true);
            iZ++;
        }
        if (p0.c(jB2, jB)) {
            return jB;
        }
        while (true) {
            j2 = p0.b;
            if (!p0.c(jB, j2) || iZ > iZ2) {
                break;
            }
            t tVar3 = (t) arrayList.get(iZ2);
            jB = tVar3.b(tVar3.a.c(tVar3.c(cVar), i, jVar), true);
            iZ2--;
        }
        return p0.c(jB, j2) ? jB2 : p.h((int) (jB2 >> 32), (int) (4294967295L & jB));
    }

    public final void i(a4.w wVar, long j2, z0 z0Var, o5.l lVar, c4.e eVar) {
        wVar.o();
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            t tVar = (t) arrayList.get(i);
            tVar.a.f(wVar, j2, z0Var, lVar, eVar);
            wVar.j(0.0f, tVar.a.b());
        }
        wVar.k();
    }

    public final void j(int i) {
        boolean z = false;
        av1.g gVar = this.a;
        if (i >= 0 && i < ((g) gVar.b).b.length()) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbR = o6.c.r(i, "offset(", ") is out of bounds [0, ");
        sbR.append(((g) gVar.b).b.length());
        sbR.append(')');
        j5.a.a(sbR.toString());
    }

    public final void k(int i) {
        boolean z = false;
        av1.g gVar = this.a;
        if (i >= 0 && i <= ((g) gVar.b).b.length()) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbR = o6.c.r(i, "offset(", ") is out of bounds [0, ");
        sbR.append(((g) gVar.b).b.length());
        sbR.append(']');
        j5.a.a(sbR.toString());
    }

    public final void l(int i) {
        boolean z = false;
        int i2 = this.f75f;
        if (i >= 0 && i < i2) {
            z = true;
        }
        if (z) {
            return;
        }
        j5.a.a("lineIndex(" + i + ") is out of bounds [0, " + i2 + ')');
    }
}
