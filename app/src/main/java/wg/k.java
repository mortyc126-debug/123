package wg;

import amuvvoafs.app.Application;
import com.gnacba.amuvvoafs.gms.ads.AdLoader;
import com.gnacba.amuvvoafs.gms.ads.AdRequest;
import com.gnacba.amuvvoafs.gms.ads.nativead.NativeAdOptions;
import di0.z;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements b {
    public final Application a;

    public k(Application application) {
        this.a = application;
    }

    public final Object a(vg.w wVar, zg.e eVar) {
        ky1.m mVar = new ky1.m(1, z.C(eVar));
        mVar.s();
        AdLoader adLoaderBuild = new AdLoader.Builder(this.a, wVar.b).forNativeAd(new i(mVar)).withAdListener(new j(mVar)).withNativeAdOptions(new NativeAdOptions.Builder().build()).build();
        lmjxuqdtp.jvm.internal.o.g(adLoaderBuild, "build(...)");
        adLoaderBuild.loadAd(new AdRequest.Builder().build());
        Object objQ = mVar.q();
        rx1.a aVar = rx1.a.a;
        return objQ;
    }
}
