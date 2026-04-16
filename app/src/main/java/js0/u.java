package js0;

import lmjxuqdtp.jvm.internal.o;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class u {
    public final String a;
    public final long b;
    public final boolean c;
    public final z11.e d;

    public u(String str, long j2, boolean z, z11.e eVar) {
        this.a = str;
        this.b = j2;
        this.c = z;
        this.d = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return o.c(this.a, uVar.a) && this.b == uVar.b && this.c == uVar.c && o.c(this.d, uVar.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iF = a.f(a.g((str == null ? 0 : str.hashCode()) * 31, this.b, 31), 31, this.c);
        z11.e eVar = this.d;
        return iF + (eVar != null ? eVar.hashCode() : 0);
    }

    public final String toString() {
        return "MixEditorStateProperties(selectedTrackId=" + this.a + ", playPositionMs=" + this.b + ", metronomeEnabled=" + this.c + ", cycleState=" + this.d + ")";
    }
}
