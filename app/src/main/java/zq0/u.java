package zq0;

import am.p;
import com.bandlab.mixeditor.presets.services.FavoritePresetsService;
import d01.i;
import d01.k;
import fy1.l;
import java.util.concurrent.atomic.AtomicBoolean;
import jv0.i0;
import jx0.h;
import lmjxuqdtp.jvm.internal.d0;
import ny1.z;
import yr.y4;
import z70.t;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements to0.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f758f;
    public final mt.b a;
    public String b;
    public final i c;
    public final AtomicBoolean d;
    public final t e;

    static {
        l vVar = new lmjxuqdtp.jvm.internal.v(u.class, "service", "getService()Lcom/bandlab/mixeditor/presets/services/FavoritePresetsService;", 0);
        d0.a.getClass();
        f758f = new l[]{vVar};
    }

    public u(i0 i0Var, mt.b bVar, k kVar, y10.a aVar) {
        this.a = bVar;
        i iVarA = kVar.a(o.c);
        this.c = iVarA;
        this.d = new AtomicBoolean(false);
        this.e = new t(iVarA.f(), 5);
        z.J(aVar, new p(20, new nc0.g(((or.q) i0Var).f, 1), new y4(this, (qx1.d) null, 11)));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.bandlab.auth.UserNotLoadedException */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        if (r11.addPresetToFavorites(r2, r10, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r10, sx1.c r11) throws java.lang.Exception {
        /*
            r9 = this;
            boolean r0 = r11 instanceof zq0.p
            if (r0 == 0) goto L13
            r0 = r11
            zq0.p r0 = (zq0.p) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            zq0.p r0 = new zq0.p
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.l
            rx1.a r1 = rx1.a.a
            int r2 = r0.n
            d01.i r3 = r9.c
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L4b
            if (r2 == r6) goto L45
            if (r2 == r5) goto L3a
            if (r2 == r4) goto L34
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L34:
            java.lang.Exception r10 = r0.k
            lg.e.O(r11)
            goto L91
        L3a:
            java.lang.String r10 = r0.j
            lg.e.O(r11)     // Catch: java.lang.Exception -> L40
            goto L73
        L40:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L7d
        L45:
            java.lang.String r10 = r0.j
            lg.e.O(r11)     // Catch: java.lang.Exception -> L40
            goto L60
        L4b:
            lg.e.O(r11)
            b60.x r11 = new b60.x     // Catch: java.lang.Exception -> L40
            r2 = 22
            r11.<init>(r10, r2, r7)     // Catch: java.lang.Exception -> L40
            r0.j = r10     // Catch: java.lang.Exception -> L40
            r0.n = r6     // Catch: java.lang.Exception -> L40
            java.lang.Object r11 = r3.m(r11, r0)     // Catch: java.lang.Exception -> L40
            if (r11 != r1) goto L60
            goto L90
        L60:
            com.bandlab.mixeditor.presets.services.FavoritePresetsService r11 = r9.c()     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = r9.b     // Catch: java.lang.Exception -> L40
            if (r2 == 0) goto L76
            r0.j = r10     // Catch: java.lang.Exception -> L40
            r0.n = r5     // Catch: java.lang.Exception -> L40
            java.lang.Object r10 = r11.addPresetToFavorites(r2, r10, r0)     // Catch: java.lang.Exception -> L40
            if (r10 != r1) goto L73
            goto L90
        L73:
            lx1.b0 r10 = lx1.b0.a
            return r10
        L76:
            com.bandlab.auth.UserNotLoadedException r11 = new com.bandlab.auth.UserNotLoadedException     // Catch: java.lang.Exception -> L40
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> L40
            throw r11     // Catch: java.lang.Exception -> L40
        L7d:
            b60.x r2 = new b60.x
            r5 = 23
            r2.<init>(r11, r5, r7)
            r0.j = r7
            r0.k = r10
            r0.n = r4
            java.lang.Object r11 = r3.m(r2, r0)
            if (r11 != r1) goto L91
        L90:
            return r1
        L91:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.u.a(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (r10.j(r11, r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r10, sx1.c r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof zq0.q
            if (r0 == 0) goto L13
            r0 = r11
            zq0.q r0 = (zq0.q) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            zq0.q r0 = new zq0.q
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            java.util.concurrent.atomic.AtomicBoolean r3 = r9.d
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L3b
            if (r2 == r6) goto L35
            if (r2 != r4) goto L2d
            lg.e.O(r11)     // Catch: java.lang.Exception -> L73
            goto L77
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            d01.i r10 = r0.f756j
            lg.e.O(r11)     // Catch: java.lang.Exception -> L73
            goto L62
        L3b:
            lg.e.O(r11)
            boolean r11 = r3.getAndSet(r6)
            if (r11 != 0) goto L77
            d01.i r11 = r9.c     // Catch: java.lang.Exception -> L73
            r0.f756j = r11     // Catch: java.lang.Exception -> L73
            r0.m = r6     // Catch: java.lang.Exception -> L73
            zq0.d r2 = new zq0.d     // Catch: java.lang.Exception -> L73
            r7 = 1
            r2.<init>(r9, r10, r5, r7)     // Catch: java.lang.Exception -> L73
            r10 = 9
            r7 = 50
            com.bandlab.listmanager.pagination.impl.r r10 = ct1.b.r(r7, r7, r10, r2)     // Catch: java.lang.Exception -> L73
            java.lang.Object r10 = aq1.b.I(r10, r0)     // Catch: java.lang.Exception -> L73
            if (r10 != r1) goto L5f
            goto L72
        L5f:
            r8 = r11
            r11 = r10
            r10 = r8
        L62:
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Exception -> L73
            java.util.List r11 = mx1.o.o0(r11)     // Catch: java.lang.Exception -> L73
            r0.f756j = r5     // Catch: java.lang.Exception -> L73
            r0.m = r4     // Catch: java.lang.Exception -> L73
            java.lang.Object r10 = r10.j(r11, r0)     // Catch: java.lang.Exception -> L73
            if (r10 != r1) goto L77
        L72:
            return r1
        L73:
            r6 = 0
            r3.set(r6)
        L77:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.u.b(java.lang.String, sx1.c):java.lang.Object");
    }

    public final FavoritePresetsService c() {
        return (FavoritePresetsService) new h(d0.a(FavoritePresetsService.class), this.a).t(f758f[0]);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.bandlab.auth.UserNotLoadedException */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(4:(1:(1:(2:15|16)(2:17|59))(5:18|56|19|43|44))(5:23|58|24|38|(1:40)(2:45|46))|49|(2:52|53)|51)(1:28))(3:29|(1:32)|51)|33|54|34|(3:37|38|(0)(0))|51) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009c, code lost:
    
        if (r0.removePresetFromFavorites(r5, r4, r6) == r7) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
    
        r11 = r0;
        r3 = r1;
        r1 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0092 A[Catch: Exception -> 0x0054, TRY_LEAVE, TryCatch #2 {Exception -> 0x0054, blocks: (B:24:0x0050, B:38:0x008a, B:40:0x0092, B:45:0x00a2, B:46:0x00a8), top: B:58:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[Catch: Exception -> 0x0054, TRY_ENTER, TryCatch #2 {Exception -> 0x0054, blocks: (B:24:0x0050, B:38:0x008a, B:40:0x0092, B:45:0x00a2, B:46:0x00a8), top: B:58:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r13, sx1.c r14) throws java.lang.Exception {
        /*
            r12 = this;
            boolean r1 = r14 instanceof zq0.r
            if (r1 == 0) goto L14
            r1 = r14
            zq0.r r1 = (zq0.r) r1
            int r3 = r1.o
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L14
            int r3 = r3 - r4
            r1.o = r3
        L12:
            r6 = r1
            goto L1a
        L14:
            zq0.r r1 = new zq0.r
            r1.<init>(r12, r14)
            goto L12
        L1a:
            java.lang.Object r0 = r6.m
            rx1.a r7 = rx1.a.a
            int r1 = r6.o
            r8 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r9 = 0
            d01.i r10 = r12.c
            if (r1 == 0) goto L5e
            if (r1 == r5) goto L58
            if (r1 == r4) goto L4c
            if (r1 == r3) goto L40
            if (r1 == r8) goto L39
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            java.lang.Exception r1 = r6.k
            lg.e.O(r0)
            goto Lc5
        L40:
            int r1 = r6.l
            java.lang.String r3 = r6.j
            lg.e.O(r0)     // Catch: java.lang.Exception -> L48
            goto L9f
        L48:
            r0 = move-exception
            r11 = r0
            goto Lad
        L4c:
            int r1 = r6.l
            java.lang.String r4 = r6.j
            lg.e.O(r0)     // Catch: java.lang.Exception -> L54
            goto L8a
        L54:
            r0 = move-exception
            r11 = r0
            r3 = r4
            goto Lad
        L58:
            java.lang.String r1 = r6.j
            lg.e.O(r0)
            goto L6e
        L5e:
            lg.e.O(r0)
            r6.j = r13
            r6.o = r5
            java.lang.Object r1 = r10.a(r6)
            if (r1 != r7) goto L6c
            goto Lc3
        L6c:
            r0 = r1
            r1 = r13
        L6e:
            java.util.List r0 = (java.util.List) r0
            int r5 = r0.indexOf(r1)
            b60.x r0 = new b60.x     // Catch: java.lang.Exception -> La9
            r11 = 24
            r0.<init>(r1, r11, r9)     // Catch: java.lang.Exception -> La9
            r6.j = r1     // Catch: java.lang.Exception -> La9
            r6.l = r5     // Catch: java.lang.Exception -> La9
            r6.o = r4     // Catch: java.lang.Exception -> La9
            java.lang.Object r0 = r10.m(r0, r6)     // Catch: java.lang.Exception -> La9
            if (r0 != r7) goto L88
            goto Lc3
        L88:
            r4 = r1
            r1 = r5
        L8a:
            com.bandlab.mixeditor.presets.services.FavoritePresetsService r0 = r12.c()     // Catch: java.lang.Exception -> L54
            java.lang.String r5 = r12.b     // Catch: java.lang.Exception -> L54
            if (r5 == 0) goto La2
            r6.j = r4     // Catch: java.lang.Exception -> L54
            r6.l = r1     // Catch: java.lang.Exception -> L54
            r6.o = r3     // Catch: java.lang.Exception -> L54
            java.lang.Object r0 = r0.removePresetFromFavorites(r5, r4, r6)     // Catch: java.lang.Exception -> L54
            if (r0 != r7) goto L9f
            goto Lc3
        L9f:
            lx1.b0 r0 = lx1.b0.a
            return r0
        La2:
            com.bandlab.auth.UserNotLoadedException r0 = new com.bandlab.auth.UserNotLoadedException     // Catch: java.lang.Exception -> L54
            r3 = 0
            r0.<init>(r3)     // Catch: java.lang.Exception -> L54
            throw r0     // Catch: java.lang.Exception -> L54
        La9:
            r0 = move-exception
            r11 = r0
            r3 = r1
            r1 = r5
        Lad:
            com.bandlab.media.player.impl.h r0 = new com.bandlab.media.player.impl.h
            r5 = 3
            r2 = r12
            r4 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r6.j = r4
            r6.k = r11
            r6.l = r1
            r6.o = r8
            java.lang.Object r0 = r10.m(r0, r6)
            if (r0 != r7) goto Lc4
        Lc3:
            return r7
        Lc4:
            r1 = r11
        Lc5:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.u.d(java.lang.String, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.bandlab.auth.UserNotLoadedException */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0084, code lost:
    
        if (d(r9, r0) == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
    
        if (a(r9, r0) == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.String r9, sx1.c r10) throws com.bandlab.auth.UserNotLoadedException {
        /*
            r8 = this;
            boolean r0 = r10 instanceof zq0.t
            if (r0 == 0) goto L13
            r0 = r10
            zq0.t r0 = (zq0.t) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            zq0.t r0 = new zq0.t
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L49
            if (r2 == r7) goto L43
            if (r2 == r6) goto L3d
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            lg.e.O(r10)
            goto L92
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            lg.e.O(r10)
            goto L93
        L3d:
            java.lang.String r9 = r0.j
            lg.e.O(r10)
            goto L73
        L43:
            java.lang.String r9 = r0.j
            lg.e.O(r10)
            goto L5b
        L49:
            lg.e.O(r10)
            java.lang.String r10 = r8.b
            if (r10 == 0) goto L98
            r0.j = r9
            r0.m = r7
            java.lang.Object r10 = r8.b(r10, r0)
            if (r10 != r1) goto L5b
            goto L91
        L5b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L66
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            return r9
        L66:
            r0.j = r9
            r0.m = r6
            d01.i r10 = r8.c
            java.lang.Object r10 = r10.a(r0)
            if (r10 != r1) goto L73
            goto L91
        L73:
            java.util.List r10 = (java.util.List) r10
            boolean r10 = r10.contains(r9)
            r2 = 0
            if (r10 == 0) goto L87
            r0.j = r2
            r0.m = r5
            java.lang.Object r9 = r8.d(r9, r0)
            if (r9 != r1) goto L93
            goto L91
        L87:
            r0.j = r2
            r0.m = r4
            java.lang.Object r9 = r8.a(r9, r0)
            if (r9 != r1) goto L92
        L91:
            return r1
        L92:
            r3 = r7
        L93:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            return r9
        L98:
            com.bandlab.auth.UserNotLoadedException r9 = new com.bandlab.auth.UserNotLoadedException
            r9.<init>(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zq0.u.e(java.lang.String, sx1.c):java.lang.Object");
    }
}
