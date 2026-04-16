package m41;

import com.bandlab.social.actions.api.service.SocialActionService;
import f3.f2;
import java.util.ArrayList;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.o;
import lmjxuqdtp.jvm.internal.v;
import lx1.b0;
import mt.b;
import o10.c4;
import p81.f;
import q10.i0;
import q10.j0;
import q10.o0;
import q10.s0;
import q10.t0;
import qi.h;
import qi.r;
import qi.y;
import tk0.d;
import ve.g;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends g {
    public static final /* synthetic */ fy1.l[] e;
    public final f a;
    public final u41.e b;
    public final y c;
    public final b d;

    static {
        fy1.l vVar = new v(k.class, "socialActionService", "getSocialActionService()Lcom/bandlab/social/actions/api/service/SocialActionService;", 0);
        d0.a.getClass();
        e = new fy1.l[]{vVar};
    }

    public k(f fVar, u41.e eVar, y yVar, b bVar) {
        this.a = fVar;
        this.b = eVar;
        this.c = yVar;
        this.d = bVar;
    }

    public final e F(Object obj) throws NoWhenBranchMatchedException {
        j0 j0Var = (j0) obj;
        o.h(j0Var, "<this>");
        Boolean bool = j0Var.c;
        t0 t0Var = j0Var.a;
        if (t0Var instanceof o0) {
            return new a(t0Var.a, o.c(bool, Boolean.TRUE));
        }
        if (t0Var instanceof s0) {
            return new n(t0Var.a, o.c(bool, Boolean.TRUE));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void O(Object obj, i0 i0Var, c4 c4Var) throws NoWhenBranchMatchedException {
        j0 j0Var = (j0) obj;
        o.h(j0Var, "entity");
        o.h(i0Var, "source");
        t0 t0Var = j0Var.a;
        String str = t0Var.a;
        boolean z = t0Var instanceof o0;
        y yVar = this.c;
        if (z) {
            ArrayList arrayList = new ArrayList();
            r rVar = new r(arrayList);
            rVar.e("triggered_from", d.E(i0Var));
            rVar.e("band_id", str);
            y.k(yVar, "band_follow", arrayList, h.e, 8);
            return;
        }
        if (!(t0Var instanceof s0)) {
            throw new NoWhenBranchMatchedException();
        }
        ArrayList arrayList2 = new ArrayList();
        r rVar2 = new r(arrayList2);
        rVar2.e("triggered_from", d.E(i0Var));
        rVar2.e("recommendation_attribution", c4Var != null ? c4Var.a() : null);
        rVar2.e("following_user_id", str);
        y.k(yVar, "user_follow", arrayList2, h.e, 8);
        if (i0Var.equals(q10.d0.INSTANCE)) {
            ArrayList arrayList3 = new ArrayList();
            f2.z("destination", "user_follow", arrayList3);
            y.k(yVar, "search_clickthrough", arrayList3, h.b, 8);
        }
    }

    public final Object W(String str, Object obj, d dVar) throws NoWhenBranchMatchedException {
        t0 t0Var = ((j0) obj).a;
        String str2 = t0Var.a;
        if (t0Var instanceof o0) {
            Object objUnfollowBand = b0().unfollowBand(str2, str, dVar);
            if (objUnfollowBand == rx1.a.a) {
                return objUnfollowBand;
            }
        } else {
            if (!(t0Var instanceof s0)) {
                throw new NoWhenBranchMatchedException();
            }
            Object objUnfollowUser = b0().unfollowUser(str2, dVar);
            if (objUnfollowUser == rx1.a.a) {
                return objUnfollowUser;
            }
        }
        return b0.a;
    }

    public final SocialActionService b0() {
        return (SocialActionService) new jx0.h(d0.a(SocialActionService.class), this.d).t(e[0]);
    }

    public final Object u(String str, Object obj, c cVar) throws NoWhenBranchMatchedException {
        t0 t0Var = ((j0) obj).a;
        String str2 = t0Var.a;
        if (t0Var instanceof o0) {
            Object objFollowBand = b0().followBand(str2, str, cVar);
            if (objFollowBand == rx1.a.a) {
                return objFollowBand;
            }
        } else {
            if (!(t0Var instanceof s0)) {
                throw new NoWhenBranchMatchedException();
            }
            Object objFollowUser$default = SocialActionService.followUser$default(b0(), str2, (b0) null, cVar, 2, (Object) null);
            if (objFollowUser$default == rx1.a.a) {
                return objFollowUser$default;
            }
        }
        return b0.a;
    }
}
