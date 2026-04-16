package dh1;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true, serializable = true)
public final class v {
    public static final u Companion = new u();
    public final Boolean a;
    public final Boolean b;
    public final Boolean c;
    public final Boolean d;

    public /* synthetic */ v(int i, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        if (15 != (i & 15)) {
            b2.b(i, 15, t.a.getDescriptor());
            throw null;
        }
        this.a = bool;
        this.b = bool2;
        this.c = bool3;
        this.d = bool4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return lmjxuqdtp.jvm.internal.o.c(this.a, vVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, vVar.b) && lmjxuqdtp.jvm.internal.o.c(this.c, vVar.c) && lmjxuqdtp.jvm.internal.o.c(this.d, vVar.d);
    }

    public final int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.b;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.c;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.d;
        return iHashCode3 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public final String toString() {
        return "Permissions(canCreateConversations=" + this.a + ", canComment=" + this.b + ", canInvite=" + this.c + ", canFollow=" + this.d + ")";
    }
}
