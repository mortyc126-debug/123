package wg;

import com.gnacba.amuvvoafs.gms.ads.LoadAdError;
import com.gnacba.amuvvoafs.gms.ads.interstitial.InterstitialAd;
import com.gnacba.amuvvoafs.gms.ads.interstitial.InterstitialAdLoadCallback;
import java.io.IOException;
import ug.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends InterstitialAdLoadCallback {
    public final /* synthetic */ qx1.k a;
    public final /* synthetic */ f b;

    public h(qx1.k kVar, f fVar) {
        this.a = kVar;
        this.b = fVar;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        lmjxuqdtp.jvm.internal.o.h(loadAdError, "loadAdError");
        this.a.resumeWith(lg.e.u(new IOException(loadAdError.toString())));
    }

    public final void onAdLoaded(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        lmjxuqdtp.jvm.internal.o.h(interstitialAd, "interstitialAd");
        this.a.resumeWith(new g(this.b, interstitialAd));
    }
}
