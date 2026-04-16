package of1;

import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e d = new e(IntCompanionObject.MAX_VALUE, 1, g.a);
    public static final e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f370f;
    public static final e g;
    public final int a;
    public final int b;
    public final i c;

    static {
        int i = 1;
        int i2 = 2;
        e = new e(i, f.a, i2);
        i iVar = null;
        int i3 = 6;
        f370f = new e(i, iVar, i3);
        g = new e(i2, iVar, i3);
    }

    public e(int i, int i2, i iVar) {
        lmjxuqdtp.jvm.internal.o.h(iVar, "overflow");
        this.a = i;
        this.b = i2;
        this.c = iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.b == eVar.b && lmjxuqdtp.jvm.internal.o.c(this.c, eVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + s1.a.c(this.b, Integer.hashCode(this.a) * 31, 31);
    }

    public final String toString() {
        StringBuilder sbI = z.p.i(this.a, this.b, "LinesStyle(maxLines=", ", minLines=", ", overflow=");
        sbI.append(this.c);
        sbI.append(")");
        return sbI.toString();
    }

    public /* synthetic */ e(int i, i iVar, int i2) {
        this(i, (i2 & 2) != 0 ? 1 : 2, (i2 & 4) != 0 ? h.a : iVar);
    }
}
