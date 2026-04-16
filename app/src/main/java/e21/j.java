package e21;

import fy1.l;
import i51.g;
import ky1.m0;
import ky1.x;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.jvm.internal.v;
import ny1.c2;
import pd.d;
import qg.a;
import ry1.e;
import s11.b;
import s11.c;
import s51.h;
import s51.n;
import s51.r;
import w2.u;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f96f;
    public final g a;
    public final u b;
    public final n c;
    public final c d;
    public final mt.b e;

    static {
        l vVar = new v(j.class, "postsService", "getPostsService()Lcom/bandlab/bandlab/posts/api/PostsService;", 0);
        d0.a.getClass();
        f96f = new l[]{vVar};
    }

    public j(g gVar, u uVar, n nVar, c cVar, mt.b bVar) {
        this.a = gVar;
        this.b = uVar;
        this.c = nVar;
        this.d = cVar;
        this.e = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(v01.f r9, sx1.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof e21.a
            if (r0 == 0) goto L13
            r0 = r10
            e21.a r0 = (e21.a) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            e21.a r0 = new e21.a
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            lx1.b0 r3 = lx1.b0.a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3a
            if (r2 == r5) goto L34
            if (r2 != r4) goto L2c
            lg.e.O(r10)
            return r3
        L2c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L34:
            v01.f r9 = r0.j
            lg.e.O(r10)
            goto L68
        L3a:
            lg.e.O(r10)
            fy1.l[] r10 = e21.j.f96f
            r2 = 0
            r10 = r10[r2]
            jx0.h r2 = new jx0.h
            java.lang.Class<com.bandlab.bandlab.posts.api.PostsService> r6 = com.bandlab.bandlab.posts.api.PostsService.class
            lmjxuqdtp.jvm.internal.f r6 = lmjxuqdtp.jvm.internal.d0.a(r6)
            mt.b r7 = r8.e
            r2.<init>(r6, r7)
            java.lang.Object r10 = r2.t(r10)
            com.bandlab.bandlab.posts.api.PostsService r10 = (com.bandlab.bandlab.posts.api.PostsService) r10
            java.lang.String r2 = r9.q()
            m10.u r6 = r9.p()
            r0.j = r9
            r0.m = r5
            java.lang.Object r10 = r10.updatePost(r2, r6, r0)
            if (r10 != r1) goto L68
            goto L83
        L68:
            java.lang.String r10 = r9.r()
            if (r10 == 0) goto L84
            m10.u r9 = r9.p()
            boolean r9 = gn.a.Q(r9)
            r2 = 0
            r0.j = r2
            r0.m = r4
            s51.n r2 = r8.c
            java.lang.Object r9 = r2.f(r10, r9, r0)
            if (r9 != r1) goto L84
        L83:
            return r1
        L84:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.a(v01.f, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        if (r2 == r4) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r18, sx1.c r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r2 instanceof e21.b
            if (r3 == 0) goto L19
            r3 = r2
            e21.b r3 = (e21.b) r3
            int r4 = r3.m
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.m = r4
            goto L1e
        L19:
            e21.b r3 = new e21.b
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.k
            rx1.a r4 = rx1.a.a
            int r5 = r3.m
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L3e
            if (r5 == r7) goto L38
            if (r5 != r6) goto L30
            lg.e.O(r2)
            goto L79
        L30:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L38:
            java.lang.String r1 = r3.j
            lg.e.O(r2)
            goto L5d
        L3e:
            lg.e.O(r2)
            r3.j = r1
            r3.m = r7
            s51.n r2 = r0.c
            s51.r r2 = r2.a
            s51.e r5 = s51.e.b
            s51.q r5 = new s51.q
            s51.p r7 = new s51.p
            r8 = 0
            r7.<init>(r2, r8)
            r5.<init>(r2, r1, r7, r8)
            java.lang.Object r2 = x30.b.e(r5, r3)
            if (r2 != r4) goto L5d
            goto L78
        L5d:
            y11.l1 r2 = (y11.l1) r2
            if (r2 == 0) goto L62
            return r2
        L62:
            s02.b r2 = s02.d.a
            java.lang.String r5 = "Can't find revision from local DB, songId: "
            i.A(r5, r1, r2)
            r2 = 0
            r3.j = r2
            r3.m = r6
            i51.g r2 = r0.a
            com.bandlab.song.utils.b r2 = (com.bandlab.song.utils.b) r2
            java.lang.Object r2 = r2.d(r1, r3)
            if (r2 != r4) goto L79
        L78:
            return r4
        L79:
            r3 = r2
            y11.d4 r3 = (y11.d4) r3
            java.lang.String r1 = "<this>"
            lmjxuqdtp.jvm.internal.o.h(r3, r1)
            y11.l1 r1 = r3.j
            if (r1 == 0) goto La2
            r15 = 0
            r16 = 2096639(0x1ffdff, float:2.938017E-39)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            y11.d4 r8 = y11.d4.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r14 = 134217599(0x7ffff7f, float:3.8518303E-34)
            r11 = 0
            r4 = r1
            y11.l1 r1 = y11.l1.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r1
        La2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Song doesn't have revision. song = "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.b(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a3, code lost:
    
        if (r11 != r1) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:14:0x002c, B:50:0x00a6, B:51:0x00b0, B:21:0x0040, B:40:0x0084, B:42:0x008c, B:44:0x0090, B:47:0x0095, B:24:0x004a, B:34:0x006d, B:36:0x0071, B:27:0x0056, B:30:0x0063), top: B:55:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable c(java.lang.String r10, sx1.c r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof e21.c
            if (r0 == 0) goto L13
            r0 = r11
            e21.c r0 = (e21.c) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            e21.c r0 = new e21.c
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L53
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            y11.l1 r10 = r0.l
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L31
            goto La6
        L31:
            r10 = move-exception
            goto Lb5
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            int r10 = r0.m
            e21.j r2 = r0.k
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L31
            goto L84
        L44:
            int r10 = r0.m
            e21.j r2 = r0.k
            java.lang.String r7 = r0.j
            lg.e.O(r11)     // Catch: java.lang.Throwable -> L31
            r8 = r11
            r11 = r10
            r10 = r7
            r7 = r2
            r2 = r8
            goto L6d
        L53:
            lg.e.O(r11)
            r0.j = r10     // Catch: java.lang.Throwable -> L31
            r0.k = r9     // Catch: java.lang.Throwable -> L31
            r11 = 0
            r0.m = r11     // Catch: java.lang.Throwable -> L31
            r0.p = r5     // Catch: java.lang.Throwable -> L31
            if (r10 != 0) goto L63
            r2 = r6
            goto L69
        L63:
            s51.n r2 = r9.c     // Catch: java.lang.Throwable -> L31
            java.lang.Object r2 = r2.a(r10, r0)     // Catch: java.lang.Throwable -> L31
        L69:
            if (r2 != r1) goto L6c
            goto La5
        L6c:
            r7 = r9
        L6d:
            y11.l1 r2 = (y11.l1) r2     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L8b
            r0.j = r6     // Catch: java.lang.Throwable -> L31
            r0.k = r7     // Catch: java.lang.Throwable -> L31
            r0.m = r11     // Catch: java.lang.Throwable -> L31
            r0.p = r4     // Catch: java.lang.Throwable -> L31
            java.lang.Object r10 = r7.f(r10, r0)     // Catch: java.lang.Throwable -> L31
            if (r10 != r1) goto L80
            goto La5
        L80:
            r2 = r11
            r11 = r10
            r10 = r2
            r2 = r7
        L84:
            y11.l1 r11 = (y11.l1) r11     // Catch: java.lang.Throwable -> L31
            r7 = r11
            r11 = r10
            r10 = r7
            r7 = r2
            goto L8c
        L8b:
            r10 = r2
        L8c:
            y11.d4 r2 = r10.h     // Catch: java.lang.Throwable -> L31
            if (r2 == 0) goto Lb0
            java.lang.String r2 = r2.a     // Catch: java.lang.Throwable -> L31
            if (r2 != 0) goto L95
            goto Lb0
        L95:
            r0.j = r6     // Catch: java.lang.Throwable -> L31
            r0.k = r6     // Catch: java.lang.Throwable -> L31
            r0.l = r10     // Catch: java.lang.Throwable -> L31
            r0.m = r11     // Catch: java.lang.Throwable -> L31
            r0.p = r3     // Catch: java.lang.Throwable -> L31
            java.lang.Object r11 = r7.b(r2, r0)     // Catch: java.lang.Throwable -> L31
            if (r11 != r1) goto La6
        La5:
            return r1
        La6:
            y11.l1 r11 = (y11.l1) r11     // Catch: java.lang.Throwable -> L31
            java.lang.String r10 = r10.a     // Catch: java.lang.Throwable -> L31
            java.lang.String r11 = r11.a     // Catch: java.lang.Throwable -> L31
            boolean r5 = lmjxuqdtp.jvm.internal.o.c(r10, r11)     // Catch: java.lang.Throwable -> L31
        Lb0:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L31
            return r10
        Lb5:
            lx1.n r10 = lg.e.u(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.c(java.lang.String, sx1.c):java.io.Serializable");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r5, sx1.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof e21.d
            if (r0 == 0) goto L13
            r0 = r6
            e21.d r0 = (e21.d) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            e21.d r0 = new e21.d
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r6)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            lg.e.O(r6)
            r0.l = r3
            s51.n r6 = r4.c
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            y11.l1 r6 = (y11.l1) r6
            if (r6 == 0) goto L42
            return r6
        L42:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.String r6 = "revisionId is not found"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.d(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.bandlab.revision.utils.impl.NoRevisionFoundException */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.String r12, sx1.c r13) throws com.bandlab.revision.utils.impl.NoRevisionFoundException {
        /*
            r11 = this;
            boolean r0 = r13 instanceof e21.e
            if (r0 == 0) goto L13
            r0 = r13
            e21.e r0 = (e21.e) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.l = r1
            goto L18
        L13:
            e21.e r0 = new e21.e
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.j
            rx1.a r1 = rx1.a.a
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            lg.e.O(r13)
            goto L3d
        L27:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2f:
            lg.e.O(r13)
            r0.l = r3
            s51.n r13 = r11.c
            java.lang.Object r13 = r13.a(r12, r0)
            if (r13 != r1) goto L3d
            return r1
        L3d:
            r0 = r13
            y11.l1 r0 = (y11.l1) r0
            if (r0 == 0) goto L81
            java.lang.String r12 = r0.g()
            r13 = 0
            if (r12 != 0) goto L4b
            r12 = r13
            goto L53
        L4b:
            w2.u r1 = r11.b
            y10.b r2 = y10.b.b
            java.io.File r12 = r1.i(r12, r2)
        L53:
            if (r12 != 0) goto L59
            java.lang.String r12 = "Empty"
        L57:
            r5 = r12
            goto L5c
        L59:
            java.lang.String r12 = "Ready"
            goto L57
        L5c:
            y11.h3 r12 = r0.c
            if (r12 == 0) goto L70
            y11.h3 r1 = new y11.h3
            java.lang.String r2 = r12.a
            double r3 = r12.b
            r8 = 0
            r9 = 56
            r6 = 0
            r7 = 0
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            r2 = r1
            goto L71
        L70:
            r2 = r13
        L71:
            r9 = 0
            r10 = 134217723(0x7fffffb, float:3.8518587E-34)
            r1 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            y11.l1 r12 = y11.l1.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r12
        L81:
            com.bandlab.revision.utils.impl.NoRevisionFoundException r12 = new com.bandlab.revision.utils.impl.NoRevisionFoundException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.e(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.bandlab.revision.utils.impl.NoRevisionFoundException */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.String r8, sx1.c r9) throws com.bandlab.revision.utils.impl.NoRevisionFoundException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof e21.f
            if (r0 == 0) goto L13
            r0 = r9
            e21.f r0 = (e21.f) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            e21.f r0 = new e21.f
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            lg.e.O(r9)
            return r9
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            y11.l1 r8 = r0.j
            lg.e.O(r9)     // Catch: java.lang.Exception -> L3b
            goto L90
        L3b:
            r9 = move-exception
            goto L93
        L3d:
            lg.e.O(r9)
            goto L69
        L41:
            lg.e.O(r9)
            s02.b r9 = s02.d.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "::ME Loading revision with ID: "
            r2.<init>(r6)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r9.getClass()
            s02.b.t(r2)
            boolean r9 = com.facebook.appevents.p.S(r8)
            if (r9 == 0) goto La4
            r0.m = r5
            java.lang.Object r9 = r7.e(r8, r0)
            if (r9 != r1) goto L69
            goto Lb1
        L69:
            r8 = r9
            y11.l1 r8 = (y11.l1) r8
            java.lang.String r9 = r8.a
            r2 = 0
            if (r9 == 0) goto L78
            boolean r3 = com.facebook.appevents.p.T(r9)
            if (r3 == 0) goto L78
            goto L79
        L78:
            r9 = r2
        L79:
            if (r9 == 0) goto L99
            s02.b r2 = s02.d.a
            r2.getClass()
            java.lang.String r2 = "ME:: Even though id is local, load revision from network..."
            s02.b.t(r2)
            r0.j = r8     // Catch: java.lang.Exception -> L3b
            r0.m = r4     // Catch: java.lang.Exception -> L3b
            java.lang.Object r9 = r7.g(r9, r0)     // Catch: java.lang.Exception -> L3b
            if (r9 != r1) goto L90
            goto Lb1
        L90:
            y11.l1 r9 = (y11.l1) r9     // Catch: java.lang.Exception -> L3b
            return r9
        L93:
            s02.b r0 = s02.d.a
            r0.e(r9)
            return r8
        L99:
            s02.b r9 = s02.d.a
            r9.getClass()
            java.lang.String r9 = "ME:: Use revision from db..."
            s02.b.t(r9)
            return r8
        La4:
            java.lang.String r9 = "ME:: network revision, fetch info from BE..."
            s02.b.t(r9)
            r0.m = r3
            java.lang.Object r8 = r7.g(r8, r0)
            if (r8 != r1) goto Lb2
        Lb1:
            return r1
        Lb2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.f(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(java.lang.String r7, sx1.c r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof e21.g
            if (r0 == 0) goto L13
            r0 = r8
            e21.g r0 = (e21.g) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            e21.g r0 = new e21.g
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r7 = r0.j
            lg.e.O(r8)
            return r7
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            lg.e.O(r8)
            goto L48
        L38:
            lg.e.O(r8)
            r0.m = r4
            s11.c r8 = r6.d
            com.bandlab.revision.services.impl.b r8 = (com.bandlab.revision.services.impl.b) r8
            java.lang.Object r8 = r8.b(r7, r0)
            if (r8 != r1) goto L48
            goto L74
        L48:
            r7 = r8
            y11.l1 r7 = (y11.l1) r7
            y11.d4 r2 = r7.h
            if (r2 == 0) goto L5b
            java.lang.String r2 = r2.a
            if (r2 == 0) goto L5b
            java.lang.String r4 = "Song id is null"
            r5 = 0
            java.lang.String[] r5 = new java.lang.String[r5]
            com.bandlab.bandlab.utils.debug.DebugUtils.debugThrowIfNull(r2, r4, r5)
        L5b:
            boolean r2 = r7.r
            if (r2 != 0) goto L60
            goto L75
        L60:
            java.lang.String r2 = r7.a
            boolean r2 = com.facebook.appevents.p.U(r2)
            if (r2 == 0) goto L75
            r0.j = r8
            r0.m = r3
            s51.n r2 = r6.c
            java.lang.Object r7 = r2.d(r7, r0)
            if (r7 != r1) goto L75
        L74:
            return r1
        L75:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.g(java.lang.String, sx1.c):java.lang.Object");
    }

    public final d h(String str) {
        o.h(str, "idOrStamp");
        r rVar = this.c.a;
        h hVar = h.b;
        c2 c2VarB = a.B(new c31.c(rVar, str, str, new lb.d(rVar), 4));
        e eVar = m0.a;
        x xVar = x30.b.a;
        o.h(xVar, "context");
        return new d(c2VarB, xVar, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(y11.l1 r6, sx1.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof e21.h
            if (r0 == 0) goto L13
            r0 = r7
            e21.h r0 = (e21.h) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            e21.h r0 = new e21.h
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L38
            if (r2 == r3) goto L34
            if (r2 != r4) goto L2c
            java.lang.Object r6 = r0.j
            lg.e.O(r7)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            lg.e.O(r7)
            goto L51
        L38:
            lg.e.O(r7)
            java.lang.String r7 = r6.a
            if (r7 == 0) goto L62
            p11.j r6 = new p11.j
            r6.<init>()
            r0.m = r3
            s11.c r2 = r5.d
            com.bandlab.revision.services.impl.b r2 = (com.bandlab.revision.services.impl.b) r2
            java.lang.Object r7 = r2.d(r7, r6, r0)
            if (r7 != r1) goto L51
            goto L60
        L51:
            r6 = r7
            y11.l1 r6 = (y11.l1) r6
            r0.j = r7
            r0.m = r4
            s51.n r2 = r5.c
            java.lang.Object r6 = r2.e(r6, r0)
            if (r6 != r1) goto L61
        L60:
            return r1
        L61:
            return r7
        L62:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Revision id is null: "
            r0.<init>(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.i(y11.l1, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(java.lang.String r6, y11.l1 r7, sx1.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof e21.i
            if (r0 == 0) goto L13
            r0 = r8
            e21.i r0 = (e21.i) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            e21.i r0 = new e21.i
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r6 = r0.j
            lg.e.O(r8)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            lg.e.O(r8)
            goto L48
        L38:
            lg.e.O(r8)
            r0.m = r4
            s11.c r8 = r5.d
            com.bandlab.revision.services.impl.b r8 = (com.bandlab.revision.services.impl.b) r8
            java.lang.Object r8 = r8.a(r6, r7, r0)
            if (r8 != r1) goto L48
            goto L57
        L48:
            r6 = r8
            y11.l1 r6 = (y11.l1) r6
            r0.j = r8
            r0.m = r3
            s51.n r7 = r5.c
            java.lang.Object r6 = r7.e(r6, r0)
            if (r6 != r1) goto L58
        L57:
            return r1
        L58:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: e21.j.j(java.lang.String, y11.l1, sx1.c):java.lang.Object");
    }
}
