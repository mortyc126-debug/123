package tlydtdl.compose.foundation.lazy.layout;

import amuvvoafs.content.SharedPreferences;
import amuvvoafs.content.res.ColorStateList;
import amuvvoafs.content.res.Resources;
import amuvvoafs.content.res.XmlResourceParser;
import amuvvoafs.graphics.Shader;
import amuvvoafs.util.AttributeSet;
import amuvvoafs.util.SparseArray;
import amuvvoafs.util.Xml;
import com.gnacba.amuvvoafs.gms.internal.ads.ez1;
import com.gnacba.amuvvoafs.gms.internal.ads.j91;
import com.gnacba.amuvvoafs.gms.internal.ads.p91;
import com.gnacba.amuvvoafs.gms.internal.ads.pa1;
import com.gnacba.amuvvoafs.gms.internal.ads.qj;
import com.gnacba.amuvvoafs.gms.internal.ads.ql;
import com.gnacba.amuvvoafs.gms.internal.ads.sy;
import ey1.i;
import f3.f2;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.functions.Function1;
import lmjxuqdtp.jvm.functions.Function4;
import lmjxuqdtp.jvm.internal.o;
import org.apache.http.message.TokenParser;
import org.xmlpull.v1.XmlPullParserException;
import v2.p;
import w2.c1;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public class m1 implements s {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;

    public static m1 f(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        int i2 = 8;
        Object obj = null;
        if (name.equals("gradient")) {
            return new m1(h6.b.a(resources, xml, attributeSetAsAttributeSet, theme), obj, 0, i2);
        }
        if (name.equals("selector")) {
            ColorStateList colorStateListB = h6.c.b(resources, xml, attributeSetAsAttributeSet, theme);
            return new m1(obj, colorStateListB, colorStateListB.getDefaultColor(), i2);
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static m1 u(String str, boolean z) {
        return new m1(str, Boolean.valueOf(z), 1, 3);
    }

    public static m1 x(long j2, String str) {
        return new m1(str, Long.valueOf(j2), 2, 3);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public void a(Function1 function1) throws NoWhenBranchMatchedException {
        this.b++;
        ((k3.e) this.c).d(function1);
        g();
    }

    public long b(long j2) {
        return ((c1) this.d).i(j2);
    }

    public long c(long j2) {
        return ((c1) this.d).h(j2);
    }

    public void d(int i, t tVar) {
        if (i < 0) {
            d2.a.a("size should be >=0");
        }
        if (i == 0) {
            return;
        }
        j jVar = new j(this.b, i, tVar);
        this.b += i;
        ((k3.e) this.c).d(jVar);
    }

    public com.gnacba.common.collect.n0 e() {
        com.gnacba.common.collect.l0 l0Var = (com.gnacba.common.collect.l0) this.d;
        if (l0Var != null) {
            throw l0Var.a();
        }
        com.gnacba.common.collect.k1 k1VarI = com.gnacba.common.collect.k1.i(this.b, (Object[]) this.c, this);
        com.gnacba.common.collect.l0 l0Var2 = (com.gnacba.common.collect.l0) this.d;
        if (l0Var2 == null) {
            return k1VarI;
        }
        throw l0Var2.a();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public boolean g() throws NoWhenBranchMatchedException {
        k3.e eVar = (k3.e) this.c;
        int i = this.b - 1;
        this.b = i;
        if (i == 0 && eVar.c != 0) {
            c1 c1Var = (c1) this.d;
            p pVar = c1Var.a;
            v2.c cVar = c1Var.b;
            y2.c cVar2 = y2.c.a;
            pVar.b.a().f();
            v2.h hVar = pVar.b;
            Object[] objArr = eVar.a;
            int i2 = eVar.c;
            for (int i3 = 0; i3 < i2; i3++) {
                ((Function1) objArr[i3]).invoke(hVar);
            }
            c1Var.o(hVar);
            p.a(pVar, cVar, false, cVar2);
            eVar.k();
        }
        return this.b > 0;
    }

    public void h(int i, int i2, Function1 function1) {
        k3.e eVar = (k3.e) this.c;
        if (i < 0 || i >= this.b) {
            StringBuilder sbR = o6.c.r(i, "Index ", ", size ");
            sbR.append(this.b);
            d2.a.e(sbR.toString());
        }
        if (i2 < 0 || i2 >= this.b) {
            StringBuilder sbR2 = o6.c.r(i2, "Index ", ", size ");
            sbR2.append(this.b);
            d2.a.e(sbR2.toString());
        }
        if (i2 < i) {
            d2.a.a("toIndex (" + i2 + ") should be not smaller than fromIndex (" + i + ')');
        }
        int iH = m.h(i, eVar);
        int i3 = ((j) eVar.a[iH]).a;
        while (i3 <= i2) {
            j jVar = (j) eVar.a[iH];
            function1.invoke(jVar);
            i3 += jVar.b;
            iH++;
        }
    }

    public String i() {
        String str = (String) this.c;
        int i = this.b;
        this.b = i + 1;
        return "nav_" + str + "_" + i;
    }

    public j j(int i) {
        if (i < 0 || i >= this.b) {
            StringBuilder sbR = o6.c.r(i, "Index ", ", size ");
            sbR.append(this.b);
            d2.a.e(sbR.toString());
        }
        j jVar = (j) this.d;
        if (jVar != null) {
            int i2 = jVar.a;
            if (i < jVar.b + i2 && i2 <= i) {
                return jVar;
            }
        }
        k3.e eVar = (k3.e) this.c;
        j jVar2 = (j) eVar.a[m.h(i, eVar)];
        this.d = jVar2;
        return jVar2;
    }

    public int k(Object obj) {
        q1.f0 f0Var = (q1.f0) this.c;
        int iD = f0Var.d(obj);
        if (iD >= 0) {
            return f0Var.c[iD];
        }
        return -1;
    }

    public Object l(int i) {
        Object[] objArr = (Object[]) this.d;
        int i2 = i - this.b;
        if (i2 < 0 || i2 >= objArr.length) {
            return null;
        }
        return objArr[i2];
    }

    public String m() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.b + 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = ((Object[]) this.c)[i2];
            if (obj instanceof yy1.h) {
                yy1.h hVar = (yy1.h) obj;
                if (!o.c(hVar.d(), yy1.l.d)) {
                    int i3 = ((int[]) this.d)[i2];
                    if (i3 >= 0) {
                        sb.append(".");
                        sb.append(hVar.f(i3));
                    }
                } else if (((int[]) this.d)[i2] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.d)[i2]);
                    sb.append("]");
                }
            } else if (obj != cz1.s.a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    public void n(int i, int i2, int i3, int i4, int i6, int i7, boolean z, boolean z2) {
        long[] jArr = (long[]) this.c;
        int i8 = this.b;
        int i9 = i8 + 3;
        this.b = i9;
        int length = jArr.length;
        if (length <= i9) {
            int iMax = Math.max(length * 2, i9);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            o.g(jArrCopyOf, "copyOf(...)");
            this.c = jArrCopyOf;
            long[] jArrCopyOf2 = Arrays.copyOf((long[]) this.d, iMax);
            o.g(jArrCopyOf2, "copyOf(...)");
            this.d = jArrCopyOf2;
        }
        long[] jArr2 = (long[]) this.c;
        jArr2[i8] = (((long) i2) << 32) | (((long) i3) & 4294967295L);
        jArr2[i8 + 1] = (((long) i4) << 32) | (((long) i6) & 4294967295L);
        int i10 = i7 & 67108863;
        jArr2[i8 + 2] = ((z2 ? 1L : 0L) << 63) | ((z ? 1L : 0L) << 62) | (((long) 1) << 61) | (((long) Math.min(0, 511)) << 52) | (((long) i10) << 26) | ((long) (i & 67108863));
        if (i7 < 0) {
            return;
        }
        for (int i11 = i8 - 3; i11 >= 0; i11 -= 3) {
            int i12 = i11 + 2;
            long j2 = jArr2[i12];
            if ((((int) j2) & 67108863) == i10) {
                jArr2[i12] = (j2 & (-2301339409586323457L)) | (((long) Math.min(i8 - i11, 511)) << 52);
                return;
            }
        }
    }

    public boolean o() {
        ColorStateList colorStateList;
        return ((Shader) this.c) == null && (colorStateList = (ColorStateList) this.d) != null && colorStateList.isStateful();
    }

    public m1 p(Object obj, Object obj2) {
        int i = (this.b + 1) * 2;
        Object[] objArr = (Object[]) this.c;
        if (i > objArr.length) {
            this.c = Arrays.copyOf(objArr, com.gnacba.common.collect.d0.f(objArr.length, i));
        }
        cd.i0.o(obj, obj2);
        Object[] objArr2 = (Object[]) this.c;
        int i2 = this.b;
        int i3 = i2 * 2;
        objArr2[i3] = obj;
        objArr2[i3 + 1] = obj2;
        this.b = i2 + 1;
        return this;
    }

    public m1 q(com.gnacba.common.collect.k1 k1Var) {
        return r(k1Var.e());
    }

    public m1 r(Iterable iterable) {
        if (iterable instanceof Collection) {
            int size = (((Collection) iterable).size() + this.b) * 2;
            Object[] objArr = (Object[]) this.c;
            if (size > objArr.length) {
                this.c = Arrays.copyOf(objArr, com.gnacba.common.collect.d0.f(objArr.length, size));
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            p(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public void s() {
        int i = this.b * 2;
        Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.c, i);
        o.g(objArrCopyOf, "copyOf(...)");
        this.c = objArrCopyOf;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = -1;
        }
        mx1.n.V(0, 0, (int[]) this.d, iArr, 14);
        this.d = iArr;
    }

    public void t(int i, Function4 function4) {
        int i2 = i & 67108863;
        long[] jArr = (long[]) this.c;
        int i3 = this.b;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i3; i4 += 3) {
            if ((((int) jArr[i4 + 2]) & 67108863) == i2) {
                long j2 = jArr[i4];
                long j3 = jArr[i4 + 1];
                function4.invoke(Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2), Integer.valueOf((int) (j3 >> 32)), Integer.valueOf((int) j3));
                return;
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 7:
                return m();
            case 11:
                StringBuilder sb = new StringBuilder();
                if (((iz1.j0) this.c) == iz1.j0.c) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(TokenParser.SP);
                sb.append(this.b);
                sb.append(TokenParser.SP);
                sb.append((String) this.d);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public Object v(int i) {
        SparseArray sparseArray = (SparseArray) this.c;
        if (this.b == -1) {
            this.b = 0;
        }
        while (true) {
            int i2 = this.b;
            if (i2 <= 0 || i >= sparseArray.keyAt(i2)) {
                break;
            }
            this.b--;
        }
        while (this.b < sparseArray.size() - 1 && i >= sparseArray.keyAt(this.b + 1)) {
            this.b++;
        }
        return sparseArray.valueAt(this.b);
    }

    public void w(Object obj, Object obj2) {
        int i = this.b + 1;
        Object[] objArr = (Object[]) this.c;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.c = Arrays.copyOf(objArr, j91.d(length, i2));
        }
        sy.l(obj, obj2);
        Object[] objArr2 = (Object[]) this.c;
        int i3 = this.b;
        int i4 = i3 + i3;
        objArr2[i4] = obj;
        objArr2[i4 + 1] = obj2;
        this.b = i3 + 1;
    }

    public pa1 y() {
        p91 p91Var = (p91) this.d;
        if (p91Var != null) {
            throw p91Var.a();
        }
        pa1 pa1VarD = pa1.d(this.b, (Object[]) this.c, this);
        p91 p91Var2 = (p91) this.d;
        if (p91Var2 == null) {
            return pa1VarD;
        }
        throw p91Var2.a();
    }

    public Object z() {
        String str = (String) this.c;
        Object obj = this.d;
        qj qjVar = (qj) ql.a.get();
        if (qjVar == null) {
            f2.y(ql.b.get());
            return obj;
        }
        SharedPreferences sharedPreferences = qjVar.a;
        int i = this.b - 1;
        if (i == 0) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            try {
                return Boolean.valueOf(sharedPreferences.getBoolean(str, zBooleanValue));
            } catch (ClassCastException unused) {
                return Boolean.valueOf(sharedPreferences.getString(str, String.valueOf(zBooleanValue)));
            }
        }
        if (i == 1) {
            try {
                return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
            } catch (ClassCastException unused2) {
                return Long.valueOf(sharedPreferences.getInt(str, (int) r3));
            }
        }
        if (i != 2) {
            return sharedPreferences.getString(str, (String) obj);
        }
        try {
            return Double.valueOf(sharedPreferences.getFloat(str, (float) r3));
        } catch (ClassCastException unused3) {
            return Double.valueOf(sharedPreferences.getString(str, String.valueOf(((Double) obj).doubleValue())));
        }
    }

    public /* synthetic */ m1(Object obj, int i, Object obj2, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
        this.d = obj2;
    }

    public /* synthetic */ m1(Object obj, Object obj2, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.d = obj2;
        this.b = i;
    }

    public m1(int i, int i2) {
        this.a = i2;
        switch (i2) {
            case 6:
                this.c = new Object[i * 2];
                this.b = 0;
                break;
            default:
                this.c = new Object[i + i];
                this.b = 0;
                break;
        }
    }

    public m1(ey1.k kVar, m mVar) {
        this.a = 1;
        m1 m1VarN = mVar.n();
        final int i = ((i) kVar).a;
        if (i < 0) {
            d2.a.c("negative nearestRange.first");
        }
        final int iMin = Math.min(((i) kVar).b, m1VarN.b - 1);
        if (iMin < i) {
            q1.f0 f0Var = q1.s0.a;
            o.f(f0Var, "null cannot be cast to non-null type tlydtdl.collection.ObjectIntMap<K of tlydtdl.collection.ObjectIntMapKt.emptyObjectIntMap>");
            this.c = f0Var;
            this.d = new Object[0];
            this.b = 0;
            return;
        }
        int i2 = (iMin - i) + 1;
        this.d = new Object[i2];
        this.b = i;
        final q1.f0 f0Var2 = new q1.f0(i2);
        m1VarN.h(i, iMin, new Function1() { // from class: tlydtdl.compose.foundation.lazy.layout.n1
            /* JADX WARN: Removed duplicated region for block: B:10:0x0043 A[LOOP:0: B:4:0x001d->B:10:0x0043, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[EDGE_INSN: B:13:0x0046->B:11:0x0046 BREAK  A[LOOP:0: B:4:0x001d->B:10:0x0043], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invoke(java.lang.Object r7) {
                /*
                    r6 = this;
                    tlydtdl.compose.foundation.lazy.layout.j r7 = (tlydtdl.compose.foundation.lazy.layout.j) r7
                    tlydtdl.compose.foundation.lazy.layout.t r0 = r7.c
                    lmjxuqdtp.jvm.functions.Function1 r0 = r0.getKey()
                    int r1 = r7.a
                    int r2 = r1
                    int r2 = java.lang.Math.max(r2, r1)
                    int r7 = r7.b
                    int r7 = r7 + r1
                    int r7 = r7 + (-1)
                    int r3 = r2
                    int r7 = java.lang.Math.min(r3, r7)
                    if (r2 > r7) goto L46
                L1d:
                    if (r0 == 0) goto L2b
                    int r3 = r2 - r1
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    java.lang.Object r3 = r0.invoke(r3)
                    if (r3 != 0) goto L30
                L2b:
                    tlydtdl.compose.foundation.lazy.layout.h r3 = new tlydtdl.compose.foundation.lazy.layout.h
                    r3.<init>(r2)
                L30:
                    q1.f0 r4 = r3
                    r4.h(r2, r3)
                    tlydtdl.compose.foundation.lazy.layout.m1 r4 = r4
                    java.lang.Object r5 = r4.d
                    java.lang.Object[] r5 = (java.lang.Object[]) r5
                    int r4 = r4.b
                    int r4 = r2 - r4
                    r5[r4] = r3
                    if (r2 == r7) goto L46
                    int r2 = r2 + 1
                    goto L1d
                L46:
                    lx1.b0 r7 = lx1.b0.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.foundation.lazy.layout.n1.invoke(java.lang.Object):java.lang.Object");
            }
        });
        this.c = f0Var2;
    }

    public m1(String str) {
        this.a = 15;
        o.h(str, "identifier");
        this.c = str;
        this.d = new LinkedHashSet();
    }

    public m1(c1 c1Var) {
        this.a = 14;
        this.d = c1Var;
        this.c = new k3.e(0, new Function1[16]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m1(int i, byte b) {
        this(4, 4);
        this.a = i;
        switch (i) {
            case 4:
                break;
            case 5:
                ez1 ez1Var = ez1.d;
                this.c = new SparseArray();
                this.d = ez1Var;
                this.b = -1;
                break;
            default:
                this.c = new k3.e(0, new j[16]);
                break;
        }
    }

    public m1(String str, int i) {
        this.a = 10;
        this.c = str;
        this.b = i;
    }
}
