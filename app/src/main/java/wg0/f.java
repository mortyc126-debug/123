package wg0;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
@wy1.f
public final class f {
    public static final e Companion = new e();
    public final String a;

    public static String a(String str) {
        return i.n("VoiceId(value=", str, ")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return lmjxuqdtp.jvm.internal.o.c(this.a, ((f) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return a(this.a);
    }
}
