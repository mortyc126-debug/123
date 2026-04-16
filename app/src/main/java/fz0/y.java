package fz0;

import com.bandlab.bandlab.utils.debug.DebugUtils;
import com.bandlab.bandlab.utils.debug.TaggedException;
import com.bandlab.media.preview.MediaPreviewActivity;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;
import java.util.ArrayList;
import java.util.Arrays;
import jv0.k;
import lmjxuqdtp.jvm.functions.Function0;
import m10.j0;
import m10.k1;
import m10.n1;
import y10.r;
import zs.n0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ c0 b;

    public /* synthetic */ y(c0 c0Var, int i) {
        this.a = i;
        this.b = c0Var;
    }

    public final Object invoke() {
        j0 j0Var;
        n1 n1Var;
        Long l;
        int i = this.a;
        String strD = null;
        int i2 = 3;
        c0 c0Var = this.b;
        switch (i) {
            case 0:
                k kVar = c0Var.k().l;
                if (kVar != null && (j0Var = kVar.b) != null) {
                    strD = j0Var.d();
                }
                if (strD != null) {
                    xu0.p pVar = c0Var.c;
                    n0 n0Var = c0Var.e;
                    int i3 = MediaPreviewActivity.l;
                    pVar.e(new xu0.l(wb.a.u(n0Var.a, new xe0.g(strD, xe0.l.b)), -1));
                } else {
                    bb.w wVar = new bb.w(2);
                    ArrayList arrayList = wVar.a;
                    wVar.a("CRITICAL");
                    wVar.e(new String[0]);
                    String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    DebugUtils.handleThrowable(new TaggedException(new IllegalStateException("Post:: image not opened because url is null"), (String[]) Arrays.copyOf(strArr, strArr.length)));
                }
                return lx1.b0.a;
            case 1:
                k0 k0Var = c0Var.g;
                k1 k1Var = k0Var.b().k;
                dg1.e eVarS0 = r.s0(k1Var != null ? k1Var.b : null, (dg1.d) null, 3);
                k1 k1Var2 = k0Var.b().k;
                return new xz0.a0(eVarS0, new gf1.b(b4.E(ny1.z.c(Long.valueOf((k1Var2 == null || (n1Var = k1Var2.c) == null || (l = n1Var.c) == null) ? 0L : l.longValue())), k0Var.b(), k0Var.g, k0Var.h, k0Var.i, k0Var.a.e)), new es0.l(0, k0Var, k0.class, "openVideoPlayer", "openVideoPlayer()V", 0, 29), (lj1.h) k0Var.l.getValue(), ny1.z.c(k0Var.m), k0Var.k, new bn0.i(1, k0Var, k0.class, "onPlaybackStart", "onPlaybackStart(Z)V", 0, 22), new com.bandlab.media.player.impl.r(2, k0Var, k0.class, "trackPlayQuality", "trackPlayQuality(DLlmjxuqdtp/coroutines/Continuation;)Ljava/lang/Object;", 0, 6));
            case 2:
                return b4.P(c0Var, true, new y(c0Var, i2));
            case 3:
                return c0Var.r.e();
            case 4:
                return c0Var.r.e();
            case 5:
                f fVar = c0Var.f137f;
                jv0.n nVar = fVar.a.a.a.m;
                if (nVar == null) {
                    throw new IllegalStateException("Link is missing for link post");
                }
                String str = nVar.b;
                if (str == null) {
                    str = nVar.a;
                }
                return new xz0.q(str, nVar.c, nVar.a(), nVar.d, new es0.l(0, fVar, f.class, "openPostLink", "openPostLink()V", 0, 17));
            default:
                return c0Var.n;
        }
    }
}
