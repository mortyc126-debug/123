package tlydtdl.compose.runtime;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 {
    public final ArrayList a;
    public final int b;
    public int c;
    public final ArrayList d;
    public final q1.z e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final lx1.q f546f;

    public t1(int i, ArrayList arrayList) {
        this.a = arrayList;
        this.b = i;
        if (i < 0) {
            v1.a("Invalid start index");
        }
        this.d = new ArrayList();
        q1.z zVar = new q1.z();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            t0 t0Var = (t0) this.a.get(i3);
            int i4 = t0Var.c;
            int i6 = t0Var.d;
            zVar.h(i4, new m0(i3, i2, i6));
            i2 += i6;
        }
        this.e = zVar;
        this.f546f = hs1.d.F(new s1(0, this));
    }

    public final boolean a(int i, int i2) {
        int i3;
        q1.z zVar = this.e;
        m0 m0Var = (m0) zVar.b(i);
        if (m0Var == null) {
            return false;
        }
        int i4 = m0Var.b;
        int i6 = i2 - m0Var.c;
        m0Var.c = i2;
        if (i6 == 0) {
            return true;
        }
        Object[] objArr = ((q1.n) zVar).c;
        long[] jArr = ((q1.n) zVar).a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i7 = 0;
        while (true) {
            long j2 = jArr[i7];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i7 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j2) < 128) {
                        m0 m0Var2 = (m0) objArr[(i7 << 3) + i9];
                        if (m0Var2.b >= i4 && !m0Var2.equals(m0Var) && (i3 = m0Var2.b + i6) >= 0) {
                            m0Var2.b = i3;
                        }
                    }
                    j2 >>= 8;
                }
                if (i8 != 8) {
                    return true;
                }
            }
            if (i7 == length) {
                return true;
            }
            i7++;
        }
    }
}
