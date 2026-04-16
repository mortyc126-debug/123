package d5;

import kotlin.jvm.internal.IntCompanionObject;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final Object a;
    public final int b;
    public int c;
    public final String d;

    public c(String str, int i, int i2, Object obj) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = str;
    }

    public final e a(int i) {
        int i2 = this.c;
        if (i2 != Integer.MIN_VALUE) {
            i = i2;
        }
        if (!(i != Integer.MIN_VALUE)) {
            j5.a.c("Item.end should be set first");
        }
        return new e(this.d, this.b, i, this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, cVar.a) && this.b == cVar.b && this.c == cVar.c && lmjxuqdtp.jvm.internal.o.c(this.d, cVar.d);
    }

    public final int hashCode() {
        Object obj = this.a;
        return this.d.hashCode() + s1.a.c(this.c, s1.a.c(this.b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MutableRange(item=");
        sb.append(this.a);
        sb.append(", start=");
        sb.append(this.b);
        sb.append(", end=");
        sb.append(this.c);
        sb.append(", tag=");
        return i.o(sb, this.d, ')');
    }

    public /* synthetic */ c(b bVar, int i, int i2, String str, int i3) {
        this((i3 & 8) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str, i, (i3 & 4) != 0 ? IntCompanionObject.MIN_VALUE : i2, bVar);
    }
}
