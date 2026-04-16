package x5;

import b02.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.net.ftp.FTPReply;
import qe0.m;
import qu0.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends d {
    public int A0;
    public b[] B0;
    public b[] C0;
    public int D0;
    public boolean E0;
    public boolean F0;
    public WeakReference G0;
    public WeakReference H0;
    public WeakReference I0;
    public WeakReference J0;
    public final HashSet K0;
    public final y5.b L0;
    public ArrayList q0 = new ArrayList();
    public final u r0 = new u(this);
    public final n s0;
    public int t0;
    public a6.e u0;
    public boolean v0;
    public final v5.c w0;
    public int x0;
    public int y0;
    public int z0;

    public e() {
        n nVar = new n();
        nVar.b = true;
        nVar.c = true;
        nVar.f = new ArrayList();
        new ArrayList();
        nVar.g = null;
        nVar.h = new y5.b();
        nVar.i = new ArrayList();
        nVar.d = this;
        nVar.e = this;
        this.s0 = nVar;
        this.u0 = null;
        this.v0 = false;
        this.w0 = new v5.c();
        this.z0 = 0;
        this.A0 = 0;
        this.B0 = new b[4];
        this.C0 = new b[4];
        this.D0 = FTPReply.PATHNAME_CREATED;
        this.E0 = false;
        this.F0 = false;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = new HashSet();
        this.L0 = new y5.b();
    }

    public static void V(d dVar, a6.e eVar, y5.b bVar) {
        int i;
        int i2;
        if (eVar == null) {
            return;
        }
        int i3 = dVar.g0;
        int[] iArr = dVar.t;
        if (i3 == 8 || (dVar instanceof h) || (dVar instanceof a)) {
            bVar.e = 0;
            bVar.f700f = 0;
            return;
        }
        int[] iArr2 = dVar.p0;
        bVar.a = iArr2[0];
        bVar.b = iArr2[1];
        bVar.c = dVar.q();
        bVar.d = dVar.k();
        bVar.i = false;
        bVar.f701j = 0;
        boolean z = bVar.a == 3;
        boolean z2 = bVar.b == 3;
        boolean z3 = z && dVar.W > 0.0f;
        boolean z4 = z2 && dVar.W > 0.0f;
        if (z && dVar.t(0) && dVar.r == 0 && !z3) {
            bVar.a = 2;
            if (z2 && dVar.s == 0) {
                bVar.a = 1;
            }
            z = false;
        }
        if (z2 && dVar.t(1) && dVar.s == 0 && !z4) {
            bVar.b = 2;
            if (z && dVar.r == 0) {
                bVar.b = 1;
            }
            z2 = false;
        }
        if (dVar.A()) {
            bVar.a = 1;
            z = false;
        }
        if (dVar.B()) {
            bVar.b = 1;
            z2 = false;
        }
        if (z3) {
            if (iArr[0] == 4) {
                bVar.a = 1;
            } else if (!z2) {
                if (bVar.b == 1) {
                    i2 = bVar.d;
                } else {
                    bVar.a = 2;
                    eVar.b(dVar, bVar);
                    i2 = bVar.f700f;
                }
                bVar.a = 1;
                bVar.c = (int) (dVar.W * i2);
            }
        }
        if (z4) {
            if (iArr[1] == 4) {
                bVar.b = 1;
            } else if (!z) {
                if (bVar.a == 1) {
                    i = bVar.c;
                } else {
                    bVar.b = 2;
                    eVar.b(dVar, bVar);
                    i = bVar.e;
                }
                bVar.b = 1;
                if (dVar.X == -1) {
                    bVar.d = (int) (i / dVar.W);
                } else {
                    bVar.d = (int) (dVar.W * i);
                }
            }
        }
        eVar.b(dVar, bVar);
        dVar.O(bVar.e);
        dVar.L(bVar.f700f);
        dVar.E = bVar.h;
        dVar.I(bVar.g);
        bVar.f701j = 0;
    }

    @Override // x5.d
    public final void C() {
        this.w0.t();
        this.x0 = 0;
        this.y0 = 0;
        this.q0.clear();
        super.C();
    }

    @Override // x5.d
    public final void F(u uVar) {
        super.F(uVar);
        int size = this.q0.size();
        for (int i = 0; i < size; i++) {
            ((d) this.q0.get(i)).F(uVar);
        }
    }

    @Override // x5.d
    public final void P(boolean z, boolean z2) {
        super.P(z, z2);
        int size = this.q0.size();
        for (int i = 0; i < size; i++) {
            ((d) this.q0.get(i)).P(z, z2);
        }
    }

    public final void R(d dVar, int i) {
        if (i == 0) {
            int i2 = this.z0 + 1;
            b[] bVarArr = this.C0;
            if (i2 >= bVarArr.length) {
                this.C0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.C0;
            int i3 = this.z0;
            bVarArr2[i3] = new b(dVar, 0, this.v0);
            this.z0 = i3 + 1;
            return;
        }
        if (i == 1) {
            int i4 = this.A0 + 1;
            b[] bVarArr3 = this.B0;
            if (i4 >= bVarArr3.length) {
                this.B0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.B0;
            int i6 = this.A0;
            bVarArr4[i6] = new b(dVar, 1, this.v0);
            this.A0 = i6 + 1;
        }
    }

    public final void S(v5.c cVar) {
        e eVar;
        v5.c cVar2;
        boolean zW = W(64);
        b(cVar, zW);
        int size = this.q0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            d dVar = (d) this.q0.get(i);
            boolean[] zArr = dVar.S;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                d dVar2 = (d) this.q0.get(i2);
                if (dVar2 instanceof a) {
                    a aVar = (a) dVar2;
                    for (int i3 = 0; i3 < aVar.r0; i3++) {
                        d dVar3 = aVar.q0[i3];
                        if (aVar.t0 || dVar3.c()) {
                            int i4 = aVar.s0;
                            if (i4 == 0 || i4 == 1) {
                                dVar3.S[0] = true;
                            } else if (i4 == 2 || i4 == 3) {
                                dVar3.S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.K0;
        hashSet.clear();
        for (int i6 = 0; i6 < size; i6++) {
            d dVar4 = (d) this.q0.get(i6);
            dVar4.getClass();
            boolean z2 = dVar4 instanceof k;
            if (z2 || (dVar4 instanceof h)) {
                if (z2) {
                    hashSet.add(dVar4);
                } else {
                    dVar4.b(cVar, zW);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k kVar = (k) ((d) it.next());
                for (int i7 = 0; i7 < kVar.r0; i7++) {
                    if (hashSet.contains(kVar.q0[i7])) {
                        kVar.b(cVar, zW);
                        hashSet.remove(kVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).b(cVar, zW);
                }
                hashSet.clear();
            }
        }
        if (v5.c.q) {
            HashSet<d> hashSet2 = new HashSet();
            for (int i8 = 0; i8 < size; i8++) {
                d dVar5 = (d) this.q0.get(i8);
                dVar5.getClass();
                if (!(dVar5 instanceof k) && !(dVar5 instanceof h)) {
                    hashSet2.add(dVar5);
                }
            }
            eVar = this;
            cVar2 = cVar;
            eVar.a(this, cVar2, hashSet2, this.p0[0] == 2 ? 0 : 1, false);
            for (d dVar6 : hashSet2) {
                j.a(this, cVar2, dVar6);
                dVar6.b(cVar2, zW);
            }
        } else {
            eVar = this;
            cVar2 = cVar;
            for (int i9 = 0; i9 < size; i9++) {
                d dVar7 = (d) eVar.q0.get(i9);
                if (dVar7 instanceof e) {
                    int[] iArr = dVar7.p0;
                    int i10 = iArr[0];
                    int i11 = iArr[1];
                    if (i10 == 2) {
                        dVar7.M(1);
                    }
                    if (i11 == 2) {
                        dVar7.N(1);
                    }
                    dVar7.b(cVar2, zW);
                    if (i10 == 2) {
                        dVar7.M(i10);
                    }
                    if (i11 == 2) {
                        dVar7.N(i11);
                    }
                } else {
                    j.a(this, cVar2, dVar7);
                    if (!(dVar7 instanceof k) && !(dVar7 instanceof h)) {
                        dVar7.b(cVar2, zW);
                    }
                }
            }
        }
        if (eVar.z0 > 0) {
            m.n(this, cVar2, (ArrayList) null, 0);
        }
        if (eVar.A0 > 0) {
            m.n(this, cVar2, (ArrayList) null, 1);
        }
    }

    public final boolean T(int i, boolean z) {
        boolean z2;
        boolean z3;
        n nVar = this.s0;
        ArrayList<y5.n> arrayList = (ArrayList) nVar.f;
        e eVar = (e) nVar.d;
        boolean z4 = false;
        int iJ = eVar.j(0);
        int[] iArr = eVar.p0;
        int iJ2 = eVar.j(1);
        int iR = eVar.r();
        int iS = eVar.s();
        if (z && (iJ == 2 || iJ2 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = z;
                    break;
                }
                y5.n nVar2 = (y5.n) it.next();
                if (nVar2.f702f == i && !nVar2.k()) {
                    z3 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z3 && iJ == 2) {
                    eVar.M(1);
                    eVar.O(nVar.d(eVar, 0));
                    eVar.d.e.d(eVar.q());
                }
            } else if (z3 && iJ2 == 2) {
                eVar.N(1);
                eVar.L(nVar.d(eVar, 1));
                eVar.e.e.d(eVar.k());
            }
        }
        if (i == 0) {
            int i2 = iArr[0];
            if (i2 == 1 || i2 == 4) {
                int iQ = eVar.q() + iR;
                eVar.d.i.d(iQ);
                eVar.d.e.d(iQ - iR);
                z2 = true;
            }
            z2 = false;
        } else {
            int i3 = iArr[1];
            if (i3 == 1 || i3 == 4) {
                int iK = eVar.k() + iS;
                eVar.e.i.d(iK);
                eVar.e.e.d(iK - iS);
                z2 = true;
            }
            z2 = false;
        }
        nVar.j();
        for (y5.n nVar3 : arrayList) {
            if (nVar3.f702f == i && (nVar3.b != eVar || nVar3.g)) {
                nVar3.e();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z4 = true;
                break;
            }
            y5.n nVar4 = (y5.n) it2.next();
            if (nVar4.f702f == i && (z2 || nVar4.b != eVar)) {
                if (!nVar4.h.j || !nVar4.i.j || (!(nVar4 instanceof y5.c) && !((y5.e) nVar4.e).j)) {
                    break;
                }
            }
        }
        eVar.M(iJ);
        eVar.N(iJ2);
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:660:0x0529  */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX WARN: Type inference failed for: r0v83 */
    /* JADX WARN: Type inference failed for: r0v84 */
    /* JADX WARN: Type inference failed for: r0v85 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v88 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r13v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v15 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v17 */
    /* JADX WARN: Type inference failed for: r20v18 */
    /* JADX WARN: Type inference failed for: r20v19 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v20 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void U() {
        /*
            Method dump skipped, instruction units count: 1354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.e.U():void");
    }

    public final boolean W(int i) {
        return (this.D0 & i) == i;
    }

    @Override // x5.d
    public final void n(StringBuilder sb) {
        sb.append(this.f688j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.V);
        sb.append("\n");
        Iterator it = this.q0.iterator();
        while (it.hasNext()) {
            ((d) it.next()).n(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
