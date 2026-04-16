package x5;

import v5.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static final boolean[] a = new boolean[3];

    public static void a(e eVar, v5.c cVar, d dVar) {
        dVar.o = -1;
        c cVar2 = dVar.M;
        int[] iArr = dVar.p0;
        c cVar3 = dVar.L;
        c cVar4 = dVar.J;
        c cVar5 = dVar.K;
        c cVar6 = dVar.I;
        dVar.p = -1;
        int[] iArr2 = eVar.p0;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = cVar6.g;
            int iQ = eVar.q() - cVar5.g;
            cVar6.i = cVar.k(cVar6);
            cVar5.i = cVar.k(cVar5);
            cVar.d(cVar6.i, i);
            cVar.d(cVar5.i, iQ);
            dVar.o = 2;
            dVar.Y = i;
            int i2 = iQ - i;
            dVar.U = i2;
            int i3 = dVar.b0;
            if (i2 < i3) {
                dVar.U = i3;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i4 = cVar4.g;
        int iK = eVar.k() - cVar3.g;
        cVar4.i = cVar.k(cVar4);
        cVar3.i = cVar.k(cVar3);
        cVar.d(cVar4.i, i4);
        cVar.d(cVar3.i, iK);
        if (dVar.a0 > 0 || dVar.g0 == 8) {
            f fVarK = cVar.k(cVar2);
            cVar2.i = fVarK;
            cVar.d(fVarK, dVar.a0 + i4);
        }
        dVar.p = 2;
        dVar.Z = i4;
        int i6 = iK - i4;
        dVar.V = i6;
        int i7 = dVar.c0;
        if (i6 < i7) {
            dVar.V = i7;
        }
    }

    public static final boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
