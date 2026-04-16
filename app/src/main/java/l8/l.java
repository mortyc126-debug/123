package l8;

import com.gnacba.amuvvoafs.gms.internal.ads.wr1;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-9e936228ea1ea2cc679ed5186cc1349ef706487dc89ec4e25d4a3ea878769de6 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final l e = new wr1(0).b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f300f;
    public static final String g;
    public static final String h;
    public static final String i;
    public final int a;
    public final int b;
    public final int c;
    public final String d;

    static {
        int i2 = o8.f0.a;
        f300f = Integer.toString(0, 36);
        g = Integer.toString(1, 36);
        h = Integer.toString(2, 36);
        i = Integer.toString(3, 36);
    }

    public l(wr1 wr1Var) {
        this.a = wr1Var.b;
        this.b = wr1Var.c;
        this.c = wr1Var.d;
        this.d = (String) wr1Var.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a == lVar.a && this.b == lVar.b && this.c == lVar.c && Objects.equals(this.d, lVar.d);
    }

    public final int hashCode() {
        int i2 = (((((527 + this.a) * 31) + this.b) * 31) + this.c) * 31;
        String str = this.d;
        return i2 + (str == null ? 0 : str.hashCode());
    }
}
