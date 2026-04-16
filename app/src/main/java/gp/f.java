package gp;

import a80.p;
import az1.b0;
import az1.j1;
import com.braze.events.a;
import gs0.d;
import gz.o;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import lmjxuqdtp.jvm.functions.Function0;
import mz.l1;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ int a;

    public /* synthetic */ f(int i) {
        this.a = i;
    }

    public final Object invoke() {
        switch (this.a) {
            case 0:
                return o0.Companion.serializer();
            case 1:
                return j.Companion.serializer();
            case 2:
                return new b0("com.bandlab.auth.screens.JoinBandlabDestination.AgeVerificationBlockUserScreen", z.INSTANCE, new Annotation[0]);
            case 3:
                return new b0("com.bandlab.auth.screens.JoinBandlabDestination.ErrorScreen", e0.INSTANCE, new Annotation[0]);
            case 4:
                return new b0("com.bandlab.auth.screens.JoinBandlabDestination.LoadingScreen", f0.INSTANCE, new Annotation[0]);
            case 5:
                return new b0("com.bandlab.auth.screens.JoinBandlabDestination.SignupScreen", m0.INSTANCE, new Annotation[0]);
            case 6:
                return new b0("com.bandlab.auth.screens.JoinBandlabDestination.WelcomeScreen", n0.INSTANCE, new Annotation[0]);
            case 7:
                d dVar = d.s;
                return lx1.b0.a;
            case 8:
                return j1.e("com.bandlab.bandlab.posts.api.data.vmsrhfaqrb.FeedTab", gt.b.values(), new String[]{null, null, null, null, null}, new Annotation[][]{null, null, null, null, null}, new Annotation[]{new p(11)});
            case 9:
                return j1.e("com.bandlab.chat.media.MediaType", o.values(), new String[]{null, null, null}, new Annotation[][]{null, null, null}, new Annotation[]{new gz.p(true, 0)});
            case 10:
                return j1.e("com.bandlab.chat.media.MessageQueueStatus", gz.r.values(), new String[]{null, null, null, null}, new Annotation[][]{null, null, null, null}, new Annotation[]{new gz.p(true, 0)});
            case 11:
                return new az1.d(jv0.l.a, 0);
            case 12:
                return l1.Companion.serializer();
            case 13:
                return new az1.d(mz.g.a, 0);
            case 14:
                return mz.g0.Companion.serializer();
            case 15:
                return com.braze.triggers.config.b.b();
            case 16:
                return com.braze.triggers.config.c.b();
            case 17:
                return Integer.valueOf(cy1.e.b.c(2147418112) + 65536);
            case 18:
                return new HashSet();
            case 19:
                return a.e();
            case 20:
                return a.c();
            case 21:
                return a.d();
            case 22:
                return a.V();
            case 23:
                return a.W();
            case 24:
                return a.a();
            case 25:
                return a.d0();
            case 26:
                return a.M();
            case 27:
                return a.N();
            case 28:
                return a.b0();
            default:
                return a.f();
        }
    }
}
