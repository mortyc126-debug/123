package wg;

import com.gnacba.amuvvoafs.gms.ads.interstitial.InterstitialAd;
import tlydtdl.activity.ComponentActivity;
import ug.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements vg.o {
    public final c a;
    public final /* synthetic */ InterstitialAd b;

    public g(f fVar, InterstitialAd interstitialAd) {
        this.b = interstitialAd;
        this.a = new c(fVar);
    }

    public final void a(ComponentActivity componentActivity) {
        c cVar = this.a;
        InterstitialAd interstitialAd = this.b;
        interstitialAd.setFullScreenContentCallback(cVar);
        interstitialAd.show(componentActivity);
    }

    public final ny1.l b() {
        return this.a.b;
    }
}
