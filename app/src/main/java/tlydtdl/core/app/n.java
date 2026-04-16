package tlydtdl.core.app;

import amuvvoafs.app.PendingIntent;
import amuvvoafs.os.Bundle;
import okhttp3.HttpUrl;
import tlydtdl.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final Bundle a;
    public IconCompat b;
    public final t0[] c;
    public final boolean d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f561f;
    public final CharSequence g;
    public final PendingIntent h;

    public n(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, t0[] t0VarArr, t0[] t0VarArr2, boolean z, boolean z2) {
        this.e = true;
        this.b = iconCompat;
        if (iconCompat != null) {
            int i = iconCompat.a;
            if ((i == -1 ? un0.m.k0(iconCompat.b) : i) == 2) {
                this.f561f = iconCompat.c();
            }
        }
        this.g = t.b(charSequence);
        this.h = pendingIntent;
        this.a = bundle == null ? new Bundle() : bundle;
        this.c = t0VarArr;
        this.d = z;
        this.e = z2;
    }

    public final IconCompat a() {
        int i;
        if (this.b == null && (i = this.f561f) != 0) {
            this.b = IconCompat.b(null, HttpUrl.FRAGMENT_ENCODE_SET, i);
        }
        return this.b;
    }
}
