package tlydtdl.compose.runtime;

import amuvvoafs.os.Trace;
import com.gnacba.amuvvoafs.gms.internal.measurement.j4;
import j3.b;
import j3.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function2;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.http.HttpStatus;
import q1.n0;
import q3.k;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements m {
    public int A;
    public int B;
    public boolean C;
    public final r D;
    public final ArrayList E;
    public boolean F;
    public n2 G;
    public o2 H;
    public r2 I;
    public boolean J;
    public u1 K;
    public j3.a L;
    public final b M;
    public a N;
    public j3.c O;
    public m2 P;
    public final tlydtdl.compose.runtime.tooling.c Q;
    public final qx1.i R;
    public boolean S;
    public long T;
    public y U;
    public final qu0.u a;
    public final w b;
    public final o2 c;
    public final q1.q0 d;
    public final j3.a e;

    /* JADX INFO: renamed from: f */
    public final j3.a f544f;
    public final ru1.c g;
    public final z h;

    /* JADX INFO: renamed from: j */
    public t1 f545j;
    public int k;
    public int l;
    public int m;
    public int[] o;
    public q1.x p;
    public boolean q;
    public boolean r;
    public q1.z v;
    public boolean w;
    public boolean y;
    public final ArrayList i = new ArrayList();
    public final p0 n = new p0(0, false);
    public final ArrayList s = new ArrayList();
    public final p0 t = new p0(0, false);
    public u1 u = q3.o.d;
    public final p0 x = new p0(0, false);
    public int z = -1;

    public s(qu0.u uVar, w wVar, o2 o2Var, q1.q0 q0Var, j3.a aVar, j3.a aVar2, ru1.c cVar, z zVar) {
        this.a = uVar;
        this.b = wVar;
        this.c = o2Var;
        this.d = q0Var;
        this.e = aVar;
        this.f544f = aVar2;
        this.g = cVar;
        this.h = zVar;
        this.C = wVar.g() || wVar.e();
        this.D = new r(0, this);
        this.E = new ArrayList();
        n2 n2VarE = o2Var.e();
        n2VarE.c();
        this.G = n2VarE;
        o2 o2Var2 = new o2();
        if (wVar.g()) {
            o2Var2.d();
        }
        if (wVar.e()) {
            o2Var2.k = new q1.z();
        }
        this.H = o2Var2;
        r2 r2VarH = o2Var2.h();
        r2VarH.e(true);
        this.I = r2VarH;
        this.M = new b(this, aVar);
        n2 n2VarE2 = this.H.e();
        try {
            a aVarA = n2VarE2.a(0);
            n2VarE2.c();
            this.N = aVarA;
            this.O = new j3.c();
            this.Q = new tlydtdl.compose.runtime.tooling.c(this);
            qx1.i iVarK = wVar.k();
            qx1.j jVarE = E();
            this.R = iVarK.plus(jVarE == null ? qx1.j.a : jVarE);
        } catch (Throwable th) {
            n2VarE2.c();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final tlydtdl.compose.runtime.c1 T(int r13, tlydtdl.compose.runtime.s r14) {
        /*
            tlydtdl.compose.runtime.n2 r0 = r14.G
            int r0 = r0.i(r13)
            tlydtdl.compose.runtime.n2 r1 = r14.G
            int[] r2 = r1.b
            java.lang.Object r1 = r1.p(r13, r2)
            r2 = 126665345(0x78cc281, float:2.1179178E-34)
            r3 = 0
            if (r0 != r2) goto L96
            boolean r0 = r1 instanceof tlydtdl.compose.runtime.a1
            if (r0 == 0) goto L96
            tlydtdl.compose.runtime.n2 r0 = r14.G
            boolean r0 = r0.d(r13)
            if (r0 == 0) goto L30
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            U(r14, r0, r13)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L30
            r12 = r0
            goto L31
        L30:
            r12 = r3
        L31:
            tlydtdl.compose.runtime.n2 r0 = r14.G
            int[] r1 = r0.b
            java.lang.Object r0 = r0.p(r13, r1)
            java.lang.String r1 = "null cannot be cast to non-null type tlydtdl.compose.runtime.MovableContent<lmjxuqdtp.Any?>"
            lmjxuqdtp.jvm.internal.o.f(r0, r1)
            r5 = r0
            tlydtdl.compose.runtime.a1 r5 = (tlydtdl.compose.runtime.a1) r5
            tlydtdl.compose.runtime.n2 r0 = r14.G
            r1 = 0
            java.lang.Object r6 = r0.h(r13, r1)
            tlydtdl.compose.runtime.n2 r0 = r14.G
            tlydtdl.compose.runtime.a r9 = r0.a(r13)
            tlydtdl.compose.runtime.n2 r0 = r14.G
            int[] r0 = r0.b
            int r1 = r13 * 5
            int r1 = r1 + 3
            r0 = r0[r1]
            int r0 = r0 + r13
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r1 = r14.s
            int r2 = tlydtdl.compose.runtime.u.f(r13, r1)
            if (r2 >= 0) goto L69
            int r2 = r2 + 1
            int r2 = -r2
        L69:
            int r3 = r1.size()
            if (r2 >= r3) goto L88
            java.lang.Object r3 = r1.get(r2)
            tlydtdl.compose.runtime.q0 r3 = (tlydtdl.compose.runtime.q0) r3
            int r4 = r3.b
            if (r4 >= r0) goto L88
            tlydtdl.compose.runtime.a2 r4 = r3.a
            java.lang.Object r3 = r3.c
            lx1.l r7 = new lx1.l
            r7.<init>(r4, r3)
            r10.add(r7)
            int r2 = r2 + 1
            goto L69
        L88:
            tlydtdl.compose.runtime.c1 r4 = new tlydtdl.compose.runtime.c1
            tlydtdl.compose.runtime.z r7 = r14.h
            tlydtdl.compose.runtime.o2 r8 = r14.c
            tlydtdl.compose.runtime.u1 r11 = r14.n(r13)
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            return r4
        L96:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.T(int, tlydtdl.compose.runtime.s):tlydtdl.compose.runtime.c1");
    }

    public static final void U(s sVar, ArrayList arrayList, int i) {
        int i2 = sVar.G.b[(i * 5) + 3] + i;
        int i3 = i + 1;
        while (i3 < i2) {
            if (sVar.G.j(i3)) {
                c1 c1VarT = T(i3, sVar);
                if (c1VarT != null) {
                    arrayList.add(c1VarT);
                }
            } else if (sVar.G.d(i3)) {
                U(sVar, arrayList, i3);
            }
            i3 += sVar.G.b[(i3 * 5) + 3];
        }
    }

    public static final int V(s sVar, int i, int i2, boolean z, int i3) {
        n2 n2Var = sVar.G;
        w wVar = sVar.b;
        b bVar = sVar.M;
        boolean zJ = n2Var.j(i2);
        int[] iArr = n2Var.b;
        if (zJ) {
            int i4 = n2Var.i(i2);
            Object objP = n2Var.p(i2, iArr);
            if (i4 == 126665345 && (objP instanceof a1)) {
                c1 c1VarT = T(i2, sVar);
                if (c1VarT != null) {
                    wVar.c(c1VarT);
                    bVar.e();
                    z zVar = sVar.h;
                    w wVar2 = sVar.b;
                    j3.m0 m0Var = bVar.b.b;
                    m0Var.M0(j3.w.c);
                    tlydtdl.datastore.preferences.protobuf.j1.C(m0Var, zVar, wVar2, c1VarT);
                }
                if (!z || i2 == i) {
                    return n2Var.o(i2);
                }
                bVar.c();
                bVar.b();
                s sVar2 = bVar.a;
                int iO = sVar2.G.l(i2) ? 1 : sVar2.G.o(i2);
                if (iO > 0) {
                    bVar.f(i3, iO);
                }
                return 0;
            }
            if (i4 == 206 && lmjxuqdtp.jvm.internal.o.c(objP, u.e)) {
                Object objH = n2Var.h(i2, 0);
                p pVar = objH instanceof p ? (p) objH : null;
                if (pVar != null) {
                    for (s sVar3 : pVar.a.e) {
                        o2 o2Var = sVar3.c;
                        if (o2Var.b > 0 && (o2Var.a[1] & 67108864) != 0) {
                            z zVar2 = sVar3.h;
                            synchronized (zVar2.d) {
                                zVar2.s();
                                n0 n0Var = zVar2.n;
                                zVar2.n = j4.j();
                                try {
                                    zVar2.v.m0(n0Var);
                                } finally {
                                }
                            }
                            j3.a aVar = new j3.a();
                            sVar3.L = aVar;
                            n2 n2VarE = sVar3.c.e();
                            try {
                                sVar3.G = n2VarE;
                                b bVar2 = sVar3.M;
                                j3.a aVar2 = bVar2.b;
                                try {
                                    bVar2.b = aVar;
                                    sVar3.S(0);
                                    b bVar3 = sVar3.M;
                                    bVar3.b();
                                    if (bVar3.c) {
                                        bVar3.b.b.M0(j3.d0.c);
                                        if (bVar3.c) {
                                            bVar3.d(false);
                                            bVar3.d(false);
                                            bVar3.b.b.M0(j3.m.c);
                                            bVar3.c = false;
                                        }
                                    }
                                } finally {
                                }
                            } finally {
                                n2VarE.c();
                            }
                        }
                        wVar.t(sVar3.h);
                    }
                }
                return n2Var.o(i2);
            }
            if (!n2Var.l(i2)) {
                return n2Var.o(i2);
            }
        } else if (n2Var.d(i2)) {
            int i6 = iArr[(i2 * 5) + 3] + i2;
            int iV = 0;
            for (int i7 = i2 + 1; i7 < i6; i7 += iArr[(i7 * 5) + 3]) {
                boolean zL = n2Var.l(i7);
                if (zL) {
                    bVar.c();
                    Object objN = n2Var.n(i7);
                    bVar.c();
                    bVar.h.add(objN);
                }
                iV += V(sVar, i, i7, zL || z, zL ? 0 : i3 + iV);
                if (zL) {
                    bVar.c();
                    bVar.a();
                }
            }
            if (!n2Var.l(i2)) {
                return iV;
            }
        } else if (!n2Var.l(i2)) {
            return n2Var.o(i2);
        }
        return 1;
    }

    public final void A() {
        o2 o2Var = new o2();
        if (this.C) {
            o2Var.d();
        }
        if (this.b.e()) {
            o2Var.k = new q1.z();
        }
        this.H = o2Var;
        r2 r2VarH = o2Var.h();
        r2VarH.e(true);
        this.I = r2VarH;
    }

    public final int B() {
        return this.S ? -this.I.v : this.G.i;
    }

    public final a2 C() {
        if (this.A != 0) {
            return null;
        }
        ArrayList arrayList = this.E;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (a2) o6.c.h(1, arrayList);
    }

    public final boolean D() {
        if (!G() || this.w) {
            return true;
        }
        a2 a2VarC = C();
        return (a2VarC == null || (a2VarC.b & 4) == 0) ? false : true;
    }

    public final tlydtdl.compose.runtime.tooling.c E() {
        if (this.C) {
            return this.Q;
        }
        return null;
    }

    public final boolean F() {
        return this.S;
    }

    public final boolean G() {
        a2 a2VarC;
        return (this.S || this.y || this.w || (a2VarC = C()) == null || (a2VarC.b & 8) != 0) ? false : true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(3:(3:(4:(4:(42:196|(1:198)|199|(1:201)(1:202)|203|(1:205)(1:206)|(1:208)|211|305|212|213|(4:215|(1:217)(1:218)|219|(1:221))(1:222)|223|293|224|286|225|313|226|227|303|228|229|291|230|231|288|232|233|311|234|235|309|236|307|237|301|238|(1:240)|297|241|242)(1:209)|297|241|242)|301|238|(0))|307|237)|309|236)|288|232|233|311|234|235) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:(4:(17:(42:196|(1:198)|199|(1:201)(1:202)|203|(1:205)(1:206)|(1:208)|211|305|212|213|(4:215|(1:217)(1:218)|219|(1:221))(1:222)|223|293|224|286|225|313|226|227|303|228|229|291|230|231|288|232|233|311|234|235|309|236|307|237|301|238|(1:240)|297|241|242)(1:209)|288|232|233|311|234|235|309|236|307|237|301|238|(0)|297|241|242)|291|230|231)|286|225|313|226|227|303|228|229) */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x021e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x021f, code lost:
    
        r17 = r8;
        r8 = r3;
        r14 = r5;
        r7 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0238, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0239, code lost:
    
        r7 = r2;
        r14 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:215:0x012c A[Catch: all -> 0x00b0, TryCatch #3 {all -> 0x00b0, blocks: (B:161:0x000c, B:163:0x001c, B:165:0x004f, B:167:0x0057, B:169:0x005d, B:170:0x0062, B:171:0x0065, B:182:0x00a4, B:243:0x0204, B:189:0x00ba, B:190:0x00bd, B:191:0x00be, B:193:0x00c6, B:196:0x00cd, B:198:0x00d5, B:199:0x00da, B:203:0x00e4, B:205:0x00f1, B:210:0x0111, B:211:0x0113, B:213:0x0123, B:215:0x012c, B:217:0x0137, B:219:0x0148, B:221:0x014e, B:223:0x0161, B:242:0x0201, B:274:0x0255, B:275:0x0258, B:277:0x025a, B:278:0x025d, B:206:0x00ff, B:202:0x00df, B:194:0x00c9, B:279:0x025e, B:212:0x011c), top: B:290:0x000c, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01ef A[Catch: all -> 0x0218, TRY_LEAVE, TryCatch #9 {all -> 0x0218, blocks: (B:238:0x01e2, B:240:0x01ef, B:266:0x0244, B:267:0x0246), top: B:301:0x01e2 }] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H(java.util.ArrayList r25) {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.H(java.util.ArrayList):void");
    }

    public final void I(a1 a1Var, u1 u1Var, Object obj, boolean z) {
        d0(126665345, a1Var);
        J();
        r0(obj);
        long j2 = this.T;
        try {
            this.T = 126665345;
            if (this.S) {
                r2.y(this.I);
            }
            boolean z2 = (this.S || lmjxuqdtp.jvm.internal.o.c(this.G.f(), u1Var)) ? false : true;
            if (z2) {
                P(u1Var);
            }
            a0(202, u.c, u1Var, 0);
            this.K = null;
            if (!this.S || z) {
                boolean z3 = this.w;
                this.w = z2;
                q3.p.c(this, new k(new tlydtdl.compose.foundation.layout.z(3, a1Var, obj), true, 316014703));
                this.w = z3;
            } else {
                this.J = true;
                r2 r2Var = this.I;
                this.b.l(new c1(a1Var, obj, this.h, this.H, r2Var.b(r2Var.F(r2Var.v, r2Var.b)), mx1.t.a, m(), null));
            }
        } catch (Throwable th) {
            try {
                m8.d.Q(th, new o(1, this));
                throw th;
            } finally {
                r(false);
                this.K = null;
                this.T = j2;
                r(false);
            }
        }
    }

    public final Object J() {
        boolean z = this.S;
        x0 x0Var = l.a;
        if (!z) {
            Object objM = this.G.m();
            if (!this.y || (objM instanceof p)) {
                return objM;
            }
        } else if (this.r) {
            u.c("A call to createNode(), emitNode() or useNode() expected");
            return x0Var;
        }
        return x0Var;
    }

    public final List K() {
        o2 o2Var;
        Integer numF;
        w wVar = this.b;
        v vVarI = wVar.i();
        z zVar = vVarI != null ? (z) vVarI : null;
        if (zVar == null || (numF = pa0.m.F((o2Var = zVar.f550f), wVar)) == null) {
            return mx1.t.a;
        }
        n2 n2VarE = o2Var.e();
        try {
            return pa0.m.T(n2VarE, numF.intValue(), 0);
        } finally {
            n2VarE.c();
        }
    }

    public final int L(int i) {
        int iQ = this.G.q(i) + 1;
        int i2 = 0;
        while (iQ < i) {
            if (!this.G.k(iQ)) {
                i2++;
            }
            iQ += q2.a(iQ, this.G.b);
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0059 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:43:0x0005, B:46:0x0012, B:48:0x0020, B:52:0x0029, B:51:0x0026, B:55:0x0030, B:58:0x0038, B:61:0x0040, B:63:0x0048, B:65:0x004e, B:66:0x0052, B:67:0x0053, B:69:0x0059, B:62:0x0044), top: B:74:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M(tlydtdl.compose.runtime.z r9, tlydtdl.compose.runtime.z r10, java.lang.Integer r11, java.util.List r12, lmjxuqdtp.jvm.functions.Function0 r13) {
        /*
            r8 = this;
            boolean r0 = r8.F
            int r1 = r8.k
            r2 = 1
            r8.F = r2     // Catch: java.lang.Throwable -> L24
            r2 = 0
            r8.k = r2     // Catch: java.lang.Throwable -> L24
            int r3 = r12.size()     // Catch: java.lang.Throwable -> L24
            r4 = r2
        Lf:
            r5 = 0
            if (r4 >= r3) goto L2c
            java.lang.Object r6 = r12.get(r4)     // Catch: java.lang.Throwable -> L24
            lx1.l r6 = (lx1.l) r6     // Catch: java.lang.Throwable -> L24
            java.lang.Object r7 = r6.a     // Catch: java.lang.Throwable -> L24
            tlydtdl.compose.runtime.a2 r7 = (tlydtdl.compose.runtime.a2) r7     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r6.b     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L26
            r8.l0(r7, r6)     // Catch: java.lang.Throwable -> L24
            goto L29
        L24:
            r9 = move-exception
            goto L62
        L26:
            r8.l0(r7, r5)     // Catch: java.lang.Throwable -> L24
        L29:
            int r4 = r4 + 1
            goto Lf
        L2c:
            if (r9 == 0) goto L59
            if (r11 == 0) goto L35
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L24
            goto L36
        L35:
            r11 = -1
        L36:
            if (r10 == 0) goto L53
            boolean r12 = r10.equals(r9)     // Catch: java.lang.Throwable -> L24
            if (r12 != 0) goto L53
            if (r11 < 0) goto L53
            r9.r = r10     // Catch: java.lang.Throwable -> L24
            r9.s = r11     // Catch: java.lang.Throwable -> L24
            java.lang.Object r10 = r13.invoke()     // Catch: java.lang.Throwable -> L4d
            r9.r = r5     // Catch: java.lang.Throwable -> L24
            r9.s = r2     // Catch: java.lang.Throwable -> L24
            goto L57
        L4d:
            r10 = move-exception
            r9.r = r5     // Catch: java.lang.Throwable -> L24
            r9.s = r2     // Catch: java.lang.Throwable -> L24
            throw r10     // Catch: java.lang.Throwable -> L24
        L53:
            java.lang.Object r10 = r13.invoke()     // Catch: java.lang.Throwable -> L24
        L57:
            if (r10 != 0) goto L5d
        L59:
            java.lang.Object r10 = r13.invoke()     // Catch: java.lang.Throwable -> L24
        L5d:
            r8.F = r0
            r8.k = r1
            return r10
        L62:
            r8.F = r0
            r8.k = r1
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.M(tlydtdl.compose.runtime.z, tlydtdl.compose.runtime.z, java.lang.Integer, java.util.List, lmjxuqdtp.jvm.functions.Function0):java.lang.Object");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:212:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x032e  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N() {
        /*
            Method dump skipped, instruction units count: 884
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.N():void");
    }

    public final void O() {
        S(this.G.g);
        b bVar = this.M;
        bVar.d(false);
        bVar.e();
        bVar.b.b.M0(j3.z.c);
        int i = bVar.f;
        n2 n2Var = bVar.a.G;
        bVar.f = n2Var.b[(n2Var.g * 5) + 3] + i;
    }

    public final void P(u1 u1Var) {
        q1.z zVar = this.v;
        if (zVar == null) {
            zVar = new q1.z();
            this.v = zVar;
        }
        zVar.h(this.G.g, u1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void Q(int r7, int r8, int r9) {
        /*
            r6 = this;
            tlydtdl.compose.runtime.n2 r0 = r6.G
            if (r7 != r8) goto L5
            goto L1a
        L5:
            if (r7 == r9) goto L6b
            if (r8 != r9) goto Lb
            goto L6b
        Lb:
            int r1 = r0.q(r7)
            if (r1 != r8) goto L14
            r9 = r8
            goto L6b
        L14:
            int r1 = r0.q(r8)
            if (r1 != r7) goto L1c
        L1a:
            r9 = r7
            goto L6b
        L1c:
            int r1 = r0.q(r7)
            int r2 = r0.q(r8)
            if (r1 != r2) goto L2b
            int r9 = r0.q(r7)
            goto L6b
        L2b:
            r1 = 0
            r2 = r7
            r3 = r1
        L2e:
            if (r2 <= 0) goto L39
            if (r2 == r9) goto L39
            int r2 = r0.q(r2)
            int r3 = r3 + 1
            goto L2e
        L39:
            r2 = r8
            r4 = r1
        L3b:
            if (r2 <= 0) goto L46
            if (r2 == r9) goto L46
            int r2 = r0.q(r2)
            int r4 = r4 + 1
            goto L3b
        L46:
            int r9 = r3 - r4
            r5 = r7
            r2 = r1
        L4a:
            if (r2 >= r9) goto L53
            int r5 = r0.q(r5)
            int r2 = r2 + 1
            goto L4a
        L53:
            int r4 = r4 - r3
            r9 = r8
        L55:
            if (r1 >= r4) goto L5e
            int r9 = r0.q(r9)
            int r1 = r1 + 1
            goto L55
        L5e:
            r1 = r9
            r9 = r5
        L60:
            if (r9 == r1) goto L6b
            int r9 = r0.q(r9)
            int r1 = r0.q(r1)
            goto L60
        L6b:
            if (r7 <= 0) goto L7f
            if (r7 == r9) goto L7f
            boolean r1 = r0.l(r7)
            if (r1 == 0) goto L7a
            j3.b r1 = r6.M
            r1.a()
        L7a:
            int r7 = r0.q(r7)
            goto L6b
        L7f:
            r6.q(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.Q(int, int, int):void");
    }

    public final Object R() {
        boolean z = this.S;
        x0 x0Var = l.a;
        if (!z) {
            Object objM = this.G.m();
            if (!this.y || (objM instanceof p)) {
                return objM instanceof j2 ? ((j2) objM).a : objM;
            }
        } else if (this.r) {
            u.c("A call to createNode(), emitNode() or useNode() expected");
            return x0Var;
        }
        return x0Var;
    }

    public final void S(int i) {
        boolean zL = this.G.l(i);
        b bVar = this.M;
        if (zL) {
            bVar.c();
            Object objN = this.G.n(i);
            bVar.c();
            bVar.h.add(objN);
        }
        V(this, i, i, zL, 0);
        bVar.c();
        if (zL) {
            bVar.a();
        }
    }

    public final boolean W(int i, boolean z) {
        a2 a2VarC;
        if ((i & 1) == 0 && (this.S || this.y)) {
            m2 m2Var = this.P;
            if (m2Var != null && (a2VarC = C()) != null && m2Var.d()) {
                int i2 = a2VarC.b;
                if ((i2 & 512) != 0) {
                    return true;
                }
                int i3 = i2 | 1;
                a2VarC.b = i3;
                a2VarC.b = (this.y ? i2 | 129 : i3 & (-129)) | 256;
                j3.m0 m0Var = this.M.b.b;
                m0Var.M0(y.c);
                tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 0, a2VarC);
                this.b.s(a2VarC);
                return false;
            }
        } else if (!z && G()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X() {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.X():void");
    }

    public final void Y() {
        n2 n2Var = this.G;
        int i = n2Var.i;
        this.l = i >= 0 ? n2Var.b[(i * 5) + 1] & 67108863 : 0;
        n2Var.t();
    }

    public final void Z() {
        if (this.l != 0) {
            u.c("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (this.S) {
            return;
        }
        a2 a2VarC = C();
        if (a2VarC != null) {
            int i = a2VarC.b;
            if ((i & 128) == 0) {
                a2VarC.b = i | 16;
            }
        }
        if (this.s.isEmpty()) {
            Y();
        } else {
            N();
        }
    }

    public final void a() {
        j();
        this.i.clear();
        this.n.b = 0;
        this.t.b = 0;
        this.x.b = 0;
        this.v = null;
        j3.c cVar = this.O;
        cVar.c.I0();
        cVar.b.I0();
        this.T = 0;
        this.A = 0;
        this.r = false;
        this.S = false;
        this.y = false;
        this.F = false;
        this.z = -1;
        n2 n2Var = this.G;
        if (!n2Var.f534f) {
            n2Var.c();
        }
        if (this.I.w) {
            return;
        }
        A();
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a0(int r28, java.lang.Object r29, java.lang.Object r30, int r31) {
        /*
            Method dump skipped, instruction units count: 871
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.a0(int, java.lang.Object, java.lang.Object, int):void");
    }

    public final void b(Object obj, Function2 function2) {
        if (this.S) {
            j3.m0 m0Var = this.O.b;
            m0Var.M0(j3.h0.c);
            tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 0, obj);
            lmjxuqdtp.jvm.internal.o.f(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] lmjxuqdtp.Function2<lmjxuqdtp.Any?, lmjxuqdtp.Any?, lmjxuqdtp.Unit>");
            lmjxuqdtp.jvm.internal.g0.d(2, function2);
            tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 1, function2);
            return;
        }
        b bVar = this.M;
        bVar.b();
        j3.m0 m0Var2 = bVar.b.b;
        m0Var2.M0(j3.h0.c);
        lmjxuqdtp.jvm.internal.o.f(function2, "null cannot be cast to non-null type @[ExtensionFunctionType] lmjxuqdtp.Function2<lmjxuqdtp.Any?, lmjxuqdtp.Any?, lmjxuqdtp.Unit>");
        lmjxuqdtp.jvm.internal.g0.d(2, function2);
        tlydtdl.datastore.preferences.protobuf.j1.B(m0Var2, 0, obj, 1, function2);
    }

    public final void b0() {
        a0(-127, null, null, 0);
    }

    public final boolean c(double d) {
        Object objJ = J();
        if ((objJ instanceof Double) && d == ((Number) objJ).doubleValue()) {
            return false;
        }
        r0(Double.valueOf(d));
        return true;
    }

    public final void c0(int i, g1 g1Var) {
        a0(i, g1Var, null, 0);
    }

    public final boolean d(float f2) {
        Object objJ = J();
        if ((objJ instanceof Float) && f2 == ((Number) objJ).floatValue()) {
            return false;
        }
        r0(Float.valueOf(f2));
        return true;
    }

    public final void d0(int i, Object obj) {
        a0(i, obj, null, 0);
    }

    public final boolean e(int i) {
        Object objJ = J();
        if ((objJ instanceof Integer) && i == ((Number) objJ).intValue()) {
            return false;
        }
        r0(Integer.valueOf(i));
        return true;
    }

    public final void e0(Object obj, boolean z) {
        if (z) {
            n2 n2Var = this.G;
            if (n2Var.k <= 0) {
                if ((n2Var.b[(n2Var.g * 5) + 1] & 1073741824) == 0) {
                    v1.a("Expected a node group");
                }
                n2Var.u();
                return;
            }
            return;
        }
        if (obj != null && this.G.f() != obj) {
            b bVar = this.M;
            bVar.getClass();
            bVar.d(false);
            j3.m0 m0Var = bVar.b.b;
            m0Var.M0(j3.g0.c);
            tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 0, obj);
        }
        this.G.u();
    }

    public final boolean f(long j2) {
        Object objJ = J();
        if ((objJ instanceof Long) && j2 == ((Number) objJ).longValue()) {
            return false;
        }
        r0(Long.valueOf(j2));
        return true;
    }

    public final void f0(int i) {
        int i2;
        int i3;
        if (this.f545j != null) {
            a0(i, null, null, 0);
            return;
        }
        if (this.r) {
            u.c("A call to createNode(), emitNode() or useNode() expected");
        }
        this.T = Long.rotateLeft(Long.rotateLeft(this.T, 3) ^ ((long) i), 3) ^ ((long) this.m);
        this.m++;
        n2 n2Var = this.G;
        boolean z = this.S;
        x0 x0Var = l.a;
        if (z) {
            n2Var.k++;
            this.I.R(x0Var, x0Var, false, i);
            z(false, null);
            return;
        }
        if (n2Var.g() == i && ((i3 = n2Var.g) >= n2Var.h || (n2Var.b[(i3 * 5) + 1] & 536870912) == 0)) {
            n2Var.u();
            z(false, null);
            return;
        }
        if (n2Var.k <= 0 && (i2 = n2Var.g) != n2Var.h) {
            int i4 = this.k;
            O();
            this.M.f(i4, n2Var.s());
            u.a(this.s, i2, n2Var.g);
        }
        n2Var.k++;
        this.S = true;
        this.K = null;
        if (this.I.w) {
            r2 r2VarH = this.H.h();
            this.I = r2VarH;
            r2VarH.N();
            this.J = false;
            this.K = null;
        }
        r2 r2Var = this.I;
        r2Var.d();
        int i6 = r2Var.t;
        r2Var.R(x0Var, x0Var, false, i);
        this.N = r2Var.b(i6);
        z(false, null);
    }

    public final boolean g(Object obj) {
        if (lmjxuqdtp.jvm.internal.o.c(J(), obj)) {
            return false;
        }
        r0(obj);
        return true;
    }

    public final void g0(int i) {
        a0(i, null, null, 0);
    }

    public final boolean h(boolean z) {
        Object objJ = J();
        if ((objJ instanceof Boolean) && z == ((Boolean) objJ).booleanValue()) {
            return false;
        }
        r0(Boolean.valueOf(z));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tlydtdl.compose.runtime.s h0(int r7) {
        /*
            r6 = this;
            r6.f0(r7)
            boolean r7 = r6.S
            ru1.c r0 = r6.g
            java.util.ArrayList r1 = r6.E
            tlydtdl.compose.runtime.z r2 = r6.h
            if (r7 == 0) goto L26
            tlydtdl.compose.runtime.a2 r7 = new tlydtdl.compose.runtime.a2
            r7.<init>(r2)
            r1.add(r7)
            r6.r0(r7)
            int r1 = r6.B
            r7.e = r1
            int r1 = r7.b
            r1 = r1 & (-17)
            r7.b = r1
            r0.n()
            return r6
        L26:
            tlydtdl.compose.runtime.n2 r7 = r6.G
            int r7 = r7.i
            java.util.ArrayList r3 = r6.s
            int r7 = tlydtdl.compose.runtime.u.f(r7, r3)
            if (r7 < 0) goto L39
            java.lang.Object r7 = r3.remove(r7)
            tlydtdl.compose.runtime.q0 r7 = (tlydtdl.compose.runtime.q0) r7
            goto L3a
        L39:
            r7 = 0
        L3a:
            tlydtdl.compose.runtime.n2 r3 = r6.G
            java.lang.Object r3 = r3.m()
            tlydtdl.compose.runtime.x0 r4 = tlydtdl.compose.runtime.l.a
            boolean r4 = lmjxuqdtp.jvm.internal.o.c(r3, r4)
            if (r4 == 0) goto L51
            tlydtdl.compose.runtime.a2 r3 = new tlydtdl.compose.runtime.a2
            r3.<init>(r2)
            r6.r0(r3)
            goto L58
        L51:
            java.lang.String r2 = "null cannot be cast to non-null type tlydtdl.compose.runtime.RecomposeScopeImpl"
            lmjxuqdtp.jvm.internal.o.f(r3, r2)
            tlydtdl.compose.runtime.a2 r3 = (tlydtdl.compose.runtime.a2) r3
        L58:
            r2 = 0
            r4 = 1
            if (r7 != 0) goto L70
            int r7 = r3.b
            r5 = r7 & 64
            if (r5 == 0) goto L64
            r5 = r4
            goto L65
        L64:
            r5 = r2
        L65:
            if (r5 == 0) goto L6b
            r7 = r7 & (-65)
            r3.b = r7
        L6b:
            if (r5 == 0) goto L6e
            goto L70
        L6e:
            r7 = r2
            goto L71
        L70:
            r7 = r4
        L71:
            int r5 = r3.b
            if (r7 == 0) goto L78
            r7 = r5 | 8
            goto L7a
        L78:
            r7 = r5 & (-9)
        L7a:
            r3.b = r7
            r1.add(r3)
            int r7 = r6.B
            r3.e = r7
            int r7 = r3.b
            r7 = r7 & (-17)
            r3.b = r7
            r0.n()
            int r7 = r3.b
            r0 = r7 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto Lb6
            r7 = r7 & (-257(0xfffffffffffffeff, float:NaN))
            r7 = r7 | 512(0x200, float:7.17E-43)
            r3.b = r7
            j3.b r7 = r6.M
            j3.a r7 = r7.b
            j3.m0 r7 = r7.b
            j3.e0 r0 = j3.e0.c
            r7.M0(r0)
            tlydtdl.datastore.preferences.protobuf.j1.A(r7, r2, r3)
            boolean r7 = r6.y
            if (r7 != 0) goto Lb6
            int r7 = r3.b
            r0 = r7 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto Lb6
            r6.y = r4
            r7 = r7 | 1024(0x400, float:1.435E-42)
            r3.b = r7
        Lb6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.h0(int):tlydtdl.compose.runtime.s");
    }

    public final boolean i(Object obj) {
        if (J() == obj) {
            return false;
        }
        r0(obj);
        return true;
    }

    public final void i0(Object obj) {
        if (!this.S && this.G.g() == 207 && !lmjxuqdtp.jvm.internal.o.c(this.G.f(), obj) && this.z < 0) {
            this.z = this.G.g;
            this.y = true;
        }
        a0(HttpStatus.SC_MULTI_STATUS, null, obj, 0);
    }

    public final void j() {
        this.f545j = null;
        this.k = 0;
        this.l = 0;
        this.T = 0L;
        this.r = false;
        b bVar = this.M;
        bVar.c = false;
        bVar.d.b = 0;
        bVar.f = 0;
        bVar.e = true;
        bVar.g = 0;
        bVar.h.clear();
        bVar.i = -1;
        bVar.j = -1;
        bVar.k = -1;
        bVar.l = 0;
        this.E.clear();
        this.o = null;
        this.p = null;
    }

    public final void j0() {
        a0(FTPReply.DATA_CONNECTION_ALREADY_OPEN, null, null, 2);
        this.r = true;
    }

    public final Object k(x1 x1Var) {
        return a0.v(m(), x1Var);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k0() {
        this.m = 0;
        this.G = this.c.e();
        a0(100, null, null, 0);
        w wVar = this.b;
        wVar.u();
        q3.o oVarJ = wVar.j();
        this.x.e(this.w ? 1 : 0);
        this.w = g(oVarJ);
        this.K = null;
        if (!this.q) {
            this.q = wVar.f();
        }
        if (!this.C) {
            this.C = wVar.g();
        }
        if (this.C) {
            g3 g3Var = tlydtdl.compose.runtime.tooling.d.a;
            lmjxuqdtp.jvm.internal.o.f(g3Var, "null cannot be cast to non-null type tlydtdl.compose.runtime.CompositionLocal<lmjxuqdtp.Any?>");
            oVarJ = oVarJ.c(g3Var, new h3(E()));
        }
        this.u = oVarJ;
        Set set = (Set) a0.v(oVarJ, tlydtdl.compose.runtime.tooling.e.a);
        if (set != null) {
            y yVar = this.U;
            if (yVar == null) {
                yVar = new y(this.h);
                this.U = yVar;
            }
            set.add(yVar);
            wVar.q(set);
        }
        a0(Long.hashCode(wVar.h()), null, null, 0);
    }

    public final void l(Function0 function0) {
        if (!this.r) {
            u.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.r = false;
        if (!this.S) {
            u.c("createNode() can only be called when inserting");
        }
        p0 p0Var = this.n;
        int i = p0Var.a[p0Var.b - 1];
        r2 r2Var = this.I;
        a aVarB = r2Var.b(r2Var.v);
        this.l++;
        j3.c cVar = this.O;
        j3.m0 m0Var = cVar.b;
        m0Var.M0(j3.r.d);
        tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 0, function0);
        m0Var.d[m0Var.e - m0Var.b[m0Var.c - 1].a] = i;
        tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 1, aVarB);
        j3.m0 m0Var2 = cVar.c;
        m0Var2.M0(j3.r.e);
        m0Var2.d[m0Var2.e - m0Var2.b[m0Var2.c - 1].a] = i;
        tlydtdl.datastore.preferences.protobuf.j1.A(m0Var2, 0, aVarB);
    }

    public final boolean l0(a2 a2Var, Object obj) {
        a aVar = a2Var.c;
        if (aVar == null) {
            return false;
        }
        int iB = this.G.a.b(aVar);
        if (!this.F || iB < this.G.g) {
            return false;
        }
        ArrayList arrayList = this.s;
        int iF = u.f(iB, arrayList);
        if (iF < 0) {
            int i = -(iF + 1);
            if (!(obj instanceof h0)) {
                obj = null;
            }
            arrayList.add(i, new q0(a2Var, iB, obj));
            return true;
        }
        q0 q0Var = (q0) arrayList.get(iF);
        if (!(obj instanceof h0)) {
            q0Var.c = null;
            return true;
        }
        Object obj2 = q0Var.c;
        if (obj2 == null) {
            q0Var.c = obj;
            return true;
        }
        if (obj2 instanceof q1.o0) {
            ((q1.o0) obj2).a(obj);
            return true;
        }
        q1.o0 o0Var = q1.w0.a;
        q1.o0 o0Var2 = new q1.o0(2);
        o0Var2.j(obj2);
        o0Var2.j(obj);
        q0Var.c = o0Var2;
        return true;
    }

    public final u1 m() {
        u1 u1Var = this.K;
        return u1Var != null ? u1Var : n(this.G.i);
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m0(q1.n0 r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.util.ArrayList r2 = r0.s
            int r3 = ct1.b.z(r2)
        La:
            r4 = -1
            if (r4 >= r3) goto L2e
            java.lang.Object r4 = r2.get(r3)
            tlydtdl.compose.runtime.q0 r4 = (tlydtdl.compose.runtime.q0) r4
            tlydtdl.compose.runtime.a2 r5 = r4.a
            tlydtdl.compose.runtime.a r5 = r5.c
            if (r5 == 0) goto L28
            boolean r6 = r5.a()
            if (r6 == 0) goto L28
            int r6 = r4.b
            int r5 = r5.a
            if (r6 == r5) goto L2b
            r4.b = r5
            goto L2b
        L28:
            r2.remove(r3)
        L2b:
            int r3 = r3 + (-1)
            goto La
        L2e:
            java.lang.Object[] r3 = r1.b
            java.lang.Object[] r4 = r1.c
            long[] r1 = r1.a
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L8b
            r7 = 0
        L3a:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L86
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L54:
            if (r12 >= r10) goto L84
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L80
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            java.lang.String r15 = "null cannot be cast to non-null type tlydtdl.compose.runtime.RecomposeScopeImpl"
            lmjxuqdtp.jvm.internal.o.f(r14, r15)
            tlydtdl.compose.runtime.a2 r14 = (tlydtdl.compose.runtime.a2) r14
            tlydtdl.compose.runtime.a r15 = r14.c
            if (r15 == 0) goto L80
            int r15 = r15.a
            tlydtdl.compose.runtime.x0 r6 = tlydtdl.compose.runtime.x0.e
            if (r13 != r6) goto L78
            r13 = 0
        L78:
            tlydtdl.compose.runtime.q0 r6 = new tlydtdl.compose.runtime.q0
            r6.<init>(r14, r15, r13)
            r2.add(r6)
        L80:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L54
        L84:
            if (r10 != r11) goto L8b
        L86:
            if (r7 == r5) goto L8b
            int r7 = r7 + 1
            goto L3a
        L8b:
            tlydtdl.compose.foundation.lazy.layout.a r1 = tlydtdl.compose.runtime.u.f547f
            mx1.r.f0(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.m0(q1.n0):void");
    }

    public final u1 n(int i) {
        u1 u1Var;
        boolean z = this.S;
        g1 g1Var = u.c;
        if (z && this.J) {
            int iF = this.I.v;
            while (iF > 0) {
                r2 r2Var = this.I;
                if (r2Var.b[r2Var.r(iF) * 5] == 202 && lmjxuqdtp.jvm.internal.o.c(this.I.s(iF), g1Var)) {
                    Object objQ = this.I.q(iF);
                    lmjxuqdtp.jvm.internal.o.f(objQ, "null cannot be cast to non-null type tlydtdl.compose.runtime.PersistentCompositionLocalMap");
                    u1 u1Var2 = (u1) objQ;
                    this.K = u1Var2;
                    return u1Var2;
                }
                r2 r2Var2 = this.I;
                iF = r2Var2.F(iF, r2Var2.b);
            }
        }
        if (this.G.c > 0) {
            while (i > 0) {
                if (this.G.i(i) == 202) {
                    n2 n2Var = this.G;
                    if (lmjxuqdtp.jvm.internal.o.c(n2Var.p(i, n2Var.b), g1Var)) {
                        q1.z zVar = this.v;
                        if (zVar == null || (u1Var = (u1) zVar.b(i)) == null) {
                            n2 n2Var2 = this.G;
                            Object objB = n2Var2.b(i, n2Var2.b);
                            lmjxuqdtp.jvm.internal.o.f(objB, "null cannot be cast to non-null type tlydtdl.compose.runtime.PersistentCompositionLocalMap");
                            u1Var = (u1) objB;
                        }
                        this.K = u1Var;
                        return u1Var;
                    }
                }
                i = this.G.q(i);
            }
        }
        u1 u1Var3 = this.u;
        this.K = u1Var3;
        return u1Var3;
    }

    public final void n0(int i, int i2) {
        if (s0(i) != i2) {
            if (i < 0) {
                q1.x xVar = this.p;
                if (xVar == null) {
                    xVar = new q1.x();
                    this.p = xVar;
                }
                xVar.f(i, i2);
                return;
            }
            int[] iArr = this.o;
            if (iArr == null) {
                iArr = new int[this.G.c];
                mx1.n.b0(iArr, -1, 0, 6);
                this.o = iArr;
            }
            iArr[i] = i2;
        }
    }

    public final List o() {
        if (!this.C) {
            return mx1.t.a;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(pa0.m.y(this.I));
        arrayList.addAll(pa0.m.w(this.G));
        arrayList.addAll(K());
        return arrayList;
    }

    public final void o0(int i, int i2) {
        int iS0 = s0(i);
        if (iS0 != i2) {
            int i3 = i2 - iS0;
            ArrayList arrayList = this.i;
            int size = arrayList.size() - 1;
            while (i != -1) {
                int iS02 = s0(i) + i3;
                n0(i, iS02);
                int i4 = size;
                while (true) {
                    if (-1 < i4) {
                        t1 t1Var = (t1) arrayList.get(i4);
                        if (t1Var != null && t1Var.a(i, iS02)) {
                            size = i4 - 1;
                            break;
                        }
                        i4--;
                    } else {
                        break;
                    }
                }
                if (i < 0) {
                    i = this.G.i;
                } else if (this.G.l(i)) {
                    return;
                } else {
                    i = this.G.q(i);
                }
            }
        }
    }

    public final void p(n0 n0Var, Function2 function2) {
        ArrayList arrayList = this.s;
        if (this.F) {
            u.c("Reentrant composition is not supported");
        }
        this.g.n();
        Trace.beginSection("Compose:recompose");
        try {
            this.B = Long.hashCode(s3.l.k().g());
            this.v = null;
            m0(n0Var);
            this.k = 0;
            this.F = true;
            try {
                k0();
                Object objJ = J();
                if (objJ != function2 && function2 != null) {
                    r0(function2);
                }
                r rVar = this.D;
                k3.e eVarO = a0.o();
                try {
                    eVarO.d(rVar);
                    g1 g1Var = u.a;
                    if (function2 != null) {
                        c0(200, g1Var);
                        q3.p.c(this, function2);
                        r(false);
                    } else if (!this.w || objJ == null || objJ.equals(l.a)) {
                        X();
                    } else {
                        c0(200, g1Var);
                        lmjxuqdtp.jvm.internal.g0.d(2, objJ);
                        q3.p.c(this, (Function2) objJ);
                        r(false);
                    }
                    eVarO.o(eVarO.c - 1);
                    x();
                    this.F = false;
                    arrayList.clear();
                    if (!this.I.w) {
                        u.c("Check failed");
                    }
                    A();
                } catch (Throwable th) {
                    eVarO.o(eVarO.c - 1);
                    throw th;
                }
            } finally {
            }
        } finally {
            Trace.endSection();
        }
    }

    public final q3.o p0(u1 u1Var, q3.o oVar) {
        q3.o oVar2 = (q3.o) u1Var;
        oVar2.getClass();
        q3.n nVar = new q3.n(oVar2);
        nVar.g = oVar2;
        nVar.putAll(oVar);
        q3.o oVarC = nVar.c();
        c0(HttpStatus.SC_NO_CONTENT, u.d);
        J();
        r0(oVarC);
        J();
        r0(oVar);
        r(false);
        return oVarC;
    }

    public final void q(int i, int i2) {
        if (i <= 0 || i == i2) {
            return;
        }
        q(this.G.q(i), i2);
        if (this.G.l(i)) {
            Object objN = this.G.n(i);
            b bVar = this.M;
            bVar.c();
            bVar.h.add(objN);
        }
    }

    public final void q0(Object obj) {
        int i;
        n2 n2Var;
        int i2;
        r2 r2Var;
        if (obj instanceof i2) {
            i2 i2Var = (i2) obj;
            a aVarA = null;
            if (this.S) {
                r2 r2Var2 = this.I;
                int i3 = r2Var2.t;
                if (i3 > r2Var2.v + 1) {
                    int i4 = i3 - 1;
                    int iF = r2Var2.F(i4, r2Var2.b);
                    while (true) {
                        i2 = i4;
                        i4 = iF;
                        r2Var = this.I;
                        if (i4 == r2Var.v || i4 < 0) {
                            break;
                        } else {
                            iF = r2Var.F(i4, r2Var.b);
                        }
                    }
                    aVarA = r2Var.b(i2);
                }
            } else {
                n2 n2Var2 = this.G;
                int i6 = n2Var2.g;
                if (i6 > n2Var2.i + 1) {
                    int i7 = i6 - 1;
                    int iQ = n2Var2.q(i7);
                    while (true) {
                        i = i7;
                        i7 = iQ;
                        n2Var = this.G;
                        if (i7 == n2Var.i || i7 < 0) {
                            break;
                        } else {
                            iQ = n2Var.q(i7);
                        }
                    }
                    aVarA = n2Var.a(i);
                }
            }
            j2 j2Var = new j2(i2Var, aVarA);
            if (this.S) {
                j3.m0 m0Var = this.M.b.b;
                m0Var.M0(j3.x.c);
                tlydtdl.datastore.preferences.protobuf.j1.A(m0Var, 0, j2Var);
            }
            this.d.add(obj);
            obj = j2Var;
        }
        r0(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:379:0x03ab  */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r(boolean r43) {
        /*
            Method dump skipped, instruction units count: 1394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.r(boolean):void");
    }

    public final void r0(Object obj) {
        if (this.S) {
            this.I.T(obj);
            return;
        }
        n2 n2Var = this.G;
        boolean z = n2Var.n;
        b bVar = this.M;
        if (!z) {
            a aVarA = n2Var.a(n2Var.i);
            j3.m0 m0Var = bVar.b.b;
            m0Var.M0(j3.e.c);
            tlydtdl.datastore.preferences.protobuf.j1.B(m0Var, 0, aVarA, 1, obj);
            return;
        }
        int iC = (n2Var.l - q2.c(n2Var.i, n2Var.b)) - 1;
        if (bVar.a.G.i - bVar.f >= 0) {
            bVar.d(true);
            j3.m0 m0Var2 = bVar.b.b;
            m0Var2.M0(j3.r.g);
            tlydtdl.datastore.preferences.protobuf.j1.A(m0Var2, 0, obj);
            m0Var2.d[m0Var2.e - m0Var2.b[m0Var2.c - 1].a] = iC;
            return;
        }
        n2 n2Var2 = this.G;
        a aVarA2 = n2Var2.a(n2Var2.i);
        j3.m0 m0Var3 = bVar.b.b;
        m0Var3.M0(j3.r.f);
        tlydtdl.datastore.preferences.protobuf.j1.B(m0Var3, 0, obj, 1, aVarA2);
        m0Var3.d[m0Var3.e - m0Var3.b[m0Var3.c - 1].a] = iC;
    }

    public final void s() {
        r(false);
        a2 a2VarC = C();
        if (a2VarC != null) {
            int i = a2VarC.b;
            if ((i & 1) != 0) {
                a2VarC.b = i | 2;
            }
        }
    }

    public final int s0(int i) {
        int i2;
        if (i >= 0) {
            int[] iArr = this.o;
            return (iArr == null || (i2 = iArr[i]) < 0) ? this.G.o(i) : i2;
        }
        q1.x xVar = this.p;
        if (xVar == null || xVar.c(i) < 0) {
            return 0;
        }
        int iC = xVar.c(i);
        if (iC >= 0) {
            return xVar.c[iC];
        }
        r1.a.e("Cannot find value for key " + i);
        throw null;
    }

    public final void t() {
        r(true);
    }

    public final void t0() {
        if (!this.r) {
            u.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.r = false;
        if (this.S) {
            u.c("useNode() called while inserting");
        }
        n2 n2Var = this.G;
        Object objN = n2Var.n(n2Var.i);
        b bVar = this.M;
        bVar.c();
        bVar.h.add(objN);
        if (this.y && (objN instanceof j)) {
            bVar.b();
            bVar.b.b.M0(j3.j0.c);
        }
    }

    public final void u() {
        r(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0083 A[EDGE_INSN: B:123:0x0083->B:92:0x0083 BREAK  A[LOOP:0: B:79:0x003e->B:91:0x0080], EDGE_INSN: B:124:0x0083->B:92:0x0083 BREAK  A[LOOP:0: B:79:0x003e->B:91:0x0080]] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tlydtdl.compose.runtime.a2 v() {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tlydtdl.compose.runtime.s.v():tlydtdl.compose.runtime.a2");
    }

    public final void w() {
        if (this.F || this.z != 100) {
            v1.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.z = -1;
        this.y = false;
    }

    public final void x() {
        r(false);
        this.b.d();
        r(false);
        b bVar = this.M;
        if (bVar.c) {
            bVar.d(false);
            bVar.d(false);
            bVar.b.b.M0(j3.m.c);
            bVar.c = false;
        }
        bVar.b();
        if (bVar.d.b != 0) {
            u.c("Missed recording an endGroup()");
        }
        if (!this.i.isEmpty()) {
            u.c("Start/end imbalance");
        }
        j();
        this.G.c();
        this.w = this.x.d() != 0;
    }

    public final void y(int i) {
        if (i < 0) {
            int i2 = -i;
            r2 r2Var = this.I;
            while (true) {
                int i3 = r2Var.v;
                if (i3 <= i2) {
                    return;
                } else {
                    r(r2Var.x(i3));
                }
            }
        } else {
            if (this.S) {
                r2 r2Var2 = this.I;
                while (this.S) {
                    r(r2Var2.x(r2Var2.v));
                }
            }
            n2 n2Var = this.G;
            while (true) {
                int i4 = n2Var.i;
                if (i4 <= i) {
                    return;
                } else {
                    r(n2Var.l(i4));
                }
            }
        }
    }

    public final void z(boolean z, t1 t1Var) {
        this.i.add(this.f545j);
        this.f545j = t1Var;
        int i = this.l;
        p0 p0Var = this.n;
        p0Var.e(i);
        p0Var.e(this.m);
        p0Var.e(this.k);
        if (z) {
            this.k = 0;
        }
        this.l = 0;
        this.m = 0;
    }
}
