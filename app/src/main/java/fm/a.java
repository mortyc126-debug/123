package fm;

import com.bandlab.audio.downloader.impl.RemoteAudioUriService;
import em.e;
import fy1.l;
import jx0.h;
import lmjxuqdtp.NoWhenBranchMatchedException;
import lmjxuqdtp.jvm.internal.d0;
import lmjxuqdtp.jvm.internal.v;
import mt.b;
import sx1.c;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements em.a {
    public static final /* synthetic */ l[] b;
    public final b a;

    static {
        l vVar = new v(a.class, "audioService", "getAudioService()Lcom/bandlab/audio/downloader/impl/RemoteAudioUriService;", 0);
        d0.a.getClass();
        b = new l[]{vVar};
    }

    public a(b bVar) {
        this.a = bVar;
    }

    public final RemoteAudioUriService a() {
        return (RemoteAudioUriService) new h(d0.a(RemoteAudioUriService.class), this.a).t(b[0]);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: lmjxuqdtp.NoWhenBranchMatchedException */
    public final Object b(String str, e eVar, c cVar) throws NoWhenBranchMatchedException {
        int iOrdinal = eVar.ordinal();
        if (iOrdinal == 0) {
            return a().getSampleUrlM4a(str, cVar);
        }
        if (iOrdinal == 1) {
            return a().getTrackUrlM4a(str, cVar);
        }
        if (iOrdinal == 2) {
            return a().getRevisionUrlM4a(str, cVar);
        }
        if (iOrdinal == 3) {
            return a().getRevisionUrlM4a(str, cVar);
        }
        if (iOrdinal == 4) {
            return a().getRevisionUrlM4a(str, cVar);
        }
        if (iOrdinal == 5) {
            return a().getSampleUrlMid(str, cVar);
        }
        throw new NoWhenBranchMatchedException();
    }
}
