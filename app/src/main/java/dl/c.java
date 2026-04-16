package dl;

import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import f3.f2;
import gl.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CancellationException;
import k80.t;
import ky1.a0;
import ky1.b0;
import ky1.c0;
import lg0.b;
import lmjxuqdtp.jvm.functions.Function0;
import lmjxuqdtp.jvm.functions.Function1;
import ls0.l;
import ls0.p;
import mg0.e;
import ny1.b2;
import ny1.r2;
import ny1.z;
import okhttp3.HttpUrl;
import p4.a;
import q1.f0;
import qi.y;
import qp1.o;
import qx1.i;
import s4.c1;
import s4.d;
import s4.d2;
import s4.f1;
import s4.g;
import s4.j0;
import s4.k1;
import s4.l1;
import s4.v;
import st1.t1;
import t3.n;
import t4.y1;
import zj.v1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b, e, mg0.b {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f89f;
    public Object g;
    public Object h;
    public Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f90j;
    public Object k;

    public /* synthetic */ c() {
        this.a = 5;
    }

    public static final boolean i(c cVar) {
        return l.c((l) cVar.e, t1.o((a21.e) ((v1) ((o) cVar.b).b).x.getValue())).equals(p.a);
    }

    public static final void j(c cVar, t3.o oVar, k1 k1Var) {
        for (t3.o parent$ui_release = oVar.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (parent$ui_release == ((f1) cVar.c)) {
                j0 j0VarV = ((j0) cVar.b).v();
                k1Var.q = j0VarV != null ? (v) j0VarV.E.d : null;
                cVar.e = k1Var;
                return;
            } else {
                if ((parent$ui_release.getKindSet$ui_release() & 2) != 0) {
                    return;
                }
                parent$ui_release.updateCoordinator$ui_release(k1Var);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(dl.c r8, java.lang.String r9, dl.a r10) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            km.a r0 = r10.a()
            if (r0 != 0) goto L8
            r0 = -1
            goto L10
        L8:
            int[] r1 = dl.b.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L10:
            r1 = 0
            switch(r0) {
                case -1: goto L33;
                case 0: goto L14;
                case 1: goto L30;
                case 2: goto L2d;
                case 3: goto L2a;
                case 4: goto L27;
                case 5: goto L24;
                case 6: goto L21;
                case 7: goto L1e;
                case 8: goto L1a;
                default: goto L14;
            }
        L14:
            lmjxuqdtp.NoWhenBranchMatchedException r8 = new lmjxuqdtp.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L1a:
            java.lang.String r0 = "Rock"
        L1c:
            r4 = r0
            goto L34
        L1e:
            java.lang.String r0 = "RnB"
            goto L1c
        L21:
            java.lang.String r0 = "Pop"
            goto L1c
        L24:
            java.lang.String r0 = "Lo_Fi"
            goto L1c
        L27:
            java.lang.String r0 = "Jazz"
            goto L1c
        L2a:
            java.lang.String r0 = "House"
            goto L1c
        L2d:
            java.lang.String r0 = "Hip_Hop"
            goto L1c
        L30:
            java.lang.String r0 = "Electronic"
            goto L1c
        L33:
            r4 = r1
        L34:
            java.util.List r0 = r10.b()
            if (r0 == 0) goto L80
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L43
            goto L7d
        L43:
            java.util.Iterator r1 = r0.iterator()
        L47:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L7d
            java.lang.Object r2 = r1.next()
            a21.t r2 = (a21.t) r2
            boolean r2 = r2.a()
            if (r2 != 0) goto L47
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L60
            goto L7a
        L60:
            java.util.Iterator r0 = r0.iterator()
        L64:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r0.next()
            a21.t r1 = (a21.t) r1
            boolean r1 = r1.a()
            if (r1 == 0) goto L64
            java.lang.String r0 = "mixed"
        L78:
            r1 = r0
            goto L80
        L7a:
            java.lang.String r0 = "audio"
            goto L78
        L7d:
            java.lang.String r0 = "midi"
            goto L78
        L80:
            r6 = r1
            java.lang.Object r8 = r8.h
            qi.y r8 = (qi.y) r8
            qi.h r0 = qi.h.e
            a2.y1 r2 = new a2.y1
            r7 = 4
            r3 = r9
            r5 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            java.util.ArrayList r9 = m8.d.o(r2)
            java.lang.String r10 = "automix_complete"
            r1 = 8
            qi.y.k(r8, r10, r9, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dl.c.k(dl.c, java.lang.String, dl.a):void");
    }

    public static t3.o n(n nVar, t3.o oVar) {
        t3.o oVarCreate;
        if (nVar instanceof c1) {
            oVarCreate = ((c1) nVar).create();
            oVarCreate.setKindSet$ui_release(l1.g(oVarCreate));
        } else {
            d dVar = new d();
            dVar.setKindSet$ui_release(l1.e(nVar));
            dVar.a = nVar;
            dVar.c = new HashSet();
            oVarCreate = dVar;
        }
        if (oVarCreate.isAttached()) {
            a.b("A ModifierNodeElement cannot return an already attached node from create() ");
        }
        oVarCreate.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        t3.o child$ui_release = oVar.getChild$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(oVarCreate);
            oVarCreate.setChild$ui_release(child$ui_release);
        }
        oVar.setChild$ui_release(oVarCreate);
        oVarCreate.setParent$ui_release(oVar);
        return oVarCreate;
    }

    public static t3.o o(t3.o oVar) {
        if (oVar.isAttached()) {
            f0 f0Var = l1.a;
            if (!oVar.isAttached()) {
                a.b("autoInvalidateRemovedNode called on unattached node");
            }
            l1.b(oVar, -1, 2);
            oVar.runDetachLifecycle$ui_release();
            oVar.markAsDetached$ui_release();
        }
        t3.o child$ui_release = oVar.getChild$ui_release();
        t3.o parent$ui_release = oVar.getParent$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            oVar.setChild$ui_release((t3.o) null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            oVar.setParent$ui_release((t3.o) null);
        }
        lmjxuqdtp.jvm.internal.o.e(parent$ui_release);
        return parent$ui_release;
    }

    public static void u(n nVar, n nVar2, t3.o oVar) {
        if ((nVar instanceof c1) && (nVar2 instanceof c1)) {
            lmjxuqdtp.jvm.internal.o.f(oVar, "null cannot be cast to non-null type T of tlydtdl.compose.ui.node.NodeChainKt.updateUnsafe");
            ((c1) nVar2).update(oVar);
            if (oVar.isAttached()) {
                l1.d(oVar);
                return;
            } else {
                oVar.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                return;
            }
        }
        if (!(oVar instanceof d)) {
            a.b("Unknown Modifier.Node type");
            return;
        }
        d dVar = (d) oVar;
        if (dVar.isAttached()) {
            dVar.R0();
        }
        dVar.a = nVar2;
        dVar.setKindSet$ui_release(l1.e(nVar2));
        if (dVar.isAttached()) {
            dVar.Q0(false);
        }
        if (oVar.isAttached()) {
            l1.d(oVar);
        } else {
            oVar.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
        }
    }

    public Function0 a() {
        return (h) this.b;
    }

    public Function0 b() {
        return (kg0.e) this.e;
    }

    public Function0 c() {
        return (kg0.e) this.d;
    }

    public Function1 d() {
        return (t) this.f90j;
    }

    public Function0 e() {
        return (kg0.e) this.g;
    }

    public Function0 f() {
        return (kg0.e) this.c;
    }

    public Function0 g() {
        return (kg0.e) this.f89f;
    }

    public Function0 h() {
        return (kg0.e) this.k;
    }

    public void l(String str, String str2) {
        HashMap map = (HashMap) this.g;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public oo1.h m() {
        String strC = ((String) this.b) == null ? " transportName" : HttpUrl.FRAGMENT_ENCODE_SET;
        if (((oo1.l) this.d) == null) {
            strC = strC.concat(" encodedPayload");
        }
        if (((Long) this.e) == null) {
            strC = f2.C(strC, " eventMillis");
        }
        if (((Long) this.f89f) == null) {
            strC = f2.C(strC, " uptimeMillis");
        }
        if (((HashMap) this.g) == null) {
            strC = f2.C(strC, " autoMetadata");
        }
        if (strC.isEmpty()) {
            return new oo1.h((String) this.b, (Integer) this.c, (oo1.l) this.d, ((Long) this.e).longValue(), ((Long) this.f89f).longValue(), (HashMap) this.g, (Integer) this.h, (String) this.i, (byte[]) this.f90j, (byte[]) this.k);
        }
        throw new IllegalStateException("Missing required properties:".concat(strC));
    }

    public boolean p(int i) {
        return (i & ((t3.o) this.g).getAggregateChildKindSet$ui_release()) != 0;
    }

    public void q() {
        for (t3.o child$ui_release = (t3.o) this.g; child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
            child$ui_release.runAttachLifecycle$ui_release();
            if (child$ui_release.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
                l1.a(child$ui_release);
            }
            if (child$ui_release.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
                l1.d(child$ui_release);
            }
            child$ui_release.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            child$ui_release.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public void r(km.a aVar) {
        ky1.t1 t1Var = (ky1.t1) this.k;
        if (t1Var != null && t1Var.isActive()) {
            w wVar = new w(2);
            ArrayList arrayList = wVar.a;
            wVar.a("CRITICAL");
            wVar.e(new String[0]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Job is already active"), (String[]) Arrays.copyOf(strArr, strArr.length)));
        }
        ky1.t1 t1Var2 = (ky1.t1) this.k;
        if (t1Var2 != null) {
            t1Var2.a((CancellationException) null);
        }
        this.k = c0.F((a0) this.f89f, (i) null, (b0) null, new a00.t(this, new a(aVar, ((lmjxuqdtp.time.v) this.g).a()), aVar, (qx1.d) null, 21), 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0264, code lost:
    
        r13 = r28 + 2;
        r11 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x026a, code lost:
    
        r3 = r3 + 1;
        r12 = r20;
        r11 = r21;
        r13 = r26;
        r14 = r29;
        r35 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014a, code lost:
    
        r26 = r13;
        r29 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0150, code lost:
    
        if ((r19 & 1) != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0152, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0154, code lost:
    
        r11 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0156, code lost:
    
        r13 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0157, code lost:
    
        if (r13 > r3) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0159, code lost:
    
        if (r13 == r12) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
    
        if (r13 == r3) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x015d, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x016b, code lost:
    
        if (r20[(r13 + 1) + r17] >= r20[(r13 - 1) + r17]) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x016e, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0170, code lost:
    
        r11 = r20[(r13 - 1) + r17];
        r14 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0179, code lost:
    
        r24 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017b, code lost:
    
        r11 = r20[(r13 + 1) + r17];
        r14 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0182, code lost:
    
        r22 = r10 - ((r6 - r14) - r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0188, code lost:
    
        if (r3 == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x018a, code lost:
    
        r25 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x018d, code lost:
    
        r25 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x018f, code lost:
    
        if (r14 != r11) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0191, code lost:
    
        r27 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0194, code lost:
    
        r27 = r33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0196, code lost:
    
        r25 = r22 + (r25 & r27);
        r22 = r11;
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a0, code lost:
    
        if (r14 <= r7) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a2, code lost:
    
        if (r11 <= r15) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        r27 = r11;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b0, code lost:
    
        if (r0.a(r14 - 1, r27 - 1) == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b2, code lost:
    
        r14 = r14 - 1;
        r11 = r27 - 1;
        r13 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b9, code lost:
    
        r27 = r11;
        r28 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bd, code lost:
    
        r20[r17 + r28] = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c1, code lost:
    
        if (r24 == 0) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c3, code lost:
    
        r11 = r19 - r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c5, code lost:
    
        if (r11 < r12) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c7, code lost:
    
        if (r11 > r3) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cd, code lost:
    
        if (r16[r17 + r11] < r14) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01cf, code lost:
    
        r26[r33] = r14;
        r11 = 1;
        r26[1] = r27;
        r26[r32] = r22;
        r26[3] = r25;
        r26[4] = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void s(int r32, k3.e r33, k3.e r34, t3.o r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 937
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dl.c.s(int, k3.e, k3.e, t3.o, boolean):void");
    }

    public void t() {
        s4.c0 c0Var;
        y1 y1Var;
        j0 j0Var = (j0) this.b;
        k1 k1Var = (v) this.d;
        for (s4.a0 parent$ui_release = ((d2) this.f89f).getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            s4.a0 a0VarF = g.f(parent$ui_release);
            if (a0VarF != null) {
                if (parent$ui_release.getCoordinator$ui_release() != null) {
                    k1 coordinator$ui_release = parent$ui_release.getCoordinator$ui_release();
                    lmjxuqdtp.jvm.internal.o.f(coordinator$ui_release, "null cannot be cast to non-null type tlydtdl.compose.ui.node.LayoutModifierNodeCoordinator");
                    c0Var = (s4.c0) coordinator$ui_release;
                    s4.a0 a0Var = c0Var.P;
                    c0Var.M1(a0VarF);
                    if (a0Var != parent$ui_release && (y1Var = c0Var.I) != null) {
                        y1Var.invalidate();
                    }
                } else {
                    c0Var = new s4.c0(j0Var, a0VarF);
                    parent$ui_release.updateCoordinator$ui_release(c0Var);
                }
                k1Var.q = c0Var;
                c0Var.p = k1Var;
                k1Var = c0Var;
            } else {
                parent$ui_release.updateCoordinator$ui_release(k1Var);
            }
        }
        j0 j0VarV = j0Var.v();
        k1Var.q = j0VarV != null ? (v) j0VarV.E.d : null;
        this.e = k1Var;
    }

    public String toString() {
        switch (this.a) {
            case 7:
                StringBuilder sb = new StringBuilder("[");
                t3.o child$ui_release = (t3.o) this.g;
                d2 d2Var = (d2) this.f89f;
                if (child$ui_release == d2Var) {
                    sb.append("]");
                } else {
                    while (true) {
                        if (child$ui_release != null && child$ui_release != d2Var) {
                            sb.append(String.valueOf(child$ui_release));
                            if (child$ui_release.getChild$ui_release() == d2Var) {
                                sb.append("]");
                            } else {
                                sb.append(",");
                                child$ui_release = child$ui_release.getChild$ui_release();
                            }
                        }
                    }
                }
                String string = sb.toString();
                lmjxuqdtp.jvm.internal.o.g(string, "toString(...)");
                return string;
            default:
                return super.toString();
        }
    }

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
        this.f89f = obj5;
        this.g = obj6;
        this.h = obj7;
        this.i = obj8;
        this.f90j = obj9;
        this.k = obj10;
    }

    public c(j0 j0Var) {
        this.a = 7;
        this.b = j0Var;
        f1 f1Var = new f1();
        f1Var.setAggregateChildKindSet$ui_release(-1);
        this.c = f1Var;
        v vVar = new v(j0Var);
        this.d = vVar;
        this.e = vVar;
        d2 d2Var = vVar.P;
        this.f89f = d2Var;
        this.g = d2Var;
        this.f90j = new k3.e(0, new t3.p[16]);
    }

    public c(o oVar, f fVar, lm.i iVar, l lVar, a0 a0Var, lmjxuqdtp.time.v vVar, y yVar) {
        this.a = 0;
        this.b = oVar;
        this.c = fVar;
        this.d = iVar;
        this.e = lVar;
        this.f89f = a0Var;
        this.g = vVar;
        this.h = yVar;
        r2 r2VarC = z.c(ck.d.a);
        this.i = r2VarC;
        this.f90j = new b2(r2VarC);
    }
}
