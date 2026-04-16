package wg0;

import az1.b2;
import com.gnacba.ads.interactivemedia.v3.internal.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class m implements a0 {
    public static final l Companion = new l();
    public final boolean a;

    public /* synthetic */ m(int i, boolean z) {
        if (1 == (i & 1)) {
            this.a = z;
        } else {
            b2.b(i, 1, k.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && this.a == ((m) obj).a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public final String toString() {
        return a.i("Loading(showApplyForWholeTrackSkeleton=", ")", this.a);
    }

    public m(boolean z) {
        this.a = z;
    }
}
