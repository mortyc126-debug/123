package s51;

import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import dd.v;
import j50.q0;
import j51.a;
import java.io.Serializable;
import java.util.List;
import jv0.i0;
import lmjxuqdtp.NoWhenBranchMatchedException;
import m10.w;
import okhttp3.HttpUrl;
import qa.f;
import rd.g;
import ry1.e;
import s71.c;
import s71.d;
import s71.q;
import s71.s;
import x30.b;
import y11.d2;
import y11.d4;
import y11.g4;
import y11.h3;
import y11.l1;
import y11.n3;
import y11.o1;
import y11.r1;
import y11.s2;
import y11.v2;
import y11.w3;
import y11.z3;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {
    public final n0 a;
    public final lx1.h b;
    public final i0 c;

    public b0(n0 n0Var, lx1.h hVar, i0 i0Var) {
        this.a = n0Var;
        this.b = hVar;
        this.c = i0Var;
    }

    public static d4 j(o oVar) {
        s2 s2Var;
        q qVar = oVar.b;
        d dVar = oVar.r;
        c cVar = oVar.q;
        String str = qVar != null ? qVar.a : null;
        s sVar = oVar.c;
        String str2 = sVar != null ? sVar.a : null;
        String str3 = oVar.d;
        boolean z = oVar.f451f;
        boolean z2 = oVar.e;
        boolean z3 = oVar.g;
        boolean z4 = oVar.h;
        boolean z5 = oVar.i;
        m10.j0 j0Var = oVar.f452j;
        z3 z3Var = new z3(oVar.k);
        String strQ = b4.Q(oVar.l);
        String strQ2 = b4.Q(oVar.m);
        if ((cVar != null ? cVar.a : null) != null) {
            s2Var = new s2(cVar.a, (h3) null, (List) null, (List) null, (n3) null, (String) null, (String) null, (String) null, (d4) null, (String) null, (String) null, (v2) null, (o1) null, (String) null, (m10.q) null, false, false, (List) null, false, false, (d2) null, 0.0d, (String) null, (String) null, (r1) null, (m10.u) null, (Boolean) null, 536870910);
        } else {
            s2Var = (dVar != null ? dVar.a : null) != null ? new s2((String) null, (h3) null, (List) null, (List) null, (n3) null, dVar.a, (String) null, (String) null, (d4) null, (String) null, (String) null, (v2) null, (o1) null, (String) null, (m10.q) null, false, false, (List) null, false, false, (d2) null, 0.0d, (String) null, (String) null, (r1) null, (m10.u) null, (Boolean) null, 536870847) : null;
        }
        l1 l1VarP = s2Var != null ? m8.d.P(s2Var) : null;
        String str4 = oVar.n;
        if (str4 == null) {
            str4 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String str5 = str4;
        String str6 = oVar.p;
        w wVar = oVar.o;
        if (wVar == null) {
            wVar = w.c;
        }
        return new d4(str, str2, str3, (String) null, strQ2, z3, z, l1VarP, z3Var, j0Var, false, z2, (List) null, new g4(wVar, str5, str6, (String) null, (String) null), z4, Boolean.valueOf(z5), (w3) null, strQ, 610600);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Serializable a(int i, int i2, String str, Boolean bool, Boolean bool2, a aVar, sx1.c cVar) throws NoWhenBranchMatchedException {
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            return h(i, i2, str, w.b, false, HttpUrl.FRAGMENT_ENCODE_SET, bool, bool2, cVar);
        }
        if (iOrdinal == 1) {
            return i(i, i2, str, w.b, false, HttpUrl.FRAGMENT_ENCODE_SET, bool, bool2, cVar);
        }
        if (iOrdinal == 2) {
            return g(i, i2, str, w.b, false, HttpUrl.FRAGMENT_ENCODE_SET, bool, bool2, cVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r17, sx1.c r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof s51.t
            if (r2 == 0) goto L17
            r2 = r1
            s51.t r2 = (s51.t) r2
            int r3 = r2.l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.l = r3
            goto L1c
        L17:
            s51.t r2 = new s51.t
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.j
            rx1.a r3 = rx1.a.a
            int r4 = r2.l
            r5 = 1
            if (r4 == 0) goto L33
            if (r4 != r5) goto L2b
            lg.e.O(r1)
            goto L67
        L2b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L33:
            lg.e.O(r1)
            jv0.i0 r1 = r0.c
            or.q r1 = (or.q) r1
            java.lang.String r8 = r1.b()
            if (r8 != 0) goto L41
            goto L6b
        L41:
            s71.q r9 = new s71.q
            r1 = r17
            r9.<init>(r1)
            py.b r1 = new py.b
            r4 = 19
            r1.<init>(r4)
            oq.p r6 = new oq.p
            qe0.e r10 = new qe0.e
            r4 = 13
            s51.n0 r7 = r0.a
            r10.<init>(r4, r1, r7)
            r11 = 2
            r6.<init>(r7, r8, r9, r10, r11)
            r2.l = r5
            java.lang.Object r1 = x30.b.e(r6, r2)
            if (r1 != r3) goto L67
            return r3
        L67:
            s51.b r1 = (s51.b) r1
            if (r1 != 0) goto L6d
        L6b:
            r1 = 0
            return r1
        L6d:
            y11.d4 r2 = r1.b()
            y11.l1 r8 = r1.a()
            r14 = 0
            r15 = 2096639(0x1ffdff, float:2.938017E-39)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            y11.d4 r1 = y11.d4.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.b0.b(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(java.lang.String r7, sx1.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof s51.v
            if (r0 == 0) goto L13
            r0 = r8
            s51.v r0 = (s51.v) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            s51.v r0 = new s51.v
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            s51.n0 r3 = r6.a
            r4 = 1
            if (r2 == 0) goto L31
            if (r2 != r4) goto L29
            lg.e.O(r8)
            goto L4f
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L31:
            lg.e.O(r8)
            s71.c r8 = new s71.c
            r8.<init>(r7)
            k41.b r7 = new k41.b
            qu0.p r2 = new qu0.p
            r5 = 19
            r2.<init>(r5, r3)
            r5 = 3
            r7.<init>(r3, r8, r2, r5)
            r0.l = r4
            java.lang.Object r8 = x30.b.e(r7, r0)
            if (r8 != r1) goto L4f
            return r1
        L4f:
            y11.d4 r8 = (y11.d4) r8
            r7 = 0
            if (r8 == 0) goto L57
            java.lang.String r0 = r8.a
            goto L58
        L57:
            r0 = r7
        L58:
            if (r0 == 0) goto L89
            jv0.i0 r1 = r6.c
            java.lang.String r1 = dd.v.D(r1)
            s71.q r2 = new s71.q
            r2.<init>(r0)
            java.lang.String r0 = "song"
            lmjxuqdtp.jvm.internal.o.h(r8, r0)
            java.lang.Object r0 = r3.a
            rd.g r0 = (rd.g) r0
            java.lang.String r4 = "\n        |UPDATE Songs SET song = ?\n        |WHERE userId = ? AND songId = ?\n        "
            java.lang.String r4 = hy1.r.d0(r4)
            s51.f0 r5 = new s51.f0
            r5.<init>(r3, r8, r1, r2)
            r0.b(r7, r4, r5)
            s50.a r7 = new s50.a
            r8 = 10
            r7.<init>(r8)
            r8 = 1954835469(0x74846c0d, float:8.393246E31)
            r3.r(r8, r7)
        L89:
            lx1.b0 r7 = lx1.b0.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.b0.c(java.lang.String, sx1.c):java.lang.Object");
    }

    public final Object d(String str, sx1.c cVar) {
        e eVar = ky1.m0.a;
        Object objR = ky1.c0.R(b.a, new s(this, str, (qx1.d) null, 1), cVar);
        return objR == rx1.a.a ? objR : lx1.b0.a;
    }

    public final Object e(d4 d4Var, sx1.c cVar) {
        l1 l1Var = d4Var.j;
        if (l1Var != null) {
            e eVar = ky1.m0.a;
            Object objR = ky1.c0.R(b.a, new q0(this, d4Var, l1Var, (qx1.d) null, 20), cVar);
            return objR == rx1.a.a ? objR : lx1.b0.a;
        }
        throw new IllegalArgumentException(("Song doesn't contain revision " + d4Var).toString());
    }

    public final void f(d4 d4Var, String str, String str2) {
        lmjxuqdtp.jvm.internal.o.h(d4Var, "song");
        String strD = v.D(this.c);
        if (str == null && str2 == null) {
            throw new IllegalStateException("Cannot save song with null revision id and stamp");
        }
        String str3 = d4Var.a;
        q qVar = str3 != null ? new q(str3) : null;
        String str4 = d4Var.b;
        o0 o0VarC = f.C(d4Var, strD, qVar, str4 != null ? new s(str4) : null, str != null ? new c(str) : null, str2 != null ? new d(str2) : null);
        n0 n0Var = this.a;
        ((g) n0Var.a).b(2117817467, "INSERT OR REPLACE INTO Songs (userId, songId, songStamp, song, songName, isCollaborator, isPublic, isFork, canEdit, canDelete, picture, collaboratorsCount, lastRevisionCreatedOn, createdOn, authorId, authorType, authorName, revisionId, revisionStamp, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", new qe0.e(14, o0VarC, n0Var));
        n0Var.r(2117817467, new s50.a(16));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable g(int r23, int r24, java.lang.String r25, m10.w r26, boolean r27, java.lang.String r28, java.lang.Boolean r29, java.lang.Boolean r30, sx1.c r31) {
        /*
            r22 = this;
            r0 = r22
            r1 = r31
            boolean r2 = r1 instanceof s51.x
            if (r2 == 0) goto L17
            r2 = r1
            s51.x r2 = (s51.x) r2
            int r3 = r2.l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.l = r3
            goto L1c
        L17:
            s51.x r2 = new s51.x
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.j
            rx1.a r3 = rx1.a.a
            int r4 = r2.l
            r5 = 1
            if (r4 == 0) goto L34
            if (r4 != r5) goto L2c
            lg.e.O(r1)
            goto L98
        L2c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L34:
            lg.e.O(r1)
            r1 = r23
            long r6 = (long) r1
            r1 = r24
            long r8 = (long) r1
            jv0.i0 r1 = r0.c
            java.lang.String r1 = dd.v.D(r1)
            if (r27 == 0) goto L49
            r10 = 1
        L47:
            r13 = r10
            goto L4c
        L49:
            r10 = 0
            goto L47
        L4c:
            boolean r4 = hy1.q.L0(r28)
            if (r4 == 0) goto L55
            java.lang.String r4 = ""
            goto L63
        L55:
            java.lang.CharSequence r4 = hy1.q.o1(r28)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "%"
            java.lang.String r4 = i.n(r10, r4, r10)
        L63:
            java.lang.String r10 = "filter"
            lmjxuqdtp.jvm.internal.o.h(r4, r10)
            s51.d0 r10 = new s51.d0
            r11 = 0
            r10.<init>(r11)
            r18 = r6
            s51.l0 r6 = new s51.l0
            qe0.e r7 = new qe0.e
            r11 = 15
            s51.n0 r12 = r0.a
            r7.<init>(r11, r10, r12)
            r21 = 0
            r11 = r25
            r10 = r29
            r15 = r30
            r20 = r7
            r16 = r8
            r7 = r12
            r12 = r26
            r8 = r1
            r9 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r15, r16, r18, r20, r21)
            r2.l = r5
            java.lang.Object r1 = x30.b.b(r6, r2)
            if (r1 != r3) goto L98
            return r3
        L98:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = mx1.p.c0(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        La9:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lbd
            java.lang.Object r3 = r1.next()
            s51.o r3 = (s51.o) r3
            y11.d4 r3 = j(r3)
            r2.add(r3)
            goto La9
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.b0.g(int, int, java.lang.String, m10.w, boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, sx1.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable h(int r22, int r23, java.lang.String r24, m10.w r25, boolean r26, java.lang.String r27, java.lang.Boolean r28, java.lang.Boolean r29, sx1.c r30) {
        /*
            r21 = this;
            r0 = r21
            r1 = r30
            boolean r2 = r1 instanceof s51.y
            if (r2 == 0) goto L17
            r2 = r1
            s51.y r2 = (s51.y) r2
            int r3 = r2.l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.l = r3
            goto L1c
        L17:
            s51.y r2 = new s51.y
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.f454j
            rx1.a r3 = rx1.a.a
            int r4 = r2.l
            r5 = 1
            if (r4 == 0) goto L34
            if (r4 != r5) goto L2c
            lg.e.O(r1)
            goto L95
        L2c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L34:
            lg.e.O(r1)
            r1 = r22
            long r6 = (long) r1
            r1 = r23
            long r8 = (long) r1
            jv0.i0 r1 = r0.c
            java.lang.String r1 = dd.v.D(r1)
            if (r26 == 0) goto L49
            r10 = 1
        L47:
            r13 = r10
            goto L4c
        L49:
            r10 = 0
            goto L47
        L4c:
            boolean r4 = hy1.q.L0(r27)
            if (r4 == 0) goto L55
            java.lang.String r4 = ""
            goto L63
        L55:
            java.lang.CharSequence r4 = hy1.q.o1(r27)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "%"
            java.lang.String r4 = i.n(r10, r4, r10)
        L63:
            java.lang.String r10 = "filter"
            lmjxuqdtp.jvm.internal.o.h(r4, r10)
            s51.g0 r10 = new s51.g0
            r10.<init>()
            r18 = r6
            s51.m0 r6 = new s51.m0
            le1.h r7 = new le1.h
            r11 = 16
            s51.n0 r12 = r0.a
            r7.<init>(r11, r10, r12)
            r11 = r24
            r10 = r28
            r15 = r29
            r20 = r7
            r16 = r8
            r7 = r12
            r12 = r25
            r8 = r1
            r9 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r15, r16, r18, r20)
            r2.l = r5
            java.lang.Object r1 = x30.b.b(r6, r2)
            if (r1 != r3) goto L95
            return r3
        L95:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = mx1.p.c0(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        La6:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lba
            java.lang.Object r3 = r1.next()
            s51.o r3 = (s51.o) r3
            y11.d4 r3 = j(r3)
            r2.add(r3)
            goto La6
        Lba:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.b0.h(int, int, java.lang.String, m10.w, boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, sx1.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable i(int r23, int r24, java.lang.String r25, m10.w r26, boolean r27, java.lang.String r28, java.lang.Boolean r29, java.lang.Boolean r30, sx1.c r31) {
        /*
            r22 = this;
            r0 = r22
            r1 = r31
            boolean r2 = r1 instanceof s51.z
            if (r2 == 0) goto L17
            r2 = r1
            s51.z r2 = (s51.z) r2
            int r3 = r2.l
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.l = r3
            goto L1c
        L17:
            s51.z r2 = new s51.z
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.j
            rx1.a r3 = rx1.a.a
            int r4 = r2.l
            r5 = 1
            if (r4 == 0) goto L34
            if (r4 != r5) goto L2c
            lg.e.O(r1)
            goto L98
        L2c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L34:
            lg.e.O(r1)
            r1 = r23
            long r6 = (long) r1
            r1 = r24
            long r8 = (long) r1
            jv0.i0 r1 = r0.c
            java.lang.String r1 = dd.v.D(r1)
            if (r27 == 0) goto L49
            r10 = 1
        L47:
            r13 = r10
            goto L4c
        L49:
            r10 = 0
            goto L47
        L4c:
            boolean r4 = hy1.q.L0(r28)
            if (r4 == 0) goto L55
            java.lang.String r4 = ""
            goto L63
        L55:
            java.lang.CharSequence r4 = hy1.q.o1(r28)
            java.lang.String r4 = r4.toString()
            java.lang.String r10 = "%"
            java.lang.String r4 = i.n(r10, r4, r10)
        L63:
            java.lang.String r10 = "filter"
            lmjxuqdtp.jvm.internal.o.h(r4, r10)
            s51.d0 r10 = new s51.d0
            r11 = 1
            r10.<init>(r11)
            r18 = r6
            s51.l0 r6 = new s51.l0
            qe0.e r7 = new qe0.e
            r11 = 11
            s51.n0 r12 = r0.a
            r7.<init>(r11, r10, r12)
            r21 = 1
            r11 = r25
            r10 = r29
            r15 = r30
            r20 = r7
            r16 = r8
            r7 = r12
            r12 = r26
            r8 = r1
            r9 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r15, r16, r18, r20, r21)
            r2.l = r5
            java.lang.Object r1 = x30.b.b(r6, r2)
            if (r1 != r3) goto L98
            return r3
        L98:
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = mx1.p.c0(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        La9:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lbd
            java.lang.Object r3 = r1.next()
            s51.o r3 = (s51.o) r3
            y11.d4 r3 = j(r3)
            r2.add(r3)
            goto La9
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.b0.i(int, int, java.lang.String, m10.w, boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, sx1.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(sx1.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof s51.a0
            if (r0 == 0) goto L13
            r0 = r9
            s51.a0 r0 = (s51.a0) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            s51.a0 r0 = new s51.a0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f448j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 0
            r5 = 1
            if (r2 == 0) goto L31
            if (r2 != r5) goto L29
            lg.e.O(r9)
            goto L55
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L31:
            lg.e.O(r9)
            jv0.i0 r9 = r8.c
            or.q r9 = (or.q) r9
            java.lang.String r9 = r9.b()
            if (r9 == 0) goto L5d
            s51.k0 r2 = new s51.k0
            p90.f r6 = new p90.f
            r7 = 26
            r6.<init>(r7)
            s51.n0 r7 = r8.a
            r2.<init>(r7, r9, r6)
            r0.l = r5
            java.lang.Object r9 = x30.b.e(r2, r0)
            if (r9 != r1) goto L55
            return r1
        L55:
            java.lang.Long r9 = (java.lang.Long) r9
            if (r9 == 0) goto L5d
            long r3 = r9.longValue()
        L5d:
            java.lang.Long r9 = new java.lang.Long
            r9.<init>(r3)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s51.b0.k(sx1.c):java.lang.Object");
    }
}
