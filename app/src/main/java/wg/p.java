package wg;

import com.gnacba.amuvvoafs.gms.ads.initialization.InitializationStatus;
import com.gnacba.amuvvoafs.gms.ads.initialization.OnInitializationCompleteListener;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements OnInitializationCompleteListener {
    public final /* synthetic */ qx1.k a;

    public p(qx1.k kVar) {
        this.a = kVar;
    }

    public final void onInitializationComplete(InitializationStatus initializationStatus) {
        lmjxuqdtp.jvm.internal.o.h(initializationStatus, "status");
        this.a.resumeWith(initializationStatus);
    }
}
