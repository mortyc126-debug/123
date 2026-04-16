package i5;

import k5.b;
import s1.a;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final k g = new k(false, 0, true, 1, 1, b.c);
    public final boolean a;
    public final int b;
    public final boolean c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f219f;

    public k(boolean z, int i, boolean z2, int i2, int i3, b bVar) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f219f = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.a == kVar.a && this.b == kVar.b && this.c == kVar.c && this.d == kVar.d && this.e == kVar.e && lmjxuqdtp.jvm.internal.o.c(this.f219f, kVar.f219f);
    }

    public final int hashCode() {
        return this.f219f.a.hashCode() + a.c(this.e, a.c(this.d, a.f(a.c(this.b, Boolean.hashCode(this.a) * 31, 31), 31, this.c), 31), 961);
    }

    public final String toString() {
        return "ImeOptions(singleLine=" + this.a + ", capitalization=" + ((Object) l.a(this.b)) + ", autoCorrect=" + this.c + ", keyboardType=" + ((Object) m.a(this.d)) + ", imeAction=" + ((Object) j.a(this.e)) + ", platformImeOptions=null, hintLocales=" + this.f219f + ')';
    }
}
