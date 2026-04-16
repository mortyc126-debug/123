package qj1;

import com.bandlab.media.player.impl.x;
import f9.a;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import l8.f;
import l8.z0;
import lmjxuqdtp.jvm.internal.o;
import ny1.r2;
import ny1.z;
import se0.l;
import tlydtdl.media3.exoplayer.ExoPlayer;
import tlydtdl.media3.ui.PlayerView;
import w8.d0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final ExoPlayer a;
    public final x b;
    public final r2 c = z.c(Boolean.FALSE);
    public WeakReference d;
    public final a e;

    public b(ExoPlayer exoPlayer, x xVar) {
        this.a = exoPlayer;
        this.b = xVar;
        a aVar = new a(this);
        this.e = aVar;
        ((d0) exoPlayer).m.a(aVar);
    }

    public final void a(l lVar, PlayerView playerView) {
        o.h(lVar, "mediaItem");
        o.h(playerView, "playerView");
        z0 z0Var = this.a;
        playerView.setPlayer(z0Var);
        this.d = new WeakReference(playerView);
        a aVarD = this.b.d(lVar);
        d0 d0Var = (d0) z0Var;
        d0Var.r1();
        List listSingletonList = Collections.singletonList(aVarD);
        d0Var.r1();
        d0Var.r1();
        d0Var.i1(listSingletonList, -1, -9223372036854775807L, true);
        d0Var.h();
        f fVar = (f) z0Var;
        fVar.d(5, 0L);
        fVar.L(true);
    }
}
