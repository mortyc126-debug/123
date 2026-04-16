package x6;

import amuvvoafs.os.Bundle;
import java.util.Set;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Bundle bundle, Bundle bundle2, boolean z, Set set, int i) {
        super("com.gnacba.amuvvoafs.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", bundle, bundle2, true, z, set, i);
        o.h(set, "allowedProviders");
        if (i == 100) {
            throw new IllegalArgumentException("Custom types should not have passkey level priority.");
        }
    }
}
