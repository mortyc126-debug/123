package s51;

import java.util.List;
import qe0.e;
import qx1.d;
import rd.g;
import rx1.a;
import sx1.c;
import x30.b;
import y11.d4;
import y11.h3;
import y11.l1;
import y11.r1;
import y11.v2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final r a;
    public final b0 b;

    public n(r rVar, b0 b0Var) {
        this.a = rVar;
        this.b = b0Var;
    }

    public final Object a(String str, c cVar) {
        if (str == null) {
            return null;
        }
        d dVar = d.b;
        r rVar = this.a;
        Object objE = b.e(new q(rVar, str, new e(9, dVar, rVar), 1), cVar);
        return objE == a.a ? objE : (l1) objE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r19, sx1.c r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof s51.f
            if (r2 == 0) goto L17
            r2 = r1
            s51.f r2 = (s51.f) r2
            int r3 = r2.l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.l = r3
            goto L1c
        L17:
            s51.f r2 = new s51.f
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.j
            rx1.a r3 = rx1.a.a
            int r4 = r2.l
            lx1.b0 r5 = lx1.b0.a
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L3c
            if (r4 == r7) goto L38
            if (r4 != r6) goto L30
            lg.e.O(r1)
            return r5
        L30:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L38:
            lg.e.O(r1)
            goto L4a
        L3c:
            lg.e.O(r1)
            r2.l = r7
            r1 = r19
            java.lang.Object r1 = r0.a(r1, r2)
            if (r1 != r3) goto L4a
            goto L89
        L4a:
            r7 = r1
            y11.l1 r7 = (y11.l1) r7
            if (r7 != 0) goto L50
            goto L8a
        L50:
            y11.v2 r1 = r7.k
            if (r1 != 0) goto L5b
            y11.v2 r1 = new y11.v2
            r8 = 0
            r1.<init>(r8, r8)
        L5b:
            long r8 = r1.a
            r10 = 1
            long r8 = r8 + r10
            long r10 = r1.b
            y11.v2 r12 = new y11.v2
            r12.<init>(r8, r10)
            r16 = 0
            r17 = 134216703(0x7fffbff, float:3.8516246E-34)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            y11.l1 r1 = y11.l1.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            ry1.e r4 = ky1.m0.a
            ky1.x r4 = x30.b.a
            s51.g r7 = new s51.g
            r8 = 0
            r7.<init>(r0, r1, r9, r8)
            r2.l = r6
            java.lang.Object r1 = ky1.c0.R(r4, r7, r2)
            if (r1 != r3) goto L8a
        L89:
            return r3
        L8a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.n.b(java.lang.String, sx1.c):java.lang.Object");
    }

    public final void c(l1 l1Var, boolean z) {
        String str;
        String str2 = l1Var.b;
        String str3 = l1Var.a;
        if (str2 != null) {
            str = str2;
        } else {
            if (str3 == null) {
                throw new IllegalStateException(("Revision id and stamp are null: " + l1Var).toString());
            }
            str = str3;
        }
        l1 l1VarA = (z && str3 == null) ? l1.a(l1Var, str2, (h3) null, (String) null, (d4) null, (v2) null, (List) null, (String) null, (r1) null, (m10.u) null, 134217726) : l1Var;
        String str4 = l1VarA.a;
        String str5 = str4 == null ? str : str4;
        String str6 = l1VarA.m;
        d4 d4Var = l1VarA.h;
        String str7 = d4Var != null ? d4Var.a : null;
        r rVar = this.a;
        ((g) rVar.a).b(-1160415225, "INSERT INTO my_revisions_v3 (object_id, object, created_on, revision_id, song_id, sync_version)\nVALUES (?, ?, ?, ?, ?, ?)", new com.bandlab.audio.controller.audioToMidi.a(str, l1VarA, str6, str5, str7, rVar));
        rVar.r(-1160415225, new s50.a(8));
    }

    public final Object d(l1 l1Var, c cVar) {
        ry1.e eVar = ky1.m0.a;
        Object objR = ky1.c0.R(b.a, new g(this, l1Var, (d) null, 1), cVar);
        return objR == a.a ? objR : lx1.b0.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (g(r6, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(y11.l1 r6, sx1.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof s51.k
            if (r0 == 0) goto L13
            r0 = r7
            s51.k r0 = (s51.k) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            s51.k r0 = new s51.k
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            lg.e.O(r7)
            goto L52
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            y11.l1 r6 = r0.j
            lg.e.O(r7)
            goto L46
        L38:
            lg.e.O(r7)
            r0.j = r6
            r0.m = r4
            java.lang.Object r7 = r5.d(r6, r0)
            if (r7 != r1) goto L46
            goto L51
        L46:
            r7 = 0
            r0.j = r7
            r0.m = r3
            java.lang.Object r6 = r5.g(r6, r0)
            if (r6 != r1) goto L52
        L51:
            return r1
        L52:
            lx1.b0 r6 = lx1.b0.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.n.e(y11.l1, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.String r20, boolean r21, sx1.c r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r22
            boolean r2 = r1 instanceof s51.l
            if (r2 == 0) goto L17
            r2 = r1
            s51.l r2 = (s51.l) r2
            int r3 = r2.m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.m = r3
            goto L1c
        L17:
            s51.l r2 = new s51.l
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.k
            rx1.a r3 = rx1.a.a
            int r4 = r2.m
            lx1.b0 r5 = lx1.b0.a
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L43
            if (r4 == r7) goto L38
            if (r4 != r6) goto L30
            lg.e.O(r1)
            return r5
        L30:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L38:
            boolean r4 = r2.j
            lg.e.O(r1)
            r18 = r4
            r4 = r1
            r1 = r18
            goto L55
        L43:
            lg.e.O(r1)
            r1 = r21
            r2.j = r1
            r2.m = r7
            r4 = r20
            java.lang.Object r4 = r0.a(r4, r2)
            if (r4 != r3) goto L55
            goto L79
        L55:
            r7 = r4
            y11.l1 r7 = (y11.l1) r7
            if (r7 == 0) goto L7a
            m10.u r4 = r7.z
            m10.u r16 = gn.a.H(r4, r1)
            r17 = 100663295(0x5ffffff, float:2.4074123E-35)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            y11.l1 r4 = y11.l1.a(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2.j = r1
            r2.m = r6
            java.lang.Object r1 = r0.d(r4, r2)
            if (r1 != r3) goto L7a
        L79:
            return r3
        L7a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.n.f(java.lang.String, boolean, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(y11.l1 r25, sx1.c r26) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.n.g(y11.l1, sx1.c):java.lang.Object");
    }
}
