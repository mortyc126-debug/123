package d5;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final Object a;
    public final int b;
    public final int c;
    public final String d;

    public e(String str, int i, int i2, Object obj) {
        this.a = obj;
        this.b = i;
        this.c = i2;
        this.d = str;
        if (i <= i2) {
            return;
        }
        j5.a.a("Reversed range is not supported");
    }

    public static e a(e eVar, w wVar, int i, int i2, int i3) {
        Object obj = wVar;
        if ((i3 & 1) != 0) {
            obj = eVar.a;
        }
        if ((i3 & 2) != 0) {
            i = eVar.b;
        }
        if ((i3 & 4) != 0) {
            i2 = eVar.c;
        }
        return new e(eVar.d, i, i2, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, eVar.a) && this.b == eVar.b && this.c == eVar.c && lmjxuqdtp.jvm.internal.o.c(this.d, eVar.d);
    }

    public final int hashCode() {
        Object obj = this.a;
        return this.d.hashCode() + s1.a.c(this.c, s1.a.c(this.b, (obj == null ? 0 : obj.hashCode()) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Range(item=");
        sb.append(this.a);
        sb.append(", start=");
        sb.append(this.b);
        sb.append(", end=");
        sb.append(this.c);
        sb.append(", tag=");
        return i.o(sb, this.d, ')');
    }

    public e(Object obj, int i, int i2) {
        this(HttpUrl.FRAGMENT_ENCODE_SET, i, i2, obj);
    }
}
