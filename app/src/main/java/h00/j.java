package h00;

import bb.w;
import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.comment.api.service.AlbumCommentsService;
import com.bandlab.comment.api.service.PostCommentsService;
import com.ironsource.adqualitysdk.sdk.i.a0;
import fy1.l;
import java.util.ArrayList;
import java.util.Arrays;
import k00.c;
import l41.d;
import l41.h;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.jvm.internal.v;
import lx1.b0;
import m41.k;
import mt.b;
import p41.a;
import p41.e;
import p81.f;
import t41.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends e {
    public static final /* synthetic */ l[] h = {new v(j.class, "postService", "getPostService()Lcom/bandlab/comment/api/service/PostCommentsService;", 0), a0.r(d0.a, j.class, "albumService", "getAlbumService()Lcom/bandlab/comment/api/service/AlbumCommentsService;", 0), new v(j.class, "commentLikesService", "getCommentLikesService()Lcom/bandlab/comment/api/service/CommentsLikesService;", 0)};
    public final g a;
    public final k b;
    public final y41.j c;
    public final f d;
    public final b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f187f;
    public final b g;

    public j(g gVar, k kVar, y41.j jVar, f fVar, b bVar) {
        this.a = gVar;
        this.b = kVar;
        this.c = jVar;
        this.d = fVar;
        this.e = bVar;
        this.f187f = bVar;
        this.g = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(java.util.List r6, sx1.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof h00.h
            if (r0 == 0) goto L13
            r0 = r7
            h00.h r0 = (h00.h) r0
            int r1 = r0.n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.n = r1
            goto L18
        L13:
            h00.h r0 = new h00.h
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
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
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
            q10.j0 r7 = r7.G()
            r0.j = r2
            r0.k = r6
            r0.n = r3
            m41.k r4 = r5.b
            java.lang.Object r7 = r4.Q(r7, r0)
            if (r7 != r1) goto L3d
            return r1
        L5c:
            lx1.b0 r6 = lx1.b0.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: h00.j.A(java.util.List, sx1.c):java.lang.Object");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object B(l41.i r10, k00.c r11, sx1.c r12) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h00.j.B(l41.i, k00.c, sx1.c):java.lang.Object");
    }

    public final /* bridge */ /* synthetic */ Object b(String str, Object obj, c51.j jVar, c51.j jVar2, a aVar) {
        return b0.a;
    }

    public final Long c(Object obj) {
        a aVar = (a) obj;
        o.h(aVar, "<this>");
        k00.f fVar = aVar.c().j;
        if (fVar != null) {
            return fVar.a;
        }
        return null;
    }

    public final y41.j d() {
        return this.c;
    }

    public final c51.j e(Object obj) {
        o.h((a) obj, "<this>");
        return null;
    }

    public final p41.f f(Object obj) {
        a aVar = (a) obj;
        o.h(aVar, "<this>");
        String str = aVar.c().a;
        if (str == null) {
            return null;
        }
        return new b(str, aVar.d());
    }

    public final f g() {
        return this.d;
    }

    public final Boolean h(Object obj) {
        a aVar = (a) obj;
        o.h(aVar, "<this>");
        return aVar.c().g;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object k(String str, Object obj, p41.b bVar) throws NoWhenBranchMatchedException {
        a aVar = (a) obj;
        c cVarA = aVar.a();
        h hVarB = aVar.b();
        String str2 = cVarA.a;
        b0 b0Var = b0.a;
        if (str2 != null) {
            if (hVarB instanceof h) {
                Object objLikeComment = z().likeComment(hVarB.b, str2, str, bVar);
                if (objLikeComment == rx1.a.a) {
                    return objLikeComment;
                }
            } else {
                if (!(hVarB instanceof d)) {
                    throw new NoWhenBranchMatchedException();
                }
                Object objLikeComment2 = w().likeComment(((d) hVarB).b, str2, str, bVar);
                if (objLikeComment2 == rx1.a.a) {
                    return objLikeComment2;
                }
            }
            return b0Var;
        }
        String str3 = "Comment id is null " + aVar.c();
        w wVar = new w(2);
        ArrayList arrayList = wVar.a;
        wVar.a("CRITICAL");
        wVar.e(new String[0]);
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(str3), (String[]) Arrays.copyOf(strArr, strArr.length)));
        this.d.k("Comment id is null " + aVar.c());
        return b0Var;
    }

    public final void n(Object obj) {
        o.h((a) obj, "entity");
    }

    public final void o(Object obj, c51.j jVar) {
        o.h((a) obj, "entity");
    }

    public final /* bridge */ /* synthetic */ Object r(String str, Object obj, p41.c cVar) {
        return b0.a;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object t(String str, Object obj, p41.d dVar) throws NoWhenBranchMatchedException {
        a aVar = (a) obj;
        c cVarA = aVar.a();
        h hVarB = aVar.b();
        String str2 = cVarA.a;
        b0 b0Var = b0.a;
        if (str2 != null) {
            if (hVarB instanceof h) {
                Object objUnlikeComment = z().unlikeComment(hVarB.b, str2, str, dVar);
                if (objUnlikeComment == rx1.a.a) {
                    return objUnlikeComment;
                }
            } else {
                if (!(hVarB instanceof d)) {
                    throw new NoWhenBranchMatchedException();
                }
                Object objUnlikeComment2 = w().unlikeComment(((d) hVarB).b, str2, str, dVar);
                if (objUnlikeComment2 == rx1.a.a) {
                    return objUnlikeComment2;
                }
            }
            return b0Var;
        }
        String str3 = "Comment id is null " + aVar.c();
        w wVar = new w(2);
        ArrayList arrayList = wVar.a;
        wVar.a("CRITICAL");
        wVar.e(new String[0]);
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        DebugUtils.handleThrowable(new TaggedException(new IllegalStateException(str3), (String[]) Arrays.copyOf(strArr, strArr.length)));
        this.d.k("Comment id is null " + aVar.c());
        return b0Var;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        if (r2.deleteComment(r6, r12, r0) == r1) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(l41.i r10, k00.c r11, sx1.c r12) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h00.j.u(l41.i, k00.c, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(java.lang.String r8, java.lang.String r9, sx1.c r10, tc0.p r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof h00.e
            if (r0 == 0) goto L13
            r0 = r10
            h00.e r0 = (h00.e) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            h00.e r0 = new h00.e
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r8 = r0.j
            lg.e.O(r10)
            return r8
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            lg.e.O(r10)
            goto L5b
        L38:
            lg.e.O(r10)
            fy1.l[] r10 = h00.j.h
            r10 = r10[r3]
            jx0.h r2 = new jx0.h
            java.lang.Class<com.bandlab.comment.api.service.CommentsLikesService> r5 = com.bandlab.comment.api.service.CommentsLikesService.class
            lmjxuqdtp.jvm.internal.f r5 = lmjxuqdtp.jvm.internal.d0.a(r5)
            mt.b r6 = r7.g
            r2.<init>(r5, r6)
            java.lang.Object r10 = r2.t(r10)
            com.bandlab.comment.api.service.CommentsLikesService r10 = (com.bandlab.comment.api.service.CommentsLikesService) r10
            r0.m = r4
            java.lang.Object r10 = r10.getAlbumLikes(r8, r9, r11, r0)
            if (r10 != r1) goto L5b
            goto L6c
        L5b:
            r8 = r10
            tc0.l r8 = (tc0.l) r8
            java.util.List r8 = r8.a
            if (r8 == 0) goto L6d
            r0.j = r10
            r0.m = r3
            java.lang.Object r8 = r7.A(r8, r0)
            if (r8 != r1) goto L6d
        L6c:
            return r1
        L6d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h00.j.v(java.lang.String, java.lang.String, sx1.c, tc0.p):java.lang.Object");
    }

    public final AlbumCommentsService w() {
        return (AlbumCommentsService) new jx0.h(d0.a(AlbumCommentsService.class), this.f187f).t(h[1]);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
    
        if (r0 == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c4, code lost:
    
        if (r0 == r1) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x012c -> B:56:0x012d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0134 -> B:57:0x0131). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object x(l41.i r14, java.lang.String r15, h00.c r16, tc0.p r17, sx1.c r18) throws lmjxuqdtp.NoWhenBranchMatchedException {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h00.j.x(l41.i, java.lang.String, h00.c, tc0.p, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(java.lang.String r8, java.lang.String r9, sx1.c r10, tc0.p r11) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof h00.g
            if (r0 == 0) goto L13
            r0 = r10
            h00.g r0 = (h00.g) r0
            int r1 = r0.m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.m = r1
            goto L18
        L13:
            h00.g r0 = new h00.g
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.k
            rx1.a r1 = rx1.a.a
            int r2 = r0.m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r8 = r0.j
            lg.e.O(r10)
            return r8
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            lg.e.O(r10)
            goto L5b
        L38:
            lg.e.O(r10)
            fy1.l[] r10 = h00.j.h
            r10 = r10[r3]
            jx0.h r2 = new jx0.h
            java.lang.Class<com.bandlab.comment.api.service.CommentsLikesService> r5 = com.bandlab.comment.api.service.CommentsLikesService.class
            lmjxuqdtp.jvm.internal.f r5 = lmjxuqdtp.jvm.internal.d0.a(r5)
            mt.b r6 = r7.g
            r2.<init>(r5, r6)
            java.lang.Object r10 = r2.t(r10)
            com.bandlab.comment.api.service.CommentsLikesService r10 = (com.bandlab.comment.api.service.CommentsLikesService) r10
            r0.m = r4
            java.lang.Object r10 = r10.getPostLikes(r8, r9, r11, r0)
            if (r10 != r1) goto L5b
            goto L6c
        L5b:
            r8 = r10
            tc0.l r8 = (tc0.l) r8
            java.util.List r8 = r8.a
            if (r8 == 0) goto L6d
            r0.j = r10
            r0.m = r3
            java.lang.Object r8 = r7.A(r8, r0)
            if (r8 != r1) goto L6d
        L6c:
            return r1
        L6d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h00.j.y(java.lang.String, java.lang.String, sx1.c, tc0.p):java.lang.Object");
    }

    public final PostCommentsService z() {
        return (PostCommentsService) new jx0.h(d0.a(PostCommentsService.class), this.e).t(h[0]);
    }
}
