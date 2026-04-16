package wk;

import az1.b2;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@aj.a(deserializable = true)
public final class r {
    public static final q Companion = new q();
    public final Integer a;

    public /* synthetic */ r(int i, Integer num) {
        if (1 == (i & 1)) {
            this.a = num;
        } else {
            b2.b(i, 1, p.a.getDescriptor());
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r) && lmjxuqdtp.jvm.internal.o.c(this.a, ((r) obj).a);
    }

    public final int hashCode() {
        Integer num = this.a;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public final String toString() {
        return "SmartComposeRemainingTokensDTO(remaining=" + this.a + ")";
    }
}
