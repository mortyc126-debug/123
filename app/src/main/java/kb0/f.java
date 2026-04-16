package kb0;

import com.bandlab.invite.api.InviteService;
import fy1.l;
import jx0.h;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.v;
import lx1.b0;
import m41.k;
import mt.b;
import rx1.a;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final /* synthetic */ l[] c;
    public final k a;
    public final b b;

    static {
        l vVar = new v(f.class, "inviteService", "getInviteService()Lcom/bandlab/invite/api/InviteService;", 0);
        d0.a.getClass();
        c = new l[]{vVar};
    }

    public f(k kVar, b bVar) {
        this.a = kVar;
        this.b = bVar;
    }

    public static Object a(f fVar, String str, c cVar) {
        InviteService inviteServiceC = fVar.c();
        b0 b0Var = b0.a;
        Object objAcceptInvite = inviteServiceC.acceptInvite(str, b0Var, cVar);
        return objAcceptInvite == a.a ? objAcceptInvite : b0Var;
    }

    public final Object b(String str, c cVar) {
        Object objDeclineInvite = c().declineInvite(str, cVar);
        return objDeclineInvite == a.a ? objDeclineInvite : b0.a;
    }

    public final InviteService c() {
        return (InviteService) new h(d0.a(InviteService.class), this.b).t(c[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r9 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(java.lang.String r7, tc0.p r8, sx1.c r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof kb0.d
            if (r0 == 0) goto L13
            r0 = r9
            kb0.d r0 = (kb0.d) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            kb0.d r0 = new kb0.d
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            int r7 = r0.m
            int r8 = r0.l
            java.util.Iterator r2 = r0.k
            java.lang.Object r4 = r0.j
            lg.e.O(r9)
            goto L5d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            lg.e.O(r9)
            goto L4e
        L3e:
            lg.e.O(r9)
            com.bandlab.invite.api.InviteService r9 = r6.c()
            r0.p = r4
            java.lang.Object r9 = r9.getInvites(r7, r8, r0)
            if (r9 != r1) goto L4e
            goto L8f
        L4e:
            r7 = r9
            tc0.l r7 = (tc0.l) r7
            java.util.List r7 = r7.a
            if (r7 == 0) goto L91
            java.util.Iterator r7 = r7.iterator()
            r8 = 0
            r2 = r7
            r7 = r8
            r4 = r9
        L5d:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L90
            java.lang.Object r9 = r2.next()
            kb0.c r9 = (kb0.c) r9
            dh1.w r9 = r9.y()
            if (r9 == 0) goto L5d
            r0.getClass()
            r0.j = r4
            r0.k = r2
            r0.l = r8
            r0.m = r7
            r0.p = r3
            m41.k r5 = r6.a
            q10.j0 r9 = r9.G()
            java.lang.Object r9 = r5.Q(r9, r0)
            rx1.a r5 = rx1.a.a
            if (r9 != r5) goto L8b
            goto L8d
        L8b:
            lx1.b0 r9 = lx1.b0.a
        L8d:
            if (r9 != r1) goto L5d
        L8f:
            return r1
        L90:
            return r4
        L91:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kb0.f.d(java.lang.String, tc0.p, sx1.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r9 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(java.lang.String r7, tc0.p r8, sx1.c r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof kb0.e
            if (r0 == 0) goto L13
            r0 = r9
            kb0.e r0 = (kb0.e) r0
            int r1 = r0.p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.p = r1
            goto L18
        L13:
            kb0.e r0 = new kb0.e
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.n
            rx1.a r1 = rx1.a.a
            int r2 = r0.p
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            int r7 = r0.m
            int r8 = r0.l
            java.util.Iterator r2 = r0.k
            java.lang.Object r4 = r0.j
            lg.e.O(r9)
            goto L5d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            lg.e.O(r9)
            goto L4e
        L3e:
            lg.e.O(r9)
            com.bandlab.invite.api.InviteService r9 = r6.c()
            r0.p = r4
            java.lang.Object r9 = r9.getSongInvites(r7, r8, r0)
            if (r9 != r1) goto L4e
            goto L8f
        L4e:
            r7 = r9
            tc0.l r7 = (tc0.l) r7
            java.util.List r7 = r7.a
            if (r7 == 0) goto L91
            java.util.Iterator r7 = r7.iterator()
            r8 = 0
            r2 = r7
            r7 = r8
            r4 = r9
        L5d:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L90
            java.lang.Object r9 = r2.next()
            kb0.c r9 = (kb0.c) r9
            dh1.w r9 = r9.y()
            if (r9 == 0) goto L5d
            r0.getClass()
            r0.j = r4
            r0.k = r2
            r0.l = r8
            r0.m = r7
            r0.p = r3
            m41.k r5 = r6.a
            q10.j0 r9 = r9.G()
            java.lang.Object r9 = r5.Q(r9, r0)
            rx1.a r5 = rx1.a.a
            if (r9 != r5) goto L8b
            goto L8d
        L8b:
            lx1.b0 r9 = lx1.b0.a
        L8d:
            if (r9 != r1) goto L5d
        L8f:
            return r1
        L90:
            return r4
        L91:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kb0.f.e(java.lang.String, tc0.p, sx1.c):java.lang.Object");
    }
}
