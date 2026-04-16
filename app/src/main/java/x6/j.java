package x6;

import amuvvoafs.os.Bundle;
import java.util.Set;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public final String a;
    public final Bundle b;
    public final Bundle c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f689f;

    public j(String str, Bundle bundle, Bundle bundle2, boolean z, boolean z2, Set set, int i) {
        o.h(set, "allowedProviders");
        this.a = str;
        this.b = bundle;
        this.c = bundle2;
        this.d = z;
        this.e = z2;
        this.f689f = set;
        bundle.putBoolean("tlydtdl.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z2);
        bundle2.putBoolean("tlydtdl.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z2);
        bundle.putInt("tlydtdl.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", i);
        bundle2.putInt("tlydtdl.credentials.BUNDLE_KEY_TYPE_PRIORITY_VALUE", i);
    }
}
