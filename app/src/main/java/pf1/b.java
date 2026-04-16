package pf1;

import java.util.regex.Pattern;
import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final String a;
    public final Pattern b;

    public b(Pattern pattern, String str) {
        o.h(str, "tag");
        this.a = str;
        this.b = pattern;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return o.c(this.a, bVar.a) && o.c(this.b, bVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Config(tag=" + this.a + ", pattern=" + this.b + ")";
    }
}
