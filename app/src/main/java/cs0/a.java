package cs0;

import f3.f2;
import hg1.b;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements h {
    public final float a;
    public final e b;
    public final boolean c;

    public a(float f2, e eVar, boolean z) {
        lmjxuqdtp.jvm.internal.o.h(eVar, "pressed");
        this.a = f2;
        this.b = eVar;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return b.a(this.a, aVar.a) && lmjxuqdtp.jvm.internal.o.c(this.b, aVar.b) && this.c == aVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (Float.hashCode(this.a) * 31)) * 31);
    }

    public final String toString() {
        String strB = b.b(this.a);
        StringBuilder sb = new StringBuilder("ButtonsInput(bpm=");
        sb.append(strB);
        sb.append(", pressed=");
        sb.append(this.b);
        sb.append(", isEnabled=");
        return f2.o(sb, this.c, ")");
    }
}
