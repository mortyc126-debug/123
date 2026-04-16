package l8;

import amuvvoafs.net.Uri;
import com.facebook.internal.j;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static final String b;
    public final Uri a;

    static {
        int i = o8.f0.a;
        b = Integer.toString(0, 36);
    }

    public y(j jVar) {
        this.a = j.a(jVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y) && this.a.equals(((y) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }
}
