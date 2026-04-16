package gy0;

import com.bandlab.playlist.api.PlaylistsService;
import com.ironsource.adqualitysdk.sdk.i.a0;
import fy1.l;
import go.a;
import i11.t;
import jx0.h;
import l41.k;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import ow.n;
import p41.e;
import p41.j;
import q41.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static final /* synthetic */ l[] l = {new lmjxuqdtp.jvm.internal.v(v.class, "service", "getService()Lcom/bandlab/playlist/api/PlaylistsService;", 0), a0.r(d0.a, v.class, "imageService", "getImageService()Lcom/bandlab/playlist/api/CollectionsImageService;", 0)};
    public final n a;
    public final t b;
    public final z c;
    public final e d;
    public final j e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k f185f;
    public final m41.k g;
    public final b h;
    public final b i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final mt.b f186j;
    public final mt.b k;

    public v(n nVar, t tVar, z zVar, e eVar, j jVar, k kVar, m41.k kVar2, b bVar, b bVar2, mt.b bVar3) {
        this.a = nVar;
        this.b = tVar;
        this.c = zVar;
        this.d = eVar;
        this.e = jVar;
        this.f185f = kVar;
        this.g = kVar2;
        this.h = bVar;
        this.i = bVar2;
        this.f186j = bVar3;
        this.k = bVar3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(gy0.v r5, java.util.List r6, sx1.c r7) {
        /*
            boolean r0 = r7 instanceof gy0.q
            if (r0 == 0) goto L13
            r0 = r7
            gy0.q r0 = (gy0.q) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            gy0.q r0 = new gy0.q
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.n
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r6 = r0.k
            java.util.Iterator r2 = r0.j
            lg.e.O(r7)
            goto L3d
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            lg.e.O(r7)
            java.util.Iterator r6 = r6.iterator()
            r7 = 0
            r2 = r6
            r6 = r7
        L3d:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L5c
            java.lang.Object r7 = r2.next()
            dh1.w r7 = (dh1.w) r7
            m41.k r4 = r5.g
            q10.j0 r7 = r7.G()
            r0.j = r2
            r0.k = r6
            r0.n = r3
            java.lang.Object r7 = r4.Q(r7, r0)
            if (r7 != r1) goto L3d
            return r1
        L5c:
            lx1.b0 r5 = lx1.b0.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.a(gy0.v, java.util.List, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(gy0.c r6, sx1.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof gy0.n
            if (r0 == 0) goto L13
            r0 = r7
            gy0.n r0 = (gy0.n) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            gy0.n r0 = new gy0.n
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
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
            goto L48
        L38:
            lg.e.O(r7)
            com.bandlab.playlist.api.PlaylistsService r7 = r5.d()
            r0.m = r4
            java.lang.Object r7 = r7.create(r6, r0)
            if (r7 != r1) goto L48
            goto L55
        L48:
            r6 = r7
            gy0.i r6 = (gy0.i) r6
            r0.j = r7
            r0.m = r3
            java.lang.Object r6 = r5.g(r6, r0)
            if (r6 != r1) goto L56
        L55:
            return r1
        L56:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.b(gy0.c, sx1.c):java.lang.Object");
    }

    public final a c(String str) {
        o.h(str, "id");
        return new a(this, str);
    }

    public final PlaylistsService d() {
        return (PlaylistsService) new h(d0.a(PlaylistsService.class), this.f186j).t(l[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.String r9, java.lang.String r10, sx1.c r11, tc0.p r12, boolean r13) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof gy0.o
            if (r0 == 0) goto L14
            r0 = r11
            gy0.o r0 = (gy0.o) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.n = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            gy0.o r0 = new gy0.o
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.l
            rx1.a r0 = rx1.a.a
            int r1 = r6.n
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L36
            if (r1 != r7) goto L2e
            java.lang.Object r9 = r6.j
            lg.e.O(r11)
            return r9
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            boolean r13 = r6.k
            lg.e.O(r11)
            goto L53
        L3c:
            lg.e.O(r11)
            com.bandlab.playlist.api.PlaylistsService r1 = r8.d()
            r6.k = r13
            r6.n = r2
            r2 = r9
            r5 = r10
            r3 = r12
            r4 = r13
            java.lang.Object r11 = r1.getByUserId(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L52
            goto L62
        L52:
            r13 = r4
        L53:
            r9 = r11
            tc0.l r9 = (tc0.l) r9
            r6.j = r11
            r6.k = r13
            r6.n = r7
            java.lang.Object r9 = r8.i(r9, r6)
            if (r9 != r0) goto L63
        L62:
            return r0
        L63:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.e(java.lang.String, java.lang.String, sx1.c, tc0.p, boolean):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.String r6, tc0.p r7, sx1.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof gy0.p
            if (r0 == 0) goto L13
            r0 = r8
            gy0.p r0 = (gy0.p) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            gy0.p r0 = new gy0.p
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
            com.bandlab.playlist.api.PlaylistsService r8 = r5.d()
            r0.m = r4
            java.lang.Object r8 = r8.getLikedCollections(r6, r7, r0)
            if (r8 != r1) goto L48
            goto L55
        L48:
            r6 = r8
            tc0.l r6 = (tc0.l) r6
            r0.j = r8
            r0.m = r3
            java.lang.Object r6 = r5.i(r6, r0)
            if (r6 != r1) goto L56
        L55:
            return r1
        L56:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.f(java.lang.String, tc0.p, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(gy0.i r8, sx1.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof gy0.s
            if (r0 == 0) goto L13
            r0 = r9
            gy0.s r0 = (gy0.s) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            gy0.s r0 = new gy0.s
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            lx1.b0 r3 = lx1.b0.a
            r4 = 3
            r5 = 1
            r6 = 2
            if (r2 == 0) goto L43
            if (r2 == r5) goto L3d
            if (r2 == r6) goto L37
            if (r2 != r4) goto L2f
            lg.e.O(r9)
            return r3
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            gy0.i r8 = r0.j
            lg.e.O(r9)
            goto L65
        L3d:
            gy0.i r8 = r0.j
            lg.e.O(r9)
            goto L58
        L43:
            lg.e.O(r9)
            ey0.a r9 = new ey0.a
            r9.<init>(r8)
            r0.j = r8
            r0.m = r5
            p41.e r2 = r7.d
            java.lang.Object r9 = r2.p(r9, r0)
            if (r9 != r1) goto L58
            goto L76
        L58:
            r0.j = r8
            r0.m = r6
            q41.b r9 = r7.i
            java.lang.Object r9 = r9.g(r8, r0)
            if (r9 != r1) goto L65
            goto L76
        L65:
            java.util.List r8 = r8.e0()
            if (r8 == 0) goto L77
            r9 = 0
            r0.j = r9
            r0.m = r4
            java.lang.Object r8 = r7.h(r8, r0)
            if (r8 != r1) goto L77
        L76:
            return r1
        L77:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.g(gy0.i, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
    
        if (r11.h.g(r8, r0) != r1) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[PHI: r2 r8 r9 r12
  0x004a: PHI (r2v1 int) = (r2v3 int), (r2v13 int) binds: [B:33:0x00b9, B:18:0x003f] A[DONT_GENERATE, DONT_INLINE]
  0x004a: PHI (r8v0 oz0.d1) = (r8v1 oz0.d1), (r8v7 oz0.d1) binds: [B:33:0x00b9, B:18:0x003f] A[DONT_GENERATE, DONT_INLINE]
  0x004a: PHI (r9v0 java.util.Iterator) = (r9v2 java.util.Iterator), (r9v7 java.util.Iterator) binds: [B:33:0x00b9, B:18:0x003f] A[DONT_GENERATE, DONT_INLINE]
  0x004a: PHI (r12v2 int) = (r12v4 int), (r12v13 int) binds: [B:33:0x00b9, B:18:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5 A[PHI: r2 r8 r9 r12
  0x00a5: PHI (r2v3 int) = (r2v4 int), (r2v12 int) binds: [B:30:0x00a2, B:20:0x004f] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r8v1 oz0.d1) = (r8v2 oz0.d1), (r8v6 oz0.d1) binds: [B:30:0x00a2, B:20:0x004f] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r9v2 java.util.Iterator) = (r9v3 java.util.Iterator), (r9v6 java.util.Iterator) binds: [B:30:0x00a2, B:20:0x004f] A[DONT_GENERATE, DONT_INLINE]
  0x00a5: PHI (r12v4 int) = (r12v5 int), (r12v12 int) binds: [B:30:0x00a2, B:20:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00cd -> B:15:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(java.util.List r12, sx1.c r13) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.h(java.util.List, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(tc0.l r8, sx1.c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof gy0.r
            if (r0 == 0) goto L13
            r0 = r9
            gy0.r r0 = (gy0.r) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            gy0.r r0 = new gy0.r
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            int r8 = r0.m
            int r2 = r0.l
            java.util.Iterator r4 = r0.k
            java.lang.Iterable r5 = r0.j
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            lg.e.O(r9)
            goto L48
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            lg.e.O(r9)
            java.util.List r8 = r8.a
            if (r8 == 0) goto L6a
            java.util.Iterator r9 = r8.iterator()
            r2 = 0
            r5 = r8
            r4 = r9
            r8 = r2
        L48:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L68
            java.lang.Object r9 = r4.next()
            gy0.i r9 = (gy0.i) r9
            r6 = r5
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r0.j = r6
            r0.k = r4
            r0.l = r2
            r0.m = r8
            r0.p = r3
            java.lang.Object r9 = r7.g(r9, r0)
            if (r9 != r1) goto L48
            return r1
        L68:
            java.util.List r5 = (java.util.List) r5
        L6a:
            lx1.b0 r8 = lx1.b0.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.i(tc0.l, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(java.lang.String r6, tc0.p r7, sx1.c r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof gy0.u
            if (r0 == 0) goto L13
            r0 = r8
            gy0.u r0 = (gy0.u) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            gy0.u r0 = new gy0.u
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
            com.bandlab.playlist.api.PlaylistsService r8 = r5.d()
            r0.m = r4
            java.lang.Object r8 = r8.search(r6, r7, r0)
            if (r8 != r1) goto L48
            goto L55
        L48:
            r6 = r8
            tc0.l r6 = (tc0.l) r6
            r0.j = r8
            r0.m = r3
            java.lang.Object r6 = r5.i(r6, r0)
            if (r6 != r1) goto L56
        L55:
            return r1
        L56:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: gy0.v.j(java.lang.String, tc0.p, sx1.c):java.lang.Object");
    }
}
