package wg;

import com.gnacba.amuvvoafs.gms.ads.AdListener;
import com.gnacba.amuvvoafs.gms.ads.LoadAdError;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends AdListener {
    public final /* synthetic */ ky1.m a;

    public j(ky1.m mVar) {
        this.a = mVar;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        lmjxuqdtp.jvm.internal.o.h(loadAdError, "adError");
        ky1.m mVar = this.a;
        if (mVar.isActive()) {
            mVar.resumeWith(lg.e.u(new Exception(loadAdError.toString())));
        }
    }
}
