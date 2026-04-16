package br;

import amuvvoafs.content.Context;
import amuvvoafs.content.Intent;
import com.bandlab.band.profile.screen.BandProfileActivity;
import com.bandlab.community.profile.screen.CommunityProfileActivity;
import com.bandlab.playlist.profile.screen.PlaylistProfileActivity;
import com.bandlab.post.screen.PostActivity;
import com.bandlab.song.project.screen.SongProjectActivity;
import com.bandlab.user.profile.screen.UserProfileActivity;
import com.gnacba.common.util.concurrent.s;
import com.ironsource.adqualitysdk.sdk.i.a0;
import dh1.w;
import gq.y;
import lh1.a;
import lv0.g;
import lv0.h;
import lv0.i;
import lv0.m;
import lx1.l;
import o10.c4;
import o10.g3;
import oz0.d1;
import q10.i0;
import qi1.k;
import r20.b0;
import sx1.c;
import x10.r;
import x10.v;
import yr1.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 implements i {
    public final /* synthetic */ int a;
    public final Context b;

    public /* synthetic */ o0(Context context, int i) {
        this.a = i;
        this.b = context;
    }

    public final Object a(g gVar, c cVar) {
        String strA;
        String strA2;
        String strA3;
        String strA4;
        String strA5;
        Intent intentU;
        String strA6;
        String strA7;
        int i = this.a;
        Context context = this.b;
        switch (i) {
            case 0:
                m mVarB = gVar.b();
                if (mVarB == null || (strA = mVarB.a()) == null) {
                    return null;
                }
                int i2 = BandProfileActivity.l;
                return s.C(gVar, f.u(context, strA, false, (y) null), "invite_notifications", a0.v(v.Companion, 2132017490), (Integer) null, (h) null, 24);
            case 1:
                m mVarB2 = gVar.b();
                if (mVarB2 == null || (strA2 = mVarB2.a()) == null) {
                    return null;
                }
                return s.C(gVar, k.d(UserProfileActivity.m, this.b, strA2, (w) null, (oh1.f) null, false, (a) null, (i0) null, (l) null, (c4) null, 508), "default_notifications", a0.v(v.Companion, 2132020536), (Integer) null, h.a, 8);
            case 2:
                m mVarB3 = gVar.b();
                if (mVarB3 == null || (strA3 = mVarB3.a()) == null) {
                    return null;
                }
                return s.C(gVar, ry0.l.c(PlaylistProfileActivity.m, context, strA3, (g3) null, 12), "collection_notification", a0.v(v.Companion, 2132017736), (Integer) null, (h) null, 24);
            case 3:
                m mVarB4 = gVar.b();
                if (mVarB4 == null || (strA4 = mVarB4.a()) == null) {
                    return null;
                }
                int i3 = PostActivity.m;
                Intent intentU2 = rw1.a.u(this.b, strA4, (String) null, (String) null, (d1) null, false, 60);
                r rVarV = a0.v(v.Companion, 2132019398);
                m mVarB5 = gVar.b();
                String strA8 = mVarB5 != null ? mVarB5.a() : null;
                return s.C(gVar, intentU2, "new_post_notifications", rVarV, new Integer(strA8 != null ? strA8.hashCode() : 0), (h) null, 16);
            case 4:
                m mVarB6 = gVar.b();
                if (mVarB6 == null || (strA5 = mVarB6.a()) == null) {
                    return null;
                }
                m mVarB7 = gVar.b();
                String strB = mVarB7 != null ? mVarB7.b() : null;
                m mVarB8 = gVar.b();
                String strC = mVarB8 != null ? mVarB8.c() : null;
                Context context2 = this.b;
                if (strB != null) {
                    int i4 = PostActivity.m;
                    intentU = rw1.a.u(context2, strA5, strB, strC, (d1) null, false, 48);
                } else {
                    int i6 = PostActivity.m;
                    intentU = rw1.a.u(context2, strA5, (String) null, (String) null, (d1) null, false, 60);
                }
                return s.C(gVar, intentU, "post_notifications", a0.v(v.Companion, 2132019758), (Integer) null, h.a, 8);
            case 5:
                m mVarB9 = gVar.b();
                if (mVarB9 == null || (strA6 = mVarB9.a()) == null) {
                    return null;
                }
                return s.C(gVar, w51.q0.c(SongProjectActivity.m, context, strA6, 12), "project_updates", a0.v(v.Companion, 2132019830), (Integer) null, h.a, 8);
            default:
                m mVarB10 = gVar.b();
                if (mVarB10 == null || (strA7 = mVarB10.a()) == null) {
                    return null;
                }
                int i7 = CommunityProfileActivity.l;
                return s.C(gVar, q51.a.h(context, strA7, (r20.i) null, b0.INSTANCE), "community_updates", a0.v(v.Companion, 2132017800), (Integer) null, (h) null, 24);
        }
    }
}
