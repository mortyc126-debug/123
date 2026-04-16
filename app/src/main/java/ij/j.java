package ij;

import lmjxuqdtp.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class j {
    public final boolean a;
    public final s b;

    public j(s sVar, boolean z) {
        this.a = z;
        this.b = sVar;
    }

    public static j a(j jVar) {
        boolean z = jVar.a;
        jVar.getClass();
        return new j(q.a, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.a == jVar.a && o.c(this.b, jVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "AutomationUiState(hasAutomation=" + this.a + ", curve=" + this.b + ")";
    }
}
