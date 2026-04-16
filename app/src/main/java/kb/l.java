package kb;

import f3.f2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends m {
    public final b a;
    public final int b;

    public l(b bVar, int i) {
        lmjxuqdtp.jvm.internal.o.h(bVar, "latestEvent");
        this.a = bVar;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.b == lVar.b && lmjxuqdtp.jvm.internal.o.c(this.a, lVar.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InProgress(latestEvent=");
        sb.append(this.a);
        sb.append(", direction=");
        return f2.l(sb, this.b, ')');
    }
}
