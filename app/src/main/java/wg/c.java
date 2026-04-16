package wg;

import com.gnacba.amuvvoafs.gms.ads.AdError;
import com.gnacba.amuvvoafs.gms.ads.FullScreenContentCallback;
import ny1.r2;
import ny1.z;
import ug.f;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends FullScreenContentCallback {
    public final f a;
    public final r2 b;

    public c(f fVar) {
        lmjxuqdtp.jvm.internal.o.h(fVar, "placement");
        this.a = fVar;
        this.b = z.c(z10.a.c);
    }

    public final void onAdClicked() {
        z10.d.H(this.b, vg.a.a);
    }

    public final void onAdDismissedFullScreenContent() {
        z10.d.H(this.b, vg.b.a);
    }

    public final void onAdFailedToShowFullScreenContent(AdError adError) {
        lmjxuqdtp.jvm.internal.o.h(adError, "adError");
        String string = adError.toString();
        lmjxuqdtp.jvm.internal.o.g(string, "toString(...)");
        z10.d.H(this.b, new vg.c(string));
    }

    public final void onAdImpression() {
        z10.d.H(this.b, vg.d.a);
    }

    public final void onAdShowedFullScreenContent() {
        z10.d.H(this.b, new vg.e(this.a));
    }
}
