package vm;

import com.gnacba.ads.interactivemedia.v3.internal.a;
import com.gnacba.amuvvoafs.gms.internal.measurement.b4;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b4 {
    public final boolean c;

    public c(boolean z) {
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.c == ((c) obj).c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c);
    }

    public final String toString() {
        return a.i("Ok(customFFmpeg=", ")", this.c);
    }
}
