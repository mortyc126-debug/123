package bh;

import com.gnacba.amuvvoafs.gms.tasks.OnFailureListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import hs1.d;
import my1.y;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements LevelPlayInterstitialListener, OnFailureListener {
    public final /* synthetic */ y a;

    public void onAdClicked(AdInfo adInfo) {
        d.P(this.a, new c(adInfo));
    }

    public void onAdClosed(AdInfo adInfo) {
        d.P(this.a, new d(adInfo));
    }

    public void onAdLoadFailed(IronSourceError ironSourceError) {
        d.P(this.a, new e(ironSourceError));
    }

    public void onAdOpened(AdInfo adInfo) {
        d.P(this.a, new f(adInfo));
    }

    public void onAdReady(AdInfo adInfo) {
        d.P(this.a, new g(adInfo));
    }

    public void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo) {
        d.P(this.a, new h(ironSourceError, adInfo));
    }

    public void onAdShowSucceeded(AdInfo adInfo) {
    }

    public void onFailure(Exception exc) {
        lmjxuqdtp.jvm.internal.o.h(exc, "exception");
        this.a.p(exc);
    }
}
