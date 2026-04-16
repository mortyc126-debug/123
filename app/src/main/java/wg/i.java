package wg;

import com.gnacba.amuvvoafs.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements NativeAd.OnNativeAdLoadedListener {
    public final /* synthetic */ ky1.m a;

    public i(ky1.m mVar) {
        this.a = mVar;
    }

    public final void onNativeAdLoaded(NativeAd nativeAd) {
        lmjxuqdtp.jvm.internal.o.h(nativeAd, "ad");
        ky1.m mVar = this.a;
        if (mVar.isActive()) {
            mVar.resumeWith(nativeAd);
        } else {
            nativeAd.destroy();
        }
    }
}
